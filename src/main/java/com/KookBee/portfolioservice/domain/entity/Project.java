package com.KookBee.portfolioservice.domain.entity;

import com.KookBee.portfolioservice.domain.enums.EAllStatus;
import com.KookBee.portfolioservice.domain.request.ProjectRequest;
import com.KookBee.portfolioservice.domain.request.ProjectSubmitRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;
    private String projectTitle;
    private String projectTeamName;
    private String projectLeaderName;
    private Long projectLeaderId;
    private String projectSubject;
    private String projectDescription;
    private String projectOutputLink;
    private String projectOutputFileUUID;
    @Enumerated(EnumType.STRING)
    private EAllStatus projectStatus;
    @JsonIgnore
    @OneToMany (mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectUser> projectUserList;
    private Long bootcampId;
    private String projectCode;
    private LocalDateTime createAt = LocalDateTime.now();

    public Project(ProjectRequest request, Long userId,  Long bootcampId, String projectCode) {
        this.projectTitle = request.getProjectTitle();
        this.projectTeamName = request.getProjectTeamName();
        this.projectLeaderId = userId;
        this.projectLeaderName = request.getProjectLeaderName();
        this.projectSubject = request.getProjectSubject();
        this.projectDescription = request.getProjectDescription();
        this.projectStatus = request.getProjectStatus();
        this.bootcampId = bootcampId;
        this.projectCode = projectCode;
    }
    public Project updateProject(ProjectRequest request){
        this.projectTitle = request.getProjectTitle();
        this.projectTeamName = request.getProjectTeamName();
        this.projectSubject = request.getProjectSubject();
        this.projectDescription = request.getProjectDescription();
        this.projectStatus = request.getProjectStatus();
        return this;
    }
    public Project updateStatus(EAllStatus projectStatus) {
        this.projectStatus = projectStatus;
        return this;
    }

    public Project(Long id) {
        this.id = id;
    }

    public Project finishedProject(ProjectSubmitRequest request, EAllStatus finished) {
        this.projectOutputFileUUID = request.getProjectOutputFileUUID();
        this.projectOutputLink = request.getProjectOutputLink();
        this.projectStatus = finished;
        return this;
    }
}
