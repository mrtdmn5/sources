package com.animaconnected.secondo.screens.settings.configuration;

import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.workout.ConfigureMetricViewModel;
import com.animaconnected.watch.workout.UIWorkoutMetric;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: WorkoutMetricsConfiguration.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.configuration.WorkoutMetricsConfiguration$onCreateView$1", f = "WorkoutMetricsConfiguration.kt", l = {65}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutMetricsConfiguration$onCreateView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<UIWorkoutMetric>>, Object> {
    int label;
    final /* synthetic */ WorkoutMetricsConfiguration this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutMetricsConfiguration$onCreateView$1(WorkoutMetricsConfiguration workoutMetricsConfiguration, Continuation<? super WorkoutMetricsConfiguration$onCreateView$1> continuation) {
        super(2, continuation);
        this.this$0 = workoutMetricsConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutMetricsConfiguration$onCreateView$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConfigureMetricViewModel configureMetricViewModel;
        SessionType sessionType;
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
            configureMetricViewModel = this.this$0.viewModel;
            if (configureMetricViewModel != null) {
                sessionType = this.this$0.sessionType;
                if (sessionType != null) {
                    Flow<List<UIWorkoutMetric>> workoutMetrics = configureMetricViewModel.getWorkoutMetrics(sessionType);
                    this.label = 1;
                    obj = FlowKt.first(workoutMetrics, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionType");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                throw null;
            }
        }
        return CollectionsKt___CollectionsKt.toMutableList((Collection) obj);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<UIWorkoutMetric>> continuation) {
        return ((WorkoutMetricsConfiguration$onCreateView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
