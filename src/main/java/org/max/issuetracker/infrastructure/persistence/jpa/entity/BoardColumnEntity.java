package org.max.issuetracker.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "board_columns")
public class BoardColumnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id")
    private Long projectId;

    private String name;

    private int position;

    public BoardColumnEntity() {}

    public BoardColumnEntity(Long id,
                             Long projectId,
                             String name,
                             int position) {

        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.position = position;
    }

    public Long getId() { return id; }
    public Long getProjectId() { return projectId; }
    public String getName() { return name; }
    public int getPosition() { return position; }

    public void setId(Long id) { this.id = id; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public void setName(String name) { this.name = name; }
    public void setPosition(int position) { this.position = position; }
}
