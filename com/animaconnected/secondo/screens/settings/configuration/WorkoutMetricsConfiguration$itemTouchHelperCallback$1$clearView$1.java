package com.animaconnected.secondo.screens.settings.configuration;

import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.workout.ConfigureMetricViewModel;
import com.animaconnected.watch.workout.UIWorkoutMetric;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WorkoutMetricsConfiguration.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.configuration.WorkoutMetricsConfiguration$itemTouchHelperCallback$1$clearView$1", f = "WorkoutMetricsConfiguration.kt", l = {52}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutMetricsConfiguration$itemTouchHelperCallback$1$clearView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WorkoutMetricsConfiguration this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutMetricsConfiguration$itemTouchHelperCallback$1$clearView$1(WorkoutMetricsConfiguration workoutMetricsConfiguration, Continuation<? super WorkoutMetricsConfiguration$itemTouchHelperCallback$1$clearView$1> continuation) {
        super(2, continuation);
        this.this$0 = workoutMetricsConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutMetricsConfiguration$itemTouchHelperCallback$1$clearView$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConfigureMetricViewModel configureMetricViewModel;
        SessionType sessionType;
        MetricConfigurationAdapter metricConfigurationAdapter;
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
                    metricConfigurationAdapter = this.this$0.adapter;
                    if (metricConfigurationAdapter != null) {
                        List<UIWorkoutMetric> items = metricConfigurationAdapter.getItems();
                        this.label = 1;
                        if (configureMetricViewModel.sync(sessionType, items, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        throw null;
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
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkoutMetricsConfiguration$itemTouchHelperCallback$1$clearView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
