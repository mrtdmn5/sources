package com.animaconnected.secondo.screens.workout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentGenericWorkoutMetricDetailBinding;
import com.animaconnected.secondo.provider.KronabyFonts;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.debugsettings.DfuLogsFragment$$ExternalSyntheticLambda1;
import com.animaconnected.secondo.screens.details.Dismissible;
import com.animaconnected.secondo.screens.details.OnDismissedListener;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.animaconnected.watch.AndroidDateFormatter;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutMetricDetailBaseFragment.kt */
/* loaded from: classes3.dex */
public abstract class WorkoutMetricDetailBaseFragment extends BaseFragment implements Dismissible {
    public static final int $stable = 8;
    public FragmentGenericWorkoutMetricDetailBinding binding;
    private boolean shouldReveal;
    private final String secondAboutTitle = "";
    private final String secondAboutDescription = "";
    private final Lazy chartColors$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DarkThemeChartColors>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment$chartColors$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DarkThemeChartColors invoke() {
            return ProviderFactory.INSTANCE.getThemeProvider().getChartColors();
        }
    });
    private final Lazy chartFonts$delegate = LazyKt__LazyJVMKt.lazy(new Function0<KronabyFonts>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment$chartFonts$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KronabyFonts invoke() {
            return ProviderFactory.INSTANCE.getThemeProvider().getChartFonts();
        }
    });
    private final Lazy featurePathName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment$featurePathName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String string = WorkoutMetricDetailBaseFragment.this.getString(R.string.health_top_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
    });
    private final Lazy inflater$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LayoutInflater>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment$inflater$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutInflater invoke() {
            return LayoutInflater.from(WorkoutMetricDetailBaseFragment.this.requireContext());
        }
    });
    private Rect cardBounds = new Rect(0, 0, 0, 0);
    private final AndroidDateFormatter dateFormatter = new AndroidDateFormatter("EEE HH:mm", null, 2, null);
    private final AndroidDateFormatter timeFormatter = new AndroidDateFormatter("HH:mm", null, 2, null);

    public static /* synthetic */ void setupToolbarHelpButton$default(WorkoutMetricDetailBaseFragment workoutMetricDetailBaseFragment, int r1, Function0 function0, int r3, Object obj) {
        if (obj == null) {
            if ((r3 & 1) != 0) {
                r1 = R.drawable.ic_faq;
            }
            workoutMetricDetailBaseFragment.setupToolbarHelpButton(r1, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setupToolbarHelpButton");
    }

    public static final void setupToolbarHelpButton$lambda$4(Function0 onClick, View view) {
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        onClick.invoke();
    }

    @Override // com.animaconnected.secondo.screens.details.Dismissible
    public void dismiss(OnDismissedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FrameLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        View viewAnimContainer = getBinding().viewAnimContainer;
        Intrinsics.checkNotNullExpressionValue(viewAnimContainer, "viewAnimContainer");
        AnimationFactoryKotlinKt.exitCardRevealAnim(this, root, viewAnimContainer, this.cardBounds, listener);
    }

    public abstract String getAboutDescription();

    public final FragmentGenericWorkoutMetricDetailBinding getBinding() {
        FragmentGenericWorkoutMetricDetailBinding fragmentGenericWorkoutMetricDetailBinding = this.binding;
        if (fragmentGenericWorkoutMetricDetailBinding != null) {
            return fragmentGenericWorkoutMetricDetailBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public final DarkThemeChartColors getChartColors() {
        return (DarkThemeChartColors) this.chartColors$delegate.getValue();
    }

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

    public abstract Function0<Unit> getFullHistoryClick();

    public final LayoutInflater getInflater() {
        Object value = this.inflater$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (LayoutInflater) value;
    }

    public abstract String getMetricName();

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public abstract String getName();

    public String getSecondAboutDescription() {
        return this.secondAboutDescription;
    }

    public String getSecondAboutTitle() {
        return this.secondAboutTitle;
    }

    public abstract String getTitleChartHistory();

    public abstract String getTitleChartToday();

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public Drawable getToolbarBackDrawable() {
        Context context = getContext();
        if (context != null) {
            Object obj = ContextCompat.sLock;
            return ContextCompat.Api21Impl.getDrawable(context, R.drawable.ic_close);
        }
        return null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cardBounds.left = arguments.getInt(AnimationFactoryKotlinKt.LEFT, 0);
            this.cardBounds.top = arguments.getInt(AnimationFactoryKotlinKt.TOP, 0);
            this.cardBounds.right = arguments.getInt(AnimationFactoryKotlinKt.RIGHT, 0);
            this.cardBounds.bottom = arguments.getInt(AnimationFactoryKotlinKt.BOTTOM, 0);
            if (bundle != null) {
                z = bundle.getBoolean(AnimationFactoryKotlinKt.SHOULD_REVEAL, false);
            } else {
                z = arguments.getBoolean(AnimationFactoryKotlinKt.SHOULD_REVEAL, false);
            }
            this.shouldReveal = z;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final FragmentGenericWorkoutMetricDetailBinding inflate = FragmentGenericWorkoutMetricDetailBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.tvMetricName.setText(getMetricName());
        inflate.tvChartTodayTitle.setText(getTitleChartToday());
        inflate.tvChartHistoryTitle.setText(getTitleChartHistory());
        TextView tvFullHistory = inflate.tvFullHistory;
        Intrinsics.checkNotNullExpressionValue(tvFullHistory, "tvFullHistory");
        onClick(tvFullHistory, new WorkoutMetricDetailBaseFragment$onCreateView$1$1(this, null));
        inflate.tvAboutTitle.setText(getString(R.string.health_detail_about_title));
        inflate.tvAboutDesc.setText(getAboutDescription());
        boolean z2 = true;
        if (getSecondAboutTitle().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            TextView tvSecondAboutTitle = inflate.tvSecondAboutTitle;
            Intrinsics.checkNotNullExpressionValue(tvSecondAboutTitle, "tvSecondAboutTitle");
            ViewKt.visible(tvSecondAboutTitle);
            inflate.tvSecondAboutTitle.setText(getSecondAboutTitle());
        }
        if (getSecondAboutDescription().length() != 0) {
            z2 = false;
        }
        if (!z2) {
            TextView tvSecondAboutDesc = inflate.tvSecondAboutDesc;
            Intrinsics.checkNotNullExpressionValue(tvSecondAboutDesc, "tvSecondAboutDesc");
            ViewKt.visible(tvSecondAboutDesc);
            inflate.tvSecondAboutDesc.setText(getSecondAboutDescription());
        }
        BaseFragmentUtilsKt.collectSafely$default(this, ProviderFactory.getWatch().fitness().getLastSynced(), null, null, Hashing.getLifecycleScope(this), new Function1<Long, Unit>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutMetricDetailBaseFragment$onCreateView$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke2(l);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l) {
                AndroidDateFormatter androidDateFormatter;
                AndroidDateFormatter androidDateFormatter2;
                if (l != null) {
                    CardView cardLastSynced = FragmentGenericWorkoutMetricDetailBinding.this.cardLastSynced;
                    Intrinsics.checkNotNullExpressionValue(cardLastSynced, "cardLastSynced");
                    ViewKt.visible(cardLastSynced);
                    TextView textView = FragmentGenericWorkoutMetricDetailBinding.this.tvLastSynced;
                    StringBuilder sb = new StringBuilder();
                    sb.append(StringsExtensionsKt.getAppString(Key.last_synced));
                    sb.append(' ');
                    long longValue = l.longValue();
                    androidDateFormatter = this.dateFormatter;
                    androidDateFormatter2 = this.timeFormatter;
                    sb.append(WorkoutFormatUtilsKt.toReadablePast(longValue, androidDateFormatter, androidDateFormatter2));
                    textView.setText(sb.toString());
                    return;
                }
                CardView cardLastSynced2 = FragmentGenericWorkoutMetricDetailBinding.this.cardLastSynced;
                Intrinsics.checkNotNullExpressionValue(cardLastSynced2, "cardLastSynced");
                ViewKt.gone(cardLastSynced2);
            }
        }, 6, null);
        setBinding(inflate);
        setupDetailView();
        if (this.shouldReveal) {
            FrameLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            View viewAnimContainer = getBinding().viewAnimContainer;
            Intrinsics.checkNotNullExpressionValue(viewAnimContainer, "viewAnimContainer");
            AnimationFactoryKotlinKt.enterCardRevealAnim(this, root, viewAnimContainer, this.cardBounds);
        }
        this.shouldReveal = false;
        FrameLayout root2 = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        return root2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(AnimationFactoryKotlinKt.SHOULD_REVEAL, this.shouldReveal);
    }

    public final void setBinding(FragmentGenericWorkoutMetricDetailBinding fragmentGenericWorkoutMetricDetailBinding) {
        Intrinsics.checkNotNullParameter(fragmentGenericWorkoutMetricDetailBinding, "<set-?>");
        this.binding = fragmentGenericWorkoutMetricDetailBinding;
    }

    public abstract void setupDetailView();

    public final void setupToolbarHelpButton(int r3, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Resources resources = requireActivity().getResources();
        ThreadLocal<TypedValue> threadLocal = ResourcesCompat.sTempTypedValue;
        Drawable drawable = null;
        Drawable drawable2 = ResourcesCompat.Api21Impl.getDrawable(resources, r3, null);
        if (drawable2 != null) {
            DrawableCompat$Api21Impl.setTint(drawable2, R.attr.detailIconTint);
            drawable = drawable2;
        }
        ((AnimatedToolbar) getBinding().customToolbar.findViewById(R.id.animated_toolbar)).setHelpActionDrawable(drawable);
        View findViewById = getBinding().customToolbar.findViewById(R.id.touch_area_help_button);
        if (findViewById != null) {
            findViewById.setOnClickListener(new DfuLogsFragment$$ExternalSyntheticLambda1(1, onClick));
        }
    }
}
