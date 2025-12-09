package org.max.issuetracker.web.dto;

public record CreateUserRequest (
        String username,
        String email,
        String password,
        String role
) {}




