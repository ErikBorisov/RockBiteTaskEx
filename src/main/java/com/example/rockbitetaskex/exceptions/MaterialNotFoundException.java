package com.example.rockbitetaskex.exceptions;

public class MaterialNotFoundException extends RuntimeException {

    private final String message;

    public MaterialNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
