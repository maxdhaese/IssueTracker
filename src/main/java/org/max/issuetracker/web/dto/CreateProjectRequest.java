package org.max.issuetracker.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateProjectRequest(
        @NotBlank(message = "Project name is required")
        @Size(min = 3, max = 100, message = "Project name must be between 3 and 100 characters")
        String name,

        @NotBlank(message = "Project key is required")
        @Size(min = 2, max = 10, message = "Project key must be between 2 and 10 characters")
        String projectKey,

        @Size(max = 500, message = "Description must be at most 500 characters")
        String description,

        @NotNull(message = "Owner id is required")
        Long ownerId
) {
}
