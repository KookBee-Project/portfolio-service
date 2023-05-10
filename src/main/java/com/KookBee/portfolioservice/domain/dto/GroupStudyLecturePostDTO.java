package com.KookBee.portfolioservice.domain.dto;

import com.KookBee.portfolioservice.domain.entity.GroupStudy;
import com.KookBee.portfolioservice.domain.request.PortfolioStudyLectureRegisterRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class GroupStudyLecturePostDTO {
    private GroupStudy groupStudy;
    private Integer groupStudyLectureIteration;
    private String groupStudyLectureTitle;
    private String groupStudyLectureContents;
    private LocalDate groupStudyLectureCreateAt;

    public GroupStudyLecturePostDTO(PortfolioStudyLectureRegisterRequest request, GroupStudy groupStudy) {
        this.groupStudy = groupStudy;
        this.groupStudyLectureIteration = request.getGroupStudyLectureIteration();
        this.groupStudyLectureTitle = request.getGroupStudyLectureTitle();
        this.groupStudyLectureContents = request.getGroupStudyLectureContents();
        this.groupStudyLectureCreateAt = LocalDate.now();
    }
}
