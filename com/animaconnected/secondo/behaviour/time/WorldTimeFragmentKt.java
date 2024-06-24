package com.animaconnected.secondo.behaviour.time;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale$Companion$Inside$1;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel;
import com.animaconnected.widget.ButtonOutlinedKt;
import com.animaconnected.widget.ModifiersKt;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.TextKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorldTimeFragment.kt */
/* loaded from: classes3.dex */
public final class WorldTimeFragmentKt {
    /* JADX WARN: Type inference failed for: r0v3, types: [com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$AddCity$1, kotlin.jvm.internal.Lambda] */
    public static final void AddCity(Modifier modifier, final boolean z, final Function0<Unit> function0, Composer composer, final int r17, final int r18) {
        final Modifier modifier2;
        int r2;
        int r22;
        int r3;
        int r32;
        Modifier modifier3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-874609513);
        int r0 = r18 & 1;
        if (r0 != 0) {
            r2 = r17 | 6;
            modifier2 = modifier;
        } else if ((r17 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier)) {
                r22 = 4;
            } else {
                r22 = 2;
            }
            r2 = r22 | r17;
        } else {
            modifier2 = modifier;
            r2 = r17;
        }
        if ((r18 & 2) != 0) {
            r2 |= 48;
        } else if ((r17 & 112) == 0) {
            if (startRestartGroup.changed(z)) {
                r3 = 32;
            } else {
                r3 = 16;
            }
            r2 |= r3;
        }
        if ((r18 & 4) != 0) {
            r2 |= 384;
        } else if ((r17 & 896) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r32 = 256;
            } else {
                r32 = 128;
            }
            r2 |= r32;
        }
        if ((r2 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (r0 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ButtonOutlinedKt.ButtonOutlined(modifier3, function0, z, false, ComposableLambdaKt.composableLambda(startRestartGroup, 546876932, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$AddCity$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope ButtonOutlined, Composer composer2, int r27) {
                    long Color;
                    Intrinsics.checkNotNullParameter(ButtonOutlined, "$this$ButtonOutlined");
                    if ((r27 & 81) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    String stringResource = URLProtocolKt.stringResource(R.string.world_time_add_city, composer2);
                    Color = ColorKt.Color(Color.m322getRedimpl(r2), Color.m321getGreenimpl(r2), Color.m319getBlueimpl(r2), z ? 1.0f : 0.5f, Color.m320getColorSpaceimpl(((Colors) composer2.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU()));
                    TextKt.m1633CapsTextfLXpl1I(stringResource, null, Color, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer2, 0, 0, 65530);
                }
            }), startRestartGroup, (r2 & 14) | 24576 | ((r2 >> 3) & 112) | ((r2 << 3) & 896), 8);
            modifier2 = modifier3;
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$AddCity$2
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
                    WorldTimeFragmentKt.AddCity(Modifier.this, z, function0, composer2, Strings.updateChangedFlags(r17 | 1), r18);
                }
            };
        }
    }

    public static final void AddCityButtonPreview(Composer composer, final int r8) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(678121904);
        if (r8 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            AddCity(null, true, new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$AddCityButtonPreview$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 432, 1);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$AddCityButtonPreview$2
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
                    WorldTimeFragmentKt.AddCityButtonPreview(composer2, Strings.updateChangedFlags(r8 | 1));
                }
            };
        }
    }

    public static final void ScreenPreview(Composer composer, final int r9) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1956750182);
        if (r9 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            WorldTimeScreen(EmptyList.INSTANCE, new Function2<String, String, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$ScreenPreview$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                    invoke2(str, str2);
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$ScreenPreview$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, true, false, startRestartGroup, 28088);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$ScreenPreview$3
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
                    WorldTimeFragmentKt.ScreenPreview(composer2, Strings.updateChangedFlags(r9 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$TimeZoneRow$1$1$1, kotlin.jvm.internal.Lambda] */
    public static final void TimeZoneRow(Modifier modifier, final WorldTimeViewModel.State state, final boolean z, final Function0<Unit> function0, Composer composer, final int r60, final int r61) {
        Modifier modifier2;
        Modifier fillMaxWidth;
        ComposerImpl startRestartGroup = composer.startRestartGroup(2072117383);
        int r1 = r61 & 1;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        fillMaxWidth = SizeKt.fillMaxWidth(modifier2, 1.0f);
        Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
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
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier weight = rowScopeInstance.weight(companion, 2.0f, true);
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight);
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, rowMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                modifierMaterializerOf2.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 231676711, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$TimeZoneRow$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                        invoke(animatedVisibilityScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int r14) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.ic_minus, composer2);
                        ContentScale$Companion$Inside$1 contentScale$Companion$Inside$1 = ContentScale.Companion.Inside;
                        float f = 48;
                        Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(SizeKt.m81defaultMinSizeVpY3zN4(Modifier.Companion.$$INSTANCE, f, f), 0.0f, 0.0f, 8, 0.0f, 11);
                        composer2.startReplaceableGroup(107664298);
                        boolean changedInstance = composer2.changedInstance(function0);
                        final Function0<Unit> function02 = function0;
                        Object rememberedValue = composer2.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.Empty) {
                            rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$TimeZoneRow$1$1$1$1$1
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
                                    function02.invoke();
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        ImageKt.Image(painterResource, "delete timezone", ModifiersKt.noRippleClickable(m75paddingqDBjuR0$default, (Function0) rememberedValue), null, contentScale$Companion$Inside$1, 0.0f, null, composer2, 24632, 104);
                    }
                }), startRestartGroup, ((r60 >> 3) & 112) | 1572870, 30);
                startRestartGroup.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    modifierMaterializerOf3.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    String offset = state.getOffset();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                    long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
                    androidx.compose.material.TextKt.m216Text4IGK_g(offset, null, m166getOnBackground0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).h4, startRestartGroup, 0, 0, 65530);
                    androidx.compose.material.TextKt.m216Text4IGK_g(state.getCity(), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 8, 0.0f, 0.0f, 13), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 2, false, 1, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).h2, startRestartGroup, 48, 3120, 55288);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    com.animaconnected.widget.theme.TypographyKt.m1636BigTextZHfKjFs(null, state.getHourMinute(), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), new TextAlign(6), 0, 0, false, startRestartGroup, 0, 113);
                    RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                    if (m != null) {
                        final Modifier modifier3 = modifier2;
                        m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$TimeZoneRow$2
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
                                WorldTimeFragmentKt.TimeZoneRow(Modifier.this, state, z, function0, composer2, Strings.updateChangedFlags(r60 | 1), r61);
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
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final void TimeZoneRowPreview(Composer composer, final int r9) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(592116237);
        if (r9 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            TimeZoneRow(null, new WorldTimeViewModel.State("New york", "05:45", "Today, -6hrs", "", ""), true, new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$TimeZoneRowPreview$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 3520, 1);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$TimeZoneRowPreview$2
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
                    WorldTimeFragmentKt.TimeZoneRowPreview(composer2, Strings.updateChangedFlags(r9 | 1));
                }
            };
        }
    }

    public static final void TimeZones(Modifier modifier, final List<WorldTimeViewModel.State> list, final Function2<? super String, ? super String, Unit> function2, final boolean z, Composer composer, final int r22, final int r23) {
        Modifier modifier2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-976768257);
        int r1 = r23 & 1;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        int size = list.size();
        Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.wrapContentHeight$default(modifier2), ScrollKt.rememberScrollState(startRestartGroup), false, 14);
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
            AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 72024802);
            int r14 = 0;
            for (Object obj : list) {
                int r15 = r14 + 1;
                if (r14 >= 0) {
                    final WorldTimeViewModel.State state = (WorldTimeViewModel.State) obj;
                    TimeZoneRow(null, state, z, new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$TimeZones$1$1$1
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
                            function2.invoke(state.getZoneId(), state.getCityKey());
                        }
                    }, startRestartGroup, ((r22 >> 3) & 896) | 64, 1);
                    startRestartGroup.startReplaceableGroup(2015405408);
                    if (r14 != size) {
                        SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 40), startRestartGroup, 6);
                    }
                    startRestartGroup.end(false);
                    r14 = r15;
                } else {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                    throw null;
                }
            }
            AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
            startRestartGroup.end(false);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                final Modifier modifier3 = modifier2;
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$TimeZones$2
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
                        WorldTimeFragmentKt.TimeZones(Modifier.this, list, function2, z, composer2, Strings.updateChangedFlags(r22 | 1), r23);
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final void WorldTimeScreen(final List<WorldTimeViewModel.State> list, final Function2<? super String, ? super String, Unit> function2, final Function0<Unit> function0, final boolean z, final boolean z2, Composer composer, final int r39) {
        boolean z3;
        boolean z4;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1910611803);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        float f = 32;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier height = IntrinsicKt.height(companion, IntrinsicSize.Min);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(height);
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
            float f2 = 24;
            ScreenTitleKt.ScreenImageTitle(PaddingKt.m75paddingqDBjuR0$default(companion, f, f2, f, 0.0f, 8), URLProtocolKt.stringResource(R.string.world_time_title, startRestartGroup), R.drawable.ic_second_time, startRestartGroup, 390, 0);
            androidx.compose.material.TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.world_time_desc, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, f, f2, f, 0.0f, 8), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).body1, startRestartGroup, 48, 0, 65528);
            Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, f, 64, f, 0.0f, 8);
            startRestartGroup.startReplaceableGroup(-279069130);
            if ((((r39 & 112) ^ 48) > 32 && startRestartGroup.changedInstance(function2)) || (r39 & 48) == 32) {
                z3 = true;
            } else {
                z3 = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (z3 || nextSlot == composer$Companion$Empty$1) {
                nextSlot = new Function2<String, String, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$WorldTimeScreen$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                        invoke2(str, str2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String zoneId, String cityKey) {
                        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
                        Intrinsics.checkNotNullParameter(cityKey, "cityKey");
                        function2.invoke(zoneId, cityKey);
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            TimeZones(m75paddingqDBjuR0$default, list, (Function2) nextSlot, z2, startRestartGroup, ((r39 >> 3) & 7168) | 70, 0);
            Modifier m74paddingqDBjuR0 = PaddingKt.m74paddingqDBjuR0(new HorizontalAlignElement(Alignment.Companion.CenterHorizontally), f, f2, f, f2);
            startRestartGroup.startReplaceableGroup(-279069023);
            if ((((r39 & 896) ^ 384) > 256 && startRestartGroup.changedInstance(function0)) || (r39 & 384) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z4 || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$WorldTimeScreen$1$2$1
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
                startRestartGroup.updateValue(nextSlot2);
            }
            startRestartGroup.end(false);
            AddCity(m74paddingqDBjuR0, z, (Function0) nextSlot2, startRestartGroup, (r39 >> 6) & 112, 0);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragmentKt$WorldTimeScreen$2
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
                        WorldTimeFragmentKt.WorldTimeScreen(list, function2, function0, z, z2, composer2, Strings.updateChangedFlags(r39 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final /* synthetic */ void access$WorldTimeScreen(List list, Function2 function2, Function0 function0, boolean z, boolean z2, Composer composer, int r6) {
        WorldTimeScreen(list, function2, function0, z, z2, composer, r6);
    }
}
