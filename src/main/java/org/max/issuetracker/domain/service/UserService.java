package org.max.issuetracker.domain.service;

import org.max.issuetracker.domain.model.User;
import org.max.issuetracker.domain.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String email, String passwordHash, String role) {
        userRepository.findByUsername(username).ifPresent(u -> {
            throw new IllegalArgumentException("Username already exists: " + username);
        });

        User user = new User(null, username, email, passwordHash, role, null, null);
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
