package com.appsandbox.appsandbox.infrastructure.rest.exceptions;

// import java.util.Date;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.context.request.WebRequest;
// import org.springframework.web.server.ResponseStatusException;

// import lombok.Getter;

// @ControllerAdvice
public class CustomExceptionHandler {

    // Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    // @ExceptionHandler(ResponseStatusException.class)
    // public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
    //     HttpStatus status = HttpStatus.valueOf(ex.getStatusCode().value());
    //     CustomErrorResponse errorResponse = new CustomErrorResponse(status, request.getDescription(false).split("=")[1], ex.getReason());
    //     return new ResponseEntity<>(errorResponse, status);
    // }

    // @Getter
    // private static class CustomErrorResponse {
    //     private final Date date;
    //     private final int status;
    //     private final String error;
    //     private final String message;
    //     private final String path;

    //     public CustomErrorResponse(HttpStatus status, String path, String message) {
    //         this.date = new Date();
    //         this.status = status.value();
    //         this.error = status.getReasonPhrase();
    //         this.path = path;
    //         this.message = message;
    //     }
    // }
}