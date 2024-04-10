package com.com.cnu.devlog_springboot.week1.practice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.com.cnu.devlog_springboot.error.SlangBadRequestException;
import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.model.request.PostRequest;
import com.com.cnu.devlog_springboot.service.PostService;
import com.com.cnu.devlog_springboot.week1.practice.service.fixture.PostFixture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

//@ActiveProfiles("dev")
@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    void init() {

    }

    @DisplayName("글 저장 테스트")
//    @Transactional
    @Test
    void createPost() {
        PostRequest postRequest = PostFixture.getNormalPostRequest();

        Post post = postService.creatPost(postRequest);
        assertAll("verify object",
                () -> assertThat(post.getTitle()).isEqualTo(postRequest.title()),
                () -> assertThat(post.getContents()).isEqualTo(postRequest.contents()),
                () -> assertThat(post.getTag()).isEqualTo(postRequest.tag())
        );
    }

    @DisplayName("비속어 글 저장 테스트")
    @Transactional
    @Test
    void createPostWithSlang() {
        PostRequest postRequest = PostFixture.getSlangPostRequest();
        assertThrows(SlangBadRequestException.class, () -> postService.creatPost(postRequest));
    }


    @DisplayName("글 업데이트 테스트")
    @Test
    void updatePost() {
        // given
        PostRequest postRequest = PostFixture.getNormalPostRequest();
        Post post = postService.creatPost(postRequest);

        PostRequest updatedPostRequest = PostFixture.getNormalPostRequestUpdated();
        // when
        Post updatedPost = postService.updatePost(post.getId(), updatedPostRequest);

        // then
        assertAll("verify object",
                () -> assertThat(updatedPost.getTitle()).isEqualTo(updatedPostRequest.title()),
                () -> assertThat(updatedPost.getContents()).isEqualTo(updatedPostRequest.contents()),
                () -> assertThat(updatedPost.getTag()).isEqualTo(updatedPostRequest.tag())
        );
    }
}
