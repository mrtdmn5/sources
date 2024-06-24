package com.animaconnected.secondo.screens.notification.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.animaconnected.draganddrop.ContainerLayout;
import com.animaconnected.secondo.R;

/* loaded from: classes3.dex */
public class FillLayout extends LinearLayout implements ContainerLayout {
    private int mContentSpace;
    private int mCustomGroup;
    private int mFillBackgroundColor;
    private int mNumberOfItems;
    private int mSelectedBackgroundColor;

    public FillLayout(Context context) {
        super(context);
        this.mFillBackgroundColor = -9257756;
        this.mSelectedBackgroundColor = -9257756;
        this.mNumberOfItems = 1;
        this.mContentSpace = 0;
        this.mCustomGroup = -1;
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.FillLayout, 0, 0);
            try {
                this.mNumberOfItems = obtainStyledAttributes.getInteger(3, this.mNumberOfItems);
                this.mFillBackgroundColor = obtainStyledAttributes.getInteger(1, this.mFillBackgroundColor);
                this.mContentSpace = obtainStyledAttributes.getDimensionPixelSize(0, 0);
                this.mSelectedBackgroundColor = obtainStyledAttributes.getInteger(4, this.mSelectedBackgroundColor);
                this.mCustomGroup = obtainStyledAttributes.getInteger(2, -1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setBackgroundColor(this.mFillBackgroundColor);
    }

    @Override // com.animaconnected.draganddrop.ContainerLayout
    public int getContentSpace() {
        return this.mContentSpace;
    }

    @Override // com.animaconnected.draganddrop.ContainerLayout
    public int getCustomGroup() {
        return this.mCustomGroup;
    }

    @Override // com.animaconnected.draganddrop.ContainerLayout
    public int getNumberOfItems() {
        return this.mNumberOfItems;
    }

    @Override // com.animaconnected.draganddrop.ContainerLayout
    public void setContainerLayoutSelected(boolean z) {
        if (z) {
            setBackgroundColor(this.mSelectedBackgroundColor);
        } else {
            setBackgroundColor(this.mFillBackgroundColor);
        }
    }

    public FillLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFillBackgroundColor = -9257756;
        this.mSelectedBackgroundColor = -9257756;
        this.mNumberOfItems = 1;
        this.mContentSpace = 0;
        this.mCustomGroup = -1;
        init(attributeSet);
    }

    public FillLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mFillBackgroundColor = -9257756;
        this.mSelectedBackgroundColor = -9257756;
        this.mNumberOfItems = 1;
        this.mContentSpace = 0;
        this.mCustomGroup = -1;
        init(attributeSet);
    }
}
