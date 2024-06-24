package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableKt$DefaultScrollMotionDurationScale$1;
import androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$scope$1;
import androidx.compose.foundation.pager.PagerKt$SnapLayoutInfoProvider$1;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapFlingBehavior.kt */
/* loaded from: classes.dex */
public final class SnapFlingBehavior implements FlingBehavior {
    public final Density density;
    public final DecayAnimationSpec<Float> highVelocityAnimationSpec;
    public final AnimationSpec<Float> lowVelocityAnimationSpec;
    public final ScrollableKt$DefaultScrollMotionDurationScale$1 motionScaleDuration;
    public final float shortSnapVelocityThreshold;
    public final AnimationSpec<Float> snapAnimationSpec;
    public final SnapLayoutInfoProvider snapLayoutInfoProvider;
    public final float velocityThreshold;

    public SnapFlingBehavior() {
        throw null;
    }

    public SnapFlingBehavior(PagerKt$SnapLayoutInfoProvider$1 pagerKt$SnapLayoutInfoProvider$1, AnimationSpec lowVelocityAnimationSpec, DecayAnimationSpec highVelocityAnimationSpec, AnimationSpec snapAnimationSpec, Density density, float f) {
        Intrinsics.checkNotNullParameter(lowVelocityAnimationSpec, "lowVelocityAnimationSpec");
        Intrinsics.checkNotNullParameter(highVelocityAnimationSpec, "highVelocityAnimationSpec");
        Intrinsics.checkNotNullParameter(snapAnimationSpec, "snapAnimationSpec");
        Intrinsics.checkNotNullParameter(density, "density");
        this.snapLayoutInfoProvider = pagerKt$SnapLayoutInfoProvider$1;
        this.lowVelocityAnimationSpec = lowVelocityAnimationSpec;
        this.highVelocityAnimationSpec = highVelocityAnimationSpec;
        this.snapAnimationSpec = snapAnimationSpec;
        this.density = density;
        this.shortSnapVelocityThreshold = f;
        this.velocityThreshold = density.mo49toPx0680j_4(f);
        this.motionScaleDuration = ScrollableKt.DefaultScrollMotionDurationScale;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$3] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$longSnap(float r17, androidx.compose.foundation.gestures.ScrollScope r18, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r19, kotlin.coroutines.Continuation r20, final kotlin.jvm.functions.Function1 r21) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.access$longSnap(float, androidx.compose.foundation.gestures.ScrollScope, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, kotlin.coroutines.Continuation, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SnapFlingBehavior)) {
            return false;
        }
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) obj;
        if (!Intrinsics.areEqual(snapFlingBehavior.snapAnimationSpec, this.snapAnimationSpec) || !Intrinsics.areEqual(snapFlingBehavior.highVelocityAnimationSpec, this.highVelocityAnimationSpec) || !Intrinsics.areEqual(snapFlingBehavior.lowVelocityAnimationSpec, this.lowVelocityAnimationSpec) || !Intrinsics.areEqual(snapFlingBehavior.snapLayoutInfoProvider, this.snapLayoutInfoProvider) || !Intrinsics.areEqual(snapFlingBehavior.density, this.density) || !Dp.m579equalsimpl0(snapFlingBehavior.shortSnapVelocityThreshold, this.shortSnapVelocityThreshold)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fling(androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$scope$1 r11, float r12, kotlin.jvm.functions.Function1 r13, kotlin.coroutines.Continuation r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1
            if (r0 == 0) goto L13
            r0 = r14
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.jvm.functions.Function1 r13 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L4c
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            kotlin.ResultKt.throwOnFailure(r14)
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1 r14 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1
            r8 = 0
            r4 = r14
            r5 = r12
            r6 = r11
            r7 = r10
            r9 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.L$0 = r13
            r0.label = r3
            androidx.compose.foundation.gestures.ScrollableKt$DefaultScrollMotionDurationScale$1 r11 = r10.motionScaleDuration
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r11, r14, r0)
            if (r14 != r1) goto L4c
            return r1
        L4c:
            androidx.compose.foundation.gestures.snapping.AnimationResult r14 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r14
            java.lang.Float r11 = new java.lang.Float
            r12 = 0
            r11.<init>(r12)
            r13.invoke(r11)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.fling(androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$scope$1, float, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final int hashCode() {
        return Float.hashCode(this.shortSnapVelocityThreshold) + ((this.density.hashCode() + ((this.snapLayoutInfoProvider.hashCode() + ((this.lowVelocityAnimationSpec.hashCode() + ((this.highVelocityAnimationSpec.hashCode() + ((this.snapAnimationSpec.hashCode() + 0) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object performFling(androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$scope$1 r5, float r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$3
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$3 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$3 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$3
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r8)
            goto L3b
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.label = r3
            java.lang.Object r8 = r4.fling(r5, r6, r7, r0)
            if (r8 != r1) goto L3b
            return r1
        L3b:
            androidx.compose.foundation.gestures.snapping.AnimationResult r8 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r8
            T r5 = r8.remainingOffset
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 != 0) goto L4b
            goto L4c
        L4b:
            r3 = 0
        L4c:
            if (r3 == 0) goto L4f
            goto L5b
        L4f:
            androidx.compose.animation.core.AnimationState<T, V extends androidx.compose.animation.core.AnimationVector> r5 = r8.currentAnimationState
            java.lang.Object r5 = r5.getVelocity()
            java.lang.Number r5 = (java.lang.Number) r5
            float r6 = r5.floatValue()
        L5b:
            java.lang.Float r5 = new java.lang.Float
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$scope$1, float, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final Object performFling(ScrollingLogic$doFlingAnimation$2$scope$1 scrollingLogic$doFlingAnimation$2$scope$1, float f, Continuation continuation) {
        return performFling(scrollingLogic$doFlingAnimation$2$scope$1, f, new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                f2.floatValue();
                return Unit.INSTANCE;
            }
        }, continuation);
    }
}
