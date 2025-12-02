package org.max.issuetracker.domain.repository;

import org.max.issuetracker.domain.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    Optional<Project> findById(Long id);

    Optional<Project> findByProjectKey(String projectKey);

    List<Project> findAllByOwnerId(Long ownerId);

    List<Project> findAll();

    Project save(Project project);

    void deleteById(Long id);
}
