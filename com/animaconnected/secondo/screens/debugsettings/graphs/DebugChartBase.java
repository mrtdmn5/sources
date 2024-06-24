package com.animaconnected.secondo.screens.debugsettings.graphs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.databinding.FragmentDebugChartBinding;
import com.animaconnected.secondo.provider.KronabyFonts;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugChartBase.kt */
/* loaded from: classes3.dex */
public abstract class DebugChartBase extends BaseFragment {
    public static final int $stable = 8;
    public FragmentDebugChartBinding binding;
    private final Chart chartHistory;
    private final Chart chartLast7Days;
    private final Chart chartToday;
    private final Lazy chartViewHistory$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ChartView>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase$chartViewHistory$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ChartView invoke() {
            Context requireContext = DebugChartBase.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            return new ChartView(requireContext, null, 0, 6, null);
        }
    });
    private final Lazy chartViewToday$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ChartView>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase$chartViewToday$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ChartView invoke() {
            Context requireContext = DebugChartBase.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            return new ChartView(requireContext, null, 0, 6, null);
        }
    });
    private final Lazy chartViewLast7Days$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ChartView>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase$chartViewLast7Days$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ChartView invoke() {
            Context requireContext = DebugChartBase.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            return new ChartView(requireContext, null, 0, 6, null);
        }
    });
    private final Lazy chartColors$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DarkThemeChartColors>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase$chartColors$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DarkThemeChartColors invoke() {
            return ProviderFactory.INSTANCE.getThemeProvider().getChartColors();
        }
    });
    private final Lazy chartfonts$delegate = LazyKt__LazyJVMKt.lazy(new Function0<KronabyFonts>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase$chartfonts$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KronabyFonts invoke() {
            return ProviderFactory.INSTANCE.getThemeProvider().getChartFonts();
        }
    });
    private Screen currentScreen = Screen.Today;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DebugChartBase.kt */
    /* loaded from: classes3.dex */
    public static final class Screen {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Screen[] $VALUES;
        public static final Screen Today = new Screen("Today", 0);
        public static final Screen Last7Days = new Screen("Last7Days", 1);
        public static final Screen Week = new Screen("Week", 2);
        public static final Screen Month = new Screen("Month", 3);
        public static final Screen Year = new Screen("Year", 4);

        private static final /* synthetic */ Screen[] $values() {
            return new Screen[]{Today, Last7Days, Week, Month, Year};
        }

        static {
            Screen[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Screen(String str, int r2) {
        }

        public static EnumEntries<Screen> getEntries() {
            return $ENTRIES;
        }

        public static Screen valueOf(String str) {
            return (Screen) Enum.valueOf(Screen.class, str);
        }

        public static Screen[] values() {
            return (Screen[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCustomDataView() {
        FragmentDebugChartBinding binding = getBinding();
        LinearLayout containerEdit = binding.containerEdit;
        Intrinsics.checkNotNullExpressionValue(containerEdit, "containerEdit");
        ViewKt.gone(containerEdit);
        LinearLayout containerViewButtons = binding.containerViewButtons;
        Intrinsics.checkNotNullExpressionValue(containerViewButtons, "containerViewButtons");
        ViewKt.gone(containerViewButtons);
        RecyclerView recyclerView = binding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewKt.visible(recyclerView);
        TextView textView = getBinding().tvGoBack;
        Intrinsics.checkNotNull(textView);
        ViewKt.visible(textView);
        onClick(textView, new DebugChartBase$showCustomDataView$2$1(this, null));
    }

    private final void showOnlyHistory() {
        FragmentDebugChartBinding binding = getBinding();
        LinearLayout containerHistory = binding.containerHistory;
        Intrinsics.checkNotNullExpressionValue(containerHistory, "containerHistory");
        ViewKt.visible(containerHistory);
        LinearLayout containerToday = binding.containerToday;
        Intrinsics.checkNotNullExpressionValue(containerToday, "containerToday");
        ViewKt.gone(containerToday);
        LinearLayout containerLast7Days = binding.containerLast7Days;
        Intrinsics.checkNotNullExpressionValue(containerLast7Days, "containerLast7Days");
        ViewKt.gone(containerLast7Days);
    }

    public final FragmentDebugChartBinding getBinding() {
        FragmentDebugChartBinding fragmentDebugChartBinding = this.binding;
        if (fragmentDebugChartBinding != null) {
            return fragmentDebugChartBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public final DarkThemeChartColors getChartColors() {
        return (DarkThemeChartColors) this.chartColors$delegate.getValue();
    }

    public Chart getChartHistory() {
        return this.chartHistory;
    }

    public Chart getChartLast7Days() {
        return this.chartLast7Days;
    }

    public Chart getChartToday() {
        return this.chartToday;
    }

    public final ChartView getChartViewHistory() {
        return (ChartView) this.chartViewHistory$delegate.getValue();
    }

    public final ChartView getChartViewLast7Days() {
        return (ChartView) this.chartViewLast7Days$delegate.getValue();
    }

    public final ChartView getChartViewToday() {
        return (ChartView) this.chartViewToday$delegate.getValue();
    }

    public final KronabyFonts getChartfonts() {
        return (KronabyFonts) this.chartfonts$delegate.getValue();
    }

    public final Screen getCurrentScreen() {
        return this.currentScreen;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public void on7DaysClick() {
        FragmentDebugChartBinding binding = getBinding();
        LinearLayout containerLast7Days = binding.containerLast7Days;
        Intrinsics.checkNotNullExpressionValue(containerLast7Days, "containerLast7Days");
        ViewKt.visible(containerLast7Days);
        LinearLayout containerToday = binding.containerToday;
        Intrinsics.checkNotNullExpressionValue(containerToday, "containerToday");
        ViewKt.gone(containerToday);
        LinearLayout containerHistory = binding.containerHistory;
        Intrinsics.checkNotNullExpressionValue(containerHistory, "containerHistory");
        ViewKt.gone(containerHistory);
        this.currentScreen = Screen.Last7Days;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        ViewGroup viewGroup4;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentDebugChartBinding inflate = FragmentDebugChartBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        getChartViewToday().setChart(getChartToday());
        ViewParent parent = getChartViewToday().getParent();
        if (parent instanceof ViewGroup) {
            viewGroup2 = (ViewGroup) parent;
        } else {
            viewGroup2 = null;
        }
        if (viewGroup2 != null) {
            viewGroup2.removeView(getChartViewToday());
        }
        getBinding().containerToday.addView(getChartViewToday());
        getChartViewLast7Days().setChart(getChartLast7Days());
        ViewParent parent2 = getChartViewLast7Days().getParent();
        if (parent2 instanceof ViewGroup) {
            viewGroup3 = (ViewGroup) parent2;
        } else {
            viewGroup3 = null;
        }
        if (viewGroup3 != null) {
            viewGroup3.removeView(getChartViewLast7Days());
        }
        getBinding().containerLast7Days.addView(getChartViewLast7Days());
        getChartViewHistory().setChart(getChartHistory());
        ViewParent parent3 = getChartViewHistory().getParent();
        if (parent3 instanceof ViewGroup) {
            viewGroup4 = (ViewGroup) parent3;
        } else {
            viewGroup4 = null;
        }
        if (viewGroup4 != null) {
            viewGroup4.removeView(getChartViewHistory());
        }
        getBinding().containerHistory.addView(getChartViewHistory());
        setupCharts();
        FragmentDebugChartBinding binding = getBinding();
        Button btnToday = binding.btnToday;
        Intrinsics.checkNotNullExpressionValue(btnToday, "btnToday");
        onClick(btnToday, new DebugChartBase$onCreateView$1$1(this, null));
        Button btnLast7Days = binding.btnLast7Days;
        Intrinsics.checkNotNullExpressionValue(btnLast7Days, "btnLast7Days");
        onClick(btnLast7Days, new DebugChartBase$onCreateView$1$2(this, null));
        Button btnWeek = binding.btnWeek;
        Intrinsics.checkNotNullExpressionValue(btnWeek, "btnWeek");
        onClick(btnWeek, new DebugChartBase$onCreateView$1$3(this, null));
        Button btnMonth = binding.btnMonth;
        Intrinsics.checkNotNullExpressionValue(btnMonth, "btnMonth");
        onClick(btnMonth, new DebugChartBase$onCreateView$1$4(this, null));
        Button btnYear = binding.btnYear;
        Intrinsics.checkNotNullExpressionValue(btnYear, "btnYear");
        onClick(btnYear, new DebugChartBase$onCreateView$1$5(this, null));
        TextView tvSetCustomData = binding.tvSetCustomData;
        Intrinsics.checkNotNullExpressionValue(tvSetCustomData, "tvSetCustomData");
        onClick(tvSetCustomData, new DebugChartBase$onCreateView$1$6(this, null));
        TextView tvRandomizeData = binding.tvRandomizeData;
        Intrinsics.checkNotNullExpressionValue(tvRandomizeData, "tvRandomizeData");
        onClick(tvRandomizeData, new DebugChartBase$onCreateView$1$7(this, null));
        TextView tvEmptyData = binding.tvEmptyData;
        Intrinsics.checkNotNullExpressionValue(tvEmptyData, "tvEmptyData");
        onClick(tvEmptyData, new DebugChartBase$onCreateView$1$8(this, null));
        onTodayClick();
        return getBinding().getRoot();
    }

    public abstract void onEmptyDataClick();

    public void onMonthClick() {
        showOnlyHistory();
        this.currentScreen = Screen.Month;
    }

    public abstract void onRandomizeDataClick();

    public void onTodayClick() {
        FragmentDebugChartBinding binding = getBinding();
        LinearLayout containerToday = binding.containerToday;
        Intrinsics.checkNotNullExpressionValue(containerToday, "containerToday");
        ViewKt.visible(containerToday);
        LinearLayout containerLast7Days = binding.containerLast7Days;
        Intrinsics.checkNotNullExpressionValue(containerLast7Days, "containerLast7Days");
        ViewKt.gone(containerLast7Days);
        LinearLayout containerHistory = binding.containerHistory;
        Intrinsics.checkNotNullExpressionValue(containerHistory, "containerHistory");
        ViewKt.gone(containerHistory);
        this.currentScreen = Screen.Today;
    }

    public void onWeekClick() {
        showOnlyHistory();
        this.currentScreen = Screen.Week;
    }

    public void onYearClick() {
        showOnlyHistory();
        this.currentScreen = Screen.Year;
    }

    public final void setBinding(FragmentDebugChartBinding fragmentDebugChartBinding) {
        Intrinsics.checkNotNullParameter(fragmentDebugChartBinding, "<set-?>");
        this.binding = fragmentDebugChartBinding;
    }

    public final void setCurrentScreen(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<set-?>");
        this.currentScreen = screen;
    }

    public abstract void setupCharts();
}
