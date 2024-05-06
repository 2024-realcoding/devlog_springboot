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

@RequiredArgsConstructor
@RequestMapping("/projects")
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody ProjectRequest request) {
        Project project = projectService.create(request);
        return ResponseEntity.ok(project);
    }

    @PutMapping("{id}")
    public ResponseEntity<Project> updateProject(
            @PathVariable("id") Long id,
            @RequestBody ProjectRequest request
    ) {
        Project project = projectService.update(id, request);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProject(
            @PathVariable("id") Long id
    ) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Project>> findAll() {
        List<Project> projects = projectService.findAll();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getById(
            @PathVariable("id") Long id
    ) {
        Project project = projectService.getById(id);
        return ResponseEntity.ok(project);
    }
}