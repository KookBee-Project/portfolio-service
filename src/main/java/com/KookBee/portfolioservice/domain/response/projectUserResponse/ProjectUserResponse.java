package com.KookBee.portfolioservice.domain.response.projectUserResponse;

import com.KookBee.portfolioservice.domain.entity.Project;
import com.KookBee.portfolioservice.domain.entity.ProjectUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectUserResponse {
    private Long id;
    private Long userId;
    private Long projectId;

    public ProjectUserResponse(ProjectUser projectUser) {
        this.id = projectUser.getId();
        this.userId = projectUser.getUserId();
        this.projectId = projectUser.getProject().getId();
    }
}
