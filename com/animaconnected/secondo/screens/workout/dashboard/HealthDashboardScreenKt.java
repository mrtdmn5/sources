package com.animaconnected.secondo.screens.workout.dashboard;

import android.content.Context;
import android.icu.text.RelativeDateTimeFormatter;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.compose.FlowExtKt;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import com.animaconnected.secondo.screens.workout.utils.ChartMitmapsKt;
import com.animaconnected.secondo.widget.compose.ChartsKt;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.fitness.HeartrateValue;
import com.animaconnected.watch.graphs.BarChartSize;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.theme.ChartTheme;
import com.animaconnected.watch.workout.HeartrateMetricItem;
import com.animaconnected.watch.workout.HeartrateMetricListItem;
import com.animaconnected.watch.workout.MetricListItem;
import com.animaconnected.watch.workout.StringMetricListItem;
import com.animaconnected.watch.workout.WorkoutMetricType;
import com.animaconnected.widget.BackgroundCardKt;
import com.animaconnected.widget.ModifiersKt;
import com.animaconnected.widget.TopbarKt;
import com.animaconnected.widget.VerticalGridKt;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.time.Duration;
import kotlinx.datetime.Instant;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: HealthDashboardScreen.kt */
/* loaded from: classes3.dex */
public final class HealthDashboardScreenKt {
    private static final float paddingInsideCard;
    private static final float paddingScreenEdge;
    private static final float paddingTitle = 32;

    /* compiled from: HealthDashboardScreen.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WorkoutMetricType.values().length];
            try {
                r0[WorkoutMetricType.Steps.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WorkoutMetricType.HeartRate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WorkoutMetricType.Calories.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[WorkoutMetricType.VO2Max.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[WorkoutMetricType.Sleep.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        float f = 16;
        paddingInsideCard = f;
        paddingScreenEdge = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DailyGoalCharts(final HealthGoals healthGoals, final Function0<BarEntry> function0, final Function0<BarEntry> function02, final Function0<BarEntry> function03, final ChartTheme chartTheme, Composer composer, final int r29) {
        Modifier fillMaxWidth;
        Modifier fillMaxWidth2;
        Modifier fillMaxWidth3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(554799997);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.LocalContext);
        startRestartGroup.startReplaceableGroup(-1217064400);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.end(false);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier fillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
        startRestartGroup.startReplaceableGroup(-1217064265);
        Object nextSlot2 = startRestartGroup.nextSlot();
        if (nextSlot2 == composer$Companion$Empty$1) {
            nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$DailyGoalCharts$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    boolean DailyGoalCharts$lambda$21;
                    MutableState<Boolean> mutableState2 = mutableState;
                    DailyGoalCharts$lambda$21 = HealthDashboardScreenKt.DailyGoalCharts$lambda$21(mutableState2);
                    HealthDashboardScreenKt.DailyGoalCharts$lambda$22(mutableState2, !DailyGoalCharts$lambda$21);
                }
            };
            startRestartGroup.updateValue(nextSlot2);
        }
        startRestartGroup.end(false);
        Modifier noRippleClickable = ModifiersKt.noRippleClickable(fillMaxWidth4, (Function0) nextSlot2);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(noRippleClickable);
        if (startRestartGroup.applier instanceof Applier) {
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
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            float f = 2;
            float f2 = 32;
            fillMaxWidth = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f, 7), f2), 1.0f);
            int steps = healthGoals.getSteps();
            startRestartGroup.startReplaceableGroup(-1537453012);
            Object nextSlot3 = startRestartGroup.nextSlot();
            if (nextSlot3 == composer$Companion$Empty$1) {
                nextSlot3 = ChartMitmapsKt.ninePatchProgressBackground(context);
                startRestartGroup.updateValue(nextSlot3);
            }
            startRestartGroup.end(false);
            ChartColors colors = chartTheme.getColors();
            ChartFonts fonts = chartTheme.getFonts();
            boolean DailyGoalCharts$lambda$21 = DailyGoalCharts$lambda$21(mutableState);
            BarChartSize barChartSize = BarChartSize.Large;
            ChartsKt.HorizontalGoalChart(function0, steps, false, barChartSize, fillMaxWidth, (Mitmap) nextSlot3, DailyGoalCharts$lambda$21, colors, fonts, startRestartGroup, ((r29 >> 3) & 14) | 151285120, 0);
            fillMaxWidth2 = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f, 7), f2), 1.0f);
            int stand = healthGoals.getStand();
            startRestartGroup.startReplaceableGroup(-1537452487);
            Object nextSlot4 = startRestartGroup.nextSlot();
            if (nextSlot4 == composer$Companion$Empty$1) {
                nextSlot4 = ChartMitmapsKt.ninePatchProgressBackground(context);
                startRestartGroup.updateValue(nextSlot4);
            }
            startRestartGroup.end(false);
            ChartsKt.SegmentedGoalChart(function02, stand, false, barChartSize, fillMaxWidth2, (Mitmap) nextSlot4, false, DailyGoalCharts$lambda$21(mutableState), chartTheme.getColors(), chartTheme.getFonts(), startRestartGroup, ((r29 >> 6) & 14) | 1208249728, 64);
            fillMaxWidth3 = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(companion, f2), 1.0f);
            int exercise = healthGoals.getExercise();
            startRestartGroup.startReplaceableGroup(-1537451996);
            Object nextSlot5 = startRestartGroup.nextSlot();
            if (nextSlot5 == composer$Companion$Empty$1) {
                nextSlot5 = ChartMitmapsKt.ninePatchProgressBackground(context);
                startRestartGroup.updateValue(nextSlot5);
            }
            startRestartGroup.end(false);
            ChartsKt.HorizontalGoalChart(function03, exercise, false, barChartSize, fillMaxWidth3, (Mitmap) nextSlot5, DailyGoalCharts$lambda$21(mutableState), chartTheme.getColors(), chartTheme.getFonts(), startRestartGroup, ((r29 >> 9) & 14) | 151285120, 0);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$DailyGoalCharts$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r9) {
                        HealthDashboardScreenKt.DailyGoalCharts(HealthGoals.this, function0, function02, function03, chartTheme, composer2, Strings.updateChangedFlags(r29 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DailyGoalCharts$lambda$21(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DailyGoalCharts$lambda$22(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, androidx.compose.ui.geometry.Rect] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlin.jvm.internal.Lambda, com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$DailyGoalsCard$2] */
    public static final void DailyGoalsCard(Modifier modifier, final Function0<BarEntry> steps, final Function0<BarEntry> stand, final Function0<BarEntry> exercise, final HealthGoals goals, final ChartTheme chartTheme, final Function1<? super Rect, Unit> onClick, Composer composer, final int r32, final int r33) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(stand, "stand");
        Intrinsics.checkNotNullParameter(exercise, "exercise");
        Intrinsics.checkNotNullParameter(goals, "goals");
        Intrinsics.checkNotNullParameter(chartTheme, "chartTheme");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ComposerImpl startRestartGroup = composer.startRestartGroup(839523911);
        int r1 = r33 & 1;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        startRestartGroup.startReplaceableGroup(-1747262217);
        Object nextSlot = startRestartGroup.nextSlot();
        if (nextSlot == Composer.Companion.Empty) {
            nextSlot = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        ref$ObjectRef.element = (Rect) nextSlot;
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, new Function1<LayoutCoordinates, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$DailyGoalsCard$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.compose.ui.geometry.Rect] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                ref$ObjectRef.element = LayoutCoordinatesKt.boundsInRoot(layoutCoordinates);
            }
        });
        float f = paddingInsideCard;
        final Modifier modifier3 = modifier2;
        BackgroundCardKt.m1587BackgroundCardNinePatchY3c_0f4(R.drawable.app_dropped, onGloballyPositioned, PaddingKt.m75paddingqDBjuR0$default(companion, f, f, f, 0.0f, 8), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 772450143, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$DailyGoalsCard$2
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

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0088, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r19.rememberedValue(), java.lang.Integer.valueOf(r7)) == false) goto L20;     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(androidx.compose.runtime.Composer r19, int r20) {
                /*
                    Method dump skipped, instructions count: 422
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$DailyGoalsCard$2.invoke(androidx.compose.runtime.Composer, int):void");
            }
        }), startRestartGroup, 196998, 24);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$DailyGoalsCard$3
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

                public final void invoke(Composer composer2, int r12) {
                    HealthDashboardScreenKt.DailyGoalsCard(Modifier.this, steps, stand, exercise, goals, chartTheme, onClick, composer2, Strings.updateChangedFlags(r32 | 1), r33);
                }
            };
        }
    }

    public static final void DebugButton(Modifier modifier, final Function0<Unit> onClick, Composer composer, final int r43, final int r44) {
        final Modifier modifier2;
        int r6;
        int r62;
        int r7;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1462544461);
        int r4 = r44 & 1;
        if (r4 != 0) {
            r6 = r43 | 6;
            modifier2 = modifier;
        } else if ((r43 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r62 = 4;
            } else {
                r62 = 2;
            }
            r6 = r62 | r43;
        } else {
            modifier2 = modifier;
            r6 = r43;
        }
        if ((r44 & 2) != 0) {
            r6 |= 48;
        } else if ((r43 & 112) == 0) {
            if (startRestartGroup.changedInstance(onClick)) {
                r7 = 32;
            } else {
                r7 = 16;
            }
            r6 |= r7;
        }
        int r11 = r6;
        if ((r11 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (r4 != 0) {
                modifier3 = companion;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            BiasAlignment biasAlignment = Alignment.Companion.Center;
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier3);
            int r5 = ((((((r11 & 14) | 48) << 3) & 112) << 9) & 7168) | 6;
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedContentKt$$ExternalSyntheticOutline1.m((r5 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, -454770737);
                boolean z = true;
                if ((r11 & 112) != 32) {
                    z = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                if (z || nextSlot == Composer.Companion.Empty) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$DebugButton$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            onClick.invoke();
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.item_dragged, startRestartGroup), null, ClickableKt.m26clickableXHw0xAI$default(companion, (Function0) nextSlot), null, null, 0.0f, null, startRestartGroup, 56, 120);
                TextKt.m216Text4IGK_g("Debug", null, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).subtitle2, startRestartGroup, 6, 0, 65530);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                modifier2 = modifier3;
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$DebugButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r52) {
                    HealthDashboardScreenKt.DebugButton(Modifier.this, onClick, composer2, Strings.updateChangedFlags(r43 | 1), r44);
                }
            };
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x011a, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r0.nextSlot(), java.lang.Integer.valueOf(r11)) == false) goto L19;     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02df, code lost:            if (r6 == r3) goto L101;     */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x019f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void HealthDashboardScreen(final com.animaconnected.secondo.screens.workout.dashboard.GoalData r40, final com.animaconnected.widget.SessionCardData r41, final java.util.List<? extends com.animaconnected.watch.workout.MetricListItem<?>> r42, final com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingUIState r43, final com.animaconnected.watch.workout.HealthOnboardingState r44, final boolean r45, final java.lang.String r46, final com.animaconnected.watch.theme.ChartTheme r47, final kotlin.jvm.functions.Function1<? super com.animaconnected.secondo.screens.workout.dashboard.ClickEvent, kotlin.Unit> r48, androidx.compose.runtime.Composer r49, final int r50) {
        /*
            Method dump skipped, instructions count: 1665
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt.HealthDashboardScreen(com.animaconnected.secondo.screens.workout.dashboard.GoalData, com.animaconnected.widget.SessionCardData, java.util.List, com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingUIState, com.animaconnected.watch.workout.HealthOnboardingState, boolean, java.lang.String, com.animaconnected.watch.theme.ChartTheme, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BarEntry HealthDashboardScreen$lambda$0(State<BarEntry> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BarEntry HealthDashboardScreen$lambda$1(State<BarEntry> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BarEntry HealthDashboardScreen$lambda$2(State<BarEntry> state) {
        return state.getValue();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$HealthTopBar$2, kotlin.jvm.internal.Lambda] */
    public static final void HealthTopBar(final boolean z, final boolean z2, final Function1<? super Float, Unit> onHeightMeasured, final Function0<Unit> onBackClick, final Function0<Unit> onHealthSettingsClick, Composer composer, final int r15) {
        int r0;
        boolean z3;
        int r1;
        int r12;
        int r13;
        int r14;
        int r02;
        Intrinsics.checkNotNullParameter(onHeightMeasured, "onHeightMeasured");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onHealthSettingsClick, "onHealthSettingsClick");
        ComposerImpl startRestartGroup = composer.startRestartGroup(32627010);
        if ((r15 & 14) == 0) {
            if (startRestartGroup.changed(z)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r15;
        } else {
            r0 = r15;
        }
        if ((r15 & 112) == 0) {
            if (startRestartGroup.changed(z2)) {
                r14 = 32;
            } else {
                r14 = 16;
            }
            r0 |= r14;
        }
        if ((r15 & 896) == 0) {
            if (startRestartGroup.changedInstance(onHeightMeasured)) {
                r13 = 256;
            } else {
                r13 = 128;
            }
            r0 |= r13;
        }
        if ((r15 & 7168) == 0) {
            if (startRestartGroup.changedInstance(onBackClick)) {
                r12 = 2048;
            } else {
                r12 = 1024;
            }
            r0 |= r12;
        }
        if ((57344 & r15) == 0) {
            if (startRestartGroup.changedInstance(onHealthSettingsClick)) {
                r1 = DfuBaseService.ERROR_CONNECTION_MASK;
            } else {
                r1 = DfuBaseService.ERROR_REMOTE_MASK;
            }
            r0 |= r1;
        }
        if ((46811 & r0) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            startRestartGroup.startReplaceableGroup(1480252653);
            if ((r0 & 896) == 256) {
                z3 = true;
            } else {
                z3 = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z3 || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function1<LayoutCoordinates, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$HealthTopBar$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates layoutCoordinates) {
                        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                        onHeightMeasured.invoke(Float.valueOf(IntSize.m593getHeightimpl(layoutCoordinates.mo423getSizeYbymL2g())));
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            TopbarKt.TopBar(OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) nextSlot), R.drawable.ic_chevron_left, onBackClick, URLProtocolKt.stringResource(R.string.health_top_title, startRestartGroup), ComposableLambdaKt.composableLambda(startRestartGroup, 499287964, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$HealthTopBar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                    invoke(boxScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxScope TopBar, Composer composer2, int r132) {
                    Intrinsics.checkNotNullParameter(TopBar, "$this$TopBar");
                    if ((r132 & 14) == 0) {
                        r132 |= composer2.changed(TopBar) ? 4 : 2;
                    }
                    if ((r132 & 91) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    if (z) {
                        IconButtonKt.IconButton(onHealthSettingsClick, null, false, null, ComposableSingletons$HealthDashboardScreenKt.INSTANCE.m1014getLambda1$secondo_kronabyRelease(), composer2, 24576, 14);
                        if (z2) {
                            float f = 16;
                            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_badge_setup, composer2), DetailBottomDialog.keyBadge, SizeKt.m91size3ABfNKs(PaddingKt.m75paddingqDBjuR0$default(TopBar.align(Modifier.Companion.$$INSTANCE, Alignment.Companion.Center), f, 0.0f, 0.0f, f, 6), 24), null, null, 0.0f, null, composer2, 56, 120);
                        }
                    }
                }
            }), startRestartGroup, ((r0 >> 3) & 896) | 24624, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$HealthTopBar$3
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

                public final void invoke(Composer composer2, int r9) {
                    HealthDashboardScreenKt.HealthTopBar(z, z2, onHeightMeasured, onBackClick, onHealthSettingsClick, composer2, Strings.updateChangedFlags(r15 | 1));
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$LastSynced$1, kotlin.jvm.internal.Lambda] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LastSynced(final java.lang.String r15, final boolean r16, androidx.compose.ui.Modifier r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            r1 = r15
            r4 = r19
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -256825947(0xfffffffff0b125a5, float:-4.3859485E29)
            r2 = r18
            androidx.compose.runtime.ComposerImpl r0 = r2.startRestartGroup(r0)
            r2 = r20 & 1
            if (r2 == 0) goto L18
            r2 = r4 | 6
            goto L28
        L18:
            r2 = r4 & 14
            if (r2 != 0) goto L27
            boolean r2 = r0.changed(r15)
            if (r2 == 0) goto L24
            r2 = 4
            goto L25
        L24:
            r2 = 2
        L25:
            r2 = r2 | r4
            goto L28
        L27:
            r2 = r4
        L28:
            r3 = r20 & 2
            if (r3 == 0) goto L2f
            r2 = r2 | 48
            goto L42
        L2f:
            r3 = r4 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L42
            r3 = r16
            boolean r5 = r0.changed(r3)
            if (r5 == 0) goto L3e
            r5 = 32
            goto L40
        L3e:
            r5 = 16
        L40:
            r2 = r2 | r5
            goto L44
        L42:
            r3 = r16
        L44:
            r5 = r20 & 4
            if (r5 == 0) goto L4b
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L5e
        L4b:
            r6 = r4 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L5e
            r6 = r17
            boolean r7 = r0.changed(r6)
            if (r7 == 0) goto L5a
            r7 = 256(0x100, float:3.59E-43)
            goto L5c
        L5a:
            r7 = 128(0x80, float:1.8E-43)
        L5c:
            r2 = r2 | r7
            goto L60
        L5e:
            r6 = r17
        L60:
            r7 = r2 & 731(0x2db, float:1.024E-42)
            r8 = 146(0x92, float:2.05E-43)
            if (r7 != r8) goto L72
            boolean r7 = r0.getSkipping()
            if (r7 != 0) goto L6d
            goto L72
        L6d:
            r0.skipToGroupEnd()
            r14 = r6
            goto L9e
        L72:
            if (r5 == 0) goto L78
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion.$$INSTANCE
            r14 = r5
            goto L79
        L78:
            r14 = r6
        L79:
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r5 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            r7 = 0
            r8 = 0
            r9 = 0
            com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$LastSynced$1 r5 = new com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$LastSynced$1
            r5.<init>()
            r6 = -1277649971(0xffffffffb3d89bcd, float:-1.0086624E-7)
            androidx.compose.runtime.internal.ComposableLambdaImpl r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r6, r5)
            int r2 = r2 >> 3
            r5 = r2 & 14
            r6 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 | r6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r12 = r5 | r2
            r13 = 28
            r5 = r16
            r6 = r14
            r11 = r0
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(r5, r6, r7, r8, r9, r10, r11, r12, r13)
        L9e:
            androidx.compose.runtime.RecomposeScopeImpl r6 = r0.endRestartGroup()
            if (r6 == 0) goto Lb4
            com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$LastSynced$2 r7 = new com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$LastSynced$2
            r0 = r7
            r1 = r15
            r2 = r16
            r3 = r14
            r4 = r19
            r5 = r20
            r0.<init>()
            r6.block = r7
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt.LastSynced(java.lang.String, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$MetricCard$3, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, androidx.compose.ui.geometry.Rect] */
    public static final void MetricCard(Modifier modifier, final MetricListItem<?> metric, final Function1<? super Rect, Unit> onClick, Composer composer, final int r14, final int r15) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1476728382);
        int r0 = r15 & 1;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r0 != 0) {
            modifier = companion;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        startRestartGroup.startReplaceableGroup(432525213);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        ref$ObjectRef.element = (Rect) nextSlot;
        startRestartGroup.startReplaceableGroup(432525279);
        Object nextSlot2 = startRestartGroup.nextSlot();
        if (nextSlot2 == composer$Companion$Empty$1) {
            nextSlot2 = RelativeDateTimeFormatter.getInstance();
            startRestartGroup.updateValue(nextSlot2);
        }
        final RelativeDateTimeFormatter relativeDateTimeFormatter = (RelativeDateTimeFormatter) nextSlot2;
        startRestartGroup.end(false);
        BackgroundCardKt.m1587BackgroundCardNinePatchY3c_0f4(R.drawable.app_dropped, AspectRatioKt.aspectRatio$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, new Function1<LayoutCoordinates, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$MetricCard$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.compose.ui.geometry.Rect] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                ref$ObjectRef.element = LayoutCoordinatesKt.boundsInRoot(layoutCoordinates);
            }
        }), 1.15f), PaddingKt.m71padding3ABfNKs(companion, paddingInsideCard), null, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$MetricCard$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                onClick.invoke(ref$ObjectRef.element);
            }
        }, ComposableLambdaKt.composableLambda(startRestartGroup, -2073440038, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$MetricCard$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(Composer composer2, int r42) {
                String str;
                Instant instant;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal;
                HeartrateValue conditionalHeartrateValue;
                String num;
                if ((r42 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion2);
                Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
                MetricListItem<?> metricListItem = metric;
                RelativeDateTimeFormatter relativeDateTimeFormatter2 = relativeDateTimeFormatter;
                composer2.startReplaceableGroup(-483455358);
                BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$SpaceBetween$1, horizontal, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
                if (composer2.getApplier() instanceof Applier) {
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        composer2.useNode();
                    }
                    ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Updater.m228setimpl(composer2, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Updater.m228setimpl(composer2, currentCompositionLocalMap, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    modifierMaterializerOf.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                    composer2.startReplaceableGroup(2058660585);
                    String title = HealthDashboardScreenKt.title(metricListItem.getType(), composer2, 0);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = ColorsKt.LocalColors;
                    long m166getOnBackground0d7_KjU = ((Colors) composer2.consume(staticProvidableCompositionLocal2)).m166getOnBackground0d7_KjU();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = TypographyKt.LocalTypography;
                    TextKt.m216Text4IGK_g(title, null, m166getOnBackground0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 2, false, 2, 0, null, ((Typography) composer2.consume(staticProvidableCompositionLocal3)).h3, composer2, 0, 3120, 55290);
                    if (metricListItem instanceof StringMetricListItem) {
                        composer2.startReplaceableGroup(-841202420);
                        com.animaconnected.widget.theme.TypographyKt.m1636BigTextZHfKjFs(null, (String) FlowExtKt.collectAsStateWithLifecycle(((StringMetricListItem) metricListItem).getValueFlow(), "-", composer2, 56).getValue(), ((Colors) composer2.consume(staticProvidableCompositionLocal2)).m166getOnBackground0d7_KjU(), null, 2, 1, true, composer2, 1794048, 9);
                        composer2.endReplaceableGroup();
                    } else if (metricListItem instanceof HeartrateMetricListItem) {
                        composer2.startReplaceableGroup(-841201995);
                        MutableState collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(((HeartrateMetricListItem) metricListItem).getValueFlow(), null, composer2, 56);
                        Instant.Companion.getClass();
                        Instant instant2 = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
                        HeartrateMetricItem heartrateMetricItem = (HeartrateMetricItem) collectAsStateWithLifecycle.getValue();
                        Instant conditionalTimestamp = heartrateMetricItem != null ? heartrateMetricItem.conditionalTimestamp(instant2) : null;
                        composer2.startReplaceableGroup(-841201805);
                        if (conditionalTimestamp == null) {
                            instant = instant2;
                            str = "-";
                            staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                        } else {
                            String format = relativeDateTimeFormatter2.format(Duration.m1678getInWholeMinutesimpl(instant2.m1704minus5sfh64U(conditionalTimestamp)), RelativeDateTimeFormatter.Direction.LAST, RelativeDateTimeFormatter.RelativeUnit.MINUTES);
                            if (((double) 1.0f) > 0.0d) {
                                LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                                companion2.then(layoutWeightElement);
                                composer2.startReplaceableGroup(-483455358);
                                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, composer2);
                                composer2.startReplaceableGroup(-1323940314);
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                                PersistentCompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(layoutWeightElement);
                                if (composer2.getApplier() instanceof Applier) {
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(layoutNode$Companion$Constructor$1);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Updater.m228setimpl(composer2, columnMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                                    Updater.m228setimpl(composer2, currentCompositionLocalMap2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer2, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                                    }
                                    modifierMaterializerOf2.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    Intrinsics.checkNotNull(format);
                                    str = "-";
                                    instant = instant2;
                                    staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                                    TextKt.m216Text4IGK_g(format, null, ((Colors) composer2.consume(staticProvidableCompositionLocal2)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 2, false, 2, 0, null, ((Typography) composer2.consume(staticProvidableCompositionLocal3)).caption, composer2, 0, 3120, 55290);
                                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                                } else {
                                    ComposablesKt.invalidApplier();
                                    throw null;
                                }
                            } else {
                                throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
                            }
                        }
                        composer2.endReplaceableGroup();
                        HeartrateMetricItem heartrateMetricItem2 = (HeartrateMetricItem) collectAsStateWithLifecycle.getValue();
                        com.animaconnected.widget.theme.TypographyKt.m1636BigTextZHfKjFs(null, (heartrateMetricItem2 == null || (conditionalHeartrateValue = heartrateMetricItem2.conditionalHeartrateValue(instant)) == null || (num = Integer.valueOf(conditionalHeartrateValue.getHeartrate()).toString()) == null) ? str : num, ((Colors) composer2.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), null, 2, 1, true, composer2, 1794048, 9);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(-841200618);
                        composer2.endReplaceableGroup();
                    }
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, 196998, 8);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$MetricCard$4
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
                    HealthDashboardScreenKt.MetricCard(Modifier.this, metric, onClick, composer2, Strings.updateChangedFlags(r14 | 1), r15);
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$MetricSection$1, kotlin.jvm.internal.Lambda] */
    public static final void MetricSection(final List<? extends MetricListItem<?>> metrics, final Function2<? super Rect, ? super WorkoutMetricType, Unit> onClick, Modifier modifier, Composer composer, final int r14, final int r15) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-309668977);
        if ((r15 & 4) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        VerticalGridKt.m1635VerticalGrid1yyLQnY(modifier, metrics, 0.0f, 0.0f, 0, ComposableLambdaKt.composableLambda(startRestartGroup, -1431488484, new Function3<MetricListItem<?>, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$MetricSection$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(MetricListItem<?> metricListItem, Composer composer2, Integer num) {
                invoke(metricListItem, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final MetricListItem<?> metric, Composer composer2, int r10) {
                Intrinsics.checkNotNullParameter(metric, "metric");
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Modifier fillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                final Function2<Rect, WorkoutMetricType, Unit> function2 = onClick;
                HealthDashboardScreenKt.MetricCard(fillMaxWidth, metric, new Function1<Rect, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$MetricSection$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                        invoke2(rect);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Rect cardBounds) {
                        Intrinsics.checkNotNullParameter(cardBounds, "cardBounds");
                        function2.invoke(cardBounds, metric.getType());
                    }
                }, composer2, 70, 0);
            }
        }), startRestartGroup, ((r14 >> 6) & 14) | 196672, 28);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$MetricSection$2
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
                    HealthDashboardScreenKt.MetricSection(metrics, onClick, modifier2, composer2, Strings.updateChangedFlags(r14 | 1), r15);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewDailyGoals(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1074350176);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableSingletons$HealthDashboardScreenKt.INSTANCE.m1016getLambda3$secondo_kronabyRelease(), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$PreviewDailyGoals$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    HealthDashboardScreenKt.PreviewDailyGoals(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewHealthDashBoard(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-974568221);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableSingletons$HealthDashboardScreenKt.INSTANCE.m1015getLambda2$secondo_kronabyRelease(), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$PreviewHealthDashBoard$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    HealthDashboardScreenKt.PreviewHealthDashBoard(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SectionTitle(final java.lang.String r31, androidx.compose.ui.Modifier r32, final boolean r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt.SectionTitle(java.lang.String, androidx.compose.ui.Modifier, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float SectionTitle$lambda$32(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void WorkoutSection(final com.animaconnected.widget.SessionCardData r21, final kotlin.jvm.functions.Function0<kotlin.Unit> r22, final kotlin.jvm.functions.Function2<? super java.lang.Long, ? super androidx.compose.ui.geometry.Rect, kotlin.Unit> r23, androidx.compose.ui.Modifier r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt.WorkoutSection(com.animaconnected.widget.SessionCardData, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final String title(WorkoutMetricType workoutMetricType, Composer composer, int r2) {
        String stringResource;
        Intrinsics.checkNotNullParameter(workoutMetricType, "<this>");
        composer.startReplaceableGroup(647752401);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        int r0 = WhenMappings.$EnumSwitchMapping$0[workoutMetricType.ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 != 4) {
                        if (r0 == 5) {
                            composer.startReplaceableGroup(248635597);
                            stringResource = URLProtocolKt.stringResource(R.string.health_measurement_sleep_title, composer);
                            composer.endReplaceableGroup();
                        } else {
                            composer.startReplaceableGroup(248616020);
                            composer.endReplaceableGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        composer.startReplaceableGroup(248635527);
                        stringResource = URLProtocolKt.stringResource(R.string.fitness_index_vo2max_title, composer);
                        composer.endReplaceableGroup();
                    }
                } else {
                    composer.startReplaceableGroup(248635449);
                    stringResource = URLProtocolKt.stringResource(R.string.health_measurement_calories_title, composer);
                    composer.endReplaceableGroup();
                }
            } else {
                composer.startReplaceableGroup(248635367);
                stringResource = URLProtocolKt.stringResource(R.string.health_measurement_heart_rate_title, composer);
                composer.endReplaceableGroup();
            }
        } else {
            composer.startReplaceableGroup(248635289);
            stringResource = URLProtocolKt.stringResource(R.string.health_measurement_steps_title, composer);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return stringResource;
    }
}
