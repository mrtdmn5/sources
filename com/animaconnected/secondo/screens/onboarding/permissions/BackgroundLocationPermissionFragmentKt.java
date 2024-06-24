package com.animaconnected.secondo.screens.onboarding.permissions;

import android.os.Build;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.IconKt;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.animaconnected.secondo.screens.onboarding.OnboardingPermissionInfo;
import com.animaconnected.secondo.screens.onboarding.OnboardingPermissionKt;
import com.animaconnected.secondo.screens.onboarding.PermissionState;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.KronabyComposeLightThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackgroundLocationPermissionFragment.kt */
/* loaded from: classes3.dex */
public final class BackgroundLocationPermissionFragmentKt {
    private static final List<String> locationPermissions;

    static {
        List<String> listOf;
        if (Build.VERSION.SDK_INT >= 29) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"});
        } else {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});
        }
        locationPermissions = listOf;
    }

    /* JADX WARN: Type inference failed for: r6v11, types: [com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$BackgroundLocationPermissionContent$3, kotlin.jvm.internal.Lambda] */
    public static final void BackgroundLocationPermissionContent(final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final PermissionState permissionState, Composer composer, final int r22) {
        int r6;
        boolean z;
        int r8;
        int r82;
        int r83;
        int r62;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-798772742);
        if ((r22 & 14) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r62 = 4;
            } else {
                r62 = 2;
            }
            r6 = r62 | r22;
        } else {
            r6 = r22;
        }
        if ((r22 & 112) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                r83 = 32;
            } else {
                r83 = 16;
            }
            r6 |= r83;
        }
        if ((r22 & 896) == 0) {
            if (startRestartGroup.changedInstance(function03)) {
                r82 = 256;
            } else {
                r82 = 128;
            }
            r6 |= r82;
        }
        if ((r22 & 7168) == 0) {
            if (startRestartGroup.changed(permissionState)) {
                r8 = 2048;
            } else {
                r8 = 1024;
            }
            r6 |= r8;
        }
        if ((r6 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            OnboardingPermissionInfo onboardingPermissionInfo = new OnboardingPermissionInfo(URLProtocolKt.stringResource(R.string.location_permission_background_title, startRestartGroup), 0, URLProtocolKt.stringResource(R.string.allow, startRestartGroup), URLProtocolKt.stringResource(R.string.button_label_not_now, startRestartGroup), 2, null);
            startRestartGroup.startReplaceableGroup(-295850260);
            boolean z2 = true;
            if ((r6 & 14) == 4) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (z || nextSlot == composer$Companion$Empty$1) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$BackgroundLocationPermissionContent$1$1
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
                startRestartGroup.updateValue(nextSlot);
            }
            Function0 function04 = (Function0) nextSlot;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-295850202);
            if ((r6 & 112) != 32) {
                z2 = false;
            }
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z2 || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$BackgroundLocationPermissionContent$2$1
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
                        function02.invoke();
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            startRestartGroup.end(false);
            OnboardingPermissionKt.OnboardingPermissionScreen(onboardingPermissionInfo, function04, (Function0) nextSlot2, ComposableLambdaKt.composableLambda(startRestartGroup, 934681952, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$BackgroundLocationPermissionContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r37) {
                    if ((r37 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    PermissionState permissionState2 = PermissionState.this;
                    if (Intrinsics.areEqual(permissionState2, PermissionState.Idle.INSTANCE)) {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier fillMaxHeight = SizeKt.fillMaxHeight(companion, 1.0f);
                        Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
                        composer2.startReplaceableGroup(-483455358);
                        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$SpaceBetween$1, horizontal, composer2);
                        composer2.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                        PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxHeight);
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
                            TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.onboarding_location_permission_description, composer2), null, ((Colors) composer2.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer2.consume(TypographyKt.LocalTypography)).body1, composer2, 0, 0, 65530);
                            composer2.startReplaceableGroup(-483455358);
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, composer2);
                            composer2.startReplaceableGroup(-1323940314);
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                            PersistentCompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
                            if (composer2.getApplier() instanceof Applier) {
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(layoutNode$Companion$Constructor$1);
                                } else {
                                    composer2.useNode();
                                }
                                Updater.m228setimpl(composer2, columnMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                                Updater.m228setimpl(composer2, currentCompositionLocalMap2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                                if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer2, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                                }
                                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf2, new SkippableUpdater(composer2), composer2, 2058660585);
                                BackgroundLocationPermissionFragmentKt.FeatureRow(URLProtocolKt.stringResource(R.string.detail_watch_app_workout_title, composer2), R.drawable.ic_workout, composer2, 48);
                                BackgroundLocationPermissionFragmentKt.FeatureRow(URLProtocolKt.stringResource(R.string.detail_watch_app_weather_title, composer2), R.drawable.ic_weather, composer2, 48);
                                BackgroundLocationPermissionFragmentKt.FeatureRow(URLProtocolKt.stringResource(R.string.behaviour_name_remember_this_spot, composer2), R.drawable.ic_remember_this_spot, composer2, 48);
                                BackgroundLocationPermissionFragmentKt.FeatureRow(URLProtocolKt.stringResource(R.string.behaviour_name_distress, composer2), R.drawable.ic_walk_me_home, composer2, 48);
                                BackgroundLocationPermissionFragmentKt.FeatureRow(URLProtocolKt.stringResource(R.string.settings_lost_watch_title_text, composer2), R.drawable.ic_find_phone, composer2, 48);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                            } else {
                                ComposablesKt.invalidApplier();
                                throw null;
                            }
                        } else {
                            ComposablesKt.invalidApplier();
                            throw null;
                        }
                    } else {
                        if (Intrinsics.areEqual(permissionState2, PermissionState.Granted.INSTANCE) ? true : Intrinsics.areEqual(permissionState2, PermissionState.Denied.INSTANCE)) {
                            function03.invoke();
                        }
                    }
                }
            }), startRestartGroup, 3072);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$BackgroundLocationPermissionContent$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r84) {
                    BackgroundLocationPermissionFragmentKt.BackgroundLocationPermissionContent(function0, function02, function03, permissionState, composer2, Strings.updateChangedFlags(r22 | 1));
                }
            };
        }
    }

    public static final void FeatureRow(final String str, final int r28, Composer composer, final int r30) {
        int r0;
        ComposerImpl composerImpl;
        int r2;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(818807917);
        if ((r30 & 14) == 0) {
            if (startRestartGroup.changed(str)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r30;
        } else {
            r0 = r30;
        }
        if ((r30 & 112) == 0) {
            if (startRestartGroup.changed(r28)) {
                r2 = 32;
            } else {
                r2 = 16;
            }
            r0 |= r2;
        }
        int r21 = r0;
        if ((r21 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 4, 7);
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
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
                Painter painterResource = PainterResources_androidKt.painterResource(r28, startRestartGroup);
                Modifier m75paddingqDBjuR0$default2 = PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 32, 0.0f, 11);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                IconKt.m187Iconww6aTOc(painterResource, str, m75paddingqDBjuR0$default2, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), startRestartGroup, ((r21 << 3) & 112) | 392, 0);
                TextKt.m216Text4IGK_g(str, null, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).body1, startRestartGroup, r21 & 14, 0, 65530);
                composerImpl = startRestartGroup;
                AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$FeatureRow$2
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
                    BackgroundLocationPermissionFragmentKt.FeatureRow(str, r28, composer2, Strings.updateChangedFlags(r30 | 1));
                }
            };
        }
    }

    public static final void FestinaBackgroundLocationPermissionScreen(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-901876577);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableSingletons$BackgroundLocationPermissionFragmentKt.INSTANCE.m952getLambda1$secondo_kronabyRelease(), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$FestinaBackgroundLocationPermissionScreen$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    BackgroundLocationPermissionFragmentKt.FestinaBackgroundLocationPermissionScreen(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final void KronabyBackgroundLocationPermissionScreen(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-15643607);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(KronabyComposeLightThemeProvider.INSTANCE, ComposableSingletons$BackgroundLocationPermissionFragmentKt.INSTANCE.m953getLambda2$secondo_kronabyRelease(), startRestartGroup, KronabyComposeLightThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$KronabyBackgroundLocationPermissionScreen$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    BackgroundLocationPermissionFragmentKt.KronabyBackgroundLocationPermissionScreen(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final void PreviewScreen(Composer composer, final int r8) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(954883173);
        if (r8 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            BackgroundLocationPermissionContent(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$PreviewScreen$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$PreviewScreen$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$PreviewScreen$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, PermissionState.Idle.INSTANCE, startRestartGroup, 3510);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt$PreviewScreen$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    BackgroundLocationPermissionFragmentKt.PreviewScreen(composer2, Strings.updateChangedFlags(r8 | 1));
                }
            };
        }
    }

    public static final /* synthetic */ void access$PreviewScreen(Composer composer, int r1) {
        PreviewScreen(composer, r1);
    }

    public static final List<String> getLocationPermissions() {
        return locationPermissions;
    }
}
