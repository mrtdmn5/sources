package com.animaconnected.secondo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public class DynamicHeightViewPager extends ViewPager {
    public DynamicHeightViewPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int r6, int r7) {
        int r2 = 0;
        for (int r1 = 0; r1 < getChildCount(); r1++) {
            View childAt = getChildAt(r1);
            childAt.measure(r6, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > r2) {
                r2 = measuredHeight;
            }
        }
        if (r2 != 0) {
            r7 = View.MeasureSpec.makeMeasureSpec(r2, 1073741824);
        }
        super.onMeasure(r6, r7);
    }

    public DynamicHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
