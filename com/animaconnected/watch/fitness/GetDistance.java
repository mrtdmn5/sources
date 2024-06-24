package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetDistance.kt */
/* loaded from: classes3.dex */
public final class GetDistance {
    private final Double SUM;

    public GetDistance(Double d) {
        this.SUM = d;
    }

    public static /* synthetic */ GetDistance copy$default(GetDistance getDistance, Double d, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            d = getDistance.SUM;
        }
        return getDistance.copy(d);
    }

    public final Double component1() {
        return this.SUM;
    }

    public final GetDistance copy(Double d) {
        return new GetDistance(d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof GetDistance) && Intrinsics.areEqual(this.SUM, ((GetDistance) obj).SUM)) {
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
        return "GetDistance(SUM=" + this.SUM + ')';
    }
}
