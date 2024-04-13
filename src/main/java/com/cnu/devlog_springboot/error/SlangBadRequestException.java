package com.cnu.devlog_springboot.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SlangBadRequestException extends RuntimeException {
    private static final long serialVersionUID = -4785136912743477236L;

    public SlangBadRequestException() {
        super("비속어가 포함된 글은 등록할 수 없습니다");
    }

    public ErrorResponse getErrorResponse() {
        return new ErrorResponse("slangInput", this.getMessage());
    }
}
