package kotlinx.datetime;

import kotlinx.datetime.serializers.DatePeriodIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: DateTimePeriod.kt */
@Serializable(with = DatePeriodIso8601Serializer.class)
/* loaded from: classes4.dex */
public final class DatePeriod extends DateTimePeriod {
    public static final Companion Companion = new Companion();
    public final int days;
    public final int totalMonths;

    /* compiled from: DateTimePeriod.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public final KSerializer<DatePeriod> serializer() {
            return DatePeriodIso8601Serializer.INSTANCE;
        }
    }

    public DatePeriod(int r1, int r2) {
        this.totalMonths = r1;
        this.days = r2;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int getDays() {
        return this.days;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int getHours() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int getMinutes() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int getNanoseconds() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int getSeconds() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int getTotalMonths$kotlinx_datetime() {
        return this.totalMonths;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final long getTotalNanoseconds$kotlinx_datetime() {
        return 0L;
    }

    public DatePeriod() {
        this(DateTimePeriodKt.totalMonths(0, 0), 1);
    }
}
