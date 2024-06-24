package com.animaconnected.secondo.screens.debugsettings.graphs;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.TextFieldKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.amazonaws.services.s3.Headers;
import com.animaconnected.widget.ButtonOutlinedKt;
import com.animaconnected.widget.TopbarKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: DebugChart.kt */
/* loaded from: classes3.dex */
public final class DebugChartKt {
    public static final void DebugLineChartScreen(final Function2<? super Integer, ? super Integer, Unit> onRandomizeClick, final Function0<Unit> onBackClick, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> chart, Composer composer, final int r21) {
        int r1;
        boolean z;
        int r2;
        int r22;
        int r12;
        Intrinsics.checkNotNullParameter(onRandomizeClick, "onRandomizeClick");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(chart, "chart");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1388976054);
        if ((r21 & 14) == 0) {
            if (startRestartGroup.changedInstance(onRandomizeClick)) {
                r12 = 4;
            } else {
                r12 = 2;
            }
            r1 = r12 | r21;
        } else {
            r1 = r21;
        }
        if ((r21 & 112) == 0) {
            if (startRestartGroup.changedInstance(onBackClick)) {
                r22 = 32;
            } else {
                r22 = 16;
            }
            r1 |= r22;
        }
        if ((r21 & 896) == 0) {
            if (startRestartGroup.changedInstance(chart)) {
                r2 = 256;
            } else {
                r2 = 128;
            }
            r1 |= r2;
        }
        int r13 = r1;
        if ((r13 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(BackgroundKt.m21backgroundbw27NRU(companion, Color.Black, RectangleShapeKt.RectangleShape), ScrollKt.rememberScrollState(startRestartGroup), false, 14);
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
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                TopbarKt.TopBar(null, R.drawable.ic_chevron_left, onBackClick, "Debug", null, startRestartGroup, ((r13 << 3) & 896) | 3120, 17);
                chart.invoke(columnScopeInstance, startRestartGroup, Integer.valueOf(((r13 >> 3) & 112) | 6));
                Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(companion, 8);
                startRestartGroup.startReplaceableGroup(400962297);
                if ((r13 & 14) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                if (z || nextSlot == Composer.Companion.Empty) {
                    nextSlot = new Function2<Integer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartKt$DebugLineChartScreen$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                            invoke(num.intValue(), num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int r23, int r3) {
                            onRandomizeClick.invoke(Integer.valueOf(r23), Integer.valueOf(r3));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                RandomizeSection(m71padding3ABfNKs, (Function2) nextSlot, startRestartGroup, 6, 0);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartKt$DebugLineChartScreen$2
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

                public final void invoke(Composer composer2, int r5) {
                    DebugChartKt.DebugLineChartScreen(onRandomizeClick, onBackClick, chart, composer2, Strings.updateChangedFlags(r21 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartKt$DebugTextField$1, kotlin.jvm.internal.Lambda] */
    public static final void DebugTextField(Modifier modifier, final String str, final String str2, final Function1<? super String, Unit> function1, Composer composer, final int r35, final int r36) {
        Modifier modifier2;
        int r4;
        int r42;
        int r6;
        int r62;
        int r63;
        final Modifier modifier3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(584920274);
        int r1 = r36 & 1;
        if (r1 != 0) {
            r4 = r35 | 6;
            modifier2 = modifier;
        } else if ((r35 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r42 = 4;
            } else {
                r42 = 2;
            }
            r4 = r42 | r35;
        } else {
            modifier2 = modifier;
            r4 = r35;
        }
        if ((r36 & 2) != 0) {
            r4 |= 48;
        } else if ((r35 & 112) == 0) {
            if (startRestartGroup.changed(str)) {
                r6 = 32;
            } else {
                r6 = 16;
            }
            r4 |= r6;
        }
        if ((r36 & 4) != 0) {
            r4 |= 384;
        } else if ((r35 & 896) == 0) {
            if (startRestartGroup.changed(str2)) {
                r62 = 256;
            } else {
                r62 = 128;
            }
            r4 |= r62;
        }
        if ((r36 & 8) != 0) {
            r4 |= 3072;
        } else if ((r35 & 7168) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r63 = 2048;
            } else {
                r63 = 1024;
            }
            r4 |= r63;
        }
        if ((r4 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (r1 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, 3, 7, 3);
            int r3 = r4 >> 6;
            Modifier modifier4 = modifier3;
            TextFieldKt.TextField(str2, function1, modifier4, false, false, null, ComposableLambdaKt.composableLambda(startRestartGroup, 803198894, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartKt$DebugTextField$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r28) {
                    if ((r28 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        TextKt.m216Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                    }
                }
            }), null, null, null, false, null, keyboardOptions, null, false, 0, 0, null, null, null, startRestartGroup, (r3 & 112) | (r3 & 14) | 1572864 | ((r4 << 6) & 896), 384, 1044408);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartKt$DebugTextField$2
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
                    DebugChartKt.DebugTextField(Modifier.this, str, str2, function1, composer2, Strings.updateChangedFlags(r35 | 1), r36);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RandomizeSection(Modifier modifier, final Function2<? super Integer, ? super Integer, Unit> function2, Composer composer, final int r20, final int r21) {
        final Modifier modifier2;
        int r6;
        int r62;
        int r7;
        Modifier modifier3;
        final MutableState mutableState;
        boolean z;
        boolean z2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1290062393);
        int r4 = r21 & 1;
        if (r4 != 0) {
            r6 = r20 | 6;
            modifier2 = modifier;
        } else if ((r20 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r62 = 4;
            } else {
                r62 = 2;
            }
            r6 = r62 | r20;
        } else {
            modifier2 = modifier;
            r6 = r20;
        }
        if ((r21 & 2) != 0) {
            r6 |= 48;
        } else if ((r20 & 112) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
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
            startRestartGroup.startReplaceableGroup(-1737240611);
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (nextSlot == composer$Companion$Empty$1) {
                nextSlot = Platform.mutableStateOf$default(null);
                startRestartGroup.updateValue(nextSlot);
            }
            final MutableState mutableState2 = (MutableState) nextSlot;
            Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -1737240554);
            if (m == composer$Companion$Empty$1) {
                m = Platform.mutableStateOf$default(null);
                startRestartGroup.updateValue(m);
            }
            MutableState mutableState3 = (MutableState) m;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier3);
            int r42 = (((((r11 & 14) << 3) & 112) << 9) & 7168) | 6;
            Applier<?> applier = startRestartGroup.applier;
            Modifier modifier4 = modifier3;
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
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r42 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, Alignment.Companion.Top, startRestartGroup);
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
                    Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(rowScopeInstance.weight(companion, 1.0f, true), 0.0f, 0.0f, 16, 0.0f, 11);
                    String asString = asString(RandomizeSection$lambda$3(mutableState2));
                    startRestartGroup.startReplaceableGroup(601703769);
                    Object nextSlot2 = startRestartGroup.nextSlot();
                    if (nextSlot2 == composer$Companion$Empty$1) {
                        nextSlot2 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartKt$RandomizeSection$1$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                mutableState2.setValue(StringsKt__StringNumberConversionsKt.toIntOrNull(it));
                            }
                        };
                        startRestartGroup.updateValue(nextSlot2);
                    }
                    startRestartGroup.end(false);
                    DebugTextField(m75paddingqDBjuR0$default, "Baseline", asString, (Function1) nextSlot2, startRestartGroup, 3120, 0);
                    Modifier weight = rowScopeInstance.weight(companion, 1.0f, true);
                    String asString2 = asString(RandomizeSection$lambda$6(mutableState3));
                    startRestartGroup.startReplaceableGroup(601703998);
                    Object nextSlot3 = startRestartGroup.nextSlot();
                    if (nextSlot3 == composer$Companion$Empty$1) {
                        mutableState = mutableState3;
                        nextSlot3 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartKt$RandomizeSection$1$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                mutableState.setValue(StringsKt__StringNumberConversionsKt.toIntOrNull(it));
                            }
                        };
                        startRestartGroup.updateValue(nextSlot3);
                    } else {
                        mutableState = mutableState3;
                    }
                    startRestartGroup.end(false);
                    DebugTextField(weight, Headers.RANGE, asString2, (Function1) nextSlot3, startRestartGroup, 3120, 0);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    Modifier m75paddingqDBjuR0$default2 = PaddingKt.m75paddingqDBjuR0$default(new HorizontalAlignElement(Alignment.Companion.CenterHorizontally), 0.0f, 8, 0.0f, 0.0f, 13);
                    if (RandomizeSection$lambda$3(mutableState2) != null && RandomizeSection$lambda$6(mutableState) != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    startRestartGroup.startReplaceableGroup(-1828748748);
                    if ((r11 & 112) == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Object nextSlot4 = startRestartGroup.nextSlot();
                    if (z2 || nextSlot4 == composer$Companion$Empty$1) {
                        nextSlot4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartKt$RandomizeSection$1$2$1
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
                                Integer RandomizeSection$lambda$3;
                                Integer RandomizeSection$lambda$6;
                                Function2<Integer, Integer, Unit> function22 = function2;
                                RandomizeSection$lambda$3 = DebugChartKt.RandomizeSection$lambda$3(mutableState2);
                                Integer valueOf = Integer.valueOf(RandomizeSection$lambda$3 != null ? RandomizeSection$lambda$3.intValue() : 0);
                                RandomizeSection$lambda$6 = DebugChartKt.RandomizeSection$lambda$6(mutableState);
                                function22.invoke(valueOf, Integer.valueOf(RandomizeSection$lambda$6 != null ? RandomizeSection$lambda$6.intValue() : 0));
                            }
                        };
                        startRestartGroup.updateValue(nextSlot4);
                    }
                    startRestartGroup.end(false);
                    ButtonOutlinedKt.ButtonOutlined(m75paddingqDBjuR0$default2, (Function0) nextSlot4, z, false, ComposableSingletons$DebugChartKt.INSTANCE.m905getLambda1$secondo_kronabyRelease(), startRestartGroup, 24576, 8);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    modifier2 = modifier4;
                } else {
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartKt$RandomizeSection$2
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

                public final void invoke(Composer composer2, int r5) {
                    DebugChartKt.RandomizeSection(Modifier.this, function2, composer2, Strings.updateChangedFlags(r20 | 1), r21);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer RandomizeSection$lambda$3(MutableState<Integer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer RandomizeSection$lambda$6(MutableState<Integer> mutableState) {
        return mutableState.getValue();
    }

    private static final String asString(Integer num) {
        String num2;
        if (num == null || (num2 = num.toString()) == null) {
            return "";
        }
        return num2;
    }
}
