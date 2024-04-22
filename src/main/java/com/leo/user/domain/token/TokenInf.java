package com.leo.user.domain.token;

public interface TokenInf {
    void deactivate();
    boolean isValid();
}
