package com.KookBee.portfolioservice.domain.response;

import com.KookBee.portfolioservice.domain.entity.GroupStudyApply;
import com.KookBee.portfolioservice.domain.enums.EStudyApplyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PortfolioStudyApplyRequestedResponse {
    private Long groupStudyApplyId;
    private String groupStudyName;
    private EStudyApplyStatus eStudyApplyStatus;
    private LocalDate groupStudyApplyCreateAt;

    public PortfolioStudyApplyRequestedResponse(GroupStudyApply apply) {
        this.groupStudyApplyId = apply.getId();
        this.groupStudyName = apply.getGroupStudy().getGroupStudyName();
        this.eStudyApplyStatus = apply.getEStudyApplyStatus();
        this.groupStudyApplyCreateAt = apply.getGroupStudyApplyCreateAt();
    }
}
