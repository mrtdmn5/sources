package com.animaconnected.draganddrop.dragframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.animaconnected.draganddrop.dragframework.DropTarget;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DragController {
    private final Context mContext;
    private final DragLayer mDragLayer;
    private DropTarget.DragObject mDragObject;
    private boolean mDragging;
    private DropTarget mLastDropTarget;
    private int mMotionDownX;
    private int mMotionDownY;
    private final Rect mRectTemp = new Rect();
    private final int[] mCoordinatesTemp = new int[2];
    private final ArrayList<DropTarget> mDropTargets = new ArrayList<>();
    private final ArrayList<DragListener> mListeners = new ArrayList<>();
    private final int[] mTmpPoint = new int[2];
    private final Rect mDragLayerRect = new Rect();

    /* loaded from: classes.dex */
    public interface DragListener {
        void onDragEnd();

        void onDragStart(DragSource dragSource, Object obj);
    }

    public DragController(Context context, DragLayer dragLayer) {
        this.mContext = context;
        this.mDragLayer = dragLayer;
    }

    private void checkTouchMove(DropTarget dropTarget) {
        if (dropTarget != null) {
            dropTarget.onDragOver(this.mDragObject);
        }
        this.mLastDropTarget = dropTarget;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void drop(float f, float f2) {
        int[] r0 = this.mCoordinatesTemp;
        DropTarget findDropTarget = findDropTarget((int) f, (int) f2, r0);
        DropTarget.DragObject dragObject = this.mDragObject;
        boolean z = false;
        dragObject.x = r0[0];
        dragObject.y = r0[1];
        if (findDropTarget != 0) {
            dragObject.dragComplete = true;
            if (findDropTarget.acceptDrop(dragObject)) {
                findDropTarget.onDrop(this.mDragObject);
                z = true;
            }
        }
        DropTarget.DragObject dragObject2 = this.mDragObject;
        dragObject2.dragSource.onDropCompleted((View) findDropTarget, dragObject2, z);
    }

    private void endDrag() {
        if (this.mDragging) {
            boolean z = false;
            this.mDragging = false;
            DropTarget.DragObject dragObject = this.mDragObject;
            DragView dragView = dragObject.dragView;
            if (dragView != null) {
                z = dragObject.deferDragViewCleanupPostAnimation;
                if (!z && dragView.getParent() != null) {
                    this.mDragLayer.removeView(this.mDragObject.dragView);
                }
                this.mDragObject.dragView = null;
            }
            if (!z) {
                Iterator it = new ArrayList(this.mListeners).iterator();
                while (it.hasNext()) {
                    ((DragListener) it.next()).onDragEnd();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DropTarget findDropTarget(int r7, int r8, int[] r9) {
        Rect rect = this.mRectTemp;
        ArrayList<DropTarget> arrayList = this.mDropTargets;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DropTarget dropTarget = arrayList.get(size);
            if (dropTarget.isDropEnabled()) {
                dropTarget.getHitRectRelativeToDragLayer(rect);
                DropTarget.DragObject dragObject = this.mDragObject;
                dragObject.x = r7;
                dragObject.y = r8;
                if (rect.contains(r7, r8)) {
                    r9[0] = r7;
                    r9[1] = r8;
                    this.mDragLayer.mapCoordInSelfToDescendent((View) dropTarget, r9);
                    return dropTarget;
                }
            }
        }
        return null;
    }

    private int[] getClampedDragLayerPos(float f, float f2) {
        this.mDragLayer.getLocalVisibleRect(this.mDragLayerRect);
        int[] r0 = this.mTmpPoint;
        Rect rect = this.mDragLayerRect;
        r0[0] = (int) Math.max(rect.left, Math.min(f, rect.right - 1));
        int[] r5 = this.mTmpPoint;
        Rect rect2 = this.mDragLayerRect;
        r5[1] = (int) Math.max(rect2.top, Math.min(f2, rect2.bottom - 1));
        return this.mTmpPoint;
    }

    private void handleMoveEvent(int r3, int r4) {
        this.mDragObject.dragView.move(r3, r4);
        int[] r0 = this.mCoordinatesTemp;
        DropTarget findDropTarget = findDropTarget(r3, r4, r0);
        DropTarget.DragObject dragObject = this.mDragObject;
        dragObject.x = r0[0];
        dragObject.y = r0[1];
        checkTouchMove(findDropTarget);
    }

    public void addDragListener(DragListener dragListener) {
        this.mListeners.add(dragListener);
    }

    public void addDropTarget(DropTarget dropTarget) {
        this.mDropTargets.add(dropTarget);
    }

    public void cancelDrag() {
        if (this.mDragging) {
            DropTarget dropTarget = this.mLastDropTarget;
            if (dropTarget != null) {
                dropTarget.onDragExit(this.mDragObject);
            }
            DropTarget.DragObject dragObject = this.mDragObject;
            dragObject.deferDragViewCleanupPostAnimation = false;
            dragObject.cancelled = true;
            dragObject.dragComplete = true;
            dragObject.dragSource.onDropCompleted(null, dragObject, false);
        }
        endDrag();
    }

    public void onDeferredEndDrag(DragView dragView) {
        if (dragView.getParent() != null) {
            this.mDragLayer.removeView(dragView);
        }
        if (this.mDragObject.deferDragViewCleanupPostAnimation) {
            Iterator it = new ArrayList(this.mListeners).iterator();
            while (it.hasNext()) {
                ((DragListener) it.next()).onDragEnd();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int[] clampedDragLayerPos = getClampedDragLayerPos(motionEvent.getX(), motionEvent.getY());
        int r1 = clampedDragLayerPos[0];
        int r4 = clampedDragLayerPos[1];
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    cancelDrag();
                }
            } else {
                if (this.mDragging) {
                    drop(r1, r4);
                }
                endDrag();
            }
        } else {
            this.mMotionDownX = r1;
            this.mMotionDownY = r4;
            this.mLastDropTarget = null;
        }
        return this.mDragging;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mDragging) {
            return false;
        }
        int action = motionEvent.getAction();
        int[] clampedDragLayerPos = getClampedDragLayerPos(motionEvent.getX(), motionEvent.getY());
        int r1 = clampedDragLayerPos[0];
        int r5 = clampedDragLayerPos[1];
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        cancelDrag();
                    }
                } else {
                    handleMoveEvent(r1, r5);
                }
            } else {
                handleMoveEvent(r1, r5);
                if (this.mDragging) {
                    drop(r1, r5);
                }
                endDrag();
            }
        } else {
            this.mMotionDownX = r1;
            this.mMotionDownY = r5;
            handleMoveEvent(r1, r5);
        }
        return true;
    }

    public void removeDragListener(DragListener dragListener) {
        this.mListeners.remove(dragListener);
    }

    public void removeDropTarget(DropTarget dropTarget) {
        this.mDropTargets.remove(dropTarget);
    }

    public DragView startDrag(Bitmap bitmap, int r21, int r22, DragSource dragSource, Object obj, Point point, Rect rect, float f) {
        int r16;
        int r17;
        Iterator<DragListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onDragStart(dragSource, obj);
        }
        int r9 = this.mMotionDownX - r21;
        int r10 = this.mMotionDownY - r22;
        if (rect == null) {
            r16 = 0;
        } else {
            r16 = rect.left;
        }
        if (rect == null) {
            r17 = 0;
        } else {
            r17 = rect.top;
        }
        this.mDragging = true;
        DropTarget.DragObject dragObject = new DropTarget.DragObject();
        this.mDragObject = dragObject;
        DragView dragView = new DragView(this.mContext, bitmap, r9, r10, 0, 0, bitmap.getWidth(), bitmap.getHeight(), f);
        dragObject.dragView = dragView;
        DropTarget.DragObject dragObject2 = this.mDragObject;
        dragObject2.dragComplete = false;
        dragObject2.xOffset = this.mMotionDownX - (r21 + r16);
        dragObject2.yOffset = this.mMotionDownY - (r22 + r17);
        dragObject2.dragSource = dragSource;
        dragObject2.dragInfo = obj;
        if (point != null) {
            dragView.setDragVisualizeOffset(new Point(point));
        }
        if (rect != null) {
            dragView.setDragRegion(new Rect(rect));
        }
        this.mDragLayer.performHapticFeedback(0);
        this.mDragLayer.addView(dragView);
        dragView.show(this.mMotionDownX, this.mMotionDownY);
        handleMoveEvent(this.mMotionDownX, this.mMotionDownY);
        return dragView;
    }

    public void onDeferredEndDrag(DragViewRemove dragViewRemove) {
        if (dragViewRemove.getParent() != null) {
            this.mDragLayer.removeView(dragViewRemove);
        }
        if (this.mDragObject.deferDragViewCleanupPostAnimation) {
            Iterator it = new ArrayList(this.mListeners).iterator();
            while (it.hasNext()) {
                ((DragListener) it.next()).onDragEnd();
            }
        }
    }
}
