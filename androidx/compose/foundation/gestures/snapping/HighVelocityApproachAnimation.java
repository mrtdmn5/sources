package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.ScrollScope;
import com.google.android.gms.common.zzw;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapFlingBehavior.kt */
/* loaded from: classes.dex */
public final class HighVelocityApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {
    public final DecayAnimationSpec<Float> decayAnimationSpec;

    public HighVelocityApproachAnimation(DecayAnimationSpec<Float> decayAnimationSpec) {
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "decayAnimationSpec");
        this.decayAnimationSpec = decayAnimationSpec;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public final Object approachAnimation(ScrollScope scrollScope, Float f, Float f2, SnapFlingBehavior$longSnap$3 snapFlingBehavior$longSnap$3, SnapFlingBehaviorKt$approach$1 snapFlingBehaviorKt$approach$1) {
        Object access$animateDecay = SnapFlingBehaviorKt.access$animateDecay(scrollScope, f.floatValue(), zzw.AnimationState$default(f2.floatValue(), 28), this.decayAnimationSpec, snapFlingBehavior$longSnap$3, snapFlingBehaviorKt$approach$1);
        if (access$animateDecay != CoroutineSingletons.COROUTINE_SUSPENDED) {
            return (AnimationResult) access$animateDecay;
        }
        return access$animateDecay;
    }
}
