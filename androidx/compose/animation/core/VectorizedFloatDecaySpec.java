package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import com.google.android.gms.common.zzy;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DecayAnimationSpec.kt */
/* loaded from: classes.dex */
public final class VectorizedFloatDecaySpec<V extends AnimationVector> implements VectorizedDecayAnimationSpec<V> {
    public final float absVelocityThreshold;
    public final FloatDecayAnimationSpec floatDecaySpec;
    public V targetVector;
    public V valueVector;
    public V velocityVector;

    public VectorizedFloatDecaySpec(FloatDecayAnimationSpec floatDecaySpec) {
        Intrinsics.checkNotNullParameter(floatDecaySpec, "floatDecaySpec");
        this.floatDecaySpec = floatDecaySpec;
        floatDecaySpec.getAbsVelocityThreshold();
        this.absVelocityThreshold = 0.0f;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public final float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public final long getDurationNanos(V initialValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.velocityVector == null) {
            this.velocityVector = (V) zzy.newInstance(initialValue);
        }
        V v = this.velocityVector;
        if (v != null) {
            int size$animation_core_release = v.getSize$animation_core_release();
            long j = 0;
            for (int r3 = 0; r3 < size$animation_core_release; r3++) {
                initialValue.get$animation_core_release(r3);
                j = Math.max(j, this.floatDecaySpec.getDurationNanos(initialVelocity.get$animation_core_release(r3)));
            }
            return j;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        throw null;
    }

    public final V getTargetValue(V initialValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.targetVector == null) {
            this.targetVector = (V) zzy.newInstance(initialValue);
        }
        V v = this.targetVector;
        if (v != null) {
            int size$animation_core_release = v.getSize$animation_core_release();
            for (int r3 = 0; r3 < size$animation_core_release; r3++) {
                V v2 = this.targetVector;
                if (v2 != null) {
                    v2.set$animation_core_release(this.floatDecaySpec.getTargetValue(initialValue.get$animation_core_release(r3), initialVelocity.get$animation_core_release(r3)), r3);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("targetVector");
                    throw null;
                }
            }
            V v3 = this.targetVector;
            if (v3 != null) {
                return v3;
            }
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("targetVector");
        throw null;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public final V getValueFromNanos(long j, V initialValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.valueVector == null) {
            this.valueVector = (V) zzy.newInstance(initialValue);
        }
        V v = this.valueVector;
        if (v != null) {
            int size$animation_core_release = v.getSize$animation_core_release();
            for (int r3 = 0; r3 < size$animation_core_release; r3++) {
                V v2 = this.valueVector;
                if (v2 != null) {
                    v2.set$animation_core_release(this.floatDecaySpec.getValueFromNanos(initialValue.get$animation_core_release(r3), initialVelocity.get$animation_core_release(r3), j), r3);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                    throw null;
                }
            }
            V v3 = this.valueVector;
            if (v3 != null) {
                return v3;
            }
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        throw null;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public final V getVelocityFromNanos(long j, V initialValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.velocityVector == null) {
            this.velocityVector = (V) zzy.newInstance(initialValue);
        }
        V v = this.velocityVector;
        if (v != null) {
            int size$animation_core_release = v.getSize$animation_core_release();
            for (int r3 = 0; r3 < size$animation_core_release; r3++) {
                V v2 = this.velocityVector;
                if (v2 != null) {
                    initialValue.get$animation_core_release(r3);
                    v2.set$animation_core_release(this.floatDecaySpec.getVelocityFromNanos(initialVelocity.get$animation_core_release(r3), j), r3);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                    throw null;
                }
            }
            V v3 = this.velocityVector;
            if (v3 != null) {
                return v3;
            }
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        throw null;
    }
}
