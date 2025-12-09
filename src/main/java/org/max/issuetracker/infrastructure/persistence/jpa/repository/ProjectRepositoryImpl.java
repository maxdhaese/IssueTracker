package org.max.issuetracker.infrastructure.persistence.jpa.repository;

import org.max.issuetracker.domain.model.Project;
import org.max.issuetracker.domain.repository.ProjectRepository;
import org.max.issuetracker.infrastructure.persistence.jpa.entity.ProjectEntity;
import org.max.issuetracker.infrastructure.persistence.jpa.mapper.ProjectMapper;

import java.util.List;
import java.util.Optional;

public class ProjectRepositoryImpl implements ProjectRepository {

    private final SpringDataProjectJpaRepository jpa;

    public ProjectRepositoryImpl(SpringDataProjectJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return jpa.findById(id).map(ProjectMapper::toDomain);
    }

    @Override
    public Optional<Project> findByProjectKey(String projectKey) {
        return jpa.findByProjectKey(projectKey).map(ProjectMapper::toDomain);
    }

    @Override
    public List<Project> findAllByOwnerId(Long ownerId) {
        return jpa.findAllByOwnerId(ownerId).stream()
                .map(ProjectMapper::toDomain)
                .toList();
    }

    @Override
    public List<Project> findAll() {
        return jpa.findAll().stream()
                .map(ProjectMapper::toDomain)
                .toList();
    }

    @Override
    public Project save(Project project) {
        ProjectEntity saved = jpa.save(ProjectMapper.toEntity(project));
        return ProjectMapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);

    }
}
