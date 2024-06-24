package com.animaconnected.watch.fitness;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class HeartrateSummary {
    private final int avg;
    private final int max;
    private final int min;
    private final long timestamp;
    private final boolean worn;

    public HeartrateSummary(long j, int r3, int r4, int r5, boolean z) {
        this.timestamp = j;
        this.max = r3;
        this.min = r4;
        this.avg = r5;
        this.worn = z;
    }

    public static /* synthetic */ HeartrateSummary copy$default(HeartrateSummary heartrateSummary, long j, int r10, int r11, int r12, boolean z, int r14, Object obj) {
        if ((r14 & 1) != 0) {
            j = heartrateSummary.timestamp;
        }
        long j2 = j;
        if ((r14 & 2) != 0) {
            r10 = heartrateSummary.max;
        }
        int r3 = r10;
        if ((r14 & 4) != 0) {
            r11 = heartrateSummary.min;
        }
        int r4 = r11;
        if ((r14 & 8) != 0) {
            r12 = heartrateSummary.avg;
        }
        int r5 = r12;
        if ((r14 & 16) != 0) {
            z = heartrateSummary.worn;
        }
        return heartrateSummary.copy(j2, r3, r4, r5, z);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final int component2() {
        return this.max;
    }

    public final int component3() {
        return this.min;
    }

    public final int component4() {
        return this.avg;
    }

    public final boolean component5() {
        return this.worn;
    }

    public final HeartrateSummary copy(long j, int r11, int r12, int r13, boolean z) {
        return new HeartrateSummary(j, r11, r12, r13, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeartrateSummary)) {
            return false;
        }
        HeartrateSummary heartrateSummary = (HeartrateSummary) obj;
        if (this.timestamp == heartrateSummary.timestamp && this.max == heartrateSummary.max && this.min == heartrateSummary.min && this.avg == heartrateSummary.avg && this.worn == heartrateSummary.worn) {
            return true;
        }
        return false;
    }

    public final int getAvg() {
        return this.avg;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final boolean getWorn() {
        return this.worn;
    }

    public int hashCode() {
        return Boolean.hashCode(this.worn) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.avg, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.min, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.max, Long.hashCode(this.timestamp) * 31, 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HeartrateSummary(timestamp=");
        sb.append(this.timestamp);
        sb.append(", max=");
        sb.append(this.max);
        sb.append(", min=");
        sb.append(this.min);
        sb.append(", avg=");
        sb.append(this.avg);
        sb.append(", worn=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.worn, ')');
    }
}
