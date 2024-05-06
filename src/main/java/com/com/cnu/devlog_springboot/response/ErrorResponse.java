package com.com.cnu.devlog_springboot.response;

public record ErrorResponse (
        String title,
        Integer status,
        Integer code,
        String instance
) {

}