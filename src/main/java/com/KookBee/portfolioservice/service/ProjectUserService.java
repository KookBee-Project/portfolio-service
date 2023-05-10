package com.KookBee.portfolioservice.service;

import com.KookBee.portfolioservice.domain.entity.Project;
import com.KookBee.portfolioservice.domain.entity.ProjectUser;
import com.KookBee.portfolioservice.domain.enums.EAllStatus;
import com.KookBee.portfolioservice.domain.request.ProjectUserRequest;
import com.KookBee.portfolioservice.domain.response.projectUserResponse.ProjectUserResponse;
import com.KookBee.portfolioservice.exception.ProjectCodeCheckException;
import com.KookBee.portfolioservice.exception.ProjectJoinStatusCheckException;
import com.KookBee.portfolioservice.exception.ProjectUserCheckException;
import com.KookBee.portfolioservice.repository.ProjectRepository;
import com.KookBee.portfolioservice.repository.ProjectUserRepository;
import com.KookBee.portfolioservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectUserService {
    private final ProjectUserRepository projectUserRepository;
    private final JwtService jwtService;
    private final ProjectRepository projectRepository;

    public ProjectUserResponse getNewUser(ProjectUserRequest request) throws ProjectCodeCheckException, ProjectUserCheckException, ProjectJoinStatusCheckException {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        Project project = projectRepository.findByProjectCode(request.getProjectCode()).orElseThrow(ProjectCodeCheckException::new);
        if(project.getProjectStatus() != EAllStatus.PENDING)
            throw new ProjectJoinStatusCheckException();
        Optional<ProjectUser> find = projectUserRepository.findByProjectAndUserId(project, userId);
        if(find.isPresent())
            throw new ProjectUserCheckException();
        ProjectUser projectUser = new ProjectUser(project, userId, request.getUserName());
        return new ProjectUserResponse(projectUserRepository.save(projectUser));
    }
}
