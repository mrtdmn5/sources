package com.animaconnected.watch.fitness;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.FitnessProviderKt", f = "FitnessProvider.kt", l = {343}, m = "getStepsToday")
/* loaded from: classes3.dex */
public final class FitnessProviderKt$getStepsToday$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public FitnessProviderKt$getStepsToday$1(Continuation<? super FitnessProviderKt$getStepsToday$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FitnessProviderKt.getStepsToday(null, this);
    }
}
