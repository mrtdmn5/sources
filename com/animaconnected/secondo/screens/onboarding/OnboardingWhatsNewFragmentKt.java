package com.animaconnected.secondo.screens.onboarding;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
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
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import com.animaconnected.widget.ButtonOutlinedKt;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingWhatsNewFragment.kt */
/* loaded from: classes3.dex */
public final class OnboardingWhatsNewFragmentKt {
    public static final void PreviewWhatsNewScreen(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(324569496);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ThemeKt.BrandTheme(composeThemeProvider, ComposableSingletons$OnboardingWhatsNewFragmentKt.INSTANCE.m944getLambda2$secondo_kronabyRelease(), startRestartGroup, 56);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWhatsNewFragmentKt$PreviewWhatsNewScreen$1
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
                    OnboardingWhatsNewFragmentKt.PreviewWhatsNewScreen(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final void WhatsNewScreen(final List<WhatsNewUiItem> list, final Function0<Unit> function0, Composer composer, final int r38) {
        Modifier m21backgroundbw27NRU;
        ComposerImpl startRestartGroup = composer.startRestartGroup(114298214);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(SizeKt.fillMaxSize$default(companion), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m164getBackground0d7_KjU(), RectangleShapeKt.RectangleShape);
        startRestartGroup.startReplaceableGroup(733328855);
        BiasAlignment biasAlignment = Alignment.Companion.TopStart;
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
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
            modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            float f = 32;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m73paddingVpY3zN4$default(BoxScopeInstance.INSTANCE.align(SizeKt.fillMaxSize$default(companion), biasAlignment), f, 0.0f, 2), ScrollKt.rememberScrollState(startRestartGroup), false, 14);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(verticalScroll$default);
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
                modifierMaterializerOf2.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 72), startRestartGroup, 6);
                String stringResource = URLProtocolKt.stringResource(R.string.onboarding_whatsnew_title, startRestartGroup);
                Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                TextAlign textAlign = new TextAlign(3);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = TypographyKt.LocalTypography;
                TextKt.m216Text4IGK_g(stringResource, fillMaxWidth, 0L, 0L, null, null, null, 0L, null, textAlign, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).h1, startRestartGroup, 48, 0, 65020);
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, f), startRestartGroup, 6);
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.validate_marble, startRestartGroup), null, columnScopeInstance.align(companion), null, null, 0.0f, null, startRestartGroup, 56, 120);
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 48), startRestartGroup, 6);
                TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.onboarding_whatsnew_list_title, startRestartGroup), SizeKt.fillMaxWidth(companion, 1.0f), 0L, 0L, null, null, null, 0L, null, new TextAlign(3), 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).h5, startRestartGroup, 48, 0, 65020);
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 16), startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-458897104);
                float f2 = 1.0f;
                for (WhatsNewUiItem whatsNewUiItem : list) {
                    String stringResource2 = URLProtocolKt.stringResource(whatsNewUiItem.getTitle(), startRestartGroup);
                    Modifier fillMaxWidth2 = SizeKt.fillMaxWidth(companion, f2);
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
                    TextKt.m216Text4IGK_g(stringResource2, fillMaxWidth2, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).caption, startRestartGroup, 48, 0, 65532);
                    SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 4), startRestartGroup, 6);
                    TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(whatsNewUiItem.getDescription(), startRestartGroup), SizeKt.fillMaxWidth(companion, 1.0f), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).body1, startRestartGroup, 48, 0, 65532);
                    SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 24), startRestartGroup, 6);
                    f2 = 1.0f;
                }
                startRestartGroup.end(false);
                SpacerKt.Spacer(columnScopeInstance.weight(companion, 1.0f, true), startRestartGroup, 0);
                ButtonOutlinedKt.ButtonOutlined(columnScopeInstance.align(companion), function0, false, false, ComposableSingletons$OnboardingWhatsNewFragmentKt.INSTANCE.m943getLambda1$secondo_kronabyRelease(), startRestartGroup, (r38 & 112) | 24576, 12);
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 56), startRestartGroup, 6);
                startRestartGroup.end(false);
                startRestartGroup.end(true);
                startRestartGroup.end(false);
                startRestartGroup.end(false);
                startRestartGroup.end(false);
                startRestartGroup.end(true);
                startRestartGroup.end(false);
                startRestartGroup.end(false);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWhatsNewFragmentKt$WhatsNewScreen$2
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
                            OnboardingWhatsNewFragmentKt.WhatsNewScreen(list, function0, composer2, Strings.updateChangedFlags(r38 | 1));
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

    public static final /* synthetic */ void access$WhatsNewScreen(List list, Function0 function0, Composer composer, int r3) {
        WhatsNewScreen(list, function0, composer, r3);
    }
}
