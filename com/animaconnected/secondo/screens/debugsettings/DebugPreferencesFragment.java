package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceEvenly$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.RadioButtonKt;
import androidx.compose.material.SliderKt;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.settings.configuration.WorkoutTypeSelection;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.provider.preferences.ColorTheme;
import com.animaconnected.watch.provider.preferences.GPSPreferences;
import com.animaconnected.watch.provider.preferences.Preferences;
import com.animaconnected.widget.ButtonOutlinedKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatRange;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: DebugPreferencesFragment.kt */
/* loaded from: classes3.dex */
public final class DebugPreferencesFragment extends ComposeFragment {
    public static final int $stable = 8;
    private final Preferences preferences = ProviderFactory.getWatch().getWatchManager().getPreferences();
    private final String name = "DebugFitnessDatabase";

    public final void ColorThemeRow(final ColorTheme theme, final ColorTheme currentTheme, Composer composer, final int r33) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(currentTheme, "currentTheme");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1620154450);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier m73paddingVpY3zN4$default = PaddingKt.m73paddingVpY3zN4$default(Modifier.Companion.$$INSTANCE, 16, 0.0f, 2);
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m73paddingVpY3zN4$default);
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
            boolean z = true;
            if (currentTheme != theme) {
                z = false;
            }
            RadioButtonKt.RadioButton(z, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$ColorThemeRow$1$1
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
                    Preferences preferences;
                    preferences = DebugPreferencesFragment.this.preferences;
                    preferences.setColorTheme(theme);
                }
            }, null, false, null, null, startRestartGroup, 0, 60);
            TextKt.m216Text4IGK_g(theme.name() + " theme", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 0, 0, 131070);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$ColorThemeRow$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r5) {
                        DebugPreferencesFragment.this.ColorThemeRow(theme, currentTheme, composer2, Strings.updateChangedFlags(r33 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r112) {
        boolean z;
        float f;
        Modifier.Companion companion;
        ComposerImpl composerImpl;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1757378427);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
        float f2 = 24;
        Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion2, f2, 0.0f, f2, 0.0f, 10);
        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
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
            MutableState collectAsState = Platform.collectAsState(this.preferences.getBrightnessFlow(), 255, null, startRestartGroup, 2);
            TextKt.m216Text4IGK_g("Brightness: " + ((Number) collectAsState.getValue()).intValue(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 0, 0, 131070);
            SliderKt.Slider((float) ((Number) collectAsState.getValue()).intValue(), new Function1<Float, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$ComposeContent$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f3) {
                    invoke(f3.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f3) {
                    Preferences preferences;
                    preferences = DebugPreferencesFragment.this.preferences;
                    preferences.setBrightness((int) f3);
                }
            }, null, false, new ClosedFloatRange(50.0f, 255.0f), 0, null, null, null, startRestartGroup, 0, 492);
            float f3 = (float) 16;
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion2, f3), startRestartGroup, 6);
            CommonFlow<ColorTheme> colorThemeFlow = this.preferences.getColorThemeFlow();
            ColorTheme colorTheme = ColorTheme.Sku;
            MutableState collectAsState2 = Platform.collectAsState(colorThemeFlow, colorTheme, null, startRestartGroup, 2);
            ColorThemeRow(colorTheme, (ColorTheme) collectAsState2.getValue(), startRestartGroup, 518);
            ColorThemeRow(ColorTheme.Default, (ColorTheme) collectAsState2.getValue(), startRestartGroup, 518);
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion2, f3), startRestartGroup, 6);
            TextKt.m216Text4IGK_g("Quick action first show: " + ((Boolean) Platform.collectAsState(this.preferences.getQuickActionFirstShownFlow(), Boolean.FALSE, null, startRestartGroup, 2).getValue()).booleanValue(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 0, 0, 131070);
            TextKt.m216Text4IGK_g("Assigned QuickAction: " + ((AppId) Platform.collectAsState(this.preferences.getQuickActionFlow(), AppId.Unknown, null, startRestartGroup, 2).getValue()).name(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 0, 0, 131070);
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion2, f3), startRestartGroup, 6);
            TextKt.m216Text4IGK_g("Speed calibration coefficient: " + ((Number) Platform.collectAsState(this.preferences.getSpeedCalibrationCoefficient(), 0, null, startRestartGroup, 2).getValue()).intValue(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 0, 0, 131070);
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion2, f3), startRestartGroup, 6);
            MutableState collectAsState3 = Platform.collectAsState(this.preferences.getSessionTypeGPSPreferencesFlow(), EmptyMap.INSTANCE, null, startRestartGroup, 2);
            startRestartGroup.startReplaceableGroup(1545922072);
            boolean z2 = true;
            if (!((Map) collectAsState3.getValue()).isEmpty()) {
                final LinkedHashMap mutableMap = MapsKt__MapsKt.toMutableMap((Map) collectAsState3.getValue());
                Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion2, 1.0f);
                Arrangement$SpaceEvenly$1 arrangement$SpaceEvenly$1 = Arrangement.SpaceEvenly;
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceEvenly$1, Alignment.Companion.Top, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth);
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
                    TextKt.m216Text4IGK_g("Type", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131070);
                    TextKt.m216Text4IGK_g("Unknown", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131070);
                    TextKt.m216Text4IGK_g("Yes", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131070);
                    TextKt.m216Text4IGK_g("No", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131070);
                    z2 = true;
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    f = f3;
                    z = false;
                    companion = companion2;
                    composerImpl = startRestartGroup;
                    GpsPreferences("Run", (GPSPreferences) mutableMap.get(SessionType.Running), new Function1<GPSPreferences, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$ComposeContent$1$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GPSPreferences gPSPreferences) {
                            invoke2(gPSPreferences);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GPSPreferences it) {
                            Preferences preferences;
                            Intrinsics.checkNotNullParameter(it, "it");
                            mutableMap.put(SessionType.Running, it);
                            preferences = this.preferences;
                            preferences.setSessionTypeGPSPreferences(MapsKt__MapsKt.toMap(mutableMap));
                        }
                    }, startRestartGroup, DfuBaseService.ERROR_SERVICE_NOT_FOUND);
                    GpsPreferences("Walk", (GPSPreferences) mutableMap.get(SessionType.Walking), new Function1<GPSPreferences, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$ComposeContent$1$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GPSPreferences gPSPreferences) {
                            invoke2(gPSPreferences);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GPSPreferences it) {
                            Preferences preferences;
                            Intrinsics.checkNotNullParameter(it, "it");
                            mutableMap.put(SessionType.Walking, it);
                            preferences = this.preferences;
                            preferences.setSessionTypeGPSPreferences(MapsKt__MapsKt.toMap(mutableMap));
                        }
                    }, composerImpl, DfuBaseService.ERROR_SERVICE_NOT_FOUND);
                    GpsPreferences("Bike", (GPSPreferences) mutableMap.get(SessionType.Bike), new Function1<GPSPreferences, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$ComposeContent$1$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GPSPreferences gPSPreferences) {
                            invoke2(gPSPreferences);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GPSPreferences it) {
                            Preferences preferences;
                            Intrinsics.checkNotNullParameter(it, "it");
                            mutableMap.put(SessionType.Bike, it);
                            preferences = this.preferences;
                            preferences.setSessionTypeGPSPreferences(MapsKt__MapsKt.toMap(mutableMap));
                        }
                    }, composerImpl, DfuBaseService.ERROR_SERVICE_NOT_FOUND);
                    GpsPreferences("Other", (GPSPreferences) mutableMap.get(SessionType.Other), new Function1<GPSPreferences, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$ComposeContent$1$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GPSPreferences gPSPreferences) {
                            invoke2(gPSPreferences);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GPSPreferences it) {
                            Preferences preferences;
                            Intrinsics.checkNotNullParameter(it, "it");
                            mutableMap.put(SessionType.Other, it);
                            preferences = this.preferences;
                            preferences.setSessionTypeGPSPreferences(MapsKt__MapsKt.toMap(mutableMap));
                        }
                    }, composerImpl, DfuBaseService.ERROR_SERVICE_NOT_FOUND);
                } else {
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            } else {
                z = false;
                f = f3;
                companion = companion2;
                composerImpl = startRestartGroup;
            }
            composerImpl.end(z);
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, f), composerImpl, 6);
            ButtonOutlinedKt.ButtonOutlined(null, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$ComposeContent$1$7
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
                    DebugPreferencesFragment.this.getMainController().gotoNextFragment(WorkoutTypeSelection.Companion.newInstance());
                }
            }, false, false, ComposableSingletons$DebugPreferencesFragmentKt.INSTANCE.m857getLambda1$secondo_kronabyRelease(), composerImpl, 24576, 13);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(composerImpl, z, z2, z, z);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$ComposeContent$2
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
                        DebugPreferencesFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r112 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public final void GpsPreferences(final String type, final GPSPreferences gPSPreferences, final Function1<? super GPSPreferences, Unit> setData, Composer composer, final int r34) {
        int r4;
        boolean z;
        ComposerImpl composerImpl;
        boolean z2;
        final Function1<? super GPSPreferences, Unit> function1;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int r5;
        int r42;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(setData, "setData");
        ComposerImpl startRestartGroup = composer.startRestartGroup(645365714);
        if ((r34 & 14) == 0) {
            if (startRestartGroup.changed(type)) {
                r42 = 4;
            } else {
                r42 = 2;
            }
            r4 = r42 | r34;
        } else {
            r4 = r34;
        }
        if ((r34 & 112) == 0) {
            if (startRestartGroup.changed(gPSPreferences)) {
                r5 = 32;
            } else {
                r5 = 16;
            }
            r4 |= r5;
        }
        int r6 = 256;
        if ((r34 & 896) == 0) {
            if (!startRestartGroup.changedInstance(setData)) {
                r6 = 128;
            }
            r4 |= r6;
        }
        int r13 = r4;
        if ((r13 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier fillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
            Arrangement$SpaceEvenly$1 arrangement$SpaceEvenly$1 = Arrangement.SpaceEvenly;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceEvenly$1, Alignment.Companion.Top, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth);
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
                TextKt.m216Text4IGK_g(type, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, r13 & 14, 0, 131070);
                if (gPSPreferences == GPSPreferences.Unknown) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z7 = z;
                composerImpl = startRestartGroup;
                composerImpl.startReplaceableGroup(-38192620);
                int r0 = r13 & 896;
                if (r0 == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object nextSlot = composerImpl.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (!z2 && nextSlot != composer$Companion$Empty$1) {
                    function1 = setData;
                } else {
                    function1 = setData;
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$GpsPreferences$1$1$1
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
                            function1.invoke(GPSPreferences.Unknown);
                        }
                    };
                    composerImpl.updateValue(nextSlot);
                }
                composerImpl.end(false);
                RadioButtonKt.RadioButton(z7, (Function0) nextSlot, null, false, null, null, composerImpl, 0, 60);
                if (gPSPreferences == GPSPreferences.Yes) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                composerImpl.startReplaceableGroup(-38192461);
                if (r0 == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Object nextSlot2 = composerImpl.nextSlot();
                if (z4 || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$GpsPreferences$1$2$1
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
                            function1.invoke(GPSPreferences.Yes);
                        }
                    };
                    composerImpl.updateValue(nextSlot2);
                }
                composerImpl.end(false);
                RadioButtonKt.RadioButton(z3, (Function0) nextSlot2, null, false, null, null, composerImpl, 0, 60);
                if (gPSPreferences == GPSPreferences.No) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                composerImpl.startReplaceableGroup(-38192307);
                if (r0 == 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                Object nextSlot3 = composerImpl.nextSlot();
                if (z6 || nextSlot3 == composer$Companion$Empty$1) {
                    nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$GpsPreferences$1$3$1
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
                            function1.invoke(GPSPreferences.No);
                        }
                    };
                    composerImpl.updateValue(nextSlot3);
                }
                composerImpl.end(false);
                RadioButtonKt.RadioButton(z5, (Function0) nextSlot3, null, false, null, null, composerImpl, 0, 60);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugPreferencesFragment$GpsPreferences$2
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

                public final void invoke(Composer composer2, int r8) {
                    DebugPreferencesFragment.this.GpsPreferences(type, gPSPreferences, setData, composer2, Strings.updateChangedFlags(r34 | 1));
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
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }
}
