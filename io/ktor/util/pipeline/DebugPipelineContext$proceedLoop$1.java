package io.ktor.util.pipeline;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DebugPipelineContext.kt */
@DebugMetadata(c = "io.ktor.util.pipeline.DebugPipelineContext", f = "DebugPipelineContext.kt", l = {80}, m = "proceedLoop")
/* loaded from: classes3.dex */
public final class DebugPipelineContext$proceedLoop$1 extends ContinuationImpl {
    public DebugPipelineContext L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DebugPipelineContext<TSubject, TContext> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugPipelineContext$proceedLoop$1(DebugPipelineContext<TSubject, TContext> debugPipelineContext, Continuation<? super DebugPipelineContext$proceedLoop$1> continuation) {
        super(continuation);
        this.this$0 = debugPipelineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.proceedLoop(this);
    }
}
