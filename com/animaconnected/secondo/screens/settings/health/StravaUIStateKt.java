package com.animaconnected.secondo.screens.settings.health;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: StravaUIState.kt */
/* loaded from: classes3.dex */
public final class StravaUIStateKt {
    private static final String KEY_BADGE = "KEY_STRAVA_BADGE";
    private static final String STORAGE_NAME = "STRAVA_UI_STORAGE";

    public static final StravaUIState rememberStravaUIState(Function1<? super BottomSheetType, Unit> showSheet, CoroutineScope coroutineScope, Composer composer, int r3, int r4) {
        Intrinsics.checkNotNullParameter(showSheet, "showSheet");
        composer.startReplaceableGroup(1395827747);
        int r32 = r4 & 2;
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (r32 != 0) {
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == composer$Companion$Empty$1) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).coroutineScope;
            composer.endReplaceableGroup();
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(1045032359);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == composer$Companion$Empty$1) {
            rememberedValue2 = new StravaUIState(showSheet, coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        StravaUIState stravaUIState = (StravaUIState) rememberedValue2;
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stravaUIState;
    }
}
