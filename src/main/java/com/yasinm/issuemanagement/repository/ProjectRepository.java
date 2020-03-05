package com.yasinm.issuemanagement.repository;

import com.yasinm.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);

    List<Project> getByProjectCodeContains(String projectCode);

    List<Project> getByProjectCode(String projectCode);

}
