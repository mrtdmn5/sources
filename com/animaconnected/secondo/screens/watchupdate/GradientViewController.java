package com.animaconnected.secondo.screens.watchupdate;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.animaconnected.watch.provider.DateTimeFormattersKt;

/* loaded from: classes3.dex */
public class GradientViewController {
    private final View mGradientBottom;
    private int mGradientBottomDefaultX;
    private int mGradientBottomDefaultY;
    private final View mGradientTop;
    private int mGradientTopDefaultX;
    private int mGradientTopDefaultY;
    private boolean mIsInitiated = false;
    private ObjectAnimator mXGradientBottomAnimator;
    private ObjectAnimator mXGradientTopAnimator;
    private ObjectAnimator mYGradientBottomAnimator;
    private ObjectAnimator mYGradientTopAnimator;

    public GradientViewController(View view, View view2) {
        this.mGradientTop = view;
        this.mGradientBottom = view2;
    }

    private static Interpolator createInterpolator() {
        return new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
    }

    private void initiateIfNeeded() {
        if (!this.mIsInitiated) {
            this.mGradientTopDefaultX = Math.round(this.mGradientTop.getX());
            this.mGradientTopDefaultY = Math.round(this.mGradientTop.getY());
            this.mGradientBottomDefaultX = Math.round(this.mGradientBottom.getX());
            this.mGradientBottomDefaultY = Math.round(this.mGradientBottom.getY());
            this.mIsInitiated = true;
        }
    }

    private void startAnimation(float f, float f2, float f3, float f4, long j) {
        ObjectAnimator objectAnimator = this.mXGradientTopAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.mYGradientTopAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.mXGradientBottomAnimator;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        ObjectAnimator objectAnimator4 = this.mYGradientBottomAnimator;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
        if (j <= 0) {
            this.mGradientTop.setX(f);
            this.mGradientTop.setY(f2);
            this.mGradientBottom.setX(f3);
            this.mGradientBottom.setY(f4);
            return;
        }
        View view = this.mGradientTop;
        this.mXGradientTopAnimator = ObjectAnimator.ofFloat(view, "x", view.getX(), f);
        View view2 = this.mGradientTop;
        this.mYGradientTopAnimator = ObjectAnimator.ofFloat(view2, DateTimeFormattersKt.yearNoPaddingFormat, view2.getY(), f2);
        this.mXGradientTopAnimator.setDuration(j);
        this.mYGradientTopAnimator.setDuration(j);
        View view3 = this.mGradientBottom;
        this.mXGradientBottomAnimator = ObjectAnimator.ofFloat(view3, "x", view3.getX(), f3);
        View view4 = this.mGradientBottom;
        this.mYGradientBottomAnimator = ObjectAnimator.ofFloat(view4, DateTimeFormattersKt.yearNoPaddingFormat, view4.getY(), f4);
        this.mXGradientBottomAnimator.setDuration(j);
        this.mYGradientBottomAnimator.setDuration(j);
        this.mXGradientTopAnimator.setInterpolator(createInterpolator());
        this.mYGradientTopAnimator.setInterpolator(createInterpolator());
        this.mXGradientBottomAnimator.setInterpolator(createInterpolator());
        this.mYGradientBottomAnimator.setInterpolator(createInterpolator());
        this.mXGradientTopAnimator.start();
        this.mYGradientTopAnimator.start();
        this.mXGradientBottomAnimator.start();
        this.mYGradientBottomAnimator.start();
    }

    public void animateGradient(int r9, int r10, int r11) {
        initiateIfNeeded();
        startAnimation(this.mGradientTopDefaultX + r9, this.mGradientTopDefaultY + r10, this.mGradientBottomDefaultX + r9, this.mGradientBottomDefaultY + r10, r11);
    }
}
