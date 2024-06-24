package com.animaconnected.secondo.screens.workout.vo2max;

import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.graphs.ChartEntry;
import com.animaconnected.watch.graphs.Vo2MaxHistoryChart;
import com.animaconnected.watch.graphs.Vo2MaxHistoryChartsKt;
import com.animaconnected.watch.workout.FitnessIndexViewModel;
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

/* compiled from: WorkoutVO2MaxHistoryFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutVO2MaxHistoryFragment extends WorkoutMetricHistoryBaseFragment {
    private Vo2MaxHistoryChart chartHistory;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "WorkoutVO2MaxHistoryFragment";
    private final Lazy metricName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.vo2max.WorkoutVO2MaxHistoryFragment$metricName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutVO2MaxHistoryFragment.this.getString(R.string.fitness_index_vo2max_title);
        }
    });
    private final Lazy titleTabs$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.vo2max.WorkoutVO2MaxHistoryFragment$titleTabs$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutVO2MaxHistoryFragment.this.getString(R.string.health_detail_history_label_title);
        }
    });
    private FitnessIndexViewModel viewModel = new FitnessIndexViewModel(ProviderFactory.getWatch().fitness());

    /* compiled from: WorkoutVO2MaxHistoryFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutVO2MaxHistoryFragment newInstance() {
            return new WorkoutVO2MaxHistoryFragment();
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public Object getChartDataFlow(HistoryState historyState, Continuation<? super CommonFlow<? extends ChartData<? extends ChartEntry>>> continuation) {
        return this.viewModel.observeFitnessIndexData(historyState.getTimePeriod(), historyState.getSelectedTimePeriod(), historyState.getNbrOfEntries(), historyState.getDateFormat(), this.viewModel.markerHistoryFormatter(historyState.getHistoryTab()));
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
        return ProviderFactory.getWatch().fitness().hasFitnessIndexDataBefore(instant);
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void onMonthClick() {
        Vo2MaxHistoryChart vo2MaxHistoryChart = this.chartHistory;
        if (vo2MaxHistoryChart != null) {
            Vo2MaxHistoryChartsKt.showMonth(vo2MaxHistoryChart);
            super.onMonthClick();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("chartHistory");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void onYearClick() {
        Vo2MaxHistoryChart vo2MaxHistoryChart = this.chartHistory;
        if (vo2MaxHistoryChart != null) {
            Vo2MaxHistoryChartsKt.showYear(vo2MaxHistoryChart);
            super.onYearClick();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("chartHistory");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment
    public void setupHistoryView() {
        TabLayout.TabView tabView;
        getBinding().chartView.setChart(Vo2MaxHistoryChartsKt.createVo2MaxHistoryChart(getBinding().chartView.getKanvas(), getChartColors(), getChartFonts(), EmptyList.INSTANCE, ProviderFactory.getWatch().fitness().getProfile()));
        Chart chart = getBinding().chartView.getChart();
        Intrinsics.checkNotNull(chart, "null cannot be cast to non-null type com.animaconnected.watch.graphs.Vo2MaxHistoryChart");
        this.chartHistory = (Vo2MaxHistoryChart) chart;
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
        onMonthClick();
    }
}
