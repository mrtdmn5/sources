package androidx.compose.foundation.gestures.snapping;

/* compiled from: SnapFlingBehavior.kt */
/* loaded from: classes.dex */
public final class SnapFlingBehaviorKt {
    public static final float MinFlingVelocityDp = 400;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$animateDecay(final androidx.compose.foundation.gestures.ScrollScope r5, final float r6, androidx.compose.animation.core.AnimationState r7, androidx.compose.animation.core.DecayAnimationSpec r8, final androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$3 r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            float r6 = r0.F$0
            kotlin.jvm.internal.Ref$FloatRef r5 = r0.L$1
            androidx.compose.animation.core.AnimationState r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L65
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.jvm.internal.Ref$FloatRef r10 = new kotlin.jvm.internal.Ref$FloatRef
            r10.<init>()
            java.lang.Object r2 = r7.getVelocity()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L4e
            r2 = r3
            goto L4f
        L4e:
            r2 = 0
        L4f:
            r2 = r2 ^ r3
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2 r4 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2
            r4.<init>()
            r0.L$0 = r7
            r0.L$1 = r10
            r0.F$0 = r6
            r0.label = r3
            java.lang.Object r5 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay(r7, r8, r2, r4, r0)
            if (r5 != r1) goto L64
            goto L72
        L64:
            r5 = r10
        L65:
            androidx.compose.foundation.gestures.snapping.AnimationResult r1 = new androidx.compose.foundation.gestures.snapping.AnimationResult
            float r5 = r5.element
            float r6 = r6 - r5
            java.lang.Float r5 = new java.lang.Float
            r5.<init>(r6)
            r1.<init>(r5, r7)
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.access$animateDecay(androidx.compose.foundation.gestures.ScrollScope, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$animateSnap(final androidx.compose.foundation.gestures.ScrollScope r8, float r9, final float r10, androidx.compose.animation.core.AnimationState r11, androidx.compose.animation.core.AnimationSpec r12, final kotlin.jvm.functions.Function1 r13, kotlin.coroutines.Continuation r14) {
        /*
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1
            if (r0 == 0) goto L13
            r0 = r14
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1
            r0.<init>(r14)
        L18:
            r6 = r0
            java.lang.Object r14 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            float r8 = r6.F$1
            float r9 = r6.F$0
            kotlin.jvm.internal.Ref$FloatRef r10 = r6.L$1
            androidx.compose.animation.core.AnimationState r11 = r6.L$0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L7e
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.jvm.internal.Ref$FloatRef r14 = new kotlin.jvm.internal.Ref$FloatRef
            r14.<init>()
            java.lang.Object r1 = r11.getVelocity()
            java.lang.Number r1 = (java.lang.Number) r1
            float r7 = r1.floatValue()
            java.lang.Float r3 = new java.lang.Float
            r3.<init>(r9)
            java.lang.Object r1 = r11.getVelocity()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L60
            r1 = r2
            goto L61
        L60:
            r1 = 0
        L61:
            r4 = r1 ^ 1
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$2 r5 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$2
            r5.<init>()
            r6.L$0 = r11
            r6.L$1 = r14
            r6.F$0 = r9
            r6.F$1 = r7
            r6.label = r2
            r1 = r11
            r2 = r3
            r3 = r12
            java.lang.Object r8 = androidx.compose.animation.core.SuspendAnimationKt.animateTo(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L7c
            goto L9f
        L7c:
            r10 = r14
            r8 = r7
        L7e:
            java.lang.Object r12 = r11.getVelocity()
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            float r8 = coerceToTarget(r12, r8)
            androidx.compose.foundation.gestures.snapping.AnimationResult r0 = new androidx.compose.foundation.gestures.snapping.AnimationResult
            float r10 = r10.element
            float r9 = r9 - r10
            java.lang.Float r10 = new java.lang.Float
            r10.<init>(r9)
            r9 = 29
            androidx.compose.animation.core.AnimationState r8 = com.google.android.gms.common.zzw.copy$default(r11, r8, r9)
            r0.<init>(r10, r8)
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.access$animateSnap(androidx.compose.foundation.gestures.ScrollScope, float, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.AnimationSpec, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$approach(androidx.compose.foundation.gestures.ScrollScope r7, float r8, float r9, androidx.compose.foundation.gestures.snapping.ApproachAnimation r10, androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r11, androidx.compose.ui.unit.Density r12, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$3 r13, kotlin.coroutines.Continuation r14) {
        /*
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1
            if (r0 == 0) goto L13
            r0 = r14
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1
            r0.<init>(r14)
        L18:
            r6 = r0
            java.lang.Object r14 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            androidx.compose.ui.unit.Density r12 = r6.L$1
            androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r11 = r6.L$0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L51
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Float r3 = new java.lang.Float
            r3.<init>(r8)
            java.lang.Float r4 = new java.lang.Float
            r4.<init>(r9)
            r6.L$0 = r11
            r6.L$1 = r12
            r6.label = r2
            r1 = r10
            r2 = r7
            r5 = r13
            java.lang.Object r14 = r1.approachAnimation(r2, r3, r4, r5, r6)
            if (r14 != r0) goto L51
            goto L6d
        L51:
            androidx.compose.foundation.gestures.snapping.AnimationResult r14 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r14
            androidx.compose.animation.core.AnimationState<T, V extends androidx.compose.animation.core.AnimationVector> r7 = r14.currentAnimationState
            java.lang.Object r8 = r7.getVelocity()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            float r8 = r11.calculateSnappingOffset(r8, r12)
            androidx.compose.foundation.gestures.snapping.AnimationResult r0 = new androidx.compose.foundation.gestures.snapping.AnimationResult
            java.lang.Float r9 = new java.lang.Float
            r9.<init>(r8)
            r0.<init>(r9, r7)
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.access$approach(androidx.compose.foundation.gestures.ScrollScope, float, float, androidx.compose.foundation.gestures.snapping.ApproachAnimation, androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider, androidx.compose.ui.unit.Density, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final float coerceToTarget(float f, float f2) {
        boolean z;
        if (f2 == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return 0.0f;
        }
        if (f2 > 0.0f) {
            if (f <= f2) {
                return f;
            }
        } else if (f >= f2) {
            return f;
        }
        return f2;
    }
}
