package com.animaconnected.secondo.screens.workout.steps;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentGenericWorkoutMetricDetailBinding;
import com.animaconnected.secondo.databinding.LayoutWorkoutChartInfoBinding;
import com.animaconnected.secondo.provider.KronabyFonts;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.screens.workout.utils.ChartMitmapsKt;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.animaconnected.watch.HealthSettingsViewModel;
import com.animaconnected.watch.display.AndroidKanvas;
import com.animaconnected.watch.graphs.BarChart;
import com.animaconnected.watch.graphs.BarChartSize;
import com.animaconnected.watch.graphs.BarChartsKt;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.ChartEntry;
import com.animaconnected.watch.graphs.HorizontalProgressBar;
import com.animaconnected.watch.graphs.SegmentedProgressBarChartsKt;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.watch.workout.StepsViewModel;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: WorkoutStepsFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutStepsFragment extends WorkoutMetricDetailBaseFragment {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "WorkoutStepsFragment";
    private final Lazy metricName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.steps.WorkoutStepsFragment$metricName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutStepsFragment.this.getString(R.string.health_measurement_steps_title);
        }
    });
    private final Lazy titleChartToday$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.steps.WorkoutStepsFragment$titleChartToday$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutStepsFragment.this.getString(R.string.activity_history_today);
        }
    });
    private final Lazy titleChartHistory$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.steps.WorkoutStepsFragment$titleChartHistory$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutStepsFragment.this.getString(R.string.health_lastweek_graph_title);
        }
    });
    private final Lazy aboutDescription$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.steps.WorkoutStepsFragment$aboutDescription$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutStepsFragment.this.getString(R.string.health_detail_steps_about_text);
        }
    });
    private final int stepGoal = new HealthSettingsViewModel(ProviderFactory.getWatch().fitness()).getGoals().getSteps();
    private StepsViewModel viewModel = new StepsViewModel(ProviderFactory.getWatch().fitness());

    /* compiled from: WorkoutStepsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutStepsFragment newInstance() {
            return new WorkoutStepsFragment();
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
        return new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.steps.WorkoutStepsFragment$fullHistoryClick$1
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
                WorkoutStepsFragment.this.getMainController().gotoNextFragment(WorkoutStepsHistoryFragment.Companion.newInstance());
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
        AndroidKanvas kanvas = getBinding().chartViewToday.getKanvas();
        DarkThemeChartColors chartColors = getChartColors();
        KronabyFonts chartFonts = getChartFonts();
        EmptyList emptyList = EmptyList.INSTANCE;
        final BarChart createStepsTodayChart = BarChartsKt.createStepsTodayChart(kanvas, chartColors, chartFonts, emptyList);
        getBinding().chartViewToday.setChart(createStepsTodayChart);
        BarChart createStepsLastSevenDaysChart = BarChartsKt.createStepsLastSevenDaysChart(getBinding().chartViewHistory.getKanvas(), getChartColors(), getChartFonts(), emptyList, this.stepGoal);
        getBinding().chartViewHistory.setChart(createStepsLastSevenDaysChart);
        final HorizontalProgressBar createHorizontalProgressBarChart = SegmentedProgressBarChartsKt.createHorizontalProgressBarChart(getBinding().chartProgressBar.getKanvas(), getChartColors(), getChartFonts(), BarChartSize.Large, this.stepGoal, false, false, ChartMitmapsKt.getNinePatchProgressBackground());
        FragmentGenericWorkoutMetricDetailBinding binding = getBinding();
        getInflater().inflate(R.layout.layout_workout_chart_info, (ViewGroup) binding.containerTodayChartInfo, false);
        ChartView chartProgressBar = binding.chartProgressBar;
        Intrinsics.checkNotNullExpressionValue(chartProgressBar, "chartProgressBar");
        ViewKt.visible(chartProgressBar);
        binding.chartProgressBar.setChart(createHorizontalProgressBarChart);
        final LayoutWorkoutChartInfoBinding inflate = LayoutWorkoutChartInfoBinding.inflate(getInflater(), getBinding().containerTodayChartInfo, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        BaseFragmentUtilsKt.collectSafelyOnStarted(this, this.viewModel.observeStepsTodaySummary(), new Function1<Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.steps.WorkoutStepsFragment$setupDetailView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int r12) {
                int r1;
                List<? extends ChartEntry> listOf = CollectionsKt__CollectionsKt.listOf(new BarEntry(r12, "", 0L, (String) null, (String) null, false, 60, (DefaultConstructorMarker) null));
                LayoutWorkoutChartInfoBinding.this.tvTextOne.setText(String.valueOf(r12));
                TextView tvDivider = LayoutWorkoutChartInfoBinding.this.tvDivider;
                Intrinsics.checkNotNullExpressionValue(tvDivider, "tvDivider");
                ViewKt.visible(tvDivider);
                TextView textView = LayoutWorkoutChartInfoBinding.this.tvTextTwo;
                r1 = this.stepGoal;
                textView.setText(String.valueOf(r1));
                createStepsTodayChart.setData(listOf);
                createHorizontalProgressBarChart.setData(listOf);
            }
        });
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new WorkoutStepsFragment$setupDetailView$3(this, createStepsTodayChart, null), 3);
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new WorkoutStepsFragment$setupDetailView$4(this, createStepsLastSevenDaysChart, null), 3);
    }
}
