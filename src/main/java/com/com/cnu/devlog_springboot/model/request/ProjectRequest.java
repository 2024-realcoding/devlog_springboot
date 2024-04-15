package com.com.cnu.devlog_springboot.model.request;

public record ProjectRequest(String title,
                             String date,
                             String summary,
                             String description) {
}
