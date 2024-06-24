package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SafeCollector.common.kt */
/* loaded from: classes4.dex */
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1 implements Flow<Object> {
    public final /* synthetic */ int $count$inlined = 1;
    public final /* synthetic */ Flow $this_take$inlined;

    /* compiled from: SafeCollector.common.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1", f = "Limit.kt", l = {116}, m = "collect")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        public FlowCollector L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$take$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__LimitKt$take$$inlined$unsafeFlow$1(Flow flow) {
        this.$this_take$inlined = flow;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(3:19|20|(1:22))|12|13|14))|27|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:            r8 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:            if (r8.owner != r7) goto L25;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:            throw r8;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlinx.coroutines.flow.FlowCollector r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4d
            goto L52
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$IntRef r8 = new kotlin.jvm.internal.Ref$IntRef
            r8.<init>()
            kotlinx.coroutines.flow.Flow r2 = r6.$this_take$inlined     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4d
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1 r4 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4d
            int r5 = r6.$count$inlined     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4d
            r4.<init>(r8, r5, r7)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4d
            r0.L$0 = r7     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4d
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4d
            java.lang.Object r7 = r2.collect(r4, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4d
            if (r7 != r1) goto L52
            return r1
        L4d:
            r8 = move-exception
            kotlinx.coroutines.flow.FlowCollector<?> r0 = r8.owner
            if (r0 != r7) goto L55
        L52:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L55:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
