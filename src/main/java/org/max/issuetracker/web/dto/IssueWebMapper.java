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
                i.getType().name(),
                i.getStatus().name(),
                i.getPriority().name(),
                i.getAssigneeId(),
                i.getReporterId(),
                i.getStoryPoints(),
                i.getBoardColumnId()
        );
    }
}
