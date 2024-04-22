package com.leo.user.service.token;

import com.leo.user.domain.token.Token;
import com.leo.user.domain.user.User;
import com.leo.user.model.auth.AuthenticationResult;

public interface TokenService {
    void revokeAllToken(User user);

    boolean verifyToken(String token);

    void verifyAndRevoke(String token);

    Token create(Token bearer);

    Token create(AuthenticationResult authentication);
}
