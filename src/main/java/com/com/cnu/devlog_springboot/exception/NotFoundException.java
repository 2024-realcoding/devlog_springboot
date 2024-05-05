package com.com.cnu.devlog_springboot.exception;

public class NotFoundException extends DevlogException {

    public NotFoundException(String message) {
        super(message, 404);
    }
}
