package org.max.issuetracker.infrastructure.persistence.jpa.repository;

import org.max.issuetracker.infrastructure.persistence.jpa.entity.BoardColumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataBoardColumnJpaRepository extends JpaRepository<BoardColumnEntity, Long> {

    List<BoardColumnEntity> findByProjectId(Long projectId);
}
