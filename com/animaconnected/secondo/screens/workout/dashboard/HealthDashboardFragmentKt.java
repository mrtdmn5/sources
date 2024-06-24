package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.ui.text.font.FontWeightKt;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.settings.health.HealthSettings;
import com.animaconnected.secondo.screens.workout.WorkoutHistory;
import com.animaconnected.secondo.screens.workout.calories.WorkoutCaloriesDetailFragment;
import com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragment;
import com.animaconnected.secondo.screens.workout.dashboard.ClickEvent;
import com.animaconnected.secondo.screens.workout.dashboard.OnboardingClickEvent;
import com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment;
import com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment;
import com.animaconnected.secondo.screens.workout.sleep.WorkoutSleepDetailFragment;
import com.animaconnected.secondo.screens.workout.steps.WorkoutStepsFragment;
import com.animaconnected.secondo.screens.workout.vo2max.WorkoutVO2MaxDetailFragment;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.animaconnected.watch.workout.DashboardViewModel;
import com.animaconnected.watch.workout.WorkoutMetricType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthDashboardFragment.kt */
/* loaded from: classes3.dex */
public final class HealthDashboardFragmentKt {

    /* compiled from: HealthDashboardFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WorkoutMetricType.values().length];
            try {
                r0[WorkoutMetricType.Steps.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WorkoutMetricType.HeartRate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WorkoutMetricType.Calories.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[WorkoutMetricType.VO2Max.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[WorkoutMetricType.Sleep.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleClicks(MainController mainController, ClickEvent clickEvent, DashboardViewModel dashboardViewModel) {
        BaseFragment newInstance;
        if (clickEvent instanceof ClickEvent.DailyGoal) {
            WorkoutDailyGoalDetailFragment newInstance2 = WorkoutDailyGoalDetailFragment.Companion.newInstance();
            AnimationFactoryKotlinKt.setupAnimVariables(newInstance2, FontWeightKt.toAndroidRect(((ClickEvent.DailyGoal) clickEvent).getRect()), true);
            mainController.gotoRevealedFragment(newInstance2);
            return;
        }
        if (clickEvent instanceof ClickEvent.Session) {
            ClickEvent.Session session = (ClickEvent.Session) clickEvent;
            WorkoutDetailsFragment newInstance3 = WorkoutDetailsFragment.Companion.newInstance(session.getTimestamp(), false);
            AnimationFactoryKotlinKt.setupAnimVariables(newInstance3, FontWeightKt.toAndroidRect(session.getCardRect()), true);
            mainController.gotoRevealedFragment(newInstance3);
            return;
        }
        if (clickEvent instanceof ClickEvent.Metric) {
            ClickEvent.Metric metric = (ClickEvent.Metric) clickEvent;
            int r6 = WhenMappings.$EnumSwitchMapping$0[metric.getType().ordinal()];
            if (r6 != 1) {
                if (r6 != 2) {
                    if (r6 != 3) {
                        if (r6 != 4) {
                            if (r6 == 5) {
                                newInstance = WorkoutSleepDetailFragment.Companion.newInstance();
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        } else {
                            newInstance = WorkoutVO2MaxDetailFragment.Companion.newInstance();
                        }
                    } else {
                        newInstance = WorkoutCaloriesDetailFragment.Companion.newInstance();
                    }
                } else {
                    newInstance = WorkoutHeartRateDetailFragment.Companion.newInstance();
                }
            } else {
                newInstance = WorkoutStepsFragment.Companion.newInstance();
            }
            AnimationFactoryKotlinKt.setupAnimVariables(newInstance, FontWeightKt.toAndroidRect(metric.getCardRect()), true);
            mainController.gotoRevealedFragment(newInstance);
            return;
        }
        if (Intrinsics.areEqual(clickEvent, ClickEvent.WorkoutHistory.INSTANCE)) {
            mainController.gotoNextFragment(WorkoutHistory.Companion.newInstance());
            return;
        }
        if (Intrinsics.areEqual(clickEvent, ClickEvent.Back.INSTANCE)) {
            mainController.goBack();
            return;
        }
        if (Intrinsics.areEqual(clickEvent, ClickEvent.HealthSettings.INSTANCE)) {
            mainController.gotoNextFragment(HealthSettings.Companion.newInstance());
            return;
        }
        if (Intrinsics.areEqual(clickEvent, OnboardingClickEvent.DailyGoal.INSTANCE)) {
            dashboardViewModel.onboardingDailyGoalDone();
            return;
        }
        if (Intrinsics.areEqual(clickEvent, OnboardingClickEvent.LetsGo.INSTANCE)) {
            dashboardViewModel.onboardingLetsGoDone();
        } else if (Intrinsics.areEqual(clickEvent, OnboardingClickEvent.Metric.INSTANCE)) {
            dashboardViewModel.onboardingMetricDone();
        } else {
            if (Intrinsics.areEqual(clickEvent, OnboardingClickEvent.Workout.INSTANCE)) {
                dashboardViewModel.onboardingWorkoutDone();
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
