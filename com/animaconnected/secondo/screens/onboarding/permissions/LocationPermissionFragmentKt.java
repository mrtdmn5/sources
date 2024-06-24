package com.animaconnected.secondo.screens.onboarding.permissions;

import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationPermissionFragment.kt */
/* loaded from: classes3.dex */
public final class LocationPermissionFragmentKt {
    public static final void BluetoothImage(final Modifier modifier, Composer composer, final int r13, final int r14) {
        int r2;
        int r22;
        ComposerImpl startRestartGroup = composer.startRestartGroup(716087029);
        int r0 = r14 & 1;
        if (r0 != 0) {
            r2 = r13 | 6;
        } else if ((r13 & 14) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r22 = 4;
            } else {
                r22 = 2;
            }
            r2 = r22 | r13;
        } else {
            r2 = r13;
        }
        if ((r2 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (r0 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.bt_image, startRestartGroup), "", SizeKt.wrapContentSize$default(modifier, null, 3), null, ContentScale.Companion.Inside, 0.0f, null, startRestartGroup, 24632, 104);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$BluetoothImage$1
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
                    LocationPermissionFragmentKt.BluetoothImage(Modifier.this, composer2, Strings.updateChangedFlags(r13 | 1), r14);
                }
            };
        }
    }

    public static final void FestinaLocationPermissionScreen(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(2049411387);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableSingletons$LocationPermissionFragmentKt.INSTANCE.m956getLambda1$secondo_kronabyRelease(), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$FestinaLocationPermissionScreen$1
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
                    LocationPermissionFragmentKt.FestinaLocationPermissionScreen(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final void KronabyLocationPermissionScreen(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-456783419);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(KronabyComposeLightThemeProvider.INSTANCE, ComposableSingletons$LocationPermissionFragmentKt.INSTANCE.m957getLambda2$secondo_kronabyRelease(), startRestartGroup, KronabyComposeLightThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$KronabyLocationPermissionScreen$1
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
                    LocationPermissionFragmentKt.KronabyLocationPermissionScreen(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r6v11, types: [com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$LocationPermissionContent$3, kotlin.jvm.internal.Lambda] */
    public static final void LocationPermissionContent(final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final PermissionState permissionState, Composer composer, final int r22) {
        int r6;
        boolean z;
        int r8;
        int r82;
        int r83;
        int r62;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1099201578);
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
            OnboardingPermissionInfo onboardingPermissionInfo = new OnboardingPermissionInfo(URLProtocolKt.stringResource(R.string.onboarding_permission_title, startRestartGroup), 0, URLProtocolKt.stringResource(R.string.allow, startRestartGroup), "", 2, null);
            startRestartGroup.startReplaceableGroup(432190320);
            boolean z2 = true;
            if ((r6 & 14) == 4) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (z || nextSlot == composer$Companion$Empty$1) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$LocationPermissionContent$1$1
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
            startRestartGroup.startReplaceableGroup(432190378);
            if ((r6 & 112) != 32) {
                z2 = false;
            }
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z2 || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$LocationPermissionContent$2$1
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
            OnboardingPermissionKt.OnboardingPermissionScreen(onboardingPermissionInfo, function04, (Function0) nextSlot2, ComposableLambdaKt.composableLambda(startRestartGroup, -1616044484, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$LocationPermissionContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r23) {
                    if ((r23 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    PermissionState permissionState2 = PermissionState.this;
                    boolean areEqual = Intrinsics.areEqual(permissionState2, PermissionState.Idle.INSTANCE);
                    BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                    BiasAlignment.Horizontal horizontal2 = Alignment.Companion.Start;
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    if (areEqual) {
                        composer2.startReplaceableGroup(-1853055697);
                        composer2.startReplaceableGroup(-483455358);
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal2, composer2);
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
                            Updater.m228setimpl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                            }
                            modifierMaterializerOf.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                            composer2.startReplaceableGroup(2058660585);
                            LocationPermissionFragmentKt.BluetoothImage(PaddingKt.m75paddingqDBjuR0$default(new HorizontalAlignElement(horizontal), 0.0f, 0.0f, 0.0f, 56, 7), composer2, 0, 0);
                            LocationPermissionFragmentKt.TextBody1(R.string.onboarding_permission_description1, null, composer2, 6, 2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            return;
                        }
                        ComposablesKt.invalidApplier();
                        throw null;
                    }
                    if (Intrinsics.areEqual(permissionState2, PermissionState.Denied.INSTANCE)) {
                        composer2.startReplaceableGroup(-1853055319);
                        composer2.startReplaceableGroup(-483455358);
                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal2, composer2);
                        composer2.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                        PersistentCompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
                        ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
                        if (composer2.getApplier() instanceof Applier) {
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(layoutNode$Companion$Constructor$12);
                            } else {
                                composer2.useNode();
                            }
                            Updater.m228setimpl(composer2, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                            Updater.m228setimpl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
                            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer2, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$12);
                            }
                            modifierMaterializerOf2.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                            composer2.startReplaceableGroup(2058660585);
                            LocationPermissionFragmentKt.BluetoothImage(PaddingKt.m75paddingqDBjuR0$default(new HorizontalAlignElement(horizontal), 0.0f, 0.0f, 0.0f, 56, 7), composer2, 0, 0);
                            LocationPermissionFragmentKt.TextBody1(R.string.onboarding_permission_description_reason1, null, composer2, 6, 2);
                            LocationPermissionFragmentKt.TextBody1(R.string.onboarding_permission_description_reason2, PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 16, 0.0f, 0.0f, 13), composer2, 54, 0);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            return;
                        }
                        ComposablesKt.invalidApplier();
                        throw null;
                    }
                    if (!Intrinsics.areEqual(permissionState2, PermissionState.Granted.INSTANCE)) {
                        composer2.startReplaceableGroup(-1853054723);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(-1853054746);
                        composer2.endReplaceableGroup();
                        function03.invoke();
                    }
                }
            }), startRestartGroup, 3072);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$LocationPermissionContent$4
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
                    LocationPermissionFragmentKt.LocationPermissionContent(function0, function02, function03, permissionState, composer2, Strings.updateChangedFlags(r22 | 1));
                }
            };
        }
    }

    public static final void PreviewScreen(Composer composer, final int r8) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(559318771);
        if (r8 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            LocationPermissionContent(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$PreviewScreen$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$PreviewScreen$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$PreviewScreen$3
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
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$PreviewScreen$4
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
                    LocationPermissionFragmentKt.PreviewScreen(composer2, Strings.updateChangedFlags(r8 | 1));
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TextBody1(final int r30, androidx.compose.ui.Modifier r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            r0 = r30
            r1 = r33
            r2 = r34
            r3 = 1434690073(0x5583a219, float:1.8091528E13)
            r4 = r32
            androidx.compose.runtime.ComposerImpl r3 = r4.startRestartGroup(r3)
            r4 = r2 & 1
            if (r4 == 0) goto L16
            r4 = r1 | 6
            goto L26
        L16:
            r4 = r1 & 14
            if (r4 != 0) goto L25
            boolean r4 = r3.changed(r0)
            if (r4 == 0) goto L22
            r4 = 4
            goto L23
        L22:
            r4 = 2
        L23:
            r4 = r4 | r1
            goto L26
        L25:
            r4 = r1
        L26:
            r5 = r2 & 2
            if (r5 == 0) goto L2d
            r4 = r4 | 48
            goto L40
        L2d:
            r6 = r1 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L40
            r6 = r31
            boolean r7 = r3.changed(r6)
            if (r7 == 0) goto L3c
            r7 = 32
            goto L3e
        L3c:
            r7 = 16
        L3e:
            r4 = r4 | r7
            goto L42
        L40:
            r6 = r31
        L42:
            r15 = r4
            r4 = r15 & 91
            r7 = 18
            if (r4 != r7) goto L54
            boolean r4 = r3.getSkipping()
            if (r4 != 0) goto L50
            goto L54
        L50:
            r3.skipToGroupEnd()
            goto La1
        L54:
            if (r5 == 0) goto L5b
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion.$$INSTANCE
            r29 = r4
            goto L5d
        L5b:
            r29 = r6
        L5d:
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r4 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            java.lang.String r4 = io.ktor.http.URLProtocolKt.stringResource(r0, r3)
            androidx.compose.runtime.StaticProvidableCompositionLocal r5 = androidx.compose.material.ColorsKt.LocalColors
            java.lang.Object r5 = r3.consume(r5)
            androidx.compose.material.Colors r5 = (androidx.compose.material.Colors) r5
            long r6 = r5.m166getOnBackground0d7_KjU()
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            androidx.compose.runtime.StaticProvidableCompositionLocal r5 = androidx.compose.material.TypographyKt.LocalTypography
            java.lang.Object r5 = r3.consume(r5)
            androidx.compose.material.Typography r5 = (androidx.compose.material.Typography) r5
            androidx.compose.ui.text.TextStyle r5 = r5.body1
            r24 = r5
            r26 = r15 & 112(0x70, float:1.57E-43)
            r27 = 0
            r28 = 65528(0xfff8, float:9.1824E-41)
            r15 = 0
            r5 = r29
            r25 = r3
            androidx.compose.material.TextKt.m216Text4IGK_g(r4, r5, r6, r8, r10, r11, r12, r13, r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r6 = r29
        La1:
            androidx.compose.runtime.RecomposeScopeImpl r3 = r3.endRestartGroup()
            if (r3 == 0) goto Lae
            com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$TextBody1$1 r4 = new com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt$TextBody1$1
            r4.<init>()
            r3.block = r4
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragmentKt.TextBody1(int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final /* synthetic */ void access$PreviewScreen(Composer composer, int r1) {
        PreviewScreen(composer, r1);
    }
}
