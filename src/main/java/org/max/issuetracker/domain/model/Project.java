package org.max.issuetracker.domain.model;

import java.time.Instant;
import java.util.Objects;

public class Project {
    private final Long id;
    private final String name;
    private final String projectKey;
    private final String description;
    private final Long ownerId; // user id
    private final Instant createdAt;
    private final Instant updatedAt;

    public Project(Long id, String name, String projectKey, String description, Long ownerId, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.projectKey = Objects.requireNonNull(projectKey);
        this.description = description;
        this.ownerId = ownerId;
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public String getDescription() {
        return description;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
