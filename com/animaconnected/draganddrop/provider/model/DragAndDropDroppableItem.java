package com.animaconnected.draganddrop.provider.model;

import com.animaconnected.draganddrop.provider.BadgeState;
import com.animaconnected.draganddrop.provider.BadgeVisualState;

/* loaded from: classes.dex */
public class DragAndDropDroppableItem extends DragAndDropItem {
    private boolean mAnimatedBack;
    private int mCenterX;
    private int mCenterY;
    private final int mColor;
    private boolean mDraggedFromSourceGridView;
    private boolean mDropped;
    private boolean mDroppedGrid1;
    private boolean mDroppedGrid2;
    private boolean mSelected;
    private boolean mShouldAnimate;
    private int mSourceGridViewIndex;
    private int mSourceGridViewIndexGrid1;
    private int mSourceGridViewIndexGrid2;
    private int mTargetLayoutPosition;
    private int mGroup = -1;
    private boolean mEnabled = true;
    private BadgeState mBadgeState = BadgeState.Normal;
    private BadgeVisualState mBadgeVisualState = BadgeVisualState.Invisible;

    public DragAndDropDroppableItem(int r2, int r3) {
        this.mId = Integer.valueOf(r2);
        this.mColor = r3;
    }

    public void enableOrDisable(boolean z) {
        this.mEnabled = z;
    }

    public BadgeState getBadgeState() {
        return this.mBadgeState;
    }

    public BadgeVisualState getBadgeVisualState() {
        return this.mBadgeVisualState;
    }

    public int getCenterX() {
        return this.mCenterX;
    }

    public int getCenterY() {
        return this.mCenterY;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getGroup() {
        return this.mGroup;
    }

    public int getSourceGridViewIndex() {
        return this.mSourceGridViewIndex;
    }

    public int getTargetLayoutPosition() {
        return this.mTargetLayoutPosition;
    }

    public boolean isAnimatedBack() {
        return this.mAnimatedBack;
    }

    public boolean isDraggedFromSourceGridView() {
        return this.mDraggedFromSourceGridView;
    }

    public boolean isDropped() {
        return this.mDropped;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isSelected() {
        return this.mSelected;
    }

    public void setAnimatedBack(boolean z) {
        this.mAnimatedBack = z;
    }

    public void setBadgeState(BadgeState badgeState) {
        this.mBadgeState = badgeState;
    }

    public void setBadgeVisualState(BadgeVisualState badgeVisualState) {
        this.mBadgeVisualState = badgeVisualState;
    }

    public void setCenterX(int r1) {
        this.mCenterX = r1;
    }

    public void setCenterY(int r1) {
        this.mCenterY = r1;
    }

    public void setDraggedFromSourceGridView(boolean z) {
        this.mDraggedFromSourceGridView = z;
    }

    public void setDropped(boolean z) {
        this.mDropped = z;
    }

    public void setGroup(int r1) {
        this.mGroup = r1;
    }

    public void setSelected(boolean z) {
        this.mSelected = z;
    }

    public void setShouldAnimate(boolean z) {
        this.mShouldAnimate = z;
    }

    public void setSourceGridViewIndex(int r1) {
        this.mSourceGridViewIndex = r1;
    }

    public void setTargetLayoutPosition(int r1) {
        this.mTargetLayoutPosition = r1;
    }

    public boolean shouldAnimate() {
        return this.mShouldAnimate;
    }

    public int getSourceGridViewIndex(int r2) {
        if (r2 == 0) {
            return this.mSourceGridViewIndexGrid1;
        }
        if (r2 == 1) {
            return this.mSourceGridViewIndexGrid2;
        }
        return this.mSourceGridViewIndex;
    }

    public boolean isDropped(int r2) {
        if (r2 == 0) {
            return this.mDroppedGrid1;
        }
        if (r2 == 1) {
            return this.mDroppedGrid2;
        }
        return this.mDropped;
    }

    public void setDropped(boolean z, int r3) {
        if (r3 == 0) {
            this.mDroppedGrid1 = z;
        } else if (r3 == 1) {
            this.mDroppedGrid2 = z;
        } else {
            this.mDropped = z;
        }
    }

    public void setSourceGridViewIndex(int r2, int r3) {
        if (r3 == 0) {
            this.mSourceGridViewIndexGrid1 = r2;
        } else if (r3 == 1) {
            this.mSourceGridViewIndexGrid2 = r2;
        } else {
            this.mSourceGridViewIndex = r2;
        }
    }
}
