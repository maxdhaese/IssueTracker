package org.max.issuetracker.domain.service;

import org.max.issuetracker.domain.enums.IssueStatus;
import org.max.issuetracker.domain.enums.IssueType;
import org.max.issuetracker.domain.enums.Priority;
import org.max.issuetracker.domain.model.Issue;
import org.max.issuetracker.domain.repository.IssueRepository;
import org.max.issuetracker.web.exception.BadRequestException;
import org.max.issuetracker.web.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public Issue createIssue(Long projectId,
                             Long sprintId,
                             String title,
                             String description,
                             IssueType type,
                             IssueStatus status,
                             Priority priority,
                             Long assigneeId,
                             Long reporterId,
                             Integer storyPoints,
                             Long boardColumnId) {

        Issue issue = new Issue(
                null,
                projectId,
                sprintId,
                title,
                description,
                type,
                status,
                priority,
                assigneeId,
                reporterId,
                storyPoints,
                boardColumnId,
                Instant.now(),
                Instant.now()
        );

        return issueRepository.save(issue);
    }

    public Optional<Issue> findById(Long id) {
        return issueRepository.findById(id);
    }

    public List<Issue> listByProject(Long projectId) {
        return issueRepository.findByProjectId(projectId);
    }

    public List<Issue> listBySprint(Long sprintId) {
        return issueRepository.findBySprintId(sprintId);
    }

    public List<Issue> listByAssignee(Long userId) {
        return issueRepository.findByAssigneeId(userId);
    }

    public Issue updateStatus(Long issueId, IssueStatus newStatus) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new NotFoundException("Issue not found: " + issueId));

        if (issue.getStatus() == newStatus) {
            return issue; // no-op
        }

        if (!issue.getStatus().canTransitionTo(newStatus)) {
            throw new BadRequestException(
                    "Cannot change issue status from " + issue.getStatus() + " to " + newStatus
            );
        }

        Issue updated = new Issue(
                issue.getId(),
                issue.getProjectId(),
                issue.getSprintId(),
                issue.getTitle(),
                issue.getDescription(),
                issue.getType(),
                newStatus,
                issue.getPriority(),
                issue.getAssigneeId(),
                issue.getReporterId(),
                issue.getStoryPoints(),
                issue.getBoardColumnId(),
                issue.getCreatedAt(),
                Instant.now()
        );

        return issueRepository.save(updated);
    }

    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }
}
