package com.KookBee.portfolioservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PortfolioStudyRegisterRequest {
    private String groupStudyName;
    private String groupStudyPurpose;
    private List<Long> userIdList;

}
