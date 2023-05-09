package com.KookBee.portfolioservice.domain.response;

import com.KookBee.portfolioservice.domain.entity.GroupStudyPost;
import com.KookBee.portfolioservice.domain.entity.GroupStudyReview;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PortfolioStudyPostResponse {
    private Long groupStudyPostId;
    private String groupStudyPostWriterName;
    private String groupStudyPostTitle;
    private String groupStudyPostContents;
    private List<PortfolioStudyReviewResponse> reviewList;

    public PortfolioStudyPostResponse(GroupStudyPost groupStudyPost, String userName, List<PortfolioStudyReviewResponse> groupStudyReviewList) {
        this.groupStudyPostId = groupStudyPost.getId();
        this.groupStudyPostWriterName = userName;
        this.groupStudyPostTitle = groupStudyPost.getGroupStudyPostTitle();
        this.groupStudyPostContents = groupStudyPost.getGroupStudyPostContents();
        this.reviewList = groupStudyReviewList;
    }
}
