package com.animaconnected.secondo.screens.workout.calories;

import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.graphs.BarChart;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.workout.CaloriesViewModel;
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

/* compiled from: WorkoutCaloriesDetailFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.calories.WorkoutCaloriesDetailFragment$setupDetailView$2", f = "WorkoutCaloriesDetailFragment.kt", l = {64}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutCaloriesDetailFragment$setupDetailView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BarChart $chartHistory;
    Object L$0;
    int label;
    final /* synthetic */ WorkoutCaloriesDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutCaloriesDetailFragment$setupDetailView$2(WorkoutCaloriesDetailFragment workoutCaloriesDetailFragment, BarChart barChart, Continuation<? super WorkoutCaloriesDetailFragment$setupDetailView$2> continuation) {
        super(2, continuation);
        this.this$0 = workoutCaloriesDetailFragment;
        this.$chartHistory = barChart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutCaloriesDetailFragment$setupDetailView$2(this.this$0, this.$chartHistory, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CaloriesViewModel caloriesViewModel;
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
            WorkoutCaloriesDetailFragment workoutCaloriesDetailFragment = this.this$0;
            caloriesViewModel = workoutCaloriesDetailFragment.caloriesViewModel;
            this.L$0 = workoutCaloriesDetailFragment;
            this.label = 1;
            Object observeCaloriesLastWeek = caloriesViewModel.observeCaloriesLastWeek(this);
            if (observeCaloriesLastWeek == coroutineSingletons) {
                return coroutineSingletons;
            }
            baseFragment = workoutCaloriesDetailFragment;
            obj = observeCaloriesLastWeek;
        }
        final BarChart barChart = this.$chartHistory;
        BaseFragmentUtilsKt.collectSafelyOnStarted(baseFragment, (CommonFlow) obj, new Function1<ChartData<? extends BarEntry>, Unit>() { // from class: com.animaconnected.secondo.screens.workout.calories.WorkoutCaloriesDetailFragment$setupDetailView$2.1
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
        return ((WorkoutCaloriesDetailFragment$setupDetailView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
