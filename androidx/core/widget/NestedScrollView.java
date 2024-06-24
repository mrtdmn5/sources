package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat$Api15Impl;
import androidx.core.widget.EdgeEffectCompat;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild {
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final float SCROLL_FRICTION = 0.015f;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    public EdgeEffect mEdgeGlowBottom;
    public EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private final float mPhysicalCoeff;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;
    private static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
    private static final int[] SCROLLVIEW_STYLEABLE = {R.attr.fillViewport};

    /* loaded from: classes.dex */
    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            boolean z;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            if (nestedScrollView.getScrollRange() > 0) {
                z = true;
            } else {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat$Api15Impl.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat$Api15Impl.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                accessibilityNodeInfoCompat.setScrollable(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View view, int r6, Bundle bundle) {
            if (super.performAccessibilityAction(view, r6, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (r6 != 4096) {
                if (r6 != 8192 && r6 != 16908344) {
                    if (r6 != 16908346) {
                        return false;
                    }
                } else {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollTo(0, max, true);
                    return true;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.smoothScrollTo(0, min, true);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static boolean getClipToPadding(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* loaded from: classes.dex */
    public interface OnScrollChangeListener {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public int scrollPosition;

        /* renamed from: androidx.core.widget.NestedScrollView$SavedState$1, reason: invalid class name */
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

        public SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.scrollPosition, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r2) {
            super.writeToParcel(parcel, r2);
            parcel.writeInt(this.scrollPosition);
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private boolean canOverScroll() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0) {
            return true;
        }
        if (overScrollMode == 1 && getScrollRange() > 0) {
            return true;
        }
        return false;
    }

    private boolean canScroll() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin <= (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            return false;
        }
        return true;
    }

    private static int clamp(int r1, int r2, int r3) {
        if (r2 < r3 && r1 >= 0) {
            if (r2 + r1 > r3) {
                return r3 - r2;
            }
            return r1;
        }
        return 0;
    }

    private void doScrollY(int r3) {
        if (r3 != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(0, r3);
            } else {
                scrollBy(0, r3);
            }
        }
    }

    private boolean edgeEffectFling(int r3) {
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != DECELERATION_RATE) {
            if (shouldAbsorb(this.mEdgeGlowTop, r3)) {
                this.mEdgeGlowTop.onAbsorb(r3);
            } else {
                fling(-r3);
            }
        } else if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != DECELERATION_RATE) {
            int r32 = -r3;
            if (shouldAbsorb(this.mEdgeGlowBottom, r32)) {
                this.mEdgeGlowBottom.onAbsorb(r32);
            } else {
                fling(r32);
            }
        } else {
            return false;
        }
        return true;
    }

    private void endTouchDrag() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    private View findFocusableViewInBounds(boolean z, int r14, int r15) {
        boolean z2;
        boolean z3;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z4 = false;
        for (int r4 = 0; r4 < size; r4++) {
            View view2 = focusables.get(r4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (r14 < bottom && top < r15) {
                if (r14 < top && bottom < r15) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (view == null) {
                    view = view2;
                    z4 = z2;
                } else {
                    if ((z && top < view.getTop()) || (!z && bottom > view.getBottom())) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z4) {
                        if (z2) {
                            if (!z3) {
                            }
                            view = view2;
                        }
                    } else if (z2) {
                        view = view2;
                        z4 = true;
                    } else {
                        if (!z3) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private float getSplineFlingDistance(int r9) {
        double log = Math.log((Math.abs(r9) * INFLEXION) / (this.mPhysicalCoeff * SCROLL_FRICTION));
        float f = DECELERATION_RATE;
        return (float) (Math.exp((f / (f - 1.0d)) * log) * this.mPhysicalCoeff * SCROLL_FRICTION);
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == DECELERATION_RATE) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.mVerticalScrollFactor;
    }

    private boolean inChild(int r5, int r6) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (r6 < childAt.getTop() - scrollY || r6 >= childAt.getBottom() - scrollY || r5 < childAt.getLeft() || r5 >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void initializeTouchDrag(int r1, int r2) {
        this.mLastMotionY = r1;
        this.mActivePointerId = r2;
        startNestedScroll(2, 0);
    }

    private boolean isOffScreen(View view) {
        return !isWithinDeltaOfScreen(view, 0, getHeight());
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        if ((parent instanceof ViewGroup) && isViewDescendantOf((View) parent, view2)) {
            return true;
        }
        return false;
    }

    private boolean isWithinDeltaOfScreen(View view, int r3, int r4) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (this.mTempRect.bottom + r3 >= getScrollY() && this.mTempRect.top - r3 <= getScrollY() + r4) {
            return true;
        }
        return false;
    }

    private void onNestedScrollInternal(int r11, int r12, int[] r13) {
        int scrollY = getScrollY();
        scrollBy(0, r11);
        int scrollY2 = getScrollY() - scrollY;
        if (r13 != null) {
            r13[1] = r13[1] + scrollY2;
        }
        this.mChildHelper.dispatchNestedScrollInternal(0, scrollY2, 0, r11 - scrollY2, null, r12, r13);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int r0;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                r0 = 1;
            } else {
                r0 = 0;
            }
            this.mLastMotionY = (int) motionEvent.getY(r0);
            this.mActivePointerId = motionEvent.getPointerId(r0);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int releaseVerticalGlow(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.mEdgeGlowTop
            float r0 = androidx.core.widget.EdgeEffectCompat.getDistance(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.mEdgeGlowTop
            float r4 = -r4
            float r4 = androidx.core.widget.EdgeEffectCompat.onPullDistance(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.mEdgeGlowTop
            float r5 = androidx.core.widget.EdgeEffectCompat.getDistance(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.mEdgeGlowTop
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.mEdgeGlowBottom
            float r0 = androidx.core.widget.EdgeEffectCompat.getDistance(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.mEdgeGlowBottom
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.EdgeEffectCompat.onPullDistance(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.mEdgeGlowBottom
            float r5 = androidx.core.widget.EdgeEffectCompat.getDistance(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.mEdgeGlowBottom
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L63
            r3.invalidate()
        L63:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.releaseVerticalGlow(int, float):int");
    }

    private void runAnimatedScroll(boolean z) {
        if (z) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.mLastScrollerY = getScrollY();
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
    }

    private boolean scrollAndFocus(int r7, int r8, int r9) {
        boolean z;
        int r82;
        int height = getHeight();
        int scrollY = getScrollY();
        int r0 = height + scrollY;
        boolean z2 = false;
        if (r7 == 33) {
            z = true;
        } else {
            z = false;
        }
        View findFocusableViewInBounds = findFocusableViewInBounds(z, r8, r9);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if (r8 < scrollY || r9 > r0) {
            if (z) {
                r82 = r8 - scrollY;
            } else {
                r82 = r9 - r0;
            }
            scrollBy(r82, 0, 1, true);
            z2 = true;
        }
        if (findFocusableViewInBounds != findFocus()) {
            findFocusableViewInBounds.requestFocus(r7);
        }
        return z2;
    }

    private int scrollBy(int r22, int r23, int r24, boolean z) {
        int r15;
        int r16;
        boolean z2;
        boolean z3;
        if (r24 == 1) {
            startNestedScroll(2, r24);
        }
        boolean z4 = false;
        if (dispatchNestedPreScroll(0, r22, this.mScrollConsumed, this.mScrollOffset, r24)) {
            r15 = r22 - this.mScrollConsumed[1];
            r16 = this.mScrollOffset[1] + 0;
        } else {
            r15 = r22;
            r16 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        if (canOverScroll() && !z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (overScrollByCompat(0, r15, 0, scrollY, 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent(r24)) {
            z3 = true;
        } else {
            z3 = false;
        }
        int scrollY2 = getScrollY() - scrollY;
        int[] r7 = this.mScrollConsumed;
        r7[1] = 0;
        dispatchNestedScroll(0, scrollY2, 0, r15 - scrollY2, this.mScrollOffset, r24, r7);
        int r162 = r16 + this.mScrollOffset[1];
        int r152 = r15 - this.mScrollConsumed[1];
        int r0 = scrollY + r152;
        if (r0 < 0) {
            if (z2) {
                EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (-r152) / getHeight(), r23 / getWidth());
                if (!this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
        } else if (r0 > scrollRange && z2) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, r152 / getHeight(), 1.0f - (r23 / getWidth()));
            if (!this.mEdgeGlowTop.isFinished()) {
                this.mEdgeGlowTop.onRelease();
            }
        }
        if (this.mEdgeGlowTop.isFinished() && this.mEdgeGlowBottom.isFinished()) {
            z4 = z3;
        } else {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
        }
        if (z4 && r24 == 0) {
            this.mVelocityTracker.clear();
        }
        if (r24 == 1) {
            stopNestedScroll(r24);
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
        return r162;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z) {
        boolean z2;
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    private boolean shouldAbsorb(EdgeEffect edgeEffect, int r4) {
        if (r4 > 0) {
            return true;
        }
        if (getSplineFlingDistance(-r4) < EdgeEffectCompat.getDistance(edgeEffect) * getHeight()) {
            return true;
        }
        return false;
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != DECELERATION_RATE) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, DECELERATION_RATE, motionEvent.getX() / getWidth());
            z = true;
        } else {
            z = false;
        }
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != DECELERATION_RATE) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, DECELERATION_RATE, 1.0f - (motionEvent.getX() / getWidth()));
            return true;
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int r9) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, r9);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && isWithinDeltaOfScreen(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            scrollBy(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0, 1, true);
            findNextFocus.requestFocus(r9);
        } else {
            if (r9 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (r9 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (r9 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            scrollBy(maxScrollAmount, 0, 1, true);
        }
        if (findFocus != null && findFocus.isFocused() && isOffScreen(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished()) {
            return;
        }
        this.mScroller.computeScrollOffset();
        int currY = this.mScroller.getCurrY();
        int consumeFlingInVerticalStretch = consumeFlingInVerticalStretch(currY - this.mLastScrollerY);
        this.mLastScrollerY = currY;
        int[] r3 = this.mScrollConsumed;
        boolean z = false;
        r3[1] = 0;
        dispatchNestedPreScroll(0, consumeFlingInVerticalStretch, r3, null, 1);
        int r13 = consumeFlingInVerticalStretch - this.mScrollConsumed[1];
        int scrollRange = getScrollRange();
        if (r13 != 0) {
            int scrollY = getScrollY();
            overScrollByCompat(0, r13, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int r132 = r13 - scrollY2;
            int[] r7 = this.mScrollConsumed;
            r7[1] = 0;
            dispatchNestedScroll(0, scrollY2, 0, r132, this.mScrollOffset, 1, r7);
            r13 = r132 - this.mScrollConsumed[1];
        }
        if (r13 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z = true;
            }
            if (z) {
                if (r13 < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                } else if (this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
                }
            }
            abortAnimatedScroll();
        }
        if (!this.mScroller.isFinished()) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
        } else {
            stopNestedScroll(1);
        }
    }

    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int r4;
        int r1;
        int r11;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int r3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            r4 = r3 - verticalFadingEdgeLength;
        } else {
            r4 = r3;
        }
        int r7 = rect.bottom;
        if (r7 > r4 && rect.top > scrollY) {
            if (rect.height() > height) {
                r11 = rect.top - scrollY;
            } else {
                r11 = rect.bottom - r4;
            }
            return Math.min(r11 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - r3);
        }
        if (rect.top >= scrollY || r7 >= r4) {
            return 0;
        }
        if (rect.height() > height) {
            r1 = 0 - (r4 - rect.bottom);
        } else {
            r1 = 0 - (scrollY - rect.top);
        }
        return Math.max(r1, -getScrollY());
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    public int consumeFlingInVerticalStretch(int r6) {
        int height = getHeight();
        if (r6 > 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != DECELERATION_RATE) {
            int round = Math.round(EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, ((-r6) * 4.0f) / height, MAX_SCROLL_FACTOR) * ((-height) / 4.0f));
            if (round != r6) {
                this.mEdgeGlowTop.finish();
            }
            return r6 - round;
        }
        if (r6 < 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != DECELERATION_RATE) {
            float f = height;
            int round2 = Math.round(EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, (r6 * 4.0f) / f, MAX_SCROLL_FACTOR) * (f / 4.0f));
            if (round2 != r6) {
                this.mEdgeGlowBottom.finish();
            }
            return r6 - round2;
        }
        return r6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return this.mChildHelper.dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    public void dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13, int r14, int[] r15) {
        this.mChildHelper.dispatchNestedScrollInternal(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int r6;
        super.draw(canvas);
        int scrollY = getScrollY();
        int r2 = 0;
        if (!this.mEdgeGlowTop.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (Api21Impl.getClipToPadding(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                r6 = getPaddingLeft() + 0;
            } else {
                r6 = 0;
            }
            if (Api21Impl.getClipToPadding(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            }
            canvas.translate(r6, min);
            this.mEdgeGlowTop.setSize(width, height);
            if (this.mEdgeGlowTop.draw(canvas)) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
            }
            canvas.restoreToCount(save);
        }
        if (!this.mEdgeGlowBottom.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (Api21Impl.getClipToPadding(this)) {
                width2 -= getPaddingRight() + getPaddingLeft();
                r2 = 0 + getPaddingLeft();
            }
            if (Api21Impl.getClipToPadding(this)) {
                height2 -= getPaddingBottom() + getPaddingTop();
                max -= getPaddingBottom();
            }
            canvas.translate(r2 - width2, max);
            canvas.rotate(180.0f, width2, DECELERATION_RATE);
            this.mEdgeGlowBottom.setSize(width2, height2);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        boolean canScroll = canScroll();
        int r2 = com.animaconnected.secondo.R.styleable.AppTheme_statusTopStripeSetup;
        if (!canScroll) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, com.animaconnected.secondo.R.styleable.AppTheme_statusTopStripeSetup);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(com.animaconnected.secondo.R.styleable.AppTheme_statusTopStripeSetup)) {
                return false;
            }
            return true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 19) {
            if (keyCode != 20) {
                if (keyCode != 62) {
                    if (keyCode != 92) {
                        if (keyCode != 93) {
                            if (keyCode != 122) {
                                if (keyCode != 123) {
                                    return false;
                                }
                                pageScroll(com.animaconnected.secondo.R.styleable.AppTheme_statusTopStripeSetup);
                                return false;
                            }
                            pageScroll(33);
                            return false;
                        }
                        return fullScroll(com.animaconnected.secondo.R.styleable.AppTheme_statusTopStripeSetup);
                    }
                    return fullScroll(33);
                }
                if (keyEvent.isShiftPressed()) {
                    r2 = 33;
                }
                pageScroll(r2);
                return false;
            }
            if (keyEvent.isAltPressed()) {
                return fullScroll(com.animaconnected.secondo.R.styleable.AppTheme_statusTopStripeSetup);
            }
            return arrowScroll(com.animaconnected.secondo.R.styleable.AppTheme_statusTopStripeSetup);
        }
        if (keyEvent.isAltPressed()) {
            return fullScroll(33);
        }
        return arrowScroll(33);
    }

    public void fling(int r13) {
        if (getChildCount() > 0) {
            this.mScroller.fling(getScrollX(), getScrollY(), 0, r13, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            runAnimatedScroll(true);
        }
    }

    public boolean fullScroll(int r6) {
        boolean z;
        int childCount;
        if (r6 == 130) {
            z = true;
        } else {
            z = false;
        }
        int height = getHeight();
        Rect rect = this.mTempRect;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.mTempRect.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            Rect rect2 = this.mTempRect;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.mTempRect;
        return scrollAndFocus(r6, rect3.top, rect3.bottom);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return DECELERATION_RATE;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * MAX_SCROLL_FACTOR);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mParentHelper;
        return nestedScrollingParentHelper.mNestedScrollAxesNonTouch | nestedScrollingParentHelper.mNestedScrollAxesTouch;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return DECELERATION_RATE;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public boolean hasNestedScrollingParent(int r2) {
        return this.mChildHelper.getNestedScrollingParentForType(r2) != null;
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.mIsNestedScrollingEnabled;
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int r4, int r5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(r4, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int r3, int r4, int r5, int r6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(r3, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + r4, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int r1;
        float f;
        boolean z3 = false;
        if (motionEvent.getAction() != 8 || this.mIsBeingDragged) {
            return false;
        }
        if ((motionEvent.getSource() & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f = motionEvent.getAxisValue(9);
            r1 = (int) motionEvent.getX();
        } else {
            if ((motionEvent.getSource() & 4194304) == 4194304) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                f = motionEvent.getAxisValue(26);
                r1 = getWidth() / 2;
            } else {
                r1 = 0;
                f = 0.0f;
            }
        }
        if (f == DECELERATION_RATE) {
            return false;
        }
        int verticalScrollFactorCompat = (int) (f * getVerticalScrollFactorCompat());
        if ((motionEvent.getSource() & 8194) == 8194) {
            z3 = true;
        }
        scrollBy(-verticalScrollFactorCompat, r1, 1, z3);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int r0 = action & 255;
        if (r0 != 0) {
            if (r0 != 1) {
                if (r0 != 2) {
                    if (r0 != 3) {
                        if (r0 == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    }
                } else {
                    int r02 = this.mActivePointerId;
                    if (r02 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(r02);
                        if (findPointerIndex == -1) {
                            Log.e(TAG, "Invalid pointerId=" + r02 + " in onInterceptTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                                this.mIsBeingDragged = true;
                                this.mLastMotionY = y;
                                initVelocityTrackerIfNotExists();
                                this.mVelocityTracker.addMovement(motionEvent);
                                this.mNestedYOffset = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
            }
            stopNestedScroll(0);
        } else {
            int y2 = (int) motionEvent.getY();
            if (!inChild((int) motionEvent.getX(), y2)) {
                if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                    z = false;
                }
                this.mIsBeingDragged = z;
                recycleVelocityTracker();
            } else {
                this.mLastMotionY = y2;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mScroller.computeScrollOffset();
                if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                    z = false;
                }
                this.mIsBeingDragged = z;
                startNestedScroll(2, 0);
            }
        }
        return this.mIsBeingDragged;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int r3, int r4, int r5, int r6) {
        super.onLayout(z, r3, r4, r5, r6);
        int r2 = 0;
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                r2 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((r6 - r4) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int clamp = clamp(scrollY, paddingTop, r2);
            if (clamp != scrollY) {
                scrollTo(getScrollX(), clamp);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        if (this.mFillViewport && View.MeasureSpec.getMode(r6) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(r5, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!z) {
            dispatchNestedFling(DECELERATION_RATE, f2, true);
            fling((int) f2);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int r8, int r9, int[] r10, int r11) {
        dispatchNestedPreScroll(r8, r9, r10, null, r11);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        onNestedScrollInternal(r5, r6, r7);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int r3, int r4) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mParentHelper;
        if (r4 == 1) {
            nestedScrollingParentHelper.mNestedScrollAxesNonTouch = r3;
        } else {
            nestedScrollingParentHelper.mNestedScrollAxesTouch = r3;
        }
        startNestedScroll(2, r4);
    }

    @Override // android.view.View
    public void onOverScrolled(int r1, int r2, boolean z, boolean z2) {
        super.scrollTo(r1, r2);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r4, Rect rect) {
        View findNextFocusFromRect;
        if (r4 == 2) {
            r4 = com.animaconnected.secondo.R.styleable.AppTheme_statusTopStripeSetup;
        } else if (r4 == 1) {
            r4 = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, r4);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, r4);
        }
        if (findNextFocusFromRect == null || isOffScreen(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(r4, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSavedState = savedState;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && isWithinDeltaOfScreen(findFocus, 0, r4)) {
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int r3, int r4) {
        return (r3 & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int r4) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mParentHelper;
        if (r4 == 1) {
            nestedScrollingParentHelper.mNestedScrollAxesNonTouch = 0;
        } else {
            nestedScrollingParentHelper.mNestedScrollAxesTouch = 0;
        }
        stopNestedScroll(r4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        initVelocityTrackerIfNotExists();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(DECELERATION_RATE, this.mNestedYOffset);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                onSecondaryPointerUp(motionEvent);
                                this.mLastMotionY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.mLastMotionY = (int) motionEvent.getY(actionIndex);
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                        }
                    } else {
                        if (this.mIsBeingDragged && getChildCount() > 0 && this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                            ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
                        }
                        endTouchDrag();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                    } else {
                        int y = (int) motionEvent.getY(findPointerIndex);
                        int r5 = this.mLastMotionY - y;
                        int releaseVerticalGlow = r5 - releaseVerticalGlow(r5, motionEvent.getX(findPointerIndex));
                        if (!this.mIsBeingDragged && Math.abs(releaseVerticalGlow) > this.mTouchSlop) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mIsBeingDragged = true;
                            releaseVerticalGlow = releaseVerticalGlow > 0 ? releaseVerticalGlow - this.mTouchSlop : releaseVerticalGlow + this.mTouchSlop;
                        }
                        if (this.mIsBeingDragged) {
                            int scrollBy = scrollBy(releaseVerticalGlow, (int) motionEvent.getX(findPointerIndex), 0, false);
                            this.mLastMotionY = y - scrollBy;
                            this.mNestedYOffset += scrollBy;
                        }
                    }
                }
            } else {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                if (Math.abs(yVelocity) >= this.mMinimumVelocity) {
                    if (!edgeEffectFling(yVelocity)) {
                        int r13 = -yVelocity;
                        float f = r13;
                        if (!dispatchNestedPreFling(DECELERATION_RATE, f)) {
                            dispatchNestedFling(DECELERATION_RATE, f, true);
                            fling(r13);
                        }
                    }
                } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
                }
                endTouchDrag();
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.mIsBeingDragged && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            initializeTouchDrag((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public boolean overScrollByCompat(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int r2;
        int r1;
        boolean z6;
        boolean z7;
        int overScrollMode = getOverScrollMode();
        if (computeHorizontalScrollRange() > computeHorizontalScrollExtent()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (overScrollMode != 0 && (overScrollMode != 1 || !z2)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (overScrollMode != 0 && (overScrollMode != 1 || !z3)) {
            z5 = false;
        } else {
            z5 = true;
        }
        int r3 = r15 + r13;
        if (!z4) {
            r2 = 0;
        } else {
            r2 = r19;
        }
        int r6 = r16 + r14;
        if (!z5) {
            r1 = 0;
        } else {
            r1 = r20;
        }
        int r7 = -r2;
        int r22 = r2 + r17;
        int r8 = -r1;
        int r12 = r1 + r18;
        if (r3 > r22) {
            r3 = r22;
            z6 = true;
        } else if (r3 < r7) {
            z6 = true;
            r3 = r7;
        } else {
            z6 = false;
        }
        if (r6 > r12) {
            r6 = r12;
            z7 = true;
        } else if (r6 < r8) {
            z7 = true;
            r6 = r8;
        } else {
            z7 = false;
        }
        if (z7 && !hasNestedScrollingParent(1)) {
            this.mScroller.springBack(r3, r6, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(r3, r6, z6, z7);
        if (!z6 && !z7) {
            return false;
        }
        return true;
    }

    public boolean pageScroll(int r5) {
        boolean z;
        if (r5 == 130) {
            z = true;
        } else {
            z = false;
        }
        int height = getHeight();
        if (z) {
            this.mTempRect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                Rect rect = this.mTempRect;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            Rect rect2 = this.mTempRect;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.mTempRect;
        int r1 = rect3.top;
        int r3 = height + r1;
        rect3.bottom = r3;
        return scrollAndFocus(r5, r1, r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mIsLayoutDirty) {
            scrollToChild(view2);
        } else {
            this.mChildToScrollTo = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int r7, int r8) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int clamp = clamp(r7, width, width2);
            int clamp2 = clamp(r8, height, height2);
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.mFillViewport) {
            this.mFillViewport = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.mChildHelper;
        if (nestedScrollingChildHelper.mIsNestedScrollingEnabled) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.stopNestedScroll(nestedScrollingChildHelper.mView);
        }
        nestedScrollingChildHelper.mIsNestedScrollingEnabled = z;
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.mSmoothScrollingEnabled = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int r3, int r4) {
        smoothScrollBy(r3, r4, 250, false);
    }

    public final void smoothScrollTo(int r3, int r4) {
        smoothScrollTo(r3, r4, 250, false);
    }

    public boolean startNestedScroll(int r2, int r3) {
        return this.mChildHelper.startNestedScroll(r2, r3);
    }

    public void stopNestedScroll(int r2) {
        this.mChildHelper.stopNestedScroll(r2);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.kronaby.watch.app.R.attr.nestedScrollViewStyle);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10) {
        return dispatchNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int r8, int r9, int[] r10) {
        onNestedPreScroll(view, r8, r9, r10, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int r2, int r3, int r4, int r5, int r6) {
        onNestedScrollInternal(r5, r6, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int r4) {
        return onStartNestedScroll(view, view2, r4, 0);
    }

    public final void smoothScrollBy(int r2, int r3, int r4) {
        smoothScrollBy(r2, r3, r4, false);
    }

    public final void smoothScrollTo(int r2, int r3, int r4) {
        smoothScrollTo(r2, r3, r4, false);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int r2) {
        return startNestedScroll(r2, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int r8) {
        super(context, attributeSet, r8);
        EdgeEffect edgeEffect;
        EdgeEffect edgeEffect2;
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        int r2 = Build.VERSION.SDK_INT;
        if (r2 >= 31) {
            edgeEffect = EdgeEffectCompat.Api31Impl.create(context, attributeSet);
        } else {
            edgeEffect = new EdgeEffect(context);
        }
        this.mEdgeGlowTop = edgeEffect;
        if (r2 >= 31) {
            edgeEffect2 = EdgeEffectCompat.Api31Impl.create(context, attributeSet);
        } else {
            edgeEffect2 = new EdgeEffect(context);
        }
        this.mEdgeGlowBottom = edgeEffect2;
        this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        initScrollView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, r8, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.mParentHelper = new NestedScrollingParentHelper();
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private void smoothScrollBy(int r9, int r10, int r11, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.mScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(r10 + scrollY, Math.max(0, height - height2))) - scrollY, r11);
            runAnimatedScroll(z);
        } else {
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            scrollBy(r9, r10);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public boolean dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13, int r14) {
        return this.mChildHelper.dispatchNestedScrollInternal(r9, r10, r11, r12, r13, r14, null);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int r2, int r3, int r4, int r5) {
        onNestedScrollInternal(r5, 0, null);
    }

    public void smoothScrollTo(int r2, int r3, boolean z) {
        smoothScrollTo(r2, r3, 250, z);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int r3) {
        if (getChildCount() <= 0) {
            super.addView(view, r3);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void smoothScrollTo(int r2, int r3, int r4, boolean z) {
        smoothScrollBy(r2 - getScrollX(), r3 - getScrollY(), r4, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13) {
        return this.mChildHelper.dispatchNestedScrollInternal(r9, r10, r11, r12, r13, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int r4) {
        onNestedScrollAccepted(view, view2, r4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int r3, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, r3, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
