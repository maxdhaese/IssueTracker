package org.max.issuetracker.web.dto;

public record TokenResponse(
        String token,
        String tokenType
) {}