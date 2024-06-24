package com.animaconnected.widget;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: PinCodeField.kt */
/* loaded from: classes3.dex */
public final class PinCodeFieldKt {
    public static final void AllPinCode(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1517173013);
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
            ThemeKt.BrandTheme(composeThemeProvider, ComposableSingletons$PinCodeFieldKt.INSTANCE.m1595getLambda2$widget_release(), startRestartGroup, (r0 & 14) | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.PinCodeFieldKt$AllPinCode$1
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
                    PinCodeFieldKt.AllPinCode(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    public static final void AllPinCodeDialog(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1460903955);
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
            ThemeKt.BrandTheme(composeThemeProvider, ComposableSingletons$PinCodeFieldKt.INSTANCE.m1594getLambda1$widget_release(), startRestartGroup, (r0 & 14) | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.PinCodeFieldKt$AllPinCodeDialog$1
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
                    PinCodeFieldKt.AllPinCodeDialog(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* renamed from: BlinkingCursor-iJQMabo */
    public static final void m1616BlinkingCursoriJQMabo(Modifier modifier, final long j, Composer composer, final int r13, final int r14) {
        int r2;
        int r22;
        int r3;
        Modifier fillMaxHeight;
        Modifier m21backgroundbw27NRU;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-106689408);
        int r0 = r14 & 1;
        if (r0 != 0) {
            r2 = r13 | 6;
        } else if ((r13 & 14) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r22 = 4;
            } else {
                r22 = 2;
            }
            r2 = r22 | r13;
        } else {
            r2 = r13;
        }
        if ((r14 & 2) != 0) {
            r2 |= 48;
        } else if ((r13 & 112) == 0) {
            if (startRestartGroup.changed(j)) {
                r3 = 32;
            } else {
                r3 = 16;
            }
            r2 |= r3;
        }
        if ((r2 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (r0 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            final float floatValue = ((Number) InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("cursor infinite transition", startRestartGroup, 0), 1.0f, AnimationSpecKt.m10infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween(400, 100, EasingKt.LinearEasing), RepeatMode.Reverse, 4), "cursor animate float", startRestartGroup, 29112, 0).getValue()).floatValue();
            fillMaxHeight = SizeKt.fillMaxHeight(modifier, 1.0f);
            Modifier m73paddingVpY3zN4$default = PaddingKt.m73paddingVpY3zN4$default(SizeKt.m94width3ABfNKs(fillMaxHeight, 1), 0.0f, 6, 1);
            startRestartGroup.startReplaceableGroup(-170935424);
            boolean changed = startRestartGroup.changed(floatValue);
            Object nextSlot = startRestartGroup.nextSlot();
            if (changed || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function1<GraphicsLayerScope, Unit>() { // from class: com.animaconnected.widget.PinCodeFieldKt$BlinkingCursor$1$1
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
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setAlpha(floatValue);
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(m73paddingVpY3zN4$default, (Function1) nextSlot), j, RectangleShapeKt.RectangleShape);
            BoxKt.Box(m21backgroundbw27NRU, startRestartGroup, 0);
        }
        final Modifier modifier2 = modifier;
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.PinCodeFieldKt$BlinkingCursor$2
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
                    PinCodeFieldKt.m1616BlinkingCursoriJQMabo(Modifier.this, j, composer2, Strings.updateChangedFlags(r13 | 1), r14);
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0050  */
    /* renamed from: CodeEntry-yrwZFoE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1617CodeEntryyrwZFoE(final java.lang.String r35, androidx.compose.ui.Modifier r36, final boolean r37, final boolean r38, final long r39, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.PinCodeFieldKt.m1617CodeEntryyrwZFoE(java.lang.String, androidx.compose.ui.Modifier, boolean, boolean, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: CodeInputDecoration-qFjXxE8 */
    public static final void m1618CodeInputDecorationqFjXxE8(final String str, final int r21, final boolean z, final boolean z2, final long j, Composer composer, final int r27) {
        int r5;
        Character ch;
        String str2;
        boolean z3;
        boolean z4;
        int r6;
        int r62;
        int r63;
        int r64;
        int r52;
        ComposerImpl startRestartGroup = composer.startRestartGroup(169499808);
        if ((r27 & 14) == 0) {
            if (startRestartGroup.changed(str)) {
                r52 = 4;
            } else {
                r52 = 2;
            }
            r5 = r52 | r27;
        } else {
            r5 = r27;
        }
        if ((r27 & 112) == 0) {
            if (startRestartGroup.changed(r21)) {
                r64 = 32;
            } else {
                r64 = 16;
            }
            r5 |= r64;
        }
        if ((r27 & 896) == 0) {
            if (startRestartGroup.changed(z)) {
                r63 = 256;
            } else {
                r63 = 128;
            }
            r5 |= r63;
        }
        if ((r27 & 7168) == 0) {
            if (startRestartGroup.changed(z2)) {
                r62 = 2048;
            } else {
                r62 = 1024;
            }
            r5 |= r62;
        }
        if ((57344 & r27) == 0) {
            if (startRestartGroup.changed(j)) {
                r6 = DfuBaseService.ERROR_CONNECTION_MASK;
            } else {
                r6 = DfuBaseService.ERROR_REMOTE_MASK;
            }
            r5 |= r6;
        }
        if ((46811 & r5) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Arrangement.SpacedAligned m60spacedBy0680j_4 = Arrangement.m60spacedBy0680j_4(12);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 24, 7);
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m60spacedBy0680j_4, Alignment.Companion.Top, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                int r65 = 0;
                boolean z5 = false;
                AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 1773260185);
                while (true) {
                    boolean z6 = true;
                    if (r65 < r21) {
                        Intrinsics.checkNotNullParameter(str, "<this>");
                        if (r65 >= 0 && r65 <= StringsKt__StringsKt.getLastIndex(str)) {
                            ch = Character.valueOf(str.charAt(r65));
                        } else {
                            ch = null;
                        }
                        if (ch == null || (str2 = ch.toString()) == null) {
                            str2 = "";
                        }
                        if (1.0f > 0.0d) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                            companion.then(layoutWeightElement);
                            if (z && (!z2 ? r65 < str.length() : r65 <= str.length())) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (r65 != str.length() || !z2 || !z) {
                                z6 = false;
                            }
                            m1617CodeEntryyrwZFoE(str2, layoutWeightElement, z4, z6, j, startRestartGroup, r5 & 57344, 0);
                            r65++;
                            z5 = false;
                        } else {
                            throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
                        }
                    } else {
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, z5, z5, true, z5);
                        startRestartGroup.end(z5);
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        break;
                    }
                }
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.PinCodeFieldKt$CodeInputDecoration$2
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
                    PinCodeFieldKt.m1618CodeInputDecorationqFjXxE8(str, r21, z, z2, j, composer2, Strings.updateChangedFlags(r27 | 1));
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0083  */
    /* JADX WARN: Type inference failed for: r6v11, types: [com.animaconnected.widget.PinCodeFieldKt$PinCodeField$3$4, kotlin.jvm.internal.Lambda] */
    /* renamed from: PinCodeField-fWhpE4E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1619PinCodeFieldfWhpE4E(androidx.compose.ui.Modifier r31, final java.lang.String r32, int r33, long r34, kotlin.jvm.functions.Function0<java.lang.Boolean> r36, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 673
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.PinCodeFieldKt.m1619PinCodeFieldfWhpE4E(androidx.compose.ui.Modifier, java.lang.String, int, long, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: access$CodeInputDecoration-qFjXxE8 */
    public static final /* synthetic */ void m1622access$CodeInputDecorationqFjXxE8(String str, int r1, boolean z, boolean z2, long j, Composer composer, int r7) {
        m1618CodeInputDecorationqFjXxE8(str, r1, z, z2, j, composer, r7);
    }
}
