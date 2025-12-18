package com.gismateaching.spring_boot_example.exception;

public class BadRequestException  extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
