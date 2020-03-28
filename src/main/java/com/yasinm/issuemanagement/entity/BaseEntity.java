package com.yasinm.issuemanagement.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "created_by", length = 50)
    private String createdBy;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDate updatedAt;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    @Column(name = "status")
    private Boolean status;


    @PrePersist
    void onCreate() {
        setCreatedAt(LocalDate.now());
    }

    @PreUpdate
    void onPersist() {
        setUpdatedAt(LocalDate.now());
    }
}
