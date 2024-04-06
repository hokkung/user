package com.leo.user.common.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClockUtilsTest {

    @AfterEach
    void tearDown() {
        ClockUtils.resetClock();
    }

    @Test
    void getCurrent() {
        Clock fixedClock = Clock.fixed(Instant.parse("2024-04-01T12:00:00Z"), ZoneId.systemDefault());
        ClockUtils.setClock(fixedClock);

        Instant currentInstant = ClockUtils.getCurrent();

        assertEquals(Instant.parse("2024-04-01T12:00:00Z"), currentInstant);
    }

    @Test
    void current() {
        Clock fixedClock = Clock.fixed(Instant.parse("2024-04-01T12:00:00Z"), ZoneId.systemDefault());
        ClockUtils.setClock(fixedClock);

        Date currentDate = ClockUtils.current();

        assertEquals(Date.from(Instant.parse("2024-04-01T12:00:00Z")), currentDate);
    }

    @Test
    void isBefore() {
        Clock fixedClock = Clock.fixed(Instant.parse("2024-04-01T12:00:00Z"), ZoneId.systemDefault());
        ClockUtils.setClock(fixedClock);

        boolean result = ClockUtils.isBefore(Instant.parse("2024-04-01T11:00:00Z"));

        assertTrue(result);
    }

    @Test
    void isAfter() {
        Clock fixedClock = Clock.fixed(Instant.parse("2024-04-01T12:00:00Z"), ZoneId.systemDefault());
        ClockUtils.setClock(fixedClock);

        boolean result = ClockUtils.isAfter(Instant.parse("2024-04-01T13:00:00Z"));

        assertTrue(result);
    }

    @Test
    void isNow() {
        Clock fixedClock = Clock.fixed(Instant.parse("2024-04-01T12:00:00Z"), ZoneId.systemDefault());
        ClockUtils.setClock(fixedClock);

        boolean result = ClockUtils.isNow(Instant.parse("2024-04-01T12:00:00Z"));

        assertTrue(result);
    }
}
