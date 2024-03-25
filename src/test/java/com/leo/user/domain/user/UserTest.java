package com.leo.user.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User underTest;

    @BeforeEach
    void setUp() {
        underTest = new User();
    }

    @Test
    void testGet() {
        assertNull(underTest.getId());

        underTest.setId(1L);

        assertEquals(1L, underTest.getId());
    }
}