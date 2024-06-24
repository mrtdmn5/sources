package com.animaconnected.secondo.screens.activity;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
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
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.text.TextStyle;
import com.animaconnected.widget.ButtonOutlinedKt;
import com.animaconnected.widget.TopbarKt;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: ActivitySetupFragment.kt */
/* loaded from: classes3.dex */
public final class ActivitySetupFragmentKt {
    public static final void ActivitySetupScreen(final String str, final boolean z, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int r68) {
        int r4;
        long m164getBackground0d7_KjU;
        boolean z2;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        int r6;
        int r62;
        int r63;
        int r42;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-236191032);
        if ((r68 & 14) == 0) {
            if (startRestartGroup.changed(str)) {
                r42 = 4;
            } else {
                r42 = 2;
            }
            r4 = r42 | r68;
        } else {
            r4 = r68;
        }
        if ((r68 & 112) == 0) {
            if (startRestartGroup.changed(z)) {
                r63 = 32;
            } else {
                r63 = 16;
            }
            r4 |= r63;
        }
        if ((r68 & 896) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r62 = 256;
            } else {
                r62 = 128;
            }
            r4 |= r62;
        }
        if ((r68 & 7168) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                r6 = 2048;
            } else {
                r6 = 1024;
            }
            r4 |= r6;
        }
        if ((r4 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            if (z) {
                startRestartGroup.startReplaceableGroup(-924785791);
                m164getBackground0d7_KjU = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU();
            } else {
                startRestartGroup.startReplaceableGroup(-924785757);
                m164getBackground0d7_KjU = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m164getBackground0d7_KjU();
            }
            startRestartGroup.end(false);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(companion, m164getBackground0d7_KjU, RectangleShapeKt.RectangleShape);
            startRestartGroup.startReplaceableGroup(-483455358);
            Arrangement$Top$1 arrangement$Top$1 = Arrangement.Top;
            BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
            Applier<?> applier = startRestartGroup.applier;
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$12);
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
                String stringResource = URLProtocolKt.stringResource(R.string.feature_path_activity, startRestartGroup);
                startRestartGroup.startReplaceableGroup(1230617146);
                if ((r4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                if (z2 || nextSlot == Composer.Companion.Empty) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivitySetupFragmentKt$ActivitySetupScreen$1$1$1
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
                Modifier m73paddingVpY3zN4$default = PaddingKt.m73paddingVpY3zN4$default(companion, 16, 0.0f, 2);
                startRestartGroup.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m73paddingVpY3zN4$default);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$12;
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$12;
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, columnMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                    SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 10), startRestartGroup, 6);
                    String stringResource2 = URLProtocolKt.stringResource(R.string.activity_daily, startRestartGroup);
                    HorizontalAlignElement horizontalAlignElement = new HorizontalAlignElement(Alignment.Companion.CenterHorizontally);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = TypographyKt.LocalTypography;
                    TextStyle textStyle = ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).h1;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = ColorsKt.LocalColors;
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$13 = layoutNode$Companion$Constructor$1;
                    TextKt.m216Text4IGK_g(stringResource2, horizontalAlignElement, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal2)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, startRestartGroup, 0, 0, 65528);
                    SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 32), startRestartGroup, 6);
                    TextKt.m216Text4IGK_g(str, null, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal2)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).body1, startRestartGroup, r4 & 14, 0, 65530);
                    BiasAlignment biasAlignment = Alignment.Companion.BottomCenter;
                    Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(SizeKt.fillMaxSize$default(companion), 0.0f, 0.0f, 0.0f, 56, 7);
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, startRestartGroup);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                    PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                    ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
                    if (applier instanceof Applier) {
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.inserting) {
                            startRestartGroup.createNode(layoutNode$Companion$Constructor$13);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                            AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf3, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                        ButtonOutlinedKt.ButtonOutlined(null, function02, false, false, ComposableSingletons$ActivitySetupFragmentKt.INSTANCE.m831getLambda1$secondo_kronabyRelease(), startRestartGroup, ((r4 >> 6) & 112) | 24576, 13);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    } else {
                        ComposablesKt.invalidApplier();
                        throw null;
                    }
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
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivitySetupFragmentKt$ActivitySetupScreen$2
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
                    ActivitySetupFragmentKt.ActivitySetupScreen(str, z, function0, function02, composer2, Strings.updateChangedFlags(r68 | 1));
                }
            };
        }
    }

    public static final void PreviewActivitySetup(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-315296339);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        PreviewScreen(composeThemeProvider, false, startRestartGroup, 56);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivitySetupFragmentKt$PreviewActivitySetup$1
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
                    ActivitySetupFragmentKt.PreviewActivitySetup(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final void PreviewActivitySetupDetailed(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1884657027);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        PreviewScreen(composeThemeProvider, true, startRestartGroup, 56);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivitySetupFragmentKt$PreviewActivitySetupDetailed$1
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
                    ActivitySetupFragmentKt.PreviewActivitySetupDetailed(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.animaconnected.secondo.screens.activity.ActivitySetupFragmentKt$PreviewScreen$1, kotlin.jvm.internal.Lambda] */
    public static final void PreviewScreen(final ComposeThemeProvider composeThemeProvider, final boolean z, Composer composer, final int r5) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1833859389);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ThemeKt.BrandTheme(composeThemeProvider, ComposableLambdaKt.composableLambda(startRestartGroup, -1102791725, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivitySetupFragmentKt$PreviewScreen$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                boolean z2 = z;
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
                    ActivitySetupFragmentKt.ActivitySetupScreen(URLProtocolKt.stringResource(R.string.activity_activate_description, composer2), z2, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivitySetupFragmentKt$PreviewScreen$1$1$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivitySetupFragmentKt$PreviewScreen$1$1$2
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, composer2, 3456);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, 56);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivitySetupFragmentKt$PreviewScreen$2
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
                    ActivitySetupFragmentKt.PreviewScreen(ComposeThemeProvider.this, z, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    public static final /* synthetic */ void access$ActivitySetupScreen(String str, boolean z, Function0 function0, Function0 function02, Composer composer, int r5) {
        ActivitySetupScreen(str, z, function0, function02, composer, r5);
    }
}
