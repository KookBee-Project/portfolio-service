package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.Project;
import com.KookBee.portfolioservice.domain.response.projectResponse.ProjectListResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findAllByBootcampId(Long id);
    Optional<Project> findByProjectCode(String projectCode);
}
