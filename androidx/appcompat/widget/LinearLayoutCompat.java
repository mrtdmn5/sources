package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    public boolean mBaselineAligned;
    public int mBaselineAlignedChildIndex;
    public int mBaselineChildTop;
    public Drawable mDivider;
    public int mDividerHeight;
    public int mDividerPadding;
    public int mDividerWidth;
    public int mGravity;
    public int[] mMaxAscent;
    public int[] mMaxDescent;
    public int mOrientation;
    public int mShowDividers;
    public int mTotalLength;
    public boolean mUseLargestChild;
    public float mWeightSum;

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void drawHorizontalDivider(Canvas canvas, int r6) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, r6, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + r6);
        this.mDivider.draw(canvas);
    }

    public final void drawVerticalDivider(Canvas canvas, int r7) {
        this.mDivider.setBounds(r7, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + r7, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int r3;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int r1 = this.mBaselineAlignedChildIndex;
        if (childCount > r1) {
            View childAt = getChildAt(r1);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.mBaselineAlignedChildIndex == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int r2 = this.mBaselineChildTop;
            if (this.mOrientation == 1 && (r3 = this.mGravity & 112) != 48) {
                if (r3 != 16) {
                    if (r3 == 80) {
                        r2 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                } else {
                    r2 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                }
            }
            return r2 + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public final boolean hasDividerBeforeChildAt(int r5) {
        if (r5 == 0) {
            if ((this.mShowDividers & 1) == 0) {
                return false;
            }
            return true;
        }
        if (r5 == getChildCount()) {
            if ((this.mShowDividers & 4) == 0) {
                return false;
            }
            return true;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int r52 = r5 - 1; r52 >= 0; r52--) {
            if (getChildAt(r52).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int r1;
        int left2;
        int bottom;
        if (this.mDivider == null) {
            return;
        }
        int r2 = 0;
        if (this.mOrientation == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (r2 < virtualChildCount) {
                View childAt = getChildAt(r2);
                if (childAt != null && childAt.getVisibility() != 8 && hasDividerBeforeChildAt(r2)) {
                    drawHorizontalDivider(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin) - this.mDividerHeight);
                }
                r2++;
            }
            if (hasDividerBeforeChildAt(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                if (childAt2 == null) {
                    bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
                } else {
                    bottom = childAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) childAt2.getLayoutParams())).bottomMargin;
                }
                drawHorizontalDivider(canvas, bottom);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        while (r2 < virtualChildCount2) {
            View childAt3 = getChildAt(r2);
            if (childAt3 != null && childAt3.getVisibility() != 8 && hasDividerBeforeChildAt(r2)) {
                LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                if (isLayoutRtl) {
                    left2 = childAt3.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                } else {
                    left2 = (childAt3.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, left2);
            }
            r2++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 == null) {
                if (isLayoutRtl) {
                    right = getPaddingLeft();
                } else {
                    left = getWidth() - getPaddingRight();
                    r1 = this.mDividerWidth;
                    right = left - r1;
                }
            } else {
                LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                if (isLayoutRtl) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    r1 = this.mDividerWidth;
                    right = left - r1;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            }
            drawVerticalDivider(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0199  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r26, int r27, int r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:177:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x08a4  */
    /* JADX WARN: Removed duplicated region for block: B:357:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x06e7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int r3) {
        if (r3 >= 0 && r3 < getChildCount()) {
            this.mBaselineAlignedChildIndex = r3;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        boolean z = false;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        if (drawable == null) {
            z = true;
        }
        setWillNotDraw(z);
        requestLayout();
    }

    public void setDividerPadding(int r1) {
        this.mDividerPadding = r1;
    }

    public void setGravity(int r2) {
        if (this.mGravity != r2) {
            if ((8388615 & r2) == 0) {
                r2 |= 8388611;
            }
            if ((r2 & 112) == 0) {
                r2 |= 48;
            }
            this.mGravity = r2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int r3) {
        int r32 = r3 & 8388615;
        int r1 = this.mGravity;
        if ((8388615 & r1) != r32) {
            this.mGravity = r32 | ((-8388616) & r1);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int r2) {
        if (this.mOrientation != r2) {
            this.mOrientation = r2;
            requestLayout();
        }
    }

    public void setShowDividers(int r2) {
        if (r2 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = r2;
    }

    public void setVerticalGravity(int r3) {
        int r32 = r3 & 112;
        int r0 = this.mGravity;
        if ((r0 & 112) != r32) {
            this.mGravity = r32 | (r0 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int r0 = this.mOrientation;
        if (r0 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (r0 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int r13) {
        super(context, attributeSet, r13);
        Drawable drawable;
        int resourceId;
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        int[] r6 = R$styleable.LinearLayoutCompat;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r6, r13, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, r6, attributeSet, obtainStyledAttributes, r13);
        int r12 = obtainStyledAttributes.getInt(1, -1);
        if (r12 >= 0) {
            setOrientation(r12);
        }
        int r122 = obtainStyledAttributes.getInt(0, -1);
        if (r122 >= 0) {
            setGravity(r122);
        }
        boolean z = obtainStyledAttributes.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(3, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(7, false);
        if (obtainStyledAttributes.hasValue(5) && (resourceId = obtainStyledAttributes.getResourceId(5, 0)) != 0) {
            drawable = AppCompatResources.getDrawable(context, resourceId);
        } else {
            drawable = obtainStyledAttributes.getDrawable(5);
        }
        setDividerDrawable(drawable);
        this.mShowDividers = obtainStyledAttributes.getInt(8, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
