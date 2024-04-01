package com.leo.user.model.user;


import com.leo.user.common.domain.Name;
import com.leo.user.domain.user.Gender;
import com.leo.user.model.audit.AuditDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO {
    private long id;
    private Name name;
    private String email;
    private Gender gender;
    private AuditDto auditDto;
    private Set<String> roles;

    public static UserDTO create(int id, Name name, String email, Gender gender, AuditDto auditDto) {
      return UserDTO.builder().id(id).name(name).email(email).gender(gender).auditDto(auditDto).build();
    }
}
