package com.animaconnected.widget;

import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
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

/* compiled from: BackgroundCard.kt */
/* loaded from: classes3.dex */
public final class BackgroundCardKt {
    private static final float whiteSpaceBackgroundCard = 12;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.animaconnected.widget.BackgroundCardKt$AllBackgroundCards$1, kotlin.jvm.internal.Lambda] */
    public static final void AllBackgroundCards(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-610798500);
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
            ThemeKt.BrandTheme(composeThemeProvider, ComposableLambdaKt.composableLambda(startRestartGroup, -522034836, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.BackgroundCardKt$AllBackgroundCards$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r14v3, types: [kotlin.jvm.internal.Lambda, com.animaconnected.widget.BackgroundCardKt$AllBackgroundCards$1$1] */
                public final void invoke(Composer composer2, int r14) {
                    if ((r14 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    final ComposeThemeProvider composeThemeProvider2 = ComposeThemeProvider.this;
                    BackgroundCardKt.m1586BackgroundCardUalQlp0(null, null, null, null, 0L, 0.0f, false, ComposableLambdaKt.composableLambda(composer2, 321606494, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.BackgroundCardKt$AllBackgroundCards$1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int r54) {
                            if ((r54 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                            Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(Modifier.Companion.$$INSTANCE, 16);
                            ComposeThemeProvider composeThemeProvider3 = ComposeThemeProvider.this;
                            composer3.startReplaceableGroup(-483455358);
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer3);
                            composer3.startReplaceableGroup(-1323940314);
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3);
                            PersistentCompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
                            if (composer3.getApplier() instanceof Applier) {
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(layoutNode$Companion$Constructor$1);
                                } else {
                                    composer3.useNode();
                                }
                                Updater.m228setimpl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                Updater.m228setimpl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer3, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                                }
                                modifierMaterializerOf.invoke((Object) new SkippableUpdater(composer3), (Object) composer3, (Object) 0);
                                composer3.startReplaceableGroup(2058660585);
                                String simpleName = composeThemeProvider3.getClass().getSimpleName();
                                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                                long m169getOnSurface0d7_KjU = ((Colors) composer3.consume(staticProvidableCompositionLocal)).m169getOnSurface0d7_KjU();
                                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
                                androidx.compose.material.TextKt.m216Text4IGK_g(simpleName, null, m169getOnSurface0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer3.consume(staticProvidableCompositionLocal2)).h4, composer3, 0, 0, 65530);
                                androidx.compose.material.TextKt.m216Text4IGK_g("consectetur adipiscing elit", null, ((Colors) composer3.consume(staticProvidableCompositionLocal)).m169getOnSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer3.consume(staticProvidableCompositionLocal2)).body1, composer3, 6, 0, 65530);
                                DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer3);
                                return;
                            }
                            ComposablesKt.invalidApplier();
                            throw null;
                        }
                    }), composer2, 12582912, com.animaconnected.secondo.R.styleable.AppTheme_statusTextH5);
                }
            }), startRestartGroup, (r0 & 14) | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.BackgroundCardKt$AllBackgroundCards$2
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
                    BackgroundCardKt.AllBackgroundCards(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c9  */
    /* JADX WARN: Type inference failed for: r13v1, types: [com.animaconnected.widget.BackgroundCardKt$BackgroundCard$2, kotlin.jvm.internal.Lambda] */
    /* renamed from: BackgroundCard-UalQlp0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1586BackgroundCardUalQlp0(androidx.compose.ui.Modifier r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.graphics.Shape r31, androidx.compose.foundation.BorderStroke r32, long r33, float r35, boolean r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 601
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.BackgroundCardKt.m1586BackgroundCardUalQlp0(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, long, float, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0183, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r0.nextSlot(), java.lang.Integer.valueOf(r10)) == false) goto L109;     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0113 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x009e  */
    /* renamed from: BackgroundCardNinePatch-Y3c_0f4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1587BackgroundCardNinePatchY3c_0f4(final int r20, androidx.compose.ui.Modifier r21, androidx.compose.ui.Modifier r22, androidx.compose.ui.unit.Dp r23, kotlin.jvm.functions.Function0<kotlin.Unit> r24, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.BackgroundCardKt.m1587BackgroundCardNinePatchY3c_0f4(int, androidx.compose.ui.Modifier, androidx.compose.ui.Modifier, androidx.compose.ui.unit.Dp, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getWhiteSpaceBackgroundCard() {
        return whiteSpaceBackgroundCard;
    }
}
