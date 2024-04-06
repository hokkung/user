package com.leo.user.service.user;

import com.leo.user.common.exception.EntityNotFoundException;
import com.leo.user.common.exception.InvalidValueException;
import com.leo.user.controller.user.UserFilter;
import com.leo.user.domain.user.User;
import com.leo.user.model.auth.ChangePasswordRequest;
import com.leo.user.repository.user.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Setter
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsers(UserFilter filter) {
        return userRepository.findByNameFirstName(filter.getFirstName());
    }

    @Transactional
    @Override
    public void changePassword(ChangePasswordRequest request, Principal principal) {
        Optional<User> opUser = userRepository.findByEmail(principal.getName());
        if (opUser.isEmpty()) {
            throw new EntityNotFoundException();
        }

        User user = opUser.get();
        if (!passwordEncoder.matches(request.currentPassword(), user.getPassword())) {
            throw new InvalidValueException();
        }

        user.setPassword(passwordEncoder.encode(request.newPassword()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  userRepository.findByEmail(username).orElseThrow();
    }
}
