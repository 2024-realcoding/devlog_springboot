package com.com.cnu.devlog_springboot.model.Response;

public record ProjectResponse(
        String title,
        String date,
        String summary,
        String description
) {
}
