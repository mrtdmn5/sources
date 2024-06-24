package com.animaconnected.watch.fitness;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.fitness.sync.FitnessSyncWatch;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$syncFitness$3", f = "WatchFitnessProvider.kt", l = {R.styleable.AppTheme_themeGradientColor}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$syncFitness$3 extends SuspendLambda implements Function2<FlowCollector<? super SyncResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ FitnessSyncWatch $fitnessSync;
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$syncFitness$3(WatchFitnessProvider watchFitnessProvider, FitnessSyncWatch fitnessSyncWatch, Continuation<? super WatchFitnessProvider$syncFitness$3> continuation) {
        super(2, continuation);
        this.this$0 = watchFitnessProvider;
        this.$fitnessSync = fitnessSyncWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchFitnessProvider$syncFitness$3(this.this$0, this.$fitnessSync, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StepFetcher stepFetcher;
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
            new SyncResult(SyncState.Fetching, 0.0f, null, 4, null);
            stepFetcher = this.this$0.stepsFetcher;
            FitnessSyncWatch fitnessSyncWatch = this.$fitnessSync;
            this.label = 1;
            if (StepFetcher.fetch$default(stepFetcher, fitnessSyncWatch, null, this, 2, null) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        new SyncResult(SyncState.Done, 1.0f, null, 4, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super SyncResult> flowCollector, Continuation<? super Unit> continuation) {
        return ((WatchFitnessProvider$syncFitness$3) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
