package com.animaconnected.secondo.screens.tipsandtricks;

import android.content.Intent;
import android.net.Uri;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerStateImpl;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
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
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimatable;
import com.airbnb.lottie.compose.LottieAnimatableKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.animaconnected.secondo.provider.TipsAndTricksProvider;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.widget.PagerIndicatorKt;
import com.animaconnected.widget.TopbarKt;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TipsAndTricksPascalFragment.kt */
/* loaded from: classes3.dex */
public final class TipsAndTricksPascalFragment extends ComposeFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "TipsAndTricksPascal";
    private final int screenTitleId = R.string.feature_path_settings;

    /* compiled from: TipsAndTricksPascalFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TipsAndTricksPascalFragment newInstance() {
            return new TipsAndTricksPascalFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d1, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r5.nextSlot(), java.lang.Integer.valueOf(r11)) == false) goto L49;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PageContentTipsAndTricks(final com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksModel r65, final boolean r66, final androidx.compose.ui.Modifier r67, androidx.compose.runtime.Composer r68, final int r69) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment.PageContentTipsAndTricks(com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksModel, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):void");
    }

    private static final LottieComposition PageContentTipsAndTricks$lambda$9$lambda$4(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    private static final Modifier PageContentTipsAndTricks$lambda$9$lambda$8$lambda$7$handleClickIfUrlAvailable(Modifier modifier, final TipsAndTricksModel tipsAndTricksModel, final TipsAndTricksPascalFragment tipsAndTricksPascalFragment) {
        Modifier m26clickableXHw0xAI$default;
        if (tipsAndTricksModel.getUrl() != null && (m26clickableXHw0xAI$default = ClickableKt.m26clickableXHw0xAI$default(modifier, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$PageContentTipsAndTricks$1$1$2$handleClickIfUrlAvailable$1$1
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
                TipsAndTricksPascalFragment.this.openUrl(tipsAndTricksModel.getUrl());
            }
        })) != null) {
            return m26clickableXHw0xAI$default;
        }
        return modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void TipsAndTricksScreen(final Function0<Unit> function0, final List<? extends TipsAndTricksModel> list, Composer composer, final int r37) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(137368196);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        float dimensionResource = PrimitiveResources_androidKt.dimensionResource(R.dimen.padding, startRestartGroup);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), 0.0f, 0.0f, 0.0f, PrimitiveResources_androidKt.dimensionResource(R.dimen.screen_bottom_margin, startRestartGroup), 7);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String stringResource = URLProtocolKt.stringResource(this.screenTitleId, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-757149882);
            boolean z = true;
            if ((((r37 & 14) ^ 6) <= 4 || !startRestartGroup.changedInstance(function0)) && (r37 & 6) != 4) {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$TipsAndTricksScreen$1$1$1
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
            TopbarKt.TopBar(null, R.drawable.ic_back_arrow_white, (Function0) nextSlot, stringResource, null, startRestartGroup, 48, 17);
            TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.tips_and_tricks_pascal_title, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(columnScopeInstance.align(companion), 0.0f, dimensionResource, 0.0f, dimensionResource * 10, 5), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h1, startRestartGroup, 0, 0, 65528);
            TipsPager(columnScopeInstance, list, startRestartGroup, (r37 & 896) | 70);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$TipsAndTricksScreen$2
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

                    public final void invoke(Composer composer2, int r5) {
                        TipsAndTricksPascalFragment.this.TipsAndTricksScreen(function0, list, composer2, Strings.updateChangedFlags(r37 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$TipsPager$1, kotlin.jvm.internal.Lambda] */
    public final void TipsPager(final ColumnScope columnScope, final List<? extends TipsAndTricksModel> list, Composer composer, final int r27) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(502632448);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final PagerStateImpl rememberPagerState = PagerStateKt.rememberPagerState(new Function0<Integer>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$TipsPager$pagerState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(list.size());
            }
        }, startRestartGroup);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        PagerKt.m105HorizontalPagerxYaah8o(rememberPagerState, columnScope.weight(companion, 1.0f, true), null, null, 1, 0.0f, null, null, false, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 957145885, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$TipsPager$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer2, Integer num2) {
                invoke(pagerScope, num.intValue(), composer2, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PagerScope HorizontalPager, int r8, Composer composer2, int r10) {
                Modifier fillMaxHeight;
                Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                TipsAndTricksModel tipsAndTricksModel = list.get(r8);
                boolean z = ((Number) rememberPagerState.settledPage$delegate.getValue()).intValue() == r8;
                TipsAndTricksPascalFragment tipsAndTricksPascalFragment = this;
                fillMaxHeight = SizeKt.fillMaxHeight(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 1.0f);
                tipsAndTricksPascalFragment.PageContentTipsAndTricks(tipsAndTricksModel, z, PaddingKt.m73paddingVpY3zN4$default(fillMaxHeight, PrimitiveResources_androidKt.dimensionResource(R.dimen.padding_tips_and_tricks, composer2), 0.0f, 2), composer2, 0);
            }
        }), startRestartGroup, 24576, 384, 4076);
        PagerIndicatorKt.PagerIndicator(list.size(), rememberPagerState.getCurrentPage(), columnScope.align(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, PrimitiveResources_androidKt.dimensionResource(R.dimen.padding, startRestartGroup), 0.0f, 0.0f, 13)), startRestartGroup, 0, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$TipsPager$2
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

                public final void invoke(Composer composer2, int r5) {
                    TipsAndTricksPascalFragment.this.TipsPager(columnScope, list, composer2, Strings.updateChangedFlags(r27 | 1));
                }
            };
        }
    }

    private final LottieAnimationState animateLottieResetOnStop(LottieComposition lottieComposition, boolean z, Composer composer, int r10, int r11) {
        composer.startReplaceableGroup(-918659844);
        if ((r11 & 2) != 0) {
            z = true;
        }
        boolean z2 = z;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        LottieAnimatable rememberLottieAnimatable = LottieAnimatableKt.rememberLottieAnimatable(composer);
        composer.startReplaceableGroup(683073262);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.Empty) {
            rememberedValue = Platform.mutableStateOf$default(Boolean.valueOf(z2));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(lottieComposition, Boolean.valueOf(z2), new TipsAndTricksPascalFragment$animateLottieResetOnStop$1(z2, rememberLottieAnimatable, lottieComposition, (MutableState) rememberedValue, null), composer);
        composer.endReplaceableGroup();
        return rememberLottieAnimatable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean animateLottieResetOnStop$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateLottieResetOnStop$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrl(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r8) {
        int r0;
        boolean z;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-842805990);
        if ((r8 & 14) == 0) {
            if (startRestartGroup.changed(this)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r8;
        } else {
            r0 = r8;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-161375668);
            if ((r0 & 14) == 4) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$ComposeContent$onBackClick$1$1
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
                        TipsAndTricksPascalFragment.this.getMainController().goBack();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            Function0<Unit> function0 = (Function0) nextSlot;
            startRestartGroup.end(false);
            List<TipsAndTricksModel> tipsAndTricksModelsPascal = TipsAndTricksProvider.INSTANCE.getTipsAndTricksModelsPascal();
            ArrayList arrayList = new ArrayList();
            for (Object obj : tipsAndTricksModelsPascal) {
                if (((TipsAndTricksModel) obj).isCompatibleToBeShown()) {
                    arrayList.add(obj);
                }
            }
            TipsAndTricksScreen(function0, arrayList, startRestartGroup, ((r0 << 6) & 896) | 64);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$ComposeContent$1
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
                    TipsAndTricksPascalFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r8 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$TipsAndTricksPreview$1, kotlin.jvm.internal.Lambda] */
    public final void TipsAndTricksPreview(Composer composer, final int r11) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1379937416);
        if ((r11 & 14) == 0) {
            if (startRestartGroup.changed(this)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r11;
        } else {
            r0 = r11;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            final TipsAndTricksModel tipsAndTricksModel = new TipsAndTricksModel(TipsAndTricksConstants.NOTIFICATIONS_PASCAL_NAME, 0, R.string.tips_and_tricks_pascal_filter_notifications_title, R.string.tips_and_tricks_pascal_filter_notifications_body, null, null, LottieFile.TrixNotificationsPascal);
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableLambdaKt.composableLambda(startRestartGroup, 1397282952, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$TipsAndTricksPreview$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r6) {
                    if ((r6 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    TipsAndTricksPascalFragment$TipsAndTricksPreview$1$onBackClick$1 tipsAndTricksPascalFragment$TipsAndTricksPreview$1$onBackClick$1 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$TipsAndTricksPreview$1$onBackClick$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    };
                    TipsAndTricksModel tipsAndTricksModel2 = TipsAndTricksModel.this;
                    this.TipsAndTricksScreen(tipsAndTricksPascalFragment$TipsAndTricksPreview$1$onBackClick$1, CollectionsKt__CollectionsKt.listOf((Object[]) new TipsAndTricksModel[]{tipsAndTricksModel2, tipsAndTricksModel2, tipsAndTricksModel2}), composer2, 6);
                }
            }), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment$TipsAndTricksPreview$2
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
                    TipsAndTricksPascalFragment.this.TipsAndTricksPreview(composer2, Strings.updateChangedFlags(r11 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(this.screenTitleId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }
}
