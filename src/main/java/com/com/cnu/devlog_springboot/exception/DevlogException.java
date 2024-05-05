package com.com.cnu.devlog_springboot.exception;

import lombok.Getter;

@Getter
public abstract class DevlogException extends RuntimeException {

    private final int status;

    protected DevlogException(String message, int status) {
        super(message);
        this.status = status;
    }
}
