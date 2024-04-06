package com.leo.user.controller.auth;


import com.leo.user.mapper.user.UserMapper;
import com.leo.user.model.auth.AuthenticationResult;
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
    public LoginResponseDto register(@RequestBody RegisterRequest request) {
        AuthenticationResult res = authenticationService.register(request);

        return new LoginResponseDto(
                UserMapper.INSTANCE.toUserDTO(res.user()),
                res.token(),
                res.tokenExpirationTime());
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody RegisterRequest request) {
        AuthenticationResult res = authenticationService.login(request);

        return new LoginResponseDto(
                UserMapper.INSTANCE.toUserDTO(res.user()),
                res.token(),
                res.tokenExpirationTime());
    }
}
