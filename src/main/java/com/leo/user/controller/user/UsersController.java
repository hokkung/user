package com.leo.user.controller.user;

import com.leo.user.entity.user.User;
import com.leo.user.model.user.UserDTO;
import com.leo.user.service.user.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    @Setter
    private UserService userService;

    @GetMapping("")
    public List<UserDTO> getUsers() {
        List<User> users = userService.getUsers();
        return users.stream().map(u -> new UserDTO(u.getId(), u.getFirstname(), u.getLastname(), u.getEmail())).toList();
    }
}
