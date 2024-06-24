package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetSumCaloriesByIdentifierForWorkout.kt */
/* loaded from: classes3.dex */
public final class GetSumCaloriesByIdentifierForWorkout {
    private final Double SUM;

    public GetSumCaloriesByIdentifierForWorkout(Double d) {
        this.SUM = d;
    }

    public static /* synthetic */ GetSumCaloriesByIdentifierForWorkout copy$default(GetSumCaloriesByIdentifierForWorkout getSumCaloriesByIdentifierForWorkout, Double d, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            d = getSumCaloriesByIdentifierForWorkout.SUM;
        }
        return getSumCaloriesByIdentifierForWorkout.copy(d);
    }

    public final Double component1() {
        return this.SUM;
    }

    public final GetSumCaloriesByIdentifierForWorkout copy(Double d) {
        return new GetSumCaloriesByIdentifierForWorkout(d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof GetSumCaloriesByIdentifierForWorkout) && Intrinsics.areEqual(this.SUM, ((GetSumCaloriesByIdentifierForWorkout) obj).SUM)) {
            return true;
        }
        return false;
    }

    public final Double getSUM() {
        return this.SUM;
    }

    public int hashCode() {
        Double d = this.SUM;
        if (d == null) {
            return 0;
        }
        return d.hashCode();
    }

    public String toString() {
        return "GetSumCaloriesByIdentifierForWorkout(SUM=" + this.SUM + ')';
    }
}
