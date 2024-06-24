package com.animaconnected.secondo.screens.debugsettings;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$Center$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
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
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amazonaws.http.HttpHeader;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.fitness.ActivityEntry;
import com.animaconnected.watch.fitness.DebugEntry;
import com.animaconnected.watch.fitness.DiagnosticsEntry;
import com.animaconnected.watch.fitness.Entry;
import com.animaconnected.watch.fitness.ExerciseEntry;
import com.animaconnected.watch.fitness.FitnessIndexEntry;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.HeartrateEntry;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.PowerEntry;
import com.animaconnected.watch.fitness.RestingHeartrateEntry;
import com.animaconnected.watch.fitness.SessionEntry;
import com.animaconnected.watch.fitness.SleepEntry;
import com.animaconnected.watch.fitness.SleepHistoryEntry;
import com.animaconnected.watch.fitness.SpeedCalibrationEntry;
import com.animaconnected.watch.fitness.StandEntry;
import com.animaconnected.watch.fitness.StressEntry;
import com.animaconnected.watch.fitness.SyncResult;
import com.animaconnected.watch.fitness.SyncState;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.WristEntry;
import com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: DebugFitnessDatabaseFragment.kt */
/* loaded from: classes3.dex */
public final class DebugFitnessDatabaseFragment extends ComposeFragment {
    public static final int $stable = 8;
    private final CommonFlow<SyncResult> fetchFitnessDataFlow;
    private final FitnessProvider fitnessProvider;
    private final Map<KClass<? extends Entry>, EntryTypeData> lookupMap;
    private final String name;
    private final SimpleDateFormat sdf;

    /* compiled from: DebugFitnessDatabaseFragment.kt */
    /* loaded from: classes3.dex */
    public static final class EntryTypeData {
        private final long color;
        private final String emoji;

        public /* synthetic */ EntryTypeData(long j, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str);
        }

        /* renamed from: copy-DxMtmZc$default, reason: not valid java name */
        public static /* synthetic */ EntryTypeData m882copyDxMtmZc$default(EntryTypeData entryTypeData, long j, String str, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                j = entryTypeData.color;
            }
            if ((r4 & 2) != 0) {
                str = entryTypeData.emoji;
            }
            return entryTypeData.m884copyDxMtmZc(j, str);
        }

        /* renamed from: component1-0d7_KjU, reason: not valid java name */
        public final long m883component10d7_KjU() {
            return this.color;
        }

        public final String component2() {
            return this.emoji;
        }

        /* renamed from: copy-DxMtmZc, reason: not valid java name */
        public final EntryTypeData m884copyDxMtmZc(long j, String emoji) {
            Intrinsics.checkNotNullParameter(emoji, "emoji");
            return new EntryTypeData(j, emoji, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EntryTypeData)) {
                return false;
            }
            EntryTypeData entryTypeData = (EntryTypeData) obj;
            if (Color.m317equalsimpl0(this.color, entryTypeData.color) && Intrinsics.areEqual(this.emoji, entryTypeData.emoji)) {
                return true;
            }
            return false;
        }

        /* renamed from: getColor-0d7_KjU, reason: not valid java name */
        public final long m885getColor0d7_KjU() {
            return this.color;
        }

        public final String getEmoji() {
            return this.emoji;
        }

        public int hashCode() {
            long j = this.color;
            int r2 = Color.$r8$clinit;
            return this.emoji.hashCode() + (Long.hashCode(j) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("EntryTypeData(color=");
            sb.append((Object) Color.m323toStringimpl(this.color));
            sb.append(", emoji=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.emoji, ')');
        }

        private EntryTypeData(long j, String emoji) {
            Intrinsics.checkNotNullParameter(emoji, "emoji");
            this.color = j;
            this.emoji = emoji;
        }
    }

    /* compiled from: DebugFitnessDatabaseFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[SyncState.values().length];
            try {
                r0[SyncState.Calculating.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SyncState.Fetching.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SyncState.Error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[SyncState.Done.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DebugFitnessDatabaseFragment() {
        FitnessProvider fitness = ProviderFactory.getWatch().fitness();
        this.fitnessProvider = fitness;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str = "🏅";
        String str2 = "🛌";
        this.lookupMap = MapsKt__MapsKt.mapOf(new Pair(Reflection.getOrCreateKotlinClass(ActivityEntry.class), new EntryTypeData(ColorKt.Color(255, R.styleable.AppTheme_themeBackgroundGradientBottom, R.styleable.AppTheme_themeBackgroundGradientBottom, 255), "🚶", defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(LocationEntry.class), new EntryTypeData(ColorKt.Color(188, 255, R.styleable.AppTheme_themeBackgroundGradientBottom, 255), "📍", defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(SessionEntry.class), new EntryTypeData(ColorKt.Color(R.styleable.AppTheme_themeBackgroundGradientBottom, 235, 255, 255), str, defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(SleepEntry.class), new EntryTypeData(ColorKt.Color(R.styleable.AppTheme_topPusherDropZoneSelected, R.styleable.AppTheme_themeBackgroundGradientBottom, 255, 255), str2, defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(SleepHistoryEntry.class), new EntryTypeData(ColorKt.Color(180, R.styleable.AppTheme_stepsHistoryFontDetail, 240, 255), str2, defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(HeartrateEntry.class), new EntryTypeData(ColorKt.Color(249, R.styleable.AppTheme_themeBackgroundGradientBottom, 255, 255), "💕", defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(FitnessIndexEntry.class), new EntryTypeData(ColorKt.Color(99, 255, 182, 255), str, defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(StandEntry.class), new EntryTypeData(ColorKt.Color(255, 99, R.styleable.AppTheme_stepsHistoryGoalLegendColorDetail, 255), "👣", defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(StressEntry.class), new EntryTypeData(ColorKt.Color(195, 99, 255, 255), "💓", defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(ExerciseEntry.class), new EntryTypeData(ColorKt.Color(255, 254, R.styleable.AppTheme_themeBackgroundGradientBottom, 255), "💪", defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(RestingHeartrateEntry.class), new EntryTypeData(ColorKt.Color(65, 204, 83, 255), "💕 🛌", defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(WristEntry.class), new EntryTypeData(ColorKt.Color(84, 241, 210, 255), "🤛", defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(DebugEntry.class), new EntryTypeData(ColorKt.Color(240, 188, 0, 255), "💬", defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(DiagnosticsEntry.class), new EntryTypeData(ColorKt.Color(R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, 162, 48, 255), "📜", defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(PowerEntry.class), new EntryTypeData(ColorKt.Color(106, 79, 202, 255), "🔋", defaultConstructorMarker)), new Pair(Reflection.getOrCreateKotlinClass(SpeedCalibrationEntry.class), new EntryTypeData(ColorKt.Color(180, 199, 126, 255), "🚄", defaultConstructorMarker)));
        this.fetchFitnessDataFlow = fitness.syncFitness();
        this.name = "DebugFitnessDatabase";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Entry> ComposeContent$lambda$0(State<? extends List<? extends Entry>> state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SyncResult ComposeContent$lambda$2(State<SyncResult> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void DataList(final List<? extends Entry> list, final List<? extends KClass<? extends Entry>> list2, Composer composer, final int r20) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(399873250);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        int size = list2.size();
        startRestartGroup.startReplaceableGroup(-1153181202);
        boolean changed = startRestartGroup.changed(size) | startRestartGroup.changed(list);
        Object nextSlot = startRestartGroup.nextSlot();
        if (changed || nextSlot == Composer.Companion.Empty) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (list2.contains(Reflection.getOrCreateKotlinClass(((Entry) obj).getClass()))) {
                    arrayList.add(obj);
                }
            }
            nextSlot = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$DataList$lambda$7$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return BorderStrokeKt.compareValues(Long.valueOf(((Entry) t2).getTimestamp()), Long.valueOf(((Entry) t).getTimestamp()));
                }
            });
            startRestartGroup.updateValue(nextSlot);
        }
        final List list3 = (List) nextSlot;
        startRestartGroup.end(false);
        float f = 16;
        LazyDslKt.LazyColumn(PaddingKt.m74paddingqDBjuR0(Modifier.Companion.$$INSTANCE, f, 0, f, f), null, null, false, Arrangement.m60spacedBy0680j_4(4), null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$DataList$1
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

            /* JADX WARN: Type inference failed for: r2v1, types: [com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$DataList$1$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final List<Entry> list4 = list3;
                final DebugFitnessDatabaseFragment debugFitnessDatabaseFragment = this;
                final DebugFitnessDatabaseFragment$DataList$1$invoke$$inlined$items$default$1 debugFitnessDatabaseFragment$DataList$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$DataList$1$invoke$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(Entry entry) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        return invoke((Entry) obj2);
                    }
                };
                LazyColumn.items(list4.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$DataList$1$invoke$$inlined$items$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int r3) {
                        return Function1.this.invoke(list4.get(r3));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$DataList$1$invoke$$inlined$items$default$4
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
                            debugFitnessDatabaseFragment.toListItem((Entry) list4.get(r3), composer2, 72);
                        }
                    }
                }, true));
            }
        }, startRestartGroup, 24576, 238);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$DataList$2
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
                    DebugFitnessDatabaseFragment.this.DataList(list, list2, composer2, Strings.updateChangedFlags(r20 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Filters(final List<KClass<? extends Entry>> list, Composer composer, final int r32) {
        float f;
        Modifier fillMaxWidth;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1639470193);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Iterator<T> it = this.lookupMap.keySet().iterator();
        while (it.hasNext()) {
            final KClass kClass = (KClass) it.next();
            EntryTypeData entryTypeData = this.lookupMap.get(kClass);
            if (entryTypeData != null) {
                if (list.contains(kClass)) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                float f2 = 8;
                fillMaxWidth = SizeKt.fillMaxWidth(BackgroundKt.m21backgroundbw27NRU(AlphaKt.alpha(companion, f), entryTypeData.m885getColor0d7_KjU(), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f2)), 1.0f);
                Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(ClickableKt.m26clickableXHw0xAI$default(fillMaxWidth, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$Filters$1$1
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
                        Map map;
                        Map map2;
                        int size = list.size();
                        map = this.lookupMap;
                        if (size == map.size()) {
                            list.clear();
                            list.add(kClass);
                            return;
                        }
                        if (list.size() == 1 && list.contains(kClass)) {
                            list.clear();
                            List<KClass<? extends Entry>> list2 = list;
                            map2 = this.lookupMap;
                            CollectionsKt__ReversedViewsKt.addAll(list2, map2.keySet().toArray(new KClass[0]));
                            return;
                        }
                        if (list.contains(kClass)) {
                            list.remove(kClass);
                        } else {
                            list.add(kClass);
                        }
                    }
                }), f2);
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
                String str = null;
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
                    boolean z = false;
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                    if (1.0f > 0.0d) {
                        z = true;
                    }
                    if (z) {
                        LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                        companion.then(layoutWeightElement);
                        StringBuilder sb = new StringBuilder();
                        sb.append(entryTypeData.getEmoji());
                        sb.append(' ');
                        String simpleName = kClass.getSimpleName();
                        if (simpleName != null) {
                            str = StringsKt__StringsJVMKt.replace$default(simpleName, "Entry", "");
                        }
                        sb.append(str);
                        String sb2 = sb.toString();
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        TextKt.m216Text4IGK_g(sb2, layoutWeightElement, Color.Black, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).caption, startRestartGroup, 384, 0, 65528);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    } else {
                        throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
                    }
                } else {
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$Filters$2
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
                    DebugFitnessDatabaseFragment.this.Filters(list, composer2, Strings.updateChangedFlags(r32 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ListItem-iJQMabo, reason: not valid java name */
    public final void m880ListItemiJQMabo(final Entry entry, final long j, final String str, Composer composer, final int r37) {
        Modifier fillMaxWidth;
        boolean z;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-819865115);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-2016338505);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.end(false);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        fillMaxWidth = SizeKt.fillMaxWidth(BackgroundKt.m21backgroundbw27NRU(companion, j, RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(8)), 1.0f);
        Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(fillMaxWidth, 4);
        startRestartGroup.startReplaceableGroup(-2016338190);
        Object nextSlot2 = startRestartGroup.nextSlot();
        if (nextSlot2 == composer$Companion$Empty$1) {
            nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$ListItem$1$1
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
                    boolean ListItem_iJQMabo$lambda$9;
                    MutableState<Boolean> mutableState2 = mutableState;
                    ListItem_iJQMabo$lambda$9 = DebugFitnessDatabaseFragment.ListItem_iJQMabo$lambda$9(mutableState2);
                    DebugFitnessDatabaseFragment.ListItem_iJQMabo$lambda$10(mutableState2, !ListItem_iJQMabo$lambda$9);
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
                startRestartGroup.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
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
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
                    TextStyle textStyle = ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).caption;
                    long j2 = Color.Black;
                    TextKt.m216Text4IGK_g(str, null, j2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, startRestartGroup, ((r37 >> 6) & 14) | 384, 0, 65530);
                    startRestartGroup.startReplaceableGroup(-978030129);
                    if (ListItem_iJQMabo$lambda$9(mutableState)) {
                        staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                        TextKt.m216Text4IGK_g(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(entry.toString(), "(", "\n"), ", ", "\n"), ")", ""), "=", ": "), null, j2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).caption, startRestartGroup, 384, 0, 65530);
                    } else {
                        staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                    }
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
                    startRestartGroup.end(false);
                    String format = this.sdf.format(new Date(entry.getTimestamp()));
                    TextStyle textStyle2 = ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).caption;
                    Intrinsics.checkNotNull(format);
                    TextKt.m216Text4IGK_g(format, null, j2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle2, startRestartGroup, 384, 0, 65530);
                    RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                    if (m != null) {
                        m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$ListItem$3
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
                                DebugFitnessDatabaseFragment.this.m880ListItemiJQMabo(entry, j, str, composer2, Strings.updateChangedFlags(r37 | 1));
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
    public static final void ListItem_iJQMabo$lambda$10(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ListItem_iJQMabo$lambda$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void SyncStatus(final SyncResult syncResult, Composer composer, final int r32) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(112380461);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (syncResult != null) {
            if (syncResult.getState() == SyncState.Done) {
                RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$SyncStatus$1$1
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
                            DebugFitnessDatabaseFragment.this.SyncStatus(syncResult, composer2, Strings.updateChangedFlags(r32 | 1));
                        }
                    };
                    return;
                }
                return;
            }
            Arrangement$Center$1 arrangement$Center$1 = Arrangement.Center;
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Center$1, horizontal, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
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
                boolean z = false;
                modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                float f = 16;
                Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(BackgroundKt.m21backgroundbw27NRU(companion, MaterialTheme.getColors(startRestartGroup).m164getBackground0d7_KjU(), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f)), f);
                Arrangement.SpacedAligned m60spacedBy0680j_4 = Arrangement.m60spacedBy0680j_4(4);
                startRestartGroup.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m60spacedBy0680j_4, Alignment.Companion.Start, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, columnMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    modifierMaterializerOf2.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    int r4 = WhenMappings.$EnumSwitchMapping$0[syncResult.getState().ordinal()];
                    if (r4 != 1) {
                        if (r4 != 2) {
                            if (r4 != 3) {
                                if (r4 != 4) {
                                    startRestartGroup.startReplaceableGroup(204278608);
                                    startRestartGroup.end(false);
                                } else {
                                    startRestartGroup.startReplaceableGroup(204278559);
                                    startRestartGroup.end(false);
                                }
                            } else {
                                startRestartGroup.startReplaceableGroup(204278200);
                                TextKt.m216Text4IGK_g("Error", null, MaterialTheme.getColors(startRestartGroup).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131066);
                                String error = syncResult.getError();
                                if (error == null) {
                                    error = "";
                                }
                                TextKt.m216Text4IGK_g(error, null, MaterialTheme.getColors(startRestartGroup).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 0, 0, 131066);
                                z = false;
                                startRestartGroup.end(false);
                            }
                        } else {
                            startRestartGroup.startReplaceableGroup(204277746);
                            TextKt.m216Text4IGK_g("Fetching", null, MaterialTheme.getColors(startRestartGroup).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131066);
                            ProgressIndicatorKt.m196LinearProgressIndicator_5eSRE(syncResult.getPercentage(), 0, 0, 18, MaterialTheme.getColors(startRestartGroup).m172getSecondary0d7_KjU(), MaterialTheme.getColors(startRestartGroup).m164getBackground0d7_KjU(), startRestartGroup, null);
                            z = false;
                            startRestartGroup.end(false);
                        }
                    } else {
                        startRestartGroup.startReplaceableGroup(204277574);
                        TextKt.m216Text4IGK_g("Calculating", null, MaterialTheme.getColors(startRestartGroup).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131066);
                        z = false;
                        startRestartGroup.end(false);
                    }
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, z, true, z, z);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, z, true, z, z);
                } else {
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$SyncStatus$2
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
                    DebugFitnessDatabaseFragment.this.SyncStatus(syncResult, composer2, Strings.updateChangedFlags(r32 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toListItem(final Entry entry, Composer composer, final int r11) {
        String obj;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1896237402);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (entry instanceof ActivityEntry) {
            StringBuilder sb = new StringBuilder("R: ");
            ActivityEntry activityEntry = (ActivityEntry) entry;
            sb.append(activityEntry.getRunSteps());
            sb.append(", W: ");
            sb.append(activityEntry.getWalkSteps());
            sb.append(", O: ");
            sb.append(activityEntry.getOtherSteps());
            obj = sb.toString();
        } else if (entry instanceof LocationEntry) {
            obj = HttpHeader.LOCATION;
        } else if (entry instanceof SessionEntry) {
            obj = ((SessionEntry) entry).getEvent().name();
        } else if (entry instanceof SleepEntry) {
            obj = ((SleepEntry) entry).getState().name();
        } else if (entry instanceof SleepHistoryEntry) {
            StringBuilder sb2 = new StringBuilder("D: ");
            int r1 = Duration.$r8$clinit;
            SleepHistoryEntry sleepHistoryEntry = (SleepHistoryEntry) entry;
            long deepSleepMs = sleepHistoryEntry.getDeepSleepMs();
            DurationUnit durationUnit = DurationUnit.MILLISECONDS;
            sb2.append(WorkoutFormatUtilsKt.m1573formatDurationLRDsOJo(DurationKt.toDuration(deepSleepMs, durationUnit)));
            sb2.append(", L: ");
            sb2.append(WorkoutFormatUtilsKt.m1573formatDurationLRDsOJo(DurationKt.toDuration(sleepHistoryEntry.getLightSleepMs(), durationUnit)));
            sb2.append(", T: ");
            sb2.append(WorkoutFormatUtilsKt.m1573formatDurationLRDsOJo(Duration.m1686plusLRDsOJo(DurationKt.toDuration(sleepHistoryEntry.getDeepSleepMs(), durationUnit), DurationKt.toDuration(sleepHistoryEntry.getLightSleepMs(), durationUnit))));
            obj = sb2.toString();
        } else if (entry instanceof HeartrateEntry) {
            obj = String.valueOf(((HeartrateEntry) entry).getHeartrate());
        } else if (entry instanceof StandEntry) {
            obj = String.valueOf(((StandEntry) entry).getSuccessfulStands());
        } else if (entry instanceof FitnessIndexEntry) {
            obj = String.valueOf(((FitnessIndexEntry) entry).getValue());
        } else if (entry instanceof StressEntry) {
            obj = String.valueOf(((StressEntry) entry).getStress());
        } else if (entry instanceof WristEntry) {
            obj = ((WristEntry) entry).getState().toString();
        } else if (entry instanceof ExerciseEntry) {
            obj = ((ExerciseEntry) entry).getActiveMinutes() + "min";
        } else if (entry instanceof RestingHeartrateEntry) {
            obj = String.valueOf(((RestingHeartrateEntry) entry).getRestingHeartrate());
        } else if (entry instanceof DebugEntry) {
            StringBuilder sb3 = new StringBuilder();
            DebugEntry debugEntry = (DebugEntry) entry;
            sb3.append(debugEntry.getType());
            sb3.append(": ");
            sb3.append(debugEntry.getValue());
            obj = sb3.toString();
        } else if (entry instanceof DiagnosticsEntry) {
            StringBuilder sb4 = new StringBuilder();
            DiagnosticsEntry diagnosticsEntry = (DiagnosticsEntry) entry;
            sb4.append(diagnosticsEntry.getKey());
            sb4.append(": ");
            sb4.append(diagnosticsEntry.getValue());
            obj = sb4.toString();
        } else if (entry instanceof PowerEntry) {
            obj = ((PowerEntry) entry).getState().toString();
        } else if (entry instanceof SpeedCalibrationEntry) {
            obj = String.valueOf(((SpeedCalibrationEntry) entry).getCoefficient());
        } else {
            obj = entry.toString();
        }
        EntryTypeData entryTypeData = this.lookupMap.get(Reflection.getOrCreateKotlinClass(entry.getClass()));
        if (entryTypeData == null) {
            entryTypeData = new EntryTypeData(ColorKt.Color(244, 67, 54, 255), "", null);
        }
        m880ListItemiJQMabo(entry, entryTypeData.m885getColor0d7_KjU(), entryTypeData.getEmoji() + ' ' + obj, startRestartGroup, DfuBaseService.ERROR_INVALID_RESPONSE);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$toListItem$1
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
                    DebugFitnessDatabaseFragment.this.toListItem(entry, composer2, Strings.updateChangedFlags(r11 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$ComposeContent$1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$ComposeContent$2, kotlin.jvm.internal.Lambda] */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r26) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-216121765);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        CommonFlow<List<Entry>> data = this.fitnessProvider.getData(TimePeriod.Companion.none());
        EmptyList emptyList = EmptyList.INSTANCE;
        DefaultIoScheduler defaultIoScheduler = Dispatchers.IO;
        final MutableState collectAsState = Platform.collectAsState(data, emptyList, defaultIoScheduler, startRestartGroup, 0);
        final ModalBottomSheetState rememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, true, startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(773894976);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) nextSlot).coroutineScope;
        Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 1224381664);
        if (m == composer$Companion$Empty$1) {
            KClass[] kClassArr = (KClass[]) this.lookupMap.keySet().toArray(new KClass[0]);
            m = Platform.mutableStateListOf(Arrays.copyOf(kClassArr, kClassArr.length));
            startRestartGroup.updateValue(m);
        }
        final SnapshotStateList snapshotStateList = (SnapshotStateList) m;
        startRestartGroup.end(false);
        final MutableState collectAsState2 = Platform.collectAsState(this.fetchFitnessDataFlow, null, defaultIoScheduler, startRestartGroup, 0);
        long j = Color.Transparent;
        ModalBottomSheetKt.m191ModalBottomSheetLayoutGs3lGvM(ComposableLambdaKt.composableLambda(startRestartGroup, 229831945, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$ComposeContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope ModalBottomSheetLayout, Composer composer2, int r9) {
                Intrinsics.checkNotNullParameter(ModalBottomSheetLayout, "$this$ModalBottomSheetLayout");
                if ((r9 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Arrangement.SpacedAligned m60spacedBy0680j_4 = Arrangement.m60spacedBy0680j_4(4);
                Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(Modifier.Companion.$$INSTANCE, 16);
                DebugFitnessDatabaseFragment debugFitnessDatabaseFragment = DebugFitnessDatabaseFragment.this;
                SnapshotStateList<KClass<? extends Entry>> snapshotStateList2 = snapshotStateList;
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m60spacedBy0680j_4, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
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
                    debugFitnessDatabaseFragment.Filters(snapshotStateList2, composer2, 70);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), null, rememberModalBottomSheetState, false, null, 0.0f, Color.Black, 0L, j, ComposableLambdaKt.composableLambda(startRestartGroup, 1340806466, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$ComposeContent$2
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

            public final void invoke(Composer composer2, int r37) {
                ColorFilter porterDuffColorFilter;
                List ComposeContent$lambda$0;
                SyncResult ComposeContent$lambda$2;
                if ((r37 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                final CoroutineScope coroutineScope2 = CoroutineScope.this;
                final ModalBottomSheetState modalBottomSheetState = rememberModalBottomSheetState;
                DebugFitnessDatabaseFragment debugFitnessDatabaseFragment = this;
                SnapshotStateList<KClass<? extends Entry>> snapshotStateList2 = snapshotStateList;
                State<List<Entry>> state = collectAsState;
                State<SyncResult> state2 = collectAsState2;
                composer2.startReplaceableGroup(-483455358);
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
                if (composer2.getApplier() instanceof Applier) {
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        composer2.useNode();
                    }
                    ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Updater.m228setimpl(composer2, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Updater.m228setimpl(composer2, currentCompositionLocalMap, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer2), composer2, 2058660585);
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier m26clickableXHw0xAI$default = ClickableKt.m26clickableXHw0xAI$default(companion, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$ComposeContent$2$1$1

                        /* compiled from: DebugFitnessDatabaseFragment.kt */
                        @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$ComposeContent$2$1$1$1", f = "DebugFitnessDatabaseFragment.kt", l = {91, 91}, m = "invokeSuspend")
                        /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$ComposeContent$2$1$1$1, reason: invalid class name */
                        /* loaded from: classes3.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ ModalBottomSheetState $sheetState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$sheetState = modalBottomSheetState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$sheetState, continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                boolean z;
                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                int r1 = this.label;
                                if (r1 != 0) {
                                    if (r1 != 1 && r1 != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                    if (this.$sheetState.anchoredDraggableState.getCurrentValue() != ModalBottomSheetValue.Hidden) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                        this.label = 1;
                                        if (modalBottomSheetState.hide(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    } else {
                                        ModalBottomSheetState modalBottomSheetState2 = this.$sheetState;
                                        this.label = 2;
                                        if (modalBottomSheetState2.show(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }
                        }

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
                            BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(modalBottomSheetState, null), 3);
                        }
                    });
                    composer2.startReplaceableGroup(693286680);
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, composer2);
                    composer2.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                    PersistentCompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m26clickableXHw0xAI$default);
                    if (composer2.getApplier() instanceof Applier) {
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            composer2.useNode();
                        }
                        Updater.m228setimpl(composer2, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(composer2, currentCompositionLocalMap2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer2, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf2, new SkippableUpdater(composer2), composer2, 2058660585);
                        Painter painterResource = PainterResources_androidKt.painterResource(com.kronaby.watch.app.R.drawable.ic_settings, composer2);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                        long m166getOnBackground0d7_KjU = ((Colors) composer2.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
                        if (Build.VERSION.SDK_INT >= 29) {
                            porterDuffColorFilter = BlendModeColorFilterHelper.INSTANCE.m309BlendModeColorFilterxETnrds(m166getOnBackground0d7_KjU, 5);
                        } else {
                            porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m327toArgb8_81llA(m166getOnBackground0d7_KjU), AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(5));
                        }
                        ImageKt.Image(painterResource, "Filter", PaddingKt.m71padding3ABfNKs(companion, 8), null, null, 0.0f, new androidx.compose.ui.graphics.ColorFilter(porterDuffColorFilter), composer2, 440, 56);
                        TextKt.m216Text4IGK_g("Filter", null, ((Colors) composer2.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer2.consume(TypographyKt.LocalTypography)).body1, composer2, 6, 0, 65530);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.TopStart, false, composer2);
                        composer2.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                        PersistentCompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion);
                        if (composer2.getApplier() instanceof Applier) {
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                composer2.useNode();
                            }
                            Updater.m228setimpl(composer2, rememberBoxMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                            Updater.m228setimpl(composer2, currentCompositionLocalMap3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, composer2, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                            }
                            modifierMaterializerOf3.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposeContent$lambda$0 = DebugFitnessDatabaseFragment.ComposeContent$lambda$0(state);
                            debugFitnessDatabaseFragment.DataList(ComposeContent$lambda$0, snapshotStateList2, composer2, 568);
                            ComposeContent$lambda$2 = DebugFitnessDatabaseFragment.ComposeContent$lambda$2(state2);
                            debugFitnessDatabaseFragment.SyncStatus(ComposeContent$lambda$2, composer2, 72);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
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
                    ComposablesKt.invalidApplier();
                    throw null;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, 907543046, 186);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessDatabaseFragment$ComposeContent$3
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
                    DebugFitnessDatabaseFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r26 | 1));
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
