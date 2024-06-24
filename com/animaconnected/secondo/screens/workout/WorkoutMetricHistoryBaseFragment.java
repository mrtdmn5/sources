package com.animaconnected.secondo.screens.workout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentGenericWorkoutMetricHistoryBinding;
import com.animaconnected.secondo.provider.KronabyFonts;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.graphs.ChartEntry;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.watch.workout.HistoryState;
import com.animaconnected.watch.workout.WorkoutDatePickerViewModel;
import com.animaconnected.watch.workout.WorkoutPeriod;
import com.google.android.material.tabs.TabLayout;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.datetime.Instant;

/* compiled from: WorkoutMetricHistoryBaseFragment.kt */
/* loaded from: classes3.dex */
public abstract class WorkoutMetricHistoryBaseFragment extends BaseFragment {
    public static final int $stable = 8;
    public FragmentGenericWorkoutMetricHistoryBinding binding;
    private final WorkoutDatePickerViewModel viewModel = new WorkoutDatePickerViewModel(new Function1<Instant, Boolean>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$viewModel$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Instant instant) {
            Intrinsics.checkNotNullParameter(instant, "instant");
            return Boolean.valueOf(WorkoutMetricHistoryBaseFragment.this.hasDataBefore(instant));
        }
    });
    private WorkoutPeriod activeTab = WorkoutPeriod.WEEK;
    private final Lazy featurePathName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$featurePathName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String string = WorkoutMetricHistoryBaseFragment.this.getString(R.string.health_top_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
    });
    private final Lazy chartColors$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DarkThemeChartColors>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$chartColors$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DarkThemeChartColors invoke() {
            return ProviderFactory.INSTANCE.getThemeProvider().getChartColors();
        }
    });
    private final Lazy chartFonts$delegate = LazyKt__LazyJVMKt.lazy(new Function0<KronabyFonts>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$chartFonts$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KronabyFonts invoke() {
            return ProviderFactory.INSTANCE.getThemeProvider().getChartFonts();
        }
    });
    private final WorkoutMetricHistoryBaseFragment$tabListener$1 tabListener = new TabLayout.OnTabSelectedListener() { // from class: com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$tabListener$1
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            int selectedTabPosition = WorkoutMetricHistoryBaseFragment.this.getBinding().tabLayout.getSelectedTabPosition();
            WorkoutPeriod workoutPeriod = WorkoutPeriod.WEEK;
            if (selectedTabPosition == workoutPeriod.ordinal()) {
                WorkoutMetricHistoryBaseFragment.this.setActiveTab(workoutPeriod);
                WorkoutMetricHistoryBaseFragment.this.onWeekClick();
                return;
            }
            WorkoutPeriod workoutPeriod2 = WorkoutPeriod.MONTH;
            if (selectedTabPosition == workoutPeriod2.ordinal()) {
                WorkoutMetricHistoryBaseFragment.this.setActiveTab(workoutPeriod2);
                WorkoutMetricHistoryBaseFragment.this.onMonthClick();
                return;
            }
            WorkoutPeriod workoutPeriod3 = WorkoutPeriod.YEAR;
            if (selectedTabPosition == workoutPeriod3.ordinal()) {
                WorkoutMetricHistoryBaseFragment.this.setActiveTab(workoutPeriod3);
                WorkoutMetricHistoryBaseFragment.this.onYearClick();
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final Chart getChart() {
        return getBinding().chartView.getChart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidatePicker(View view, boolean z) {
        if (z) {
            view.setAlpha(1.0f);
            view.setEnabled(true);
        } else {
            view.setAlpha(0.3f);
            view.setEnabled(false);
        }
    }

    private final Job observeHistoryState() {
        return BaseFragmentUtilsKt.launchOnStarted(this, new WorkoutMetricHistoryBaseFragment$observeHistoryState$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateDataOnTabChange(com.animaconnected.watch.workout.HistoryState r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$1 r0 = (com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$1 r0 = new com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L65
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.lang.Object r6 = r0.L$0
            com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment r6 = (com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.graphs.Chart r7 = r5.getChart()
            if (r7 == 0) goto L46
            r7.hideMarkerNextRedraw()
        L46:
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r5.getChartDataFlow(r6, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r6 = r5
        L52:
            kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
            com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$2 r2 = new com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment$updateDataOnTabChange$2
            r4 = 0
            r2.<init>(r6, r4)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.collectLatest(r7, r2, r0)
            if (r6 != r1) goto L65
            return r1
        L65:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.WorkoutMetricHistoryBaseFragment.updateDataOnTabChange(com.animaconnected.watch.workout.HistoryState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final WorkoutPeriod getActiveTab() {
        return this.activeTab;
    }

    public final FragmentGenericWorkoutMetricHistoryBinding getBinding() {
        FragmentGenericWorkoutMetricHistoryBinding fragmentGenericWorkoutMetricHistoryBinding = this.binding;
        if (fragmentGenericWorkoutMetricHistoryBinding != null) {
            return fragmentGenericWorkoutMetricHistoryBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public final DarkThemeChartColors getChartColors() {
        return (DarkThemeChartColors) this.chartColors$delegate.getValue();
    }

    public abstract Object getChartDataFlow(HistoryState historyState, Continuation<? super CommonFlow<? extends ChartData<? extends ChartEntry>>> continuation);

    public final KronabyFonts getChartFonts() {
        return (KronabyFonts) this.chartFonts$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return (String) this.featurePathName$delegate.getValue();
    }

    public abstract String getMetricName();

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public abstract String getName();

    public abstract String getTitleTabs();

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public Drawable getToolbarBackDrawable() {
        Context context = getContext();
        if (context != null) {
            Object obj = ContextCompat.sLock;
            return ContextCompat.Api21Impl.getDrawable(context, R.drawable.ic_chevron_left);
        }
        return null;
    }

    public abstract boolean hasDataBefore(Instant instant);

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentGenericWorkoutMetricHistoryBinding inflate = FragmentGenericWorkoutMetricHistoryBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.tvMetricName.setText(getMetricName());
        ImageView btnPreviousDate = inflate.btnPreviousDate;
        Intrinsics.checkNotNullExpressionValue(btnPreviousDate, "btnPreviousDate");
        onClick(btnPreviousDate, new WorkoutMetricHistoryBaseFragment$onCreateView$1$1(this, null));
        ImageView btnNextDate = inflate.btnNextDate;
        Intrinsics.checkNotNullExpressionValue(btnNextDate, "btnNextDate");
        onClick(btnNextDate, new WorkoutMetricHistoryBaseFragment$onCreateView$1$2(this, null));
        inflate.tabLayout.addOnTabSelectedListener(this.tabListener);
        setBinding(inflate);
        setupHistoryView();
        return getBinding().getRoot();
    }

    public void onMonthClick() {
        this.viewModel.onMonthClick();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        observeHistoryState();
    }

    public void onWeekClick() {
        this.viewModel.onWeekClick();
    }

    public void onYearClick() {
        this.viewModel.onYearClick();
    }

    public final void setActiveTab(WorkoutPeriod workoutPeriod) {
        Intrinsics.checkNotNullParameter(workoutPeriod, "<set-?>");
        this.activeTab = workoutPeriod;
    }

    public final void setBinding(FragmentGenericWorkoutMetricHistoryBinding fragmentGenericWorkoutMetricHistoryBinding) {
        Intrinsics.checkNotNullParameter(fragmentGenericWorkoutMetricHistoryBinding, "<set-?>");
        this.binding = fragmentGenericWorkoutMetricHistoryBinding;
    }

    public abstract void setupHistoryView();
}
