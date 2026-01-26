package org.max.issuetracker.domain.service;

import org.max.issuetracker.domain.model.User;
import org.max.issuetracker.domain.repository.UserRepository;
import org.max.issuetracker.web.exception.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String username, String email, String passwordHash, String role) {
        userRepository.findByUsername(username).ifPresent(u -> {
            throw new BadRequestException("Username already exists: " + username);
        });

        User user = new User(
                null,
                username,
                email,
                passwordHash,
                role,
                Instant.now(),
                Instant.now()
        );
        return userRepository.save(user);
    }

    public User registerUser(String username, String email, String rawPassword) {

        userRepository.findByUsername(username)
                .ifPresent(u -> {
                    throw new BadRequestException("Username already exists: " + username);
                });

        userRepository.findByEmail(email)
                .ifPresent(u -> {
                    throw new BadRequestException("Email already exists: " + email);
                });

        String passwordHash = passwordEncoder.encode(rawPassword);

        User user = new User(
                null,
                username,
                email,
                passwordHash,
                "USER",
                Instant.now(),
                Instant.now()
        );

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
