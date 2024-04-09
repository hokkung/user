package com.leo.user.repository.token;

import com.leo.user.domain.token.TokenType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TokenTypeConverter implements AttributeConverter<TokenType, String> {
    @Override
    public String convertToDatabaseColumn(TokenType type) {
        return type != null ? type.name() : null;
    }

    @Override
    public TokenType convertToEntityAttribute(String value) {
        return value != null ? TokenType.valueOf(value) : null;
    }
}
