package androidx.compose.animation;

import androidx.compose.animation.FlingCalculator;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.ui.unit.Density;

/* compiled from: SplineBasedFloatDecayAnimationSpec.kt */
/* loaded from: classes.dex */
public final class SplineBasedFloatDecayAnimationSpec implements FloatDecayAnimationSpec {
    public final FlingCalculator flingCalculator;

    public SplineBasedFloatDecayAnimationSpec(Density density) {
        this.flingCalculator = new FlingCalculator(SplineBasedFloatDecayAnimationSpec_androidKt.platformFlingScrollFriction, density);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public final long getDurationNanos(float f) {
        return ((long) (Math.exp(this.flingCalculator.getSplineDeceleration(f) / (FlingCalculatorKt.DecelerationRate - 1.0d)) * 1000.0d)) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public final float getTargetValue(float f, float f2) {
        double splineDeceleration = this.flingCalculator.getSplineDeceleration(f2);
        double d = FlingCalculatorKt.DecelerationRate;
        return (Math.signum(f2) * ((float) (Math.exp((d / (d - 1.0d)) * splineDeceleration) * r0.friction * r0.magicPhysicalCoefficient))) + f;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public final float getValueFromNanos(float f, float f2, long j) {
        float f3;
        long j2 = j / 1000000;
        FlingCalculator.FlingInfo flingInfo = this.flingCalculator.flingInfo(f2);
        long j3 = flingInfo.duration;
        if (j3 > 0) {
            f3 = ((float) j2) / ((float) j3);
        } else {
            f3 = 1.0f;
        }
        return (Math.signum(flingInfo.initialVelocity) * flingInfo.distance * AndroidFlingSpline.flingPosition(f3).distanceCoefficient) + f;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public final float getVelocityFromNanos(float f, long j) {
        float f2;
        long j2 = j / 1000000;
        FlingCalculator.FlingInfo flingInfo = this.flingCalculator.flingInfo(f);
        long j3 = flingInfo.duration;
        if (j3 > 0) {
            f2 = ((float) j2) / ((float) j3);
        } else {
            f2 = 1.0f;
        }
        return (((Math.signum(flingInfo.initialVelocity) * AndroidFlingSpline.flingPosition(f2).velocityCoefficient) * flingInfo.distance) / ((float) j3)) * 1000.0f;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public final void getAbsVelocityThreshold() {
    }
}
