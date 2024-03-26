package com.leo.user.service.user;

import com.leo.user.controller.user.UserFilter;
import com.leo.user.domain.user.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    List<User> getUsers(UserFilter filter);
}
