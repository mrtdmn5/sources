package com.animaconnected.watch.fitness;

import com.animaconnected.watch.workout.HeartrateMetricItem;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$1", f = "WatchFitnessProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$getHeartrateLiveData$1 extends SuspendLambda implements Function3<HeartrateMetricItem, HeartrateMetricItem, Continuation<? super HeartrateMetricItem>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public WatchFitnessProvider$getHeartrateLiveData$1(Continuation<? super WatchFitnessProvider$getHeartrateLiveData$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(HeartrateMetricItem heartrateMetricItem, HeartrateMetricItem heartrateMetricItem2, Continuation<? super HeartrateMetricItem> continuation) {
        WatchFitnessProvider$getHeartrateLiveData$1 watchFitnessProvider$getHeartrateLiveData$1 = new WatchFitnessProvider$getHeartrateLiveData$1(continuation);
        watchFitnessProvider$getHeartrateLiveData$1.L$0 = heartrateMetricItem;
        watchFitnessProvider$getHeartrateLiveData$1.L$1 = heartrateMetricItem2;
        return watchFitnessProvider$getHeartrateLiveData$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            HeartrateMetricItem heartrateMetricItem = (HeartrateMetricItem) this.L$0;
            HeartrateMetricItem heartrateMetricItem2 = (HeartrateMetricItem) this.L$1;
            if (heartrateMetricItem != null && heartrateMetricItem.getTimestamp().compareTo(heartrateMetricItem2.getTimestamp()) > 0) {
                return heartrateMetricItem;
            }
            return heartrateMetricItem2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
