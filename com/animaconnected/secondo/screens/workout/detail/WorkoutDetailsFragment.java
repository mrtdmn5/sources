package com.animaconnected.secondo.screens.workout.detail;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.databinding.DialogGenericBinding;
import com.animaconnected.secondo.databinding.FragmentWorkoutDetailsBinding;
import com.animaconnected.secondo.databinding.LayoutWorkoutDetailsLinechartBinding;
import com.animaconnected.secondo.databinding.LayoutWorkoutDetailsSplitsBinding;
import com.animaconnected.secondo.provider.KronabyFonts;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.debugsettings.LottiePreviewFragment$$ExternalSyntheticLambda0;
import com.animaconnected.secondo.screens.details.Dismissible;
import com.animaconnected.secondo.screens.details.OnDismissedListener;
import com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsViewModel;
import com.animaconnected.secondo.screens.workout.detail.WorkoutMetricDetailFragment;
import com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt;
import com.animaconnected.secondo.screens.workout.utils.LocationMapUtilsKt;
import com.animaconnected.secondo.utils.Loading;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.animaconnected.secondo.utils.animations.AnimatorsKt;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.animaconnected.watch.display.AndroidKanvas;
import com.animaconnected.watch.display.DpUtils;
import com.animaconnected.watch.display.DpUtilsKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.graphs.HorizontalBarChart;
import com.animaconnected.watch.graphs.HorizontalBarChartsKt;
import com.animaconnected.watch.graphs.LineChartsKt;
import com.animaconnected.watch.graphs.PointEntry;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.watch.workout.SessionListItem;
import com.animaconnected.watch.workout.WorkoutDataClassesKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zaf;
import com.google.android.gms.dynamic.zag;
import com.google.android.gms.internal.fitness.zzav;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.zzaf;
import com.google.android.gms.maps.zzag;
import com.google.android.gms.maps.zzah;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.common.base.Strings;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;

/* compiled from: WorkoutDetailsFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutDetailsFragment extends BaseFragment implements Dismissible {
    private AnimatorSet animatorSet;
    private FragmentWorkoutDetailsBinding binding;
    private Rect cardBounds;
    private int collapsedMapHeight;
    private final DarkThemeChartColors colors;
    private Session detailedSession;
    private int expandedMapHeight;
    private final Lazy featurePathName$delegate;
    private final KronabyFonts fonts;
    private boolean inWorkoutHistory;
    private LatLng initialCameraTarget;
    private GoogleMap map;
    private final String name;
    private SessionListItem session;
    private long sessionID;
    private boolean shouldReveal;
    private WorkoutDetailsViewModel viewModel;
    private float zoomLevelCollapsed;
    private float zoomLevelExpanded;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WorkoutDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutDetailsFragment newInstance(long j, boolean z) {
            WorkoutDetailsFragment workoutDetailsFragment = new WorkoutDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("sessionID", j);
            bundle.putBoolean("historyID", z);
            workoutDetailsFragment.setArguments(bundle);
            return workoutDetailsFragment;
        }

        private Companion() {
        }
    }

    /* compiled from: WorkoutDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] r0 = new int[WorkoutDetailsViewModel.AnimationState.values().length];
            try {
                r0[WorkoutDetailsViewModel.AnimationState.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WorkoutDetailsViewModel.AnimationState.EXPANDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WorkoutDetailsViewModel.AnimationState.COLLAPSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[WorkoutDetailsViewModel.AnimationState.PLAY_COLLAPSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[WorkoutDetailsViewModel.AnimationState.PLAY_EXPAND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[FitnessProvider.Profile.Measurement.values().length];
            try {
                r02[FitnessProvider.Profile.Measurement.Metric.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r02[FitnessProvider.Profile.Measurement.Imperial.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = r02;
            int[] r03 = new int[SessionType.values().length];
            try {
                r03[SessionType.Bike.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$2 = r03;
        }
    }

    public WorkoutDetailsFragment() {
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        this.colors = providerFactory.getThemeProvider().getChartColors();
        this.fonts = providerFactory.getThemeProvider().getChartFonts();
        this.cardBounds = new Rect(0, 0, 0, 0);
        this.featurePathName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$featurePathName$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String string = WorkoutDetailsFragment.this.getString(R.string.health_top_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
        });
        this.name = "WorkoutDetailsFragment";
    }

    public final void ActivityTypeSummary(final ActivityState activityState, Modifier modifier, Composer composer, final int r56, final int r57) {
        Modifier modifier2;
        long Color;
        long Color2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-843034458);
        int r1 = r57 & 2;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
        int r12 = ((((((r56 >> 3) & 14) << 3) & 112) << 9) & 7168) | 6;
        Applier<?> applier = startRestartGroup.applier;
        if (applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
            ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$1);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r12 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), 0.0f, 0.0f, 0.0f, 4, 7);
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                modifierMaterializerOf2.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                TextKt.m216Text4IGK_g(activityState.getActivityType(), null, MaterialTheme.getColors(startRestartGroup).m169getOnSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(startRestartGroup).h1, startRestartGroup, 0, 0, 65530);
                IconKt.m187Iconww6aTOc(PainterResources_androidKt.painterResource(activityState.getImageId(), startRestartGroup), "activity type", GraphicsLayerModifierKt.m331graphicsLayerAp8cVGQ$default(companion, 0.7f, 0.7f, 0.0f, null, false, 0, 131068), MaterialTheme.getColors(startRestartGroup).m169getOnSurface0d7_KjU(), startRestartGroup, 440, 0);
                startRestartGroup.end(false);
                startRestartGroup.end(true);
                startRestartGroup.end(false);
                startRestartGroup.end(false);
                String str = activityState.getDate() + ", " + activityState.getTime();
                Color = ColorKt.Color(Color.m322getRedimpl(r3), Color.m321getGreenimpl(r3), Color.m319getBlueimpl(r3), 0.7f, Color.m320getColorSpaceimpl(MaterialTheme.getColors(startRestartGroup).m169getOnSurface0d7_KjU()));
                TextKt.m216Text4IGK_g(str, null, Color, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(startRestartGroup).h3, startRestartGroup, 0, 0, 65530);
                String address = activityState.getAddress();
                Color2 = ColorKt.Color(Color.m322getRedimpl(r1), Color.m321getGreenimpl(r1), Color.m319getBlueimpl(r1), 0.7f, Color.m320getColorSpaceimpl(MaterialTheme.getColors(startRestartGroup).m169getOnSurface0d7_KjU()));
                TextKt.m216Text4IGK_g(address, null, Color2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(startRestartGroup).h3, startRestartGroup, 0, 0, 65530);
                RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                if (m != null) {
                    final Modifier modifier3 = modifier2;
                    m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$ActivityTypeSummary$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int r8) {
                            WorkoutDetailsFragment.this.ActivityTypeSummary(activityState, modifier3, composer2, Strings.updateChangedFlags(r56 | 1), r57);
                        }
                    };
                    return;
                }
                return;
            }
            ComposablesKt.invalidApplier();
            throw null;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    public final void MetricSummary(final List<? extends List<Pair<String, String>>> list, Modifier modifier, Composer composer, final int r67, final int r68) {
        Modifier modifier2;
        boolean z;
        long Color;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-372904357);
        int r1 = r68 & 2;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        float f = 16;
        Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(modifier2, 0.0f, 0.0f, 0.0f, f, 7);
        startRestartGroup.startReplaceableGroup(-483455358);
        Arrangement$Top$1 arrangement$Top$1 = Arrangement.Top;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, startRestartGroup);
        int r12 = -1323940314;
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
        Applier<?> applier = startRestartGroup.applier;
        if (applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            int r10 = 2058660585;
            AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 818240595);
            Iterator it = list.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                List<Pair> list2 = (List) it.next();
                int r3 = r10;
                Applier<?> applier2 = applier;
                Modifier m75paddingqDBjuR0$default2 = PaddingKt.m75paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), f, 0.0f, 0.0f, f, 6);
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, startRestartGroup);
                startRestartGroup.startReplaceableGroup(r12);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default2);
                if (applier2 instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$12);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$12);
                    }
                    applier = applier2;
                    r10 = r3;
                    AnimatedContentKt$$ExternalSyntheticOutline1.m(z2, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, r10, 1119068606);
                    float f2 = 1.0f;
                    z2 = z2;
                    for (Pair pair : list2) {
                        String str = (String) pair.first;
                        String str2 = (String) pair.second;
                        if (f2 > 0.0d) {
                            z = true;
                        } else {
                            z = z2 ? 1 : 0;
                        }
                        if (z) {
                            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(f2, true);
                            companion.then(layoutWeightElement);
                            startRestartGroup.startReplaceableGroup(-483455358);
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, startRestartGroup);
                            startRestartGroup.startReplaceableGroup(r12);
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                            PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$13 = ComposeUiNode.Companion.Constructor;
                            ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(layoutWeightElement);
                            if (applier instanceof Applier) {
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.inserting) {
                                    startRestartGroup.createNode(layoutNode$Companion$Constructor$13);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                Updater.m228setimpl(startRestartGroup, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$13 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$13);
                                }
                                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(z2 ? 1 : 0, modifierMaterializerOf3, new SkippableUpdater(startRestartGroup), startRestartGroup, r10);
                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                                Color = ColorKt.Color(Color.m322getRedimpl(r2), Color.m321getGreenimpl(r2), Color.m319getBlueimpl(r2), 0.7f, Color.m320getColorSpaceimpl(((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m169getOnSurface0d7_KjU()));
                                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
                                TextKt.m216Text4IGK_g(str, null, Color, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).h4, startRestartGroup, 0, 0, 65530);
                                TextKt.m216Text4IGK_g(str2, null, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m169getOnSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).h2, startRestartGroup, 0, 0, 65530);
                                z2 = false;
                                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                                f2 = 1.0f;
                                applier = applier;
                                r10 = r10;
                                r12 = r12;
                                horizontal = horizontal;
                                companion = companion;
                                f = f;
                            } else {
                                ComposablesKt.invalidApplier();
                                throw null;
                            }
                        } else {
                            throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
                        }
                    }
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, z2, z2, true, z2);
                    startRestartGroup.end(z2);
                } else {
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }
            boolean z3 = z2;
            AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, z3, z3, true, z3);
            startRestartGroup.end(z3);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                final Modifier modifier3 = modifier2;
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$MetricSummary$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r8) {
                        WorkoutDetailsFragment.this.MetricSummary(list, modifier3, composer2, Strings.updateChangedFlags(r67 | 1), r68);
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public final void initElevation(LayoutWorkoutDetailsLinechartBinding layoutWorkoutDetailsLinechartBinding) {
        layoutWorkoutDetailsLinechartBinding.tvChartBottom.setText(getString(R.string.health_workouts_detail_elevation_title));
        ChartView chartView = layoutWorkoutDetailsLinechartBinding.chartView;
        AndroidKanvas kanvas = chartView.getKanvas();
        DarkThemeChartColors darkThemeChartColors = this.colors;
        KronabyFonts kronabyFonts = this.fonts;
        SessionListItem sessionListItem = this.session;
        if (sessionListItem != null) {
            String elevationGain = sessionListItem.getElevationGain();
            FitnessProvider.Profile.Measurement measurement = ProviderFactory.getWatch().fitness().getProfile().getMeasurement();
            SessionListItem sessionListItem2 = this.session;
            if (sessionListItem2 != null) {
                chartView.setChart(LineChartsKt.createElevationChart(kanvas, darkThemeChartColors, kronabyFonts, elevationGain, measurement, sessionListItem2.getElevations()));
                layoutWorkoutDetailsLinechartBinding.touchAreaBtnArrow.setOnClickListener(new LottiePreviewFragment$$ExternalSyntheticLambda0(this, 1));
                RelativeLayout root = layoutWorkoutDetailsLinechartBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.visible(root);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("session");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("session");
        throw null;
    }

    public static final void initElevation$lambda$18(WorkoutDetailsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainController mainController = this$0.getMainController();
        WorkoutMetricDetailFragment.Companion companion = WorkoutMetricDetailFragment.Companion;
        SessionListItem sessionListItem = this$0.session;
        if (sessionListItem != null) {
            String serialize = WorkoutDataClassesKt.serialize(sessionListItem.getElevations());
            SessionListItem sessionListItem2 = this$0.session;
            if (sessionListItem2 != null) {
                mainController.gotoNextFragment(WorkoutMetricDetailFragment.Companion.newInstance$default(companion, serialize, R.string.health_workouts_detail_elevation_title, sessionListItem2.getTotalTime(), 0, 8, null));
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("session");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("session");
        throw null;
    }

    public final void initGoogleMap() {
        GoogleMap googleMap;
        DpUtils dpUtils = DpUtils.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.collapsedMapHeight = dpUtils.dpToPx(requireContext, 250.0f);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
        if (fragmentWorkoutDetailsBinding != null) {
            MapView mapView = fragmentWorkoutDetailsBinding.mapView;
            OnMapReadyCallback onMapReadyCallback = new OnMapReadyCallback() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.maps.OnMapReadyCallback
                public final void onMapReady(GoogleMap googleMap2) {
                    WorkoutDetailsFragment.initGoogleMap$lambda$20(this, ref$BooleanRef, ref$BooleanRef2, googleMap2);
                }
            };
            mapView.getClass();
            Preconditions.checkMainThread("getMapAsync() must be called on the main thread");
            zzah zzahVar = mapView.zza;
            LifecycleDelegate lifecycleDelegate = zzahVar.zaa;
            if (lifecycleDelegate != null) {
                try {
                    ((zzag) lifecycleDelegate).zzb.getMapAsync(new zzaf(onMapReadyCallback));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            } else {
                zzahVar.zze.add(onMapReadyCallback);
            }
            FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding2 = this.binding;
            if (fragmentWorkoutDetailsBinding2 != null) {
                MapView mapView2 = fragmentWorkoutDetailsBinding2.mapView;
                Intrinsics.checkNotNullExpressionValue(mapView2, "mapView");
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (ViewCompat.Api19Impl.isLaidOut(mapView2) && !mapView2.isLayoutRequested()) {
                    ref$BooleanRef2.element = true;
                    if (ref$BooleanRef.element && (googleMap = this.map) != null) {
                        invalidate(googleMap);
                        return;
                    }
                    return;
                }
                mapView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$initGoogleMap$$inlined$doOnLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                        GoogleMap googleMap2;
                        view.removeOnLayoutChangeListener(this);
                        Ref$BooleanRef.this.element = true;
                        if (ref$BooleanRef.element && (googleMap2 = this.map) != null) {
                            this.invalidate(googleMap2);
                        }
                    }
                });
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public static final void initGoogleMap$lambda$20(WorkoutDetailsFragment this$0, Ref$BooleanRef mapLoaded, Ref$BooleanRef viewCreated, GoogleMap googleMap) {
        GoogleMap googleMap2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mapLoaded, "$mapLoaded");
        Intrinsics.checkNotNullParameter(viewCreated, "$viewCreated");
        Intrinsics.checkNotNullParameter(googleMap, "googleMap");
        this$0.map = googleMap;
        SessionListItem sessionListItem = this$0.session;
        if (sessionListItem != null) {
            LocationMapUtilsKt.addLocation(googleMap, LocationMapUtilsKt.getPoint(sessionListItem.getRoute()), GoogleMapsGeneratorKt.getPathColor());
            mapLoaded.element = true;
            if (viewCreated.element && (googleMap2 = this$0.map) != null) {
                this$0.invalidate(googleMap2);
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("session");
        throw null;
    }

    public final void initHeartRate(LayoutWorkoutDetailsLinechartBinding layoutWorkoutDetailsLinechartBinding) {
        layoutWorkoutDetailsLinechartBinding.tvChartBottom.setText(getString(R.string.health_measurement_heart_rate_title));
        ChartView chartView = layoutWorkoutDetailsLinechartBinding.chartView;
        AndroidKanvas kanvas = chartView.getKanvas();
        DarkThemeChartColors darkThemeChartColors = this.colors;
        KronabyFonts kronabyFonts = this.fonts;
        SessionListItem sessionListItem = this.session;
        if (sessionListItem != null) {
            List<PointEntry> heartrates = sessionListItem.getHeartrates();
            SessionListItem sessionListItem2 = this.session;
            if (sessionListItem2 != null) {
                chartView.setChart(LineChartsKt.createHeartRateChart(kanvas, darkThemeChartColors, kronabyFonts, heartrates, sessionListItem2.getRawAverageHeartrate()));
                layoutWorkoutDetailsLinechartBinding.touchAreaBtnArrow.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WorkoutDetailsFragment.initHeartRate$lambda$17(WorkoutDetailsFragment.this, view);
                    }
                });
                RelativeLayout root = layoutWorkoutDetailsLinechartBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.visible(root);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("session");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("session");
        throw null;
    }

    public static final void initHeartRate$lambda$17(WorkoutDetailsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainController mainController = this$0.getMainController();
        WorkoutMetricDetailFragment.Companion companion = WorkoutMetricDetailFragment.Companion;
        SessionListItem sessionListItem = this$0.session;
        if (sessionListItem != null) {
            String serialize = WorkoutDataClassesKt.serialize(sessionListItem.getHeartrates());
            SessionListItem sessionListItem2 = this$0.session;
            if (sessionListItem2 != null) {
                String totalTime = sessionListItem2.getTotalTime();
                SessionListItem sessionListItem3 = this$0.session;
                if (sessionListItem3 != null) {
                    mainController.gotoNextFragment(companion.newInstance(serialize, R.string.health_measurement_heart_rate_title, totalTime, sessionListItem3.getRawAverageHeartrate()));
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("session");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("session");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("session");
        throw null;
    }

    public final void initSplits(LayoutWorkoutDetailsSplitsBinding layoutWorkoutDetailsSplitsBinding) {
        int r0;
        String upperCase;
        int r02 = WhenMappings.$EnumSwitchMapping$1[ProviderFactory.getWatch().fitness().getProfile().getMeasurement().ordinal()];
        if (r02 != 1) {
            if (r02 == 2) {
                r0 = R.string.units_distance_miles;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            r0 = R.string.units_distance_km;
        }
        String string = getString(r0);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase2 = string.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        SessionListItem sessionListItem = this.session;
        if (sessionListItem != null) {
            if (WhenMappings.$EnumSwitchMapping$2[sessionListItem.getSessionType().ordinal()] == 1) {
                upperCase = StringsExtensionsKt.getAppString(Key.time).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            } else {
                upperCase = StringsExtensionsKt.getAppString(Key.pace).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            }
            String str = upperCase;
            AndroidKanvas kanvas = layoutWorkoutDetailsSplitsBinding.chartView.getKanvas();
            DarkThemeChartColors darkThemeChartColors = this.colors;
            SessionListItem sessionListItem2 = this.session;
            if (sessionListItem2 != null) {
                HorizontalBarChart createSplitsChart = HorizontalBarChartsKt.createSplitsChart(kanvas, darkThemeChartColors, this.fonts, sessionListItem2.getSplits(), upperCase2, str);
                ChartView chartView = layoutWorkoutDetailsSplitsBinding.chartView;
                chartView.getLayoutParams().height = DpUtilsKt.toPxInt(createSplitsChart.getTotalHeight());
                chartView.setChart(createSplitsChart);
                LinearLayout root = layoutWorkoutDetailsSplitsBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.visible(root);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("session");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("session");
        throw null;
    }

    public final void invalidate(GoogleMap googleMap) {
        LocationMapUtilsKt.configure(googleMap);
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
        if (fragmentWorkoutDetailsBinding != null) {
            MapView mapView = fragmentWorkoutDetailsBinding.mapView;
            Intrinsics.checkNotNullExpressionValue(mapView, "mapView");
            DpUtils dpUtils = DpUtils.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            int dpToPx = dpUtils.dpToPx(requireContext, 32.0f);
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            LocationMapUtilsKt.moveGoogleMapLogo$default(mapView, dpToPx, dpUtils.dpToPx(requireContext2, 56.0f), 0, 0, 12, null);
            LocationMapUtilsKt.disableMapInteraction(googleMap);
            SessionListItem sessionListItem = this.session;
            if (sessionListItem != null) {
                LatLng point = LocationMapUtilsKt.getPoint(sessionListItem.getRoute());
                SessionListItem sessionListItem2 = this.session;
                if (sessionListItem2 != null) {
                    LocationMapUtilsKt.repositionCamera$default(googleMap, false, point, LocationMapUtilsKt.latLangBounds(sessionListItem2.getRoute()), 0.0f, 0, 24, null);
                    LatLng target = googleMap.getCameraPosition().target;
                    Intrinsics.checkNotNullExpressionValue(target, "target");
                    this.initialCameraTarget = target;
                    this.zoomLevelExpanded = googleMap.getCameraPosition().zoom;
                    float f = googleMap.getCameraPosition().zoom - 1.0f;
                    this.zoomLevelCollapsed = f;
                    GoogleMap googleMap2 = this.map;
                    if (googleMap2 != null) {
                        try {
                            ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate = MagicApiIntrinsics.zza;
                            Preconditions.checkNotNull(iCameraUpdateFactoryDelegate, "CameraUpdateFactory is not initialized");
                            IObjectWrapper zoomTo = iCameraUpdateFactoryDelegate.zoomTo(f);
                            Preconditions.checkNotNull(zoomTo);
                            try {
                                googleMap2.zza.moveCamera(zoomTo);
                            } catch (RemoteException e) {
                                throw new RuntimeRemoteException(e);
                            }
                        } catch (RemoteException e2) {
                            throw new RuntimeRemoteException(e2);
                        }
                    }
                    SessionListItem sessionListItem3 = this.session;
                    if (sessionListItem3 != null) {
                        PolylineOptions createPolyline = LocationMapUtilsKt.createPolyline(sessionListItem3.getRoute(), GoogleMapsGeneratorKt.getPathColor());
                        if (createPolyline != null) {
                            try {
                                Preconditions.checkNotNull(googleMap.zza.addPolyline(createPolyline));
                                return;
                            } catch (RemoteException e3) {
                                throw new RuntimeRemoteException(e3);
                            }
                        }
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("session");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("session");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("session");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    private final void playCollapseAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[5];
        GoogleMap googleMap = this.map;
        Intrinsics.checkNotNull(googleMap);
        LatLng latLng = this.initialCameraTarget;
        if (latLng != null) {
            animatorArr[0] = AnimatorsKt.mapsAnimator$default(googleMap, 250L, latLng, this.zoomLevelCollapsed, null, 8, null);
            FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
            if (fragmentWorkoutDetailsBinding != null) {
                FrameLayout containerMap = fragmentWorkoutDetailsBinding.containerMap;
                Intrinsics.checkNotNullExpressionValue(containerMap, "containerMap");
                animatorArr[1] = AnimatorsKt.resizeAnimator(containerMap, 250L, this.collapsedMapHeight);
                FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding2 = this.binding;
                if (fragmentWorkoutDetailsBinding2 != null) {
                    ImageView ivToolbarBack = fragmentWorkoutDetailsBinding2.ivToolbarBack;
                    Intrinsics.checkNotNullExpressionValue(ivToolbarBack, "ivToolbarBack");
                    animatorArr[2] = AnimatorsKt.fadeInAnimator$default(ivToolbarBack, 200L, null, 2, null);
                    FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding3 = this.binding;
                    if (fragmentWorkoutDetailsBinding3 != null) {
                        ImageView ivToolbarCollapse = fragmentWorkoutDetailsBinding3.ivToolbarCollapse;
                        Intrinsics.checkNotNullExpressionValue(ivToolbarCollapse, "ivToolbarCollapse");
                        animatorArr[3] = AnimatorsKt.fadeOutAnimator$default(ivToolbarCollapse, 150L, null, 2, null);
                        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding4 = this.binding;
                        if (fragmentWorkoutDetailsBinding4 != null) {
                            ImageView ivToolbarExpand = fragmentWorkoutDetailsBinding4.ivToolbarExpand;
                            Intrinsics.checkNotNullExpressionValue(ivToolbarExpand, "ivToolbarExpand");
                            animatorArr[4] = AnimatorsKt.fadeInAnimator$default(ivToolbarExpand, 200L, null, 2, null);
                            animatorSet.playTogether(animatorArr);
                            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$playCollapseAnimation$lambda$3$$inlined$doOnEnd$1
                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    WorkoutDetailsViewModel workoutDetailsViewModel;
                                    workoutDetailsViewModel = WorkoutDetailsFragment.this.viewModel;
                                    if (workoutDetailsViewModel != null) {
                                        workoutDetailsViewModel.onEndAnimation();
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                        throw null;
                                    }
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationRepeat(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                }
                            });
                            animatorSet.start();
                            this.animatorSet = animatorSet;
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initialCameraTarget");
        throw null;
    }

    private final void playExpandAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[5];
        GoogleMap googleMap = this.map;
        Intrinsics.checkNotNull(googleMap);
        LatLng latLng = this.initialCameraTarget;
        if (latLng != null) {
            animatorArr[0] = AnimatorsKt.mapsAnimator$default(googleMap, 300L, latLng, this.zoomLevelExpanded, null, 8, null);
            FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
            if (fragmentWorkoutDetailsBinding != null) {
                FrameLayout containerMap = fragmentWorkoutDetailsBinding.containerMap;
                Intrinsics.checkNotNullExpressionValue(containerMap, "containerMap");
                animatorArr[1] = AnimatorsKt.resizeAnimator(containerMap, 300L, this.expandedMapHeight);
                FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding2 = this.binding;
                if (fragmentWorkoutDetailsBinding2 != null) {
                    ImageView ivToolbarBack = fragmentWorkoutDetailsBinding2.ivToolbarBack;
                    Intrinsics.checkNotNullExpressionValue(ivToolbarBack, "ivToolbarBack");
                    animatorArr[2] = AnimatorsKt.fadeOutAnimator$default(ivToolbarBack, 150L, null, 2, null);
                    FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding3 = this.binding;
                    if (fragmentWorkoutDetailsBinding3 != null) {
                        ImageView ivToolbarCollapse = fragmentWorkoutDetailsBinding3.ivToolbarCollapse;
                        Intrinsics.checkNotNullExpressionValue(ivToolbarCollapse, "ivToolbarCollapse");
                        animatorArr[3] = AnimatorsKt.fadeInAnimator$default(ivToolbarCollapse, 200L, null, 2, null);
                        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding4 = this.binding;
                        if (fragmentWorkoutDetailsBinding4 != null) {
                            ImageView ivToolbarExpand = fragmentWorkoutDetailsBinding4.ivToolbarExpand;
                            Intrinsics.checkNotNullExpressionValue(ivToolbarExpand, "ivToolbarExpand");
                            animatorArr[4] = AnimatorsKt.fadeOutAnimator$default(ivToolbarExpand, 150L, null, 2, null);
                            animatorSet.playTogether(animatorArr);
                            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$playExpandAnimation$lambda$1$$inlined$doOnEnd$1
                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    WorkoutDetailsViewModel workoutDetailsViewModel;
                                    workoutDetailsViewModel = WorkoutDetailsFragment.this.viewModel;
                                    if (workoutDetailsViewModel != null) {
                                        workoutDetailsViewModel.onEndAnimation();
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                        throw null;
                                    }
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationRepeat(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                }
                            });
                            animatorSet.start();
                            this.animatorSet = animatorSet;
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initialCameraTarget");
        throw null;
    }

    public final Unit renderAnimationState(WorkoutDetailsViewModel.AnimationState animationState) {
        int r8 = WhenMappings.$EnumSwitchMapping$0[animationState.ordinal()];
        UiSettings uiSettings = null;
        if (r8 != 1) {
            if (r8 != 2) {
                if (r8 != 3) {
                    if (r8 != 4) {
                        if (r8 == 5) {
                            FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
                            if (fragmentWorkoutDetailsBinding != null) {
                                ImageView ivToolbarCollapse = fragmentWorkoutDetailsBinding.ivToolbarCollapse;
                                Intrinsics.checkNotNullExpressionValue(ivToolbarCollapse, "ivToolbarCollapse");
                                ViewKt.visible(ivToolbarCollapse);
                                fragmentWorkoutDetailsBinding.ivToolbarBack.setEnabled(false);
                                fragmentWorkoutDetailsBinding.scrollView.smoothScrollTo(0, 0);
                                GoogleMap googleMap = this.map;
                                if (googleMap != null) {
                                    uiSettings = googleMap.getUiSettings();
                                }
                                if (uiSettings != null) {
                                    try {
                                        uiSettings.zza.setCompassEnabled(true);
                                    } catch (RemoteException e) {
                                        throw new RuntimeRemoteException(e);
                                    }
                                }
                                playExpandAnimation();
                                return Unit.INSTANCE;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            throw null;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding2 = this.binding;
                    if (fragmentWorkoutDetailsBinding2 != null) {
                        ImageView ivToolbarExpand = fragmentWorkoutDetailsBinding2.ivToolbarExpand;
                        Intrinsics.checkNotNullExpressionValue(ivToolbarExpand, "ivToolbarExpand");
                        ViewKt.visible(ivToolbarExpand);
                        fragmentWorkoutDetailsBinding2.ivToolbarBack.setEnabled(true);
                        GoogleMap googleMap2 = this.map;
                        if (googleMap2 != null) {
                            uiSettings = googleMap2.getUiSettings();
                        }
                        if (uiSettings != null) {
                            try {
                                uiSettings.zza.setCompassEnabled(false);
                            } catch (RemoteException e2) {
                                throw new RuntimeRemoteException(e2);
                            }
                        }
                        playCollapseAnimation();
                        return Unit.INSTANCE;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
                FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding3 = this.binding;
                if (fragmentWorkoutDetailsBinding3 != null) {
                    ImageView ivToolbarCollapse2 = fragmentWorkoutDetailsBinding3.ivToolbarCollapse;
                    Intrinsics.checkNotNullExpressionValue(ivToolbarCollapse2, "ivToolbarCollapse");
                    ViewKt.gone(ivToolbarCollapse2);
                    FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding4 = this.binding;
                    if (fragmentWorkoutDetailsBinding4 != null) {
                        fragmentWorkoutDetailsBinding4.scrollView.setEnableScrolling(true);
                        GoogleMap googleMap3 = this.map;
                        if (googleMap3 == null) {
                            return null;
                        }
                        LocationMapUtilsKt.disableMapInteraction(googleMap3);
                        return Unit.INSTANCE;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding5 = this.binding;
            if (fragmentWorkoutDetailsBinding5 != null) {
                ImageView ivToolbarExpand2 = fragmentWorkoutDetailsBinding5.ivToolbarExpand;
                Intrinsics.checkNotNullExpressionValue(ivToolbarExpand2, "ivToolbarExpand");
                ViewKt.invisible(ivToolbarExpand2);
                FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding6 = this.binding;
                if (fragmentWorkoutDetailsBinding6 != null) {
                    fragmentWorkoutDetailsBinding6.scrollView.setEnableScrolling(false);
                    GoogleMap googleMap4 = this.map;
                    if (googleMap4 == null) {
                        return null;
                    }
                    LocationMapUtilsKt.enableMapInteraction(googleMap4);
                    return Unit.INSTANCE;
                }
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        GoogleMap googleMap5 = this.map;
        if (googleMap5 == null) {
            return null;
        }
        invalidate(googleMap5);
        return Unit.INSTANCE;
    }

    public final void showDeleteWorkoutDialog() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BottomSheetKt.createBottomDialog(requireContext, new Function2<BottomDialog, LayoutInflater, ViewBinding>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$showDeleteWorkoutDialog$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final ViewBinding invoke(BottomDialog dialog, LayoutInflater inflater) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                DialogGenericBinding inflate = DialogGenericBinding.inflate(inflater);
                WorkoutDetailsFragment workoutDetailsFragment = WorkoutDetailsFragment.this;
                Button btnPrimary = inflate.btnPrimary;
                Intrinsics.checkNotNullExpressionValue(btnPrimary, "btnPrimary");
                ProgressBar progressBar = inflate.progressBar;
                Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                Loading loading = new Loading(btnPrimary, progressBar, false);
                inflate.tvTitle.setText(workoutDetailsFragment.getString(R.string.general_are_you_sure));
                inflate.tvBody.setText(workoutDetailsFragment.getString(R.string.health_workouts_detail_dialog_delete_subtitle));
                inflate.btnPrimary.setText(workoutDetailsFragment.getString(R.string.delete));
                inflate.btnSecondary.setText(workoutDetailsFragment.getString(R.string.button_cancel));
                Button btnPrimary2 = inflate.btnPrimary;
                Intrinsics.checkNotNullExpressionValue(btnPrimary2, "btnPrimary");
                workoutDetailsFragment.onClick(btnPrimary2, new WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$1(loading, workoutDetailsFragment, dialog, null));
                Button btnSecondary = inflate.btnSecondary;
                Intrinsics.checkNotNullExpressionValue(btnSecondary, "btnSecondary");
                workoutDetailsFragment.onClick(btnSecondary, new WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$2(dialog, null));
                return inflate;
            }
        }).show();
    }

    public final void updateTopBarAlpha(final FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding) {
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(new ShapeAppearanceModel());
        DpUtils dpUtils = DpUtils.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        float dpToPx = dpUtils.dpToPx(requireContext, 24.0f);
        KeyEvent_androidKt createCornerTreatment = zzav.createCornerTreatment(0);
        builder.topLeftCorner = createCornerTreatment;
        float compatCornerTreatmentSize = ShapeAppearanceModel.Builder.compatCornerTreatmentSize(createCornerTreatment);
        if (compatCornerTreatmentSize != -1.0f) {
            builder.setTopLeftCornerSize(compatCornerTreatmentSize);
        }
        builder.setTopLeftCornerSize(dpToPx);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        float dpToPx2 = dpUtils.dpToPx(requireContext2, 24.0f);
        KeyEvent_androidKt createCornerTreatment2 = zzav.createCornerTreatment(0);
        builder.topRightCorner = createCornerTreatment2;
        float compatCornerTreatmentSize2 = ShapeAppearanceModel.Builder.compatCornerTreatmentSize(createCornerTreatment2);
        if (compatCornerTreatmentSize2 != -1.0f) {
            builder.setTopRightCornerSize(compatCornerTreatmentSize2);
        }
        builder.setTopRightCornerSize(dpToPx2);
        final MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel(builder));
        Context requireContext3 = requireContext();
        Object obj = ContextCompat.sLock;
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(ContextCompat.Api23Impl.getColor(requireContext3, R.color.pascalColorCard)));
        materialShapeDrawable.setAlpha(0);
        fragmentWorkoutDetailsBinding.containerAnimatedToolbar.setBackground(materialShapeDrawable);
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        fragmentWorkoutDetailsBinding.scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int r10, int r11, int r12, int r13) {
                WorkoutDetailsFragment.updateTopBarAlpha$lambda$6(FragmentWorkoutDetailsBinding.this, ref$FloatRef, materialShapeDrawable, view, r10, r11, r12, r13);
            }
        });
    }

    public static final void updateTopBarAlpha$lambda$6(FragmentWorkoutDetailsBinding this_updateTopBarAlpha, Ref$FloatRef progress, MaterialShapeDrawable toolbarShape, View view, int r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(this_updateTopBarAlpha, "$this_updateTopBarAlpha");
        Intrinsics.checkNotNullParameter(progress, "$progress");
        Intrinsics.checkNotNullParameter(toolbarShape, "$toolbarShape");
        float height = this_updateTopBarAlpha.containerAnimatedToolbar.getHeight();
        if (height > 0.0f) {
            float coerceIn = RangesKt___RangesKt.coerceIn(r5 / height, 0.0f, 1.0f);
            progress.element = coerceIn;
            toolbarShape.setAlpha((int) (coerceIn * 255));
        }
    }

    @Override // com.animaconnected.secondo.screens.details.Dismissible
    public void dismiss(OnDismissedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
        if (fragmentWorkoutDetailsBinding != null) {
            RelativeLayout root = fragmentWorkoutDetailsBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding2 = this.binding;
            if (fragmentWorkoutDetailsBinding2 != null) {
                View viewAnimContainer = fragmentWorkoutDetailsBinding2.viewAnimContainer;
                Intrinsics.checkNotNullExpressionValue(viewAnimContainer, "viewAnimContainer");
                AnimationFactoryKotlinKt.exitCardRevealAnim(this, root, viewAnimContainer, this.cardBounds, listener);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
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
            return ContextCompat.Api21Impl.getDrawable(context, R.drawable.ic_close);
        }
        return null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.sessionID = arguments.getLong("sessionID");
            this.inWorkoutHistory = arguments.getBoolean("historyID");
            this.cardBounds.left = arguments.getInt(AnimationFactoryKotlinKt.LEFT, 0);
            this.cardBounds.top = arguments.getInt(AnimationFactoryKotlinKt.TOP, 0);
            this.cardBounds.right = arguments.getInt(AnimationFactoryKotlinKt.RIGHT, 0);
            this.cardBounds.bottom = arguments.getInt(AnimationFactoryKotlinKt.BOTTOM, 0);
            this.shouldReveal = arguments.getBoolean(AnimationFactoryKotlinKt.SHOULD_REVEAL, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentWorkoutDetailsBinding inflate = FragmentWorkoutDetailsBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new WorkoutDetailsFragment$onCreateView$1(this, bundle, inflater, null), 3);
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
        if (fragmentWorkoutDetailsBinding != null) {
            RelativeLayout root = fragmentWorkoutDetailsBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
        if (fragmentWorkoutDetailsBinding != null) {
            zzah zzahVar = fragmentWorkoutDetailsBinding.mapView.zza;
            LifecycleDelegate lifecycleDelegate = zzahVar.zaa;
            if (lifecycleDelegate != null) {
                lifecycleDelegate.onDestroy();
                return;
            } else {
                zzahVar.zae(1);
                return;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
        if (fragmentWorkoutDetailsBinding != null) {
            LifecycleDelegate lifecycleDelegate = fragmentWorkoutDetailsBinding.mapView.zza.zaa;
            if (lifecycleDelegate != null) {
                lifecycleDelegate.onLowMemory();
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
        if (fragmentWorkoutDetailsBinding != null) {
            zzah zzahVar = fragmentWorkoutDetailsBinding.mapView.zza;
            LifecycleDelegate lifecycleDelegate = zzahVar.zaa;
            if (lifecycleDelegate != null) {
                lifecycleDelegate.onPause();
                return;
            } else {
                zzahVar.zae(5);
                return;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
        if (fragmentWorkoutDetailsBinding != null) {
            zzah zzahVar = fragmentWorkoutDetailsBinding.mapView.zza;
            zzahVar.getClass();
            zzahVar.zaf(null, new zag(zzahVar));
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding = this.binding;
        if (fragmentWorkoutDetailsBinding != null) {
            zzah zzahVar = fragmentWorkoutDetailsBinding.mapView.zza;
            zzahVar.getClass();
            zzahVar.zaf(null, new zaf(zzahVar));
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }
}
