package com.leo.user.service.user;

import com.leo.user.domain.user.User;
import com.leo.user.model.user.CreateOrUpdateUserForm;

import java.util.Optional;

public interface UserCrudService {

    User create(CreateOrUpdateUserForm form);

    User update(User user);

    User update(long id, CreateOrUpdateUserForm form);

    Optional<User> get(long id);

    void remove(User user);

    void remove(long id);
}
