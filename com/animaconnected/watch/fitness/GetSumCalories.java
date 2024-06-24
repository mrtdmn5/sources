package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetSumCalories.kt */
/* loaded from: classes3.dex */
public final class GetSumCalories {
    private final Double SUM;

    public GetSumCalories(Double d) {
        this.SUM = d;
    }

    public static /* synthetic */ GetSumCalories copy$default(GetSumCalories getSumCalories, Double d, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            d = getSumCalories.SUM;
        }
        return getSumCalories.copy(d);
    }

    public final Double component1() {
        return this.SUM;
    }

    public final GetSumCalories copy(Double d) {
        return new GetSumCalories(d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof GetSumCalories) && Intrinsics.areEqual(this.SUM, ((GetSumCalories) obj).SUM)) {
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
        return "GetSumCalories(SUM=" + this.SUM + ')';
    }
}
