package com.animaconnected.secondo.screens.workout.heartrate;

import android.os.Bundle;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.graphs.AvgMaxMinChartsKt;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.graphs.ChartEntry;
import com.animaconnected.watch.graphs.LineChartsKt;
import com.animaconnected.watch.workout.HeartRateViewModel;
import com.animaconnected.watch.workout.HistoryState;
import com.animaconnected.watch.workout.WorkoutPeriod;
import com.google.android.material.tabs.TabLayout;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: WorkoutHeartRateHistoryFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutHeartRateHistoryFragment extends WorkoutMetricHistoryBaseFragment {
    private Chart chartHistory;
    private final FitnessProvider fitnessProvider;
    private final HeartRateViewModel heartRateViewModel;
    private final Lazy metricName$delegate;
    private boolean showRestingHeartRate;
    private final Lazy titleTabs$delegate;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WorkoutHeartRateHistoryFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ WorkoutHeartRateHistoryFragment newInstance$default(Companion companion, boolean z, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                z = false;
            }
            return companion.newInstance(z);
        }

        public final WorkoutHeartRateHistoryFragment newInstance(boolean z) {
            WorkoutHeartRateHistoryFragment workoutHeartRateHistoryFragment = new WorkoutHeartRateHistoryFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("showRestingHeartRate", z);
            workoutHeartRateHistoryFragment.setArguments(bundle);
            return workoutHeartRateHistoryFragment;
        }

        private Companion() {
        }
    }

    public WorkoutHeartRateHistoryFragment() {
        FitnessProvider fitness = ProviderFactory.getWatch().fitness();
        this.fitnessProvider = fitness;
        this.heartRateViewModel = new HeartRateViewModel(fitness);
        this.metricName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateHistoryFragment$metricName$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                boolean z;
                z = WorkoutHeartRateHistoryFragment.this.showRestingHeartRate;
                if (z) {
                    return WorkoutHeartRateHistoryFragment.this.getString(R.string.health_detail_heart_rate_resting_title);
                }
                return WorkoutHeartRateHistoryFragment.this.getString(R.string.health_measurement_heart_rate_title);
            }
        });
        this.titleTabs$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateHistoryFragment$titleTabs$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return WorkoutHeartRateHistoryFragment.this.getString(R.string.health_detail_history_label_title);
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public Object getChartDataFlow(HistoryState historyState, Continuation<? super CommonFlow<? extends ChartData<? extends ChartEntry>>> continuation) {
        if (this.showRestingHeartRate) {
            return this.heartRateViewModel.observeRestingHeartRateData(historyState.getTimePeriod(), historyState.getSelectedTimePeriod(), historyState.getNbrOfEntries(), historyState.getDateFormat(), this.heartRateViewModel.markerHistoryFormatter(historyState.getHistoryTab()));
        }
        return this.heartRateViewModel.observeHeartRateData(historyState.getTimePeriod(), historyState.getSelectedTimePeriod(), historyState.getNbrOfEntries(), historyState.getDateFormat(), this.heartRateViewModel.markerHistoryFormatter(historyState.getHistoryTab()));
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
        return "WorkoutHeartRateHistoryFragment";
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public String getTitleTabs() {
        return (String) this.titleTabs$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public boolean hasDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return this.fitnessProvider.hasHeartRateDataBefore(instant);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.showRestingHeartRate = arguments.getBoolean("showRestingHeartRate");
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void onMonthClick() {
        Chart chart = this.chartHistory;
        if (chart != null) {
            LineChartsKt.showHeartRateHistory(chart, WorkoutPeriod.MONTH);
            super.onMonthClick();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("chartHistory");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void onWeekClick() {
        Chart chart = this.chartHistory;
        if (chart != null) {
            LineChartsKt.showHeartRateHistory(chart, WorkoutPeriod.WEEK);
            super.onWeekClick();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("chartHistory");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void onYearClick() {
        Chart chart = this.chartHistory;
        if (chart != null) {
            LineChartsKt.showHeartRateHistory(chart, WorkoutPeriod.YEAR);
            super.onYearClick();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("chartHistory");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void setupHistoryView() {
        TabLayout.TabView tabView;
        boolean z = this.showRestingHeartRate;
        EmptyList emptyList = EmptyList.INSTANCE;
        if (z) {
            getBinding().chartView.setChart(LineChartsKt.createRestingHeartRateHistoryChart(getBinding().chartView.getKanvas(), getChartColors(), getChartFonts(), emptyList));
            Chart chart = getBinding().chartView.getChart();
            Intrinsics.checkNotNull(chart, "null cannot be cast to non-null type com.animaconnected.watch.graphs.Chart");
            this.chartHistory = chart;
            TabLayout.Tab tabAt = getBinding().tabLayout.getTabAt(WorkoutPeriod.WEEK.ordinal());
            if (tabAt != null) {
                tabView = tabAt.view;
            } else {
                tabView = null;
            }
            if (tabView != null) {
                tabView.setVisibility(8);
            }
            TabLayout.Tab tabAt2 = getBinding().tabLayout.getTabAt(WorkoutPeriod.MONTH.ordinal());
            if (tabAt2 != null) {
                tabAt2.select();
            }
            getBinding().tvChartInfo.setText(getString(R.string.health_detail_heart_rate_average_resting_heart_rate));
            TextView tvChartInfo = getBinding().tvChartInfo;
            Intrinsics.checkNotNullExpressionValue(tvChartInfo, "tvChartInfo");
            ViewKt.visible(tvChartInfo);
            onMonthClick();
            return;
        }
        getBinding().chartView.setChart(AvgMaxMinChartsKt.createHeartRateHistoryChart(getBinding().chartView.getKanvas(), getChartColors(), getChartFonts(), emptyList));
        Chart chart2 = getBinding().chartView.getChart();
        Intrinsics.checkNotNull(chart2, "null cannot be cast to non-null type com.animaconnected.watch.graphs.Chart");
        this.chartHistory = chart2;
        onWeekClick();
    }
}
