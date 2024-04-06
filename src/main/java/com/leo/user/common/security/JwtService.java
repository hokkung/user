package com.leo.user.common.security;

import com.leo.user.domain.user.User;
import com.leo.user.model.auth.JwtToken;

public interface JwtService {

//    String extractUsername(String token);
//
//    boolean IsTokenValid(String token, UserDetails userDetails);

    JwtToken generateToken(String name);

    JwtToken generateToken(User user);
}
