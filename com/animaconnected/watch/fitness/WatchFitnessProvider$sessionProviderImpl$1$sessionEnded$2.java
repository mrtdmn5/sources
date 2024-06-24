package com.animaconnected.watch.fitness;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.CommonFlow;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$sessionProviderImpl$1$sessionEnded$2", f = "WatchFitnessProvider.kt", l = {R.styleable.AppTheme_stepsHistoryColumnColorActivity, R.styleable.AppTheme_stepsHistoryColumnColorDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$sessionProviderImpl$1$sessionEnded$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$sessionProviderImpl$1$sessionEnded$2(WatchFitnessProvider watchFitnessProvider, Continuation<? super WatchFitnessProvider$sessionProviderImpl$1$sessionEnded$2> continuation) {
        super(2, continuation);
        this.this$0 = watchFitnessProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchFitnessProvider$sessionProviderImpl$1$sessionEnded$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CommonFlow<SyncResult> syncFitness = this.this$0.syncFitness();
            this.label = 1;
            if (FitnessProviderKt.suspendUntilDone(syncFitness, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        WatchFitnessProvider watchFitnessProvider = this.this$0;
        this.label = 2;
        if (watchFitnessProvider.processSessions(this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchFitnessProvider$sessionProviderImpl$1$sessionEnded$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
