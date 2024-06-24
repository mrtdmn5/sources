package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetStressIntervaled.kt */
/* loaded from: classes3.dex */
public final class GetStressIntervaled {
    private final Double avg_stress;
    private final long interval_index;

    public GetStressIntervaled(long j, Double d) {
        this.interval_index = j;
        this.avg_stress = d;
    }

    public static /* synthetic */ GetStressIntervaled copy$default(GetStressIntervaled getStressIntervaled, long j, Double d, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = getStressIntervaled.interval_index;
        }
        if ((r4 & 2) != 0) {
            d = getStressIntervaled.avg_stress;
        }
        return getStressIntervaled.copy(j, d);
    }

    public final long component1() {
        return this.interval_index;
    }

    public final Double component2() {
        return this.avg_stress;
    }

    public final GetStressIntervaled copy(long j, Double d) {
        return new GetStressIntervaled(j, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetStressIntervaled)) {
            return false;
        }
        GetStressIntervaled getStressIntervaled = (GetStressIntervaled) obj;
        if (this.interval_index == getStressIntervaled.interval_index && Intrinsics.areEqual(this.avg_stress, getStressIntervaled.avg_stress)) {
            return true;
        }
        return false;
    }

    public final Double getAvg_stress() {
        return this.avg_stress;
    }

    public final long getInterval_index() {
        return this.interval_index;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Long.hashCode(this.interval_index) * 31;
        Double d = this.avg_stress;
        if (d == null) {
            hashCode = 0;
        } else {
            hashCode = d.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "GetStressIntervaled(interval_index=" + this.interval_index + ", avg_stress=" + this.avg_stress + ')';
    }
}
