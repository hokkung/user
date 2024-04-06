package com.leo.user.common.util;

import lombok.experimental.UtilityClass;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

@UtilityClass
public class ClockUtils {
    private static final Clock SYSTEM_CLOCK = Clock.systemUTC();
    public static Instant getCurrent() {
        return Instant.now(SYSTEM_CLOCK);
    }

    public static Date current() {
        return Date.from(Instant.now(SYSTEM_CLOCK));
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
}
