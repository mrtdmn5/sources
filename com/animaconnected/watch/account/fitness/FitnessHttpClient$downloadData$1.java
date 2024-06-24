package com.animaconnected.watch.account.fitness;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FitnessHttpClient.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.fitness.FitnessHttpClient", f = "FitnessHttpClient.kt", l = {109, 110}, m = "downloadData")
/* loaded from: classes3.dex */
public final class FitnessHttpClient$downloadData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FitnessHttpClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessHttpClient$downloadData$1(FitnessHttpClient fitnessHttpClient, Continuation<? super FitnessHttpClient$downloadData$1> continuation) {
        super(continuation);
        this.this$0 = fitnessHttpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadData(null, this);
    }
}
