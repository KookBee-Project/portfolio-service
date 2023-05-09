package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.GroupStudyApply;
import com.KookBee.portfolioservice.domain.enums.EStudyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupStudyApplyRepository extends JpaRepository<GroupStudyApply, Long> {
    @Query("select gsa, gs from GroupStudyApply gsa join gsa.groupStudy gs " +
            "where gs.groupStudyLeader = :userId and gs.groupStudyStatus = :status")
    List<GroupStudyApply> findAllByLeaderId(@Param("userId") Long userId,
                                            @Param("status") EStudyStatus status);
}
