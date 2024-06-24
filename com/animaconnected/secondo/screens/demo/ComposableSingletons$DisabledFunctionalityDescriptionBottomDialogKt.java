package com.animaconnected.secondo.screens.demo;

import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
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
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisabledFunctionalityDescriptionBottomDialog.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt {
    public static final ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt INSTANCE = new ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<Function0<Unit>, Composer, Integer, Unit> f71lambda1 = ComposableLambdaKt.composableLambdaInstance(1658842872, new Function3<Function0<? extends Unit>, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, Composer composer, Integer num) {
            invoke((Function0<Unit>) function0, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r4v4, types: [com.animaconnected.secondo.screens.demo.ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt$lambda-1$1$1, kotlin.jvm.internal.Lambda] */
        public final void invoke(final Function0<Unit> dismissDialog, Composer composer, int r4) {
            Intrinsics.checkNotNullParameter(dismissDialog, "dismissDialog");
            if ((r4 & 14) == 0) {
                r4 |= composer.changedInstance(dismissDialog) ? 4 : 2;
            }
            if ((r4 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, 186639623, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt$lambda-1$1.1
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
                        if ((r5 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                            DisabledFunctionalityDescriptionBottomDialogKt.DisabledFunctionalityDialogContent(URLProtocolKt.stringResource(R.string.demo_brand_account_disabled_title, composer2), URLProtocolKt.stringResource(R.string.demo_this_is_not_available_in_demo_mode, composer2), dismissDialog, composer2, 0);
                        }
                    }
                }), composer, 6);
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f72lambda2 = ComposableLambdaKt.composableLambdaInstance(795450512, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope ButtonOutlined, Composer composer, int r30) {
            Intrinsics.checkNotNullParameter(ButtonOutlined, "$this$ButtonOutlined");
            if ((r30 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            String upperCase = URLProtocolKt.stringResource(R.string.activity_ok, composer).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.m216Text4IGK_g(upperCase, null, ((Colors) composer.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer.consume(TypographyKt.LocalTypography)).button, composer, 0, 0, 65530);
        }
    }, false);

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f73lambda3 = ComposableLambdaKt.composableLambdaInstance(-1901194156, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r8) {
            Modifier m21backgroundbw27NRU;
            if ((r8 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), Color.White, RectangleShapeKt.RectangleShape);
            composer.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.TopStart, false, composer);
            composer.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer);
            PersistentCompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
            if (composer.getApplier() instanceof Applier) {
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    composer.useNode();
                }
                Updater.m228setimpl(composer, rememberBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(composer, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer), composer, 2058660585);
                DisabledFunctionalityDescriptionBottomDialogKt.DisabledFunctionalityDialogContent(URLProtocolKt.stringResource(R.string.demo_brand_account_disabled_title, composer), URLProtocolKt.stringResource(R.string.demo_this_is_not_available_in_demo_mode, composer), new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.demo.ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt$lambda-3$1$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, composer, 384);
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                return;
            }
            ComposablesKt.invalidApplier();
            throw null;
        }
    }, false);

    /* renamed from: getLambda-1$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<Function0<Unit>, Composer, Integer, Unit> m912getLambda1$secondo_kronabyRelease() {
        return f71lambda1;
    }

    /* renamed from: getLambda-2$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m913getLambda2$secondo_kronabyRelease() {
        return f72lambda2;
    }

    /* renamed from: getLambda-3$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m914getLambda3$secondo_kronabyRelease() {
        return f73lambda3;
    }
}
