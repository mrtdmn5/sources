package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LocationUtils.kt */
/* loaded from: classes3.dex */
public final class SpotQualityResult {
    private final boolean accepted;
    private final double distanceFromPrevious;

    public SpotQualityResult(boolean z, double d) {
        this.accepted = z;
        this.distanceFromPrevious = d;
    }

    public static /* synthetic */ SpotQualityResult copy$default(SpotQualityResult spotQualityResult, boolean z, double d, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            z = spotQualityResult.accepted;
        }
        if ((r4 & 2) != 0) {
            d = spotQualityResult.distanceFromPrevious;
        }
        return spotQualityResult.copy(z, d);
    }

    public final boolean component1() {
        return this.accepted;
    }

    public final double component2() {
        return this.distanceFromPrevious;
    }

    public final SpotQualityResult copy(boolean z, double d) {
        return new SpotQualityResult(z, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpotQualityResult)) {
            return false;
        }
        SpotQualityResult spotQualityResult = (SpotQualityResult) obj;
        if (this.accepted == spotQualityResult.accepted && Double.compare(this.distanceFromPrevious, spotQualityResult.distanceFromPrevious) == 0) {
            return true;
        }
        return false;
    }

    public final boolean getAccepted() {
        return this.accepted;
    }

    public final double getDistanceFromPrevious() {
        return this.distanceFromPrevious;
    }

    public int hashCode() {
        return Double.hashCode(this.distanceFromPrevious) + (Boolean.hashCode(this.accepted) * 31);
    }

    public String toString() {
        return "SpotQualityResult(accepted=" + this.accepted + ", distanceFromPrevious=" + this.distanceFromPrevious + ')';
    }

    public /* synthetic */ SpotQualityResult(boolean z, double d, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (r4 & 2) != 0 ? 0.0d : d);
    }
}
