package com.KookBee.portfolioservice.domain.request;

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
public class ProjectRequest {
    private String projectTitle;
    private String projectTeamName;
    private String projectLeaderName;
    private String projectSubject;
    private String projectDescription;
    private EAllStatus projectStatus;


}
