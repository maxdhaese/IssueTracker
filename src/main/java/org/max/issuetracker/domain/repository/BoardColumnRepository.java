package org.max.issuetracker.domain.repository;

import org.max.issuetracker.domain.model.BoardColumn;

import java.util.List;
import java.util.Optional;

public interface BoardColumnRepository {

    Optional<BoardColumn> findById(Long id);

    List<BoardColumn> findByProjectId(Long projectId);

    List<BoardColumn> findAll();

    BoardColumn save(BoardColumn column);

    void deleteById(Long id);
}
