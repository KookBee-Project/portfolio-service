package com.KookBee.portfolioservice.domain.response.myPageResponse;

import com.KookBee.portfolioservice.domain.entity.GroupStudyPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MyPageStudyListResponse {

    private Long groupStudyId;
    private Long groupStudyLectureId;
    private Long groupStudyPostId;
    private String groupStudyName;
    private Integer groupStudyLectureIteration;
    private String groupStudyLectureTitle;
    private String groupStudyPostTitle;
    private LocalDate groupStudyPostCreateAt;

    public MyPageStudyListResponse(GroupStudyPost post) {
        this.groupStudyId = post.getGroupStudyLecture().getGroupStudy().getId();
        this.groupStudyLectureId = post.getGroupStudyLecture().getId();
        this.groupStudyPostId = post.getId();
        this.groupStudyName = post.getGroupStudyLecture().getGroupStudy().getGroupStudyName();
        this.groupStudyLectureIteration = post.getGroupStudyLecture().getGroupStudyLectureIteration();
        this.groupStudyLectureTitle = post.getGroupStudyLecture().getGroupStudyLectureTitle();
        this.groupStudyPostTitle = post.getGroupStudyPostTitle();
        this.groupStudyPostCreateAt = post.getGroupStudyPostCreateAt();
    }
}
