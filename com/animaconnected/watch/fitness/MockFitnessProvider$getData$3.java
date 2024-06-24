package com.animaconnected.watch.fitness;

import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: MockFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.MockFitnessProvider$getData$3", f = "MockFitnessProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MockFitnessProvider$getData$3 extends SuspendLambda implements Function3<List<? extends Entry>, List<? extends LocationEntry>, Continuation<? super List<? extends Entry>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public MockFitnessProvider$getData$3(Continuation<? super MockFitnessProvider$getData$3> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends Entry> list, List<? extends LocationEntry> list2, Continuation<? super List<? extends Entry>> continuation) {
        return invoke2(list, (List<LocationEntry>) list2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            return CollectionsKt___CollectionsKt.plus((Iterable) this.L$1, (Collection) list);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<? extends Entry> list, List<LocationEntry> list2, Continuation<? super List<? extends Entry>> continuation) {
        MockFitnessProvider$getData$3 mockFitnessProvider$getData$3 = new MockFitnessProvider$getData$3(continuation);
        mockFitnessProvider$getData$3.L$0 = list;
        mockFitnessProvider$getData$3.L$1 = list2;
        return mockFitnessProvider$getData$3.invokeSuspend(Unit.INSTANCE);
    }
}
