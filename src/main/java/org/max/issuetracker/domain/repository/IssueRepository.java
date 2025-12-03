package org.max.issuetracker.domain.repository;

import org.max.issuetracker.domain.model.Issue;

import java.util.List;
import java.util.Optional;

public interface IssueRepository {

    Optional<Issue> findById(Long id);

    List<Issue> findByProjectId(Long projectId);

    List<Issue> findBySprintId(Long sprintId);

    List<Issue> findByAssigneeId(Long userId);

    Issue save(Issue issue);

    void deleteById(Long id);
}
