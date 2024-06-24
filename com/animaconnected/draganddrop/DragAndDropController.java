package com.animaconnected.draganddrop;

import android.content.Context;
import android.view.View;
import com.animaconnected.draganddrop.dragframework.DragSource;
import java.util.List;

/* loaded from: classes.dex */
public interface DragAndDropController {
    void animateInDropTargets(List<Integer> list, int r2, int r3);

    void animateOutDropTargets(List<Integer> list, int r2, int r3);

    void beginDragShared(View view, DragSource dragSource);

    boolean canStartDragFromSourceGridView();

    void cancelDropTargetAnimations();

    void disableDropTargets(List<Integer> list);

    void dragOverReceivedInSourceGridView();

    void dragOverReceivedInTargetLayout();

    int getAdapterType();

    Context getDragAndDropContext();

    View getDragAndDroppableTargetViewForAnimation(int r1);

    View getDragAndDroppableViewForAnimation(int r1);

    int getTab();

    void hideDropTargets(List<Integer> list);

    boolean isAnimatorRunning();

    boolean isDragging();

    boolean possibleToDrop();

    void showDropTargets();

    void startDraggingFromSourceGridView();

    void startDraggingFromTargetLayout(int r1);

    void stopDragging();
}
