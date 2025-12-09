package org.max.issuetracker.domain.model;

import java.time.Instant;
import java.util.Objects;

public class User {

    private final Long id;
    private final String username;
    private final String email;
    private final String passwordHash;
    private final String role;
    private final Instant createdAt;
    private final Instant updatedAt;

    public User(Long id, String username, String email, String paswordHash, String role, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.username = Objects.requireNonNull(username);
        this.email = Objects.requireNonNull(email);
        this.passwordHash = Objects.requireNonNull(paswordHash);
        this.role = Objects.requireNonNull(role);
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getRole() {
        return role;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
