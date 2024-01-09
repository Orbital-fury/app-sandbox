package com.appsandbox.appsandbox.infrastructure.exceptions;

public class NoContentException extends RuntimeException {

    private String message;

    public NoContentException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
