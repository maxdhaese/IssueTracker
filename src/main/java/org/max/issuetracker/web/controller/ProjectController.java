package org.max.issuetracker.web.controller;

import org.max.issuetracker.domain.model.Project;
import org.max.issuetracker.domain.service.ProjectService;
import org.max.issuetracker.web.dto.CreateProjectRequest;
import org.max.issuetracker.web.dto.ProjectDTO;
import org.max.issuetracker.web.dto.ProjectWebMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    public ProjectDTO create(@RequestBody CreateProjectRequest req){
        Project project = service.createProject(
                req.name(),
                req.projectKey(),
                req.description(),
                req.ownerId()
        );
        return ProjectWebMapper.toDTO(project);
    }

    @GetMapping("/{id}")
    public ProjectDTO get(@PathVariable Long id){
        return service.findById(id)
                .map(ProjectWebMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Project not found: " + id));
    }

    @GetMapping
    public List<ProjectDTO> list(){
        return service.listAll()
                .stream()
                .map(ProjectWebMapper::toDTO)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteProject(id);
    }

}
