package com.animaconnected.draganddrop.dataadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.draganddrop.DragAndDropController;
import com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview.DragAndDropHeaderSourceGridViewHolder;
import com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview.DragAndDropIconSourceGridViewHolder;
import com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview.DragAndDropMarbleContactSourceGridViewHolder;
import com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview.DragAndDropMarbleIconSourceGridViewHolder;
import com.animaconnected.draganddrop.dataadapter.viewholder.sourcegridview.DragAndDropSourceGridViewHolderBase;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;
import com.animaconnected.draganddrop.provider.model.ClickListener;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropHeaderItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropIconItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleContactItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleIconItem;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DragAndDropSourceGridViewAdapter extends RecyclerView.Adapter<DragAndDropSourceGridViewHolderBase> implements DragAndDropProvider.DragAndDropChangedListener {
    private static final int GRID_VIEW_HEADER_VIEW_TYPE = 3;
    private static final int GRID_VIEW_ICON_VIEW_TYPE = 1;
    private static final int ITEMS_PER_ROW = 3;
    private static final int MARBLE_CONTACT_VIEW_TYPE = 4;
    public static final int MARBLE_ICON_VIEW_TYPE = 2;
    private final int mAdapterType;
    private DragAndDropController mDragAndDropController;
    private final DragAndDropProvider<Object> mDragAndDropProvider;
    private boolean mFirstStart = true;
    private final SmoothScrollGridLayoutManager mGridLayoutMgr;
    private ClickListener mItemClickedListener;
    private final OnSourceGridItemClickedListener mOnSourceGridItemClickedListener;
    private SourceGridAdapterListener mSourceGridAdapterListener;
    private final String mTabTitle;

    /* loaded from: classes.dex */
    public class GridSpanSizer extends GridLayoutManager.SpanSizeLookup {
        public GridSpanSizer() {
            setSpanIndexCacheEnabled(true);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int r3) {
            if (r3 >= DragAndDropSourceGridViewAdapter.this.getItemCount()) {
                return 0;
            }
            DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter = DragAndDropSourceGridViewAdapter.this;
            if (!(dragAndDropSourceGridViewAdapter.getItems(dragAndDropSourceGridViewAdapter.mAdapterType).get(r3) instanceof DragAndDropDroppableItem)) {
                DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter2 = DragAndDropSourceGridViewAdapter.this;
                if (!(dragAndDropSourceGridViewAdapter2.getItems(dragAndDropSourceGridViewAdapter2.mAdapterType).get(r3) instanceof DragAndDropIconItem)) {
                    return 3;
                }
                return 1;
            }
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public interface SourceGridAdapterListener {
        void onSourceGridItemDragged(View view, DragAndDropDroppableItem dragAndDropDroppableItem);
    }

    public DragAndDropSourceGridViewAdapter(Context context, DragAndDropProvider dragAndDropProvider, int r4, String str) {
        this.mDragAndDropProvider = dragAndDropProvider;
        this.mAdapterType = r4;
        this.mTabTitle = str;
        GridSpanSizer gridSpanSizer = new GridSpanSizer();
        SmoothScrollGridLayoutManager smoothScrollGridLayoutManager = new SmoothScrollGridLayoutManager(context, 3);
        this.mGridLayoutMgr = smoothScrollGridLayoutManager;
        smoothScrollGridLayoutManager.setSpanSizeLookup(gridSpanSizer);
        this.mOnSourceGridItemClickedListener = new OnSourceGridItemClickedListener() { // from class: com.animaconnected.draganddrop.dataadapter.DragAndDropSourceGridViewAdapter.1
            @Override // com.animaconnected.draganddrop.dataadapter.OnSourceGridItemClickedListener
            public void onDragStarted(View view, DragAndDropDroppableItem dragAndDropDroppableItem) {
                if (DragAndDropSourceGridViewAdapter.this.mDragAndDropController.isAnimatorRunning()) {
                    return;
                }
                DragAndDropSourceGridViewAdapter.this.mSourceGridAdapterListener.onSourceGridItemDragged(view, dragAndDropDroppableItem);
                DragAndDropSourceGridViewAdapter.this.notifyDataSetChanged();
            }

            @Override // com.animaconnected.draganddrop.dataadapter.OnSourceGridItemClickedListener
            public void onSourceGridItemClicked(View view, DragAndDropItem dragAndDropItem) {
                if (DragAndDropSourceGridViewAdapter.this.mItemClickedListener != null) {
                    DragAndDropSourceGridViewAdapter.this.mItemClickedListener.onItemClicked(dragAndDropItem, view);
                }
            }
        };
    }

    public void destroy() {
        this.mDragAndDropProvider.unregisterDragAndDropItemsChangedListener(this);
    }

    public void disableDragAndDropSourceGridViewItems(int r5) {
        for (DragAndDropItem dragAndDropItem : getItems(this.mAdapterType)) {
            if (dragAndDropItem instanceof DragAndDropDroppableItem) {
                DragAndDropDroppableItem dragAndDropDroppableItem = (DragAndDropDroppableItem) dragAndDropItem;
                if (dragAndDropDroppableItem.getSourceGridViewIndex(this.mAdapterType) != r5) {
                    dragAndDropDroppableItem.enableOrDisable(false);
                    dragAndDropDroppableItem.setShouldAnimate(true);
                } else {
                    dragAndDropDroppableItem.setShouldAnimate(false);
                }
            }
        }
    }

    public void enableDragAndDropSourceGridViewItems() {
        for (DragAndDropItem dragAndDropItem : getItems(this.mAdapterType)) {
            if (dragAndDropItem instanceof DragAndDropDroppableItem) {
                ((DragAndDropDroppableItem) dragAndDropItem).enableOrDisable(true);
            }
        }
    }

    public int getAdapterType() {
        return this.mAdapterType;
    }

    public int getIndexOfLastMarbleIconViewType() {
        Iterator<DragAndDropItem> it = getItems(this.mAdapterType).iterator();
        int r1 = 0;
        int r2 = 0;
        while (it.hasNext()) {
            if (it.next() instanceof DragAndDropMarbleIconItem) {
                r1 = r2;
            }
            r2++;
        }
        return r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getItems(this.mAdapterType).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r2) {
        DragAndDropItem dragAndDropItem = getItems(this.mAdapterType).get(r2);
        if (dragAndDropItem instanceof DragAndDropDroppableItem) {
            if (dragAndDropItem instanceof DragAndDropMarbleIconItem) {
                return 2;
            }
            if (dragAndDropItem instanceof DragAndDropMarbleContactItem) {
                return 4;
            }
        } else {
            if (dragAndDropItem instanceof DragAndDropHeaderItem) {
                return 3;
            }
            if (dragAndDropItem instanceof DragAndDropIconItem) {
                return 1;
            }
        }
        throw new RuntimeException("Unsupported DragAndDropItem type!");
    }

    public List<DragAndDropItem> getItems(int r2) {
        if (r2 != 2) {
            return this.mDragAndDropProvider.getItems(r2);
        }
        return this.mDragAndDropProvider.getItems();
    }

    public String getTabTitle() {
        return this.mTabTitle;
    }

    public void init(DragAndDropController dragAndDropController) {
        this.mDragAndDropProvider.registerDragAndDropItemsChangedListener(this);
        this.mDragAndDropController = dragAndDropController;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider.DragAndDropChangedListener
    public void onDragAndDropDataChanged() {
        notifyDataSetChanged();
    }

    public void resetAnimations() {
        for (DragAndDropItem dragAndDropItem : getItems(this.mAdapterType)) {
            if (dragAndDropItem instanceof DragAndDropDroppableItem) {
                ((DragAndDropDroppableItem) dragAndDropItem).setAnimatedBack(false);
            }
        }
    }

    public void setFastScrollSpeed() {
        this.mGridLayoutMgr.setFastScrollSpeed();
    }

    public void setFirstStart(boolean z) {
        this.mFirstStart = z;
    }

    public void setItemClickListener(ClickListener clickListener) {
        this.mItemClickedListener = clickListener;
    }

    public void setSlowScrollSpeed() {
        this.mGridLayoutMgr.setSlowScrollSpeed();
    }

    public void setSourceGridAdapterListener(SourceGridAdapterListener sourceGridAdapterListener) {
        this.mSourceGridAdapterListener = sourceGridAdapterListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DragAndDropSourceGridViewHolderBase dragAndDropSourceGridViewHolderBase, int r4) {
        DragAndDropItem dragAndDropItem = getItems(this.mAdapterType).get(r4);
        if (dragAndDropSourceGridViewHolderBase instanceof DragAndDropMarbleContactSourceGridViewHolder) {
            ((DragAndDropMarbleContactSourceGridViewHolder) dragAndDropSourceGridViewHolderBase).setFirstStart(this.mFirstStart);
        }
        dragAndDropSourceGridViewHolderBase.bind(dragAndDropItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DragAndDropSourceGridViewHolderBase onCreateViewHolder(ViewGroup viewGroup, int r4) {
        if (r4 == 1) {
            return DragAndDropIconSourceGridViewHolder.newInstance(viewGroup, this.mOnSourceGridItemClickedListener);
        }
        if (r4 == 2) {
            return DragAndDropMarbleIconSourceGridViewHolder.newInstance(viewGroup, this.mOnSourceGridItemClickedListener, this.mDragAndDropProvider, this.mDragAndDropController);
        }
        if (r4 == 3) {
            return DragAndDropHeaderSourceGridViewHolder.newInstance(viewGroup, this.mDragAndDropProvider.getHeaderTextStyle());
        }
        if (r4 == 4) {
            return DragAndDropMarbleContactSourceGridViewHolder.newInstance(viewGroup, this.mOnSourceGridItemClickedListener, this.mDragAndDropProvider, this.mDragAndDropController);
        }
        throw new RuntimeException("Unexpected view type");
    }
}
