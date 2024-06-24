package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetAvgStepsPerMonth.kt */
/* loaded from: classes3.dex */
public final class GetAvgStepsPerMonth {
    private final Double avg_steps;
    private final long timestamp;

    public GetAvgStepsPerMonth(long j, Double d) {
        this.timestamp = j;
        this.avg_steps = d;
    }

    public static /* synthetic */ GetAvgStepsPerMonth copy$default(GetAvgStepsPerMonth getAvgStepsPerMonth, long j, Double d, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = getAvgStepsPerMonth.timestamp;
        }
        if ((r4 & 2) != 0) {
            d = getAvgStepsPerMonth.avg_steps;
        }
        return getAvgStepsPerMonth.copy(j, d);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final Double component2() {
        return this.avg_steps;
    }

    public final GetAvgStepsPerMonth copy(long j, Double d) {
        return new GetAvgStepsPerMonth(j, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAvgStepsPerMonth)) {
            return false;
        }
        GetAvgStepsPerMonth getAvgStepsPerMonth = (GetAvgStepsPerMonth) obj;
        if (this.timestamp == getAvgStepsPerMonth.timestamp && Intrinsics.areEqual(this.avg_steps, getAvgStepsPerMonth.avg_steps)) {
            return true;
        }
        return false;
    }

    public final Double getAvg_steps() {
        return this.avg_steps;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Long.hashCode(this.timestamp) * 31;
        Double d = this.avg_steps;
        if (d == null) {
            hashCode = 0;
        } else {
            hashCode = d.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "GetAvgStepsPerMonth(timestamp=" + this.timestamp + ", avg_steps=" + this.avg_steps + ')';
    }
}
