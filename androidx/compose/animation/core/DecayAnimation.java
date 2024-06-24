package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import com.google.android.gms.common.zzy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Animation.kt */
/* loaded from: classes.dex */
public final class DecayAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public final VectorizedDecayAnimationSpec<V> animationSpec;
    public final long durationNanos;
    public final V endVelocity;
    public final T initialValue;
    public final V initialValueVector;
    public final V initialVelocityVector;
    public final T targetValue;
    public final TwoWayConverter<T, V> typeConverter;

    public DecayAnimation(DecayAnimationSpec<T> animationSpec, TwoWayConverter<T, V> typeConverter, T t, V initialVelocityVector) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(initialVelocityVector, "initialVelocityVector");
        VectorizedFloatDecaySpec animationSpec2 = animationSpec.vectorize(typeConverter);
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        this.animationSpec = animationSpec2;
        this.typeConverter = typeConverter;
        this.initialValue = t;
        V invoke = typeConverter.getConvertToVector().invoke(t);
        this.initialValueVector = invoke;
        this.initialVelocityVector = (V) zzy.copy(initialVelocityVector);
        this.targetValue = (T) typeConverter.getConvertFromVector().invoke(animationSpec2.getTargetValue(invoke, initialVelocityVector));
        long durationNanos = animationSpec2.getDurationNanos(invoke, initialVelocityVector);
        this.durationNanos = durationNanos;
        V v = (V) zzy.copy(animationSpec2.getVelocityFromNanos(durationNanos, invoke, initialVelocityVector));
        this.endVelocity = v;
        int size$animation_core_release = v.getSize$animation_core_release();
        for (int r4 = 0; r4 < size$animation_core_release; r4++) {
            V v2 = this.endVelocity;
            v2.set$animation_core_release(RangesKt___RangesKt.coerceIn(v2.get$animation_core_release(r4), -this.animationSpec.getAbsVelocityThreshold(), this.animationSpec.getAbsVelocityThreshold()), r4);
        }
    }

    @Override // androidx.compose.animation.core.Animation
    public final long getDurationNanos() {
        return this.durationNanos;
    }

    @Override // androidx.compose.animation.core.Animation
    public final T getTargetValue() {
        return this.targetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.animation.core.Animation
    public final T getValueFromNanos(long j) {
        if (!isFinishedFromNanos(j)) {
            return (T) this.typeConverter.getConvertFromVector().invoke(this.animationSpec.getValueFromNanos(j, this.initialValueVector, this.initialVelocityVector));
        }
        return this.targetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public final V getVelocityVectorFromNanos(long j) {
        if (!isFinishedFromNanos(j)) {
            return this.animationSpec.getVelocityFromNanos(j, this.initialValueVector, this.initialVelocityVector);
        }
        return this.endVelocity;
    }

    @Override // androidx.compose.animation.core.Animation
    public final boolean isInfinite() {
        return false;
    }
}
