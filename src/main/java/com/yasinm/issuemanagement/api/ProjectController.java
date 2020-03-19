package com.yasinm.issuemanagement.api;

import com.yasinm.issuemanagement.dto.ProjectDto;
import com.yasinm.issuemanagement.service.ProjectService;
import com.yasinm.issuemanagement.util.ApiPaths;
import com.yasinm.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created By Yasin Memic on Mar, 2020
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
@Slf4j
@CrossOrigin
public class ProjectController {

    private final ProjectService projectService;


    @GetMapping
    @ApiOperation(value = "Get All Operation", response = ProjectDto.class)
    public ResponseEntity<List<ProjectDto>> getAll() {
        log.info("ProjectController -> getAllByPagination");
        return ResponseEntity.ok(projectService.getAll());
    }


    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
        log.info("ProjectController -> getAllByPagination");
        log.debug("ProjectController -> getAllByPagination -> PARAM: "+pageable );
        return ResponseEntity.ok(projectService.getAllPageable(pageable));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
        log.info("ProjectController -> GetByID");
        log.debug("ProjectController -> GetByID -> PARAM: "+id );
        return ResponseEntity.ok(projectService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.save(projectDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.update(id, projectDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectService.deleteById(id));
    }
}
