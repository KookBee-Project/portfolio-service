package com.KookBee.portfolioservice.domain.entity;

import com.KookBee.portfolioservice.domain.enums.EAllStatus;
import com.KookBee.portfolioservice.domain.request.ProjectUserRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProjectUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_user_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
    private Long userId;
    private String userName;


    public ProjectUser(Project project, Long userId , String userName) {
        this.project = project;
        this.userId = userId;
        this.userName = userName;

    }
}
