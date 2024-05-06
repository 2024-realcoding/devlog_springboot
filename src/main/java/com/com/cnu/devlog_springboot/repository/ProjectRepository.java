package com.com.cnu.devlog_springboot.repository;

import com.com.cnu.devlog_springboot.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {


}
