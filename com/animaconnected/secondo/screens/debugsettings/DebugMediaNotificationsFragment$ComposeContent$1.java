package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.SliderKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
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
import com.animaconnected.watch.MusicInfo;
import com.animaconnected.watch.MusicPlayback;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.Switch2Kt;
import com.google.common.collect.Platform;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: DebugMediaNotificationsFragment.kt */
/* loaded from: classes3.dex */
public final class DebugMediaNotificationsFragment$ComposeContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<MusicInfo> $musicInfo$delegate;
    final /* synthetic */ MutableState<MusicPlayback> $playbackState$delegate;
    final /* synthetic */ List<Pair<String, Integer>> $playbackStates;
    final /* synthetic */ DebugMediaNotificationsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugMediaNotificationsFragment$ComposeContent$1(MutableState<MusicInfo> mutableState, MutableState<MusicPlayback> mutableState2, List<Pair<String, Integer>> list, DebugMediaNotificationsFragment debugMediaNotificationsFragment) {
        super(2);
        this.$musicInfo$delegate = mutableState;
        this.$playbackState$delegate = mutableState2;
        this.$playbackStates = list;
        this.this$0 = debugMediaNotificationsFragment;
    }

    private static final boolean invoke$lambda$12$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$12$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v15, types: [com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$10, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$5$3, kotlin.jvm.internal.Lambda] */
    public final void invoke(Composer composer, int r48) {
        MusicInfo ComposeContent$lambda$1;
        MusicInfo ComposeContent$lambda$12;
        final MutableState<MusicInfo> mutableState;
        MusicInfo ComposeContent$lambda$13;
        final MutableState<MusicInfo> mutableState2;
        MusicInfo ComposeContent$lambda$14;
        final MutableState<MusicInfo> mutableState3;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1;
        MusicPlayback ComposeContent$lambda$4;
        Modifier m21backgroundbw27NRU;
        Modifier m21backgroundbw27NRU2;
        final MutableState mutableState4;
        MusicPlayback ComposeContent$lambda$42;
        MusicInfo ComposeContent$lambda$15;
        final MutableState<MusicInfo> mutableState5;
        MutableState mutableState6;
        MutableState mutableState7;
        if ((r48 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final MutableState<MusicInfo> mutableState8 = this.$musicInfo$delegate;
        final MutableState<MusicPlayback> mutableState9 = this.$playbackState$delegate;
        final List<Pair<String, Integer>> list = this.$playbackStates;
        final DebugMediaNotificationsFragment debugMediaNotificationsFragment = this.this$0;
        composer.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer);
        composer.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer);
        PersistentCompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
        if (composer.getApplier() instanceof Applier) {
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(layoutNode$Companion$Constructor$12);
            } else {
                composer.useNode();
            }
            ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Updater.m228setimpl(composer, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
            ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Updater.m228setimpl(composer, currentCompositionLocalMap, composeUiNode$Companion$SetResolvedCompositionLocals$1);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$12);
            }
            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer), composer, 2058660585);
            ScreenTitleKt.ScreenTitle(PaddingKt.m73paddingVpY3zN4$default(companion, 0.0f, 16, 1), "Media notification", composer, 54, 0);
            ComposeContent$lambda$1 = DebugMediaNotificationsFragment.ComposeContent$lambda$1(mutableState8);
            String album = ComposeContent$lambda$1.getAlbum();
            composer.startReplaceableGroup(1224581631);
            Object rememberedValue = composer.rememberedValue();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (rememberedValue == composer$Companion$Empty$1) {
                rememberedValue = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        MusicInfo ComposeContent$lambda$16;
                        Intrinsics.checkNotNullParameter(it, "it");
                        MutableState<MusicInfo> mutableState10 = mutableState8;
                        ComposeContent$lambda$16 = DebugMediaNotificationsFragment.ComposeContent$lambda$1(mutableState10);
                        mutableState10.setValue(MusicInfo.copy$default(ComposeContent$lambda$16, null, null, it, 0, 11, null));
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            ComposableSingletons$DebugMediaNotificationsFragmentKt composableSingletons$DebugMediaNotificationsFragmentKt = ComposableSingletons$DebugMediaNotificationsFragmentKt.INSTANCE;
            OutlinedTextFieldKt.OutlinedTextField(album, (Function1) rememberedValue, null, false, false, null, composableSingletons$DebugMediaNotificationsFragmentKt.m846getLambda1$secondo_kronabyRelease(), null, null, null, false, null, null, null, false, 0, 0, null, null, null, composer, 1572912, 0, 1048508);
            ComposeContent$lambda$12 = DebugMediaNotificationsFragment.ComposeContent$lambda$1(mutableState8);
            String title = ComposeContent$lambda$12.getTitle();
            composer.startReplaceableGroup(1224581843);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == composer$Companion$Empty$1) {
                mutableState = mutableState8;
                rememberedValue2 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        MusicInfo ComposeContent$lambda$16;
                        Intrinsics.checkNotNullParameter(it, "it");
                        MutableState<MusicInfo> mutableState10 = mutableState;
                        ComposeContent$lambda$16 = DebugMediaNotificationsFragment.ComposeContent$lambda$1(mutableState10);
                        mutableState10.setValue(MusicInfo.copy$default(ComposeContent$lambda$16, null, it, null, 0, 13, null));
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            } else {
                mutableState = mutableState8;
            }
            composer.endReplaceableGroup();
            MutableState<MusicInfo> mutableState10 = mutableState;
            OutlinedTextFieldKt.OutlinedTextField(title, (Function1) rememberedValue2, null, false, false, null, composableSingletons$DebugMediaNotificationsFragmentKt.m847getLambda2$secondo_kronabyRelease(), null, null, null, false, null, null, null, false, 0, 0, null, null, null, composer, 1572912, 0, 1048508);
            ComposeContent$lambda$13 = DebugMediaNotificationsFragment.ComposeContent$lambda$1(mutableState10);
            String artist = ComposeContent$lambda$13.getArtist();
            composer.startReplaceableGroup(1224582052);
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == composer$Companion$Empty$1) {
                mutableState2 = mutableState10;
                rememberedValue3 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        MusicInfo ComposeContent$lambda$16;
                        Intrinsics.checkNotNullParameter(it, "it");
                        MutableState<MusicInfo> mutableState11 = mutableState2;
                        ComposeContent$lambda$16 = DebugMediaNotificationsFragment.ComposeContent$lambda$1(mutableState11);
                        mutableState11.setValue(MusicInfo.copy$default(ComposeContent$lambda$16, it, null, null, 0, 14, null));
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            } else {
                mutableState2 = mutableState10;
            }
            composer.endReplaceableGroup();
            MutableState<MusicInfo> mutableState11 = mutableState2;
            OutlinedTextFieldKt.OutlinedTextField(artist, (Function1) rememberedValue3, null, false, false, null, composableSingletons$DebugMediaNotificationsFragmentKt.m848getLambda3$secondo_kronabyRelease(), null, null, null, false, null, null, null, false, 0, 0, null, null, null, composer, 1572912, 0, 1048508);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, 3, 0, 11);
            ComposeContent$lambda$14 = DebugMediaNotificationsFragment.ComposeContent$lambda$1(mutableState11);
            String valueOf = String.valueOf(ComposeContent$lambda$14.getDurationSeconds());
            composer.startReplaceableGroup(1224582383);
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == composer$Companion$Empty$1) {
                mutableState3 = mutableState11;
                rememberedValue4 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        MusicInfo ComposeContent$lambda$16;
                        Intrinsics.checkNotNullParameter(it, "it");
                        MutableState<MusicInfo> mutableState12 = mutableState3;
                        ComposeContent$lambda$16 = DebugMediaNotificationsFragment.ComposeContent$lambda$1(mutableState12);
                        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(it);
                        mutableState12.setValue(MusicInfo.copy$default(ComposeContent$lambda$16, null, null, null, intOrNull != null ? intOrNull.intValue() : 0, 7, null));
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            } else {
                mutableState3 = mutableState11;
            }
            composer.endReplaceableGroup();
            MutableState<MusicInfo> mutableState12 = mutableState3;
            OutlinedTextFieldKt.OutlinedTextField(valueOf, (Function1) rememberedValue4, null, false, false, null, composableSingletons$DebugMediaNotificationsFragmentKt.m849getLambda4$secondo_kronabyRelease(), null, null, null, false, null, keyboardOptions, null, false, 0, 0, null, null, null, composer, 1572912, 384, 1044412);
            composer.startReplaceableGroup(1224582488);
            Object rememberedValue5 = composer.rememberedValue();
            if (rememberedValue5 == composer$Companion$Empty$1) {
                rememberedValue5 = Platform.mutableStateOf$default(Boolean.FALSE);
                composer.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState13 = (MutableState) rememberedValue5;
            composer.endReplaceableGroup();
            BiasAlignment biasAlignment = Alignment.Companion.TopStart;
            Modifier wrapContentSize$default = SizeKt.wrapContentSize$default(companion, biasAlignment, 2);
            composer.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, composer);
            composer.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer);
            PersistentCompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(wrapContentSize$default);
            if (composer.getApplier() instanceof Applier) {
                composer.startReusableNode();
                if (composer.getInserting()) {
                    layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$12;
                    composer.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$12;
                    composer.useNode();
                }
                Updater.m228setimpl(composer, rememberBoxMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                Updater.m228setimpl(composer, currentCompositionLocalMap2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composeUiNode$Companion$SetCompositeKeyHash$1 = composeUiNode$Companion$SetCompositeKeyHash$12;
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                } else {
                    composeUiNode$Companion$SetCompositeKeyHash$1 = composeUiNode$Companion$SetCompositeKeyHash$12;
                }
                modifierMaterializerOf2.invoke((Object) new SkippableUpdater(composer), (Object) composer, (Object) 0);
                composer.startReplaceableGroup(2058660585);
                ComposeContent$lambda$4 = DebugMediaNotificationsFragment.ComposeContent$lambda$4(mutableState9);
                String name = ComposeContent$lambda$4.getState().name();
                Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                composer.startReplaceableGroup(37351910);
                Object rememberedValue6 = composer.rememberedValue();
                if (rememberedValue6 == composer$Companion$Empty$1) {
                    rememberedValue6 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$5$1$1
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
                            DebugMediaNotificationsFragment$ComposeContent$1.invoke$lambda$12$lambda$6(mutableState13, true);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue6);
                }
                composer.endReplaceableGroup();
                m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(ClickableKt.m26clickableXHw0xAI$default(fillMaxWidth, (Function0) rememberedValue6), Color.LightGray, RectangleShapeKt.RectangleShape);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$13 = composeUiNode$Companion$SetCompositeKeyHash$1;
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$13 = layoutNode$Companion$Constructor$1;
                TextKt.m216Text4IGK_g(name, m21backgroundbw27NRU, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131068);
                m21backgroundbw27NRU2 = BackgroundKt.m21backgroundbw27NRU(SizeKt.fillMaxWidth(companion, 1.0f), Color.Red, RectangleShapeKt.RectangleShape);
                boolean invoke$lambda$12$lambda$5 = invoke$lambda$12$lambda$5(mutableState13);
                composer.startReplaceableGroup(37352272);
                Object rememberedValue7 = composer.rememberedValue();
                if (rememberedValue7 == composer$Companion$Empty$1) {
                    mutableState4 = mutableState13;
                    rememberedValue7 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$5$2$1
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
                            DebugMediaNotificationsFragment$ComposeContent$1.invoke$lambda$12$lambda$6(mutableState4, false);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue7);
                } else {
                    mutableState4 = mutableState13;
                }
                composer.endReplaceableGroup();
                AndroidMenu_androidKt.m155DropdownMenu4kj_NE(invoke$lambda$12$lambda$5, (Function0) rememberedValue7, m21backgroundbw27NRU2, 0L, null, null, ComposableLambdaKt.composableLambda(composer, -1205045717, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$5$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                        invoke(columnScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r7v0, types: [com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$5$3$1$2, kotlin.jvm.internal.Lambda] */
                    public final void invoke(ColumnScope DropdownMenu, Composer composer2, int r17) {
                        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                        if ((r17 & 81) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        List<Pair<String, Integer>> list2 = list;
                        final MutableState<Boolean> mutableState14 = mutableState4;
                        final MutableState<MusicPlayback> mutableState15 = mutableState9;
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            final String str = (String) pair.first;
                            final int intValue = ((Number) pair.second).intValue();
                            composer2.startReplaceableGroup(-649671237);
                            boolean changed = composer2.changed(intValue);
                            Object rememberedValue8 = composer2.rememberedValue();
                            if (changed || rememberedValue8 == Composer.Companion.Empty) {
                                rememberedValue8 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$5$3$1$1$1
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
                                        MusicPlayback ComposeContent$lambda$43;
                                        DebugMediaNotificationsFragment$ComposeContent$1.invoke$lambda$12$lambda$6(mutableState14, false);
                                        MutableState<MusicPlayback> mutableState16 = mutableState15;
                                        ComposeContent$lambda$43 = DebugMediaNotificationsFragment.ComposeContent$lambda$4(mutableState16);
                                        mutableState16.setValue(MusicPlayback.copy$default(ComposeContent$lambda$43, 0L, intValue, 1, null));
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue8);
                            }
                            composer2.endReplaceableGroup();
                            AndroidMenu_androidKt.DropdownMenuItem((Function0) rememberedValue8, null, false, null, null, ComposableLambdaKt.composableLambda(composer2, -475634841, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$5$3$1$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                    invoke(rowScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope DropdownMenuItem, Composer composer3, int r29) {
                                    Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
                                    if ((r29 & 81) == 16 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                                        TextKt.m216Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131070);
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
                ComposeContent$lambda$42 = DebugMediaNotificationsFragment.ComposeContent$lambda$4(mutableState9);
                float positionSeconds = ComposeContent$lambda$42.getPositionSeconds();
                ComposeContent$lambda$15 = DebugMediaNotificationsFragment.ComposeContent$lambda$1(mutableState12);
                float max = positionSeconds / Math.max(ComposeContent$lambda$15.getDurationSeconds(), 1);
                composer.startReplaceableGroup(1224583875);
                Object rememberedValue8 = composer.rememberedValue();
                if (rememberedValue8 == composer$Companion$Empty$1) {
                    mutableState5 = mutableState12;
                    rememberedValue8 = new Function1<Float, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                            invoke(f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f) {
                            MusicPlayback ComposeContent$lambda$43;
                            MusicInfo ComposeContent$lambda$16;
                            MutableState<MusicPlayback> mutableState14 = mutableState9;
                            ComposeContent$lambda$43 = DebugMediaNotificationsFragment.ComposeContent$lambda$4(mutableState14);
                            ComposeContent$lambda$16 = DebugMediaNotificationsFragment.ComposeContent$lambda$1(mutableState5);
                            mutableState14.setValue(MusicPlayback.copy$default(ComposeContent$lambda$43, f * ComposeContent$lambda$16.getDurationSeconds() * 1000, 0, 2, null));
                        }
                    };
                    composer.updateRememberedValue(rememberedValue8);
                } else {
                    mutableState5 = mutableState12;
                }
                composer.endReplaceableGroup();
                final MutableState<MusicInfo> mutableState14 = mutableState5;
                SliderKt.Slider(max, (Function1) rememberedValue8, null, false, null, 0, null, null, null, composer, 48, 508);
                ButtonKt.Button(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$7
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
                        MusicInfo ComposeContent$lambda$16;
                        MusicPlayback ComposeContent$lambda$43;
                        DebugMediaNotificationsFragment debugMediaNotificationsFragment2 = DebugMediaNotificationsFragment.this;
                        ComposeContent$lambda$16 = DebugMediaNotificationsFragment.ComposeContent$lambda$1(mutableState14);
                        ComposeContent$lambda$43 = DebugMediaNotificationsFragment.ComposeContent$lambda$4(mutableState9);
                        debugMediaNotificationsFragment2.sendMediaNotification(ComposeContent$lambda$16, ComposeContent$lambda$43);
                    }
                }, null, false, null, null, null, null, null, null, composableSingletons$DebugMediaNotificationsFragmentKt.m850getLambda5$secondo_kronabyRelease(), composer, 805306368, 510);
                Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(companion, 8);
                BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                composer.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, composer);
                composer.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer);
                PersistentCompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
                if (composer.getApplier() instanceof Applier) {
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(layoutNode$Companion$Constructor$13);
                    } else {
                        composer.useNode();
                    }
                    Updater.m228setimpl(composer, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(composer, currentCompositionLocalMap3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, composer, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$13);
                    }
                    modifierMaterializerOf3.invoke((Object) new SkippableUpdater(composer), (Object) composer, (Object) 0);
                    composer.startReplaceableGroup(2058660585);
                    mutableState6 = debugMediaNotificationsFragment.useMediaManager;
                    Switch2Kt.Switch2(((Boolean) mutableState6.getValue()).booleanValue(), new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$8$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            MutableState mutableState15;
                            mutableState15 = DebugMediaNotificationsFragment.this.useMediaManager;
                            mutableState15.setValue(Boolean.valueOf(z));
                        }
                    }, null, false, null, null, composer, 0, 60);
                    Modifier fillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    StringBuilder sb = new StringBuilder("Use media info from android: ");
                    mutableState7 = debugMediaNotificationsFragment.useMediaManager;
                    sb.append(((Boolean) mutableState7.getValue()).booleanValue());
                    TextKt.m216Text4IGK_g(sb.toString(), fillMaxWidth2, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 48, 0, 131068);
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ButtonKt.Button(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$9
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
                            DebugMediaNotificationsFragment.this.sendVolume();
                        }
                    }, null, false, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer, -1824757991, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$1$1$10
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                            invoke(rowScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public final void invoke(RowScope Button, Composer composer2, int r30) {
                            MutableState mutableState15;
                            Intrinsics.checkNotNullParameter(Button, "$this$Button");
                            if ((r30 & 81) == 16 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                            Modifier fillMaxWidth3 = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                            StringBuilder sb2 = new StringBuilder("Send volume 30. Current volume ");
                            mutableState15 = DebugMediaNotificationsFragment.this.currentVolume;
                            sb2.append(((Number) mutableState15.getValue()).intValue());
                            TextKt.m216Text4IGK_g(sb2.toString(), fillMaxWidth3, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 48, 0, 131068);
                        }
                    }), composer, 805306368, 510);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer);
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
}
