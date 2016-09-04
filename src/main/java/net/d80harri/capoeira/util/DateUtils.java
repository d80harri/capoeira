package net.d80harri.capoeira.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by d80harri on 04.09.16.
 */
public class DateUtils {

    public static Date now() {
        return new Date();
    }

    public static Date add(Date date, long value, TemporalUnit unit) {
        LocalDateTime local = LocalDateTime.from(date.toInstant()).plus(value, unit);
        return Date.from(local.toInstant(ZoneOffset.UTC));
    }
}
