package com.animaconnected.secondo.screens.workout.sleep;

import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.graphs.ChartEntry;
import com.animaconnected.watch.graphs.StackedBarChart;
import com.animaconnected.watch.graphs.StackedBarChartsKt;
import com.animaconnected.watch.workout.HistoryState;
import com.animaconnected.watch.workout.SleepViewModel;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: WorkoutSleepHistoryFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutSleepHistoryFragment extends WorkoutMetricHistoryBaseFragment {
    private StackedBarChart chartHistory;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Lazy metricName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.sleep.WorkoutSleepHistoryFragment$metricName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutSleepHistoryFragment.this.getString(R.string.health_measurement_sleep_title);
        }
    });
    private final Lazy titleTabs$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.sleep.WorkoutSleepHistoryFragment$titleTabs$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutSleepHistoryFragment.this.getString(R.string.health_detail_history_label_title);
        }
    });
    private final String name = "WorkoutSleepHistoryFragment";
    private final SleepViewModel sleepViewModel = new SleepViewModel(ProviderFactory.getWatch().fitness());

    /* compiled from: WorkoutSleepHistoryFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutSleepHistoryFragment newInstance() {
            return new WorkoutSleepHistoryFragment();
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public Object getChartDataFlow(HistoryState historyState, Continuation<? super CommonFlow<? extends ChartData<? extends ChartEntry>>> continuation) {
        return this.sleepViewModel.observeSleepData(historyState.getTimePeriod(), historyState.getSelectedTimePeriod(), historyState.getNbrOfEntries(), historyState.getDateFormat(), this.sleepViewModel.markerHistoryFormatter(historyState.getHistoryTab()), continuation);
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
        return ProviderFactory.getWatch().fitness().hasSleepHistoryBefore(instant);
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void onMonthClick() {
        getBinding().tvChartInfo.setText(getString(R.string.health_detail_sleep_total_sleep));
        StackedBarChart stackedBarChart = this.chartHistory;
        if (stackedBarChart != null) {
            StackedBarChartsKt.showSleepPeriodMonth(stackedBarChart);
            super.onMonthClick();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("chartHistory");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void onWeekClick() {
        getBinding().tvChartInfo.setText(getString(R.string.health_detail_sleep_total_sleep));
        StackedBarChart stackedBarChart = this.chartHistory;
        if (stackedBarChart != null) {
            StackedBarChartsKt.showSleepPeriodWeek(stackedBarChart);
            super.onWeekClick();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("chartHistory");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void onYearClick() {
        getBinding().tvChartInfo.setText(getString(R.string.health_detail_sleep_average_sleep_per_month));
        StackedBarChart stackedBarChart = this.chartHistory;
        if (stackedBarChart != null) {
            StackedBarChartsKt.showSleepPeriodYear(stackedBarChart);
            super.onYearClick();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("chartHistory");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void setupHistoryView() {
        getBinding().chartView.setChart(StackedBarChartsKt.createSleepHistoryChart(getBinding().chartView.getKanvas(), getChartColors(), getChartFonts()));
        Chart chart = getBinding().chartView.getChart();
        Intrinsics.checkNotNull(chart, "null cannot be cast to non-null type com.animaconnected.watch.graphs.StackedBarChart");
        this.chartHistory = (StackedBarChart) chart;
        TextView tvChartInfo = getBinding().tvChartInfo;
        Intrinsics.checkNotNullExpressionValue(tvChartInfo, "tvChartInfo");
        ViewKt.visible(tvChartInfo);
        onWeekClick();
    }
}
