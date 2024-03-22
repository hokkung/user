package com.leo.user.model.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserDTO {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
}
