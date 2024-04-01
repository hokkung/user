package com.leo.user.testutil.user;

import com.leo.user.domain.user.User;
import lombok.experimental.UtilityClass;


@UtilityClass
public final class UserUtils {

    public User create(String firstName,
                       String lastName,
                       String email,
                       long id) {
        User user = UserUtils.create(firstName, lastName, email);
        user.setId(id);

        return user;
    }

    public User create(String firstName,
                       String lastName,
                       String email,
                       String password) {
        User user = UserUtils.create(firstName, lastName, email);
        user.setPassword(password);

        return user;
    }

    public User create(String firstName,
                       String lastName,
                       String email) {
        User user = User.create();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        return user;
    }
}
