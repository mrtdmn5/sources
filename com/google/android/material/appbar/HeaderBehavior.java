package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    public int activePointerId;
    public FlingRunnable flingRunnable;
    public boolean isBeingDragged;
    public int lastMotionY;
    public OverScroller scroller;
    public int touchSlop;
    public VelocityTracker velocityTracker;

    /* loaded from: classes3.dex */
    public class FlingRunnable implements Runnable {
        public final V layout;
        public final CoordinatorLayout parent;

        public FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.parent = coordinatorLayout;
            this.layout = v;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HeaderBehavior headerBehavior;
            OverScroller overScroller;
            V v = this.layout;
            if (v != null && (overScroller = (headerBehavior = HeaderBehavior.this).scroller) != null) {
                boolean computeScrollOffset = overScroller.computeScrollOffset();
                CoordinatorLayout coordinatorLayout = this.parent;
                if (computeScrollOffset) {
                    headerBehavior.setHeaderTopBottomOffset(coordinatorLayout, v, headerBehavior.scroller.getCurrY());
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api16Impl.postOnAnimation(v, this);
                    return;
                }
                headerBehavior.onFlingFinished(v, coordinatorLayout);
            }
        }
    }

    public HeaderBehavior() {
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    public boolean canDragView(V v) {
        return false;
    }

    public int getMaxDragOffset(V v) {
        return -v.getHeight();
    }

    public int getScrollRangeForDragFling(V v) {
        return v.getHeight();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z;
        int findPointerIndex;
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.isBeingDragged) {
            int r0 = this.activePointerId;
            if (r0 == -1 || (findPointerIndex = motionEvent.findPointerIndex(r0)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.lastMotionY) > this.touchSlop) {
                this.lastMotionY = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.activePointerId = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (canDragView(v) && coordinatorLayout.isPointInChildBounds(v, x, y2)) {
                z = true;
            } else {
                z = false;
            }
            this.isBeingDragged = z;
            if (z) {
                this.lastMotionY = y2;
                this.activePointerId = motionEvent.getPointerId(0);
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.scroller;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.scroller.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r20, V r21, android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, View view, int r9) {
        setHeaderTopBottomOffset(coordinatorLayout, view, r9, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int r3, int r4, int r5) {
        int clamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (r4 == 0 || topAndBottomOffset < r4 || topAndBottomOffset > r5 || topAndBottomOffset == (clamp = MathUtils.clamp(r3, r4, r5))) {
            return 0;
        }
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            if (viewOffsetHelper.offsetTop != clamp) {
                viewOffsetHelper.offsetTop = clamp;
                viewOffsetHelper.applyOffsets();
            }
        } else {
            this.tempTopBottomOffset = clamp;
        }
        return topAndBottomOffset - clamp;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    public void onFlingFinished(View view, CoordinatorLayout coordinatorLayout) {
    }
}
