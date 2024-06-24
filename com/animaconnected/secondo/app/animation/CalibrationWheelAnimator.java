package com.animaconnected.secondo.app.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public final class CalibrationWheelAnimator {
    private static final int FADE_TIME_MS = 1000;
    private static final int TURNS_COUNT = 3;
    private static final float TURN_ANGLE_BEGIN = -1.5707964f;
    private static final float TURN_ANGLE_END = 0.0f;
    private static final int TURN_TIME_MS = 3000;
    private final ValueAnimator mFadeInAnimator;
    private final ValueAnimator mFadeOutAnimator;
    private float mFingerAlphaFade;
    private Listener mListener;
    private boolean mRunning;
    private final ValueAnimator mTurnAnimator;
    private float mWheelAngle;

    /* loaded from: classes.dex */
    public interface Listener {
        void onWheelAnimationEnd(CalibrationWheelAnimator calibrationWheelAnimator);

        void onWheelAnimationUpdate(float f, float f2);
    }

    public CalibrationWheelAnimator() {
        ValueAnimator createFadeAnimator = createFadeAnimator(TURN_ANGLE_END, 1.0f);
        this.mFadeInAnimator = createFadeAnimator;
        createFadeAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.animaconnected.secondo.app.animation.CalibrationWheelAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (CalibrationWheelAnimator.this.mRunning) {
                    CalibrationWheelAnimator.this.mTurnAnimator.start();
                }
            }
        });
        ValueAnimator ofFloat = ValueAnimator.ofFloat(TURN_ANGLE_BEGIN, TURN_ANGLE_END);
        this.mTurnAnimator = ofFloat;
        ofFloat.setDuration(1500L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(3);
        ofFloat.setRepeatMode(2);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.animaconnected.secondo.app.animation.CalibrationWheelAnimator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (CalibrationWheelAnimator.this.mRunning) {
                    CalibrationWheelAnimator.this.mFadeOutAnimator.start();
                }
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.secondo.app.animation.CalibrationWheelAnimator$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CalibrationWheelAnimator.this.lambda$new$0(valueAnimator);
            }
        });
        ValueAnimator createFadeAnimator2 = createFadeAnimator(1.0f, TURN_ANGLE_END);
        this.mFadeOutAnimator = createFadeAnimator2;
        createFadeAnimator2.addListener(new AnimatorListenerAdapter() { // from class: com.animaconnected.secondo.app.animation.CalibrationWheelAnimator.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (CalibrationWheelAnimator.this.mRunning && CalibrationWheelAnimator.this.mListener != null) {
                    CalibrationWheelAnimator.this.mListener.onWheelAnimationEnd(CalibrationWheelAnimator.this);
                }
            }
        });
    }

    private ValueAnimator createFadeAnimator(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.secondo.app.animation.CalibrationWheelAnimator$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CalibrationWheelAnimator.this.lambda$createFadeAnimator$1(valueAnimator);
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createFadeAnimator$1(ValueAnimator valueAnimator) {
        this.mFingerAlphaFade = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        onAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ValueAnimator valueAnimator) {
        this.mWheelAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        onAnimation();
    }

    private void onAnimation() {
        Listener listener;
        if (this.mRunning && (listener = this.mListener) != null) {
            listener.onWheelAnimationUpdate(this.mWheelAngle, this.mFingerAlphaFade);
        }
    }

    public void cancel() {
        this.mRunning = false;
        if (this.mFadeInAnimator.isRunning()) {
            this.mFadeInAnimator.cancel();
        }
        if (this.mTurnAnimator.isRunning()) {
            this.mTurnAnimator.cancel();
        }
        if (this.mFadeOutAnimator.isRunning()) {
            this.mFadeOutAnimator.cancel();
        }
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public void start() {
        this.mWheelAngle = TURN_ANGLE_BEGIN;
        this.mRunning = true;
        this.mFadeInAnimator.start();
    }
}
