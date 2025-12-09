package org.max.issuetracker.infrastructure.persistence.jpa.repository;

import org.max.issuetracker.infrastructure.persistence.jpa.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataProjectJpaRepository extends JpaRepository<ProjectEntity, Long> {

    Optional<ProjectEntity> findByProjectKey(String key);

    List<ProjectEntity> findAllByOwnerId(Long ownerId);
}
