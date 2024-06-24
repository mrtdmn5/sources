package com.animaconnected.secondo.screens.settings.displaynotifications.components;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
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
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale$Companion$Inside$1;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.animaconnected.secondo.screens.behaviourconfiguration.FeatureIssue;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.TopbarKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallsTextComponents.kt */
/* loaded from: classes3.dex */
public final class CallsTextComponentsKt {

    /* compiled from: CallsTextComponents.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FeatureIssue.values().length];
            try {
                r0[FeatureIssue.GeneralPermissions.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FeatureIssue.GeneralPermission.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FeatureIssue.NotificationAccess.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$CallsTextScreen$1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$CallsTextScreen$2, kotlin.jvm.internal.Lambda] */
    public static final void CallsTextScreen(final List<Filter> filters, final Filter activeFilter, final String screenTitle, int r32, final ModalBottomSheetState sheetState, final Function0<Unit> onBackClick, final Function1<? super Filter, Unit> onFilterSelected, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> sheetContent, Composer composer, final int r38, final int r39) {
        int r28;
        Intrinsics.checkNotNullParameter(filters, "filters");
        Intrinsics.checkNotNullParameter(activeFilter, "activeFilter");
        Intrinsics.checkNotNullParameter(screenTitle, "screenTitle");
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onFilterSelected, "onFilterSelected");
        Intrinsics.checkNotNullParameter(sheetContent, "sheetContent");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-545558995);
        if ((r39 & 8) != 0) {
            r28 = 0;
        } else {
            r28 = r32;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        long j = Color.Transparent;
        final int r3 = r28;
        ModalBottomSheetKt.m191ModalBottomSheetLayoutGs3lGvM(ComposableLambdaKt.composableLambda(startRestartGroup, 1949421403, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$CallsTextScreen$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope ModalBottomSheetLayout, Composer composer2, int r5) {
                Intrinsics.checkNotNullParameter(ModalBottomSheetLayout, "$this$ModalBottomSheetLayout");
                if ((r5 & 14) == 0) {
                    r5 |= composer2.changed(ModalBottomSheetLayout) ? 4 : 2;
                }
                if ((r5 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    sheetContent.invoke(ModalBottomSheetLayout, composer2, Integer.valueOf(r5 & 14));
                }
            }
        }), null, sheetState, false, RectangleShapeKt.RectangleShape, 0.0f, Color.White, 0L, j, ComposableLambdaKt.composableLambda(startRestartGroup, 1920763476, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$CallsTextScreen$2
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

            public final void invoke(Composer composer2, int r31) {
                if ((r31 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                ProvidableCompositionLocal providableCompositionLocal = ColorsKt.LocalColors;
                Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(companion, ((Colors) composer2.consume(providableCompositionLocal)).m164getBackground0d7_KjU(), RectangleShapeKt.RectangleShape);
                final Function0<Unit> function0 = onBackClick;
                int r11 = r3;
                String str = screenTitle;
                List<Filter> list = filters;
                Filter filter = activeFilter;
                Function1<Filter, Unit> function1 = onFilterSelected;
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
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
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer2), composer2, 2058660585);
                    String stringResource = URLProtocolKt.stringResource(R.string.feature_path_settings, composer2);
                    composer2.startReplaceableGroup(1603826);
                    boolean changedInstance = composer2.changedInstance(function0);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.Companion.Empty) {
                        rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$CallsTextScreen$2$1$1$1
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
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    TopbarKt.TopBar(null, R.drawable.ic_chevron_left, (Function0) rememberedValue, stringResource, null, composer2, 48, 17);
                    if (r11 == 0) {
                        composer2.startReplaceableGroup(1604037);
                        ScreenTitleKt.ScreenTitle(PaddingKt.m73paddingVpY3zN4$default(companion, 0.0f, 32, 1), str, composer2, 6, 0);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(1604232);
                        ScreenTitleKt.ScreenImageTitle(PaddingKt.m73paddingVpY3zN4$default(companion, 0.0f, 32, 1), str, r11, composer2, 6, 0);
                        composer2.endReplaceableGroup();
                    }
                    TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.filtered_notifications_i_want_to_be_notified_by, composer2), PaddingKt.m75paddingqDBjuR0$default(companion, 32, 0.0f, 0.0f, 16, 6), ((Colors) composer2.consume(providableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer2.consume(TypographyKt.LocalTypography)).h4, composer2, 48, 0, 65528);
                    CallsTextComponentsKt.ListItems(list, filter, function1, composer2, 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, ((r38 >> 6) & 896) | 907567622, 170);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final int r4 = r28;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$CallsTextScreen$3
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

                public final void invoke(Composer composer2, int r13) {
                    CallsTextComponentsKt.CallsTextScreen(filters, activeFilter, screenTitle, r4, sheetState, onBackClick, onFilterSelected, sheetContent, composer2, Strings.updateChangedFlags(r38 | 1), r39);
                }
            };
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void FeatureIssueDialog(final java.util.List<java.lang.String> r12, final kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r13, androidx.compose.runtime.Composer r14, final int r15) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt.FeatureIssueDialog(java.util.List, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ListItems(final List<Filter> list, final Filter filter, final Function1<? super Filter, Unit> function1, Composer composer, final int r20) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1941131756);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$ListItems$1
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

            /* JADX WARN: Type inference failed for: r3v1, types: [com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$ListItems$1$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final List<Filter> list2 = list;
                final Filter filter2 = filter;
                final Function1<Filter, Unit> function12 = function1;
                final CallsTextComponentsKt$ListItems$1$invoke$$inlined$items$default$1 callsTextComponentsKt$ListItems$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$ListItems$1$invoke$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(Filter filter3) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((Filter) obj);
                    }
                };
                LazyColumn.items(list2.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$ListItems$1$invoke$$inlined$items$default$3
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
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$ListItems$1$invoke$$inlined$items$default$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                        invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope items, int r12, Composer composer2, int r14) {
                        int r11;
                        long j;
                        Modifier m21backgroundbw27NRU;
                        Intrinsics.checkNotNullParameter(items, "$this$items");
                        if ((r14 & 14) == 0) {
                            r11 = (composer2.changed(items) ? 4 : 2) | r14;
                        } else {
                            r11 = r14;
                        }
                        if ((r14 & 112) == 0) {
                            r11 |= composer2.changed(r12) ? 32 : 16;
                        }
                        if ((r11 & 731) == 146 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        int r112 = r11 & 14;
                        final Filter filter3 = (Filter) list2.get(r12);
                        boolean z = true;
                        boolean z2 = filter2.getAllowed() == filter3.getAllowed();
                        composer2.startReplaceableGroup(-119462416);
                        if (!z2) {
                            j = Color.Transparent;
                        } else {
                            j = ColorKt.Color(Color.m322getRedimpl(r6), Color.m321getGreenimpl(r6), Color.m319getBlueimpl(r6), 0.25f, Color.m320getColorSpaceimpl(((Colors) composer2.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU()));
                        }
                        composer2.endReplaceableGroup();
                        m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(SizeKt.m85heightInVpY3zN4$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 82, 0.0f, 2), j, RectangleShapeKt.RectangleShape);
                        composer2.startReplaceableGroup(-119462120);
                        boolean changedInstance = composer2.changedInstance(function12);
                        int r7 = r112 & 112;
                        if (((r7 ^ 48) <= 32 || !composer2.changed(filter3)) && (r112 & 48) != 32) {
                            z = false;
                        }
                        boolean z3 = changedInstance | z;
                        Object rememberedValue = composer2.rememberedValue();
                        if (z3 || rememberedValue == Composer.Companion.Empty) {
                            final Function1 function13 = function12;
                            rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$ListItems$1$1$1$1
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
                                    function13.invoke(filter3);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        CallsTextComponentsKt.ListRow(PaddingKt.m72paddingVpY3zN4(ClickableKt.m26clickableXHw0xAI$default(m21backgroundbw27NRU, (Function0) rememberedValue), 32, 16), filter3, z2, composer2, r7, 0);
                    }
                }, true));
            }
        }, startRestartGroup, 0, 255);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$ListItems$2
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
                    CallsTextComponentsKt.ListItems(list, filter, function1, composer2, Strings.updateChangedFlags(r20 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ListRow(Modifier modifier, final Filter filter, final boolean z, Composer composer, final int r66, final int r67) {
        Modifier modifier2;
        int r5;
        int r52;
        int r6;
        int r62;
        ColorFilter porterDuffColorFilter;
        final Modifier modifier3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-589893116);
        int r1 = r67 & 1;
        if (r1 != 0) {
            r5 = r66 | 6;
            modifier2 = modifier;
        } else if ((r66 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r52 = 4;
            } else {
                r52 = 2;
            }
            r5 = r52 | r66;
        } else {
            modifier2 = modifier;
            r5 = r66;
        }
        if ((r67 & 2) != 0) {
            r5 |= 48;
        } else if ((r66 & 112) == 0) {
            if (startRestartGroup.changed(filter)) {
                r6 = 32;
            } else {
                r6 = 16;
            }
            r5 |= r6;
        }
        if ((r67 & 4) != 0) {
            r5 |= 384;
        } else if ((r66 & 896) == 0) {
            if (startRestartGroup.changed(z)) {
                r62 = 256;
            } else {
                r62 = 128;
            }
            r5 |= r62;
        }
        if ((r5 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (r1 != 0) {
                modifier2 = companion;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
            int r53 = ((((((r5 & 14) | 384) << 3) & 112) << 9) & 7168) | 6;
            Applier<?> applier = startRestartGroup.applier;
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r53 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier weight = rowScopeInstance.weight(companion, 2.0f, true);
                BiasAlignment biasAlignment = Alignment.Companion.CenterStart;
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, -483455358);
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
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
                        Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                            AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        modifierMaterializerOf3.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        String title = filter.getTitle();
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                        long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
                        Modifier modifier4 = modifier2;
                        com.animaconnected.widget.TextKt.m1633CapsTextfLXpl1I(title, null, m166getOnBackground0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).button, startRestartGroup, 0, 0, 32762);
                        SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 8), startRestartGroup, 6);
                        TextKt.m216Text4IGK_g(filter.getDescription(), null, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).caption, startRestartGroup, 0, 0, 65530);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                        Modifier weight2 = rowScopeInstance.weight(companion, 1.0f, true);
                        BiasAlignment biasAlignment2 = Alignment.Companion.CenterEnd;
                        startRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(biasAlignment2, false, startRestartGroup);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                        PersistentCompositionLocalMap currentCompositionLocalScope4 = startRestartGroup.currentCompositionLocalScope();
                        ComposableLambdaImpl modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight2);
                        if (applier instanceof Applier) {
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.inserting) {
                                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                startRestartGroup.useNode();
                            }
                            Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope4, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash4))) {
                                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash4, startRestartGroup, currentCompositeKeyHash4, composeUiNode$Companion$SetCompositeKeyHash$1);
                            }
                            modifierMaterializerOf4.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                            startRestartGroup.startReplaceableGroup(2058660585);
                            boolean showBadge = filter.getShowBadge();
                            ContentScale$Companion$Inside$1 contentScale$Companion$Inside$1 = ContentScale.Companion.Inside;
                            if (showBadge) {
                                startRestartGroup.startReplaceableGroup(1663806632);
                                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_badge_attention, startRestartGroup), URLProtocolKt.stringResource(R.string.bottom_dialog_general_singular_title, startRestartGroup), SizeKt.m91size3ABfNKs(companion, 48), null, contentScale$Companion$Inside$1, 0.0f, null, startRestartGroup, 24968, 104);
                                startRestartGroup.end(false);
                            } else if (z) {
                                startRestartGroup.startReplaceableGroup(1663806965);
                                Modifier m91size3ABfNKs = SizeKt.m91size3ABfNKs(companion, 36);
                                Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.ic_check, startRestartGroup);
                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                long m173getSecondaryVariant0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m173getSecondaryVariant0d7_KjU();
                                if (Build.VERSION.SDK_INT >= 29) {
                                    porterDuffColorFilter = BlendModeColorFilterHelper.INSTANCE.m309BlendModeColorFilterxETnrds(m173getSecondaryVariant0d7_KjU, 5);
                                } else {
                                    porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m327toArgb8_81llA(m173getSecondaryVariant0d7_KjU), AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(5));
                                }
                                ImageKt.Image(painterResource, "", m91size3ABfNKs, null, contentScale$Companion$Inside$1, 0.0f, new androidx.compose.ui.graphics.ColorFilter(porterDuffColorFilter), startRestartGroup, 25016, 40);
                                startRestartGroup.end(false);
                            } else {
                                startRestartGroup.startReplaceableGroup(1663807277);
                                startRestartGroup.end(false);
                            }
                            AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                            AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                            modifier3 = modifier4;
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
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt$ListRow$2
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
                    CallsTextComponentsKt.ListRow(Modifier.this, filter, z, composer2, Strings.updateChangedFlags(r66 | 1), r67);
                }
            };
        }
    }
}
