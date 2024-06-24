package com.animaconnected.watch.behaviour.util;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;

/* compiled from: HoursMinutesFwdAdjust24.kt */
/* loaded from: classes3.dex */
public final class HoursMinutesFwdAdjust24 {
    public static final Companion Companion = new Companion(null);
    public final int hours;
    public final int minutes;

    /* compiled from: HoursMinutesFwdAdjust24.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HoursMinutesFwdAdjust24 fromTo(LocalDateTime time1, LocalDateTime time2) {
            Intrinsics.checkNotNullParameter(time1, "time1");
            Intrinsics.checkNotNullParameter(time2, "time2");
            int minute = (time2.getMinute() + (time2.getHour() * 60)) - (time1.getMinute() + (time1.getHour() * 60));
            if (minute < 0) {
                minute += 1440;
            }
            return new HoursMinutesFwdAdjust24(minute / 60, minute % 60);
        }

        private Companion() {
        }
    }

    public HoursMinutesFwdAdjust24(int r1, int r2) {
        this.hours = r1;
        this.minutes = r2;
    }

    public static /* synthetic */ HoursMinutesFwdAdjust24 copy$default(HoursMinutesFwdAdjust24 hoursMinutesFwdAdjust24, int r1, int r2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = hoursMinutesFwdAdjust24.hours;
        }
        if ((r3 & 2) != 0) {
            r2 = hoursMinutesFwdAdjust24.minutes;
        }
        return hoursMinutesFwdAdjust24.copy(r1, r2);
    }

    public static final HoursMinutesFwdAdjust24 fromTo(LocalDateTime localDateTime, LocalDateTime localDateTime2) {
        return Companion.fromTo(localDateTime, localDateTime2);
    }

    public final int component1() {
        return this.hours;
    }

    public final int component2() {
        return this.minutes;
    }

    public final HoursMinutesFwdAdjust24 copy(int r2, int r3) {
        return new HoursMinutesFwdAdjust24(r2, r3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HoursMinutesFwdAdjust24)) {
            return false;
        }
        HoursMinutesFwdAdjust24 hoursMinutesFwdAdjust24 = (HoursMinutesFwdAdjust24) obj;
        if (this.hours == hoursMinutesFwdAdjust24.hours && this.minutes == hoursMinutesFwdAdjust24.minutes) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Integer.hashCode(this.minutes) + (Integer.hashCode(this.hours) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HoursMinutesFwdAdjust24(hours=");
        sb.append(this.hours);
        sb.append(", minutes=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.minutes, ')');
    }
}
