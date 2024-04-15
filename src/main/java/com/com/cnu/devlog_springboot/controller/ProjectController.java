package com.com.cnu.devlog_springboot.controller;

import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.PostRequest;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.service.PostService;
import com.com.cnu.devlog_springboot.service.ProjectService;
import com.com.cnu.devlog_springboot.type.Tag;
import io.micrometer.common.lang.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    @Autowired
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projectService.getProjects());
    }

    // GET /posts/{postId}
    @GetMapping("{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId")Integer projectId) {
        return ResponseEntity.ok(projectService.getProject(projectId));
    }

    // POST /posts
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.createProject(projectRequest));
    }

    // PUT /posts/{postId}
    // localhost:8080/posts/3
    @PutMapping("{projectId}")
    public ResponseEntity<Project> updateProject(
            @PathVariable Integer projectId,
            @RequestBody ProjectRequest projectRequest
    ) {
        return ResponseEntity.ok(projectService.updateProject(projectId, projectRequest));
    }

    // DELETE /posts/{postId}
    @DeleteMapping("{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable("projectId")Integer projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
