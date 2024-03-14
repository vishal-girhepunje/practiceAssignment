package com.investo.controller;

import com.investo.model.Candle;
import com.investo.service.CandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candle")
public class CandleController {

    @Autowired
    private CandleService candleService;

    /**
     * Endpoint to save the candles
     * @return ResponseEntity containing a message and HTTP status
     */
    @PostMapping("/save-candles")
    public ResponseEntity<String> saveCandleHandler(){
        String msg = candleService.addData();
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    /**
     * Endpoint to get Opening Range Breakout (ORB) time for the specified interval
     * @param time The time interval in minutes
     * @return ResponseEntity containing a message and HTTP status
     */
    @GetMapping("/ORB/{time}")
    public ResponseEntity<String> getORBHandler(@PathVariable Integer time){
        String msg = candleService.getORBCandle(time);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    /**
     * Endpoint to get combined candles for the specified interval
     * @param time The time interval in minutes
     * @return ResponseEntity containing list of combined candle and HTTP status
     */
    @GetMapping("combine/{time}")
    public ResponseEntity<List<Candle>> getCombinedCandleHandler(@PathVariable Integer time){
        List<Candle> list = candleService.getCombinedCandle(time);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
