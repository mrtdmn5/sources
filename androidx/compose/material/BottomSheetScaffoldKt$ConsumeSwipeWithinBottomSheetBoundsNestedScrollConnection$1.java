package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;

/* compiled from: BottomSheetScaffold.kt */
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 implements NestedScrollConnection {
    public final /* synthetic */ Orientation $orientation;
    public final /* synthetic */ AnchoredDraggableState<?> $state;

    public BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        this.$state = anchoredDraggableState;
        this.$orientation = orientation;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo51onPostFlingRZ2iAVY(long r3, long r5, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r7) {
        /*
            r2 = this;
            boolean r3 = r7 instanceof androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
            if (r3 == 0) goto L13
            r3 = r7
            androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r3 = (androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r3
            int r4 = r3.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.label = r4
            goto L18
        L13:
            androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r3 = new androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
            r3.<init>(r2, r7)
        L18:
            java.lang.Object r4 = r3.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r3.label
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 != r1) goto L29
            long r5 = r3.J$0
            kotlin.ResultKt.throwOnFailure(r4)
            goto L50
        L29:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L31:
            kotlin.ResultKt.throwOnFailure(r4)
            androidx.compose.foundation.gestures.Orientation r4 = r2.$orientation
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
            if (r4 != r0) goto L3f
            float r4 = androidx.compose.ui.unit.Velocity.m604getXimpl(r5)
            goto L43
        L3f:
            float r4 = androidx.compose.ui.unit.Velocity.m605getYimpl(r5)
        L43:
            r3.J$0 = r5
            r3.label = r1
            androidx.compose.material.AnchoredDraggableState<?> r0 = r2.$state
            java.lang.Object r3 = r0.settle(r4, r3)
            if (r3 != r7) goto L50
            return r7
        L50:
            androidx.compose.ui.unit.Velocity r3 = new androidx.compose.ui.unit.Velocity
            r3.<init>(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1.mo51onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public final long mo52onPostScrollDzOQY0M(int r1, long j, long j2) {
        float m260getYimpl;
        float f;
        boolean z = true;
        if (r1 != 1) {
            z = false;
        }
        if (z) {
            Orientation orientation = Orientation.Horizontal;
            Orientation orientation2 = this.$orientation;
            if (orientation2 == orientation) {
                m260getYimpl = Offset.m259getXimpl(j2);
            } else {
                m260getYimpl = Offset.m260getYimpl(j2);
            }
            float dispatchRawDelta = this.$state.dispatchRawDelta(m260getYimpl);
            if (orientation2 == orientation) {
                f = dispatchRawDelta;
            } else {
                f = 0.0f;
            }
            if (orientation2 != Orientation.Vertical) {
                dispatchRawDelta = 0.0f;
            }
            return OffsetKt.Offset(f, dispatchRawDelta);
        }
        return Offset.Zero;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo159onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            long r7 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6b
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.foundation.gestures.Orientation r9 = r6.$orientation
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Horizontal
            if (r9 != r2) goto L3f
            float r9 = androidx.compose.ui.unit.Velocity.m604getXimpl(r7)
            goto L43
        L3f:
            float r9 = androidx.compose.ui.unit.Velocity.m605getYimpl(r7)
        L43:
            androidx.compose.material.AnchoredDraggableState<?> r2 = r6.$state
            float r4 = r2.requireOffset()
            r5 = 0
            int r5 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r5 >= 0) goto L69
            androidx.compose.runtime.DerivedSnapshotState r5 = r2.minOffset$delegate
            java.lang.Object r5 = r5.getValue()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L69
            r0.J$0 = r7
            r0.label = r3
            java.lang.Object r9 = r2.settle(r9, r0)
            if (r9 != r1) goto L6b
            return r1
        L69:
            long r7 = androidx.compose.ui.unit.Velocity.Zero
        L6b:
            androidx.compose.ui.unit.Velocity r9 = new androidx.compose.ui.unit.Velocity
            r9.<init>(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1.mo159onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public final long mo53onPreScrollOzD1aCk(int r4, long j) {
        float m260getYimpl;
        float f;
        Orientation orientation = Orientation.Horizontal;
        Orientation orientation2 = this.$orientation;
        if (orientation2 == orientation) {
            m260getYimpl = Offset.m259getXimpl(j);
        } else {
            m260getYimpl = Offset.m260getYimpl(j);
        }
        float f2 = 0.0f;
        if (m260getYimpl < 0.0f) {
            boolean z = true;
            if (r4 != 1) {
                z = false;
            }
            if (z) {
                float dispatchRawDelta = this.$state.dispatchRawDelta(m260getYimpl);
                if (orientation2 == orientation) {
                    f = dispatchRawDelta;
                } else {
                    f = 0.0f;
                }
                if (orientation2 == Orientation.Vertical) {
                    f2 = dispatchRawDelta;
                }
                return OffsetKt.Offset(f, f2);
            }
        }
        return Offset.Zero;
    }
}
