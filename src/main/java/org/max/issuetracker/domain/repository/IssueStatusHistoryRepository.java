package org.max.issuetracker.domain.repository;

import org.max.issuetracker.domain.model.IssueStatusHistory;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IssueStatusHistoryRepository {

    Optional<IssueStatusHistory> findbyId(Long id);

    List<IssueStatusHistory> findByIssueId(Long issueId);

    IssueStatusHistory save(IssueStatusHistory issueStatusHistory);


}
