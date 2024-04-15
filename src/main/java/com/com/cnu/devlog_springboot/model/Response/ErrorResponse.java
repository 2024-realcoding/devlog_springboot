package com.com.cnu.devlog_springboot.model.Response;

public record ErrorResponse(
    String title,
    Integer status,
    Integer code,
    String instance
) {

}
