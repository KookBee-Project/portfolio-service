package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.Project;
import com.KookBee.portfolioservice.domain.entity.ProjectUser;
import com.KookBee.portfolioservice.domain.enums.EAllStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProjectUserRepository extends JpaRepository<ProjectUser, Long> {
    Long countByProject(Project el);

    Optional<ProjectUser> findByProjectAndUserId(Project project, Long userId);
    @Query("select pu from ProjectUser pu where pu.userId = :userId and pu.project.projectStatus != :deleted")
    List<ProjectUser> findByUserIdAndProjectStatusNot(@Param("userId") Long userId, @Param("deleted") EAllStatus deleted);

}
