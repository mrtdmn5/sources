package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat$Api17Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    public int overlayTop;
    public final Rect tempRect1;
    public final Rect tempRect2;
    public int verticalLayoutGap;

    public HeaderScrollingViewBehavior() {
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    public abstract AppBarLayout findFirstDependency$1(ArrayList arrayList);

    public float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    public int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public final void layoutChild(CoordinatorLayout coordinatorLayout, View view, int r19) {
        AppBarLayout findFirstDependency$1 = findFirstDependency$1(coordinatorLayout.getDependencies(view));
        int r3 = 0;
        if (findFirstDependency$1 != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            int paddingLeft = coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int bottom = findFirstDependency$1.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            int bottom2 = ((findFirstDependency$1.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            Rect rect = this.tempRect1;
            rect.set(paddingLeft, bottom, width, bottom2);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (ViewCompat.Api16Impl.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.Api16Impl.getFitsSystemWindows(view)) {
                    rect.left = lastWindowInsets.getSystemWindowInsetLeft() + rect.left;
                    rect.right -= lastWindowInsets.getSystemWindowInsetRight();
                }
            }
            Rect rect2 = this.tempRect2;
            int r4 = layoutParams.gravity;
            if (r4 == 0) {
                r4 = 8388659;
            }
            GravityCompat$Api17Impl.apply(r4, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, r19);
            if (this.overlayTop != 0) {
                float overlapRatioForOffset = getOverlapRatioForOffset(findFirstDependency$1);
                int r6 = this.overlayTop;
                r3 = MathUtils.clamp((int) (overlapRatioForOffset * r6), 0, r6);
            }
            view.layout(rect2.left, rect2.top - r3, rect2.right, rect2.bottom - r3);
            this.verticalLayoutGap = rect2.top - findFirstDependency$1.getBottom();
            return;
        }
        coordinatorLayout.onLayoutChild(r19, view);
        this.verticalLayoutGap = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int r8, int r9, int r10) {
        AppBarLayout findFirstDependency$1;
        int r102;
        WindowInsetsCompat lastWindowInsets;
        int r0 = view.getLayoutParams().height;
        if ((r0 == -1 || r0 == -2) && (findFirstDependency$1 = findFirstDependency$1(coordinatorLayout.getDependencies(view))) != null) {
            int size = View.MeasureSpec.getSize(r10);
            if (size > 0) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (ViewCompat.Api16Impl.getFitsSystemWindows(findFirstDependency$1) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.getSystemWindowInsetBottom() + lastWindowInsets.getSystemWindowInsetTop();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            int scrollRange = (getScrollRange(findFirstDependency$1) + size) - findFirstDependency$1.getMeasuredHeight();
            if (r0 == -1) {
                r102 = 1073741824;
            } else {
                r102 = Integer.MIN_VALUE;
            }
            coordinatorLayout.onMeasureChild(view, r8, r9, View.MeasureSpec.makeMeasureSpec(scrollRange, r102));
            return true;
        }
        return false;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }
}
