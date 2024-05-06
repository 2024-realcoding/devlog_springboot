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
    private final ProjectService projectService;

    // GET /projects
    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projectService.getProjects());
    }

    // GET /projects/{projectId}
    @GetMapping("{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId")Integer projectId) {
        return ResponseEntity.ok(projectService.getProject(projectId));
    }

    // POST /projects
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody final ProjectRequest request) {
        return ResponseEntity.ok(projectService.createProject(request));
    }

    // PUT /projects/{projects}
    // ex. localhost:8080/projects/3
    @PutMapping("{projectId}")
    public ResponseEntity<Project> updateProject(
            @PathVariable("projectId") final Integer projectId,
            @RequestBody final ProjectRequest request
    ) {
        final Project project = projectService.updateProject(projectId, request);
        return ResponseEntity.ok(project);
    }

    // DELETE /projects/{projects}
    @DeleteMapping("{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable("projectId") final Integer projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
