package org.max.issuetracker.domain.service;

import org.max.issuetracker.domain.model.BoardColumn;
import org.max.issuetracker.domain.repository.BoardColumnRepository;

import java.util.List;
import java.util.Optional;

public class BoardColumnService {

    private final BoardColumnRepository repository;

    public BoardColumnService(BoardColumnRepository repository) {
        this.repository = repository;
    }

    public BoardColumn createColumn(Long projectId, String name, int position) {

        BoardColumn column = new BoardColumn(
                null,
                projectId,
                name,
                position
        );

        return repository.save(column);
    }

    public Optional<BoardColumn> findById(Long id) {
        return repository.findById(id);
    }

    public List<BoardColumn> findByProject(Long projectId) {
        return repository.findByProjectId(projectId);
    }

    public List<BoardColumn> listAll() {
        return repository.findAll();
    }

    public void deleteColumn(Long id) {
        repository.deleteById(id);
    }
}
