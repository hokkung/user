package com.leo.user.service.auth;

import com.leo.user.domain.user.User;
import com.leo.user.model.auth.RegisterRequest;

public interface AuthenticationService {
    User register(RegisterRequest registerRequest);

    String login(RegisterRequest request);
}
