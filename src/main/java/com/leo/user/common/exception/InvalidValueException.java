package com.leo.user.common.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@AllArgsConstructor
public class InvalidValueException extends IllegalArgumentException {
    private String message;
}
