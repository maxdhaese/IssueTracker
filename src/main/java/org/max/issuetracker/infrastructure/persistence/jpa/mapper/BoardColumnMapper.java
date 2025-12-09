package org.max.issuetracker.infrastructure.persistence.jpa.mapper;

import org.max.issuetracker.domain.model.BoardColumn;
import org.max.issuetracker.infrastructure.persistence.jpa.entity.BoardColumnEntity;

public class BoardColumnMapper {

    public static BoardColumn toDomain(BoardColumnEntity e) {
        return new BoardColumn(
                e.getId(),
                e.getProjectId(),
                e.getName(),
                e.getPosition()
        );
    }

    public static BoardColumnEntity toEntity(BoardColumn c) {
        return new BoardColumnEntity(
                c.getId(),
                c.getProjectId(),
                c.getName(),
                c.getPosition()
        );
    }
}
