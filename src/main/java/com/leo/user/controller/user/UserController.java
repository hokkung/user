package com.leo.user.controller.user;

import com.leo.user.common.exception.EntityNotFoundException;
import com.leo.user.domain.user.User;
import com.leo.user.mapper.user.UserMapper;
import com.leo.user.model.auth.ChangePasswordRequest;
import com.leo.user.model.user.CreateOrUpdateUserForm;
import com.leo.user.model.user.UserDto;
import com.leo.user.service.user.UserCrudService;
import com.leo.user.service.user.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@Setter
public class UserController {

    @Autowired
    private UserCrudService userCrudService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDto get(@PathVariable long id) {
        Optional<User> optionalUser = userCrudService.get(id);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException();
        }

        User user = optionalUser.get();
        return UserMapper.INSTANCE.toUserDTO(user);
    }

    @PostMapping("")
    public UserDto create(@RequestBody CreateOrUpdateUserForm form) {
        User user = userCrudService.create(form);
        return UserMapper.INSTANCE.toUserDTO(user);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        userCrudService.remove(id);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable long id, @RequestBody CreateOrUpdateUserForm form) {
        User user = userCrudService.update(id, form);
        return UserMapper.INSTANCE.toUserDTO(user);
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request, Principal user) {
        userService.changePassword(request, user);
        return ResponseEntity.ok().build();
    }
}
