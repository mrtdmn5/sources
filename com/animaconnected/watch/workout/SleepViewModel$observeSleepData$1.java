package com.animaconnected.watch.workout;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SleepViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.SleepViewModel", f = "SleepViewModel.kt", l = {80}, m = "observeSleepData")
/* loaded from: classes3.dex */
public final class SleepViewModel$observeSleepData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SleepViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SleepViewModel$observeSleepData$1(SleepViewModel sleepViewModel, Continuation<? super SleepViewModel$observeSleepData$1> continuation) {
        super(continuation);
        this.this$0 = sleepViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.observeSleepData(null, null, null, null, null, this);
    }
}
