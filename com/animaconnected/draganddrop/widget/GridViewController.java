package com.animaconnected.draganddrop.widget;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public class GridViewController {
    private final View mDragAndDropRecyclerView;
    private final View mDragAndDropRecyclerView2;
    private int mDragAndDropRecyclerView2DefaultX;
    private int mDragAndDropRecyclerViewDefaultX;
    private boolean mIsInitiated = false;
    private ObjectAnimator mXDragAndDropRecyclerView2Animator;
    private ObjectAnimator mXDragAndDropRecyclerViewAnimator;

    public GridViewController(View view, View view2) {
        this.mDragAndDropRecyclerView = view;
        this.mDragAndDropRecyclerView2 = view2;
    }

    private static Interpolator createInterpolator() {
        return new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
    }

    private void initiateIfNeeded(int r3) {
        if (!this.mIsInitiated) {
            this.mDragAndDropRecyclerViewDefaultX = Math.round(this.mDragAndDropRecyclerView.getX());
            View view = this.mDragAndDropRecyclerView2;
            view.setX(view.getX() + r3);
            this.mDragAndDropRecyclerView2.setVisibility(0);
            this.mDragAndDropRecyclerView2DefaultX = Math.round(this.mDragAndDropRecyclerView2.getX());
            this.mIsInitiated = true;
        }
    }

    private void startAnimation(float f, float f2, long j) {
        ObjectAnimator objectAnimator = this.mXDragAndDropRecyclerViewAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.mXDragAndDropRecyclerView2Animator;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        if (j <= 0) {
            this.mDragAndDropRecyclerView.setX(f);
            this.mDragAndDropRecyclerView2.setX(f2);
            return;
        }
        View view = this.mDragAndDropRecyclerView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "x", view.getX(), f);
        this.mXDragAndDropRecyclerViewAnimator = ofFloat;
        ofFloat.setDuration(j);
        View view2 = this.mDragAndDropRecyclerView2;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "x", view2.getX(), f2);
        this.mXDragAndDropRecyclerView2Animator = ofFloat2;
        ofFloat2.setDuration(j);
        this.mXDragAndDropRecyclerViewAnimator.setInterpolator(createInterpolator());
        this.mXDragAndDropRecyclerView2Animator.setInterpolator(createInterpolator());
        this.mXDragAndDropRecyclerViewAnimator.start();
        this.mXDragAndDropRecyclerView2Animator.start();
    }

    public void animateRecyclerView(int r3, int r4, int r5) {
        initiateIfNeeded(r4);
        startAnimation(this.mDragAndDropRecyclerViewDefaultX + r3, this.mDragAndDropRecyclerView2DefaultX + r3, r5);
    }

    public boolean isAnimatorRunning() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.mXDragAndDropRecyclerViewAnimator;
        if (objectAnimator2 == null || this.mXDragAndDropRecyclerView2Animator == null) {
            return false;
        }
        if ((objectAnimator2 == null || !objectAnimator2.isRunning()) && ((objectAnimator = this.mXDragAndDropRecyclerView2Animator) == null || !objectAnimator.isRunning())) {
            return false;
        }
        return true;
    }
}
