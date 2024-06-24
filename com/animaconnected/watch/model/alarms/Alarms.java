package com.animaconnected.watch.model.alarms;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: Alarms.kt */
/* loaded from: classes3.dex */
public final class Alarms {
    private final long _id;
    private final DaysOfWeek daysofweek;
    private final boolean delete_after_use;
    private final boolean enabled;
    private final int hour;
    private final long last_modified;
    private final int minutes;

    /* compiled from: Alarms.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<DaysOfWeek, Long> daysofweekAdapter;
        private final ColumnAdapter<Integer, Long> hourAdapter;
        private final ColumnAdapter<Integer, Long> minutesAdapter;

        public Adapter(ColumnAdapter<Integer, Long> hourAdapter, ColumnAdapter<Integer, Long> minutesAdapter, ColumnAdapter<DaysOfWeek, Long> daysofweekAdapter) {
            Intrinsics.checkNotNullParameter(hourAdapter, "hourAdapter");
            Intrinsics.checkNotNullParameter(minutesAdapter, "minutesAdapter");
            Intrinsics.checkNotNullParameter(daysofweekAdapter, "daysofweekAdapter");
            this.hourAdapter = hourAdapter;
            this.minutesAdapter = minutesAdapter;
            this.daysofweekAdapter = daysofweekAdapter;
        }

        public final ColumnAdapter<DaysOfWeek, Long> getDaysofweekAdapter() {
            return this.daysofweekAdapter;
        }

        public final ColumnAdapter<Integer, Long> getHourAdapter() {
            return this.hourAdapter;
        }

        public final ColumnAdapter<Integer, Long> getMinutesAdapter() {
            return this.minutesAdapter;
        }
    }

    public Alarms(long j, int r4, int r5, DaysOfWeek daysofweek, boolean z, boolean z2, long j2) {
        Intrinsics.checkNotNullParameter(daysofweek, "daysofweek");
        this._id = j;
        this.hour = r4;
        this.minutes = r5;
        this.daysofweek = daysofweek;
        this.enabled = z;
        this.delete_after_use = z2;
        this.last_modified = j2;
    }

    public static /* synthetic */ Alarms copy$default(Alarms alarms, long j, int r13, int r14, DaysOfWeek daysOfWeek, boolean z, boolean z2, long j2, int r20, Object obj) {
        long j3;
        int r3;
        int r4;
        DaysOfWeek daysOfWeek2;
        boolean z3;
        boolean z4;
        long j4;
        if ((r20 & 1) != 0) {
            j3 = alarms._id;
        } else {
            j3 = j;
        }
        if ((r20 & 2) != 0) {
            r3 = alarms.hour;
        } else {
            r3 = r13;
        }
        if ((r20 & 4) != 0) {
            r4 = alarms.minutes;
        } else {
            r4 = r14;
        }
        if ((r20 & 8) != 0) {
            daysOfWeek2 = alarms.daysofweek;
        } else {
            daysOfWeek2 = daysOfWeek;
        }
        if ((r20 & 16) != 0) {
            z3 = alarms.enabled;
        } else {
            z3 = z;
        }
        if ((r20 & 32) != 0) {
            z4 = alarms.delete_after_use;
        } else {
            z4 = z2;
        }
        if ((r20 & 64) != 0) {
            j4 = alarms.last_modified;
        } else {
            j4 = j2;
        }
        return alarms.copy(j3, r3, r4, daysOfWeek2, z3, z4, j4);
    }

    public final long component1() {
        return this._id;
    }

    public final int component2() {
        return this.hour;
    }

    public final int component3() {
        return this.minutes;
    }

    public final DaysOfWeek component4() {
        return this.daysofweek;
    }

    public final boolean component5() {
        return this.enabled;
    }

    public final boolean component6() {
        return this.delete_after_use;
    }

    public final long component7() {
        return this.last_modified;
    }

    public final Alarms copy(long j, int r14, int r15, DaysOfWeek daysofweek, boolean z, boolean z2, long j2) {
        Intrinsics.checkNotNullParameter(daysofweek, "daysofweek");
        return new Alarms(j, r14, r15, daysofweek, z, z2, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Alarms)) {
            return false;
        }
        Alarms alarms = (Alarms) obj;
        if (this._id == alarms._id && this.hour == alarms.hour && this.minutes == alarms.minutes && Intrinsics.areEqual(this.daysofweek, alarms.daysofweek) && this.enabled == alarms.enabled && this.delete_after_use == alarms.delete_after_use && this.last_modified == alarms.last_modified) {
            return true;
        }
        return false;
    }

    public final DaysOfWeek getDaysofweek() {
        return this.daysofweek;
    }

    public final boolean getDelete_after_use() {
        return this.delete_after_use;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getHour() {
        return this.hour;
    }

    public final long getLast_modified() {
        return this.last_modified;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final long get_id() {
        return this._id;
    }

    public int hashCode() {
        return Long.hashCode(this.last_modified) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.delete_after_use, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.enabled, (this.daysofweek.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.minutes, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.hour, Long.hashCode(this._id) * 31, 31), 31)) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Alarms(_id=");
        sb.append(this._id);
        sb.append(", hour=");
        sb.append(this.hour);
        sb.append(", minutes=");
        sb.append(this.minutes);
        sb.append(", daysofweek=");
        sb.append(this.daysofweek);
        sb.append(", enabled=");
        sb.append(this.enabled);
        sb.append(", delete_after_use=");
        sb.append(this.delete_after_use);
        sb.append(", last_modified=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.last_modified, ')');
    }
}
