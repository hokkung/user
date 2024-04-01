package com.leo.user.domain.user;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    ADMIN,
    USER;
    private String name;
}
