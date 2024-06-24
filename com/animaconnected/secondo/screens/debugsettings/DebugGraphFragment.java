package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.KronabyFonts;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.animaconnected.watch.display.AndroidKanvas;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.MockFitnessProvider;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.HorizontalBarChartsKt;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.watch.workout.WorkoutDataClassesKt;
import com.kronaby.watch.app.R;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugGraphFragment.kt */
/* loaded from: classes3.dex */
public final class DebugGraphFragment extends BaseFragment {
    private final MockFitnessProvider fitnessProvider = new MockFitnessProvider(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    private final String name = "DebugGraphFragment";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DebugGraphFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugGraphFragment newInstance() {
            return new DebugGraphFragment();
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        int r1;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_debug_graph, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.tv_debug_chart_steps);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        onClick(findViewById, new DebugGraphFragment$onCreateView$1(this, null));
        View findViewById2 = inflate.findViewById(R.id.tv_debug_chart_calories);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        onClick(findViewById2, new DebugGraphFragment$onCreateView$2(this, null));
        View findViewById3 = inflate.findViewById(R.id.tv_debug_chart_resting_heartrate_detail);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        onClick(findViewById3, new DebugGraphFragment$onCreateView$3(this, null));
        View findViewById4 = inflate.findViewById(R.id.tv_debug_chart_resting_heartrate_history);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        onClick(findViewById4, new DebugGraphFragment$onCreateView$4(this, null));
        View findViewById5 = inflate.findViewById(R.id.tv_debug_chart_heartrate_detail);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        onClick(findViewById5, new DebugGraphFragment$onCreateView$5(this, null));
        View findViewById6 = inflate.findViewById(R.id.tv_debug_chart_heartrate_history);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        onClick(findViewById6, new DebugGraphFragment$onCreateView$6(this, null));
        View findViewById7 = inflate.findViewById(R.id.tv_debug_chart_elevation_detail);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        onClick(findViewById7, new DebugGraphFragment$onCreateView$7(this, null));
        ChartView chartView = (ChartView) inflate.findViewById(R.id.debug_graph_workout_splits);
        Context context = KronabyApplication.Companion.getContext();
        if (this.fitnessProvider.getProfile().getMeasurement() == FitnessProvider.Profile.Measurement.Metric) {
            r1 = R.string.units_distance_km;
        } else {
            r1 = R.string.units_distance_miles;
        }
        String string = context.getString(r1);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = string.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        AndroidKanvas kanvas = chartView.getKanvas();
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        DarkThemeChartColors chartColors = providerFactory.getThemeProvider().getChartColors();
        KronabyFonts chartFonts = providerFactory.getThemeProvider().getChartFonts();
        List<BarEntry> splitBarEntries = WorkoutDataClassesKt.toSplitBarEntries(this.fitnessProvider.calculateSplits(), this.fitnessProvider.getProfile().getMeasurement(), false);
        String upperCase2 = StringsExtensionsKt.getAppString(Key.pace).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        HorizontalBarChartsKt.createSplitsChart(kanvas, chartColors, chartFonts, splitBarEntries, upperCase, upperCase2);
        return inflate;
    }
}
