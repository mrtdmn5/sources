package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorizedAnimationSpec.kt */
/* loaded from: classes.dex */
public interface VectorizedAnimationSpec<V extends AnimationVector> {
    long getDurationNanos(V v, V v2, V v3);

    default V getEndVelocity(V initialValue, V targetValue, V v) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        return getVelocityFromNanos(getDurationNanos(initialValue, targetValue, v), initialValue, targetValue, v);
    }

    V getValueFromNanos(long j, V v, V v2, V v3);

    V getVelocityFromNanos(long j, V v, V v2, V v3);

    boolean isInfinite();
}
