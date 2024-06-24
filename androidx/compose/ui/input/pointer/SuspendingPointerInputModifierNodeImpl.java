package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.StandaloneCoroutine;

/* compiled from: SuspendingPointerInputFilter.kt */
/* loaded from: classes.dex */
public final class SuspendingPointerInputModifierNodeImpl extends Modifier.Node implements SuspendingPointerInputModifierNode, PointerInputScope, Density {
    public long boundsSize;
    public PointerEvent currentEvent;
    public final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    public PointerEvent lastPointerEvent;
    public final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers;
    public Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> pointerInputHandler;
    public StandaloneCoroutine pointerInputJob;

    /* compiled from: SuspendingPointerInputFilter.kt */
    /* loaded from: classes.dex */
    public final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {
        public final /* synthetic */ SuspendingPointerInputModifierNodeImpl $$delegate_0;
        public final Continuation<R> completion;
        public CancellableContinuation<? super PointerEvent> pointerAwaiter;
        public PointerEventPass awaitPass = PointerEventPass.Main;
        public final EmptyCoroutineContext context = EmptyCoroutineContext.INSTANCE;

        public PointerEventHandlerCoroutine(CancellableContinuationImpl cancellableContinuationImpl) {
            this.completion = cancellableContinuationImpl;
            this.$$delegate_0 = SuspendingPointerInputModifierNodeImpl.this;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public final Object awaitPointerEvent(PointerEventPass pointerEventPass, BaseContinuationImpl baseContinuationImpl) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(baseContinuationImpl));
            cancellableContinuationImpl.initCancellability();
            this.awaitPass = pointerEventPass;
            this.pointerAwaiter = cancellableContinuationImpl;
            Object result = cancellableContinuationImpl.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return result;
        }

        @Override // kotlin.coroutines.Continuation
        public final CoroutineContext getContext() {
            return this.context;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public final PointerEvent getCurrentEvent() {
            return SuspendingPointerInputModifierNodeImpl.this.currentEvent;
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getExtendedTouchPadding-NH-jbRc */
        public final long mo406getExtendedTouchPaddingNHjbRc() {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            suspendingPointerInputModifierNodeImpl.getClass();
            long mo50toSizeXkaWNTQ = suspendingPointerInputModifierNodeImpl.mo50toSizeXkaWNTQ(DelegatableNodeKt.requireLayoutNode(suspendingPointerInputModifierNodeImpl).viewConfiguration.mo449getMinimumTouchTargetSizeMYxV2XQ());
            long j = suspendingPointerInputModifierNodeImpl.boundsSize;
            return SizeKt.Size(Math.max(0.0f, Size.m276getWidthimpl(mo50toSizeXkaWNTQ) - ((int) (j >> 32))) / 2.0f, Math.max(0.0f, Size.m274getHeightimpl(mo50toSizeXkaWNTQ) - IntSize.m593getHeightimpl(j)) / 2.0f);
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getSize-YbymL2g */
        public final long mo407getSizeYbymL2g() {
            return SuspendingPointerInputModifierNodeImpl.this.boundsSize;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public final ViewConfiguration getViewConfiguration() {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            suspendingPointerInputModifierNodeImpl.getClass();
            return DelegatableNodeKt.requireLayoutNode(suspendingPointerInputModifierNodeImpl).viewConfiguration;
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object obj) {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            synchronized (suspendingPointerInputModifierNodeImpl.pointerHandlers) {
                suspendingPointerInputModifierNodeImpl.pointerHandlers.remove(this);
                Unit unit = Unit.INSTANCE;
            }
            this.completion.resumeWith(obj);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public final int mo44roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo44roundToPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public final float mo46toDpu2uoSUM(int r2) {
            return this.$$delegate_0.mo46toDpu2uoSUM(r2);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public final long mo47toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo47toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public final float mo48toPxR2X_6o(long j) {
            return this.$$delegate_0.mo48toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public final float mo49toPx0680j_4(float f) {
            return this.$$delegate_0.getDensity() * f;
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public final long mo50toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo50toSizeXkaWNTQ(j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
        /* JADX WARN: Type inference failed for: r7v0, types: [long] */
        /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r7v4, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final <T> java.lang.Object withTimeout(long r7, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super T> r10) {
            /*
                r6 = this;
                boolean r0 = r10 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1
                if (r0 == 0) goto L13
                r0 = r10
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1
                r0.<init>(r6, r10)
            L18:
                java.lang.Object r10 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlinx.coroutines.StandaloneCoroutine r7 = r0.L$0
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L6c
                goto L66
            L29:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L31:
                kotlin.ResultKt.throwOnFailure(r10)
                r4 = 0
                int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
                if (r10 > 0) goto L4a
                kotlinx.coroutines.CancellableContinuation<? super androidx.compose.ui.input.pointer.PointerEvent> r10 = r6.pointerAwaiter
                if (r10 == 0) goto L4a
                androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r2 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
                r2.<init>(r7)
                kotlin.Result$Failure r2 = kotlin.ResultKt.createFailure(r2)
                r10.resumeWith(r2)
            L4a:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r10 = androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.this
                kotlinx.coroutines.CoroutineScope r10 = r10.getCoroutineScope()
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 r2 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1
                r4 = 0
                r2.<init>(r7, r6, r4)
                r7 = 3
                kotlinx.coroutines.StandaloneCoroutine r7 = kotlinx.coroutines.BuildersKt.launch$default(r10, r4, r4, r2, r7)
                r0.L$0 = r7     // Catch: java.lang.Throwable -> L6c
                r0.label = r3     // Catch: java.lang.Throwable -> L6c
                java.lang.Object r10 = r9.invoke(r6, r0)     // Catch: java.lang.Throwable -> L6c
                if (r10 != r1) goto L66
                return r1
            L66:
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r8 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.INSTANCE
                r7.cancel(r8)
                return r10
            L6c:
                r8 = move-exception
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r9 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.INSTANCE
                r7.cancel(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeout(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object withTimeoutOrNull(long r5, androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2 r7, kotlin.coroutines.Continuation r8) {
            /*
                r4 = this;
                boolean r0 = r8 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                if (r0 == 0) goto L13
                r0 = r8
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                r0.<init>(r4, r8)
            L18:
                java.lang.Object r8 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3b
                goto L3c
            L27:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2f:
                kotlin.ResultKt.throwOnFailure(r8)
                r0.label = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3b
                java.lang.Object r8 = r4.withTimeout(r5, r7, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3b
                if (r8 != r1) goto L3c
                return r1
            L3b:
                r8 = 0
            L3c:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeoutOrNull(long, androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public final float mo45toDpu2uoSUM(float f) {
            return f / this.$$delegate_0.getDensity();
        }
    }

    /* compiled from: SuspendingPointerInputFilter.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[PointerEventPass.values().length];
            try {
                r0[PointerEventPass.Initial.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[PointerEventPass.Final.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[PointerEventPass.Main.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public SuspendingPointerInputModifierNodeImpl(Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> pointerInputHandler) {
        Intrinsics.checkNotNullParameter(pointerInputHandler, "pointerInputHandler");
        this.pointerInputHandler = pointerInputHandler;
        this.currentEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        this.pointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16]);
        this.dispatchingPointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16]);
        this.boundsSize = 0L;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public final <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        final PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(cancellableContinuationImpl);
        synchronized (this.pointerHandlers) {
            this.pointerHandlers.add(pointerEventHandlerCoroutine);
            new SafeContinuation(CoroutineSingletons.COROUTINE_SUSPENDED, IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, pointerEventHandlerCoroutine, pointerEventHandlerCoroutine))).resumeWith(Unit.INSTANCE);
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$awaitPointerEventScope$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                Throwable th2 = th;
                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine2 = pointerEventHandlerCoroutine;
                CancellableContinuation<? super PointerEvent> cancellableContinuation = pointerEventHandlerCoroutine2.pointerAwaiter;
                if (cancellableContinuation != null) {
                    cancellableContinuation.cancel(th2);
                }
                pointerEventHandlerCoroutine2.pointerAwaiter = null;
                return Unit.INSTANCE;
            }
        });
        return cancellableContinuationImpl.getResult();
    }

    public final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pointerEventPass) {
        CancellableContinuation<? super PointerEvent> cancellableContinuation;
        MutableVector<PointerEventHandlerCoroutine<?>> mutableVector;
        int r3;
        CancellableContinuation<? super PointerEvent> cancellableContinuation2;
        synchronized (this.pointerHandlers) {
            MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
            mutableVector2.addAll(mutableVector2.size, this.pointerHandlers);
        }
        try {
            int r0 = WhenMappings.$EnumSwitchMapping$0[pointerEventPass.ordinal()];
            if (r0 != 1 && r0 != 2) {
                if (r0 == 3 && (r3 = (mutableVector = this.dispatchingPointerHandlers).size) > 0) {
                    int r32 = r3 - 1;
                    PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArr = mutableVector.content;
                    do {
                        PointerEventHandlerCoroutine<?> pointerEventHandlerCoroutine = pointerEventHandlerCoroutineArr[r32];
                        pointerEventHandlerCoroutine.getClass();
                        if (pointerEventPass == pointerEventHandlerCoroutine.awaitPass && (cancellableContinuation2 = pointerEventHandlerCoroutine.pointerAwaiter) != null) {
                            pointerEventHandlerCoroutine.pointerAwaiter = null;
                            cancellableContinuation2.resumeWith(pointerEvent);
                        }
                        r32--;
                    } while (r32 >= 0);
                }
            } else {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int r2 = mutableVector3.size;
                if (r2 > 0) {
                    PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArr2 = mutableVector3.content;
                    int r33 = 0;
                    do {
                        PointerEventHandlerCoroutine<?> pointerEventHandlerCoroutine2 = pointerEventHandlerCoroutineArr2[r33];
                        pointerEventHandlerCoroutine2.getClass();
                        if (pointerEventPass == pointerEventHandlerCoroutine2.awaitPass && (cancellableContinuation = pointerEventHandlerCoroutine2.pointerAwaiter) != null) {
                            pointerEventHandlerCoroutine2.pointerAwaiter = null;
                            cancellableContinuation.resumeWith(pointerEvent);
                        }
                        r33++;
                    } while (r33 < r2);
                }
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).density.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return DelegatableNodeKt.requireLayoutNode(this).density.getFontScale();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    /* renamed from: getSize-YbymL2g */
    public final long mo416getSizeYbymL2g() {
        return this.boundsSize;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        boolean z;
        PointerEvent pointerEvent = this.lastPointerEvent;
        if (pointerEvent == null) {
            return;
        }
        List<PointerInputChange> list = pointerEvent.changes;
        int size = list.size();
        int r4 = 0;
        while (true) {
            z = true;
            if (r4 >= size) {
                break;
            }
            if (!(true ^ list.get(r4).pressed)) {
                z = false;
                break;
            }
            r4++;
        }
        if (z) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int r3 = 0; r3 < size2; r3++) {
            PointerInputChange pointerInputChange = list.get(r3);
            long j = pointerInputChange.id;
            long j2 = pointerInputChange.position;
            long j3 = pointerInputChange.uptimeMillis;
            float f = pointerInputChange.pressure;
            boolean z2 = pointerInputChange.pressed;
            arrayList.add(new PointerInputChange(j, j3, j2, false, f, j3, j2, z2, z2, 1, Offset.Zero));
        }
        PointerEvent pointerEvent2 = new PointerEvent(arrayList, null);
        this.currentEvent = pointerEvent2;
        dispatchPointerEvent(pointerEvent2, PointerEventPass.Initial);
        dispatchPointerEvent(pointerEvent2, PointerEventPass.Main);
        dispatchPointerEvent(pointerEvent2, PointerEventPass.Final);
        this.lastPointerEvent = null;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onDensityChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public final void mo13onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long j) {
        Intrinsics.checkNotNullParameter(pass, "pass");
        this.boundsSize = j;
        if (pass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent;
        }
        if (this.pointerInputJob == null) {
            this.pointerInputJob = BuildersKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this, null), 1);
        }
        dispatchPointerEvent(pointerEvent, pass);
        List<PointerInputChange> list = pointerEvent.changes;
        int size = list.size();
        boolean z = false;
        int r2 = 0;
        while (true) {
            if (r2 < size) {
                if (!PointerEventKt.changedToUpIgnoreConsumed(list.get(r2))) {
                    break;
                } else {
                    r2++;
                }
            } else {
                z = true;
                break;
            }
        }
        if (!(!z)) {
            pointerEvent = null;
        }
        this.lastPointerEvent = pointerEvent;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onViewConfigurationChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public final void resetPointerInputHandler() {
        StandaloneCoroutine standaloneCoroutine = this.pointerInputJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(new PointerInputResetException());
            this.pointerInputJob = null;
        }
    }
}
