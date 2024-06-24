package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetHeartrateIntervaled.kt */
/* loaded from: classes3.dex */
public final class GetHeartrateIntervaled {
    private final Double avg;
    private final long interval_index;
    private final Integer max;
    private final Integer min;

    public GetHeartrateIntervaled(long j, Integer num, Integer num2, Double d) {
        this.interval_index = j;
        this.max = num;
        this.min = num2;
        this.avg = d;
    }

    public static /* synthetic */ GetHeartrateIntervaled copy$default(GetHeartrateIntervaled getHeartrateIntervaled, long j, Integer num, Integer num2, Double d, int r12, Object obj) {
        if ((r12 & 1) != 0) {
            j = getHeartrateIntervaled.interval_index;
        }
        long j2 = j;
        if ((r12 & 2) != 0) {
            num = getHeartrateIntervaled.max;
        }
        Integer num3 = num;
        if ((r12 & 4) != 0) {
            num2 = getHeartrateIntervaled.min;
        }
        Integer num4 = num2;
        if ((r12 & 8) != 0) {
            d = getHeartrateIntervaled.avg;
        }
        return getHeartrateIntervaled.copy(j2, num3, num4, d);
    }

    public final long component1() {
        return this.interval_index;
    }

    public final Integer component2() {
        return this.max;
    }

    public final Integer component3() {
        return this.min;
    }

    public final Double component4() {
        return this.avg;
    }

    public final GetHeartrateIntervaled copy(long j, Integer num, Integer num2, Double d) {
        return new GetHeartrateIntervaled(j, num, num2, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetHeartrateIntervaled)) {
            return false;
        }
        GetHeartrateIntervaled getHeartrateIntervaled = (GetHeartrateIntervaled) obj;
        if (this.interval_index == getHeartrateIntervaled.interval_index && Intrinsics.areEqual(this.max, getHeartrateIntervaled.max) && Intrinsics.areEqual(this.min, getHeartrateIntervaled.min) && Intrinsics.areEqual(this.avg, getHeartrateIntervaled.avg)) {
            return true;
        }
        return false;
    }

    public final Double getAvg() {
        return this.avg;
    }

    public final long getInterval_index() {
        return this.interval_index;
    }

    public final Integer getMax() {
        return this.max;
    }

    public final Integer getMin() {
        return this.min;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = Long.hashCode(this.interval_index) * 31;
        Integer num = this.max;
        int r2 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r0 = (hashCode3 + hashCode) * 31;
        Integer num2 = this.min;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        Double d = this.avg;
        if (d != null) {
            r2 = d.hashCode();
        }
        return r02 + r2;
    }

    public String toString() {
        return "GetHeartrateIntervaled(interval_index=" + this.interval_index + ", max=" + this.max + ", min=" + this.min + ", avg=" + this.avg + ')';
    }
}
