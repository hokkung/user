package com.leo.user.model.auth;

import com.leo.user.model.user.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponseDto {
    private UserDto user;
}
