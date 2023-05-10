package com.KookBee.portfolioservice.domain.response;

import com.KookBee.portfolioservice.domain.entity.GroupStudyReview;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PortfolioStudyReviewResponse {
    private String groupStudyReviewWriterName;
    private String groupStudyReviewContents;

    public PortfolioStudyReviewResponse(GroupStudyReview groupStudyReview) {
        this.groupStudyReviewWriterName = groupStudyReview.getGroupStudyReviewWriterName();
        this.groupStudyReviewContents = groupStudyReview.getGroupStudyReviewContents();
    }
}
