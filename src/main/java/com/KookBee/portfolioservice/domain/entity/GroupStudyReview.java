package com.KookBee.portfolioservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupStudyReview {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_study_review_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_study_post_id")
    private GroupStudyPost groupStudyPost;
    private Long groupStudyReviewWriterId;
    private String groupStudyReviewWriterName;
    private String groupStudyReviewContents;
    private LocalDateTime groupStudyReviewCreateAt;
}
