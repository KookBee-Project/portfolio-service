package com.KookBee.portfolioservice.domain.dto;

import com.KookBee.portfolioservice.domain.enums.EStudyStatus;
import com.KookBee.portfolioservice.domain.request.PortfolioStudyRegistRequest;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class GroupStudyPostDTO {
    private String groupStudyName;
    private Long groupStudyLeader; // 스터디 리더의 userId
    private String groupStudyPurpose;
    private EStudyStatus groupStudyStatus;
    private LocalDate groupStudyOpenDate;

    public GroupStudyPostDTO(PortfolioStudyRegistRequest request, Long userId) {
        this.groupStudyName = request.getStudyName();
        this.groupStudyLeader = userId;
        this.groupStudyPurpose = request.getStudyPerpose();
        this.groupStudyStatus = EStudyStatus.PROCEEDING;
        this.groupStudyOpenDate = LocalDate.now();
    }
}
