package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animatable.kt */
/* loaded from: classes.dex */
public final class AnimationResult<T, V extends AnimationVector> {
    public final AnimationEndReason endReason;
    public final AnimationState<T, V> endState;

    public AnimationResult(AnimationState<T, V> endState, AnimationEndReason endReason) {
        Intrinsics.checkNotNullParameter(endState, "endState");
        Intrinsics.checkNotNullParameter(endReason, "endReason");
        this.endState = endState;
        this.endReason = endReason;
    }

    public final String toString() {
        return "AnimationResult(endReason=" + this.endReason + ", endState=" + this.endState + ')';
    }
}
