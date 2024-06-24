package androidx.compose.ui.input.pointer;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: PointerIcon.kt */
@DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1", f = "PointerIcon.kt", l = {110}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ PointerIconModifierLocal $pointerIconModifierLocal;
    public /* synthetic */ Object L$0;
    public int label;

    /* compiled from: PointerIcon.kt */
    @DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1$1", f = "PointerIcon.kt", l = {112}, m = "invokeSuspend")
    /* renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ PointerIconModifierLocal $pointerIconModifierLocal;
        public /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PointerIconModifierLocal pointerIconModifierLocal, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$pointerIconModifierLocal = pointerIconModifierLocal;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pointerIconModifierLocal, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0031 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x003f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0032 -> B:5:0x0037). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r1 = r8.label
                r2 = 1
                if (r1 == 0) goto L1c
                if (r1 != r2) goto L14
                java.lang.Object r1 = r8.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r9)
                r3 = r1
                r1 = r0
                r0 = r8
                goto L37
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.Object r9 = r8.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
                r1 = r9
                r9 = r8
            L25:
                androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                r9.L$0 = r1
                r9.label = r2
                java.lang.Object r3 = r1.awaitPointerEvent(r3, r9)
                if (r3 != r0) goto L32
                return r0
            L32:
                r7 = r0
                r0 = r9
                r9 = r3
                r3 = r1
                r1 = r7
            L37:
                androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
                int r9 = r9.type
                r4 = 4
                r5 = 0
                if (r9 != r4) goto L41
                r4 = r2
                goto L42
            L41:
                r4 = r5
            L42:
                androidx.compose.ui.input.pointer.PointerIconModifierLocal r6 = r0.$pointerIconModifierLocal
                if (r4 == 0) goto L5d
                r6.isHovered = r2
                boolean r9 = r6.isPaused
                if (r9 != 0) goto L7b
                androidx.compose.ui.input.pointer.PointerIconModifierLocal r9 = r6.getParentInfo()
                if (r9 == 0) goto L55
                r9.pause()
            L55:
                kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerIcon, kotlin.Unit> r9 = r6.onSetIcon
                androidx.compose.ui.input.pointer.PointerIcon r4 = r6.icon
                r9.invoke(r4)
                goto L7b
            L5d:
                r4 = 5
                if (r9 != r4) goto L62
                r9 = r2
                goto L63
            L62:
                r9 = r5
            L63:
                if (r9 == 0) goto L7b
                androidx.compose.ui.input.pointer.PointerIconModifierLocal r9 = r6.getParentInfo()
                boolean r4 = r6.isHovered
                if (r4 == 0) goto L79
                if (r9 != 0) goto L76
                kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerIcon, kotlin.Unit> r9 = r6.onSetIcon
                r4 = 0
                r9.invoke(r4)
                goto L79
            L76:
                r9.reassignIcon()
            L79:
                r6.isHovered = r5
            L7b:
                r9 = r0
                r0 = r1
                r1 = r3
                goto L25
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(PointerIconModifierLocal pointerIconModifierLocal, Continuation<? super PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1> continuation) {
        super(2, continuation);
        this.$pointerIconModifierLocal = pointerIconModifierLocal;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 = new PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(this.$pointerIconModifierLocal, continuation);
        pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1.L$0 = obj;
        return pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pointerIconModifierLocal, null);
            this.label = 1;
            if (pointerInputScope.awaitPointerEventScope(anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
