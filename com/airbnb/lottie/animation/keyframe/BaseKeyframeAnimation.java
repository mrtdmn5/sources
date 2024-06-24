package com.airbnb.lottie.animation.keyframe;

import android.view.animation.Interpolator;
import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    public final KeyframesWrapper<K> keyframesWrapper;
    public LottieValueCallback<A> valueCallback;
    public final ArrayList listeners = new ArrayList(1);
    public boolean isDiscrete = false;
    public float progress = 0.0f;
    public A cachedGetValue = null;
    public float cachedStartDelayProgress = -1.0f;
    public float cachedEndProgress = -1.0f;

    /* loaded from: classes.dex */
    public interface AnimationListener {
        void onValueChanged();
    }

    /* loaded from: classes.dex */
    public static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final Keyframe<T> getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float getEndProgress() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float getStartDelayProgress() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isCachedValueEnabled(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isEmpty() {
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isValueChanged(float f) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface KeyframesWrapper<T> {
        Keyframe<T> getCurrentKeyframe();

        float getEndProgress();

        float getStartDelayProgress();

        boolean isCachedValueEnabled(float f);

        boolean isEmpty();

        boolean isValueChanged(float f);
    }

    /* loaded from: classes.dex */
    public static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {
        public Keyframe<T> cachedCurrentKeyframe = null;
        public float cachedInterpolatedProgress = -1.0f;
        public Keyframe<T> currentKeyframe = findKeyframe(0.0f);
        public final List<? extends Keyframe<T>> keyframes;

        public KeyframesWrapperImpl(List<? extends Keyframe<T>> list) {
            this.keyframes = list;
        }

        public final Keyframe<T> findKeyframe(float f) {
            List<? extends Keyframe<T>> list = this.keyframes;
            Keyframe<T> keyframe = list.get(list.size() - 1);
            if (f >= keyframe.getStartProgress()) {
                return keyframe;
            }
            int size = list.size() - 2;
            while (true) {
                boolean z = false;
                if (size >= 1) {
                    Keyframe<T> keyframe2 = list.get(size);
                    if (this.currentKeyframe != keyframe2) {
                        if (f >= keyframe2.getStartProgress() && f < keyframe2.getEndProgress()) {
                            z = true;
                        }
                        if (z) {
                            return keyframe2;
                        }
                    }
                    size--;
                } else {
                    return list.get(0);
                }
            }
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final Keyframe<T> getCurrentKeyframe() {
            return this.currentKeyframe;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float getEndProgress() {
            return this.keyframes.get(r0.size() - 1).getEndProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float getStartDelayProgress() {
            return this.keyframes.get(0).getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isCachedValueEnabled(float f) {
            Keyframe<T> keyframe = this.cachedCurrentKeyframe;
            Keyframe<T> keyframe2 = this.currentKeyframe;
            if (keyframe == keyframe2 && this.cachedInterpolatedProgress == f) {
                return true;
            }
            this.cachedCurrentKeyframe = keyframe2;
            this.cachedInterpolatedProgress = f;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isValueChanged(float f) {
            boolean z;
            Keyframe<T> keyframe = this.currentKeyframe;
            if (f >= keyframe.getStartProgress() && f < keyframe.getEndProgress()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return !this.currentKeyframe.isStatic();
            }
            this.currentKeyframe = findKeyframe(f);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {
        public float cachedInterpolatedProgress = -1.0f;
        public final Keyframe<T> keyframe;

        public SingleKeyframeWrapper(List<? extends Keyframe<T>> list) {
            this.keyframe = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final Keyframe<T> getCurrentKeyframe() {
            return this.keyframe;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float getEndProgress() {
            return this.keyframe.getEndProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float getStartDelayProgress() {
            return this.keyframe.getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isCachedValueEnabled(float f) {
            if (this.cachedInterpolatedProgress == f) {
                return true;
            }
            this.cachedInterpolatedProgress = f;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isValueChanged(float f) {
            return !this.keyframe.isStatic();
        }
    }

    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        KeyframesWrapper keyframesWrapperImpl;
        KeyframesWrapper keyframesWrapper;
        if (list.isEmpty()) {
            keyframesWrapper = new EmptyKeyframeWrapper();
        } else {
            if (list.size() == 1) {
                keyframesWrapperImpl = new SingleKeyframeWrapper(list);
            } else {
                keyframesWrapperImpl = new KeyframesWrapperImpl(list);
            }
            keyframesWrapper = keyframesWrapperImpl;
        }
        this.keyframesWrapper = keyframesWrapper;
    }

    public final void addUpdateListener(AnimationListener animationListener) {
        this.listeners.add(animationListener);
    }

    public final Keyframe<K> getCurrentKeyframe() {
        Keyframe<K> currentKeyframe = this.keyframesWrapper.getCurrentKeyframe();
        L.endSection();
        return currentKeyframe;
    }

    public float getEndProgress() {
        if (this.cachedEndProgress == -1.0f) {
            this.cachedEndProgress = this.keyframesWrapper.getEndProgress();
        }
        return this.cachedEndProgress;
    }

    public final float getInterpolatedCurrentKeyframeProgress() {
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe != null && !currentKeyframe.isStatic()) {
            return currentKeyframe.interpolator.getInterpolation(getLinearCurrentKeyframeProgress());
        }
        return 0.0f;
    }

    public final float getLinearCurrentKeyframeProgress() {
        if (this.isDiscrete) {
            return 0.0f;
        }
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return (this.progress - currentKeyframe.getStartProgress()) / (currentKeyframe.getEndProgress() - currentKeyframe.getStartProgress());
    }

    public A getValue() {
        A value;
        Interpolator interpolator;
        float linearCurrentKeyframeProgress = getLinearCurrentKeyframeProgress();
        if (this.valueCallback == null && this.keyframesWrapper.isCachedValueEnabled(linearCurrentKeyframeProgress)) {
            return this.cachedGetValue;
        }
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        Interpolator interpolator2 = currentKeyframe.xInterpolator;
        if (interpolator2 != null && (interpolator = currentKeyframe.yInterpolator) != null) {
            value = getValue(currentKeyframe, linearCurrentKeyframeProgress, interpolator2.getInterpolation(linearCurrentKeyframeProgress), interpolator.getInterpolation(linearCurrentKeyframeProgress));
        } else {
            value = getValue(currentKeyframe, getInterpolatedCurrentKeyframeProgress());
        }
        this.cachedGetValue = value;
        return value;
    }

    public abstract A getValue(Keyframe<K> keyframe, float f);

    public void notifyListeners() {
        int r0 = 0;
        while (true) {
            ArrayList arrayList = this.listeners;
            if (r0 < arrayList.size()) {
                ((AnimationListener) arrayList.get(r0)).onValueChanged();
                r0++;
            } else {
                return;
            }
        }
    }

    public void setProgress(float f) {
        KeyframesWrapper<K> keyframesWrapper = this.keyframesWrapper;
        if (keyframesWrapper.isEmpty()) {
            return;
        }
        if (this.cachedStartDelayProgress == -1.0f) {
            this.cachedStartDelayProgress = keyframesWrapper.getStartDelayProgress();
        }
        float f2 = this.cachedStartDelayProgress;
        if (f < f2) {
            if (f2 == -1.0f) {
                this.cachedStartDelayProgress = keyframesWrapper.getStartDelayProgress();
            }
            f = this.cachedStartDelayProgress;
        } else if (f > getEndProgress()) {
            f = getEndProgress();
        }
        if (f == this.progress) {
            return;
        }
        this.progress = f;
        if (keyframesWrapper.isValueChanged(f)) {
            notifyListeners();
        }
    }

    public final void setValueCallback(LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.valueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.getClass();
        }
        this.valueCallback = lottieValueCallback;
    }

    public A getValue(Keyframe<K> keyframe, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }
}
