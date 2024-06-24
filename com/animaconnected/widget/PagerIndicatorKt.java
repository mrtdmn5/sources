package com.animaconnected.widget;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$Center$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagerIndicator.kt */
/* loaded from: classes3.dex */
public final class PagerIndicatorKt {
    public static final void PagerIndicator(final int r10, final int r11, Modifier modifier, Composer composer, final int r14, final int r15) {
        int r0;
        int r02;
        int r1;
        int r2;
        long j;
        Modifier m21backgroundbw27NRU;
        ComposerImpl startRestartGroup = composer.startRestartGroup(64330495);
        if ((r15 & 1) != 0) {
            r0 = r14 | 6;
        } else if ((r14 & 14) == 0) {
            if (startRestartGroup.changed(r10)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r14;
        } else {
            r0 = r14;
        }
        if ((r15 & 2) != 0) {
            r0 |= 48;
        } else if ((r14 & 112) == 0) {
            if (startRestartGroup.changed(r11)) {
                r1 = 32;
            } else {
                r1 = 16;
            }
            r0 |= r1;
        }
        int r12 = r15 & 4;
        if (r12 != 0) {
            r0 |= 384;
        } else if ((r14 & 896) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r2 = 256;
            } else {
                r2 = 128;
            }
            r0 |= r2;
        }
        if ((r0 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (r12 != 0) {
                modifier = companion;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Arrangement$Center$1 arrangement$Center$1 = Arrangement.Center;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$Center$1, Alignment.Companion.Top, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int r03 = (((((((r0 >> 6) & 14) | 48) << 3) & 112) << 9) & 7168) | 6;
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
                AnimatedContentKt$$ExternalSyntheticOutline1.m((r03 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 351837982);
                for (int r13 = 0; r13 < r10; r13++) {
                    startRestartGroup.startReplaceableGroup(573671034);
                    if (r11 == r13) {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        j = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m172getSecondary0d7_KjU();
                    } else {
                        j = Color.DarkGray;
                    }
                    startRestartGroup.end(false);
                    m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(ClipKt.clip(PaddingKt.m73paddingVpY3zN4$default(companion, 4, 0.0f, 2), RoundedCornerShapeKt.CircleShape), j, RectangleShapeKt.RectangleShape);
                    BoxKt.Box(SizeKt.m91size3ABfNKs(m21backgroundbw27NRU, 8), startRestartGroup, 0);
                }
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
                startRestartGroup.end(false);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        final Modifier modifier2 = modifier;
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.PagerIndicatorKt$PagerIndicator$2
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
                    PagerIndicatorKt.PagerIndicator(r10, r11, modifier2, composer2, Strings.updateChangedFlags(r14 | 1), r15);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewPagerIndicator(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1445977482);
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
            ThemeKt.BrandTheme(composeThemeProvider, ComposableSingletons$PagerIndicatorKt.INSTANCE.m1593getLambda1$widget_release(), startRestartGroup, (r0 & 14) | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.PagerIndicatorKt$PreviewPagerIndicator$1
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
                    PagerIndicatorKt.PreviewPagerIndicator(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }
}
