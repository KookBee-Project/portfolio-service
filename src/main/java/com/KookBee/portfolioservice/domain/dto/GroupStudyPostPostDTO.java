package com.KookBee.portfolioservice.domain.dto;

import com.KookBee.portfolioservice.domain.entity.GroupStudyLecture;
import com.KookBee.portfolioservice.domain.request.PortfolioStudyPostRegisterRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
public class GroupStudyPostPostDTO {
    private GroupStudyLecture groupStudyLecture;
    private Long groupStudyPostWriter;
    private String groupStudyPostTitle;
    private String groupStudyPostContents;
    private LocalDate groupStudyPostCreateAt;

    public GroupStudyPostPostDTO(PortfolioStudyPostRegisterRequest request, Long userId, GroupStudyLecture groupStudyLecture) {
        this.groupStudyLecture = groupStudyLecture;
        this.groupStudyPostWriter = userId;
        this.groupStudyPostTitle = request.getGroupStudyPostTitle();
        this.groupStudyPostContents = request.getGroupStudyPostContents();
        this.groupStudyPostCreateAt = LocalDate.now();
    }
}
