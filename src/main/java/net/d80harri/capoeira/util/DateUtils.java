package net.d80harri.capoeira.util;

import java.time.LocalDate;
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

    public static Date addDays(Date date, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, value);
        return calendar.getTime();
    }
}
