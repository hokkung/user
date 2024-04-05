package com.leo.user.model.auth;


import com.leo.user.common.domain.Name;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterRequest {
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Name name;
    @NotNull
    private String gender;


    public static RegisterRequest create(String email, String password) {
        RegisterRequest r = new RegisterRequest();
        r.setEmail(email);
        r.setPassword(password);

        return r;
    }

    public static RegisterRequest create(
            String email,
            String password,
            Name name,
            String gender) {
        RegisterRequest r = create(email, password);
        r.setName(name);
        r.setGender(gender);

        return r;
    }
}
