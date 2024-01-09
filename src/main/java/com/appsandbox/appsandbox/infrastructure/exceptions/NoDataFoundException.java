package com.appsandbox.appsandbox.infrastructure.exceptions;

public class NoDataFoundException extends RuntimeException {

    private String message;

    public NoDataFoundException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
