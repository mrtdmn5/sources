package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetDistanceByIdentifierForWorkout.kt */
/* loaded from: classes3.dex */
public final class GetDistanceByIdentifierForWorkout {
    private final Double SUM;

    public GetDistanceByIdentifierForWorkout(Double d) {
        this.SUM = d;
    }

    public static /* synthetic */ GetDistanceByIdentifierForWorkout copy$default(GetDistanceByIdentifierForWorkout getDistanceByIdentifierForWorkout, Double d, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            d = getDistanceByIdentifierForWorkout.SUM;
        }
        return getDistanceByIdentifierForWorkout.copy(d);
    }

    public final Double component1() {
        return this.SUM;
    }

    public final GetDistanceByIdentifierForWorkout copy(Double d) {
        return new GetDistanceByIdentifierForWorkout(d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof GetDistanceByIdentifierForWorkout) && Intrinsics.areEqual(this.SUM, ((GetDistanceByIdentifierForWorkout) obj).SUM)) {
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
        return "GetDistanceByIdentifierForWorkout(SUM=" + this.SUM + ')';
    }
}
