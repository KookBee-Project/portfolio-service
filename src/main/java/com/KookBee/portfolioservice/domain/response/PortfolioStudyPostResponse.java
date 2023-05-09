package com.KookBee.portfolioservice.domain.response;

import com.KookBee.portfolioservice.domain.entity.GroupStudyPost;
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

    public PortfolioStudyPostResponse(GroupStudyPost groupStudyPost) {
        this.groupStudyPostId = groupStudyPost.getId();
        this.groupStudyPostWriterName = null;
        this.groupStudyPostTitle = groupStudyPost.getGroupStudyPostTitle();
        this.groupStudyPostContents = groupStudyPost.getGroupStudyPostContents();
    }
}
