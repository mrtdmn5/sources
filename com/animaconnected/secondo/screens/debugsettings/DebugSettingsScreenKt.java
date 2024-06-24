package com.animaconnected.secondo.screens.debugsettings;

import android.os.Build;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.text.selection.SelectionContainerKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.InteractiveComponentSizeKt;
import androidx.compose.material.Shapes;
import androidx.compose.material.ShapesKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.notification.handler.DisplayNotificationHandler;
import com.animaconnected.secondo.screens.debugsettings.DebugBleStatus;
import com.animaconnected.secondo.screens.debugsettings.DebugClick;
import com.animaconnected.watch.Watch;
import com.animaconnected.widget.ButtonOutlinedKt;
import com.animaconnected.widget.ModifiersKt;
import com.animaconnected.widget.Switch2Kt;
import com.animaconnected.widget.TopbarKt;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: DebugSettingsScreen.kt */
/* loaded from: classes3.dex */
public final class DebugSettingsScreenKt {

    /* compiled from: DebugSettingsScreen.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[DebugBleStatus.ConnectionState.values().length];
            try {
                r0[DebugBleStatus.ConnectionState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[DebugBleStatus.ConnectionState.DFU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[DebugBleStatus.ConnectionState.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[Watch.WatchState.values().length];
            try {
                r02[Watch.WatchState.Ready.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r02[Watch.WatchState.Syncing.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r02[Watch.WatchState.Initialized.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r02[Watch.WatchState.UpdateRequired.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r02[Watch.WatchState.Initializing.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                r02[Watch.WatchState.Disconnected.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                r02[Watch.WatchState.Inactive.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AppConfig(final DebugAppInfo debugAppInfo, final DebugSwitchStatus debugSwitchStatus, final boolean z, final Function1<? super DebugClick, Unit> function1, Composer composer, final int r112) {
        int r2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        String str;
        Integer num;
        boolean z11;
        int r6;
        int r22;
        ComposerImpl startRestartGroup = composer.startRestartGroup(98397427);
        if ((r112 & 14) == 0) {
            if (startRestartGroup.changed(debugAppInfo)) {
                r22 = 4;
            } else {
                r22 = 2;
            }
            r2 = r22 | r112;
        } else {
            r2 = r112;
        }
        int r7 = 16;
        if ((r112 & 112) == 0) {
            if (startRestartGroup.changed(debugSwitchStatus)) {
                r7 = 32;
            }
            r2 |= r7;
        }
        if ((r112 & 896) == 0) {
            if (startRestartGroup.changed(z)) {
                r6 = 256;
            } else {
                r6 = 128;
            }
            r2 |= r6;
        }
        int r72 = 2048;
        if ((r112 & 7168) == 0) {
            if (!startRestartGroup.changedInstance(function1)) {
                r72 = 1024;
            }
            r2 |= r72;
        }
        if ((r2 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SectionHeader("App Config", startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
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
                modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                String str2 = "App version: " + debugAppInfo.getVersion();
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = TypographyKt.LocalTypography;
                TextKt.m216Text4IGK_g(str2, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).caption, startRestartGroup, 0, 0, 65534);
                float f = 4;
                ModifiersKt.m1611Spacer8Feqmps(f, startRestartGroup, 6);
                TextKt.m216Text4IGK_g("Category: " + debugAppInfo.getCategory(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).caption, startRestartGroup, 0, 0, 65534);
                ModifiersKt.m1611Spacer8Feqmps(f, startRestartGroup, 6);
                TextKt.m216Text4IGK_g("Sandbox: " + debugAppInfo.isSandbox(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).caption, startRestartGroup, 0, 0, 65534);
                ModifiersKt.m1611Spacer8Feqmps(f, startRestartGroup, 6);
                TextKt.m216Text4IGK_g("Using file logger: " + debugAppInfo.isLoggerDogfood(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).caption, startRestartGroup, 0, 0, 65534);
                ModifiersKt.m1611Spacer8Feqmps((float) 8, startRestartGroup, 6);
                boolean demoMode = debugSwitchStatus.getDemoMode();
                startRestartGroup.startReplaceableGroup(1849014577);
                int r23 = r2 & 7168;
                boolean z12 = true;
                if (r23 == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (z2 || nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z13) {
                            function1.invoke(new DebugClick.ToggleDemoMode(z13));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                TextSwitch("Retail demo mode", demoMode, (Function1) nextSlot, startRestartGroup, 6);
                boolean mockFitness = debugSwitchStatus.getMockFitness();
                startRestartGroup.startReplaceableGroup(1849014774);
                if (r23 == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z3 || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z13) {
                            function1.invoke(new DebugClick.ToggleMockFitness(z13));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                TextSwitch("Mocked fitness", mockFitness, (Function1) nextSlot2, startRestartGroup, 6);
                boolean speedCalibration = debugSwitchStatus.getSpeedCalibration();
                startRestartGroup.startReplaceableGroup(1849014982);
                if (r23 == 2048) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Object nextSlot3 = startRestartGroup.nextSlot();
                if (z4 || nextSlot3 == composer$Companion$Empty$1) {
                    nextSlot3 = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$1$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z13) {
                            function1.invoke(new DebugClick.ToggleSpeedCalibration(z13));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot3);
                }
                startRestartGroup.end(false);
                TextSwitch("Speed calibration", speedCalibration, (Function1) nextSlot3, startRestartGroup, 6);
                boolean workInProgress = debugSwitchStatus.getWorkInProgress();
                startRestartGroup.startReplaceableGroup(1849015192);
                if (r23 == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Object nextSlot4 = startRestartGroup.nextSlot();
                if (z5 || nextSlot4 == composer$Companion$Empty$1) {
                    nextSlot4 = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$1$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z13) {
                            function1.invoke(new DebugClick.ToggleWorkInProgress(z13));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot4);
                }
                startRestartGroup.end(false);
                TextSwitch("Work in progress", workInProgress, (Function1) nextSlot4, startRestartGroup, 6);
                boolean healthDashboard = debugSwitchStatus.getHealthDashboard();
                startRestartGroup.startReplaceableGroup(1849015401);
                if (r23 == 2048) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                Object nextSlot5 = startRestartGroup.nextSlot();
                if (z6 || nextSlot5 == composer$Companion$Empty$1) {
                    nextSlot5 = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$1$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z13) {
                            function1.invoke(new DebugClick.ToggleHealthDashboard(z13));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot5);
                }
                startRestartGroup.end(false);
                TextSwitch("Health dashboard", healthDashboard, (Function1) nextSlot5, startRestartGroup, 6);
                boolean ktorLogs = debugSwitchStatus.getKtorLogs();
                startRestartGroup.startReplaceableGroup(1849015597);
                if (r23 == 2048) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Object nextSlot6 = startRestartGroup.nextSlot();
                if (z7 || nextSlot6 == composer$Companion$Empty$1) {
                    nextSlot6 = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$1$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z13) {
                            function1.invoke(new DebugClick.ToggleKtorLogging(z13));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot6);
                }
                startRestartGroup.end(false);
                TextSwitch("KTOR logs", ktorLogs, (Function1) nextSlot6, startRestartGroup, 6);
                boolean appAlwaysOn = debugSwitchStatus.getAppAlwaysOn();
                startRestartGroup.startReplaceableGroup(1849015803);
                if (r23 == 2048) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                Object nextSlot7 = startRestartGroup.nextSlot();
                if (z8 || nextSlot7 == composer$Companion$Empty$1) {
                    nextSlot7 = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$1$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z13) {
                            function1.invoke(new DebugClick.ToggleAppAlwaysOn(z13));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot7);
                }
                startRestartGroup.end(false);
                TextSwitch("App always available", appAlwaysOn, (Function1) nextSlot7, startRestartGroup, 6);
                boolean customerSupportDev = debugSwitchStatus.getCustomerSupportDev();
                startRestartGroup.startReplaceableGroup(1849016028);
                if (r23 == 2048) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                Object nextSlot8 = startRestartGroup.nextSlot();
                if (z9 || nextSlot8 == composer$Companion$Empty$1) {
                    nextSlot8 = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$1$8$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z13) {
                            function1.invoke(new DebugClick.ToggleCustomerSupportDevEnv(z13));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot8);
                }
                startRestartGroup.end(false);
                TextSwitch("Customer support dev environment", customerSupportDev, (Function1) nextSlot8, startRestartGroup, 6);
                ModifiersKt.m1611Spacer8Feqmps(16, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(1849016168);
                if (r23 == 2048) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Object nextSlot9 = startRestartGroup.nextSlot();
                if (z10 || nextSlot9 == composer$Companion$Empty$1) {
                    nextSlot9 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$1$9$1
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
                            function1.invoke(DebugClick.PermissionSettings.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot9);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Permissions", false, false, null, (Function0) nextSlot9, startRestartGroup, 48, 29);
                if (z) {
                    str = "Battery Optimization Disabled";
                } else {
                    str = "Disable Battery Optimization";
                }
                boolean z13 = !z;
                if (z) {
                    num = Integer.valueOf(R.drawable.ic_check);
                } else {
                    num = null;
                }
                startRestartGroup.startReplaceableGroup(1849016500);
                if (r23 != 2048) {
                    z12 = false;
                }
                Object nextSlot10 = startRestartGroup.nextSlot();
                if (z12 || nextSlot10 == composer$Companion$Empty$1) {
                    nextSlot10 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$1$10$1
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
                            function1.invoke(DebugClick.DisablePowerOptimizations.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot10);
                }
                startRestartGroup.end(false);
                DebugButton(null, str, z13, false, num, (Function0) nextSlot10, startRestartGroup, 0, 9);
                startRestartGroup.startReplaceableGroup(1849016602);
                if (r23 == 2048) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Object nextSlot11 = startRestartGroup.nextSlot();
                if (z11 || nextSlot11 == composer$Companion$Empty$1) {
                    nextSlot11 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$1$11$1
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
                            function1.invoke(DebugClick.ResetRecentDemoData.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot11);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Reset recent demo data", false, false, null, (Function0) nextSlot11, startRestartGroup, 48, 29);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$AppConfig$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                    invoke(composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r8) {
                    DebugSettingsScreenKt.AppConfig(DebugAppInfo.this, debugSwitchStatus, z, function1, composer2, Strings.updateChangedFlags(r112 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ConnectionStatus(final DebugBleStatus.ConnectionState connectionState, final Watch.WatchState watchState, Composer composer, final int r63) {
        int r4;
        long j;
        long j2;
        int r6;
        int r42;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1810099635);
        if ((r63 & 14) == 0) {
            if (startRestartGroup.changed(connectionState)) {
                r42 = 4;
            } else {
                r42 = 2;
            }
            r4 = r42 | r63;
        } else {
            r4 = r63;
        }
        if ((r63 & 112) == 0) {
            if (startRestartGroup.changed(watchState)) {
                r6 = 32;
            } else {
                r6 = 16;
            }
            r4 |= r6;
        }
        if ((r4 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            int r43 = WhenMappings.$EnumSwitchMapping$0[connectionState.ordinal()];
            if (r43 != 1) {
                if (r43 != 2) {
                    if (r43 == 3) {
                        j = Color.Red;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    j = Color.Yellow;
                }
            } else {
                j = Color.Green;
            }
            long j3 = j;
            switch (WhenMappings.$EnumSwitchMapping$1[watchState.ordinal()]) {
                case 1:
                    j2 = Color.Cyan;
                    break;
                case 2:
                    j2 = Color.Yellow;
                    break;
                case 3:
                    j2 = Color.Magenta;
                    break;
                case 4:
                    j2 = Color.DarkGray;
                    break;
                case 5:
                    j2 = Color.LightGray;
                    break;
                case 6:
                    j2 = Color.Gray;
                    break;
                case 7:
                    j2 = Color.Red;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            long j4 = j2;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, Alignment.Companion.Top, startRestartGroup);
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
                modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                String str = "Bluetooth: " + connectionState.getDescription();
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ShapesKt.LocalShapes;
                float f = 8;
                Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(BackgroundKt.m21backgroundbw27NRU(companion, j3, ((Shapes) startRestartGroup.consume(staticProvidableCompositionLocal)).small), f);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = ColorsKt.LocalColors;
                long m167getOnPrimary0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal2)).m167getOnPrimary0d7_KjU();
                StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = TypographyKt.LocalTypography;
                TextKt.m216Text4IGK_g(str, m71padding3ABfNKs, m167getOnPrimary0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal3)).caption, startRestartGroup, 0, 0, 65528);
                TextKt.m216Text4IGK_g("Watch: " + watchState.name(), PaddingKt.m71padding3ABfNKs(BackgroundKt.m21backgroundbw27NRU(companion, j4, ((Shapes) startRestartGroup.consume(staticProvidableCompositionLocal)).small), f), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal2)).m167getOnPrimary0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal3)).caption, startRestartGroup, 0, 0, 65528);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$ConnectionStatus$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r44) {
                    DebugSettingsScreenKt.ConnectionStatus(DebugBleStatus.ConnectionState.this, watchState, composer2, Strings.updateChangedFlags(r63 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r8v16, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$7, kotlin.jvm.internal.Lambda] */
    public static final void Connectivity(final boolean z, final boolean z2, final boolean z3, final String str, final DebugLoadingState debugLoadingState, final Function1<? super DebugClick, Unit> function1, Composer composer, final int r49) {
        int r5;
        boolean z4;
        Composer$Companion$Empty$1 composer$Companion$Empty$1;
        int r36;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        int r10;
        int r8;
        int r82;
        int r83;
        int r84;
        int r52;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1650362281);
        if ((r49 & 14) == 0) {
            if (startRestartGroup.changed(z)) {
                r52 = 4;
            } else {
                r52 = 2;
            }
            r5 = r52 | r49;
        } else {
            r5 = r49;
        }
        if ((r49 & 112) == 0) {
            if (startRestartGroup.changed(z2)) {
                r84 = 32;
            } else {
                r84 = 16;
            }
            r5 |= r84;
        }
        if ((r49 & 896) == 0) {
            if (startRestartGroup.changed(z3)) {
                r83 = 256;
            } else {
                r83 = 128;
            }
            r5 |= r83;
        }
        if ((r49 & 7168) == 0) {
            if (startRestartGroup.changed(str)) {
                r82 = 2048;
            } else {
                r82 = 1024;
            }
            r5 |= r82;
        }
        if ((57344 & r49) == 0) {
            if (startRestartGroup.changed(debugLoadingState)) {
                r8 = DfuBaseService.ERROR_CONNECTION_MASK;
            } else {
                r8 = DfuBaseService.ERROR_REMOTE_MASK;
            }
            r5 |= r8;
        }
        if ((r49 & 458752) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r10 = 131072;
            } else {
                r10 = 65536;
            }
            r5 |= r10;
        }
        if ((374491 & r5) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SectionHeader("Connectivity", startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
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
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-313802861);
                int r15 = r5 & 458752;
                boolean z12 = true;
                if (r15 == 131072) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$12 = Composer.Companion.Empty;
                if (z4 || nextSlot == composer$Companion$Empty$12) {
                    nextSlot = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z13) {
                            function1.invoke(new DebugClick.ToggleBluetoothDebug(z13));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                TextSwitch("Bluetooth debug", z2, (Function1) nextSlot, startRestartGroup, (r5 & 112) | 6);
                startRestartGroup.startReplaceableGroup(-313802664);
                if (r15 != 131072) {
                    z12 = false;
                }
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z12 || nextSlot2 == composer$Companion$Empty$12) {
                    nextSlot2 = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z13) {
                            function1.invoke(new DebugClick.ToggleRssiNotification(z13));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                TextSwitch("RSSI Live Updates", z3, (Function1) nextSlot2, startRestartGroup, ((r5 >> 3) & 112) | 6);
                startRestartGroup.startReplaceableGroup(-313802522);
                if (Build.VERSION.SDK_INT >= 33) {
                    composer$Companion$Empty$1 = composer$Companion$Empty$12;
                    TextKt.m216Text4IGK_g("associated: " + z, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).caption, startRestartGroup, 0, 0, 65534);
                    ModifiersKt.m1611Spacer8Feqmps(8, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-313802287);
                    if (r15 == 131072) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Object nextSlot3 = startRestartGroup.nextSlot();
                    if (z10 || nextSlot3 == composer$Companion$Empty$1) {
                        nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$3$1
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
                                function1.invoke(DebugClick.RequestAssociation.INSTANCE);
                            }
                        };
                        startRestartGroup.updateValue(nextSlot3);
                    }
                    startRestartGroup.end(false);
                    DebugButton(null, "Request association", false, false, null, (Function0) nextSlot3, startRestartGroup, 48, 29);
                    startRestartGroup.startReplaceableGroup(-313802202);
                    if (r15 == 131072) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    Object nextSlot4 = startRestartGroup.nextSlot();
                    if (z11 || nextSlot4 == composer$Companion$Empty$1) {
                        nextSlot4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$4$1
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
                                function1.invoke(DebugClick.RemoveAssociation.INSTANCE);
                            }
                        };
                        startRestartGroup.updateValue(nextSlot4);
                    }
                    startRestartGroup.end(false);
                    r36 = r15;
                    DebugButton(null, "Remove association", false, false, null, (Function0) nextSlot4, startRestartGroup, 48, 29);
                } else {
                    composer$Companion$Empty$1 = composer$Companion$Empty$12;
                    r36 = r15;
                }
                startRestartGroup.end(false);
                startRestartGroup.startReplaceableGroup(-313802119);
                int r152 = r36;
                if (r152 == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Object nextSlot5 = startRestartGroup.nextSlot();
                if (z5 || nextSlot5 == composer$Companion$Empty$1) {
                    nextSlot5 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$5$1
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
                            function1.invoke(DebugClick.RemoveBond.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot5);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Remove bond", false, false, null, (Function0) nextSlot5, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(-313802040);
                if (r152 == 131072) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                Object nextSlot6 = startRestartGroup.nextSlot();
                if (z6 || nextSlot6 == composer$Companion$Empty$1) {
                    nextSlot6 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$6$1
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
                            function1.invoke(DebugClick.GetLastDisconnectInfo.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot6);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Get last disconnect info", false, false, null, (Function0) nextSlot6, startRestartGroup, 48, 29);
                if (str.length() > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z7, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1870003035, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                        invoke(animatedVisibilityScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int r30) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        TextKt.m216Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer2.consume(TypographyKt.LocalTypography)).caption, composer2, 0, 0, 65534);
                    }
                }), startRestartGroup, 1572870, 30);
                ModifiersKt.m1611Spacer8Feqmps(16, startRestartGroup, 6);
                TextKt.m216Text4IGK_g("Use buttons below at own risk!", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h3, startRestartGroup, 6, 0, 65534);
                ModifiersKt.m1611Spacer8Feqmps(8, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-313801675);
                if (r152 == 131072) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                Object nextSlot7 = startRestartGroup.nextSlot();
                if (z8 || nextSlot7 == composer$Companion$Empty$1) {
                    nextSlot7 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$8$1
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
                            function1.invoke(DebugClick.Close.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot7);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Close", false, false, null, (Function0) nextSlot7, startRestartGroup, 48, 29);
                boolean z13 = true;
                boolean z14 = !debugLoadingState.isFakeConnecting();
                boolean isFakeConnecting = debugLoadingState.isFakeConnecting();
                startRestartGroup.startReplaceableGroup(-313801467);
                if (r152 != 131072) {
                    z13 = false;
                }
                Object nextSlot8 = startRestartGroup.nextSlot();
                if (z13 || nextSlot8 == composer$Companion$Empty$1) {
                    nextSlot8 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$9$1
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
                            function1.invoke(DebugClick.FakeConnect.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot8);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Fake connect", z14, isFakeConnecting, null, (Function0) nextSlot8, startRestartGroup, 48, 17);
                boolean z15 = true;
                boolean z16 = !debugLoadingState.isDeviceScanning();
                boolean isDeviceScanning = debugLoadingState.isDeviceScanning();
                startRestartGroup.startReplaceableGroup(-313801251);
                if (r152 != 131072) {
                    z15 = false;
                }
                Object nextSlot9 = startRestartGroup.nextSlot();
                if (z15 || nextSlot9 == composer$Companion$Empty$1) {
                    nextSlot9 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$10$1
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
                            function1.invoke(DebugClick.Scan.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot9);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Scan", z16, isDeviceScanning, null, (Function0) nextSlot9, startRestartGroup, 48, 17);
                startRestartGroup.startReplaceableGroup(-313801185);
                if (r152 == 131072) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                Object nextSlot10 = startRestartGroup.nextSlot();
                if (z9 || nextSlot10 == composer$Companion$Empty$1) {
                    nextSlot10 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$1$11$1
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
                            function1.invoke(DebugClick.Connect.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot10);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Connect", false, false, null, (Function0) nextSlot10, startRestartGroup, 48, 29);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Connectivity$2
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

                public final void invoke(Composer composer2, int r102) {
                    DebugSettingsScreenKt.Connectivity(z, z2, z3, str, debugLoadingState, function1, composer2, Strings.updateChangedFlags(r49 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0065  */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugButton$1, kotlin.jvm.internal.Lambda] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void DebugButton(androidx.compose.ui.Modifier r16, final java.lang.String r17, boolean r18, boolean r19, java.lang.Integer r20, final kotlin.jvm.functions.Function0<kotlin.Unit> r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt.DebugButton(androidx.compose.ui.Modifier, java.lang.String, boolean, boolean, java.lang.Integer, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void DebugSettingsScreen(final DebugUiState uiState, final Function1<? super DebugClick, Unit> onClick, Composer composer, final int r30) {
        int r4;
        boolean z;
        boolean z2;
        int r5;
        int r42;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1867738407);
        if ((r30 & 14) == 0) {
            if (startRestartGroup.changed(uiState)) {
                r42 = 4;
            } else {
                r42 = 2;
            }
            r4 = r42 | r30;
        } else {
            r4 = r30;
        }
        if ((r30 & 112) == 0) {
            if (startRestartGroup.changedInstance(onClick)) {
                r5 = 32;
            } else {
                r5 = 16;
            }
            r4 |= r5;
        }
        int r14 = r4;
        if ((r14 & 91) == 18 && startRestartGroup.getSkipping()) {
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
                AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 1712154875);
                int r9 = r14 & 112;
                boolean z3 = true;
                if (r9 != 32) {
                    z3 = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (z3 || nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$1$1
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
                            onClick.invoke(DebugClick.NavigateBack.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                TopbarKt.TopBar(null, R.drawable.ic_chevron_left, (Function0) nextSlot, "Debug", null, startRestartGroup, 3120, 17);
                float f = 32;
                Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(ModifiersKt.m1614fadingEdgeTop3ABfNKs(companion, f), f, 0.0f, f, 56, 2);
                LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(startRestartGroup);
                Arrangement.SpacedAligned m60spacedBy0680j_4 = Arrangement.m60spacedBy0680j_4(f);
                startRestartGroup.startReplaceableGroup(1712155188);
                if ((r14 & 14) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                if (r9 == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z4 = z | z2;
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z4 || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1
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

                        /* JADX WARN: Type inference failed for: r0v1, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1$1, kotlin.jvm.internal.Lambda] */
                        /* JADX WARN: Type inference failed for: r0v11, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1$6, kotlin.jvm.internal.Lambda] */
                        /* JADX WARN: Type inference failed for: r0v13, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1$7, kotlin.jvm.internal.Lambda] */
                        /* JADX WARN: Type inference failed for: r0v15, types: [kotlin.jvm.internal.Lambda, com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1$8] */
                        /* JADX WARN: Type inference failed for: r0v17, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1$9, kotlin.jvm.internal.Lambda] */
                        /* JADX WARN: Type inference failed for: r0v19, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1$10, kotlin.jvm.internal.Lambda] */
                        /* JADX WARN: Type inference failed for: r0v21, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1$11, kotlin.jvm.internal.Lambda] */
                        /* JADX WARN: Type inference failed for: r0v3, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1$2, kotlin.jvm.internal.Lambda] */
                        /* JADX WARN: Type inference failed for: r0v5, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1$3, kotlin.jvm.internal.Lambda] */
                        /* JADX WARN: Type inference failed for: r0v7, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1$4, kotlin.jvm.internal.Lambda] */
                        /* JADX WARN: Type inference failed for: r0v9, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1$5, kotlin.jvm.internal.Lambda] */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyColumn) {
                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                            final DebugUiState debugUiState = DebugUiState.this;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(674300047, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1.1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r43) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r43 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                    ModifiersKt.m1611Spacer8Feqmps(32, composer2, 6);
                                    DebugSettingsScreenKt.ConnectionStatus(DebugUiState.this.getBleStatus().getConnectionState(), DebugUiState.this.getWatchState(), composer2, 0);
                                }
                            }, true));
                            final DebugUiState debugUiState2 = DebugUiState.this;
                            final Function1<DebugClick, Unit> function1 = onClick;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(1627543544, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r52) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r52 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                        DebugSettingsScreenKt.Firmware(DebugUiState.this.getBleStatus().getConnectionState() == DebugBleStatus.ConnectionState.CONNECTED, DebugUiState.this.getFirmwareStatus(), function1, composer2, 0);
                                    }
                                }
                            }, true));
                            final DebugUiState debugUiState3 = DebugUiState.this;
                            final Function1<DebugClick, Unit> function12 = onClick;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(1456704087, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r92) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r92 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                        DebugSettingsScreenKt.AppConfig(DebugUiState.this.getAppStatus(), DebugUiState.this.getSwitches(), DebugUiState.this.getIgnoreBatteryOptimization(), function12, composer2, 0);
                                    }
                                }
                            }, true));
                            final DebugUiState debugUiState4 = DebugUiState.this;
                            final Function1<DebugClick, Unit> function13 = onClick;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(1285864630, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r43) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r43 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                        DebugSettingsScreenKt.Notifications(DebugUiState.this.getBleStatus().getConnectionState() == DebugBleStatus.ConnectionState.CONNECTED, function13, composer2, 0);
                                    }
                                }
                            }, true));
                            final Function1<DebugClick, Unit> function14 = onClick;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(1115025173, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r43) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r43 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                        DebugSettingsScreenKt.Design(function14, composer2, 0);
                                    }
                                }
                            }, true));
                            final DebugUiState debugUiState5 = DebugUiState.this;
                            final Function1<DebugClick, Unit> function15 = onClick;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(944185716, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r43) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r43 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                    DebugSettingsScreenKt.DeviceData(function15, DebugUiState.this.getLoadingStates().isReadingPostMortem(), composer2, 0);
                                }
                            }, true));
                            final Function1<DebugClick, Unit> function16 = onClick;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(773346259, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1.7
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r43) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r43 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                        DebugSettingsScreenKt.Display(function16, composer2, 0);
                                    }
                                }
                            }, true));
                            final Function1<DebugClick, Unit> function17 = onClick;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(602506802, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1.8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r43) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r43 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                        DebugSettingsScreenKt.Fitness(function17, composer2, 0);
                                    }
                                }
                            }, true));
                            final Function1<DebugClick, Unit> function18 = onClick;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(431667345, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1.9
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r43) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r43 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                        DebugSettingsScreenKt.DebugTools(function18, composer2, 0);
                                    }
                                }
                            }, true));
                            final DebugUiState debugUiState6 = DebugUiState.this;
                            final Function1<DebugClick, Unit> function19 = onClick;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(260827888, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1.10
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r11) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r11 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                        DebugSettingsScreenKt.Connectivity(DebugUiState.this.getBleStatus().isAssociated(), DebugUiState.this.getSwitches().getBluetoothDebug(), DebugUiState.this.getSwitches().getRssiLiveUpdates(), DebugUiState.this.getLastDisconnectInfo(), DebugUiState.this.getLoadingStates(), function19, composer2, 0);
                                    }
                                }
                            }, true));
                            final DebugUiState debugUiState7 = DebugUiState.this;
                            final Function1<DebugClick, Unit> function110 = onClick;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(1179123574, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$1$2$1.11
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r43) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r43 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                        DebugSettingsScreenKt.Services(DebugUiState.this.getTokens(), function110, composer2, 0);
                                    }
                                }
                            }, true));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                LazyDslKt.LazyColumn(m75paddingqDBjuR0$default, rememberLazyListState, null, false, m60spacedBy0680j_4, null, null, false, (Function1) nextSlot2, startRestartGroup, 24576, 236);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugSettingsScreen$2
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

                public final void invoke(Composer composer2, int r43) {
                    DebugSettingsScreenKt.DebugSettingsScreen(DebugUiState.this, onClick, composer2, Strings.updateChangedFlags(r30 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DebugTools(final Function1<? super DebugClick, Unit> function1, Composer composer, final int r33) {
        int r28;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        ComposerImpl startRestartGroup = composer.startRestartGroup(406306997);
        int r5 = 4;
        if ((r33 & 14) == 0) {
            if (!startRestartGroup.changedInstance(function1)) {
                r5 = 2;
            }
            r28 = r5 | r33;
        } else {
            r28 = r33;
        }
        if ((r28 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SectionHeader("Misc", startRestartGroup, 6);
            TextKt.m216Text4IGK_g("Set battery state:", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h3, startRestartGroup, 6, 0, 65534);
            ModifiersKt.m1611Spacer8Feqmps(4, startRestartGroup, 6);
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
                Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
                BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
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
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    Modifier weight = rowScopeInstance.weight(companion, 1.0f, true);
                    startRestartGroup.startReplaceableGroup(-2000790216);
                    int r15 = r28 & 14;
                    if (r15 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Object nextSlot = startRestartGroup.nextSlot();
                    Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                    if (z || nextSlot == composer$Companion$Empty$1) {
                        nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugTools$1$1$1$1
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
                                function1.invoke(new DebugClick.SetBatteryLevel(0));
                            }
                        };
                        startRestartGroup.updateValue(nextSlot);
                    }
                    startRestartGroup.end(false);
                    ComposableSingletons$DebugSettingsScreenKt composableSingletons$DebugSettingsScreenKt = ComposableSingletons$DebugSettingsScreenKt.INSTANCE;
                    ButtonOutlinedKt.ButtonOutlined(weight, (Function0) nextSlot, false, false, composableSingletons$DebugSettingsScreenKt.m858getLambda1$secondo_kronabyRelease(), startRestartGroup, 24576, 12);
                    Modifier weight2 = rowScopeInstance.weight(companion, 1.0f, true);
                    startRestartGroup.startReplaceableGroup(-2000789952);
                    if (r15 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Object nextSlot2 = startRestartGroup.nextSlot();
                    if (z2 || nextSlot2 == composer$Companion$Empty$1) {
                        nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugTools$1$1$2$1
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
                                function1.invoke(new DebugClick.SetBatteryLevel(DebugSettingsPresenter.LOW_BATTERY));
                            }
                        };
                        startRestartGroup.updateValue(nextSlot2);
                    }
                    startRestartGroup.end(false);
                    ButtonOutlinedKt.ButtonOutlined(weight2, (Function0) nextSlot2, false, false, composableSingletons$DebugSettingsScreenKt.m859getLambda2$secondo_kronabyRelease(), startRestartGroup, 24576, 12);
                    Modifier weight3 = rowScopeInstance.weight(companion, 1.0f, true);
                    startRestartGroup.startReplaceableGroup(-2000789695);
                    if (r15 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Object nextSlot3 = startRestartGroup.nextSlot();
                    if (z3 || nextSlot3 == composer$Companion$Empty$1) {
                        nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugTools$1$1$3$1
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
                                function1.invoke(new DebugClick.SetBatteryLevel(DebugSettingsPresenter.CRITICAL_BATTERY));
                            }
                        };
                        startRestartGroup.updateValue(nextSlot3);
                    }
                    startRestartGroup.end(false);
                    ButtonOutlinedKt.ButtonOutlined(weight3, (Function0) nextSlot3, false, false, composableSingletons$DebugSettingsScreenKt.m860getLambda3$secondo_kronabyRelease(), startRestartGroup, 24576, 12);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    startRestartGroup.startReplaceableGroup(1120556045);
                    if (r15 == 4) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Object nextSlot4 = startRestartGroup.nextSlot();
                    if (z4 || nextSlot4 == composer$Companion$Empty$1) {
                        nextSlot4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugTools$1$2$1
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
                                function1.invoke(new DebugClick.GoToNextFragment(new DebugWeatherFragment()));
                            }
                        };
                        startRestartGroup.updateValue(nextSlot4);
                    }
                    startRestartGroup.end(false);
                    DebugButton(null, "Weather", false, false, null, (Function0) nextSlot4, startRestartGroup, 48, 29);
                    startRestartGroup.startReplaceableGroup(1120556148);
                    if (r15 == 4) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Object nextSlot5 = startRestartGroup.nextSlot();
                    if (z5 || nextSlot5 == composer$Companion$Empty$1) {
                        nextSlot5 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugTools$1$3$1
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
                                function1.invoke(DebugClick.TriggerHardFault.INSTANCE);
                            }
                        };
                        startRestartGroup.updateValue(nextSlot5);
                    }
                    startRestartGroup.end(false);
                    DebugButton(null, "Trigger hard fault", false, false, null, (Function0) nextSlot5, startRestartGroup, 48, 29);
                    startRestartGroup.startReplaceableGroup(1120556226);
                    if (r15 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    Object nextSlot6 = startRestartGroup.nextSlot();
                    if (z6 || nextSlot6 == composer$Companion$Empty$1) {
                        nextSlot6 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugTools$1$4$1
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
                                function1.invoke(DebugClick.TriggerAppError.INSTANCE);
                            }
                        };
                        startRestartGroup.updateValue(nextSlot6);
                    }
                    startRestartGroup.end(false);
                    DebugButton(null, "Trigger app error", false, false, null, (Function0) nextSlot6, startRestartGroup, 48, 29);
                    startRestartGroup.startReplaceableGroup(1120556299);
                    if (r15 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Object nextSlot7 = startRestartGroup.nextSlot();
                    if (z7 || nextSlot7 == composer$Companion$Empty$1) {
                        nextSlot7 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugTools$1$5$1
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
                                function1.invoke(DebugClick.DebugTesting.INSTANCE);
                            }
                        };
                        startRestartGroup.updateValue(nextSlot7);
                    }
                    startRestartGroup.end(false);
                    DebugButton(null, "Debug testing", false, false, null, (Function0) nextSlot7, startRestartGroup, 48, 29);
                    startRestartGroup.startReplaceableGroup(1120556370);
                    if (r15 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    Object nextSlot8 = startRestartGroup.nextSlot();
                    if (z8 || nextSlot8 == composer$Companion$Empty$1) {
                        nextSlot8 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugTools$1$6$1
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
                                function1.invoke(new DebugClick.GoToNextFragment(new LottiePreviewFragment()));
                            }
                        };
                        startRestartGroup.updateValue(nextSlot8);
                    }
                    startRestartGroup.end(false);
                    DebugButton(null, "Lottie preview", false, false, null, (Function0) nextSlot8, startRestartGroup, 48, 29);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
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
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DebugTools$2
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

                public final void invoke(Composer composer2, int r3) {
                    DebugSettingsScreenKt.DebugTools(function1, composer2, Strings.updateChangedFlags(r33 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Design(final Function1<? super DebugClick, Unit> function1, Composer composer, final int r23) {
        int r3;
        boolean z;
        boolean z2;
        int r32;
        ComposerImpl startRestartGroup = composer.startRestartGroup(583139883);
        if ((r23 & 14) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r32 = 4;
            } else {
                r32 = 2;
            }
            r3 = r32 | r23;
        } else {
            r3 = r23;
        }
        if ((r3 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SectionHeader("Design", startRestartGroup, 6);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, Alignment.Companion.Top, startRestartGroup);
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
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                boolean z3 = true;
                Modifier weight = rowScopeInstance.weight(companion, 1.0f, true);
                startRestartGroup.startReplaceableGroup(-955431375);
                int r15 = r3 & 14;
                if (r15 != 4) {
                    z3 = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (z3 || nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Design$1$1$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugThemingFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                DebugButton(weight, "Themes", false, false, null, (Function0) nextSlot, startRestartGroup, 48, 28);
                Modifier weight2 = rowScopeInstance.weight(companion, 1.0f, true);
                startRestartGroup.startReplaceableGroup(-955431195);
                if (r15 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Design$1$2$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugGraphFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                DebugButton(weight2, "Graphs", false, false, null, (Function0) nextSlot2, startRestartGroup, 48, 28);
                Modifier weight3 = rowScopeInstance.weight(companion, 1.0f, true);
                startRestartGroup.startReplaceableGroup(-955431016);
                if (r15 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object nextSlot3 = startRestartGroup.nextSlot();
                if (z2 || nextSlot3 == composer$Companion$Empty$1) {
                    nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Design$1$3$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugWatchThemeFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot3);
                }
                startRestartGroup.end(false);
                DebugButton(weight3, "Colours", false, false, null, (Function0) nextSlot3, startRestartGroup, 48, 28);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Design$2
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

                public final void invoke(Composer composer2, int r33) {
                    DebugSettingsScreenKt.Design(function1, composer2, Strings.updateChangedFlags(r23 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DeviceData(final Function1<? super DebugClick, Unit> function1, final boolean z, Composer composer, final int r24) {
        int r1;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ComposerImpl composerImpl;
        int r2;
        int r12;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1685792489);
        if ((r24 & 14) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r12 = 4;
            } else {
                r12 = 2;
            }
            r1 = r12 | r24;
        } else {
            r1 = r24;
        }
        if ((r24 & 112) == 0) {
            if (startRestartGroup.changed(z)) {
                r2 = 32;
            } else {
                r2 = 16;
            }
            r1 |= r2;
        }
        if ((r1 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SectionHeader("Device data", startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
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
                AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 1156489084);
                int r7 = r1 & 14;
                if (r7 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (z2 || nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DeviceData$1$1$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DeviceInfoFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Device info", false, false, null, (Function0) nextSlot, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1156489178);
                if (r7 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z3 || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DeviceData$1$2$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DeviceLogsFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Device logs", false, false, null, (Function0) nextSlot2, startRestartGroup, 48, 29);
                boolean z6 = !z;
                startRestartGroup.startReplaceableGroup(1156489398);
                if (r7 == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Object nextSlot3 = startRestartGroup.nextSlot();
                if (z4 || nextSlot3 == composer$Companion$Empty$1) {
                    nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DeviceData$1$3$1
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
                            function1.invoke(DebugClick.ReadPostMortem.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot3);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Post mortem", z6, z, null, (Function0) nextSlot3, startRestartGroup, ((r1 << 6) & 7168) | 48, 17);
                startRestartGroup.startReplaceableGroup(1156489481);
                if (r7 == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Object nextSlot4 = startRestartGroup.nextSlot();
                if (z5 || nextSlot4 == composer$Companion$Empty$1) {
                    nextSlot4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DeviceData$1$4$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new MsgPackFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot4);
                }
                startRestartGroup.end(false);
                composerImpl = startRestartGroup;
                DebugButton(null, "Msgpack sender", false, false, null, (Function0) nextSlot4, composerImpl, 48, 29);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$DeviceData$2
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
                    DebugSettingsScreenKt.DeviceData(function1, z, composer2, Strings.updateChangedFlags(r24 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Display(final Function1<? super DebugClick, Unit> function1, Composer composer, final int r22) {
        int r9;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int r3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-134797677);
        if ((r22 & 14) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r3 = 4;
            } else {
                r3 = 2;
            }
            r9 = r3 | r22;
        } else {
            r9 = r22;
        }
        if ((r9 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SectionHeader("Display", startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
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
                AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 1920715694);
                int r92 = r9 & 14;
                if (r92 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (z || nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Display$1$1$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugDisplayFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Display testing", false, false, null, (Function0) nextSlot, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1920715790);
                if (r92 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z2 || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Display$1$2$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugPreferencesFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Preferences", false, false, null, (Function0) nextSlot2, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1920715900);
                if (r92 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object nextSlot3 = startRestartGroup.nextSlot();
                if (z3 || nextSlot3 == composer$Companion$Empty$1) {
                    nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Display$1$3$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugImagePreview()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot3);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Display image preview", false, false, null, (Function0) nextSlot3, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1920715996);
                if (r92 == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Object nextSlot4 = startRestartGroup.nextSlot();
                if (z4 || nextSlot4 == composer$Companion$Empty$1) {
                    nextSlot4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Display$1$4$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugDeviceStorageFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot4);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Device storage", false, false, null, (Function0) nextSlot4, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1920716099);
                if (r92 == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Object nextSlot5 = startRestartGroup.nextSlot();
                if (z5 || nextSlot5 == composer$Companion$Empty$1) {
                    nextSlot5 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Display$1$5$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugKanvasFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot5);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Debug kanvas", false, false, null, (Function0) nextSlot5, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1920716199);
                if (r92 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                Object nextSlot6 = startRestartGroup.nextSlot();
                if (z6 || nextSlot6 == composer$Companion$Empty$1) {
                    nextSlot6 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Display$1$6$1
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
                            function1.invoke(DebugClick.ClearDisplayDatabase.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot6);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Clear display db", false, false, null, (Function0) nextSlot6, startRestartGroup, 48, 29);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Display$2
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

                public final void invoke(Composer composer2, int r32) {
                    DebugSettingsScreenKt.Display(function1, composer2, Strings.updateChangedFlags(r22 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Firmware(final boolean z, final DebugFirmwareStatus debugFirmwareStatus, final Function1<? super DebugClick, Unit> function1, Composer composer, final int r98) {
        int r0;
        boolean z2;
        boolean z3;
        final Function1<? super DebugClick, Unit> function12;
        int r7;
        ComposerImpl composerImpl;
        boolean z4;
        int r1;
        int r12;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(793623672);
        if ((r98 & 14) == 0) {
            if (startRestartGroup.changed(z)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r98;
        } else {
            r0 = r98;
        }
        if ((r98 & 112) == 0) {
            if (startRestartGroup.changed(debugFirmwareStatus)) {
                r12 = 32;
            } else {
                r12 = 16;
            }
            r0 |= r12;
        }
        if ((r98 & 896) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r1 = 256;
            } else {
                r1 = 128;
            }
            r0 |= r1;
        }
        if ((r0 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function12 = function1;
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SectionHeader("Firmware", startRestartGroup, 6);
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
                Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
                startRestartGroup.startReplaceableGroup(693286680);
                BiasAlignment.Vertical vertical = Alignment.Companion.Top;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
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
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    Modifier weight = rowScopeInstance.weight(companion, 1.0f, true);
                    startRestartGroup.startReplaceableGroup(-537652447);
                    int r4 = r0 & 896;
                    if (r4 == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Object nextSlot = startRestartGroup.nextSlot();
                    Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                    if (z2 || nextSlot == composer$Companion$Empty$1) {
                        nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Firmware$1$1$1$1
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
                                function1.invoke(DebugClick.FetchDfuCloud.INSTANCE);
                            }
                        };
                        startRestartGroup.updateValue(nextSlot);
                    }
                    startRestartGroup.end(false);
                    int r22 = ((r0 << 6) & 896) | 48;
                    DebugButton(weight, "From cloud", z, false, null, (Function0) nextSlot, startRestartGroup, r22, 24);
                    boolean z5 = true;
                    Modifier weight2 = rowScopeInstance.weight(companion, 1.0f, true);
                    startRestartGroup.startReplaceableGroup(-537652232);
                    if (r4 != 256) {
                        z5 = false;
                    }
                    Object nextSlot2 = startRestartGroup.nextSlot();
                    if (z5 || nextSlot2 == composer$Companion$Empty$1) {
                        nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Firmware$1$1$2$1
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
                                function1.invoke(DebugClick.FetchDfuLocal.INSTANCE);
                            }
                        };
                        startRestartGroup.updateValue(nextSlot2);
                    }
                    startRestartGroup.end(false);
                    DebugButton(weight2, "From file", z, false, null, (Function0) nextSlot2, startRestartGroup, r22, 24);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    Modifier fillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    startRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                    PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                    ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth2);
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
                        AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf3, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                        Modifier weight3 = rowScopeInstance.weight(companion, 1.0f, true);
                        startRestartGroup.startReplaceableGroup(-537651917);
                        if (r4 == 256) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        Object nextSlot3 = startRestartGroup.nextSlot();
                        if (!z3 && nextSlot3 != composer$Companion$Empty$1) {
                            function12 = function1;
                            r7 = r4;
                        } else {
                            function12 = function1;
                            r7 = r4;
                            nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Firmware$1$2$1$1
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
                                    function12.invoke(new DebugClick.GoToNextFragment(new DfuLogsFragment()));
                                }
                            };
                            startRestartGroup.updateValue(nextSlot3);
                        }
                        startRestartGroup.end(false);
                        composerImpl = startRestartGroup;
                        DebugButton(weight3, "Logs", false, false, null, (Function0) nextSlot3, composerImpl, 48, 28);
                        Modifier weight4 = rowScopeInstance.weight(companion, 1.0f, true);
                        composerImpl.startReplaceableGroup(-537651724);
                        if (r7 == 256) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        Object nextSlot4 = composerImpl.nextSlot();
                        if (z4 || nextSlot4 == composer$Companion$Empty$1) {
                            nextSlot4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Firmware$1$2$2$1
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
                                    Function1<DebugClick, Unit> function13 = function12;
                                    FotaInfoFragment create = FotaInfoFragment.create();
                                    Intrinsics.checkNotNullExpressionValue(create, "create(...)");
                                    function13.invoke(new DebugClick.GoToNextFragment(create));
                                }
                            };
                            composerImpl.updateValue(nextSlot4);
                        }
                        composerImpl.end(false);
                        DebugButton(weight4, "Info", false, false, null, (Function0) nextSlot4, composerImpl, 48, 28);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
                        ModifiersKt.m1611Spacer8Feqmps(8, composerImpl, 6);
                        String str = "Firmware version: " + debugFirmwareStatus.getVersion();
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = TypographyKt.LocalTypography;
                        TextKt.m216Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composerImpl.consume(staticProvidableCompositionLocal)).caption, composerImpl, 0, 0, 65534);
                        float f = 4;
                        ModifiersKt.m1611Spacer8Feqmps(f, composerImpl, 6);
                        TextKt.m216Text4IGK_g("Update status: " + debugFirmwareStatus.getUpdateStatus(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composerImpl.consume(staticProvidableCompositionLocal)).caption, composerImpl, 0, 0, 65534);
                        ModifiersKt.m1611Spacer8Feqmps(f, composerImpl, 6);
                        TextKt.m216Text4IGK_g("Last dfu_ready: " + debugFirmwareStatus.getLastDfu(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composerImpl.consume(staticProvidableCompositionLocal)).caption, composerImpl, 0, 0, 65534);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
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
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Firmware$2
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
                    DebugSettingsScreenKt.Firmware(z, debugFirmwareStatus, function12, composer2, Strings.updateChangedFlags(r98 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fitness(final Function1<? super DebugClick, Unit> function1, Composer composer, final int r22) {
        int r9;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int r3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1923509177);
        if ((r22 & 14) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r3 = 4;
            } else {
                r3 = 2;
            }
            r9 = r3 | r22;
        } else {
            r9 = r22;
        }
        if ((r9 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SectionHeader("Fitness", startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
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
                AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 1077628671);
                int r92 = r9 & 14;
                if (r92 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (z || nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Fitness$1$1$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugCSEMLogsFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                DebugButton(null, "CSEM logs", false, false, null, (Function0) nextSlot, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1077628770);
                if (r92 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z2 || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Fitness$1$2$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new HeartRateRefDeviceFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                DebugButton(null, "HR REF DEVICE", false, false, null, (Function0) nextSlot2, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1077628869);
                if (r92 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object nextSlot3 = startRestartGroup.nextSlot();
                if (z3 || nextSlot3 == composer$Companion$Empty$1) {
                    nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Fitness$1$3$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugFitnessMainFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot3);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Overview", false, false, null, (Function0) nextSlot3, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1077628977);
                if (r92 == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Object nextSlot4 = startRestartGroup.nextSlot();
                if (z4 || nextSlot4 == composer$Companion$Empty$1) {
                    nextSlot4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Fitness$1$4$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugFitnessDatabaseFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot4);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Database inspection", false, false, null, (Function0) nextSlot4, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1077629081);
                if (r92 == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Object nextSlot5 = startRestartGroup.nextSlot();
                if (z5 || nextSlot5 == composer$Companion$Empty$1) {
                    nextSlot5 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Fitness$1$5$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugSleepFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot5);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Sleep debug", false, false, null, (Function0) nextSlot5, startRestartGroup, 48, 29);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Fitness$2
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

                public final void invoke(Composer composer2, int r32) {
                    DebugSettingsScreenKt.Fitness(function1, composer2, Strings.updateChangedFlags(r22 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Notifications(final boolean z, final Function1<? super DebugClick, Unit> function1, Composer composer, final int r25) {
        int r0;
        boolean z2;
        boolean z3;
        boolean z4;
        ComposerImpl composerImpl;
        int r1;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(10973589);
        if ((r25 & 14) == 0) {
            if (startRestartGroup.changed(z)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r25;
        } else {
            r0 = r25;
        }
        if ((r25 & 112) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r1 = 32;
            } else {
                r1 = 16;
            }
            r0 |= r1;
        }
        if ((r0 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SectionHeader(DisplayNotificationHandler.TYPE, startRestartGroup, 6);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, Alignment.Companion.Top, startRestartGroup);
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
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier weight = rowScopeInstance.weight(companion, 1.0f, true);
                startRestartGroup.startReplaceableGroup(1155174857);
                int r8 = r0 & 112;
                if (r8 == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (z2 || nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Notifications$1$1$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugNotificationsFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                int r21 = ((r0 << 6) & 896) | 48;
                DebugButton(weight, "App", z, false, null, (Function0) nextSlot, startRestartGroup, r21, 24);
                Modifier weight2 = rowScopeInstance.weight(companion, 1.0f, true);
                startRestartGroup.startReplaceableGroup(1155175042);
                if (r8 == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z3 || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Notifications$1$2$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugMediaNotificationsFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                DebugButton(weight2, "Media", false, false, null, (Function0) nextSlot2, startRestartGroup, 48, 28);
                Modifier weight3 = rowScopeInstance.weight(companion, 1.0f, true);
                startRestartGroup.startReplaceableGroup(1155175266);
                if (r8 == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Object nextSlot3 = startRestartGroup.nextSlot();
                if (z4 || nextSlot3 == composer$Companion$Empty$1) {
                    nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Notifications$1$3$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new DebugCallNotificationsFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot3);
                }
                startRestartGroup.end(false);
                composerImpl = startRestartGroup;
                DebugButton(weight3, "Call", z, false, null, (Function0) nextSlot3, composerImpl, r21, 24);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Notifications$2
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
                    DebugSettingsScreenKt.Notifications(z, function1, composer2, Strings.updateChangedFlags(r25 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewDebugScreen(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-846742119);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ThemeKt.BrandTheme(composeThemeProvider, ComposableSingletons$DebugSettingsScreenKt.INSTANCE.m861getLambda4$secondo_kronabyRelease(), startRestartGroup, 56);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$PreviewDebugScreen$1
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
                    DebugSettingsScreenKt.PreviewDebugScreen(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SectionHeader(final String str, Composer composer, final int r28) {
        int r21;
        ComposerImpl composerImpl;
        int r1;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1251713315);
        if ((r28 & 14) == 0) {
            if (startRestartGroup.changed(str)) {
                r1 = 4;
            } else {
                r1 = 2;
            }
            r21 = r1 | r28;
        } else {
            r21 = r28;
        }
        if ((r21 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            TextKt.m216Text4IGK_g(str, null, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h1, startRestartGroup, r21 & 14, 0, 65530);
            composerImpl = startRestartGroup;
            ModifiersKt.m1611Spacer8Feqmps(8, composerImpl, 6);
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$SectionHeader$1
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
                    DebugSettingsScreenKt.SectionHeader(str, composer2, Strings.updateChangedFlags(r28 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$SelectableText$1$1, kotlin.jvm.internal.Lambda] */
    public static final void SelectableText(final String str, String str2, Composer composer, final int r31) {
        int r4;
        final String str3;
        ComposerImpl composerImpl;
        int r5;
        int r42;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1729029341);
        if ((r31 & 14) == 0) {
            if (startRestartGroup.changed(str)) {
                r42 = 4;
            } else {
                r42 = 2;
            }
            r4 = r42 | r31;
        } else {
            r4 = r31;
        }
        if ((r31 & 112) == 0) {
            if (startRestartGroup.changed(str2)) {
                r5 = 32;
            } else {
                r5 = 16;
            }
            r4 |= r5;
        }
        int r21 = r4;
        if ((r21 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
            str3 = str2;
        } else {
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
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                TextKt.m216Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).subtitle1, startRestartGroup, r21 & 14, 0, 65534);
                str3 = str2;
                composerImpl = startRestartGroup;
                SelectionContainerKt.SelectionContainer(null, ComposableLambdaKt.composableLambda(composerImpl, 1051123626, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$SelectableText$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r30) {
                        if ((r30 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                            TextKt.m216Text4IGK_g(str3, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer2.consume(TypographyKt.LocalTypography)).caption, composer2, 0, 0, 65534);
                        }
                    }
                }), composerImpl, 48, 1);
                composerImpl.end(false);
                composerImpl.end(true);
                composerImpl.end(false);
                composerImpl.end(false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$SelectableText$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r43) {
                    DebugSettingsScreenKt.SelectableText(str, str3, composer2, Strings.updateChangedFlags(r31 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Services(final DebugTokens debugTokens, final Function1<? super DebugClick, Unit> function1, Composer composer, final int r15) {
        int r0;
        boolean z;
        boolean z2;
        boolean z3;
        int r1;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-590369972);
        if ((r15 & 14) == 0) {
            if (startRestartGroup.changed(debugTokens)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r15;
        } else {
            r0 = r15;
        }
        if ((r15 & 112) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
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
            SectionHeader("Services", startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
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
                modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                SelectableText("Amazon Pool ID:", debugTokens.getPoolId(), startRestartGroup, 6);
                float f = 16;
                ModifiersKt.m1611Spacer8Feqmps(f, startRestartGroup, 6);
                SelectableText("Cognito ID:", debugTokens.getCognito(), startRestartGroup, 6);
                ModifiersKt.m1611Spacer8Feqmps(f, startRestartGroup, 6);
                SelectableText("Firebase instance token:", debugTokens.getFirebase(), startRestartGroup, 6);
                ModifiersKt.m1611Spacer8Feqmps(f, startRestartGroup, 6);
                SelectableText("Amplify access token:", debugTokens.getAmplifyAccess(), startRestartGroup, 6);
                ModifiersKt.m1611Spacer8Feqmps(f, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(1591278642);
                int r03 = r0 & 112;
                boolean z4 = true;
                if (r03 != 32) {
                    z4 = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (z4 || nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Services$1$1$1
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
                            function1.invoke(DebugClick.ChangePoolID.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Change pool id", false, false, null, (Function0) nextSlot, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1591278712);
                if (r03 == 32) {
                    z = true;
                } else {
                    z = false;
                }
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (z || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Services$1$2$1
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
                            function1.invoke(DebugClick.RefreshAmplifySession.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Force refresh", false, false, null, (Function0) nextSlot2, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(1591278796);
                if (r03 == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object nextSlot3 = startRestartGroup.nextSlot();
                if (z2 || nextSlot3 == composer$Companion$Empty$1) {
                    nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Services$1$3$1
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
                            function1.invoke(new DebugClick.GoToNextFragment(new RemoteConfigFragment()));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot3);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Read remote config", false, false, null, (Function0) nextSlot3, startRestartGroup, 48, 29);
                startRestartGroup.startReplaceableGroup(706393833);
                startRestartGroup.startReplaceableGroup(1591278935);
                if (r03 == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object nextSlot4 = startRestartGroup.nextSlot();
                if (z3 || nextSlot4 == composer$Companion$Empty$1) {
                    nextSlot4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Services$1$4$1
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
                            function1.invoke(DebugClick.SendCrashlytics.INSTANCE);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot4);
                }
                startRestartGroup.end(false);
                DebugButton(null, "Send crashlytics", false, false, null, (Function0) nextSlot4, startRestartGroup, 48, 29);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
                startRestartGroup.end(false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$Services$2
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
                    DebugSettingsScreenKt.Services(DebugTokens.this, function1, composer2, Strings.updateChangedFlags(r15 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextSwitch(final String str, final boolean z, final Function1<? super Boolean, Unit> function1, Composer composer, final int r32) {
        int r1;
        ComposerImpl composerImpl;
        int r4;
        int r42;
        int r12;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-346904671);
        if ((r32 & 14) == 0) {
            if (startRestartGroup.changed(str)) {
                r12 = 4;
            } else {
                r12 = 2;
            }
            r1 = r12 | r32;
        } else {
            r1 = r32;
        }
        if ((r32 & 112) == 0) {
            if (startRestartGroup.changed(z)) {
                r42 = 32;
            } else {
                r42 = 16;
            }
            r1 |= r42;
        }
        if ((r32 & 896) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r4 = 256;
            } else {
                r4 = 128;
            }
            r1 |= r4;
        }
        int r13 = r1;
        if ((r13 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(SizeKt.fillMaxWidth(companion, 1.0f));
            Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(minimumInteractiveComponentSize);
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
                boolean z2 = false;
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                if (1.0f > 0.0d) {
                    z2 = true;
                }
                if (z2) {
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    companion.then(layoutWeightElement);
                    TextKt.m216Text4IGK_g(str, layoutWeightElement, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).body1, startRestartGroup, r13 & 14, 0, 65532);
                    int r0 = r13 >> 3;
                    Switch2Kt.Switch2(z, function1, null, false, null, null, startRestartGroup, (r0 & 14) | (r0 & 112), 60);
                    composerImpl = startRestartGroup;
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
                } else {
                    throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
                }
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsScreenKt$TextSwitch$2
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
                    DebugSettingsScreenKt.TextSwitch(str, z, function1, composer2, Strings.updateChangedFlags(r32 | 1));
                }
            };
        }
    }
}
