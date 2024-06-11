package com.cnu.devlog_springboot.service;

import com.cnu.devlog_springboot.exception.DevlogException;
import com.cnu.devlog_springboot.model.Post;
import com.cnu.devlog_springboot.type.ErrorCode;
import com.cnu.devlog_springboot.model.request.PostRequest;
import com.cnu.devlog_springboot.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post creatPost(PostRequest postRequest) {
        return postRepository.save(new Post(
                null,
                postRequest.title(),
                postRequest.contents(),
                postRequest.tag()
        ));
    }

    public Post updatePost(Integer postId, PostRequest postRequest) {
        return postRepository.findById(postId)
                .map(post -> {
                    post.setTitle(postRequest.title());
                    post.setContents(postRequest.contents());
                    return postRepository.save(post);
                })
                .orElseThrow(() -> new DevlogException(ErrorCode.POST_NOT_FOUND));
    }

    public Post getPost(Integer postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new DevlogException(ErrorCode.POST_NOT_FOUND));
    }

    public void deletePost(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new DevlogException(ErrorCode.POST_NOT_FOUND));
        postRepository.delete(post);
    }
}
