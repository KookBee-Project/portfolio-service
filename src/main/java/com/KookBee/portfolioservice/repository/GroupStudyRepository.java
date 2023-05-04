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
    List<GroupStudy> findProceedingGroupStudies(@Param("eStudyStatus") EStudyStatus eStudyStatus);
}
