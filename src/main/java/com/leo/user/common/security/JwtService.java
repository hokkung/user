package com.leo.user.common.security;

import com.leo.user.domain.user.User;
import org.springframework.security.oauth2.jwt.Jwt;


public interface JwtService {

//    String extractUsername(String token);
//
//    boolean IsTokenValid(String token, UserDetails userDetails);

    JwtToken generateToken(User user);

    JwtToken generateToken(User user, Jwt token);
}
