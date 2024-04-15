package com.com.cnu.devlog_springboot.model.reponse;

public record ErrorResponse(
        String title,
        Integer status,
        Integer code,
        String instance
) {
}

