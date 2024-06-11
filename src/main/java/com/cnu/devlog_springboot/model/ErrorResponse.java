package com.cnu.devlog_springboot.model;

public record ErrorResponse(
        String title,
        Integer status,
        Integer code,
        String instance
) {
}