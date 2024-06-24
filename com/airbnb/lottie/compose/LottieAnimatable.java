package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieComposition;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: LottieAnimatable.kt */
/* loaded from: classes.dex */
public interface LottieAnimatable extends LottieAnimationState {

    /* compiled from: LottieAnimatable.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
    }

    Object animate(LottieComposition lottieComposition, int r2, int r3, float f, LottieClipSpec lottieClipSpec, float f2, boolean z, LottieCancellationBehavior lottieCancellationBehavior, Continuation continuation);

    Object snapTo(LottieComposition lottieComposition, float f, int r3, boolean z, Continuation<? super Unit> continuation);
}
