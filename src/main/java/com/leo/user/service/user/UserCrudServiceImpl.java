package com.leo.user.service.user;


import com.leo.user.common.Name;
import com.leo.user.common.exception.EntityNotFoundException;
import com.leo.user.domain.user.User;
import com.leo.user.model.user.CreateOrUpdateUserForm;
import com.leo.user.repository.user.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCrudServiceImpl implements UserCrudService {

    @Autowired
    @Setter
    private UserRepository userRepository;

    @Override
    public User create(CreateOrUpdateUserForm form) {
        User user = new User();
        user.setEmail(form.getEmail());

        Name name = form.getName();
        user.setFirstName(name.getFirstName());
        user.setLastName(name.getLastName());

        userRepository.save(user);

        return user;
    }

    @Override
    public User update(User user) {
        userRepository.save(user);
        return user;
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
        return  userRepository.findById(id);
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
