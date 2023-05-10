package com.KookBee.portfolioservice.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PortfolioStudyCheckResponse {
    private boolean isStudyJoin;
    private List<PortfolioStudyLectureResponse> responseList;
}
