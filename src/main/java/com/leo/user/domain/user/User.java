package com.leo.user.domain.user;

import com.leo.user.common.domain.AbstractAuditableEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractAuditableEntity<Long> {

    @NotNull
    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @NotNull
    @Column(name = "firstname")
    @Getter
    @Setter
    private String firstName;

    @NotNull
    @Column(name = "lastname")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Gender gender;

    @Column(name = "password")
    @NotNull
    @Getter
    @Setter
    private String password;

    @OneToMany(mappedBy = "user", targetEntity = UserRole.class)
    @Getter
    @Setter
    private Set<UserRole> roles;

    protected User() {
        setCreatedDate(new Date());
        setUpdatedDate(new Date());
        setRoles(new HashSet<>());
    }

    public static User create() {
        return  new User();
    }
}
