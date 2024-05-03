package com.com.cnu.devlog_springboot.controller;

import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.model.request.PostRequest;
import com.com.cnu.devlog_springboot.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // GET /posts
    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    // GET /posts/{postId}
    @GetMapping("{postId}")
    public ResponseEntity<Post> getPost(@PathVariable("postId")Integer postId) {
        Post post = postService.getPost(postId);
        if (post != null) {
            return ResponseEntity.ok(postService.getPost(postId));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /posts
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest) {
        return ResponseEntity.ok(postService.creatPost(postRequest));
    }

    // PUT /posts/{postId}
    // ex. localhost:8080/posts/3
    @PutMapping("{postId}")
    public ResponseEntity<Post> updatePost(
            @PathVariable("postId")Integer postId,
            @RequestBody PostRequest postRequest
    ) {
        Post post = postService.getPost(postId);
        if (post != null) {
            return ResponseEntity.ok(postService.updatePost(postId, postRequest));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /posts/{postId}
    @DeleteMapping("{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Integer postId) {
        Post post = postService.getPost(postId);
        if (post != null) {
            postService.deletePost(postId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
