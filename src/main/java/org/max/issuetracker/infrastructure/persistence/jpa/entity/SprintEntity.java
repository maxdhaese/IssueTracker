package org.max.issuetracker.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "sprints")
public class SprintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id")
    private Long projectId;

    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private String status; // PLANNED / ACTIVE / COMPLETED

    private String goal;

    @Column(name = "created_at")
    private Instant createdAt;

    public SprintEntity() {}

    public SprintEntity(Long id,
                        Long projectId,
                        String name,
                        LocalDate startDate,
                        LocalDate endDate,
                        String status,
                        String goal,
                        Instant createdAt) {

        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.goal = goal;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public Long getProjectId() { return projectId; }
    public String getName() { return name; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getStatus() { return status; }
    public String getGoal() { return goal; }
    public Instant getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public void setName(String name) { this.name = name; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setStatus(String status) { this.status = status; }
    public void setGoal(String goal) { this.goal = goal; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}

