package org.max.issuetracker.infrastructure.persistence.jpa.repository;

import org.max.issuetracker.domain.model.User;
import org.max.issuetracker.domain.repository.UserRepository;
import org.max.issuetracker.infrastructure.persistence.jpa.entity.UserEntity;
import org.max.issuetracker.infrastructure.persistence.jpa.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserJpaRepository jpa;

    public UserRepositoryImpl(SpringDataUserJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpa.findById(id).map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpa.findByUsername(username).map(UserMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpa.findAll().stream()
                .map(UserMapper::toDomain)
                .toList();
    }

    @Override
    public User save(User user) {
        UserEntity saved = jpa.save(UserMapper.toEntity(user));
        return UserMapper.toDomain(saved);

    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
