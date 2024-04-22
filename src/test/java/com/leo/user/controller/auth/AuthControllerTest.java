package com.leo.user.controller.auth;

import com.leo.user.common.domain.Name;
import com.leo.user.common.util.ClockUtils;
import com.leo.user.domain.user.Gender;
import com.leo.user.domain.user.User;
import com.leo.user.mapper.user.UserMapper;
import com.leo.user.model.auth.AuthenticationResult;
import com.leo.user.model.auth.LoginResponseDto;
import com.leo.user.model.auth.RegisterRequest;
import com.leo.user.model.user.UserDto;
import com.leo.user.service.auth.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthControllerTest {
    private AuthController underTest;

    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        authenticationService = mock(AuthenticationService.class);

        underTest = new AuthController();
        underTest.setAuthenticationService(authenticationService);
    }

    @Test
    void testRegister() {
        Clock.fixed(Instant.now(), ZoneId.systemDefault());

        RegisterRequest r = RegisterRequest.create(
                "leo",
                "1234",
                Name.builder().firstName("leo").lastName("rou").build(),
                "MALE");

        User user = User.create();
        user.setName(r.getName());
        user.setGender(Gender.MALE);
        user.setEmail(r.getEmail());
        user.setPassword(r.getPassword());

        UserDto userDto = UserMapper.INSTANCE.toUserDTO(user);

        AuthenticationResult expect = new AuthenticationResult(
                user,
                "jwt",
                "refreshJwt",
                Date.from(ClockUtils.getCurrent())
        );

        when(authenticationService.register(r)).thenReturn(expect);

        LoginResponseDto result = underTest.register(r);

        assertEquals(expect.token(), result.token());
        assertEquals(expect.tokenExpirationTime(), result.tokenExpiredTime());
        assertEquals(userDto.getEmail(), result.user().getEmail());
    }
}
