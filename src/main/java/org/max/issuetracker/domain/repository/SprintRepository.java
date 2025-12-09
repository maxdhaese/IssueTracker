package org.max.issuetracker.domain.repository;

import org.max.issuetracker.domain.model.Sprint;

import java.util.List;
import java.util.Optional;

public interface SprintRepository {

    Optional<Sprint> findById(Long id);

    List<Sprint> findByProjectId(Long projectId);

    List<Sprint> findAll();

    Sprint save(Sprint sprint);

    void deleteById(Long id);
}
