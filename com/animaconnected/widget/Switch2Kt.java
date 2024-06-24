package com.animaconnected.widget;

import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.SwipeableDefaults;
import androidx.compose.material.SwipeableState;
import androidx.compose.material.SwitchKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt__MathJVMKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: Switch2.kt */
/* loaded from: classes3.dex */
public final class Switch2Kt {
    private static final float DefaultSwitchPadding;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;
    private static final float ThumbRippleRadius = 24;
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(100, 0, null, 6);
    private static final float ThumbPressedElevation = 6;

    static {
        float f = 44;
        TrackWidth = f;
        float f2 = 1;
        TrackStrokeWidth = f2;
        float f3 = 20;
        ThumbDiameter = f3;
        float f4 = 2;
        DefaultSwitchPadding = f4;
        SwitchWidth = f;
        SwitchHeight = f3;
        ThumbPathLength = f - (f3 / f4);
        ThumbDefaultElevation = f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Switch2(final boolean r35, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r36, androidx.compose.ui.Modifier r37, boolean r38, androidx.compose.foundation.interaction.MutableInteractionSource r39, com.animaconnected.widget.SwitchColors2 r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 722
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.Switch2Kt.Switch2(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, com.animaconnected.widget.SwitchColors2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchImpl(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors2 switchColors2, final State<Float> state, final InteractionSource interactionSource, Composer composer, final int r25) {
        int r8;
        boolean z3;
        float f;
        boolean z4;
        boolean z5;
        int r14;
        int r12;
        int r10;
        int r102;
        int r103;
        int r82;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-957134731);
        if ((r25 & 14) == 0) {
            if (startRestartGroup.changed(boxScope)) {
                r82 = 4;
            } else {
                r82 = 2;
            }
            r8 = r82 | r25;
        } else {
            r8 = r25;
        }
        if ((r25 & 112) == 0) {
            if (startRestartGroup.changed(z)) {
                r103 = 32;
            } else {
                r103 = 16;
            }
            r8 |= r103;
        }
        if ((r25 & 896) == 0) {
            if (startRestartGroup.changed(z2)) {
                r102 = 256;
            } else {
                r102 = 128;
            }
            r8 |= r102;
        }
        if ((r25 & 7168) == 0) {
            if (startRestartGroup.changed(switchColors2)) {
                r10 = 2048;
            } else {
                r10 = 1024;
            }
            r8 |= r10;
        }
        if ((r25 & 57344) == 0) {
            if (startRestartGroup.changed(state)) {
                r12 = DfuBaseService.ERROR_CONNECTION_MASK;
            } else {
                r12 = DfuBaseService.ERROR_REMOTE_MASK;
            }
            r8 |= r12;
        }
        if ((r25 & 458752) == 0) {
            if (startRestartGroup.changed(interactionSource)) {
                r14 = 131072;
            } else {
                r14 = 65536;
            }
            r8 |= r14;
        }
        if ((374491 & r8) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-1184561564);
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (nextSlot == composer$Companion$Empty$1) {
                nextSlot = new SnapshotStateList();
                startRestartGroup.updateValue(nextSlot);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) nextSlot;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-1184561478);
            if ((458752 & r8) == 131072) {
                z3 = true;
            } else {
                z3 = false;
            }
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z3 || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Switch2Kt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                startRestartGroup.updateValue(nextSlot2);
            }
            startRestartGroup.end(false);
            EffectsKt.LaunchedEffect(interactionSource, (Function2) nextSlot2, startRestartGroup);
            if (!snapshotStateList.isEmpty()) {
                f = ThumbPressedElevation;
            } else {
                f = ThumbDefaultElevation;
            }
            int r15 = r8 & 112;
            int r122 = ((r8 >> 6) & 14) | r15 | ((r8 >> 3) & 896);
            final State<Color> trackColor = switchColors2.trackColor(z2, z, startRestartGroup, r122);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(boxScope.align(companion, Alignment.Companion.Center));
            startRestartGroup.startReplaceableGroup(-1184560533);
            boolean changed = startRestartGroup.changed(trackColor);
            Object nextSlot3 = startRestartGroup.nextSlot();
            if (changed || nextSlot3 == composer$Companion$Empty$1) {
                nextSlot3 = new Function1<DrawScope, Unit>() { // from class: com.animaconnected.widget.Switch2Kt$SwitchImpl$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        long SwitchImpl$lambda$5;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        SwitchImpl$lambda$5 = Switch2Kt.SwitchImpl$lambda$5(trackColor);
                        Switch2Kt.m1630drawTrackRPmYEkk(Canvas, SwitchImpl$lambda$5, Canvas.mo49toPx0680j_4(Switch2Kt.getTrackWidth()), Canvas.mo49toPx0680j_4(Switch2Kt.getTrackStrokeWidth()));
                    }
                };
                startRestartGroup.updateValue(nextSlot3);
            }
            startRestartGroup.end(false);
            CanvasKt.Canvas(fillMaxSize$default, (Function1) nextSlot3, startRestartGroup, 0);
            final State<Color> thumbColor = switchColors2.thumbColor(z2, z, startRestartGroup, r122);
            Modifier align = boxScope.align(companion, Alignment.Companion.CenterStart);
            startRestartGroup.startReplaceableGroup(-1184560301);
            if ((r8 & 57344) == 16384) {
                z4 = true;
            } else {
                z4 = false;
            }
            Object nextSlot4 = startRestartGroup.nextSlot();
            if (z4 || nextSlot4 == composer$Companion$Empty$1) {
                nextSlot4 = new Function1<Density, IntOffset>() { // from class: com.animaconnected.widget.Switch2Kt$SwitchImpl$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ IntOffset invoke(Density density) {
                        return new IntOffset(m1631invokeBjo55l4(density));
                    }

                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m1631invokeBjo55l4(Density offset) {
                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                        return IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(state.getValue().floatValue()), 0);
                    }
                };
                startRestartGroup.updateValue(nextSlot4);
            }
            startRestartGroup.end(false);
            Modifier m235shadows4CzXII$default = ShadowKt.m235shadows4CzXII$default(SizeKt.m88requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align, (Function1) nextSlot4), interactionSource, RippleKt.m226rememberRipple9IZ8Weo(false, ThumbRippleRadius, startRestartGroup, 54, 4)), ThumbDiameter), f, RoundedCornerShapeKt.CircleShape);
            startRestartGroup.startReplaceableGroup(-1184559942);
            if (r15 == 32) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean changed2 = z5 | startRestartGroup.changed(thumbColor) | startRestartGroup.changed(trackColor);
            Object nextSlot5 = startRestartGroup.nextSlot();
            if (changed2 || nextSlot5 == composer$Companion$Empty$1) {
                nextSlot5 = new Function1<ContentDrawScope, Unit>() { // from class: com.animaconnected.widget.Switch2Kt$SwitchImpl$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                        invoke2(contentDrawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ContentDrawScope drawWithContent) {
                        long SwitchImpl$lambda$7;
                        long SwitchImpl$lambda$5;
                        long SwitchImpl$lambda$72;
                        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                        if (z) {
                            SwitchImpl$lambda$72 = Switch2Kt.SwitchImpl$lambda$7(thumbColor);
                            DrawScope.m378drawCircleVaOC9Bg$default(drawWithContent, SwitchImpl$lambda$72, drawWithContent.mo49toPx0680j_4(Switch2Kt.getThumbDiameter()) / 2.0f, 0L, Fill.INSTANCE, 108);
                        } else {
                            SwitchImpl$lambda$7 = Switch2Kt.SwitchImpl$lambda$7(thumbColor);
                            DrawScope.m378drawCircleVaOC9Bg$default(drawWithContent, SwitchImpl$lambda$7, drawWithContent.mo49toPx0680j_4(Switch2Kt.getThumbDiameter()) / 2.0f, 0L, Fill.INSTANCE, 108);
                            SwitchImpl$lambda$5 = Switch2Kt.SwitchImpl$lambda$5(trackColor);
                            DrawScope.m378drawCircleVaOC9Bg$default(drawWithContent, SwitchImpl$lambda$5, drawWithContent.mo49toPx0680j_4(Switch2Kt.getThumbDiameter()) / 2.0f, 0L, new Stroke(drawWithContent.mo49toPx0680j_4(1), 0.0f, 0, 0, 30), 108);
                        }
                    }
                };
                startRestartGroup.updateValue(nextSlot5);
            }
            startRestartGroup.end(false);
            SpacerKt.Spacer(DrawModifierKt.drawWithContent(m235shadows4CzXII$default, (Function1) nextSlot5), startRestartGroup, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.Switch2Kt$SwitchImpl$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r104) {
                    Switch2Kt.SwitchImpl(BoxScope.this, z, z2, switchColors2, state, interactionSource, composer2, Strings.updateChangedFlags(r25 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long SwitchImpl$lambda$5(State<Color> state) {
        return state.getValue().value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long SwitchImpl$lambda$7(State<Color> state) {
        return state.getValue().value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.internal.Lambda, com.animaconnected.widget.Switch2Kt$SwitchPreviewAll$1] */
    public static final void SwitchPreviewAll(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(768058735);
        if ((r5 & 14) == 0) {
            if (startRestartGroup.changed(composeThemeProvider)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r5;
        } else {
            r0 = r5;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(composeThemeProvider, ComposableLambdaKt.composableLambda(startRestartGroup, -1150597537, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.Switch2Kt$SwitchPreviewAll$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r29) {
                    if ((r29 & 11) == 2 && composer2.getSkipping()) {
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
                        androidx.compose.material.TextKt.m216Text4IGK_g(simpleName, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                        Switch2Kt.Switch2(true, new Function1<Boolean, Unit>() { // from class: com.animaconnected.widget.Switch2Kt$SwitchPreviewAll$1$1$1
                            public final void invoke(boolean z) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        }, null, false, null, null, composer2, 54, 60);
                        Switch2Kt.Switch2(false, new Function1<Boolean, Unit>() { // from class: com.animaconnected.widget.Switch2Kt$SwitchPreviewAll$1$1$2
                            public final void invoke(boolean z) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        }, null, false, null, null, composer2, 54, 60);
                        SwitchKt.Switch(true, new Function1<Boolean, Unit>() { // from class: com.animaconnected.widget.Switch2Kt$SwitchPreviewAll$1$1$3
                            public final void invoke(boolean z) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        }, null, false, null, null, composer2, 54, 60);
                        SwitchKt.Switch(false, new Function1<Boolean, Unit>() { // from class: com.animaconnected.widget.Switch2Kt$SwitchPreviewAll$1$1$4
                            public final void invoke(boolean z) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        }, null, false, null, null, composer2, 54, 60);
                        DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                        return;
                    }
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }), startRestartGroup, (r0 & 14) | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.Switch2Kt$SwitchPreviewAll$2
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
                    Switch2Kt.SwitchPreviewAll(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    public static final void m1630drawTrackRPmYEkk(DrawScope drawScope, long j, float f, float f2) {
        float f3 = f2 / 2;
        DrawScope.m382drawLineNGM6Ib0$default(drawScope, j, androidx.compose.ui.geometry.OffsetKt.Offset(f3, Offset.m260getYimpl(drawScope.mo390getCenterF1C5BW0())), androidx.compose.ui.geometry.OffsetKt.Offset(f - f3, Offset.m260getYimpl(drawScope.mo390getCenterF1C5BW0())), f2, 1, 480);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final <T> SwipeableState<T> rememberSwipeableStateFor(final T value, final Function1<? super T, Unit> onValueChange, AnimationSpec<Float> animationSpec, Composer composer, int r6, int r7) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        composer.startReplaceableGroup(-1529445184);
        if ((r7 & 4) != 0) {
            animationSpec = SwipeableDefaults.AnimationSpec;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(1514713521);
        Object rememberedValue = composer.rememberedValue();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (rememberedValue == composer$Companion$Empty$1) {
            rememberedValue = new SwipeableState(value, animationSpec, new Function1<T, Boolean>() { // from class: com.animaconnected.widget.Switch2Kt$rememberSwipeableStateFor$swipeableState$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return invoke((Switch2Kt$rememberSwipeableStateFor$swipeableState$1$1<T>) obj);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        final SwipeableState<T> swipeableState = (SwipeableState) rememberedValue;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(1514713721);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == composer$Companion$Empty$1) {
            rememberedValue2 = Platform.mutableStateOf$default(Boolean.FALSE);
            composer.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState = (MutableState) rememberedValue2;
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(value, mutableState.getValue(), new Switch2Kt$rememberSwipeableStateFor$1(value, swipeableState, null), composer);
        EffectsKt.DisposableEffect(swipeableState.getCurrentValue(), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.animaconnected.widget.Switch2Kt$rememberSwipeableStateFor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                if (!Intrinsics.areEqual(value, swipeableState.getCurrentValue())) {
                    onValueChange.invoke(swipeableState.getCurrentValue());
                    mutableState.setValue(Boolean.valueOf(!r2.getValue().booleanValue()));
                }
                return new DisposableEffectResult() { // from class: com.animaconnected.widget.Switch2Kt$rememberSwipeableStateFor$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        }, composer);
        composer.endReplaceableGroup();
        return swipeableState;
    }
}
