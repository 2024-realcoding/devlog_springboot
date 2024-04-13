package com.cnu.devlog_springboot.week1.base.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.cnu.devlog_springboot.model.Post;
import com.cnu.devlog_springboot.service.PostService;
import com.cnu.devlog_springboot.week1.practice.service.fixture.PostFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("dev")
@SpringBootTest
public class PostServiceWithSpringTest {
    @Autowired
    PostService postService;

    @DisplayName("테스트 코드에서 Spring Component 실행해보기")
    @Test
    void testDoCodeRun() {
        Post post = postService.createPost(PostFixture.getNormalPostRequest());
        assertThat(post).isNotNull();
    }
}
