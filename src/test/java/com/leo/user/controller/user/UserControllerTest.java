package com.leo.user.controller.user;

import com.leo.user.common.exception.EntityNotFoundException;
import com.leo.user.domain.user.User;
import com.leo.user.mapper.user.UserMapper;
import com.leo.user.model.user.UserDTO;
import com.leo.user.service.user.UserCrudServiceImpl;
import com.leo.user.testutil.user.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserControllerTest {

    private UserCrudServiceImpl mockUserCrudService;

    private UserController underTest;

    @BeforeEach
    void setUp() {
        mockUserCrudService = mock(UserCrudServiceImpl.class);

        underTest = new UserController();
        underTest.setUserCrudService(mockUserCrudService);
    }

    @Test
    void testGet() {
        long id = 1;

        User user = UserUtils.create("f", "l", "h@gmail.com", id);
        UserDTO expect = UserMapper.INSTANCE.toUserDTO(user);

        when(mockUserCrudService.get(id)).thenReturn(Optional.of(user));

        UserDTO actual = underTest.get(id);

        assertEquals(expect.getId(), actual.getId());
        assertEquals(expect.getName(), actual.getName());
        assertEquals(expect.getEmail(), actual.getEmail());

    }

    @Test
    void testGetNotFound() {
        long id = 1;

        when(mockUserCrudService.get(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> underTest.get(id));
    }

    @Test
    void create() {
    }

    @Test
    void remove() {
    }

    @Test
    void update() {
    }

    @Test
    void setUserCrudService() {
    }
}