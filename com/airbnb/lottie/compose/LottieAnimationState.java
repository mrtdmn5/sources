package com.airbnb.lottie.compose;

import androidx.compose.runtime.State;
import com.airbnb.lottie.LottieComposition;

/* compiled from: LottieAnimationState.kt */
/* loaded from: classes.dex */
public interface LottieAnimationState extends State<Float> {
    LottieClipSpec getClipSpec();

    LottieComposition getComposition();

    int getIteration();

    float getProgress();

    float getSpeed();
}
