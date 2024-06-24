package com.animaconnected.secondo.screens.workout.dailygoal;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.animaconnected.secondo.widget.compose.ChartsKt;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.graphs.BarChartSize;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.workout.DailyGoalSummary;
import com.animaconnected.watch.workout.DailyGoalsProgressItem;
import com.animaconnected.watch.workout.DailyGoalsProgressSection;
import com.animaconnected.widget.LoadingIndicatorKt;
import com.animaconnected.widget.ModifiersKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDailyGoalHistoryFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutDailyGoalHistoryFragmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void DailyGoalHistoryScreen(final List<DailyGoalsProgressSection> list, final HealthGoals healthGoals, final Function0<Unit> function0, Composer composer, final int r21) {
        boolean z;
        boolean z2;
        boolean z3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(593305416);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(companion, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU(), RectangleShapeKt.RectangleShape);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
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
            String stringResource = URLProtocolKt.stringResource(R.string.health_top_title, startRestartGroup);
            startRestartGroup.startReplaceableGroup(1950272254);
            if ((((r21 & 896) ^ 384) > 256 && startRestartGroup.changedInstance(function0)) || (r21 & 384) == 256) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$DailyGoalHistoryScreen$1$1$1
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
            TopbarKt.TopBar(null, R.drawable.ic_chevron_left, (Function0) nextSlot, stringResource, null, startRestartGroup, 48, 17);
            if (!list.isEmpty()) {
                startRestartGroup.startReplaceableGroup(1950272319);
                LazyDslKt.LazyColumn(PaddingKt.m71padding3ABfNKs(ModifiersKt.m1615fadingEdgeTop3ABfNKs$default(companion, 0.0f, 1, null), 16), null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$DailyGoalHistoryScreen$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                        invoke2(lazyListScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference failed for: r3v0, types: [com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$DailyGoalHistoryScreen$1$2$1$1, kotlin.jvm.internal.Lambda] */
                    /* JADX WARN: Type inference failed for: r8v0, types: [com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$DailyGoalHistoryScreen$1$2$invoke$lambda$1$$inlined$itemsIndexed$default$3, kotlin.jvm.internal.Lambda] */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LazyListScope LazyColumn) {
                        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                        List<DailyGoalsProgressSection> list2 = list;
                        final HealthGoals healthGoals2 = healthGoals;
                        for (final DailyGoalsProgressSection dailyGoalsProgressSection : list2) {
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(321402983, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$DailyGoalHistoryScreen$1$2$1$1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r9) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r9 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                        WorkoutDailyGoalHistoryFragmentKt.Summary(DailyGoalsProgressSection.this.getHeader(), PaddingKt.m75paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 0.0f, 0.0f, 0.0f, 16, 7), composer2, 56, 0);
                                    }
                                }
                            }, true));
                            final List<DailyGoalsProgressItem> items = dailyGoalsProgressSection.getItems();
                            LazyColumn.items(items.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$DailyGoalHistoryScreen$1$2$invoke$lambda$1$$inlined$itemsIndexed$default$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                    return invoke(num.intValue());
                                }

                                public final Object invoke(int r2) {
                                    items.get(r2);
                                    return null;
                                }
                            }, ComposableLambdaKt.composableLambdaInstance(-1091073711, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$DailyGoalHistoryScreen$1$2$invoke$lambda$1$$inlined$itemsIndexed$default$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope items2, int r10, Composer composer2, int r12) {
                                    int r9;
                                    Intrinsics.checkNotNullParameter(items2, "$this$items");
                                    if ((r12 & 14) == 0) {
                                        r9 = (composer2.changed(items2) ? 4 : 2) | r12;
                                    } else {
                                        r9 = r12;
                                    }
                                    if ((r12 & 112) == 0) {
                                        r9 |= composer2.changed(r10) ? 32 : 16;
                                    }
                                    if ((r9 & 731) == 146 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                        WorkoutDailyGoalHistoryFragmentKt.HistoryItem(PaddingKt.m75paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 0.0f, 0.0f, 0.0f, r10 == CollectionsKt__CollectionsKt.getLastIndex(dailyGoalsProgressSection.getItems()) ? 40 : 12, 7), (DailyGoalsProgressItem) items.get(r10), healthGoals2, composer2, 576, 0);
                                    }
                                }
                            }, true));
                        }
                    }
                }, startRestartGroup, 0, 254);
                z2 = false;
                startRestartGroup.end(false);
                z3 = true;
            } else {
                z2 = false;
                startRestartGroup.startReplaceableGroup(1950273170);
                z3 = true;
                LoadingIndicatorKt.CircularLoadingIndicator(null, startRestartGroup, 0, 1);
                startRestartGroup.end(false);
            }
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, z2, z3, z2, z2);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$DailyGoalHistoryScreen$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r5) {
                        WorkoutDailyGoalHistoryFragmentKt.DailyGoalHistoryScreen(list, healthGoals, function0, composer2, Strings.updateChangedFlags(r21 | 1));
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
    public static final void HistoryItem(Modifier modifier, final DailyGoalsProgressItem dailyGoalsProgressItem, final HealthGoals healthGoals, Composer composer, final int r41, final int r42) {
        Modifier modifier2;
        float f;
        long Color;
        Modifier fillMaxWidth;
        Modifier fillMaxWidth2;
        Modifier fillMaxWidth3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1635465861);
        int r1 = r42 & 1;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        float f2 = 1.0f;
        if (dailyGoalsProgressItem.getAllGoalsCompleted()) {
            f = 1.0f;
        } else {
            f = 0.7f;
        }
        if (!dailyGoalsProgressItem.getAllGoalsCompleted()) {
            f2 = 0.3f;
        }
        float f3 = f2;
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
        int r4 = ((((((r41 & 14) | 384) << 3) & 112) << 9) & 7168) | 6;
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
            modifierMaterializerOf.invoke(new SkippableUpdater(startRestartGroup), startRestartGroup, Integer.valueOf((r4 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            String title = dailyGoalsProgressItem.getTitle();
            Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 16, 0.0f, 11);
            Color = ColorKt.Color(Color.m322getRedimpl(r5), Color.m321getGreenimpl(r5), Color.m319getBlueimpl(r5), f, Color.m320getColorSpaceimpl(((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU()));
            final Modifier modifier3 = modifier2;
            TextKt.m216Text4IGK_g(title, m75paddingqDBjuR0$default, Color, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h4, startRestartGroup, 48, 0, 65528);
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
                float f4 = 2;
                float f5 = 4;
                fillMaxWidth = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f4, 7), f5), 1.0f);
                Modifier alpha = AlphaKt.alpha(fillMaxWidth, f3);
                int steps = healthGoals.getSteps();
                BarChartSize barChartSize = BarChartSize.Small;
                ChartsKt.HorizontalGoalChart(new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$HistoryItem$1$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final BarEntry invoke() {
                        return DailyGoalsProgressItem.this.getStepsEntry();
                    }
                }, steps, false, barChartSize, alpha, null, false, null, null, startRestartGroup, 3456, 480);
                fillMaxWidth2 = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f4, 7), f5), 1.0f);
                ChartsKt.SegmentedGoalChart(new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$HistoryItem$1$1$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final BarEntry invoke() {
                        return DailyGoalsProgressItem.this.getStandEntry();
                    }
                }, healthGoals.getStand(), false, barChartSize, AlphaKt.alpha(fillMaxWidth2, f3), null, false, false, null, null, startRestartGroup, 1576320, 928);
                fillMaxWidth3 = SizeKt.fillMaxWidth(SizeKt.m83height3ABfNKs(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f4, 7), f5), 1.0f);
                ChartsKt.HorizontalGoalChart(new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$HistoryItem$1$1$3
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final BarEntry invoke() {
                        return DailyGoalsProgressItem.this.getExerciseEntry();
                    }
                }, healthGoals.getExercise(), false, barChartSize, AlphaKt.alpha(fillMaxWidth3, f3), null, false, null, null, startRestartGroup, 3456, 480);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                if (m != null) {
                    m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$HistoryItem$2
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
                            WorkoutDailyGoalHistoryFragmentKt.HistoryItem(Modifier.this, dailyGoalsProgressItem, healthGoals, composer2, Strings.updateChangedFlags(r41 | 1), r42);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Summary(final DailyGoalSummary dailyGoalSummary, Modifier modifier, Composer composer, final int r32, final int r33) {
        Modifier modifier2;
        Modifier fillMaxWidth;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1629917735);
        int r3 = r33 & 2;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r3 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        fillMaxWidth = SizeKt.fillMaxWidth(modifier2, 1.0f);
        BiasAlignment.Horizontal horizontal = Alignment.Companion.End;
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth);
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
            modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            final Modifier modifier3 = modifier2;
            TextKt.m216Text4IGK_g(dailyGoalSummary.getTitle(), modifier2, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h2, startRestartGroup, r32 & 112, 0, 65528);
            float f = 8;
            SummaryBody(URLProtocolKt.stringResource(R.string.health_daily_goal_move_title, startRestartGroup), dailyGoalSummary.getMoveSummary() + " / " + dailyGoalSummary.getNbrOfDays(), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, f, 0.0f, 0.0f, 13), startRestartGroup, 384, 0);
            SummaryBody(URLProtocolKt.stringResource(R.string.health_daily_goal_stand_title, startRestartGroup), dailyGoalSummary.getStandSummary() + " / " + dailyGoalSummary.getNbrOfDays(), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, f, 0.0f, 0.0f, 13), startRestartGroup, 384, 0);
            SummaryBody(URLProtocolKt.stringResource(R.string.health_daily_goal_exercise_title, startRestartGroup), dailyGoalSummary.getExerciseSummary() + " / " + dailyGoalSummary.getNbrOfDays(), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, f, 0.0f, 0.0f, 13), startRestartGroup, 384, 0);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt$Summary$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r5) {
                        WorkoutDailyGoalHistoryFragmentKt.Summary(DailyGoalSummary.this, modifier3, composer2, Strings.updateChangedFlags(r32 | 1), r33);
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
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SummaryBody(final java.lang.String r58, final java.lang.String r59, androidx.compose.ui.Modifier r60, androidx.compose.runtime.Composer r61, final int r62, final int r63) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragmentKt.SummaryBody(java.lang.String, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
