package com.com.cnu.devlog_springboot.controller;

import com.com.cnu.devlog_springboot.model.response.Project;
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
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createPost(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.createProject(projectRequest));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projectService.getProjects());
    }

    @GetMapping("{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId") Integer projectId) {
        return ResponseEntity.ok(projectService.getProject(projectId));
    }

    @PutMapping("{projectId}")
    public ResponseEntity<Project> updateProject(
            @PathVariable("projectId") Integer projectId,
            @RequestBody ProjectRequest projectRequest
    ) {
        return ResponseEntity.ok(projectService.updateProject(projectId, projectRequest));
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<Void> deletePost(@PathVariable("projectId") Integer projectId) {
        projectService.deletePost(projectId);
        return ResponseEntity.noContent().build();
    }
}