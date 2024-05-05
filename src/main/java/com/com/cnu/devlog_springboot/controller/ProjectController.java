package com.com.cnu.devlog_springboot.controller;

import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.PostRequest;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.service.PostService;
import com.com.cnu.devlog_springboot.service.ProjectService;
import com.com.cnu.devlog_springboot.type.Tag;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    //Get /posts?tag=JAVA
    @GetMapping
    public ResponseEntity<List<Project>> getProject(){
        return ResponseEntity.ok(projectService.getProjects());
    }

    //Get /posts/{postId}
    @GetMapping("{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId")Integer projectId){
        return ResponseEntity.ok(projectService.getProject(projectId));
    }


    //Post /posts
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest){
        return ResponseEntity.of(projectService.creatProject(projectRequest));
    }

    //Put /posts/{postId}
    //localhost:8080/posts/3
    @PutMapping("{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable("projectId")Integer projectId,
                                           @RequestBody ProjectRequest projectRequest
    ){
        return ResponseEntity.ok(projectService.updateProject(projectId,projectRequest));
    }

    //DELETE /posts/{postId}
    @DeleteMapping("{projectId}")
    public ResponseEntity<Project> deleteProject(@PathVariable("projectId") Integer projectId){
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
