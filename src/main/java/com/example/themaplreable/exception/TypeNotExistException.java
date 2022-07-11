package com.example.themaplreable.exception;

/**
 * Exception thrown if no player is found.
 */
public class TypeNotExistException extends Exception{

    public TypeNotExistException(String type){
        super("The type " + type + " don't exist !");
    }
}
