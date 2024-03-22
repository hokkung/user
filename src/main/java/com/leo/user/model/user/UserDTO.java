package com.leo.user.model.user;


import com.leo.user.common.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private long id;
    private Name name;
    private String email;
}
