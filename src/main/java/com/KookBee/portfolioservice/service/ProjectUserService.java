package com.KookBee.portfolioservice.service;

import com.KookBee.portfolioservice.domain.entity.Project;
import com.KookBee.portfolioservice.domain.entity.ProjectUser;
import com.KookBee.portfolioservice.domain.request.ProjectUserRequest;
import com.KookBee.portfolioservice.domain.response.projectUserResponse.ProjectUserResponse;
import com.KookBee.portfolioservice.repository.ProjectRepository;
import com.KookBee.portfolioservice.repository.ProjectUserRepository;
import com.KookBee.portfolioservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ProjectUserService {
    private final ProjectUserRepository projectUserRepository;
    private final JwtService jwtService;
    private final ProjectRepository projectRepository;

    public ProjectUserResponse getNewUser(ProjectUserRequest request){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        Project project = projectRepository.findByProjectCode(request.getProjectCode()).orElse(null);
        ProjectUser projectUser = new ProjectUser(project, userId, request.getUserName());
        return new ProjectUserResponse(projectUserRepository.save(projectUser));
    }
}
