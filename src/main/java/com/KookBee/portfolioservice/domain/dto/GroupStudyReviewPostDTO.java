package com.KookBee.portfolioservice.domain.dto;

import com.KookBee.portfolioservice.domain.entity.GroupStudyPost;
import com.KookBee.portfolioservice.domain.request.PortfolioStudyReviewRegisterRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class GroupStudyReviewPostDTO {
    private GroupStudyPost groupStudyPost;
    private Long groupStudyReviewWriterId;
    private String groupStudyReviewWriterName;
    private String groupStudyReviewContents;
    private LocalDateTime groupStudyReviewCreateAt;

    public GroupStudyReviewPostDTO(PortfolioStudyReviewRegisterRequest request,
                                   GroupStudyPost post, Long userId, String userName) {
        this.groupStudyPost = post;
        this.groupStudyReviewWriterId = userId;
        this.groupStudyReviewWriterName = userName;
        this.groupStudyReviewContents = request.getGroupStudyReviewContents();
        this.groupStudyReviewCreateAt = LocalDateTime.now();
    }
}
