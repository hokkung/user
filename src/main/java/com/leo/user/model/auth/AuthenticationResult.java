package com.leo.user.model.auth;

import com.leo.user.domain.user.User;

import java.util.Date;

public record AuthenticationResult(
        User user,
        String token,
        String refreshToken,
        Date tokenExpirationTime
) {}
