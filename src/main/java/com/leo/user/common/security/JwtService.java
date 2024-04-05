package com.leo.user.common.security;

import org.springframework.security.core.Authentication;

public interface JwtService {

//    String extractUsername(String token);
//
//    boolean IsTokenValid(String token, UserDetails userDetails);

    String generateToken(Authentication authentication);
}
