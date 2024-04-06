package com.leo.user.model.auth;


import java.util.Date;

public record JwtToken (
        String token,
        Date tokenExpirationTime
){}
