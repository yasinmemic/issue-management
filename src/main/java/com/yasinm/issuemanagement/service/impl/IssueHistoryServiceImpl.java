package com.yasinm.issuemanagement.service.impl;

import com.yasinm.issuemanagement.entity.Issue;
import com.yasinm.issuemanagement.entity.IssueHistory;
import com.yasinm.issuemanagement.repository.IssueHistoryRepository;
import com.yasinm.issuemanagement.service.IssueHistoryService;
import com.yasinm.issuemanagement.util.TPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if (issueHistory.getDate() == null) {
            throw new IllegalArgumentException("Date field can't be null!");
        }
        return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public TPage<IssueHistory> getAllPageable(Pageable pageable) {
        Page<IssueHistory> issueHistories = issueHistoryRepository.findAll(pageable);
        TPage<IssueHistory> issueHistoryTPage = new TPage<>();
        IssueHistory[] histories = modelMapper.map(issueHistories.getContent(),IssueHistory[].class);
        issueHistoryTPage.setStat(issueHistories, Arrays.asList(histories));
        return issueHistoryTPage;
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        if (issueHistoryRepository.getOne(issueHistory.getId()) != null) {
            issueHistoryRepository.delete(modelMapper.map(issueHistory, IssueHistory.class));
            return true;
        } else {
            return false;
        }
    }
}
