package com.leo.user.service.auth;


import com.leo.user.common.exception.EntityNotFoundException;
import com.leo.user.common.security.JwtService;
import com.leo.user.domain.user.Gender;
import com.leo.user.domain.user.User;
import com.leo.user.model.auth.AuthenticationResult;
import com.leo.user.model.auth.JwtToken;
import com.leo.user.model.auth.RegisterRequest;
import com.leo.user.model.user.CreateOrUpdateUserForm;
import com.leo.user.repository.user.UserRepository;
import com.leo.user.service.user.UserCrudService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Setter
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserCrudService userCrudService;

    @Override
    public AuthenticationResult register(RegisterRequest request) {
        CreateOrUpdateUserForm form = CreateOrUpdateUserForm
                .builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .gender(Gender.valueOf(request.getGender()))
                .build();
        User user = userCrudService.create(form);
        return generateToken(user);
    }

    @Override
    public AuthenticationResult login(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return generateToken(optionalUser.get());
    }

    private AuthenticationResult generateToken(User user) {
        JwtToken jwtToken = jwtService.generateToken(user);
        return new AuthenticationResult(
                user,
                jwtToken.token(),
                jwtToken.tokenExpirationTime()
        );
    }
}
