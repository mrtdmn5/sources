package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes3.dex */
public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public int tempTopBottomOffset;
    public ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
        this.tempTopBottomOffset = 0;
    }

    public final int getTopAndBottomOffset() {
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.offsetTop;
        }
        return 0;
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public void layoutChild(CoordinatorLayout coordinatorLayout, V v, int r3) {
        coordinatorLayout.onLayoutChild(r3, v);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int r3) {
        layoutChild(coordinatorLayout, v, r3);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new ViewOffsetHelper(v);
        }
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        View view = viewOffsetHelper.view;
        viewOffsetHelper.layoutTop = view.getTop();
        viewOffsetHelper.layoutLeft = view.getLeft();
        this.viewOffsetHelper.applyOffsets();
        int r1 = this.tempTopBottomOffset;
        if (r1 != 0) {
            ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
            if (viewOffsetHelper2.offsetTop != r1) {
                viewOffsetHelper2.offsetTop = r1;
                viewOffsetHelper2.applyOffsets();
            }
            this.tempTopBottomOffset = 0;
            return true;
        }
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
    }
}
