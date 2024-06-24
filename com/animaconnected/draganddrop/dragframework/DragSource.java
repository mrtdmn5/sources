package com.animaconnected.draganddrop.dragframework;

import android.view.View;
import com.animaconnected.draganddrop.dragframework.DropTarget;

/* loaded from: classes.dex */
public interface DragSource {
    void onDropCompleted(View view, DropTarget.DragObject dragObject, boolean z);
}
