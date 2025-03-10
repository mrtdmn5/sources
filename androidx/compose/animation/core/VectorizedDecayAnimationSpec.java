package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;

/* compiled from: VectorizedDecayAnimationSpec.kt */
/* loaded from: classes.dex */
public interface VectorizedDecayAnimationSpec<V extends AnimationVector> {
    float getAbsVelocityThreshold();

    V getValueFromNanos(long j, V v, V v2);

    V getVelocityFromNanos(long j, V v, V v2);
}
