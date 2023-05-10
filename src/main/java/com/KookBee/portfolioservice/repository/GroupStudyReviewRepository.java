package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.GroupStudyReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupStudyReviewRepository extends JpaRepository<GroupStudyReview, Long> {
    @Query("select gsr,gsp from GroupStudyReview gsr join gsr.groupStudyPost gsp " +
            "where gsp.id = :postId")
    List<GroupStudyReview> findAllByPostId(@Param("postId") Long postId);
}
