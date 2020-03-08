package com.yasinm.issuemanagement.dto;

import com.yasinm.issuemanagement.entity.Issue;
import com.yasinm.issuemanagement.entity.IssueStatus;
import com.yasinm.issuemanagement.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created By Yasin Memic on Mar, 2020
 */
@Data
@ApiModel(value = "Issue History Data Transfer Object")
public class IssueHistoryDto {
    @ApiModelProperty(value = "ID", required = true)
    private Long id;

    @ApiModelProperty(value = "Issue", required = true)
    private Issue issue;

    @ApiModelProperty(value = "Description", required = true)
    private String description;

    @ApiModelProperty(value = "Date", required = true)
    private Date date;

    @ApiModelProperty(value = "Issue Status", required = true)
    private IssueStatus issueStatus;

    @ApiModelProperty(value = "Details", required = true)
    private String details;

    @ApiModelProperty(value = "Assignee", required = true)
    private User assignee;
}
