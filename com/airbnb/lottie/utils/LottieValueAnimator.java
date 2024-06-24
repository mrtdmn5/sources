package com.airbnb.lottie.utils;

import android.animation.Animator;
import android.graphics.PointF;
import android.view.Choreographer;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    public LottieComposition composition;
    public float speed = 1.0f;
    public boolean speedReversedForRepeatMode = false;
    public long lastFrameTimeNs = 0;
    public float frame = 0.0f;
    public int repeatCount = 0;
    public float minFrame = -2.1474836E9f;
    public float maxFrame = 2.1474836E9f;
    public boolean running = false;

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
        }
        notifyEnd(isReversed());
        removeFrameCallback(true);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        float minFrame;
        float maxFrame;
        boolean z = false;
        if (this.running) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null && this.running) {
            long j2 = this.lastFrameTimeNs;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            float abs = ((float) j3) / ((1.0E9f / lottieComposition.frameRate) / Math.abs(this.speed));
            float f = this.frame;
            if (isReversed()) {
                abs = -abs;
            }
            float f2 = f + abs;
            this.frame = f2;
            float minFrame2 = getMinFrame();
            float maxFrame2 = getMaxFrame();
            PointF pointF = MiscUtils.pathFromDataCurrentPoint;
            if (f2 >= minFrame2 && f2 <= maxFrame2) {
                z = true;
            }
            boolean z2 = !z;
            this.frame = MiscUtils.clamp(this.frame, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = j;
            notifyUpdate();
            if (z2) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    if (this.speed < 0.0f) {
                        maxFrame = getMinFrame();
                    } else {
                        maxFrame = getMaxFrame();
                    }
                    this.frame = maxFrame;
                    removeFrameCallback(true);
                    notifyEnd(isReversed());
                } else {
                    Iterator it = this.listeners.iterator();
                    while (it.hasNext()) {
                        ((Animator.AnimatorListener) it.next()).onAnimationRepeat(this);
                    }
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                        this.speed = -this.speed;
                    } else {
                        if (isReversed()) {
                            minFrame = getMaxFrame();
                        } else {
                            minFrame = getMinFrame();
                        }
                        this.frame = minFrame;
                    }
                    this.lastFrameTimeNs = j;
                }
            }
            if (this.composition != null) {
                float f3 = this.frame;
                if (f3 < this.minFrame || f3 > this.maxFrame) {
                    throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)));
                }
            }
            L.endSection();
        }
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        float minFrame;
        float maxFrame;
        float minFrame2;
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            minFrame = getMaxFrame() - this.frame;
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        } else {
            minFrame = this.frame - getMinFrame();
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        }
        return minFrame / (maxFrame - minFrame2);
    }

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue() {
        float f;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            f = 0.0f;
        } else {
            float f2 = this.frame;
            float f3 = lottieComposition.startFrame;
            f = (f2 - f3) / (lottieComposition.endFrame - f3);
        }
        return Float.valueOf(f);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return r0.getDuration();
    }

    public final float getMaxFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.maxFrame;
        if (f == 2.1474836E9f) {
            return lottieComposition.endFrame;
        }
        return f;
    }

    public final float getMinFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.minFrame;
        if (f == -2.1474836E9f) {
            return lottieComposition.startFrame;
        }
        return f;
    }

    public final boolean isReversed() {
        if (this.speed < 0.0f) {
            return true;
        }
        return false;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        return this.running;
    }

    public final void removeFrameCallback(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }

    public final void setFrame(float f) {
        if (this.frame == f) {
            return;
        }
        this.frame = MiscUtils.clamp(f, getMinFrame(), getMaxFrame());
        this.lastFrameTimeNs = 0L;
        notifyUpdate();
    }

    public final void setMinAndMaxFrames(float f, float f2) {
        float f3;
        float f4;
        if (f <= f2) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                f3 = -3.4028235E38f;
            } else {
                f3 = lottieComposition.startFrame;
            }
            if (lottieComposition == null) {
                f4 = Float.MAX_VALUE;
            } else {
                f4 = lottieComposition.endFrame;
            }
            float clamp = MiscUtils.clamp(f, f3, f4);
            float clamp2 = MiscUtils.clamp(f2, f3, f4);
            if (clamp != this.minFrame || clamp2 != this.maxFrame) {
                this.minFrame = clamp;
                this.maxFrame = clamp2;
                setFrame((int) MiscUtils.clamp(this.frame, clamp, clamp2));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
    }

    @Override // android.animation.ValueAnimator
    public final void setRepeatMode(int r2) {
        super.setRepeatMode(r2);
        if (r2 != 2 && this.speedReversedForRepeatMode) {
            this.speedReversedForRepeatMode = false;
            this.speed = -this.speed;
        }
    }
}
