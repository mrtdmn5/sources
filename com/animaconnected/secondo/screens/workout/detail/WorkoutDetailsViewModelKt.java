package com.animaconnected.secondo.screens.workout.detail;

import com.animaconnected.watch.workout.MetricType;
import com.kronaby.watch.app.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;

/* compiled from: WorkoutDetailsViewModel.kt */
/* loaded from: classes3.dex */
public final class WorkoutDetailsViewModelKt {

    /* compiled from: WorkoutDetailsViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[MetricType.values().length];
            try {
                r0[MetricType.ACTIVE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[MetricType.TOTAL_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[MetricType.DISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[MetricType.STEPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[MetricType.PACE_AVG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[MetricType.SPEED_AVG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r0[MetricType.ACTIVE_CALORIES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r0[MetricType.TOTAL_CALORIES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toString(MetricType metricType, Function1<? super Integer, String> function1) {
        switch (WhenMappings.$EnumSwitchMapping$0[metricType.ordinal()]) {
            case 1:
                return function1.invoke(Integer.valueOf(R.string.health_workouts_metric_moving_time));
            case 2:
                return function1.invoke(Integer.valueOf(R.string.health_workouts_metric_elapsed_time));
            case 3:
                return function1.invoke(Integer.valueOf(R.string.health_workouts_metric_distance));
            case 4:
                return function1.invoke(Integer.valueOf(R.string.health_workouts_metric_steps));
            case 5:
                return function1.invoke(Integer.valueOf(R.string.health_workouts_metric_average_pace));
            case 6:
                return function1.invoke(Integer.valueOf(R.string.health_workouts_metric_average_speed));
            case 7:
                return function1.invoke(Integer.valueOf(R.string.health_workouts_metric_calories_active));
            case 8:
                return function1.invoke(Integer.valueOf(R.string.health_workouts_metric_calories_total));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
