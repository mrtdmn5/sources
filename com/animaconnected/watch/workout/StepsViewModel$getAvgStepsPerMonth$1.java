package com.animaconnected.watch.workout;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StepsViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.StepsViewModel", f = "StepsViewModel.kt", l = {95, 95}, m = "getAvgStepsPerMonth")
/* loaded from: classes3.dex */
public final class StepsViewModel$getAvgStepsPerMonth$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StepsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepsViewModel$getAvgStepsPerMonth$1(StepsViewModel stepsViewModel, Continuation<? super StepsViewModel$getAvgStepsPerMonth$1> continuation) {
        super(continuation);
        this.this$0 = stepsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object avgStepsPerMonth;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        avgStepsPerMonth = this.this$0.getAvgStepsPerMonth(null, this);
        return avgStepsPerMonth;
    }
}
