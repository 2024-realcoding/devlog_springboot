package com.com.cnu.devlog_springboot.model.request;

import java.time.LocalDate;

public record ProjectRequest(String title,
                             String summary,
                             String contents,
                             LocalDate startDate,
                             LocalDate endDate) {
}
