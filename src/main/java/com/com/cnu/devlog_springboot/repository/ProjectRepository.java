package com.com.cnu.devlog_springboot.repository;

import com.com.cnu.devlog_springboot.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project save(Project project);
    List<Project> findAll();
    Optional<Project> findById(Integer projectId);
    void delete(Project project);
}
