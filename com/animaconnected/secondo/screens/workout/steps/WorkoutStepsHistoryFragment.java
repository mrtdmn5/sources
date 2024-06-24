package com.animaconnected.secondo.screens.workout.steps;

import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.HealthSettingsViewModel;
import com.animaconnected.watch.graphs.BarChart;
import com.animaconnected.watch.graphs.BarChartsKt;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.graphs.ChartEntry;
import com.animaconnected.watch.workout.HistoryState;
import com.animaconnected.watch.workout.StepsViewModel;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: WorkoutStepsHistoryFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutStepsHistoryFragment extends WorkoutMetricHistoryBaseFragment {
    private BarChart chartHistory;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Lazy metricName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.steps.WorkoutStepsHistoryFragment$metricName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutStepsHistoryFragment.this.getString(R.string.health_measurement_steps_title);
        }
    });
    private final Lazy titleTabs$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.steps.WorkoutStepsHistoryFragment$titleTabs$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutStepsHistoryFragment.this.getString(R.string.health_detail_history_label_title);
        }
    });
    private final String name = "WorkoutStepsHistoryFragment";
    private final int stepGoal = new HealthSettingsViewModel(ProviderFactory.getWatch().fitness()).getGoals().getSteps();
    private StepsViewModel viewModel = new StepsViewModel(ProviderFactory.getWatch().fitness());

    /* compiled from: WorkoutStepsHistoryFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutStepsHistoryFragment newInstance() {
            return new WorkoutStepsHistoryFragment();
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public Object getChartDataFlow(HistoryState historyState, Continuation<? super CommonFlow<? extends ChartData<? extends ChartEntry>>> continuation) {
        return this.viewModel.observeStepsData(historyState.getTimePeriod(), historyState.getSelectedTimePeriod(), historyState.getNbrOfEntries(), historyState.getDateFormat(), this.viewModel.markerHistoryFormatter(historyState.getHistoryTab()), continuation);
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public String getMetricName() {
        return (String) this.metricName$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public String getTitleTabs() {
        return (String) this.titleTabs$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public boolean hasDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return ProviderFactory.getWatch().fitness().hasStepsDataBefore(instant);
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void onMonthClick() {
        getBinding().tvChartInfo.setText(getString(R.string.health_detail_steps_total_title));
        BarChart barChart = this.chartHistory;
        if (barChart != null) {
            BarChartsKt.showStepsPeriodMonth(barChart);
            super.onMonthClick();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("chartHistory");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void onWeekClick() {
        getBinding().tvChartInfo.setText(getString(R.string.health_detail_steps_total_title));
        BarChart barChart = this.chartHistory;
        if (barChart != null) {
            BarChartsKt.showStepsPeriodWeek(barChart);
            super.onWeekClick();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("chartHistory");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void onYearClick() {
        getBinding().tvChartInfo.setText(getString(R.string.health_detail_steps_average_title));
        BarChart barChart = this.chartHistory;
        if (barChart != null) {
            BarChartsKt.showStepsPeriodYear(barChart);
            super.onYearClick();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("chartHistory");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void setupHistoryView() {
        TextView tvChartInfo = getBinding().tvChartInfo;
        Intrinsics.checkNotNullExpressionValue(tvChartInfo, "tvChartInfo");
        ViewKt.visible(tvChartInfo);
        getBinding().chartView.setChart(BarChartsKt.createStepsHistoryChart(getBinding().chartView.getKanvas(), getChartColors(), getChartFonts(), EmptyList.INSTANCE, this.stepGoal));
        Chart chart = getBinding().chartView.getChart();
        Intrinsics.checkNotNull(chart, "null cannot be cast to non-null type com.animaconnected.watch.graphs.BarChart");
        this.chartHistory = (BarChart) chart;
        onWeekClick();
    }
}
