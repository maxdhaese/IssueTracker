package org.max.issuetracker.web.controller;


import org.max.issuetracker.domain.model.Issue;
import org.max.issuetracker.domain.service.IssueService;
import org.max.issuetracker.web.dto.CreateIssueRequest;
import org.max.issuetracker.web.dto.IssueDTO;
import org.max.issuetracker.web.dto.IssueWebMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final IssueService service;

    public IssueController(IssueService service) {
        this.service = service;
    }

    @PostMapping
    public IssueDTO create(@RequestBody CreateIssueRequest req){
        Issue issue = service.createIssue(
                req.projectId(),
                req.sprintId(),
                req.title(),
                req.description(),
                req.type(),
                req.status(),
                req.priority(),
                req.assigneeId(),
                req.reporterId(),
                req.storyPoints(),
                req.boardColumnId()
        );
        return IssueWebMapper.toDTO(issue);
    }

    @GetMapping("/{id}")
    public IssueDTO get(@PathVariable Long id){
        return service.findById(id)
                .map(IssueWebMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Issue not found: " + id));
    }

    @GetMapping("/project/{projectId}")
    public List<IssueDTO> listByProject(@PathVariable Long projectId){
        return service.listByProject(projectId)
                .stream()
                .map(IssueWebMapper::toDTO)
                .toList();
    }
}
