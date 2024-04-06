package com.leo.user.model.auth;

public record ChangePasswordRequest(
        String currentPassword,
        String newPassword
) {}
