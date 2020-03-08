package com.yasinm.issuemanagement.dto;

import com.yasinm.issuemanagement.entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel(value = "Issue Data Transfer Object")
public class IssueDto {

    @ApiModelProperty(value = "Issue ID", readOnly = true)
    private Long id;

    @ApiModelProperty(value = "Issue Description")
    private String description;

    @ApiModelProperty(value = "Issue Details")
    private String details;

    @ApiModelProperty(value = "Issue Date")
    private Date date;

    @ApiModelProperty(value = "Issue Status")
    private IssueStatus issueStatus;

    @ApiModelProperty(value = "Issue Assignee")
    private UserDto assignee;

    @ApiModelProperty(value = "Issue Project")
    private ProjectDto project;
}
