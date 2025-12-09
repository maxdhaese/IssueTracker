package org.max.issuetracker.web.dto;

import org.max.issuetracker.domain.model.User;

public class UserWebMapper {

    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }
}
