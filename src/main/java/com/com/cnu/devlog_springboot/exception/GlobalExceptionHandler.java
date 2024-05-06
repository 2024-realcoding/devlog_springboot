package com.com.cnu.devlog_springboot.exception;

import com.com.cnu.devlog_springboot.model.ErrorResponse;
import com.com.cnu.devlog_springboot.type.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DevlogException.class)
    public ResponseEntity<ErrorResponse> handleDevlogException(
            final HttpServletRequest request,
            final DevlogException e
    ) {
        final ErrorCode errorCode = e.getErrorCode();
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(
                        new ErrorResponse(
                                errorCode.getDescription(),
                                errorCode.getHttpStatus().value(),
                                errorCode.getErrorCode(),
                                request.getRequestURI()
                        )
                );
    }
}
