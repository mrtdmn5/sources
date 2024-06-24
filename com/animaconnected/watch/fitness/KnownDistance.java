package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class KnownDistance extends Distance {
    private final long timestamp;
    private final double total;

    public KnownDistance(double d, long j) {
        super(null);
        this.total = d;
        this.timestamp = j;
    }

    public static /* synthetic */ KnownDistance copy$default(KnownDistance knownDistance, double d, long j, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            d = knownDistance.total;
        }
        if ((r5 & 2) != 0) {
            j = knownDistance.timestamp;
        }
        return knownDistance.copy(d, j);
    }

    public final double component1() {
        return this.total;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final KnownDistance copy(double d, long j) {
        return new KnownDistance(d, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KnownDistance)) {
            return false;
        }
        KnownDistance knownDistance = (KnownDistance) obj;
        if (Double.compare(this.total, knownDistance.total) == 0 && this.timestamp == knownDistance.timestamp) {
            return true;
        }
        return false;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final double getTotal() {
        return this.total;
    }

    public int hashCode() {
        return Long.hashCode(this.timestamp) + (Double.hashCode(this.total) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KnownDistance(total=");
        sb.append(this.total);
        sb.append(", timestamp=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.timestamp, ')');
    }
}
