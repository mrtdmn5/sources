package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    /* loaded from: classes.dex */
    public static class AnchorInfo {
        public int mCoordinate;
        public boolean mLayoutFromEnd;
        public OrientationHelper mOrientationHelper;
        public int mPosition;
        public boolean mValid;

        public AnchorInfo() {
            reset();
        }

        public final void assignCoordinateFromPadding() {
            int startAfterPadding;
            if (this.mLayoutFromEnd) {
                startAfterPadding = this.mOrientationHelper.getEndAfterPadding();
            } else {
                startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
            }
            this.mCoordinate = startAfterPadding;
        }

        public final void assignFromView(int r4, View view) {
            int totalSpace;
            if (this.mLayoutFromEnd) {
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(view);
                OrientationHelper orientationHelper = this.mOrientationHelper;
                if (Integer.MIN_VALUE == orientationHelper.mLastTotalSpace) {
                    totalSpace = 0;
                } else {
                    totalSpace = orientationHelper.getTotalSpace() - orientationHelper.mLastTotalSpace;
                }
                this.mCoordinate = totalSpace + decoratedEnd;
            } else {
                this.mCoordinate = this.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = r4;
        }

        public final void assignFromViewAndKeepVisibleRect(int r5, View view) {
            int totalSpace;
            OrientationHelper orientationHelper = this.mOrientationHelper;
            if (Integer.MIN_VALUE == orientationHelper.mLastTotalSpace) {
                totalSpace = 0;
            } else {
                totalSpace = orientationHelper.getTotalSpace() - orientationHelper.mLastTotalSpace;
            }
            if (totalSpace >= 0) {
                assignFromView(r5, view);
                return;
            }
            this.mPosition = r5;
            if (this.mLayoutFromEnd) {
                int endAfterPadding = (this.mOrientationHelper.getEndAfterPadding() - totalSpace) - this.mOrientationHelper.getDecoratedEnd(view);
                this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(view);
                    int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                    int min = decoratedMeasurement - (Math.min(this.mOrientationHelper.getDecoratedStart(view) - startAfterPadding, 0) + startAfterPadding);
                    if (min < 0) {
                        this.mCoordinate = Math.min(endAfterPadding, -min) + this.mCoordinate;
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (this.mOrientationHelper.getEndAfterPadding() - totalSpace) - this.mOrientationHelper.getDecoratedEnd(view))) - (this.mOrientationHelper.getDecoratedMeasurement(view) + decoratedStart);
                if (endAfterPadding2 < 0) {
                    this.mCoordinate -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        public final void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mValid = false;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("AnchorInfo{mPosition=");
            sb.append(this.mPosition);
            sb.append(", mCoordinate=");
            sb.append(this.mCoordinate);
            sb.append(", mLayoutFromEnd=");
            sb.append(this.mLayoutFromEnd);
            sb.append(", mValid=");
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.mValid, '}');
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;
    }

    /* loaded from: classes.dex */
    public static class LayoutState {
        public int mAvailable;
        public int mCurrentPosition;
        public boolean mInfinite;
        public int mItemDirection;
        public int mLastScrollDelta;
        public int mLayoutDirection;
        public int mOffset;
        public int mScrollingOffset;
        public boolean mRecycle = true;
        public int mExtraFillSpace = 0;
        public int mNoRecycleSpace = 0;
        public List<RecyclerView.ViewHolder> mScrapList = null;

        public final void assignPositionFromScrapList(View view) {
            int viewLayoutPosition;
            int size = this.mScrapList.size();
            View view2 = null;
            int r2 = Integer.MAX_VALUE;
            for (int r3 = 0; r3 < size; r3++) {
                View view3 = this.mScrapList.get(r3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection) >= 0 && viewLayoutPosition < r2) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    } else {
                        r2 = viewLayoutPosition;
                    }
                }
            }
            if (view2 == null) {
                this.mCurrentPosition = -1;
            } else {
                this.mCurrentPosition = ((RecyclerView.LayoutParams) view2.getLayoutParams()).getViewLayoutPosition();
            }
        }

        public final View next(RecyclerView.Recycler recycler) {
            List<RecyclerView.ViewHolder> list = this.mScrapList;
            if (list != null) {
                int size = list.size();
                for (int r0 = 0; r0 < size; r0++) {
                    View view = this.mScrapList.get(r0).itemView;
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    if (!layoutParams.isItemRemoved() && this.mCurrentPosition == layoutParams.getViewLayoutPosition()) {
                        assignPositionFromScrapList(view);
                        return view;
                    }
                }
                return null;
            }
            View view2 = recycler.tryGetViewHolderForPositionByDeadline(this.mCurrentPosition, Long.MAX_VALUE).itemView;
            this.mCurrentPosition += this.mItemDirection;
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public boolean mAnchorLayoutFromEnd;
        public int mAnchorOffset;
        public int mAnchorPosition;

        /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$SavedState$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r2) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollExtent(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollOffset(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollRange(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private int fixLayoutEndGap(int r2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - r2;
        if (endAfterPadding2 > 0) {
            int r3 = -scrollBy(-endAfterPadding2, recycler, state);
            int r22 = r2 + r3;
            if (z && (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - r22) > 0) {
                this.mOrientationHelper.offsetChildren(endAfterPadding);
                return endAfterPadding + r3;
            }
            return r3;
        }
        return 0;
    }

    private int fixLayoutStartGap(int r2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int startAfterPadding2 = r2 - this.mOrientationHelper.getStartAfterPadding();
        if (startAfterPadding2 > 0) {
            int r3 = -scrollBy(startAfterPadding2, recycler, state);
            int r22 = r2 + r3;
            if (z && (startAfterPadding = r22 - this.mOrientationHelper.getStartAfterPadding()) > 0) {
                this.mOrientationHelper.offsetChildren(-startAfterPadding);
                return r3 - startAfterPadding;
            }
            return r3;
        }
        return 0;
    }

    private View getChildClosestToEnd() {
        int childCount;
        if (this.mShouldReverseLayout) {
            childCount = 0;
        } else {
            childCount = getChildCount() - 1;
        }
        return getChildAt(childCount);
    }

    private View getChildClosestToStart() {
        int r0;
        if (this.mShouldReverseLayout) {
            r0 = getChildCount() - 1;
        } else {
            r0 = 0;
        }
        return getChildAt(r0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int r18, int r19) {
        boolean z;
        if (state.mRunPredictiveAnimations && getChildCount() != 0 && !state.mInPreLayout && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> list = recycler.mUnmodifiableAttachedScrap;
            int size = list.size();
            int position = getPosition(getChildAt(0));
            int r8 = 0;
            int r9 = 0;
            for (int r7 = 0; r7 < size; r7++) {
                RecyclerView.ViewHolder viewHolder = list.get(r7);
                if (!viewHolder.isRemoved()) {
                    char c = 1;
                    if (viewHolder.getLayoutPosition() < position) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z != this.mShouldReverseLayout) {
                        c = 65535;
                    }
                    if (c == 65535) {
                        r8 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    } else {
                        r9 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    }
                }
            }
            this.mLayoutState.mScrapList = list;
            if (r8 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), r18);
                LayoutState layoutState = this.mLayoutState;
                layoutState.mExtraFillSpace = r8;
                layoutState.mAvailable = 0;
                layoutState.assignPositionFromScrapList(null);
                fill(recycler, this.mLayoutState, state, false);
            }
            if (r9 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), r19);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.mExtraFillSpace = r9;
                layoutState2.mAvailable = 0;
                layoutState2.assignPositionFromScrapList(null);
                fill(recycler, this.mLayoutState, state, false);
            }
            this.mLayoutState.mScrapList = null;
        }
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int r0 = 0; r0 < getChildCount(); r0++) {
            View childAt = getChildAt(r0);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.getDecoratedStart(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            int r0 = layoutState.mScrollingOffset;
            int r1 = layoutState.mNoRecycleSpace;
            if (layoutState.mLayoutDirection == -1) {
                recycleViewsFromEnd(recycler, r0, r1);
            } else {
                recycleViewsFromStart(recycler, r0, r1);
            }
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int r2, int r3) {
        if (r2 == r3) {
            return;
        }
        if (r3 > r2) {
            for (int r32 = r3 - 1; r32 >= r2; r32--) {
                removeAndRecycleViewAt(r32, recycler);
            }
            return;
        }
        while (r2 > r3) {
            removeAndRecycleViewAt(r2, recycler);
            r2--;
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int r6, int r7) {
        int childCount = getChildCount();
        if (r6 < 0) {
            return;
        }
        int end = (this.mOrientationHelper.getEnd() - r6) + r7;
        if (this.mShouldReverseLayout) {
            for (int r72 = 0; r72 < childCount; r72++) {
                View childAt = getChildAt(r72);
                if (this.mOrientationHelper.getDecoratedStart(childAt) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt) < end) {
                    recycleChildren(recycler, 0, r72);
                    return;
                }
            }
            return;
        }
        int r0 = childCount - 1;
        for (int r62 = r0; r62 >= 0; r62--) {
            View childAt2 = getChildAt(r62);
            if (this.mOrientationHelper.getDecoratedStart(childAt2) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt2) < end) {
                recycleChildren(recycler, r0, r62);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int r6, int r7) {
        if (r6 < 0) {
            return;
        }
        int r62 = r6 - r7;
        int childCount = getChildCount();
        if (this.mShouldReverseLayout) {
            int r72 = childCount - 1;
            for (int r0 = r72; r0 >= 0; r0--) {
                View childAt = getChildAt(r0);
                if (this.mOrientationHelper.getDecoratedEnd(childAt) > r62 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt) > r62) {
                    recycleChildren(recycler, r72, r0);
                    return;
                }
            }
            return;
        }
        for (int r1 = 0; r1 < childCount; r1++) {
            View childAt2 = getChildAt(r1);
            if (this.mOrientationHelper.getDecoratedEnd(childAt2) > r62 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt2) > r62) {
                recycleChildren(recycler, 0, r1);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1 && isLayoutRTL()) {
            this.mShouldReverseLayout = !this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View findReferenceChild;
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null) {
            anchorInfo.getClass();
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) focusedChild.getLayoutParams();
            if (!layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                anchorInfo.assignFromViewAndKeepVisibleRect(getPosition(focusedChild), focusedChild);
                return true;
            }
        }
        boolean z4 = this.mLastStackFromEnd;
        boolean z5 = this.mStackFromEnd;
        if (z4 != z5 || (findReferenceChild = findReferenceChild(recycler, state, anchorInfo.mLayoutFromEnd, z5)) == null) {
            return false;
        }
        anchorInfo.assignFromView(getPosition(findReferenceChild), findReferenceChild);
        if (!state.mInPreLayout && supportsPredictiveItemAnimations()) {
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(findReferenceChild);
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findReferenceChild);
            int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
            int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
            if (decoratedEnd <= startAfterPadding && decoratedStart < startAfterPadding) {
                z = true;
            } else {
                z = false;
            }
            if (decoratedStart >= endAfterPadding && decoratedEnd > endAfterPadding) {
                z3 = true;
            }
            if (z || z3) {
                if (anchorInfo.mLayoutFromEnd) {
                    startAfterPadding = endAfterPadding;
                }
                anchorInfo.mCoordinate = startAfterPadding;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int r0;
        boolean z;
        int decoratedStart;
        byte b;
        boolean z2 = false;
        int r1 = 0;
        if (!state.mInPreLayout && (r0 = this.mPendingScrollPosition) != -1) {
            if (r0 >= 0 && r0 < state.getItemCount()) {
                int r6 = this.mPendingScrollPosition;
                anchorInfo.mPosition = r6;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null) {
                    if (savedState.mAnchorPosition >= 0) {
                        b = true;
                    } else {
                        b = false;
                    }
                    if (b != false) {
                        boolean z3 = savedState.mAnchorLayoutFromEnd;
                        anchorInfo.mLayoutFromEnd = z3;
                        if (z3) {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                        } else {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                        }
                        return true;
                    }
                }
                if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(r6);
                    if (findViewByPosition != null) {
                        if (this.mOrientationHelper.getDecoratedMeasurement(findViewByPosition) > this.mOrientationHelper.getTotalSpace()) {
                            anchorInfo.assignCoordinateFromPadding();
                            return true;
                        }
                        if (this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                            anchorInfo.mLayoutFromEnd = false;
                            return true;
                        }
                        if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition) < 0) {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                            anchorInfo.mLayoutFromEnd = true;
                            return true;
                        }
                        if (anchorInfo.mLayoutFromEnd) {
                            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findViewByPosition);
                            OrientationHelper orientationHelper = this.mOrientationHelper;
                            if (Integer.MIN_VALUE != orientationHelper.mLastTotalSpace) {
                                r1 = orientationHelper.getTotalSpace() - orientationHelper.mLastTotalSpace;
                            }
                            decoratedStart = r1 + decoratedEnd;
                        } else {
                            decoratedStart = this.mOrientationHelper.getDecoratedStart(findViewByPosition);
                        }
                        anchorInfo.mCoordinate = decoratedStart;
                    } else {
                        if (getChildCount() > 0) {
                            if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z == this.mShouldReverseLayout) {
                                z2 = true;
                            }
                            anchorInfo.mLayoutFromEnd = z2;
                        }
                        anchorInfo.assignCoordinateFromPadding();
                    }
                    return true;
                }
                boolean z4 = this.mShouldReverseLayout;
                anchorInfo.mLayoutFromEnd = z4;
                if (z4) {
                    anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                } else {
                    anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        int r2;
        if (updateAnchorFromPendingData(state, anchorInfo) || updateAnchorFromChildren(recycler, state, anchorInfo)) {
            return;
        }
        anchorInfo.assignCoordinateFromPadding();
        if (this.mStackFromEnd) {
            r2 = state.getItemCount() - 1;
        } else {
            r2 = 0;
        }
        anchorInfo.mPosition = r2;
    }

    private void updateLayoutState(int r5, int r6, boolean z, RecyclerView.State state) {
        int r3;
        int startAfterPadding;
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = r5;
        int[] r0 = this.mReusableIntPair;
        boolean z2 = false;
        r0[0] = 0;
        int r2 = 1;
        r0[1] = 0;
        calculateExtraLayoutSpace(state, r0);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (r5 == 1) {
            z2 = true;
        }
        LayoutState layoutState = this.mLayoutState;
        if (z2) {
            r3 = max2;
        } else {
            r3 = max;
        }
        layoutState.mExtraFillSpace = r3;
        if (!z2) {
            max = max2;
        }
        layoutState.mNoRecycleSpace = max;
        if (z2) {
            layoutState.mExtraFillSpace = this.mOrientationHelper.getEndPadding() + r3;
            View childClosestToEnd = getChildClosestToEnd();
            LayoutState layoutState2 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                r2 = -1;
            }
            layoutState2.mItemDirection = r2;
            int position = getPosition(childClosestToEnd);
            LayoutState layoutState3 = this.mLayoutState;
            layoutState2.mCurrentPosition = position + layoutState3.mItemDirection;
            layoutState3.mOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
            startAfterPadding = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            View childClosestToStart = getChildClosestToStart();
            LayoutState layoutState4 = this.mLayoutState;
            layoutState4.mExtraFillSpace = this.mOrientationHelper.getStartAfterPadding() + layoutState4.mExtraFillSpace;
            LayoutState layoutState5 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                r2 = -1;
            }
            layoutState5.mItemDirection = r2;
            int position2 = getPosition(childClosestToStart);
            LayoutState layoutState6 = this.mLayoutState;
            layoutState5.mCurrentPosition = position2 + layoutState6.mItemDirection;
            layoutState6.mOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart);
            startAfterPadding = (-this.mOrientationHelper.getDecoratedStart(childClosestToStart)) + this.mOrientationHelper.getStartAfterPadding();
        }
        LayoutState layoutState7 = this.mLayoutState;
        layoutState7.mAvailable = r6;
        if (z) {
            layoutState7.mAvailable = r6 - startAfterPadding;
        }
        layoutState7.mScrollingOffset = startAfterPadding;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.State state, int[] r5) {
        int r0;
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.mLayoutDirection == -1) {
            r0 = 0;
        } else {
            r0 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        r5[0] = extraLayoutSpace;
        r5[1] = r0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int r2, int r3, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int r0;
        if (this.mOrientation != 0) {
            r2 = r3;
        }
        if (getChildCount() != 0 && r2 != 0) {
            ensureLayoutState();
            if (r2 > 0) {
                r0 = 1;
            } else {
                r0 = -1;
            }
            updateLayoutState(r0, Math.abs(r2), true, state);
            collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void collectInitialPrefetchPositions(int r7, androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry r8) {
        /*
            r6 = this;
            androidx.recyclerview.widget.LinearLayoutManager$SavedState r0 = r6.mPendingSavedState
            r1 = 1
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L13
            int r4 = r0.mAnchorPosition
            if (r4 < 0) goto Ld
            r5 = r1
            goto Le
        Ld:
            r5 = r3
        Le:
            if (r5 == 0) goto L13
            boolean r0 = r0.mAnchorLayoutFromEnd
            goto L22
        L13:
            r6.resolveShouldLayoutReverse()
            boolean r0 = r6.mShouldReverseLayout
            int r4 = r6.mPendingScrollPosition
            if (r4 != r2) goto L22
            if (r0 == 0) goto L21
            int r4 = r7 + (-1)
            goto L22
        L21:
            r4 = r3
        L22:
            if (r0 == 0) goto L25
            r1 = r2
        L25:
            r0 = r3
        L26:
            int r2 = r6.mInitialPrefetchItemCount
            if (r0 >= r2) goto L38
            if (r4 < 0) goto L38
            if (r4 >= r7) goto L38
            r2 = r8
            androidx.recyclerview.widget.GapWorker$LayoutPrefetchRegistryImpl r2 = (androidx.recyclerview.widget.GapWorker.LayoutPrefetchRegistryImpl) r2
            r2.addPosition(r4, r3)
            int r4 = r4 + r1
            int r0 = r0 + 1
            goto L26
        L38:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.collectInitialPrefetchPositions(int, androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry):void");
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int r0 = layoutState.mCurrentPosition;
        if (r0 >= 0 && r0 < state.getItemCount()) {
            ((GapWorker.LayoutPrefetchRegistryImpl) layoutPrefetchRegistry).addPosition(r0, Math.max(0, layoutState.mScrollingOffset));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int r4) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z = false;
        int r2 = 1;
        if (r4 < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.mShouldReverseLayout) {
            r2 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF(r2, 0.0f);
        }
        return new PointF(0.0f, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public int convertFocusDirectionToLayoutDirection(int r5) {
        if (r5 != 1) {
            if (r5 != 2) {
                if (r5 != 17) {
                    if (r5 != 33) {
                        if (r5 != 66) {
                            if (r5 == 130 && this.mOrientation == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        }
                        if (this.mOrientation == 0) {
                            return 1;
                        }
                        return Integer.MIN_VALUE;
                    }
                    if (this.mOrientation == 1) {
                        return -1;
                    }
                    return Integer.MIN_VALUE;
                }
                if (this.mOrientation == 0) {
                    return -1;
                }
                return Integer.MIN_VALUE;
            }
            if (this.mOrientation != 1 && isLayoutRTL()) {
                return -1;
            }
            return 1;
        }
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            return -1;
        }
        return 1;
    }

    public LayoutState createLayoutState() {
        return new LayoutState();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z) {
        boolean z2;
        int r0 = layoutState.mAvailable;
        int r1 = layoutState.mScrollingOffset;
        if (r1 != Integer.MIN_VALUE) {
            if (r0 < 0) {
                layoutState.mScrollingOffset = r1 + r0;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int r12 = layoutState.mAvailable + layoutState.mExtraFillSpace;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if (!layoutState.mInfinite && r12 <= 0) {
                break;
            }
            int r4 = layoutState.mCurrentPosition;
            if (r4 >= 0 && r4 < state.getItemCount()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                break;
            }
            layoutChunkResult.mConsumed = 0;
            layoutChunkResult.mFinished = false;
            layoutChunkResult.mIgnoreConsumed = false;
            layoutChunkResult.mFocusable = false;
            layoutChunk(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                int r42 = layoutState.mOffset;
                int r5 = layoutChunkResult.mConsumed;
                layoutState.mOffset = (layoutState.mLayoutDirection * r5) + r42;
                if (!layoutChunkResult.mIgnoreConsumed || layoutState.mScrapList != null || !state.mInPreLayout) {
                    layoutState.mAvailable -= r5;
                    r12 -= r5;
                }
                int r43 = layoutState.mScrollingOffset;
                if (r43 != Integer.MIN_VALUE) {
                    int r44 = r43 + r5;
                    layoutState.mScrollingOffset = r44;
                    int r52 = layoutState.mAvailable;
                    if (r52 < 0) {
                        layoutState.mScrollingOffset = r44 + r52;
                    }
                    recycleByLayoutState(recycler, layoutState);
                }
                if (z && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return r0 - layoutState.mAvailable;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int r4, int r5) {
        char c;
        int r0;
        int r1;
        ensureLayoutState();
        if (r5 > r4) {
            c = 1;
        } else if (r5 < r4) {
            c = 65535;
        } else {
            c = 0;
        }
        if (c == 0) {
            return getChildAt(r4);
        }
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(r4)) < this.mOrientationHelper.getStartAfterPadding()) {
            r0 = 16644;
            r1 = 16388;
        } else {
            r0 = 4161;
            r1 = DfuBaseService.ERROR_FILE_NOT_FOUND;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(r4, r5, r0, r1);
        }
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(r4, r5, r0, r1);
    }

    public View findOneVisibleChild(int r2, int r3, boolean z, boolean z2) {
        int r4;
        ensureLayoutState();
        int r0 = 320;
        if (z) {
            r4 = 24579;
        } else {
            r4 = 320;
        }
        if (!z2) {
            r0 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(r2, r3, r4, r0);
        }
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(r2, r3, r4, r0);
    }

    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z, boolean z2) {
        int r4;
        int r1;
        int r5;
        boolean z3;
        boolean z4;
        ensureLayoutState();
        int childCount = getChildCount();
        if (z2) {
            r1 = getChildCount() - 1;
            r4 = -1;
            r5 = -1;
        } else {
            r4 = childCount;
            r1 = 0;
            r5 = 1;
        }
        int itemCount = state.getItemCount();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (r1 != r4) {
            View childAt = getChildAt(r1);
            int position = getPosition(childAt);
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(childAt);
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(childAt);
            if (position >= 0 && position < itemCount) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view3 == null) {
                        view3 = childAt;
                    }
                } else {
                    if (decoratedEnd <= startAfterPadding && decoratedStart < startAfterPadding) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (decoratedStart >= endAfterPadding && decoratedEnd > endAfterPadding) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z3 && !z4) {
                        return childAt;
                    }
                    if (z) {
                        if (!z4) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    } else {
                        if (!z3) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    }
                }
            }
            r1 += r5;
        }
        if (view == null) {
            if (view2 != null) {
                return view2;
            }
            return view3;
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int r3) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = r3 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == r3) {
                return childAt;
            }
        }
        return super.findViewByPosition(r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State state) {
        boolean z;
        if (state.mTargetPosition != -1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return 0;
        }
        return this.mOrientationHelper.getTotalSpace();
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        boolean z;
        int r3;
        int r4;
        int r5;
        int r2;
        int decoratedMeasurementInOther;
        boolean z2;
        View next = layoutState.next(recycler);
        if (next == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) next.getLayoutParams();
        if (layoutState.mScrapList == null) {
            boolean z3 = this.mShouldReverseLayout;
            if (layoutState.mLayoutDirection == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3 == z2) {
                addView(next);
            } else {
                addView(next, 0);
            }
        } else {
            boolean z4 = this.mShouldReverseLayout;
            if (layoutState.mLayoutDirection == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z4 == z) {
                addDisappearingView(next);
            } else {
                addDisappearingView(next, 0);
            }
        }
        measureChildWithMargins(next, 0, 0);
        layoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(next);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                decoratedMeasurementInOther = getWidth() - getPaddingRight();
                r2 = decoratedMeasurementInOther - this.mOrientationHelper.getDecoratedMeasurementInOther(next);
            } else {
                r2 = getPaddingLeft();
                decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + r2;
            }
            if (layoutState.mLayoutDirection == -1) {
                int r10 = layoutState.mOffset;
                r5 = r10;
                r4 = decoratedMeasurementInOther;
                r3 = r10 - layoutChunkResult.mConsumed;
            } else {
                int r102 = layoutState.mOffset;
                r3 = r102;
                r4 = decoratedMeasurementInOther;
                r5 = layoutChunkResult.mConsumed + r102;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther2 = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + paddingTop;
            if (layoutState.mLayoutDirection == -1) {
                int r103 = layoutState.mOffset;
                r4 = r103;
                r3 = paddingTop;
                r5 = decoratedMeasurementInOther2;
                r2 = r103 - layoutChunkResult.mConsumed;
            } else {
                int r104 = layoutState.mOffset;
                r3 = paddingTop;
                r4 = layoutChunkResult.mConsumed + r104;
                r5 = decoratedMeasurementInOther2;
                r2 = r104;
            }
        }
        layoutDecoratedWithMargins(next, r2, r3, r4, r5);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = next.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.mAttachedScrap.clear();
            recycler.recycleAndClearCachedViews();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int r5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        View findPartiallyOrCompletelyInvisibleChildClosestToEnd;
        View childClosestToEnd;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(r5)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.getTotalSpace() * MAX_SCROLL_FACTOR), false, state);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
        layoutState.mRecycle = false;
        fill(recycler, layoutState, state, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            childClosestToEnd = getChildClosestToStart();
        } else {
            childClosestToEnd = getChildClosestToEnd();
        }
        if (childClosestToEnd.hasFocusable()) {
            if (findPartiallyOrCompletelyInvisibleChildClosestToEnd == null) {
                return null;
            }
            return childClosestToEnd;
        }
        return findPartiallyOrCompletelyInvisibleChildClosestToEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int r4;
        int r5;
        int r1;
        int r12;
        int r52;
        int fixLayoutEndGap;
        int r0;
        View findViewByPosition;
        int decoratedStart;
        int r6;
        boolean z;
        int r13 = -1;
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            int r02 = savedState.mAnchorPosition;
            if (r02 >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.mPendingScrollPosition = r02;
            }
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (anchorInfo.mValid && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) {
            if (focusedChild != null && (this.mOrientationHelper.getDecoratedStart(focusedChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(focusedChild) <= this.mOrientationHelper.getStartAfterPadding())) {
                this.mAnchorInfo.assignFromViewAndKeepVisibleRect(getPosition(focusedChild), focusedChild);
            }
        } else {
            anchorInfo.reset();
            AnchorInfo anchorInfo2 = this.mAnchorInfo;
            anchorInfo2.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, anchorInfo2);
            this.mAnchorInfo.mValid = true;
        }
        LayoutState layoutState = this.mLayoutState;
        if (layoutState.mLastScrollDelta >= 0) {
            r4 = 1;
        } else {
            r4 = -1;
        }
        layoutState.mLayoutDirection = r4;
        int[] r03 = this.mReusableIntPair;
        r03[0] = 0;
        r03[1] = 0;
        calculateExtraLayoutSpace(state, r03);
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding() + Math.max(0, this.mReusableIntPair[0]);
        int endPadding = this.mOrientationHelper.getEndPadding() + Math.max(0, this.mReusableIntPair[1]);
        if (state.mInPreLayout && (r0 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(r0)) != null) {
            if (this.mShouldReverseLayout) {
                r6 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition);
                decoratedStart = this.mPendingScrollPositionOffset;
            } else {
                decoratedStart = this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding();
                r6 = this.mPendingScrollPositionOffset;
            }
            int r62 = r6 - decoratedStart;
            if (r62 > 0) {
                startAfterPadding += r62;
            } else {
                endPadding -= r62;
            }
        }
        AnchorInfo anchorInfo3 = this.mAnchorInfo;
        if (!anchorInfo3.mLayoutFromEnd ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            r13 = 1;
        }
        onAnchorReady(recycler, state, anchorInfo3, r13);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.getClass();
        this.mLayoutState.mNoRecycleSpace = 0;
        AnchorInfo anchorInfo4 = this.mAnchorInfo;
        if (anchorInfo4.mLayoutFromEnd) {
            updateLayoutStateToFillStart(anchorInfo4);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mExtraFillSpace = startAfterPadding;
            fill(recycler, layoutState2, state, false);
            LayoutState layoutState3 = this.mLayoutState;
            r1 = layoutState3.mOffset;
            int r42 = layoutState3.mCurrentPosition;
            int r04 = layoutState3.mAvailable;
            if (r04 > 0) {
                endPadding += r04;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            LayoutState layoutState4 = this.mLayoutState;
            layoutState4.mExtraFillSpace = endPadding;
            layoutState4.mCurrentPosition += layoutState4.mItemDirection;
            fill(recycler, layoutState4, state, false);
            LayoutState layoutState5 = this.mLayoutState;
            r5 = layoutState5.mOffset;
            int r05 = layoutState5.mAvailable;
            if (r05 > 0) {
                updateLayoutStateToFillStart(r42, r1);
                LayoutState layoutState6 = this.mLayoutState;
                layoutState6.mExtraFillSpace = r05;
                fill(recycler, layoutState6, state, false);
                r1 = this.mLayoutState.mOffset;
            }
        } else {
            updateLayoutStateToFillEnd(anchorInfo4);
            LayoutState layoutState7 = this.mLayoutState;
            layoutState7.mExtraFillSpace = endPadding;
            fill(recycler, layoutState7, state, false);
            LayoutState layoutState8 = this.mLayoutState;
            int r14 = layoutState8.mOffset;
            int r53 = layoutState8.mCurrentPosition;
            int r06 = layoutState8.mAvailable;
            if (r06 > 0) {
                startAfterPadding += r06;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            LayoutState layoutState9 = this.mLayoutState;
            layoutState9.mExtraFillSpace = startAfterPadding;
            layoutState9.mCurrentPosition += layoutState9.mItemDirection;
            fill(recycler, layoutState9, state, false);
            LayoutState layoutState10 = this.mLayoutState;
            int r43 = layoutState10.mOffset;
            int r07 = layoutState10.mAvailable;
            if (r07 > 0) {
                updateLayoutStateToFillEnd(r53, r14);
                LayoutState layoutState11 = this.mLayoutState;
                layoutState11.mExtraFillSpace = r07;
                fill(recycler, layoutState11, state, false);
                r5 = this.mLayoutState.mOffset;
            } else {
                r5 = r14;
            }
            r1 = r43;
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(r5, recycler, state, true);
                r12 = r1 + fixLayoutEndGap2;
                r52 = r5 + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(r12, recycler, state, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(r1, recycler, state, true);
                r12 = r1 + fixLayoutStartGap;
                r52 = r5 + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(r52, recycler, state, false);
            }
            r1 = r12 + fixLayoutEndGap;
            r5 = r52 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(recycler, state, r1, r5);
        if (!state.mInPreLayout) {
            OrientationHelper orientationHelper = this.mOrientationHelper;
            orientationHelper.mLastTotalSpace = orientationHelper.getTotalSpace();
        } else {
            this.mAnchorInfo.reset();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.mAnchorPosition = -1;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState2.mAnchorLayoutFromEnd = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState2.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
                savedState2.mAnchorPosition = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState2.mAnchorPosition = getPosition(childClosestToStart);
                savedState2.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
            }
        } else {
            savedState2.mAnchorPosition = -1;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(View view, View view2, int r6, int r7) {
        char c;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            c = 1;
        } else {
            c = 65535;
        }
        if (this.mShouldReverseLayout) {
            if (c == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedMeasurement(view) + this.mOrientationHelper.getDecoratedStart(view2)));
                return;
            }
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view2));
            return;
        }
        if (c == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedMeasurement(view));
        }
    }

    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0) {
            return true;
        }
        return false;
    }

    public int scrollBy(int r6, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int r0;
        if (getChildCount() == 0 || r6 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = true;
        if (r6 > 0) {
            r0 = 1;
        } else {
            r0 = -1;
        }
        int abs = Math.abs(r6);
        updateLayoutState(r0, abs, true, state);
        LayoutState layoutState = this.mLayoutState;
        int fill = fill(recycler, layoutState, state, false) + layoutState.mScrollingOffset;
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            r6 = r0 * fill;
        }
        this.mOrientationHelper.offsetChildren(-r6);
        this.mLayoutState.mLastScrollDelta = r6;
        return r6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(r3, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r2) {
        this.mPendingScrollPosition = r2;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.mAnchorPosition = -1;
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int r1, int r2) {
        this.mPendingScrollPosition = r1;
        this.mPendingScrollPositionOffset = r2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.mAnchorPosition = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(r2, recycler, state);
    }

    public void setInitialPrefetchItemCount(int r1) {
        this.mInitialPrefetchItemCount = r1;
    }

    public void setOrientation(int r3) {
        if (r3 != 0 && r3 != 1) {
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("invalid orientation:", r3));
        }
        assertNotInLayoutOrScroll(null);
        if (r3 != this.mOrientation || this.mOrientationHelper == null) {
            OrientationHelper createOrientationHelper = OrientationHelper.createOrientationHelper(this, r3);
            this.mOrientationHelper = createOrientationHelper;
            this.mAnchorInfo.mOrientationHelper = createOrientationHelper;
            this.mOrientation = r3;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean shouldMeasureTwice() {
        if (getHeightMode() != 1073741824 && getWidthMode() != 1073741824 && hasFlexibleChildInBothOrientations()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int r3) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(r3);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) {
            return true;
        }
        return false;
    }

    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean z = true;
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int decoratedStart = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int r4 = 1; r4 < getChildCount(); r4++) {
                View childAt = getChildAt(r4);
                int position2 = getPosition(childAt);
                int decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb = new StringBuilder("detected invalid position. loc invalid? ");
                    if (decoratedStart2 >= decoratedStart) {
                        z = false;
                    }
                    sb.append(z);
                    throw new RuntimeException(sb.toString());
                }
                if (decoratedStart2 > decoratedStart) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int r42 = 1; r42 < getChildCount(); r42++) {
            View childAt2 = getChildAt(r42);
            int position3 = getPosition(childAt2);
            int decoratedStart3 = this.mOrientationHelper.getDecoratedStart(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb2 = new StringBuilder("detected invalid position. loc invalid? ");
                if (decoratedStart3 >= decoratedStart) {
                    z = false;
                }
                sb2.append(z);
                throw new RuntimeException(sb2.toString());
            }
            if (decoratedStart3 < decoratedStart) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public LinearLayoutManager(Context context, int r3, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(r3);
        setReverseLayout(z);
    }

    private void updateLayoutStateToFillEnd(int r4, int r5) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - r5;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mItemDirection = this.mShouldReverseLayout ? -1 : 1;
        layoutState.mCurrentPosition = r4;
        layoutState.mLayoutDirection = 1;
        layoutState.mOffset = r5;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int r3, int r4) {
        this.mLayoutState.mAvailable = r4 - this.mOrientationHelper.getStartAfterPadding();
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = r3;
        layoutState.mItemDirection = this.mShouldReverseLayout ? 1 : -1;
        layoutState.mLayoutDirection = -1;
        layoutState.mOffset = r4;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int r5, int r6) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, r5, r6);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }

    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int r4) {
    }
}
