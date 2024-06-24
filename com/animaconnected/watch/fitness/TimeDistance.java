package com.animaconnected.watch.fitness;

/* compiled from: LocationUtils.kt */
/* loaded from: classes3.dex */
public final class TimeDistance {
    private final double distance;
    private final long time;

    public TimeDistance(long j, double d) {
        this.time = j;
        this.distance = d;
    }

    public static /* synthetic */ TimeDistance copy$default(TimeDistance timeDistance, long j, double d, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            j = timeDistance.time;
        }
        if ((r5 & 2) != 0) {
            d = timeDistance.distance;
        }
        return timeDistance.copy(j, d);
    }

    public final long component1() {
        return this.time;
    }

    public final double component2() {
        return this.distance;
    }

    public final TimeDistance copy(long j, double d) {
        return new TimeDistance(j, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeDistance)) {
            return false;
        }
        TimeDistance timeDistance = (TimeDistance) obj;
        if (this.time == timeDistance.time && Double.compare(this.distance, timeDistance.distance) == 0) {
            return true;
        }
        return false;
    }

    public final double getDistance() {
        return this.distance;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return Double.hashCode(this.distance) + (Long.hashCode(this.time) * 31);
    }

    public String toString() {
        return "TimeDistance(time=" + this.time + ", distance=" + this.distance + ')';
    }
}
