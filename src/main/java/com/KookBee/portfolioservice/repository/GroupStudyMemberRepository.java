package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.GroupStudyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupStudyMemberRepository extends JpaRepository<GroupStudyMember,Long> {
    @Query("select count(gsm) from GroupStudyMember gsm join gsm.groupStudy gs " +
            "where gs.id = :groupStudyId")
    Integer memberCounts(@Param("groupStudyId") Long groupStudyId);

    // 스터디의 이름리스트
    @Query("select gsm.userId from GroupStudyMember gsm where gsm.groupStudy.id = :groupStudyId")
    List<Long> groupStudyMemberIdList(@Param("groupStudyId") Long groupStudyId);
}
