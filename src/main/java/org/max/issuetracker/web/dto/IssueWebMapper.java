package org.max.issuetracker.web.dto;

import org.max.issuetracker.domain.model.Issue;

public class IssueWebMapper {

    public static IssueDTO toDTO(Issue i){
        return new IssueDTO(
                i.getId(),
                i.getProjectId(),
                i.getSprintId(),
                i.getTitle(),
                i.getDescription(),
                i.getType(),
                i.getStatus(),
                i.getPriority(),
                i.getAssigneeId(),
                i.getReporterId(),
                i.getStoryPoints(),
                i.getBoardColumnId()
        );
    }
}
