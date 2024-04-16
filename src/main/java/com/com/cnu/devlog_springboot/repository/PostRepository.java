package com.com.cnu.devlog_springboot.repository;

import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.type.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> { //    Post save(Post post);
//    List<Post> findAll();
//    Optional<Post> findById(Integer postId);
//    void delete(Post post);
    List<Post> findAllByTag(Tag tag);
}