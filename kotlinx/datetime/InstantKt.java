package kotlinx.datetime;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.internal.DivRemResult;
import kotlinx.datetime.internal.MathKt;

/* compiled from: Instant.kt */
/* loaded from: classes4.dex */
public final class InstantKt {
    public static final int daysUntil(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        DateTimeUnit.Companion.getClass();
        return MathKt.clampToInt(InstantJvmKt.until(instant, other, DateTimeUnit.DAY, timeZone));
    }

    public static final Instant minus(Instant instant, DateTimePeriod dateTimePeriod, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        if (dateTimePeriod.getTotalNanoseconds$kotlinx_datetime() != Long.MIN_VALUE) {
            return InstantJvmKt.plus(instant, DateTimePeriodKt.buildDateTimePeriod(-dateTimePeriod.getTotalNanoseconds$kotlinx_datetime(), -dateTimePeriod.getTotalMonths$kotlinx_datetime(), -dateTimePeriod.getDays()), timeZone);
        }
        Instant plus = InstantJvmKt.plus(instant, DateTimePeriodKt.buildDateTimePeriod(-(dateTimePeriod.getTotalNanoseconds$kotlinx_datetime() + 1), -dateTimePeriod.getTotalMonths$kotlinx_datetime(), -dateTimePeriod.getDays()), timeZone);
        DateTimeUnit.Companion.getClass();
        DateTimeUnit.TimeBased unit = DateTimeUnit.NANOSECOND;
        Intrinsics.checkNotNullParameter(unit, "unit");
        return InstantJvmKt.plus(plus, 1L, unit);
    }

    public static final long until(Instant instant, Instant other, DateTimeUnit.TimeBased unit) {
        long j;
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            long epochSeconds = other.getEpochSeconds() - instant.getEpochSeconds();
            long nano = other.value.getNano() - instant.value.getNano();
            long j2 = unit.nanoseconds;
            if (epochSeconds > 0 && nano < 0) {
                epochSeconds--;
                nano += 1000000000;
            } else if (epochSeconds < 0 && nano > 0) {
                epochSeconds++;
                nano -= 1000000000;
            }
            if (epochSeconds == 0) {
                return nano / j2;
            }
            DivRemResult multiplyAndDivide = MathKt.multiplyAndDivide(epochSeconds, 1000000000L, j2);
            return Math.addExact(multiplyAndDivide.q, Math.addExact(nano / j2, Math.addExact(nano % j2, multiplyAndDivide.r) / j2));
        } catch (ArithmeticException unused) {
            if (instant.compareTo(other) < 0) {
                j = Long.MAX_VALUE;
            } else {
                j = Long.MIN_VALUE;
            }
            return j;
        }
    }

    public static final int yearsUntil(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        DateTimeUnit.Companion.getClass();
        return MathKt.clampToInt(InstantJvmKt.until(instant, other, DateTimeUnit.YEAR, timeZone));
    }
}
