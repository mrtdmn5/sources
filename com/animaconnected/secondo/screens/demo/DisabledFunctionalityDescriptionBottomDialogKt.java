package com.animaconnected.secondo.screens.demo;

import android.content.Context;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.widget.ButtonOutlinedKt;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisabledFunctionalityDescriptionBottomDialog.kt */
/* loaded from: classes3.dex */
public final class DisabledFunctionalityDescriptionBottomDialogKt {
    public static final void DisabledFunctionalityDialogContent(final String title, final String description, Function0<Unit> dismissDialog, Composer composer, final int r60) {
        int r2;
        ComposerImpl composerImpl;
        boolean z;
        final Function0<Unit> function0;
        int r3;
        int r22;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(dismissDialog, "dismissDialog");
        ComposerImpl startRestartGroup = composer.startRestartGroup(721866003);
        if ((r60 & 14) == 0) {
            if (startRestartGroup.changed(title)) {
                r22 = 4;
            } else {
                r22 = 2;
            }
            r2 = r22 | r60;
        } else {
            r2 = r60;
        }
        if ((r60 & 112) == 0) {
            if (startRestartGroup.changed(description)) {
                r3 = 32;
            } else {
                r3 = 16;
            }
            r2 |= r3;
        }
        int r8 = 256;
        if ((r60 & 896) == 0) {
            if (!startRestartGroup.changedInstance(dismissDialog)) {
                r8 = 128;
            }
            r2 |= r8;
        }
        int r15 = r2;
        if ((r15 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
            function0 = dismissDialog;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            float f = 32;
            float f2 = 48;
            Modifier m74paddingqDBjuR0 = PaddingKt.m74paddingqDBjuR0(SizeKt.fillMaxWidth$default(SizeKt.wrapContentHeight$default(companion)), f, f2, f, f2);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            Arrangement.SpacedAligned m60spacedBy0680j_4 = Arrangement.m60spacedBy0680j_4(24);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m60spacedBy0680j_4, horizontal, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m74paddingqDBjuR0);
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
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                long m168getOnSecondary0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m168getOnSecondary0d7_KjU();
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
                TextKt.m216Text4IGK_g(title, null, m168getOnSecondary0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).h1, startRestartGroup, r15 & 14, 0, 65530);
                composerImpl = startRestartGroup;
                TextKt.m216Text4IGK_g(description, null, ((Colors) composerImpl.consume(staticProvidableCompositionLocal)).m174getSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composerImpl.consume(staticProvidableCompositionLocal2)).body1, composerImpl, (r15 >> 3) & 14, 0, 65530);
                Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, f, 0.0f, 0.0f, 13);
                composerImpl.startReplaceableGroup(1245650336);
                if ((r15 & 896) == 256) {
                    z = true;
                } else {
                    z = false;
                }
                Object nextSlot = composerImpl.nextSlot();
                if (!z && nextSlot != Composer.Companion.Empty) {
                    function0 = dismissDialog;
                } else {
                    function0 = dismissDialog;
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.demo.DisabledFunctionalityDescriptionBottomDialogKt$DisabledFunctionalityDialogContent$1$1$1
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
                    composerImpl.updateValue(nextSlot);
                }
                composerImpl.end(false);
                ButtonOutlinedKt.ButtonOutlined(m75paddingqDBjuR0$default, (Function0) nextSlot, false, true, ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt.INSTANCE.m913getLambda2$secondo_kronabyRelease(), composerImpl, 27654, 4);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.DisabledFunctionalityDescriptionBottomDialogKt$DisabledFunctionalityDialogContent$2
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
                    DisabledFunctionalityDescriptionBottomDialogKt.DisabledFunctionalityDialogContent(title, description, function0, composer2, Strings.updateChangedFlags(r60 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewDialogContent(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-659498172);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt.INSTANCE.m914getLambda3$secondo_kronabyRelease(), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.DisabledFunctionalityDescriptionBottomDialogKt$PreviewDialogContent$1
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
                    DisabledFunctionalityDescriptionBottomDialogKt.PreviewDialogContent(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final BottomDialog showSignInDisabledInfoBottomDialog(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return BottomSheetKt.showBottomDialog$default(ctx, false, ComposableSingletons$DisabledFunctionalityDescriptionBottomDialogKt.INSTANCE.m912getLambda1$secondo_kronabyRelease(), 2, null);
    }
}
