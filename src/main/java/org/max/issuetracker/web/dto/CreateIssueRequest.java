package org.max.issuetracker.web.dto;

import jakarta.validation.constraints.*;
import org.max.issuetracker.domain.enums.IssueStatus;
import org.max.issuetracker.domain.enums.IssueType;

public record CreateIssueRequest(
        @NotNull(message = "Project id is required")
        Long projectId,

        Long sprintId,

        @NotBlank(message = "Title is required")
        @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters")
        String title,

        @Size(max = 2000, message = "Description must be at most 2000 characters")
        String description,

        @NotBlank(message = "Issue type is required")
        IssueType type,

        @NotBlank(message = "Issue status is required")
        IssueStatus status,

        @NotBlank(message = "Issue priority is required")
        String priority,

        Long assigneeId,

        @NotNull(message = "Reporter id is required")
        Long reporterId,

//        @Min(value = 0, message = "Story points must be >= 0")
//        @Max(value = 100, message = "Story points must be <= 100")
        Integer storyPoints,

        @NotNull(message = "Board column id is required")
        Long boardColumnId
) {
}
