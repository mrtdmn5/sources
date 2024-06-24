package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.foundation.ScrollState;
import androidx.compose.ui.unit.Dp;
import com.animaconnected.watch.display.DpUtilsKt;
import com.animaconnected.watch.workout.MetricListItem;
import com.animaconnected.widget.ModifiersKt;
import com.animaconnected.widget.SessionCardData;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: HealthOnboarding.kt */
/* loaded from: classes3.dex */
public final class HealthOnboardingUIState {
    public static final int $stable = 8;
    private final int fadingHeight;
    private final Heights heights;
    private final List<MetricListItem<?>> mockedMetrics;
    private final SessionCardData mockedSession;
    private final Position position;
    private final int screenHeightDp;
    private final ScrollState scrollState;

    /* JADX WARN: Multi-variable type inference failed */
    public HealthOnboardingUIState(ScrollState scrollState, int r9, SessionCardData mockedSession, List<? extends MetricListItem<?>> mockedMetrics) {
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        Intrinsics.checkNotNullParameter(mockedSession, "mockedSession");
        Intrinsics.checkNotNullParameter(mockedMetrics, "mockedMetrics");
        this.scrollState = scrollState;
        this.screenHeightDp = r9;
        this.mockedSession = mockedSession;
        this.mockedMetrics = mockedMetrics;
        this.position = new Position(0.0f, 0.0f, 0.0f, 7, null);
        this.heights = new Heights(0.0f, 0.0f, 3, null);
        this.fadingHeight = DpUtilsKt.toPxInt(ModifiersKt.getDefaultFadingEdgeHeight());
    }

    /* renamed from: getBottomPadding-D9Ej5fM, reason: not valid java name */
    public final float m1020getBottomPaddingD9Ej5fM() {
        Dp dp = new Dp(DpUtilsKt.toDpInt(((DpUtilsKt.toPxInt(this.screenHeightDp) - this.heights.getTopBarPx()) - this.heights.getLastCardPx()) - this.fadingHeight));
        Dp dp2 = new Dp(0);
        if (dp.compareTo(dp2) < 0) {
            dp = dp2;
        }
        return dp.value;
    }

    public final Heights getHeights() {
        return this.heights;
    }

    public final List<MetricListItem<?>> getMockedMetrics() {
        return this.mockedMetrics;
    }

    public final SessionCardData getMockedSession() {
        return this.mockedSession;
    }

    public final Position getPosition() {
        return this.position;
    }

    public final int getScreenHeightDp() {
        return this.screenHeightDp;
    }

    public final ScrollState getScrollState() {
        return this.scrollState;
    }

    public final Object scrollToBottomCard(Continuation<? super Unit> continuation) {
        Object animateScrollTo = this.scrollState.animateScrollTo(MathKt__MathJVMKt.roundToInt(this.position.getBottom()) - this.fadingHeight, HealthOnboardingAnimations.INSTANCE.scrollDownTweenSpec((int) (this.position.getBottom() - this.position.getMetric())), continuation);
        if (animateScrollTo == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return animateScrollTo;
        }
        return Unit.INSTANCE;
    }

    public final Object scrollToMetric(Continuation<? super Unit> continuation) {
        Object animateScrollTo = this.scrollState.animateScrollTo(MathKt__MathJVMKt.roundToInt(this.position.getMetric()) - this.fadingHeight, HealthOnboardingAnimations.INSTANCE.scrollDownTweenSpec((int) (this.position.getMetric() - this.position.getWorkout())), continuation);
        if (animateScrollTo == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return animateScrollTo;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object scrollToTop(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingUIState$scrollToTop$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingUIState$scrollToTop$1 r0 = (com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingUIState$scrollToTop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingUIState$scrollToTop$1 r0 = new com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingUIState$scrollToTop$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L67
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L32:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingUIState r2 = (com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingUIState) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4b
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r4
            r4 = 200(0xc8, double:9.9E-322)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r0)
            if (r7 != r1) goto L4a
            return r1
        L4a:
            r2 = r6
        L4b:
            com.animaconnected.secondo.screens.workout.dashboard.Position r7 = r2.position
            float r7 = r7.getBottom()
            int r7 = (int) r7
            androidx.compose.foundation.ScrollState r2 = r2.scrollState
            com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingAnimations r4 = com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingAnimations.INSTANCE
            androidx.compose.animation.core.TweenSpec r7 = r4.scrollUpTweenSpec(r7)
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            r3 = 0
            java.lang.Object r7 = r2.animateScrollTo(r3, r7, r0)
            if (r7 != r1) goto L67
            return r1
        L67:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingUIState.scrollToTop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object scrollToWorkout(Continuation<? super Unit> continuation) {
        Object animateScrollTo = this.scrollState.animateScrollTo(MathKt__MathJVMKt.roundToInt(this.position.getWorkout()) - this.fadingHeight, HealthOnboardingAnimations.INSTANCE.scrollDownTweenSpec(MathKt__MathJVMKt.roundToInt(this.position.getWorkout())), continuation);
        if (animateScrollTo == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return animateScrollTo;
        }
        return Unit.INSTANCE;
    }
}
