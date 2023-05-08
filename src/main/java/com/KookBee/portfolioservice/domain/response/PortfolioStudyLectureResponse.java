package com.KookBee.portfolioservice.domain.response;

import com.KookBee.portfolioservice.domain.entity.GroupStudyLecture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PortfolioStudyLectureResponse {
    private Integer groupStudyLectureIteration;
    private String groupStudyLectureTitle;
    private String groupStudyLectureContents;
    private Integer submitterCounts;

    public PortfolioStudyLectureResponse(GroupStudyLecture lecture, Integer postCounts) {
        this.groupStudyLectureIteration = lecture.getGroupStudyLectureIteration();
        this.groupStudyLectureTitle = lecture.getGroupStudyLectureTitle();
        this.groupStudyLectureContents = lecture.getGroupStudyLectureContents();
        this.submitterCounts = postCounts;
    }
}
