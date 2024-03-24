package com.leo.user.controller.user;

import com.leo.user.common.exception.EntityNotFoundException;
import com.leo.user.domain.user.User;
import com.leo.user.mapper.user.UserMapper;
import com.leo.user.model.user.CreateOrUpdateUserForm;
import com.leo.user.model.user.UserDTO;
import com.leo.user.service.user.UserCrudServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    @Setter
    private UserCrudServiceImpl userCrudService;

    @GetMapping("/{id}")
    public UserDTO get(@PathVariable long id) {
        Optional<User> optionalUser = userCrudService.get(id);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException();
        }

        User user = optionalUser.get();
        return UserMapper.INSTANCE.toUserDTO(user);
    }

    @PostMapping("")
    public UserDTO create(@RequestBody CreateOrUpdateUserForm form) {
        User user = userCrudService.create(form);
        return UserMapper.INSTANCE.toUserDTO(user);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        userCrudService.remove(id);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable long id, @RequestBody CreateOrUpdateUserForm form) {
        User user = userCrudService.update(id, form);
        return UserMapper.INSTANCE.toUserDTO(user);
    }
}
