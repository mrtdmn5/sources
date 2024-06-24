package com.animaconnected.watch.device;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* compiled from: WatchIO.kt */
/* loaded from: classes3.dex */
public final class WatchTime {
    private final int dayOfMonth;
    private final int dayOfWeek;
    private final int hour;
    private final int minute;
    private final int month;
    private final int second;
    private final Duration utcOffset;
    private final int year;

    public /* synthetic */ WatchTime(int r1, int r2, int r3, int r4, int r5, int r6, int r7, Duration duration, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3, r4, r5, r6, r7, duration);
    }

    /* renamed from: copy-bAucREo$default, reason: not valid java name */
    public static /* synthetic */ WatchTime m1098copybAucREo$default(WatchTime watchTime, int r10, int r11, int r12, int r13, int r14, int r15, int r16, Duration duration, int r18, Object obj) {
        int r2;
        int r3;
        int r4;
        int r5;
        int r6;
        int r7;
        int r8;
        Duration duration2;
        if ((r18 & 1) != 0) {
            r2 = watchTime.year;
        } else {
            r2 = r10;
        }
        if ((r18 & 2) != 0) {
            r3 = watchTime.month;
        } else {
            r3 = r11;
        }
        if ((r18 & 4) != 0) {
            r4 = watchTime.dayOfMonth;
        } else {
            r4 = r12;
        }
        if ((r18 & 8) != 0) {
            r5 = watchTime.hour;
        } else {
            r5 = r13;
        }
        if ((r18 & 16) != 0) {
            r6 = watchTime.minute;
        } else {
            r6 = r14;
        }
        if ((r18 & 32) != 0) {
            r7 = watchTime.second;
        } else {
            r7 = r15;
        }
        if ((r18 & 64) != 0) {
            r8 = watchTime.dayOfWeek;
        } else {
            r8 = r16;
        }
        if ((r18 & 128) != 0) {
            duration2 = watchTime.utcOffset;
        } else {
            duration2 = duration;
        }
        return watchTime.m1100copybAucREo(r2, r3, r4, r5, r6, r7, r8, duration2);
    }

    public final int component1() {
        return this.year;
    }

    public final int component2() {
        return this.month;
    }

    public final int component3() {
        return this.dayOfMonth;
    }

    public final int component4() {
        return this.hour;
    }

    public final int component5() {
        return this.minute;
    }

    public final int component6() {
        return this.second;
    }

    public final int component7() {
        return this.dayOfWeek;
    }

    /* renamed from: component8-FghU774, reason: not valid java name */
    public final Duration m1099component8FghU774() {
        return this.utcOffset;
    }

    /* renamed from: copy-bAucREo, reason: not valid java name */
    public final WatchTime m1100copybAucREo(int r12, int r13, int r14, int r15, int r16, int r17, int r18, Duration duration) {
        return new WatchTime(r12, r13, r14, r15, r16, r17, r18, duration, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchTime)) {
            return false;
        }
        WatchTime watchTime = (WatchTime) obj;
        if (this.year == watchTime.year && this.month == watchTime.month && this.dayOfMonth == watchTime.dayOfMonth && this.hour == watchTime.hour && this.minute == watchTime.minute && this.second == watchTime.second && this.dayOfWeek == watchTime.dayOfWeek && Intrinsics.areEqual(this.utcOffset, watchTime.utcOffset)) {
            return true;
        }
        return false;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getDayOfWeek() {
        return this.dayOfWeek;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getSecond() {
        return this.second;
    }

    /* renamed from: getUtcOffset-FghU774, reason: not valid java name */
    public final Duration m1101getUtcOffsetFghU774() {
        return this.utcOffset;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        int hashCode;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.dayOfWeek, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.second, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.minute, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.hour, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.dayOfMonth, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.month, Integer.hashCode(this.year) * 31, 31), 31), 31), 31), 31), 31);
        Duration duration = this.utcOffset;
        if (duration == null) {
            hashCode = 0;
        } else {
            hashCode = Long.hashCode(duration.rawValue);
        }
        return m + hashCode;
    }

    public String toString() {
        return "WatchTime(year=" + this.year + ", month=" + this.month + ", dayOfMonth=" + this.dayOfMonth + ", hour=" + this.hour + ", minute=" + this.minute + ", second=" + this.second + ", dayOfWeek=" + this.dayOfWeek + ", utcOffset=" + this.utcOffset + ')';
    }

    private WatchTime(int r1, int r2, int r3, int r4, int r5, int r6, int r7, Duration duration) {
        this.year = r1;
        this.month = r2;
        this.dayOfMonth = r3;
        this.hour = r4;
        this.minute = r5;
        this.second = r6;
        this.dayOfWeek = r7;
        this.utcOffset = duration;
    }
}
