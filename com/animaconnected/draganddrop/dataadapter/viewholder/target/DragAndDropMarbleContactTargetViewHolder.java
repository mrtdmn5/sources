package com.animaconnected.draganddrop.dataadapter.viewholder.target;

import android.content.Context;
import android.widget.ImageView;
import com.animaconnected.draganddrop.DragAndDropController;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.dataadapter.viewholder.target.DragAndDropTargetViewHolder;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.utils.LayoutPool;
import com.animaconnected.draganddrop.widget.DragItemLayout;

/* loaded from: classes.dex */
public class DragAndDropMarbleContactTargetViewHolder extends DragAndDropTargetViewHolder {
    public DragAndDropMarbleContactTargetViewHolder(int r10, int r11, DragItemLayout dragItemLayout, DragAndDropDroppableItem dragAndDropDroppableItem, DragAndDropTargetViewHolder.OnTargetItemClickedListener onTargetItemClickedListener, DragAndDropProvider dragAndDropProvider, DragAndDropController dragAndDropController) {
        super(r10, r11, dragItemLayout, dragAndDropDroppableItem, onTargetItemClickedListener, dragAndDropProvider, dragAndDropController, true);
    }

    public static DragAndDropMarbleContactTargetViewHolder newInstance(int r9, int r10, DragAndDropDroppableItem dragAndDropDroppableItem, DragAndDropTargetViewHolder.OnTargetItemClickedListener onTargetItemClickedListener, Context context, DragAndDropProvider dragAndDropProvider, DragAndDropController dragAndDropController) {
        DragItemLayout dragItemLayout = (DragItemLayout) LayoutPool.getInstance().getViewOrCreateIfNeeded(context, R.layout.marblecontact_dragitemlayout_target);
        if (dragAndDropDroppableItem != null) {
            Integer resId = dragAndDropDroppableItem.getBadgeState().getResId();
            ImageView badgeView = dragItemLayout.getBadgeView();
            if (resId != null && badgeView != null) {
                badgeView.setImageDrawable(context.getDrawable(resId.intValue()));
            }
        }
        return new DragAndDropMarbleContactTargetViewHolder(r9, r10, dragItemLayout, dragAndDropDroppableItem, onTargetItemClickedListener, dragAndDropProvider, dragAndDropController);
    }
}
