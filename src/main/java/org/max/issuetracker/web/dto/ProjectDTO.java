package org.max.issuetracker.web.dto;

public record ProjectDTO(
        Long id,
        String name,
        String projectKey,
        String description,
        Long ownerId
) {
}
