package com.leo.user.controller.user;

import com.leo.user.common.domain.Name;
import com.leo.user.domain.user.Gender;
import com.leo.user.domain.user.User;
import com.leo.user.model.audit.AuditDto;
import com.leo.user.model.user.UserDto;
import com.leo.user.service.user.UserService;
import com.leo.user.testutil.user.UserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UsersControllerTest {
    private UsersController underTest;

    private UserService mockUserservice;

    @BeforeEach
    void setUp() {
        underTest = new UsersController();

        mockUserservice = mock(UserService.class);

        underTest.setUserService(mockUserservice);
    }

    @Test
    void getUsers() {
        User u = UserUtils.create("f", "l", "e", 1);

        List<User> users = new ArrayList<>();
        users.add(u);

        List<UserDto> expect = new ArrayList<>();
        Name name = new Name();
        name.setFirstName("f");
        name.setLastName("l");

        expect.add(UserDto.create(1, name, "e", Gender.MALE, new AuditDto()));

        when(mockUserservice.getUsers()).thenReturn(users);

        List<UserDto> actual = underTest.getUsers();

        Assertions.assertEquals(actual.size(), 1);
    }
}