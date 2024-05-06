package com.com.cnu.devlog_springboot.repository;

import com.com.cnu.devlog_springboot.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByTag(Tag tag);
}
