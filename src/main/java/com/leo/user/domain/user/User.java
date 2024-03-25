package com.leo.user.domain.user;

import com.leo.user.common.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity<Long> {

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "firstname")
    private String firstName;

    @NotNull
    @Column(name = "lastname")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
