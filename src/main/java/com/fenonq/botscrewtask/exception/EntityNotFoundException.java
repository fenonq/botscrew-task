package com.fenonq.botscrewtask.exception;

public class EntityNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Entity not found!";

    public EntityNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

}
