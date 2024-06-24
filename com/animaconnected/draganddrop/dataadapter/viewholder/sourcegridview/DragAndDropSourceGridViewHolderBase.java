package com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;

/* loaded from: classes.dex */
public abstract class DragAndDropSourceGridViewHolderBase extends RecyclerView.ViewHolder {
    public DragAndDropSourceGridViewHolderBase(View view) {
        super(view);
    }

    public abstract void bind(DragAndDropItem dragAndDropItem);
}
