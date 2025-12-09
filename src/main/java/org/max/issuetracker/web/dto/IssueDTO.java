package org.max.issuetracker.web.dto;

public record IssueDTO(
        Long id,
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
        Long boardColumnId
) {
}
