package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.GroupStudyApply;
import com.KookBee.portfolioservice.domain.enums.EStudyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupStudyApplyRepository extends JpaRepository<GroupStudyApply, Long> {
    @Query("select gsa, gs from GroupStudyApply gsa join gsa.groupStudy gs " +
            "where gs.groupStudyLeader = :userId and gs.groupStudyStatus = :status " +
            "order by case gsa.eStudyApplyStatus " +
            "when 'PENDING' then 1 " +
            "when 'APPROVAL' then 2 " +
            "when 'REJECT' then 3 " +
            "end, gsa.id desc")
    List<GroupStudyApply> findAllByLeaderId(@Param("userId") Long userId,
                                            @Param("status") EStudyStatus status);

    @Query("select gsa from GroupStudyApply gsa where gsa.groupStudyApplicantId = :userId " +
            "order by case gsa.eStudyApplyStatus " +
            "when 'PENDING' then 1 " +
            "when 'APPROVAL' then 2 " +
            "when 'REJECT' then 3 " +
            "end, gsa.id desc")
    List<GroupStudyApply> findByApplicantId(@Param("userId") Long userId);
}
