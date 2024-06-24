package com.animaconnected.watch.fitness;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider", f = "WatchFitnessProvider.kt", l = {1200, 1217, 1236, 1250}, m = "handleLocationResult")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$handleLocationResult$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$handleLocationResult$1(WatchFitnessProvider watchFitnessProvider, Continuation<? super WatchFitnessProvider$handleLocationResult$1> continuation) {
        super(continuation);
        this.this$0 = watchFitnessProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handleLocationResult;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleLocationResult = this.this$0.handleLocationResult(null, this);
        return handleLocationResult;
    }
}
