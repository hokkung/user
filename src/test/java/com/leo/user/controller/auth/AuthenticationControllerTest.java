package com.leo.user.controller.auth;

import com.leo.user.common.domain.Name;
import com.leo.user.domain.user.Gender;
import com.leo.user.domain.user.User;
import com.leo.user.mapper.user.UserMapper;
import com.leo.user.model.auth.AuthenticationResponseDto;
import com.leo.user.model.auth.RegisterRequest;
import com.leo.user.model.user.UserDto;
import com.leo.user.service.auth.AuthenticationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthenticationControllerTest {
    private AuthenticationController underTest;

    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        authenticationService = mock(AuthenticationService.class);

        underTest = new AuthenticationController();
        underTest.setAuthenticationService(authenticationService);
    }

    @Test
    void testRegister() {
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

        UserDto expect = UserMapper.INSTANCE.toUserDTO(user);

        when(authenticationService.register(r)).thenReturn(user);

        AuthenticationResponseDto result = underTest.register(r);

        Assertions.assertEquals(expect.getName().getFirstName(), result.getUser().getName().getFirstName());
        Assertions.assertEquals(expect.getName().getLastName(), result.getUser().getName().getLastName());
        Assertions.assertEquals(expect.getEmail(), result.getUser().getEmail());
        Assertions.assertEquals(expect.getId(), result.getUser().getId());
        Assertions.assertEquals(expect.getGender(), result.getUser().getGender());
    }


}