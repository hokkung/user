package com.leo.user.testutil.user;

import com.leo.user.entity.user.User;
import lombok.experimental.UtilityClass;


@UtilityClass
public final class UserUtils {

    public User createUser(String firstName,
                                  String lastName,
                                  String email,
                                  long id) {
        User user = new User();
//        user.setId(id);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setEmail(email);

        return user;
    }
}
