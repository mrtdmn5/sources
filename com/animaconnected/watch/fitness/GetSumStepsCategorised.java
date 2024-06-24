package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetSumStepsCategorised.kt */
/* loaded from: classes3.dex */
public final class GetSumStepsCategorised {
    private final Double other;
    private final Double run;
    private final Double walk;

    public GetSumStepsCategorised(Double d, Double d2, Double d3) {
        this.walk = d;
        this.run = d2;
        this.other = d3;
    }

    public static /* synthetic */ GetSumStepsCategorised copy$default(GetSumStepsCategorised getSumStepsCategorised, Double d, Double d2, Double d3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            d = getSumStepsCategorised.walk;
        }
        if ((r4 & 2) != 0) {
            d2 = getSumStepsCategorised.run;
        }
        if ((r4 & 4) != 0) {
            d3 = getSumStepsCategorised.other;
        }
        return getSumStepsCategorised.copy(d, d2, d3);
    }

    public final Double component1() {
        return this.walk;
    }

    public final Double component2() {
        return this.run;
    }

    public final Double component3() {
        return this.other;
    }

    public final GetSumStepsCategorised copy(Double d, Double d2, Double d3) {
        return new GetSumStepsCategorised(d, d2, d3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSumStepsCategorised)) {
            return false;
        }
        GetSumStepsCategorised getSumStepsCategorised = (GetSumStepsCategorised) obj;
        if (Intrinsics.areEqual(this.walk, getSumStepsCategorised.walk) && Intrinsics.areEqual(this.run, getSumStepsCategorised.run) && Intrinsics.areEqual(this.other, getSumStepsCategorised.other)) {
            return true;
        }
        return false;
    }

    public final Double getOther() {
        return this.other;
    }

    public final Double getRun() {
        return this.run;
    }

    public final Double getWalk() {
        return this.walk;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        Double d = this.walk;
        int r1 = 0;
        if (d == null) {
            hashCode = 0;
        } else {
            hashCode = d.hashCode();
        }
        int r0 = hashCode * 31;
        Double d2 = this.run;
        if (d2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = d2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        Double d3 = this.other;
        if (d3 != null) {
            r1 = d3.hashCode();
        }
        return r02 + r1;
    }

    public String toString() {
        return "GetSumStepsCategorised(walk=" + this.walk + ", run=" + this.run + ", other=" + this.other + ')';
    }
}
