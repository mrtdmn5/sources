package com.animaconnected.secondo.screens.debugsettings.graphs;

import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.secondo.databinding.FragmentDebugChartBinding;
import com.animaconnected.secondo.provider.KronabyFonts;
import com.animaconnected.secondo.screens.activity.ActivityStepGoalDialogFragmentCallback;
import com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.AndroidDateFormatter;
import com.animaconnected.watch.HealthSettingsViewModel;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.display.AndroidKanvas;
import com.animaconnected.watch.fitness.EntriesAmount;
import com.animaconnected.watch.fitness.EqualIntervals;
import com.animaconnected.watch.fitness.MockFitnessProvider;
import com.animaconnected.watch.fitness.Months;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.TimePeriodKt;
import com.animaconnected.watch.graphs.BarChart;
import com.animaconnected.watch.graphs.BarChartsKt;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.watch.workout.StepsViewModel;
import com.google.common.collect.Hashing;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt;

/* compiled from: DebugStepsChartFragment.kt */
/* loaded from: classes3.dex */
public final class DebugStepsChartFragment extends DebugChartBase implements ActivityStepGoalDialogFragmentCallback {
    private final HealthSettingsViewModel healthSettingsViewModel;
    private final StepsViewModel viewModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "DebugStepsChartFragment";
    private List<BarEntry> stepsData = new ArrayList();
    private int goalValue = Constants.MAXIMUM_UPLOAD_PARTS;
    private final DebugBarEntryAdapter debugAdapter = new DebugBarEntryAdapter();
    private final Lazy chartToday$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BarChart>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugStepsChartFragment$chartToday$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BarChart invoke() {
            return BarChartsKt.createStepsTodayChart(DebugStepsChartFragment.this.getChartViewToday().getKanvas(), DebugStepsChartFragment.this.getChartColors(), DebugStepsChartFragment.this.getChartfonts(), EmptyList.INSTANCE);
        }
    });
    private final Lazy chartLast7Days$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BarChart>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugStepsChartFragment$chartLast7Days$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BarChart invoke() {
            HealthSettingsViewModel healthSettingsViewModel;
            AndroidKanvas kanvas = DebugStepsChartFragment.this.getChartViewLast7Days().getKanvas();
            DarkThemeChartColors chartColors = DebugStepsChartFragment.this.getChartColors();
            KronabyFonts chartfonts = DebugStepsChartFragment.this.getChartfonts();
            EmptyList emptyList = EmptyList.INSTANCE;
            healthSettingsViewModel = DebugStepsChartFragment.this.healthSettingsViewModel;
            return BarChartsKt.createStepsLastSevenDaysChart(kanvas, chartColors, chartfonts, emptyList, healthSettingsViewModel.getGoals().getSteps());
        }
    });
    private final Lazy chartHistory$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BarChart>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugStepsChartFragment$chartHistory$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BarChart invoke() {
            int r4;
            AndroidKanvas kanvas = DebugStepsChartFragment.this.getChartViewHistory().getKanvas();
            DarkThemeChartColors chartColors = DebugStepsChartFragment.this.getChartColors();
            KronabyFonts chartfonts = DebugStepsChartFragment.this.getChartfonts();
            EmptyList emptyList = EmptyList.INSTANCE;
            r4 = DebugStepsChartFragment.this.goalValue;
            return BarChartsKt.createStepsHistoryChart(kanvas, chartColors, chartfonts, emptyList, r4);
        }
    });

    /* compiled from: DebugStepsChartFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugStepsChartFragment newInstance() {
            return new DebugStepsChartFragment();
        }

        private Companion() {
        }
    }

    /* compiled from: DebugStepsChartFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[DebugChartBase.Screen.values().length];
            try {
                r0[DebugChartBase.Screen.Today.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[DebugChartBase.Screen.Last7Days.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DebugStepsChartFragment() {
        int r3 = 3;
        this.healthSettingsViewModel = new HealthSettingsViewModel(new MockFitnessProvider(null, 0 == true ? 1 : 0, r3, 0 == true ? 1 : 0));
        this.viewModel = new StepsViewModel(new MockFitnessProvider(0 == true ? 1 : 0, 0 == true ? 1 : 0, r3, 0 == true ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateCurrentScreen() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[getCurrentScreen().ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                getChartHistory().setData(this.stepsData);
            } else {
                getChartLast7Days().setData(this.stepsData);
            }
        } else {
            getChartToday().setData(this.stepsData);
        }
        this.debugAdapter.setData(this.stepsData);
    }

    private final void observeHistorySteps(TimePeriod timePeriod, TimePeriod timePeriod2, EntriesAmount entriesAmount, DateFormatter dateFormatter, Function1<? super Long, String> function1) {
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugStepsChartFragment$observeHistorySteps$2(this, timePeriod, timePeriod2, entriesAmount, dateFormatter, function1, null), 3);
    }

    public static /* synthetic */ void observeHistorySteps$default(DebugStepsChartFragment debugStepsChartFragment, TimePeriod timePeriod, TimePeriod timePeriod2, EntriesAmount entriesAmount, DateFormatter dateFormatter, Function1 function1, int r12, Object obj) {
        if ((r12 & 16) != 0) {
            function1 = new Function1<Long, String>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugStepsChartFragment$observeHistorySteps$1
                public final String invoke(long j) {
                    return "";
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ String invoke(Long l) {
                    return invoke(l.longValue());
                }
            };
        }
        debugStepsChartFragment.observeHistorySteps(timePeriod, timePeriod2, entriesAmount, dateFormatter, function1);
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void on7DaysClick() {
        super.on7DaysClick();
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugStepsChartFragment$on7DaysClick$1(this, null), 3);
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onEmptyDataClick() {
        List<BarEntry> list = this.stepsData;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new BarEntry(0, ((BarEntry) it.next()).getXAxisLabel(), 0L, (String) null, (String) null, false, 60, (DefaultConstructorMarker) null));
        }
        this.stepsData = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        invalidateCurrentScreen();
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onMonthClick() {
        super.onMonthClick();
        BarChartsKt.showStepsPeriodMonth(getChartHistory());
        TimePeriod.Companion companion = TimePeriod.Companion;
        observeHistorySteps$default(this, TimePeriod.Companion.month$default(companion, null, null, 3, null), TimePeriod.Companion.day$default(companion, null, null, 3, null), new EqualIntervals(TimePeriodKt.inDays$default(TimePeriod.Companion.month$default(companion, null, null, 3, null), null, 1, null)), new AndroidDateFormatter(DateTimeFormattersKt.dayInMonthFormat, null, 2, null), null, 16, null);
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onRandomizeDataClick() {
        List<BarEntry> list = this.stepsData;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        for (BarEntry barEntry : list) {
            Random.Default r3 = Random.Default;
            int nextInt = r3.nextInt(30000);
            arrayList.add(new BarEntry(r3.nextInt(0, nextInt), barEntry.getXAxisLabel(), 0L, (String) null, (String) null, false, 60, (DefaultConstructorMarker) null));
        }
        this.stepsData = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        invalidateCurrentScreen();
    }

    @Override // com.animaconnected.secondo.screens.activity.ActivityStepGoalDialogFragmentCallback
    public void onStepGoalPicked(int r1) {
        this.goalValue = r1;
        invalidateCurrentScreen();
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onTodayClick() {
        super.onTodayClick();
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugStepsChartFragment$onTodayClick$1(this, null), 3);
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onWeekClick() {
        super.onWeekClick();
        BarChartsKt.showStepsPeriodWeek(getChartHistory());
        TimePeriod.Companion companion = TimePeriod.Companion;
        observeHistorySteps$default(this, TimePeriod.Companion.week$default(companion, null, null, 3, null), TimePeriod.Companion.day$default(companion, null, null, 3, null), new EqualIntervals(TimePeriodKt.inDays$default(TimePeriod.Companion.week$default(companion, null, null, 3, null), null, 1, null)), new AndroidDateFormatter(DateTimeFormattersKt.shortDayNameInWeekFormat, null, 2, null), null, 16, null);
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onYearClick() {
        super.onYearClick();
        BarChartsKt.showStepsPeriodYear(getChartHistory());
        TimePeriod.Companion companion = TimePeriod.Companion;
        observeHistorySteps$default(this, TimePeriod.Companion.year$default(companion, null, null, 3, null), TimePeriod.Companion.month$default(companion, null, null, 3, null), Months.INSTANCE, new AndroidDateFormatter(DateTimeFormattersKt.monthInYearFormat, null, 2, null), null, 16, null);
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void setupCharts() {
        FragmentDebugChartBinding binding = getBinding();
        TextView tvChangeStepGoal = binding.tvChangeStepGoal;
        Intrinsics.checkNotNullExpressionValue(tvChangeStepGoal, "tvChangeStepGoal");
        ViewKt.visible(tvChangeStepGoal);
        binding.recyclerView.setAdapter(this.debugAdapter);
        TextView tvChangeStepGoal2 = binding.tvChangeStepGoal;
        Intrinsics.checkNotNullExpressionValue(tvChangeStepGoal2, "tvChangeStepGoal");
        onClick(tvChangeStepGoal2, new DebugStepsChartFragment$setupCharts$1$1(this, null));
        onStepGoalPicked(this.goalValue);
        this.debugAdapter.setItemClicked(new Function2<Integer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugStepsChartFragment$setupCharts$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int r12, int r13) {
                List list;
                List list2;
                list = DebugStepsChartFragment.this.stepsData;
                BarEntry barEntry = new BarEntry(r12, ((BarEntry) list.get(r13)).getXAxisLabel(), 0L, (String) null, (String) null, false, 60, (DefaultConstructorMarker) null);
                list2 = DebugStepsChartFragment.this.stepsData;
                list2.set(r13, barEntry);
                DebugStepsChartFragment.this.invalidateCurrentScreen();
            }
        });
        onTodayClick();
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public BarChart getChartHistory() {
        return (BarChart) this.chartHistory$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public BarChart getChartLast7Days() {
        return (BarChart) this.chartLast7Days$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public BarChart getChartToday() {
        return (BarChart) this.chartToday$delegate.getValue();
    }
}
