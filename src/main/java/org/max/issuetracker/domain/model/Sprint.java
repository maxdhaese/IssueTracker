package org.max.issuetracker.domain.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

public class Sprint {

    private final Long id;
    private final Long projectId;
    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String status;   // PLANNED / ACTIVE / COMPLETED
    private final String goal;
    private final Instant createdAt;

    public Sprint(Long id,
                  Long projectId,
                  String name,
                  LocalDate startDate,
                  LocalDate endDate,
                  String status,
                  String goal,
                  Instant createdAt) {

        this.id = id;
        this.projectId = Objects.requireNonNull(projectId);
        this.name = Objects.requireNonNull(name);
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = Objects.requireNonNull(status);
        this.goal = goal;
        this.createdAt = createdAt != null ? createdAt : Instant.now();
    }

    public Long getId() { return id; }
    public Long getProjectId() { return projectId; }
    public String getName() { return name; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getStatus() { return status; }
    public String getGoal() { return goal; }
    public Instant getCreatedAt() { return createdAt; }
}
