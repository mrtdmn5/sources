package com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.animaconnected.draganddrop.DragAndDropController;
import com.animaconnected.draganddrop.R;
import com.animaconnected.draganddrop.dataadapter.OnSourceGridItemClickedListener;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;
import com.animaconnected.draganddrop.widget.DragItemLayout;

/* loaded from: classes.dex */
public class DragAndDropMarbleIconSourceGridViewHolder extends DragAndDropSourceGridViewHolder {
    private DragAndDropMarbleIconSourceGridViewHolder(DragItemLayout dragItemLayout, OnSourceGridItemClickedListener onSourceGridItemClickedListener, DragAndDropProvider dragAndDropProvider, DragAndDropController dragAndDropController) {
        super(dragItemLayout, onSourceGridItemClickedListener, dragAndDropProvider, dragAndDropController);
    }

    public static DragAndDropSourceGridViewHolder newInstance(ViewGroup viewGroup, OnSourceGridItemClickedListener onSourceGridItemClickedListener, DragAndDropProvider dragAndDropProvider, DragAndDropController dragAndDropController) {
        return new DragAndDropMarbleIconSourceGridViewHolder((DragItemLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.marbleicon_dragitemlayout_sourcegridview, viewGroup, false), onSourceGridItemClickedListener, dragAndDropProvider, dragAndDropController);
    }
}
