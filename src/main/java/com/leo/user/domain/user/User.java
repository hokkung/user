package com.leo.user.domain.user;

import com.leo.user.common.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "users",
        indexes = {
                @Index(columnList = "firstname", name = "firstname_idx"),
                @Index(columnList = "firstname,lastname", name = "first_and_last_idx")
})
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

    public static User create() {
        User user = new User();
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());

        return user;
    }
}
