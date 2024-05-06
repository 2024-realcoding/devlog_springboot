package com.com.cnu.devlog_springboot.service;

import com.com.cnu.devlog_springboot.exception.DevlogException;
import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.repository.ProjectRepository;
import com.com.cnu.devlog_springboot.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

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

    public Project updateProject(Integer projectId, ProjectRequest projectRequest) {
        return projectRepository.findById(projectId)
                .map(project -> {
                    project.setTitle(projectRequest.title());
                    project.setSummary(projectRequest.summary());
                    project.setContents(projectRequest.contents());
                    project.setStartDate(projectRequest.startDate());
                    project.setEndDate(projectRequest.endDate());
                    return projectRepository.save(project);
                })
                .orElseThrow(() -> new DevlogException(ErrorCode.POST_NOT_FOUND));
    }

    public Project getProject(Integer projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new DevlogException(ErrorCode.POST_NOT_FOUND));
    }

    public void deleteProject(Integer projectId) {
        projectRepository.findById(projectId)
                .ifPresentOrElse(projectRepository::delete,
                        () -> {throw new DevlogException(ErrorCode.POST_NOT_FOUND);});


    }
}