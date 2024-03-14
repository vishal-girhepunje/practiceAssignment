package com.investo.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.investo.exception.CandleException;
import com.investo.exception.CandleIOException;
import com.investo.exception.InvalidInputException;
import com.investo.model.Candle;
import com.investo.repository.CandleRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CandleServiceImpl implements CandleService{

    @Autowired
    private CandleRepository candleRepository;

    @Override
    public String addData() throws CandleException, CandleIOException {

        // Load the JSON data from the classpath resource
        ClassPathResource resource = new ClassPathResource("data.json");

        // Initialize an ObjectMapper instance for JSON serialization and deserialization
        ObjectMapper objectMapper = new ObjectMapper();

        // Register the JavaTimeModule to handle Java 8 date and time types during JSON processing
        objectMapper.registerModule(new JavaTimeModule());

        List<Candle> candleList = new ArrayList<>();

        try {
            // Read the content of the JSON file into a String
            String staticDataString = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

            // Parse the JSON data into a Map<String, Object>
            Map<String, Object> map = objectMapper.readValue(staticDataString, new TypeReference<Map<String, Object>>() {});

            // Extract the "candle" list from the map and convert it into a List<Candle>
            candleList = objectMapper.convertValue(map.get("candles"), new TypeReference<List<Candle>>() {});

        } catch (IOException ex) {
            throw new CandleIOException("Error in reading the candle data.", ex);
        }

        // If no candles are found in the JSON data, throw an exception
        if(candleList.isEmpty()) throw new CandleException("Not found any candle for adding to database!");

        // Sort the candleList using a custom comparator based on the lastTradeTime field of Candle
        Collections.sort(candleList, Comparator.comparing(Candle::getLastTradeTime));

        // Save the list of candles to the database using the candleRepository
        candleRepository.saveAll(candleList);

        // Return a success message
        return "Candles added successfully!";
    }


    @Override
    public String getORBCandle(Integer time) throws InvalidInputException {

        // Check if given time is not valid
        if(time % 5 != 0) throw new InvalidInputException("Invalid time interval!");

        // Calculate the number of records for the specified time interval
        Integer numberOfCandle = time / 5;

        // Finding the all candle from database
        List<Candle> candleList = candleRepository.findAll();

        double highestHigh = Double.MIN_VALUE;
        double lowestLow = Double.MAX_VALUE;

        // Find the highest high and lowest low within the opening range
        for (int i = 0; i < numberOfCandle; i++){
            highestHigh = Math.max(highestHigh, candleList.get(i).getHigh());
            lowestLow = Math.min(lowestLow, candleList.get(i).getLow());
        }

        String msg = "Not found any ORB candle";

        // Find the first ORB candle
        for (int i = numberOfCandle; i < candleList.size(); i++){
            Candle candle = candleList.get(i);
            if(candle.getClose() > highestHigh || candle.getClose() < lowestLow) {
                msg = "ORB candle generated at '" + candle.getLastTradeTime() + "'";
                break;
            }
        }

        // Return a message
        return msg;
    }


    @Override
    public List<Candle> getCombinedCandle(Integer time) throws InvalidInputException {

        // Check if given time is not valid, if not then throw an exception
        if(time % 5 != 0) throw new InvalidInputException("Invalid time interval!");

        // Calculate the number of candle and total interval based on the given time
        Integer numberOfCandle = time / 5;
        double interval = Math.ceil(75 / (double) numberOfCandle);

        // Created a list of Candle for adding the combined candle
        List<Candle> combinedCandleList = new ArrayList<>();

        // Iterate through pages and create combined candles
        for(int i = 0; i < interval; i++) {

            // Create pageable request for the current interval
            Pageable pageable = PageRequest.of(i, numberOfCandle, Sort.by("lastTradeTime"));

            // Find the candle
            Page<Candle> page = candleRepository.findAll(pageable);

            // Getting the list of candle in one time interval
            List<Candle> list = page.getContent();

            double open =  list.get(0).getOpen(); // Finding the opening of first Candle in this interval
            double close = list.get(list.size() - 1).getClose(); // Finding the closing of last Candle in this interval
            LocalDateTime lastTime = list.get(0).getLastTradeTime(); // Finding the last tread time of first Candle in this interval
            Long totalTrad = list.stream().mapToLong(Candle::getTradedQty).sum(); // Finding the sum of all tradedQTY
            Double highestHigh = list.stream().mapToDouble(Candle::getHigh).max().getAsDouble();  // Finding the highest high value
            Double lowestLow = list.stream().mapToDouble(Candle::getLow).min().getAsDouble();  // Finding the lowest low value

            // Creating a combined candle
            Candle candle = new Candle();
            candle.setId(i);
            candle.setLow(lowestLow);
            candle.setTradedQty(totalTrad);
            candle.setClose(close);
            candle.setLastTradeTime(lastTime);
            candle.setHigh(highestHigh);
            candle.setQuotationLot(1);
            candle.setOpen(open);
            candle.setOpenInterest(0);

            // Adding the combined candle to combined candle list
            combinedCandleList.add(candle);
        }

        // Return a list of combined candle data
        return combinedCandleList;
    }

}
