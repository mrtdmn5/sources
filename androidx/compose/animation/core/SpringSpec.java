package androidx.compose.animation.core;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public final class SpringSpec<T> implements FiniteAnimationSpec<T> {
    public final float dampingRatio;
    public final float stiffness;
    public final T visibilityThreshold;

    public SpringSpec() {
        this(null, 7);
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof SpringSpec)) {
            return false;
        }
        SpringSpec springSpec = (SpringSpec) obj;
        if (springSpec.dampingRatio == this.dampingRatio) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (springSpec.stiffness == this.stiffness) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || !Intrinsics.areEqual(springSpec.visibilityThreshold, this.visibilityThreshold)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int r0;
        T t = this.visibilityThreshold;
        if (t != null) {
            r0 = t.hashCode();
        } else {
            r0 = 0;
        }
        return Float.hashCode(this.stiffness) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.dampingRatio, r0 * 31, 31);
    }

    public SpringSpec(float f, float f2, T t) {
        this.dampingRatio = f;
        this.stiffness = f2;
        this.visibilityThreshold = t;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final <V extends AnimationVector> VectorizedSpringSpec<V> vectorize(TwoWayConverter<T, V> converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        T t = this.visibilityThreshold;
        return new VectorizedSpringSpec<>(this.dampingRatio, this.stiffness, t == null ? null : converter.getConvertToVector().invoke(t));
    }

    public /* synthetic */ SpringSpec(Object obj, int r5) {
        this((r5 & 1) != 0 ? 1.0f : 0.0f, (r5 & 2) != 0 ? 1500.0f : 0.0f, (r5 & 4) != 0 ? null : obj);
    }
}
