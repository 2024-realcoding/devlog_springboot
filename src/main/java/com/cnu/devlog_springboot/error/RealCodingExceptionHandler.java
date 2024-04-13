package com.cnu.devlog_springboot.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RealCodingExceptionHandler {
    @ExceptionHandler(SlangBadRequestException.class)
    public ResponseEntity<ErrorResponse> handleSlangRequestException(SlangBadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getErrorResponse());
    }
}
