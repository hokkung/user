package com.leo.user.service.auth;

import com.leo.user.model.auth.AuthenticationResult;
import com.leo.user.model.auth.RegisterRequest;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public interface AuthenticationService {
    AuthenticationResult register(RegisterRequest registerRequest);

    AuthenticationResult login(RegisterRequest request);

    AuthenticationResult refreshToken(JwtAuthenticationToken token);
}
