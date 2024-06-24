package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import com.google.android.gms.common.zzy;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animation.kt */
/* loaded from: classes.dex */
public final class TargetBasedAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public final VectorizedAnimationSpec<V> animationSpec;
    public final long durationNanos;
    public final V endVelocity;
    public final T initialValue;
    public final V initialValueVector;
    public final V initialVelocityVector;
    public final T targetValue;
    public final V targetValueVector;
    public final TwoWayConverter<T, V> typeConverter;

    public TargetBasedAnimation() {
        throw null;
    }

    public /* synthetic */ TargetBasedAnimation(AnimationSpec animationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2) {
        this(animationSpec, twoWayConverter, obj, obj2, null);
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
            V valueFromNanos = this.animationSpec.getValueFromNanos(j, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
            int size$animation_core_release = valueFromNanos.getSize$animation_core_release();
            for (int r2 = 0; r2 < size$animation_core_release; r2++) {
                if (!(!Float.isNaN(valueFromNanos.get$animation_core_release(r2)))) {
                    throw new IllegalStateException(("AnimationVector cannot contain a NaN. " + valueFromNanos + ". Animation: " + this + ", playTimeNanos: " + j).toString());
                }
            }
            return this.typeConverter.getConvertFromVector().invoke(valueFromNanos);
        }
        return this.targetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public final V getVelocityVectorFromNanos(long j) {
        if (!isFinishedFromNanos(j)) {
            return this.animationSpec.getVelocityFromNanos(j, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        }
        return this.endVelocity;
    }

    @Override // androidx.compose.animation.core.Animation
    public final boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    public final String toString() {
        return "TargetBasedAnimation: " + this.initialValue + " -> " + this.targetValue + ",initial velocity: " + this.initialVelocityVector + ", duration: " + (getDurationNanos() / 1000000) + " ms,animationSpec: " + this.animationSpec;
    }

    public TargetBasedAnimation(AnimationSpec<T> animationSpec, TwoWayConverter<T, V> typeConverter, T t, T t2, V v) {
        V v2;
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        VectorizedAnimationSpec<V> animationSpec2 = animationSpec.vectorize(typeConverter);
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        this.animationSpec = animationSpec2;
        this.typeConverter = typeConverter;
        this.initialValue = t;
        this.targetValue = t2;
        V invoke = typeConverter.getConvertToVector().invoke(t);
        this.initialValueVector = invoke;
        V invoke2 = typeConverter.getConvertToVector().invoke(t2);
        this.targetValueVector = invoke2;
        if (v != null) {
            v2 = (V) zzy.copy(v);
        } else {
            v2 = (V) zzy.newInstance(typeConverter.getConvertToVector().invoke(t));
        }
        this.initialVelocityVector = v2;
        this.durationNanos = animationSpec2.getDurationNanos(invoke, invoke2, v2);
        this.endVelocity = animationSpec2.getEndVelocity(invoke, invoke2, v2);
    }
}
