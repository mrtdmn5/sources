package com.animaconnected.secondo.screens.demo;

import android.app.Activity;
import android.content.Context;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.HorizontalAlignElement;
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
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
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
import com.animaconnected.widget.ButtonBorderlessKt;
import com.animaconnected.widget.ButtonOutlinedKt;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisableDemoModeBottomDialog.kt */
/* loaded from: classes3.dex */
public final class DisableDemoModeBottomDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void DialogContent(final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int r33) {
        int r4;
        boolean z;
        boolean z2;
        boolean z3;
        int r5;
        ComposerImpl startRestartGroup = composer.startRestartGroup(764944891);
        int r52 = 4;
        if ((r33 & 14) == 0) {
            if (!startRestartGroup.changedInstance(function0)) {
                r52 = 2;
            }
            r4 = r52 | r33;
        } else {
            r4 = r33;
        }
        if ((r33 & 112) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                r5 = 32;
            } else {
                r5 = 16;
            }
            r4 |= r5;
        }
        int r29 = r4;
        if ((r29 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 32);
            Arrangement.SpacedAligned m60spacedBy0680j_4 = Arrangement.m60spacedBy0680j_4(16);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m60spacedBy0680j_4, horizontal, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
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
                TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.demo_retail_demo_mode, startRestartGroup), new HorizontalAlignElement(horizontal), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h1, startRestartGroup, 0, 0, 65528);
                startRestartGroup.startReplaceableGroup(208451855);
                int r12 = r29 & 14;
                if (r12 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                if ((r29 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z4 = z | z2;
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (z4 || nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.demo.DisableDemoModeBottomDialogKt$DialogContent$1$1$1
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
                            function02.invoke();
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                ButtonOutlinedKt.ButtonOutlined(null, (Function0) nextSlot, false, true, ComposableSingletons$DisableDemoModeBottomDialogKt.INSTANCE.m910getLambda2$secondo_kronabyRelease(), startRestartGroup, 27648, 5);
                String stringResource = URLProtocolKt.stringResource(R.string.button_cancel, startRestartGroup);
                startRestartGroup.startReplaceableGroup(208452307);
                if (r12 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z3 || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.demo.DisableDemoModeBottomDialogKt$DialogContent$1$2$1
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
                ButtonBorderlessKt.ButtonBorderless(null, stringResource, true, false, (Function0) nextSlot2, startRestartGroup, 384, 9);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.DisableDemoModeBottomDialogKt$DialogContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r42) {
                    DisableDemoModeBottomDialogKt.DialogContent(function0, function02, composer2, Strings.updateChangedFlags(r33 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewDialogContent(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(289497161);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableSingletons$DisableDemoModeBottomDialogKt.INSTANCE.m911getLambda3$secondo_kronabyRelease(), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.DisableDemoModeBottomDialogKt$PreviewDialogContent$1
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
                    DisableDemoModeBottomDialogKt.PreviewDialogContent(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final BottomDialog showDisableDemoModeBottomDialog(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        return BottomSheetKt.showBottomDialog((Context) activity, false, (Function3<? super Function0<Unit>, ? super Composer, ? super Integer, Unit>) ComposableSingletons$DisableDemoModeBottomDialogKt.INSTANCE.m909getLambda1$secondo_kronabyRelease());
    }
}
