package com.yasinm.issuemanagement.service.impl;

import com.yasinm.issuemanagement.dto.IssueDto;
import com.yasinm.issuemanagement.entity.Issue;
import com.yasinm.issuemanagement.repository.IssueRepository;
import com.yasinm.issuemanagement.service.IssueService;
import com.yasinm.issuemanagement.util.TPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate() == null) {
            throw new IllegalArgumentException("Issue date cannot be null!");
        }
        Issue issueDb = modelMapper.map(issue, Issue.class);
        issueDb = issueRepository.save(issueDb);
        IssueDto issueDto = modelMapper.map(issueDb, IssueDto.class);
        return issueDto;
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> datas = issueRepository.findAll(pageable);
        IssueDto[] issueDtos = modelMapper.map(datas.getContent(),IssueDto[].class);
        TPage<IssueDto> page = new TPage<>();
        page.setStat(datas,Arrays.asList(issueDtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        //  issueRepository.delete(issue);
        return Boolean.TRUE;

    }
}
