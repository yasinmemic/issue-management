package com.yasinm.issuemanagement.dto;

import com.yasinm.issuemanagement.entity.IssueStatus;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class IssueDto {

    private Long id;

    private String description;

    private String details;

    private Date date;

    private IssueStatus issueStatus;

    private UserDto assignee;
    
    private ProjectDto project;
}
