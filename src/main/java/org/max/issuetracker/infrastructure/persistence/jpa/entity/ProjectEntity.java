package org.max.issuetracker.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "projects")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "project_key")
    private String projectKey;

    private String description;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    public ProjectEntity() {}

    public ProjectEntity(Long id,
                         String name,
                         String projectKey,
                         String description,
                         Long ownerId,
                         Instant createdAt,
                         Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.projectKey = projectKey;
        this.description = description;
        this.ownerId = ownerId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getProjectKey() { return projectKey; }
    public String getDescription() { return description; }
    public Long getOwnerId() { return ownerId; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setProjectKey(String projectKey) { this.projectKey = projectKey; }
    public void setDescription(String description) { this.description = description; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
