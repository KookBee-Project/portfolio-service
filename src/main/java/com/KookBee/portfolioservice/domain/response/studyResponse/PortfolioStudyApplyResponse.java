package com.KookBee.portfolioservice.domain.response.studyResponse;

import com.KookBee.portfolioservice.domain.entity.GroupStudyApply;
import com.KookBee.portfolioservice.domain.enums.EStudyApplyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PortfolioStudyApplyResponse {
    private Long groupStudyApplyId;
    private String groupStudyName;
    private String groupStudyApplicantName;
    private String groupStudyApplyContents;
    private EStudyApplyStatus eStudyApplyStatus;
    private LocalDate groupStudyApplyCreateAt;

    public PortfolioStudyApplyResponse(GroupStudyApply apply) {
        this.groupStudyApplyId = apply.getId();
        this.groupStudyName = apply.getGroupStudy().getGroupStudyName();
        this.groupStudyApplicantName = apply.getGroupStudyApplicantName();
        this.groupStudyApplyContents = apply.getGroupStudyApplyContents();
        this.eStudyApplyStatus = apply.getEStudyApplyStatus();
        this.groupStudyApplyCreateAt = apply.getGroupStudyApplyCreateAt();
    }
}
