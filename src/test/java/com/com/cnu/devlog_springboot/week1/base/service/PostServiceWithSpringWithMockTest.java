package com.com.cnu.devlog_springboot.week1.base.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.repository.PostRepository;
import com.com.cnu.devlog_springboot.service.PostService;
import com.com.cnu.devlog_springboot.type.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PostServiceWithSpringWithMockTest {

    @Autowired
    PostService postService;

    @MockBean
    PostRepository postRepository;

    @BeforeEach
    void init() {

    }

    @DisplayName("테스트 코드에서 Spring Component 실행해보기")
    @Test
    void testDoCodeRun() {
        // given : 로직 수행을 위한 상황(데이터) 제시
        String title = "만나서";
        String contents = "반가워요";
        Tag tag = Tag.SPRINGBOOT;

        Post testPostData = Post.builder()
                .title(title)
                .contents(contents)
                .tag(tag)
                .build();
        when(postRepository.findById(1)).thenReturn(Optional.of(testPostData)); // when 때 실행 시 줄 데이터 세팅

        // when : 로직을 수행
        Post post = postService.getPost(1);
        // then : 생각한 대로 결과가 나오는지 확인
        assertThat(post).isNotNull();
    }
}
