package org.max.issuetracker.infrastructure.persistence.jpa.mapper;

import org.max.issuetracker.domain.model.Project;
import org.max.issuetracker.infrastructure.persistence.jpa.entity.ProjectEntity;

public class ProjectMapper {

    public static Project toDomain(ProjectEntity e) {
        return new Project(
                e.getId(),
                e.getName(),
                e.getProjectKey(),
                e.getDescription(),
                e.getOwnerId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }

    public static ProjectEntity toEntity(Project p) {
        return new ProjectEntity(
                p.getId(),
                p.getName(),
                p.getProjectKey(),
                p.getDescription(),
                p.getOwnerId(),
                p.getCreatedAt(),
                p.getUpdatedAt()
        );
    }
}
