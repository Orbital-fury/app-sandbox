package com.appsandbox.appsandbox.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NoDataFoundException.class, BadRequestException.class})
    public ResponseEntity<ApiError> handleHttpException(@NonNull Exception ex, WebRequest request) {
        if (ex instanceof NoDataFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            NoDataFoundException ndfe = (NoDataFoundException) ex;
            return handleNoDataFoundException(ndfe, status, request);
        } else if (ex instanceof BadRequestException) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            BadRequestException bre = (BadRequestException) ex;
            return handleBadRequestException(bre, status, request);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, null, status, request);
        }
    }

    // Customize the response for NoDataFoundException
    protected ResponseEntity<ApiError> handleNoDataFoundException(NoDataFoundException ex,
    @NonNull HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, new ApiError(status, ex.getMessage()), status, request);
    }

    // Customize the response for NoDataFoundException
    protected ResponseEntity<ApiError> handleBadRequestException(BadRequestException ex,
    @NonNull HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, new ApiError(status, ex.getMessage()), status, request);
    }

    // A single place to customize the response body of all Exception types
    protected ResponseEntity<ApiError> handleExceptionInternal(@NonNull Exception ex, ApiError body,
            @NonNull HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, status);
    }

}
