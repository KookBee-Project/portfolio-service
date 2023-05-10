package com.KookBee.portfolioservice.domain.dto;

import com.KookBee.portfolioservice.domain.enums.EStudyApplyStatus;
import com.KookBee.portfolioservice.domain.request.PortfolioStudyApplyPutRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class GroupStudyApplyPutDTO {
    private Long groupStudyApplyId;
    private EStudyApplyStatus eStudyApplyStatus;

    public GroupStudyApplyPutDTO(PortfolioStudyApplyPutRequest request, Long applyId) {
        this.groupStudyApplyId = applyId;
        this.eStudyApplyStatus = EStudyApplyStatus.valueOf(request.getStudyApplyStatus());
    }
}
