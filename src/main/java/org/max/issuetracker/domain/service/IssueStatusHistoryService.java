package org.max.issuetracker.domain.service;

import org.max.issuetracker.domain.repository.IssueStatusHistoryRepository;

public class IssueStatusHistoryService {

    private final IssueStatusHistoryRepository repository;

    public IssueStatusHistoryService(IssueStatusHistoryRepository repository) {
        this.repository = repository;
    }


}
