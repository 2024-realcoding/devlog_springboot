package com.com.cnu.devlog_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    String summary;
    String contents;
    LocalDate startDate;
    LocalDate endDate;

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getContents() {
        return this.contents;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setSummary(final String summary) {
        this.summary = summary;
    }

    public void setContents(final String contents) {
        this.contents = contents;
    }

    public void setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
    }

    public Project(final Integer id, final String title, final String summary, final String contents, final LocalDate startDate, final LocalDate endDate) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.contents = contents;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    protected Project() {
    }
}
