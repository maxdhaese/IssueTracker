package org.max.issuetracker.domain.model;

import org.max.issuetracker.domain.enums.IssueStatus;
import org.max.issuetracker.domain.enums.IssueType;
import org.max.issuetracker.domain.enums.Priority;

import java.time.Instant;
import java.util.Objects;

public class Issue {
    private final Long id;
    private final Long projectId;
    private final Long sprintId;       // can be null
    private final String title;
    private final String description;
    private final IssueType type;         // BUG / FEATURE / TASK
    private final IssueStatus status;       // TO_DO / IN_PROGRESS / DONE
    private final Priority priority;     // LOW / MEDIUM / HIGH / CRITICAL
    private final Long assigneeId;     // can be null
    private final Long reporterId;     // required
    private final Integer storyPoints; // can be null
    private final Long boardColumnId;  // required
    private final Instant createdAt;
    private final Instant updatedAt;

    public Issue(Long id, Long projectId, Long sprintId, String title, String description, IssueType type, IssueStatus status, Priority priority, Long assigneeId, Long reporterId, Integer storyPoints, Long boardColumnId, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.projectId = Objects.requireNonNull(projectId);
        this.sprintId = sprintId;
        this.title = Objects.requireNonNull(title);
        this.description = description;
        this.type = Objects.requireNonNull(type);
        this.status = Objects.requireNonNull(status);
        this.priority = Objects.requireNonNull(priority);
        this.assigneeId = assigneeId;
        this.reporterId = Objects.requireNonNull(reporterId);
        this.storyPoints = storyPoints;
        this.boardColumnId = Objects.requireNonNull(boardColumnId);
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public Long getId() {
        return id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getSprintId() {
        return sprintId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public IssueType getType() {
        return type;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public Long getAssigneeId() {
        return assigneeId;
    }

    public Long getReporterId() {
        return reporterId;
    }

    public Integer getStoryPoints() {
        return storyPoints;
    }

    public Long getBoardColumnId() {
        return boardColumnId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
