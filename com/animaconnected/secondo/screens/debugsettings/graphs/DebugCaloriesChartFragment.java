package com.animaconnected.secondo.screens.debugsettings.graphs;

import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase;
import com.animaconnected.watch.AndroidDateFormatter;
import com.animaconnected.watch.device.DateFormatter;
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
import com.animaconnected.watch.workout.CaloriesViewModel;
import com.animaconnected.watch.workout.HistoryPeriodTab;
import com.google.common.collect.Hashing;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt;

/* compiled from: DebugCaloriesChartFragment.kt */
/* loaded from: classes3.dex */
public final class DebugCaloriesChartFragment extends DebugChartBase {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "DebugCaloriesChartFragment";
    private final CaloriesViewModel viewModel = new CaloriesViewModel(new MockFitnessProvider(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    private final DebugBarEntryAdapter debugAdapter = new DebugBarEntryAdapter();
    private List<BarEntry> caloriesData = new ArrayList();
    private final Lazy chartToday$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BarChart>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugCaloriesChartFragment$chartToday$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BarChart invoke() {
            return BarChartsKt.createCaloriesTodayChart(DebugCaloriesChartFragment.this.getChartViewToday().getKanvas(), DebugCaloriesChartFragment.this.getChartColors(), DebugCaloriesChartFragment.this.getChartfonts(), EmptyList.INSTANCE);
        }
    });
    private final Lazy chartLast7Days$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BarChart>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugCaloriesChartFragment$chartLast7Days$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BarChart invoke() {
            return BarChartsKt.createCaloriesLastSevenDaysChart(DebugCaloriesChartFragment.this.getChartViewLast7Days().getKanvas(), DebugCaloriesChartFragment.this.getChartColors(), DebugCaloriesChartFragment.this.getChartfonts(), EmptyList.INSTANCE);
        }
    });
    private final Lazy chartHistory$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BarChart>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugCaloriesChartFragment$chartHistory$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BarChart invoke() {
            return BarChartsKt.createCaloriesHistoryChart(DebugCaloriesChartFragment.this.getChartViewHistory().getKanvas(), DebugCaloriesChartFragment.this.getChartColors(), DebugCaloriesChartFragment.this.getChartfonts(), EmptyList.INSTANCE);
        }
    });

    /* compiled from: DebugCaloriesChartFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugCaloriesChartFragment newInstance() {
            return new DebugCaloriesChartFragment();
        }

        private Companion() {
        }
    }

    /* compiled from: DebugCaloriesChartFragment.kt */
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateCurrentScreen() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[getCurrentScreen().ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                getChartHistory().setData(this.caloriesData);
            } else {
                getChartLast7Days().setData(this.caloriesData);
            }
        } else {
            getChartToday().setData(this.caloriesData);
        }
        this.debugAdapter.setData(this.caloriesData);
    }

    private final void observeHistoryCalories(TimePeriod timePeriod, TimePeriod timePeriod2, EntriesAmount entriesAmount, DateFormatter dateFormatter, Function1<? super Long, String> function1) {
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugCaloriesChartFragment$observeHistoryCalories$1(this, timePeriod, timePeriod2, entriesAmount, dateFormatter, function1, null), 3);
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
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugCaloriesChartFragment$on7DaysClick$1(this, null), 3);
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onEmptyDataClick() {
        List<BarEntry> list = this.caloriesData;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new BarEntry(0, ((BarEntry) it.next()).getXAxisLabel(), 0L, (String) null, (String) null, false, 60, (DefaultConstructorMarker) null));
        }
        this.caloriesData = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        invalidateCurrentScreen();
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onMonthClick() {
        super.onMonthClick();
        BarChartsKt.showCaloriesPeriodMonth(getChartHistory());
        TimePeriod.Companion companion = TimePeriod.Companion;
        observeHistoryCalories(TimePeriod.Companion.month$default(companion, null, null, 3, null), TimePeriod.Companion.month$default(companion, null, null, 3, null), new EqualIntervals(TimePeriodKt.inDays$default(TimePeriod.Companion.month$default(companion, null, null, 3, null), null, 1, null)), new AndroidDateFormatter(DateTimeFormattersKt.dayInMonthFormat, null, 2, null), this.viewModel.markerHistoryFormatter(HistoryPeriodTab.Month));
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onRandomizeDataClick() {
        List<BarEntry> list = this.caloriesData;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        for (BarEntry barEntry : list) {
            Random.Default r3 = Random.Default;
            int nextInt = r3.nextInt(30000);
            arrayList.add(new BarEntry(r3.nextInt(0, nextInt), barEntry.getXAxisLabel(), 0L, (String) null, (String) null, false, 60, (DefaultConstructorMarker) null));
        }
        this.caloriesData = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        invalidateCurrentScreen();
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onTodayClick() {
        super.onTodayClick();
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugCaloriesChartFragment$onTodayClick$1(this, null), 3);
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onWeekClick() {
        super.onWeekClick();
        BarChartsKt.showCaloriesPeriodWeek(getChartHistory());
        TimePeriod.Companion companion = TimePeriod.Companion;
        observeHistoryCalories(TimePeriod.Companion.week$default(companion, null, null, 3, null), TimePeriod.Companion.day$default(companion, null, null, 3, null), new EqualIntervals(7), new AndroidDateFormatter(DateTimeFormattersKt.shortDayNameInWeekFormat, null, 2, null), this.viewModel.markerHistoryFormatter(HistoryPeriodTab.Week));
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void onYearClick() {
        super.onYearClick();
        BarChartsKt.showCaloriesPeriodYear(getChartHistory());
        TimePeriod.Companion companion = TimePeriod.Companion;
        observeHistoryCalories(TimePeriod.Companion.year$default(companion, null, null, 3, null), TimePeriod.Companion.month$default(companion, null, null, 3, null), Months.INSTANCE, new AndroidDateFormatter(DateTimeFormattersKt.monthInYearFormat, null, 2, null), this.viewModel.markerHistoryFormatter(HistoryPeriodTab.Year));
    }

    @Override // com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase
    public void setupCharts() {
        getBinding().recyclerView.setAdapter(this.debugAdapter);
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
