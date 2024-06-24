package com.animaconnected.watch.fitness.sync;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FitnessSyncWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.sync.FitnessSyncWatch", f = "FitnessSyncWatch.kt", l = {193, 237, 240}, m = "writeDailyFitnessData")
/* loaded from: classes3.dex */
public final class FitnessSyncWatch$writeDailyFitnessData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FitnessSyncWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessSyncWatch$writeDailyFitnessData$1(FitnessSyncWatch fitnessSyncWatch, Continuation<? super FitnessSyncWatch$writeDailyFitnessData$1> continuation) {
        super(continuation);
        this.this$0 = fitnessSyncWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeDailyFitnessData(null, this);
    }
}
