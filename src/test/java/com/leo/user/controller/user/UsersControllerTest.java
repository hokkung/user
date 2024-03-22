package com.leo.user.controller.user;

import com.leo.user.entity.user.User;
import com.leo.user.model.user.UserDTO;
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
        User u = UserUtils.createUser("f", "l", "e", 1);

        List<User> users = new ArrayList<>();
        users.add(u);

        List<UserDTO> expect = new ArrayList<>();
        expect.add(new UserDTO(1, "f", "l", "e"));

        when(mockUserservice.getUsers()).thenReturn(users);

        List<UserDTO> actual = underTest.getUsers();

        Assertions.assertEquals(actual.size(), 1);
    }
}