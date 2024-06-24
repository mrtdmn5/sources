package com.animaconnected.watch.fitness;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StepFetcher.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.StepFetcher", f = "StepFetcher.kt", l = {54, 59, 72, 81}, m = "save")
/* loaded from: classes3.dex */
public final class StepFetcher$save$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StepFetcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepFetcher$save$1(StepFetcher stepFetcher, Continuation<? super StepFetcher$save$1> continuation) {
        super(continuation);
        this.this$0 = stepFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.save(null, 0, 0, null, this);
    }
}
