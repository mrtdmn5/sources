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
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: Draggable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1", f = "Draggable.kt", l = {302}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DraggableNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ DraggableNode this$0;

    /* compiled from: Draggable.kt */
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1", f = "Draggable.kt", l = {326}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ DraggableNode this$0;

        /* compiled from: Draggable.kt */
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1", f = "Draggable.kt", l = {305, 307, 309, 316, 318, 321}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public /* synthetic */ Object L$0;
            public Ref$ObjectRef L$1;
            public Ref$ObjectRef L$2;
            public int label;
            public final /* synthetic */ DraggableNode this$0;

            /* compiled from: Draggable.kt */
            @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1$1", f = "Draggable.kt", l = {312}, m = "invokeSuspend")
            /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C00061 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
                public final /* synthetic */ Ref$ObjectRef<DragEvent> $event;
                public /* synthetic */ Object L$0;
                public Ref$ObjectRef L$1;
                public int label;
                public final /* synthetic */ DraggableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00061(Ref$ObjectRef<DragEvent> ref$ObjectRef, DraggableNode draggableNode, Continuation<? super C00061> continuation) {
                    super(2, continuation);
                    this.$event = ref$ObjectRef;
                    this.this$0 = draggableNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00061 c00061 = new C00061(this.$event, this.this$0, continuation);
                    c00061.L$0 = obj;
                    return c00061;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
                    return ((C00061) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0063 -> B:5:0x0069). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                    /*
                        r11 = this;
                        kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r1 = r11.label
                        r2 = 1
                        if (r1 == 0) goto L1f
                        if (r1 != r2) goto L17
                        kotlin.jvm.internal.Ref$ObjectRef r1 = r11.L$1
                        java.lang.Object r3 = r11.L$0
                        androidx.compose.foundation.gestures.DragScope r3 = (androidx.compose.foundation.gestures.DragScope) r3
                        kotlin.ResultKt.throwOnFailure(r12)
                        r4 = r3
                        r3 = r1
                        r1 = r0
                        r0 = r11
                        goto L69
                    L17:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r0)
                        throw r12
                    L1f:
                        kotlin.ResultKt.throwOnFailure(r12)
                        java.lang.Object r12 = r11.L$0
                        androidx.compose.foundation.gestures.DragScope r12 = (androidx.compose.foundation.gestures.DragScope) r12
                        r3 = r12
                        r12 = r11
                    L28:
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r1 = r12.$event
                        T r4 = r1.element
                        boolean r5 = r4 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
                        if (r5 != 0) goto L6f
                        boolean r5 = r4 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
                        if (r5 != 0) goto L6f
                        boolean r5 = r4 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
                        if (r5 == 0) goto L3b
                        androidx.compose.foundation.gestures.DragEvent$DragDelta r4 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r4
                        goto L3c
                    L3b:
                        r4 = 0
                    L3c:
                        androidx.compose.foundation.gestures.DraggableNode r5 = r12.this$0
                        if (r4 == 0) goto L54
                        androidx.compose.foundation.gestures.Orientation r6 = r5.orientation
                        androidx.compose.foundation.gestures.Orientation r7 = androidx.compose.foundation.gestures.Orientation.Vertical
                        long r8 = r4.delta
                        if (r6 != r7) goto L4d
                        float r4 = androidx.compose.ui.geometry.Offset.m260getYimpl(r8)
                        goto L51
                    L4d:
                        float r4 = androidx.compose.ui.geometry.Offset.m259getXimpl(r8)
                    L51:
                        r3.dragBy(r4)
                    L54:
                        kotlinx.coroutines.channels.BufferedChannel r4 = r5.channel
                        r12.L$0 = r3
                        r12.L$1 = r1
                        r12.label = r2
                        java.lang.Object r4 = r4.receive(r12)
                        if (r4 != r0) goto L63
                        return r0
                    L63:
                        r10 = r0
                        r0 = r12
                        r12 = r4
                        r4 = r3
                        r3 = r1
                        r1 = r10
                    L69:
                        r3.element = r12
                        r12 = r0
                        r0 = r1
                        r3 = r4
                        goto L28
                    L6f:
                        kotlin.Unit r12 = kotlin.Unit.INSTANCE
                        return r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.C00051.C00061.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00051(DraggableNode draggableNode, Continuation<? super C00051> continuation) {
                super(2, continuation);
                this.this$0 = draggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00051 c00051 = new C00051(this.this$0, continuation);
                c00051.L$0 = obj;
                return c00051;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0063  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00b7 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00be A[Catch: CancellationException -> 0x00e9, TryCatch #2 {CancellationException -> 0x00e9, blocks: (B:21:0x009f, B:24:0x00b8, B:26:0x00be, B:30:0x00d5, B:32:0x00d9), top: B:20:0x009f }] */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00d5 A[Catch: CancellationException -> 0x00e9, TryCatch #2 {CancellationException -> 0x00e9, blocks: (B:21:0x009f, B:24:0x00b8, B:26:0x00be, B:30:0x00d5, B:32:0x00d9), top: B:20:0x009f }] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00f8 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00fe  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x0103  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f9 -> B:8:0x005d). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00fe -> B:8:0x005d). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    Method dump skipped, instructions count: 280
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.C00051.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* compiled from: Draggable.kt */
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2", f = "Draggable.kt", l = {328, 336}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ CoroutineScope $$this$coroutineScope;
            public /* synthetic */ Object L$0;
            public DraggableNode L$1;
            public CoroutineScope L$2;
            public int label;
            public final /* synthetic */ DraggableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(DraggableNode draggableNode, Continuation continuation, CoroutineScope coroutineScope) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.this$0 = draggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation, this.$$this$coroutineScope);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Can't wrap try/catch for region: R(7:28|(1:29)|30|31|32|33|(1:35)(4:36|9|10|(0))) */
            /* JADX WARN: Can't wrap try/catch for region: R(8:(3:6|7|8)|9|10|(7:12|(1:14)(1:61)|15|16|17|18|(2:20|(1:22)(4:24|25|26|(7:28|29|30|31|32|33|(1:35)(4:36|9|10|(0)))(4:58|17|18|(2:59|60)(0))))(0))|16|17|18|(0)(0)) */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x00f9, code lost:            r0 = e;     */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x0108, code lost:            r8 = r2;        r2 = r4;        r14 = r6;        r6 = r17;        r7 = r18;     */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x00f7, code lost:            r0 = th;     */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x00fe, code lost:            r13 = r18;     */
            /* JADX WARN: Code restructure failed: missing block: B:62:0x0117, code lost:            r0 = androidx.compose.foundation.gestures.DragEvent.DragCancelled.INSTANCE;     */
            /* JADX WARN: Code restructure failed: missing block: B:64:0x00f5, code lost:            r0 = e;     */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:12:0x00b1  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x0115  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x011f A[Catch: all -> 0x0120, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0120, blocks: (B:41:0x010f, B:44:0x011f), top: B:40:0x010f }] */
            /* JADX WARN: Removed duplicated region for block: B:58:0x012b  */
            /* JADX WARN: Removed duplicated region for block: B:59:0x0133  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00a2 -> B:9:0x00a9). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x012b -> B:17:0x0130). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r20) {
                /*
                    Method dump skipped, instructions count: 310
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PointerInputScope pointerInputScope, DraggableNode draggableNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = draggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$SuspendingPointerInputModifierNode, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.util.concurrent.CancellationException -> L11
                goto L4b
            L11:
                r8 = move-exception
                goto L45
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1b:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
                kotlinx.coroutines.CoroutineStart r1 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1 r3 = new androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1
                androidx.compose.foundation.gestures.DraggableNode r4 = r7.this$0
                r5 = 0
                r3.<init>(r4, r5)
                kotlinx.coroutines.BuildersKt.launch$default(r8, r5, r1, r3, r2)
                androidx.compose.ui.input.pointer.PointerInputScope r1 = r7.$$this$SuspendingPointerInputModifierNode     // Catch: java.util.concurrent.CancellationException -> L41
                androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2 r3 = new androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2     // Catch: java.util.concurrent.CancellationException -> L41
                r3.<init>(r4, r5, r8)     // Catch: java.util.concurrent.CancellationException -> L41
                r7.L$0 = r8     // Catch: java.util.concurrent.CancellationException -> L41
                r7.label = r2     // Catch: java.util.concurrent.CancellationException -> L41
                java.lang.Object r8 = r1.awaitPointerEventScope(r3, r7)     // Catch: java.util.concurrent.CancellationException -> L41
                if (r8 != r0) goto L4b
                return r0
            L41:
                r0 = move-exception
                r6 = r0
                r0 = r8
                r8 = r6
            L45:
                boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r0)
                if (r0 == 0) goto L4e
            L4b:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            L4e:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableNode$pointerInputNode$1(DraggableNode draggableNode, Continuation<? super DraggableNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = draggableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DraggableNode$pointerInputNode$1 draggableNode$pointerInputNode$1 = new DraggableNode$pointerInputNode$1(this.this$0, continuation);
        draggableNode$pointerInputNode$1.L$0 = obj;
        return draggableNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DraggableNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            DraggableNode draggableNode = this.this$0;
            if (!draggableNode.enabled) {
                return Unit.INSTANCE;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(pointerInputScope, draggableNode, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
