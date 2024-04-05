package com.leo.user.domain.user;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    UNSPECIFIED(0),
    ADMIN(1),
    USER(2);

    private final long value;

    public static Role create(long value) {
        for (Role role : Role.values()) {
            if (role.value == value) {
                return role;
            }
        }

        throw new IllegalArgumentException("invalid role value");
    }
}
