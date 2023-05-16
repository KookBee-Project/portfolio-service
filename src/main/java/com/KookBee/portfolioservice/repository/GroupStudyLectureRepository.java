package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.GroupStudyLecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupStudyLectureRepository extends JpaRepository<GroupStudyLecture, Long> {
    List<GroupStudyLecture> findByGroupStudyId(Long groupStudyId);
}
