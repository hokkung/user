package com.leo.user.service.auth;


import com.leo.user.common.security.JwtService;
import com.leo.user.domain.user.Gender;
import com.leo.user.domain.user.User;
import com.leo.user.model.auth.RegisterRequest;
import com.leo.user.model.user.CreateOrUpdateUserForm;
import com.leo.user.repository.user.UserRepository;
import com.leo.user.service.user.UserCrudService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    @Setter
    private UserRepository userRepository;

    @Autowired
    @Setter
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserCrudService userCrudService;

    @Override
    public User register(RegisterRequest request) {
        CreateOrUpdateUserForm form = CreateOrUpdateUserForm
                .builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .gender(Gender.valueOf(request.getGender()))
                .build();
        return userCrudService.create(form);
    }

    @Override
    public String login(RegisterRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        return jwtService.generateToken(auth);}
}
