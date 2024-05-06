package com.com.cnu.devlog_springboot.controller;

import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    // GET /projects
    public final ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable Integer projectId) {
        Project project = projectService.getProject(projectId);
        return ResponseEntity.ok(project);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.createProject(projectRequest));
    }

    @PutMapping("{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable Integer projectId, @RequestBody ProjectRequest projectRequest) {
        Project project = projectService.updateProject(projectId, projectRequest);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
