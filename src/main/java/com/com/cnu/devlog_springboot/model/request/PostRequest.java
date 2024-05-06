package com.com.cnu.devlog_springboot.model.request;

import com.com.cnu.devlog_springboot.type.ErrorCode;

public record PostRequest(
        String title,
        String contents,
        ErrorCode tag
) {
}
