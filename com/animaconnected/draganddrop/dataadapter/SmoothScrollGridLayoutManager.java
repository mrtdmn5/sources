package com.animaconnected.draganddrop.dataadapter;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class SmoothScrollGridLayoutManager extends GridLayoutManager {
    private static final float MILLISECONDS_PER_INCH_FAST = 50.0f;
    private static final float MILLISECONDS_PER_INCH_SLOW = 100.0f;
    private float mScrollSpeed;

    public SmoothScrollGridLayoutManager(Context context, int r4) {
        super(context, r4, 1, false);
        this.mScrollSpeed = MILLISECONDS_PER_INCH_SLOW;
    }

    public void setFastScrollSpeed() {
        this.mScrollSpeed = MILLISECONDS_PER_INCH_FAST;
    }

    public void setSlowScrollSpeed() {
        this.mScrollSpeed = MILLISECONDS_PER_INCH_SLOW;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int r3) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.animaconnected.draganddrop.dataadapter.SmoothScrollGridLayoutManager.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return SmoothScrollGridLayoutManager.this.mScrollSpeed / displayMetrics.densityDpi;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int r2) {
                return SmoothScrollGridLayoutManager.this.computeScrollVectorForPosition(r2);
            }
        };
        linearSmoothScroller.setTargetPosition(r3);
        startSmoothScroll(linearSmoothScroller);
    }
}
