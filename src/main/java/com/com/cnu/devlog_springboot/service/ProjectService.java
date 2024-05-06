package com.com.cnu.devlog_springboot.service;

import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.repository.ProjectRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project create(ProjectRequest request) {
        Project project = request.toProject();
        return projectRepository.save(project);
    }

    public Project update(Long id, ProjectRequest request) {
        Project project = projectRepository.getById(id);
        project.update(
                request.title(),
                request.summary(),
                request.contents(),
                request.startDate(),
                request.endDate()
        );
        return project;
    }

    public void delete(Long id) {
        Project project = projectRepository.getById(id);
        projectRepository.delete(project);
    }

    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Project getById(Long id) {
        return projectRepository.getById(id);
    }
}