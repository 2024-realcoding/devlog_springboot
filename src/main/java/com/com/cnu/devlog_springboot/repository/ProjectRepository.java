package com.com.cnu.devlog_springboot.repository;

import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.type.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    // post save(Post post);
    // List<Post> findAll();
    // Optional<Post> findById(Integer postId);
    // void delete(Post post);
//    List<Project> findAllByTag(Tag tag);
}
