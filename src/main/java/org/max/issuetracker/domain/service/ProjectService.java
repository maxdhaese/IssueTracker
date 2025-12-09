package org.max.issuetracker.domain.service;

import org.max.issuetracker.domain.model.Project;
import org.max.issuetracker.domain.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(String name, String key, String description, Long ownerId) {
        projectRepository.findByProjectKey(key).ifPresent(p -> {
            throw new IllegalArgumentException("Project key already exists: " + key);
        });

        Project project = new Project(
                null,
                name,
                key,
                description,
                ownerId,
                Instant.now(),
                Instant.now()
        );

        return projectRepository.save(project);
    }

    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    public List<Project> listAll() {
        return projectRepository.findAll();
    }

    public List<Project> listByOwner(Long ownerId) {
        return projectRepository.findAllByOwnerId(ownerId);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
