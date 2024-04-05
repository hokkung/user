package com.leo.user.common.util;

import lombok.experimental.UtilityClass;

import java.time.Clock;
import java.util.Date;

@UtilityClass
public class ClockUtils {
    public static Date current() {
        return Date.from(Clock.systemDefaultZone().instant());
    }
}
