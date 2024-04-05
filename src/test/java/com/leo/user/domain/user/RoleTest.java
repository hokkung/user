package com.leo.user.domain.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleTest {

    @Test
    void testName() {
        assertEquals("ADMIN", Role.ADMIN.name());
        assertEquals("USER", Role.USER.name());

    }

    @Test
    void testValueOf() {
        assertEquals(Role.ADMIN, Role.valueOf("ADMIN"));
        assertEquals(Role.USER, Role.valueOf("USER"));
    }
}
