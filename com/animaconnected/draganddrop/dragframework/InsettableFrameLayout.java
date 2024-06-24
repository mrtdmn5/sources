package com.animaconnected.draganddrop.dragframework;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.animaconnected.draganddrop.R;

/* loaded from: classes.dex */
public class InsettableFrameLayout extends FrameLayout implements ViewGroup.OnHierarchyChangeListener, Insettable {
    private final Rect mInsets;

    public InsettableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setFrameLayoutChildInsets(View view, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (view instanceof Insettable) {
            ((Insettable) view).setInsets(rect);
        } else if (!layoutParams.ignoreInsets) {
            ((FrameLayout.LayoutParams) layoutParams).topMargin = (rect.top - rect2.top) + ((FrameLayout.LayoutParams) layoutParams).topMargin;
            ((FrameLayout.LayoutParams) layoutParams).leftMargin = (rect.left - rect2.left) + ((FrameLayout.LayoutParams) layoutParams).leftMargin;
            ((FrameLayout.LayoutParams) layoutParams).rightMargin = (rect.right - rect2.right) + ((FrameLayout.LayoutParams) layoutParams).rightMargin;
            ((FrameLayout.LayoutParams) layoutParams).bottomMargin = (rect.bottom - rect2.bottom) + ((FrameLayout.LayoutParams) layoutParams).bottomMargin;
        }
        view.setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onChildViewAdded(View view, View view2) {
        setFrameLayoutChildInsets(view2, this.mInsets, new Rect());
    }

    @Override // com.animaconnected.draganddrop.dragframework.Insettable
    public void setInsets(Rect rect) {
        int childCount = getChildCount();
        for (int r1 = 0; r1 < childCount; r1++) {
            setFrameLayoutChildInsets(getChildAt(r1), rect, this.mInsets);
        }
        this.mInsets.set(rect);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        boolean ignoreInsets;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.ignoreInsets = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.InsettableFrameLayout_Layout);
            this.ignoreInsets = obtainStyledAttributes.getBoolean(R.styleable.InsettableFrameLayout_Layout_layout_ignoreInsets, false);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.ignoreInsets = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.ignoreInsets = false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void onChildViewRemoved(View view, View view2) {
    }
}
