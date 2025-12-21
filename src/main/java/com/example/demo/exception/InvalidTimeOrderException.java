package com.example.demo.exception;

public class InvalidTimeOrderException extends RuntimeException {
    public InvalidTimeOrderException(String message) {
        super(message);
    }
}
