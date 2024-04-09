package com.leo.user.model.auth;

import java.util.Date;

public record TokenDto (
    String token,
    String refreshToken,
    Date tokenExpiredTime
) {}
