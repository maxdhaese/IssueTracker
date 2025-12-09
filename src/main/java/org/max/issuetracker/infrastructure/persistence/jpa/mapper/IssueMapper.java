package org.max.issuetracker.infrastructure.persistence.jpa.mapper;

import org.max.issuetracker.domain.model.Issue;
import org.max.issuetracker.infrastructure.persistence.jpa.entity.IssueEntity;

public class IssueMapper {

    public static Issue toDomain(IssueEntity e) {
        return new Issue(
                e.getId(),
                e.getProjectId(),
                e.getSprintId(),
                e.getTitle(),
                e.getDescription(),
                e.getType(),
                e.getStatus(),
                e.getPriority(),
                e.getAssigneeId(),
                e.getReporterId(),
                e.getStoryPoints(),
                e.getBoardColumnId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }

    public static IssueEntity toEntity(Issue issue) {
        return new IssueEntity(
                issue.getId(),
                issue.getProjectId(),
                issue.getSprintId(),
                issue.getTitle(),
                issue.getDescription(),
                issue.getType(),
                issue.getStatus(),
                issue.getPriority(),
                issue.getAssigneeId(),
                issue.getReporterId(),
                issue.getStoryPoints(),
                issue.getBoardColumnId(),
                issue.getCreatedAt(),
                issue.getUpdatedAt()
        );
    }
}
