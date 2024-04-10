package com.com.cnu.devlog_springboot.week1.practice.service.fixture;


import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.model.request.PostRequest;
import com.com.cnu.devlog_springboot.type.Tag;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PostFixture {

    static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    public static PostRequest getSlangPostRequest() {
        String title = "비속어1";
        String content = "비속어2";
        Tag tag = Tag.SPRINGBOOT;

        try {
            return mapper.readValue(
                    """
                            {
                                "title": "%s",
                                "contents": "%s",
                                "tag": "%s"
                            }
                            """.formatted(title, content, tag)
                    , PostRequest.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static PostRequest getNormalPostRequest() {
        String title = "정상 제목";
        String content = "정상 본문";
        Tag tag = Tag.SPRINGBOOT;

        try {
            return mapper.readValue(
                    """
                            {
                                "title": "%s",
                                "contents": "%s",
                                "tag": "%s"
                            }
                            """.formatted(title, content, tag)
                    , PostRequest.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static PostRequest getNormalPostRequestUpdated() {
        String title = "정상 제목2";
        String content = "정상 본문2";
        Tag tag = Tag.JAVA;

        try {
            return mapper.readValue(
                    """
                            {
                                "title": "%s",
                                "contents": "%s",
                                "tag": "%s"
                            }
                            """.formatted(title, content, tag)
                    , PostRequest.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Post getNormalPost() {
        String title = "정상 제목2";
        String content = "정상 본문2";
        Tag tag = Tag.JAVA;

        try {
            return mapper.readValue(
                    """
                            {
                                "id": 1,
                                "title": "%s",
                                "contents": "%s",
                                "tag": "%s"
                            }
                            """.formatted(title, content, tag)
                    , Post.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}