package com.animaconnected.draganddrop.dataadapter;

import android.view.View;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;

/* loaded from: classes.dex */
public interface OnSourceGridItemClickedListener {
    void onDragStarted(View view, DragAndDropDroppableItem dragAndDropDroppableItem);

    void onSourceGridItemClicked(View view, DragAndDropItem dragAndDropItem);
}
