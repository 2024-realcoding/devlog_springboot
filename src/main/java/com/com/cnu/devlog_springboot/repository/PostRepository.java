package com.com.cnu.devlog_springboot.repository;

import com.com.cnu.devlog_springboot.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.com.cnu.devlog_springboot.type.Tag;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByTag(Tag tag);
}
