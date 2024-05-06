package com.com.cnu.devlog_springboot.type;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.management.Descriptor;
@Getter
public enum ErrorCode {
    //4XX not exist resoruce
    POST_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            4000,
            "해당 포스트를 찾을 수 없습니다."
    );

    private final HttpStatus httpStatus;
    private final Integer errorCode;
    private final String description;

    ErrorCode(HttpStatus httpStatus, Integer errorCode, String description) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.description = description;
    }
}
