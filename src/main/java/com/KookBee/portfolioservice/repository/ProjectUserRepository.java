package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.Project;
import com.KookBee.portfolioservice.domain.entity.ProjectUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectUserRepository extends JpaRepository<ProjectUser, Long> {
    Long countByProject(Project el);

    List<ProjectUser> findAllByProject(Project project);
}
