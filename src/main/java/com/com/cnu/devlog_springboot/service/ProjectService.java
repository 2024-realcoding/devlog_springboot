package com.com.cnu.devlog_springboot.service;

import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project createProject(ProjectRequest projectRequest) {
        return projectRepository.save(new Project(
                null,
                projectRequest.title(),
                projectRequest.summary(),
                projectRequest.contents(),
                projectRequest.startDate(),
                projectRequest.endDate()
        ));
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(Integer projectId) {
        return projectRepository.findById(projectId)
                .orElse(null);
    }

    public Project updateProject(Integer projectId, ProjectRequest projectRequest) {
        return projectRepository.findById(projectId)
                .map(project -> {
                    project.setTitle(projectRequest.title());
                    project.setContents(projectRequest.contents());
                    project.setSummary(projectRequest.summary());
                    project.setStartDate(projectRequest.startDate());
                    project.setEndDate((projectRequest.endDate()));
                    return projectRepository.save(project);
                })
                .orElse(null);
    }

    public void deleteProject(Integer projectId) {
        projectRepository.findById(projectId)
                .ifPresent(projectRepository::delete);
    }
}
