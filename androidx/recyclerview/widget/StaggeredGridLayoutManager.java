package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public final AnchorInfo mAnchorInfo;
    public final AnonymousClass1 mCheckForGapsRunnable;
    public final int mGapStrategy;
    public boolean mLastLayoutFromEnd;
    public boolean mLastLayoutRTL;
    public final LayoutState mLayoutState;
    public final LazySpanLookup mLazySpanLookup;
    public int mOrientation;
    public SavedState mPendingSavedState;
    public int[] mPrefetchDistances;
    public OrientationHelper mPrimaryOrientation;
    public BitSet mRemainingSpans;
    public boolean mReverseLayout;
    public OrientationHelper mSecondaryOrientation;
    public int mSizePerSpan;
    public final boolean mSmoothScrollbarEnabled;
    public int mSpanCount;
    public Span[] mSpans;
    public final Rect mTmpRect;
    public boolean mShouldReverseLayout = false;
    public int mPendingScrollPosition = -1;
    public int mPendingScrollPositionOffset = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public class AnchorInfo {
        public boolean mInvalidateOffsets;
        public boolean mLayoutFromEnd;
        public int mOffset;
        public int mPosition;
        public int[] mSpanReferenceLines;
        public boolean mValid;

        public AnchorInfo() {
            reset();
        }

        public final void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] r1 = this.mSpanReferenceLines;
            if (r1 != null) {
                Arrays.fill(r1, -1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public Span mSpan;
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public boolean mAnchorLayoutFromEnd;
        public int mAnchorPosition;
        public List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        public boolean mLastLayoutRTL;
        public boolean mReverseLayout;
        public int[] mSpanLookup;
        public int mSpanLookupSize;
        public int[] mSpanOffsets;
        public int mSpanOffsetsSize;
        public int mVisibleAnchorPosition;

        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState$1, reason: invalid class name */
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
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }

        public SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            int readInt = parcel.readInt();
            this.mSpanOffsetsSize = readInt;
            if (readInt > 0) {
                int[] r0 = new int[readInt];
                this.mSpanOffsets = r0;
                parcel.readIntArray(r0);
            }
            int readInt2 = parcel.readInt();
            this.mSpanLookupSize = readInt2;
            if (readInt2 > 0) {
                int[] r02 = new int[readInt2];
                this.mSpanLookup = r02;
                parcel.readIntArray(r02);
            }
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }
    }

    /* loaded from: classes.dex */
    public class Span {
        public final int mIndex;
        public final ArrayList<View> mViews = new ArrayList<>();
        public int mCachedStart = Integer.MIN_VALUE;
        public int mCachedEnd = Integer.MIN_VALUE;
        public int mDeletedSize = 0;

        public Span(int r2) {
            this.mIndex = r2;
        }

        public static LayoutParams getLayoutParams(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        public final void calculateCachedEnd() {
            View view = this.mViews.get(r0.size() - 1);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            layoutParams.getClass();
        }

        public final void clear() {
            this.mViews.clear();
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mDeletedSize = 0;
        }

        public final int findFirstPartiallyVisibleItemPosition() {
            boolean z = StaggeredGridLayoutManager.this.mReverseLayout;
            ArrayList<View> arrayList = this.mViews;
            if (z) {
                return findOnePartiallyVisibleChild(arrayList.size() - 1, -1);
            }
            return findOnePartiallyVisibleChild(0, arrayList.size());
        }

        public final int findLastPartiallyVisibleItemPosition() {
            boolean z = StaggeredGridLayoutManager.this.mReverseLayout;
            ArrayList<View> arrayList = this.mViews;
            if (z) {
                return findOnePartiallyVisibleChild(0, arrayList.size());
            }
            return findOnePartiallyVisibleChild(arrayList.size() - 1, -1);
        }

        public final int findOnePartiallyVisibleChild(int r12, int r13) {
            int r5;
            boolean z;
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            int startAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding();
            if (r13 > r12) {
                r5 = 1;
            } else {
                r5 = -1;
            }
            while (r12 != r13) {
                View view = this.mViews.get(r12);
                int decoratedStart = staggeredGridLayoutManager.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = staggeredGridLayoutManager.mPrimaryOrientation.getDecoratedEnd(view);
                boolean z2 = false;
                if (decoratedStart <= endAfterPadding) {
                    z = true;
                } else {
                    z = false;
                }
                if (decoratedEnd >= startAfterPadding) {
                    z2 = true;
                }
                if (z && z2 && (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding)) {
                    return staggeredGridLayoutManager.getPosition(view);
                }
                r12 += r5;
            }
            return -1;
        }

        public final int getEndLine(int r3) {
            int r0 = this.mCachedEnd;
            if (r0 != Integer.MIN_VALUE) {
                return r0;
            }
            if (this.mViews.size() == 0) {
                return r3;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public final View getFocusableViewAfter(int r7, int r8) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            ArrayList<View> arrayList = this.mViews;
            View view = null;
            if (r8 == -1) {
                int size = arrayList.size();
                int r0 = 0;
                while (r0 < size) {
                    View view2 = arrayList.get(r0);
                    if ((staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) <= r7) || ((!staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) >= r7) || !view2.hasFocusable())) {
                        break;
                    }
                    r0++;
                    view = view2;
                }
            } else {
                int size2 = arrayList.size() - 1;
                while (size2 >= 0) {
                    View view3 = arrayList.get(size2);
                    if ((staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view3) >= r7) || ((!staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view3) <= r7) || !view3.hasFocusable())) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }

        public final int getStartLine(int r3) {
            int r0 = this.mCachedStart;
            if (r0 != Integer.MIN_VALUE) {
                return r0;
            }
            ArrayList<View> arrayList = this.mViews;
            if (arrayList.size() == 0) {
                return r3;
            }
            View view = arrayList.get(0);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            layoutParams.getClass();
            return this.mCachedStart;
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$1] */
    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int r7, int r8) {
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        LazySpanLookup lazySpanLookup = new LazySpanLookup();
        this.mLazySpanLookup = lazySpanLookup;
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo();
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
            @Override // java.lang.Runnable
            public final void run() {
                StaggeredGridLayoutManager.this.checkForGaps();
            }
        };
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, r7, r8);
        int r6 = properties.orientation;
        if (r6 != 0 && r6 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (r6 != this.mOrientation) {
            this.mOrientation = r6;
            OrientationHelper orientationHelper = this.mPrimaryOrientation;
            this.mPrimaryOrientation = this.mSecondaryOrientation;
            this.mSecondaryOrientation = orientationHelper;
            requestLayout();
        }
        int r62 = properties.spanCount;
        assertNotInLayoutOrScroll(null);
        if (r62 != this.mSpanCount) {
            lazySpanLookup.clear();
            requestLayout();
            this.mSpanCount = r62;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new Span[this.mSpanCount];
            for (int r1 = 0; r1 < this.mSpanCount; r1++) {
                this.mSpans[r1] = new Span(r1);
            }
            requestLayout();
        }
        boolean z = properties.reverseLayout;
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mReverseLayout != z) {
            savedState.mReverseLayout = z;
        }
        this.mReverseLayout = z;
        requestLayout();
        this.mLayoutState = new LayoutState();
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    public static int updateSpecWithExtra(int r2, int r3, int r4) {
        if (r3 == 0 && r4 == 0) {
            return r2;
        }
        int mode = View.MeasureSpec.getMode(r2);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            return r2;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(r2) - r3) - r4), mode);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public final int calculateScrollDirectionForPosition(int r4) {
        boolean z;
        if (getChildCount() == 0) {
            if (!this.mShouldReverseLayout) {
                return -1;
            }
            return 1;
        }
        if (r4 < getFirstChildPosition()) {
            z = true;
        } else {
            z = false;
        }
        if (z != this.mShouldReverseLayout) {
            return -1;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    public final boolean checkForGaps() {
        int firstChildPosition;
        if (getChildCount() != 0 && this.mGapStrategy != 0 && isAttachedToWindow()) {
            if (this.mShouldReverseLayout) {
                firstChildPosition = getLastChildPosition();
                getFirstChildPosition();
            } else {
                firstChildPosition = getFirstChildPosition();
                getLastChildPosition();
            }
            if (firstChildPosition == 0 && hasGapsToFix() != null) {
                this.mLazySpanLookup.clear();
                requestSimpleAnimationsInNextLayout();
                requestLayout();
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void collectAdjacentPrefetchPositions(int r6, int r7, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        LayoutState layoutState;
        boolean z;
        int endLine;
        int r2;
        if (this.mOrientation != 0) {
            r6 = r7;
        }
        if (getChildCount() != 0 && r6 != 0) {
            prepareLayoutStateForDelta(r6, state);
            int[] r62 = this.mPrefetchDistances;
            if (r62 == null || r62.length < this.mSpanCount) {
                this.mPrefetchDistances = new int[this.mSpanCount];
            }
            int r72 = 0;
            int r0 = 0;
            while (true) {
                int r1 = this.mSpanCount;
                layoutState = this.mLayoutState;
                if (r72 >= r1) {
                    break;
                }
                if (layoutState.mItemDirection == -1) {
                    endLine = layoutState.mStartLine;
                    r2 = this.mSpans[r72].getStartLine(endLine);
                } else {
                    endLine = this.mSpans[r72].getEndLine(layoutState.mEndLine);
                    r2 = layoutState.mEndLine;
                }
                int r12 = endLine - r2;
                if (r12 >= 0) {
                    this.mPrefetchDistances[r0] = r12;
                    r0++;
                }
                r72++;
            }
            Arrays.sort(this.mPrefetchDistances, 0, r0);
            for (int r73 = 0; r73 < r0; r73++) {
                int r13 = layoutState.mCurrentPosition;
                if (r13 >= 0 && r13 < state.getItemCount()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    ((GapWorker.LayoutPrefetchRegistryImpl) layoutPrefetchRegistry).addPosition(layoutState.mCurrentPosition, this.mPrefetchDistances[r73]);
                    layoutState.mCurrentPosition += layoutState.mItemDirection;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        boolean z = this.mSmoothScrollbarEnabled;
        return ScrollbarHelper.computeScrollExtent(state, orientationHelper, findFirstVisibleItemClosestToStart(!z), findFirstVisibleItemClosestToEnd(!z), this, this.mSmoothScrollbarEnabled);
    }

    public final int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        boolean z = this.mSmoothScrollbarEnabled;
        return ScrollbarHelper.computeScrollOffset(state, orientationHelper, findFirstVisibleItemClosestToStart(!z), findFirstVisibleItemClosestToEnd(!z), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public final int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        boolean z = this.mSmoothScrollbarEnabled;
        return ScrollbarHelper.computeScrollRange(state, orientationHelper, findFirstVisibleItemClosestToStart(!z), findFirstVisibleItemClosestToEnd(!z), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public final PointF computeScrollVectorForPosition(int r4) {
        int calculateScrollDirectionForPosition = calculateScrollDirectionForPosition(r4);
        PointF pointF = new PointF();
        if (calculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = calculateScrollDirectionForPosition;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = calculateScrollDirectionForPosition;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v53 */
    public final int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int r0;
        int r14;
        int startAfterPadding;
        int r1;
        int maxEnd;
        int r4;
        int r12;
        Span span;
        ?? r13;
        int r9;
        int decoratedMeasurement;
        int startAfterPadding2;
        int decoratedMeasurement2;
        View view;
        int r3;
        int r122;
        int r42;
        RecyclerView.Recycler recycler2 = recycler;
        int r92 = 0;
        int r10 = 1;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        LayoutState layoutState2 = this.mLayoutState;
        if (layoutState2.mInfinite) {
            if (layoutState.mLayoutDirection == 1) {
                r14 = Integer.MAX_VALUE;
            } else {
                r14 = Integer.MIN_VALUE;
            }
        } else {
            if (layoutState.mLayoutDirection == 1) {
                r0 = layoutState.mEndLine + layoutState.mAvailable;
            } else {
                r0 = layoutState.mStartLine - layoutState.mAvailable;
            }
            r14 = r0;
        }
        int r02 = layoutState.mLayoutDirection;
        for (int r15 = 0; r15 < this.mSpanCount; r15++) {
            if (!this.mSpans[r15].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[r15], r02, r14);
            }
        }
        if (this.mShouldReverseLayout) {
            startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        } else {
            startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        }
        int r152 = startAfterPadding;
        boolean z = false;
        while (true) {
            int r16 = layoutState.mCurrentPosition;
            if (r16 >= 0 && r16 < state.getItemCount()) {
                r1 = r10;
            } else {
                r1 = r92;
            }
            int r2 = -1;
            if (r1 == 0 || (!layoutState2.mInfinite && this.mRemainingSpans.isEmpty())) {
                break;
            }
            View view2 = recycler2.tryGetViewHolderForPositionByDeadline(layoutState.mCurrentPosition, Long.MAX_VALUE).itemView;
            layoutState.mCurrentPosition += layoutState.mItemDirection;
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
            int[] r43 = lazySpanLookup.mData;
            if (r43 != null && viewLayoutPosition < r43.length) {
                r4 = r43[viewLayoutPosition];
            } else {
                r4 = -1;
            }
            if (r4 == -1) {
                r12 = r10;
            } else {
                r12 = r92;
            }
            if (r12 != 0) {
                if (preferLastSpan(layoutState.mLayoutDirection)) {
                    r122 = this.mSpanCount - r10;
                    r42 = -1;
                } else {
                    r2 = this.mSpanCount;
                    r122 = r92;
                    r42 = r10;
                }
                Span span2 = null;
                if (layoutState.mLayoutDirection == r10) {
                    int startAfterPadding3 = this.mPrimaryOrientation.getStartAfterPadding();
                    int r93 = Integer.MAX_VALUE;
                    while (r122 != r2) {
                        Span span3 = this.mSpans[r122];
                        int endLine = span3.getEndLine(startAfterPadding3);
                        if (endLine < r93) {
                            r93 = endLine;
                            span2 = span3;
                        }
                        r122 += r42;
                    }
                } else {
                    int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                    int r94 = Integer.MIN_VALUE;
                    while (r122 != r2) {
                        Span span4 = this.mSpans[r122];
                        int startLine = span4.getStartLine(endAfterPadding);
                        if (startLine > r94) {
                            span2 = span4;
                            r94 = startLine;
                        }
                        r122 += r42;
                    }
                }
                span = span2;
                lazySpanLookup.ensureSize(viewLayoutPosition);
                lazySpanLookup.mData[viewLayoutPosition] = span.mIndex;
            } else {
                span = this.mSpans[r4];
            }
            Span span5 = span;
            layoutParams.mSpan = span5;
            if (layoutState.mLayoutDirection == 1) {
                addView(view2);
                r13 = 0;
            } else {
                r13 = 0;
                addView(view2, 0);
            }
            if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin(view2, RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), r13, ((ViewGroup.MarginLayoutParams) layoutParams).width, r13), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true));
            } else {
                measureChildWithDecorationsAndMargin(view2, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false));
            }
            if (layoutState.mLayoutDirection == 1) {
                int endLine2 = span5.getEndLine(r152);
                decoratedMeasurement = endLine2;
                r9 = this.mPrimaryOrientation.getDecoratedMeasurement(view2) + endLine2;
            } else {
                int startLine2 = span5.getStartLine(r152);
                r9 = startLine2;
                decoratedMeasurement = startLine2 - this.mPrimaryOrientation.getDecoratedMeasurement(view2);
            }
            if (layoutState.mLayoutDirection == 1) {
                Span span6 = layoutParams.mSpan;
                span6.getClass();
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                layoutParams2.mSpan = span6;
                ArrayList<View> arrayList = span6.mViews;
                arrayList.add(view2);
                span6.mCachedEnd = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    span6.mCachedStart = Integer.MIN_VALUE;
                }
                if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                    span6.mDeletedSize = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view2) + span6.mDeletedSize;
                }
            } else {
                Span span7 = layoutParams.mSpan;
                span7.getClass();
                LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
                layoutParams3.mSpan = span7;
                ArrayList<View> arrayList2 = span7.mViews;
                arrayList2.add(0, view2);
                span7.mCachedStart = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    span7.mCachedEnd = Integer.MIN_VALUE;
                }
                if (layoutParams3.isItemRemoved() || layoutParams3.isItemChanged()) {
                    span7.mDeletedSize = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view2) + span7.mDeletedSize;
                }
            }
            if (isLayoutRTL() && this.mOrientation == 1) {
                decoratedMeasurement2 = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - span5.mIndex) * this.mSizePerSpan);
                startAfterPadding2 = decoratedMeasurement2 - this.mSecondaryOrientation.getDecoratedMeasurement(view2);
            } else {
                startAfterPadding2 = this.mSecondaryOrientation.getStartAfterPadding() + (span5.mIndex * this.mSizePerSpan);
                decoratedMeasurement2 = this.mSecondaryOrientation.getDecoratedMeasurement(view2) + startAfterPadding2;
            }
            int r123 = decoratedMeasurement2;
            int r44 = startAfterPadding2;
            if (this.mOrientation == 1) {
                view = view2;
                layoutDecoratedWithMargins(view2, r44, decoratedMeasurement, r123, r9);
            } else {
                view = view2;
                layoutDecoratedWithMargins(view, decoratedMeasurement, r44, r9, r123);
            }
            updateRemainingSpans(span5, layoutState2.mLayoutDirection, r14);
            recycle(recycler, layoutState2);
            if (layoutState2.mStopInFocusable && view.hasFocusable()) {
                r3 = 0;
                this.mRemainingSpans.set(span5.mIndex, false);
            } else {
                r3 = 0;
            }
            recycler2 = recycler;
            r92 = r3;
            z = true;
            r10 = 1;
        }
        RecyclerView.Recycler recycler3 = recycler2;
        int r32 = r92;
        if (!z) {
            recycle(recycler3, layoutState2);
        }
        if (layoutState2.mLayoutDirection == -1) {
            maxEnd = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
        } else {
            maxEnd = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        }
        if (maxEnd > 0) {
            return Math.min(layoutState.mAvailable, maxEnd);
        }
        return r32;
    }

    public final View findFirstVisibleItemClosestToEnd(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd > endAfterPadding && z) {
                    if (view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
        }
        return view;
    }

    public final View findFirstVisibleItemClosestToStart(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int r4 = 0; r4 < childCount; r4++) {
            View childAt = getChildAt(r4);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart < startAfterPadding && z) {
                    if (view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
        }
        return view;
    }

    public final void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int r0 = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (z && r0 > 0) {
                this.mPrimaryOrientation.offsetChildren(r0);
            }
        }
    }

    public final void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int scrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (z && scrollBy > 0) {
                this.mPrimaryOrientation.offsetChildren(-scrollBy);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public final int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final int getMaxEnd(int r4) {
        int endLine = this.mSpans[0].getEndLine(r4);
        for (int r1 = 1; r1 < this.mSpanCount; r1++) {
            int endLine2 = this.mSpans[r1].getEndLine(r4);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    public final int getMinStart(int r4) {
        int startLine = this.mSpans[0].getStartLine(r4);
        for (int r1 = 1; r1 < this.mSpanCount; r1++) {
            int startLine2 = this.mSpans[r1].getStartLine(r4);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleUpdate(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.mShouldReverseLayout
            if (r0 == 0) goto L9
            int r0 = r7.getLastChildPosition()
            goto Ld
        L9:
            int r0 = r7.getFirstChildPosition()
        Ld:
            r1 = 8
            if (r10 != r1) goto L1a
            if (r8 >= r9) goto L16
            int r2 = r9 + 1
            goto L1c
        L16:
            int r2 = r8 + 1
            r3 = r9
            goto L1d
        L1a:
            int r2 = r8 + r9
        L1c:
            r3 = r8
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r7.mLazySpanLookup
            r4.invalidateAfter(r3)
            r5 = 1
            if (r10 == r5) goto L36
            r6 = 2
            if (r10 == r6) goto L32
            if (r10 == r1) goto L2b
            goto L39
        L2b:
            r4.offsetForRemoval(r8, r5)
            r4.offsetForAddition(r9, r5)
            goto L39
        L32:
            r4.offsetForRemoval(r8, r9)
            goto L39
        L36:
            r4.offsetForAddition(r8, r9)
        L39:
            if (r2 > r0) goto L3c
            return
        L3c:
            boolean r8 = r7.mShouldReverseLayout
            if (r8 == 0) goto L45
            int r8 = r7.getFirstChildPosition()
            goto L49
        L45:
            int r8 = r7.getLastChildPosition()
        L49:
            if (r3 > r8) goto L4e
            r7.requestLayout()
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.handleUpdate(int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d1, code lost:            if (r10 == r11) goto L51;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e7, code lost:            r10 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e5, code lost:            r10 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e3, code lost:            if (r10 == r11) goto L51;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View hasGapsToFix() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.hasGapsToFix():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        if (this.mGapStrategy != 0) {
            return true;
        }
        return false;
    }

    public final boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public final void measureChildWithDecorationsAndMargin(View view, int r7, int r8) {
        Rect rect = this.mTmpRect;
        calculateItemDecorationsForChild(view, rect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int updateSpecWithExtra = updateSpecWithExtra(r7, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int updateSpecWithExtra2 = updateSpecWithExtra(r8, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.bottom);
        if (shouldMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams)) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void offsetChildrenHorizontal(int r5) {
        super.offsetChildrenHorizontal(r5);
        for (int r0 = 0; r0 < this.mSpanCount; r0++) {
            Span span = this.mSpans[r0];
            int r2 = span.mCachedStart;
            if (r2 != Integer.MIN_VALUE) {
                span.mCachedStart = r2 + r5;
            }
            int r22 = span.mCachedEnd;
            if (r22 != Integer.MIN_VALUE) {
                span.mCachedEnd = r22 + r5;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void offsetChildrenVertical(int r5) {
        super.offsetChildrenVertical(r5);
        for (int r0 = 0; r0 < this.mSpanCount; r0++) {
            Span span = this.mSpans[r0];
            int r2 = span.mCachedStart;
            if (r2 != Integer.MIN_VALUE) {
                span.mCachedStart = r2 + r5;
            }
            int r22 = span.mCachedEnd;
            if (r22 != Integer.MIN_VALUE) {
                span.mCachedEnd = r22 + r5;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.mLazySpanLookup.clear();
        for (int r1 = 0; r1 < this.mSpanCount; r1++) {
            this.mSpans[r1].clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int r3 = 0; r3 < this.mSpanCount; r3++) {
            this.mSpans[r3].clear();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x003b, code lost:            if (r8.mOrientation == 1) goto L30;     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0041, code lost:            if (r8.mOrientation == 0) goto L30;     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x004d, code lost:            if (isLayoutRTL() == false) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0059, code lost:            if (isLayoutRTL() == false) goto L30;     */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View onFocusSearchFailed(android.view.View r9, int r10, androidx.recyclerview.widget.RecyclerView.Recycler r11, androidx.recyclerview.widget.RecyclerView.State r12) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (findFirstVisibleItemClosestToStart != null && findFirstVisibleItemClosestToEnd != null) {
                int position = getPosition(findFirstVisibleItemClosestToStart);
                int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                } else {
                    accessibilityEvent.setFromIndex(position2);
                    accessibilityEvent.setToIndex(position);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(RecyclerView recyclerView, int r2, int r3) {
        handleUpdate(r2, r3, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsMoved(RecyclerView recyclerView, int r2, int r3, int r4) {
        handleUpdate(r2, r3, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView recyclerView, int r2, int r3) {
        handleUpdate(r2, r3, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsUpdated(RecyclerView recyclerView, int r2, int r3, Object obj) {
        handleUpdate(r2, r3, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        onLayoutChildren(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.mSpanOffsets = null;
                savedState.mSpanOffsetsSize = 0;
                savedState.mAnchorPosition = -1;
                savedState.mVisibleAnchorPosition = -1;
                savedState.mSpanOffsets = null;
                savedState.mSpanOffsetsSize = 0;
                savedState.mSpanLookupSize = 0;
                savedState.mSpanLookup = null;
                savedState.mFullSpanItems = null;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final Parcelable onSaveInstanceState() {
        int firstChildPosition;
        View findFirstVisibleItemClosestToStart;
        int startLine;
        int startAfterPadding;
        int[] r3;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.mReverseLayout = this.mReverseLayout;
        savedState2.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState2.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
        if (lazySpanLookup != null && (r3 = lazySpanLookup.mData) != null) {
            savedState2.mSpanLookup = r3;
            savedState2.mSpanLookupSize = r3.length;
            savedState2.mFullSpanItems = lazySpanLookup.mFullSpanItems;
        } else {
            savedState2.mSpanLookupSize = 0;
        }
        int r32 = -1;
        if (getChildCount() > 0) {
            if (this.mLastLayoutFromEnd) {
                firstChildPosition = getLastChildPosition();
            } else {
                firstChildPosition = getFirstChildPosition();
            }
            savedState2.mAnchorPosition = firstChildPosition;
            if (this.mShouldReverseLayout) {
                findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToEnd(true);
            } else {
                findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(true);
            }
            if (findFirstVisibleItemClosestToStart != null) {
                r32 = getPosition(findFirstVisibleItemClosestToStart);
            }
            savedState2.mVisibleAnchorPosition = r32;
            int r2 = this.mSpanCount;
            savedState2.mSpanOffsetsSize = r2;
            savedState2.mSpanOffsets = new int[r2];
            for (int r1 = 0; r1 < this.mSpanCount; r1++) {
                if (this.mLastLayoutFromEnd) {
                    startLine = this.mSpans[r1].getEndLine(Integer.MIN_VALUE);
                    if (startLine != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                        startLine -= startAfterPadding;
                        savedState2.mSpanOffsets[r1] = startLine;
                    } else {
                        savedState2.mSpanOffsets[r1] = startLine;
                    }
                } else {
                    startLine = this.mSpans[r1].getStartLine(Integer.MIN_VALUE);
                    if (startLine != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                        startLine -= startAfterPadding;
                        savedState2.mSpanOffsets[r1] = startLine;
                    } else {
                        savedState2.mSpanOffsets[r1] = startLine;
                    }
                }
            }
        } else {
            savedState2.mAnchorPosition = -1;
            savedState2.mVisibleAnchorPosition = -1;
            savedState2.mSpanOffsetsSize = 0;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onScrollStateChanged(int r1) {
        if (r1 == 0) {
            checkForGaps();
        }
    }

    public final boolean preferLastSpan(int r5) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.mOrientation == 0) {
            if (r5 == -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 != this.mShouldReverseLayout) {
                return true;
            }
            return false;
        }
        if (r5 == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z == this.mShouldReverseLayout) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    public final void prepareLayoutStateForDelta(int r5, RecyclerView.State state) {
        int firstChildPosition;
        int r2;
        if (r5 > 0) {
            firstChildPosition = getLastChildPosition();
            r2 = 1;
        } else {
            firstChildPosition = getFirstChildPosition();
            r2 = -1;
        }
        LayoutState layoutState = this.mLayoutState;
        layoutState.mRecycle = true;
        updateLayoutState(firstChildPosition, state);
        setLayoutStateDirection(r2);
        layoutState.mCurrentPosition = firstChildPosition + layoutState.mItemDirection;
        layoutState.mAvailable = Math.abs(r5);
    }

    public final void recycle(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int min;
        int min2;
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            if (layoutState.mAvailable == 0) {
                if (layoutState.mLayoutDirection == -1) {
                    recycleFromEnd(layoutState.mEndLine, recycler);
                    return;
                } else {
                    recycleFromStart(layoutState.mStartLine, recycler);
                    return;
                }
            }
            int r3 = 1;
            if (layoutState.mLayoutDirection == -1) {
                int r0 = layoutState.mStartLine;
                int startLine = this.mSpans[0].getStartLine(r0);
                while (r3 < this.mSpanCount) {
                    int startLine2 = this.mSpans[r3].getStartLine(r0);
                    if (startLine2 > startLine) {
                        startLine = startLine2;
                    }
                    r3++;
                }
                int r02 = r0 - startLine;
                if (r02 < 0) {
                    min2 = layoutState.mEndLine;
                } else {
                    min2 = layoutState.mEndLine - Math.min(r02, layoutState.mAvailable);
                }
                recycleFromEnd(min2, recycler);
                return;
            }
            int r03 = layoutState.mEndLine;
            int endLine = this.mSpans[0].getEndLine(r03);
            while (r3 < this.mSpanCount) {
                int endLine2 = this.mSpans[r3].getEndLine(r03);
                if (endLine2 < endLine) {
                    endLine = endLine2;
                }
                r3++;
            }
            int r1 = endLine - layoutState.mEndLine;
            if (r1 < 0) {
                min = layoutState.mStartLine;
            } else {
                min = Math.min(r1, layoutState.mAvailable) + layoutState.mStartLine;
            }
            recycleFromStart(min, recycler);
        }
    }

    public final void recycleFromEnd(int r9, RecyclerView.Recycler recycler) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) >= r9 && this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) >= r9) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.getClass();
                if (layoutParams.mSpan.mViews.size() == 1) {
                    return;
                }
                Span span = layoutParams.mSpan;
                ArrayList<View> arrayList = span.mViews;
                int size = arrayList.size();
                View remove = arrayList.remove(size - 1);
                LayoutParams layoutParams2 = Span.getLayoutParams(remove);
                layoutParams2.mSpan = null;
                if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                    span.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
                }
                if (size == 1) {
                    span.mCachedStart = Integer.MIN_VALUE;
                }
                span.mCachedEnd = Integer.MIN_VALUE;
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    public final void recycleFromStart(int r7, RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) <= r7 && this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) <= r7) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.getClass();
                if (layoutParams.mSpan.mViews.size() == 1) {
                    return;
                }
                Span span = layoutParams.mSpan;
                ArrayList<View> arrayList = span.mViews;
                View remove = arrayList.remove(0);
                LayoutParams layoutParams2 = Span.getLayoutParams(remove);
                layoutParams2.mSpan = null;
                if (arrayList.size() == 0) {
                    span.mCachedEnd = Integer.MIN_VALUE;
                }
                if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                    span.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
                }
                span.mCachedStart = Integer.MIN_VALUE;
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    public final void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1 && isLayoutRTL()) {
            this.mShouldReverseLayout = !this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = this.mReverseLayout;
        }
    }

    public final int scrollBy(int r4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || r4 == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(r4, state);
        LayoutState layoutState = this.mLayoutState;
        int fill = fill(recycler, layoutState, state);
        if (layoutState.mAvailable >= fill) {
            if (r4 < 0) {
                r4 = -fill;
            } else {
                r4 = fill;
            }
        }
        this.mPrimaryOrientation.offsetChildren(-r4);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        layoutState.mAvailable = 0;
        recycle(recycler, layoutState);
        return r4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r1, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(r1, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r3) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mAnchorPosition != r3) {
            savedState.mSpanOffsets = null;
            savedState.mSpanOffsetsSize = 0;
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
        }
        this.mPendingScrollPosition = r3;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r1, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(r1, recycler, state);
    }

    public final void setLayoutStateDirection(int r5) {
        boolean z;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mLayoutDirection = r5;
        boolean z2 = this.mShouldReverseLayout;
        int r2 = 1;
        if (r5 == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z2 != z) {
            r2 = -1;
        }
        layoutState.mItemDirection = r2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void setMeasuredDimension(Rect rect, int r6, int r7) {
        int chooseSize;
        int chooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(r7, rect.height() + paddingBottom, getMinimumHeight());
            chooseSize = RecyclerView.LayoutManager.chooseSize(r6, (this.mSizePerSpan * this.mSpanCount) + paddingRight, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.LayoutManager.chooseSize(r6, rect.width() + paddingRight, getMinimumWidth());
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(r7, (this.mSizePerSpan * this.mSpanCount) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int r3) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(r3);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) {
            return true;
        }
        return false;
    }

    public final void updateLayoutState(int r5, RecyclerView.State state) {
        int r52;
        int r6;
        int r62;
        boolean z;
        LayoutState layoutState = this.mLayoutState;
        boolean z2 = false;
        layoutState.mAvailable = 0;
        layoutState.mCurrentPosition = r5;
        if (isSmoothScrolling() && (r62 = state.mTargetPosition) != -1) {
            boolean z3 = this.mShouldReverseLayout;
            if (r62 < r5) {
                z = true;
            } else {
                z = false;
            }
            if (z3 == z) {
                r52 = this.mPrimaryOrientation.getTotalSpace();
                r6 = 0;
            } else {
                r6 = this.mPrimaryOrientation.getTotalSpace();
                r52 = 0;
            }
        } else {
            r52 = 0;
            r6 = 0;
        }
        if (getClipToPadding()) {
            layoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - r6;
            layoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + r52;
        } else {
            layoutState.mEndLine = this.mPrimaryOrientation.getEnd() + r52;
            layoutState.mStartLine = -r6;
        }
        layoutState.mStopInFocusable = false;
        layoutState.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
            z2 = true;
        }
        layoutState.mInfinite = z2;
    }

    public final void updateRemainingSpans(Span span, int r7, int r8) {
        int r0 = span.mDeletedSize;
        int r4 = span.mIndex;
        if (r7 == -1) {
            int r72 = span.mCachedStart;
            if (r72 == Integer.MIN_VALUE) {
                View view = span.mViews.get(0);
                LayoutParams layoutParams = Span.getLayoutParams(view);
                span.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                layoutParams.getClass();
                r72 = span.mCachedStart;
            }
            if (r72 + r0 <= r8) {
                this.mRemainingSpans.set(r4, false);
                return;
            }
            return;
        }
        int r73 = span.mCachedEnd;
        if (r73 == Integer.MIN_VALUE) {
            span.calculateCachedEnd();
            r73 = span.mCachedEnd;
        }
        if (r73 - r0 >= r8) {
            this.mRemainingSpans.set(r4, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:258:0x0404, code lost:            if (checkForGaps() != false) goto L251;     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r17, androidx.recyclerview.widget.RecyclerView.State r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1058
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    /* loaded from: classes.dex */
    public static class LazySpanLookup {
        public int[] mData;
        public List<FullSpanItem> mFullSpanItems;

        public final void clear() {
            int[] r0 = this.mData;
            if (r0 != null) {
                Arrays.fill(r0, -1);
            }
            this.mFullSpanItems = null;
        }

        public final void ensureSize(int r5) {
            int[] r0 = this.mData;
            if (r0 == null) {
                int[] r52 = new int[Math.max(r5, 10) + 1];
                this.mData = r52;
                Arrays.fill(r52, -1);
            } else if (r5 >= r0.length) {
                int length = r0.length;
                while (length <= r5) {
                    length *= 2;
                }
                int[] r53 = new int[length];
                this.mData = r53;
                System.arraycopy(r0, 0, r53, 0, r0.length);
                int[] r54 = this.mData;
                Arrays.fill(r54, r0.length, r54.length, -1);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int invalidateAfter(int r6) {
            /*
                r5 = this;
                int[] r0 = r5.mData
                r1 = -1
                if (r0 != 0) goto L6
                return r1
            L6:
                int r0 = r0.length
                if (r6 < r0) goto La
                return r1
            La:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r5.mFullSpanItems
                if (r0 != 0) goto Lf
                goto L5e
            Lf:
                r2 = 0
                if (r0 != 0) goto L13
                goto L2b
            L13:
                int r0 = r0.size()
                int r0 = r0 + r1
            L18:
                if (r0 < 0) goto L2b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r5.mFullSpanItems
                java.lang.Object r3 = r3.get(r0)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r3
                int r4 = r3.mPosition
                if (r4 != r6) goto L28
                r2 = r3
                goto L2b
            L28:
                int r0 = r0 + (-1)
                goto L18
            L2b:
                if (r2 == 0) goto L32
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r5.mFullSpanItems
                r0.remove(r2)
            L32:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r5.mFullSpanItems
                int r0 = r0.size()
                r2 = 0
            L39:
                if (r2 >= r0) goto L4b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r5.mFullSpanItems
                java.lang.Object r3 = r3.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r3
                int r3 = r3.mPosition
                if (r3 < r6) goto L48
                goto L4c
            L48:
                int r2 = r2 + 1
                goto L39
            L4b:
                r2 = r1
            L4c:
                if (r2 == r1) goto L5e
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r5.mFullSpanItems
                java.lang.Object r0 = r0.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r0
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r5.mFullSpanItems
                r3.remove(r2)
                int r0 = r0.mPosition
                goto L5f
            L5e:
                r0 = r1
            L5f:
                if (r0 != r1) goto L6b
                int[] r0 = r5.mData
                int r2 = r0.length
                java.util.Arrays.fill(r0, r6, r2, r1)
                int[] r6 = r5.mData
                int r6 = r6.length
                return r6
            L6b:
                int r0 = r0 + 1
                int[] r2 = r5.mData
                int r2 = r2.length
                int r0 = java.lang.Math.min(r0, r2)
                int[] r2 = r5.mData
                java.util.Arrays.fill(r2, r6, r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.invalidateAfter(int):int");
        }

        public final void offsetForAddition(int r4, int r5) {
            int[] r0 = this.mData;
            if (r0 != null && r4 < r0.length) {
                int r02 = r4 + r5;
                ensureSize(r02);
                int[] r1 = this.mData;
                System.arraycopy(r1, r4, r1, r02, (r1.length - r4) - r5);
                Arrays.fill(this.mData, r4, r02, -1);
                List<FullSpanItem> list = this.mFullSpanItems;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                        int r2 = fullSpanItem.mPosition;
                        if (r2 >= r4) {
                            fullSpanItem.mPosition = r2 + r5;
                        }
                    }
                }
            }
        }

        public final void offsetForRemoval(int r6, int r7) {
            int[] r0 = this.mData;
            if (r0 != null && r6 < r0.length) {
                int r02 = r6 + r7;
                ensureSize(r02);
                int[] r1 = this.mData;
                System.arraycopy(r1, r02, r1, r6, (r1.length - r6) - r7);
                int[] r12 = this.mData;
                Arrays.fill(r12, r12.length - r7, r12.length, -1);
                List<FullSpanItem> list = this.mFullSpanItems;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                        int r3 = fullSpanItem.mPosition;
                        if (r3 >= r6) {
                            if (r3 < r02) {
                                this.mFullSpanItems.remove(size);
                            } else {
                                fullSpanItem.mPosition = r3 - r7;
                            }
                        }
                    }
                }
            }
        }

        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new AnonymousClass1();
            public int mGapDir;
            public int[] mGapPerSpan;
            public boolean mHasUnwantedGapAfter;
            public int mPosition;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public class AnonymousClass1 implements Parcelable.Creator<FullSpanItem> {
                @Override // android.os.Parcelable.Creator
                public final FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                public final FullSpanItem[] newArray(int r1) {
                    return new FullSpanItem[r1];
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] r0 = new int[readInt];
                    this.mGapPerSpan = r0;
                    parcel.readIntArray(r0);
                }
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public final String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int r3) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] r32 = this.mGapPerSpan;
                if (r32 != null && r32.length > 0) {
                    parcel.writeInt(r32.length);
                    parcel.writeIntArray(this.mGapPerSpan);
                } else {
                    parcel.writeInt(0);
                }
            }

            public FullSpanItem() {
            }
        }
    }
}
