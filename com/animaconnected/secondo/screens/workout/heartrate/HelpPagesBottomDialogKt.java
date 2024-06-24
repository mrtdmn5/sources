package com.animaconnected.secondo.screens.workout.heartrate;

import android.content.Context;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateImpl;
import androidx.compose.foundation.pager.PagerStateKt;
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
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.provider.lottie.LottieKt;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import com.animaconnected.widget.ButtonBorderlessKt;
import com.animaconnected.widget.PagerIndicatorKt;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HelpPagesBottomDialog.kt */
/* loaded from: classes3.dex */
public final class HelpPagesBottomDialogKt {
    private static final List<HelpPageModel> hrGraphInfoModels = CollectionsKt__CollectionsKt.listOf((Object[]) new HelpPageModel[]{new HelpPageModel(R.string.health_detail_heart_rate_help_avg_title, R.string.health_detail_heart_rate_help_avg_description, LottieFile.HeartRateHelpAvg, 1.787f), new HelpPageModel(R.string.health_detail_heart_rate_help_dots_title, R.string.health_detail_heart_rate_help_dots_description, LottieFile.HeartRateHelpDots, 1.787f), new HelpPageModel(R.string.health_detail_heart_rate_help_info_title, R.string.health_detail_heart_rate_help_info_description, LottieFile.HeartRateHelpInfo, 1.787f)});

    /* JADX WARN: Type inference failed for: r6v7, types: [com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$DialogContent$1$1, kotlin.jvm.internal.Lambda] */
    public static final void DialogContent(final List<HelpPageModel> list, final Function0<Unit> function0, Composer composer, final int r26) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1347207000);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final float dimensionResource = PrimitiveResources_androidKt.dimensionResource(R.dimen.padding_quadruple, startRestartGroup);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, dimensionResource, 0.0f, 40, 5);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
        Float f = null;
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
            modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            PagerStateImpl rememberPagerState = PagerStateKt.rememberPagerState(new Function0<Integer>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$DialogContent$1$pagerState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    return Integer.valueOf(list.size());
                }
            }, startRestartGroup);
            startRestartGroup.startReplaceableGroup(773894976);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot = startRestartGroup.nextSlot();
            if (nextSlot == Composer.Companion.Empty) {
                nextSlot = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
            }
            startRestartGroup.end(false);
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) nextSlot).coroutineScope;
            startRestartGroup.end(false);
            Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                float lottieAspectRatio = ((HelpPageModel) it.next()).getLottieAspectRatio();
                while (it.hasNext()) {
                    lottieAspectRatio = Math.min(lottieAspectRatio, ((HelpPageModel) it.next()).getLottieAspectRatio());
                }
                f = Float.valueOf(lottieAspectRatio);
            }
            final float f2 = 1.0f;
            if (f != null) {
                f2 = f.floatValue();
            }
            PagerKt.m105HorizontalPagerxYaah8o(rememberPagerState, null, null, null, list.size() - 1, 0.0f, Alignment.Companion.Top, null, false, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -246761137, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$DialogContent$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer2, Integer num2) {
                    invoke(pagerScope, num.intValue(), composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PagerScope HorizontalPager, int r4, Composer composer2, int r6) {
                    Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    HelpPagesBottomDialogKt.PageContent(list.get(r4), PaddingKt.m73paddingVpY3zN4$default(Modifier.Companion.$$INSTANCE, dimensionResource, 0.0f, 2), f2, composer2, 0);
                }
            }), startRestartGroup, 1572864, 384, 4014);
            Footer(list.size(), rememberPagerState.getCurrentPage(), new HelpPagesBottomDialogKt$DialogContent$1$2(coroutineScope, rememberPagerState, list, function0), PaddingKt.m73paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), dimensionResource, 0.0f, 2), startRestartGroup, 0);
            AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$DialogContent$2
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
                        HelpPagesBottomDialogKt.DialogContent(list, function0, composer2, Strings.updateChangedFlags(r26 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final void DialogContent$lambda$1$changePage(CoroutineScope coroutineScope, PagerState pagerState, List<HelpPageModel> list, Function0<Unit> function0, int r11) {
        BuildersKt.launch$default(coroutineScope, null, null, new HelpPagesBottomDialogKt$DialogContent$1$changePage$1(pagerState, r11, list, function0, null), 3);
    }

    public static final void Footer(final int r21, final int r22, final Function1<? super Integer, Unit> function1, final Modifier modifier, Composer composer, final int r26) {
        int r0;
        int r19;
        int r02;
        boolean z;
        ComposerImpl composerImpl;
        boolean z2;
        int r1;
        int r12;
        int r13;
        int r03;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1638251652);
        if ((r26 & 14) == 0) {
            if (startRestartGroup.changed(r21)) {
                r03 = 4;
            } else {
                r03 = 2;
            }
            r0 = r03 | r26;
        } else {
            r0 = r26;
        }
        if ((r26 & 112) == 0) {
            if (startRestartGroup.changed(r22)) {
                r13 = 32;
            } else {
                r13 = 16;
            }
            r0 |= r13;
        }
        if ((r26 & 896) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r12 = 256;
            } else {
                r12 = 128;
            }
            r0 |= r12;
        }
        if ((r26 & 7168) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r1 = 2048;
            } else {
                r1 = 1024;
            }
            r0 |= r1;
        }
        int r4 = r0;
        if ((r4 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            float f = 1;
            Modifier m81defaultMinSizeVpY3zN4 = SizeKt.m81defaultMinSizeVpY3zN4(companion, f, f);
            Modifier m86requiredHeight3ABfNKs = SizeKt.m86requiredHeight3ABfNKs(modifier, 44);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.TopStart, false, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m86requiredHeight3ABfNKs);
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-1104849025);
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (r22 != 0) {
                    String stringResource = URLProtocolKt.stringResource(R.string.mini_onboarding_button_previous, startRestartGroup);
                    Modifier align = boxScopeInstance.align(m81defaultMinSizeVpY3zN4, Alignment.Companion.CenterStart);
                    startRestartGroup.startReplaceableGroup(-1104848752);
                    if ((r4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Object nextSlot = startRestartGroup.nextSlot();
                    if (z2 || nextSlot == composer$Companion$Empty$1) {
                        nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$Footer$1$1$1
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
                                function1.invoke(-1);
                            }
                        };
                        startRestartGroup.updateValue(nextSlot);
                    }
                    startRestartGroup.end(false);
                    r19 = 256;
                    ButtonBorderlessKt.ButtonBorderless(align, stringResource, true, false, (Function0) nextSlot, startRestartGroup, 384, 8);
                } else {
                    r19 = 256;
                }
                int r11 = r19;
                startRestartGroup.end(false);
                PagerIndicatorKt.PagerIndicator(r21, r22, boxScopeInstance.align(companion, Alignment.Companion.Center), startRestartGroup, (r4 & 112) | (r4 & 14), 0);
                if (r22 < r21 - 1) {
                    r02 = R.string.mini_onboarding_button_next;
                } else {
                    r02 = R.string.mini_onboarding_button_done;
                }
                String stringResource2 = URLProtocolKt.stringResource(r02, startRestartGroup);
                Modifier align2 = boxScopeInstance.align(m81defaultMinSizeVpY3zN4, Alignment.Companion.CenterEnd);
                startRestartGroup.startReplaceableGroup(-1104848197);
                if ((r4 & 896) == r11) {
                    z = true;
                } else {
                    z = false;
                }
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$Footer$1$2$1
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
                            function1.invoke(1);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                composerImpl = startRestartGroup;
                ButtonBorderlessKt.ButtonBorderless(align2, stringResource2, true, false, (Function0) nextSlot2, composerImpl, 384, 8);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$Footer$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r8) {
                    HelpPagesBottomDialogKt.Footer(r21, r22, function1, modifier, composer2, Strings.updateChangedFlags(r26 | 1));
                }
            };
        }
    }

    public static final void PageContent(final HelpPageModel helpPageModel, final Modifier modifier, final float f, Composer composer, final int r84) {
        int r5;
        int r6;
        int r62;
        int r52;
        ComposerImpl startRestartGroup = composer.startRestartGroup(165438143);
        if ((r84 & 14) == 0) {
            if (startRestartGroup.changed(helpPageModel)) {
                r52 = 4;
            } else {
                r52 = 2;
            }
            r5 = r52 | r84;
        } else {
            r5 = r84;
        }
        if ((r84 & 112) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r62 = 32;
            } else {
                r62 = 16;
            }
            r5 |= r62;
        }
        if ((r84 & 896) == 0) {
            if (startRestartGroup.changed(f)) {
                r6 = 256;
            } else {
                r6 = 128;
            }
            r5 |= r6;
        }
        if ((r5 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            float dimensionResource = PrimitiveResources_androidKt.dimensionResource(R.dimen.padding_quadruple, startRestartGroup);
            Arrangement$Top$1 arrangement$Top$1 = Arrangement.Top;
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, Alignment.Companion.Start, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int r53 = (((((((r5 >> 3) & 14) | 48) << 3) & 112) << 9) & 7168) | 6;
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
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r53 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                String stringResource = URLProtocolKt.stringResource(helpPageModel.getTitleId(), startRestartGroup);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                long m174getSurface0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m174getSurface0d7_KjU();
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
                TextStyle textStyle = ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).h1;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                TextKt.m216Text4IGK_g(stringResource, new HorizontalAlignElement(horizontal), m174getSurface0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, startRestartGroup, 0, 0, 65528);
                LottieComposition PageContent$lambda$3$lambda$2 = PageContent$lambda$3$lambda$2(RememberLottieCompositionKt.rememberLottieComposition(new LottieCompositionSpec.Asset(LottieKt.asSpec(helpPageModel.getLottieFile())), startRestartGroup));
                Modifier aspectRatio$default = AspectRatioKt.aspectRatio$default(PaddingKt.m73paddingVpY3zN4$default(companion, 0.0f, dimensionResource, 1), f);
                Intrinsics.checkNotNullParameter(aspectRatio$default, "<this>");
                LottieAnimationKt.LottieAnimation(PageContent$lambda$3$lambda$2, aspectRatio$default.then(new HorizontalAlignElement(horizontal)), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, null, false, null, null, null, false, startRestartGroup, 1572872, 0, 65468);
                TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(helpPageModel.getDescriptionId(), startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, dimensionResource, 7), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m174getSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).body1, startRestartGroup, 0, 0, 65528);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$PageContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r54) {
                    HelpPagesBottomDialogKt.PageContent(HelpPageModel.this, modifier, f, composer2, Strings.updateChangedFlags(r84 | 1));
                }
            };
        }
    }

    private static final LottieComposition PageContent$lambda$3$lambda$2(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    public static final void PreviewDialogContent(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(363039850);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableSingletons$HelpPagesBottomDialogKt.INSTANCE.m1021getLambda1$secondo_kronabyRelease(), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$PreviewDialogContent$1
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
                    HelpPagesBottomDialogKt.PreviewDialogContent(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final /* synthetic */ void access$DialogContent(List list, Function0 function0, Composer composer, int r3) {
        DialogContent(list, function0, composer, r3);
    }

    public static final /* synthetic */ List access$getHrGraphInfoModels$p() {
        return hrGraphInfoModels;
    }

    public static final void showGraphInfoBottomDialog(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        showHelpPagesBottomDialog(fragment, hrGraphInfoModels);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$showHelpPagesBottomDialog$1, kotlin.jvm.internal.Lambda] */
    private static final void showHelpPagesBottomDialog(Fragment fragment, final List<HelpPageModel> list) {
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BottomSheetKt.showBottomDialog$default(requireContext, false, ComposableLambdaKt.composableLambdaInstance(-1384477069, new Function3<Function0<? extends Unit>, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$showHelpPagesBottomDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, Composer composer, Integer num) {
                invoke((Function0<Unit>) function0, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r4v4, types: [com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$showHelpPagesBottomDialog$1$1, kotlin.jvm.internal.Lambda] */
            public final void invoke(final Function0<Unit> dismissDialog, Composer composer, int r4) {
                Intrinsics.checkNotNullParameter(dismissDialog, "dismissDialog");
                if ((r4 & 14) == 0) {
                    r4 |= composer.changedInstance(dismissDialog) ? 4 : 2;
                }
                if ((r4 & 91) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                final List<HelpPageModel> list2 = list;
                ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, -1904997116, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$showHelpPagesBottomDialog$1.1
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
                        if ((r42 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                            HelpPagesBottomDialogKt.DialogContent(list2, dismissDialog, composer2, 8);
                        }
                    }
                }), composer, 6);
            }
        }, true), 2, null);
    }
}
