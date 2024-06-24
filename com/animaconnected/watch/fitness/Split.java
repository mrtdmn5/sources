package com.animaconnected.watch.fitness;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class Split {
    private final double distance;
    private final long duration;

    public Split(long j, double d) {
        this.duration = j;
        this.distance = d;
    }

    public static /* synthetic */ Split copy$default(Split split, long j, double d, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            j = split.duration;
        }
        if ((r5 & 2) != 0) {
            d = split.distance;
        }
        return split.copy(j, d);
    }

    public final long component1() {
        return this.duration;
    }

    public final double component2() {
        return this.distance;
    }

    public final Split copy(long j, double d) {
        return new Split(j, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Split)) {
            return false;
        }
        Split split = (Split) obj;
        if (this.duration == split.duration && Double.compare(this.distance, split.distance) == 0) {
            return true;
        }
        return false;
    }

    public final double getDistance() {
        return this.distance;
    }

    public final long getDuration() {
        return this.duration;
    }

    public int hashCode() {
        return Double.hashCode(this.distance) + (Long.hashCode(this.duration) * 31);
    }

    public String toString() {
        return "Split(duration=" + this.duration + ", distance=" + this.distance + ')';
    }
}
