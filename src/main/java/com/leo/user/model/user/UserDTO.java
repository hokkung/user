package com.leo.user.model.user;


import com.leo.user.common.Name;
import com.leo.user.domain.user.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private long id;
    private Name name;
    private String email;
    private Date createdDate;
    private Date updatedDate;
    private Gender gender;
}
