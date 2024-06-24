package com.animaconnected.secondo.screens.workout.heartrate;

import android.content.Context;
import android.icu.text.RelativeDateTimeFormatter;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.secondo.databinding.LayoutHeartRateChartInfoBinding;
import com.animaconnected.secondo.provider.KronabyFonts;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment;
import com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateHistoryFragment;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.animaconnected.watch.display.AndroidKanvas;
import com.animaconnected.watch.display.DpUtils;
import com.animaconnected.watch.fitness.HeartrateValue;
import com.animaconnected.watch.graphs.AverageMaxMinChart;
import com.animaconnected.watch.graphs.AvgMaxMinChartsKt;
import com.animaconnected.watch.graphs.AvgMaxMinEntry;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.graphs.LineChart;
import com.animaconnected.watch.graphs.LineChartsKt;
import com.animaconnected.watch.graphs.PointEntry;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.watch.workout.HeartRateSummary;
import com.animaconnected.watch.workout.HeartRateViewModel;
import com.animaconnected.watch.workout.HeartrateMetricItem;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.datetime.Instant;

/* compiled from: WorkoutHeartRateDetailFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutHeartRateDetailFragment extends WorkoutMetricDetailBaseFragment {
    private LineChart restingHeartRateChart;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "WorkoutHeartRateDetailFragment";
    private final Lazy metricName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$metricName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutHeartRateDetailFragment.this.getString(R.string.health_measurement_heart_rate_title);
        }
    });
    private final Lazy titleChartToday$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$titleChartToday$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutHeartRateDetailFragment.this.getString(R.string.activity_history_today);
        }
    });
    private final Lazy titleChartHistory$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$titleChartHistory$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutHeartRateDetailFragment.this.getString(R.string.health_lastweek_graph_title);
        }
    });
    private final Lazy titleRestingHeartRateChart$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$titleRestingHeartRateChart$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutHeartRateDetailFragment.this.getString(R.string.health_detail_heart_rate_resting_title);
        }
    });
    private final Lazy aboutDescription$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$aboutDescription$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutHeartRateDetailFragment.this.getString(R.string.health_detail_heart_rate_about_text);
        }
    });
    private final Lazy secondAboutTitle$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$secondAboutTitle$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutHeartRateDetailFragment.this.getString(R.string.health_detail_heart_rate_resting_title);
        }
    });
    private final Lazy secondAboutDescription$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$secondAboutDescription$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutHeartRateDetailFragment.this.getString(R.string.health_detail_heart_rate_resting_about_text);
        }
    });
    private final HeartRateViewModel heartRateViewModel = new HeartRateViewModel(ProviderFactory.getWatch().fitness());
    private final RelativeDateTimeFormatter relativeDateFormatter = RelativeDateTimeFormatter.getInstance();

    /* compiled from: WorkoutHeartRateDetailFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutHeartRateDetailFragment newInstance() {
            return new WorkoutHeartRateDetailFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function0<Unit> getRestingHeartRateFullHistoryClick() {
        return new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$restingHeartRateFullHistoryClick$1
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
                WorkoutHeartRateDetailFragment.this.getMainController().gotoNextFragment(WorkoutHeartRateHistoryFragment.Companion.newInstance(true));
            }
        };
    }

    private final String getTitleRestingHeartRateChart() {
        return (String) this.titleRestingHeartRateChart$delegate.getValue();
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
        return new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$fullHistoryClick$1
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
                WorkoutHeartRateDetailFragment.this.getMainController().gotoNextFragment(WorkoutHeartRateHistoryFragment.Companion.newInstance$default(WorkoutHeartRateHistoryFragment.Companion, false, 1, null));
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
    public String getSecondAboutDescription() {
        return (String) this.secondAboutDescription$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment
    public String getSecondAboutTitle() {
        return (String) this.secondAboutTitle$delegate.getValue();
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
        getInflater().inflate(R.layout.layout_heart_rate_chart_info, (ViewGroup) getBinding().containerTodayChartInfo, false);
        AndroidKanvas kanvas = getBinding().chartViewToday.getKanvas();
        DarkThemeChartColors chartColors = getChartColors();
        KronabyFonts chartFonts = getChartFonts();
        EmptyList emptyList = EmptyList.INSTANCE;
        final LineChart createHeartRateTodayChart = LineChartsKt.createHeartRateTodayChart(kanvas, chartColors, chartFonts, emptyList);
        getBinding().chartViewToday.setChart(createHeartRateTodayChart);
        final AverageMaxMinChart createHeartRateLastSevenDaysChart = AvgMaxMinChartsKt.createHeartRateLastSevenDaysChart(getBinding().chartViewHistory.getKanvas(), getChartColors(), getChartFonts(), emptyList);
        ChartView chartView = getBinding().chartViewHistory;
        ViewGroup.LayoutParams layoutParams = chartView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = chartView.getLayoutParams();
        DpUtils dpUtils = DpUtils.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        layoutParams2.height = dpUtils.dpToPx(requireContext, 240.0f);
        chartView.setLayoutParams(layoutParams);
        chartView.setChart(createHeartRateLastSevenDaysChart);
        this.restingHeartRateChart = LineChartsKt.createRestingHeartRateDetailChart(getBinding().chartViewDetail.getKanvas(), getChartColors(), getChartFonts(), emptyList);
        ChartView chartView2 = getBinding().chartViewDetail;
        LineChart lineChart = this.restingHeartRateChart;
        if (lineChart != null) {
            chartView2.setChart(lineChart);
            getBinding().tvChartDetailTitle.setText(getTitleRestingHeartRateChart());
            TextView tvChartDetailTitle = getBinding().tvChartDetailTitle;
            Intrinsics.checkNotNullExpressionValue(tvChartDetailTitle, "tvChartDetailTitle");
            ViewKt.visible(tvChartDetailTitle);
            RelativeLayout containerDetail = getBinding().containerDetail;
            Intrinsics.checkNotNullExpressionValue(containerDetail, "containerDetail");
            ViewKt.visible(containerDetail);
            TextView tvFullHistoryDetail = getBinding().tvFullHistoryDetail;
            Intrinsics.checkNotNullExpressionValue(tvFullHistoryDetail, "tvFullHistoryDetail");
            onClick(tvFullHistoryDetail, new WorkoutHeartRateDetailFragment$setupDetailView$2(this, null));
            final LayoutHeartRateChartInfoBinding inflate = LayoutHeartRateChartInfoBinding.inflate(getInflater(), getBinding().containerTodayChartInfo, true);
            BaseFragmentUtilsKt.collectSafelyOnStarted(this, this.heartRateViewModel.observeLiveHeartRateData(), new Function1<HeartrateMetricItem, Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$setupDetailView$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HeartrateMetricItem heartrateMetricItem) {
                    invoke2(heartrateMetricItem);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HeartrateMetricItem heartRate) {
                    RelativeDateTimeFormatter relativeDateTimeFormatter;
                    String format;
                    Intrinsics.checkNotNullParameter(heartRate, "heartRate");
                    Instant now = DateTimeUtilsKt.now();
                    HeartrateValue conditionalHeartrateValue = heartRate.conditionalHeartrateValue(now);
                    Integer valueOf = conditionalHeartrateValue != null ? Integer.valueOf(conditionalHeartrateValue.getHeartrate()) : null;
                    if (valueOf == null) {
                        LayoutHeartRateChartInfoBinding.this.tvLiveValue.setText(StringsExtensionsKt.getAppString(Key.not_available));
                        TextView tvLiveUnit = LayoutHeartRateChartInfoBinding.this.tvLiveUnit;
                        Intrinsics.checkNotNullExpressionValue(tvLiveUnit, "tvLiveUnit");
                        ViewKt.gone(tvLiveUnit);
                    } else {
                        LayoutHeartRateChartInfoBinding.this.tvCurrentHeartRateTitle.setText(this.getString(R.string.health_detail_heart_rate_current_title));
                        LayoutHeartRateChartInfoBinding.this.tvLiveValue.setText(valueOf.toString());
                        TextView tvLiveUnit2 = LayoutHeartRateChartInfoBinding.this.tvLiveUnit;
                        Intrinsics.checkNotNullExpressionValue(tvLiveUnit2, "tvLiveUnit");
                        ViewKt.visible(tvLiveUnit2);
                    }
                    Instant conditionalTimestamp = heartRate.conditionalTimestamp(now);
                    TextView textView = LayoutHeartRateChartInfoBinding.this.tvCurrentHeartRateTitle;
                    if (conditionalTimestamp != null) {
                        relativeDateTimeFormatter = this.relativeDateFormatter;
                        format = relativeDateTimeFormatter.format(Duration.m1678getInWholeMinutesimpl(now.m1704minus5sfh64U(conditionalTimestamp)), RelativeDateTimeFormatter.Direction.LAST, RelativeDateTimeFormatter.RelativeUnit.MINUTES);
                    } else {
                        format = this.getString(R.string.health_detail_heart_rate_current_title);
                    }
                    textView.setText(format);
                }
            });
            BaseFragmentUtilsKt.collectSafelyOnStarted(this, this.heartRateViewModel.observeTodayHeartRateData(), new Function1<HeartRateSummary, Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$setupDetailView$3$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HeartRateSummary heartRateSummary) {
                    invoke2(heartRateSummary);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HeartRateSummary summary) {
                    Intrinsics.checkNotNullParameter(summary, "summary");
                    LineChart.this.setShowNoDataText(summary.isEmpty());
                    LineChart.this.setData(summary.getPoints());
                    inflate.tvHeartRateHighValue.setText(summary.getMaxValue());
                    inflate.tvHeartRateAvgValue.setText(summary.getAverageValue());
                    inflate.tvHeartRateLowValue.setText(summary.getMinValue());
                }
            });
            BaseFragmentUtilsKt.collectSafelyOnStarted(this, this.heartRateViewModel.observeLastMonthRestingHeartRateData(), new Function1<ChartData<? extends PointEntry>, Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$setupDetailView$3$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ChartData<? extends PointEntry> chartData) {
                    invoke2((ChartData<PointEntry>) chartData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ChartData<PointEntry> data) {
                    LineChart lineChart2;
                    LineChart lineChart3;
                    Intrinsics.checkNotNullParameter(data, "data");
                    lineChart2 = WorkoutHeartRateDetailFragment.this.restingHeartRateChart;
                    if (lineChart2 != null) {
                        lineChart2.setShowNoDataText(data.isDataEmpty());
                        lineChart3 = WorkoutHeartRateDetailFragment.this.restingHeartRateChart;
                        if (lineChart3 != null) {
                            lineChart3.setData(data.getEntries());
                            return;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("restingHeartRateChart");
                            throw null;
                        }
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("restingHeartRateChart");
                    throw null;
                }
            });
            BaseFragmentUtilsKt.collectSafelyOnStarted(this, this.heartRateViewModel.observeLastWeekHeartRateData(), new Function1<ChartData<? extends AvgMaxMinEntry>, Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$setupDetailView$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ChartData<? extends AvgMaxMinEntry> chartData) {
                    invoke2((ChartData<AvgMaxMinEntry>) chartData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ChartData<AvgMaxMinEntry> data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    AverageMaxMinChart.this.setShowNoDataText(data.isDataEmpty());
                    AverageMaxMinChart.this.setData(data.getEntries());
                }
            });
            WorkoutMetricDetailBaseFragment.setupToolbarHelpButton$default(this, 0, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.WorkoutHeartRateDetailFragment$setupDetailView$5
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
                    HelpPagesBottomDialogKt.showGraphInfoBottomDialog(WorkoutHeartRateDetailFragment.this);
                }
            }, 1, null);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("restingHeartRateChart");
        throw null;
    }
}
