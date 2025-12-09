package org.max.issuetracker.infrastructure.persistence.jpa.repository;

import org.max.issuetracker.domain.model.Issue;
import org.max.issuetracker.domain.repository.IssueRepository;
import org.max.issuetracker.infrastructure.persistence.jpa.entity.IssueEntity;
import org.max.issuetracker.infrastructure.persistence.jpa.mapper.IssueMapper;

import java.util.List;
import java.util.Optional;

public class IssueRepositoryImpl implements IssueRepository {

    private final SpringDataIssueJpaRepository jpa;

    public IssueRepositoryImpl(SpringDataIssueJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<Issue> findById(Long id) {
        return jpa.findById(id).map(IssueMapper::toDomain);
    }

    @Override
    public List<Issue> findByProjectId(Long projectId) {
        return jpa.findByProjectId(projectId).stream()
                .map(IssueMapper::toDomain)
                .toList();
    }

    @Override
    public List<Issue> findBySprintId(Long sprintId) {
        return jpa.findBySprintId(sprintId).stream()
                .map(IssueMapper::toDomain)
                .toList();
    }

    @Override
    public List<Issue> findByAssigneeId(Long userId) {
        return jpa.findByAssigneeId(userId).stream()
                .map(IssueMapper::toDomain)
                .toList();
    }

    @Override
    public Issue save(Issue issue) {
        IssueEntity saved = jpa.save(IssueMapper.toEntity(issue));
        return IssueMapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);

    }
}
