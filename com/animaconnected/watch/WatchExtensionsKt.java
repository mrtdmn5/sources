package com.animaconnected.watch;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.device.IOException;
import com.animaconnected.watch.device.WatchTime;
import j$.time.DayOfWeek;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: WatchExtensions.kt */
/* loaded from: classes3.dex */
public final class WatchExtensionsKt {

    /* compiled from: WatchExtensions.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[DayOfWeek.values().length];
            try {
                r0[DayOfWeek.MONDAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[DayOfWeek.TUESDAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[DayOfWeek.WEDNESDAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[DayOfWeek.THURSDAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[DayOfWeek.FRIDAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[DayOfWeek.SATURDAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r0[DayOfWeek.SUNDAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final Instant asInstant(WatchTime watchTime) {
        Intrinsics.checkNotNullParameter(watchTime, "<this>");
        LocalDateTime localDateTime = new LocalDateTime(watchTime.getYear(), watchTime.getMonth(), watchTime.getDayOfMonth(), watchTime.getHour(), watchTime.getMinute(), watchTime.getSecond(), 64, 0);
        TimeZone.Companion.getClass();
        return TimeZoneKt.toInstant(localDateTime, TimeZone.Companion.currentSystemDefault());
    }

    public static final WatchTime asWatchTime(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        TimeZone.Companion.getClass();
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(instant, TimeZone.Companion.currentSystemDefault());
        int year = localDateTime.getYear();
        j$.time.LocalDateTime localDateTime2 = localDateTime.value;
        int monthValue = localDateTime2.getMonthValue();
        int dayOfMonth = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime2.getSecond();
        DayOfWeek dayOfWeek = localDateTime2.getDayOfWeek();
        Intrinsics.checkNotNullExpressionValue(dayOfWeek, "value.dayOfWeek");
        int deviceDayOfWeek = getDeviceDayOfWeek(dayOfWeek);
        int r11 = Duration.$r8$clinit;
        return new WatchTime(year, monthValue, dayOfMonth, hour, minute, second, deviceDayOfWeek, new Duration(DurationKt.toDuration(DateTimeUtilsKt.getCurrentTimezoneOffsetToUTCInMinutes$default(null, 1, null), DurationUnit.MILLISECONDS)), null);
    }

    private static final int getDeviceDayOfWeek(DayOfWeek dayOfWeek) {
        switch (WhenMappings.$EnumSwitchMapping$0[dayOfWeek.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            default:
                throw new IOException("Not a valid day of week");
        }
    }
}
