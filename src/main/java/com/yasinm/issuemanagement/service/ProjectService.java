package com.yasinm.issuemanagement.service;

import com.yasinm.issuemanagement.dto.ProjectDto;
import com.yasinm.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    ProjectDto getByProjectCode(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean deleteById(Long projectId);

    ProjectDto update(Long id, ProjectDto projectDto);

    List<ProjectDto> getAll();
}
