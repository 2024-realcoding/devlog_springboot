package com.com.cnu.devlog_springboot.model.request;

import com.com.cnu.devlog_springboot.type.Tag;

public record PostRequest(
        String title,
        String contents,
        Tag tag
) {
}
