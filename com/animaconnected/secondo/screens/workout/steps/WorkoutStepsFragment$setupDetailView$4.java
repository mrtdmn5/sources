package com.animaconnected.secondo.screens.workout.steps;

import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.graphs.BarChart;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.workout.StepsViewModel;
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

/* compiled from: WorkoutStepsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.steps.WorkoutStepsFragment$setupDetailView$4", f = "WorkoutStepsFragment.kt", l = {91}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutStepsFragment$setupDetailView$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BarChart $historyChart;
    Object L$0;
    int label;
    final /* synthetic */ WorkoutStepsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutStepsFragment$setupDetailView$4(WorkoutStepsFragment workoutStepsFragment, BarChart barChart, Continuation<? super WorkoutStepsFragment$setupDetailView$4> continuation) {
        super(2, continuation);
        this.this$0 = workoutStepsFragment;
        this.$historyChart = barChart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutStepsFragment$setupDetailView$4(this.this$0, this.$historyChart, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StepsViewModel stepsViewModel;
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
            WorkoutStepsFragment workoutStepsFragment = this.this$0;
            stepsViewModel = workoutStepsFragment.viewModel;
            this.L$0 = workoutStepsFragment;
            this.label = 1;
            Object observeStepsLastWeek = stepsViewModel.observeStepsLastWeek(this);
            if (observeStepsLastWeek == coroutineSingletons) {
                return coroutineSingletons;
            }
            baseFragment = workoutStepsFragment;
            obj = observeStepsLastWeek;
        }
        final BarChart barChart = this.$historyChart;
        BaseFragmentUtilsKt.collectSafelyOnStarted(baseFragment, (CommonFlow) obj, new Function1<ChartData<? extends BarEntry>, Unit>() { // from class: com.animaconnected.secondo.screens.workout.steps.WorkoutStepsFragment$setupDetailView$4.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChartData<? extends BarEntry> chartData) {
                invoke2((ChartData<BarEntry>) chartData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChartData<BarEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                BarChart.this.setShowNoDataText(data.isDataEmpty());
                BarChart.this.setData(data.getEntries());
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkoutStepsFragment$setupDetailView$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
