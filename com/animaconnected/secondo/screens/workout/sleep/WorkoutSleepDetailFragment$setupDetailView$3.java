package com.animaconnected.secondo.screens.workout.sleep;

import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.graphs.StackedBarChart;
import com.animaconnected.watch.graphs.StackedBarEntry;
import com.animaconnected.watch.workout.SleepViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WorkoutSleepDetailFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.sleep.WorkoutSleepDetailFragment$setupDetailView$3", f = "WorkoutSleepDetailFragment.kt", l = {79}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutSleepDetailFragment$setupDetailView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StackedBarChart $historyChart;
    Object L$0;
    int label;
    final /* synthetic */ WorkoutSleepDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutSleepDetailFragment$setupDetailView$3(WorkoutSleepDetailFragment workoutSleepDetailFragment, StackedBarChart stackedBarChart, Continuation<? super WorkoutSleepDetailFragment$setupDetailView$3> continuation) {
        super(2, continuation);
        this.this$0 = workoutSleepDetailFragment;
        this.$historyChart = stackedBarChart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutSleepDetailFragment$setupDetailView$3(this.this$0, this.$historyChart, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SleepViewModel sleepViewModel;
        BaseFragment baseFragment;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                baseFragment = (BaseFragment) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            WorkoutSleepDetailFragment workoutSleepDetailFragment = this.this$0;
            sleepViewModel = workoutSleepDetailFragment.sleepViewModel;
            this.L$0 = workoutSleepDetailFragment;
            this.label = 1;
            Object observeLastWeekSleepData = sleepViewModel.observeLastWeekSleepData(this);
            if (observeLastWeekSleepData == coroutineSingletons) {
                return coroutineSingletons;
            }
            baseFragment = workoutSleepDetailFragment;
            obj = observeLastWeekSleepData;
        }
        final StackedBarChart stackedBarChart = this.$historyChart;
        BaseFragmentUtilsKt.collectSafelyOnStarted(baseFragment, (CommonFlow) obj, new Function1<ChartData<? extends StackedBarEntry>, Unit>() { // from class: com.animaconnected.secondo.screens.workout.sleep.WorkoutSleepDetailFragment$setupDetailView$3.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChartData<? extends StackedBarEntry> chartData) {
                invoke2((ChartData<StackedBarEntry>) chartData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChartData<StackedBarEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                StackedBarChart.this.setShowNoDataText(data.isDataEmpty());
                StackedBarChart.this.setData(data.getEntries());
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkoutSleepDetailFragment$setupDetailView$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
