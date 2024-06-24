package com.animaconnected.draganddrop;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.draganddrop.dataadapter.DragAndDropSourceGridViewAdapter;
import com.animaconnected.draganddrop.dataadapter.SmoothScrollGridLayoutManager;
import com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview.DragAndDropSourceGridViewHolder;
import com.animaconnected.draganddrop.dragframework.DragController;
import com.animaconnected.draganddrop.dragframework.DragLayer;
import com.animaconnected.draganddrop.dragframework.DragSource;
import com.animaconnected.draganddrop.dragframework.DragView;
import com.animaconnected.draganddrop.dragframework.DropTarget;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropIconItem;
import com.animaconnected.draganddrop.widget.DragAndDropSourceGridRecyclerViewAdapter;
import com.animaconnected.draganddrop.widget.GridViewController;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DragAndDropSourceGridView extends FrameLayout implements DragSource, DragAndDropSourceGridViewAdapter.SourceGridAdapterListener, DragAndDropProvider.DragAndDropChangedListener, DragAndDropProvider.ViewCreatedListener, DropTarget, DragController.DragListener {
    private static final int DRAGGED_TO_NOT_DRAGGED_DURATION = 250;
    private static final int FLASH_AND_ENABLE_SCROLL_DATA_LOADED_DELAY_MS = 400;
    private static final int FLASH_AND_ENABLE_SCROLL_DELAY_MS = 1000;
    private static final int GRADIENT_ANIMATION_DURATION = 350;
    private static final int INIT_SCROLL_DELAY_MS = 500;
    private static final int INVALID_DROP_AND_DRAG_TARGET_INDEX = -1;
    private static final int ITEMS_PER_ROW = 3;
    private static final int SELECTED_DISTANCE_DP = 70;
    final int[] locations;
    private DragAndDropSourceGridViewAdapter mAdapter;
    private DragAndDropSourceGridViewAdapter mAdapter2;
    private DragAndDropDroppableItem mAdapterItemDragged;
    private int mCurrentAdapterIndex;
    private RecyclerView mCurrentDragAndDropRecyclerView;
    private GridLayoutManager mCurrentLayoutManager;
    private DragAndDropController mDragAndDropController;
    private DragAndDropProvider mDragAndDropProvider;
    private RecyclerView mDragAndDropRecyclerView;
    private RecyclerView mDragAndDropRecyclerView2;
    private DragLayer mDragLayer;
    private float[] mDragViewVisualCenter;
    private int mDropOnIndex;
    DragAndDropSourceGridViewHolder mDropOnViewHolder;
    private final Runnable mFlashAndEnableScrollBarRunnable;
    private GridViewController mGradientViewController;
    private final Handler mHandler;
    private boolean mHasScrollPosition;
    private boolean mInitialStart;
    private GridLayoutManager mLayoutManager;
    private GridLayoutManager mLayoutManager2;
    private DragAndDropSourceGridRecyclerViewAdapter mPagerAdapter;
    private float[] mRes;
    private int mScrollPosition;
    private int mScrollPositionOffset;
    private int mScrollState;
    private int mSelectedDistance;
    private final Runnable mStartInitScrollRunnable;
    protected TabController mTabController;
    private TabLayout mTabLayout;
    private int mViewXOffset;

    /* loaded from: classes.dex */
    public class CustomScrollListener extends RecyclerView.OnScrollListener {
        public CustomScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int r2) {
            DragAndDropSourceGridView.this.mScrollState = r2;
        }
    }

    /* loaded from: classes.dex */
    public class GridSpanSizer extends GridLayoutManager.SpanSizeLookup {
        public GridSpanSizer() {
            setSpanIndexCacheEnabled(true);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int r3) {
            if (r3 >= DragAndDropSourceGridView.this.getCurrentAdapter().getItemCount()) {
                return 0;
            }
            if (!(DragAndDropSourceGridView.this.mDragAndDropProvider.getItems(DragAndDropSourceGridView.this.getAdapterType()).get(r3) instanceof DragAndDropDroppableItem) && !(DragAndDropSourceGridView.this.mDragAndDropProvider.getItems(DragAndDropSourceGridView.this.getAdapterType()).get(r3) instanceof DragAndDropIconItem)) {
                return 3;
            }
            return 1;
        }
    }

    public DragAndDropSourceGridView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateDropTargets(DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter, DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter2) {
        int integer = getResources().getInteger(R.integer.screen_transition_duration_horizontal);
        int integer2 = getResources().getInteger(R.integer.drag_and_drop_target_fade);
        this.mDragAndDropController.cancelDropTargetAnimations();
        this.mDragAndDropController.animateOutDropTargets(this.mDragAndDropProvider.getShownGroups(dragAndDropSourceGridViewAdapter2.getAdapterType()), integer, integer2);
        this.mDragAndDropController.animateInDropTargets(this.mDragAndDropProvider.getShownGroups(dragAndDropSourceGridViewAdapter.getAdapterType()), integer, integer);
    }

    private void animateToTargetView(DragAndDropDroppableItem dragAndDropDroppableItem, DragView dragView) {
        this.mDragLayer.animateViewIntoPosition(dragView, this.mDragAndDropController.getDragAndDroppableTargetViewForAnimation(dragAndDropDroppableItem.getTargetLayoutPosition()), 1.0f, false, 250, getDropOnRemoveTargetAnimationCompleteRunnable(dragAndDropDroppableItem), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flashAndEnableScrollBar() {
        if (!this.mInitialStart) {
            this.mCurrentDragAndDropRecyclerView.setVerticalScrollBarEnabled(true);
            this.mCurrentDragAndDropRecyclerView.scrollBy(0, 1);
            this.mCurrentDragAndDropRecyclerView.scrollBy(0, -1);
            this.mInitialStart = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragAndDropSourceGridViewAdapter getCurrentAdapter() {
        if (this.mCurrentAdapterIndex == 0) {
            return this.mAdapter;
        }
        return this.mAdapter2;
    }

    private Runnable getDropOnRemoveTargetAnimationCompleteRunnable(final DragAndDropDroppableItem dragAndDropDroppableItem) {
        return new Runnable() { // from class: com.animaconnected.draganddrop.DragAndDropSourceGridView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                DragAndDropSourceGridView.this.lambda$getDropOnRemoveTargetAnimationCompleteRunnable$1(dragAndDropDroppableItem);
            }
        };
    }

    private Runnable getDropOnTargetAnimationCompleteRunnable(final DragAndDropDroppableItem dragAndDropDroppableItem) {
        return new Runnable() { // from class: com.animaconnected.draganddrop.DragAndDropSourceGridView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DragAndDropSourceGridView.this.lambda$getDropOnTargetAnimationCompleteRunnable$2(dragAndDropDroppableItem);
            }
        };
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

    private DragAndDropSourceGridViewHolder isOnChildTargetView(int r5, int r6, DragAndDropDroppableItem dragAndDropDroppableItem) {
        View findViewByPosition = this.mCurrentLayoutManager.findViewByPosition(dragAndDropDroppableItem.getSourceGridViewIndex(getCurrentAdapter().getAdapterType()));
        if (findViewByPosition == null) {
            return null;
        }
        DragAndDropSourceGridViewHolder dragAndDropSourceGridViewHolder = (DragAndDropSourceGridViewHolder) this.mCurrentDragAndDropRecyclerView.getChildViewHolder(findViewByPosition);
        this.mRes = getVisualCenter(dragAndDropSourceGridViewHolder.getDragAndDroppableViewForAnimation(), this.mRes);
        double hypot = Math.hypot(r1[0] - r5, r1[1] - r6);
        if (hypot >= Double.MAX_VALUE) {
            dragAndDropSourceGridViewHolder = null;
            hypot = Double.MAX_VALUE;
        }
        if (hypot < this.mSelectedDistance) {
            return dragAndDropSourceGridViewHolder;
        }
        this.mDropOnIndex = -1;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDropOnRemoveTargetAnimationCompleteRunnable$1(DragAndDropDroppableItem dragAndDropDroppableItem) {
        updateAdapterItemDropped(dragAndDropDroppableItem);
        this.mDragAndDropController.stopDragging();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDropOnTargetAnimationCompleteRunnable$2(DragAndDropDroppableItem dragAndDropDroppableItem) {
        RecyclerView.ViewHolder viewHolder;
        updateAdapterItemRemoved(dragAndDropDroppableItem);
        View findViewByPosition = this.mCurrentLayoutManager.findViewByPosition(this.mDropOnIndex);
        if (findViewByPosition != null) {
            viewHolder = this.mCurrentDragAndDropRecyclerView.getChildViewHolder(findViewByPosition);
        } else {
            viewHolder = null;
        }
        if (viewHolder instanceof DragAndDropSourceGridViewHolder) {
            ((DragAndDropSourceGridViewHolder) viewHolder).getAdapterItem().setDraggedFromSourceGridView(false);
        }
        resetContainerLayoutsAndDropIndexes();
        this.mDragAndDropController.stopDragging();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$init$0(View view, MotionEvent motionEvent) {
        return this.mDragAndDropController.isDragging();
    }

    private void performLongClick(View view) {
        if (!view.isInTouchMode()) {
            return;
        }
        this.mDragAndDropController.startDraggingFromSourceGridView();
        this.mDragAndDropController.beginDragShared(view, this);
        setFirstStart(false);
    }

    private void resetContainerLayoutViews() {
        for (int r1 = 0; r1 < getCurrentAdapter().getItemCount(); r1++) {
            View findViewByPosition = this.mCurrentLayoutManager.findViewByPosition(r1);
            if (findViewByPosition != null) {
                RecyclerView.ViewHolder childViewHolder = this.mCurrentDragAndDropRecyclerView.getChildViewHolder(findViewByPosition);
                if (childViewHolder instanceof DragAndDropSourceGridViewHolder) {
                    ((DragAndDropSourceGridViewHolder) childViewHolder).setSelected(false);
                }
            }
        }
    }

    private void resetContainerLayoutsAndDropIndexes() {
        this.mDropOnIndex = -1;
    }

    private void setPageChangeListener() {
        this.mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.animaconnected.draganddrop.DragAndDropSourceGridView.2
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                DragAndDropSourceGridView.this.mCurrentAdapterIndex = tab.position;
                int r4 = tab.position;
                if (r4 != 0) {
                    if (r4 == 1) {
                        DragAndDropSourceGridView dragAndDropSourceGridView = DragAndDropSourceGridView.this;
                        dragAndDropSourceGridView.mCurrentDragAndDropRecyclerView = dragAndDropSourceGridView.mDragAndDropRecyclerView2;
                        DragAndDropSourceGridView dragAndDropSourceGridView2 = DragAndDropSourceGridView.this;
                        dragAndDropSourceGridView2.mCurrentLayoutManager = dragAndDropSourceGridView2.mLayoutManager2;
                        DragAndDropSourceGridView.this.mDragAndDropController.showDropTargets();
                        DragAndDropSourceGridView dragAndDropSourceGridView3 = DragAndDropSourceGridView.this;
                        dragAndDropSourceGridView3.animateDropTargets(dragAndDropSourceGridView3.mAdapter2, DragAndDropSourceGridView.this.mAdapter);
                        DragAndDropSourceGridView dragAndDropSourceGridView4 = DragAndDropSourceGridView.this;
                        dragAndDropSourceGridView4.mViewXOffset = dragAndDropSourceGridView4.mDragAndDropRecyclerView.getWidth();
                        DragAndDropSourceGridView.this.mGradientViewController.animateRecyclerView(-DragAndDropSourceGridView.this.mViewXOffset, DragAndDropSourceGridView.this.mViewXOffset, 350);
                        DragAndDropSourceGridView dragAndDropSourceGridView5 = DragAndDropSourceGridView.this;
                        dragAndDropSourceGridView5.mTabController.tabChanged(dragAndDropSourceGridView5.mAdapter2.getAdapterType());
                        return;
                    }
                    return;
                }
                DragAndDropSourceGridView dragAndDropSourceGridView6 = DragAndDropSourceGridView.this;
                dragAndDropSourceGridView6.mCurrentDragAndDropRecyclerView = dragAndDropSourceGridView6.mDragAndDropRecyclerView;
                DragAndDropSourceGridView dragAndDropSourceGridView7 = DragAndDropSourceGridView.this;
                dragAndDropSourceGridView7.mCurrentLayoutManager = dragAndDropSourceGridView7.mLayoutManager;
                DragAndDropSourceGridView.this.mDragAndDropController.showDropTargets();
                DragAndDropSourceGridView dragAndDropSourceGridView8 = DragAndDropSourceGridView.this;
                dragAndDropSourceGridView8.animateDropTargets(dragAndDropSourceGridView8.mAdapter, DragAndDropSourceGridView.this.mAdapter2);
                DragAndDropSourceGridView dragAndDropSourceGridView9 = DragAndDropSourceGridView.this;
                dragAndDropSourceGridView9.mViewXOffset = dragAndDropSourceGridView9.mDragAndDropRecyclerView.getWidth();
                DragAndDropSourceGridView.this.mGradientViewController.animateRecyclerView(0, DragAndDropSourceGridView.this.mViewXOffset, 350);
                DragAndDropSourceGridView dragAndDropSourceGridView10 = DragAndDropSourceGridView.this;
                dragAndDropSourceGridView10.mTabController.tabChanged(dragAndDropSourceGridView10.mAdapter.getAdapterType());
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
    }

    private void startScroll() {
        int r0 = this.mScrollPosition;
        if (r0 != -1 && this.mHasScrollPosition) {
            this.mCurrentLayoutManager.scrollToPositionWithOffset(r0, this.mScrollPositionOffset);
            this.mHasScrollPosition = false;
        }
    }

    private void updateAdapterItemDropped(DragAndDropDroppableItem dragAndDropDroppableItem) {
        dragAndDropDroppableItem.setDropped(true, getCurrentAdapter().getAdapterType());
        dragAndDropDroppableItem.setDraggedFromSourceGridView(false);
        this.mDragAndDropProvider.updateItemData(dragAndDropDroppableItem);
    }

    private void updateAdapterItemRemoved(DragAndDropDroppableItem dragAndDropDroppableItem) {
        dragAndDropDroppableItem.setDropped(false, getCurrentAdapter().getAdapterType());
        dragAndDropDroppableItem.setGroup(-1);
        dragAndDropDroppableItem.setTargetLayoutPosition(-1);
        dragAndDropDroppableItem.setDraggedFromSourceGridView(false);
        this.mDragAndDropProvider.updateItemData(dragAndDropDroppableItem);
    }

    private void updateContainerLayoutsAndDropOnViews(DragAndDropDroppableItem dragAndDropDroppableItem) {
        float[] fArr = this.mDragViewVisualCenter;
        DragAndDropSourceGridViewHolder isOnChildTargetView = isOnChildTargetView((int) fArr[0], (int) fArr[1], dragAndDropDroppableItem);
        DragAndDropSourceGridViewHolder dragAndDropSourceGridViewHolder = this.mDropOnViewHolder;
        if (dragAndDropSourceGridViewHolder != null && isOnChildTargetView != null && !dragAndDropSourceGridViewHolder.equals(isOnChildTargetView)) {
            this.mDropOnViewHolder = null;
        }
        if (isOnChildTargetView == null) {
            if (this.mDropOnViewHolder != null) {
                resetContainerLayoutViews();
            }
        } else if (this.mDropOnViewHolder == null) {
            isOnChildTargetView.setSelected(true);
        }
        this.mDropOnViewHolder = isOnChildTargetView;
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public boolean acceptDrop(DropTarget.DragObject dragObject) {
        return true;
    }

    public void destroy() {
        this.mHandler.removeCallbacks(this.mStartInitScrollRunnable);
        this.mDragAndDropProvider.unregisterDragAndDropItemsChangedListener(this);
        this.mDragAndDropProvider.unregisterViewCreatedListener(this);
    }

    public void disableDragAndDropSourceGridViewItems(int r2) {
        getCurrentAdapter().disableDragAndDropSourceGridViewItems(r2);
    }

    public void dragOverReceivedInTargetLayout() {
        resetContainerLayoutViews();
    }

    public void enableDragAndDropSourceGridViewItems() {
        getCurrentAdapter().enableDragAndDropSourceGridViewItems();
    }

    public int getAdapterType() {
        if (this.mCurrentAdapterIndex == 0) {
            return this.mAdapter.getAdapterType();
        }
        return this.mAdapter2.getAdapterType();
    }

    public View getDragAndDroppableViewForAnimation(int r3) {
        View findViewByPosition = this.mCurrentLayoutManager.findViewByPosition(r3);
        if (findViewByPosition == null) {
            return null;
        }
        RecyclerView.ViewHolder childViewHolder = this.mCurrentDragAndDropRecyclerView.getChildViewHolder(findViewByPosition);
        if (!(childViewHolder instanceof DragAndDropSourceGridViewHolder)) {
            return null;
        }
        return ((DragAndDropSourceGridViewHolder) childViewHolder).getDragAndDroppableViewForAnimation();
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public void getHitRectRelativeToDragLayer(Rect rect) {
        this.mDragLayer.getDescendantRectRelativeToSelf(this, rect);
    }

    public RecyclerView getRecyclerView() {
        return this.mCurrentDragAndDropRecyclerView;
    }

    public int[] getScrollPositionAndOffset(int[] r5) {
        int top;
        if (r5 == null) {
            r5 = new int[2];
        }
        int findFirstVisibleItemPosition = this.mCurrentLayoutManager.findFirstVisibleItemPosition();
        View childAt = this.mCurrentDragAndDropRecyclerView.getChildAt(0);
        if (childAt == null) {
            top = 0;
        } else {
            top = childAt.getTop() - this.mCurrentDragAndDropRecyclerView.getPaddingTop();
        }
        r5[0] = findFirstVisibleItemPosition;
        r5[1] = top;
        return r5;
    }

    public void init(DragAndDropController dragAndDropController, DragLayer dragLayer, DragAndDropSettings dragAndDropSettings) {
        int intValue;
        this.mDragAndDropController = dragAndDropController;
        this.mDragLayer = dragLayer;
        this.mTabController = dragAndDropSettings.tabController;
        this.mAdapter = dragAndDropSettings.dragAndDropSourceGridViewAdapter1;
        this.mAdapter2 = dragAndDropSettings.dragAndDropSourceGridViewAdapter2;
        Integer num = dragAndDropSettings.sourceGridColor;
        if (num == null) {
            intValue = getResources().getColor(R.color.transparent);
        } else {
            intValue = num.intValue();
        }
        GridSpanSizer gridSpanSizer = new GridSpanSizer();
        SmoothScrollGridLayoutManager smoothScrollGridLayoutManager = new SmoothScrollGridLayoutManager(dragAndDropController.getDragAndDropContext(), 3);
        smoothScrollGridLayoutManager.setSpanSizeLookup(gridSpanSizer);
        SmoothScrollGridLayoutManager smoothScrollGridLayoutManager2 = new SmoothScrollGridLayoutManager(dragAndDropController.getDragAndDropContext(), 3);
        smoothScrollGridLayoutManager2.setSpanSizeLookup(gridSpanSizer);
        this.mLayoutManager = smoothScrollGridLayoutManager;
        this.mLayoutManager2 = smoothScrollGridLayoutManager2;
        this.mAdapter.setSourceGridAdapterListener(this);
        DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter = this.mAdapter2;
        if (dragAndDropSourceGridViewAdapter != null) {
            dragAndDropSourceGridViewAdapter.setSourceGridAdapterListener(this);
        }
        this.mDragAndDropRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mDragAndDropRecyclerView.setAdapter(this.mAdapter);
        this.mDragAndDropRecyclerView.setHasFixedSize(true);
        this.mDragAndDropRecyclerView.setVerticalScrollBarEnabled(false);
        this.mDragAndDropRecyclerView.addOnScrollListener(new CustomScrollListener());
        this.mDragAndDropRecyclerView.setBackgroundColor(intValue);
        if (this.mAdapter2 != null) {
            this.mDragAndDropRecyclerView2.setLayoutManager(this.mLayoutManager2);
            this.mDragAndDropRecyclerView2.setAdapter(this.mAdapter2);
            this.mDragAndDropRecyclerView2.setHasFixedSize(true);
            this.mDragAndDropRecyclerView2.setVerticalScrollBarEnabled(false);
            this.mDragAndDropRecyclerView2.addOnScrollListener(new CustomScrollListener());
            this.mTabLayout.setVisibility(0);
            this.mDragAndDropRecyclerView2.setBackgroundColor(intValue);
        }
        this.mCurrentDragAndDropRecyclerView = this.mDragAndDropRecyclerView;
        setBackgroundColor(intValue);
        this.mCurrentLayoutManager = this.mLayoutManager;
        this.mAdapter.init(dragAndDropController);
        DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter2 = this.mAdapter2;
        if (dragAndDropSourceGridViewAdapter2 != null) {
            dragAndDropSourceGridViewAdapter2.init(dragAndDropController);
            this.mPagerAdapter = new DragAndDropSourceGridRecyclerViewAdapter();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mAdapter.getTabTitle());
            arrayList.add(this.mAdapter2.getTabTitle());
            this.mPagerAdapter.setData(arrayList);
            setTabs();
            setCustomTabStyle(dragAndDropSettings.tabTextStyle, dragAndDropSettings.tabSelectIndicatorColor);
            setPageChangeListener();
            LinearLayout linearLayout = (LinearLayout) this.mTabLayout.getChildAt(0);
            for (int r7 = 0; r7 < linearLayout.getChildCount(); r7++) {
                linearLayout.getChildAt(r7).setOnTouchListener(new View.OnTouchListener() { // from class: com.animaconnected.draganddrop.DragAndDropSourceGridView$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean lambda$init$0;
                        lambda$init$0 = DragAndDropSourceGridView.this.lambda$init$0(view, motionEvent);
                        return lambda$init$0;
                    }
                });
            }
        }
        DragAndDropProvider<Object> dragAndDropProvider = dragAndDropSettings.dragAndDropProvider;
        this.mDragAndDropProvider = dragAndDropProvider;
        dragAndDropProvider.registerDragAndDropItemsChangedListener(this);
        this.mDragAndDropProvider.registerViewCreatedListener(this);
        if (this.mAdapter2 != null) {
            this.mCurrentAdapterIndex = 0;
            this.mGradientViewController = new GridViewController(this.mDragAndDropRecyclerView, this.mDragAndDropRecyclerView2);
        }
        this.mSelectedDistance = (int) TypedValue.applyDimension(1, 70.0f, getResources().getDisplayMetrics());
    }

    public boolean isAnimatorRunning() {
        if (this.mAdapter2 != null && this.mGradientViewController.isAnimatorRunning()) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public boolean isDropEnabled() {
        return true;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider.DragAndDropChangedListener
    public void onDragAndDropDataChanged() {
        this.mHandler.postDelayed(this.mFlashAndEnableScrollBarRunnable, 400L);
        startScroll();
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public void onDragExit(DropTarget.DragObject dragObject) {
        DragAndDropDroppableItem dragAndDropDroppableItem = this.mAdapterItemDragged;
        if (dragAndDropDroppableItem != null) {
            dragAndDropDroppableItem.setDraggedFromSourceGridView(false);
            this.mDragAndDropController.stopDragging();
            this.mAdapterItemDragged = null;
            resetContainerLayoutsAndDropIndexes();
        }
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public void onDragOver(DropTarget.DragObject dragObject) {
        DragAndDropDroppableItem dragAndDropDroppableItem = (DragAndDropDroppableItem) dragObject.dragInfo;
        this.mAdapterItemDragged = dragAndDropDroppableItem;
        this.mDragAndDropController.dragOverReceivedInSourceGridView();
        this.mDragViewVisualCenter = dragObject.getVisualCenter(this.mDragViewVisualCenter);
        updateContainerLayoutsAndDropOnViews(dragAndDropDroppableItem);
        if (this.mCurrentLayoutManager.findViewByPosition(dragAndDropDroppableItem.getSourceGridViewIndex(getCurrentAdapter().getAdapterType())) == null) {
            return;
        }
        this.mDropOnIndex = dragAndDropDroppableItem.getSourceGridViewIndex(getCurrentAdapter().getAdapterType());
    }

    @Override // com.animaconnected.draganddrop.dragframework.DropTarget
    public void onDrop(DropTarget.DragObject dragObject) {
        DragAndDropDroppableItem dragAndDropDroppableItem = (DragAndDropDroppableItem) dragObject.dragInfo;
        if (this.mDropOnIndex != -1) {
            Runnable dropOnTargetAnimationCompleteRunnable = getDropOnTargetAnimationCompleteRunnable(dragAndDropDroppableItem);
            if (getDragAndDroppableViewForAnimation(this.mDropOnIndex) != null && possibleToDrop()) {
                this.mDragLayer.animateViewIntoPosition(dragObject.dragView, getDragAndDroppableViewForAnimation(this.mDropOnIndex), 1.0f, false, 250, dropOnTargetAnimationCompleteRunnable, this);
                return;
            } else {
                animateToTargetView(dragAndDropDroppableItem, dragObject.dragView);
                return;
            }
        }
        animateToTargetView(dragAndDropDroppableItem, dragObject.dragView);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mDragAndDropRecyclerView = (RecyclerView) findViewById(R.id.draganddrop_list_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.draganddrop_list_view2);
        this.mDragAndDropRecyclerView2 = recyclerView;
        recyclerView.setVisibility(8);
        this.mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
    }

    @Override // com.animaconnected.draganddrop.dataadapter.DragAndDropSourceGridViewAdapter.SourceGridAdapterListener
    public void onSourceGridItemDragged(View view, DragAndDropDroppableItem dragAndDropDroppableItem) {
        view.setTag(dragAndDropDroppableItem);
        if (this.mCurrentAdapterIndex == 0) {
            if (this.mDragAndDropProvider.getDisabledGroups(dragAndDropDroppableItem, this.mAdapter.getAdapterType()) != null) {
                this.mDragAndDropController.disableDropTargets(this.mDragAndDropProvider.getDisabledGroups(dragAndDropDroppableItem, this.mAdapter.getAdapterType()));
            }
        } else if (this.mDragAndDropProvider.getDisabledGroups(dragAndDropDroppableItem, this.mAdapter2.getAdapterType()) != null) {
            this.mDragAndDropController.disableDropTargets(this.mDragAndDropProvider.getDisabledGroups(dragAndDropDroppableItem, this.mAdapter2.getAdapterType()));
        }
        disableDragAndDropSourceGridViewItems(dragAndDropDroppableItem.getSourceGridViewIndex(getCurrentAdapter().getAdapterType()));
        performLongClick(view);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider.ViewCreatedListener
    public void onViewCreated() {
        this.mHandler.postDelayed(this.mFlashAndEnableScrollBarRunnable, 1000L);
        startScroll();
    }

    public boolean possibleToDrop() {
        if (this.mScrollState == 0) {
            return true;
        }
        return false;
    }

    public void refreshViews() {
        getCurrentAdapter().notifyDataSetChanged();
        if (this.mAdapter2 != null) {
            this.mDragAndDropController.hideDropTargets(this.mDragAndDropProvider.getHiddenGroups(getCurrentAdapter().getAdapterType()));
        }
    }

    public void resetAnimations() {
        getCurrentAdapter().resetAnimations();
    }

    public void scrollToLastMarbleIcon() {
        this.mCurrentDragAndDropRecyclerView.scrollToPosition(getCurrentAdapter().getIndexOfLastMarbleIconViewType());
    }

    public void scrollToPosition(int r2) {
        getCurrentAdapter().setFastScrollSpeed();
        this.mCurrentDragAndDropRecyclerView.smoothScrollToPosition(r2);
    }

    public void setCustomTabStyle(int r9, int r10) {
        this.mTabLayout.setSelectedTabIndicatorColor(r10);
        ViewGroup viewGroup = (ViewGroup) this.mTabLayout.getChildAt(0);
        int childCount = viewGroup.getChildCount();
        for (int r2 = 0; r2 < childCount; r2++) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(r2);
            int childCount2 = viewGroup2.getChildCount();
            for (int r5 = 0; r5 < childCount2; r5++) {
                View childAt = viewGroup2.getChildAt(r5);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextAppearance(r9);
                }
            }
        }
    }

    public void setFirstStart(boolean z) {
        getCurrentAdapter().setFirstStart(z);
    }

    public void setScrollPosition(int r1, int r2) {
        this.mScrollPosition = r1;
        this.mScrollPositionOffset = r2;
        this.mHasScrollPosition = true;
    }

    public void setTabs() {
        for (int r1 = 0; r1 < this.mPagerAdapter.getCount(); r1++) {
            TabLayout.Tab newTab = this.mTabLayout.newTab();
            newTab.setText(this.mPagerAdapter.getPageTitle(r1));
            TabLayout tabLayout = this.mTabLayout;
            tabLayout.addTab(newTab, tabLayout.tabs.isEmpty());
            this.mTabLayout.setTabGravity(0);
        }
    }

    public void startInitialScroll() {
        scrollToLastMarbleIcon();
        this.mHandler.postDelayed(this.mStartInitScrollRunnable, 500L);
    }

    public DragAndDropSourceGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DragAndDropSourceGridView(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mScrollPosition = -1;
        this.mScrollPositionOffset = -1;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDropOnIndex = -1;
        this.mStartInitScrollRunnable = new Runnable() { // from class: com.animaconnected.draganddrop.DragAndDropSourceGridView.1
            @Override // java.lang.Runnable
            public void run() {
                DragAndDropSourceGridView.this.getCurrentAdapter().setSlowScrollSpeed();
                DragAndDropSourceGridView.this.mCurrentDragAndDropRecyclerView.smoothScrollToPosition(0);
            }
        };
        this.mFlashAndEnableScrollBarRunnable = new Runnable() { // from class: com.animaconnected.draganddrop.DragAndDropSourceGridView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DragAndDropSourceGridView.this.flashAndEnableScrollBar();
            }
        };
        this.mDragViewVisualCenter = new float[2];
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
