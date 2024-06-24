package com.animaconnected.secondo.screens.workout;

import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.graphs.ChartEntry;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WorkoutMetricHistoryBaseFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$2", f = "WorkoutMetricHistoryBaseFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$2 extends SuspendLambda implements Function2<ChartData<? extends ChartEntry>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WorkoutMetricHistoryBaseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$2(WorkoutMetricHistoryBaseFragment workoutMetricHistoryBaseFragment, Continuation<? super WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$2> continuation) {
        super(2, continuation);
        this.this$0 = workoutMetricHistoryBaseFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$2 workoutMetricHistoryBaseFragment$updateDataOnTabChange$2 = new WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$2(this.this$0, continuation);
        workoutMetricHistoryBaseFragment$updateDataOnTabChange$2.L$0 = obj;
        return workoutMetricHistoryBaseFragment$updateDataOnTabChange$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ChartData<? extends ChartEntry> chartData, Continuation<? super Unit> continuation) {
        return ((WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$2) create(chartData, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Chart chart;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ChartData chartData = (ChartData) this.L$0;
            chart = this.this$0.getChart();
            if (chart != null) {
                chart.setData(chartData.getEntries());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
