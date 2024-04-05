package com.leo.user.repository.user;

import com.leo.user.domain.user.Role;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<Role, Long> {
    @Override
    public Long convertToDatabaseColumn(Role role) {
        return role != null ? role.getValue() : null;
    }

    @Override
    public Role convertToEntityAttribute(Long value) {
        return value != null ? Role.create(value) : null;
    }
}
