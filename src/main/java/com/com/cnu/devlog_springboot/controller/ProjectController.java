package com.com.cnu.devlog_springboot.controller;


import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projectService.getProjects());
    }

    @GetMapping("{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable Integer projectId) {
        return ResponseEntity.ok(projectService.getProject(projectId));
    }
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.createProject(projectRequest));
    }

    @PutMapping("{projectId}")
    public ResponseEntity<Project> updateProject(
            @PathVariable Integer projectId,
            @RequestBody ProjectRequest projectRequest
    )
    {
        return ResponseEntity.ok(projectService.updateProject(projectId, projectRequest));
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }

}
