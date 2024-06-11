package com.cnu.devlog_springboot.exception;

import com.cnu.devlog_springboot.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DevlogException extends RuntimeException {
    private final ErrorCode errorCode;
}
