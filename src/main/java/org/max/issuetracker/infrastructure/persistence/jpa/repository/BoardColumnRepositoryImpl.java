package org.max.issuetracker.infrastructure.persistence.jpa.repository;

import org.max.issuetracker.domain.model.BoardColumn;
import org.max.issuetracker.domain.repository.BoardColumnRepository;
import org.max.issuetracker.infrastructure.persistence.jpa.entity.BoardColumnEntity;
import org.max.issuetracker.infrastructure.persistence.jpa.mapper.BoardColumnMapper;

import java.util.List;
import java.util.Optional;

public class BoardColumnRepositoryImpl implements BoardColumnRepository {

    private final SpringDataBoardColumnJpaRepository jpa;

    public BoardColumnRepositoryImpl(SpringDataBoardColumnJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<BoardColumn> findById(Long id) {
        return jpa.findById(id).map(BoardColumnMapper::toDomain);
    }

    @Override
    public List<BoardColumn> findByProjectId(Long projectId) {
        return jpa.findByProjectId(projectId).stream()
                .map(BoardColumnMapper::toDomain)
                .toList();
    }

    @Override
    public List<BoardColumn> findAll() {
        return jpa.findAll().stream()
                .map(BoardColumnMapper::toDomain)
                .toList();
    }

    @Override
    public BoardColumn save(BoardColumn column) {
        BoardColumnEntity saved = jpa.save(BoardColumnMapper.toEntity(column));
        return BoardColumnMapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);

    }
}
