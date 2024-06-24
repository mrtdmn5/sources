package com.animaconnected.draganddrop.dragframework;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.dragframework.InsettableFrameLayout;
import com.animaconnected.draganddrop.utils.Utilities;

/* loaded from: classes.dex */
public class DragLayer extends InsettableFrameLayout {
    private static final int ANIMATION_END_DISAPPEAR = 0;
    private static final int ANIMATION_END_REMAIN_VISIBLE = 2;
    private static final int DROPVIEW_FADE_DURATION = 150;
    private View mAnchorView;
    private int mAnchorViewInitialScrollX;
    private int mChildCountOnLastUpdate;
    private final TimeInterpolator mCubicEaseOutInterpolator;
    private DragController mDragController;
    private ValueAnimator mDropAnim;
    private DragView mDropView;
    private final TimeInterpolator mLinearInterpolator;
    private ValueAnimator mRemovedDropAnim;
    private DragViewRemove mRemovedDropView;
    private final int[] mTmpXY;
    private int mTopViewIndex;

    public DragLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTmpXY = new int[2];
        this.mDropAnim = null;
        this.mRemovedDropAnim = null;
        this.mDropView = null;
        this.mRemovedDropView = null;
        this.mAnchorViewInitialScrollX = 0;
        this.mAnchorView = null;
        this.mChildCountOnLastUpdate = -1;
        this.mCubicEaseOutInterpolator = new DecelerateInterpolator(1.5f);
        this.mLinearInterpolator = new LinearInterpolator();
        setMotionEventSplittingEnabled(false);
        setChildrenDrawingOrderEnabled(true);
    }

    private void animateRemovedView(final DragViewRemove dragViewRemove, final Rect rect, final Rect rect2, final float f, boolean z, final float f2, final float f3, final float f4, final float f5, int r28, final Interpolator interpolator, final Interpolator interpolator2, Runnable runnable, int r32, View view) {
        int r15;
        float hypot = (float) Math.hypot(rect2.left - rect.left, rect2.top - rect.top);
        Resources resources = getResources();
        float integer = resources.getInteger(R.integer.config_dropAnimMaxDist);
        if (r28 < 0) {
            int integer2 = resources.getInteger(R.integer.config_dropAnimMaxDuration);
            if (hypot < integer) {
                integer2 = (int) (this.mCubicEaseOutInterpolator.getInterpolation(hypot / integer) * integer2);
            }
            r15 = Math.max(integer2, resources.getInteger(R.integer.config_dropAnimMinDuration));
        } else {
            r15 = r28;
        }
        TimeInterpolator timeInterpolator = interpolator == null ? this.mCubicEaseOutInterpolator : null;
        final float alpha = dragViewRemove.getAlpha();
        final float scaleX = dragViewRemove.getScaleX();
        animateRemovedView(dragViewRemove, new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.draganddrop.dragframework.DragLayer$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DragLayer.this.lambda$animateRemovedView$3(dragViewRemove, interpolator2, interpolator, f2, scaleX, f3, f4, f5, f, alpha, rect, rect2, valueAnimator);
            }
        }, z, r15, timeInterpolator, runnable, r32, view);
    }

    private void animateView(final DragView dragView, final Rect rect, final Rect rect2, final float f, boolean z, final float f2, final float f3, final float f4, final float f5, int r28, final Interpolator interpolator, final Interpolator interpolator2, Runnable runnable, int r32, View view) {
        int r15;
        float hypot = (float) Math.hypot(rect2.left - rect.left, rect2.top - rect.top);
        Resources resources = getResources();
        float integer = resources.getInteger(R.integer.config_dropAnimMaxDist);
        if (r28 < 0) {
            int integer2 = resources.getInteger(R.integer.config_dropAnimMaxDuration);
            if (hypot < integer) {
                integer2 = (int) (this.mCubicEaseOutInterpolator.getInterpolation(hypot / integer) * integer2);
            }
            r15 = Math.max(integer2, resources.getInteger(R.integer.config_dropAnimMinDuration));
        } else {
            r15 = r28;
        }
        TimeInterpolator timeInterpolator = interpolator == null ? this.mCubicEaseOutInterpolator : null;
        final float alpha = dragView.getAlpha();
        final float scaleX = dragView.getScaleX();
        animateView(dragView, new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.draganddrop.dragframework.DragLayer$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DragLayer.this.lambda$animateView$1(dragView, interpolator2, interpolator, f2, scaleX, f3, f4, f5, f, alpha, rect, rect2, valueAnimator);
            }
        }, z, r15, timeInterpolator, runnable, r32, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnimatedView() {
        ValueAnimator valueAnimator = this.mDropAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        DragView dragView = this.mDropView;
        if (dragView != null) {
            this.mDragController.onDeferredEndDrag(dragView);
        }
        this.mDropView = null;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRemovedAnimatedView() {
        ValueAnimator valueAnimator = this.mRemovedDropAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        DragViewRemove dragViewRemove = this.mRemovedDropView;
        if (dragViewRemove != null) {
            this.mDragController.onDeferredEndDrag(dragViewRemove);
        }
        this.mRemovedDropView = null;
        invalidate();
    }

    private float getDescendantCoordRelativeToSelf(View view, int[] r3) {
        return getDescendantCoordRelativeToSelf(view, r3, false);
    }

    private void getViewRectRelativeToSelf(View view, Rect rect) {
        int[] r0 = new int[2];
        getLocationInWindow(r0);
        int r2 = r0[0];
        int r4 = r0[1];
        view.getLocationInWindow(r0);
        int r1 = r0[0] - r2;
        int r02 = r0[1] - r4;
        rect.set(r1, r02, view.getMeasuredWidth() + r1, view.getMeasuredHeight() + r02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateRemovedView$3(DragViewRemove dragViewRemove, Interpolator interpolator, Interpolator interpolator2, float f, float f2, float f3, float f4, float f5, float f6, float f7, Rect rect, Rect rect2, ValueAnimator valueAnimator) {
        float interpolation;
        float interpolation2;
        int scaleX;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int measuredWidth = dragViewRemove.getMeasuredWidth();
        int measuredHeight = dragViewRemove.getMeasuredHeight();
        if (interpolator == null) {
            interpolation = this.mLinearInterpolator.getInterpolation(floatValue);
        } else {
            interpolation = interpolator.getInterpolation(floatValue);
        }
        if (interpolator2 == null) {
            interpolation2 = floatValue;
        } else {
            interpolation2 = interpolator2.getInterpolation(floatValue);
        }
        float f8 = f * f2;
        float f9 = f3 * f2;
        float f10 = 1.0f - floatValue;
        float f11 = (f8 * f10) + (f4 * floatValue);
        float f12 = (f10 * f9) + (floatValue * f5);
        float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(1.0f, interpolation, f7, f6 * interpolation);
        int round = (int) ((((f8 - 1.0f) * measuredWidth) / 2.0f) + rect.left + Math.round((rect2.left - r8) * interpolation2));
        int round2 = (int) ((((f9 - 1.0f) * measuredHeight) / 2.0f) + rect.top + Math.round((rect2.top - r9) * interpolation2));
        View view = this.mAnchorView;
        if (view == null) {
            scaleX = 0;
        } else {
            scaleX = (int) (view.getScaleX() * (this.mAnchorViewInitialScrollX - this.mAnchorView.getScrollX()));
        }
        int scrollX = (round - this.mRemovedDropView.getScrollX()) + scaleX;
        int scrollY = round2 - this.mRemovedDropView.getScrollY();
        this.mRemovedDropView.setTranslationX(scrollX);
        this.mRemovedDropView.setTranslationY(scrollY);
        this.mRemovedDropView.setScaleX(f11);
        this.mRemovedDropView.setScaleY(f12);
        this.mRemovedDropView.setAlpha(m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$animateRemovedViewIntoPosition$2(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateView$1(DragView dragView, Interpolator interpolator, Interpolator interpolator2, float f, float f2, float f3, float f4, float f5, float f6, float f7, Rect rect, Rect rect2, ValueAnimator valueAnimator) {
        float interpolation;
        float interpolation2;
        int scaleX;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int measuredWidth = dragView.getMeasuredWidth();
        int measuredHeight = dragView.getMeasuredHeight();
        if (interpolator == null) {
            interpolation = this.mLinearInterpolator.getInterpolation(floatValue);
        } else {
            interpolation = interpolator.getInterpolation(floatValue);
        }
        if (interpolator2 == null) {
            interpolation2 = floatValue;
        } else {
            interpolation2 = interpolator2.getInterpolation(floatValue);
        }
        float f8 = f * f2;
        float f9 = f3 * f2;
        float f10 = 1.0f - floatValue;
        float f11 = (f8 * f10) + (f4 * floatValue);
        float f12 = (f10 * f9) + (floatValue * f5);
        float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(1.0f, interpolation, f7, f6 * interpolation);
        int round = (int) ((((f8 - 1.0f) * measuredWidth) / 2.0f) + rect.left + Math.round((rect2.left - r8) * interpolation2));
        int round2 = (int) ((((f9 - 1.0f) * measuredHeight) / 2.0f) + rect.top + Math.round((rect2.top - r9) * interpolation2));
        View view = this.mAnchorView;
        if (view == null) {
            scaleX = 0;
        } else {
            scaleX = (int) (view.getScaleX() * (this.mAnchorViewInitialScrollX - this.mAnchorView.getScrollX()));
        }
        int scrollX = (round - this.mDropView.getScrollX()) + scaleX;
        int scrollY = round2 - this.mDropView.getScrollY();
        this.mDropView.setTranslationX(scrollX);
        this.mDropView.setTranslationY(scrollY);
        this.mDropView.setScaleX(f11);
        this.mDropView.setScaleY(f12);
        this.mDropView.setAlpha(m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$animateViewIntoPosition$0(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    private void updateChildIndices() {
        this.mTopViewIndex = -1;
        int childCount = getChildCount();
        for (int r1 = 0; r1 < childCount; r1++) {
            if (getChildAt(r1) instanceof DragView) {
                this.mTopViewIndex = r1;
            }
        }
        this.mChildCountOnLastUpdate = childCount;
    }

    public DragViewRemove addRemoveView(Context context, Bitmap bitmap, int r16, int r17, Point point, Rect rect, float f) {
        DragViewRemove dragViewRemove = new DragViewRemove(context, bitmap, r16, r17, 0, 0, bitmap.getWidth(), bitmap.getHeight(), f);
        if (point != null) {
            dragViewRemove.setDragVisualizeOffset(new Point(point));
        }
        if (rect != null) {
            dragViewRemove.setDragRegion(new Rect(rect));
        }
        addView(dragViewRemove);
        dragViewRemove.show(r16, r17);
        return dragViewRemove;
    }

    public void animateRemovedViewIntoPosition(DragViewRemove dragViewRemove, View view, float f, boolean z, int r21, final Runnable runnable, View view2, boolean z2) {
        int height;
        int r4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        Rect rect = new Rect();
        getViewRectRelativeToSelf(dragViewRemove, rect);
        float scaleX = view.getScaleX();
        float f2 = 1.0f - scaleX;
        int[] r42 = {((int) view.getX()) + ((int) ((view.getMeasuredWidth() * f2) / 2.0f)), ((int) view.getY()) + ((int) ((view.getMeasuredHeight() * f2) / 2.0f))};
        float descendantCoordRelativeToSelf = getDescendantCoordRelativeToSelf((View) view.getParent(), r42) * scaleX;
        if (!z2) {
            int r2 = r42[0];
            int r3 = r42[1];
            r4 = r2;
            height = r3;
        } else {
            Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            int width = (point.x / 2) - (view.getWidth() / 2);
            height = (view.getHeight() / 2) + point.y;
            r4 = width;
        }
        animateRemovedViewIntoPosition(dragViewRemove, rect.left, rect.top, r4, height, f, z, 1.0f, 1.0f, descendantCoordRelativeToSelf, descendantCoordRelativeToSelf, new Runnable() { // from class: com.animaconnected.draganddrop.dragframework.DragLayer$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                DragLayer.lambda$animateRemovedViewIntoPosition$2(runnable);
            }
        }, 0, r21, view2);
    }

    public void animateViewIntoPosition(DragView dragView, View view, float f, boolean z, int r21, final Runnable runnable, View view2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        Rect rect = new Rect();
        getViewRectRelativeToSelf(dragView, rect);
        float scaleX = view.getScaleX();
        float f2 = 1.0f - scaleX;
        int[] r4 = {((int) view.getX()) + ((int) ((view.getMeasuredWidth() * f2) / 2.0f)), ((int) view.getY()) + ((int) ((view.getMeasuredHeight() * f2) / 2.0f))};
        float descendantCoordRelativeToSelf = getDescendantCoordRelativeToSelf((View) view.getParent(), r4) * scaleX;
        int r3 = r4[0];
        animateViewIntoPosition(dragView, rect.left, rect.top, r3 - (Math.round((dragView.getMeasuredWidth() - view.getMeasuredWidth()) * descendantCoordRelativeToSelf) / 2), r4[1] - (Math.round((dragView.getHeight() - view.getMeasuredHeight()) * descendantCoordRelativeToSelf) / 2), f, z, 1.0f, 1.0f, descendantCoordRelativeToSelf, descendantCoordRelativeToSelf, new Runnable() { // from class: com.animaconnected.draganddrop.dragframework.DragLayer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DragLayer.lambda$animateViewIntoPosition$0(runnable);
            }
        }, 0, r21, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        updateChildIndices();
    }

    @Override // com.animaconnected.draganddrop.dragframework.InsettableFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r3, int r4) {
        if (this.mChildCountOnLastUpdate != r3) {
            updateChildIndices();
        }
        int r0 = this.mTopViewIndex;
        if (r0 == -1) {
            return r4;
        }
        if (r4 == r3 - 1) {
            return r0;
        }
        if (r4 < r0) {
            return r4;
        }
        return r4 + 1;
    }

    public float getDescendantRectRelativeToSelf(View view, Rect rect) {
        int[] r0 = this.mTmpXY;
        r0[0] = 0;
        r0[1] = 0;
        float descendantCoordRelativeToSelf = getDescendantCoordRelativeToSelf(view, r0);
        int[] r3 = this.mTmpXY;
        int r1 = r3[0];
        rect.set(r1, r3[1], (int) ((view.getMeasuredWidth() * descendantCoordRelativeToSelf) + r1), (int) ((view.getMeasuredHeight() * descendantCoordRelativeToSelf) + this.mTmpXY[1]));
        return descendantCoordRelativeToSelf;
    }

    public float getLocationInDragLayer(View view, int[] r4) {
        r4[0] = 0;
        r4[1] = 0;
        return getDescendantCoordRelativeToSelf(view, r4);
    }

    public float mapCoordInSelfToDescendent(View view, int[] r2) {
        return Utilities.mapCoordInSelfToDescendent(view, this, r2);
    }

    @Override // com.animaconnected.draganddrop.dragframework.InsettableFrameLayout, android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        super.onChildViewAdded(view, view2);
        updateChildIndices();
    }

    @Override // com.animaconnected.draganddrop.dragframework.InsettableFrameLayout, android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        updateChildIndices();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mDragController.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int r4, int r5, int r6, int r7) {
        super.onLayout(z, r4, r5, r6, r7);
        int childCount = getChildCount();
        for (int r42 = 0; r42 < childCount; r42++) {
            View childAt = getChildAt(r42);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (layoutParams2.customPosition) {
                    int r72 = layoutParams2.x;
                    int r0 = layoutParams2.y;
                    childAt.layout(r72, r0, ((FrameLayout.LayoutParams) layoutParams2).width + r72, ((FrameLayout.LayoutParams) layoutParams2).height + r0);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mDragController.onTouchEvent(motionEvent);
    }

    public void setup(DragController dragController) {
        this.mDragController = dragController;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends InsettableFrameLayout.LayoutParams {
        public boolean customPosition;
        public int x;
        public int y;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.customPosition = false;
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.customPosition = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.customPosition = false;
        }
    }

    private float getDescendantCoordRelativeToSelf(View view, int[] r2, boolean z) {
        return Utilities.getDescendantCoordRelativeToParent(view, this, r2, z);
    }

    @Override // com.animaconnected.draganddrop.dragframework.InsettableFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // com.animaconnected.draganddrop.dragframework.InsettableFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // com.animaconnected.draganddrop.dragframework.InsettableFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    private void animateRemovedView(DragViewRemove dragViewRemove, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, final boolean z, int r5, TimeInterpolator timeInterpolator, final Runnable runnable, final int r8, View view) {
        ValueAnimator valueAnimator = this.mRemovedDropAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mRemovedDropView = dragViewRemove;
        dragViewRemove.resetLayoutParams();
        if (view != null) {
            this.mAnchorViewInitialScrollX = view.getScrollX();
        }
        this.mAnchorView = view;
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.mRemovedDropAnim = valueAnimator2;
        valueAnimator2.setInterpolator(timeInterpolator);
        this.mRemovedDropAnim.setDuration(r5);
        this.mRemovedDropAnim.setFloatValues(0.0f, 1.0f);
        this.mRemovedDropAnim.addUpdateListener(animatorUpdateListener);
        this.mRemovedDropAnim.addListener(new AnimatorListenerAdapter() { // from class: com.animaconnected.draganddrop.dragframework.DragLayer.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    DragLayer.this.mRemovedDropView.animate().alpha(0.0f).setDuration(150L).setListener(new AnimatorListenerAdapter() { // from class: com.animaconnected.draganddrop.dragframework.DragLayer.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2) {
                            Runnable runnable2 = runnable;
                            if (runnable2 != null) {
                                runnable2.run();
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (r8 == 0) {
                                DragLayer.this.clearRemovedAnimatedView();
                            }
                        }
                    });
                    return;
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                if (r8 == 0) {
                    DragLayer.this.clearRemovedAnimatedView();
                }
            }
        });
        this.mRemovedDropAnim.start();
    }

    private void animateView(DragView dragView, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, final boolean z, int r5, TimeInterpolator timeInterpolator, final Runnable runnable, final int r8, View view) {
        ValueAnimator valueAnimator = this.mDropAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mDropView = dragView;
        dragView.cancelAnimation();
        this.mDropView.resetLayoutParams();
        if (view != null) {
            this.mAnchorViewInitialScrollX = view.getScrollX();
        }
        this.mAnchorView = view;
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.mDropAnim = valueAnimator2;
        valueAnimator2.setInterpolator(timeInterpolator);
        this.mDropAnim.setDuration(r5);
        this.mDropAnim.setFloatValues(0.0f, 1.0f);
        this.mDropAnim.addUpdateListener(animatorUpdateListener);
        this.mDropAnim.addListener(new AnimatorListenerAdapter() { // from class: com.animaconnected.draganddrop.dragframework.DragLayer.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    DragLayer.this.mDropView.animate().alpha(0.0f).setDuration(150L).setListener(new AnimatorListenerAdapter() { // from class: com.animaconnected.draganddrop.dragframework.DragLayer.1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2) {
                            Runnable runnable2 = runnable;
                            if (runnable2 != null) {
                                runnable2.run();
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (r8 == 0) {
                                DragLayer.this.clearAnimatedView();
                            }
                        }
                    });
                    return;
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                if (r8 == 0) {
                    DragLayer.this.clearAnimatedView();
                }
            }
        });
        this.mDropAnim.start();
    }

    private void animateViewIntoPosition(DragView dragView, int r18, int r19, int r20, int r21, float f, boolean z, float f2, float f3, float f4, float f5, Runnable runnable, int r29, int r30, View view) {
        animateView(dragView, new Rect(r18, r19, dragView.getMeasuredWidth() + r18, dragView.getMeasuredHeight() + r19), new Rect(r20, r21, dragView.getMeasuredWidth() + r20, dragView.getMeasuredHeight() + r21), f, z, f2, f3, f4, f5, r30, null, null, runnable, r29, view);
    }

    private void animateRemovedViewIntoPosition(DragViewRemove dragViewRemove, int r18, int r19, int r20, int r21, float f, boolean z, float f2, float f3, float f4, float f5, Runnable runnable, int r29, int r30, View view) {
        animateRemovedView(dragViewRemove, new Rect(r18, r19, dragViewRemove.getMeasuredWidth() + r18, dragViewRemove.getMeasuredHeight() + r19), new Rect(r20, r21, dragViewRemove.getMeasuredWidth() + r20, dragViewRemove.getMeasuredHeight() + r21), f, z, f2, f3, f4, f5, r30, null, null, runnable, r29, view);
    }
}
