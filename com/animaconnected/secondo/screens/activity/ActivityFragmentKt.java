package com.animaconnected.secondo.screens.activity;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.IconButtonKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.text.style.TextAlign;
import com.animaconnected.secondo.screens.activity.activityHistory.StepsHistoryGraph;
import com.animaconnected.watch.display.PascalDisplay;
import com.animaconnected.widget.LoadingIndicatorKt;
import com.animaconnected.widget.TopbarKt;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: ActivityFragment.kt */
/* loaded from: classes3.dex */
public final class ActivityFragmentKt {
    public static final void ActivityContent(final StepProgress stepProgress, final List<StepsHistoryGraph.GraphData> list, final boolean z, Composer composer, final int r20) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-384612023);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth(companion, 1.0f), ScrollKt.rememberScrollState(startRestartGroup), false, 14);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(verticalScroll$default);
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
            float f = 32;
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, f), startRestartGroup, 6);
            float f2 = 12;
            TitleDescription(PaddingKt.m73paddingVpY3zN4$default(companion, f2, 0.0f, 2), startRestartGroup, 6, 0);
            float f3 = 16;
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, f3), startRestartGroup, 6);
            CircularProgressView(stepProgress, z, PaddingKt.m73paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), f2, 0.0f, 2), startRestartGroup, (r20 & 14) | 384 | ((r20 >> 3) & 112), 0);
            StepsOverview(stepProgress.getProgress(), PaddingKt.m73paddingVpY3zN4$default(companion, f2, 0.0f, 2), startRestartGroup, 48, 0);
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 64), startRestartGroup, 6);
            HistoryTitle(PaddingKt.m73paddingVpY3zN4$default(companion, f2, 0.0f, 2), startRestartGroup, 6, 0);
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, f3), startRestartGroup, 6);
            LastSevenDayChart(list, stepProgress.getGoal(), z, PaddingKt.m73paddingVpY3zN4$default(companion, 8, 0.0f, 2), startRestartGroup, (r20 & 896) | 3080, 0);
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, f), startRestartGroup, 6);
            startRestartGroup.end(false);
            startRestartGroup.end(true);
            startRestartGroup.end(false);
            startRestartGroup.end(false);
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityContent$2
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
                        ActivityFragmentKt.ActivityContent(StepProgress.this, list, z, composer2, Strings.updateChangedFlags(r20 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final void ActivityStepsScreen(final StepProgress stepProgress, final List<StepsHistoryGraph.GraphData> list, final boolean z, final boolean z2, final boolean z3, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int r28) {
        float f;
        long m164getBackground0d7_KjU;
        boolean z4;
        boolean z5;
        long Color;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1180844767);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-2075712023);
        Object nextSlot = startRestartGroup.nextSlot();
        Object obj = Composer.Companion.Empty;
        if (nextSlot == obj) {
            nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.end(false);
        if (ActivityStepsScreen$lambda$1(mutableState)) {
            f = 0.32f;
        } else {
            f = 1.0f;
        }
        float f2 = f;
        TweenSpec tweenSpec = new TweenSpec(PascalDisplay.visibleWidth, 0, null, 6);
        startRestartGroup.startReplaceableGroup(-2075711746);
        Object nextSlot2 = startRestartGroup.nextSlot();
        if (nextSlot2 == obj) {
            nextSlot2 = new Function1<Float, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityStepsScreen$backgroundAlpha$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f3) {
                    invoke(f3.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f3) {
                    ActivityFragmentKt.ActivityStepsScreen$lambda$2(mutableState, false);
                }
            };
            startRestartGroup.updateValue(nextSlot2);
        }
        startRestartGroup.end(false);
        final State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f2, tweenSpec, "Background Alpha Set Goal", (Function1) nextSlot2, startRestartGroup, 27696, 4);
        if (z3) {
            startRestartGroup.startReplaceableGroup(-2075711638);
            m164getBackground0d7_KjU = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU();
        } else {
            startRestartGroup.startReplaceableGroup(-2075711604);
            m164getBackground0d7_KjU = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m164getBackground0d7_KjU();
        }
        startRestartGroup.end(false);
        BiasAlignment biasAlignment = Alignment.Companion.Center;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = RectangleShapeKt.RectangleShape;
        Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(companion, m164getBackground0d7_KjU, rectangleShapeKt$RectangleShape$1);
        startRestartGroup.startReplaceableGroup(-2075711442);
        boolean changed = startRestartGroup.changed(animateFloatAsState);
        Object nextSlot3 = startRestartGroup.nextSlot();
        if (changed || nextSlot3 == obj) {
            nextSlot3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityStepsScreen$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                    invoke2(graphicsLayerScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GraphicsLayerScope graphicsLayer) {
                    float ActivityStepsScreen$lambda$4;
                    Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                    ActivityStepsScreen$lambda$4 = ActivityFragmentKt.ActivityStepsScreen$lambda$4(animateFloatAsState);
                    graphicsLayer.setAlpha(ActivityStepsScreen$lambda$4);
                }
            };
            startRestartGroup.updateValue(nextSlot3);
        }
        startRestartGroup.end(false);
        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(m21backgroundbw27NRU, (Function1) nextSlot3);
        startRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(graphicsLayer);
        Applier<?> applier = startRestartGroup.applier;
        if (applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
            ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$1);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, -483455358);
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
                AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 1876101314);
                if ((((r28 & 3670016) ^ 1572864) > 1048576 && startRestartGroup.changedInstance(function02)) || (r28 & 1572864) == 1048576) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Object nextSlot4 = startRestartGroup.nextSlot();
                if (z4 || nextSlot4 == obj) {
                    nextSlot4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityStepsScreen$2$1$1$1
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
                            ActivityFragmentKt.ActivityStepsScreen$lambda$2(mutableState, true);
                            function02.invoke();
                        }
                    };
                    startRestartGroup.updateValue(nextSlot4);
                }
                startRestartGroup.end(false);
                int r1 = r28 >> 6;
                int r3 = r28 >> 12;
                ActivityToolbar(z, function0, (Function0) nextSlot4, function03, startRestartGroup, (r1 & 14) | (r3 & 112) | (r3 & 7168));
                ActivityContent(stepProgress, list, z3, startRestartGroup, (r1 & 896) | (r28 & 14) | 64);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                startRestartGroup.startReplaceableGroup(-2075710865);
                if (z2) {
                    Color = ColorKt.Color(Color.m322getRedimpl(r8), Color.m321getGreenimpl(r8), Color.m319getBlueimpl(r8), 0.5f, Color.m320getColorSpaceimpl(Color.Black));
                    z5 = false;
                    LoadingIndicatorKt.CircularLoadingIndicator(BackgroundKt.m21backgroundbw27NRU(companion, Color, rectangleShapeKt$RectangleShape$1), startRestartGroup, 0, 0);
                } else {
                    z5 = false;
                }
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, z5, z5, true, z5);
                startRestartGroup.end(z5);
                RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityStepsScreen$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int r12) {
                            ActivityFragmentKt.ActivityStepsScreen(StepProgress.this, list, z, z2, z3, function0, function02, function03, composer2, Strings.updateChangedFlags(r28 | 1));
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

    private static final boolean ActivityStepsScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public static final void ActivityStepsScreen$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final float ActivityStepsScreen$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityToolbar$1, kotlin.jvm.internal.Lambda] */
    public static final void ActivityToolbar(final boolean z, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int r14) {
        int r0;
        int r1;
        int r12;
        int r13;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1179478262);
        if ((r14 & 14) == 0) {
            if (startRestartGroup.changed(z)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r14;
        } else {
            r0 = r14;
        }
        if ((r14 & 112) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r13 = 32;
            } else {
                r13 = 16;
            }
            r0 |= r13;
        }
        if ((r14 & 896) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                r12 = 256;
            } else {
                r12 = 128;
            }
            r0 |= r12;
        }
        if ((r14 & 7168) == 0) {
            if (startRestartGroup.changedInstance(function03)) {
                r1 = 2048;
            } else {
                r1 = 1024;
            }
            r0 |= r1;
        }
        if ((r0 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-571522454);
            Object nextSlot = startRestartGroup.nextSlot();
            if (nextSlot == Composer.Companion.Empty) {
                nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
                startRestartGroup.updateValue(nextSlot);
            }
            final MutableState mutableState = (MutableState) nextSlot;
            startRestartGroup.end(false);
            TopbarKt.TopBar(null, R.drawable.ic_chevron_left, function0, URLProtocolKt.stringResource(R.string.feature_path_activity, startRestartGroup), ComposableLambdaKt.composableLambda(startRestartGroup, 1375642352, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityToolbar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                    invoke(boxScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxScope TopBar, Composer composer2, int r11) {
                    boolean ActivityToolbar$lambda$11;
                    Intrinsics.checkNotNullParameter(TopBar, "$this$TopBar");
                    if ((r11 & 81) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    ActivityToolbar$lambda$11 = ActivityFragmentKt.ActivityToolbar$lambda$11(mutableState);
                    boolean z2 = z;
                    composer2.startReplaceableGroup(408515717);
                    final MutableState<Boolean> mutableState2 = mutableState;
                    Object rememberedValue = composer2.rememberedValue();
                    Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                    if (rememberedValue == composer$Companion$Empty$1) {
                        rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityToolbar$1$1$1
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
                                boolean ActivityToolbar$lambda$112;
                                MutableState<Boolean> mutableState3 = mutableState2;
                                ActivityToolbar$lambda$112 = ActivityFragmentKt.ActivityToolbar$lambda$11(mutableState3);
                                ActivityFragmentKt.ActivityToolbar$lambda$12(mutableState3, !ActivityToolbar$lambda$112);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    Function0 function04 = (Function0) rememberedValue;
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(408516028);
                    final MutableState<Boolean> mutableState3 = mutableState;
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (rememberedValue2 == composer$Companion$Empty$1) {
                        rememberedValue2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityToolbar$1$2$1
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
                                ActivityFragmentKt.ActivityToolbar$lambda$12(mutableState3, false);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    Function0 function05 = (Function0) rememberedValue2;
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(408515771);
                    boolean changedInstance = composer2.changedInstance(function02);
                    final Function0<Unit> function06 = function02;
                    final MutableState<Boolean> mutableState4 = mutableState;
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changedInstance || rememberedValue3 == composer$Companion$Empty$1) {
                        rememberedValue3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityToolbar$1$3$1
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
                                ActivityFragmentKt.ActivityToolbar$lambda$12(mutableState4, false);
                                function06.invoke();
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    Function0 function07 = (Function0) rememberedValue3;
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(408515896);
                    boolean changedInstance2 = composer2.changedInstance(function03);
                    final Function0<Unit> function08 = function03;
                    final MutableState<Boolean> mutableState5 = mutableState;
                    Object rememberedValue4 = composer2.rememberedValue();
                    if (changedInstance2 || rememberedValue4 == composer$Companion$Empty$1) {
                        rememberedValue4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityToolbar$1$4$1
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
                                ActivityFragmentKt.ActivityToolbar$lambda$12(mutableState5, false);
                                function08.invoke();
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    composer2.endReplaceableGroup();
                    ActivityFragmentKt.OverflowMenu(ActivityToolbar$lambda$11, z2, function04, function05, function07, (Function0) rememberedValue4, composer2, 3456);
                }
            }), startRestartGroup, ((r0 << 3) & 896) | 24624, 1);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$ActivityToolbar$2
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
                    ActivityFragmentKt.ActivityToolbar(z, function0, function02, function03, composer2, Strings.updateChangedFlags(r14 | 1));
                }
            };
        }
    }

    public static final boolean ActivityToolbar$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public static final void ActivityToolbar$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CircularProgressView(final com.animaconnected.secondo.screens.activity.StepProgress r31, final boolean r32, androidx.compose.ui.Modifier r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.activity.ActivityFragmentKt.CircularProgressView(com.animaconnected.secondo.screens.activity.StepProgress, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void HistoryTitle(Modifier modifier, Composer composer, final int r31, final int r32) {
        final Modifier modifier2;
        int r6;
        int r62;
        Modifier modifier3;
        Modifier fillMaxWidth;
        ComposerImpl startRestartGroup = composer.startRestartGroup(2057750869);
        int r3 = r32 & 1;
        if (r3 != 0) {
            r6 = r31 | 6;
            modifier2 = modifier;
        } else if ((r31 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r62 = 4;
            } else {
                r62 = 2;
            }
            r6 = r62 | r31;
        } else {
            modifier2 = modifier;
            r6 = r31;
        }
        if ((r6 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (r3 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            String stringResource = URLProtocolKt.stringResource(R.string.activity_history, startRestartGroup);
            fillMaxWidth = SizeKt.fillMaxWidth(modifier3, 1.0f);
            TextKt.m216Text4IGK_g(stringResource, fillMaxWidth, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, new TextAlign(3), 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h3, startRestartGroup, 0, 0, 65016);
            modifier2 = modifier3;
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$HistoryTitle$1
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
                    ActivityFragmentKt.HistoryTitle(Modifier.this, composer2, Strings.updateChangedFlags(r31 | 1), r32);
                }
            };
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00dd, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r0.nextSlot(), java.lang.Integer.valueOf(r9)) == false) goto L116;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LastSevenDayChart(final java.util.List<com.animaconnected.secondo.screens.activity.activityHistory.StepsHistoryGraph.GraphData> r33, final int r34, final boolean r35, androidx.compose.ui.Modifier r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.activity.ActivityFragmentKt.LastSevenDayChart(java.util.List, int, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Type inference failed for: r8v11, types: [com.animaconnected.secondo.screens.activity.ActivityFragmentKt$OverflowMenu$1, kotlin.jvm.internal.Lambda] */
    public static final void OverflowMenu(final boolean z, final boolean z2, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, Composer composer, final int r26) {
        int r3;
        int r8;
        int r82;
        int r83;
        int r84;
        int r4;
        int r32;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1448535069);
        if ((r26 & 14) == 0) {
            if (startRestartGroup.changed(z)) {
                r32 = 4;
            } else {
                r32 = 2;
            }
            r3 = r32 | r26;
        } else {
            r3 = r26;
        }
        if ((r26 & 112) == 0) {
            if (startRestartGroup.changed(z2)) {
                r4 = 32;
            } else {
                r4 = 16;
            }
            r3 |= r4;
        }
        if ((r26 & 896) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r84 = 256;
            } else {
                r84 = 128;
            }
            r3 |= r84;
        }
        if ((r26 & 7168) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                r83 = 2048;
            } else {
                r83 = 1024;
            }
            r3 |= r83;
        }
        if ((57344 & r26) == 0) {
            if (startRestartGroup.changedInstance(function03)) {
                r82 = DfuBaseService.ERROR_CONNECTION_MASK;
            } else {
                r82 = DfuBaseService.ERROR_REMOTE_MASK;
            }
            r3 |= r82;
        }
        if ((458752 & r26) == 0) {
            if (startRestartGroup.changedInstance(function04)) {
                r8 = 131072;
            } else {
                r8 = 65536;
            }
            r3 |= r8;
        }
        if ((374491 & r3) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            int r16 = r3 >> 6;
            IconButtonKt.IconButton(function0, null, false, null, ComposableSingletons$ActivityFragmentKt.INSTANCE.m828getLambda1$secondo_kronabyRelease(), startRestartGroup, (r16 & 14) | 24576, 14);
            AndroidMenu_androidKt.m155DropdownMenu4kj_NE(z, function02, null, 0L, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 406790608, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$OverflowMenu$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r1v4, types: [com.animaconnected.secondo.screens.activity.ActivityFragmentKt$OverflowMenu$1$1, kotlin.jvm.internal.Lambda] */
                public final void invoke(ColumnScope DropdownMenu, Composer composer2, int r23) {
                    Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                    if ((r23 & 81) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    AndroidMenu_androidKt.DropdownMenuItem(function03, null, false, null, null, ComposableSingletons$ActivityFragmentKt.INSTANCE.m829getLambda2$secondo_kronabyRelease(), composer2, 196608, 30);
                    Function0<Unit> function05 = function04;
                    final boolean z3 = z2;
                    AndroidMenu_androidKt.DropdownMenuItem(function05, null, false, null, null, ComposableLambdaKt.composableLambda(composer2, -615599012, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$OverflowMenu$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope DropdownMenuItem, Composer composer3, int r28) {
                            Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
                            if ((r28 & 81) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                            } else {
                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                                TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(z3 ? R.string.google_fit_disconnect : R.string.google_fit_connect, composer3), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer3.consume(TypographyKt.LocalTypography)).subtitle1, composer3, 0, 0, 65534);
                            }
                        }
                    }), composer2, 196608, 30);
                }
            }), startRestartGroup, (r3 & 14) | 1572864 | (r16 & 112), 60);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$OverflowMenu$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r10) {
                    ActivityFragmentKt.OverflowMenu(z, z2, function0, function02, function03, function04, composer2, Strings.updateChangedFlags(r26 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.jvm.internal.Lambda, com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivity$1] */
    public static final void PreviewActivity(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(605877263);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ThemeKt.BrandTheme(composeThemeProvider, ComposableLambdaKt.composableLambda(startRestartGroup, -2106046209, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivity$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int r34) {
                if ((r34 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                ComposeThemeProvider composeThemeProvider2 = ComposeThemeProvider.this;
                composer2.startReplaceableGroup(-483455358);
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
                if (composer2.getApplier() instanceof Applier) {
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        composer2.useNode();
                    }
                    Updater.m228setimpl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    modifierMaterializerOf.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                    composer2.startReplaceableGroup(2058660585);
                    String simpleName = Reflection.getOrCreateKotlinClass(composeThemeProvider2.getClass()).getSimpleName();
                    if (simpleName == null) {
                        simpleName = "";
                    }
                    TextKt.m216Text4IGK_g(simpleName, null, ((Colors) composer2.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131066);
                    ActivityFragmentKt.ActivityStepsScreen(new StepProgress(0, 0, null, null, 15, null), EmptyList.INSTANCE, false, false, false, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivity$1$1$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivity$1$1$2
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivity$1$1$3
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, composer2, 14380464);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, 56);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivity$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    ActivityFragmentKt.PreviewActivity(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivityDetailed$1, kotlin.jvm.internal.Lambda] */
    public static final void PreviewActivityDetailed(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-673201601);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ThemeKt.BrandTheme(composeThemeProvider, ComposableLambdaKt.composableLambda(startRestartGroup, 533669679, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivityDetailed$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int r34) {
                if ((r34 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                ComposeThemeProvider composeThemeProvider2 = ComposeThemeProvider.this;
                composer2.startReplaceableGroup(-483455358);
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
                if (composer2.getApplier() instanceof Applier) {
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        composer2.useNode();
                    }
                    Updater.m228setimpl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    modifierMaterializerOf.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                    composer2.startReplaceableGroup(2058660585);
                    String simpleName = Reflection.getOrCreateKotlinClass(composeThemeProvider2.getClass()).getSimpleName();
                    if (simpleName == null) {
                        simpleName = "";
                    }
                    TextKt.m216Text4IGK_g(simpleName, null, ((Colors) composer2.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131066);
                    ActivityFragmentKt.ActivityStepsScreen(new StepProgress(0, 0, null, null, 15, null), EmptyList.INSTANCE, false, false, true, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivityDetailed$1$1$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivityDetailed$1$1$2
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivityDetailed$1$1$3
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, composer2, 14380464);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, 56);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$PreviewActivityDetailed$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    ActivityFragmentKt.PreviewActivityDetailed(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void StepsOverview(final java.lang.String r46, androidx.compose.ui.Modifier r47, androidx.compose.runtime.Composer r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.activity.ActivityFragmentKt.StepsOverview(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void TitleDescription(Modifier modifier, Composer composer, final int r35, final int r36) {
        final Modifier modifier2;
        int r6;
        int r62;
        Modifier modifier3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1693133813);
        int r3 = r36 & 1;
        if (r3 != 0) {
            r6 = r35 | 6;
            modifier2 = modifier;
        } else if ((r35 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r62 = 4;
            } else {
                r62 = 2;
            }
            r6 = r62 | r35;
        } else {
            modifier2 = modifier;
            r6 = r35;
        }
        if ((r6 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (r3 != 0) {
                modifier3 = companion;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
            int r32 = ((r6 & 14) << 3) & 112;
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier3);
            int r33 = ((r32 << 9) & 7168) | 6;
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
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r33 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                String stringResource = URLProtocolKt.stringResource(R.string.activity_daily, startRestartGroup);
                Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
                TextAlign textAlign = new TextAlign(3);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
                TextKt.m216Text4IGK_g(stringResource, fillMaxWidth, m166getOnBackground0d7_KjU, 0L, null, null, null, 0L, null, textAlign, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).h1, startRestartGroup, 48, 0, 65016);
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 4), startRestartGroup, 6);
                TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.activity_daily_description, startRestartGroup), SizeKt.fillMaxWidth(companion, 1.0f), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, new TextAlign(3), 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).body1, startRestartGroup, 48, 0, 65016);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                modifier2 = modifier3;
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragmentKt$TitleDescription$2
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
                    ActivityFragmentKt.TitleDescription(Modifier.this, composer2, Strings.updateChangedFlags(r35 | 1), r36);
                }
            };
        }
    }

    public static final /* synthetic */ void access$ActivityStepsScreen(StepProgress stepProgress, List list, boolean z, boolean z2, boolean z3, Function0 function0, Function0 function02, Function0 function03, Composer composer, int r9) {
        ActivityStepsScreen(stepProgress, list, z, z2, z3, function0, function02, function03, composer, r9);
    }
}
