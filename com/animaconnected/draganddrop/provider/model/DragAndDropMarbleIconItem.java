package com.animaconnected.draganddrop.provider.model;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class DragAndDropMarbleIconItem extends DragAndDropDroppableItem {
    public static final int NO_ICON_ID = -1;
    private final int mBackgroundDraggedResourceId;
    private final int mBackgroundDroppedResourceId;
    private final int mEmptyIconColor;
    private final Integer mIconColor;
    private final Drawable mIconDrawable;
    private final int mIconResourceId;
    private final String mName;
    private final int mTextStyle;

    public DragAndDropMarbleIconItem(int r1, int r2, Drawable drawable, String str, int r5, int r6, int r7, Integer num, int r9) {
        super(r1, r2);
        this.mIconDrawable = drawable;
        this.mIconResourceId = -1;
        this.mName = str;
        this.mTextStyle = r7;
        this.mBackgroundDroppedResourceId = r5;
        this.mBackgroundDraggedResourceId = r6;
        this.mIconColor = num;
        this.mEmptyIconColor = r9;
    }

    public int getBackgroundDraggedResourceId() {
        return this.mBackgroundDraggedResourceId;
    }

    public int getBackgroundDroppedResourceId() {
        return this.mBackgroundDroppedResourceId;
    }

    public int getEmptyIconColor() {
        return this.mEmptyIconColor;
    }

    public Drawable getIconAsDrawable() {
        return this.mIconDrawable;
    }

    public Integer getIconColor() {
        return this.mIconColor;
    }

    public int getIconResourceId() {
        return this.mIconResourceId;
    }

    public String getName() {
        return this.mName;
    }

    public int getTextStyle() {
        return this.mTextStyle;
    }

    public DragAndDropMarbleIconItem(int r1, int r2, int r3, String str, int r5, int r6, int r7, Integer num, int r9) {
        super(r1, r2);
        this.mIconResourceId = r3;
        this.mName = str;
        this.mTextStyle = r7;
        this.mIconDrawable = null;
        this.mBackgroundDroppedResourceId = r5;
        this.mBackgroundDraggedResourceId = r6;
        this.mIconColor = num;
        this.mEmptyIconColor = r9;
    }
}
