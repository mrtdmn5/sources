package com.animaconnected.secondo.screens.workout.detail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentWorkoutMetricDetailBinding;
import com.animaconnected.secondo.provider.KronabyFonts;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.watch.display.AndroidKanvas;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.LineChartsKt;
import com.animaconnected.watch.graphs.PointEntry;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.watch.workout.WorkoutDataClassesKt;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: WorkoutMetricDetailFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutMetricDetailFragment extends BaseFragment {
    private FragmentWorkoutMetricDetailBinding binding;
    private final DarkThemeChartColors colors;
    private final Lazy featurePathName$delegate;
    private final KronabyFonts fonts;
    private final String name;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WorkoutMetricDetailFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ WorkoutMetricDetailFragment newInstance$default(Companion companion, String str, int r2, String str2, int r4, int r5, Object obj) {
            if ((r5 & 8) != 0) {
                r4 = 0;
            }
            return companion.newInstance(str, r2, str2, r4);
        }

        public final WorkoutMetricDetailFragment newInstance(String json, int r5, String durationLabel, int r7) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(durationLabel, "durationLabel");
            WorkoutMetricDetailFragment workoutMetricDetailFragment = new WorkoutMetricDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", json);
            bundle.putInt("screen", r5);
            bundle.putString("total-time", durationLabel);
            bundle.putInt("average", r7);
            workoutMetricDetailFragment.setArguments(bundle);
            return workoutMetricDetailFragment;
        }

        private Companion() {
        }
    }

    public WorkoutMetricDetailFragment() {
        String simpleName = Reflection.getOrCreateKotlinClass(WorkoutMetricDetailFragment.class).getSimpleName();
        this.name = simpleName == null ? "WorkoutMetricDetailFragment" : simpleName;
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        this.colors = providerFactory.getThemeProvider().getChartColors();
        this.fonts = providerFactory.getThemeProvider().getChartFonts();
        this.featurePathName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutMetricDetailFragment$featurePathName$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return WorkoutMetricDetailFragment.this.getString(R.string.health_top_title);
            }
        });
    }

    private final Chart getChart(int r10, List<PointEntry> list, int r12) {
        String str;
        String string;
        String str2;
        String string2;
        if (r10 != R.string.health_measurement_heart_rate_title) {
            if (r10 != R.string.health_workouts_detail_elevation_title) {
                return null;
            }
            FragmentWorkoutMetricDetailBinding fragmentWorkoutMetricDetailBinding = this.binding;
            if (fragmentWorkoutMetricDetailBinding != null) {
                AndroidKanvas kanvas = fragmentWorkoutMetricDetailBinding.chartView.getKanvas();
                DarkThemeChartColors darkThemeChartColors = this.colors;
                KronabyFonts kronabyFonts = this.fonts;
                FitnessProvider.Profile.Measurement measurement = ProviderFactory.getWatch().fitness().getProfile().getMeasurement();
                Bundle arguments = getArguments();
                if (arguments == null || (string2 = arguments.getString("total-time")) == null) {
                    str2 = "";
                } else {
                    str2 = string2;
                }
                return LineChartsKt.createElevationDetailChart(kanvas, darkThemeChartColors, kronabyFonts, list, measurement, str2);
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        FragmentWorkoutMetricDetailBinding fragmentWorkoutMetricDetailBinding2 = this.binding;
        if (fragmentWorkoutMetricDetailBinding2 != null) {
            AndroidKanvas kanvas2 = fragmentWorkoutMetricDetailBinding2.chartView.getKanvas();
            DarkThemeChartColors darkThemeChartColors2 = this.colors;
            KronabyFonts kronabyFonts2 = this.fonts;
            Bundle arguments2 = getArguments();
            if (arguments2 == null || (string = arguments2.getString("total-time")) == null) {
                str = "";
            } else {
                str = string;
            }
            return LineChartsKt.createHeartRateDetailChart(kanvas2, darkThemeChartColors2, kronabyFonts2, list, str, r12);
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    private final String getScreenTitle(int r1) {
        try {
            String string = getString(r1);
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return (String) this.featurePathName$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public Drawable getToolbarBackDrawable() {
        Context context = getContext();
        if (context != null) {
            Object obj = ContextCompat.sLock;
            return ContextCompat.Api21Impl.getDrawable(context, R.drawable.ic_chevron_left);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        int r4;
        List<PointEntry> list;
        String string;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int r6 = 0;
        FragmentWorkoutMetricDetailBinding inflate = FragmentWorkoutMetricDetailBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        Bundle arguments = getArguments();
        if (arguments != null) {
            r4 = arguments.getInt("screen");
        } else {
            r4 = -1;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString("data")) == null || (list = WorkoutDataClassesKt.deserializeToPointEntry(string)) == null) {
            list = EmptyList.INSTANCE;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            r6 = arguments3.getInt("average");
        }
        Chart chart = getChart(r4, list, r6);
        FragmentWorkoutMetricDetailBinding fragmentWorkoutMetricDetailBinding = this.binding;
        if (fragmentWorkoutMetricDetailBinding != null) {
            fragmentWorkoutMetricDetailBinding.tvTitle.setText(getScreenTitle(r4));
            fragmentWorkoutMetricDetailBinding.chartView.setChart(chart);
            fragmentWorkoutMetricDetailBinding.chartView.invalidate();
            FragmentWorkoutMetricDetailBinding fragmentWorkoutMetricDetailBinding2 = this.binding;
            if (fragmentWorkoutMetricDetailBinding2 != null) {
                FrameLayout root = fragmentWorkoutMetricDetailBinding2.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                return root;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }
}
