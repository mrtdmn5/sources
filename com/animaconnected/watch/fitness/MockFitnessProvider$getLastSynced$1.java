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
@DebugMetadata(c = "com.animaconnected.watch.fitness.MockFitnessProvider$getLastSynced$1", f = "MockFitnessProvider.kt", l = {253}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MockFitnessProvider$getLastSynced$1 extends SuspendLambda implements Function2<FlowCollector<? super Long>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public MockFitnessProvider$getLastSynced$1(Continuation<? super MockFitnessProvider$getLastSynced$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MockFitnessProvider$getLastSynced$1 mockFitnessProvider$getLastSynced$1 = new MockFitnessProvider$getLastSynced$1(continuation);
        mockFitnessProvider$getLastSynced$1.L$0 = obj;
        return mockFitnessProvider$getLastSynced$1;
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
            Long l = new Long(0L);
            this.label = 1;
            if (flowCollector.emit(l, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Long> flowCollector, Continuation<? super Unit> continuation) {
        return ((MockFitnessProvider$getLastSynced$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
