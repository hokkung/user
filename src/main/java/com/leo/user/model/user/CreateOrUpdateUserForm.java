package com.leo.user.model.user;

import com.leo.user.common.domain.Name;
import com.leo.user.domain.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class CreateOrUpdateUserForm {
    @Setter
    @Getter
    @NotNull
    private Name name;

    @Setter
    @Getter
    @NotNull
    private String email;

    public User extract(User user) {
        user.setFirstName(name.getFirstName());
        user.setLastName(name.getLastName());
        user.setEmail(getEmail());

        return user;
    }
}
