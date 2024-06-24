package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: FloatAnimationSpec.kt */
/* loaded from: classes.dex */
public interface FloatAnimationSpec extends AnimationSpec<Float> {
    long getDurationNanos(float f, float f2, float f3);

    default float getEndVelocity(float f, float f2, float f3) {
        return getVelocityFromNanos(getDurationNanos(f, f2, f3), f, f2, f3);
    }

    float getValueFromNanos(long j, float f, float f2, float f3);

    float getVelocityFromNanos(long j, float f, float f2, float f3);

    @Override // androidx.compose.animation.core.AnimationSpec
    default <V extends AnimationVector> VectorizedFloatAnimationSpec<V> vectorize(TwoWayConverter<Float, V> converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        return new VectorizedFloatAnimationSpec<>(this);
    }
}
