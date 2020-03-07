package com.yasinm.issuemanagement.service.impl;

import com.yasinm.issuemanagement.dto.IssueDto;
import com.yasinm.issuemanagement.entity.Issue;
import com.yasinm.issuemanagement.entity.Project;
import com.yasinm.issuemanagement.entity.User;
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
        return modelMapper.map(issueRepository.getOne(id), IssueDto.class);
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
    public IssueDto update(Long id, IssueDto issueDto) {
        Issue issue = issueRepository.getOne(id);
        if(issue == null){
            throw new IllegalArgumentException("Issue didn't find!");
        }
        if(issue.getAssignee() != null){
            issue.setAssignee(modelMapper.map(issueDto.getAssignee(), User.class));
        }
        else{
            issue.setAssignee(null);
        }

        issue.setDate(issueDto.getDate());
        issue.setDescription(issueDto.getDescription());
        issue.setDetails(issueDto.getDetails());
        issue.setIssueStatus(issueDto.getIssueStatus());
        if(issue.getProject() != null){
            issue.setProject(modelMapper.map(issueDto.getProject(), Project.class));
        }
        else{
            issue.setProject(null);
        }
        issueRepository.save(issue);
        return modelMapper.map(issue,IssueDto.class);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (issueRepository.getOne(id) != null) {
            issueRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}
