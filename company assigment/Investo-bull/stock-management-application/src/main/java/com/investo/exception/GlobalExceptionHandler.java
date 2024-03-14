package com.investo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles CandleException and returns a custom error response
     * @param ce The CandleException that was thrown
     * @param req The WebRequest
     * @return ResponseEntity containing the error details
     */
    @ExceptionHandler(CandleException.class)
    public ResponseEntity<MyErrorDetails> candleExceptionHandler(CandleException ce, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ce.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles InputException and returns a custom error response
     * @param ie The InputException that was thrown
     * @param req The WebRequest
     * @return ResponseEntity containing the error details
     */
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<MyErrorDetails> inputExceptionHandler(InvalidInputException ie, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ie.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle the IOException
     * @param ex The CandleIOException that was thrown
     * @param request The WebRequest
     * @return ResponseEntity containing the error details
     */






    @ExceptionHandler(CandleIOException.class)
    public ResponseEntity<MyErrorDetails> candleIOExceptionHandler(CandleIOException ex, WebRequest request) {
        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setMessage("Error saving candle data.");
        errorDetails.setDetails(request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }





















    /**
     * Handles general Exception and returns a custom error response
     * @param se The Exception that was thrown
     * @param req The WebRequest
     * @return ResponseEntity containing the error details
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> globalExceptionHandler(Exception se, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }
}
