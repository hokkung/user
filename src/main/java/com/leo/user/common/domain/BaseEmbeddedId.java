package com.leo.user.common.domain;

import com.leo.user.repository.user.UserRoleConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@Getter
public class BaseEmbeddedId<J, K> implements Serializable {
    @Column(name = "user_id")
    @NotNull
    private J primary;

    @Column(name = "role_id")
    @NotNull
    @Convert(converter = UserRoleConverter.class)
    private K secondary;

    public static <J, K> BaseEmbeddedId<J, K> create(J primary, K secondary) {
        return new BaseEmbeddedId<>(primary, secondary);
    }
}
