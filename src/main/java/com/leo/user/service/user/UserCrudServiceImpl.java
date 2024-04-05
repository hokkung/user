package com.leo.user.service.user;


import com.leo.user.common.domain.Name;
import com.leo.user.common.exception.EntityNotFoundException;
import com.leo.user.domain.user.Role;
import com.leo.user.domain.user.User;
import com.leo.user.model.user.CreateOrUpdateUserForm;
import com.leo.user.repository.user.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Setter
public class UserCrudServiceImpl implements UserCrudService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User create(CreateOrUpdateUserForm form) {
        // TODO: check email exist
        User user = User.create();
        user.setEmail(form.getEmail());

        Name name = form.getName();
        user.getName().setFirstName(name.getFirstName());
        user.getName().setLastName(name.getLastName());
        user.setGender(form.getGender());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.getRoles().add(Role.USER);

        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(long id, CreateOrUpdateUserForm form) {
        Optional<User> optionalUser = get(id);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException();
        }

        User user = optionalUser.get();
        form.extract(user);

        return update(user);
    }

    @Override
    public Optional<User> get(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void remove(User user) {
        userRepository.deleteById(user.getId());
    }

    @Override
    public void remove(long id) {
        Optional<User> optionalUser = get(id);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException();
        }

        remove(optionalUser.get());
    }
}
