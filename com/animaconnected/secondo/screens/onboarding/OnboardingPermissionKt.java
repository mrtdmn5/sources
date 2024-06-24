package com.animaconnected.secondo.screens.onboarding;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$Bottom$1;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
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
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.PermissionProvider;
import com.animaconnected.widget.ButtonBorderlessKt;
import com.animaconnected.widget.ButtonFilledKt;
import com.animaconnected.widget.ScreenTitleKt;
import com.google.common.base.Strings;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: OnboardingPermission.kt */
/* loaded from: classes3.dex */
public final class OnboardingPermissionKt {
    public static final void OnboardingPermissionScreen(final OnboardingPermissionInfo permissionInfo, final Function0<Unit> onClickAllowPermissions, final Function0<Unit> onClickDenyPermissions, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r30) {
        int r2;
        BiasAlignment.Horizontal horizontal;
        ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1;
        ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1;
        ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1;
        boolean z;
        ComposerImpl composerImpl;
        int r4;
        int r42;
        int r43;
        int r22;
        Intrinsics.checkNotNullParameter(permissionInfo, "permissionInfo");
        Intrinsics.checkNotNullParameter(onClickAllowPermissions, "onClickAllowPermissions");
        Intrinsics.checkNotNullParameter(onClickDenyPermissions, "onClickDenyPermissions");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(539671313);
        if ((r30 & 14) == 0) {
            if (startRestartGroup.changed(permissionInfo)) {
                r22 = 4;
            } else {
                r22 = 2;
            }
            r2 = r22 | r30;
        } else {
            r2 = r30;
        }
        if ((r30 & 112) == 0) {
            if (startRestartGroup.changedInstance(onClickAllowPermissions)) {
                r43 = 32;
            } else {
                r43 = 16;
            }
            r2 |= r43;
        }
        if ((r30 & 896) == 0) {
            if (startRestartGroup.changedInstance(onClickDenyPermissions)) {
                r42 = 256;
            } else {
                r42 = 128;
            }
            r2 |= r42;
        }
        if ((r30 & 7168) == 0) {
            if (startRestartGroup.changedInstance(content)) {
                r4 = 2048;
            } else {
                r4 = 1024;
            }
            r2 |= r4;
        }
        if ((r2 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier m22backgroundbw27NRU$default = BackgroundKt.m22backgroundbw27NRU$default(PaddingKt.m73paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion), 40, 0.0f, 2), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m164getBackground0d7_KjU());
            BiasAlignment.Horizontal horizontal2 = Alignment.Companion.CenterHorizontally;
            Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$SpaceBetween$1, horizontal2, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m22backgroundbw27NRU$default);
            Applier<?> applier = startRestartGroup.applier;
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$12 = ComposeUiNode.Companion.SetMeasurePolicy;
                Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$12);
                ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$12 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$12);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$12);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                SpacerKt.Spacer(SizeKt.fillMaxHeight(companion, 0.1f), startRestartGroup, 6);
                Modifier weight = columnScopeInstance.weight(companion, 2.0f, true);
                startRestartGroup.startReplaceableGroup(-483455358);
                Arrangement$Top$1 arrangement$Top$1 = Arrangement.Top;
                BiasAlignment.Horizontal horizontal3 = Alignment.Companion.Start;
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal3, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, columnMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$12);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$12);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$12);
                    }
                    modifierMaterializerOf2.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    if (permissionInfo.getImageId() == 0) {
                        startRestartGroup.startReplaceableGroup(-1480943218);
                        ScreenTitleKt.ScreenTitle(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 32, 7), permissionInfo.getTitle(), startRestartGroup, 6, 0);
                        startRestartGroup.end(false);
                        horizontal = horizontal3;
                        z = false;
                        composeUiNode$Companion$SetCompositeKeyHash$1 = composeUiNode$Companion$SetCompositeKeyHash$12;
                        composeUiNode$Companion$SetResolvedCompositionLocals$1 = composeUiNode$Companion$SetResolvedCompositionLocals$12;
                        composeUiNode$Companion$SetMeasurePolicy$1 = composeUiNode$Companion$SetMeasurePolicy$12;
                    } else {
                        startRestartGroup.startReplaceableGroup(-1480943056);
                        horizontal = horizontal3;
                        composeUiNode$Companion$SetCompositeKeyHash$1 = composeUiNode$Companion$SetCompositeKeyHash$12;
                        composeUiNode$Companion$SetResolvedCompositionLocals$1 = composeUiNode$Companion$SetResolvedCompositionLocals$12;
                        composeUiNode$Companion$SetMeasurePolicy$1 = composeUiNode$Companion$SetMeasurePolicy$12;
                        ScreenTitleKt.ScreenImageTitle(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 32, 7), permissionInfo.getTitle(), permissionInfo.getImageId(), startRestartGroup, 6, 0);
                        z = false;
                        startRestartGroup.end(false);
                    }
                    content.invoke(startRestartGroup, Integer.valueOf((r2 >> 9) & 14));
                    startRestartGroup.end(z);
                    startRestartGroup.end(true);
                    startRestartGroup.end(z);
                    startRestartGroup.end(z);
                    Modifier weight2 = columnScopeInstance.weight(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 44, 7), 1.0f, true);
                    Arrangement$Bottom$1 arrangement$Bottom$1 = Arrangement.Bottom;
                    startRestartGroup.startReplaceableGroup(-483455358);
                    MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement$Bottom$1, horizontal, startRestartGroup);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                    PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                    ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(weight2);
                    if (applier instanceof Applier) {
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.inserting) {
                            startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Updater.m228setimpl(startRestartGroup, columnMeasurePolicy3, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                            AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        modifierMaterializerOf3.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        int r1 = r2 << 6;
                        ButtonFilledKt.ButtonFilled(null, permissionInfo.getPrimaryButtonText(), false, onClickAllowPermissions, startRestartGroup, r1 & 7168, 5);
                        startRestartGroup.startReplaceableGroup(124797224);
                        if (!StringsKt__StringsJVMKt.isBlank(permissionInfo.getSecondaryButtonText())) {
                            int r16 = (r1 & 57344) | 6;
                            composerImpl = startRestartGroup;
                            ButtonBorderlessKt.ButtonBorderless(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 8, 0.0f, 0.0f, 13), permissionInfo.getSecondaryButtonText(), false, false, onClickDenyPermissions, composerImpl, r16, 12);
                        } else {
                            composerImpl = startRestartGroup;
                        }
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, false, true, false);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, false, true, false);
                        composerImpl.end(false);
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
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingPermissionKt$OnboardingPermissionScreen$2
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
                    OnboardingPermissionKt.OnboardingPermissionScreen(OnboardingPermissionInfo.this, onClickAllowPermissions, onClickDenyPermissions, content, composer2, Strings.updateChangedFlags(r30 | 1));
                }
            };
        }
    }

    public static final boolean arePermissionsGranted(List<String> permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return PermissionProvider.Companion.filterMissingPermissions((String[]) permissions.toArray(new String[0]), KronabyApplication.Companion.getContext()).isEmpty();
    }
}
