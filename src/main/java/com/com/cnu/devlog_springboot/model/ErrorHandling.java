package com.com.cnu.devlog_springboot.model;

public record ErrorHandling(String title, Integer status, Integer code, String instance) {
    public ErrorHandling(String title, Integer status, Integer code, String instance) {
        this.title = title;
        this.status = status;
        this.code = code;
        this.instance = instance;
    }

    public String title() {
        return this.title;
    }

    public Integer status() {
        return this.status;
    }

    public Integer code() {
        return this.code;
    }

    public String instance() {
        return this.instance;
    }
}
