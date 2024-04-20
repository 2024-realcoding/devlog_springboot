package com.com.cnu.devlog_springboot.service;

import com.com.cnu.devlog_springboot.exception.DevlogException;
import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.model.request.PostRequest;
import com.com.cnu.devlog_springboot.repository.PostRepository;
import com.com.cnu.devlog_springboot.type.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostRequest postRequest) {
        return postRepository.save(new Post(
                null,
                postRequest.title(),
                postRequest.contents())
        );
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(Integer postId) {
        //return postRepository.findById(postId).orElse(null);
        // FIXME: 2주차 내용
        return postRepository.findById(postId)
                .orElseThrow(() -> new DevlogException(ErrorCode.POST_NOT_FOUND));
    }

    @Transactional
    public Post updatePost(Integer postId, PostRequest postRequest) {
//        return postRepository.findById(postId)
//                .map(post -> {
//                    post.setTitle(postRequest.title());
//                    post.setContents(postRequest.contents());
//                    return postRepository.save(post);
//                })
//                .orElse(null);
        // FIXME: 2주차 내용
        return postRepository.findById(postId)
                .map(post -> {
                    post.setTitle(postRequest.title());
                    post.setContents(postRequest.contents());
                    return post;
                })
                .orElseThrow(() -> new DevlogException(ErrorCode.POST_NOT_FOUND));
    }

    public void deletePost(Integer postId) {
//        postRepository.findById(postId)
//                .ifPresent(postRepository::delete);

        // FIXME: 2주차 내용
        postRepository.findById(postId)
                .ifPresentOrElse(postRepository::delete, () -> {
                    throw new DevlogException(ErrorCode.POST_NOT_FOUND);
                });
    }
}
