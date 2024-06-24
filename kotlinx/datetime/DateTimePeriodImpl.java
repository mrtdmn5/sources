package kotlinx.datetime;

/* compiled from: DateTimePeriod.kt */
/* loaded from: classes4.dex */
public final class DateTimePeriodImpl extends DateTimePeriod {
    public final int days;
    public final int totalMonths;
    public final long totalNanoseconds;

    public DateTimePeriodImpl(long j, int r3, int r4) {
        this.totalMonths = r3;
        this.days = r4;
        this.totalNanoseconds = j;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int getDays() {
        return this.days;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int getTotalMonths$kotlinx_datetime() {
        return this.totalMonths;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final long getTotalNanoseconds$kotlinx_datetime() {
        return this.totalNanoseconds;
    }
}
