package com.example.themaplreable.exception;

/**
 * Exception thrown if no product is found.
 */
public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(Long productId){
        super("The product " + productId +" don't exist !");
    }
}
