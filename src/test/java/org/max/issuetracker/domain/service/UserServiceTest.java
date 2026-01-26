package org.max.issuetracker.domain.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.max.issuetracker.domain.model.User;
import org.max.issuetracker.domain.repository.UserRepository;
import org.max.issuetracker.web.exception.BadRequestException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserService userService;

    @Test
    void registerUser_hashesPassword_andSavesUser() {
        // given
        when(userRepository.findByUsername("max"))
                .thenReturn(Optional.empty());
        when(userRepository.findByEmail("max@test.com"))
                .thenReturn(Optional.empty());
        when(passwordEncoder.encode("password123"))
                .thenReturn("hashed-password");

        when(userRepository.save(any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // when
        User user = userService.registerUser(
                "max",
                "max@test.com",
                "password123"
        );

        // then
        assertNotNull(user);
        assertEquals("max", user.getUsername());
        assertEquals("max@test.com", user.getEmail());
        assertEquals("hashed-password", user.getPasswordHash());
        assertEquals("USER", user.getRole());

        verify(passwordEncoder).encode("password123");
        verify(userRepository).save(any(User.class));
    }

    @Test
    void registerUser_throwsException_whenUsernameExists() {
        // given
        when(userRepository.findByUsername("max"))
                .thenReturn(Optional.of(mock(User.class)));

        // when / then
        BadRequestException ex = assertThrows(
                BadRequestException.class,
                () -> userService.registerUser("max", "max@test.com", "password")
        );

        assertTrue(ex.getMessage().toLowerCase().contains("username"));
        verify(userRepository, never()).save(any());
    }

    @Test
    void registerUser_throwsException_whenEmailExists() {
        // given
        when(userRepository.findByUsername("max"))
                .thenReturn(Optional.empty());
        when(userRepository.findByEmail("max@test.com"))
                .thenReturn(Optional.of(mock(User.class)));

        // when / then
        BadRequestException ex = assertThrows(
                BadRequestException.class,
                () -> userService.registerUser("max", "max@test.com", "password")
        );

        assertTrue(ex.getMessage().contains("Email"));
        verify(userRepository, never()).save(any());
    }
}
