package com.KookBee.portfolioservice.domain.response.projectResponse;

import com.KookBee.portfolioservice.domain.entity.Project;
import com.KookBee.portfolioservice.domain.enums.EAllStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectResponse {
    private Long id;
    private String projectTeamName;
    private String projectLeaderName;
    private String projectSubject;
    private String projectDescription;
    private String projectOutputLink;
    private String projectOutputFileUUID;
    private EAllStatus projectStatus;
    private String projectCode;


    public ProjectResponse(Project project) {
        this.id = project.getId();
        this.projectTeamName = project.getProjectTeamName();
        this.projectLeaderName = project.getProjectLeaderName();
        this.projectSubject = project.getProjectSubject();
        this.projectDescription = project.getProjectDescription();
        this.projectOutputLink = project.getProjectOutputLink();
        this.projectOutputFileUUID = project.getProjectOutputFileUUID();
        this.projectStatus = project.getProjectStatus();
        this.projectCode = project.getProjectCode();
    }



}
