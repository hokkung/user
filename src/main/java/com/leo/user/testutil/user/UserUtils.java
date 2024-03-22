package com.leo.user.testutil.user;

import com.leo.user.entity.user.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class UserUtils {
    public static User createUser(String firstName, String lastName, String email, long id) {
        User user = new User();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setEmail(email);
        user.setId(id);
        return user;
    }
}
