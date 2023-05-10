package com.KookBee.portfolioservice.domain.dto;

import com.KookBee.portfolioservice.domain.entity.GroupStudy;
import com.KookBee.portfolioservice.domain.enums.EStudyApplyStatus;
import com.KookBee.portfolioservice.domain.request.PortfolioStudyApplyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class GroupStudyApplyPostDTO {
    private Long groupStudyApplicantId;
    private String groupStudyApplicantName;
    private String groupStudyApplyContents;
    private GroupStudy groupStudy;
    private EStudyApplyStatus eStudyApplyStatus;
    private LocalDate groupStudyApplyCreateAt;

    public GroupStudyApplyPostDTO(PortfolioStudyApplyRequest request,
                                  GroupStudy groupStudy, Long userId, String userName) {
        this.groupStudyApplicantId = userId;
        this.groupStudyApplicantName = userName;
        this.groupStudyApplyContents = request.getGroupStudyApplyContents();
        this.groupStudy = groupStudy;
        this.eStudyApplyStatus = EStudyApplyStatus.PENDING;
        this.groupStudyApplyCreateAt = LocalDate.now();
    }
}
