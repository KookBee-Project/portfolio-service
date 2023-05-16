package com.KookBee.portfolioservice.domain.dto;

import com.KookBee.portfolioservice.domain.entity.GroupStudy;
import com.KookBee.portfolioservice.domain.enums.EStudyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
public class GroupStudyGetDTO {
    private String groupStudyName;
    private String groupStudyLeaderName;
    private String groupStudyPurpose;
    private LocalDate groupStudyOpenDate;
    private Integer groupStudyMemberCounts;

    public GroupStudyGetDTO(GroupStudy groupStudy, String leaderName, Integer counts) {
        this.groupStudyName = groupStudy.getGroupStudyName();
        this.groupStudyLeaderName = leaderName;
        this.groupStudyPurpose = groupStudy.getGroupStudyPurpose();
        this.groupStudyOpenDate = groupStudy.getGroupStudyOpenDate();
        this.groupStudyMemberCounts = counts;
    }
}
