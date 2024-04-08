package com.com.cnu.devlog_springboot.service;

import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.model.request.PostRequest;
import com.com.cnu.devlog_springboot.repository.PostRepository;
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

    public Post createPost(PostRequest postRequest) {
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
                .orElse(null);
    }

    public Post getPost(Integer postId) {
        return postRepository.findById(postId)
                .orElse(null);
    }

    public void deletePost(Integer postId) {
        postRepository.findById(postId)
                .ifPresent(postRepository::delete);
    }
}
