package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;

/* compiled from: Limit.kt */
/* loaded from: classes4.dex */
public final class FlowKt__LimitKt$dropWhile$1$1<T> implements FlowCollector {
    public final /* synthetic */ Ref$BooleanRef $matched;
    public final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;
    public final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1(Ref$BooleanRef ref$BooleanRef, FlowCollector<? super T> flowCollector, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        this.$matched = ref$BooleanRef;
        this.$this_unsafeFlow = flowCollector;
        this.$predicate = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(T r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L84
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1 r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L68
        L3d:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.$matched
            boolean r8 = r8.element
            if (r8 == 0) goto L58
            r0.label = r5
            kotlinx.coroutines.flow.FlowCollector<T> r8 = r6.$this_unsafeFlow
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L58:
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r8 = r6.$predicate
            java.lang.Object r8 = r8.invoke(r7, r0)
            if (r8 != r1) goto L67
            return r1
        L67:
            r2 = r6
        L68:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L87
            kotlin.jvm.internal.Ref$BooleanRef r8 = r2.$matched
            r8.element = r5
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            kotlinx.coroutines.flow.FlowCollector<T> r8 = r2.$this_unsafeFlow
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L84
            return r1
        L84:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L87:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
