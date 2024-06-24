package io.ktor.util.pipeline;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PipelineContext.kt */
/* loaded from: classes3.dex */
public abstract class PipelineContext<TSubject, TContext> implements CoroutineScope {
    public final TContext context;

    public PipelineContext(TContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public abstract Object execute$ktor_utils(TSubject tsubject, Continuation<? super TSubject> continuation);

    public abstract TSubject getSubject();

    public abstract Object proceed(Continuation<? super TSubject> continuation);

    public abstract Object proceedWith(TSubject tsubject, Continuation<? super TSubject> continuation);
}
