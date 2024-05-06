package com.com.cnu.devlog_springboot.service;

import com.com.cnu.devlog_springboot.exception.DevlogException;
import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.repository.ProjectRepository;
import com.com.cnu.devlog_springboot.type.ErrorCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(final Integer projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new DevlogException(ErrorCode.PROJECT_NOT_FOUND));
    }

    @Transactional
    public Project createProject(final ProjectRequest request) {
        final Project project = new Project(
                null,
                request.title(),
                request.summary(),
                request.contents(),
                request.startDate(),
                request.endDate()
        );
        final Project savedProject = projectRepository.save(project);
        return savedProject;
    }

    @Transactional
    public Project updateProject(final Integer projectId, final ProjectRequest request) {
        final Project updatedProject = projectRepository.findById(projectId)
                .map(project -> {
                    project.setTitle(request.title());
                    project.setSummary(request.summary());
                    project.setContents(request.contents());
                    project.setStartDate(request.startDate());
                    project.setEndDate(request.endDate());
                    return project;
                })
                .orElseThrow(() -> new DevlogException(ErrorCode.PROJECT_NOT_FOUND));
        return updatedProject;
    }

    @Transactional
    public void deleteProject(final Integer projectId) {
        projectRepository.findById(projectId)
                .ifPresent(projectRepository::delete);
    }
}