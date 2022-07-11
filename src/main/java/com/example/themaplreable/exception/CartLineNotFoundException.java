package com.example.themaplreable.exception;

/**
 * Exception thrown if no carte line is found.
 */
public class CartLineNotFoundException extends Exception{

    public CartLineNotFoundException(){
        super("This cart line don't exist");
    }
}
