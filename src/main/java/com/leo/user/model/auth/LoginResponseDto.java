package com.leo.user.model.auth;

import com.leo.user.model.user.UserDto;

import java.util.Date;

public record LoginResponseDto(
        UserDto user,
        String token,
        Date tokenExpiredTime
) {}
