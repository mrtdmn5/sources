package com.animaconnected.secondo.screens.demo;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ProgressIndicatorKt;
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
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import com.animaconnected.widget.ButtonOutlinedKt;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: EnableDemoModeBottomDialog.kt */
/* loaded from: classes3.dex */
public final class EnableDemoModeBottomDialogKt {
    /* JADX WARN: Type inference failed for: r7v12, types: [com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$DialogContent$1$2, kotlin.jvm.internal.Lambda] */
    public static final void DialogContent(final Function0<Unit> function0, final Function0<Unit> function02, final boolean z, Composer composer, final int r42) {
        int r5;
        boolean z2;
        boolean z3;
        int r6;
        int r62;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-473567374);
        int r63 = 4;
        if ((r42 & 14) == 0) {
            if (!startRestartGroup.changedInstance(function0)) {
                r63 = 2;
            }
            r5 = r63 | r42;
        } else {
            r5 = r42;
        }
        if ((r42 & 112) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                r62 = 32;
            } else {
                r62 = 16;
            }
            r5 |= r62;
        }
        if ((r42 & 896) == 0) {
            if (startRestartGroup.changed(z)) {
                r6 = 256;
            } else {
                r6 = 128;
            }
            r5 |= r6;
        }
        int r14 = r5;
        if ((r14 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 32);
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
                String stringResource = URLProtocolKt.stringResource(R.string.demo_confirm_warning, startRestartGroup);
                long j = Color.Red;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = TypographyKt.LocalTypography;
                TextKt.m216Text4IGK_g(stringResource, new HorizontalAlignElement(horizontal), j, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).h2, startRestartGroup, 384, 0, 65528);
                String stringResource2 = URLProtocolKt.stringResource(R.string.demo_confirm_title, startRestartGroup);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = ColorsKt.LocalColors;
                TextKt.m216Text4IGK_g(stringResource2, new HorizontalAlignElement(horizontal), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal2)).m174getSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).h1, startRestartGroup, 0, 0, 65528);
                TextKt.m217TextIbK3jfQ(com.animaconnected.widget.TextKt.annotatedStringResource(R.string.demo_confirm_description, startRestartGroup, 6), new HorizontalAlignElement(horizontal), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal2)).m174getSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).body1, startRestartGroup, 0, 0, 131064);
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 8), startRestartGroup, 6);
                boolean z4 = !z;
                startRestartGroup.startReplaceableGroup(208456685);
                if ((r14 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (z2 || nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$DialogContent$1$1$1
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
                            function02.invoke();
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                ButtonOutlinedKt.ButtonOutlined(null, (Function0) nextSlot, z4, true, ComposableLambdaKt.composableLambda(startRestartGroup, 1324868885, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$DialogContent$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope ButtonOutlined, Composer composer2, int r30) {
                        Intrinsics.checkNotNullParameter(ButtonOutlined, "$this$ButtonOutlined");
                        if ((r30 & 81) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        BiasAlignment biasAlignment = Alignment.Companion.Center;
                        boolean z5 = z;
                        composer2.startReplaceableGroup(733328855);
                        Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, composer2);
                        composer2.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                        PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
                        ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                        if (composer2.getApplier() instanceof Applier) {
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(layoutNode$Companion$Constructor$12);
                            } else {
                                composer2.useNode();
                            }
                            Updater.m228setimpl(composer2, rememberBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
                            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer2, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$12);
                            }
                            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf2, new SkippableUpdater(composer2), composer2, 2058660585);
                            String stringResource3 = URLProtocolKt.stringResource(R.string.demo_confirm_button_enable_demo_mode, composer2);
                            StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = ColorsKt.LocalColors;
                            com.animaconnected.widget.TextKt.m1633CapsTextfLXpl1I(stringResource3, null, ((Colors) composer2.consume(staticProvidableCompositionLocal3)).m174getSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, ((Typography) composer2.consume(TypographyKt.LocalTypography)).button, composer2, 0, 0, 32762);
                            composer2.startReplaceableGroup(606777828);
                            if (z5) {
                                ProgressIndicatorKt.m195CircularProgressIndicatorLxG7B9w(0.0f, 0, 6, 28, ((Colors) composer2.consume(staticProvidableCompositionLocal3)).m173getSecondaryVariant0d7_KjU(), 0L, composer2, SizeKt.m91size3ABfNKs(companion2, 32));
                            }
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            return;
                        }
                        ComposablesKt.invalidApplier();
                        throw null;
                    }
                }), startRestartGroup, 27648, 1);
                startRestartGroup.startReplaceableGroup(208457401);
                if ((r14 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z3 || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$DialogContent$1$3$1
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
                ButtonOutlinedKt.ButtonOutlined(null, (Function0) nextSlot2, z4, true, ComposableSingletons$EnableDemoModeBottomDialogKt.INSTANCE.m915getLambda1$secondo_kronabyRelease(), startRestartGroup, 27648, 1);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$DialogContent$2
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
                    EnableDemoModeBottomDialogKt.DialogContent(function0, function02, z, composer2, Strings.updateChangedFlags(r42 | 1));
                }
            };
        }
    }

    public static final void PreviewDialogContent(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1777650184);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableSingletons$EnableDemoModeBottomDialogKt.INSTANCE.m916getLambda2$secondo_kronabyRelease(), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$PreviewDialogContent$1
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
                    EnableDemoModeBottomDialogKt.PreviewDialogContent(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final /* synthetic */ void access$DialogContent(Function0 function0, Function0 function02, boolean z, Composer composer, int r4) {
        DialogContent(function0, function02, z, composer, r4);
    }

    private static final void debug(String str, Throwable th) {
        LogKt.debug$default((Object) Unit.INSTANCE, str, "EnableDemoModeBottomDialog", th, false, 8, (Object) null);
    }

    public static /* synthetic */ void debug$default(String str, Throwable th, int r2, Object obj) {
        if ((r2 & 2) != 0) {
            th = null;
        }
        debug(str, th);
    }

    public static final Object ensureGoogleFitIsDisabled(Continuation<? super Boolean> continuation) {
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        if (!providerFactory.getGoogleFitProvider().isEnabled()) {
            return Boolean.TRUE;
        }
        return providerFactory.getGoogleFitProvider().disableGoogleFit(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object ensureSignedOutFromCloud(android.content.Context r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt.ensureSignedOutFromCloud(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object ensureStravaIsDisabled(kotlin.coroutines.Continuation<? super java.lang.Boolean> r4) {
        /*
            boolean r0 = r4 instanceof com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$ensureStravaIsDisabled$1
            if (r0 == 0) goto L13
            r0 = r4
            com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$ensureStravaIsDisabled$1 r0 = (com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$ensureStravaIsDisabled$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$ensureStravaIsDisabled$1 r0 = new com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$ensureStravaIsDisabled$1
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r4)
            goto L50
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2f:
            kotlin.ResultKt.throwOnFailure(r4)
            com.animaconnected.watch.WatchProvider r4 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.watch.WatchManager r4 = r4.getWatchManager()
            com.animaconnected.watch.account.strava.StravaClient r4 = r4.getStravaClient()
            boolean r2 = r4.isConnected()
            if (r2 != 0) goto L47
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            return r4
        L47:
            r0.label = r3
            java.lang.Object r4 = r4.revokeAccess(r0)
            if (r4 != r1) goto L50
            return r1
        L50:
            com.animaconnected.watch.utils.WatchLibResult r4 = (com.animaconnected.watch.utils.WatchLibResult) r4
            java.lang.Object r4 = r4.getOrNull()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            if (r4 == 0) goto L5f
            boolean r4 = r4.booleanValue()
            goto L60
        L5f:
            r4 = 0
        L60:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt.ensureStravaIsDisabled(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$showEnableDemoModeBottomDialog$1, kotlin.jvm.internal.Lambda] */
    public static final BottomDialog showEnableDemoModeBottomDialog(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        return BottomSheetKt.showBottomDialog((Context) activity, false, (Function3<? super Function0<Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambdaInstance(-133643255, new Function3<Function0<? extends Unit>, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$showEnableDemoModeBottomDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, Composer composer, Integer num) {
                invoke((Function0<Unit>) function0, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v7, types: [com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$showEnableDemoModeBottomDialog$1$2, kotlin.jvm.internal.Lambda] */
            public final void invoke(final Function0<Unit> dismissDialog, Composer composer, int r11) {
                Intrinsics.checkNotNullParameter(dismissDialog, "dismissDialog");
                if ((r11 & 14) == 0) {
                    r11 |= composer.changedInstance(dismissDialog) ? 4 : 2;
                }
                if ((r11 & 91) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                final Activity activity2 = activity;
                composer.startReplaceableGroup(773894976);
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue = composer.rememberedValue();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (rememberedValue == composer$Companion$Empty$1) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(composer));
                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                composer.endReplaceableGroup();
                final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).coroutineScope;
                composer.endReplaceableGroup();
                composer.startReplaceableGroup(465335881);
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == composer$Companion$Empty$1) {
                    rememberedValue2 = Platform.mutableStateOf$default(Boolean.FALSE);
                    composer.updateRememberedValue(rememberedValue2);
                }
                MutableState mutableState = (MutableState) rememberedValue2;
                composer.endReplaceableGroup();
                final boolean booleanValue = ((Boolean) mutableState.component1()).booleanValue();
                final Function1 component2 = mutableState.component2();
                final Activity activity3 = activity;
                final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$showEnableDemoModeBottomDialog$1$onAccept$1

                    /* compiled from: EnableDemoModeBottomDialog.kt */
                    @DebugMetadata(c = "com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$showEnableDemoModeBottomDialog$1$onAccept$1$1", f = "EnableDemoModeBottomDialog.kt", l = {55}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$showEnableDemoModeBottomDialog$1$onAccept$1$1, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Activity $ctx;
                        final /* synthetic */ Function0<Unit> $dismissDialog;
                        final /* synthetic */ Function1<Boolean, Unit> $setIsActivating;
                        final /* synthetic */ Activity $this_showEnableDemoModeBottomDialog;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        public AnonymousClass1(Function1<? super Boolean, Unit> function1, Activity activity, Function0<Unit> function0, Activity activity2, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$setIsActivating = function1;
                            this.$ctx = activity;
                            this.$dismissDialog = function0;
                            this.$this_showEnableDemoModeBottomDialog = activity2;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$setIsActivating, this.$ctx, this.$dismissDialog, this.$this_showEnableDemoModeBottomDialog, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            int r1 = this.label;
                            if (r1 != 0) {
                                if (r1 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                this.$setIsActivating.invoke(Boolean.TRUE);
                                Activity activity = this.$ctx;
                                this.label = 1;
                                obj = EnableDemoModeBottomDialogKt.signOutAllReturnFailedServiceName(activity, this);
                                if (obj == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                            String str = (String) obj;
                            this.$dismissDialog.invoke();
                            if (str == null) {
                                ProviderFactory.getWatch().getWatchManager().getDemoModeProvider().setIsEnabled(true);
                            } else {
                                String string = this.$this_showEnableDemoModeBottomDialog.getString(R.string.demo_confirm_failed_to_sign_out_from, str);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                Toast.makeText(this.$ctx, string, 1).show();
                            }
                            return Unit.INSTANCE;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        if (booleanValue) {
                            return;
                        }
                        BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass1(component2, activity2, dismissDialog, activity3, null), 3);
                    }
                };
                ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, 910104472, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$showEnableDemoModeBottomDialog$1.2
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
                            EnableDemoModeBottomDialogKt.DialogContent(dismissDialog, function0, booleanValue, composer2, 0);
                        }
                    }
                }), composer, 6);
            }
        }, true));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object signOutAllReturnFailedServiceName(android.content.Context r7, kotlin.coroutines.Continuation<? super java.lang.String> r8) {
        /*
            boolean r0 = r8 instanceof com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$signOutAllReturnFailedServiceName$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$signOutAllReturnFailedServiceName$1 r0 = (com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$signOutAllReturnFailedServiceName$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$signOutAllReturnFailedServiceName$1 r0 = new com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt$signOutAllReturnFailedServiceName$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L46
            if (r2 == r6) goto L3e
            if (r2 == r5) goto L36
            if (r2 != r4) goto L2e
            kotlin.ResultKt.throwOnFailure(r8)
            goto L80
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            java.lang.Object r7 = r0.L$0
            android.content.Context r7 = (android.content.Context) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6a
        L3e:
            java.lang.Object r7 = r0.L$0
            android.content.Context r7 = (android.content.Context) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L54
        L46:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r7
            r0.label = r6
            java.lang.Object r8 = ensureGoogleFitIsDisabled(r0)
            if (r8 != r1) goto L54
            return r1
        L54:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L5f
            java.lang.String r7 = "Google Fit"
            return r7
        L5f:
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = ensureStravaIsDisabled(r0)
            if (r8 != r1) goto L6a
            return r1
        L6a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L75
            java.lang.String r7 = "Strava"
            return r7
        L75:
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r8 = ensureSignedOutFromCloud(r7, r0)
            if (r8 != r1) goto L80
            return r1
        L80:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r7 = r8.booleanValue()
            if (r7 != 0) goto L8b
            java.lang.String r7 = "App account"
            return r7
        L8b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt.signOutAllReturnFailedServiceName(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
