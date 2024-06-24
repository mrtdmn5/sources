package com.animaconnected.draganddrop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.animaconnected.draganddrop.dataadapter.DragAndDropTargetContainerAdapter;
import com.animaconnected.draganddrop.dataadapter.viewholder.target.DragAndDropTargetViewHolder;
import com.animaconnected.draganddrop.dragframework.DragController;
import com.animaconnected.draganddrop.dragframework.DragLayer;
import com.animaconnected.draganddrop.dragframework.DragSource;
import com.animaconnected.draganddrop.dragframework.DragView;
import com.animaconnected.draganddrop.dragframework.DragViewRemove;
import com.animaconnected.draganddrop.dragframework.DropTarget;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;
import com.animaconnected.draganddrop.provider.model.ClickListener;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import com.animaconnected.draganddrop.utils.LayoutPool;
import com.animaconnected.draganddrop.widget.DragItemLayout;
import com.animaconnected.draganddrop.widget.MarbleView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class DragAndDropTargetContainerLayout extends FrameLayout implements DragController.DragListener, DragSource, DropTarget, DragAndDropProvider.DragAndDropChangedListener {
    private static final int ACTIONBAR_HEIGHT = 56;
    private static final int DRAGGED_TO_NOT_DRAGGED_DURATION = 250;
    private static final int DRAG_BITMAP_PADDING = 2;
    private static final int INVALID_DROP_AND_DRAG_TARGET_INDEX = -1;
    private static final int SELECTED_DISTANCE_DP = 100;
    private static final Rect sTempRect = new Rect();
    final int[] locations;
    private DragAndDropDroppableItem mAdapterItemDragged;
    private final Canvas mCanvas;
    private DragAndDropController mDragAndDropController;
    private DragAndDropProvider<Object> mDragAndDropProvider;
    private DragAndDropTargetContainerAdapter mDragAndDropTargetContainerAdapter;
    private DragAndDropTargetLayout mDragAndDropTargetLayout;
    private DragController mDragController;
    private DragLayer mDragLayer;
    private float[] mDragViewVisualCenter;
    private boolean mDropAnimationFinished;
    private int mDropOnIndex;
    private DragAndDropTargetViewHolder mDropOnViewHolder;
    private ClickListener mItemClickedListener;
    private DragAndDropTargetViewHolder[] mItems;
    private int mOldDropOnIndex;
    private DragAndDropTargetViewHolder.OnTargetItemClickedListener mOnTargetItemClickedListener;
    private boolean mRemoveDropTargetAnimationFinished;
    private float[] mRes;
    private int mSelectedDistance;
    private boolean mShouldWaitForRemoveDropTargetAnimation;
    private final int[] mTempXY;

    public DragAndDropTargetContainerLayout(Context context) {
        this(context, null, 0);
    }

    private void animateBackRemovedView(int r20) {
        Point point;
        Rect rect;
        int r14;
        getDragAndDroppableView(r20).clearFocus();
        getDragAndDroppableView(r20).setPressed(false);
        AtomicInteger atomicInteger = new AtomicInteger(2);
        Bitmap createDragBitmap = createDragBitmap(getDragAndDroppableView(r20), atomicInteger);
        int width = createDragBitmap.getWidth();
        int height = createDragBitmap.getHeight();
        float locationInDragLayer = this.mDragLayer.getLocationInDragLayer(getDragAndDroppableView(r20), this.mTempXY);
        int round = Math.round(this.mTempXY[0] - ((width - (getDragAndDroppableView(r20).getWidth() * locationInDragLayer)) / 2.0f));
        float f = height;
        int round2 = Math.round((this.mTempXY[1] - ((f - (locationInDragLayer * f)) / 2.0f)) - (atomicInteger.get() / 2.0f));
        if (getDragAndDroppableView(r20) instanceof MarbleView) {
            int paddingTop = getDragAndDroppableView(r20).getPaddingTop();
            int r4 = (width - 100) / 2;
            Point point2 = new Point((-atomicInteger.get()) / 2, atomicInteger.get() / 2);
            rect = new Rect(r4, paddingTop, r4 + 100, paddingTop + 100);
            r14 = round2 + paddingTop;
            point = point2;
        } else {
            point = null;
            rect = null;
            r14 = round2;
        }
        View dragAndDroppableView = getDragAndDroppableView(r20);
        LayoutPool.getInstance().dontPoolView(this.mItems[r20].getContentView());
        getDragAndDroppableView(r20).setVisibility(4);
        setBadgeVisibilityAnimated(r20, false);
        this.mDragAndDropProvider.clearBadgeState(getViewHolder(r20).getAdapterItem());
        DragViewRemove addRemoveView = this.mDragLayer.addRemoveView(this.mDragAndDropController.getDragAndDropContext(), createDragBitmap, round, r14, point, rect, locationInDragLayer);
        Runnable removeDropOnTargetAnimationCompleteRunnable = getRemoveDropOnTargetAnimationCompleteRunnable();
        View dragAndDroppableViewForAnimation = this.mDragAndDropController.getDragAndDroppableViewForAnimation(this.mDropOnViewHolder.getAdapterItem().getSourceGridViewIndex(this.mDragAndDropController.getAdapterType()));
        this.mRemoveDropTargetAnimationFinished = false;
        if (dragAndDroppableViewForAnimation != null) {
            this.mDragLayer.animateRemovedViewIntoPosition(addRemoveView, dragAndDroppableViewForAnimation, 1.0f, false, 250, removeDropOnTargetAnimationCompleteRunnable, this, false);
        } else {
            this.mDragLayer.animateRemovedViewIntoPosition(addRemoveView, dragAndDroppableView, 1.0f, false, 250, removeDropOnTargetAnimationCompleteRunnable, this, true);
        }
        createDragBitmap.recycle();
    }

    private Bitmap createDragBitmap(View view, AtomicInteger atomicInteger) {
        int r5 = atomicInteger.get();
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth() + r5, view.getHeight() + r5, Bitmap.Config.ARGB_8888);
        this.mCanvas.setBitmap(createBitmap);
        drawDragView(view, this.mCanvas, r5);
        this.mCanvas.setBitmap(null);
        return createBitmap;
    }

    private static void drawDragView(View view, Canvas canvas, int r5) {
        Rect rect = sTempRect;
        view.getDrawingRect(rect);
        canvas.save();
        float f = r5 / 2.0f;
        canvas.translate((-view.getScrollX()) + f, (-view.getScrollY()) + f);
        canvas.clipRect(rect);
        view.draw(canvas);
        canvas.restore();
    }

    private String[] getDefaultGroupNames() {
        ArrayList arrayList = new ArrayList();
        String groupText = this.mDragAndDropProvider.getGroupText(0);
        int r3 = 1;
        while (groupText != null) {
            arrayList.add(groupText);
            groupText = this.mDragAndDropProvider.getGroupText(r3);
            r3++;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private View getDragAndDroppableView(int r2) {
        return this.mItems[r2].getDragAndDroppableView();
    }

    private View getDragAndDroppableViewForAnimation(int r2) {
        return this.mItems[r2].getDragAndDroppableViewForAnimation();
    }

    private Runnable getDropOnRemoveTargetAnimationCompleteRunnable(final DragAndDropDroppableItem dragAndDropDroppableItem) {
        return new Runnable() { // from class: com.animaconnected.draganddrop.DragAndDropTargetContainerLayout$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DragAndDropTargetContainerLayout.this.lambda$getDropOnRemoveTargetAnimationCompleteRunnable$0(dragAndDropDroppableItem);
            }
        };
    }

    private Runnable getDropOnTargetAnimationCompleteRunnable(final int r2, final DragAndDropDroppableItem dragAndDropDroppableItem) {
        return new Runnable() { // from class: com.animaconnected.draganddrop.DragAndDropTargetContainerLayout$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DragAndDropTargetContainerLayout.this.lambda$getDropOnTargetAnimationCompleteRunnable$1(r2, dragAndDropDroppableItem);
            }
        };
    }

    private DragAndDropTargetViewHolder[] getItems() {
        return this.mItems;
    }

    private Runnable getRemoveDropOnTargetAnimationCompleteRunnable() {
        return new Runnable() { // from class: com.animaconnected.draganddrop.DragAndDropTargetContainerLayout$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DragAndDropTargetContainerLayout.this.lambda$getRemoveDropOnTargetAnimationCompleteRunnable$2();
            }
        };
    }

    private DragAndDropTargetViewHolder getViewHolder(int r2) {
        return this.mItems[r2];
    }

    private float[] getVisualCenter(View view, float[] fArr) {
        if (fArr == null) {
            fArr = new float[2];
        }
        view.getLocationOnScreen(this.locations);
        fArr[0] = (view.getWidth() / 2.0f) + this.locations[0];
        fArr[1] = (view.getHeight() / 2.0f) + this.locations[1];
        return fArr;
    }

    private void initializeDragAndDropTargetViewHoldersAndViews(DragAndDropTargetViewHolder.OnTargetItemClickedListener onTargetItemClickedListener, Context context) {
        Iterator<View> it = this.mDragAndDropTargetLayout.getChildContainerViews().iterator();
        int r3 = 0;
        int r4 = 0;
        while (it.hasNext()) {
            KeyEvent.Callback callback = (View) it.next();
            if (callback instanceof ContainerLayout) {
                ContainerLayout containerLayout = (ContainerLayout) callback;
                for (int r14 = 0; r14 < containerLayout.getNumberOfItems(); r14++) {
                    int customGroup = containerLayout.getCustomGroup();
                    if (customGroup != -1) {
                        r4 = customGroup;
                    }
                    DragAndDropTargetViewHolder newInstance = DragAndDropTargetViewHolder.newInstance(r3, r4, null, onTargetItemClickedListener, context, this.mDragAndDropProvider, this.mDragAndDropController);
                    setViewHolder(newInstance, r3);
                    updateViewHolder(r3);
                    r3++;
                    DragItemLayout contentView = newInstance.getContentView();
                    contentView.setTopMargin(containerLayout.getContentSpace());
                    ((ViewGroup) callback).addView(contentView);
                }
                r4++;
            } else {
                throw new RuntimeException("Unexpected type of layout!");
            }
        }
    }

    private DragAndDropTargetViewHolder isOnChildTargetView(int r18, int r19) {
        DragAndDropTargetViewHolder[] items = getItems();
        int length = items.length;
        double d = Double.MAX_VALUE;
        char c = 0;
        DragAndDropTargetViewHolder dragAndDropTargetViewHolder = null;
        int r7 = 0;
        while (r7 < length) {
            DragAndDropTargetViewHolder dragAndDropTargetViewHolder2 = items[r7];
            this.mRes = getVisualCenter(dragAndDropTargetViewHolder2.getDragAndDroppableView(), this.mRes);
            int r16 = r7;
            double hypot = Math.hypot(r10[c] - r18, r10[1] - r19);
            if (hypot < d) {
                d = hypot;
                dragAndDropTargetViewHolder = dragAndDropTargetViewHolder2;
            }
            r7 = r16 + 1;
            c = 0;
        }
        if (d >= this.mSelectedDistance) {
            return null;
        }
        return dragAndDropTargetViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDropOnRemoveTargetAnimationCompleteRunnable$0(DragAndDropDroppableItem dragAndDropDroppableItem) {
        this.mDragAndDropController.stopDragging();
        updateAdapterItemRemoved(dragAndDropDroppableItem);
        resetContainerLayoutsAndDropIndexes();
        if (this.mDragAndDropController.getAdapterType() != 2) {
            DragAndDropController dragAndDropController = this.mDragAndDropController;
            dragAndDropController.hideDropTargets(this.mDragAndDropProvider.getHiddenGroups(dragAndDropController.getTab()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDropOnTargetAnimationCompleteRunnable$1(int r8, DragAndDropDroppableItem dragAndDropDroppableItem) {
        this.mDropAnimationFinished = true;
        DragAndDropTargetViewHolder viewHolder = getViewHolder(r8);
        int[] r3 = new int[2];
        viewHolder.getContentView().getDragAndDroppableView().getLocationInWindow(r3);
        int r5 = r3[0];
        int r0 = r3[1];
        if (viewHolder.getAdapterItem() != null) {
            viewHolder.getAdapterItem().setDropped(false, this.mDragAndDropController.getAdapterType());
        }
        dragAndDropDroppableItem.setCenterX((viewHolder.getContentView().getDragAndDroppableView().getWidth() / 2) + r5);
        dragAndDropDroppableItem.setCenterY((viewHolder.getContentView().getDragAndDroppableView().getHeight() / 2) + r0);
        updateAdapterItemDropped(r8, dragAndDropDroppableItem);
        resetContainerLayoutsAndDropIndexes();
        if (!this.mShouldWaitForRemoveDropTargetAnimation) {
            this.mDragAndDropController.stopDragging();
        } else if (this.mRemoveDropTargetAnimationFinished) {
            this.mDragAndDropController.stopDragging();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRemoveDropOnTargetAnimationCompleteRunnable$2() {
        this.mRemoveDropTargetAnimationFinished = true;
        if (this.mDropAnimationFinished) {
            this.mDragAndDropController.stopDragging();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performLongClick(DragAndDropTargetViewHolder dragAndDropTargetViewHolder) {
        if (!dragAndDropTargetViewHolder.getDragAndDroppableView().isInTouchMode()) {
            return;
        }
        if (this.mDragAndDropProvider.getDisabledGroups(dragAndDropTargetViewHolder.getAdapterItem(), this.mDragAndDropController.getAdapterType()) != null) {
            this.mDragAndDropController.disableDropTargets(this.mDragAndDropProvider.getDisabledGroups(dragAndDropTargetViewHolder.getAdapterItem(), this.mDragAndDropController.getAdapterType()));
        }
        this.mDragAndDropController.beginDragShared(dragAndDropTargetViewHolder.getDragAndDroppableView(), this);
        dragAndDropTargetViewHolder.getAdapterItem().setDraggedFromSourceGridView(true);
        this.mDragAndDropController.startDraggingFromTargetLayout(dragAndDropTargetViewHolder.getAdapterItem().getSourceGridViewIndex(this.mDragAndDropController.getAdapterType()));
        dragAndDropTargetViewHolder.setAdapterItem(null);
        dragAndDropTargetViewHolder.updateViewHolder();
        this.mOldDropOnIndex = dragAndDropTargetViewHolder.getGridPosition();
    }

    private void refreshViewHoldersAndViews() {
        for (DragAndDropItem dragAndDropItem : this.mDragAndDropProvider.getItems(this.mDragAndDropController.getAdapterType())) {
            if (dragAndDropItem instanceof DragAndDropDroppableItem) {
                DragAndDropDroppableItem dragAndDropDroppableItem = (DragAndDropDroppableItem) dragAndDropItem;
                if (dragAndDropDroppableItem.isDropped(this.mDragAndDropController.getAdapterType())) {
                    DragAndDropTargetViewHolder viewHolder = getViewHolder(dragAndDropDroppableItem.getTargetLayoutPosition());
                    DragAndDropTargetViewHolder createViewHolder = this.mDragAndDropTargetContainerAdapter.createViewHolder(viewHolder.getGridPosition(), viewHolder, dragAndDropDroppableItem);
                    createViewHolder.getContentView().setTopMargin(viewHolder.getContentView().getTopMargin());
                    this.mDragAndDropTargetLayout.replaceView(viewHolder.getContentView(), createViewHolder.getContentView());
                    setViewHolder(createViewHolder, dragAndDropDroppableItem.getTargetLayoutPosition());
                    updateViewHolder(dragAndDropDroppableItem.getTargetLayoutPosition());
                }
            }
        }
    }

    private void resetContainerLayoutsAndDropIndexes() {
        this.mDragAndDropTargetLayout.resetContainerLayoutViews();
        resetHoveredDropTargets();
        this.mDropOnIndex = -1;
    }

    private void resetDragAndDropTargetViewHolders() {
        for (DragAndDropTargetViewHolder dragAndDropTargetViewHolder : getItems()) {
            dragAndDropTargetViewHolder.setSelected(false);
        }
    }

    private void setBadgeVisibilityAnimated(int r2, boolean z) {
        this.mItems[r2].setBadgeVisibilityAnimated(z);
    }

    private void setDraggedDrawbleForMarbleView(boolean z, ViewGroup viewGroup) {
        for (int r0 = 0; r0 < viewGroup.getChildCount(); r0++) {
            if (viewGroup.getChildAt(r0) instanceof MarbleView) {
                ((MarbleView) viewGroup.getChildAt(r0)).setIsDragged(z);
            }
        }
    }

    private void setViewHolder(DragAndDropTargetViewHolder dragAndDropTargetViewHolder, int r3) {
        this.mItems[r3] = dragAndDropTargetViewHolder;
    }

    private void updateAdapterItemDropped(int r3, DragAndDropDroppableItem dragAndDropDroppableItem) {
        int r0;
        dragAndDropDroppableItem.setDropped(true, this.mDragAndDropController.getAdapterType());
        DragAndDropTargetViewHolder viewHolder = getViewHolder(r3);
        if (viewHolder != null) {
            r0 = viewHolder.getGroup();
        } else {
            r0 = -1;
        }
        dragAndDropDroppableItem.setGroup(r0);
        dragAndDropDroppableItem.setTargetLayoutPosition(r3);
        dragAndDropDroppableItem.setDraggedFromSourceGridView(false);
        this.mDragAndDropProvider.updateItemData(dragAndDropDroppableItem);
    }

    private void updateAdapterItemRemoved(DragAndDropDroppableItem dragAndDropDroppableItem) {
        dragAndDropDroppableItem.setDropped(false, this.mDragAndDropController.getAdapterType());
        dragAndDropDroppableItem.setGroup(-1);
        dragAndDropDroppableItem.setTargetLayoutPosition(-1);
        dragAndDropDroppableItem.setDraggedFromSourceGridView(false);
        dragAndDropDroppableItem.setAnimatedBack(true);
        this.mDragAndDropProvider.updateItemData(dragAndDropDroppableItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateContainerLayoutsAndDropOnViews(View view) {
        if (view instanceof ContainerLayout) {
            ((ContainerLayout) view).setContainerLayoutSelected(true);
            float[] fArr = this.mDragViewVisualCenter;
            DragAndDropTargetViewHolder isOnChildTargetView = isOnChildTargetView((int) fArr[0], (int) fArr[1]);
            this.mDropOnViewHolder = isOnChildTargetView;
            if (isOnChildTargetView != null && isOnChildTargetView.isEnabled()) {
                if (this.mDropOnViewHolder.getAdapterItem() == null) {
                    this.mDropOnViewHolder.setSelected(true);
                    this.mDropOnViewHolder.getEmptyView().invalidate();
                } else {
                    this.mDropOnViewHolder.setDragAndDroppableViewHovered(true);
                }
            }
            DragAndDropTargetViewHolder dragAndDropTargetViewHolder = this.mDropOnViewHolder;
            if (dragAndDropTargetViewHolder != null && dragAndDropTargetViewHolder.isEnabled()) {
                int gridPosition = this.mDropOnViewHolder.getGridPosition();
                this.mDropOnIndex = gridPosition;
                this.mOldDropOnIndex = gridPosition;
                return;
            }
            this.mDropOnIndex = -1;
            return;
        }
        throw new RuntimeException("Unexpected type of layout!");
    }

    private void updateViewHolder(int r2) {
        this.mItems[r2].updateViewHolder();
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public boolean acceptDrop(DropTarget.DragObject dragObject) {
        return true;
    }

    public void beginDragShared(View view, DragSource dragSource) {
        Point point;
        Rect rect;
        DragAndDropDroppableItem dragAndDropDroppableItem = (DragAndDropDroppableItem) view.getTag();
        this.mAdapterItemDragged = dragAndDropDroppableItem;
        this.mDragAndDropProvider.clearBadgeState(dragAndDropDroppableItem);
        view.clearFocus();
        view.setPressed(false);
        ViewGroup viewGroup = (ViewGroup) view;
        setDraggedDrawbleForMarbleView(true, viewGroup);
        AtomicInteger atomicInteger = new AtomicInteger(2);
        Bitmap createDragBitmap = createDragBitmap(view, atomicInteger);
        setDraggedDrawbleForMarbleView(false, viewGroup);
        int width = createDragBitmap.getWidth();
        int height = createDragBitmap.getHeight();
        float locationInDragLayer = this.mDragLayer.getLocationInDragLayer(view, this.mTempXY);
        int round = Math.round(this.mTempXY[0] - ((width - (view.getWidth() * locationInDragLayer)) / 2.0f));
        float f = height;
        int round2 = Math.round((this.mTempXY[1] - ((f - (locationInDragLayer * f)) / 2.0f)) - (atomicInteger.get() / 2.0f));
        if (view instanceof MarbleView) {
            int paddingTop = view.getPaddingTop();
            int r3 = (width - 100) / 2;
            round2 += paddingTop;
            Point point2 = new Point((-atomicInteger.get()) / 2, atomicInteger.get() / 2);
            rect = new Rect(r3, paddingTop, r3 + 100, paddingTop + 100);
            point = point2;
        } else {
            point = null;
            rect = null;
        }
        this.mDragController.startDrag(createDragBitmap, round, round2, dragSource, view.getTag(), point, rect, locationInDragLayer);
        createDragBitmap.recycle();
    }

    public void destroy(int r2) {
        this.mDragAndDropProvider.unregisterDragAndDropItemsChangedListener(this);
        this.mDragAndDropTargetLayout.destroy(r2);
    }

    public void disabledDropTargets(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            getViewHolder(it.next().intValue()).enableOrDisableViewHolder(false);
        }
    }

    public void dragOverReceivedInSourceGridView() {
        this.mDragAndDropTargetLayout.resetContainerLayoutViews();
        resetHoveredDropTargets();
    }

    public void enableDropTargets() {
        for (DragAndDropTargetViewHolder dragAndDropTargetViewHolder : getItems()) {
            if (this.mDragAndDropProvider.belongsToAdapterType(dragAndDropTargetViewHolder.getGroup(), this.mDragAndDropController.getAdapterType())) {
                dragAndDropTargetViewHolder.enableOrDisableViewHolder(true);
            }
        }
    }

    public View getDragAndDroppableTargetViewForAnimation(int r1) {
        return getDragAndDroppableViewForAnimation(r1);
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public void getHitRectRelativeToDragLayer(Rect rect) {
        this.mDragLayer.getDescendantRectRelativeToSelf(this, rect);
    }

    public void hideDropTargets(List<Integer> list) {
        if (list != null) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                getViewHolder(it.next().intValue()).hideOrShowViewHolder(true);
            }
        }
    }

    public void init(DragAndDropController dragAndDropController, DragAndDropSettings dragAndDropSettings) {
        this.mDragAndDropController = dragAndDropController;
        this.mDragAndDropTargetLayout = dragAndDropSettings.dragAndDropTargetLayout;
        int applyDimension = (int) TypedValue.applyDimension(1, 56.0f, getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, applyDimension, 0, 0);
        this.mDragAndDropTargetLayout.setLayoutParams(layoutParams);
        addView(dragAndDropSettings.toolbarView);
        addView(this.mDragAndDropTargetLayout);
        this.mDragAndDropProvider = dragAndDropSettings.dragAndDropProvider;
        DragAndDropTargetViewHolder.OnTargetItemClickedListener onTargetItemClickedListener = new DragAndDropTargetViewHolder.OnTargetItemClickedListener() { // from class: com.animaconnected.draganddrop.DragAndDropTargetContainerLayout.1
            @Override // com.animaconnected.draganddrop.dataadapter.viewholder.target.DragAndDropTargetViewHolder.OnTargetItemClickedListener
            public void onTargetItemClicked(DragAndDropTargetViewHolder dragAndDropTargetViewHolder) {
                if (DragAndDropTargetContainerLayout.this.mItemClickedListener != null) {
                    dragAndDropTargetViewHolder.getDragAndDroppableView().getLocationInWindow(new int[2]);
                    DragAndDropTargetContainerLayout.this.mItemClickedListener.onItemClicked(dragAndDropTargetViewHolder.getAdapterItem(), dragAndDropTargetViewHolder.getDragAndDroppableView());
                }
            }

            @Override // com.animaconnected.draganddrop.dataadapter.viewholder.target.DragAndDropTargetViewHolder.OnTargetItemClickedListener
            public void onTargetItemDragged(DragAndDropTargetViewHolder dragAndDropTargetViewHolder) {
                DragAndDropTargetContainerLayout.this.performLongClick(dragAndDropTargetViewHolder);
            }
        };
        this.mOnTargetItemClickedListener = onTargetItemClickedListener;
        DragAndDropTargetContainerAdapter dragAndDropTargetContainerAdapter = new DragAndDropTargetContainerAdapter(onTargetItemClickedListener, dragAndDropController.getDragAndDropContext(), this.mDragAndDropProvider, this.mDragAndDropController, this.mDragAndDropTargetLayout);
        this.mItems = new DragAndDropTargetViewHolder[this.mDragAndDropTargetLayout.getItemCount()];
        this.mDragAndDropTargetContainerAdapter = dragAndDropTargetContainerAdapter;
        this.mSelectedDistance = (int) TypedValue.applyDimension(1, 100.0f, getResources().getDisplayMetrics());
        this.mDragAndDropTargetLayout.init(dragAndDropController);
        initializeDragAndDropTargetViewHoldersAndViews(this.mOnTargetItemClickedListener, dragAndDropController.getDragAndDropContext());
        refreshViewHoldersAndViews();
        DragAndDropController dragAndDropController2 = this.mDragAndDropController;
        dragAndDropController2.hideDropTargets(this.mDragAndDropProvider.getHiddenGroups(dragAndDropController2.getAdapterType()));
        this.mDragAndDropProvider.registerDragAndDropItemsChangedListener(this);
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public boolean isDropEnabled() {
        return true;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider.DragAndDropChangedListener
    public void onDragAndDropDataChanged() {
        this.mDragAndDropTargetLayout.lambda$destroy$0();
        initializeDragAndDropTargetViewHoldersAndViews(this.mOnTargetItemClickedListener, this.mDragAndDropController.getDragAndDropContext());
        refreshViewHoldersAndViews();
        if (this.mDragAndDropController.getAdapterType() != 2) {
            DragAndDropController dragAndDropController = this.mDragAndDropController;
            dragAndDropController.hideDropTargets(this.mDragAndDropProvider.getHiddenGroups(dragAndDropController.getTab()));
        }
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public void onDragExit(DropTarget.DragObject dragObject) {
        DragAndDropDroppableItem dragAndDropDroppableItem = this.mAdapterItemDragged;
        if (dragAndDropDroppableItem != null) {
            dragAndDropDroppableItem.setDraggedFromSourceGridView(false);
            this.mDragAndDropController.stopDragging();
            this.mAdapterItemDragged = null;
            resetContainerLayoutsAndDropIndexes();
            resetDragAndDropTargetViewHolders();
        }
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public void onDragOver(DropTarget.DragObject dragObject) {
        this.mDragAndDropController.dragOverReceivedInTargetLayout();
        this.mDragViewVisualCenter = dragObject.getVisualCenter(this.mDragViewVisualCenter);
        this.mDragAndDropTargetLayout.resetContainerLayoutViews();
        resetHoveredDropTargets();
        int r6 = this.mDropOnIndex;
        if (r6 != -1) {
            updateViewHolder(r6);
        }
        DragAndDropTargetLayout dragAndDropTargetLayout = this.mDragAndDropTargetLayout;
        float[] fArr = this.mDragViewVisualCenter;
        View onChildContainerLayoutView = dragAndDropTargetLayout.getOnChildContainerLayoutView((int) fArr[0], (int) fArr[1]);
        float[] fArr2 = this.mDragViewVisualCenter;
        DragAndDropTargetViewHolder isOnChildTargetView = isOnChildTargetView((int) fArr2[0], (int) fArr2[1]);
        if (isOnChildTargetView != null && !this.mDragAndDropProvider.belongsToAdapterType(isOnChildTargetView.getGroup(), this.mDragAndDropController.getAdapterType())) {
            onChildContainerLayoutView = null;
        }
        if (onChildContainerLayoutView != null) {
            updateContainerLayoutsAndDropOnViews(onChildContainerLayoutView);
        } else {
            this.mDropOnIndex = -1;
        }
        invalidate();
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public void onDrop(DropTarget.DragObject dragObject) {
        int r0 = this.mDropOnIndex;
        DragAndDropDroppableItem dragAndDropDroppableItem = (DragAndDropDroppableItem) dragObject.dragInfo;
        if (r0 != -1) {
            Runnable dropOnTargetAnimationCompleteRunnable = getDropOnTargetAnimationCompleteRunnable(r0, dragAndDropDroppableItem);
            if (getViewHolder(r0).getAdapterItem() != null) {
                this.mShouldWaitForRemoveDropTargetAnimation = true;
            }
            this.mDragLayer.animateViewIntoPosition(dragObject.dragView, getDragAndDroppableViewForAnimation(r0), 1.0f, false, 250, dropOnTargetAnimationCompleteRunnable, this);
            if (getViewHolder(r0).getAdapterItem() != null) {
                getViewHolder(r0).setDragAndDroppableViewHovered(false);
                updateAdapterItemRemoved(getViewHolder(r0).getAdapterItem());
                animateBackRemovedView(r0);
                return;
            }
            return;
        }
        Runnable dropOnRemoveTargetAnimationCompleteRunnable = getDropOnRemoveTargetAnimationCompleteRunnable(dragAndDropDroppableItem);
        DragAndDropController dragAndDropController = this.mDragAndDropController;
        if (dragAndDropController.getDragAndDroppableViewForAnimation(dragAndDropDroppableItem.getSourceGridViewIndex(dragAndDropController.getAdapterType())) != null && this.mDragAndDropController.possibleToDrop()) {
            DragLayer dragLayer = this.mDragLayer;
            DragView dragView = dragObject.dragView;
            DragAndDropController dragAndDropController2 = this.mDragAndDropController;
            dragLayer.animateViewIntoPosition(dragView, dragAndDropController2.getDragAndDroppableViewForAnimation(dragAndDropDroppableItem.getSourceGridViewIndex(dragAndDropController2.getAdapterType())), 1.0f, false, 250, dropOnRemoveTargetAnimationCompleteRunnable, this);
            return;
        }
        Runnable dropOnTargetAnimationCompleteRunnable2 = getDropOnTargetAnimationCompleteRunnable(this.mOldDropOnIndex, dragAndDropDroppableItem);
        if (getViewHolder(this.mOldDropOnIndex).getAdapterItem() != null) {
            this.mShouldWaitForRemoveDropTargetAnimation = true;
        }
        this.mDragLayer.animateViewIntoPosition(dragObject.dragView, getDragAndDroppableViewForAnimation(this.mOldDropOnIndex), 1.0f, false, 250, dropOnTargetAnimationCompleteRunnable2, this);
    }

    public void onPause() {
        this.mDragController.cancelDrag();
    }

    public void refreshViews() {
        this.mDragAndDropTargetLayout.lambda$destroy$0();
        initializeDragAndDropTargetViewHoldersAndViews(this.mOnTargetItemClickedListener, this.mDragAndDropController.getDragAndDropContext());
        refreshViewHoldersAndViews();
    }

    public void resetHoveredDropTargets() {
        for (DragAndDropTargetViewHolder dragAndDropTargetViewHolder : getItems()) {
            dragAndDropTargetViewHolder.setDragAndDroppableViewHovered(false);
        }
    }

    public void setItemClickListener(ClickListener clickListener) {
        this.mItemClickedListener = clickListener;
    }

    public void setup(DragController dragController, DragLayer dragLayer) {
        this.mDragController = dragController;
        this.mDragLayer = dragLayer;
    }

    public void showDropTargets() {
        for (DragAndDropTargetViewHolder dragAndDropTargetViewHolder : getItems()) {
            dragAndDropTargetViewHolder.hideOrShowViewHolder(false);
        }
    }

    public DragAndDropTargetContainerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DragAndDropTargetContainerLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mTempXY = new int[2];
        this.mCanvas = new Canvas();
        this.mDragViewVisualCenter = new float[2];
        this.mDropOnIndex = -1;
        this.locations = new int[2];
    }

    @Override // com.animaconnected.draganddrop.dragframework.DragController.DragListener
    public void onDragEnd() {
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public void onDragEnter(DropTarget.DragObject dragObject) {
    }

    @Override // com.animaconnected.draganddrop.dragframework.DragController.DragListener
    public void onDragStart(DragSource dragSource, Object obj) {
    }

    @Override // com.animaconnected.draganddrop.dragframework.DragSource
    public void onDropCompleted(View view, DropTarget.DragObject dragObject, boolean z) {
    }
}
