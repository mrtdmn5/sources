package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import com.google.android.gms.common.zzw;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapFlingBehavior.kt */
/* loaded from: classes.dex */
public final class LowVelocityApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {
    public final Density density;
    public final SnapLayoutInfoProvider layoutInfoProvider;
    public final AnimationSpec<Float> lowVelocityAnimationSpec;

    public LowVelocityApproachAnimation(AnimationSpec<Float> lowVelocityAnimationSpec, SnapLayoutInfoProvider layoutInfoProvider, Density density) {
        Intrinsics.checkNotNullParameter(lowVelocityAnimationSpec, "lowVelocityAnimationSpec");
        Intrinsics.checkNotNullParameter(layoutInfoProvider, "layoutInfoProvider");
        Intrinsics.checkNotNullParameter(density, "density");
        this.lowVelocityAnimationSpec = lowVelocityAnimationSpec;
        this.layoutInfoProvider = layoutInfoProvider;
        this.density = density;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public final Object approachAnimation(ScrollScope scrollScope, Float f, Float f2, SnapFlingBehavior$longSnap$3 snapFlingBehavior$longSnap$3, SnapFlingBehaviorKt$approach$1 snapFlingBehaviorKt$approach$1) {
        float floatValue = f.floatValue();
        float floatValue2 = f2.floatValue();
        Object access$animateSnap = SnapFlingBehaviorKt.access$animateSnap(scrollScope, Math.signum(floatValue2) * (this.layoutInfoProvider.calculateSnapStepSize(this.density) + Math.abs(floatValue)), floatValue, zzw.AnimationState$default(floatValue2, 28), this.lowVelocityAnimationSpec, snapFlingBehavior$longSnap$3, snapFlingBehaviorKt$approach$1);
        if (access$animateSnap != CoroutineSingletons.COROUTINE_SUSPENDED) {
            return (AnimationResult) access$animateSnap;
        }
        return access$animateSnap;
    }
}
