package io.ktor.util.pipeline;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugPipelineContext.kt */
/* loaded from: classes3.dex */
public final class DebugPipelineContext<TSubject, TContext> extends PipelineContext<TSubject, TContext> {
    public final CoroutineContext coroutineContext;
    public int index;
    public final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptors;
    public TSubject subject;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DebugPipelineContext(TContext context, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list, TSubject subject, CoroutineContext coroutineContext) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subject, "subject");
        this.interceptors = list;
        this.coroutineContext = coroutineContext;
        this.subject = subject;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object execute$ktor_utils(TSubject tsubject, Continuation<? super TSubject> continuation) {
        this.index = 0;
        Intrinsics.checkNotNullParameter(tsubject, "<set-?>");
        this.subject = tsubject;
        return proceed(continuation);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final TSubject getSubject() {
        return this.subject;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object proceed(Continuation<? super TSubject> continuation) {
        int r0 = this.index;
        if (r0 < 0) {
            return this.subject;
        }
        if (r0 >= this.interceptors.size()) {
            this.index = -1;
            return this.subject;
        }
        return proceedLoop(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object proceedLoop(kotlin.coroutines.Continuation<? super TSubject> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1 r0 = (io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1 r0 = new io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.util.pipeline.DebugPipelineContext r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L35
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L31:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r7
        L35:
            int r8 = r2.index
            r4 = -1
            if (r8 != r4) goto L3b
            goto L45
        L3b:
            java.util.List<kotlin.jvm.functions.Function3<io.ktor.util.pipeline.PipelineContext<TSubject, TContext>, TSubject, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> r5 = r2.interceptors
            int r6 = r5.size()
            if (r8 < r6) goto L48
            r2.index = r4
        L45:
            TSubject r8 = r2.subject
            return r8
        L48:
            java.lang.Object r4 = r5.get(r8)
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            int r8 = r8 + 1
            r2.index = r8
            java.lang.String r8 = "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext>, TSubject of io.ktor.util.pipeline.DebugPipelineContext, kotlin.Unit>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptor<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext> }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r8)
            TSubject r8 = r2.subject
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r4.invoke(r2, r8, r0)
            if (r8 != r1) goto L35
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.DebugPipelineContext.proceedLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object proceedWith(TSubject tsubject, Continuation<? super TSubject> continuation) {
        Intrinsics.checkNotNullParameter(tsubject, "<set-?>");
        this.subject = tsubject;
        return proceed(continuation);
    }
}
