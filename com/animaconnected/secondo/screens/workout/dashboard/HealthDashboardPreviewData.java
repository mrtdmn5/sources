package com.animaconnected.secondo.screens.workout.dashboard;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.secondo.provider.MainFonts;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.FitnessDataKt;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.theme.ChartTheme;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.watch.workout.DailyGoalItem;
import com.animaconnected.watch.workout.StringMetricListItem;
import com.animaconnected.watch.workout.WorkoutMetricType;
import com.animaconnected.widget.SessionCardData;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2;

/* compiled from: HealthDashboardUtils.kt */
/* loaded from: classes3.dex */
public final class HealthDashboardPreviewData {
    public static final HealthDashboardPreviewData INSTANCE = new HealthDashboardPreviewData();
    private static final GoalData goalData = new GoalData(new DailyGoalItem(FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(new BarEntry(0, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null))), FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(new BarEntry(0, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null))), FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(new BarEntry(0, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null)))), FitnessDataKt.m1223default(HealthGoals.Companion));
    private static final SessionCardData session = new SessionCardData(DateTimeUtilsKt.now().toEpochMilliseconds(), "Run", R.drawable.ic_run, "5.2 km", "11:20", "32m", "today");
    private static final List<StringMetricListItem> metrics = CollectionsKt__CollectionsKt.listOf((Object[]) new StringMetricListItem[]{new StringMetricListItem(WorkoutMetricType.Steps, FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2("2.3 k")), null, 4, null), new StringMetricListItem(WorkoutMetricType.HeartRate, FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2("77")), null, 4, null), new StringMetricListItem(WorkoutMetricType.Calories, FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2("870")), null, 4, null), new StringMetricListItem(WorkoutMetricType.VO2Max, FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2("37")), null, 4, null), new StringMetricListItem(WorkoutMetricType.Sleep, FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2("8h 20m")), null, 4, null)});
    private static final ChartTheme chartTheme = new ChartTheme(new DarkThemeChartColors(), new MainFonts());
    public static final int $stable = 8;

    private HealthDashboardPreviewData() {
    }

    public final ChartTheme getChartTheme() {
        return chartTheme;
    }

    public final GoalData getGoalData() {
        return goalData;
    }

    public final List<StringMetricListItem> getMetrics() {
        return metrics;
    }

    public final SessionCardData getSession() {
        return session;
    }
}
