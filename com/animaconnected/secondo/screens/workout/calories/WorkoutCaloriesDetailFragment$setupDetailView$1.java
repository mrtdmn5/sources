package com.animaconnected.secondo.screens.workout.calories;

import android.widget.TextView;
import com.animaconnected.secondo.databinding.LayoutWorkoutChartInfoBinding;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.graphs.BarChart;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.workout.CaloriesViewModel;
import com.kronaby.watch.app.R;
import java.util.Iterator;
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
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.calories.WorkoutCaloriesDetailFragment$setupDetailView$1", f = "WorkoutCaloriesDetailFragment.kt", l = {55}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutCaloriesDetailFragment$setupDetailView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BarChart $chartToday;
    final /* synthetic */ LayoutWorkoutChartInfoBinding $infoBinding;
    Object L$0;
    int label;
    final /* synthetic */ WorkoutCaloriesDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutCaloriesDetailFragment$setupDetailView$1(WorkoutCaloriesDetailFragment workoutCaloriesDetailFragment, LayoutWorkoutChartInfoBinding layoutWorkoutChartInfoBinding, BarChart barChart, Continuation<? super WorkoutCaloriesDetailFragment$setupDetailView$1> continuation) {
        super(2, continuation);
        this.this$0 = workoutCaloriesDetailFragment;
        this.$infoBinding = layoutWorkoutChartInfoBinding;
        this.$chartToday = barChart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutCaloriesDetailFragment$setupDetailView$1(this.this$0, this.$infoBinding, this.$chartToday, continuation);
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
            Object observeCaloriesToday = caloriesViewModel.observeCaloriesToday(this);
            if (observeCaloriesToday == coroutineSingletons) {
                return coroutineSingletons;
            }
            baseFragment = workoutCaloriesDetailFragment;
            obj = observeCaloriesToday;
        }
        final LayoutWorkoutChartInfoBinding layoutWorkoutChartInfoBinding = this.$infoBinding;
        final WorkoutCaloriesDetailFragment workoutCaloriesDetailFragment2 = this.this$0;
        final BarChart barChart = this.$chartToday;
        BaseFragmentUtilsKt.collectSafelyOnStarted(baseFragment, (CommonFlow) obj, new Function1<ChartData<? extends BarEntry>, Unit>() { // from class: com.animaconnected.secondo.screens.workout.calories.WorkoutCaloriesDetailFragment$setupDetailView$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                TextView textView = LayoutWorkoutChartInfoBinding.this.tvTextOne;
                Iterator<T> it = data.getEntries().iterator();
                int r2 = 0;
                while (it.hasNext()) {
                    r2 += ((BarEntry) it.next()).getValue();
                }
                textView.setText(String.valueOf(r2));
                LayoutWorkoutChartInfoBinding.this.tvTextTwo.setText(workoutCaloriesDetailFragment2.getString(R.string.metric_detail_calories_cal));
                barChart.setShowNoDataText(data.isDataEmpty());
                barChart.setData(data.getEntries());
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkoutCaloriesDetailFragment$setupDetailView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
