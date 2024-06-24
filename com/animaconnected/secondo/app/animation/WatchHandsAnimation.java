package com.animaconnected.secondo.app.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public class WatchHandsAnimation {
    private static final float ANIMATION_TIME_PER_DEGREE_MS = 5.5555553f;
    private static final float ANIMATION_TIME_PER_FULL_LAP_MS = 2000.0f;
    private static final float MIN_ANIMATION_TIME_MS = 700.0f;
    private ObjectAnimator mWatchHandHoursAnimator;
    private final View mWatchHandHoursView;
    private ObjectAnimator mWatchHandMinutesAnimator;
    private final View mWatchHandMinutesView;
    private WatchHandModel mWatchHandModel;

    /* loaded from: classes.dex */
    public interface WatchHandModel {
        float getHoursInDegrees();

        float getMinutesInDegrees();
    }

    public WatchHandsAnimation(View view, View view2, WatchHandModel watchHandModel) {
        this.mWatchHandMinutesView = view;
        this.mWatchHandHoursView = view2;
        this.mWatchHandModel = watchHandModel;
    }

    private void cancelOngoingAnimations() {
        ObjectAnimator objectAnimator = this.mWatchHandMinutesAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mWatchHandMinutesAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.mWatchHandHoursAnimator;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.mWatchHandHoursAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAnimations$0(ValueAnimator valueAnimator) {
        updateViewFlip(this.mWatchHandMinutesView, ((Float) valueAnimator.getAnimatedValue("rotation")).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAnimations$1(ValueAnimator valueAnimator) {
        updateViewFlip(this.mWatchHandHoursView, ((Float) valueAnimator.getAnimatedValue("rotation")).floatValue());
    }

    private void startAnimations() {
        cancelOngoingAnimations();
        View view = this.mWatchHandMinutesView;
        if (view != null) {
            float rotation = view.getRotation();
            if (rotation > 360.0f) {
                rotation -= 360.0f;
            }
            float minutesInDegrees = this.mWatchHandModel.getMinutesInDegrees();
            if (minutesInDegrees < rotation - 1.0E-4f) {
                minutesInDegrees += 360.0f;
            }
            float max = Math.max(MIN_ANIMATION_TIME_MS, Math.abs(rotation - minutesInDegrees) * ANIMATION_TIME_PER_DEGREE_MS);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mWatchHandMinutesView, "rotation", rotation, minutesInDegrees);
            this.mWatchHandMinutesAnimator = ofFloat;
            ofFloat.setDuration(max);
            this.mWatchHandMinutesAnimator.setInterpolator(new DecelerateInterpolator());
            this.mWatchHandMinutesAnimator.start();
            this.mWatchHandMinutesAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.secondo.app.animation.WatchHandsAnimation$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    WatchHandsAnimation.this.lambda$startAnimations$0(valueAnimator);
                }
            });
        }
        View view2 = this.mWatchHandHoursView;
        if (view2 != null) {
            float rotation2 = view2.getRotation();
            if (rotation2 > 360.0f) {
                rotation2 -= 360.0f;
            }
            float hoursInDegrees = this.mWatchHandModel.getHoursInDegrees();
            if (hoursInDegrees < rotation2 - 1.0E-4f) {
                hoursInDegrees += 360.0f;
            }
            float max2 = Math.max(MIN_ANIMATION_TIME_MS, Math.abs(rotation2 - hoursInDegrees) * ANIMATION_TIME_PER_DEGREE_MS);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mWatchHandHoursView, "rotation", rotation2, hoursInDegrees);
            this.mWatchHandHoursAnimator = ofFloat2;
            ofFloat2.setDuration(max2);
            this.mWatchHandHoursAnimator.setInterpolator(new DecelerateInterpolator());
            this.mWatchHandHoursAnimator.start();
            this.mWatchHandHoursAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.secondo.app.animation.WatchHandsAnimation$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    WatchHandsAnimation.this.lambda$startAnimations$1(valueAnimator);
                }
            });
        }
    }

    private void updateViewFlip(View view, float f) {
        if (f >= 165.0f && f <= 345.0f) {
            view.setScaleX(-1.0f);
        } else {
            view.setScaleX(1.0f);
        }
    }

    public void setWatchHandModel(WatchHandModel watchHandModel) {
        this.mWatchHandModel = watchHandModel;
    }

    public void update(boolean z) {
        cancelOngoingAnimations();
        if (z) {
            startAnimations();
            return;
        }
        if (this.mWatchHandMinutesView != null) {
            float minutesInDegrees = this.mWatchHandModel.getMinutesInDegrees();
            this.mWatchHandMinutesView.setRotation(minutesInDegrees);
            updateViewFlip(this.mWatchHandMinutesView, minutesInDegrees);
        }
        if (this.mWatchHandHoursView != null) {
            float hoursInDegrees = this.mWatchHandModel.getHoursInDegrees();
            this.mWatchHandHoursView.setRotation(hoursInDegrees);
            updateViewFlip(this.mWatchHandHoursView, hoursInDegrees);
        }
    }
}
