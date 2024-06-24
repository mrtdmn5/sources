package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
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
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.widget.ButtonOutlinedKt;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.TopbarKt;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.JaguarComposeThemeProvider;
import com.animaconnected.widget.theme.KronabyComposeDarkThemeProvider;
import com.animaconnected.widget.theme.KronabyComposeLightThemeProvider;
import com.animaconnected.widget.theme.LotusComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: DebugThemingFragment.kt */
/* loaded from: classes3.dex */
public final class DebugThemingFragment extends ComposeFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "ComposeDebug";

    /* compiled from: DebugThemingFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugThemingFragment newInstance() {
            return new DebugThemingFragment();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$ComposeContent$1, kotlin.jvm.internal.Lambda] */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r5) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-353030469);
        if ((r5 & 14) == 0) {
            if (startRestartGroup.changed(this)) {
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
            MultiBrandColumn(ComposableLambdaKt.composableLambda(startRestartGroup, 344052539, new Function3<String, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$ComposeContent$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(String str, Composer composer2, Integer num) {
                    invoke(str, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(String it, Composer composer2, int r52) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((r52 & 14) == 0) {
                        r52 |= composer2.changed(it) ? 4 : 2;
                    }
                    if ((r52 & 91) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        DebugThemingFragment.this.ComposeWidgets(it, composer2, r52 & 14);
                    }
                }
            }), startRestartGroup, ((r0 << 3) & 112) | 6);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$ComposeContent$2
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
                    DebugThemingFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$ComposeWidgets$1$2, kotlin.jvm.internal.Lambda] */
    public final void ComposeWidgets(final String title, Composer composer, final int r29) {
        int r1;
        ComposerImpl composerImpl;
        boolean z;
        int r2;
        int r12;
        Intrinsics.checkNotNullParameter(title, "title");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1742851850);
        if ((r29 & 14) == 0) {
            if (startRestartGroup.changed(title)) {
                r12 = 4;
            } else {
                r12 = 2;
            }
            r1 = r12 | r29;
        } else {
            r1 = r29;
        }
        if ((r29 & 112) == 0) {
            if (startRestartGroup.changed(this)) {
                r2 = 32;
            } else {
                r2 = 16;
            }
            r1 |= r2;
        }
        int r122 = r1;
        if ((r122 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(companion, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU(), RectangleShapeKt.RectangleShape);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
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
                Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                TopbarKt.TopBar(SizeKt.m83height3ABfNKs(companion, 0), R.drawable.ic_chevron_left, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$ComposeWidgets$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, title, ComposableLambdaKt.composableLambda(startRestartGroup, -494513454, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$ComposeWidgets$1$2
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                        invoke(boxScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxScope TopBar, Composer composer2, int r123) {
                        Intrinsics.checkNotNullParameter(TopBar, "$this$TopBar");
                        if ((r123 & 81) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        composer2.startReplaceableGroup(-2068328380);
                        boolean changed = composer2.changed(DebugThemingFragment.this);
                        final DebugThemingFragment debugThemingFragment = DebugThemingFragment.this;
                        Object rememberedValue = composer2.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.Empty) {
                            rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$ComposeWidgets$1$2$1$1
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
                                    ViewKt.toast$default((Fragment) DebugThemingFragment.this, "Not implemented", false, 2, (Object) null);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        IconButtonKt.IconButton((Function0) rememberedValue, null, false, null, ComposableSingletons$DebugThemingFragmentKt.INSTANCE.m862getLambda1$secondo_kronabyRelease(), composer2, 24576, 14);
                    }
                }), startRestartGroup, ((r122 << 9) & 7168) | 25014, 0);
                float f = 16;
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, f), startRestartGroup, 6);
                ScreenTitleKt.ScreenTitle(null, title, startRestartGroup, (r122 << 3) & 112, 1);
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 8), startRestartGroup, 6);
                Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(companion, f);
                ComposableSingletons$DebugThemingFragmentKt composableSingletons$DebugThemingFragmentKt = ComposableSingletons$DebugThemingFragmentKt.INSTANCE;
                CardKt.m162CardFjzlyU(m71padding3ABfNKs, null, 0.0f, composableSingletons$DebugThemingFragmentKt.m863getLambda2$secondo_kronabyRelease(), startRestartGroup, 1572870, 62);
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                    composerImpl = startRestartGroup;
                    ButtonKt.Button(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$ComposeWidgets$1$3$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, null, false, null, null, null, null, null, null, composableSingletons$DebugThemingFragmentKt.m864getLambda3$secondo_kronabyRelease(), composerImpl, 805306374, 510);
                    ButtonKt.OutlinedButton(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$ComposeWidgets$1$3$2
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, null, false, null, null, composableSingletons$DebugThemingFragmentKt.m865getLambda4$secondo_kronabyRelease(), composerImpl, 805306374, 510);
                    Modifier m83height3ABfNKs = SizeKt.m83height3ABfNKs(companion, 48);
                    Intrinsics.checkNotNullParameter(m83height3ABfNKs, "<this>");
                    if (1.0f > 0.0d) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        ButtonOutlinedKt.ButtonOutlined(m83height3ABfNKs.then(new LayoutWeightElement(1.0f, true)), null, false, false, composableSingletons$DebugThemingFragmentKt.m866getLambda5$secondo_kronabyRelease(), composerImpl, 24576, 14);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
                        SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 32), composerImpl, 6);
                        composerImpl.end(false);
                        composerImpl.end(true);
                        composerImpl.end(false);
                        composerImpl.end(false);
                    } else {
                        throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
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
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$ComposeWidgets$2
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
                    DebugThemingFragment.this.ComposeWidgets(title, composer2, Strings.updateChangedFlags(r29 | 1));
                }
            };
        }
    }

    public final void MultiBrandColumn(final Function3<? super String, ? super Composer, ? super Integer, Unit> content, Composer composer, final int r18) {
        int r3;
        int r32;
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(554431403);
        if ((r18 & 14) == 0) {
            if (startRestartGroup.changedInstance(content)) {
                r32 = 4;
            } else {
                r32 = 2;
            }
            r3 = r32 | r18;
        } else {
            r3 = r18;
        }
        if ((r3 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            final List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ComposeThemeProvider[]{JaguarComposeThemeProvider.INSTANCE, FestinaComposeThemeProvider.INSTANCE, LotusComposeThemeProvider.INSTANCE, KronabyComposeLightThemeProvider.INSTANCE, KronabyComposeDarkThemeProvider.INSTANCE, ProviderFactory.INSTANCE.getThemeProvider()});
            LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$MultiBrandColumn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                    invoke2(lazyListScope);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r2v1, types: [com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$MultiBrandColumn$1$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LazyListScope LazyColumn) {
                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                    final List<ComposeThemeProvider> list = listOf;
                    final Function3<String, Composer, Integer, Unit> function3 = content;
                    final DebugThemingFragment$MultiBrandColumn$1$invoke$$inlined$items$default$1 debugThemingFragment$MultiBrandColumn$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$MultiBrandColumn$1$invoke$$inlined$items$default$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Void invoke(ComposeThemeProvider composeThemeProvider) {
                            return null;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke((ComposeThemeProvider) obj);
                        }
                    };
                    LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$MultiBrandColumn$1$invoke$$inlined$items$default$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final Object invoke(int r33) {
                            return Function1.this.invoke(list.get(r33));
                        }
                    }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$MultiBrandColumn$1$invoke$$inlined$items$default$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                            invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference failed for: r11v2, types: [com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$MultiBrandColumn$1$1$1, kotlin.jvm.internal.Lambda] */
                        public final void invoke(LazyItemScope items, int r11, Composer composer2, int r13) {
                            int r10;
                            Intrinsics.checkNotNullParameter(items, "$this$items");
                            if ((r13 & 14) == 0) {
                                r10 = (composer2.changed(items) ? 4 : 2) | r13;
                            } else {
                                r10 = r13;
                            }
                            if ((r13 & 112) == 0) {
                                r10 |= composer2.changed(r11) ? 32 : 16;
                            }
                            if ((r10 & 731) == 146 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                            final ComposeThemeProvider composeThemeProvider = (ComposeThemeProvider) list.get(r11);
                            Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(Modifier.Companion.$$INSTANCE, Color.Green, RectangleShapeKt.RectangleShape);
                            final Function3 function32 = function3;
                            CardKt.m162CardFjzlyU(m21backgroundbw27NRU, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, 1383793920, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$MultiBrandColumn$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Type inference failed for: r0v1, types: [com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$MultiBrandColumn$1$1$1$1, kotlin.jvm.internal.Lambda] */
                                public final void invoke(Composer composer3, int r4) {
                                    if ((r4 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                                    final ComposeThemeProvider composeThemeProvider2 = ComposeThemeProvider.this;
                                    final Function3<String, Composer, Integer, Unit> function33 = function32;
                                    ThemeKt.BrandTheme(composeThemeProvider2, ComposableLambdaKt.composableLambda(composer3, -758461936, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$MultiBrandColumn$1$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int r42) {
                                            if ((r42 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                            } else {
                                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$14 = ComposerKt.removeCurrentGroupInstance;
                                                function33.invoke(StringsKt___StringsKt.take(20, String.valueOf(Reflection.getOrCreateKotlinClass(composeThemeProvider2.getClass()).getSimpleName())).concat("..."), composer4, 0);
                                            }
                                        }
                                    }), composer3, 56);
                                }
                            }), composer2, 1572864, 62);
                        }
                    }, true));
                }
            }, startRestartGroup, 0, 255);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugThemingFragment$MultiBrandColumn$2
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

                public final void invoke(Composer composer2, int r4) {
                    DebugThemingFragment.this.MultiBrandColumn(content, composer2, Strings.updateChangedFlags(r18 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }
}
