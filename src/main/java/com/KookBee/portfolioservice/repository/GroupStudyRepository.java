package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.GroupStudy;
import com.KookBee.portfolioservice.domain.enums.EStudyStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupStudyRepository extends JpaRepository<GroupStudy,Long> {
    @Query("select gs from GroupStudy gs " +
            "where gs.groupStudyStatus = :eStudyStatus " +
            "order by gs.groupStudyOpenDate desc")
    Page<GroupStudy> findProceedingGroupStudies(@Param("eStudyStatus") EStudyStatus eStudyStatus, Pageable pageable);

    @Query("select count(gs) from GroupStudy gs where gs.groupStudyStatus = :eStudyStatus")
    Integer groupStudyCounts(@Param("eStudyStatus") EStudyStatus eStudyStatus);

    @Query("select count(gs) from GroupStudy gs join gs.groupStudyMembers gsm " +
            "where gs.groupStudyStatus = :eStudyStatus and " +
            "gsm.userId = :userId")
    Integer myGroupStudyCounts(@Param("eStudyStatus") EStudyStatus eStudyStatus,
                             @Param("userId") Long userId);

    @Query("select gs from GroupStudy gs join gs.groupStudyMembers gsm " +
            "where gsm.userId = :userId and gs.groupStudyStatus = :eStudyStatus " +
            "order by gs.groupStudyOpenDate desc")
    Page<GroupStudy> findMyGroupStudies(@Param("eStudyStatus") EStudyStatus eStudyStatus,
                                        @Param("userId") Long userId,
                                        Pageable pageable);

    List<GroupStudy> findTop5ByGroupStudyStatusOrderByIdDesc(EStudyStatus proceeding);
}
