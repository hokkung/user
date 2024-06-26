package com.leo.user.controller.user;

import com.leo.user.domain.user.User;
import com.leo.user.mapper.user.UserMapper;
import com.leo.user.model.user.UserDto;
import com.leo.user.service.user.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<UserDto> getUsers() {
        List<User> users = userService.getUsers();

        return users.stream().map(UserMapper.INSTANCE::toUserDTO).collect(Collectors.toList());
    }

    @GetMapping("/first")
    public List<UserDto> getUsersByFirstName(UserQuery query) {
        List<User> users = userService.getUsers(query.createFilter());

        return users.stream().map(UserMapper.INSTANCE::toUserDTO).collect(Collectors.toList());
    }

}
