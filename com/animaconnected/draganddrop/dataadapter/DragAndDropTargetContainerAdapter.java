package com.animaconnected.draganddrop.dataadapter;

import android.content.Context;
import com.animaconnected.draganddrop.DragAndDropController;
import com.animaconnected.draganddrop.DragAndDropTargetLayout;
import com.animaconnected.draganddrop.dataadapter.viewholder.target.DragAndDropMarbleContactTargetViewHolder;
import com.animaconnected.draganddrop.dataadapter.viewholder.target.DragAndDropMarbleIconTargetViewHolder;
import com.animaconnected.draganddrop.dataadapter.viewholder.target.DragAndDropTargetViewHolder;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleContactItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleIconItem;

/* loaded from: classes.dex */
public class DragAndDropTargetContainerAdapter {
    private final Context mContext;
    private final DragAndDropController mDragAndDropController;
    private final DragAndDropProvider mDragAndDropProvider;
    private final DragAndDropTargetLayout mDragAndDropTargetLayout;
    private final DragAndDropTargetViewHolder.OnTargetItemClickedListener mOnTargetItemClickedListener;

    public DragAndDropTargetContainerAdapter(DragAndDropTargetViewHolder.OnTargetItemClickedListener onTargetItemClickedListener, Context context, DragAndDropProvider dragAndDropProvider, DragAndDropController dragAndDropController, DragAndDropTargetLayout dragAndDropTargetLayout) {
        this.mOnTargetItemClickedListener = onTargetItemClickedListener;
        this.mContext = context;
        this.mDragAndDropProvider = dragAndDropProvider;
        this.mDragAndDropController = dragAndDropController;
        this.mDragAndDropTargetLayout = dragAndDropTargetLayout;
    }

    public DragAndDropTargetViewHolder createViewHolder(int r8, DragAndDropTargetViewHolder dragAndDropTargetViewHolder, DragAndDropDroppableItem dragAndDropDroppableItem) {
        int r9;
        if (dragAndDropTargetViewHolder != null) {
            r9 = dragAndDropTargetViewHolder.getGroup();
        } else {
            r9 = -1;
        }
        int r1 = r9;
        dragAndDropDroppableItem.setGroup(r1);
        if (dragAndDropDroppableItem instanceof DragAndDropMarbleIconItem) {
            return DragAndDropMarbleIconTargetViewHolder.newInstance(r8, r1, dragAndDropDroppableItem, this.mOnTargetItemClickedListener, this.mContext, this.mDragAndDropProvider, this.mDragAndDropController);
        }
        if (dragAndDropDroppableItem instanceof DragAndDropMarbleContactItem) {
            return DragAndDropMarbleContactTargetViewHolder.newInstance(r8, r1, dragAndDropDroppableItem, this.mOnTargetItemClickedListener, this.mContext, this.mDragAndDropProvider, this.mDragAndDropController);
        }
        return DragAndDropTargetViewHolder.newInstance(r8, r1, dragAndDropDroppableItem, this.mOnTargetItemClickedListener, this.mContext, this.mDragAndDropProvider, this.mDragAndDropController);
    }
}
