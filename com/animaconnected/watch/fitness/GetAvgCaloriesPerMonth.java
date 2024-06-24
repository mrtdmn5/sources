package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetAvgCaloriesPerMonth.kt */
/* loaded from: classes3.dex */
public final class GetAvgCaloriesPerMonth {
    private final Double avg_calories;
    private final long timestamp;

    public GetAvgCaloriesPerMonth(long j, Double d) {
        this.timestamp = j;
        this.avg_calories = d;
    }

    public static /* synthetic */ GetAvgCaloriesPerMonth copy$default(GetAvgCaloriesPerMonth getAvgCaloriesPerMonth, long j, Double d, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = getAvgCaloriesPerMonth.timestamp;
        }
        if ((r4 & 2) != 0) {
            d = getAvgCaloriesPerMonth.avg_calories;
        }
        return getAvgCaloriesPerMonth.copy(j, d);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final Double component2() {
        return this.avg_calories;
    }

    public final GetAvgCaloriesPerMonth copy(long j, Double d) {
        return new GetAvgCaloriesPerMonth(j, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAvgCaloriesPerMonth)) {
            return false;
        }
        GetAvgCaloriesPerMonth getAvgCaloriesPerMonth = (GetAvgCaloriesPerMonth) obj;
        if (this.timestamp == getAvgCaloriesPerMonth.timestamp && Intrinsics.areEqual(this.avg_calories, getAvgCaloriesPerMonth.avg_calories)) {
            return true;
        }
        return false;
    }

    public final Double getAvg_calories() {
        return this.avg_calories;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Long.hashCode(this.timestamp) * 31;
        Double d = this.avg_calories;
        if (d == null) {
            hashCode = 0;
        } else {
            hashCode = d.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "GetAvgCaloriesPerMonth(timestamp=" + this.timestamp + ", avg_calories=" + this.avg_calories + ')';
    }
}
