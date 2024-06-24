package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CheckboxKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
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
import com.animaconnected.watch.device.CallState;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.Switch2Kt;
import com.google.common.collect.Platform;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DebugCallNotificationsFragment.kt */
/* loaded from: classes3.dex */
public final class DebugCallNotificationsFragment$CallControl$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Pair<CallState, String>> $callInfo;
    final /* synthetic */ MutableState<Boolean> $canAnswer;
    final /* synthetic */ MutableState<Boolean> $canEnd;
    final /* synthetic */ Pair<CallState, String> $info;
    final /* synthetic */ Function0<Unit> $makeCall;
    final /* synthetic */ DebugCallNotificationsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DebugCallNotificationsFragment$CallControl$1(Pair<? extends CallState, String> pair, MutableState<Pair<CallState, String>> mutableState, Function0<Unit> function0, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, DebugCallNotificationsFragment debugCallNotificationsFragment) {
        super(2);
        this.$info = pair;
        this.$callInfo = mutableState;
        this.$makeCall = function0;
        this.$canAnswer = mutableState2;
        this.$canEnd = mutableState3;
        this.this$0 = debugCallNotificationsFragment;
    }

    private static final boolean invoke$lambda$12$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$12$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10, types: [com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$1$1$4$3, kotlin.jvm.internal.Lambda] */
    public final void invoke(Composer composer, int r57) {
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12;
        ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12;
        Modifier m21backgroundbw27NRU;
        Modifier m21backgroundbw27NRU2;
        final MutableState mutableState;
        MutableState mutableState2;
        if ((r57 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final Pair<CallState, String> pair = this.$info;
        final MutableState<Pair<CallState, String>> mutableState3 = this.$callInfo;
        Function0<Unit> function0 = this.$makeCall;
        final MutableState<Boolean> mutableState4 = this.$canAnswer;
        final MutableState<Boolean> mutableState5 = this.$canEnd;
        final DebugCallNotificationsFragment debugCallNotificationsFragment = this.this$0;
        composer.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer);
        composer.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer);
        PersistentCompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$13 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
        if (composer.getApplier() instanceof Applier) {
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(layoutNode$Companion$Constructor$13);
            } else {
                composer.useNode();
            }
            ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Updater.m228setimpl(composer, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
            ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Updater.m228setimpl(composer, currentCompositionLocalMap, composeUiNode$Companion$SetResolvedCompositionLocals$1);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$13 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$13);
            }
            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer), composer, 2058660585);
            Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            composer.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, composer);
            composer.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer);
            PersistentCompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth);
            if (composer.getApplier() instanceof Applier) {
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(layoutNode$Companion$Constructor$13);
                } else {
                    composer.useNode();
                }
                Updater.m228setimpl(composer, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                Updater.m228setimpl(composer, currentCompositionLocalMap2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$13);
                }
                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf2, new SkippableUpdater(composer), composer, 2058660585);
                TextKt.m216Text4IGK_g("Can answer", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
                boolean booleanValue = mutableState4.getValue().booleanValue();
                composer.startReplaceableGroup(-1981585620);
                boolean changed = composer.changed(mutableState4);
                Object rememberedValue = composer.rememberedValue();
                Object obj = Composer.Companion.Empty;
                if (changed || rememberedValue == obj) {
                    rememberedValue = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$1$1$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            mutableState4.setValue(Boolean.valueOf(z));
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                CheckboxKt.Checkbox(booleanValue, (Function1) rememberedValue, null, false, null, null, composer, 0, 60);
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                Modifier fillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                composer.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, composer);
                composer.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer);
                PersistentCompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth2);
                if (composer.getApplier() instanceof Applier) {
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$13;
                        composer.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$13;
                        composer.useNode();
                    }
                    Updater.m228setimpl(composer, rowMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(composer, currentCompositionLocalMap3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composeUiNode$Companion$SetCompositeKeyHash$1 = composeUiNode$Companion$SetCompositeKeyHash$13;
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, composer, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                    } else {
                        composeUiNode$Companion$SetCompositeKeyHash$1 = composeUiNode$Companion$SetCompositeKeyHash$13;
                    }
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf3, new SkippableUpdater(composer), composer, 2058660585);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$14 = composeUiNode$Companion$SetCompositeKeyHash$1;
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$14 = layoutNode$Companion$Constructor$1;
                    TextKt.m216Text4IGK_g("Can end", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
                    boolean booleanValue2 = mutableState5.getValue().booleanValue();
                    composer.startReplaceableGroup(-1981585228);
                    boolean changed2 = composer.changed(mutableState5);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changed2 || rememberedValue2 == obj) {
                        rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$1$1$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z) {
                                mutableState5.setValue(Boolean.valueOf(z));
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceableGroup();
                    CheckboxKt.Checkbox(booleanValue2, (Function1) rememberedValue2, null, false, null, null, composer, 0, 60);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer);
                    ScreenTitleKt.ScreenTitle(PaddingKt.m73paddingVpY3zN4$default(companion, 0.0f, 16, 1), "Call notification", composer, 54, 0);
                    String str = pair.second;
                    composer.startReplaceableGroup(-358608949);
                    boolean changed3 = composer.changed(mutableState3) | composer.changed(pair);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (changed3 || rememberedValue3 == obj) {
                        rememberedValue3 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$1$1$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                MutableState<Pair<CallState, String>> mutableState6 = mutableState3;
                                Pair<CallState, String> pair2 = pair;
                                CallState callState = pair2.first;
                                pair2.getClass();
                                mutableState6.setValue(new Pair<>(callState, it));
                            }
                        };
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    composer.endReplaceableGroup();
                    ComposableSingletons$DebugCallNotificationsFragmentKt composableSingletons$DebugCallNotificationsFragmentKt = ComposableSingletons$DebugCallNotificationsFragmentKt.INSTANCE;
                    OutlinedTextFieldKt.OutlinedTextField(str, (Function1) rememberedValue3, null, false, false, null, composableSingletons$DebugCallNotificationsFragmentKt.m844getLambda1$secondo_kronabyRelease(), null, null, null, false, null, null, null, false, 0, 0, null, null, null, composer, 1572864, 0, 1048508);
                    composer.startReplaceableGroup(-358608871);
                    Object rememberedValue4 = composer.rememberedValue();
                    if (rememberedValue4 == obj) {
                        rememberedValue4 = Platform.mutableStateOf$default(Boolean.FALSE);
                        composer.updateRememberedValue(rememberedValue4);
                    }
                    final MutableState mutableState6 = (MutableState) rememberedValue4;
                    composer.endReplaceableGroup();
                    BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                    Modifier wrapContentSize$default = SizeKt.wrapContentSize$default(companion, biasAlignment, 2);
                    composer.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, composer);
                    composer.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer);
                    PersistentCompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                    ComposableLambdaImpl modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(wrapContentSize$default);
                    if (composer.getApplier() instanceof Applier) {
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            layoutNode$Companion$Constructor$12 = layoutNode$Companion$Constructor$14;
                            composer.createNode(layoutNode$Companion$Constructor$12);
                        } else {
                            layoutNode$Companion$Constructor$12 = layoutNode$Companion$Constructor$14;
                            composer.useNode();
                        }
                        Updater.m228setimpl(composer, rememberBoxMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(composer, currentCompositionLocalMap4, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composeUiNode$Companion$SetCompositeKeyHash$12 = composeUiNode$Companion$SetCompositeKeyHash$14;
                            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash4, composer, currentCompositeKeyHash4, composeUiNode$Companion$SetCompositeKeyHash$12);
                        } else {
                            composeUiNode$Companion$SetCompositeKeyHash$12 = composeUiNode$Companion$SetCompositeKeyHash$14;
                        }
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf4, new SkippableUpdater(composer), composer, 2058660585);
                        String name = pair.first.name();
                        Modifier fillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                        composer.startReplaceableGroup(-1981584482);
                        Object rememberedValue5 = composer.rememberedValue();
                        if (rememberedValue5 == obj) {
                            rememberedValue5 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$1$1$4$1$1
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
                                    DebugCallNotificationsFragment$CallControl$1.invoke$lambda$12$lambda$7(mutableState6, true);
                                }
                            };
                            composer.updateRememberedValue(rememberedValue5);
                        }
                        composer.endReplaceableGroup();
                        m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(ClickableKt.m26clickableXHw0xAI$default(fillMaxWidth3, (Function0) rememberedValue5), Color.LightGray, RectangleShapeKt.RectangleShape);
                        ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$15 = composeUiNode$Companion$SetCompositeKeyHash$12;
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$15 = layoutNode$Companion$Constructor$12;
                        TextKt.m216Text4IGK_g(name, m21backgroundbw27NRU, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131068);
                        m21backgroundbw27NRU2 = BackgroundKt.m21backgroundbw27NRU(SizeKt.fillMaxWidth(companion, 1.0f), Color.Red, RectangleShapeKt.RectangleShape);
                        boolean invoke$lambda$12$lambda$6 = invoke$lambda$12$lambda$6(mutableState6);
                        composer.startReplaceableGroup(-1981584120);
                        Object rememberedValue6 = composer.rememberedValue();
                        if (rememberedValue6 == obj) {
                            mutableState = mutableState6;
                            rememberedValue6 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$1$1$4$2$1
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
                                    DebugCallNotificationsFragment$CallControl$1.invoke$lambda$12$lambda$7(mutableState, false);
                                }
                            };
                            composer.updateRememberedValue(rememberedValue6);
                        } else {
                            mutableState = mutableState6;
                        }
                        composer.endReplaceableGroup();
                        AndroidMenu_androidKt.m155DropdownMenu4kj_NE(invoke$lambda$12$lambda$6, (Function0) rememberedValue6, m21backgroundbw27NRU2, 0L, null, null, ComposableLambdaKt.composableLambda(composer, 860582468, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$1$1$4$3

                            /* compiled from: DebugCallNotificationsFragment.kt */
                            /* loaded from: classes3.dex */
                            public /* synthetic */ class EntriesMappings {
                                public static final /* synthetic */ EnumEntries<CallState> entries$0 = EnumEntriesKt.enumEntries(CallState.values());
                            }

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

                            /* JADX WARN: Type inference failed for: r7v0, types: [com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$1$1$4$3$1$2, kotlin.jvm.internal.Lambda] */
                            public final void invoke(ColumnScope DropdownMenu, Composer composer2, int r18) {
                                Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                                if ((r18 & 81) == 16 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                EnumEntries<CallState> enumEntries = EntriesMappings.entries$0;
                                final MutableState<Pair<CallState, String>> mutableState7 = mutableState3;
                                final Pair<CallState, String> pair2 = pair;
                                final MutableState<Boolean> mutableState8 = mutableState;
                                for (final CallState callState : enumEntries) {
                                    composer2.startReplaceableGroup(-144513682);
                                    boolean changed4 = composer2.changed(mutableState7) | composer2.changed(pair2) | composer2.changed(callState);
                                    Object rememberedValue7 = composer2.rememberedValue();
                                    if (changed4 || rememberedValue7 == Composer.Companion.Empty) {
                                        rememberedValue7 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$1$1$4$3$1$1$1
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
                                                DebugCallNotificationsFragment$CallControl$1.invoke$lambda$12$lambda$7(mutableState8, false);
                                                MutableState<Pair<CallState, String>> mutableState9 = mutableState7;
                                                Pair<CallState, String> pair3 = pair2;
                                                CallState callState2 = callState;
                                                String str2 = pair3.second;
                                                pair3.getClass();
                                                mutableState9.setValue(new Pair<>(callState2, str2));
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue7);
                                    }
                                    composer2.endReplaceableGroup();
                                    AndroidMenu_androidKt.DropdownMenuItem((Function0) rememberedValue7, null, false, null, null, ComposableLambdaKt.composableLambda(composer2, -280754773, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$1$1$4$3$1$2
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                            invoke(rowScope, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(RowScope DropdownMenuItem, Composer composer3, int r30) {
                                            Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
                                            if ((r30 & 81) == 16 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                                                TextKt.m216Text4IGK_g(CallState.this.name(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131070);
                                            }
                                        }
                                    }), composer2, 196608, 30);
                                }
                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                            }
                        }), composer, 1572912, 56);
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        ButtonKt.Button(function0, null, false, null, null, null, null, null, null, composableSingletons$DebugCallNotificationsFragmentKt.m845getLambda2$secondo_kronabyRelease(), composer, 805306368, 510);
                        Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(companion, 8);
                        composer.startReplaceableGroup(693286680);
                        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, composer);
                        composer.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer);
                        PersistentCompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
                        ComposableLambdaImpl modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
                        if (composer.getApplier() instanceof Applier) {
                            composer.startReusableNode();
                            if (composer.getInserting()) {
                                composer.createNode(layoutNode$Companion$Constructor$15);
                            } else {
                                composer.useNode();
                            }
                            Updater.m228setimpl(composer, rowMeasurePolicy3, composeUiNode$Companion$SetMeasurePolicy$1);
                            Updater.m228setimpl(composer, currentCompositionLocalMap5, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                            if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash5, composer, currentCompositeKeyHash5, composeUiNode$Companion$SetCompositeKeyHash$15);
                            }
                            modifierMaterializerOf5.invoke((Object) new SkippableUpdater(composer), (Object) composer, (Object) 0);
                            composer.startReplaceableGroup(2058660585);
                            mutableState2 = debugCallNotificationsFragment.useCallManager;
                            Switch2Kt.Switch2(((Boolean) mutableState2.getValue()).booleanValue(), new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$1$1$5$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z) {
                                    MutableState mutableState7;
                                    mutableState7 = DebugCallNotificationsFragment.this.useCallManager;
                                    mutableState7.setValue(Boolean.valueOf(z));
                                }
                            }, null, false, null, null, composer, 0, 60);
                            TextKt.m216Text4IGK_g("Use call state info from android", SizeKt.fillMaxWidth(companion, 1.0f), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 54, 0, 131068);
                            composer.endReplaceableGroup();
                            composer.endNode();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endNode();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            return;
                        }
                        ComposablesKt.invalidApplier();
                        throw null;
                    }
                    ComposablesKt.invalidApplier();
                    throw null;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
            ComposablesKt.invalidApplier();
            throw null;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }
}
