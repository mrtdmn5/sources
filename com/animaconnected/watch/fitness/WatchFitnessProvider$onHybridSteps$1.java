package com.animaconnected.watch.fitness;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.fitness.sync.FitnessSyncWatch;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$onHybridSteps$1", f = "WatchFitnessProvider.kt", l = {240}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$onHybridSteps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $deviceDay;
    final /* synthetic */ FitnessSyncWatch $fitnessSync;
    final /* synthetic */ int $stepsAmountToday;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$onHybridSteps$1(WatchFitnessProvider watchFitnessProvider, FitnessSyncWatch fitnessSyncWatch, int r3, int r4, Continuation<? super WatchFitnessProvider$onHybridSteps$1> continuation) {
        super(2, continuation);
        this.this$0 = watchFitnessProvider;
        this.$fitnessSync = fitnessSyncWatch;
        this.$stepsAmountToday = r3;
        this.$deviceDay = r4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchFitnessProvider$onHybridSteps$1 watchFitnessProvider$onHybridSteps$1 = new WatchFitnessProvider$onHybridSteps$1(this.this$0, this.$fitnessSync, this.$stepsAmountToday, this.$deviceDay, continuation);
        watchFitnessProvider$onHybridSteps$1.L$0 = obj;
        return watchFitnessProvider$onHybridSteps$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        StepFetcher stepFetcher;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception unused) {
                    coroutineScope = coroutineScope2;
                    LogKt.verbose$default((Object) coroutineScope, "Failed to handle steps", (String) null, (Throwable) null, false, 14, (Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            try {
                stepFetcher = this.this$0.stepsFetcher;
                FitnessSyncWatch fitnessSyncWatch = this.$fitnessSync;
                int r5 = this.$stepsAmountToday;
                int r6 = this.$deviceDay;
                this.L$0 = coroutineScope3;
                this.label = 1;
                if (StepFetcher.save$default(stepFetcher, fitnessSyncWatch, r5, r6, null, this, 8, null) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } catch (Exception unused2) {
                coroutineScope = coroutineScope3;
                LogKt.verbose$default((Object) coroutineScope, "Failed to handle steps", (String) null, (Throwable) null, false, 14, (Object) null);
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchFitnessProvider$onHybridSteps$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
