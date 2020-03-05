package com.yasinm.issuemanagement.entity;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "PROJECT")
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PROJECT_CODE", length = 1000, unique = true)
    private String projectCode;

    @Column(name = "PROJECT_NAME", length = 1000)
    private String projectName;

    @JoinColumn(name = "MANAGER_USER_ID")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User manager;

}
