package androidx.compose.animation;

import androidx.compose.ui.unit.Density;

/* compiled from: FlingCalculator.kt */
/* loaded from: classes.dex */
public final class FlingCalculator {
    public final Density density;
    public final float friction;
    public final float magicPhysicalCoefficient;

    /* compiled from: FlingCalculator.kt */
    /* loaded from: classes.dex */
    public static final class FlingInfo {
        public final float distance;
        public final long duration;
        public final float initialVelocity;

        public FlingInfo(float f, float f2, long j) {
            this.initialVelocity = f;
            this.distance = f2;
            this.duration = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlingInfo)) {
                return false;
            }
            FlingInfo flingInfo = (FlingInfo) obj;
            if (Float.compare(this.initialVelocity, flingInfo.initialVelocity) == 0 && Float.compare(this.distance, flingInfo.distance) == 0 && this.duration == flingInfo.duration) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Long.hashCode(this.duration) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.distance, Float.hashCode(this.initialVelocity) * 31, 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("FlingInfo(initialVelocity=");
            sb.append(this.initialVelocity);
            sb.append(", distance=");
            sb.append(this.distance);
            sb.append(", duration=");
            return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.duration, ')');
        }
    }

    public FlingCalculator(float f, Density density) {
        this.friction = f;
        this.density = density;
        float density2 = density.getDensity();
        float f2 = FlingCalculatorKt.DecelerationRate;
        this.magicPhysicalCoefficient = density2 * 386.0878f * 160.0f * 0.84f;
    }

    public final FlingInfo flingInfo(float f) {
        double splineDeceleration = getSplineDeceleration(f);
        double d = FlingCalculatorKt.DecelerationRate;
        double d2 = d - 1.0d;
        return new FlingInfo(f, (float) (Math.exp((d / d2) * splineDeceleration) * this.friction * this.magicPhysicalCoefficient), (long) (Math.exp(splineDeceleration / d2) * 1000.0d));
    }

    public final double getSplineDeceleration(float f) {
        float[] fArr = AndroidFlingSpline.SplinePositions;
        return Math.log((Math.abs(f) * 0.35f) / (this.friction * this.magicPhysicalCoefficient));
    }
}
