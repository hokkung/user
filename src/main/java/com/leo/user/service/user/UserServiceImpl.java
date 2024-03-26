package com.leo.user.service.user;

import com.leo.user.controller.user.UserFilter;
import com.leo.user.domain.user.User;
import com.leo.user.repository.user.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Setter
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCrudService userCrudService;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsers(UserFilter filter) {
        return userRepository.findByFirstName(filter.getFirstName());
    }
}
