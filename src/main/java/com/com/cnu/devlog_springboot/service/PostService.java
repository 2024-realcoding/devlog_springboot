package com.com.cnu.devlog_springboot.service;

<<<<<<< HEAD
import com.com.cnu.devlog_springboot.exception.DevlogException;
import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.model.request.PostRequest;
import com.com.cnu.devlog_springboot.repository.PostRepository;
import com.com.cnu.devlog_springboot.type.ErrorCode;
import com.com.cnu.devlog_springboot.type.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
=======
import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.model.request.PostRequest;
import com.com.cnu.devlog_springboot.repository.PostRepository;
import lombok.RequiredArgsConstructor;
>>>>>>> origin
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

<<<<<<< HEAD
    public List<Post> getPosts(@Nullable Tag tag) {
        if (tag != null) {
            return postRepository.findAllByTag(tag);
        }
        return postRepository.findAll();
    }

    public Post createPost(PostRequest postRequest) {
        return postRepository.save(new Post(
                null,
                postRequest.title(),
                postRequest.content(),
=======
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post creatPost(PostRequest postRequest) {
        return postRepository.save(new Post(
                null,
                postRequest.title(),
                postRequest.contents(),
>>>>>>> origin
                postRequest.tag()
        ));
    }

    public Post updatePost(Integer postId, PostRequest postRequest) {
        return postRepository.findById(postId)
                .map(post -> {
                    post.setTitle(postRequest.title());
<<<<<<< HEAD
                    post.setContents(postRequest.content());
                    return postRepository.save(post);
                })
                .orElseThrow(()-> new DevlogException(ErrorCode.POST_NOT_FOUND));
=======
                    post.setContents(postRequest.contents());
                    return postRepository.save(post);
                })
                .orElse(null);
>>>>>>> origin
    }

    public Post getPost(Integer postId) {
        return postRepository.findById(postId)
<<<<<<< HEAD
                .orElseThrow(() -> new DevlogException(ErrorCode.POST_NOT_FOUND));
=======
                .orElse(null);
>>>>>>> origin
    }

    public void deletePost(Integer postId) {
        postRepository.findById(postId)
<<<<<<< HEAD
                .ifPresent(postRepository::delete); // post -> postRepository.delete(post)
=======
                .ifPresent(postRepository::delete);
>>>>>>> origin
    }
}
