package com.animaconnected.draganddrop.provider.model;

/* loaded from: classes.dex */
public class DragAndDropIconItem extends DragAndDropItem {
    private final int mIconResourceId;
    private final String mIconText;
    private final int mTextStyle;

    public DragAndDropIconItem(int r1, String str, int r3) {
        this.mIconResourceId = r1;
        this.mIconText = str;
        this.mTextStyle = r3;
    }

    public int getIconResourceId() {
        return this.mIconResourceId;
    }

    public String getIconText() {
        return this.mIconText;
    }

    public int getTextStyle() {
        return this.mTextStyle;
    }
}
