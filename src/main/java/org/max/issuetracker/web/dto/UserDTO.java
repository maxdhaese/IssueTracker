package org.max.issuetracker.web.dto;

public record UserDTO (
    Long id,
    String username,
    String email,
    String role
    ) {}
