package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Scrollable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1", f = "Scrollable.kt", l = {336}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MouseWheelScrollNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ MouseWheelScrollNode this$0;

    /* compiled from: Scrollable.kt */
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1$1", f = "Scrollable.kt", l = {338}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ MouseWheelScrollNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MouseWheelScrollNode mouseWheelScrollNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = mouseWheelScrollNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x002f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0053 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0041  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0030 -> B:5:0x0035). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r1 = r10.label
                r2 = 1
                if (r1 == 0) goto L1c
                if (r1 != r2) goto L14
                java.lang.Object r1 = r10.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r11)
                r3 = r1
                r1 = r0
                r0 = r10
                goto L35
            L14:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1c:
                kotlin.ResultKt.throwOnFailure(r11)
                java.lang.Object r11 = r10.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
                r1 = r11
                r11 = r10
            L25:
                r11.L$0 = r1
                r11.label = r2
                java.lang.Object r3 = androidx.compose.foundation.gestures.ScrollableKt.access$awaitScrollEvent(r1, r11)
                if (r3 != r0) goto L30
                return r0
            L30:
                r9 = r0
                r0 = r11
                r11 = r3
                r3 = r1
                r1 = r9
            L35:
                androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
                java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r11.changes
                int r5 = r4.size()
                r6 = 0
                r7 = r6
            L3f:
                if (r7 >= r5) goto L53
                java.lang.Object r8 = r4.get(r7)
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                boolean r8 = r8.isConsumed()
                r8 = r8 ^ r2
                if (r8 != 0) goto L50
                r4 = r6
                goto L54
            L50:
                int r7 = r7 + 1
                goto L3f
            L53:
                r4 = r2
            L54:
                if (r4 == 0) goto L98
                androidx.compose.foundation.gestures.MouseWheelScrollNode r4 = r0.this$0
                androidx.compose.foundation.gestures.ScrollConfig r5 = r4.mouseWheelScrollConfig
                r3.mo407getSizeYbymL2g()
                long r7 = r5.mo32calculateMouseWheelScroll8xgXZGE(r3, r11)
                androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r4 = r4.scrollingLogicState
                java.lang.Object r4 = r4.getValue()
                androidx.compose.foundation.gestures.ScrollingLogic r4 = (androidx.compose.foundation.gestures.ScrollingLogic) r4
                float r5 = r4.m57toFloatk4lQ0M(r7)
                boolean r7 = r4.reverseDirection
                if (r7 == 0) goto L74
                r7 = -1
                float r7 = (float) r7
                float r5 = r5 * r7
            L74:
                androidx.compose.foundation.gestures.ScrollableState r4 = r4.scrollableState
                float r4 = r4.dispatchRawDelta(r5)
                r5 = 0
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 != 0) goto L81
                r4 = r2
                goto L82
            L81:
                r4 = r6
            L82:
                if (r4 != 0) goto L98
                java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r11 = r11.changes
                int r4 = r11.size()
            L8a:
                if (r6 >= r4) goto L98
                java.lang.Object r5 = r11.get(r6)
                androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
                r5.consume()
                int r6 = r6 + 1
                goto L8a
            L98:
                r11 = r0
                r0 = r1
                r1 = r3
                goto L25
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MouseWheelScrollNode$pointerInputNode$1(MouseWheelScrollNode mouseWheelScrollNode, Continuation<? super MouseWheelScrollNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = mouseWheelScrollNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MouseWheelScrollNode$pointerInputNode$1 mouseWheelScrollNode$pointerInputNode$1 = new MouseWheelScrollNode$pointerInputNode$1(this.this$0, continuation);
        mouseWheelScrollNode$pointerInputNode$1.L$0 = obj;
        return mouseWheelScrollNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((MouseWheelScrollNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (pointerInputScope.awaitPointerEventScope(anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
