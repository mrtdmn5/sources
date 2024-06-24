package com.airbnb.lottie.compose;

import android.content.Context;
import android.provider.Settings;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.google.common.collect.Platform;
import kotlin.jvm.functions.Function2;

/* compiled from: animateLottieCompositionAsState.kt */
/* loaded from: classes.dex */
public final class AnimateLottieCompositionAsStateKt {
    public static final LottieAnimatable animateLottieCompositionAsState(LottieComposition lottieComposition, boolean z, boolean z2, LottieClipSpec lottieClipSpec, float f, int r20, Composer composer, int r22) {
        boolean z3;
        boolean z4;
        LottieClipSpec lottieClipSpec2;
        float f2;
        int r8;
        boolean z5;
        composer.startReplaceableGroup(-180607952);
        boolean z6 = true;
        if ((r22 & 2) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((r22 & 4) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
        LottieCancellationBehavior lottieCancellationBehavior = null;
        if ((r22 & 8) != 0) {
            lottieClipSpec2 = null;
        } else {
            lottieClipSpec2 = lottieClipSpec;
        }
        if ((r22 & 16) != 0) {
            f2 = 1.0f;
        } else {
            f2 = f;
        }
        if ((r22 & 32) != 0) {
            r8 = 1;
        } else {
            r8 = r20;
        }
        if ((r22 & 64) != 0) {
            lottieCancellationBehavior = LottieCancellationBehavior.Immediately;
        }
        LottieCancellationBehavior lottieCancellationBehavior2 = lottieCancellationBehavior;
        if (r8 > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            if (Float.isInfinite(f2) || Float.isNaN(f2)) {
                z6 = false;
            }
            if (z6) {
                LottieAnimatable rememberLottieAnimatable = LottieAnimatableKt.rememberLottieAnimatable(composer);
                composer.startReplaceableGroup(-3687241);
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.Empty) {
                    rememberedValue = Platform.mutableStateOf$default(Boolean.valueOf(z3));
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                MutableState mutableState = (MutableState) rememberedValue;
                composer.startReplaceableGroup(-180607189);
                Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.LocalContext);
                Utils.AnonymousClass1 anonymousClass1 = Utils.threadLocalPathMeasure;
                float f3 = f2 / Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
                composer.endReplaceableGroup();
                EffectsKt.LaunchedEffect(new Object[]{lottieComposition, Boolean.valueOf(z3), lottieClipSpec2, Float.valueOf(f3), Integer.valueOf(r8)}, (Function2) new AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3(z3, z4, rememberLottieAnimatable, lottieComposition, r8, f3, lottieClipSpec2, lottieCancellationBehavior2, mutableState, null), composer);
                composer.endReplaceableGroup();
                return rememberLottieAnimatable;
            }
            throw new IllegalArgumentException(("Speed must be a finite number. It is " + f2 + '.').toString());
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Iterations must be a positive number (", r8, ").").toString());
    }
}
