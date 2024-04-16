package com.com.cnu.devlog_springboot.service;

import com.com.cnu.devlog_springboot.exception.DevlogException;
import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.model.request.PostRequest;
import com.com.cnu.devlog_springboot.repository.PostRepository;
import com.com.cnu.devlog_springboot.type.ErrorCode;
import com.com.cnu.devlog_springboot.type.Tag;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getPosts(@Nullable Tag tag) {
        if(tag != null){
            return postRepository.findAllByTag(tag);
        }
        return postRepository.findAll();
    }

    public Post createPost(PostRequest postRequest) {
        return postRepository.save(new Post(
                null,
                postRequest.title(),
                postRequest.content(),
                postRequest.tag()
        ));
    }
    public Post updatePost(Integer postId, PostRequest postRequest){
        return postRepository.findById(postId)
                .map(post -> {
                    post.setTitle(postRequest.title());
                    post.setContents(postRequest.content());
                    return postRepository.save(post);
                })
                .orElse(null);
    }

    public Post getPost(Integer postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new DevlogException(ErrorCode.POST_NOT_FOUND)) ;
    }

    public void deletePost(Integer postId) {
        postRepository.findById(postId)
                .ifPresent(postRepository::delete);
    }
}
