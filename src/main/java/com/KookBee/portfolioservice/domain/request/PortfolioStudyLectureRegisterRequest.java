package com.KookBee.portfolioservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PortfolioStudyLectureRegisterRequest {
    private Integer groupStudyLectureIteration;
    private String groupStudyLectureTitle;
    private String groupStudyLectureContents;
}
