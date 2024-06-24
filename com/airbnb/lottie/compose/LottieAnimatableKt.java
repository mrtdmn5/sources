package com.airbnb.lottie.compose;

import androidx.compose.runtime.Composer;
import com.airbnb.lottie.LottieComposition;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* compiled from: LottieAnimatable.kt */
/* loaded from: classes.dex */
public final class LottieAnimatableKt {
    public static final float defaultProgress(LottieComposition lottieComposition, LottieClipSpec lottieClipSpec, float f) {
        if (f >= 0.0f || lottieComposition != null) {
            if (lottieComposition == null) {
                return 0.0f;
            }
            if (f < 0.0f) {
                if (lottieClipSpec != null) {
                    return lottieClipSpec.getMaxProgress$lottie_compose_release(lottieComposition);
                }
            } else {
                if (lottieClipSpec == null) {
                    return 0.0f;
                }
                return lottieClipSpec.getMinProgress$lottie_compose_release(lottieComposition);
            }
        }
        return 1.0f;
    }

    public static final LottieAnimatable rememberLottieAnimatable(Composer composer) {
        composer.startReplaceableGroup(-610207901);
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new LottieAnimatableImpl();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LottieAnimatable lottieAnimatable = (LottieAnimatable) rememberedValue;
        composer.endReplaceableGroup();
        return lottieAnimatable;
    }

    public static final Object resetToBeginning(LottieAnimatable lottieAnimatable, Continuation<? super Unit> continuation) {
        boolean z;
        float defaultProgress = defaultProgress(lottieAnimatable.getComposition(), lottieAnimatable.getClipSpec(), lottieAnimatable.getSpeed());
        LottieComposition composition = lottieAnimatable.getComposition();
        if (defaultProgress == lottieAnimatable.getProgress()) {
            z = true;
        } else {
            z = false;
        }
        Object snapTo = lottieAnimatable.snapTo(composition, defaultProgress, 1, !z, continuation);
        if (snapTo == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return snapTo;
        }
        return Unit.INSTANCE;
    }
}
