package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.Project;
import com.KookBee.portfolioservice.domain.enums.EAllStatus;
import com.KookBee.portfolioservice.domain.response.projectResponse.ProjectListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findAllByBootcampId(Long id);
    List<Project> findAllByBootcampIdAndProjectStatusNot(Long id , EAllStatus status);
    Optional<Project> findByProjectCode(String projectCode);

    List<Project> findTop5ByProjectStatusOrderByIdDesc(EAllStatus finished);

    List<Project> findByBootcampIdAndProjectStatus(Long bootcampId, EAllStatus finished);
}
