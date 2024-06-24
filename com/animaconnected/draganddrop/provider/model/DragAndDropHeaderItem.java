package com.animaconnected.draganddrop.provider.model;

/* loaded from: classes.dex */
public class DragAndDropHeaderItem extends DragAndDropItem {
    private final String mHeaderName;
    private final boolean mIsFirst;
    private final int mTextColor;

    public DragAndDropHeaderItem(String str, boolean z, int r3) {
        this.mHeaderName = str;
        this.mIsFirst = z;
        this.mTextColor = r3;
    }

    public String getHeaderName() {
        return this.mHeaderName;
    }

    public boolean getIsFirst() {
        return this.mIsFirst;
    }

    public int getTextColor() {
        return this.mTextColor;
    }
}
