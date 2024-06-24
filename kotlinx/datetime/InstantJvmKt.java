package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.ZonedDateTime;
import j$.time.temporal.ChronoUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.internal.DivRemResult;
import kotlinx.datetime.internal.MathKt;

/* compiled from: Instant.kt */
/* loaded from: classes4.dex */
public final class InstantJvmKt {
    public static final ZonedDateTime atZone(Instant instant, TimeZone timeZone) {
        try {
            ZonedDateTime atZone = instant.value.atZone(timeZone.zoneId);
            Intrinsics.checkNotNullExpressionValue(atZone, "{\n    value.atZone(zone.zoneId)\n}");
            return atZone;
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final Instant minus(Instant instant, int r3, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return plus(instant, -r3, unit, timeZone);
    }

    public static final Instant plus(Instant instant, long j, DateTimeUnit.TimeBased unit) {
        Instant instant2;
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            DivRemResult multiplyAndDivide = MathKt.multiplyAndDivide(j, unit.nanoseconds, 1000000000L);
            long j2 = multiplyAndDivide.q;
            j$.time.Instant plusNanos = instant.value.plusSeconds(j2).plusNanos(multiplyAndDivide.r);
            Intrinsics.checkNotNullExpressionValue(plusNanos, "this.value.plusSeconds(d).plusNanos(r)");
            return new Instant(plusNanos);
        } catch (Exception e) {
            if (!(e instanceof DateTimeException) && !(e instanceof ArithmeticException)) {
                throw e;
            }
            if (j > 0) {
                Instant.Companion.getClass();
                instant2 = Instant.MAX;
            } else {
                Instant.Companion.getClass();
                instant2 = Instant.MIN;
            }
            return instant2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long until(Instant instant, Instant other, DateTimeUnit.DateBased unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime atZone = atZone(instant, timeZone);
            ZonedDateTime atZone2 = atZone(other, timeZone);
            if (unit instanceof DateTimeUnit.TimeBased) {
                return InstantKt.until(instant, other, (DateTimeUnit.TimeBased) unit);
            }
            if (unit instanceof DateTimeUnit.DayBased) {
                return atZone.until(atZone2, ChronoUnit.DAYS) / ((DateTimeUnit.DayBased) unit).days;
            }
            if (unit instanceof DateTimeUnit.MonthBased) {
                return atZone.until(atZone2, ChronoUnit.MONTHS) / ((DateTimeUnit.MonthBased) unit).months;
            }
            throw new NoWhenBranchMatchedException();
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        } catch (ArithmeticException unused) {
            if (instant.value.compareTo(other.value) < 0) {
                return Long.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
    }

    public static final Instant plus(Instant instant, DateTimePeriod dateTimePeriod, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime atZone = atZone(instant, timeZone);
            if (dateTimePeriod.getTotalMonths$kotlinx_datetime() != 0) {
                atZone = atZone.plusMonths(dateTimePeriod.getTotalMonths$kotlinx_datetime());
            }
            if (dateTimePeriod.getDays() != 0) {
                atZone = atZone.plusDays(dateTimePeriod.getDays());
            }
            if (dateTimePeriod.getTotalNanoseconds$kotlinx_datetime() != 0) {
                atZone = atZone.plusNanos(dateTimePeriod.getTotalNanoseconds$kotlinx_datetime());
            }
            return new Instant(atZone.toInstant());
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final Instant plus(Instant instant, int r3, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return plus(instant, r3, unit, timeZone);
    }

    public static final Instant plus(Instant instant, long j, DateTimeUnit unit, TimeZone timeZone) {
        j$.time.Instant instant2;
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime atZone = atZone(instant, timeZone);
            if (unit instanceof DateTimeUnit.TimeBased) {
                instant2 = plus(instant, j, (DateTimeUnit.TimeBased) unit).value;
                instant2.atZone(timeZone.zoneId);
            } else if (unit instanceof DateTimeUnit.DayBased) {
                instant2 = atZone.plusDays(Math.multiplyExact(j, ((DateTimeUnit.DayBased) unit).days)).toInstant();
            } else if (unit instanceof DateTimeUnit.MonthBased) {
                instant2 = atZone.plusMonths(Math.multiplyExact(j, ((DateTimeUnit.MonthBased) unit).months)).toInstant();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new Instant(instant2);
        } catch (Exception e) {
            if (!(e instanceof DateTimeException) && !(e instanceof ArithmeticException)) {
                throw e;
            }
            throw new DateTimeArithmeticException("Instant " + instant + " cannot be represented as local date when adding " + j + ' ' + unit + " to it", e);
        }
    }
}
