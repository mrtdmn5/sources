package androidx.compose.animation.core;

import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public final class TweenSpec<T> implements DurationBasedAnimationSpec<T> {
    public final int delay;
    public final int durationMillis;
    public final Easing easing;

    public TweenSpec() {
        this(0, 0, null, 7);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TweenSpec)) {
            return false;
        }
        TweenSpec tweenSpec = (TweenSpec) obj;
        if (tweenSpec.durationMillis != this.durationMillis || tweenSpec.delay != this.delay || !Intrinsics.areEqual(tweenSpec.easing, this.easing)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.easing.hashCode() + (this.durationMillis * 31)) * 31) + this.delay;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final VectorizedAnimationSpec vectorize(TwoWayConverter converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        return new VectorizedTweenSpec(this.durationMillis, this.delay, this.easing);
    }

    public TweenSpec(int r2, int r3, Easing easing, int r5) {
        this((r5 & 1) != 0 ? TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY : r2, (r5 & 2) != 0 ? 0 : r3, (r5 & 4) != 0 ? EasingKt.FastOutSlowInEasing : easing);
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final VectorizedDurationBasedAnimationSpec vectorize(TwoWayConverter converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        return new VectorizedTweenSpec(this.durationMillis, this.delay, this.easing);
    }

    public TweenSpec(int r2, int r3, Easing easing) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.durationMillis = r2;
        this.delay = r3;
        this.easing = easing;
    }
}
