package com.com.cnu.devlog_springboot.type;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, 4000, "해당 게시글을 찾을 수 없습니다."),
    PROJECT_NOT_FOUND(HttpStatus.NOT_FOUND, 5000, "해당 프로젝 글을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final Integer errorCode;
    private final String description;

    ErrorCode(final HttpStatus httpStatus, final Integer errorCode, final String description) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.description = description;
    }
}
