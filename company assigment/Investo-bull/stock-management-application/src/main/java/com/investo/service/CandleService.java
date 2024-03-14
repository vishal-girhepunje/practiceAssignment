package com.investo.service;

import com.investo.exception.CandleException;
import com.investo.exception.CandleIOException;
import com.investo.exception.InvalidInputException;
import com.investo.model.Candle;

import java.io.IOException;
import java.util.List;

public interface CandleService {

    /**
     * This method is used to read candle data from a JSON file, convert it into list of Candle, and add the data to the database
     * @return String message "Candles added successfully!"
     * @throws CandleException If no candles are found in the JSON data
     * @throws IOException If there's an issue reading the JSON file
     */
    public String addData() throws CandleException, CandleIOException;


    /**
     * This method calculates and returns the time of the first Opening Range Breakout candle based on the specified time interval
     * @param time The time interval in minutes
     * @return A message indicating the time of the ORB candle
     */
    public String getORBCandle(Integer time) throws InvalidInputException;


    /**
     * This method combine the candles based on the specified time interval and return it
     * @param time The time interval in minutes
     * @return list of combined candle
     */
    public List<Candle> getCombinedCandle(Integer time) throws InvalidInputException;
}
