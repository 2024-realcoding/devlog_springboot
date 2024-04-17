package com.cnu.devlog_springboot.model.request;

import com.cnu.devlog_springboot.type.Tag;

public record PostRequest(
        String title,
        String contents,
        Tag tag
) {
}

