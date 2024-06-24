package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public final class InfiniteRepeatableSpec<T> implements AnimationSpec<T> {
    public final DurationBasedAnimationSpec<T> animation;
    public final long initialStartOffset;
    public final RepeatMode repeatMode;

    public InfiniteRepeatableSpec() {
        throw null;
    }

    public InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j) {
        this.animation = durationBasedAnimationSpec;
        this.repeatMode = repeatMode;
        this.initialStartOffset = j;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof InfiniteRepeatableSpec)) {
            return false;
        }
        InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) obj;
        if (!Intrinsics.areEqual(infiniteRepeatableSpec.animation, this.animation) || infiniteRepeatableSpec.repeatMode != this.repeatMode) {
            return false;
        }
        if (infiniteRepeatableSpec.initialStartOffset == this.initialStartOffset) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.initialStartOffset) + ((this.repeatMode.hashCode() + (this.animation.hashCode() * 31)) * 31);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final <V extends AnimationVector> VectorizedAnimationSpec<V> vectorize(TwoWayConverter<T, V> converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        return new VectorizedInfiniteRepeatableSpec(this.animation.vectorize((TwoWayConverter) converter), this.repeatMode, this.initialStartOffset);
    }
}
