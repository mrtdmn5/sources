package com.animaconnected.watch.fitness.sleep;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.SleepHistoryEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: SleepTimePeriod.kt */
/* loaded from: classes3.dex */
public final class SleepTimePeriod {
    public static final Companion Companion = new Companion(null);
    private final Bedtime bedtime;
    private final Instant end;
    private final Instant start;

    /* compiled from: SleepTimePeriod.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SleepTimePeriod fromInstant$default(Companion companion, Instant instant, Bedtime bedtime, Instant instant2, int r4, Object obj) {
            if ((r4 & 4) != 0) {
                instant2 = DateTimeUtilsKt.now();
            }
            return companion.fromInstant(instant, bedtime, instant2);
        }

        public final SleepTimePeriod fromInstant(Instant instant, Bedtime bedtime, Instant now) {
            Instant m1706plusLRDsOJo;
            Intrinsics.checkNotNullParameter(instant, "instant");
            Intrinsics.checkNotNullParameter(bedtime, "bedtime");
            Intrinsics.checkNotNullParameter(now, "now");
            TimeZone.Companion.getClass();
            boolean z = true;
            if (TimeZoneKt.toLocalDateTime(instant, TimeZone.Companion.currentSystemDefault()).getHour() >= bedtime.getHour()) {
                Instant startOfDay$default = DateTimeUtilsKt.getStartOfDay$default(instant, null, 2, null);
                int r0 = Duration.$r8$clinit;
                m1706plusLRDsOJo = startOfDay$default.m1706plusLRDsOJo(DurationKt.toDuration(bedtime.getHour(), DurationUnit.HOURS)).m1706plusLRDsOJo(DurationKt.toDuration(bedtime.getMinute(), DurationUnit.MINUTES));
            } else {
                Instant startOfDay$default2 = DateTimeUtilsKt.getStartOfDay$default(instant, null, 2, null);
                int r02 = Duration.$r8$clinit;
                m1706plusLRDsOJo = startOfDay$default2.m1705minusLRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS)).m1706plusLRDsOJo(DurationKt.toDuration(bedtime.getHour(), DurationUnit.HOURS)).m1706plusLRDsOJo(DurationKt.toDuration(bedtime.getMinute(), DurationUnit.MINUTES));
            }
            Instant min = SleepTimePeriodKt.min(m1706plusLRDsOJo.m1706plusLRDsOJo(SleepSessionKt.getMaxSleepAmount()), now);
            long minSleepAmount = SleepSessionKt.getMinSleepAmount();
            long maxSleepAmount = SleepSessionKt.getMaxSleepAmount();
            long m1704minus5sfh64U = min.m1704minus5sfh64U(m1706plusLRDsOJo);
            if (new Duration(m1704minus5sfh64U).compareTo(new Duration(minSleepAmount)) < 0 || new Duration(m1704minus5sfh64U).compareTo(new Duration(maxSleepAmount)) > 0) {
                z = false;
            }
            if (!z) {
                return null;
            }
            return new SleepTimePeriod(bedtime, m1706plusLRDsOJo, min);
        }

        public final SleepTimePeriod fromSleepHistoryEntry(SleepHistoryEntry sleepHistoryEntry) {
            Intrinsics.checkNotNullParameter(sleepHistoryEntry, "sleepHistoryEntry");
            Instant.Companion companion = Instant.Companion;
            long timestamp = sleepHistoryEntry.getTimestamp();
            companion.getClass();
            Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(timestamp);
            TimeZone.Companion.getClass();
            LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(fromEpochMilliseconds, TimeZone.Companion.currentSystemDefault());
            return new SleepTimePeriod(new Bedtime(localDateTime.getHour(), localDateTime.getMinute()), fromEpochMilliseconds, Instant.Companion.fromEpochMilliseconds(sleepHistoryEntry.getEnd()));
        }

        private Companion() {
        }
    }

    public SleepTimePeriod(Bedtime bedtime, Instant start, Instant end) {
        Intrinsics.checkNotNullParameter(bedtime, "bedtime");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        this.bedtime = bedtime;
        this.start = start;
        this.end = end;
    }

    public static /* synthetic */ SleepTimePeriod copy$default(SleepTimePeriod sleepTimePeriod, Bedtime bedtime, Instant instant, Instant instant2, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            bedtime = sleepTimePeriod.bedtime;
        }
        if ((r4 & 2) != 0) {
            instant = sleepTimePeriod.start;
        }
        if ((r4 & 4) != 0) {
            instant2 = sleepTimePeriod.end;
        }
        return sleepTimePeriod.copy(bedtime, instant, instant2);
    }

    public final Bedtime component1() {
        return this.bedtime;
    }

    public final Instant component2() {
        return this.start;
    }

    public final Instant component3() {
        return this.end;
    }

    public final SleepTimePeriod copy(Bedtime bedtime, Instant start, Instant end) {
        Intrinsics.checkNotNullParameter(bedtime, "bedtime");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return new SleepTimePeriod(bedtime, start, end);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepTimePeriod)) {
            return false;
        }
        SleepTimePeriod sleepTimePeriod = (SleepTimePeriod) obj;
        if (Intrinsics.areEqual(this.bedtime, sleepTimePeriod.bedtime) && Intrinsics.areEqual(this.start, sleepTimePeriod.start) && Intrinsics.areEqual(this.end, sleepTimePeriod.end)) {
            return true;
        }
        return false;
    }

    public final Bedtime getBedtime() {
        return this.bedtime;
    }

    public final Instant getEnd() {
        return this.end;
    }

    public final Instant getStart() {
        return this.start;
    }

    public int hashCode() {
        return this.end.hashCode() + ((this.start.hashCode() + (this.bedtime.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "SleepTimePeriod(bedtime=" + this.bedtime + ", start=" + this.start + ", end=" + this.end + ')';
    }
}
