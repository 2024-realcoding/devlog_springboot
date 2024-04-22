package com.com.cnu.devlog_springboot.model.request;
import com.com.cnu.devlog_springboot.type.Tag;
import java.time.LocalDate;

public record ProjectRequest(
        String title,
        String summary,
        String contents,
        LocalDate startDate,
        LocalDate endDate,
        Tag tag
) {
}
