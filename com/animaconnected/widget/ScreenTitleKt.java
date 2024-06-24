package com.animaconnected.widget;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.IconKt;
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
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Constraints;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: ScreenTitle.kt */
/* loaded from: classes3.dex */
public final class ScreenTitleKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.animaconnected.widget.ScreenTitleKt$AllScreenImageTitle$1, kotlin.jvm.internal.Lambda] */
    public static final void AllScreenImageTitle(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1242790978);
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
            ThemeKt.BrandTheme(composeThemeProvider, ComposableLambdaKt.composableLambda(startRestartGroup, -835326638, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ScreenTitleKt$AllScreenImageTitle$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r8) {
                    if ((r8 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        ScreenTitleKt.ScreenImageTitle(null, StringsKt___StringsKt.take(6, ComposeThemeProvider.this.getClass().getSimpleName()), android.R.drawable.ic_menu_call, composer2, 384, 1);
                    }
                }
            }), startRestartGroup, (r0 & 14) | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ScreenTitleKt$AllScreenImageTitle$2
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
                    ScreenTitleKt.AllScreenImageTitle(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.animaconnected.widget.ScreenTitleKt$AllScreenTitle$1, kotlin.jvm.internal.Lambda] */
    public static final void AllScreenTitle(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-199316929);
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
            ThemeKt.BrandTheme(composeThemeProvider, ComposableLambdaKt.composableLambda(startRestartGroup, -1487024337, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ScreenTitleKt$AllScreenTitle$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r52) {
                    if ((r52 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        ScreenTitleKt.ScreenTitleLarge(null, StringsKt___StringsKt.take(6, ComposeThemeProvider.this.getClass().getSimpleName()), composer2, 0, 1);
                    }
                }
            }), startRestartGroup, (r0 & 14) | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ScreenTitleKt$AllScreenTitle$2
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
                    ScreenTitleKt.AllScreenTitle(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    public static final void ScreenImageTitle(Modifier modifier, final String title, final int r32, Composer composer, final int r34, final int r35) {
        Modifier modifier2;
        int r3;
        int r33;
        int r4;
        int r42;
        Modifier modifier3;
        ComposerImpl composerImpl;
        final Modifier modifier4;
        Intrinsics.checkNotNullParameter(title, "title");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1052481186);
        int r1 = r35 & 1;
        if (r1 != 0) {
            r3 = r34 | 6;
            modifier2 = modifier;
        } else if ((r34 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r33 = 4;
            } else {
                r33 = 2;
            }
            r3 = r33 | r34;
        } else {
            modifier2 = modifier;
            r3 = r34;
        }
        if ((r35 & 2) != 0) {
            r3 |= 48;
        } else if ((r34 & 112) == 0) {
            if (startRestartGroup.changed(title)) {
                r4 = 32;
            } else {
                r4 = 16;
            }
            r3 |= r4;
        }
        if ((r35 & 4) != 0) {
            r3 |= 384;
        } else if ((r34 & 896) == 0) {
            if (startRestartGroup.changed(r32)) {
                r42 = 256;
            } else {
                r42 = 128;
            }
            r3 |= r42;
        }
        int r12 = r3;
        if ((r12 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier4 = modifier2;
            composerImpl = startRestartGroup;
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (r1 != 0) {
                modifier3 = companion;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            final float f = 28;
            final float f2 = 8;
            startRestartGroup.startReplaceableGroup(-161186581);
            Object nextSlot = startRestartGroup.nextSlot();
            if (nextSlot == Composer.Companion.Empty) {
                nextSlot = new MeasurePolicy() { // from class: com.animaconnected.widget.ScreenTitleKt$ScreenImageTitle$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int r36) {
                        return super.maxIntrinsicHeight(intrinsicMeasureScope, list, r36);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int r36) {
                        return super.maxIntrinsicWidth(intrinsicMeasureScope, list, r36);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo4measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                        final Placeable mo421measureBRTryo0 = measurables.get(0).mo421measureBRTryo0(j);
                        final Placeable mo421measureBRTryo02 = measurables.get(1).mo421measureBRTryo0(j);
                        final int m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
                        int max = Math.max(mo421measureBRTryo0.height, Math.max(mo421measureBRTryo02.height, Constraints.m566getMinHeightimpl(j)));
                        final int mo49toPx0680j_4 = (int) (Layout.mo49toPx0680j_4(f2) + Layout.mo49toPx0680j_4(f));
                        return Layout.layout(m565getMaxWidthimpl, max, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.animaconnected.widget.ScreenTitleKt$ScreenImageTitle$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope layout) {
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                int r0 = m565getMaxWidthimpl / 2;
                                int r13 = mo421measureBRTryo0.width;
                                int r2 = mo49toPx0680j_4;
                                int max2 = Math.max(0, (r0 - ((r13 - r2) / 2)) - r2);
                                Placeable placeable = mo421measureBRTryo0;
                                Placeable.PlacementScope.placeRelative$default(layout, placeable, max2, (mo421measureBRTryo02.height / 2) - (placeable.height / 2));
                                Placeable.PlacementScope.placeRelative$default(layout, mo421measureBRTryo02, max2, 0);
                            }
                        });
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int r36) {
                        return super.minIntrinsicHeight(intrinsicMeasureScope, list, r36);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int r36) {
                        return super.minIntrinsicWidth(intrinsicMeasureScope, list, r36);
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) nextSlot;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier3);
            int r36 = (((((r12 << 3) & 112) | 384) << 9) & 7168) | 6;
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                modifierMaterializerOf.invoke(new SkippableUpdater(startRestartGroup), startRestartGroup, Integer.valueOf((r36 >> 3) & 112));
                startRestartGroup.startReplaceableGroup(2058660585);
                Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, f + f2, 0.0f, 0.0f, 0.0f, 14);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                androidx.compose.material.TextKt.m216Text4IGK_g(title, m75paddingqDBjuR0$default, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h1, startRestartGroup, ((r12 >> 3) & 14) | 48, 0, 65528);
                composerImpl = startRestartGroup;
                IconKt.m187Iconww6aTOc(PainterResources_androidKt.painterResource(r32, composerImpl), title, SizeKt.m91size3ABfNKs(companion, f), ((Colors) composerImpl.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), composerImpl, (r12 & 112) | 392, 0);
                composerImpl.end(false);
                composerImpl.end(true);
                composerImpl.end(false);
                modifier4 = modifier3;
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ScreenTitleKt$ScreenImageTitle$3
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
                    ScreenTitleKt.ScreenImageTitle(Modifier.this, title, r32, composer2, Strings.updateChangedFlags(r34 | 1), r35);
                }
            };
        }
    }

    public static final void ScreenTitle(Modifier modifier, final String title, Composer composer, final int r30, final int r31) {
        final Modifier modifier2;
        int r3;
        int r32;
        int r5;
        Modifier modifier3;
        Modifier fillMaxWidth;
        ComposerImpl composerImpl;
        Intrinsics.checkNotNullParameter(title, "title");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1338676070);
        int r1 = r31 & 1;
        if (r1 != 0) {
            r3 = r30 | 6;
            modifier2 = modifier;
        } else if ((r30 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r32 = 4;
            } else {
                r32 = 2;
            }
            r3 = r32 | r30;
        } else {
            modifier2 = modifier;
            r3 = r30;
        }
        if ((r31 & 2) != 0) {
            r3 |= 48;
        } else if ((r30 & 112) == 0) {
            if (startRestartGroup.changed(title)) {
                r5 = 32;
            } else {
                r5 = 16;
            }
            r3 |= r5;
        }
        int r21 = r3;
        if ((r21 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            if (r1 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU();
            fillMaxWidth = SizeKt.fillMaxWidth(modifier3, 1.0f);
            composerImpl = startRestartGroup;
            androidx.compose.material.TextKt.m216Text4IGK_g(title, PaddingKt.m73paddingVpY3zN4$default(fillMaxWidth, 32, 0.0f, 2), m166getOnBackground0d7_KjU, 0L, null, null, null, 0L, null, new TextAlign(3), 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h1, composerImpl, (r21 >> 3) & 14, 0, 65016);
            modifier2 = modifier3;
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ScreenTitleKt$ScreenTitle$1
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
                    ScreenTitleKt.ScreenTitle(Modifier.this, title, composer2, Strings.updateChangedFlags(r30 | 1), r31);
                }
            };
        }
    }

    public static final void ScreenTitleLarge(Modifier modifier, final String title, Composer composer, final int r30, final int r31) {
        final Modifier modifier2;
        int r3;
        int r32;
        int r4;
        Modifier modifier3;
        Modifier fillMaxWidth;
        ComposerImpl composerImpl;
        Intrinsics.checkNotNullParameter(title, "title");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-557581925);
        int r1 = r31 & 1;
        if (r1 != 0) {
            r3 = r30 | 6;
            modifier2 = modifier;
        } else if ((r30 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r32 = 4;
            } else {
                r32 = 2;
            }
            r3 = r32 | r30;
        } else {
            modifier2 = modifier;
            r3 = r30;
        }
        if ((r31 & 2) != 0) {
            r3 |= 48;
        } else if ((r30 & 112) == 0) {
            if (startRestartGroup.changed(title)) {
                r4 = 32;
            } else {
                r4 = 16;
            }
            r3 |= r4;
        }
        int r21 = r3;
        if ((r21 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            if (r1 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            fillMaxWidth = SizeKt.fillMaxWidth(modifier3, 1.0f);
            composerImpl = startRestartGroup;
            androidx.compose.material.TextKt.m216Text4IGK_g(title, fillMaxWidth, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, new TextAlign(3), 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h6, composerImpl, (r21 >> 3) & 14, 0, 65016);
            modifier2 = modifier3;
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ScreenTitleKt$ScreenTitleLarge$1
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
                    ScreenTitleKt.ScreenTitleLarge(Modifier.this, title, composer2, Strings.updateChangedFlags(r30 | 1), r31);
                }
            };
        }
    }
}
