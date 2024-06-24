package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetProcessedFitnessIndexIntervaled.kt */
/* loaded from: classes3.dex */
public final class GetProcessedFitnessIndexIntervaled {
    private final Double avg_fitness_index;
    private final long interval_index;

    public GetProcessedFitnessIndexIntervaled(long j, Double d) {
        this.interval_index = j;
        this.avg_fitness_index = d;
    }

    public static /* synthetic */ GetProcessedFitnessIndexIntervaled copy$default(GetProcessedFitnessIndexIntervaled getProcessedFitnessIndexIntervaled, long j, Double d, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = getProcessedFitnessIndexIntervaled.interval_index;
        }
        if ((r4 & 2) != 0) {
            d = getProcessedFitnessIndexIntervaled.avg_fitness_index;
        }
        return getProcessedFitnessIndexIntervaled.copy(j, d);
    }

    public final long component1() {
        return this.interval_index;
    }

    public final Double component2() {
        return this.avg_fitness_index;
    }

    public final GetProcessedFitnessIndexIntervaled copy(long j, Double d) {
        return new GetProcessedFitnessIndexIntervaled(j, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetProcessedFitnessIndexIntervaled)) {
            return false;
        }
        GetProcessedFitnessIndexIntervaled getProcessedFitnessIndexIntervaled = (GetProcessedFitnessIndexIntervaled) obj;
        if (this.interval_index == getProcessedFitnessIndexIntervaled.interval_index && Intrinsics.areEqual(this.avg_fitness_index, getProcessedFitnessIndexIntervaled.avg_fitness_index)) {
            return true;
        }
        return false;
    }

    public final Double getAvg_fitness_index() {
        return this.avg_fitness_index;
    }

    public final long getInterval_index() {
        return this.interval_index;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Long.hashCode(this.interval_index) * 31;
        Double d = this.avg_fitness_index;
        if (d == null) {
            hashCode = 0;
        } else {
            hashCode = d.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "GetProcessedFitnessIndexIntervaled(interval_index=" + this.interval_index + ", avg_fitness_index=" + this.avg_fitness_index + ')';
    }
}
