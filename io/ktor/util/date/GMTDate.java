package io.ktor.util.date;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Date.kt */
/* loaded from: classes3.dex */
public final class GMTDate implements Comparable<GMTDate> {
    public final int dayOfMonth;
    public final WeekDay dayOfWeek;
    public final int dayOfYear;
    public final int hours;
    public final int minutes;
    public final Month month;
    public final int seconds;
    public final long timestamp;
    public final int year;

    static {
        DateJvmKt.GMTDate(0L);
    }

    public GMTDate(int r2, int r3, int r4, WeekDay dayOfWeek, int r6, int r7, Month month, int r9, long j) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        Intrinsics.checkNotNullParameter(month, "month");
        this.seconds = r2;
        this.minutes = r3;
        this.hours = r4;
        this.dayOfWeek = dayOfWeek;
        this.dayOfMonth = r6;
        this.dayOfYear = r7;
        this.month = month;
        this.year = r9;
        this.timestamp = j;
    }

    @Override // java.lang.Comparable
    public final int compareTo(GMTDate gMTDate) {
        GMTDate other = gMTDate;
        Intrinsics.checkNotNullParameter(other, "other");
        long j = this.timestamp;
        long j2 = other.timestamp;
        if (j < j2) {
            return -1;
        }
        if (j == j2) {
            return 0;
        }
        return 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMTDate)) {
            return false;
        }
        GMTDate gMTDate = (GMTDate) obj;
        if (this.seconds == gMTDate.seconds && this.minutes == gMTDate.minutes && this.hours == gMTDate.hours && this.dayOfWeek == gMTDate.dayOfWeek && this.dayOfMonth == gMTDate.dayOfMonth && this.dayOfYear == gMTDate.dayOfYear && this.month == gMTDate.month && this.year == gMTDate.year && this.timestamp == gMTDate.timestamp) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.timestamp) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.year, (this.month.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.dayOfYear, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.dayOfMonth, (this.dayOfWeek.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.hours, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.minutes, Integer.hashCode(this.seconds) * 31, 31), 31)) * 31, 31), 31)) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GMTDate(seconds=");
        sb.append(this.seconds);
        sb.append(", minutes=");
        sb.append(this.minutes);
        sb.append(", hours=");
        sb.append(this.hours);
        sb.append(", dayOfWeek=");
        sb.append(this.dayOfWeek);
        sb.append(", dayOfMonth=");
        sb.append(this.dayOfMonth);
        sb.append(", dayOfYear=");
        sb.append(this.dayOfYear);
        sb.append(", month=");
        sb.append(this.month);
        sb.append(", year=");
        sb.append(this.year);
        sb.append(", timestamp=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.timestamp, ')');
    }
}
