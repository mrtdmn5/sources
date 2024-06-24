package com.animaconnected.draganddrop.dragframework;

import android.graphics.Rect;

/* loaded from: classes.dex */
public interface DropTarget {

    /* loaded from: classes.dex */
    public static class DragObject {
        public int x = -1;
        public int y = -1;
        public int xOffset = -1;
        public int yOffset = -1;
        public boolean dragComplete = false;
        public DragView dragView = null;
        public Object dragInfo = null;
        public DragSource dragSource = null;
        public boolean cancelled = false;
        public boolean deferDragViewCleanupPostAnimation = true;
        final int[] locations = new int[2];

        public final float[] getVisualCenter(float[] fArr) {
            if (fArr == null) {
                fArr = new float[2];
            }
            DragView dragView = this.dragView;
            if (dragView != null) {
                dragView.getLocationOnScreen(this.locations);
                fArr[0] = (this.dragView.getWidth() / 2.0f) + this.locations[0];
                fArr[1] = (this.dragView.getHeight() / 2.0f) + this.locations[1];
            }
            return fArr;
        }
    }

    boolean acceptDrop(DragObject dragObject);

    void getHitRectRelativeToDragLayer(Rect rect);

    int getLeft();

    int getTop();

    boolean isDropEnabled();

    void onDragEnter(DragObject dragObject);

    void onDragExit(DragObject dragObject);

    void onDragOver(DragObject dragObject);

    void onDrop(DragObject dragObject);
}
