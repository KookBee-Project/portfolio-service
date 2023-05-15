package com.KookBee.portfolioservice.controller;

import com.KookBee.portfolioservice.domain.request.ProjectRequest;
import com.KookBee.portfolioservice.domain.request.ProjectSubmitRequest;
import com.KookBee.portfolioservice.domain.response.projectResponse.HomeProjectResponse;
import com.KookBee.portfolioservice.domain.response.projectResponse.ProjectDetailResponse;
import com.KookBee.portfolioservice.domain.response.projectResponse.ProjectListResponse;
import com.KookBee.portfolioservice.domain.response.projectResponse.ProjectResponse;
import com.KookBee.portfolioservice.domain.response.studyResponse.HomeStudyResponse;
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
    public ProjectResponse createProject(@PathVariable("bootcampId") Long bootcampId,@RequestBody ProjectRequest request){
        return projectService.createNewProject(bootcampId, request);
    }
    @GetMapping("/{bootcampId}")
    public List<ProjectListResponse> getProjectList(@PathVariable("bootcampId") Long bootcampId) {
        return projectService.getProjectList(bootcampId);
    }

    @GetMapping("/my")
    public List<ProjectListResponse> getMyProjectList() {
        return projectService.getMyProjectList();
    }
    @GetMapping("/detail/{projectId}")
    public ProjectDetailResponse getProject(@PathVariable("projectId") Long projectId){
        return projectService.getProject(projectId);
    }
    @DeleteMapping("/detail/{projectId}")
    public ProjectResponse deleteProject(@PathVariable("projectId") Long projectId){
        return projectService.deleteProject(projectId);
    }
    @PutMapping("/start/{projectId}")
    public ProjectResponse startProject(@PathVariable("projectId") Long projectId){
        return projectService.startProject(projectId);
    }
    @PutMapping("/submit/{projectId}")
    public ProjectResponse submitProject(@PathVariable("projectId") Long projectId, @RequestBody ProjectSubmitRequest request){
        return projectService.endProject(projectId, request);
    }
    @PutMapping("/detail/{projectId}")
    public ProjectResponse updateProject(@PathVariable Long projectId, @RequestBody ProjectRequest request){
        return projectService.updateProject(projectId,request);
    }

    @GetMapping("/submit/list/{bootcampId}")
    public List<ProjectListResponse> teacherProjectList(@PathVariable("bootcampId") Long bootcampId){
        return projectService.teacherProjectList(bootcampId);
    }
    @GetMapping("/home/list")
    public List<HomeProjectResponse> getMainProjectList() {
        return projectService.getMainProjectList();
    }
}
