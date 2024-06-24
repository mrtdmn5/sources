package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.collection.SimpleArrayMap;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat$Api19Impl;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements NestedScrollingChild {
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final List<RecyclerListener> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
    static final boolean POST_UPDATES_ON_ANIMATION = true;
    static final boolean ALLOW_THREAD_GAP_WORK = true;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                if (!recyclerView.mIsAttached) {
                    recyclerView.requestLayout();
                } else if (recyclerView.mLayoutSuppressed) {
                    recyclerView.mLayoutWasDefered = true;
                } else {
                    recyclerView.consumePendingUpdateOperations();
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView recyclerView = RecyclerView.this;
            ItemAnimator itemAnimator = recyclerView.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.runPendingAnimations();
            }
            recyclerView.mPostedAnimatorRunner = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$4 */
    /* loaded from: classes.dex */
    public class AnonymousClass4 implements ViewInfoStore.ProcessCallback {
        public AnonymousClass4() {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$5 */
    /* loaded from: classes.dex */
    public class AnonymousClass5 implements ChildHelper.Callback {
        public AnonymousClass5() {
        }

        public final int getChildCount() {
            return RecyclerView.this.getChildCount();
        }

        public final void removeViewAt(int r3) {
            RecyclerView recyclerView = RecyclerView.this;
            View childAt = recyclerView.getChildAt(r3);
            if (childAt != null) {
                recyclerView.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            recyclerView.removeViewAt(r3);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$6 */
    /* loaded from: classes.dex */
    public class AnonymousClass6 implements AdapterHelper.Callback {
        public AnonymousClass6() {
        }

        public final void dispatchUpdate(AdapterHelper.UpdateOp updateOp) {
            int r0 = updateOp.cmd;
            RecyclerView recyclerView = RecyclerView.this;
            if (r0 != 1) {
                if (r0 != 2) {
                    if (r0 != 4) {
                        if (r0 == 8) {
                            recyclerView.mLayout.onItemsMoved(recyclerView, updateOp.positionStart, updateOp.itemCount, 1);
                            return;
                        }
                        return;
                    }
                    recyclerView.mLayout.onItemsUpdated(recyclerView, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                    return;
                }
                recyclerView.mLayout.onItemsRemoved(recyclerView, updateOp.positionStart, updateOp.itemCount);
                return;
            }
            recyclerView.mLayout.onItemsAdded(recyclerView, updateOp.positionStart, updateOp.itemCount);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$7 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy;

        static {
            int[] r0 = new int[Adapter.StateRestorationPolicy.values().length];
            $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy = r0;
            try {
                r0[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public final boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public final void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public final void notifyItemMoved(int r3, int r4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(r3, r4);
            }
        }

        public final void notifyItemRangeChanged(int r3, int r4, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(r3, r4, obj);
            }
        }

        public final void notifyItemRangeInserted(int r3, int r4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(r3, r4);
            }
        }

        public final void notifyItemRangeRemoved(int r3, int r4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(r3, r4);
            }
        }

        public final void notifyStateRestorationPolicyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ChildDrawingOrderCallback {
    }

    /* loaded from: classes.dex */
    public static class EdgeEffectFactory {
    }

    /* loaded from: classes.dex */
    public static abstract class ItemAnimator {
        public ItemAnimatorListener mListener = null;
        public final ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList<>();
        public final long mAddDuration = 120;
        public final long mRemoveDuration = 120;
        public final long mMoveDuration = 250;
        public final long mChangeDuration = 250;

        /* loaded from: classes.dex */
        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        /* loaded from: classes.dex */
        public interface ItemAnimatorListener {
        }

        /* loaded from: classes.dex */
        public static class ItemHolderInfo {
            public int left;
            public int top;

            public final void setFrom(ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                view.getRight();
                view.getBottom();
            }
        }

        public static void buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            int r0 = viewHolder.mFlags & 14;
            if (!viewHolder.isInvalid() && (r0 & 4) == 0) {
                viewHolder.getOldPosition();
                viewHolder.getAbsoluteAdapterPosition();
            }
        }

        public abstract boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder, List<Object> list) {
            if (((SimpleItemAnimator) this).mSupportsChangeAnimations && !viewHolder.isInvalid()) {
                return false;
            }
            return true;
        }

        public final void dispatchAnimationFinished(ViewHolder viewHolder) {
            ItemAnimatorListener itemAnimatorListener = this.mListener;
            if (itemAnimatorListener != null) {
                ItemAnimatorRestoreListener itemAnimatorRestoreListener = (ItemAnimatorRestoreListener) itemAnimatorListener;
                itemAnimatorRestoreListener.getClass();
                viewHolder.setIsRecyclable(true);
                if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                    viewHolder.mShadowedHolder = null;
                }
                viewHolder.mShadowingHolder = null;
                if (!viewHolder.shouldBeKeptAsChild()) {
                    View view = viewHolder.itemView;
                    RecyclerView recyclerView = RecyclerView.this;
                    if (!recyclerView.removeAnimatingView(view) && viewHolder.isTmpDetached()) {
                        recyclerView.removeDetachedView(viewHolder.itemView, false);
                    }
                }
            }
        }

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public abstract boolean isRunning();

        public abstract void runPendingAnimations();
    }

    /* loaded from: classes.dex */
    public class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        public ItemAnimatorRestoreListener() {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class LayoutManager {
        boolean mAutoMeasure;
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck;
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$LayoutManager$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements ViewBoundsCheck.Callback {
            public AnonymousClass1() {
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public final View getChildAt(int r2) {
                return LayoutManager.this.getChildAt(r2);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public final int getChildEnd(View view) {
                return LayoutManager.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public final int getChildStart(View view) {
                return LayoutManager.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public final int getParentEnd() {
                LayoutManager layoutManager = LayoutManager.this;
                return layoutManager.getWidth() - layoutManager.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public final int getParentStart() {
                return LayoutManager.this.getPaddingLeft();
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$LayoutManager$2 */
        /* loaded from: classes.dex */
        public class AnonymousClass2 implements ViewBoundsCheck.Callback {
            public AnonymousClass2() {
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public final View getChildAt(int r2) {
                return LayoutManager.this.getChildAt(r2);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public final int getChildEnd(View view) {
                return LayoutManager.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public final int getChildStart(View view) {
                return LayoutManager.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public final int getParentEnd() {
                LayoutManager layoutManager = LayoutManager.this;
                return layoutManager.getHeight() - layoutManager.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public final int getParentStart() {
                return LayoutManager.this.getPaddingTop();
            }
        }

        /* loaded from: classes.dex */
        public interface LayoutPrefetchRegistry {
        }

        /* loaded from: classes.dex */
        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public LayoutManager() {
            AnonymousClass1 anonymousClass1 = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.1
                public AnonymousClass1() {
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final View getChildAt(int r2) {
                    return LayoutManager.this.getChildAt(r2);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getChildEnd(View view) {
                    return LayoutManager.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getChildStart(View view) {
                    return LayoutManager.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getParentEnd() {
                    LayoutManager layoutManager = LayoutManager.this;
                    return layoutManager.getWidth() - layoutManager.getPaddingRight();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getParentStart() {
                    return LayoutManager.this.getPaddingLeft();
                }
            };
            this.mHorizontalBoundCheckCallback = anonymousClass1;
            AnonymousClass2 anonymousClass2 = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.2
                public AnonymousClass2() {
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final View getChildAt(int r2) {
                    return LayoutManager.this.getChildAt(r2);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getChildEnd(View view) {
                    return LayoutManager.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getChildStart(View view) {
                    return LayoutManager.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getParentEnd() {
                    LayoutManager layoutManager = LayoutManager.this;
                    return layoutManager.getHeight() - layoutManager.getPaddingBottom();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int getParentStart() {
                    return LayoutManager.this.getPaddingTop();
                }
            };
            this.mVerticalBoundCheckCallback = anonymousClass2;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(anonymousClass1);
            this.mVerticalBoundCheck = new ViewBoundsCheck(anonymousClass2);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View view, int r7, boolean z) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!z && !childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            } else {
                SimpleArrayMap<ViewHolder, ViewInfoStore.InfoRecord> simpleArrayMap = this.mRecyclerView.mViewInfoStore.mLayoutHolderMap;
                ViewInfoStore.InfoRecord orDefault = simpleArrayMap.getOrDefault(childViewHolderInt, null);
                if (orDefault == null) {
                    orDefault = ViewInfoStore.InfoRecord.obtain();
                    simpleArrayMap.put(childViewHolderInt, orDefault);
                }
                orDefault.flags |= 1;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!childViewHolderInt.wasReturnedFromScrap() && !childViewHolderInt.isScrap()) {
                if (view.getParent() == this.mRecyclerView) {
                    int indexOfChild = this.mChildHelper.indexOfChild(view);
                    if (r7 == -1) {
                        r7 = this.mChildHelper.getChildCount();
                    }
                    if (indexOfChild != -1) {
                        if (indexOfChild != r7) {
                            this.mRecyclerView.mLayout.moveView(indexOfChild, r7);
                        }
                    } else {
                        StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        sb.append(this.mRecyclerView.indexOfChild(view));
                        throw new IllegalStateException(ChildHelper$$ExternalSyntheticOutline0.m(this.mRecyclerView, sb));
                    }
                } else {
                    this.mChildHelper.addView(view, r7, false);
                    layoutParams.mInsetsDirty = true;
                    SmoothScroller smoothScroller = this.mSmoothScroller;
                    if (smoothScroller != null && smoothScroller.isRunning()) {
                        this.mSmoothScroller.onChildAttachedToWindow(view);
                    }
                }
            } else {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.attachViewToParent(view, r7, view.getLayoutParams(), false);
            }
            if (layoutParams.mPendingInvalidate) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public static int chooseSize(int r2, int r3, int r4) {
            int mode = View.MeasureSpec.getMode(r2);
            int size = View.MeasureSpec.getSize(r2);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 1073741824) {
                    return Math.max(r3, r4);
                }
                return size;
            }
            return Math.min(size, Math.max(r3, r4));
        }

        private void detachViewInternal(int r1, View view) {
            this.mChildHelper.detachViewFromParent(r1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:            if (r3 >= 0) goto L25;     */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto Lf
                if (r3 < 0) goto Ld
                goto L11
            Ld:
                r3 = r2
                goto L1e
            Lf:
                if (r3 < 0) goto L13
            L11:
                r2 = r0
                goto L1e
            L13:
                r4 = -1
                if (r3 != r4) goto L18
                r3 = r1
                goto L11
            L18:
                r4 = -2
                if (r3 != r4) goto Ld
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1
            L1e:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] r0 = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int r5 = left - paddingLeft;
            int min = Math.min(0, r5);
            int r6 = top - paddingTop;
            int min2 = Math.min(0, r6);
            int r10 = width2 - width;
            int max = Math.max(0, r10);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() == 1) {
                if (max == 0) {
                    max = Math.max(min, r10);
                }
            } else {
                if (min == 0) {
                    min = Math.min(r5, max);
                }
                max = min;
            }
            if (min2 == 0) {
                min2 = Math.min(r6, max2);
            }
            r0[0] = max;
            r0[1] = min2;
            return r0;
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int r4, int r5) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, r4, r5);
            properties.orientation = obtainStyledAttributes.getInt(0, 1);
            properties.spanCount = obtainStyledAttributes.getInt(10, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(9, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int r8, int r9) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - r8 >= width || rect.right - r8 <= paddingLeft || rect.top - r9 >= height || rect.bottom - r9 <= paddingTop) {
                return false;
            }
            return true;
        }

        private static boolean isMeasurementUpToDate(int r3, int r4, int r5) {
            int mode = View.MeasureSpec.getMode(r4);
            int size = View.MeasureSpec.getSize(r4);
            if (r5 > 0 && r3 != r5) {
                return false;
            }
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    return true;
                }
                if (mode != 1073741824 || size != r3) {
                    return false;
                }
                return true;
            }
            if (size < r3) {
                return false;
            }
            return true;
        }

        private void scrapOrRecycleView(Recycler recycler, int r4, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(r4);
                recycler.recycleViewHolderInternal(childViewHolderInt);
            } else {
                detachViewAt(r4);
                recycler.scrapView(view);
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int r5, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                SimpleArrayMap<ViewHolder, ViewInfoStore.InfoRecord> simpleArrayMap = this.mRecyclerView.mViewInfoStore.mLayoutHolderMap;
                ViewInfoStore.InfoRecord orDefault = simpleArrayMap.getOrDefault(childViewHolderInt, null);
                if (orDefault == null) {
                    orDefault = ViewInfoStore.InfoRecord.obtain();
                    simpleArrayMap.put(childViewHolderInt, orDefault);
                }
                orDefault.flags |= 1;
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            this.mChildHelper.attachViewToParent(view, r5, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            if (layoutParams != null) {
                return true;
            }
            return false;
        }

        public int computeHorizontalScrollExtent(State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(State state) {
            return 0;
        }

        public int computeVerticalScrollRange(State state) {
            return 0;
        }

        public void detachAndScrapAttachedViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int r2, Recycler recycler) {
            scrapOrRecycleView(recycler, r2, getChildAt(r2));
        }

        public void detachView(View view) {
            int indexOfChild = this.mChildHelper.indexOfChild(view);
            if (indexOfChild >= 0) {
                detachViewInternal(indexOfChild, view);
            }
        }

        public void detachViewAt(int r2) {
            detachViewInternal(r2, getChildAt(r2));
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.isHidden(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int r6) {
            int childCount = getChildCount();
            for (int r1 = 0; r1 < childCount; r1++) {
                View childAt = getChildAt(r1);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == r6 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.mInPreLayout || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        public View getChildAt(int r2) {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildAt(r2);
            }
            return null;
        }

        public int getChildCount() {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildCount();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && recyclerView.mClipToPadding) {
                return true;
            }
            return false;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public int getDecoratedBottom(View view) {
            return getBottomDecorationHeight(view) + view.getBottom();
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return getRightDecorationWidth(view) + view.getRight();
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.isHidden(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            Adapter adapter;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            return ViewCompat.Api17Impl.getLayoutDirection(recyclerView);
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        public int getMinimumHeight() {
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            return ViewCompat.Api16Impl.getMinimumHeight(recyclerView);
        }

        public int getMinimumWidth() {
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            return ViewCompat.Api16Impl.getMinimumWidth(recyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                return ViewCompat.Api17Impl.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                return ViewCompat.Api17Impl.getPaddingStart(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int r2 = 0; r2 < childCount; r2++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(r2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && recyclerView.hasFocus()) {
                return true;
            }
            return false;
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent == recyclerView && recyclerView.indexOfChild(view) != -1) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                childViewHolderInt.addFlags(128);
                this.mRecyclerView.mViewInfoStore.removeViewHolder(childViewHolderInt);
                return;
            }
            throw new IllegalArgumentException(ChildHelper$$ExternalSyntheticOutline0.m(this.mRecyclerView, new StringBuilder("View should be fully attached to be ignored")));
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && recyclerView.isFocused()) {
                return true;
            }
            return false;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null && smoothScroller.isRunning()) {
                return true;
            }
            return false;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3;
            if (this.mHorizontalBoundCheck.isViewWithinBoundFlags(view) && this.mVerticalBoundCheck.isViewWithinBoundFlags(view)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z) {
                return z3;
            }
            return !z3;
        }

        public void layoutDecorated(View view, int r4, int r5, int r6, int r7) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            view.layout(r4 + rect.left, r5 + rect.top, r6 - rect.right, r7 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int r5, int r6, int r7, int r8) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view.layout(r5 + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, r6 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (r7 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (r8 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void measureChild(View view, int r7, int r8) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int r2 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + r7;
            int r72 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + r8;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + r2, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + r72, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int r7, int r8) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int r2 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + r7;
            int r72 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + r8;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + r2, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + r72, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int r3, int r4) {
            View childAt = getChildAt(r3);
            if (childAt != null) {
                detachViewAt(r3);
                attachView(childAt, r4);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r3 + this.mRecyclerView.toString());
            }
        }

        public void offsetChildrenHorizontal(int r2) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(r2);
            }
        }

        public void offsetChildrenVertical(int r2) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(r2);
            }
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int r3, int r4) {
            return false;
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int r2, Recycler recycler, State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public View onInterceptFocusSearch(View view, int r2) {
            return null;
        }

        public void onItemsUpdated(RecyclerView recyclerView, int r2, int r3) {
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onMeasure(Recycler recycler, State state, int r3, int r4) {
            this.mRecyclerView.defaultOnMeasure(r3, r4);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int r3, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, r3, bundle);
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int r4, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.removeViewAt(childCount);
            }
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public void removeAndRecycleScrapInt(Recycler recycler) {
            ArrayList<ViewHolder> arrayList;
            int size = recycler.mAttachedScrap.size();
            int r1 = size - 1;
            while (true) {
                arrayList = recycler.mAttachedScrap;
                if (r1 < 0) {
                    break;
                }
                View view = arrayList.get(r1).itemView;
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    ViewHolder childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt2.mScrapContainer = null;
                    childViewHolderInt2.mInChangeScrap = false;
                    childViewHolderInt2.clearReturnedFromScrapFlag();
                    recycler.recycleViewHolderInternal(childViewHolderInt2);
                }
                r1--;
            }
            arrayList.clear();
            ArrayList<ViewHolder> arrayList2 = recycler.mChangedScrap;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int r2, Recycler recycler) {
            View childAt = getChildAt(r2);
            removeViewAt(r2);
            recycler.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            ChildHelper childHelper = this.mChildHelper;
            AnonymousClass5 anonymousClass5 = (AnonymousClass5) childHelper.mCallback;
            int indexOfChild = RecyclerView.this.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (childHelper.mBucket.remove(indexOfChild)) {
                    childHelper.unhideViewInternal(view);
                }
                anonymousClass5.removeViewAt(indexOfChild);
            }
        }

        public void removeViewAt(int r2) {
            if (getChildAt(r2) != null) {
                this.mChildHelper.removeViewAt(r2);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int r1, Recycler recycler, State state) {
            return 0;
        }

        public int scrollVerticallyBy(int r1, Recycler recycler, State state) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        public void setMeasureSpecs(int r2, int r3) {
            this.mWidth = View.MeasureSpec.getSize(r2);
            int mode = View.MeasureSpec.getMode(r2);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(r3);
            int mode2 = View.MeasureSpec.getMode(r3);
            this.mHeightMode = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        public void setMeasuredDimension(Rect rect, int r4, int r5) {
            setMeasuredDimension(chooseSize(r4, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(r5, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int r9, int r10) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(r9, r10);
                return;
            }
            int r1 = Integer.MIN_VALUE;
            int r4 = Integer.MAX_VALUE;
            int r2 = Integer.MIN_VALUE;
            int r3 = Integer.MAX_VALUE;
            for (int r5 = 0; r5 < childCount; r5++) {
                View childAt = getChildAt(r5);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int r6 = rect.left;
                if (r6 < r3) {
                    r3 = r6;
                }
                int r62 = rect.right;
                if (r62 > r1) {
                    r1 = r62;
                }
                int r63 = rect.top;
                if (r63 < r4) {
                    r4 = r63;
                }
                int r64 = rect.bottom;
                if (r64 > r2) {
                    r2 = r64;
                }
            }
            this.mRecyclerView.mTempRect.set(r3, r4, r1, r2);
            setMeasuredDimension(this.mRecyclerView.mTempRect, r9, r10);
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public boolean shouldMeasureChild(View view, int r4, int r5, LayoutParams layoutParams) {
            if (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), r4, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), r5, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return false;
            }
            return true;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View view, int r4, int r5, LayoutParams layoutParams) {
            if (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), r4, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getMeasuredHeight(), r5, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return false;
            }
            return true;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int r3) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            smoothScroller.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void stopSmoothScroller() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public void addDisappearingView(View view, int r3) {
            addViewInt(view, r3, true);
        }

        public void addView(View view, int r3) {
            addViewInt(view, r3, false);
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            Adapter adapter = this.mRecyclerView.mAdapter;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.getItemCount());
            }
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(DfuBaseService.ERROR_REMOTE_MASK);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), getSelectionModeForAccessibility(recycler, state), isLayoutHierarchical(recycler, state)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
        }

        public void onItemsUpdated(RecyclerView recyclerView, int r2, int r3, Object obj) {
            onItemsUpdated(recyclerView, r2, r3);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, State state, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public boolean performAccessibilityAction(Recycler recycler, State state, int r10, Bundle bundle) {
            int height;
            int width;
            int r3;
            int r2;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (r10 == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    r3 = height;
                    r2 = width;
                }
                r3 = height;
                r2 = 0;
            } else if (r10 != 8192) {
                r2 = 0;
                r3 = 0;
            } else {
                height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    r3 = height;
                    r2 = width;
                }
                r3 = height;
                r2 = 0;
            }
            if (r3 == 0 && r2 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(r2, r3, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean performAccessibilityActionForItem(View view, int r9, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, r9, bundle);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int r0 = childRectangleOnScreenScrollAmount[0];
            int r4 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, r0, r4)) || (r0 == 0 && r4 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(r0, r4);
            } else {
                recyclerView.smoothScrollBy(r0, r4);
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:            if (r5 == 1073741824) goto L38;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2f
                if (r5 == r2) goto L20
                if (r5 == 0) goto L2f
                if (r5 == r3) goto L20
                goto L2f
            L1a:
                if (r7 < 0) goto L1e
            L1c:
                r5 = r3
                goto L31
            L1e:
                if (r7 != r1) goto L22
            L20:
                r7 = r4
                goto L31
            L22:
                if (r7 != r0) goto L2f
                if (r5 == r2) goto L2c
                if (r5 != r3) goto L29
                goto L2c
            L29:
                r7 = r4
                r5 = r6
                goto L31
            L2c:
                r7 = r4
                r5 = r2
                goto L31
            L2f:
                r5 = r6
                r7 = r5
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int r2, int r3) {
            this.mRecyclerView.setMeasuredDimension(r2, r3);
        }

        public void attachView(View view, int r3) {
            attachView(view, r3, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onLayoutCompleted(State state) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public void onScrollStateChanged(int r1) {
        }

        public void scrollToPosition(int r1) {
        }

        public void collectInitialPrefetchPositions(int r1, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public void onItemsAdded(RecyclerView recyclerView, int r2, int r3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int r2, int r3) {
        }

        public void collectAdjacentPrefetchPositions(int r1, int r2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int r2, int r3, int r4) {
        }
    }

    /* loaded from: classes.dex */
    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow();

        void onChildViewDetachedFromWindow(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class OnFlingListener {
    }

    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static class RecycledViewPool {
        public final SparseArray<ScrapData> mScrap = new SparseArray<>();
        public int mAttachCount = 0;

        /* loaded from: classes.dex */
        public static class ScrapData {
            public final ArrayList<ViewHolder> mScrapHeap = new ArrayList<>();
            public final int mMaxScrap = 5;
            public long mCreateRunningAverageNs = 0;
            public long mBindRunningAverageNs = 0;
        }

        public final ScrapData getScrapDataForType(int r3) {
            SparseArray<ScrapData> sparseArray = this.mScrap;
            ScrapData scrapData = sparseArray.get(r3);
            if (scrapData == null) {
                ScrapData scrapData2 = new ScrapData();
                sparseArray.put(r3, scrapData2);
                return scrapData2;
            }
            return scrapData;
        }
    }

    /* loaded from: classes.dex */
    public final class Recycler {
        public final ArrayList<ViewHolder> mAttachedScrap;
        public final ArrayList<ViewHolder> mCachedViews;
        public ArrayList<ViewHolder> mChangedScrap;
        public RecycledViewPool mRecyclerPool;
        public int mRequestedCacheMax;
        public final List<ViewHolder> mUnmodifiableAttachedScrap;
        public int mViewCacheMax;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.mAttachedScrap = arrayList;
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList<>();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(arrayList);
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        public static void invalidateDisplayListInt(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    invalidateDisplayListInt((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
            } else {
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public final void addViewHolderToRecycledViewPool(ViewHolder viewHolder, boolean z) {
            AccessibilityDelegateCompat accessibilityDelegateCompat;
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            RecyclerView recyclerView = RecyclerView.this;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = recyclerView.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate != null) {
                RecyclerViewAccessibilityDelegate.ItemDelegate itemDelegate = recyclerViewAccessibilityDelegate.mItemDelegate;
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    accessibilityDelegateCompat = (AccessibilityDelegateCompat) itemDelegate.mOriginalItemDelegates.remove(view);
                } else {
                    accessibilityDelegateCompat = null;
                }
                ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
            }
            if (z) {
                RecyclerListener recyclerListener = recyclerView.mRecyclerListener;
                if (recyclerListener != null) {
                    recyclerListener.onViewRecycled();
                }
                int size = recyclerView.mRecyclerListeners.size();
                for (int r0 = 0; r0 < size; r0++) {
                    recyclerView.mRecyclerListeners.get(r0).onViewRecycled();
                }
                Adapter adapter = recyclerView.mAdapter;
                if (adapter != null) {
                    adapter.onViewRecycled(viewHolder);
                }
                if (recyclerView.mState != null) {
                    recyclerView.mViewInfoStore.removeViewHolder(viewHolder);
                }
            }
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
            RecycledViewPool recycledViewPool = getRecycledViewPool();
            recycledViewPool.getClass();
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = recycledViewPool.getScrapDataForType(itemViewType).mScrapHeap;
            if (recycledViewPool.mScrap.get(itemViewType).mMaxScrap > arrayList.size()) {
                viewHolder.resetInternal();
                arrayList.add(viewHolder);
            }
        }

        public final int convertPreLayoutPositionToPostLayout(int r5) {
            RecyclerView recyclerView = RecyclerView.this;
            if (r5 >= 0 && r5 < recyclerView.mState.getItemCount()) {
                if (!recyclerView.mState.mInPreLayout) {
                    return r5;
                }
                return recyclerView.mAdapterHelper.findPositionOffset(r5, 0);
            }
            StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("invalid position ", r5, ". State item count is ");
            m.append(recyclerView.mState.getItemCount());
            m.append(recyclerView.exceptionLabel());
            throw new IndexOutOfBoundsException(m.toString());
        }

        public final RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                this.mRecyclerPool = new RecycledViewPool();
            }
            return this.mRecyclerPool;
        }

        public final void recycleAndClearCachedViews() {
            ArrayList<ViewHolder> arrayList = this.mCachedViews;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                recycleCachedViewAt(size);
            }
            arrayList.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = RecyclerView.this.mPrefetchRegistry;
                int[] r1 = layoutPrefetchRegistryImpl.mPrefetchArray;
                if (r1 != null) {
                    Arrays.fill(r1, -1);
                }
                layoutPrefetchRegistryImpl.mCount = 0;
            }
        }

        public final void recycleCachedViewAt(int r4) {
            ArrayList<ViewHolder> arrayList = this.mCachedViews;
            addViewHolderToRecycledViewPool(arrayList.get(r4), true);
            arrayList.remove(r4);
        }

        public final void recycleView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            boolean isTmpDetached = childViewHolderInt.isTmpDetached();
            RecyclerView recyclerView = RecyclerView.this;
            if (isTmpDetached) {
                recyclerView.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            recycleViewHolderInternal(childViewHolderInt);
            if (recyclerView.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                recyclerView.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x007d, code lost:            if (r6 == false) goto L133;     */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x007f, code lost:            r5 = r5 - 1;     */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0081, code lost:            if (r5 < 0) goto L168;     */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:            r6 = r4.get(r5).mPosition;        r7 = r2.mPrefetchRegistry;     */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x008f, code lost:            if (r7.mPrefetchArray == null) goto L143;     */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:            r8 = r7.mCount * 2;        r9 = 0;     */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0096, code lost:            if (r9 >= r8) goto L173;     */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x009c, code lost:            if (r7.mPrefetchArray[r9] != r6) goto L142;     */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a0, code lost:            r9 = r9 + 2;     */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x009e, code lost:            r6 = true;     */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00a4, code lost:            if (r6 != false) goto L172;     */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00a6, code lost:            r5 = r5 + 1;     */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00a3, code lost:            r6 = false;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void recycleViewHolderInternal(androidx.recyclerview.widget.RecyclerView.ViewHolder r12) {
            /*
                Method dump skipped, instructions count: 283
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.recycleViewHolderInternal(androidx.recyclerview.widget.RecyclerView$ViewHolder):void");
        }

        public final void scrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            boolean hasAnyOfTheFlags = childViewHolderInt.hasAnyOfTheFlags(12);
            RecyclerView recyclerView = RecyclerView.this;
            if (!hasAnyOfTheFlags && childViewHolderInt.isUpdated() && !recyclerView.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.mChangedScrap == null) {
                    this.mChangedScrap = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.mChangedScrap.add(childViewHolderInt);
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !recyclerView.mAdapter.hasStableIds()) {
                throw new IllegalArgumentException(ChildHelper$$ExternalSyntheticOutline0.m(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
            }
            childViewHolderInt.setScrapContainer(this, false);
            this.mAttachedScrap.add(childViewHolderInt);
        }

        /* JADX WARN: Code restructure failed: missing block: B:249:0x041a, code lost:            if (r8 == false) goto L552;     */
        /* JADX WARN: Removed duplicated region for block: B:121:0x0219  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:216:0x03b0  */
        /* JADX WARN: Removed duplicated region for block: B:225:0x04a0  */
        /* JADX WARN: Removed duplicated region for block: B:228:0x04c5 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:232:0x04ac  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:244:0x0403  */
        /* JADX WARN: Removed duplicated region for block: B:253:0x043d  */
        /* JADX WARN: Removed duplicated region for block: B:256:0x044d  */
        /* JADX WARN: Removed duplicated region for block: B:276:0x0495  */
        /* JADX WARN: Removed duplicated region for block: B:279:0x048e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final androidx.recyclerview.widget.RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline(int r20, long r21) {
            /*
                Method dump skipped, instructions count: 1263
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.tryGetViewHolderForPositionByDeadline(int, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        public final void unscrapView(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.mChangedScrap.remove(viewHolder);
            } else {
                this.mAttachedScrap.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        public final void updateViewCacheSize() {
            int r0;
            LayoutManager layoutManager = RecyclerView.this.mLayout;
            if (layoutManager != null) {
                r0 = layoutManager.mPrefetchMaxCountObserved;
            } else {
                r0 = 0;
            }
            this.mViewCacheMax = this.mRequestedCacheMax + r0;
            ArrayList<ViewHolder> arrayList = this.mCachedViews;
            for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.mViewCacheMax; size--) {
                recycleCachedViewAt(size);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface RecyclerListener {
        void onViewRecycled();
    }

    /* loaded from: classes.dex */
    public class RecyclerViewDataObserver extends AdapterDataObserver {
        public RecyclerViewDataObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.assertNotInLayoutOrScroll(null);
            recyclerView.mState.mStructureChanged = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                recyclerView.requestLayout();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:            if (r2.size() == 1) goto L22;     */
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onItemRangeChanged(int r5, int r6, java.lang.Object r7) {
            /*
                r4 = this;
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                r1 = 0
                r0.assertNotInLayoutOrScroll(r1)
                androidx.recyclerview.widget.AdapterHelper r0 = r0.mAdapterHelper
                r1 = 1
                if (r6 >= r1) goto Lf
                r0.getClass()
                goto L25
            Lf:
                java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r2 = r0.mPendingUpdates
                r3 = 4
                androidx.recyclerview.widget.AdapterHelper$UpdateOp r5 = r0.obtainUpdateOp(r3, r5, r6, r7)
                r2.add(r5)
                int r5 = r0.mExistingUpdateTypes
                r5 = r5 | r3
                r0.mExistingUpdateTypes = r5
                int r5 = r2.size()
                if (r5 != r1) goto L25
                goto L26
            L25:
                r1 = 0
            L26:
                if (r1 == 0) goto L2b
                r4.triggerUpdateProcessor()
            L2b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.RecyclerViewDataObserver.onItemRangeChanged(int, int, java.lang.Object):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:            if (r3.size() == 1) goto L22;     */
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onItemRangeInserted(int r5, int r6) {
            /*
                r4 = this;
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                r1 = 0
                r0.assertNotInLayoutOrScroll(r1)
                androidx.recyclerview.widget.AdapterHelper r0 = r0.mAdapterHelper
                r2 = 1
                if (r6 >= r2) goto Lf
                r0.getClass()
                goto L24
            Lf:
                java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r3 = r0.mPendingUpdates
                androidx.recyclerview.widget.AdapterHelper$UpdateOp r5 = r0.obtainUpdateOp(r2, r5, r6, r1)
                r3.add(r5)
                int r5 = r0.mExistingUpdateTypes
                r5 = r5 | r2
                r0.mExistingUpdateTypes = r5
                int r5 = r3.size()
                if (r5 != r2) goto L24
                goto L25
            L24:
                r2 = 0
            L25:
                if (r2 == 0) goto L2a
                r4.triggerUpdateProcessor()
            L2a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.RecyclerViewDataObserver.onItemRangeInserted(int, int):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0023, code lost:            if (r2.size() == 1) goto L22;     */
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onItemRangeMoved(int r5, int r6) {
            /*
                r4 = this;
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                r1 = 0
                r0.assertNotInLayoutOrScroll(r1)
                androidx.recyclerview.widget.AdapterHelper r0 = r0.mAdapterHelper
                r0.getClass()
                if (r5 != r6) goto Le
                goto L26
            Le:
                java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r2 = r0.mPendingUpdates
                r3 = 8
                androidx.recyclerview.widget.AdapterHelper$UpdateOp r5 = r0.obtainUpdateOp(r3, r5, r6, r1)
                r2.add(r5)
                int r5 = r0.mExistingUpdateTypes
                r5 = r5 | r3
                r0.mExistingUpdateTypes = r5
                int r5 = r2.size()
                r6 = 1
                if (r5 != r6) goto L26
                goto L27
            L26:
                r6 = 0
            L27:
                if (r6 == 0) goto L2c
                r4.triggerUpdateProcessor()
            L2c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.RecyclerViewDataObserver.onItemRangeMoved(int, int):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:            if (r3.size() == 1) goto L22;     */
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onItemRangeRemoved(int r6, int r7) {
            /*
                r5 = this;
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                r1 = 0
                r0.assertNotInLayoutOrScroll(r1)
                androidx.recyclerview.widget.AdapterHelper r0 = r0.mAdapterHelper
                r2 = 1
                if (r7 >= r2) goto Lf
                r0.getClass()
                goto L25
            Lf:
                java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r3 = r0.mPendingUpdates
                r4 = 2
                androidx.recyclerview.widget.AdapterHelper$UpdateOp r6 = r0.obtainUpdateOp(r4, r6, r7, r1)
                r3.add(r6)
                int r6 = r0.mExistingUpdateTypes
                r6 = r6 | r4
                r0.mExistingUpdateTypes = r6
                int r6 = r3.size()
                if (r6 != r2) goto L25
                goto L26
            L25:
                r2 = 0
            L26:
                if (r2 == 0) goto L2b
                r5.triggerUpdateProcessor()
            L2b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.RecyclerViewDataObserver.onItemRangeRemoved(int, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onStateRestorationPolicyChanged() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState != null && (adapter = recyclerView.mAdapter) != null && adapter.canRestoreState()) {
                recyclerView.requestLayout();
            }
        }

        public final void triggerUpdateProcessor() {
            boolean z = RecyclerView.POST_UPDATES_ON_ANIMATION;
            RecyclerView recyclerView = RecyclerView.this;
            if (z && recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                Runnable runnable = recyclerView.mUpdateChildViewsRunnable;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.postOnAnimation(recyclerView, runnable);
            } else {
                recyclerView.mAdapterUpdateDuringMeasure = true;
                recyclerView.requestLayout();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public Parcelable mLayoutState;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$SavedState$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r1) {
                return new SavedState[r1];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r3) {
            parcel.writeParcelable(this.mSuperState, r3);
            parcel.writeParcelable(this.mLayoutState, 0);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final Action mRecyclingAction = new Action();

        /* loaded from: classes.dex */
        public static class Action {
            public int mJumpToPosition = -1;
            public boolean mChanged = false;
            public int mConsecutiveUpdates = 0;
            public int mDx = 0;
            public int mDy = 0;
            public int mDuration = Integer.MIN_VALUE;
            public Interpolator mInterpolator = null;

            public final void runIfNecessary(RecyclerView recyclerView) {
                int r0 = this.mJumpToPosition;
                if (r0 >= 0) {
                    this.mJumpToPosition = -1;
                    recyclerView.jumpToPositionForSmoothScroller(r0);
                    this.mChanged = false;
                    return;
                }
                if (this.mChanged) {
                    Interpolator interpolator = this.mInterpolator;
                    if (interpolator != null && this.mDuration < 1) {
                        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                    }
                    int r3 = this.mDuration;
                    if (r3 >= 1) {
                        recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, interpolator, r3);
                        int r7 = this.mConsecutiveUpdates + 1;
                        this.mConsecutiveUpdates = r7;
                        if (r7 > 10) {
                            Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.mChanged = false;
                        return;
                    }
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
                this.mConsecutiveUpdates = 0;
            }
        }

        /* loaded from: classes.dex */
        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int r1);
        }

        public PointF computeScrollVectorForPosition(int r3) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(r3);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int r2) {
            return this.mRecyclerView.mLayout.findViewByPosition(r2);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int r2) {
            this.mRecyclerView.scrollToPosition(r2);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float sqrt = (float) Math.sqrt((f2 * f2) + (f * f));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public void onAnimation(int r7, int r8) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
                float f = computeScrollVectorForPosition.x;
                if (f != 0.0f || computeScrollVectorForPosition.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f), (int) Math.signum(computeScrollVectorForPosition.y), null);
                }
            }
            boolean z = false;
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.runIfNecessary(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(r7, r8, recyclerView.mState, this.mRecyclingAction);
                Action action = this.mRecyclingAction;
                if (action.mJumpToPosition >= 0) {
                    z = true;
                }
                action.runIfNecessary(recyclerView);
                if (z && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.postOnAnimation();
                }
            }
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        public abstract void onSeekTargetStep(int r1, int r2, State state, Action action);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(View view, State state, Action action);

        public void setTargetPosition(int r1) {
            this.mTargetPosition = r1;
        }

        public void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            ViewFlinger viewFlinger = recyclerView.mViewFlinger;
            RecyclerView.this.removeCallbacks(viewFlinger);
            viewFlinger.mOverScroller.abortAnimation();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            int r4 = this.mTargetPosition;
            if (r4 != -1) {
                recyclerView.mState.mTargetPosition = r4;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.postOnAnimation();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public final void stop() {
            if (!this.mRunning) {
                return;
            }
            this.mRunning = false;
            onStop();
            this.mRecyclerView.mState.mTargetPosition = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }

    /* loaded from: classes.dex */
    public static class State {
        public long mFocusedItemId;
        public int mFocusedItemPosition;
        public int mFocusedSubChildId;
        public int mTargetPosition = -1;
        public int mPreviousLayoutItemCount = 0;
        public int mDeletedInvisibleItemCountSincePreviousLayout = 0;
        public int mLayoutStep = 1;
        public int mItemCount = 0;
        public boolean mStructureChanged = false;
        public boolean mInPreLayout = false;
        public boolean mTrackOldChangeHolders = false;
        public boolean mIsMeasuring = false;
        public boolean mRunSimpleAnimations = false;
        public boolean mRunPredictiveAnimations = false;

        public final void assertLayoutStep(int r4) {
            if ((this.mLayoutStep & r4) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r4) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
        }

        public final int getItemCount() {
            if (this.mInPreLayout) {
                return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
            }
            return this.mItemCount;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("State{mTargetPosition=");
            sb.append(this.mTargetPosition);
            sb.append(", mData=null, mItemCount=");
            sb.append(this.mItemCount);
            sb.append(", mIsMeasuring=");
            sb.append(this.mIsMeasuring);
            sb.append(", mPreviousLayoutItemCount=");
            sb.append(this.mPreviousLayoutItemCount);
            sb.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            sb.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
            sb.append(", mStructureChanged=");
            sb.append(this.mStructureChanged);
            sb.append(", mInPreLayout=");
            sb.append(this.mInPreLayout);
            sb.append(", mRunSimpleAnimations=");
            sb.append(this.mRunSimpleAnimations);
            sb.append(", mRunPredictiveAnimations=");
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.mRunPredictiveAnimations, '}');
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCacheExtension {
    }

    /* loaded from: classes.dex */
    public class ViewFlinger implements Runnable {
        public boolean mEatRunOnAnimationRequest;
        public Interpolator mInterpolator;
        public int mLastFlingX;
        public int mLastFlingY;
        public OverScroller mOverScroller;
        public boolean mReSchedulePostAnimationCallback;

        public ViewFlinger() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = interpolator;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
                return;
            }
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.removeCallbacks(this);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postOnAnimation(recyclerView, this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r16;
            int r17;
            int r14;
            int r15;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            int r2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                recyclerView.removeCallbacks(this);
                this.mOverScroller.abortAnimation();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int r7 = currX - this.mLastFlingX;
                int r8 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                int[] r4 = recyclerView.mReusableIntPair;
                r4[0] = 0;
                r4[1] = 0;
                if (recyclerView.dispatchNestedPreScroll(r7, r8, r4, null, 1)) {
                    int[] r1 = recyclerView.mReusableIntPair;
                    r7 -= r1[0];
                    r8 -= r1[1];
                }
                if (recyclerView.getOverScrollMode() != 2) {
                    recyclerView.considerReleasingGlowsOnScroll(r7, r8);
                }
                if (recyclerView.mAdapter != null) {
                    int[] r12 = recyclerView.mReusableIntPair;
                    r12[0] = 0;
                    r12[1] = 0;
                    recyclerView.scrollStep(r7, r8, r12);
                    int[] r13 = recyclerView.mReusableIntPair;
                    int r22 = r13[0];
                    int r18 = r13[1];
                    int r72 = r7 - r22;
                    int r82 = r8 - r18;
                    SmoothScroller smoothScroller = recyclerView.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = recyclerView.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= itemCount) {
                            smoothScroller.setTargetPosition(itemCount - 1);
                            smoothScroller.onAnimation(r22, r18);
                        } else {
                            smoothScroller.onAnimation(r22, r18);
                        }
                    }
                    r14 = r18;
                    r15 = r22;
                    r16 = r72;
                    r17 = r82;
                } else {
                    r16 = r7;
                    r17 = r8;
                    r14 = 0;
                    r15 = 0;
                }
                if (!recyclerView.mItemDecorations.isEmpty()) {
                    recyclerView.invalidate();
                }
                int[] r83 = recyclerView.mReusableIntPair;
                r83[0] = 0;
                r83[1] = 0;
                recyclerView.dispatchNestedScroll(r15, r14, r16, r17, null, 1, r83);
                int[] r19 = recyclerView.mReusableIntPair;
                int r162 = r16 - r19[0];
                int r172 = r17 - r19[1];
                if (r15 != 0 || r14 != 0) {
                    recyclerView.dispatchOnScrolled(r15, r14);
                }
                if (!recyclerView.awakenScrollBars()) {
                    recyclerView.invalidate();
                }
                if (overScroller.getCurrX() == overScroller.getFinalX()) {
                    z = true;
                } else {
                    z = false;
                }
                if (overScroller.getCurrY() == overScroller.getFinalY()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!overScroller.isFinished() && ((!z && r162 == 0) || (!z2 && r172 == 0))) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                SmoothScroller smoothScroller2 = recyclerView.mLayout.mSmoothScroller;
                if (smoothScroller2 != null && smoothScroller2.isPendingInitialRun()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4 && z3) {
                    if (recyclerView.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (r162 < 0) {
                            r2 = -currVelocity;
                        } else if (r162 > 0) {
                            r2 = currVelocity;
                        } else {
                            r2 = 0;
                        }
                        if (r172 < 0) {
                            currVelocity = -currVelocity;
                        } else if (r172 <= 0) {
                            currVelocity = 0;
                        }
                        recyclerView.absorbGlows(r2, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
                        int[] r23 = layoutPrefetchRegistryImpl.mPrefetchArray;
                        if (r23 != null) {
                            Arrays.fill(r23, -1);
                        }
                        layoutPrefetchRegistryImpl.mCount = 0;
                    }
                } else {
                    postOnAnimation();
                    GapWorker gapWorker = recyclerView.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(recyclerView, r15, r14);
                    }
                }
            }
            SmoothScroller smoothScroller3 = recyclerView.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                recyclerView.removeCallbacks(this);
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.postOnAnimation(recyclerView, this);
            } else {
                recyclerView.setScrollState(0);
                recyclerView.stopNestedScroll(1);
            }
        }

        public final void smoothScrollBy(int r10, int r11, Interpolator interpolator, int r13) {
            boolean z;
            int height;
            RecyclerView recyclerView = RecyclerView.this;
            if (r13 == Integer.MIN_VALUE) {
                int abs = Math.abs(r10);
                int abs2 = Math.abs(r11);
                if (abs > abs2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    height = recyclerView.getWidth();
                } else {
                    height = recyclerView.getHeight();
                }
                if (!z) {
                    abs = abs2;
                }
                r13 = Math.min((int) (((abs / height) + 1.0f) * 300.0f), RecyclerView.MAX_SCROLL_DURATION);
            }
            int r8 = r13;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(recyclerView.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            recyclerView.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, r10, r11, r8);
            postOnAnimation();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        Adapter<? extends ViewHolder> mBindingAdapter;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        ViewHolder mShadowedHolder = null;
        ViewHolder mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        Recycler mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public ViewHolder(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int r2) {
            this.mFlags = r2 | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0) {
                View view = this.itemView;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (ViewCompat.Api16Impl.hasTransientState(view)) {
                    return true;
                }
            }
            return false;
        }

        public void flagRemovedAndOffsetPosition(int r2, int r3, boolean z) {
            addFlags(8);
            offsetPosition(r3, z);
            this.mPosition = r2;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int r0 = this.mPreLayoutPosition;
            if (r0 == -1) {
                return this.mPosition;
            }
            return r0;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int r0 = this.mPreLayoutPosition;
            if (r0 == -1) {
                return this.mPosition;
            }
            return r0;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                List<Object> list = this.mPayloads;
                if (list != null && list.size() != 0) {
                    return this.mUnmodifiedPayloads;
                }
                return FULLUPDATE_PAYLOADS;
            }
            return FULLUPDATE_PAYLOADS;
        }

        public boolean hasAnyOfTheFlags(int r2) {
            if ((r2 & this.mFlags) != 0) {
                return true;
            }
            return false;
        }

        public boolean isAdapterPositionUnknown() {
            if ((this.mFlags & 512) == 0 && !isInvalid()) {
                return false;
            }
            return true;
        }

        public boolean isAttachedToTransitionOverlay() {
            if (this.itemView.getParent() != null && this.itemView.getParent() != this.mOwnerRecyclerView) {
                return true;
            }
            return false;
        }

        public boolean isBound() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean isInvalid() {
            if ((this.mFlags & 4) != 0) {
                return true;
            }
            return false;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0) {
                View view = this.itemView;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (!ViewCompat.Api16Impl.hasTransientState(view)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isRemoved() {
            if ((this.mFlags & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean isScrap() {
            if (this.mScrapContainer != null) {
                return true;
            }
            return false;
        }

        public boolean isTmpDetached() {
            if ((this.mFlags & 256) != 0) {
                return true;
            }
            return false;
        }

        public boolean isUpdated() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean needsUpdate() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        public void offsetPosition(int r3, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += r3;
            }
            this.mPosition += r3;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int r0 = this.mPendingAccessibilityState;
            if (r0 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = r0;
            } else {
                View view = this.itemView;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.Api16Impl.getImportantForAccessibility(view);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int r3, int r4) {
            this.mFlags = (r3 & r4) | (this.mFlags & (~r4));
        }

        public final void setIsRecyclable(boolean z) {
            int r1;
            int r12 = this.mIsRecyclableCount;
            if (z) {
                r1 = r12 - 1;
            } else {
                r1 = r12 + 1;
            }
            this.mIsRecyclableCount = r1;
            if (r1 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && r1 == 1) {
                this.mFlags |= 16;
            } else if (z && r1 == 0) {
                this.mFlags &= -17;
            }
        }

        public void setScrapContainer(Recycler recycler, boolean z) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z;
        }

        public boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean shouldIgnore() {
            if ((this.mFlags & 128) != 0) {
                return true;
            }
            return false;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String simpleName;
            String str;
            if (getClass().isAnonymousClass()) {
                simpleName = "ViewHolder";
            } else {
                simpleName = getClass().getSimpleName();
            }
            StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(simpleName, "{");
            m.append(Integer.toHexString(hashCode()));
            m.append(" position=");
            m.append(this.mPosition);
            m.append(" id=");
            m.append(this.mItemId);
            m.append(", oldPos=");
            m.append(this.mOldPosition);
            m.append(", pLpos:");
            m.append(this.mPreLayoutPosition);
            StringBuilder sb = new StringBuilder(m.toString());
            if (isScrap()) {
                sb.append(" scrap ");
                if (this.mInChangeScrap) {
                    str = "[changeScrap]";
                } else {
                    str = "[attachedScrap]";
                }
                sb.append(str);
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        public boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) != 0) {
                return true;
            }
            return false;
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new AnonymousClass3();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        boolean z;
        View view = viewHolder.itemView;
        if (view.getParent() == this) {
            z = true;
        } else {
            z = false;
        }
        this.mRecycler.unscrapView(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z) {
            this.mChildHelper.addView(view, -1, true);
            return;
        }
        ChildHelper childHelper = this.mChildHelper;
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        if (indexOfChild >= 0) {
            childHelper.mBucket.set(indexOfChild);
            childHelper.hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    private void animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.setIsRecyclable(false);
        if (z) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.unscrapView(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.mItemAnimator.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == viewHolder.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                if (parent instanceof View) {
                    recyclerView = (View) parent;
                } else {
                    recyclerView = null;
                }
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int r10, int r11) {
        ClassLoader classLoader;
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(LayoutManager.class);
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(r10), Integer.valueOf(r11)};
                    } catch (NoSuchMethodException e) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassCastException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e4);
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e6);
                } catch (InvocationTargetException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
                }
            }
        }
    }

    private boolean didChildRangeChange(int r5, int r6) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] r0 = this.mMinMaxLayoutPositions;
        if (r0[0] == r5 && r0[1] == r6) {
            return false;
        }
        return true;
    }

    private void dispatchContentChangedIfNecessary() {
        int r0 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (r0 != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat$Api19Impl.setContentChangeTypes(obtain, r0);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        boolean z;
        boolean z2;
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        ViewInfoStore viewInfoStore = this.mViewInfoStore;
        viewInfoStore.mLayoutHolderMap.clear();
        viewInfoStore.mOldChangedHolders.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.mState;
        if (state.mRunSimpleAnimations && this.mItemsChanged) {
            z = true;
        } else {
            z = false;
        }
        state.mTrackOldChangeHolders = z;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        state.mInPreLayout = state.mRunPredictiveAnimations;
        state.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations) {
            int childCount = this.mChildHelper.getChildCount();
            for (int r4 = 0; r4 < childCount; r4++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(r4));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    ItemAnimator itemAnimator = this.mItemAnimator;
                    ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    itemAnimator.getClass();
                    ItemAnimator.ItemHolderInfo itemHolderInfo = new ItemAnimator.ItemHolderInfo();
                    itemHolderInfo.setFrom(childViewHolderInt);
                    SimpleArrayMap<ViewHolder, ViewInfoStore.InfoRecord> simpleArrayMap = this.mViewInfoStore.mLayoutHolderMap;
                    ViewInfoStore.InfoRecord orDefault = simpleArrayMap.getOrDefault(childViewHolderInt, null);
                    if (orDefault == null) {
                        orDefault = ViewInfoStore.InfoRecord.obtain();
                        simpleArrayMap.put(childViewHolderInt, orDefault);
                    }
                    orDefault.preInfo = itemHolderInfo;
                    orDefault.flags |= 4;
                    if (this.mState.mTrackOldChangeHolders && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.mOldChangedHolders.put(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.mRunPredictiveAnimations) {
            saveOldPositions();
            State state2 = this.mState;
            boolean z3 = state2.mStructureChanged;
            state2.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, state2);
            this.mState.mStructureChanged = z3;
            for (int r0 = 0; r0 < this.mChildHelper.getChildCount(); r0++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(r0));
                if (!childViewHolderInt2.shouldIgnore()) {
                    ViewInfoStore.InfoRecord orDefault2 = this.mViewInfoStore.mLayoutHolderMap.getOrDefault(childViewHolderInt2, null);
                    if (orDefault2 != null && (orDefault2.flags & 4) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                        boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(DfuBaseService.ERROR_REMOTE_MASK);
                        ItemAnimator itemAnimator2 = this.mItemAnimator;
                        childViewHolderInt2.getUnmodifiedPayloads();
                        itemAnimator2.getClass();
                        ItemAnimator.ItemHolderInfo itemHolderInfo2 = new ItemAnimator.ItemHolderInfo();
                        itemHolderInfo2.setFrom(childViewHolderInt2);
                        if (hasAnyOfTheFlags) {
                            recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, itemHolderInfo2);
                        } else {
                            SimpleArrayMap<ViewHolder, ViewInfoStore.InfoRecord> simpleArrayMap2 = this.mViewInfoStore.mLayoutHolderMap;
                            ViewInfoStore.InfoRecord orDefault3 = simpleArrayMap2.getOrDefault(childViewHolderInt2, null);
                            if (orDefault3 == null) {
                                orDefault3 = ViewInfoStore.InfoRecord.obtain();
                                simpleArrayMap2.put(childViewHolderInt2, orDefault3);
                            }
                            orDefault3.flags |= 2;
                            orDefault3.preInfo = itemHolderInfo2;
                        }
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep2() {
        boolean z;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.mLayoutState;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        State state = this.mState;
        state.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state);
        State state2 = this.mState;
        state2.mStructureChanged = false;
        if (state2.mRunSimpleAnimations && this.mItemAnimator != null) {
            z = true;
        } else {
            z = false;
        }
        state2.mRunSimpleAnimations = z;
        state2.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        boolean animateMove;
        boolean z;
        boolean z2;
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State state = this.mState;
        state.mLayoutStep = 1;
        if (state.mRunSimpleAnimations) {
            for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(childCount));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    this.mItemAnimator.getClass();
                    ItemAnimator.ItemHolderInfo itemHolderInfo = new ItemAnimator.ItemHolderInfo();
                    itemHolderInfo.setFrom(childViewHolderInt);
                    ViewHolder viewHolder = (ViewHolder) this.mViewInfoStore.mOldChangedHolders.get(changedHolderKey, null);
                    if (viewHolder != null && !viewHolder.shouldIgnore()) {
                        ViewInfoStore.InfoRecord orDefault = this.mViewInfoStore.mLayoutHolderMap.getOrDefault(viewHolder, null);
                        if (orDefault != null && (orDefault.flags & 1) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ViewInfoStore.InfoRecord orDefault2 = this.mViewInfoStore.mLayoutHolderMap.getOrDefault(childViewHolderInt, null);
                        if (orDefault2 != null && (orDefault2.flags & 1) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z && viewHolder == childViewHolderInt) {
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, itemHolderInfo);
                        } else {
                            ItemAnimator.ItemHolderInfo popFromLayoutStep = this.mViewInfoStore.popFromLayoutStep(viewHolder, 4);
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, itemHolderInfo);
                            ItemAnimator.ItemHolderInfo popFromLayoutStep2 = this.mViewInfoStore.popFromLayoutStep(childViewHolderInt, 8);
                            if (popFromLayoutStep == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, viewHolder);
                            } else {
                                animateChange(viewHolder, childViewHolderInt, popFromLayoutStep, popFromLayoutStep2, z, z2);
                            }
                        }
                    } else {
                        this.mViewInfoStore.addToPostLayout(childViewHolderInt, itemHolderInfo);
                    }
                }
            }
            ViewInfoStore viewInfoStore = this.mViewInfoStore;
            ViewInfoStore.ProcessCallback processCallback = this.mViewInfoProcessCallback;
            SimpleArrayMap<ViewHolder, ViewInfoStore.InfoRecord> simpleArrayMap = viewInfoStore.mLayoutHolderMap;
            for (int r3 = simpleArrayMap.mSize - 1; r3 >= 0; r3--) {
                ViewHolder keyAt = simpleArrayMap.keyAt(r3);
                ViewInfoStore.InfoRecord removeAt = simpleArrayMap.removeAt(r3);
                int r5 = removeAt.flags;
                if ((r5 & 3) == 3) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.mLayout.removeAndRecycleView(keyAt.itemView, recyclerView.mRecycler);
                } else if ((r5 & 1) != 0) {
                    ItemAnimator.ItemHolderInfo itemHolderInfo2 = removeAt.preInfo;
                    if (itemHolderInfo2 == null) {
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.mLayout.removeAndRecycleView(keyAt.itemView, recyclerView2.mRecycler);
                    } else {
                        ItemAnimator.ItemHolderInfo itemHolderInfo3 = removeAt.postInfo;
                        RecyclerView recyclerView3 = RecyclerView.this;
                        recyclerView3.mRecycler.unscrapView(keyAt);
                        recyclerView3.animateDisappearance(keyAt, itemHolderInfo2, itemHolderInfo3);
                    }
                } else if ((r5 & 14) == 14) {
                    RecyclerView.this.animateAppearance(keyAt, removeAt.preInfo, removeAt.postInfo);
                } else if ((r5 & 12) == 12) {
                    ItemAnimator.ItemHolderInfo itemHolderInfo4 = removeAt.preInfo;
                    ItemAnimator.ItemHolderInfo itemHolderInfo5 = removeAt.postInfo;
                    AnonymousClass4 anonymousClass4 = (AnonymousClass4) processCallback;
                    anonymousClass4.getClass();
                    keyAt.setIsRecyclable(false);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    if (recyclerView4.mDataSetHasChangedAfterLayout) {
                        if (recyclerView4.mItemAnimator.animateChange(keyAt, keyAt, itemHolderInfo4, itemHolderInfo5)) {
                            recyclerView4.postAnimationRunner();
                        }
                    } else {
                        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) recyclerView4.mItemAnimator;
                        simpleItemAnimator.getClass();
                        int r13 = itemHolderInfo4.left;
                        int r15 = itemHolderInfo5.left;
                        if (r13 == r15 && itemHolderInfo4.top == itemHolderInfo5.top) {
                            simpleItemAnimator.dispatchAnimationFinished(keyAt);
                            animateMove = false;
                        } else {
                            animateMove = simpleItemAnimator.animateMove(keyAt, r13, itemHolderInfo4.top, r15, itemHolderInfo5.top);
                        }
                        if (animateMove) {
                            recyclerView4.postAnimationRunner();
                        }
                    }
                } else if ((r5 & 4) != 0) {
                    ItemAnimator.ItemHolderInfo itemHolderInfo6 = removeAt.preInfo;
                    RecyclerView recyclerView5 = RecyclerView.this;
                    recyclerView5.mRecycler.unscrapView(keyAt);
                    recyclerView5.animateDisappearance(keyAt, itemHolderInfo6, null);
                } else if ((r5 & 8) != 0) {
                    RecyclerView.this.animateAppearance(keyAt, removeAt.preInfo, removeAt.postInfo);
                }
                removeAt.flags = 0;
                removeAt.preInfo = null;
                removeAt.postInfo = null;
                ViewInfoStore.InfoRecord.sPool.release(removeAt);
            }
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State state2 = this.mState;
        state2.mPreviousLayoutItemCount = state2.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        state2.mRunSimpleAnimations = false;
        state2.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> arrayList = this.mRecycler.mChangedScrap;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager.mPrefetchMaxObservedInInitialPrefetch) {
            layoutManager.mPrefetchMaxCountObserved = 0;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.updateViewCacheSize();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        ViewInfoStore viewInfoStore2 = this.mViewInfoStore;
        viewInfoStore2.mLayoutHolderMap.clear();
        viewInfoStore2.mOldChangedHolders.clear();
        int[] r0 = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(r0[0], r0[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (onItemTouchListener == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        onItemTouchListener.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int r3 = 0; r3 < size; r3++) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(r3);
            if (onItemTouchListener.onInterceptTouchEvent(motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] r9) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            r9[0] = -1;
            r9[1] = -1;
            return;
        }
        int r3 = Integer.MAX_VALUE;
        int r4 = Integer.MIN_VALUE;
        for (int r5 = 0; r5 < childCount; r5++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(r5));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < r3) {
                    r3 = layoutPosition;
                }
                if (layoutPosition > r4) {
                    r4 = layoutPosition;
                }
            }
        }
        r9[0] = r3;
        r9[1] = r4;
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int r2 = 0; r2 < childCount; r2++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(r2));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        ViewHolder findViewHolderForAdapterPosition;
        State state = this.mState;
        int r1 = state.mFocusedItemPosition;
        if (r1 == -1) {
            r1 = 0;
        }
        int itemCount = state.getItemCount();
        for (int r2 = r1; r2 < itemCount; r2++) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(r2);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(itemCount, r1);
        do {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
        } while (!findViewHolderForAdapterPosition.itemView.hasFocusable());
        return findViewHolderForAdapterPosition.itemView;
    }

    public static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(InstructionFileId.DOT)) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int r1 = 0; r1 < childCount; r1++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(r1));
            if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j) {
                Adapter adapter = this.mAdapter;
                if (adapter != null && adapter.hasStableIds()) {
                    StringBuilder sb = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                    sb.append(childViewHolderInt);
                    sb.append(" \n View Holder 2:");
                    sb.append(viewHolder);
                    throw new IllegalStateException(ChildHelper$$ExternalSyntheticOutline0.m(this, sb));
                }
                StringBuilder sb2 = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                sb2.append(childViewHolderInt);
                sb2.append(" \n View Holder 2:");
                sb2.append(viewHolder);
                throw new IllegalStateException(ChildHelper$$ExternalSyntheticOutline0.m(this, sb2));
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int childCount = this.mChildHelper.getChildCount();
        for (int r2 = 0; r2 < childCount; r2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(r2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        int r2;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 26) {
            r2 = ViewCompat.Api26Impl.getImportantForAutofill(this);
        } else {
            r2 = 0;
        }
        if (r2 == 0 && r0 >= 26) {
            ViewCompat.Api26Impl.setImportantForAutofill(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new AnonymousClass5());
    }

    private boolean isPreferredNextFocus(View view, View view2, int r12) {
        int r10;
        int r3;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c = 65535;
        if (this.mLayout.getLayoutDirection() == 1) {
            r10 = -1;
        } else {
            r10 = 1;
        }
        Rect rect = this.mTempRect;
        int r32 = rect.left;
        Rect rect2 = this.mTempRect2;
        int r5 = rect2.left;
        if ((r32 < r5 || rect.right <= r5) && rect.right < rect2.right) {
            r3 = 1;
        } else {
            int r6 = rect.right;
            int r7 = rect2.right;
            if ((r6 > r7 || r32 >= r7) && r32 > r5) {
                r3 = -1;
            } else {
                r3 = 0;
            }
        }
        int r52 = rect.top;
        int r62 = rect2.top;
        if ((r52 < r62 || rect.bottom <= r62) && rect.bottom < rect2.bottom) {
            c = 1;
        } else {
            int r2 = rect.bottom;
            int r4 = rect2.bottom;
            if ((r2 <= r4 && r52 < r4) || r52 <= r62) {
                c = 0;
            }
        }
        if (r12 != 1) {
            if (r12 != 2) {
                if (r12 != 17) {
                    if (r12 != 33) {
                        if (r12 != 66) {
                            if (r12 == 130) {
                                if (c <= 0) {
                                    return false;
                                }
                                return true;
                            }
                            StringBuilder sb = new StringBuilder("Invalid direction: ");
                            sb.append(r12);
                            throw new IllegalArgumentException(ChildHelper$$ExternalSyntheticOutline0.m(this, sb));
                        }
                        if (r3 <= 0) {
                            return false;
                        }
                        return true;
                    }
                    if (c >= 0) {
                        return false;
                    }
                    return true;
                }
                if (r3 >= 0) {
                    return false;
                }
                return true;
            }
            if (c <= 0 && (c != 0 || r3 * r10 <= 0)) {
                return false;
            }
            return true;
        }
        if (c >= 0 && (c != 0 || r3 * r10 >= 0)) {
            return false;
        }
        return true;
    }

    private void nestedScrollByInternal(int r12, int r13, MotionEvent motionEvent, int r15) {
        int r4;
        int r6;
        int r7;
        int r0;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        int[] r1 = this.mReusableIntPair;
        int r2 = 0;
        r1[0] = 0;
        r1[1] = 0;
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollVertically) {
            r4 = (canScrollHorizontally ? 1 : 0) | 2;
        } else {
            r4 = canScrollHorizontally ? 1 : 0;
        }
        startNestedScroll(r4, r15);
        if (canScrollHorizontally) {
            r6 = r12;
        } else {
            r6 = 0;
        }
        if (canScrollVertically) {
            r7 = r13;
        } else {
            r7 = 0;
        }
        if (dispatchNestedPreScroll(r6, r7, this.mReusableIntPair, this.mScrollOffset, r15)) {
            int[] r42 = this.mReusableIntPair;
            r12 -= r42[0];
            r13 -= r42[1];
        }
        if (canScrollHorizontally) {
            r0 = r12;
        } else {
            r0 = 0;
        }
        if (canScrollVertically) {
            r2 = r13;
        }
        scrollByInternal(r0, r2, motionEvent, r15);
        GapWorker gapWorker = this.mGapWorker;
        if (gapWorker != null && (r12 != 0 || r13 != 0)) {
            gapWorker.postFromTraversal(this, r12, r13);
        }
        stopNestedScroll(r15);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int r0;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            if (actionIndex == 0) {
                r0 = 1;
            } else {
                r0 = 0;
            }
            this.mScrollPointerId = motionEvent.getPointerId(r0);
            int x = (int) (motionEvent.getX(r0) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(r0) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations()) {
            return true;
        }
        return false;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.mDataSetHasChangedAfterLayout) {
            AdapterHelper adapterHelper = this.mAdapterHelper;
            adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPendingUpdates);
            adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPostponedList);
            adapterHelper.mExistingUpdateTypes = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.preProcess();
        } else {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        }
        if (!this.mItemsAddedOrRemoved && !this.mItemsChanged) {
            z = false;
        } else {
            z = true;
        }
        State state = this.mState;
        if (this.mFirstLayoutComplete && this.mItemAnimator != null && (((z3 = this.mDataSetHasChangedAfterLayout) || z || this.mLayout.mRequestedSimpleAnimations) && (!z3 || this.mAdapter.hasStableIds()))) {
            z2 = true;
        } else {
            z2 = false;
        }
        state.mRunSimpleAnimations = z2;
        State state2 = this.mState;
        if (state2.mRunSimpleAnimations && z && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z4 = true;
        }
        state2.mRunPredictiveAnimations = z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r1 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            androidx.core.widget.EdgeEffectCompat.Api21Impl.onPull(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r1 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.EdgeEffectCompat.Api21Impl.onPull(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.EdgeEffectCompat.Api21Impl.onPull(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.EdgeEffectCompat.Api21Impl.onPull(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L81
        L7c:
            java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r7 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
            androidx.core.view.ViewCompat.Api16Impl.postInvalidateOnAnimation(r6)
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        ViewHolder viewHolder;
        View findViewById;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                        if (this.mChildHelper.getChildCount() == 0) {
                            requestFocus();
                            return;
                        }
                    } else if (!this.mChildHelper.isHidden(focusedChild)) {
                        return;
                    }
                }
                View view = null;
                if (this.mState.mFocusedItemId != -1 && this.mAdapter.hasStableIds()) {
                    viewHolder = findViewHolderForItemId(this.mState.mFocusedItemId);
                } else {
                    viewHolder = null;
                }
                if (viewHolder != null && !this.mChildHelper.isHidden(viewHolder.itemView) && viewHolder.itemView.hasFocusable()) {
                    view = viewHolder.itemView;
                } else if (this.mChildHelper.getChildCount() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    int r0 = this.mState.mFocusedSubChildId;
                    if (r0 != -1 && (findViewById = view.findViewById(r0)) != null && findViewById.isFocusable()) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3;
        boolean z;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect = this.mTempRect;
                int r2 = rect.left;
                Rect rect2 = layoutParams2.mDecorInsets;
                rect.left = r2 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        LayoutManager layoutManager = this.mLayout;
        Rect rect3 = this.mTempRect;
        boolean z2 = !this.mFirstLayoutComplete;
        if (view2 == null) {
            z = true;
        } else {
            z = false;
        }
        layoutManager.requestChildRectangleOnScreen(this, view, rect3, z2, z);
    }

    private void resetFocusInfo() {
        State state = this.mState;
        state.mFocusedItemId = -1L;
        state.mFocusedItemPosition = -1;
        state.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        View view;
        long j;
        int absoluteAdapterPosition;
        ViewHolder viewHolder = null;
        if (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) {
            view = getFocusedChild();
        } else {
            view = null;
        }
        if (view != null) {
            viewHolder = findContainingViewHolder(view);
        }
        if (viewHolder == null) {
            resetFocusInfo();
            return;
        }
        State state = this.mState;
        if (this.mAdapter.hasStableIds()) {
            j = viewHolder.getItemId();
        } else {
            j = -1;
        }
        state.mFocusedItemId = j;
        State state2 = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            absoluteAdapterPosition = -1;
        } else if (viewHolder.isRemoved()) {
            absoluteAdapterPosition = viewHolder.mOldPosition;
        } else {
            absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        }
        state2.mFocusedItemPosition = absoluteAdapterPosition;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(viewHolder.itemView);
    }

    private void setAdapterInternal(Adapter adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        AdapterHelper adapterHelper = this.mAdapterHelper;
        adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPendingUpdates);
        adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPostponedList);
        int r0 = 0;
        adapterHelper.mExistingUpdateTypes = 0;
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.mAdapter);
        }
        Recycler recycler = this.mRecycler;
        Adapter adapter4 = this.mAdapter;
        recycler.mAttachedScrap.clear();
        recycler.recycleAndClearCachedViews();
        RecycledViewPool recycledViewPool = recycler.getRecycledViewPool();
        if (adapter3 != null) {
            recycledViewPool.mAttachCount--;
        }
        if (!z && recycledViewPool.mAttachCount == 0) {
            while (true) {
                SparseArray<RecycledViewPool.ScrapData> sparseArray = recycledViewPool.mScrap;
                if (r0 >= sparseArray.size()) {
                    break;
                }
                sparseArray.valueAt(r0).mScrapHeap.clear();
                r0++;
            }
        }
        if (adapter4 != null) {
            recycledViewPool.mAttachCount++;
        } else {
            recycledViewPool.getClass();
        }
        this.mState.mStructureChanged = true;
    }

    private void stopScrollersInternal() {
        ViewFlinger viewFlinger = this.mViewFlinger;
        RecyclerView.this.removeCallbacks(viewFlinger);
        viewFlinger.mOverScroller.abortAnimation();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    public void absorbGlows(int r3, int r4) {
        if (r3 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-r3);
            }
        } else if (r3 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(r3);
            }
        }
        if (r4 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-r4);
            }
        } else if (r4 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(r4);
            }
        }
        if (r3 != 0 || r4 != 0) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int r3, int r4) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, r3, r4)) {
            super.addFocusables(arrayList, r3, r4);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int r4) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (r4 < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(r4, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void addRecyclerListener(RecyclerListener recyclerListener) {
        boolean z;
        if (recyclerListener != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument("'listener' arg cannot be null.", z);
        this.mRecyclerListeners.add(recyclerListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void animateAppearance(androidx.recyclerview.widget.RecyclerView.ViewHolder r8, androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo r9, androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo r10) {
        /*
            r7 = this;
            r0 = 0
            r8.setIsRecyclable(r0)
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r0 = r7.mItemAnimator
            r1 = r0
            androidx.recyclerview.widget.SimpleItemAnimator r1 = (androidx.recyclerview.widget.SimpleItemAnimator) r1
            if (r9 == 0) goto L24
            r1.getClass()
            int r3 = r9.left
            int r5 = r10.left
            if (r3 != r5) goto L1a
            int r0 = r9.top
            int r2 = r10.top
            if (r0 == r2) goto L24
        L1a:
            int r4 = r9.top
            int r6 = r10.top
            r2 = r8
            boolean r8 = r1.animateMove(r2, r3, r4, r5, r6)
            goto L28
        L24:
            r1.animateAdd(r8)
            r8 = 1
        L28:
            if (r8 == 0) goto L2d
            r7.postAnimationRunner()
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.animateAppearance(androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo, androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo):void");
    }

    public void animateDisappearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int r0;
        int r10;
        boolean z;
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) this.mItemAnimator;
        simpleItemAnimator.getClass();
        int r3 = itemHolderInfo.left;
        int r4 = itemHolderInfo.top;
        View view = viewHolder.itemView;
        if (itemHolderInfo2 == null) {
            r0 = view.getLeft();
        } else {
            r0 = itemHolderInfo2.left;
        }
        int r5 = r0;
        if (itemHolderInfo2 == null) {
            r10 = view.getTop();
        } else {
            r10 = itemHolderInfo2.top;
        }
        int r6 = r10;
        if (!viewHolder.isRemoved() && (r3 != r5 || r4 != r6)) {
            view.layout(r5, r6, view.getWidth() + r5, view.getHeight() + r6);
            z = simpleItemAnimator.animateMove(viewHolder, r3, r4, r5, r6);
        } else {
            simpleItemAnimator.animateRemove(viewHolder);
            z = true;
        }
        if (z) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException(ChildHelper$$ExternalSyntheticOutline0.m(this, new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(ChildHelper$$ExternalSyntheticOutline0.m(this, FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str)));
        }
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException(ChildHelper$$ExternalSyntheticOutline0.m(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(ChildHelper$$ExternalSyntheticOutline0.m(this, new StringBuilder(""))));
        }
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null && !itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads())) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams)) {
            return true;
        }
        return false;
    }

    public void clearOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int r2 = 0; r2 < unfilteredChildCount; r2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        Recycler recycler = this.mRecycler;
        ArrayList<ViewHolder> arrayList = recycler.mCachedViews;
        int size = arrayList.size();
        for (int r4 = 0; r4 < size; r4++) {
            arrayList.get(r4).clearOldPosition();
        }
        ArrayList<ViewHolder> arrayList2 = recycler.mAttachedScrap;
        int size2 = arrayList2.size();
        for (int r42 = 0; r42 < size2; r42++) {
            arrayList2.get(r42).clearOldPosition();
        }
        ArrayList<ViewHolder> arrayList3 = recycler.mChangedScrap;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int r1 = 0; r1 < size3; r1++) {
                recycler.mChangedScrap.get(r1).clearOldPosition();
            }
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollExtent(this.mState);
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollOffset(this.mState);
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollRange(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollExtent(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollOffset(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollRange(this.mState);
    }

    public void considerReleasingGlowsOnScroll(int r3, int r4) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null && !edgeEffect.isFinished() && r3 > 0) {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && r3 < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && r4 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && r4 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
        }
    }

    public void consumePendingUpdateOperations() {
        boolean z;
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout) {
            if (!this.mAdapterHelper.hasPendingUpdates()) {
                return;
            }
            AdapterHelper adapterHelper = this.mAdapterHelper;
            int r2 = adapterHelper.mExistingUpdateTypes;
            boolean z2 = false;
            if ((4 & r2) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if ((r2 & 11) != 0) {
                    z2 = true;
                }
                if (!z2) {
                    int r0 = TraceCompat.$r8$clinit;
                    TraceCompat.Api18Impl.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                    startInterceptRequestLayout();
                    onEnterLayoutOrScroll();
                    this.mAdapterHelper.preProcess();
                    if (!this.mLayoutWasDefered) {
                        if (hasUpdatedView()) {
                            dispatchLayout();
                        } else {
                            this.mAdapterHelper.consumePostponedUpdates();
                        }
                    }
                    stopInterceptRequestLayout(true);
                    onExitLayoutOrScroll();
                    TraceCompat.Api18Impl.endSection();
                    return;
                }
            }
            if (adapterHelper.hasPendingUpdates()) {
                int r02 = TraceCompat.$r8$clinit;
                TraceCompat.Api18Impl.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                TraceCompat.Api18Impl.endSection();
                return;
            }
            return;
        }
        int r03 = TraceCompat.$r8$clinit;
        TraceCompat.Api18Impl.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.Api18Impl.endSection();
    }

    public void defaultOnMeasure(int r3, int r4) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        setMeasuredDimension(LayoutManager.chooseSize(r3, paddingRight, ViewCompat.Api16Impl.getMinimumWidth(this)), LayoutManager.chooseSize(r4, getPaddingBottom() + getPaddingTop(), ViewCompat.Api16Impl.getMinimumHeight(this)));
    }

    public void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            int size = list.size();
            while (true) {
                size--;
                if (size >= 0) {
                    this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow();
                } else {
                    return;
                }
            }
        }
    }

    public void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    public void dispatchLayout() {
        boolean z;
        if (this.mAdapter == null) {
            Log.w(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        boolean z2 = false;
        this.mState.mIsMeasuring = false;
        if (this.mLastAutoMeasureSkippedDueToExact && (this.mLastAutoMeasureNonExactMeasuredWidth != getWidth() || this.mLastAutoMeasureNonExactMeasuredHeight != getHeight())) {
            z = true;
        } else {
            z = false;
        }
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.mLayoutStep == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else {
            AdapterHelper adapterHelper = this.mAdapterHelper;
            if (!adapterHelper.mPostponedList.isEmpty() && !adapterHelper.mPendingUpdates.isEmpty()) {
                z2 = true;
            }
            if (!z2 && !z && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
            } else {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            }
        }
        dispatchLayoutStep3();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13) {
        return getScrollingChildHelper().dispatchNestedScrollInternal(r9, r10, r11, r12, r13, 0, null);
    }

    public void dispatchOnScrollStateChanged(int r3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(r3);
        }
        onScrollStateChanged(r3);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, r3);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, r3);
            }
        }
    }

    public void dispatchOnScrolled(int r5, int r6) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - r5, scrollY - r6);
        onScrolled(r5, r6);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, r5, r6);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, r5, r6);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int r2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (r2 = viewHolder.mPendingAccessibilityState) != -1) {
                View view = viewHolder.itemView;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.setImportantForAccessibility(view, r2);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        int r5;
        boolean z2;
        boolean z3;
        int r3;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z4 = false;
        for (int r2 = 0; r2 < size; r2++) {
            this.mItemDecorations.get(r2).onDrawOver(canvas, this);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z5 = true;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            if (this.mClipToPadding) {
                r3 = getPaddingBottom();
            } else {
                r3 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + r3, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            if (edgeEffect2 != null && edgeEffect2.draw(canvas)) {
                z = true;
            } else {
                z = false;
            }
            canvas.restoreToCount(save);
        } else {
            z = false;
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            if (edgeEffect4 != null && edgeEffect4.draw(canvas)) {
                z3 = true;
            } else {
                z3 = false;
            }
            z |= z3;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.mClipToPadding) {
                r5 = getPaddingTop();
            } else {
                r5 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(r5, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            if (edgeEffect6 != null && edgeEffect6.draw(canvas)) {
                z2 = true;
            } else {
                z2 = false;
            }
            z |= z2;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z |= z4;
            canvas.restoreToCount(save4);
        }
        if (z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
            z5 = z;
        }
        if (z5) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mBottomGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mLeftGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mRightGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mTopGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            overScroller.getFinalX();
            overScroller.getCurrX();
            state.getClass();
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        state.getClass();
    }

    public View findChildViewUnder(float f, float f2) {
        for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mChildHelper.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f >= childAt.getLeft() + translationX && f <= childAt.getRight() + translationX && f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public ViewHolder findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public ViewHolder findViewHolderForAdapterPosition(int r6) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int r2 = 0; r2 < unfilteredChildCount; r2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == r6) {
                if (this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    viewHolder = childViewHolderInt;
                } else {
                    return childViewHolderInt;
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int r2 = 0; r2 < unfilteredChildCount; r2++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                    if (this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                        viewHolder = childViewHolderInt;
                    } else {
                        return childViewHolderInt;
                    }
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForLayoutPosition(int r2) {
        return findViewHolderForPosition(r2, false);
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int r2) {
        return findViewHolderForPosition(r2, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0152, code lost:            if (r0 < r13) goto L259;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean fling(int r20, int r21) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int r10) {
        boolean z;
        View view2;
        boolean z2;
        boolean z3;
        boolean z4;
        int r0;
        int r02;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, r10);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z5 = true;
        if (this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed) {
            z = true;
        } else {
            z = false;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z && (r10 == 2 || r10 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                if (r10 == 2) {
                    r02 = com.animaconnected.secondo.R.styleable.AppTheme_statusTopStripeSetup;
                } else {
                    r02 = 33;
                }
                if (focusFinder.findNextFocus(this, view, r02) == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    r10 = r02;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.mLayout.canScrollHorizontally()) {
                if (this.mLayout.getLayoutDirection() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (r10 == 2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z3 ^ z4) {
                    r0 = 66;
                } else {
                    r0 = 17;
                }
                if (focusFinder.findNextFocus(this, view, r0) != null) {
                    z5 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    r10 = r0;
                }
                z2 = z5;
            }
            if (z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, r10, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = focusFinder.findNextFocus(this, view, r10);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, r10);
            if (findNextFocus == null && z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, r10, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 != null && !view2.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, r10);
            }
            requestChildOnScreen(view2, null);
            return view;
        }
        if (!isPreferredNextFocus(view, view2, r10)) {
            return super.focusSearch(view, r10);
        }
        return view2;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException(ChildHelper$$ExternalSyntheticOutline0.m(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException(ChildHelper$$ExternalSyntheticOutline0.m(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        AdapterHelper adapterHelper = this.mAdapterHelper;
        int r8 = viewHolder.mPosition;
        ArrayList<AdapterHelper.UpdateOp> arrayList = adapterHelper.mPendingUpdates;
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            AdapterHelper.UpdateOp updateOp = arrayList.get(r3);
            int r5 = updateOp.cmd;
            if (r5 != 1) {
                if (r5 != 2) {
                    if (r5 == 8) {
                        int r52 = updateOp.positionStart;
                        if (r52 == r8) {
                            r8 = updateOp.itemCount;
                        } else {
                            if (r52 < r8) {
                                r8--;
                            }
                            if (updateOp.itemCount <= r8) {
                                r8++;
                            }
                        }
                    }
                } else {
                    int r53 = updateOp.positionStart;
                    if (r53 <= r8) {
                        int r4 = updateOp.itemCount;
                        if (r53 + r4 > r8) {
                            return -1;
                        }
                        r8 -= r4;
                    } else {
                        continue;
                    }
                }
            } else if (updateOp.positionStart <= r8) {
                r8 += updateOp.itemCount;
            }
        }
        return r8;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public long getChangedHolderKey(ViewHolder viewHolder) {
        if (this.mAdapter.hasStableIds()) {
            return viewHolder.getItemId();
        }
        return viewHolder.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r1, int r2) {
        return super.getChildDrawingOrder(r1, r2);
    }

    public long getChildItemId(View view) {
        ViewHolder childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        boolean z = layoutParams.mInsetsDirty;
        Rect rect = layoutParams.mDecorInsets;
        if (!z) {
            return rect;
        }
        if (this.mState.mInPreLayout && (layoutParams.isItemChanged() || layoutParams.mViewHolder.isInvalid())) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int r4 = 0; r4 < size; r4++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(r4).getItemOffsets(this.mTempRect, view);
            int r5 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = r5 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    public ItemDecoration getItemDecorationAt(int r4) {
        int itemDecorationCount = getItemDecorationCount();
        if (r4 >= 0 && r4 < itemDecorationCount) {
            return this.mItemDecorations.get(r4);
        }
        throw new IndexOutOfBoundsException(r4 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().getNestedScrollingParentForType(0) != null;
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout && !this.mAdapterHelper.hasPendingUpdates()) {
            return false;
        }
        return true;
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AnonymousClass6());
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.kronaby.watch.app.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.kronaby.watch.app.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.kronaby.watch.app.R.dimen.fastscroll_margin));
            return;
        }
        throw new IllegalArgumentException(ChildHelper$$ExternalSyntheticOutline0.m(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            return true;
        }
        return false;
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null && itemAnimator.isRunning()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter > 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().mIsNestedScrollingEnabled;
    }

    public void jumpToPositionForSmoothScroller(int r2) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(r2);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int r2 = 0; r2 < unfilteredChildCount; r2++) {
            ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(r2).getLayoutParams()).mInsetsDirty = true;
        }
        ArrayList<ViewHolder> arrayList = this.mRecycler.mCachedViews;
        int size = arrayList.size();
        for (int r1 = 0; r1 < size; r1++) {
            LayoutParams layoutParams = (LayoutParams) arrayList.get(r1).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.mInsetsDirty = true;
            }
        }
    }

    public void markKnownViewsInvalid() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int r2 = 0; r2 < unfilteredChildCount; r2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        Recycler recycler = this.mRecycler;
        ArrayList<ViewHolder> arrayList = recycler.mCachedViews;
        int size = arrayList.size();
        for (int r1 = 0; r1 < size; r1++) {
            ViewHolder viewHolder = arrayList.get(r1);
            if (viewHolder != null) {
                viewHolder.addFlags(6);
                viewHolder.addChangePayload(null);
            }
        }
        Adapter adapter = RecyclerView.this.mAdapter;
        if (adapter == null || !adapter.hasStableIds()) {
            recycler.recycleAndClearCachedViews();
        }
    }

    public void nestedScrollBy(int r3, int r4) {
        nestedScrollByInternal(r3, r4, null, 1);
    }

    public void offsetChildrenHorizontal(int r4) {
        int childCount = this.mChildHelper.getChildCount();
        for (int r1 = 0; r1 < childCount; r1++) {
            this.mChildHelper.getChildAt(r1).offsetLeftAndRight(r4);
        }
    }

    public void offsetChildrenVertical(int r4) {
        int childCount = this.mChildHelper.getChildCount();
        for (int r1 = 0; r1 < childCount; r1++) {
            this.mChildHelper.getChildAt(r1).offsetTopAndBottom(r4);
        }
    }

    public void offsetPositionRecordsForInsert(int r7, int r8) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int r2 = 0; r2 < unfilteredChildCount; r2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= r7) {
                childViewHolderInt.offsetPosition(r8, false);
                this.mState.mStructureChanged = true;
            }
        }
        ArrayList<ViewHolder> arrayList = this.mRecycler.mCachedViews;
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            ViewHolder viewHolder = arrayList.get(r3);
            if (viewHolder != null && viewHolder.mPosition >= r7) {
                viewHolder.offsetPosition(r8, false);
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int r11, int r12) {
        int r4;
        int r3;
        int r5;
        int r32;
        int r2;
        int r8;
        int r9;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        int r1 = -1;
        if (r11 < r12) {
            r3 = r11;
            r4 = r12;
            r5 = -1;
        } else {
            r4 = r11;
            r3 = r12;
            r5 = 1;
        }
        for (int r7 = 0; r7 < unfilteredChildCount; r7++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r7));
            if (childViewHolderInt != null && (r9 = childViewHolderInt.mPosition) >= r3 && r9 <= r4) {
                if (r9 == r11) {
                    childViewHolderInt.offsetPosition(r12 - r11, false);
                } else {
                    childViewHolderInt.offsetPosition(r5, false);
                }
                this.mState.mStructureChanged = true;
            }
        }
        Recycler recycler = this.mRecycler;
        recycler.getClass();
        if (r11 < r12) {
            r2 = r11;
            r32 = r12;
        } else {
            r32 = r11;
            r1 = 1;
            r2 = r12;
        }
        ArrayList<ViewHolder> arrayList = recycler.mCachedViews;
        int size = arrayList.size();
        for (int r52 = 0; r52 < size; r52++) {
            ViewHolder viewHolder = arrayList.get(r52);
            if (viewHolder != null && (r8 = viewHolder.mPosition) >= r2 && r8 <= r32) {
                if (r8 == r11) {
                    viewHolder.offsetPosition(r12 - r11, false);
                } else {
                    viewHolder.offsetPosition(r1, false);
                }
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int r8, int r9, boolean z) {
        int r0 = r8 + r9;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int r2 = 0; r2 < unfilteredChildCount; r2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int r4 = childViewHolderInt.mPosition;
                if (r4 >= r0) {
                    childViewHolderInt.offsetPosition(-r9, z);
                    this.mState.mStructureChanged = true;
                } else if (r4 >= r8) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(r8 - 1, -r9, z);
                    this.mState.mStructureChanged = true;
                }
            }
        }
        Recycler recycler = this.mRecycler;
        ArrayList<ViewHolder> arrayList = recycler.mCachedViews;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                ViewHolder viewHolder = arrayList.get(size);
                if (viewHolder != null) {
                    int r5 = viewHolder.mPosition;
                    if (r5 >= r0) {
                        viewHolder.offsetPosition(-r9, z);
                    } else if (r5 >= r8) {
                        viewHolder.addFlags(8);
                        recycler.recycleCachedViewAt(size);
                    }
                }
            } else {
                requestLayout();
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:            if (r1 >= 30.0f) goto L48;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.mLayoutOrScrollCounter = r0
            r1 = 1
            r5.mIsAttached = r1
            boolean r2 = r5.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r5.mLayout
            if (r1 == 0) goto L1e
            r1.dispatchAttachedToWindow(r5)
        L1e:
            r5.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L65
            java.lang.ThreadLocal<androidx.recyclerview.widget.GapWorker> r0 = androidx.recyclerview.widget.GapWorker.sGapWorker
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.GapWorker r1 = (androidx.recyclerview.widget.GapWorker) r1
            r5.mGapWorker = r1
            if (r1 != 0) goto L5e
            androidx.recyclerview.widget.GapWorker r1 = new androidx.recyclerview.widget.GapWorker
            r1.<init>()
            r5.mGapWorker = r1
            java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r1 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
            android.view.Display r1 = androidx.core.view.ViewCompat.Api17Impl.getDisplay(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L50
            if (r1 == 0) goto L50
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L50
            goto L52
        L50:
            r1 = 1114636288(0x42700000, float:60.0)
        L52:
            androidx.recyclerview.widget.GapWorker r2 = r5.mGapWorker
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.mFrameIntervalNs = r3
            r0.set(r2)
        L5e:
            androidx.recyclerview.widget.GapWorker r0 = r5.mGapWorker
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView> r0 = r0.mRecyclerViews
            r0.add(r5)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.getClass();
        do {
        } while (ViewInfoStore.InfoRecord.sPool.acquire() != null);
        if (ALLOW_THREAD_GAP_WORK && (gapWorker = this.mGapWorker) != null) {
            gapWorker.mRecyclerViews.remove(this);
            this.mGapWorker = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int r1 = 0; r1 < size; r1++) {
            this.mItemDecorations.get(r1).onDraw(canvas, this);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L78
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L78
        L6c:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r3 = 1
            r5.nestedScrollByInternal(r2, r0, r6, r3)
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                onPointerUp(motionEvent);
                            }
                        } else {
                            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.mLastTouchX = x;
                            this.mInitialTouchX = x;
                            int y = (int) (motionEvent.getY(actionIndex) + 0.5f);
                            this.mLastTouchY = y;
                            this.mInitialTouchY = y;
                        }
                    } else {
                        cancelScroll();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (findPointerIndex < 0) {
                        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        int r4 = x2 - this.mInitialTouchX;
                        int r6 = y2 - this.mInitialTouchY;
                        if (canScrollHorizontally != 0 && Math.abs(r4) > this.mTouchSlop) {
                            this.mLastTouchX = x2;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (canScrollVertically && Math.abs(r6) > this.mTouchSlop) {
                            this.mLastTouchY = y2;
                            z = true;
                        }
                        if (z) {
                            setScrollState(1);
                        }
                    }
                }
            } else {
                this.mVelocityTracker.clear();
                stopNestedScroll(0);
            }
        } else {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x3 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] r9 = this.mNestedOffsets;
            r9[1] = 0;
            r9[0] = 0;
            int r0 = canScrollHorizontally;
            if (canScrollVertically) {
                r0 = (canScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(r0, 0);
        }
        if (this.mScrollState != 1) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int r2, int r3, int r4, int r5) {
        int r1 = TraceCompat.$r8$clinit;
        TraceCompat.Api18Impl.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.Api18Impl.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int r8, int r9) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(r8, r9);
            return;
        }
        boolean z = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(r8);
            int mode2 = View.MeasureSpec.getMode(r9);
            this.mLayout.onMeasure(this.mRecycler, this.mState, r8, r9);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z;
            if (!z && this.mAdapter != null) {
                if (this.mState.mLayoutStep == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(r8, r9);
                this.mState.mIsMeasuring = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(r8, r9);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.mIsMeasuring = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(r8, r9);
                }
                this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
                this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, r8, r9);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            State state = this.mState;
            if (state.mRunPredictiveAnimations) {
                state.mInPreLayout = true;
            } else {
                this.mAdapterHelper.consumeUpdatesInOnePass();
                this.mState.mInPreLayout = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.mRunPredictiveAnimations) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            this.mState.mItemCount = adapter.getItemCount();
        } else {
            this.mState.mItemCount = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, r8, r9);
        stopInterceptRequestLayout(false);
        this.mState.mInPreLayout = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(r2, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.mSuperState);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.mLayoutState = savedState2.mLayoutState;
        } else {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                savedState.mLayoutState = layoutManager.onSaveInstanceState();
            } else {
                savedState.mLayoutState = null;
            }
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 != r3 || r2 != r4) {
            invalidateGlows();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            Runnable runnable = this.mItemAnimatorRunner;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postOnAnimation(this, runnable);
            this.mPostedAnimatorRunner = true;
        }
    }

    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, DfuBaseService.ERROR_REMOTE_MASK);
        if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.mOldChangedHolders.put(getChangedHolderKey(viewHolder), viewHolder);
        }
        SimpleArrayMap<ViewHolder, ViewInfoStore.InfoRecord> simpleArrayMap = this.mViewInfoStore.mLayoutHolderMap;
        ViewInfoStore.InfoRecord orDefault = simpleArrayMap.getOrDefault(viewHolder, null);
        if (orDefault == null) {
            orDefault = ViewInfoStore.InfoRecord.obtain();
            simpleArrayMap.put(viewHolder, orDefault);
        }
        orDefault.preInfo = itemHolderInfo;
        orDefault.flags |= 4;
    }

    public void removeAndRecycleViews() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        Recycler recycler = this.mRecycler;
        recycler.mAttachedScrap.clear();
        recycler.recycleAndClearCachedViews();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean removeAnimatingView(android.view.View r6) {
        /*
            r5 = this;
            r5.startInterceptRequestLayout()
            androidx.recyclerview.widget.ChildHelper r0 = r5.mChildHelper
            androidx.recyclerview.widget.ChildHelper$Callback r1 = r0.mCallback
            androidx.recyclerview.widget.RecyclerView$5 r1 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass5) r1
            androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
            int r2 = r2.indexOfChild(r6)
            r3 = -1
            if (r2 != r3) goto L16
            r0.unhideViewInternal(r6)
            goto L27
        L16:
            androidx.recyclerview.widget.ChildHelper$Bucket r3 = r0.mBucket
            boolean r4 = r3.get(r2)
            if (r4 == 0) goto L29
            r3.remove(r2)
            r0.unhideViewInternal(r6)
            r1.removeViewAt(r2)
        L27:
            r0 = 1
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 == 0) goto L3a
            androidx.recyclerview.widget.RecyclerView$ViewHolder r6 = getChildViewHolderInt(r6)
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r5.mRecycler
            r1.unscrapView(r6)
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r5.mRecycler
            r1.recycleViewHolderInternal(r6)
        L3a:
            r6 = r0 ^ 1
            r5.stopInterceptRequestLayout(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.removeAnimatingView(android.view.View):boolean");
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(ChildHelper$$ExternalSyntheticOutline0.m(this, sb));
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        boolean z;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            if (getOverScrollMode() == 2) {
                z = true;
            } else {
                z = false;
            }
            setWillNotDraw(z);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int r4) {
        int itemDecorationCount = getItemDecorationCount();
        if (r4 >= 0 && r4 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(r4));
            return;
        }
        throw new IndexOutOfBoundsException(r4 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(onChildAttachStateChangeListener);
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void removeRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListeners.remove(recyclerListener);
    }

    public void repositionShadowingViews() {
        ViewHolder viewHolder;
        int childCount = this.mChildHelper.getChildCount();
        for (int r1 = 0; r1 < childCount; r1++) {
            View childAt = this.mChildHelper.getChildAt(r1);
            ViewHolder childViewHolder = getChildViewHolder(childAt);
            if (childViewHolder != null && (viewHolder = childViewHolder.mShadowingHolder) != null) {
                View view = viewHolder.itemView;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int r1 = 0; r1 < size; r1++) {
            this.mOnItemTouchListeners.get(r1).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    public void saveOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int r1 = 0; r1 < unfilteredChildCount; r1++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r1));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int r4, int r5) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollHorizontally || canScrollVertically) {
            if (!canScrollHorizontally) {
                r4 = 0;
            }
            if (!canScrollVertically) {
                r5 = 0;
            }
            scrollByInternal(r4, r5, null, 0);
        }
    }

    public boolean scrollByInternal(int r18, int r19, MotionEvent motionEvent, int r21) {
        int r13;
        int r14;
        int r15;
        int r16;
        boolean z;
        boolean z2;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] r0 = this.mReusableIntPair;
            r0[0] = 0;
            r0[1] = 0;
            scrollStep(r18, r19, r0);
            int[] r02 = this.mReusableIntPair;
            int r1 = r02[0];
            int r03 = r02[1];
            r13 = r03;
            r14 = r1;
            r15 = r18 - r1;
            r16 = r19 - r03;
        } else {
            r13 = 0;
            r14 = 0;
            r15 = 0;
            r16 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] r7 = this.mReusableIntPair;
        r7[0] = 0;
        r7[1] = 0;
        dispatchNestedScroll(r14, r13, r15, r16, this.mScrollOffset, r21, r7);
        int[] r04 = this.mReusableIntPair;
        int r12 = r04[0];
        int r152 = r15 - r12;
        int r05 = r04[1];
        int r2 = r16 - r05;
        if (r12 == 0 && r05 == 0) {
            z = false;
        } else {
            z = true;
        }
        int r17 = this.mLastTouchX;
        int[] r3 = this.mScrollOffset;
        int r4 = r3[0];
        this.mLastTouchX = r17 - r4;
        int r110 = this.mLastTouchY;
        int r32 = r3[1];
        this.mLastTouchY = r110 - r32;
        int[] r111 = this.mNestedOffsets;
        r111[0] = r111[0] + r4;
        r111[1] = r111[1] + r32;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                if ((motionEvent.getSource() & 8194) == 8194) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    pullGlows(motionEvent.getX(), r152, motionEvent.getY(), r2);
                }
            }
            considerReleasingGlowsOnScroll(r18, r19);
        }
        if (r14 != 0 || r13 != 0) {
            dispatchOnScrolled(r14, r13);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (z || r14 != 0 || r13 != 0) {
            return true;
        }
        return false;
    }

    public void scrollStep(int r5, int r6, int[] r7) {
        int r52;
        int r62;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        int r0 = TraceCompat.$r8$clinit;
        TraceCompat.Api18Impl.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (r5 != 0) {
            r52 = this.mLayout.scrollHorizontallyBy(r5, this.mRecycler, this.mState);
        } else {
            r52 = 0;
        }
        if (r6 != 0) {
            r62 = this.mLayout.scrollVerticallyBy(r6, this.mRecycler, this.mState);
        } else {
            r62 = 0;
        }
        TraceCompat.Api18Impl.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (r7 != null) {
            r7[0] = r52;
            r7[1] = r62;
        }
    }

    @Override // android.view.View
    public void scrollTo(int r1, int r2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int r2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.scrollToPosition(r2);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        boolean z;
        if (childDrawingOrderCallback == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = childDrawingOrderCallback;
        if (childDrawingOrderCallback != null) {
            z = true;
        } else {
            z = false;
        }
        setChildrenDrawingOrderEnabled(z);
    }

    public boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int r3) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = r3;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        View view = viewHolder.itemView;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.setImportantForAccessibility(view, r3);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        edgeEffectFactory.getClass();
        this.mEdgeEffectFactory = edgeEffectFactory;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.mItemAnimator.mListener = null;
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.mListener = this.mItemAnimatorListener;
        }
    }

    public void setItemViewCacheSize(int r2) {
        Recycler recycler = this.mRecycler;
        recycler.mRequestedCacheMax = r2;
        recycler.updateViewCacheSize();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        ChildHelper.Callback callback;
        RecyclerView recyclerView;
        if (layoutManager == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            ItemAnimator itemAnimator = this.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            Recycler recycler = this.mRecycler;
            recycler.mAttachedScrap.clear();
            recycler.recycleAndClearCachedViews();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            Recycler recycler2 = this.mRecycler;
            recycler2.mAttachedScrap.clear();
            recycler2.recycleAndClearCachedViews();
        }
        ChildHelper childHelper = this.mChildHelper;
        childHelper.mBucket.reset();
        ArrayList arrayList = childHelper.mHiddenViews;
        int size = arrayList.size();
        while (true) {
            size--;
            callback = childHelper.mCallback;
            if (size < 0) {
                break;
            }
            View view = (View) arrayList.get(size);
            AnonymousClass5 anonymousClass5 = (AnonymousClass5) callback;
            anonymousClass5.getClass();
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
            arrayList.remove(size);
        }
        AnonymousClass5 anonymousClass52 = (AnonymousClass5) callback;
        int childCount = anonymousClass52.getChildCount();
        int r1 = 0;
        while (true) {
            recyclerView = RecyclerView.this;
            if (r1 >= childCount) {
                break;
            }
            View childAt = recyclerView.getChildAt(r1);
            recyclerView.dispatchChildDetached(childAt);
            childAt.clearAnimation();
            r1++;
        }
        recyclerView.removeAllViews();
        this.mLayout = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.mRecyclerView == null) {
                layoutManager.setRecyclerView(this);
                if (this.mIsAttached) {
                    this.mLayout.dispatchAttachedToWindow(this);
                }
            } else {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(layoutManager);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(ChildHelper$$ExternalSyntheticOutline0.m(layoutManager.mRecyclerView, sb));
            }
        }
        this.mRecycler.updateViewCacheSize();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.mIsNestedScrollingEnabled) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.stopNestedScroll(scrollingChildHelper.mView);
        }
        scrollingChildHelper.mIsNestedScrollingEnabled = z;
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        Recycler recycler = this.mRecycler;
        if (recycler.mRecyclerPool != null) {
            r1.mAttachCount--;
        }
        recycler.mRecyclerPool = recycledViewPool;
        if (recycledViewPool != null && RecyclerView.this.getAdapter() != null) {
            recycler.mRecyclerPool.mAttachCount++;
        }
    }

    @Deprecated
    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    void setScrollState(int r2) {
        if (r2 == this.mScrollState) {
            return;
        }
        this.mScrollState = r2;
        if (r2 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(r2);
    }

    public void setScrollingTouchSlop(int r4) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (r4 != 0) {
            if (r4 != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + r4 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.mRecycler.getClass();
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int r3;
        int r1 = 0;
        if (!isComputingLayout()) {
            return false;
        }
        if (accessibilityEvent != null) {
            r3 = AccessibilityEventCompat$Api19Impl.getContentChangeTypes(accessibilityEvent);
        } else {
            r3 = 0;
        }
        if (r3 != 0) {
            r1 = r3;
        }
        this.mEatenAccessibilityChangeFlags |= r1;
        return true;
    }

    public void smoothScrollBy(int r2, int r3) {
        smoothScrollBy(r2, r3, null);
    }

    public void smoothScrollToPosition(int r3) {
        if (this.mLayoutSuppressed) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.smoothScrollToPosition(this, this.mState, r3);
        }
    }

    public void startInterceptRequestLayout() {
        int r0 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = r0;
        if (r0 == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    @Override // android.view.View
    public boolean startNestedScroll(int r3) {
        return getScrollingChildHelper().startNestedScroll(r3, 0);
    }

    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll(0);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int r7, int r8, Object obj) {
        int r4;
        int r5;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        int r82 = r8 + r7;
        for (int r1 = 0; r1 < unfilteredChildCount; r1++) {
            View unfilteredChildAt = this.mChildHelper.getUnfilteredChildAt(r1);
            ViewHolder childViewHolderInt = getChildViewHolderInt(unfilteredChildAt);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (r5 = childViewHolderInt.mPosition) >= r7 && r5 < r82) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) unfilteredChildAt.getLayoutParams()).mInsetsDirty = true;
            }
        }
        Recycler recycler = this.mRecycler;
        ArrayList<ViewHolder> arrayList = recycler.mCachedViews;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                ViewHolder viewHolder = arrayList.get(size);
                if (viewHolder != null && (r4 = viewHolder.mPosition) >= r7 && r4 < r82) {
                    viewHolder.addFlags(2);
                    recycler.recycleCachedViewAt(size);
                }
            } else {
                return;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Adapter<VH extends ViewHolder> {
        private final AdapterDataObservable mObservable = new AdapterDataObservable();
        private boolean mHasStableIds = false;
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        /* loaded from: classes.dex */
        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bindViewHolder(VH vh, int r6) {
            boolean z;
            if (vh.mBindingAdapter == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                vh.mPosition = r6;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(r6);
                }
                vh.setFlags(1, 519);
                int r2 = TraceCompat.$r8$clinit;
                TraceCompat.Api18Impl.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, r6, vh.getUnmodifiedPayloads());
            if (z) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).mInsetsDirty = true;
                }
                int r5 = TraceCompat.$r8$clinit;
                TraceCompat.Api18Impl.endSection();
            }
        }

        public boolean canRestoreState() {
            int r0 = AnonymousClass7.$SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[this.mStateRestorationPolicy.ordinal()];
            if (r0 == 1) {
                return false;
            }
            if (r0 == 2 && getItemCount() <= 0) {
                return false;
            }
            return true;
        }

        public final VH createViewHolder(ViewGroup viewGroup, int r4) {
            try {
                int r1 = TraceCompat.$r8$clinit;
                TraceCompat.Api18Impl.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, r4);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = r4;
                    TraceCompat.Api18Impl.endSection();
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } catch (Throwable th) {
                int r42 = TraceCompat.$r8$clinit;
                TraceCompat.Api18Impl.endSection();
                throw th;
            }
        }

        public int findRelativeAdapterPositionIn(Adapter<? extends ViewHolder> adapter, ViewHolder viewHolder, int r3) {
            if (adapter == this) {
                return r3;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int r3) {
            return -1L;
        }

        public int getItemViewType(int r1) {
            return 0;
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int r4) {
            this.mObservable.notifyItemRangeChanged(r4, 1, null);
        }

        public final void notifyItemInserted(int r3) {
            this.mObservable.notifyItemRangeInserted(r3, 1);
        }

        public final void notifyItemMoved(int r2, int r3) {
            this.mObservable.notifyItemMoved(r2, r3);
        }

        public final void notifyItemRangeChanged(int r3, int r4) {
            this.mObservable.notifyItemRangeChanged(r3, r4, null);
        }

        public final void notifyItemRangeInserted(int r2, int r3) {
            this.mObservable.notifyItemRangeInserted(r2, r3);
        }

        public final void notifyItemRangeRemoved(int r2, int r3) {
            this.mObservable.notifyItemRangeRemoved(r2, r3);
        }

        public final void notifyItemRemoved(int r3) {
            this.mObservable.notifyItemRangeRemoved(r3, 1);
        }

        public abstract void onBindViewHolder(VH vh, int r2);

        public void onBindViewHolder(VH vh, int r2, List<Object> list) {
            onBindViewHolder(vh, r2);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int r2);

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.notifyStateRestorationPolicyChanged();
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int r3, Object obj) {
            this.mObservable.notifyItemRangeChanged(r3, 1, obj);
        }

        public final void notifyItemRangeChanged(int r2, int r3, Object obj) {
            this.mObservable.notifyItemRangeChanged(r2, r3, obj);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.kronaby.watch.app.R.attr.recyclerViewStyle);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.recyclerview.widget.RecyclerView.ViewHolder findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.ChildHelper r0 = r5.mChildHelper
            int r0 = r0.getUnfilteredChildCount()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.ChildHelper r3 = r5.mChildHelper
            android.view.View r3 = r3.getUnfilteredChildAt(r2)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.ChildHelper r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.isHidden(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$ViewHolder");
    }

    public void onExitLayoutOrScroll(boolean z) {
        int r0 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = r0;
        if (r0 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int r2, int r3, Interpolator interpolator) {
        smoothScrollBy(r2, r3, interpolator, Integer.MIN_VALUE);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int r18) {
        super(context, attributeSet, r18);
        float legacyScrollFactor;
        float legacyScrollFactor2;
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.mIsAttached) {
                        recyclerView.requestLayout();
                    } else if (recyclerView.mLayoutSuppressed) {
                        recyclerView.mLayoutWasDefered = true;
                    } else {
                        recyclerView.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView recyclerView = RecyclerView.this;
                ItemAnimator itemAnimator = recyclerView.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.runPendingAnimations();
                }
                recyclerView.mPostedAnimatorRunner = false;
            }
        };
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new AnonymousClass4();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 26) {
            Method method = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
            legacyScrollFactor = ViewConfigurationCompat.Api26Impl.getScaledHorizontalScrollFactor(viewConfiguration);
        } else {
            legacyScrollFactor = ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
        }
        this.mScaledHorizontalScrollFactor = legacyScrollFactor;
        if (r1 >= 26) {
            legacyScrollFactor2 = ViewConfigurationCompat.Api26Impl.getScaledVerticalScrollFactor(viewConfiguration);
        } else {
            legacyScrollFactor2 = ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
        }
        this.mScaledVerticalScrollFactor = legacyScrollFactor2;
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.mListener = this.mItemAnimatorListener;
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api16Impl.getImportantForAccessibility(this) == 0) {
            ViewCompat.Api16Impl.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] r2 = R$styleable.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r2, r18, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, r2, attributeSet, obtainStyledAttributes, r18);
        String string = obtainStyledAttributes.getString(8);
        if (obtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(1, true);
        boolean z = obtainStyledAttributes.getBoolean(3, false);
        this.mEnableFastScroller = z;
        if (z) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(6), obtainStyledAttributes.getDrawable(7), (StateListDrawable) obtainStyledAttributes.getDrawable(4), obtainStyledAttributes.getDrawable(5));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, r18, 0);
        int[] r22 = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, r22, r18, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, r22, attributeSet, obtainStyledAttributes2, r18);
        boolean z2 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
    }

    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    public boolean dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13, int r14) {
        return getScrollingChildHelper().dispatchNestedScrollInternal(r9, r10, r11, r12, r13, r14, null);
    }

    public boolean hasNestedScrollingParent(int r2) {
        return getScrollingChildHelper().getNestedScrollingParentForType(r2) != null;
    }

    public void smoothScrollBy(int r7, int r8, Interpolator interpolator, int r10) {
        smoothScrollBy(r7, r8, interpolator, r10, false);
    }

    public boolean startNestedScroll(int r2, int r3) {
        return getScrollingChildHelper().startNestedScroll(r2, r3);
    }

    public void stopNestedScroll(int r2) {
        getScrollingChildHelper().stopNestedScroll(r2);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public final Rect mDecorInsets;
        public boolean mInsetsDirty;
        public boolean mPendingInvalidate;
        public ViewHolder mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public final int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        public final boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public final boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }
    }

    public void smoothScrollBy(int r4, int r5, Interpolator interpolator, int r7, boolean z) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!layoutManager.canScrollHorizontally()) {
            r4 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            r5 = 0;
        }
        if (r4 == 0 && r5 == 0) {
            return;
        }
        if (r7 == Integer.MIN_VALUE || r7 > 0) {
            if (z) {
                int r1 = r4 != 0 ? 1 : 0;
                if (r5 != 0) {
                    r1 |= 2;
                }
                startNestedScroll(r1, 1);
            }
            this.mViewFlinger.smoothScrollBy(r4, r5, interpolator, r7);
            return;
        }
        scrollBy(r4, r5);
    }

    public final void dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13, int r14, int[] r15) {
        getScrollingChildHelper().dispatchNestedScrollInternal(r9, r10, r11, r12, r13, r14, r15);
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException(ChildHelper$$ExternalSyntheticOutline0.m(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    /* loaded from: classes.dex */
    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeInserted(int r1, int r2) {
        }

        public void onItemRangeMoved(int r1, int r2) {
        }

        public void onItemRangeRemoved(int r1, int r2) {
        }

        public void onItemRangeChanged(int r1, int r2, Object obj) {
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int r1) {
    }

    /* loaded from: classes.dex */
    public static abstract class ItemDecoration {
        public void getItemOffsets(Rect rect, View view) {
            ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
            rect.set(0, 0, 0, 0);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int r2) {
        }

        public void onScrolled(RecyclerView recyclerView, int r2, int r3) {
        }
    }

    public void onScrolled(int r1, int r2) {
    }
}
