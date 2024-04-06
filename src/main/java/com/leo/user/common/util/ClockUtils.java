package com.leo.user.common.util;

import lombok.experimental.UtilityClass;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

@UtilityClass
public class ClockUtils {
    private static Clock systemClock = Clock.systemUTC();
    private static Clock defaultClock = Clock.systemUTC();

    public static Instant getCurrent() {
        return Instant.now(systemClock);
    }

    public static Date current() {
        return Date.from(Instant.now(systemClock));
    }

    public static boolean isBefore(Instant instant) {
        return instant.isBefore(getCurrent());
    }

    public static boolean isAfter(Instant instant) {
        return instant.isAfter(getCurrent());
    }

    public static boolean isNow(Instant instant) {
        return instant.equals(getCurrent());
    }

    public static void setClock(Clock clock) {
        systemClock = clock;
    }

    public static void resetClock() {
        systemClock = defaultClock;
    }
}
