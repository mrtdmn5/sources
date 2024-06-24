package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class GapWorker implements Runnable {
    public static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal<>();
    public static final AnonymousClass1 sTaskComparator = new AnonymousClass1();
    public long mFrameIntervalNs;
    public long mPostTimeNs;
    public final ArrayList<RecyclerView> mRecyclerViews = new ArrayList<>();
    public final ArrayList<Task> mTasks = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.GapWorker$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Comparator<Task> {
        /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:            return 1;     */
        /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:            return -1;     */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:            if (r0 != false) goto L14;     */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:            if (r0 == null) goto L13;     */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int compare(androidx.recyclerview.widget.GapWorker.Task r7, androidx.recyclerview.widget.GapWorker.Task r8) {
            /*
                r6 = this;
                androidx.recyclerview.widget.GapWorker$Task r7 = (androidx.recyclerview.widget.GapWorker.Task) r7
                androidx.recyclerview.widget.GapWorker$Task r8 = (androidx.recyclerview.widget.GapWorker.Task) r8
                androidx.recyclerview.widget.RecyclerView r0 = r7.view
                r1 = 0
                r2 = 1
                if (r0 != 0) goto Lc
                r3 = r2
                goto Ld
            Lc:
                r3 = r1
            Ld:
                androidx.recyclerview.widget.RecyclerView r4 = r8.view
                if (r4 != 0) goto L13
                r4 = r2
                goto L14
            L13:
                r4 = r1
            L14:
                r5 = -1
                if (r3 == r4) goto L1d
                if (r0 != 0) goto L1b
            L19:
                r1 = r2
                goto L37
            L1b:
                r1 = r5
                goto L37
            L1d:
                boolean r0 = r7.immediate
                boolean r3 = r8.immediate
                if (r0 == r3) goto L26
                if (r0 == 0) goto L19
                goto L1b
            L26:
                int r0 = r8.viewVelocity
                int r2 = r7.viewVelocity
                int r0 = r0 - r2
                if (r0 == 0) goto L2f
                r1 = r0
                goto L37
            L2f:
                int r7 = r7.distanceToItem
                int r8 = r8.distanceToItem
                int r7 = r7 - r8
                if (r7 == 0) goto L37
                r1 = r7
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GapWorker.AnonymousClass1.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        public int mCount;
        public int[] mPrefetchArray;
        public int mPrefetchDx;
        public int mPrefetchDy;

        public final void addPosition(int r6, int r7) {
            if (r6 >= 0) {
                if (r7 >= 0) {
                    int r0 = this.mCount * 2;
                    int[] r1 = this.mPrefetchArray;
                    if (r1 == null) {
                        int[] r12 = new int[4];
                        this.mPrefetchArray = r12;
                        Arrays.fill(r12, -1);
                    } else if (r0 >= r1.length) {
                        int[] r2 = new int[r0 * 2];
                        this.mPrefetchArray = r2;
                        System.arraycopy(r1, 0, r2, 0, r1.length);
                    }
                    int[] r13 = this.mPrefetchArray;
                    r13[r0] = r6;
                    r13[r0 + 1] = r7;
                    this.mCount++;
                    return;
                }
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        public final void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z) {
            this.mCount = 0;
            int[] r0 = this.mPrefetchArray;
            if (r0 != null) {
                Arrays.fill(r0, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
                }
                int r1 = this.mCount;
                if (r1 > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = r1;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;
    }

    public static RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int r6, long j) {
        boolean z;
        int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
        int r2 = 0;
        while (true) {
            if (r2 < unfilteredChildCount) {
                RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(r2));
                if (childViewHolderInt.mPosition == r6 && !childViewHolderInt.isInvalid()) {
                    z = true;
                    break;
                }
                r2++;
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(r6, j);
            if (tryGetViewHolderForPositionByDeadline != null) {
                if (tryGetViewHolderForPositionByDeadline.isBound() && !tryGetViewHolderForPositionByDeadline.isInvalid()) {
                    recycler.recycleView(tryGetViewHolderForPositionByDeadline.itemView);
                } else {
                    recycler.addViewHolderToRecycledViewPool(tryGetViewHolderForPositionByDeadline, false);
                }
            }
            return tryGetViewHolderForPositionByDeadline;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public final void postFromTraversal(RecyclerView recyclerView, int r6, int r7) {
        if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.mPrefetchDx = r6;
        layoutPrefetchRegistryImpl.mPrefetchDy = r7;
    }

    public final void prefetch(long j) {
        Task task;
        RecyclerView recyclerView;
        long j2;
        RecyclerView recyclerView2;
        Task task2;
        boolean z;
        ArrayList<RecyclerView> arrayList = this.mRecyclerViews;
        int size = arrayList.size();
        int r5 = 0;
        for (int r4 = 0; r4 < size; r4++) {
            RecyclerView recyclerView3 = arrayList.get(r4);
            if (recyclerView3.getWindowVisibility() == 0) {
                recyclerView3.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView3, false);
                r5 += recyclerView3.mPrefetchRegistry.mCount;
            }
        }
        ArrayList<Task> arrayList2 = this.mTasks;
        arrayList2.ensureCapacity(r5);
        int r6 = 0;
        for (int r52 = 0; r52 < size; r52++) {
            RecyclerView recyclerView4 = arrayList.get(r52);
            if (recyclerView4.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView4.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx);
                for (int r10 = 0; r10 < layoutPrefetchRegistryImpl.mCount * 2; r10 += 2) {
                    if (r6 >= arrayList2.size()) {
                        task2 = new Task();
                        arrayList2.add(task2);
                    } else {
                        task2 = arrayList2.get(r6);
                    }
                    int[] r13 = layoutPrefetchRegistryImpl.mPrefetchArray;
                    int r14 = r13[r10 + 1];
                    if (r14 <= abs) {
                        z = true;
                    } else {
                        z = false;
                    }
                    task2.immediate = z;
                    task2.viewVelocity = abs;
                    task2.distanceToItem = r14;
                    task2.view = recyclerView4;
                    task2.position = r13[r10];
                    r6++;
                }
            }
        }
        Collections.sort(arrayList2, sTaskComparator);
        for (int r0 = 0; r0 < arrayList2.size() && (recyclerView = (task = arrayList2.get(r0)).view) != null; r0++) {
            if (task.immediate) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = j;
            }
            RecyclerView.ViewHolder prefetchPositionWithDeadline = prefetchPositionWithDeadline(recyclerView, task.position, j2);
            if (prefetchPositionWithDeadline != null && prefetchPositionWithDeadline.mNestedRecyclerView != null && prefetchPositionWithDeadline.isBound() && !prefetchPositionWithDeadline.isInvalid() && (recyclerView2 = prefetchPositionWithDeadline.mNestedRecyclerView.get()) != null) {
                if (recyclerView2.mDataSetHasChangedAfterLayout && recyclerView2.mChildHelper.getUnfilteredChildCount() != 0) {
                    recyclerView2.removeAndRecycleViews();
                }
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl2 = recyclerView2.mPrefetchRegistry;
                layoutPrefetchRegistryImpl2.collectPrefetchPositionsFromView(recyclerView2, true);
                if (layoutPrefetchRegistryImpl2.mCount != 0) {
                    try {
                        int r9 = TraceCompat.$r8$clinit;
                        TraceCompat.Api18Impl.beginSection("RV Nested Prefetch");
                        RecyclerView.State state = recyclerView2.mState;
                        RecyclerView.Adapter adapter = recyclerView2.mAdapter;
                        state.mLayoutStep = 1;
                        state.mItemCount = adapter.getItemCount();
                        state.mInPreLayout = false;
                        state.mTrackOldChangeHolders = false;
                        state.mIsMeasuring = false;
                        for (int r8 = 0; r8 < layoutPrefetchRegistryImpl2.mCount * 2; r8 += 2) {
                            prefetchPositionWithDeadline(recyclerView2, layoutPrefetchRegistryImpl2.mPrefetchArray[r8], j);
                        }
                        TraceCompat.Api18Impl.endSection();
                        task.immediate = false;
                        task.viewVelocity = 0;
                        task.distanceToItem = 0;
                        task.view = null;
                        task.position = 0;
                    } catch (Throwable th) {
                        int r2 = TraceCompat.$r8$clinit;
                        TraceCompat.Api18Impl.endSection();
                        throw th;
                    }
                }
            }
            task.immediate = false;
            task.viewVelocity = 0;
            task.distanceToItem = 0;
            task.view = null;
            task.position = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int r3 = TraceCompat.$r8$clinit;
            TraceCompat.Api18Impl.beginSection("RV Prefetch");
            ArrayList<RecyclerView> arrayList = this.mRecyclerViews;
            if (arrayList.isEmpty()) {
                this.mPostTimeNs = 0L;
                TraceCompat.Api18Impl.endSection();
                return;
            }
            int size = arrayList.size();
            long j = 0;
            for (int r4 = 0; r4 < size; r4++) {
                RecyclerView recyclerView = arrayList.get(r4);
                if (recyclerView.getWindowVisibility() == 0) {
                    j = Math.max(recyclerView.getDrawingTime(), j);
                }
            }
            if (j == 0) {
                this.mPostTimeNs = 0L;
                TraceCompat.Api18Impl.endSection();
            } else {
                prefetch(TimeUnit.MILLISECONDS.toNanos(j) + this.mFrameIntervalNs);
                this.mPostTimeNs = 0L;
                TraceCompat.Api18Impl.endSection();
            }
        } catch (Throwable th) {
            this.mPostTimeNs = 0L;
            int r0 = TraceCompat.$r8$clinit;
            TraceCompat.Api18Impl.endSection();
            throw th;
        }
    }
}
