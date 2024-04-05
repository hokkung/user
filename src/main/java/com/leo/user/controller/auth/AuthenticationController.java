package com.leo.user.controller.auth;


import com.leo.user.domain.user.User;
import com.leo.user.mapper.user.UserMapper;
import com.leo.user.model.auth.AuthenticationResponseDto;
import com.leo.user.model.auth.LoginResponseDto;
import com.leo.user.model.auth.RegisterRequest;
import com.leo.user.service.auth.AuthenticationService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Setter
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public AuthenticationResponseDto register(@RequestBody RegisterRequest request) {
        User user =  authenticationService.register(request);

        return AuthenticationResponseDto.builder().user(UserMapper.INSTANCE.toUserDTO(user)).build();
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody RegisterRequest request) {
        String token =  authenticationService.login(request);

        return LoginResponseDto.builder().token(token).build();
    }
}
