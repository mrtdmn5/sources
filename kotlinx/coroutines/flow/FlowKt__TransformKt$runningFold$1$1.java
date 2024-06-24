package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Transform.kt */
/* loaded from: classes4.dex */
public final class FlowKt__TransformKt$runningFold$1$1<T> implements FlowCollector {
    public final /* synthetic */ Ref$ObjectRef<Object> $accumulator;
    public final /* synthetic */ Function3<Object, T, Continuation<Object>, Object> $operation;
    public final /* synthetic */ FlowCollector<Object> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningFold$1$1(Ref$ObjectRef<Object> ref$ObjectRef, Function3<Object, ? super T, ? super Continuation<Object>, ? extends Object> function3, FlowCollector<Object> flowCollector) {
        this.$accumulator = ref$ObjectRef;
        this.$operation = function3;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(T r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6a
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.jvm.internal.Ref$ObjectRef r7 = r0.L$1
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1 r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L54
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r8 = r6.$accumulator
            T r2 = r8.element
            r0.L$0 = r6
            r0.L$1 = r8
            r0.label = r4
            kotlin.jvm.functions.Function3<java.lang.Object, T, kotlin.coroutines.Continuation<java.lang.Object>, java.lang.Object> r4 = r6.$operation
            java.lang.Object r7 = r4.invoke(r2, r7, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r2 = r6
            r5 = r8
            r8 = r7
            r7 = r5
        L54:
            r7.element = r8
            kotlinx.coroutines.flow.FlowCollector<java.lang.Object> r7 = r2.$this_unsafeFlow
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r8 = r2.$accumulator
            T r8 = r8.element
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r7.emit(r8, r0)
            if (r7 != r1) goto L6a
            return r1
        L6a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
