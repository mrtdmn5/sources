package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;

/* compiled from: VectorizedAnimationSpec.kt */
/* loaded from: classes.dex */
public interface VectorizedFiniteAnimationSpec<V extends AnimationVector> extends VectorizedAnimationSpec<V> {
    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    default boolean isInfinite() {
        return false;
    }
}
