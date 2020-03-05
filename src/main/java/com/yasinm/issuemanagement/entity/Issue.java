package com.yasinm.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ISSUE")
public class Issue extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    @Column(name = "DETAILS", length = 4000)
    private String details;

    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "ISSUE_STATUS")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "ASSIGNEE_USER_ID")
    @ManyToOne(optional = true, fetch = FetchType.LAZY) //optional, bu issue'yi bir kullanıcıya atamasan da olur demek...
    private User assignee;

    @JoinColumn(name = "PROJECT_ID")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;
}
