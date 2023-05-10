package com.KookBee.portfolioservice.domain.dto;

import com.KookBee.portfolioservice.domain.entity.GroupStudy;
import com.KookBee.portfolioservice.domain.entity.GroupStudyApply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class GroupStudyMemberPostDTO {
    private GroupStudy groupStudy;
    private Long userId;

    public GroupStudyMemberPostDTO(GroupStudy groupStudy, Long userId) {
        this.groupStudy = groupStudy;
        this.userId = userId;
    }

    public GroupStudyMemberPostDTO(GroupStudyApply apply) {
        this.groupStudy = apply.getGroupStudy();
        this.userId = apply.getGroupStudyApplicantId();
    }
}
