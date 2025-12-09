package org.max.issuetracker.infrastructure.persistence.jpa.mapper;

import org.max.issuetracker.domain.model.User;
import org.max.issuetracker.infrastructure.persistence.jpa.entity.UserEntity;

public class UserMapper {

    public static User toDomain(UserEntity e) {
        return new User(
                e.getId(),
                e.getUsername(),
                e.getEmail(),
                e.getPasswordHash(),
                e.getRole(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }

    public static UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPasswordHash(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
