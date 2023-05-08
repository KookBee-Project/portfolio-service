package com.KookBee.portfolioservice.controller;

import com.KookBee.portfolioservice.domain.request.ProjectRequest;
import com.KookBee.portfolioservice.domain.response.projectResponse.ProjectDetailResponse;
import com.KookBee.portfolioservice.domain.response.projectResponse.ProjectListResponse;
import com.KookBee.portfolioservice.domain.response.projectResponse.ProjectResponse;
import com.KookBee.portfolioservice.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolio/project")
public class ProjectController {
    private final ProjectService projectService;
    @PostMapping("/{bootcampId}")
    public ProjectResponse createProject(@PathVariable Long bootcampId,@RequestBody ProjectRequest request){
        return projectService.createNewProject(bootcampId, request);
    }
    @GetMapping("/{bootcampId}")
    public List<ProjectListResponse> getProjectList(@PathVariable Long bootcampId) {
        return projectService.getProjectList(bootcampId);
    }
    @GetMapping("/detail/{projectId}")
    public ProjectDetailResponse getProject(@PathVariable Long projectId){
        return projectService.getProject(projectId);
    }
    @DeleteMapping("/detail/{projectId}")
    public ProjectResponse deleteProject(@PathVariable Long projectId){
        return projectService.deleteProject(projectId);
    }
    @PutMapping("/detail/{projectId}")
    public ProjectResponse updateProject(@PathVariable Long projectId, @RequestBody ProjectRequest request){
        return projectService.updateProject(projectId,request);
    }
}
