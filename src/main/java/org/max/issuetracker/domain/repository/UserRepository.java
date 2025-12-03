package org.max.issuetracker.domain.repository;

import org.max.issuetracker.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    List<User> findAll();

    User save(User user);

    void deleteById(Long id);
}
