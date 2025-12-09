package org.max.issuetracker.domain.model;

import java.util.Objects;

public class BoardColumn {

    private final Long id;
    private final Long projectId;
    private final String name;
    private final int position;

    public BoardColumn(Long id,
                       Long projectId,
                       String name,
                       int position) {

        this.id = id;
        this.projectId = Objects.requireNonNull(projectId);
        this.name = Objects.requireNonNull(name);
        this.position = position;
    }

    public Long getId() { return id; }
    public Long getProjectId() { return projectId; }
    public String getName() { return name; }
    public int getPosition() { return position; }
}
