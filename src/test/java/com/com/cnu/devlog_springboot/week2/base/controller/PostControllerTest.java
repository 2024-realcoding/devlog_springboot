package com.com.cnu.devlog_springboot.week2.base.controller;


import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import com.com.cnu.devlog_springboot.service.PostService;
import com.com.cnu.devlog_springboot.week1.practice.service.fixture.PostFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// controller 를 테스트
@ExtendWith(RestDocumentationExtension.class)
@SpringBootTest
//@AutoConfigureMockMvc // -> webAppContextSetup(webApplicationContext)
//@AutoConfigureRestDocs // -> apply(documentationConfiguration(restDocumentation))
public class PostControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .alwaysDo(document("{method-name}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())))
                .build();
    }
    @MockBean // 2
    private PostService postService;

    @DisplayName("게시글 목록")
    @Test
    void getPosts() throws Exception {
        // given
        given(postService.getPosts())
                .willReturn(List.of(PostFixture.getNormalPost())); // 3

        // when
        mockMvc.perform(get("/posts")
                        .contentType(MediaType.APPLICATION_JSON))
        // then
                .andExpect(status().isOk())
                .andDo(document("{method-name}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                List.of(
                                        fieldWithPath("[]").type(JsonFieldType.ARRAY)
                                                .description("결과 데이터"),
                                        fieldWithPath("[].title").type(JsonFieldType.STRING)
                                                .description("제목"),
                                        fieldWithPath("[].contents").type(JsonFieldType.STRING)
                                                .description("글 본문"),
                                        fieldWithPath("[].tag").type(JsonFieldType.STRING)
                                                .description("태그"),
                                        fieldWithPath("[].id").type(JsonFieldType.NUMBER)
                                                .description("id")
                                )
                        )
                ));
    }

    @DisplayName("게시글 확인")
    @Test
    void getPost() throws Exception {
        int id = 1;
        // given
        given(postService.getPost(id))
                .willReturn(PostFixture.getNormalPost());

        // when
        mockMvc.perform(get("/posts/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
        // then
                .andExpect(status().isOk())
                .andDo(document("{method-name}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("title").type(JsonFieldType.STRING)
                                        .description("제목"),
                                fieldWithPath("contents").type(JsonFieldType.STRING)
                                        .description("글 본문"),
                                fieldWithPath("tag").type(JsonFieldType.STRING)
                                        .description("태그"),
                                fieldWithPath("id").type(JsonFieldType.NUMBER)
                                        .description("id")

                        )
                ));
    }
}
