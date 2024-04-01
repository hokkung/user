package com.leo.user.common.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Setter
@Getter
public abstract class AbstractBaseEntity<K> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private K id;
}
