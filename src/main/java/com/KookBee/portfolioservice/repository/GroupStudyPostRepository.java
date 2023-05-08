package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.GroupStudyPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupStudyPostRepository extends JpaRepository<GroupStudyPost, Long> {
    @Query("select count(gsp) from GroupStudyPost gsp where gsp.groupStudyLecture.id = :lectureId")
    Integer postCounts(@Param("lectureId") Long lectureId);
}
