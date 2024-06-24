package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat$Api17Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.R$styleable;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class FlowLayout extends ViewGroup {
    public int itemSpacing;
    public int lineSpacing;
    public int rowCount;
    public boolean singleLine;

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getLineSpacing() {
        return this.lineSpacing;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r12, int r13, int r14, int r15) {
        boolean z2;
        int paddingLeft;
        int paddingRight;
        int r5;
        int r6;
        if (getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }
        this.rowCount = 1;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api17Impl.getLayoutDirection(this) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (z2) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int r142 = (r14 - r12) - paddingRight;
        int r3 = paddingLeft;
        int r122 = paddingTop;
        for (int r1 = 0; r1 < getChildCount(); r1++) {
            View childAt = getChildAt(r1);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    r6 = MarginLayoutParamsCompat$Api17Impl.getMarginStart(marginLayoutParams);
                    r5 = MarginLayoutParamsCompat$Api17Impl.getMarginEnd(marginLayoutParams);
                } else {
                    r5 = 0;
                    r6 = 0;
                }
                int measuredWidth = childAt.getMeasuredWidth() + r3 + r6;
                if (!this.singleLine && measuredWidth > r142) {
                    r122 = this.lineSpacing + paddingTop;
                    this.rowCount++;
                    r3 = paddingLeft;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.rowCount - 1));
                int r2 = r3 + r6;
                int measuredWidth2 = childAt.getMeasuredWidth() + r2;
                int measuredHeight = childAt.getMeasuredHeight() + r122;
                if (z2) {
                    childAt.layout(r142 - measuredWidth2, r122, (r142 - r3) - r6, measuredHeight);
                } else {
                    childAt.layout(r2, r122, measuredWidth2, measuredHeight);
                }
                r3 += childAt.getMeasuredWidth() + r6 + r5 + this.itemSpacing;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int r20, int r21) {
        int r7;
        int r8;
        int r6;
        int r10;
        int size = View.MeasureSpec.getSize(r20);
        int mode = View.MeasureSpec.getMode(r20);
        int size2 = View.MeasureSpec.getSize(r21);
        int mode2 = View.MeasureSpec.getMode(r21);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            r7 = Integer.MAX_VALUE;
        } else {
            r7 = size;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = r7 - getPaddingRight();
        int r11 = paddingTop;
        int r13 = 0;
        for (int r12 = 0; r12 < getChildCount(); r12++) {
            View childAt = getChildAt(r12);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, r20, r21);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    r10 = marginLayoutParams.leftMargin + 0;
                    r6 = marginLayoutParams.rightMargin + 0;
                } else {
                    r6 = 0;
                    r10 = 0;
                }
                if (childAt.getMeasuredWidth() + paddingLeft + r10 > paddingRight && !isSingleLine()) {
                    paddingLeft = getPaddingLeft();
                    r11 = this.lineSpacing + paddingTop;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + r10;
                int measuredHeight = childAt.getMeasuredHeight() + r11;
                if (measuredWidth > r13) {
                    r13 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + r10 + r6 + this.itemSpacing + paddingLeft;
                if (r12 == getChildCount() - 1) {
                    r13 += r6;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + r13;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode != Integer.MIN_VALUE) {
            r8 = 1073741824;
            if (mode != 1073741824) {
                size = paddingRight2;
            }
        } else {
            r8 = 1073741824;
            size = Math.min(paddingRight2, size);
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != r8) {
                size2 = paddingBottom;
            }
        } else {
            size2 = Math.min(paddingBottom, size2);
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int r1) {
        this.itemSpacing = r1;
    }

    public void setLineSpacing(int r1) {
        this.lineSpacing = r1;
    }

    public void setSingleLine(boolean z) {
        this.singleLine = z;
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int r4) {
        super(context, attributeSet, r4);
        this.singleLine = false;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FlowLayout, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }
}
