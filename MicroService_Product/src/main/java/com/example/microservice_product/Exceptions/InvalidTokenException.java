package com.example.microservice_product.Exceptions;

public class InvalidTokenException extends Exception{

    public InvalidTokenException(String message){
        super(message);
    }
}
