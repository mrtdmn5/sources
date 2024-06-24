package com.animaconnected.watch.fitness;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: FitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.FitnessProviderKt$suspendUntilDone$2", f = "FitnessProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FitnessProviderKt$suspendUntilDone$2 extends SuspendLambda implements Function2<SyncResult, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public FitnessProviderKt$suspendUntilDone$2(Continuation<? super FitnessProviderKt$suspendUntilDone$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FitnessProviderKt$suspendUntilDone$2 fitnessProviderKt$suspendUntilDone$2 = new FitnessProviderKt$suspendUntilDone$2(continuation);
        fitnessProviderKt$suspendUntilDone$2.L$0 = obj;
        return fitnessProviderKt$suspendUntilDone$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SyncResult syncResult, Continuation<? super Boolean> continuation) {
        return ((FitnessProviderKt$suspendUntilDone$2) create(syncResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (((SyncResult) this.L$0).getState() != SyncState.Done) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
