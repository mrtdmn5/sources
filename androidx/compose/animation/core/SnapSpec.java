package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public final class SnapSpec<T> implements DurationBasedAnimationSpec<T> {
    public final int delay;

    public SnapSpec(int r1) {
        this.delay = r1;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SnapSpec) || ((SnapSpec) obj).delay != this.delay) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.delay;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final <V extends AnimationVector> VectorizedDurationBasedAnimationSpec<V> vectorize(TwoWayConverter<T, V> converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        return new VectorizedSnapSpec(this.delay);
    }

    public SnapSpec() {
        this(0);
    }
}
