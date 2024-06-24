package com.animaconnected.draganddrop;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.animaconnected.draganddrop.dataadapter.DragAndDropSourceGridViewAdapter;
import com.animaconnected.draganddrop.dragframework.DragController;
import com.animaconnected.draganddrop.dragframework.DragLayer;
import com.animaconnected.draganddrop.dragframework.DragSource;
import com.animaconnected.draganddrop.provider.model.ClickListener;
import com.animaconnected.draganddrop.utils.LayoutPool;
import java.util.List;

/* loaded from: classes.dex */
public class DragAndDrop extends FrameLayout implements DragAndDropController {
    private static final String KEY_SCROLL_POSITION = "scrollPosition";
    private static final String KEY_SCROLL_POSITION_OFFSET = "scrollPositionOffset";
    private static final String KEY_SUPER_STATE = "superState";
    private DragAndDropSourceGridView mDragAndDropSourceGridView;
    private DragAndDropTargetContainerLayout mDragAndDropTargetContainerLayout;
    private DragAndDropTargetLayout mDragAndDropTargetLayout;
    private RelativeLayout mDragAndDropTargetRemoveLayout;
    private DragController mDragController;
    private DragLayer mDragLayer;
    private boolean mDragging;
    private Integer mExtraViewHeightPx;
    private Integer mExtraViewWidthPx;
    private boolean mFirstStart;
    private int[] mScrollPositionAndOffset;
    private Integer mSourceGridHeightPx;
    private DragAndDropSourceGridViewAdapter mSourceGridViewAdapter1;
    private DragAndDropSourceGridViewAdapter mSourceGridViewAdapter2;
    private final boolean mSourceGridViewExpanded;
    private int mToolbarHeightPx;

    public DragAndDrop(Context context) {
        super(context);
        this.mDragAndDropTargetRemoveLayout = null;
        this.mDragAndDropTargetLayout = null;
        this.mSourceGridViewExpanded = true;
    }

    public void animateInDropTargets(int r2, int r3) {
        DragAndDropTargetLayout dragAndDropTargetLayout = this.mDragAndDropTargetLayout;
        if (dragAndDropTargetLayout != null) {
            dragAndDropTargetLayout.animateInDropTargets(r2, r3);
        }
    }

    public void animateOutDropTargets(int r2) {
        DragAndDropTargetLayout dragAndDropTargetLayout = this.mDragAndDropTargetLayout;
        if (dragAndDropTargetLayout != null) {
            dragAndDropTargetLayout.animateOutDropTargets(r2);
        }
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void beginDragShared(View view, DragSource dragSource) {
        this.mDragAndDropTargetContainerLayout.beginDragShared(view, dragSource);
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public boolean canStartDragFromSourceGridView() {
        if (!this.mDragging && !this.mDragAndDropSourceGridView.getRecyclerView().isComputingLayout()) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void cancelDropTargetAnimations() {
        DragAndDropTargetLayout dragAndDropTargetLayout = this.mDragAndDropTargetLayout;
        if (dragAndDropTargetLayout != null) {
            dragAndDropTargetLayout.cancelDropTargetAnimations();
        }
    }

    public void destroy(int r2) {
        this.mSourceGridViewAdapter1.destroy();
        DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter = this.mSourceGridViewAdapter2;
        if (dragAndDropSourceGridViewAdapter != null) {
            dragAndDropSourceGridViewAdapter.destroy();
        }
        this.mDragAndDropTargetContainerLayout.destroy(r2);
        this.mDragAndDropSourceGridView.destroy();
        LayoutPool.getInstance().clear();
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void disableDropTargets(List<Integer> list) {
        this.mDragAndDropTargetContainerLayout.disabledDropTargets(list);
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void dragOverReceivedInSourceGridView() {
        this.mDragAndDropTargetContainerLayout.dragOverReceivedInSourceGridView();
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void dragOverReceivedInTargetLayout() {
        this.mDragAndDropSourceGridView.dragOverReceivedInTargetLayout();
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public int getAdapterType() {
        return this.mDragAndDropSourceGridView.getAdapterType();
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public Context getDragAndDropContext() {
        return getContext();
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public View getDragAndDroppableTargetViewForAnimation(int r2) {
        return this.mDragAndDropTargetContainerLayout.getDragAndDroppableTargetViewForAnimation(r2);
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public View getDragAndDroppableViewForAnimation(int r2) {
        return this.mDragAndDropSourceGridView.getDragAndDroppableViewForAnimation(r2);
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public int getTab() {
        return this.mDragAndDropSourceGridView.getAdapterType();
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void hideDropTargets(List<Integer> list) {
        this.mDragAndDropTargetContainerLayout.hideDropTargets(list);
    }

    public void init(DragAndDropSettings dragAndDropSettings) {
        this.mSourceGridViewAdapter1 = dragAndDropSettings.dragAndDropSourceGridViewAdapter1;
        this.mSourceGridViewAdapter2 = dragAndDropSettings.dragAndDropSourceGridViewAdapter2;
        this.mToolbarHeightPx = dragAndDropSettings.toolbarHeightPx;
        DragAndDropTargetLayout dragAndDropTargetLayout = dragAndDropSettings.dragAndDropTargetLayout;
        this.mDragAndDropTargetLayout = dragAndDropTargetLayout;
        this.mDragAndDropTargetRemoveLayout = dragAndDropTargetLayout.getDragAndDropTargetRemoveLayout();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.draganddrop_sourcegridview_container);
        LayoutInflater.from(getContext()).inflate(R.layout.draganddrop_sourcegridview, viewGroup, true);
        DragAndDropSourceGridView dragAndDropSourceGridView = (DragAndDropSourceGridView) viewGroup.getChildAt(0);
        this.mDragAndDropSourceGridView = dragAndDropSourceGridView;
        this.mDragController.addDragListener(dragAndDropSourceGridView);
        this.mDragController.addDropTarget(this.mDragAndDropSourceGridView);
        this.mDragAndDropSourceGridView.init(this, this.mDragLayer, dragAndDropSettings);
        this.mDragAndDropTargetContainerLayout.init(this, dragAndDropSettings);
        this.mSourceGridHeightPx = dragAndDropSettings.sourceGridHeightPx;
        this.mExtraViewWidthPx = dragAndDropSettings.extraViewWidthPx;
        this.mExtraViewHeightPx = dragAndDropSettings.extraViewHeightPx;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public boolean isAnimatorRunning() {
        return this.mDragAndDropSourceGridView.isAnimatorRunning();
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public boolean isDragging() {
        return this.mDragging;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mDragLayer = (DragLayer) findViewById(R.id.drag_layer);
        DragController dragController = new DragController(getContext(), this.mDragLayer);
        this.mDragController = dragController;
        this.mDragLayer.setup(dragController);
        DragAndDropTargetContainerLayout dragAndDropTargetContainerLayout = (DragAndDropTargetContainerLayout) findViewById(R.id.draganddroptargetcontainerlayout);
        this.mDragAndDropTargetContainerLayout = dragAndDropTargetContainerLayout;
        dragAndDropTargetContainerLayout.setup(this.mDragController, this.mDragLayer);
        this.mDragController.addDragListener(this.mDragAndDropTargetContainerLayout);
        this.mDragController.addDropTarget(this.mDragAndDropTargetContainerLayout);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.animaconnected.draganddrop.DragAndDrop.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int height;
                DragAndDrop.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (!DragAndDrop.this.mFirstStart) {
                    if (DragAndDrop.this.mSourceGridHeightPx != null) {
                        height = (DragAndDrop.this.mToolbarHeightPx + DragAndDrop.this.mDragAndDropTargetLayout.getHeight()) - DragAndDrop.this.mSourceGridHeightPx.intValue();
                    } else {
                        height = DragAndDrop.this.mToolbarHeightPx + (DragAndDrop.this.mDragAndDropTargetLayout.getHeight() - DragAndDrop.this.mDragAndDropTargetRemoveLayout.getHeight());
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.setMargins(0, height, 0, 0);
                    DragAndDrop.this.mDragAndDropSourceGridView.setLayoutParams(layoutParams);
                    if (DragAndDrop.this.mDragAndDropTargetLayout.getExtraView() != null && DragAndDrop.this.mExtraViewWidthPx != null && DragAndDrop.this.mExtraViewHeightPx != null) {
                        DragAndDrop.this.mDragAndDropTargetLayout.getExtraView().setLayoutParams(new FrameLayout.LayoutParams(DragAndDrop.this.mExtraViewWidthPx.intValue(), DragAndDrop.this.mExtraViewHeightPx.intValue()));
                    }
                    DragAndDrop.this.invalidate();
                    DragAndDrop.this.mFirstStart = true;
                }
            }
        });
    }

    public void onPause() {
        this.mDragAndDropTargetLayout.onPause();
        this.mDragAndDropTargetContainerLayout.onPause();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mDragAndDropSourceGridView.setScrollPosition(bundle.getInt(KEY_SCROLL_POSITION), bundle.getInt(KEY_SCROLL_POSITION_OFFSET));
            parcelable = bundle.getParcelable(KEY_SUPER_STATE);
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onResume() {
        this.mDragAndDropTargetLayout.onResume();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        this.mScrollPositionAndOffset = this.mDragAndDropSourceGridView.getScrollPositionAndOffset(this.mScrollPositionAndOffset);
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_SUPER_STATE, super.onSaveInstanceState());
        bundle.putInt(KEY_SCROLL_POSITION, this.mScrollPositionAndOffset[0]);
        bundle.putInt(KEY_SCROLL_POSITION_OFFSET, this.mScrollPositionAndOffset[1]);
        return bundle;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public boolean possibleToDrop() {
        return this.mDragAndDropSourceGridView.possibleToDrop();
    }

    public void scrollToLastMarbleIcon() {
        this.mDragAndDropSourceGridView.scrollToLastMarbleIcon();
    }

    public void setItemClickListener(ClickListener clickListener) {
        this.mDragAndDropTargetContainerLayout.setItemClickListener(clickListener);
        this.mSourceGridViewAdapter1.setItemClickListener(clickListener);
        DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter = this.mSourceGridViewAdapter2;
        if (dragAndDropSourceGridViewAdapter != null) {
            dragAndDropSourceGridViewAdapter.setItemClickListener(clickListener);
        }
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void showDropTargets() {
        this.mDragAndDropTargetContainerLayout.showDropTargets();
        this.mDragAndDropTargetContainerLayout.refreshViews();
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void startDraggingFromSourceGridView() {
        this.mDragging = true;
        this.mDragAndDropSourceGridView.resetAnimations();
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void startDraggingFromTargetLayout(int r2) {
        this.mDragging = true;
        this.mDragAndDropSourceGridView.scrollToPosition(r2);
        this.mDragAndDropSourceGridView.disableDragAndDropSourceGridViewItems(r2);
        this.mDragAndDropSourceGridView.refreshViews();
        this.mDragAndDropSourceGridView.resetAnimations();
        this.mDragAndDropSourceGridView.setFirstStart(false);
    }

    public void startInitialScroll() {
        this.mDragAndDropSourceGridView.startInitialScroll();
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void stopDragging() {
        this.mDragging = false;
        this.mDragAndDropTargetContainerLayout.enableDropTargets();
        this.mDragAndDropSourceGridView.enableDragAndDropSourceGridViewItems();
        this.mDragAndDropSourceGridView.resetAnimations();
        this.mDragAndDropTargetContainerLayout.refreshViews();
        this.mDragAndDropSourceGridView.refreshViews();
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void animateInDropTargets(List<Integer> list, int r3, int r4) {
        DragAndDropTargetLayout dragAndDropTargetLayout = this.mDragAndDropTargetLayout;
        if (dragAndDropTargetLayout != null) {
            dragAndDropTargetLayout.animateInDropTargets(list, r3, r4);
        }
    }

    @Override // com.animaconnected.draganddrop.DragAndDropController
    public void animateOutDropTargets(List<Integer> list, int r3, int r4) {
        DragAndDropTargetLayout dragAndDropTargetLayout = this.mDragAndDropTargetLayout;
        if (dragAndDropTargetLayout != null) {
            dragAndDropTargetLayout.animateOutDropTargets(list, r3, r4);
        }
    }

    public DragAndDrop(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDragAndDropTargetRemoveLayout = null;
        this.mDragAndDropTargetLayout = null;
        this.mSourceGridViewExpanded = true;
    }

    public DragAndDrop(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mDragAndDropTargetRemoveLayout = null;
        this.mDragAndDropTargetLayout = null;
        this.mSourceGridViewExpanded = true;
    }
}
