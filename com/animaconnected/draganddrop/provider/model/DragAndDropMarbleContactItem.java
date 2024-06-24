package com.animaconnected.draganddrop.provider.model;

/* loaded from: classes.dex */
public class DragAndDropMarbleContactItem extends DragAndDropDroppableItem {
    private final int mBackgroundDraggedResourceId;
    private final int mBackgroundDroppedResourceId;
    private final String mFirstName;
    private final int mIconColor;
    private final int mIconResourceId;
    private final String mInitials;
    private final String mLastName;
    private final int mTextStyle;

    public DragAndDropMarbleContactItem(int r1, int r2, String str, String str2, String str3, int r6, int r7, int r8, int r9, int r10) {
        super(r1, r2);
        this.mInitials = str;
        this.mFirstName = str2;
        this.mLastName = str3;
        this.mTextStyle = r8;
        this.mBackgroundDroppedResourceId = r6;
        this.mBackgroundDraggedResourceId = r7;
        this.mIconResourceId = r9;
        this.mIconColor = r10;
    }

    public int getBackgroundDraggedResourceId() {
        return this.mBackgroundDraggedResourceId;
    }

    public int getBackgroundDroppedResourceId() {
        return this.mBackgroundDroppedResourceId;
    }

    public String getFirstName() {
        return this.mFirstName;
    }

    public int getIconColor() {
        return this.mIconColor;
    }

    public int getIconResourceId() {
        return this.mIconResourceId;
    }

    public String getInitials() {
        return this.mInitials;
    }

    public String getLastName() {
        return this.mLastName;
    }

    public int getTextStyle() {
        return this.mTextStyle;
    }
}
