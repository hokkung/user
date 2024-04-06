package com.leo.user.service.auth;

import com.leo.user.model.auth.AuthenticationResult;
import com.leo.user.model.auth.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResult register(RegisterRequest registerRequest);

    AuthenticationResult login(RegisterRequest request);
}
