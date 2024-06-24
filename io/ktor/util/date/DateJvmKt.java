package io.ktor.util.date;

import io.ktor.util.date.Month;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateJvm.kt */
/* loaded from: classes3.dex */
public final class DateJvmKt {
    public static final TimeZone GMT_TIMEZONE = DesugarTimeZone.getTimeZone("GMT");

    public static final GMTDate GMTDate(Long l) {
        Calendar calendar = Calendar.getInstance(GMT_TIMEZONE, Locale.ROOT);
        Intrinsics.checkNotNull(calendar);
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        int r2 = calendar.get(13);
        int r3 = calendar.get(12);
        int r4 = calendar.get(11);
        int r1 = ((calendar.get(7) + 7) - 2) % 7;
        WeekDay.Companion.getClass();
        WeekDay weekDay = WeekDay.values()[r1];
        int r6 = calendar.get(5);
        int r7 = calendar.get(6);
        Month.Companion companion = Month.Companion;
        int r5 = calendar.get(2);
        companion.getClass();
        return new GMTDate(r2, r3, r4, weekDay, r6, r7, Month.values()[r5], calendar.get(1), calendar.getTimeInMillis());
    }
}
