package com.animaconnected.secondo.screens.workout.sleep;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentGenericWorkoutMetricDetailBinding;
import com.animaconnected.secondo.databinding.LayoutSleepChartInfoBinding;
import com.animaconnected.secondo.provider.KronabyFonts;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.display.AndroidKanvas;
import com.animaconnected.watch.graphs.SleepChartsKt;
import com.animaconnected.watch.graphs.StackedBarChart;
import com.animaconnected.watch.graphs.StackedBarChartsKt;
import com.animaconnected.watch.graphs.StateChart;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.watch.workout.SleepViewModel;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: WorkoutSleepDetailFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutSleepDetailFragment extends WorkoutMetricDetailBaseFragment {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "WorkoutSleepDetailFragment";
    private final Lazy metricName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.sleep.WorkoutSleepDetailFragment$metricName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutSleepDetailFragment.this.getString(R.string.sleep_title);
        }
    });
    private final Lazy titleChartToday$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.sleep.WorkoutSleepDetailFragment$titleChartToday$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutSleepDetailFragment.this.getString(R.string.health_sleep_last_night_title);
        }
    });
    private final Lazy titleChartHistory$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.sleep.WorkoutSleepDetailFragment$titleChartHistory$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutSleepDetailFragment.this.getString(R.string.sleep_history);
        }
    });
    private final Lazy aboutDescription$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.sleep.WorkoutSleepDetailFragment$aboutDescription$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutSleepDetailFragment.this.getString(R.string.health_detail_sleep_about_text);
        }
    });
    private final SleepViewModel sleepViewModel = new SleepViewModel(ProviderFactory.getWatch().fitness());

    /* compiled from: WorkoutSleepDetailFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutSleepDetailFragment newInstance() {
            return new WorkoutSleepDetailFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpannedString formatTotalSleep(String str) {
        Integer num;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int r4 = 0;
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 18);
        SpannableString valueOf = SpannableString.valueOf(str);
        ArrayList arrayList = new ArrayList();
        int r2 = 0;
        while (r4 < valueOf.length()) {
            int r5 = r2 + 1;
            if (Character.isDigit(valueOf.charAt(r4))) {
                num = Integer.valueOf(r2);
            } else {
                num = null;
            }
            if (num != null) {
                arrayList.add(num);
            }
            r4++;
            r2 = r5;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            spannableStringBuilder.setSpan(new RelativeSizeSpan(1.3f), intValue, intValue + 1, 17);
        }
        return new SpannedString(spannableStringBuilder);
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
        return new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.sleep.WorkoutSleepDetailFragment$fullHistoryClick$1
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
                WorkoutSleepDetailFragment.this.getMainController().gotoNextFragment(WorkoutSleepHistoryFragment.Companion.newInstance());
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
        getInflater().inflate(R.layout.layout_sleep_chart_info, (ViewGroup) getBinding().containerTodayChartInfo, false);
        AndroidKanvas kanvas = getBinding().chartViewToday.getKanvas();
        DarkThemeChartColors chartColors = getChartColors();
        KronabyFonts chartFonts = getChartFonts();
        EmptyList emptyList = EmptyList.INSTANCE;
        final StateChart createSleepTodayChart = SleepChartsKt.createSleepTodayChart(kanvas, chartColors, chartFonts, emptyList, ProviderFactory.getWatch().fitness().getProfile().getBedtime());
        getBinding().chartViewToday.setChart(createSleepTodayChart);
        StackedBarChart createSleepLastSevenDaysChart = StackedBarChartsKt.createSleepLastSevenDaysChart(getBinding().chartViewHistory.getKanvas(), getChartColors(), getChartFonts(), emptyList);
        getBinding().chartViewHistory.setChart(createSleepLastSevenDaysChart);
        final LayoutSleepChartInfoBinding inflate = LayoutSleepChartInfoBinding.inflate(getInflater(), getBinding().containerTodayChartInfo, true);
        BaseFragmentUtilsKt.collectSafelyOnStarted(this, this.sleepViewModel.observeLastNightSleepData(), new Function1<SleepViewModel.SleepSummary, Unit>() { // from class: com.animaconnected.secondo.screens.workout.sleep.WorkoutSleepDetailFragment$setupDetailView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SleepViewModel.SleepSummary sleepSummary) {
                invoke2(sleepSummary);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SleepViewModel.SleepSummary summary) {
                SpannedString formatTotalSleep;
                Intrinsics.checkNotNullParameter(summary, "summary");
                TextView textView = LayoutSleepChartInfoBinding.this.tvTotalSleepValue;
                formatTotalSleep = this.formatTotalSleep(summary.getTotalSleep());
                textView.setText(formatTotalSleep);
                LayoutSleepChartInfoBinding.this.tvSleepLightPercentage.setText(summary.getLightSleepPercentage());
                LayoutSleepChartInfoBinding.this.tvSleepDeepPercentage.setText(summary.getDeepSleepPercentage());
                createSleepTodayChart.setShowNoDataText(summary.isEmpty());
                createSleepTodayChart.setData(summary.getData());
            }
        });
        FragmentGenericWorkoutMetricDetailBinding binding = getBinding();
        if (!this.sleepViewModel.hasSleepData()) {
            CardView cardEmptyState = binding.cardEmptyState;
            Intrinsics.checkNotNullExpressionValue(cardEmptyState, "cardEmptyState");
            ViewKt.visible(cardEmptyState);
            binding.tvEmptyStateTitle.setText(getString(R.string.health_detail_sleep_no_data));
            binding.tvEmptyStateDescription.setText(getString(R.string.health_detail_sleep_not_enough_data));
        } else {
            CardView cardEmptyState2 = binding.cardEmptyState;
            Intrinsics.checkNotNullExpressionValue(cardEmptyState2, "cardEmptyState");
            ViewKt.gone(cardEmptyState2);
        }
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new WorkoutSleepDetailFragment$setupDetailView$3(this, createSleepLastSevenDaysChart, null), 3);
    }
}
