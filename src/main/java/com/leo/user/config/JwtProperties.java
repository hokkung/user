package com.leo.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(
        long expirationTimeInMinute,
        long refreshExpirationTimeInMinute
) {
    public JwtProperties() {
        this(1, 30);
    }
}
