package com.leo.user.common.security;


import lombok.Builder;

import java.util.Date;

@Builder
public record JwtToken(
        String token,
        String refreshToken,
        Date tokenExpirationTime
){}
