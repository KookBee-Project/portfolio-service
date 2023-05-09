package com.KookBee.portfolioservice.domain.response;

import com.KookBee.portfolioservice.domain.entity.GroupStudyApply;
import com.KookBee.portfolioservice.domain.enums.EStudyApplyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PortfolioStudyApplyResponse {
    private String groupStudyName;
    private String groupStudyApplicantName;
    private String groupStudyApplyContents;
    private EStudyApplyStatus eStudyApplyStatus;

    public PortfolioStudyApplyResponse(GroupStudyApply apply) {
        this.groupStudyName = apply.getGroupStudy().getGroupStudyName();
        this.groupStudyApplicantName = apply.getGroupStudyApplicantName();
        this.groupStudyApplyContents = apply.getGroupStudyApplyContents();
        this.eStudyApplyStatus = apply.getEStudyApplyStatus();
    }
}
