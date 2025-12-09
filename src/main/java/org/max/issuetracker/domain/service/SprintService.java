package org.max.issuetracker.domain.service;

import org.max.issuetracker.domain.model.Sprint;
import org.max.issuetracker.domain.repository.SprintRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class SprintService {

    private final SprintRepository sprintRepository;

    public SprintService(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    public Sprint createSprint(Long projectId,
                               String name,
                               LocalDate startDate,
                               LocalDate endDate,
                               String status,
                               String goal) {

        Sprint sprint = new Sprint(
                null,
                projectId,
                name,
                startDate,
                endDate,
                status,
                goal,
                Instant.now()
        );

        return sprintRepository.save(sprint);
    }

    public Optional<Sprint> findById(Long id) {
        return sprintRepository.findById(id);
    }

    public List<Sprint> findByProject(Long projectId) {
        return sprintRepository.findByProjectId(projectId);
    }

    public List<Sprint> listAll() {
        return sprintRepository.findAll();
    }

    public void deleteSprint(Long id) {
        sprintRepository.deleteById(id);
    }
}
