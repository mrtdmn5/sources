package com.animaconnected.watch.fitness;

import com.animaconnected.info.DateTimeUtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.datetime.DateTimePeriodKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.InstantJvmKt;
import kotlinx.datetime.InstantKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: TimePeriod.kt */
/* loaded from: classes3.dex */
public final class TimePeriod {
    public static final Companion Companion = new Companion(null);
    private final long duration;
    private final long durationMs;
    private final Instant end;
    private final long endTs;
    private final Instant start;
    private final long startTs;

    /* compiled from: TimePeriod.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ TimePeriod day$default(Companion companion, Instant instant, TimeZone timeZone, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                instant = DateTimeUtilsKt.now();
            }
            if ((r3 & 2) != 0) {
                TimeZone.Companion.getClass();
                timeZone = TimeZone.Companion.currentSystemDefault();
            }
            return companion.day(instant, timeZone);
        }

        public static /* synthetic */ TimePeriod lastMonth$default(Companion companion, Instant instant, TimeZone timeZone, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                instant = DateTimeUtilsKt.now();
            }
            if ((r3 & 2) != 0) {
                TimeZone.Companion.getClass();
                timeZone = TimeZone.Companion.currentSystemDefault();
            }
            return companion.lastMonth(instant, timeZone);
        }

        public static /* synthetic */ TimePeriod lastWeek$default(Companion companion, Instant instant, TimeZone timeZone, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                instant = DateTimeUtilsKt.now();
            }
            if ((r3 & 2) != 0) {
                TimeZone.Companion.getClass();
                timeZone = TimeZone.Companion.currentSystemDefault();
            }
            return companion.lastWeek(instant, timeZone);
        }

        public static /* synthetic */ TimePeriod lastYear$default(Companion companion, Instant instant, TimeZone timeZone, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                instant = DateTimeUtilsKt.now();
            }
            if ((r3 & 2) != 0) {
                TimeZone.Companion.getClass();
                timeZone = TimeZone.Companion.currentSystemDefault();
            }
            return companion.lastYear(instant, timeZone);
        }

        public static /* synthetic */ TimePeriod month$default(Companion companion, Instant instant, TimeZone timeZone, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                instant = DateTimeUtilsKt.now();
            }
            if ((r3 & 2) != 0) {
                TimeZone.Companion.getClass();
                timeZone = TimeZone.Companion.currentSystemDefault();
            }
            return companion.month(instant, timeZone);
        }

        public static /* synthetic */ TimePeriod week$default(Companion companion, Instant instant, TimeZone timeZone, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                instant = DateTimeUtilsKt.now();
            }
            if ((r3 & 2) != 0) {
                TimeZone.Companion.getClass();
                timeZone = TimeZone.Companion.currentSystemDefault();
            }
            return companion.week(instant, timeZone);
        }

        public static /* synthetic */ TimePeriod year$default(Companion companion, Instant instant, TimeZone timeZone, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                instant = DateTimeUtilsKt.now();
            }
            if ((r3 & 2) != 0) {
                TimeZone.Companion.getClass();
                timeZone = TimeZone.Companion.currentSystemDefault();
            }
            return companion.year(instant, timeZone);
        }

        public final TimePeriod day(long j) {
            Instant.Companion.getClass();
            return day$default(this, Instant.Companion.fromEpochMilliseconds(j), null, 2, null);
        }

        public final TimePeriod lastMonth(Instant instant, TimeZone timeZone) {
            Intrinsics.checkNotNullParameter(instant, "instant");
            Intrinsics.checkNotNullParameter(timeZone, "timeZone");
            Instant startOfDay = DateTimeUtilsKt.getStartOfDay(instant, timeZone);
            return new TimePeriod(InstantKt.minus(startOfDay, DateTimePeriodKt.DateTimePeriod$default(0, 30, 0, 123), timeZone), InstantJvmKt.plus(startOfDay, DateTimePeriodKt.DateTimePeriod$default(0, 1, 0, 123), timeZone));
        }

        public final TimePeriod lastWeek(Instant instant, TimeZone timeZone) {
            Intrinsics.checkNotNullParameter(instant, "instant");
            Intrinsics.checkNotNullParameter(timeZone, "timeZone");
            Instant startOfDay = DateTimeUtilsKt.getStartOfDay(instant, timeZone);
            return new TimePeriod(InstantKt.minus(startOfDay, DateTimePeriodKt.DateTimePeriod$default(0, 6, 0, 123), timeZone), InstantJvmKt.plus(startOfDay, DateTimePeriodKt.DateTimePeriod$default(0, 1, 0, 123), timeZone));
        }

        public final TimePeriod lastYear(Instant instant, TimeZone timeZone) {
            Intrinsics.checkNotNullParameter(instant, "instant");
            Intrinsics.checkNotNullParameter(timeZone, "timeZone");
            Instant plus = InstantJvmKt.plus(DateTimeUtilsKt.getStartOfDay(instant, timeZone), DateTimePeriodKt.DateTimePeriod$default(0, 1, 0, 123), timeZone);
            return new TimePeriod(InstantKt.minus(plus, DateTimePeriodKt.DateTimePeriod$default(1, 0, 0, 126), timeZone), plus);
        }

        public final TimePeriod month(Instant instant, TimeZone timeZone) {
            Intrinsics.checkNotNullParameter(instant, "instant");
            Intrinsics.checkNotNullParameter(timeZone, "timeZone");
            LocalDateTime atStartOfMonth = DateTimeUtilsKt.atStartOfMonth(DateTimeUtilsKt.getLocalDateTime(instant, timeZone));
            return new TimePeriod(atStartOfMonth, DateTimeUtilsKt.plusMonth(atStartOfMonth, timeZone), timeZone);
        }

        public final TimePeriod none() {
            Instant.Companion companion = Instant.Companion;
            companion.getClass();
            Instant instant = Instant.DISTANT_PAST;
            companion.getClass();
            return new TimePeriod(instant, Instant.DISTANT_FUTURE);
        }

        public final TimePeriod relevant() {
            return new TimePeriod(DateTimeUtilsKt.relevantInstant$default(0L, 1, null), DateTimeUtilsKt.plusYear$default(DateTimeUtilsKt.now(), (TimeZone) null, 1, (Object) null));
        }

        public final TimePeriod week(Instant instant, TimeZone timeZone) {
            Intrinsics.checkNotNullParameter(instant, "instant");
            Intrinsics.checkNotNullParameter(timeZone, "timeZone");
            LocalDateTime atStartOfWeek = DateTimeUtilsKt.atStartOfWeek(DateTimeUtilsKt.getLocalDateTime(instant, timeZone), timeZone);
            return new TimePeriod(atStartOfWeek, DateTimeUtilsKt.plusWeek(atStartOfWeek, timeZone), timeZone);
        }

        public final TimePeriod year(Instant instant, TimeZone timeZone) {
            Intrinsics.checkNotNullParameter(instant, "instant");
            Intrinsics.checkNotNullParameter(timeZone, "timeZone");
            LocalDateTime atStartOfYear = DateTimeUtilsKt.atStartOfYear(DateTimeUtilsKt.getLocalDateTime(instant, timeZone));
            return new TimePeriod(atStartOfYear, DateTimeUtilsKt.plusYear(atStartOfYear, timeZone), timeZone);
        }

        private Companion() {
        }

        public final TimePeriod day(Instant instant, TimeZone timeZone) {
            Intrinsics.checkNotNullParameter(instant, "instant");
            Intrinsics.checkNotNullParameter(timeZone, "timeZone");
            Instant atStartOfDay = DateTimeUtilsKt.atStartOfDay(DateTimeUtilsKt.getLocalDateTime(instant, timeZone), timeZone);
            return new TimePeriod(atStartOfDay, InstantJvmKt.plus(atStartOfDay, DateTimePeriodKt.DateTimePeriod$default(0, 1, 0, 123), timeZone));
        }
    }

    public TimePeriod(Instant start, Instant end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        this.start = start;
        this.end = end;
        this.startTs = start.toEpochMilliseconds();
        this.endTs = end.toEpochMilliseconds();
        long m1704minus5sfh64U = end.m1704minus5sfh64U(start);
        this.duration = m1704minus5sfh64U;
        this.durationMs = Duration.m1677getInWholeMillisecondsimpl(m1704minus5sfh64U);
    }

    public static /* synthetic */ TimePeriod copy$default(TimePeriod timePeriod, Instant instant, Instant instant2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            instant = timePeriod.start;
        }
        if ((r3 & 2) != 0) {
            instant2 = timePeriod.end;
        }
        return timePeriod.copy(instant, instant2);
    }

    public final Instant component1() {
        return this.start;
    }

    public final Instant component2() {
        return this.end;
    }

    public final boolean contains(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        Instant instant2 = this.start;
        if (instant.compareTo(this.end) > 0 || instant.compareTo(instant2) < 0) {
            return false;
        }
        return true;
    }

    public final TimePeriod copy(Instant start, Instant end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return new TimePeriod(start, end);
    }

    public boolean equals(Object obj) {
        if (obj instanceof TimePeriod) {
            TimePeriod timePeriod = (TimePeriod) obj;
            if (Intrinsics.areEqual(this.start, timePeriod.start) && Intrinsics.areEqual(this.end, timePeriod.end)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: getDuration-UwyO8pc, reason: not valid java name */
    public final long m1505getDurationUwyO8pc() {
        return this.duration;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final Instant getEnd() {
        return this.end;
    }

    public final long getEndTs() {
        return this.endTs;
    }

    public final Instant getStart() {
        return this.start;
    }

    public final long getStartTs() {
        return this.startTs;
    }

    public int hashCode() {
        return this.end.hashCode() + (this.start.hashCode() * 31);
    }

    public String toString() {
        return "TimePeriod(start=" + this.start + ", end=" + this.end + ')';
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public TimePeriod(long j, long j2) {
        this(Instant.Companion.fromEpochMilliseconds(j), Instant.Companion.fromEpochMilliseconds(j2));
        Instant.Companion.getClass();
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public TimePeriod(LocalDateTime start, LocalDateTime end, TimeZone zone) {
        this(TimeZoneKt.toInstant(start, zone), TimeZoneKt.toInstant(end, zone));
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(zone, "zone");
    }
}
