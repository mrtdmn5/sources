package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapFlingBehavior.kt */
/* loaded from: classes.dex */
public final class AnimationResult<T, V extends AnimationVector> {
    public final AnimationState<T, V> currentAnimationState;
    public final T remainingOffset;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimationResult(Float f, AnimationState currentAnimationState) {
        Intrinsics.checkNotNullParameter(currentAnimationState, "currentAnimationState");
        this.remainingOffset = f;
        this.currentAnimationState = currentAnimationState;
    }
}
