package com.KookBee.portfolioservice.domain.response.projectResponse;

import com.KookBee.portfolioservice.domain.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeProjectResponse {
    private Long projectId;
    private String projectName;
    private String projectTeamName;
    private Integer projectMemberCount;
    private String projectSubject;

    public HomeProjectResponse(Project project) {
        this.projectId = project.getId();
        if(project.getProjectTitle().length() <= 10) this.projectName = project.getProjectTitle();
        else this.projectName = project.getProjectTitle().substring(0, 9);
        this.projectTeamName = project.getProjectTeamName();
        this.projectMemberCount = project.getProjectUserList().size();
        this.projectSubject = project.getProjectSubject().substring(0,2);
    }
}
