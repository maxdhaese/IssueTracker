package org.max.issuetracker.infrastructure.persistence.jpa.repository;

import org.max.issuetracker.domain.model.Sprint;
import org.max.issuetracker.domain.repository.SprintRepository;
import org.max.issuetracker.infrastructure.persistence.jpa.entity.SprintEntity;
import org.max.issuetracker.infrastructure.persistence.jpa.mapper.SprintMapper;

import java.util.List;
import java.util.Optional;

public class SprintRepositoryImpl implements SprintRepository {

    private final SpringDataSprintJpaRepository jpa;

    public SprintRepositoryImpl(SpringDataSprintJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<Sprint> findById(Long id) {
        return jpa.findById(id).map(SprintMapper::toDomain);
    }

    @Override
    public List<Sprint> findByProjectId(Long projectId) {
        return jpa.findByProjectId(projectId).stream()
                .map(SprintMapper::toDomain)
                .toList();
    }

    @Override
    public List<Sprint> findAll() {
        return jpa.findAll().stream()
                .map(SprintMapper::toDomain)
                .toList();
    }

    @Override
    public Sprint save(Sprint sprint) {
        SprintEntity saved = jpa.save(SprintMapper.toEntity(sprint));
        return SprintMapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);

    }
}
