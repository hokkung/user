package com.leo.user.model.user;

import com.leo.user.common.domain.Name;
import com.leo.user.domain.user.Gender;
import com.leo.user.domain.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class CreateOrUpdateUserForm {
    @NotNull

    private Name name;
    @NotNull
    @Email

    private String email;

    @NotNull
    private String password;

    private Gender gender;


    public User extract(User user) {
        user.getName().setFirstName(name.getFirstName());
        user.getName().setLastName((name.getLastName()));
        user.setEmail(getEmail());

        return user;
    }
}
