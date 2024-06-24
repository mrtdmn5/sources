package com.animaconnected.watch.fitness;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StepFetcher.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.StepFetcher", f = "StepFetcher.kt", l = {17, 19, 21}, m = "fetch")
/* loaded from: classes3.dex */
public final class StepFetcher$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StepFetcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepFetcher$fetch$1(StepFetcher stepFetcher, Continuation<? super StepFetcher$fetch$1> continuation) {
        super(continuation);
        this.this$0 = stepFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetch(null, null, this);
    }
}
