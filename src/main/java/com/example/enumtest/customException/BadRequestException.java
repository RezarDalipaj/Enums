package com.example.enumtest.customException;

public class BadRequestException extends Exception{
    public BadRequestException(String message){
        super(message);
    }
}
