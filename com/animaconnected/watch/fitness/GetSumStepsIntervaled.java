package com.animaconnected.watch.fitness;

/* compiled from: GetSumStepsIntervaled.kt */
/* loaded from: classes3.dex */
public final class GetSumStepsIntervaled {
    private final long interval_index;
    private final double steps;

    public GetSumStepsIntervaled(long j, double d) {
        this.interval_index = j;
        this.steps = d;
    }

    public static /* synthetic */ GetSumStepsIntervaled copy$default(GetSumStepsIntervaled getSumStepsIntervaled, long j, double d, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            j = getSumStepsIntervaled.interval_index;
        }
        if ((r5 & 2) != 0) {
            d = getSumStepsIntervaled.steps;
        }
        return getSumStepsIntervaled.copy(j, d);
    }

    public final long component1() {
        return this.interval_index;
    }

    public final double component2() {
        return this.steps;
    }

    public final GetSumStepsIntervaled copy(long j, double d) {
        return new GetSumStepsIntervaled(j, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSumStepsIntervaled)) {
            return false;
        }
        GetSumStepsIntervaled getSumStepsIntervaled = (GetSumStepsIntervaled) obj;
        if (this.interval_index == getSumStepsIntervaled.interval_index && Double.compare(this.steps, getSumStepsIntervaled.steps) == 0) {
            return true;
        }
        return false;
    }

    public final long getInterval_index() {
        return this.interval_index;
    }

    public final double getSteps() {
        return this.steps;
    }

    public int hashCode() {
        return Double.hashCode(this.steps) + (Long.hashCode(this.interval_index) * 31);
    }

    public String toString() {
        return "GetSumStepsIntervaled(interval_index=" + this.interval_index + ", steps=" + this.steps + ')';
    }
}
