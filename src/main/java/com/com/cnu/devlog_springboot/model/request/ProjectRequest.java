package com.com.cnu.devlog_springboot.model.request;

import java.time.LocalDate;

public record ProjectRequest(
        String title,
        String summary,
        String contents,
        LocalDate startDate,
        LocalDate endDate
) {
    public ProjectRequest(String title, String summary, String contents, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.summary = summary;
        this.contents = contents;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String title() {
        return this.title;
    }

    public String summary() {
        return this.summary;
    }

    public String contents() {
        return this.contents;
    }

    public LocalDate startDate() {
        return this.startDate;
    }

    public LocalDate endDate() {
        return this.endDate;
    }
}