package androidx.compose.foundation.gestures;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;

/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class ScrollableKt$scrollableNestedScrollConnection$1 implements NestedScrollConnection {
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ State<ScrollingLogic> $scrollLogic;

    public ScrollableKt$scrollableNestedScrollConnection$1(MutableState mutableState, boolean z) {
        this.$scrollLogic = mutableState;
        this.$enabled = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo51onPostFlingRZ2iAVY(long r3, long r5, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r7) {
        /*
            r2 = this;
            boolean r3 = r7 instanceof androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1
            if (r3 == 0) goto L13
            r3 = r7
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 r3 = (androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1) r3
            int r4 = r3.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.label = r4
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 r3 = new androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1
            r3.<init>(r2, r7)
        L18:
            java.lang.Object r4 = r3.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r3.label
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            long r5 = r3.J$0
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1 r3 = r3.L$0
            kotlin.ResultKt.throwOnFailure(r4)
            goto L50
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.ResultKt.throwOnFailure(r4)
            boolean r4 = r2.$enabled
            if (r4 == 0) goto L59
            androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r4 = r2.$scrollLogic
            java.lang.Object r4 = r4.getValue()
            androidx.compose.foundation.gestures.ScrollingLogic r4 = (androidx.compose.foundation.gestures.ScrollingLogic) r4
            r3.L$0 = r2
            r3.J$0 = r5
            r3.label = r1
            java.lang.Object r4 = r4.m55doFlingAnimationQWom1Mo(r5, r3)
            if (r4 != r7) goto L4f
            return r7
        L4f:
            r3 = r2
        L50:
            androidx.compose.ui.unit.Velocity r4 = (androidx.compose.ui.unit.Velocity) r4
            long r0 = r4.packedValue
            long r4 = androidx.compose.ui.unit.Velocity.m606minusAH228Gc(r5, r0)
            goto L5c
        L59:
            long r4 = androidx.compose.ui.unit.Velocity.Zero
            r3 = r2
        L5c:
            androidx.compose.ui.unit.Velocity r6 = new androidx.compose.ui.unit.Velocity
            r6.<init>(r4)
            androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r3 = r3.$scrollLogic
            java.lang.Object r3 = r3.getValue()
            androidx.compose.foundation.gestures.ScrollingLogic r3 = (androidx.compose.foundation.gestures.ScrollingLogic) r3
            androidx.compose.runtime.ParcelableSnapshotMutableState r3 = r3.isNestedFlinging
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r3.setValue(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1.mo51onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public final long mo52onPostScrollDzOQY0M(int r2, long j, long j2) {
        if (this.$enabled) {
            ScrollingLogic value = this.$scrollLogic.getValue();
            ScrollableState scrollableState = value.scrollableState;
            if (scrollableState.isScrollInProgress()) {
                return Offset.Zero;
            }
            float m57toFloatk4lQ0M = value.m57toFloatk4lQ0M(j2);
            boolean z = value.reverseDirection;
            if (z) {
                m57toFloatk4lQ0M *= -1;
            }
            float dispatchRawDelta = scrollableState.dispatchRawDelta(m57toFloatk4lQ0M);
            if (z) {
                dispatchRawDelta *= -1;
            }
            return value.m58toOffsettuRUvjQ(dispatchRawDelta);
        }
        return Offset.Zero;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public final long mo53onPreScrollOzD1aCk(int r1, long j) {
        boolean z;
        if (r1 == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.$scrollLogic.getValue().isNestedFlinging.setValue(Boolean.TRUE);
        }
        return Offset.Zero;
    }
}
