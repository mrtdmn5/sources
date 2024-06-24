package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetRestingHeartrateIntervaled.kt */
/* loaded from: classes3.dex */
public final class GetRestingHeartrateIntervaled {
    private final Double avgRestingHeartRateValue;
    private final long interval_index;

    public GetRestingHeartrateIntervaled(long j, Double d) {
        this.interval_index = j;
        this.avgRestingHeartRateValue = d;
    }

    public static /* synthetic */ GetRestingHeartrateIntervaled copy$default(GetRestingHeartrateIntervaled getRestingHeartrateIntervaled, long j, Double d, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = getRestingHeartrateIntervaled.interval_index;
        }
        if ((r4 & 2) != 0) {
            d = getRestingHeartrateIntervaled.avgRestingHeartRateValue;
        }
        return getRestingHeartrateIntervaled.copy(j, d);
    }

    public final long component1() {
        return this.interval_index;
    }

    public final Double component2() {
        return this.avgRestingHeartRateValue;
    }

    public final GetRestingHeartrateIntervaled copy(long j, Double d) {
        return new GetRestingHeartrateIntervaled(j, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetRestingHeartrateIntervaled)) {
            return false;
        }
        GetRestingHeartrateIntervaled getRestingHeartrateIntervaled = (GetRestingHeartrateIntervaled) obj;
        if (this.interval_index == getRestingHeartrateIntervaled.interval_index && Intrinsics.areEqual(this.avgRestingHeartRateValue, getRestingHeartrateIntervaled.avgRestingHeartRateValue)) {
            return true;
        }
        return false;
    }

    public final Double getAvgRestingHeartRateValue() {
        return this.avgRestingHeartRateValue;
    }

    public final long getInterval_index() {
        return this.interval_index;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Long.hashCode(this.interval_index) * 31;
        Double d = this.avgRestingHeartRateValue;
        if (d == null) {
            hashCode = 0;
        } else {
            hashCode = d.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "GetRestingHeartrateIntervaled(interval_index=" + this.interval_index + ", avgRestingHeartRateValue=" + this.avgRestingHeartRateValue + ')';
    }
}
