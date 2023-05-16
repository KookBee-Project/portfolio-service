package com.KookBee.portfolioservice.controller;

import com.KookBee.portfolioservice.domain.request.ProjectUserRequest;
import com.KookBee.portfolioservice.domain.response.projectUserResponse.ProjectUserResponse;
import com.KookBee.portfolioservice.exception.ProjectCodeCheckException;
import com.KookBee.portfolioservice.exception.ProjectJoinStatusCheckException;
import com.KookBee.portfolioservice.exception.ProjectUserCheckException;
import com.KookBee.portfolioservice.service.ProjectUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolio/project/user")
public class ProjectUserController {
    private final ProjectUserService projectUserService;
    @PostMapping
    public ProjectUserResponse getNewUser(@RequestBody ProjectUserRequest request) throws ProjectUserCheckException, ProjectCodeCheckException, ProjectJoinStatusCheckException {
        return projectUserService.getNewUser(request);
    }

}
