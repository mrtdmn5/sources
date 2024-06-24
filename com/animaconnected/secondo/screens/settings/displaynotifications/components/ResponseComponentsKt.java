package com.animaconnected.secondo.screens.settings.displaynotifications.components;

import android.content.Context;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.VerticalAlignElement;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DividerKt;
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
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.animaconnected.secondo.utils.ViewKt;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseComponents.kt */
/* loaded from: classes3.dex */
public final class ResponseComponentsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Response(final String str, final Function1<? super String, Unit> function1, Composer composer, final int r31) {
        int r1;
        boolean z;
        ComposerImpl composerImpl;
        int r6;
        int r12;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1404733917);
        if ((r31 & 14) == 0) {
            if (startRestartGroup.changed(str)) {
                r12 = 4;
            } else {
                r12 = 2;
            }
            r1 = r12 | r31;
        } else {
            r1 = r31;
        }
        if ((r31 & 112) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r6 = 32;
            } else {
                r6 = 16;
            }
            r1 |= r6;
        }
        if ((r1 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            startRestartGroup.startReplaceableGroup(338069329);
            boolean z2 = true;
            if ((r1 & 112) == 32) {
                z = true;
            } else {
                z = false;
            }
            int r15 = r1 & 14;
            if (r15 != 4) {
                z2 = false;
            }
            boolean z3 = z2 | z;
            Object nextSlot = startRestartGroup.nextSlot();
            if (z3 || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt$Response$1$1
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
                        function1.invoke(str);
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            Modifier m83height3ABfNKs = SizeKt.m83height3ABfNKs(PaddingKt.m73paddingVpY3zN4$default(ClickableKt.m26clickableXHw0xAI$default(companion, (Function0) nextSlot), 32, 0.0f, 2), 56);
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m83height3ABfNKs);
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                TextKt.m216Text4IGK_g(str, SizeKt.fillMaxWidth(new VerticalAlignElement(Alignment.Companion.CenterVertically), 1.0f), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).body2, startRestartGroup, r15, 0, 65528);
                composerImpl = startRestartGroup;
                AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt$Response$3
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
                    ResponseComponentsKt.Response(str, function1, composer2, Strings.updateChangedFlags(r31 | 1));
                }
            };
        }
    }

    public static final void ResponseScreen(Modifier modifier, final String screenTitle, final Function0<Unit> onNavigationClick, final String responseTitle, final List<String> responses, final String responseAbout, Composer composer, final int r26, final int r27) {
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(screenTitle, "screenTitle");
        Intrinsics.checkNotNullParameter(onNavigationClick, "onNavigationClick");
        Intrinsics.checkNotNullParameter(responseTitle, "responseTitle");
        Intrinsics.checkNotNullParameter(responses, "responses");
        Intrinsics.checkNotNullParameter(responseAbout, "responseAbout");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1233435753);
        int r1 = r27 & 1;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, -1328089662);
            boolean z = true;
            if ((((r26 & 896) ^ 384) <= 256 || !startRestartGroup.changedInstance(onNavigationClick)) && (r26 & 384) != 256) {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt$ResponseScreen$1$1$1
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
                        onNavigationClick.invoke();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            TopbarKt.TopBar(null, R.drawable.ic_chevron_left, (Function0) nextSlot, URLProtocolKt.stringResource(R.string.feature_path_settings, startRestartGroup), null, startRestartGroup, 48, 17);
            ScreenTitleKt.ScreenTitle(PaddingKt.m75paddingqDBjuR0$default(modifier2, 0.0f, 0.0f, 0.0f, 32, 7), screenTitle, startRestartGroup, r26 & 112, 0);
            Responses(responses, modifier2, responseTitle, responseAbout, startRestartGroup, ((r26 << 3) & 112) | 8 | ((r26 >> 3) & 896) | ((r26 >> 6) & 7168), 0);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt$ResponseScreen$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r11) {
                        ResponseComponentsKt.ResponseScreen(Modifier.this, screenTitle, onNavigationClick, responseTitle, responses, responseAbout, composer2, Strings.updateChangedFlags(r26 | 1), r27);
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final void Responses(final List<String> responses, Modifier modifier, final String responseTitle, final String about, Composer composer, final int r37, final int r38) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(responses, "responses");
        Intrinsics.checkNotNullParameter(responseTitle, "responseTitle");
        Intrinsics.checkNotNullParameter(about, "about");
        ComposerImpl startRestartGroup = composer.startRestartGroup(900013709);
        int r3 = r38 & 2;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r3 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.LocalContext);
        Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(modifier2, 0.0f, 32, 0.0f, 0.0f, 13);
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
        long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
        StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
        TextKt.m216Text4IGK_g(responseTitle, m75paddingqDBjuR0$default, m166getOnBackground0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).h4, startRestartGroup, (r37 >> 6) & 14, 0, 65528);
        LazyDslKt.LazyColumn(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 8, 0.0f, 0.0f, 13), null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt$Responses$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                invoke2(lazyListScope);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt$Responses$1$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final List<String> list = responses;
                final Context context2 = context;
                final ResponseComponentsKt$Responses$1$invoke$$inlined$items$default$1 responseComponentsKt$Responses$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt$Responses$1$invoke$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(String str) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((String) obj);
                    }
                };
                LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt$Responses$1$invoke$$inlined$items$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int r32) {
                        return Function1.this.invoke(list.get(r32));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt$Responses$1$invoke$$inlined$items$default$4
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
                        String str = (String) list.get(r10);
                        DividerKt.m180DivideroMI9zvI(null, 0L, 0.0f, 0.0f, composer2, 0, 15);
                        final Context context3 = context2;
                        ResponseComponentsKt.Response(str, new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt$Responses$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                invoke2(str2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                ViewKt.toast$default(context3, "Not implemented", false, 2, (Object) null);
                            }
                        }, composer2, ((r9 & 14) >> 3) & 14);
                    }
                }, true));
            }
        }, startRestartGroup, 6, 254);
        DividerKt.m180DivideroMI9zvI(null, 0L, 0.0f, 0.0f, startRestartGroup, 0, 15);
        TextKt.m216Text4IGK_g(about, PaddingKt.m75paddingqDBjuR0$default(modifier2, 0.0f, 16, 0.0f, 0.0f, 13), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).caption, startRestartGroup, (r37 >> 9) & 14, 0, 65528);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt$Responses$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r9) {
                    ResponseComponentsKt.Responses(responses, modifier3, responseTitle, about, composer2, Strings.updateChangedFlags(r37 | 1), r38);
                }
            };
        }
    }
}
