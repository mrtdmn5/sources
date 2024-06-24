package com.animaconnected.info;

import j$.time.DayOfWeek;
import j$.time.Month;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.InstantJvmKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: DateTimeUtils.kt */
/* loaded from: classes.dex */
public final class DateTimeUtilsKt {
    public static final Month asMonthEnum(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Month month = getLocalDateTime(instant, timeZone).getDate().value.getMonth();
        Intrinsics.checkNotNullExpressionValue(month, "value.month");
        return month;
    }

    public static /* synthetic */ Month asMonthEnum$default(Instant instant, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return asMonthEnum(instant, timeZone);
    }

    public static final Instant atStartOfDay(LocalDateTime localDateTime, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return new Instant(localDateTime.getDate().value.atStartOfDay(timeZone.zoneId).toInstant());
    }

    public static /* synthetic */ Instant atStartOfDay$default(LocalDateTime localDateTime, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return atStartOfDay(localDateTime, timeZone);
    }

    public static final LocalDateTime atStartOfMonth(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        return new LocalDateTime(localDateTime.getYear(), localDateTime.getMonth(), 1, 0, 0, 0, 0);
    }

    public static final LocalDateTime atStartOfWeek(LocalDateTime localDateTime, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        LocalDateTime localDateTime2 = new LocalDateTime(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), 0, 0, 0, 0);
        DayOfWeek dayOfWeek = localDateTime.value.getDayOfWeek();
        Intrinsics.checkNotNullExpressionValue(dayOfWeek, "value.dayOfWeek");
        List<DayOfWeek> list = DayOfWeekKt.allDaysOfWeek;
        int ordinal = dayOfWeek.ordinal() + 1;
        DayOfWeek dayOfWeek2 = DayOfWeek.MONDAY;
        Intrinsics.checkNotNullParameter(dayOfWeek2, "<this>");
        int ordinal2 = ordinal - (dayOfWeek2.ordinal() + 1);
        DateTimeUnit.Companion.getClass();
        return minus(localDateTime2, ordinal2, DateTimeUnit.DAY, timeZone);
    }

    public static final LocalDateTime atStartOfYear(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        return new LocalDateTime(localDateTime.getYear(), Month.JANUARY, 1, 0, 0, 0, 0);
    }

    public static final LocalDateTime copy(LocalDateTime localDateTime, int r9, Month month, int r11, int r12, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(month, "month");
        return new LocalDateTime(r9, month, r11, r12, r13, r14, r15);
    }

    public static LocalDateTime copy$default(LocalDateTime localDateTime, int r6, Month month, int r8, int r9, int r10, int r11, int r12, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            r6 = localDateTime.getYear();
        }
        if ((r13 & 2) != 0) {
            month = localDateTime.getMonth();
        }
        Month month2 = month;
        if ((r13 & 4) != 0) {
            r8 = localDateTime.getDayOfMonth();
        }
        int r0 = r8;
        if ((r13 & 8) != 0) {
            r9 = localDateTime.getHour();
        }
        int r1 = r9;
        if ((r13 & 16) != 0) {
            r10 = localDateTime.getMinute();
        }
        int r2 = r10;
        if ((r13 & 32) != 0) {
            r11 = localDateTime.value.getSecond();
        }
        int r3 = r11;
        if ((r13 & 64) != 0) {
            r12 = localDateTime.value.getNano();
        }
        return copy(localDateTime, r6, month2, r0, r1, r2, r3, r12);
    }

    public static final long currentTimeMillis() {
        return now().toEpochMilliseconds();
    }

    public static final long getCurrentTimezoneOffsetToUTCInMinutes(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        int r0 = Duration.$r8$clinit;
        TimeZone.Companion.getClass();
        return -Duration.m1678getInWholeMinutesimpl(DurationKt.toDuration(TimeZoneKt.offsetAt(instant, TimeZone.Companion.currentSystemDefault()).zoneOffset.getTotalSeconds(), DurationUnit.SECONDS));
    }

    public static /* synthetic */ long getCurrentTimezoneOffsetToUTCInMinutes$default(Instant instant, int r1, Object obj) {
        if ((r1 & 1) != 0) {
            instant = now();
        }
        return getCurrentTimezoneOffsetToUTCInMinutes(instant);
    }

    public static final LocalDateTime getLocalDateTime(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return TimeZoneKt.toLocalDateTime(instant, timeZone);
    }

    public static /* synthetic */ LocalDateTime getLocalDateTime$default(Instant instant, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            instant = now();
        }
        if ((r2 & 2) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return getLocalDateTime(instant, timeZone);
    }

    public static final Instant getStartOfDay(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return atStartOfDay$default(getLocalDateTime(instant, timeZone), null, 1, null);
    }

    public static /* synthetic */ Instant getStartOfDay$default(Instant instant, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            instant = now();
        }
        if ((r2 & 2) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return getStartOfDay(instant, timeZone);
    }

    public static final long getStartOfDayEpochMillis(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return getStartOfDay$default(instant, null, 2, null).toEpochMilliseconds();
    }

    public static /* synthetic */ long getStartOfDayEpochMillis$default(Instant instant, int r1, Object obj) {
        if ((r1 & 1) != 0) {
            instant = now();
        }
        return getStartOfDayEpochMillis(instant);
    }

    public static final Instant max(Instant instant, Instant other) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (instant.compareTo(other) < 0) {
            return other;
        }
        return instant;
    }

    /* renamed from: max-QTBD994 */
    public static final long m750maxQTBD994(long j, long j2) {
        if (Duration.m1672compareToLRDsOJo(j, j2) < 0) {
            return j2;
        }
        return j;
    }

    public static final Instant min(Instant instant, Instant other) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (instant.compareTo(other) >= 0) {
            return other;
        }
        return instant;
    }

    /* renamed from: min-QTBD994 */
    public static final long m751minQTBD994(long j, long j2) {
        if (Duration.m1672compareToLRDsOJo(j, j2) >= 0) {
            return j2;
        }
        return j;
    }

    public static final LocalDateTime minus(LocalDateTime localDateTime, int r2, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return TimeZoneKt.toLocalDateTime(InstantJvmKt.minus(TimeZoneKt.toInstant(localDateTime, timeZone), r2, unit, timeZone), timeZone);
    }

    public static final Instant minusMonth(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        DateTimeUnit.Companion.getClass();
        return InstantJvmKt.minus(instant, 1, DateTimeUnit.MONTH, timeZone);
    }

    public static /* synthetic */ Instant minusMonth$default(Instant instant, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return minusMonth(instant, timeZone);
    }

    public static final Instant minusWeek(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        DateTimeUnit.Companion.getClass();
        return InstantJvmKt.minus(instant, 1, DateTimeUnit.WEEK, timeZone);
    }

    public static /* synthetic */ Instant minusWeek$default(Instant instant, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return minusWeek(instant, timeZone);
    }

    public static final Instant minusYear(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        DateTimeUnit.Companion.getClass();
        return InstantJvmKt.minus(instant, 1, DateTimeUnit.YEAR, timeZone);
    }

    public static /* synthetic */ Instant minusYear$default(Instant instant, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return minusYear(instant, timeZone);
    }

    public static final Instant now() {
        Instant.Companion.getClass();
        return new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
    }

    public static final LocalDateTime plus(LocalDateTime localDateTime, int r2, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return TimeZoneKt.toLocalDateTime(InstantJvmKt.plus(TimeZoneKt.toInstant(localDateTime, timeZone), r2, unit, timeZone), timeZone);
    }

    public static final Instant plusMonth(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        DateTimeUnit.Companion.getClass();
        return InstantJvmKt.plus(instant, 1, (DateTimeUnit) DateTimeUnit.MONTH, timeZone);
    }

    public static /* synthetic */ Instant plusMonth$default(Instant instant, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return plusMonth(instant, timeZone);
    }

    public static final Instant plusWeek(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        DateTimeUnit.Companion.getClass();
        return InstantJvmKt.plus(instant, 1, (DateTimeUnit) DateTimeUnit.WEEK, timeZone);
    }

    public static /* synthetic */ Instant plusWeek$default(Instant instant, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return plusWeek(instant, timeZone);
    }

    public static final Instant plusYear(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        DateTimeUnit.Companion.getClass();
        return InstantJvmKt.plus(instant, 1, (DateTimeUnit) DateTimeUnit.YEAR, timeZone);
    }

    public static /* synthetic */ Instant plusYear$default(Instant instant, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return plusYear(instant, timeZone);
    }

    public static final Instant relevantInstant(long j) {
        if (j == -1) {
            Instant.Companion.getClass();
            return Instant.Companion.parse("2021-01-01T00:00:00.000Z");
        }
        Instant.Companion.getClass();
        return Instant.Companion.fromEpochMilliseconds(j);
    }

    public static /* synthetic */ Instant relevantInstant$default(long j, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            j = -1;
        }
        return relevantInstant(j);
    }

    public static final boolean sameDay(Instant instant, Instant instant2, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(instant2, "instant");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return Intrinsics.areEqual(getStartOfDay(instant, timeZone), getStartOfDay(instant2, timeZone));
    }

    public static /* synthetic */ boolean sameDay$default(Instant instant, Instant instant2, TimeZone timeZone, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return sameDay(instant, instant2, timeZone);
    }

    public static final boolean sameMonth(Instant instant, Instant instant2, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(instant2, "instant");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        if (TimeZoneKt.toLocalDateTime(instant, timeZone).getMonth() == TimeZoneKt.toLocalDateTime(instant2, timeZone).getMonth()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean sameMonth$default(Instant instant, Instant instant2, TimeZone timeZone, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return sameMonth(instant, instant2, timeZone);
    }

    public static final boolean sameYear(Instant instant, Instant instant2, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(instant2, "instant");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        if (TimeZoneKt.toLocalDateTime(instant, timeZone).getYear() == TimeZoneKt.toLocalDateTime(instant2, timeZone).getYear()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean sameYear$default(Instant instant, Instant instant2, TimeZone timeZone, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return sameYear(instant, instant2, timeZone);
    }

    public static final int toWatchSeconds(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        TimeZone.Companion.getClass();
        return ((int) instant.getEpochSeconds()) + TimeZoneKt.offsetAt(instant, TimeZone.Companion.currentSystemDefault()).zoneOffset.getTotalSeconds();
    }

    public static /* synthetic */ LocalDateTime plusMonth$default(LocalDateTime localDateTime, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return plusMonth(localDateTime, timeZone);
    }

    public static /* synthetic */ LocalDateTime plusWeek$default(LocalDateTime localDateTime, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return plusWeek(localDateTime, timeZone);
    }

    public static /* synthetic */ LocalDateTime plusYear$default(LocalDateTime localDateTime, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return plusYear(localDateTime, timeZone);
    }

    public static final LocalDateTime plusMonth(LocalDateTime localDateTime, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        DateTimeUnit.Companion.getClass();
        return plus(localDateTime, 1, DateTimeUnit.MONTH, timeZone);
    }

    public static final LocalDateTime plusWeek(LocalDateTime localDateTime, TimeZone timezone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(timezone, "timezone");
        DateTimeUnit.Companion.getClass();
        return plus(localDateTime, 1, DateTimeUnit.WEEK, timezone);
    }

    public static final LocalDateTime plusYear(LocalDateTime localDateTime, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        DateTimeUnit.Companion.getClass();
        return plus(localDateTime, 1, DateTimeUnit.YEAR, timeZone);
    }
}
