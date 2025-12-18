package com.gismateaching.spring_boot_example.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiError handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ApiError(LocalDateTime.now(), 404, "Resource Not Found", ex.getMessage(), null);
    }

    @ExceptionHandler(BadRequestException.class)
    public ApiError handleBadRequestException(BadRequestException ex) {
        return new ApiError(LocalDateTime.now(), 400, "Bad Request", ex.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    public ApiError handleException(Exception ex) {
        return new ApiError(LocalDateTime.now(), 500, "Internal Server Error", ex.getMessage(), null);
    }

    @ExceptionHandler(RuntimeException.class)
    public ApiError handleRuntimeException(RuntimeException ex) {
        return new ApiError(LocalDateTime.now(), 500, "Internal Server Error", ex.getMessage(), null);
    }
}
