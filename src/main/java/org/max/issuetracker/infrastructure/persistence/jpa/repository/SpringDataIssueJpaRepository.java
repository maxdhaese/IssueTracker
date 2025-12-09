package org.max.issuetracker.infrastructure.persistence.jpa.repository;

import org.max.issuetracker.infrastructure.persistence.jpa.entity.IssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataIssueJpaRepository extends JpaRepository<IssueEntity, Long> {

    List<IssueEntity> findByProjectId(Long projectId);

    List<IssueEntity> findBySprintId(Long sprintId);

    List<IssueEntity> findByAssigneeId(Long assigneeId);
}
