package com.leo.user.testutil.user;

import com.leo.user.domain.user.User;
import lombok.experimental.UtilityClass;


@UtilityClass
public final class UserUtils {

    public User createUser(String firstName,
                                  String lastName,
                                  String email,
                                  long id) {
        User user = createUser(firstName, lastName, email);
        user.setId(id);

        return user;
    }

    public User createUser(String firstName,
                           String lastName,
                           String email) {
        User user = User.create();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        return user;
    }
}
