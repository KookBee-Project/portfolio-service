package com.KookBee.portfolioservice.domain.response.projectResponse;

import com.KookBee.portfolioservice.domain.entity.Project;
import com.KookBee.portfolioservice.domain.enums.EAllStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectListResponse {
    private Long id;
    private String projectTeamName;
    private String projectLeaderName;
    private String projectSubject;
    private String projectDescription;
    private String projectOutputLink;
    private String projectOutputFileUUID;
    private EAllStatus projectStatus;
    private Long bootcampId;
    private Long countUsers;
    public ProjectListResponse(Project project, Long count) {
        this.id = project.getId();
        this.projectTeamName = project.getProjectTeamName();
        this.projectLeaderName = project.getProjectLeaderName();
        this.projectSubject = project.getProjectSubject();
        this.projectDescription = project.getProjectDescription();
        this.projectOutputLink = project.getProjectOutputLink();
        this.projectOutputFileUUID = project.getProjectOutputFileUUID();
        this.projectStatus = project.getProjectStatus();
        this.bootcampId = project.getBootcampId();
        this.countUsers = count;
    }
}
