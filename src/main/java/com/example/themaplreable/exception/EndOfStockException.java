package com.example.themaplreable.exception;

/**
 * Exception thrown if no carte line is found.
 */
public class EndOfStockException extends Exception{

    public EndOfStockException(String productName){
        super("The product " + productName + " is not available !");
    }
}
