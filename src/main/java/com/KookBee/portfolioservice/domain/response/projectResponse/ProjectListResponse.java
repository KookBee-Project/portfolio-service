package com.KookBee.portfolioservice.domain.response.projectResponse;

import com.KookBee.portfolioservice.domain.entity.Project;
import com.KookBee.portfolioservice.domain.enums.EAllStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectListResponse {
    private Long id;
    private String projectTitle;
    private String projectTeamName;
    private String projectLeaderName;
    private String projectSubject;
    private LocalDateTime createAt;
    private EAllStatus projectStatus;
    private Long bootcampId;
    private Long countUsers;
    public ProjectListResponse(Project project, Long count) {
        this.id = project.getId();
        if(project.getProjectTitle().length() >= 10) this.projectTitle = project.getProjectTitle().substring(0, 9) + "...";
        else this.projectTitle = project.getProjectTitle();
        this.projectTeamName = project.getProjectTeamName();
        this.projectLeaderName = project.getProjectLeaderName();
        this.projectSubject = project.getProjectSubject();
        this.createAt = project.getCreateAt();
        this.projectStatus = project.getProjectStatus();
        this.bootcampId = project.getBootcampId();
        this.countUsers = count;
    }
}
