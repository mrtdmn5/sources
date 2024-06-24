package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorizedAnimationSpec.kt */
/* loaded from: classes.dex */
public final class VectorizedInfiniteRepeatableSpec<V extends AnimationVector> implements VectorizedAnimationSpec<V> {
    public final VectorizedDurationBasedAnimationSpec<V> animation;
    public final long durationNanos;
    public final long initialOffsetNanos;
    public final RepeatMode repeatMode;

    public VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec animation, RepeatMode repeatMode, long j) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(repeatMode, "repeatMode");
        this.animation = animation;
        this.repeatMode = repeatMode;
        this.durationNanos = (animation.getDurationMillis() + animation.getDelayMillis()) * 1000000;
        this.initialOffsetNanos = j * 1000000;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final long getDurationNanos(V initialValue, V targetValue, V v) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        return Long.MAX_VALUE;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final V getValueFromNanos(long j, V initialValue, V targetValue, V initialVelocity) {
        V v;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec = this.animation;
        long repetitionPlayTimeNanos = repetitionPlayTimeNanos(j);
        long j2 = this.initialOffsetNanos;
        long j3 = j + j2;
        long j4 = this.durationNanos;
        if (j3 > j4) {
            v = getVelocityFromNanos(j4 - j2, initialValue, initialVelocity, targetValue);
        } else {
            v = initialVelocity;
        }
        return vectorizedDurationBasedAnimationSpec.getValueFromNanos(repetitionPlayTimeNanos, initialValue, targetValue, v);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final V getVelocityFromNanos(long j, V initialValue, V targetValue, V initialVelocity) {
        V v;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec = this.animation;
        long repetitionPlayTimeNanos = repetitionPlayTimeNanos(j);
        long j2 = this.initialOffsetNanos;
        long j3 = j + j2;
        long j4 = this.durationNanos;
        if (j3 > j4) {
            v = getVelocityFromNanos(j4 - j2, initialValue, initialVelocity, targetValue);
        } else {
            v = initialVelocity;
        }
        return vectorizedDurationBasedAnimationSpec.getVelocityFromNanos(repetitionPlayTimeNanos, initialValue, targetValue, v);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final boolean isInfinite() {
        return true;
    }

    public final long repetitionPlayTimeNanos(long j) {
        long j2 = this.initialOffsetNanos;
        if (j + j2 <= 0) {
            return 0L;
        }
        long j3 = j + j2;
        long j4 = this.durationNanos;
        long j5 = j3 / j4;
        if (this.repeatMode != RepeatMode.Restart && j5 % 2 != 0) {
            return ((j5 + 1) * j4) - j3;
        }
        return j3 - (j5 * j4);
    }
}
