package com.leo.user.service.user;

import com.leo.user.controller.user.UserFilter;
import com.leo.user.domain.user.User;
import com.leo.user.model.auth.ChangePasswordRequest;

import java.security.Principal;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    List<User> getUsers(UserFilter filter);

    void changePassword(ChangePasswordRequest request, Principal user);
}
