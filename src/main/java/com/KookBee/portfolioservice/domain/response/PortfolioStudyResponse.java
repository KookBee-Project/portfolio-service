package com.KookBee.portfolioservice.domain.response;

import com.KookBee.portfolioservice.domain.dto.UserDTO;
import com.KookBee.portfolioservice.domain.entity.GroupStudy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PortfolioStudyResponse {
    private Long groupStudyId;
    private String groupStudyName;
    private Long groupStudyLeaderId;
    private String groupStudyLeaderName;
    private String groupStudyPurpose;
    private LocalDate groupStudyOpenDate;
    private Integer groupStudyMemberCounts;

    public PortfolioStudyResponse(GroupStudy groupStudy, UserDTO userDTO, Integer memberCounts) {
        this.groupStudyId = groupStudy.getId();
        this.groupStudyName = groupStudy.getGroupStudyName();
        this.groupStudyLeaderId = groupStudy.getGroupStudyLeader();
        this.groupStudyLeaderName = userDTO.getUserName();
        this.groupStudyPurpose = groupStudy.getGroupStudyPurpose();
        this.groupStudyOpenDate = groupStudy.getGroupStudyOpenDate();
        this.groupStudyMemberCounts = memberCounts;
    }
}
