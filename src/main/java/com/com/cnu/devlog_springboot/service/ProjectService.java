package com.com.cnu.devlog_springboot.service;

import com.com.cnu.devlog_springboot.exception.DevlogException;
import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.repository.ProjectRepository;
import com.com.cnu.devlog_springboot.type.ErrorCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                .map(Project -> {
                    Project.setTitle(projectRequest.title());
                    Project.setSummary(projectRequest.summary());
                    Project.setContents(projectRequest.contents());
                    Project.setStartDate(projectRequest.startDate());
                    Project.setEndDate(projectRequest.endDate());
                    return projectRepository.save(Project);
                })
                .orElseThrow(()-> new DevlogException(ErrorCode.PROJECT_NOT_FOUND));
    }

    public Project getProject(Integer projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(()-> new DevlogException(ErrorCode.PROJECT_NOT_FOUND));
    }

    public void deleteProject(Integer projectId) {
        projectRepository.findById(projectId)
                .ifPresent(projectRepository::delete);
    }
}
