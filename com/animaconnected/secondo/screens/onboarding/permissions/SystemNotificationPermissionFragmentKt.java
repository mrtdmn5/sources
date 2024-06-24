package com.animaconnected.secondo.screens.onboarding.permissions;

import android.os.Build;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale$Companion$Crop$1;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimatable;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionResultImpl;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.provider.lottie.LottieKt;
import com.animaconnected.secondo.screens.onboarding.OnboardingPermissionInfo;
import com.animaconnected.secondo.screens.onboarding.OnboardingPermissionKt;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.KronabyComposeLightThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SystemNotificationPermissionFragment.kt */
/* loaded from: classes3.dex */
public final class SystemNotificationPermissionFragmentKt {
    private static final List<String> systemNotificationPermission;

    static {
        List<String> list;
        if (Build.VERSION.SDK_INT >= 33) {
            list = CollectionsKt__CollectionsKt.listOf("android.permission.POST_NOTIFICATIONS");
        } else {
            list = EmptyList.INSTANCE;
        }
        systemNotificationPermission = list;
    }

    public static final void FestinaBackgroundLocationPermissionScreen(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(948815688);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableSingletons$SystemNotificationPermissionFragmentKt.INSTANCE.m960getLambda1$secondo_kronabyRelease(), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt$FestinaBackgroundLocationPermissionScreen$1
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
                    SystemNotificationPermissionFragmentKt.FestinaBackgroundLocationPermissionScreen(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final void KronabyBackgroundLocationPermissionScreen(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1835048658);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(KronabyComposeLightThemeProvider.INSTANCE, ComposableSingletons$SystemNotificationPermissionFragmentKt.INSTANCE.m961getLambda2$secondo_kronabyRelease(), startRestartGroup, KronabyComposeLightThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt$KronabyBackgroundLocationPermissionScreen$1
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
                    SystemNotificationPermissionFragmentKt.KronabyBackgroundLocationPermissionScreen(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final void PreviewScreen(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1489391858);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SystemNotificationPermissionContent(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt$PreviewScreen$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt$PreviewScreen$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 54);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt$PreviewScreen$3
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
                    SystemNotificationPermissionFragmentKt.PreviewScreen(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt$SystemNotificationPermissionContent$3, kotlin.jvm.internal.Lambda] */
    public static final void SystemNotificationPermissionContent(final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int r20) {
        int r4;
        boolean z;
        int r5;
        int r42;
        ComposerImpl startRestartGroup = composer.startRestartGroup(2047635658);
        if ((r20 & 14) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r42 = 4;
            } else {
                r42 = 2;
            }
            r4 = r42 | r20;
        } else {
            r4 = r20;
        }
        if ((r20 & 112) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
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
            final LottieCompositionResultImpl rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(new LottieCompositionSpec.Asset(LottieKt.asSpec(LottieFile.SystemNotificationAccess)), startRestartGroup);
            final LottieAnimatable animateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(SystemNotificationPermissionContent$lambda$0(rememberLottieComposition), false, false, null, 0.0f, Integer.MAX_VALUE, startRestartGroup, 222);
            OnboardingPermissionInfo onboardingPermissionInfo = new OnboardingPermissionInfo(URLProtocolKt.stringResource(R.string.NotificationAuthorization_OnboardingView_Title, startRestartGroup), 0, URLProtocolKt.stringResource(R.string.allow, startRestartGroup), URLProtocolKt.stringResource(R.string.button_label_not_now, startRestartGroup), 2, null);
            startRestartGroup.startReplaceableGroup(-590182492);
            boolean z2 = true;
            if ((r14 & 14) == 4) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (z || nextSlot == composer$Companion$Empty$1) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt$SystemNotificationPermissionContent$1$1
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
            Function0 function03 = (Function0) nextSlot;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-590182434);
            if ((r14 & 112) != 32) {
                z2 = false;
            }
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z2 || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt$SystemNotificationPermissionContent$2$1
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
            OnboardingPermissionKt.OnboardingPermissionScreen(onboardingPermissionInfo, function03, (Function0) nextSlot2, ComposableLambdaKt.composableLambda(startRestartGroup, 495144880, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt$SystemNotificationPermissionContent$3
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
                    LottieComposition SystemNotificationPermissionContent$lambda$0;
                    if ((r44 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    Modifier fillMaxHeight = SizeKt.fillMaxHeight(Modifier.Companion.$$INSTANCE, 1.0f);
                    final LottieAnimationState lottieAnimationState = LottieAnimationState.this;
                    LottieCompositionResult lottieCompositionResult = rememberLottieComposition;
                    composer2.startReplaceableGroup(-483455358);
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
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
                        Updater.m228setimpl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer2), composer2, 2058660585);
                        ContentScale$Companion$Crop$1 contentScale$Companion$Crop$1 = ContentScale.Companion.Crop;
                        SystemNotificationPermissionContent$lambda$0 = SystemNotificationPermissionFragmentKt.SystemNotificationPermissionContent$lambda$0(lottieCompositionResult);
                        composer2.startReplaceableGroup(2120888992);
                        boolean changed = composer2.changed(lottieAnimationState);
                        Object rememberedValue = composer2.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.Empty) {
                            rememberedValue = new Function0<Float>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt$SystemNotificationPermissionContent$3$1$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(LottieAnimationState.this.getProgress());
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        LottieAnimationKt.LottieAnimation(SystemNotificationPermissionContent$lambda$0, (Function0) rememberedValue, null, false, false, false, null, false, null, null, contentScale$Companion$Crop$1, false, composer2, 8, 6, 3068);
                        TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.NotificationAuthorization_OnboardingView_Description, composer2), null, ((Colors) composer2.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer2.consume(TypographyKt.LocalTypography)).body1, composer2, 0, 0, 65530);
                        DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                        return;
                    }
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }), startRestartGroup, 3072);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt$SystemNotificationPermissionContent$4
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
                    SystemNotificationPermissionFragmentKt.SystemNotificationPermissionContent(function0, function02, composer2, Strings.updateChangedFlags(r20 | 1));
                }
            };
        }
    }

    public static final LottieComposition SystemNotificationPermissionContent$lambda$0(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    public static final /* synthetic */ void access$PreviewScreen(Composer composer, int r1) {
        PreviewScreen(composer, r1);
    }

    public static final List<String> getSystemNotificationPermission() {
        return systemNotificationPermission;
    }
}
