package com.example.rockbitetaskex.exceptions;

public class WarehouseNotFoundException extends RuntimeException {

    private final String message;

    public WarehouseNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
