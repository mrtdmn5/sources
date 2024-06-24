package com.animaconnected.secondo.screens.workout.dailygoal;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.DpCornerSize;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.Shapes;
import androidx.compose.material.ShapesKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.animaconnected.secondo.screens.workout.WorkoutDetailComposeWidgetsKt;
import com.animaconnected.secondo.screens.workout.utils.ChartMitmapsKt;
import com.animaconnected.secondo.widget.compose.ChartsKt;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.graphs.BarChartSize;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.workout.DailyGoalsProgressItem;
import com.animaconnected.widget.BackgroundCardKt;
import com.animaconnected.widget.ModifiersKt;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.TopbarKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDailyGoalDetailFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutDailyGoalDetailFragmentKt {
    private static final DailyGoalsProgressItem emptyProgress = new DailyGoalsProgressItem("", new BarEntry(0, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null), new BarEntry(0, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null), new BarEntry(0, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null), false, false, false);

    public static final void AboutSection(Modifier modifier, Composer composer, final int r22, final int r23) {
        final Modifier modifier2;
        int r6;
        int r62;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1353606096);
        int r3 = r23 & 1;
        if (r3 != 0) {
            r6 = r22 | 6;
            modifier2 = modifier;
        } else if ((r22 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r62 = 4;
            } else {
                r62 = 2;
            }
            r6 = r62 | r22;
        } else {
            modifier2 = modifier;
            r6 = r22;
        }
        if ((r6 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (r3 != 0) {
                modifier2 = companion;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            float f = 8;
            Modifier m73paddingVpY3zN4$default = PaddingKt.m73paddingVpY3zN4$default(modifier2, f, 0.0f, 2);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m73paddingVpY3zN4$default);
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
                WorkoutDetailComposeWidgetsKt.AboutTitle(URLProtocolKt.stringResource(R.string.health_daily_goal_top_title, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f, 7), startRestartGroup, 48, 0);
                float f2 = 40;
                WorkoutDetailComposeWidgetsKt.AboutDescription(URLProtocolKt.stringResource(R.string.health_daily_goal_about_section_one_text, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f2, 7), startRestartGroup, 48, 0);
                WorkoutDetailComposeWidgetsKt.AboutTitle(URLProtocolKt.stringResource(R.string.health_daily_goal_about_section_two_title, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f, 7), startRestartGroup, 48, 0);
                WorkoutDetailComposeWidgetsKt.AboutDescription(URLProtocolKt.stringResource(R.string.health_daily_goal_about_section_two_text, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f2, 7), startRestartGroup, 48, 0);
                WorkoutDetailComposeWidgetsKt.AboutTitle(URLProtocolKt.stringResource(R.string.health_daily_goal_about_section_three_title, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f, 7), startRestartGroup, 48, 0);
                WorkoutDetailComposeWidgetsKt.AboutDescription(URLProtocolKt.stringResource(R.string.health_daily_goal_about_section_three_text, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f2, 7), startRestartGroup, 48, 0);
                WorkoutDetailComposeWidgetsKt.AboutTitle(URLProtocolKt.stringResource(R.string.health_daily_goal_about_section_four_title, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f, 7), startRestartGroup, 48, 0);
                WorkoutDetailComposeWidgetsKt.AboutDescription(URLProtocolKt.stringResource(R.string.health_daily_goal_about_section_four_text, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 56, 7), startRestartGroup, 48, 0);
                startRestartGroup.end(false);
                startRestartGroup.end(true);
                startRestartGroup.end(false);
                startRestartGroup.end(false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$AboutSection$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r4) {
                    WorkoutDailyGoalDetailFragmentKt.AboutSection(Modifier.this, composer2, Strings.updateChangedFlags(r22 | 1), r23);
                }
            };
        }
    }

    public static final void DailyGoalsDetailScreen(Modifier modifier, final DailyGoalsProgressItem dailyGoalsProgressItem, final HealthGoals healthGoals, final List<DailyGoalsProgressItem> list, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int r28, final int r29) {
        final Modifier modifier2;
        CornerBasedShape copy;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1655875301);
        int r1 = r29 & 1;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        long m174getSurface0d7_KjU = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU();
        float f = 0;
        copy = r6.copy(r6.topStart, ((Shapes) startRestartGroup.consume(ShapesKt.LocalShapes)).large.topEnd, new DpCornerSize(f), new DpCornerSize(f));
        Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(modifier2, m174getSurface0d7_KjU, copy);
        startRestartGroup.startReplaceableGroup(-483455358);
        Arrangement$Top$1 arrangement$Top$1 = Arrangement.Top;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
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
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            float f2 = 8;
            Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, f2, f2, f2, 0.0f, 8);
            String stringResource = URLProtocolKt.stringResource(R.string.health_top_title, startRestartGroup);
            startRestartGroup.startReplaceableGroup(1355160474);
            boolean z = true;
            if ((((57344 & r28) ^ 24576) <= 16384 || !startRestartGroup.changedInstance(function0)) && (r28 & 24576) != 16384) {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$DailyGoalsDetailScreen$1$1$1
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
                        function0.invoke();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            TopbarKt.TopBar(m75paddingqDBjuR0$default, R.drawable.ic_close, (Function0) nextSlot, stringResource, null, startRestartGroup, 54, 16);
            float f3 = 24;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m73paddingVpY3zN4$default(ModifiersKt.m1615fadingEdgeTop3ABfNKs$default(companion, 0.0f, 1, null), f3, 0.0f, 2), ScrollKt.rememberScrollState(startRestartGroup), false, 14);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(verticalScroll$default);
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, columnMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                ScreenTitleKt.ScreenTitle(PaddingKt.m73paddingVpY3zN4$default(companion, 0.0f, f3, 1), URLProtocolKt.stringResource(R.string.health_daily_goal_top_title, startRestartGroup), startRestartGroup, 6, 0);
                TodaySection(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 48, 7), dailyGoalsProgressItem, healthGoals, startRestartGroup, 582, 0);
                HistorySection(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 40, 7), list, healthGoals, function02, startRestartGroup, ((r28 >> 6) & 7168) | 582, 0);
                AboutSection(null, startRestartGroup, 0, 1);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                if (m != null) {
                    m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$DailyGoalsDetailScreen$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int r11) {
                            WorkoutDailyGoalDetailFragmentKt.DailyGoalsDetailScreen(Modifier.this, dailyGoalsProgressItem, healthGoals, list, function0, function02, composer2, Strings.updateChangedFlags(r28 | 1), r29);
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

    public static final void HistoryRow(final DailyGoalsProgressItem dailyGoalsProgressItem, final HealthGoals healthGoals, Modifier modifier, Composer composer, final int r40, final int r41) {
        Modifier modifier2;
        float f;
        Modifier fillMaxWidth;
        long Color;
        Modifier fillMaxWidth2;
        Modifier fillMaxWidth3;
        Modifier fillMaxWidth4;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-740178503);
        int r2 = r41 & 4;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r2 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (!dailyGoalsProgressItem.getStepGoalsCompleted() && !dailyGoalsProgressItem.getStandGoalsCompleted() && !dailyGoalsProgressItem.getExerciseGoalsCompleted()) {
            f = 0.5f;
        } else {
            f = 1.0f;
        }
        float f2 = f;
        fillMaxWidth = SizeKt.fillMaxWidth(modifier2, 1.0f);
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth);
        Applier<?> applier = startRestartGroup.applier;
        if (applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
            ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$1);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            String title = dailyGoalsProgressItem.getTitle();
            Modifier m95widthInVpY3zN4$default = SizeKt.m95widthInVpY3zN4$default(companion, 24, 0.0f, 2);
            Color = ColorKt.Color(Color.m322getRedimpl(r8), Color.m321getGreenimpl(r8), Color.m319getBlueimpl(r8), f2, Color.m320getColorSpaceimpl(((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU()));
            TextKt.m216Text4IGK_g(title, m95widthInVpY3zN4$default, Color, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h4, startRestartGroup, 48, 0, 65528);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                float f3 = 2;
                float f4 = 12;
                fillMaxWidth2 = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f3, 7), f4), 1.0f);
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(fillMaxWidth2, new Function1<GraphicsLayerScope, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$HistoryRow$1$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer2) {
                        Intrinsics.checkNotNullParameter(graphicsLayer2, "$this$graphicsLayer");
                        graphicsLayer2.setAlpha(DailyGoalsProgressItem.this.getStepGoalsCompleted() ? 1.0f : 0.5f);
                    }
                });
                int steps = healthGoals.getSteps();
                BarChartSize barChartSize = BarChartSize.Medium;
                ChartsKt.HorizontalGoalChart(new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$HistoryRow$1$1$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final BarEntry invoke() {
                        return DailyGoalsProgressItem.this.getStepsEntry();
                    }
                }, steps, false, barChartSize, graphicsLayer, null, false, null, null, startRestartGroup, 3456, 480);
                fillMaxWidth3 = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f3, 7), f4), 1.0f);
                ChartsKt.SegmentedGoalChart(new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$HistoryRow$1$1$4
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final BarEntry invoke() {
                        return DailyGoalsProgressItem.this.getStandEntry();
                    }
                }, healthGoals.getStand(), false, barChartSize, GraphicsLayerModifierKt.graphicsLayer(fillMaxWidth3, new Function1<GraphicsLayerScope, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$HistoryRow$1$1$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer2) {
                        Intrinsics.checkNotNullParameter(graphicsLayer2, "$this$graphicsLayer");
                        graphicsLayer2.setAlpha(DailyGoalsProgressItem.this.getStandGoalsCompleted() ? 1.0f : 0.5f);
                    }
                }), null, true, false, null, null, startRestartGroup, 1576320, 928);
                fillMaxWidth4 = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(companion, f4), 1.0f);
                ChartsKt.HorizontalGoalChart(new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$HistoryRow$1$1$6
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final BarEntry invoke() {
                        return DailyGoalsProgressItem.this.getExerciseEntry();
                    }
                }, healthGoals.getExercise(), false, barChartSize, GraphicsLayerModifierKt.graphicsLayer(fillMaxWidth4, new Function1<GraphicsLayerScope, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$HistoryRow$1$1$5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer2) {
                        Intrinsics.checkNotNullParameter(graphicsLayer2, "$this$graphicsLayer");
                        graphicsLayer2.setAlpha(DailyGoalsProgressItem.this.getExerciseGoalsCompleted() ? 1.0f : 0.5f);
                    }
                }), null, false, null, null, startRestartGroup, 3456, 480);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                if (m != null) {
                    final Modifier modifier3 = modifier2;
                    m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$HistoryRow$2
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
                            WorkoutDailyGoalDetailFragmentKt.HistoryRow(DailyGoalsProgressItem.this, healthGoals, modifier3, composer2, Strings.updateChangedFlags(r40 | 1), r41);
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

    /* JADX WARN: Type inference failed for: r6v4, types: [com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$HistorySection$1$1, kotlin.jvm.internal.Lambda] */
    public static final void HistorySection(Modifier modifier, final List<DailyGoalsProgressItem> list, final HealthGoals healthGoals, final Function0<Unit> function0, Composer composer, final int r32, final int r33) {
        Modifier modifier2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1756379675);
        int r1 = r33 & 1;
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
        int r12 = (((((r32 & 14) << 3) & 112) << 9) & 7168) | 6;
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
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r12 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            float f = 8;
            TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.health_lastweek_graph_title, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, f, 0.0f, 0.0f, f, 6), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h2, startRestartGroup, 48, 0, 65528);
            BackgroundCardKt.m1587BackgroundCardNinePatchY3c_0f4(R.drawable.graph_background, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1801326599, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$HistorySection$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r21) {
                    if ((r21 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                    float f2 = 8;
                    float f3 = 16;
                    Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion2, 1.0f), f2, f3, f2, 0.0f, 8);
                    List<DailyGoalsProgressItem> list2 = list;
                    Function0<Unit> function02 = function0;
                    HealthGoals healthGoals2 = healthGoals;
                    composer2.startReplaceableGroup(-483455358);
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                    composer2.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                    PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
                    ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
                    if (composer2.getApplier() instanceof Applier) {
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(layoutNode$Companion$Constructor$12);
                        } else {
                            composer2.useNode();
                        }
                        Updater.m228setimpl(composer2, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                        Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer2, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$12);
                        }
                        int r3 = 0;
                        modifierMaterializerOf2.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(664749000);
                        int r13 = 0;
                        for (Object obj : list2) {
                            int r18 = r13 + 1;
                            if (r13 >= 0) {
                                WorkoutDailyGoalDetailFragmentKt.HistoryRow((DailyGoalsProgressItem) obj, healthGoals2, PaddingKt.m75paddingqDBjuR0$default(companion2, 0.0f, 0.0f, 0.0f, r13 == CollectionsKt__CollectionsKt.getLastIndex(list2) ? r3 : 12, 7), composer2, 72, 0);
                                healthGoals2 = healthGoals2;
                                list2 = list2;
                                r3 = r3;
                                function02 = function02;
                                r13 = r18;
                            } else {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                throw null;
                            }
                        }
                        final Function0<Unit> function03 = function02;
                        composer2.endReplaceableGroup();
                        Modifier m75paddingqDBjuR0$default2 = PaddingKt.m75paddingqDBjuR0$default(companion2, f3, f3, f3, 0.0f, 8);
                        composer2.startReplaceableGroup(664749368);
                        boolean changedInstance = composer2.changedInstance(function03);
                        Object rememberedValue = composer2.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.Empty) {
                            rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$HistorySection$1$1$1$2$1
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
                                    function03.invoke();
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        WorkoutDetailComposeWidgetsKt.History(m75paddingqDBjuR0$default2, null, (Function0) rememberedValue, composer2, 6, 2);
                        DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                        return;
                    }
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }), startRestartGroup, 196614, 30);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                final Modifier modifier3 = modifier2;
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$HistorySection$2
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
                        WorkoutDailyGoalDetailFragmentKt.HistorySection(Modifier.this, list, healthGoals, function0, composer2, Strings.updateChangedFlags(r32 | 1), r33);
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Metric(final java.lang.String r59, final int r60, final int r61, androidx.compose.ui.Modifier r62, androidx.compose.runtime.Composer r63, final int r64, final int r65) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt.Metric(java.lang.String, int, int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void TodaySection(Modifier modifier, final DailyGoalsProgressItem dailyGoalsProgressItem, final HealthGoals healthGoals, Composer composer, final int r28, final int r29) {
        final Modifier modifier2;
        Modifier fillMaxWidth;
        Modifier fillMaxWidth2;
        Modifier fillMaxWidth3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1034378773);
        int r1 = r29 & 1;
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
        int r3 = (((((r28 & 14) << 3) & 112) << 9) & 7168) | 6;
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
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r3 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            float f = 8;
            float f2 = 4;
            Metric(URLProtocolKt.stringResource(R.string.health_daily_goal_move_title, startRestartGroup), dailyGoalsProgressItem.getStepsEntry().getValue(), healthGoals.getSteps(), PaddingKt.m75paddingqDBjuR0$default(companion, f, 0.0f, f, f2, 2), startRestartGroup, 3072, 0);
            float f3 = 40;
            float f4 = 32;
            fillMaxWidth = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f3, 7), f4), 1.0f);
            int steps = healthGoals.getSteps();
            BarChartSize barChartSize = BarChartSize.Large;
            ChartsKt.HorizontalGoalChart(new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$TodaySection$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BarEntry invoke() {
                    return DailyGoalsProgressItem.this.getStepsEntry();
                }
            }, steps, false, barChartSize, fillMaxWidth, ChartMitmapsKt.getNinePatchProgressBackground(), false, null, null, startRestartGroup, 290176, 448);
            Metric(URLProtocolKt.stringResource(R.string.health_daily_goal_stand_title, startRestartGroup), dailyGoalsProgressItem.getStandEntry().getValue(), healthGoals.getStand(), PaddingKt.m75paddingqDBjuR0$default(companion, f, 0.0f, f, f2, 2), startRestartGroup, 3072, 0);
            fillMaxWidth2 = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f3, 7), f4), 1.0f);
            ChartsKt.SegmentedGoalChart(new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$TodaySection$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BarEntry invoke() {
                    return DailyGoalsProgressItem.this.getStandEntry();
                }
            }, healthGoals.getStand(), false, barChartSize, fillMaxWidth2, ChartMitmapsKt.getNinePatchProgressBackground(), true, false, null, null, startRestartGroup, 1863040, 896);
            Metric(URLProtocolKt.stringResource(R.string.health_daily_goal_exercise_title, startRestartGroup), dailyGoalsProgressItem.getExerciseEntry().getValue(), healthGoals.getExercise(), PaddingKt.m75paddingqDBjuR0$default(companion, f, 0.0f, f, f2, 2), startRestartGroup, 3072, 0);
            fillMaxWidth3 = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(companion, f4), 1.0f);
            ChartsKt.HorizontalGoalChart(new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$TodaySection$1$3
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BarEntry invoke() {
                    return DailyGoalsProgressItem.this.getExerciseEntry();
                }
            }, healthGoals.getExercise(), false, barChartSize, fillMaxWidth3, ChartMitmapsKt.getNinePatchProgressBackground(), false, null, null, startRestartGroup, 290176, 448);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragmentKt$TodaySection$2
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
                        WorkoutDailyGoalDetailFragmentKt.TodaySection(Modifier.this, dailyGoalsProgressItem, healthGoals, composer2, Strings.updateChangedFlags(r28 | 1), r29);
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final /* synthetic */ void access$DailyGoalsDetailScreen(Modifier modifier, DailyGoalsProgressItem dailyGoalsProgressItem, HealthGoals healthGoals, List list, Function0 function0, Function0 function02, Composer composer, int r7, int r8) {
        DailyGoalsDetailScreen(modifier, dailyGoalsProgressItem, healthGoals, list, function0, function02, composer, r7, r8);
    }

    public static final /* synthetic */ DailyGoalsProgressItem access$getEmptyProgress$p() {
        return emptyProgress;
    }
}
