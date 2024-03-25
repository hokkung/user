package com.leo.user.common.domain;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class Auditable {

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    @Setter
    @Getter
    private Date createdDate;

    @Column(name = "updated_date", nullable = false)
    @LastModifiedDate
    @Setter
    @Getter
    private Date updatedDate;
}
