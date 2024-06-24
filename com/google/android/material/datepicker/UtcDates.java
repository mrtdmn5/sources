package com.google.android.material.datepicker;

import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class UtcDates {
    public static final AtomicReference<TimeSource> timeSourceRef = new AtomicReference<>();

    public static long canonicalYearMonthDay(long j) {
        Calendar utcCalendarOf = getUtcCalendarOf(null);
        utcCalendarOf.setTimeInMillis(j);
        return getDayCopy(utcCalendarOf).getTimeInMillis();
    }

    public static Calendar getDayCopy(Calendar calendar) {
        Calendar utcCalendarOf = getUtcCalendarOf(calendar);
        Calendar utcCalendarOf2 = getUtcCalendarOf(null);
        utcCalendarOf2.set(utcCalendarOf.get(1), utcCalendarOf.get(2), utcCalendarOf.get(5));
        return utcCalendarOf2;
    }

    public static Calendar getTodayCalendar() {
        Calendar calendar;
        TimeSource timeSource = timeSourceRef.get();
        if (timeSource == null) {
            timeSource = TimeSource.SYSTEM_TIME_SOURCE;
        }
        TimeZone timeZone = timeSource.fixedTimeZone;
        if (timeZone == null) {
            calendar = Calendar.getInstance();
        } else {
            calendar = Calendar.getInstance(timeZone);
        }
        Long l = timeSource.fixedTimeMs;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return calendar;
    }

    public static Calendar getUtcCalendarOf(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }
}
