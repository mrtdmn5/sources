package com.animaconnected.watch.provider;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.animaconnected.info.DateTimeUtilsKt;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: WatchAlarmProvider.kt */
/* loaded from: classes3.dex */
public final class WatchAlarm {
    public static final Companion Companion = new Companion(null);
    private Set<? extends AlarmDay> daysEnabled;
    private boolean deleteAfterUse;
    private boolean enabled;
    private int hour;
    private final long id;
    private long lastModified;
    private int minute;

    /* compiled from: WatchAlarmProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public WatchAlarm(long j, int r4, int r5, Set<? extends AlarmDay> daysEnabled, boolean z, boolean z2, long j2) {
        Intrinsics.checkNotNullParameter(daysEnabled, "daysEnabled");
        this.id = j;
        this.hour = r4;
        this.minute = r5;
        this.daysEnabled = daysEnabled;
        this.enabled = z;
        this.deleteAfterUse = z2;
        this.lastModified = j2;
    }

    public static /* synthetic */ WatchAlarm copy$default(WatchAlarm watchAlarm, long j, int r13, int r14, Set set, boolean z, boolean z2, long j2, int r20, Object obj) {
        long j3;
        int r3;
        int r4;
        Set set2;
        boolean z3;
        boolean z4;
        long j4;
        if ((r20 & 1) != 0) {
            j3 = watchAlarm.id;
        } else {
            j3 = j;
        }
        if ((r20 & 2) != 0) {
            r3 = watchAlarm.hour;
        } else {
            r3 = r13;
        }
        if ((r20 & 4) != 0) {
            r4 = watchAlarm.minute;
        } else {
            r4 = r14;
        }
        if ((r20 & 8) != 0) {
            set2 = watchAlarm.daysEnabled;
        } else {
            set2 = set;
        }
        if ((r20 & 16) != 0) {
            z3 = watchAlarm.enabled;
        } else {
            z3 = z;
        }
        if ((r20 & 32) != 0) {
            z4 = watchAlarm.deleteAfterUse;
        } else {
            z4 = z2;
        }
        if ((r20 & 64) != 0) {
            j4 = watchAlarm.lastModified;
        } else {
            j4 = j2;
        }
        return watchAlarm.copy(j3, r3, r4, set2, z3, z4, j4);
    }

    public final long component1() {
        return this.id;
    }

    public final int component2() {
        return this.hour;
    }

    public final int component3() {
        return this.minute;
    }

    public final Set<AlarmDay> component4() {
        return this.daysEnabled;
    }

    public final boolean component5() {
        return this.enabled;
    }

    public final boolean component6() {
        return this.deleteAfterUse;
    }

    public final long component7() {
        return this.lastModified;
    }

    public final WatchAlarm copy(long j, int r14, int r15, Set<? extends AlarmDay> daysEnabled, boolean z, boolean z2, long j2) {
        Intrinsics.checkNotNullParameter(daysEnabled, "daysEnabled");
        return new WatchAlarm(j, r14, r15, daysEnabled, z, z2, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchAlarm)) {
            return false;
        }
        WatchAlarm watchAlarm = (WatchAlarm) obj;
        if (this.id == watchAlarm.id && this.hour == watchAlarm.hour && this.minute == watchAlarm.minute && Intrinsics.areEqual(this.daysEnabled, watchAlarm.daysEnabled) && this.enabled == watchAlarm.enabled && this.deleteAfterUse == watchAlarm.deleteAfterUse && this.lastModified == watchAlarm.lastModified) {
            return true;
        }
        return false;
    }

    public final Set<AlarmDay> getDaysEnabled() {
        return this.daysEnabled;
    }

    public final boolean getDeleteAfterUse() {
        return this.deleteAfterUse;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getHour() {
        return this.hour;
    }

    public final long getId() {
        return this.id;
    }

    public final long getLastModified() {
        return this.lastModified;
    }

    public final int getMinute() {
        return this.minute;
    }

    public int hashCode() {
        return Long.hashCode(this.lastModified) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.deleteAfterUse, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.enabled, (this.daysEnabled.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.minute, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.hour, Long.hashCode(this.id) * 31, 31), 31)) * 31, 31), 31);
    }

    public final void setDaysEnabled(Set<? extends AlarmDay> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.daysEnabled = set;
    }

    public final void setDeleteAfterUse(boolean z) {
        this.deleteAfterUse = z;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setHour(int r1) {
        this.hour = r1;
    }

    public final void setLastModified(long j) {
        this.lastModified = j;
    }

    public final void setMinute(int r1) {
        this.minute = r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WatchAlarm(id=");
        sb.append(this.id);
        sb.append(", hour=");
        sb.append(this.hour);
        sb.append(", minute=");
        sb.append(this.minute);
        sb.append(", daysEnabled=");
        sb.append(this.daysEnabled);
        sb.append(", enabled=");
        sb.append(this.enabled);
        sb.append(", deleteAfterUse=");
        sb.append(this.deleteAfterUse);
        sb.append(", lastModified=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.lastModified, ')');
    }

    public WatchAlarm(long j) {
        this(j, 12, 0, EmptySet.INSTANCE, true, false, 1000 * DateTimeUtilsKt.now().getEpochSeconds());
    }
}
