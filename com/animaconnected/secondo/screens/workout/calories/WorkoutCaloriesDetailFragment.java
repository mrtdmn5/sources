package com.animaconnected.secondo.screens.workout.calories;

import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.LayoutWorkoutChartInfoBinding;
import com.animaconnected.secondo.provider.KronabyFonts;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.animaconnected.watch.display.AndroidKanvas;
import com.animaconnected.watch.graphs.BarChart;
import com.animaconnected.watch.graphs.BarChartsKt;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.watch.workout.CaloriesViewModel;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: WorkoutCaloriesDetailFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutCaloriesDetailFragment extends WorkoutMetricDetailBaseFragment {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "WorkoutCaloriesDetailFragment";
    private final Lazy metricName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.calories.WorkoutCaloriesDetailFragment$metricName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutCaloriesDetailFragment.this.getString(R.string.health_workouts_metric_calories);
        }
    });
    private final Lazy titleChartToday$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.calories.WorkoutCaloriesDetailFragment$titleChartToday$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutCaloriesDetailFragment.this.getString(R.string.activity_history_today);
        }
    });
    private final Lazy titleChartHistory$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.calories.WorkoutCaloriesDetailFragment$titleChartHistory$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutCaloriesDetailFragment.this.getString(R.string.health_lastweek_graph_title);
        }
    });
    private final Lazy aboutDescription$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.calories.WorkoutCaloriesDetailFragment$aboutDescription$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutCaloriesDetailFragment.this.getString(R.string.health_detail_calories_about_text);
        }
    });
    private final CaloriesViewModel caloriesViewModel = new CaloriesViewModel(ProviderFactory.getWatch().fitness());

    /* compiled from: WorkoutCaloriesDetailFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutCaloriesDetailFragment newInstance() {
            return new WorkoutCaloriesDetailFragment();
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment
    public String getAboutDescription() {
        return (String) this.aboutDescription$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment
    public Function0<Unit> getFullHistoryClick() {
        return new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.calories.WorkoutCaloriesDetailFragment$fullHistoryClick$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WorkoutCaloriesDetailFragment.this.getMainController().gotoNextFragment(WorkoutCaloriesHistoryFragment.Companion.newInstance());
            }
        };
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment
    public String getMetricName() {
        return (String) this.metricName$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment
    public String getTitleChartHistory() {
        return (String) this.titleChartHistory$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment
    public String getTitleChartToday() {
        return (String) this.titleChartToday$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment
    public void setupDetailView() {
        getInflater().inflate(R.layout.layout_workout_chart_info, (ViewGroup) getBinding().containerTodayChartInfo, false);
        ChartView chartView = getBinding().chartViewToday;
        AndroidKanvas kanvas = getBinding().chartViewToday.getKanvas();
        DarkThemeChartColors chartColors = getChartColors();
        KronabyFonts chartFonts = getChartFonts();
        EmptyList emptyList = EmptyList.INSTANCE;
        chartView.setChart(BarChartsKt.createCaloriesTodayChart(kanvas, chartColors, chartFonts, emptyList));
        getBinding().chartViewHistory.setChart(BarChartsKt.createCaloriesLastSevenDaysChart(getBinding().chartViewHistory.getKanvas(), getChartColors(), getChartFonts(), emptyList));
        Chart chart = getBinding().chartViewToday.getChart();
        Intrinsics.checkNotNull(chart, "null cannot be cast to non-null type com.animaconnected.watch.graphs.BarChart");
        Chart chart2 = getBinding().chartViewHistory.getChart();
        Intrinsics.checkNotNull(chart2, "null cannot be cast to non-null type com.animaconnected.watch.graphs.BarChart");
        LayoutWorkoutChartInfoBinding inflate = LayoutWorkoutChartInfoBinding.inflate(getInflater(), getBinding().containerTodayChartInfo, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new WorkoutCaloriesDetailFragment$setupDetailView$1(this, inflate, (BarChart) chart, null), 3);
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new WorkoutCaloriesDetailFragment$setupDetailView$2(this, (BarChart) chart2, null), 3);
    }
}
