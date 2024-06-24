package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetSumCaloriesIntervaled.kt */
/* loaded from: classes3.dex */
public final class GetSumCaloriesIntervaled {
    private final Double calories;
    private final long interval_index;

    public GetSumCaloriesIntervaled(long j, Double d) {
        this.interval_index = j;
        this.calories = d;
    }

    public static /* synthetic */ GetSumCaloriesIntervaled copy$default(GetSumCaloriesIntervaled getSumCaloriesIntervaled, long j, Double d, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = getSumCaloriesIntervaled.interval_index;
        }
        if ((r4 & 2) != 0) {
            d = getSumCaloriesIntervaled.calories;
        }
        return getSumCaloriesIntervaled.copy(j, d);
    }

    public final long component1() {
        return this.interval_index;
    }

    public final Double component2() {
        return this.calories;
    }

    public final GetSumCaloriesIntervaled copy(long j, Double d) {
        return new GetSumCaloriesIntervaled(j, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSumCaloriesIntervaled)) {
            return false;
        }
        GetSumCaloriesIntervaled getSumCaloriesIntervaled = (GetSumCaloriesIntervaled) obj;
        if (this.interval_index == getSumCaloriesIntervaled.interval_index && Intrinsics.areEqual(this.calories, getSumCaloriesIntervaled.calories)) {
            return true;
        }
        return false;
    }

    public final Double getCalories() {
        return this.calories;
    }

    public final long getInterval_index() {
        return this.interval_index;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Long.hashCode(this.interval_index) * 31;
        Double d = this.calories;
        if (d == null) {
            hashCode = 0;
        } else {
            hashCode = d.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "GetSumCaloriesIntervaled(interval_index=" + this.interval_index + ", calories=" + this.calories + ')';
    }
}
