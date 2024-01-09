package com.appsandbox.appsandbox.infrastructure.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApiError {

    private LocalDateTime date;
    private int status;
    private String error;
    private String message;

    public ApiError(HttpStatus status, String message) {
        this.date = LocalDateTime.now();
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
    }

    public String toString() {
        return "Error " + this.status + " (" + this.error + "): " + this.message;
    }

}
