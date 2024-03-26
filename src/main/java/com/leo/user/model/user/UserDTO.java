package com.leo.user.model.user;


import com.leo.user.common.domain.Name;
import com.leo.user.domain.user.Gender;
import com.leo.user.model.audit.AuditDto;
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
    private Gender gender;
    private AuditDto auditDto;
}
