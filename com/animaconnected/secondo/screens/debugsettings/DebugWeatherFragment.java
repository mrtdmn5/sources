package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$Center$1;
import androidx.compose.foundation.layout.Arrangement$Start$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.dfu.dfu.utils.DfuConstants;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.location.AndroidLocationBackend;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.watch.behaviour.temperature.Current;
import com.animaconnected.watch.behaviour.temperature.Daily;
import com.animaconnected.watch.behaviour.temperature.Hourly;
import com.animaconnected.watch.display.AndroidGraphicsKt;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.LocationUtilsKt;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.location.Spot;
import com.animaconnected.watch.provider.weather.DailyForecast;
import com.animaconnected.watch.provider.weather.HistoricalWeatherProvider;
import com.animaconnected.watch.provider.weather.HourlyForecast;
import com.animaconnected.watch.provider.weather.TodayForecast;
import com.animaconnected.watch.provider.weather.WeatherForecastWatch;
import com.animaconnected.watch.provider.weather.WeatherViewModel;
import com.google.common.base.Strings;
import com.google.common.collect.Hashing;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: DebugWeatherFragment.kt */
/* loaded from: classes3.dex */
public final class DebugWeatherFragment extends ComposeFragment {
    private final String name = "DebugWeatherFragment";
    private final HistoricalWeatherProvider provider = ProviderFactory.getWeatherProvider();
    private final WeatherViewModel viewModel = ProviderFactory.createWeatherViewModel();
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DebugWeatherFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugWeatherFragment newInstance() {
            return new DebugWeatherFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void CurrentWatchWeather(final TodayForecast todayForecast, Composer composer, final int r22) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(2012761100);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            Modifier m85heightInVpY3zN4$default = SizeKt.m85heightInVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 24, 0.0f, 2);
            startRestartGroup.startReplaceableGroup(693286680);
            Arrangement$Start$1 arrangement$Start$1 = Arrangement.Start;
            BiasAlignment.Vertical vertical = Alignment.Companion.Top;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$Start$1, vertical, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m85heightInVpY3zN4$default);
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
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                WeatherText(todayForecast.getMaxTemp(), rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 0);
                WeatherText(todayForecast.getRain(), rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 0);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$Start$1, vertical, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rowMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    modifierMaterializerOf3.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    WeatherText(todayForecast.getMinTemp(), rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 0);
                    WeatherText(todayForecast.getUv(), rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 0);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                    if (m != null) {
                        m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$CurrentWatchWeather$2
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
                                DebugWeatherFragment.this.CurrentWatchWeather(todayForecast, composer2, Strings.updateChangedFlags(r22 | 1));
                            }
                        };
                        return;
                    }
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void DailyWatchWeather(final List<DailyForecast> list, Composer composer, final int r21) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1570315934);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        int r9 = -1323940314;
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
        Applier<?> applier = startRestartGroup.applier;
        if (applier instanceof Applier) {
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
            int r13 = 2058660585;
            AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 1059697851);
            for (DailyForecast dailyForecast : list) {
                Modifier m85heightInVpY3zN4$default = SizeKt.m85heightInVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 24, 0.0f, 2);
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, startRestartGroup);
                startRestartGroup.startReplaceableGroup(r9);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m85heightInVpY3zN4$default);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$12);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$12);
                    }
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, r13);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    WeatherText(dailyForecast.getDate(), rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 0);
                    WeatherText(dailyForecast.getTemp(), rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 0);
                    if (Intrinsics.areEqual(dailyForecast.getIcon(), GraphicsKt.emptyMitmap())) {
                        startRestartGroup.startReplaceableGroup(23134496);
                        WeatherText("-", rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, 518, 0);
                        startRestartGroup.end(false);
                    } else {
                        startRestartGroup.startReplaceableGroup(23134579);
                        WeatherIcon(dailyForecast.getIcon(), rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, DfuConstants.UNKNOWN_DFU_15_ERROR, 0);
                        startRestartGroup.end(false);
                    }
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    r9 = -1323940314;
                    r13 = 2058660585;
                } else {
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }
            AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
            startRestartGroup.end(false);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$DailyWatchWeather$2
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
                        DebugWeatherFragment.this.DailyWatchWeather(list, composer2, Strings.updateChangedFlags(r21 | 1));
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
    /* JADX WARN: Type inference failed for: r4v7, types: [com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$Expandable$2, kotlin.jvm.internal.Lambda] */
    public final void Expandable(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int r12) {
        int r0;
        int r1;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1080373717);
        if ((r12 & 14) == 0) {
            if (startRestartGroup.changed(str)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r12;
        } else {
            r0 = r12;
        }
        if ((r12 & 112) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
                r1 = 32;
            } else {
                r1 = 16;
            }
            r0 |= r1;
        }
        if ((r0 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], null, new Function0<MutableState<Boolean>>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$Expandable$isExpanded$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MutableState<Boolean> invoke() {
                    return Platform.mutableStateOf$default(Boolean.FALSE);
                }
            }, startRestartGroup, 6);
            Modifier m82defaultMinSizeVpY3zN4$default = SizeKt.m82defaultMinSizeVpY3zN4$default(PaddingKt.m73paddingVpY3zN4$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 0.0f, 16, 1), 48, 1);
            startRestartGroup.startReplaceableGroup(1131790639);
            boolean changed = startRestartGroup.changed(mutableState);
            Object nextSlot = startRestartGroup.nextSlot();
            if (changed || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$Expandable$1$1
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
                        boolean Expandable$lambda$10;
                        MutableState<Boolean> mutableState2 = mutableState;
                        Expandable$lambda$10 = DebugWeatherFragment.Expandable$lambda$10(mutableState2);
                        DebugWeatherFragment.Expandable$lambda$11(mutableState2, !Expandable$lambda$10);
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            CardKt.m162CardFjzlyU(ClickableKt.m26clickableXHw0xAI$default(m82defaultMinSizeVpY3zN4$default, (Function0) nextSlot), null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -132804466, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$Expandable$2
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

                /* JADX WARN: Type inference failed for: r1v3, types: [com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$Expandable$2$1$1, kotlin.jvm.internal.Lambda] */
                public final void invoke(Composer composer2, int r31) {
                    boolean Expandable$lambda$10;
                    if ((r31 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    Arrangement$Center$1 arrangement$Center$1 = Arrangement.Center;
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    float f = 4;
                    Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(companion, f);
                    String str2 = str;
                    MutableState<Boolean> mutableState2 = mutableState;
                    final Function2<Composer, Integer, Unit> function22 = function2;
                    composer2.startReplaceableGroup(-483455358);
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Center$1, Alignment.Companion.Start, composer2);
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
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        TextKt.m216Text4IGK_g(str2, PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, f, 7), ((Colors) composer2.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer2.consume(TypographyKt.LocalTypography)).h1, composer2, 48, 0, 65528);
                        Expandable$lambda$10 = DebugWeatherFragment.Expandable$lambda$10(mutableState2);
                        AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, Expandable$lambda$10, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer2, 132763228, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$Expandable$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                invoke(animatedVisibilityScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int r3) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                                function22.invoke(composer3, 0);
                            }
                        }), composer2, 1572870, 30);
                        DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                        return;
                    }
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }), startRestartGroup, 1572864, 62);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$Expandable$3
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
                    DebugWeatherFragment.this.Expandable(str, function2, composer2, Strings.updateChangedFlags(r12 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Expandable$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Expandable$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void HourlyWatchWeather(final List<HourlyForecast> list, Composer composer, final int r21) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1189771350);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        int r9 = -1323940314;
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
        Applier<?> applier = startRestartGroup.applier;
        if (applier instanceof Applier) {
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
            int r13 = 2058660585;
            AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 904277194);
            for (HourlyForecast hourlyForecast : list) {
                Modifier m85heightInVpY3zN4$default = SizeKt.m85heightInVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 24, 0.0f, 2);
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, startRestartGroup);
                startRestartGroup.startReplaceableGroup(r9);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m85heightInVpY3zN4$default);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$12);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$12);
                    }
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, r13);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    WeatherText(hourlyForecast.getTime(), rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 0);
                    WeatherText(hourlyForecast.getTemp(), rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 0);
                    if (Intrinsics.areEqual(hourlyForecast.getIcon(), GraphicsKt.emptyMitmap())) {
                        startRestartGroup.startReplaceableGroup(1445789747);
                        WeatherText("-", rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, 518, 0);
                        startRestartGroup.end(false);
                    } else {
                        startRestartGroup.startReplaceableGroup(1445789830);
                        WeatherIcon(hourlyForecast.getIcon(), rowScopeInstance.weight(companion, 1.0f, true), startRestartGroup, DfuConstants.UNKNOWN_DFU_15_ERROR, 0);
                        startRestartGroup.end(false);
                    }
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    r9 = -1323940314;
                    r13 = 2058660585;
                } else {
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }
            AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
            startRestartGroup.end(false);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$HourlyWatchWeather$2
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
                        DebugWeatherFragment.this.HourlyWatchWeather(list, composer2, Strings.updateChangedFlags(r21 | 1));
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
    public final void JsonText(final String str, Composer composer, final int r29) {
        int r21;
        ComposerImpl composerImpl;
        int r1;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1006490046);
        if ((r29 & 14) == 0) {
            if (startRestartGroup.changed(str)) {
                r1 = 4;
            } else {
                r1 = 2;
            }
            r21 = r1 | r29;
        } else {
            r21 = r29;
        }
        if ((r21 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            composerImpl = startRestartGroup;
            TextKt.m216Text4IGK_g(str, null, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).body1, startRestartGroup, r21 & 14, 0, 65530);
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$JsonText$1
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
                    DebugWeatherFragment.this.JsonText(str, composer2, Strings.updateChangedFlags(r29 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void WeatherIcon(final Mitmap mitmap, Modifier modifier, Composer composer, final int r12, final int r13) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-214122722);
        if ((r13 & 2) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ImageKt.m28Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(AndroidGraphicsKt.toBitmap$default(mitmap, null, 1, null)), "weather icon", SizeKt.m91size3ABfNKs(modifier, 24), ContentScale.Companion.Inside, startRestartGroup, 24632, 232);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$WeatherIcon$1
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
                    DebugWeatherFragment.this.WeatherIcon(mitmap, modifier2, composer2, Strings.updateChangedFlags(r12 | 1), r13);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void WeatherText(final java.lang.String r28, androidx.compose.ui.Modifier r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            r27 = this;
            r0 = -1227798875(0xffffffffb6d146a5, float:-6.2369095E-6)
            r1 = r30
            androidx.compose.runtime.ComposerImpl r0 = r1.startRestartGroup(r0)
            r1 = r32 & 1
            if (r1 == 0) goto L12
            r1 = r31 | 6
            r2 = r28
            goto L26
        L12:
            r1 = r31 & 14
            r2 = r28
            if (r1 != 0) goto L24
            boolean r1 = r0.changed(r2)
            if (r1 == 0) goto L20
            r1 = 4
            goto L21
        L20:
            r1 = 2
        L21:
            r1 = r31 | r1
            goto L26
        L24:
            r1 = r31
        L26:
            r3 = r32 & 2
            if (r3 == 0) goto L2d
            r1 = r1 | 48
            goto L40
        L2d:
            r4 = r31 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L40
            r4 = r29
            boolean r5 = r0.changed(r4)
            if (r5 == 0) goto L3c
            r5 = 32
            goto L3e
        L3c:
            r5 = 16
        L3e:
            r1 = r1 | r5
            goto L42
        L40:
            r4 = r29
        L42:
            r5 = r1 & 91
            r6 = 18
            if (r5 != r6) goto L54
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L4f
            goto L54
        L4f:
            r0.skipToGroupEnd()
            r3 = r4
            goto La2
        L54:
            if (r3 == 0) goto L5b
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion.$$INSTANCE
            r26 = r3
            goto L5d
        L5b:
            r26 = r4
        L5d:
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r3 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            androidx.compose.runtime.StaticProvidableCompositionLocal r3 = androidx.compose.material.ColorsKt.LocalColors
            java.lang.Object r3 = r0.consume(r3)
            androidx.compose.material.Colors r3 = (androidx.compose.material.Colors) r3
            long r3 = r3.m169getOnSurface0d7_KjU()
            androidx.compose.runtime.StaticProvidableCompositionLocal r5 = androidx.compose.material.TypographyKt.LocalTypography
            java.lang.Object r5 = r0.consume(r5)
            androidx.compose.material.Typography r5 = (androidx.compose.material.Typography) r5
            androidx.compose.ui.text.TextStyle r5 = r5.body1
            r21 = r5
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = r1 & 14
            r1 = r1 & 112(0x70, float:1.57E-43)
            r23 = r22 | r1
            r24 = 0
            r25 = 65528(0xfff8, float:9.1824E-41)
            r1 = r28
            r2 = r26
            r22 = r0
            androidx.compose.material.TextKt.m216Text4IGK_g(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r3 = r26
        La2:
            androidx.compose.runtime.RecomposeScopeImpl r6 = r0.endRestartGroup()
            if (r6 == 0) goto Lb8
            com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$WeatherText$1 r7 = new com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$WeatherText$1
            r0 = r7
            r1 = r27
            r2 = r28
            r4 = r31
            r5 = r32
            r0.<init>()
            r6.block = r7
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment.WeatherText(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$3, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$4, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$5, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r0v19, types: [com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$6, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$1, kotlin.jvm.internal.Lambda] */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r12) {
        LocationEntry locationEntry;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-433788805);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ScrollState rememberScrollState = ScrollKt.rememberScrollState(startRestartGroup);
        final WeatherForecastWatch watchData = this.viewModel.getWatchData();
        Modifier m73paddingVpY3zN4$default = PaddingKt.m73paddingVpY3zN4$default(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion.$$INSTANCE), rememberScrollState, false, 14), 8, 0.0f, 2);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m73paddingVpY3zN4$default);
        String str = null;
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
            WeatherText("Time since last fetch: " + Duration.m1690toStringimpl(this.provider.m1568getTimeSinceLastFetchUwyO8pc()) + " ago", null, startRestartGroup, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 2);
            StringBuilder sb = new StringBuilder("City: ");
            Spot location = this.provider.getLocation();
            if (location != null && (locationEntry = LocationUtilsKt.toLocationEntry(location)) != null) {
                str = AndroidLocationBackend.INSTANCE.getCityName(locationEntry);
            }
            sb.append(str);
            WeatherText(sb.toString(), null, startRestartGroup, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 2);
            Expandable("Current", ComposableLambdaKt.composableLambda(startRestartGroup, -273830925, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$1
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
                    if ((r4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        DebugWeatherFragment.this.CurrentWatchWeather(watchData.getToday(), composer2, 72);
                    }
                }
            }), startRestartGroup, 566);
            Expandable("Hourly", ComposableLambdaKt.composableLambda(startRestartGroup, -999313366, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$2
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
                    if ((r4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        DebugWeatherFragment.this.HourlyWatchWeather(watchData.getHourly(), composer2, 72);
                    }
                }
            }), startRestartGroup, 566);
            Expandable("Daily", ComposableLambdaKt.composableLambda(startRestartGroup, 1599630571, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$3
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
                    if ((r4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        DebugWeatherFragment.this.DailyWatchWeather(watchData.getDaily(), composer2, 72);
                    }
                }
            }), startRestartGroup, 566);
            Expandable("Current (last fetched json)", ComposableLambdaKt.composableLambda(startRestartGroup, -96392788, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r5) {
                    HistoricalWeatherProvider historicalWeatherProvider;
                    if ((r5 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    DebugWeatherFragment debugWeatherFragment = DebugWeatherFragment.this;
                    HistoricalWeatherProvider.Companion companion = HistoricalWeatherProvider.Companion;
                    historicalWeatherProvider = debugWeatherFragment.provider;
                    Current current = historicalWeatherProvider.getCurrent();
                    Json json = companion.getJson();
                    json.getClass();
                    debugWeatherFragment.JsonText(json.encodeToString(BuiltinSerializersKt.getNullable(Current.Companion.serializer()), current), composer2, 64);
                }
            }), startRestartGroup, 566);
            Expandable("Hourly (last fetched json)", ComposableLambdaKt.composableLambda(startRestartGroup, -1792416147, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$5
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r6) {
                    HistoricalWeatherProvider historicalWeatherProvider;
                    if ((r6 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    DebugWeatherFragment debugWeatherFragment = DebugWeatherFragment.this;
                    HistoricalWeatherProvider.Companion companion = HistoricalWeatherProvider.Companion;
                    historicalWeatherProvider = debugWeatherFragment.provider;
                    List<Hourly> hourly = historicalWeatherProvider.getHourly();
                    Json json = companion.getJson();
                    json.getClass();
                    debugWeatherFragment.JsonText(json.encodeToString(new ArrayListSerializer(Hourly.Companion.serializer()), hourly), composer2, 64);
                }
            }), startRestartGroup, 566);
            Expandable("Daily (last fetched json)", ComposableLambdaKt.composableLambda(startRestartGroup, 806527790, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$1$6
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r6) {
                    HistoricalWeatherProvider historicalWeatherProvider;
                    if ((r6 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    DebugWeatherFragment debugWeatherFragment = DebugWeatherFragment.this;
                    HistoricalWeatherProvider.Companion companion = HistoricalWeatherProvider.Companion;
                    historicalWeatherProvider = debugWeatherFragment.provider;
                    List<Daily> daily = historicalWeatherProvider.getDaily();
                    Json json = companion.getJson();
                    json.getClass();
                    debugWeatherFragment.JsonText(json.encodeToString(new ArrayListSerializer(Daily.Companion.serializer()), daily), composer2, 64);
                }
            }), startRestartGroup, 566);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWeatherFragment$ComposeContent$2
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
                        DebugWeatherFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r12 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugWeatherFragment$onStart$1(this, null), 3);
    }
}
