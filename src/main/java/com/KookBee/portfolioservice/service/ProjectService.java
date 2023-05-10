package com.KookBee.portfolioservice.service;

import com.KookBee.portfolioservice.client.UserServiceClient;
import com.KookBee.portfolioservice.domain.entity.Project;
import com.KookBee.portfolioservice.domain.entity.ProjectUser;
import com.KookBee.portfolioservice.domain.enums.EAllStatus;
import com.KookBee.portfolioservice.domain.request.ProjectRequest;
import com.KookBee.portfolioservice.domain.request.ProjectSubmitRequest;
import com.KookBee.portfolioservice.domain.response.projectResponse.ProjectDetailResponse;
import com.KookBee.portfolioservice.domain.response.projectResponse.ProjectListResponse;
import com.KookBee.portfolioservice.domain.response.projectResponse.ProjectResponse;
import com.KookBee.portfolioservice.repository.ProjectRepository;
import com.KookBee.portfolioservice.repository.ProjectUserRepository;
import com.KookBee.portfolioservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final JwtService jwtService;
    private final UserServiceClient userServiceClient;
    private final ProjectUserRepository projectUserRepository;


    @Transactional
    public ProjectResponse createNewProject (Long bootcampId, ProjectRequest request ){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        StringBuilder projectCode = new StringBuilder();
        for (int i = 1;i<=10;i++){
            char ch;
            if(i<=6){
                ch = (char) ((Math.random() * 26) + 65);
            }else {
                ch = (char) ((Math.random() * 10) + 48);
            }
            projectCode.append(ch);
        }
        Project project = new Project(request, userId, bootcampId, projectCode.toString());
        ProjectUser projectUser = new ProjectUser(projectRepository.save(project), userId, request.getProjectLeaderName());
        projectUserRepository.save(projectUser);
        return new ProjectResponse(project);
    }

    public List<ProjectListResponse> getProjectList(Long bootcampId) {
        List<Project> projectList = projectRepository.findAllByBootcampIdAndProjectStatusNot(bootcampId,EAllStatus.DELETED);
        return projectList.stream().map(el->new ProjectListResponse(el,(long)el.getProjectUserList().size())).toList();
    }
    public ProjectDetailResponse getProject (Long projectId){
        Project project = projectRepository.findById(projectId).orElse(null);
        assert project != null;
        List<String> projectUserList = project.getProjectUserList().stream().map(ProjectUser::getUserName).toList();
        return new ProjectDetailResponse(project, projectUserList);
    }
    public ProjectResponse deleteProject (Long projectId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        assert project != null;
        projectRepository.save(project.updateStatus(EAllStatus.DELETED));
        return new ProjectResponse(project);
    }
    public ProjectResponse updateProject(Long projectId, ProjectRequest request) {
        Project project = projectRepository.findById(projectId).orElse(null);
        assert project != null;
        projectRepository.save(project.updateProject(request));
        return new ProjectResponse(project);
    }

    public ProjectResponse startProject(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(NullPointerException::new);
        projectRepository.save(project.updateStatus(EAllStatus.PROGRESS));
        return new ProjectResponse(project);
    }

    public List<ProjectListResponse> getMyProjectList() {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<ProjectUser> projectUsers = projectUserRepository.findByUserIdAndProjectStatusNot(userId, EAllStatus.DELETED);
        return projectUsers.stream().map(el ->
                        new ProjectListResponse(el.getProject(), (long)el.getProject().getProjectUserList().size()))
                .toList();
    }

    public ProjectResponse endProject(Long projectId, ProjectSubmitRequest request) {
        Project project = projectRepository.findById(projectId).orElseThrow(NullPointerException::new);
        projectRepository.save(project.finishedProject(request, EAllStatus.FINISHED));
        return new ProjectResponse(project);
    }
}
