package com.com.cnu.devlog_springboot.controller;

import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        final List<Project> projects = projectService.getProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId") final Integer projectId) {
        final Project project = projectService.getProject(projectId);
        return ResponseEntity.ok(project);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody final ProjectRequest request) {
        final Project project = projectService.createProject(request);
        return ResponseEntity.ok(project);
    }

    @PutMapping("{projectId}")
    public ResponseEntity<Project> updateProject(
            @PathVariable("projectId") final Integer projectId,
            @RequestBody final ProjectRequest request
    ) {
        final Project project = projectService.updateProject(projectId, request);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable("projectId") final Integer projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
