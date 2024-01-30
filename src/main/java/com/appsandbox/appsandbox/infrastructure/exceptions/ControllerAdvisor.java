package com.appsandbox.appsandbox.infrastructure.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NoDataFoundException.class, BadRequestException.class})
    public ResponseEntity<Object> handleHttpException(RuntimeException ex, @NonNull WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof NoDataFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else if (ex instanceof BadRequestException) {
            status = HttpStatus.BAD_REQUEST;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(ex, new ApiError(status, ex.getMessage()), headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherExceptions(@NonNull Exception ex, @NonNull WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return handleExceptionInternal(ex, new ApiError(status, "Internal Server Error"), new HttpHeaders(), status, request);
    }

    @NonNull
    protected ResponseEntity<ApiError> handleExceptionInternal(@NonNull Exception ex, ApiError body,
            @NonNull HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, status);
    }

}
