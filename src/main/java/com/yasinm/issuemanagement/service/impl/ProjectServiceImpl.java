package com.yasinm.issuemanagement.service.impl;

import com.yasinm.issuemanagement.dto.ProjectDto;
import com.yasinm.issuemanagement.entity.Project;
import com.yasinm.issuemanagement.repository.ProjectRepository;
import com.yasinm.issuemanagement.service.ProjectService;
import com.yasinm.issuemanagement.util.TPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProjectDto save(ProjectDto project) {
        Project checkProjectForExisting = projectRepository.getByProjectCode(project.getProjectCode());
        if (checkProjectForExisting != null) {
            throw new IllegalArgumentException("Project Code already exist.");
        }
        Project projectForReturning = modelMapper.map(project, Project.class);
        projectForReturning = projectRepository.save(projectForReturning);
        return modelMapper.map(projectForReturning, ProjectDto.class);
    }

    @Override
    public ProjectDto getById(Long id) {
        return modelMapper.map(projectRepository.getOne(id), ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return modelMapper.map(projectRepository.getByProjectCode(projectCode), ProjectDto.class);
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> projects = projectRepository.findAll(pageable);
        ProjectDto[] projectDtoTPage = modelMapper.map(projects.getContent(), ProjectDto[].class);
        TPage<ProjectDto> tPage = new TPage<>();
        tPage.setStat(projects, Arrays.asList(projectDtoTPage));
        return tPage;
    }

    @Override
    public Boolean deleteById(Long projectId) {
        if (projectRepository.getOne(projectId) != null) {
            projectRepository.deleteById(projectId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project project = projectRepository.getOne(id);
        if (project == null) {
            throw new IllegalArgumentException("Project doesn't exist! ID: " + id);
        }

        Project checkProjectForExisting = projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(),id);
        if (checkProjectForExisting != null) {
            throw new IllegalArgumentException("Project Code already exist.");
        }

        project.setProjectCode(projectDto.getProjectCode());
        project.setProjectName(projectDto.getProjectName());
        projectRepository.save(project);
        return modelMapper.map(project, ProjectDto.class);

    }

    @Override
    public List<ProjectDto> getAll() {
        ProjectDto[] projectDtoList = modelMapper.map(projectRepository.findAll(), ProjectDto[].class);
        return Arrays.asList(projectDtoList);
    }
}

