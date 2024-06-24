package com.animaconnected.watch.workout;

import com.animaconnected.watch.fitness.StepEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* compiled from: StepsViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.StepsViewModel$observeStepsData$flow$1", f = "StepsViewModel.kt", l = {61}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class StepsViewModel$observeStepsData$flow$1 extends SuspendLambda implements Function2<TimePeriod, Continuation<? super Flow<? extends List<? extends StepEntry>>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StepsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepsViewModel$observeStepsData$flow$1(StepsViewModel stepsViewModel, Continuation<? super StepsViewModel$observeStepsData$flow$1> continuation) {
        super(2, continuation);
        this.this$0 = stepsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StepsViewModel$observeStepsData$flow$1 stepsViewModel$observeStepsData$flow$1 = new StepsViewModel$observeStepsData$flow$1(this.this$0, continuation);
        stepsViewModel$observeStepsData$flow$1.L$0 = obj;
        return stepsViewModel$observeStepsData$flow$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(TimePeriod timePeriod, Continuation<? super Flow<? extends List<StepEntry>>> continuation) {
        return ((StepsViewModel$observeStepsData$flow$1) create(timePeriod, continuation)).invokeSuspend(Unit.INSTANCE);
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
            TimePeriod timePeriod = (TimePeriod) this.L$0;
            StepsViewModel stepsViewModel = this.this$0;
            this.label = 1;
            obj = stepsViewModel.getAvgStepsPerMonth(timePeriod, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(TimePeriod timePeriod, Continuation<? super Flow<? extends List<? extends StepEntry>>> continuation) {
        return invoke2(timePeriod, (Continuation<? super Flow<? extends List<StepEntry>>>) continuation);
    }
}
