package com.animaconnected.watch.fitness;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: MockFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.MockFitnessProvider$syncFitness$1", f = "MockFitnessProvider.kt", l = {250}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MockFitnessProvider$syncFitness$1 extends SuspendLambda implements Function2<FlowCollector<? super SyncResult>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public MockFitnessProvider$syncFitness$1(Continuation<? super MockFitnessProvider$syncFitness$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MockFitnessProvider$syncFitness$1 mockFitnessProvider$syncFitness$1 = new MockFitnessProvider$syncFitness$1(continuation);
        mockFitnessProvider$syncFitness$1.L$0 = obj;
        return mockFitnessProvider$syncFitness$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            SyncResult syncResult = new SyncResult(SyncState.Done, 0.0f, null);
            this.label = 1;
            if (flowCollector.emit(syncResult, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super SyncResult> flowCollector, Continuation<? super Unit> continuation) {
        return ((MockFitnessProvider$syncFitness$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
