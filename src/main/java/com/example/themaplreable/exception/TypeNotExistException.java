package com.example.themaplreable.exception;

/**
 * Exception thrown if no player is found.
 */
public class TypeNotExistException extends Exception{

    public TypeNotExistException(Exception e){
        super("This syrup type don't exist : ", e);
    }
}
