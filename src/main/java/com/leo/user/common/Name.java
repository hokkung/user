package com.leo.user.common;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Name {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
