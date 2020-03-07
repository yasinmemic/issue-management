package com.yasinm.issuemanagement.service;

import com.yasinm.issuemanagement.dto.IssueDto;
import com.yasinm.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    IssueDto update(Long id, IssueDto issueDto);

    Boolean deleteById(Long id);
}
