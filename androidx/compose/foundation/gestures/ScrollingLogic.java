package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import com.google.common.collect.Platform;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class ScrollingLogic {
    public final FlingBehavior flingBehavior;
    public final ParcelableSnapshotMutableState isNestedFlinging;
    public final State<NestedScrollDispatcher> nestedScrollDispatcher;
    public final Orientation orientation;
    public final OverscrollEffect overscrollEffect;
    public final boolean reverseDirection;
    public final ScrollableState scrollableState;

    public ScrollingLogic(Orientation orientation, boolean z, MutableState nestedScrollDispatcher, ScrollableState scrollableState, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "nestedScrollDispatcher");
        Intrinsics.checkNotNullParameter(scrollableState, "scrollableState");
        Intrinsics.checkNotNullParameter(flingBehavior, "flingBehavior");
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.scrollableState = scrollableState;
        this.flingBehavior = flingBehavior;
        this.overscrollEffect = overscrollEffect;
        this.isNestedFlinging = Platform.mutableStateOf$default(Boolean.FALSE);
    }

    /* renamed from: dispatchScroll-3eAAhYA */
    public final long m54dispatchScroll3eAAhYA(ScrollScope dispatchScroll, long j, int r8) {
        long m256copydBAh8RU$default;
        Intrinsics.checkNotNullParameter(dispatchScroll, "$this$dispatchScroll");
        boolean z = true;
        if (this.orientation == Orientation.Horizontal) {
            m256copydBAh8RU$default = Offset.m256copydBAh8RU$default(j, 1);
        } else {
            m256copydBAh8RU$default = Offset.m256copydBAh8RU$default(j, 2);
        }
        ScrollingLogic$dispatchScroll$performScroll$1 scrollingLogic$dispatchScroll$performScroll$1 = new ScrollingLogic$dispatchScroll$performScroll$1(this, r8, dispatchScroll);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null) {
            ScrollableState scrollableState = this.scrollableState;
            if (!scrollableState.getCanScrollForward() && !scrollableState.getCanScrollBackward()) {
                z = false;
            }
            if (z) {
                return overscrollEffect.mo16applyToScrollRhakbz0(m256copydBAh8RU$default, r8, scrollingLogic$dispatchScroll$performScroll$1);
            }
        }
        return ((Offset) scrollingLogic$dispatchScroll$performScroll$1.invoke(new Offset(m256copydBAh8RU$default))).packedValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: doFlingAnimation-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m55doFlingAnimationQWom1Mo(long r11, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L13
            r0 = r13
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.jvm.internal.Ref$LongRef r11 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L53
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.jvm.internal.Ref$LongRef r13 = new kotlin.jvm.internal.Ref$LongRef
            r13.<init>()
            r13.element = r11
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r2 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r13
            r7 = r11
            r4.<init>(r5, r6, r7, r9)
            r0.L$0 = r13
            r0.label = r3
            androidx.compose.foundation.gestures.ScrollableState r11 = r10.scrollableState
            java.lang.Object r11 = androidx.compose.foundation.gestures.ScrollableState.scroll$default(r11, r2, r0)
            if (r11 != r1) goto L52
            return r1
        L52:
            r11 = r13
        L53:
            long r11 = r11.element
            androidx.compose.ui.unit.Velocity r13 = new androidx.compose.ui.unit.Velocity
            r13.<init>(r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m55doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* renamed from: onDragStopped-sF-c-tU */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m56onDragStoppedsFctU(long r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 == r4) goto L2f
            if (r2 != r3) goto L27
            goto L2f
        L27:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2f:
            androidx.compose.foundation.gestures.ScrollingLogic r8 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L87
        L35:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.compose.runtime.ParcelableSnapshotMutableState r10 = r7.isNestedFlinging
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r10.setValue(r2)
            androidx.compose.foundation.gestures.Orientation r10 = r7.orientation
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Horizontal
            if (r10 != r2) goto L47
            r10 = r4
            goto L48
        L47:
            r10 = r3
        L48:
            r2 = 0
            long r8 = androidx.compose.ui.unit.Velocity.m603copyOhffZ5M$default(r8, r2, r2, r10)
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1 r10 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1
            r2 = 0
            r10.<init>(r7, r2)
            androidx.compose.foundation.OverscrollEffect r2 = r7.overscrollEffect
            if (r2 == 0) goto L76
            androidx.compose.foundation.gestures.ScrollableState r5 = r7.scrollableState
            boolean r6 = r5.getCanScrollForward()
            if (r6 != 0) goto L68
            boolean r5 = r5.getCanScrollBackward()
            if (r5 == 0) goto L66
            goto L68
        L66:
            r5 = 0
            goto L69
        L68:
            r5 = r4
        L69:
            if (r5 == 0) goto L76
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r2.mo15applyToFlingBMRW4eQ(r8, r10, r0)
            if (r8 != r1) goto L86
            return r1
        L76:
            androidx.compose.ui.unit.Velocity r2 = new androidx.compose.ui.unit.Velocity
            r2.<init>(r8)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r10.invoke(r2, r0)
            if (r8 != r1) goto L86
            return r1
        L86:
            r8 = r7
        L87:
            androidx.compose.runtime.ParcelableSnapshotMutableState r8 = r8.isNestedFlinging
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            r8.setValue(r9)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m56onDragStoppedsFctU(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: toFloat-k-4lQ0M */
    public final float m57toFloatk4lQ0M(long j) {
        if (this.orientation == Orientation.Horizontal) {
            return Offset.m259getXimpl(j);
        }
        return Offset.m260getYimpl(j);
    }

    /* renamed from: toOffset-tuRUvjQ */
    public final long m58toOffsettuRUvjQ(float f) {
        boolean z;
        if (f == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int r4 = Offset.$r8$clinit;
            return Offset.Zero;
        }
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset(f, 0.0f);
        }
        return OffsetKt.Offset(0.0f, f);
    }
}
