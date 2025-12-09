package org.max.issuetracker.infrastructure.persistence.jpa.repository;

import org.max.issuetracker.infrastructure.persistence.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataUserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity>findByUsername(String username);

}
