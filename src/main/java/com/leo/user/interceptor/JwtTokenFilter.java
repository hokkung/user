package com.leo.user.interceptor;

import com.leo.user.service.token.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;


@Component
@Setter
public class JwtTokenFilter extends OncePerRequestFilter {

    private static final Set<String> WHITE_LIST_URL = Set.of(
            "/api/v1/auth/login",
            "/api/v1/auth/register",
            "/api/v1/auth/refresh-token"
    );

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain
    ) throws ServletException, IOException {
        for (String whiteList : WHITE_LIST_URL) {
            if (whiteList.equals(request.getRequestURI())) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            throw new IllegalArgumentException("should have token");
        }

        String jwtToken = authHeader.substring(7);
        if (!tokenService.verifyToken(jwtToken)) {
            // TODO: throw another exception
            throw new IllegalArgumentException("invalid token");
        }

        filterChain.doFilter(request, response);
    }
}
