package com.com.cnu.devlog_springboot.repository;

import com.com.cnu.devlog_springboot.exception.NotFoundException;
import com.com.cnu.devlog_springboot.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    default Project getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException("project가 존재하지 않음"));
    }
}