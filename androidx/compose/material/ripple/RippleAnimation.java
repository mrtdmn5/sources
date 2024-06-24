package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Offset;
import com.google.android.gms.common.zzu;
import com.google.common.collect.Platform;
import kotlinx.coroutines.CompletableDeferredImpl;

/* compiled from: RippleAnimation.kt */
/* loaded from: classes.dex */
public final class RippleAnimation {
    public final boolean bounded;
    public final ParcelableSnapshotMutableState finishRequested$delegate;
    public final ParcelableSnapshotMutableState finishedFadingIn$delegate;
    public Offset origin;
    public final float radius;
    public Float startRadius;
    public Offset targetCenter;
    public Float targetRadius;
    public final Animatable<Float, AnimationVector1D> animatedAlpha = zzu.Animatable$default(0.0f);
    public final Animatable<Float, AnimationVector1D> animatedRadiusPercent = zzu.Animatable$default(0.0f);
    public final Animatable<Float, AnimationVector1D> animatedCenterPercent = zzu.Animatable$default(0.0f);
    public final CompletableDeferredImpl finishSignalDeferred = new CompletableDeferredImpl(null);

    public RippleAnimation(Offset offset, float f, boolean z) {
        this.origin = offset;
        this.radius = f;
        this.bounded = z;
        Boolean bool = Boolean.FALSE;
        this.finishedFadingIn$delegate = Platform.mutableStateOf$default(bool);
        this.finishRequested$delegate = Platform.mutableStateOf$default(bool);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object animate(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.material.ripple.RippleAnimation$animate$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = (androidx.compose.material.ripple.RippleAnimation$animate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = new androidx.compose.material.ripple.RippleAnimation$animate$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L42
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r8)
            goto L87
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L36:
            androidx.compose.material.ripple.RippleAnimation r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6f
        L3c:
            androidx.compose.material.ripple.RippleAnimation r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5b
        L42:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r7
            r0.label = r5
            androidx.compose.material.ripple.RippleAnimation$fadeIn$2 r8 = new androidx.compose.material.ripple.RippleAnimation$fadeIn$2
            r8.<init>(r7, r6)
            java.lang.Object r8 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r8, r0)
            if (r8 != r1) goto L55
            goto L57
        L55:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
        L57:
            if (r8 != r1) goto L5a
            return r1
        L5a:
            r2 = r7
        L5b:
            androidx.compose.runtime.ParcelableSnapshotMutableState r8 = r2.finishedFadingIn$delegate
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r8.setValue(r5)
            r0.L$0 = r2
            r0.label = r4
            kotlinx.coroutines.CompletableDeferredImpl r8 = r2.finishSignalDeferred
            java.lang.Object r8 = r8.await(r0)
            if (r8 != r1) goto L6f
            return r1
        L6f:
            r0.L$0 = r6
            r0.label = r3
            r2.getClass()
            androidx.compose.material.ripple.RippleAnimation$fadeOut$2 r8 = new androidx.compose.material.ripple.RippleAnimation$fadeOut$2
            r8.<init>(r2, r6)
            java.lang.Object r8 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r8, r0)
            if (r8 != r1) goto L82
            goto L84
        L82:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
        L84:
            if (r8 != r1) goto L87
            return r1
        L87:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.RippleAnimation.animate(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
