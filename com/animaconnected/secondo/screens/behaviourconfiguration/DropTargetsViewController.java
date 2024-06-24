package com.animaconnected.secondo.screens.behaviourconfiguration;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.animaconnected.watch.provider.DateTimeFormattersKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DropTargetsViewController {
    private final View mDropTarget;
    private int mDropTargetDefaultX;
    private int mDropTargetDefaultY;
    private final View mDropTargetDoubleCrown;
    private int mDropTargetDoubleCrownDefaultX;
    private boolean mIsDoubleCrownInitiated;
    private boolean mIsInitiated = false;
    private ObjectAnimator mXDropTargetAnimator;
    private ObjectAnimator mYDropTargetAnimator;

    public DropTargetsViewController(View view, View view2) {
        this.mDropTarget = view;
        this.mDropTargetDoubleCrown = view2;
    }

    private static Interpolator createInterpolator() {
        return new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
    }

    private void initiateDropTargetDoubleCrownIfNeeded(boolean z) {
        View view;
        if (!this.mIsDoubleCrownInitiated && z && (view = this.mDropTargetDoubleCrown) != null) {
            int[] r0 = new int[2];
            view.getLocationInWindow(r0);
            this.mDropTargetDoubleCrownDefaultX = r0[0];
            this.mIsDoubleCrownInitiated = true;
        }
    }

    private void initiateDropTargetIfNeeded() {
        if (!this.mIsInitiated) {
            this.mDropTargetDefaultX = Math.round(this.mDropTarget.getX());
            this.mDropTargetDefaultY = Math.round(this.mDropTarget.getY());
            this.mIsInitiated = true;
        }
    }

    private void startAnimation(float f, float f2, int r6, boolean z, long j) {
        View view = this.mDropTargetDoubleCrown;
        if (view != null && z) {
            view.setX(this.mDropTargetDoubleCrownDefaultX + r6);
        }
        ObjectAnimator objectAnimator = this.mXDropTargetAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.mYDropTargetAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        if (j <= 0) {
            this.mDropTarget.setX(f);
            this.mDropTarget.setY(f2);
            return;
        }
        View view2 = this.mDropTarget;
        this.mXDropTargetAnimator = ObjectAnimator.ofFloat(view2, "x", view2.getX(), f);
        View view3 = this.mDropTarget;
        this.mYDropTargetAnimator = ObjectAnimator.ofFloat(view3, DateTimeFormattersKt.yearNoPaddingFormat, view3.getY(), f2);
        this.mXDropTargetAnimator.setDuration(j);
        this.mYDropTargetAnimator.setDuration(j);
        this.mXDropTargetAnimator.setInterpolator(createInterpolator());
        this.mYDropTargetAnimator.setInterpolator(createInterpolator());
        this.mXDropTargetAnimator.start();
        this.mYDropTargetAnimator.start();
    }

    public void animateDropTargets(int r9, int r10, int r11) {
        initiateDropTargetIfNeeded();
        startAnimation(this.mDropTargetDefaultX + r9, this.mDropTargetDefaultY + r10, 0, false, r11);
    }

    public void animateDropTargets(int r9, int r10, int r11, boolean z, int r13) {
        initiateDropTargetIfNeeded();
        initiateDropTargetDoubleCrownIfNeeded(z);
        startAnimation(this.mDropTargetDefaultX + r9, this.mDropTargetDefaultY + r10, r11, z, r13);
    }
}
