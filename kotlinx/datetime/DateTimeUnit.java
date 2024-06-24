package kotlinx.datetime;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.DateBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.DateTimeUnitSerializer;
import kotlinx.datetime.serializers.DayBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.MonthBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.TimeBasedDateTimeUnitSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: DateTimeUnit.kt */
@Serializable(with = DateTimeUnitSerializer.class)
/* loaded from: classes4.dex */
public abstract class DateTimeUnit {
    public static final Companion Companion = new Companion();
    public static final DayBased DAY;
    public static final TimeBased HOUR;
    public static final MonthBased MONTH;
    public static final TimeBased NANOSECOND;
    public static final DayBased WEEK;
    public static final MonthBased YEAR;

    /* compiled from: DateTimeUnit.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public final KSerializer<DateTimeUnit> serializer() {
            return DateTimeUnitSerializer.INSTANCE;
        }
    }

    /* compiled from: DateTimeUnit.kt */
    @Serializable(with = DateBasedDateTimeUnitSerializer.class)
    /* loaded from: classes4.dex */
    public static abstract class DateBased extends DateTimeUnit {
        public static final Companion Companion = new Companion();

        /* compiled from: DateTimeUnit.kt */
        /* loaded from: classes4.dex */
        public static final class Companion {
            public final KSerializer<DateBased> serializer() {
                return DateBasedDateTimeUnitSerializer.INSTANCE;
            }
        }
    }

    /* compiled from: DateTimeUnit.kt */
    @Serializable(with = DayBasedDateTimeUnitSerializer.class)
    /* loaded from: classes4.dex */
    public static final class DayBased extends DateBased {
        public static final Companion Companion = new Companion();
        public final int days;

        /* compiled from: DateTimeUnit.kt */
        /* loaded from: classes4.dex */
        public static final class Companion {
            public final KSerializer<DayBased> serializer() {
                return DayBasedDateTimeUnitSerializer.INSTANCE;
            }
        }

        public DayBased(int r3) {
            boolean z;
            this.days = r3;
            if (r3 > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
            } else {
                throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Unit duration must be positive, but was ", r3, " days.").toString());
            }
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof DayBased) {
                    if (this.days == ((DayBased) obj).days) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.days ^ 65536;
        }

        public final String toString() {
            int r0 = this.days;
            if (r0 % 7 == 0) {
                return DateTimeUnit.formatToString(r0 / 7, "WEEK");
            }
            return DateTimeUnit.formatToString(r0, "DAY");
        }
    }

    /* compiled from: DateTimeUnit.kt */
    @Serializable(with = MonthBasedDateTimeUnitSerializer.class)
    /* loaded from: classes4.dex */
    public static final class MonthBased extends DateBased {
        public static final Companion Companion = new Companion();
        public final int months;

        /* compiled from: DateTimeUnit.kt */
        /* loaded from: classes4.dex */
        public static final class Companion {
            public final KSerializer<MonthBased> serializer() {
                return MonthBasedDateTimeUnitSerializer.INSTANCE;
            }
        }

        public MonthBased(int r3) {
            boolean z;
            this.months = r3;
            if (r3 > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
            } else {
                throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Unit duration must be positive, but was ", r3, " months.").toString());
            }
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof MonthBased) {
                    if (this.months == ((MonthBased) obj).months) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.months ^ 131072;
        }

        public final String toString() {
            int r0 = this.months;
            if (r0 % 1200 == 0) {
                return DateTimeUnit.formatToString(r0 / 1200, "CENTURY");
            }
            if (r0 % 12 == 0) {
                return DateTimeUnit.formatToString(r0 / 12, "YEAR");
            }
            if (r0 % 3 == 0) {
                return DateTimeUnit.formatToString(r0 / 3, "QUARTER");
            }
            return DateTimeUnit.formatToString(r0, "MONTH");
        }
    }

    /* compiled from: DateTimeUnit.kt */
    @Serializable(with = TimeBasedDateTimeUnitSerializer.class)
    /* loaded from: classes4.dex */
    public static final class TimeBased extends DateTimeUnit {
        public static final Companion Companion = new Companion();
        public final long nanoseconds;
        public final String unitName;
        public final long unitScale;

        /* compiled from: DateTimeUnit.kt */
        /* loaded from: classes4.dex */
        public static final class Companion {
            public final KSerializer<TimeBased> serializer() {
                return TimeBasedDateTimeUnitSerializer.INSTANCE;
            }
        }

        public TimeBased(long j) {
            boolean z;
            this.nanoseconds = j;
            if (j > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (j % 3600000000000L == 0) {
                    this.unitName = "HOUR";
                    this.unitScale = j / 3600000000000L;
                    return;
                }
                if (j % 60000000000L == 0) {
                    this.unitName = "MINUTE";
                    this.unitScale = j / 60000000000L;
                    return;
                }
                long j2 = 1000000000;
                if (j % j2 == 0) {
                    this.unitName = "SECOND";
                    this.unitScale = j / j2;
                    return;
                }
                long j3 = 1000000;
                if (j % j3 == 0) {
                    this.unitName = "MILLISECOND";
                    this.unitScale = j / j3;
                    return;
                }
                long j4 = 1000;
                if (j % j4 == 0) {
                    this.unitName = "MICROSECOND";
                    this.unitScale = j / j4;
                    return;
                } else {
                    this.unitName = "NANOSECOND";
                    this.unitScale = j;
                    return;
                }
            }
            throw new IllegalArgumentException(("Unit duration must be positive, but was " + j + " ns.").toString());
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof TimeBased) {
                    if (this.nanoseconds == ((TimeBased) obj).nanoseconds) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j = this.nanoseconds;
            return ((int) (j >> 32)) ^ ((int) j);
        }

        public final TimeBased times(int r6) {
            return new TimeBased(Math.multiplyExact(this.nanoseconds, r6));
        }

        public final String toString() {
            String unit = this.unitName;
            Intrinsics.checkNotNullParameter(unit, "unit");
            long j = this.unitScale;
            if (j != 1) {
                return j + '-' + unit;
            }
            return unit;
        }
    }

    static {
        TimeBased timeBased = new TimeBased(1L);
        NANOSECOND = timeBased;
        HOUR = timeBased.times(1000).times(1000).times(1000).times(60).times(60);
        DayBased dayBased = new DayBased(1);
        DAY = dayBased;
        WEEK = new DayBased(Math.multiplyExact(dayBased.days, 7));
        MonthBased monthBased = new MonthBased(1);
        MONTH = monthBased;
        int r0 = monthBased.months;
        new MonthBased(Math.multiplyExact(r0, 3));
        MonthBased monthBased2 = new MonthBased(Math.multiplyExact(r0, 12));
        YEAR = monthBased2;
        new MonthBased(Math.multiplyExact(monthBased2.months, 100));
    }

    public static String formatToString(int r1, String str) {
        if (r1 != 1) {
            return r1 + '-' + str;
        }
        return str;
    }
}
