package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {
    public RecyclerView mRecyclerView;
    public final AnonymousClass1 mScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.SnapHelper.1
        public boolean mScrolled = false;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView recyclerView, int r2) {
            super.onScrollStateChanged(recyclerView, r2);
            if (r2 == 0 && this.mScrolled) {
                this.mScrolled = false;
                SnapHelper.this.snapToTargetExistingView();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int r2, int r3) {
            if (r2 != 0 || r3 != 0) {
                this.mScrolled = true;
            }
        }
    };

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view);

    public final void snapToTargetExistingView() {
        RecyclerView.LayoutManager layoutManager;
        View view;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        PagerSnapHelper pagerSnapHelper = (PagerSnapHelper) this;
        if (layoutManager.canScrollVertically()) {
            view = PagerSnapHelper.findCenterView(layoutManager, pagerSnapHelper.getVerticalHelper(layoutManager));
        } else if (layoutManager.canScrollHorizontally()) {
            view = PagerSnapHelper.findCenterView(layoutManager, pagerSnapHelper.getHorizontalHelper(layoutManager));
        } else {
            view = null;
        }
        if (view == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, view);
        int r1 = calculateDistanceToFinalSnap[0];
        if (r1 != 0 || calculateDistanceToFinalSnap[1] != 0) {
            this.mRecyclerView.smoothScrollBy(r1, calculateDistanceToFinalSnap[1]);
        }
    }
}
