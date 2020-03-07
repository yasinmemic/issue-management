package com.yasinm.issuemanagement.api;

import com.yasinm.issuemanagement.dto.IssueDto;
import com.yasinm.issuemanagement.service.IssueService;
import com.yasinm.issuemanagement.util.ApiPaths;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created By Yasin Memic on Mar, 2020
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {
    private final IssueService issueService;


    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueService.getById(id));
    }

    @PostMapping
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueService.save(issueDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateIssue(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueService.update(id, issueDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIssue(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueService.deleteById(id));
    }
}
