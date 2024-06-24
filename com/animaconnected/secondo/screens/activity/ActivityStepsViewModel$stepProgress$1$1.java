package com.animaconnected.secondo.screens.activity;

import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.fitness.StepEntry;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: ActivityViewModel.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.activity.ActivityStepsViewModel$stepProgress$1$1", f = "ActivityViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ActivityStepsViewModel$stepProgress$1$1 extends SuspendLambda implements Function3<List<? extends StepEntry>, HealthGoals, Continuation<? super StepProgress>, Object> {
    final /* synthetic */ ActivityStepsViewModel $this_run;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityStepsViewModel$stepProgress$1$1(ActivityStepsViewModel activityStepsViewModel, Continuation<? super ActivityStepsViewModel$stepProgress$1$1> continuation) {
        super(3, continuation);
        this.$this_run = activityStepsViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends StepEntry> list, HealthGoals healthGoals, Continuation<? super StepProgress> continuation) {
        return invoke2((List<StepEntry>) list, healthGoals, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int r5;
        String formatStepPercentage;
        String formatStepProgress;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            HealthGoals healthGoals = (HealthGoals) this.L$1;
            StepEntry stepEntry = (StepEntry) CollectionsKt___CollectionsKt.firstOrNull(list);
            if (stepEntry != null) {
                r5 = stepEntry.getSteps();
            } else {
                r5 = 0;
            }
            formatStepPercentage = this.$this_run.formatStepPercentage(r5, healthGoals.getSteps());
            formatStepProgress = this.$this_run.formatStepProgress(r5, healthGoals.getSteps());
            return new StepProgress(r5, healthGoals.getSteps(), formatStepPercentage, formatStepProgress);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<StepEntry> list, HealthGoals healthGoals, Continuation<? super StepProgress> continuation) {
        ActivityStepsViewModel$stepProgress$1$1 activityStepsViewModel$stepProgress$1$1 = new ActivityStepsViewModel$stepProgress$1$1(this.$this_run, continuation);
        activityStepsViewModel$stepProgress$1$1.L$0 = list;
        activityStepsViewModel$stepProgress$1$1.L$1 = healthGoals;
        return activityStepsViewModel$stepProgress$1$1.invokeSuspend(Unit.INSTANCE);
    }
}
