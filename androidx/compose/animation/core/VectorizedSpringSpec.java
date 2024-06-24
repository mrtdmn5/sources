package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: VectorizedAnimationSpec.kt */
/* loaded from: classes.dex */
public final class VectorizedSpringSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public final /* synthetic */ VectorizedFloatAnimationSpec<V> $$delegate_0;

    public VectorizedSpringSpec(final float f, final float f2, final V v) {
        Animations animations;
        if (v != null) {
            animations = new Animations(f, f2, v) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt$createSpringAnimations$1
                public final ArrayList anims;

                /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
                {
                    IntRange until = RangesKt___RangesKt.until(0, v.getSize$animation_core_release());
                    ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
                    ?? it = until.iterator();
                    while (it.hasNext) {
                        arrayList.add(new FloatSpringSpec(f, f2, v.get$animation_core_release(it.nextInt())));
                    }
                    this.anims = arrayList;
                }

                @Override // androidx.compose.animation.core.Animations
                public final FloatAnimationSpec get(int r2) {
                    return (FloatSpringSpec) this.anims.get(r2);
                }
            };
        } else {
            animations = new Animations(f, f2) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt$createSpringAnimations$2
                public final FloatSpringSpec anim;

                {
                    this.anim = new FloatSpringSpec(f, f2, 4);
                }

                @Override // androidx.compose.animation.core.Animations
                public final FloatAnimationSpec get(int r1) {
                    return this.anim;
                }
            };
        }
        this.$$delegate_0 = new VectorizedFloatAnimationSpec<>(animations);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final long getDurationNanos(V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        return this.$$delegate_0.getDurationNanos(initialValue, targetValue, initialVelocity);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final V getEndVelocity(V initialValue, V targetValue, V v) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        return this.$$delegate_0.getEndVelocity(initialValue, targetValue, v);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final V getValueFromNanos(long j, V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        return this.$$delegate_0.getValueFromNanos(j, initialValue, targetValue, initialVelocity);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final V getVelocityFromNanos(long j, V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        return this.$$delegate_0.getVelocityFromNanos(j, initialValue, targetValue, initialVelocity);
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public final boolean isInfinite() {
        this.$$delegate_0.getClass();
        return false;
    }
}
