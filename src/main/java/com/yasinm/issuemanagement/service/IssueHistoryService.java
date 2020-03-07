package com.yasinm.issuemanagement.service;

import com.yasinm.issuemanagement.entity.IssueHistory;
import com.yasinm.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {

    IssueHistory save(IssueHistory issueHistory);

    IssueHistory getById(Long id);

    TPage<IssueHistory> getAllPageable(Pageable pageable);

    Boolean delete(IssueHistory issueHistory);
}
