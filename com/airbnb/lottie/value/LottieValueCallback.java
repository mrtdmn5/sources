package com.airbnb.lottie.value;

import com.airbnb.lottie.SimpleColorFilter;

/* loaded from: classes.dex */
public class LottieValueCallback<T> {
    public final LottieFrameInfo<T> frameInfo;
    public final T value;

    public LottieValueCallback() {
        this.frameInfo = new LottieFrameInfo<>();
        this.value = null;
    }

    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        return this.value;
    }

    public final T getValueInternal(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        LottieFrameInfo<T> lottieFrameInfo = this.frameInfo;
        lottieFrameInfo.startFrame = f;
        lottieFrameInfo.endFrame = f2;
        lottieFrameInfo.startValue = t;
        lottieFrameInfo.endValue = t2;
        lottieFrameInfo.linearKeyframeProgress = f3;
        lottieFrameInfo.interpolatedKeyframeProgress = f4;
        lottieFrameInfo.overallProgress = f5;
        return getValue(lottieFrameInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LottieValueCallback(SimpleColorFilter simpleColorFilter) {
        this.frameInfo = new LottieFrameInfo<>();
        this.value = null;
        this.value = simpleColorFilter;
    }
}
