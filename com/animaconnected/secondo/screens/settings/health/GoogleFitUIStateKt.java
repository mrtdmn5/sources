package com.animaconnected.secondo.screens.settings.health;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import com.animaconnected.secondo.utils.CustomActivityResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleFitUIState.kt */
/* loaded from: classes3.dex */
public final class GoogleFitUIStateKt {
    public static final GoogleFitUIState rememberGoogleFitUIState(CustomActivityResult<Intent, ActivityResult> activityLauncher, Function1<? super BottomSheetType, Unit> showSheet, Composer composer, int r4) {
        Intrinsics.checkNotNullParameter(activityLauncher, "activityLauncher");
        Intrinsics.checkNotNullParameter(showSheet, "showSheet");
        composer.startReplaceableGroup(-1027586185);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-1610196101);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new GoogleFitUIState(showSheet, activityLauncher);
            composer.updateRememberedValue(rememberedValue);
        }
        GoogleFitUIState googleFitUIState = (GoogleFitUIState) rememberedValue;
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return googleFitUIState;
    }
}
