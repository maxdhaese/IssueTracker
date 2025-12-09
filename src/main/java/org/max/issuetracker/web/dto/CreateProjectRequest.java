package org.max.issuetracker.web.dto;

public record CreateProjectRequest(
        String name,
        String projectKey,
        String description,
        Long ownerId
) {
}
