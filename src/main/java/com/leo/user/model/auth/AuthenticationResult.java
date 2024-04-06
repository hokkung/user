package com.leo.user.model.auth;

import com.leo.user.domain.user.User;

import java.util.Date;

public record AuthenticationResult(
        User user,
        String token,
        Date tokenExpirationTime
){
}
