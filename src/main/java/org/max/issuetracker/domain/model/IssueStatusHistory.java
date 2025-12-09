package org.max.issuetracker.domain.model;

import java.time.Instant;
import java.util.Objects;

public class IssueStatusHistory {
    private final Long id;
    private final Long issueId;
    private final String oldStatus;
    private final String newStatus;
    private final Long changedById;
    private final Instant changedAt;

    public IssueStatusHistory(Long id,
                              Long issueId,
                              String oldStatus,
                              String newStatus,
                              Long changedById,
                              Instant changedAt) {

        this.id = id;
        this.issueId = Objects.requireNonNull(issueId);
        this.oldStatus = Objects.requireNonNull(oldStatus);
        this.newStatus = Objects.requireNonNull(newStatus);
        this.changedById = changedById; // optional (system changes)
        this.changedAt = changedAt != null ? changedAt : Instant.now();
    }

    public Long getId() { return id; }
    public Long getIssueId() { return issueId; }
    public String getOldStatus() { return oldStatus; }
    public String getNewStatus() { return newStatus; }
    public Long getChangedById() { return changedById; }
    public Instant getChangedAt() { return changedAt; }
}
