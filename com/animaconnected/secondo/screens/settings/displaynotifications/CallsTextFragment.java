package com.animaconnected.secondo.screens.settings.displaynotifications;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DividerKt;
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
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.debugsettings.DebugStorage;
import com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment;
import com.animaconnected.watch.filter.FilterSettings;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.TextKt;
import com.animaconnected.widget.TopbarKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: CallsTextFragment.kt */
/* loaded from: classes3.dex */
public final class CallsTextFragment extends ComposeFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "CallsText";

    /* compiled from: CallsTextFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CallsTextFragment newInstance() {
            return new CallsTextFragment();
        }

        private Companion() {
        }
    }

    /* compiled from: CallsTextFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FilterSettings.Allowed.values().length];
            try {
                r0[FilterSettings.Allowed.All.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FilterSettings.Allowed.Known.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FilterSettings.Allowed.Favourites.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FilterSettings.Allowed.Important.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[FilterSettings.Allowed.None.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ListItems(final List<RowData> list, Composer composer, final int r19) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1549251875);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ListItems$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                invoke2(lazyListScope);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ListItems$1$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final List<CallsTextFragment.RowData> list2 = list;
                final CallsTextFragment callsTextFragment = this;
                final CallsTextFragment$ListItems$1$invoke$$inlined$items$default$1 callsTextFragment$ListItems$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ListItems$1$invoke$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(CallsTextFragment.RowData rowData) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((CallsTextFragment.RowData) obj);
                    }
                };
                LazyColumn.items(list2.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ListItems$1$invoke$$inlined$items$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int r3) {
                        return Function1.this.invoke(list2.get(r3));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ListItems$1$invoke$$inlined$items$default$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                        invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope items, int r10, Composer composer2, int r12) {
                        int r9;
                        Intrinsics.checkNotNullParameter(items, "$this$items");
                        if ((r12 & 14) == 0) {
                            r9 = (composer2.changed(items) ? 4 : 2) | r12;
                        } else {
                            r9 = r12;
                        }
                        if ((r12 & 112) == 0) {
                            r9 |= composer2.changed(r10) ? 32 : 16;
                        }
                        if ((r9 & 731) == 146 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        CallsTextFragment.RowData rowData = (CallsTextFragment.RowData) list2.get(r10);
                        DividerKt.m180DivideroMI9zvI(null, 0L, 0.0f, 0.0f, composer2, 0, 15);
                        callsTextFragment.ListRow(rowData, composer2, ((r9 & 14) >> 3) & 14);
                    }
                }, true));
            }
        }, startRestartGroup, 0, 255);
        DividerKt.m180DivideroMI9zvI(null, 0L, 0.0f, 0.0f, startRestartGroup, 0, 15);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ListItems$2
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
                    CallsTextFragment.this.ListItems(list, composer2, Strings.updateChangedFlags(r19 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ListRow(final RowData rowData, Composer composer, final int r41) {
        int r3;
        boolean z;
        ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1;
        ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1;
        Applier<?> applier;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal;
        int r32;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1169216405);
        if ((r41 & 14) == 0) {
            if (startRestartGroup.changed(rowData)) {
                r32 = 4;
            } else {
                r32 = 2;
            }
            r3 = r32 | r41;
        } else {
            r3 = r41;
        }
        if ((r3 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier m83height3ABfNKs = SizeKt.m83height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 56);
            startRestartGroup.startReplaceableGroup(-727369178);
            if ((r3 & 14) == 4) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ListRow$1$1
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
                        CallsTextFragment.RowData.this.getOnClick().invoke();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            Modifier m73paddingVpY3zN4$default = PaddingKt.m73paddingVpY3zN4$default(ClickableKt.m26clickableXHw0xAI$default(m83height3ABfNKs, (Function0) nextSlot), 16, 0.0f, 2);
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m73paddingVpY3zN4$default);
            Applier<?> applier2 = startRestartGroup.applier;
            if (applier2 instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$12);
                } else {
                    startRestartGroup.useNode();
                }
                ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$12 = ComposeUiNode.Companion.SetMeasurePolicy;
                Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$12);
                ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$12 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$12);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 693286680);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
                if (applier2 instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$12);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rowMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$12);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$12);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, -893081345);
                    if (rowData.getShowBadge()) {
                        composeUiNode$Companion$SetResolvedCompositionLocals$1 = composeUiNode$Companion$SetResolvedCompositionLocals$12;
                        composeUiNode$Companion$SetMeasurePolicy$1 = composeUiNode$Companion$SetMeasurePolicy$12;
                        applier = applier2;
                        layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$12;
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.breadcrumb_shadow_headsup, startRestartGroup), URLProtocolKt.stringResource(R.string.bottom_dialog_general_singular_title, startRestartGroup), null, null, null, 0.0f, null, startRestartGroup, 8, 124);
                    } else {
                        composeUiNode$Companion$SetResolvedCompositionLocals$1 = composeUiNode$Companion$SetResolvedCompositionLocals$12;
                        composeUiNode$Companion$SetMeasurePolicy$1 = composeUiNode$Companion$SetMeasurePolicy$12;
                        applier = applier2;
                        layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$12;
                    }
                    startRestartGroup.end(false);
                    String title = rowData.getTitle();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = ColorsKt.LocalColors;
                    long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal2)).m166getOnBackground0d7_KjU();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = TypographyKt.LocalTypography;
                    TextKt.m1633CapsTextfLXpl1I(title, null, m166getOnBackground0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal3)).button, startRestartGroup, 0, 0, 32762);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    Arrangement$End$1 arrangement$End$1 = Arrangement.End;
                    startRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, startRestartGroup);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                    PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                    ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion);
                    if (applier instanceof Applier) {
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.inserting) {
                            startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Updater.m228setimpl(startRestartGroup, rowMeasurePolicy3, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                            AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf3, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, -893080666);
                        if (!StringsKt__StringsJVMKt.isBlank(rowData.getOptionalText())) {
                            staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                            androidx.compose.material.TextKt.m216Text4IGK_g(rowData.getOptionalText(), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 8, 0.0f, 11), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal3)).h5, startRestartGroup, 48, 0, 65528);
                        } else {
                            staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                        }
                        startRestartGroup.end(false);
                        IconKt.m187Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_chevron_right, startRestartGroup), "", null, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), startRestartGroup, 56, 4);
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
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ListRow$3
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
                    CallsTextFragment.this.ListRow(rowData, composer2, Strings.updateChangedFlags(r41 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Toolbar(Composer composer, final int r11) {
        int r0;
        boolean z;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(365704582);
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
            String string = getString(R.string.feature_path_settings);
            startRestartGroup.startReplaceableGroup(1238824220);
            if ((r0 & 14) == 4) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$Toolbar$1$1
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
                        CallsTextFragment.this.getMainController().goBack();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            Intrinsics.checkNotNull(string);
            TopbarKt.TopBar(null, R.drawable.ic_chevron_left, (Function0) nextSlot, string, null, startRestartGroup, 48, 17);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$Toolbar$2
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
                    CallsTextFragment.this.Toolbar(composer2, Strings.updateChangedFlags(r11 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r36) {
        int r3;
        String string;
        String string2;
        int r32;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1185936674);
        if ((r36 & 14) == 0) {
            if (startRestartGroup.changed(this)) {
                r32 = 4;
            } else {
                r32 = 2;
            }
            r3 = r32 | r36;
        } else {
            r3 = r36;
        }
        if ((r3 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(companion, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m164getBackground0d7_KjU(), RectangleShapeKt.RectangleShape);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
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
                startRestartGroup.startReplaceableGroup(-1482222541);
                Object nextSlot = startRestartGroup.nextSlot();
                if (nextSlot == Composer.Companion.Empty) {
                    FilterSettings.Allowed callsFilter = ProviderFactory.getWatch().getWatchManager().getFilterSettings().getCallsFilter();
                    FilterSettings.Allowed textsFilter = ProviderFactory.getWatch().getWatchManager().getFilterSettings().getTextsFilter();
                    int[] r12 = WhenMappings.$EnumSwitchMapping$0;
                    int r7 = r12[callsFilter.ordinal()];
                    if (r7 != 1) {
                        if (r7 != 2) {
                            if (r7 != 3) {
                                if (r7 != 4) {
                                    if (r7 == 5) {
                                        string = getString(R.string.filtered_notifications_preference_title_none);
                                    } else {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                } else {
                                    string = getString(R.string.filtered_notifications_important_contacts);
                                }
                            } else {
                                string = getString(R.string.filtered_notifications_preference_title_phone_favourites);
                            }
                        } else {
                            string = getString(R.string.filtered_notifications_preference_title_known_contacts);
                        }
                    } else {
                        string = getString(R.string.filtered_notifications_preference_title_everyone);
                    }
                    Intrinsics.checkNotNull(string);
                    int r8 = r12[textsFilter.ordinal()];
                    if (r8 != 1) {
                        if (r8 != 2) {
                            if (r8 != 3) {
                                if (r8 != 4) {
                                    if (r8 == 5) {
                                        string2 = getString(R.string.filtered_notifications_preference_title_none);
                                    } else {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                } else {
                                    string2 = getString(R.string.filtered_notifications_important_contacts);
                                }
                            } else {
                                string2 = getString(R.string.filtered_notifications_preference_title_phone_favourites);
                            }
                        } else {
                            string2 = getString(R.string.filtered_notifications_preference_title_known_contacts);
                        }
                    } else {
                        string2 = getString(R.string.filtered_notifications_preference_title_everyone);
                    }
                    Intrinsics.checkNotNull(string2);
                    String string3 = getString(R.string.nft_calls);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    RowData rowData = new RowData(string3, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ComposeContent$1$rowData$1$items$1
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
                            CallsTextFragment.this.getMainController().gotoNextFragment(CallsFragment.Companion.newInstance());
                        }
                    }, string, CallsFragment.Companion.isBadgeVisible());
                    String string4 = getString(R.string.filtered_notifications_texts_title);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    RowData rowData2 = new RowData(string4, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ComposeContent$1$rowData$1$items$2
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
                            CallsTextFragment.this.getMainController().gotoNextFragment(TextsFragment.Companion.newInstance());
                        }
                    }, string2, TextsFragment.Companion.isBadgeVisible());
                    String string5 = getString(R.string.filtered_notifications_important_contacts);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    RowData rowData3 = new RowData(string5, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ComposeContent$1$rowData$1$items$3
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
                            CallsTextFragment.this.getMainController().gotoNextFragment(ImportantContactFragment.Companion.newInstance());
                        }
                    }, null, false, 12, null);
                    String string6 = getString(R.string.filtered_notifications_call_handling_title);
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    RowData rowData4 = new RowData(string6, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ComposeContent$1$rowData$1$items$4
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
                            CallsTextFragment.this.getMainController().gotoNextFragment(CallHandlingFragment.Companion.newInstance());
                        }
                    }, null, false, 12, null);
                    String string7 = getString(R.string.filtered_notifications_text_reply_title);
                    Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                    List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new RowData[]{rowData, rowData2, rowData3, rowData4, new RowData(string7, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ComposeContent$1$rowData$1$items$5
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
                            CallsTextFragment.this.getMainController().gotoNextFragment(TextQuickReplyFragment.Companion.newInstance());
                        }
                    }, null, false, 12, null)});
                    if (!DebugStorage.INSTANCE.getShowWipStuff()) {
                        listOf = CollectionsKt___CollectionsKt.take(listOf, 3);
                    }
                    nextSlot = listOf;
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                Toolbar(startRestartGroup, r3 & 14);
                Modifier m73paddingVpY3zN4$default = PaddingKt.m73paddingVpY3zN4$default(companion, 0.0f, 32, 1);
                String string8 = getString(R.string.filtered_notifications_calls_text_title);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                ScreenTitleKt.ScreenTitle(m73paddingVpY3zN4$default, string8, startRestartGroup, 6, 0);
                ListItems((List) nextSlot, startRestartGroup, ((r3 << 3) & 112) | 8);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment$ComposeContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r33) {
                    CallsTextFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r36 | 1));
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

    /* compiled from: CallsTextFragment.kt */
    /* loaded from: classes3.dex */
    public static final class RowData {
        private final Function0<Unit> onClick;
        private final String optionalText;
        private final boolean showBadge;
        private final String title;

        public RowData(String title, Function0<Unit> onClick, String optionalText, boolean z) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            Intrinsics.checkNotNullParameter(optionalText, "optionalText");
            this.title = title;
            this.onClick = onClick;
            this.optionalText = optionalText;
            this.showBadge = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RowData copy$default(RowData rowData, String str, Function0 function0, String str2, boolean z, int r5, Object obj) {
            if ((r5 & 1) != 0) {
                str = rowData.title;
            }
            if ((r5 & 2) != 0) {
                function0 = rowData.onClick;
            }
            if ((r5 & 4) != 0) {
                str2 = rowData.optionalText;
            }
            if ((r5 & 8) != 0) {
                z = rowData.showBadge;
            }
            return rowData.copy(str, function0, str2, z);
        }

        public final String component1() {
            return this.title;
        }

        public final Function0<Unit> component2() {
            return this.onClick;
        }

        public final String component3() {
            return this.optionalText;
        }

        public final boolean component4() {
            return this.showBadge;
        }

        public final RowData copy(String title, Function0<Unit> onClick, String optionalText, boolean z) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            Intrinsics.checkNotNullParameter(optionalText, "optionalText");
            return new RowData(title, onClick, optionalText, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RowData)) {
                return false;
            }
            RowData rowData = (RowData) obj;
            if (Intrinsics.areEqual(this.title, rowData.title) && Intrinsics.areEqual(this.onClick, rowData.onClick) && Intrinsics.areEqual(this.optionalText, rowData.optionalText) && this.showBadge == rowData.showBadge) {
                return true;
            }
            return false;
        }

        public final Function0<Unit> getOnClick() {
            return this.onClick;
        }

        public final String getOptionalText() {
            return this.optionalText;
        }

        public final boolean getShowBadge() {
            return this.showBadge;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return Boolean.hashCode(this.showBadge) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.optionalText, (this.onClick.hashCode() + (this.title.hashCode() * 31)) * 31, 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("RowData(title=");
            sb.append(this.title);
            sb.append(", onClick=");
            sb.append(this.onClick);
            sb.append(", optionalText=");
            sb.append(this.optionalText);
            sb.append(", showBadge=");
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.showBadge, ')');
        }

        public /* synthetic */ RowData(String str, Function0 function0, String str2, boolean z, int r5, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, function0, (r5 & 4) != 0 ? "" : str2, (r5 & 8) != 0 ? false : z);
        }
    }
}
