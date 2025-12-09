package org.max.issuetracker.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "issues")
public class IssueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign keys stored as IDs (DDD-friendly & simple)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "sprint_id")
    private Long sprintId;

    private String title;

    private String description;

    private String type;      // BUG / FEATURE / TASK

    private String status;    // TO_DO / ...

    private String priority;  // LOW / MEDIUM / HIGH / CRITICAL

    @Column(name = "assignee_id")
    private Long assigneeId;

    @Column(name = "reporter_id")
    private Long reporterId;

    @Column(name = "story_points")
    private Integer storyPoints;

    @Column(name = "board_column_id")
    private Long boardColumnId;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;


    public IssueEntity() {}

    public IssueEntity(Long id,
                       Long projectId,
                       Long sprintId,
                       String title,
                       String description,
                       String type,
                       String status,
                       String priority,
                       Long assigneeId,
                       Long reporterId,
                       Integer storyPoints,
                       Long boardColumnId,
                       Instant createdAt,
                       Instant updatedAt) {

        this.id = id;
        this.projectId = projectId;
        this.sprintId = sprintId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = status;
        this.priority = priority;
        this.assigneeId = assigneeId;
        this.reporterId = reporterId;
        this.storyPoints = storyPoints;
        this.boardColumnId = boardColumnId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters
    public Long getId() { return id; }
    public Long getProjectId() { return projectId; }
    public Long getSprintId() { return sprintId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public String getPriority() { return priority; }
    public Long getAssigneeId() { return assigneeId; }
    public Long getReporterId() { return reporterId; }
    public Integer getStoryPoints() { return storyPoints; }
    public Long getBoardColumnId() { return boardColumnId; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }

    // Setters (used by JPA)
    public void setId(Long id) { this.id = id; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public void setSprintId(Long sprintId) { this.sprintId = sprintId; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setType(String type) { this.type = type; }
    public void setStatus(String status) { this.status = status; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setAssigneeId(Long assigneeId) { this.assigneeId = assigneeId; }
    public void setReporterId(Long reporterId) { this.reporterId = reporterId; }
    public void setStoryPoints(Integer storyPoints) { this.storyPoints = storyPoints; }
    public void setBoardColumnId(Long boardColumnId) { this.boardColumnId = boardColumnId; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

}
