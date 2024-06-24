package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: FloatAnimationSpec.kt */
/* loaded from: classes.dex */
public final class FloatTweenSpec implements FloatAnimationSpec {
    public final int delay;
    public final int duration;
    public final Easing easing;

    public FloatTweenSpec(int r2, int r3, Easing easing) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.duration = r2;
        this.delay = r3;
        this.easing = easing;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final long getDurationNanos(float f, float f2, float f3) {
        return (this.delay + this.duration) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getValueFromNanos(long j, float f, float f2, float f3) {
        float f4;
        long j2 = (j / 1000000) - this.delay;
        int r9 = this.duration;
        long coerceIn = RangesKt___RangesKt.coerceIn(j2, 0L, r9);
        if (r9 == 0) {
            f4 = 1.0f;
        } else {
            f4 = ((float) coerceIn) / r9;
        }
        float transform = this.easing.transform(RangesKt___RangesKt.coerceIn(f4, 0.0f, 1.0f));
        TwoWayConverterImpl twoWayConverterImpl = VectorConvertersKt.FloatToVector;
        return (f2 * transform) + ((1 - transform) * f);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getVelocityFromNanos(long j, float f, float f2, float f3) {
        long coerceIn = RangesKt___RangesKt.coerceIn((j / 1000000) - this.delay, 0L, this.duration);
        if (coerceIn < 0) {
            return 0.0f;
        }
        if (coerceIn == 0) {
            return f3;
        }
        return (getValueFromNanos(coerceIn * 1000000, f, f2, f3) - getValueFromNanos((coerceIn - 1) * 1000000, f, f2, f3)) * 1000.0f;
    }
}
