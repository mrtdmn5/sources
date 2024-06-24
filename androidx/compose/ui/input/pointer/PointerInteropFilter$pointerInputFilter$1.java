package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.tracing.TraceApi18Impl;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerInteropFilter.android.kt */
/* loaded from: classes.dex */
public final class PointerInteropFilter$pointerInputFilter$1 extends PointerInputFilter {
    public PointerInteropFilter.DispatchToViewState state = PointerInteropFilter.DispatchToViewState.Unknown;
    public final /* synthetic */ PointerInteropFilter this$0;

    public PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter pointerInteropFilter) {
        this.this$0 = pointerInteropFilter;
    }

    public final void dispatchToView(PointerEvent pointerEvent) {
        boolean z;
        List<PointerInputChange> list = pointerEvent.changes;
        int size = list.size();
        int r3 = 0;
        while (true) {
            if (r3 < size) {
                if (list.get(r3).isConsumed()) {
                    z = true;
                    break;
                }
                r3++;
            } else {
                z = false;
                break;
            }
        }
        final PointerInteropFilter pointerInteropFilter = this.this$0;
        if (z) {
            if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
                LayoutCoordinates layoutCoordinates = this.layoutCoordinates;
                if (layoutCoordinates != null) {
                    TraceApi18Impl.m612toMotionEventScopeubNVwUQ(pointerEvent, layoutCoordinates.mo425localToRootMKHz9U(Offset.Zero), new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(MotionEvent motionEvent) {
                            MotionEvent motionEvent2 = motionEvent;
                            Intrinsics.checkNotNullParameter(motionEvent2, "motionEvent");
                            Function1<? super MotionEvent, Boolean> function1 = PointerInteropFilter.this.onTouchEvent;
                            if (function1 != null) {
                                function1.invoke(motionEvent2);
                                return Unit.INSTANCE;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("onTouchEvent");
                            throw null;
                        }
                    }, true);
                } else {
                    throw new IllegalStateException("layoutCoordinates not set".toString());
                }
            }
            this.state = PointerInteropFilter.DispatchToViewState.NotDispatching;
            return;
        }
        LayoutCoordinates layoutCoordinates2 = this.layoutCoordinates;
        if (layoutCoordinates2 != null) {
            TraceApi18Impl.m612toMotionEventScopeubNVwUQ(pointerEvent, layoutCoordinates2.mo425localToRootMKHz9U(Offset.Zero), new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(MotionEvent motionEvent) {
                    PointerInteropFilter.DispatchToViewState dispatchToViewState;
                    MotionEvent motionEvent2 = motionEvent;
                    Intrinsics.checkNotNullParameter(motionEvent2, "motionEvent");
                    int actionMasked = motionEvent2.getActionMasked();
                    PointerInteropFilter pointerInteropFilter2 = pointerInteropFilter;
                    if (actionMasked == 0) {
                        Function1<? super MotionEvent, Boolean> function1 = pointerInteropFilter2.onTouchEvent;
                        if (function1 != null) {
                            if (function1.invoke(motionEvent2).booleanValue()) {
                                dispatchToViewState = PointerInteropFilter.DispatchToViewState.Dispatching;
                            } else {
                                dispatchToViewState = PointerInteropFilter.DispatchToViewState.NotDispatching;
                            }
                            PointerInteropFilter$pointerInputFilter$1.this.state = dispatchToViewState;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("onTouchEvent");
                            throw null;
                        }
                    } else {
                        Function1<? super MotionEvent, Boolean> function12 = pointerInteropFilter2.onTouchEvent;
                        if (function12 != null) {
                            function12.invoke(motionEvent2);
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("onTouchEvent");
                            throw null;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, false);
            if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
                int size2 = list.size();
                for (int r2 = 0; r2 < size2; r2++) {
                    list.get(r2).consume();
                }
                InternalPointerEvent internalPointerEvent = pointerEvent.internalPointerEvent;
                if (internalPointerEvent != null) {
                    internalPointerEvent.suppressMovementConsumption = !pointerInteropFilter.disallowIntercept;
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("layoutCoordinates not set".toString());
    }

    public final void onCancel() {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            long uptimeMillis = SystemClock.uptimeMillis();
            final PointerInteropFilter pointerInteropFilter = this.this$0;
            Function1<MotionEvent, Unit> function1 = new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$onCancel$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(MotionEvent motionEvent) {
                    MotionEvent motionEvent2 = motionEvent;
                    Intrinsics.checkNotNullParameter(motionEvent2, "motionEvent");
                    Function1<? super MotionEvent, Boolean> function12 = PointerInteropFilter.this.onTouchEvent;
                    if (function12 != null) {
                        function12.invoke(motionEvent2);
                        return Unit.INSTANCE;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("onTouchEvent");
                    throw null;
                }
            };
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            obtain.setSource(0);
            function1.invoke(obtain);
            obtain.recycle();
            this.state = PointerInteropFilter.DispatchToViewState.Unknown;
            pointerInteropFilter.disallowIntercept = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* renamed from: onPointerEvent-H0pRuoY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m417onPointerEventH0pRuoY(androidx.compose.ui.input.pointer.PointerEvent r9, androidx.compose.ui.input.pointer.PointerEventPass r10) {
        /*
            r8 = this;
            java.lang.String r0 = "pass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.compose.ui.input.pointer.PointerInteropFilter r0 = r8.this$0
            boolean r1 = r0.disallowIntercept
            r2 = 0
            r3 = 1
            java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r9.changes
            if (r1 != 0) goto L39
            int r1 = r4.size()
            r5 = r2
        L14:
            if (r5 >= r1) goto L33
            java.lang.Object r6 = r4.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r6)
            if (r7 != 0) goto L2b
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r6)
            if (r6 == 0) goto L29
            goto L2b
        L29:
            r6 = r2
            goto L2c
        L2b:
            r6 = r3
        L2c:
            if (r6 == 0) goto L30
            r1 = r3
            goto L34
        L30:
            int r5 = r5 + 1
            goto L14
        L33:
            r1 = r2
        L34:
            if (r1 == 0) goto L37
            goto L39
        L37:
            r1 = r2
            goto L3a
        L39:
            r1 = r3
        L3a:
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r5 = r8.state
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r6 = androidx.compose.ui.input.pointer.PointerInteropFilter.DispatchToViewState.NotDispatching
            if (r5 == r6) goto L52
            androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            if (r10 != r5) goto L49
            if (r1 == 0) goto L49
            r8.dispatchToView(r9)
        L49:
            androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r10 != r5) goto L52
            if (r1 != 0) goto L52
            r8.dispatchToView(r9)
        L52:
            androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r10 != r9) goto L76
            int r9 = r4.size()
            r10 = r2
        L5b:
            if (r10 >= r9) goto L6e
            java.lang.Object r1 = r4.get(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r1)
            if (r1 != 0) goto L6b
            r3 = r2
            goto L6e
        L6b:
            int r10 = r10 + 1
            goto L5b
        L6e:
            if (r3 == 0) goto L76
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r9 = androidx.compose.ui.input.pointer.PointerInteropFilter.DispatchToViewState.Unknown
            r8.state = r9
            r0.disallowIntercept = r2
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1.m417onPointerEventH0pRuoY(androidx.compose.ui.input.pointer.PointerEvent, androidx.compose.ui.input.pointer.PointerEventPass):void");
    }
}
