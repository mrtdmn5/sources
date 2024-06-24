package com.animaconnected.watch.workout;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StepsViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.StepsViewModel", f = "StepsViewModel.kt", l = {60}, m = "observeStepsData")
/* loaded from: classes3.dex */
public final class StepsViewModel$observeStepsData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StepsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepsViewModel$observeStepsData$1(StepsViewModel stepsViewModel, Continuation<? super StepsViewModel$observeStepsData$1> continuation) {
        super(continuation);
        this.this$0 = stepsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.observeStepsData(null, null, null, null, null, this);
    }
}
