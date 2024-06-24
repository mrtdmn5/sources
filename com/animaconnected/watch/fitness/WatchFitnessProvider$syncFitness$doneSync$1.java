package com.animaconnected.watch.fitness;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$syncFitness$doneSync$1", f = "WatchFitnessProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$syncFitness$doneSync$1 extends SuspendLambda implements Function2<FlowCollector<? super SyncResult>, Continuation<? super Unit>, Object> {
    int label;

    public WatchFitnessProvider$syncFitness$doneSync$1(Continuation<? super WatchFitnessProvider$syncFitness$doneSync$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchFitnessProvider$syncFitness$doneSync$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            new SyncResult(SyncState.Done, 1.0f, null, 4, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super SyncResult> flowCollector, Continuation<? super Unit> continuation) {
        return ((WatchFitnessProvider$syncFitness$doneSync$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
