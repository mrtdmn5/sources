package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.SleepEntry;
import com.animaconnected.watch.fitness.SleepHistoryEntry;
import com.animaconnected.watch.fitness.WatchFitnessProvider;
import com.animaconnected.watch.fitness.sleep.SleepSession;
import com.animaconnected.watch.fitness.sleep.SleepSessionState;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.util.Comparator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.Dispatchers;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: DebugSleepFragment.kt */
/* loaded from: classes3.dex */
public final class DebugSleepFragment extends ComposeFragment {
    public static final int $stable = 8;
    private final FitnessProvider fitnessProvider = ProviderFactory.getWatch().fitness();
    private final String name = "DebugSleepFragment";

    /* compiled from: DebugSleepFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[SleepSessionState.values().length];
            try {
                r0[SleepSessionState.Invalid.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SleepSessionState.Ongoing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SleepSessionState.Completed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final List<WatchFitnessProvider.DebugSleepSession> ComposeContent$lambda$0(State<? extends List<WatchFitnessProvider.DebugSleepSession>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void DataList(final List<WatchFitnessProvider.DebugSleepSession> list, Composer composer, final int r18) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1159097624);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        int size = list.size();
        startRestartGroup.startReplaceableGroup(-2053367562);
        boolean changed = startRestartGroup.changed(size);
        Object nextSlot = startRestartGroup.nextSlot();
        if (changed || nextSlot == Composer.Companion.Empty) {
            nextSlot = CollectionsKt___CollectionsKt.sortedWith(CollectionsKt___CollectionsKt.toList(list), new Comparator() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSleepFragment$DataList$lambda$2$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return BorderStrokeKt.compareValues(((WatchFitnessProvider.DebugSleepSession) t2).getSession().getSleepTimePeriod().getStart(), ((WatchFitnessProvider.DebugSleepSession) t).getSession().getSleepTimePeriod().getStart());
                }
            });
            startRestartGroup.updateValue(nextSlot);
        }
        final List list2 = (List) nextSlot;
        startRestartGroup.end(false);
        float f = 16;
        LazyDslKt.LazyColumn(PaddingKt.m74paddingqDBjuR0(Modifier.Companion.$$INSTANCE, f, 0, f, f), null, null, false, Arrangement.m60spacedBy0680j_4(4), null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSleepFragment$DataList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                invoke2(lazyListScope);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [com.animaconnected.secondo.screens.debugsettings.DebugSleepFragment$DataList$1$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final List<WatchFitnessProvider.DebugSleepSession> list3 = list2;
                final DebugSleepFragment debugSleepFragment = this;
                final DebugSleepFragment$DataList$1$invoke$$inlined$items$default$1 debugSleepFragment$DataList$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSleepFragment$DataList$1$invoke$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(WatchFitnessProvider.DebugSleepSession debugSleepSession) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((WatchFitnessProvider.DebugSleepSession) obj);
                    }
                };
                LazyColumn.items(list3.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSleepFragment$DataList$1$invoke$$inlined$items$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int r3) {
                        return Function1.this.invoke(list3.get(r3));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSleepFragment$DataList$1$invoke$$inlined$items$default$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                        invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope items, int r3, Composer composer2, int r5) {
                        int r2;
                        Intrinsics.checkNotNullParameter(items, "$this$items");
                        if ((r5 & 14) == 0) {
                            r2 = (composer2.changed(items) ? 4 : 2) | r5;
                        } else {
                            r2 = r5;
                        }
                        if ((r5 & 112) == 0) {
                            r2 |= composer2.changed(r3) ? 32 : 16;
                        }
                        if ((r2 & 731) == 146 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                            debugSleepFragment.ListItem((WatchFitnessProvider.DebugSleepSession) list3.get(r3), composer2, 72);
                        }
                    }
                }, true));
            }
        }, startRestartGroup, 24576, 238);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSleepFragment$DataList$2
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
                    DebugSleepFragment.this.DataList(list, composer2, Strings.updateChangedFlags(r18 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ListItem(final WatchFitnessProvider.DebugSleepSession debugSleepSession, Composer composer, final int r87) {
        Modifier fillMaxWidth;
        boolean z;
        long Color;
        Modifier fillMaxWidth2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1714255631);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        SleepSession session = debugSleepSession.getSession();
        List<SleepEntry> entries = session.getEntries();
        List<SleepEntry> rawData = debugSleepSession.getRawData();
        startRestartGroup.startReplaceableGroup(1378441005);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.end(false);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        float f = 8;
        fillMaxWidth = SizeKt.fillMaxWidth(BackgroundKt.m21backgroundbw27NRU(companion, m890colorvNxB06k(debugSleepSession.getSession().getState()), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f)), 1.0f);
        float f2 = 4;
        Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(fillMaxWidth, f2);
        startRestartGroup.startReplaceableGroup(1378441331);
        Object nextSlot2 = startRestartGroup.nextSlot();
        if (nextSlot2 == composer$Companion$Empty$1) {
            nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSleepFragment$ListItem$1$1
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
                    boolean ListItem$lambda$4;
                    MutableState<Boolean> mutableState2 = mutableState;
                    ListItem$lambda$4 = DebugSleepFragment.ListItem$lambda$4(mutableState2);
                    DebugSleepFragment.ListItem$lambda$5(mutableState2, !ListItem$lambda$4);
                }
            };
            startRestartGroup.updateValue(nextSlot2);
        }
        startRestartGroup.end(false);
        Modifier m26clickableXHw0xAI$default = ClickableKt.m26clickableXHw0xAI$default(m71padding3ABfNKs, (Function0) nextSlot2);
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m26clickableXHw0xAI$default);
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
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            if (1.0f > 0.0d) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                companion.then(layoutWeightElement);
                Arrangement.SpacedAligned m60spacedBy0680j_4 = Arrangement.m60spacedBy0680j_4(f2);
                startRestartGroup.startReplaceableGroup(-483455358);
                BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m60spacedBy0680j_4, horizontal, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                List<SleepEntry> list = entries;
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(layoutWeightElement);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    modifierMaterializerOf2.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    StringBuilder sb = new StringBuilder();
                    Instant start = session.getSleepTimePeriod().getStart();
                    TimeZone.Companion.getClass();
                    sb.append(TimeZoneKt.toLocalDateTime(start, TimeZone.Companion.currentSystemDefault()));
                    sb.append(" -> ");
                    sb.append(TimeZoneKt.toLocalDateTime(session.getSleepTimePeriod().getEnd(), TimeZone.Companion.currentSystemDefault()));
                    String sb2 = sb.toString();
                    Modifier.Companion companion2 = companion;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = TypographyKt.LocalTypography;
                    float f3 = f2;
                    BiasAlignment.Horizontal horizontal2 = horizontal;
                    Applier<?> applier2 = applier;
                    TextKt.m216Text4IGK_g(sb2, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).body1, startRestartGroup, 0, 0, 65534);
                    SleepHistoryEntry historyEntry = debugSleepSession.getHistoryEntry();
                    startRestartGroup.startReplaceableGroup(-73230251);
                    if (historyEntry != null) {
                        StringBuilder sb3 = new StringBuilder("Sleep Length: ");
                        int r4 = Duration.$r8$clinit;
                        sb3.append((Object) Duration.m1690toStringimpl(DurationKt.toDuration(historyEntry.getDeepSleepMs() + historyEntry.getLightSleepMs(), DurationUnit.MILLISECONDS)));
                        TextKt.m216Text4IGK_g(sb3.toString(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).body1, startRestartGroup, 0, 0, 65534);
                        Unit unit = Unit.INSTANCE;
                    }
                    boolean z2 = false;
                    startRestartGroup.end(false);
                    startRestartGroup.startReplaceableGroup(-379277522);
                    if (ListItem$lambda$4(mutableState)) {
                        TextKt.m216Text4IGK_g("State: " + session.getState(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).body1, startRestartGroup, 0, 0, 65534);
                        TextKt.m216Text4IGK_g(session.getSleepTimePeriod().getBedtime().toString(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).caption, startRestartGroup, 0, 0, 65534);
                        TextKt.m216Text4IGK_g("History: " + debugSleepSession.getHistoryEntry(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).caption, startRestartGroup, 0, 0, 65534);
                        for (SleepEntry sleepEntry : rawData) {
                            List<SleepEntry> list2 = list;
                            if (list2.contains(sleepEntry)) {
                                Color = ColorKt.Color(R.styleable.AppTheme_stepsHistoryFontActivity, 195, 74, 255);
                            } else {
                                Color = ColorKt.Color(244, 67, 54, 255);
                            }
                            Modifier.Companion companion3 = companion2;
                            fillMaxWidth2 = SizeKt.fillMaxWidth(BackgroundKt.m21backgroundbw27NRU(companion3, Color, RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f)), 1.0f);
                            float f4 = f3;
                            Modifier m71padding3ABfNKs2 = PaddingKt.m71padding3ABfNKs(fillMaxWidth2, f4);
                            startRestartGroup.startReplaceableGroup(-483455358);
                            BiasAlignment.Horizontal horizontal3 = horizontal2;
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal3, startRestartGroup);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                            PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
                            ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs2);
                            Applier<?> applier3 = applier2;
                            if (applier3 instanceof Applier) {
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.inserting) {
                                    startRestartGroup.createNode(layoutNode$Companion$Constructor$12);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                Updater.m228setimpl(startRestartGroup, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$12);
                                }
                                modifierMaterializerOf3.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                StringBuilder sb4 = new StringBuilder();
                                Instant.Companion companion4 = Instant.Companion;
                                long timestamp = sleepEntry.getTimestamp();
                                companion4.getClass();
                                Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(timestamp);
                                TimeZone.Companion.getClass();
                                sb4.append(TimeZoneKt.toLocalDateTime(fromEpochMilliseconds, TimeZone.Companion.currentSystemDefault()));
                                sb4.append(": ");
                                sb4.append(sleepEntry.getState());
                                TextKt.m216Text4IGK_g(sb4.toString(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 0, 0, 131070);
                                String mo1121getHistoryDeviceIdV9ZILtA = sleepEntry.mo1121getHistoryDeviceIdV9ZILtA();
                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                TextKt.m216Text4IGK_g(mo1121getHistoryDeviceIdV9ZILtA, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).caption, startRestartGroup, 0, 0, 65534);
                                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                                applier2 = applier3;
                                horizontal2 = horizontal3;
                                companion2 = companion3;
                                f3 = f4;
                                list = list2;
                            } else {
                                ComposablesKt.invalidApplier();
                                throw null;
                            }
                        }
                        z2 = false;
                    }
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, z2, z2, true, z2);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, z2, z2, true, z2);
                    startRestartGroup.end(z2);
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                    RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSleepFragment$ListItem$3
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
                                DebugSleepFragment.this.ListItem(debugSleepSession, composer2, Strings.updateChangedFlags(r87 | 1));
                            }
                        };
                        return;
                    }
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
            throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ListItem$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ListItem$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* renamed from: color-vNxB06k, reason: not valid java name */
    private final long m890colorvNxB06k(SleepSessionState sleepSessionState) {
        int r4 = WhenMappings.$EnumSwitchMapping$0[sleepSessionState.ordinal()];
        if (r4 != 1) {
            if (r4 != 2) {
                if (r4 == 3) {
                    return ColorKt.Color(27, 94, 32, 255);
                }
                throw new NoWhenBranchMatchedException();
            }
            return ColorKt.Color(230, 74, 25, 255);
        }
        return ColorKt.Color(183, 28, 28, 255);
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r6) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(2140596059);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        DataList(ComposeContent$lambda$0(Platform.collectAsState(this.fitnessProvider.debugSleepSession(), EmptyList.INSTANCE, Dispatchers.IO, startRestartGroup, 0)), startRestartGroup, 72);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSleepFragment$ComposeContent$1
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
                    DebugSleepFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r6 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(com.kronaby.watch.app.R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }
}
