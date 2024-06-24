package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import com.google.android.gms.common.zzy;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: VectorizedAnimationSpec.kt */
/* loaded from: classes.dex */
public final class VectorizedFloatAnimationSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public final Animations anims;
    public V endVelocityVector;
    public V valueVector;
    public V velocityVector;

    public VectorizedFloatAnimationSpec(Animations animations) {
        this.anims = animations;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final long getDurationNanos(V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        Iterator<Integer> it = RangesKt___RangesKt.until(0, initialValue.getSize$animation_core_release()).iterator();
        long j = 0;
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            j = Math.max(j, this.anims.get(nextInt).getDurationNanos(initialValue.get$animation_core_release(nextInt), targetValue.get$animation_core_release(nextInt), initialVelocity.get$animation_core_release(nextInt)));
        }
        return j;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final V getEndVelocity(V initialValue, V targetValue, V v) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        if (this.endVelocityVector == null) {
            this.endVelocityVector = (V) zzy.newInstance(v);
        }
        V v2 = this.endVelocityVector;
        if (v2 != null) {
            int size$animation_core_release = v2.getSize$animation_core_release();
            for (int r3 = 0; r3 < size$animation_core_release; r3++) {
                V v3 = this.endVelocityVector;
                if (v3 != null) {
                    v3.set$animation_core_release(this.anims.get(r3).getEndVelocity(initialValue.get$animation_core_release(r3), targetValue.get$animation_core_release(r3), v.get$animation_core_release(r3)), r3);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
                    throw null;
                }
            }
            V v4 = this.endVelocityVector;
            if (v4 != null) {
                return v4;
            }
            Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        throw null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final V getValueFromNanos(long j, V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.valueVector == null) {
            this.valueVector = (V) zzy.newInstance(initialValue);
        }
        V v = this.valueVector;
        if (v != null) {
            int size$animation_core_release = v.getSize$animation_core_release();
            for (int r7 = 0; r7 < size$animation_core_release; r7++) {
                V v2 = this.valueVector;
                if (v2 != null) {
                    v2.set$animation_core_release(this.anims.get(r7).getValueFromNanos(j, initialValue.get$animation_core_release(r7), targetValue.get$animation_core_release(r7), initialVelocity.get$animation_core_release(r7)), r7);
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

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final V getVelocityFromNanos(long j, V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        if (this.velocityVector == null) {
            this.velocityVector = (V) zzy.newInstance(initialVelocity);
        }
        V v = this.velocityVector;
        if (v != null) {
            int size$animation_core_release = v.getSize$animation_core_release();
            for (int r7 = 0; r7 < size$animation_core_release; r7++) {
                V v2 = this.velocityVector;
                if (v2 != null) {
                    v2.set$animation_core_release(this.anims.get(r7).getVelocityFromNanos(j, initialValue.get$animation_core_release(r7), targetValue.get$animation_core_release(r7), initialVelocity.get$animation_core_release(r7)), r7);
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

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public VectorizedFloatAnimationSpec(final FloatAnimationSpec anim) {
        this(new Animations() { // from class: androidx.compose.animation.core.VectorizedFloatAnimationSpec.1
            @Override // androidx.compose.animation.core.Animations
            public final FloatAnimationSpec get(int r1) {
                return FloatAnimationSpec.this;
            }
        });
        Intrinsics.checkNotNullParameter(anim, "anim");
    }
}
