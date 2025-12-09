package org.max.issuetracker.infrastructure.persistence.jpa.repository;

import org.max.issuetracker.infrastructure.persistence.jpa.entity.SprintEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataSprintJpaRepository extends JpaRepository<SprintEntity, Long> {

    List<SprintEntity> findByProjectId(Long projectId);
}
