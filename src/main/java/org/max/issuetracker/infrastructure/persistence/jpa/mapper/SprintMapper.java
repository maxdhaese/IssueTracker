package org.max.issuetracker.infrastructure.persistence.jpa.mapper;

import org.max.issuetracker.infrastructure.persistence.jpa.entity.SprintEntity;
import org.max.issuetracker.domain.model.Sprint;
import org.springframework.stereotype.Component;

@Component
public class SprintMapper {

    public static Sprint toDomain(SprintEntity e) {
        return new Sprint(
                e.getId(),
                e.getProjectId(),
                e.getName(),
                e.getStartDate(),
                e.getEndDate(),
                e.getStatus(),
                e.getGoal(),
                e.getCreatedAt()
        );
    }

    public static SprintEntity toEntity(Sprint s) {
        return new SprintEntity(
                s.getId(),
                s.getProjectId(),
                s.getName(),
                s.getStartDate(),
                s.getEndDate(),
                s.getStatus(),
                s.getGoal(),
                s.getCreatedAt()
        );
    }
}

