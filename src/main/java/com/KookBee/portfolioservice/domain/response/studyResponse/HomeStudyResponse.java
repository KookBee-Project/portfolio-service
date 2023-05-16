package com.KookBee.portfolioservice.domain.response.studyResponse;

import com.KookBee.portfolioservice.domain.entity.GroupStudy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeStudyResponse {
    private Long groupStudyId;
    private String groupStudyName;
    private Integer currentGroupStudyLectureIteration; //회차수 + 1
    private Integer groupStudyMemberCount;

    public HomeStudyResponse(GroupStudy groupStudy) {
        this.groupStudyId = groupStudy.getId();
        if(groupStudy.getGroupStudyName().length() <= 10) this.groupStudyName = groupStudy.getGroupStudyName();
        else this.groupStudyName = groupStudy.getGroupStudyName().substring(0,9) + "...";
        this.currentGroupStudyLectureIteration = groupStudy.getGroupStudyLectureList().size() + 1;
        this.groupStudyMemberCount = groupStudy.getGroupStudyMembers().size();
    }
}
