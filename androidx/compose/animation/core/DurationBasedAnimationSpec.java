package androidx.compose.animation.core;

/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public interface DurationBasedAnimationSpec<T> extends FiniteAnimationSpec<T> {
    @Override // androidx.compose.animation.core.AnimationSpec
    <V extends AnimationVector> VectorizedDurationBasedAnimationSpec<V> vectorize(TwoWayConverter<T, V> twoWayConverter);
}
