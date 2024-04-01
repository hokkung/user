package com.leo.user.domain.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leo.user.common.domain.BaseEmbeddedId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "user_roles")
@Getter
@Setter
public class UserRole {

    @EmbeddedId
    private BaseEmbeddedId<Long, Role> id;

    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    public static UserRole create() {
        return new UserRole();
    }
}
