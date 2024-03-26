package com.leo.user.common.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<K> extends Auditable implements Serializable {

    @Getter
    @Setter
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private K id;
}