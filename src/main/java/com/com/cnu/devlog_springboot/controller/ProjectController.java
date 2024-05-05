package com.com.cnu.devlog_springboot.controller;

import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.repository.ProjectRepository;
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
    private final ProjectRepository projectRepository;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projectService.getProjects());
    }

    @PostMapping
    public ResponseEntity<Project> postProject(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.createProject(projectRequest));
    }

    @GetMapping("{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId") Integer projectId) {
        if (projectRepository.findById(projectId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projectService.getProject(projectId));
    }

    @PutMapping("{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable Integer projectId, @RequestBody ProjectRequest projectRequest) {
        if (projectRepository.findById(projectId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(projectService.updateProject(projectId, projectRequest));
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<Project> deleteProject(@PathVariable Integer projectId) {
        if (projectRepository.findById(projectId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}