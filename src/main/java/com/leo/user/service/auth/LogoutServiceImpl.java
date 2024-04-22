package com.leo.user.service.auth;

import com.leo.user.common.exception.InvalidValueException;
import com.leo.user.service.token.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;


@Service
@Setter
public class LogoutServiceImpl implements LogoutHandler {

    @Autowired
    private TokenService tokenService;

    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            throw new InvalidValueException("should have token");
        }

        String jwtToken = authHeader.substring(7);
        tokenService.verifyAndRevoke(jwtToken);
    }
}
