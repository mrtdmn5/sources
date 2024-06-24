package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat$Api23Impl;
import androidx.core.util.ObjectsCompat$Api19Impl;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.GravityCompat$Api17Impl;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.kronaby.watch.app.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    public static final Class<?>[] CONSTRUCTOR_PARAMS;
    public static final ViewElevationComparator TOP_SORTED_CHILDREN_COMPARATOR;
    public static final String WIDGET_PACKAGE_NAME;
    public static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
    public static final Pools$SynchronizedPool sRectPool;
    public AnonymousClass1 mApplyWindowInsetsListener;
    public final int[] mBehaviorConsumed;
    public View mBehaviorTouchView;
    public final DirectedAcyclicGraph<View> mChildDag;
    public final ArrayList mDependencySortedChildren;
    public boolean mDisallowInterceptReset;
    public boolean mDrawStatusBarBackground;
    public boolean mIsAttachedToWindow;
    public final int[] mKeylines;
    public WindowInsetsCompat mLastInsets;
    public boolean mNeedsPreDrawListener;
    public final NestedScrollingParentHelper mNestedScrollingParentHelper;
    public View mNestedScrollingTarget;
    public final int[] mNestedScrollingV2ConsumedCompat;
    public ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    public OnPreDrawListener mOnPreDrawListener;
    public Drawable mStatusBarBackground;
    public final ArrayList mTempDependenciesList;
    public final ArrayList mTempList1;

    /* loaded from: classes.dex */
    public interface AttachedBehavior {
        Behavior getBehavior();
    }

    /* loaded from: classes.dex */
    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public boolean getInsetDodgeRect(View view) {
            return false;
        }

        public boolean layoutDependsOn(View view, View view2) {
            return false;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int r3) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int r3, int r4, int r5) {
            return false;
        }

        public boolean onNestedPreFling(View view) {
            return false;
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, int r3, int r4, int r5, int[] r6) {
            r6[0] = r6[0] + r4;
            r6[1] = r6[1] + r5;
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public Parcelable onSaveInstanceState(View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int r5, int r6) {
            return false;
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public void onAttachedToLayoutParams(LayoutParams layoutParams) {
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view) {
        }

        public void onRestoreInstanceState(View view, Parcelable parcelable) {
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int r4) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int r4, int r5, int[] r6, int r7) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    /* loaded from: classes.dex */
    public class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        public HierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            coordinatorLayout.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = coordinatorLayout.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        public OnPreDrawListener() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public SparseArray<Parcelable> behaviorStates;

        /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
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
            int readInt = parcel.readInt();
            int[] r1 = new int[readInt];
            parcel.readIntArray(r1);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(readInt);
            for (int r7 = 0; r7 < readInt; r7++) {
                this.behaviorStates.append(r1[r7], readParcelableArray[r7]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r7) {
            int r0;
            parcel.writeParcelable(this.mSuperState, r7);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            if (sparseArray != null) {
                r0 = sparseArray.size();
            } else {
                r0 = 0;
            }
            parcel.writeInt(r0);
            int[] r2 = new int[r0];
            Parcelable[] parcelableArr = new Parcelable[r0];
            for (int r1 = 0; r1 < r0; r1++) {
                r2[r1] = this.behaviorStates.keyAt(r1);
                parcelableArr[r1] = this.behaviorStates.valueAt(r1);
            }
            parcel.writeIntArray(r2);
            parcel.writeParcelableArray(parcelableArr, r7);
        }
    }

    /* loaded from: classes.dex */
    public static class ViewElevationComparator implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View view, View view2) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            float z = ViewCompat.Api21Impl.getZ(view);
            float z2 = ViewCompat.Api21Impl.getZ(view2);
            if (z > z2) {
                return -1;
            }
            if (z < z2) {
                return 1;
            }
            return 0;
        }
    }

    static {
        String str;
        Package r0 = CoordinatorLayout.class.getPackage();
        if (r0 != null) {
            str = r0.getName();
        } else {
            str = null;
        }
        WIDGET_PACKAGE_NAME = str;
        TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal<>();
        sRectPool = new Pools$SynchronizedPool(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper();
        int[] r1 = R$styleable.CoordinatorLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r1, R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, r1, attributeSet, obtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.mKeylines = intArray;
            float f = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int r2 = 0; r2 < length; r2++) {
                this.mKeylines[r2] = (int) (r1[r2] * f);
            }
        }
        this.mStatusBarBackground = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api16Impl.getImportantForAccessibility(this) == 0) {
            ViewCompat.Api16Impl.setImportantForAccessibility(this, 1);
        }
    }

    public static Rect acquireTempRect() {
        Rect rect = (Rect) sRectPool.acquire();
        if (rect == null) {
            return new Rect();
        }
        return rect;
    }

    public static void getDesiredAnchoredChildRectWithoutConstraints(int r6, Rect rect, Rect rect2, LayoutParams layoutParams, int r10, int r11) {
        int width;
        int height;
        int r0 = layoutParams.gravity;
        if (r0 == 0) {
            r0 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(r0, r6);
        int r9 = layoutParams.anchorGravity;
        if ((r9 & 7) == 0) {
            r9 |= 8388611;
        }
        if ((r9 & 112) == 0) {
            r9 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(r9, r6);
        int r92 = absoluteGravity & 7;
        int r02 = absoluteGravity & 112;
        int r1 = absoluteGravity2 & 7;
        int r62 = absoluteGravity2 & 112;
        if (r1 != 1) {
            if (r1 != 5) {
                width = rect.left;
            } else {
                width = rect.right;
            }
        } else {
            width = rect.left + (rect.width() / 2);
        }
        if (r62 != 16) {
            if (r62 != 80) {
                height = rect.top;
            } else {
                height = rect.bottom;
            }
        } else {
            height = rect.top + (rect.height() / 2);
        }
        if (r92 != 1) {
            if (r92 != 5) {
                width -= r10;
            }
        } else {
            width -= r10 / 2;
        }
        if (r02 != 16) {
            if (r02 != 80) {
                height -= r11;
            }
        } else {
            height -= r11 / 2;
        }
        rect2.set(width, height, r10 + width, r11 + height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static LayoutParams getResolvedLayoutParams(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mBehaviorResolved) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                Behavior behavior2 = layoutParams.mBehavior;
                if (behavior2 != behavior) {
                    if (behavior2 != null) {
                        behavior2.onDetachedFromLayoutParams();
                    }
                    layoutParams.mBehavior = behavior;
                    layoutParams.mBehaviorResolved = true;
                    if (behavior != null) {
                        behavior.onAttachedToLayoutParams(layoutParams);
                    }
                }
                layoutParams.mBehaviorResolved = true;
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        Behavior newInstance = defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        Behavior behavior3 = layoutParams.mBehavior;
                        if (behavior3 != newInstance) {
                            if (behavior3 != null) {
                                behavior3.onDetachedFromLayoutParams();
                            }
                            layoutParams.mBehavior = newInstance;
                            layoutParams.mBehaviorResolved = true;
                            if (newInstance != null) {
                                newInstance.onAttachedToLayoutParams(layoutParams);
                            }
                        }
                    } catch (Exception e) {
                        Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                    }
                }
                layoutParams.mBehaviorResolved = true;
            }
        }
        return layoutParams;
    }

    public static void setInsetOffsetX(int r3, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int r1 = layoutParams.mInsetOffsetX;
        if (r1 != r3) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            view.offsetLeftAndRight(r3 - r1);
            layoutParams.mInsetOffsetX = r3;
        }
    }

    public static void setInsetOffsetY(int r3, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int r1 = layoutParams.mInsetOffsetY;
        if (r1 != r3) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            view.offsetTopAndBottom(r3 - r1);
            layoutParams.mInsetOffsetY = r3;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    public final void constrainChildRect(LayoutParams layoutParams, Rect rect, int r8, int r9) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - r8) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - r9) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        rect.set(max, max2, r8 + max, r9 + max2);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).mBehavior;
        if (behavior != null) {
            behavior.getClass();
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final void getChildRect(View view, boolean z, Rect rect) {
        if (!view.isLayoutRequested() && view.getVisibility() != 8) {
            if (z) {
                getDescendantRect(view, rect);
                return;
            } else {
                rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                return;
            }
        }
        rect.setEmpty();
    }

    public final ArrayList getDependencies(View view) {
        SimpleArrayMap<View, ArrayList<View>> simpleArrayMap = this.mChildDag.mGraph;
        int r1 = simpleArrayMap.mSize;
        ArrayList arrayList = null;
        for (int r3 = 0; r3 < r1; r3++) {
            ArrayList<View> valueAt = simpleArrayMap.valueAt(r3);
            if (valueAt != null && valueAt.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(simpleArrayMap.keyAt(r3));
            }
        }
        ArrayList arrayList2 = this.mTempDependenciesList;
        arrayList2.clear();
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        return arrayList2;
    }

    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    public final void getDescendantRect(View view, Rect rect) {
        ThreadLocal<Matrix> threadLocal = ViewGroupUtils.sMatrix;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal<Matrix> threadLocal2 = ViewGroupUtils.sMatrix;
        Matrix matrix = threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        ViewGroupUtils.offsetDescendantMatrix(this, view, matrix);
        ThreadLocal<RectF> threadLocal3 = ViewGroupUtils.sRectF;
        RectF rectF = threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int getKeyline(int r5) {
        int[] r2 = this.mKeylines;
        if (r2 == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + r5);
            return 0;
        }
        if (r5 >= 0 && r5 < r2.length) {
            return r2[r5];
        }
        Log.e("CoordinatorLayout", "Keyline index " + r5 + " out of range for " + this);
        return 0;
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mNestedScrollingParentHelper;
        return nestedScrollingParentHelper.mNestedScrollAxesNonTouch | nestedScrollingParentHelper.mNestedScrollAxesTouch;
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final boolean isPointInChildBounds(View view, int r4, int r5) {
        Pools$SynchronizedPool pools$SynchronizedPool = sRectPool;
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            return acquireTempRect.contains(r4, r5);
        } finally {
            acquireTempRect.setEmpty();
            pools$SynchronizedPool.release(acquireTempRect);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api16Impl.getFitsSystemWindows(this)) {
                ViewCompat.Api20Impl.requestApplyInsets(this);
            }
        }
        this.mIsAttachedToWindow = true;
    }

    public final void onChildViewsChanged(int r26) {
        int r21;
        Rect rect;
        int r6;
        ArrayList arrayList;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int width;
        int r3;
        int r5;
        int r62;
        int height;
        int r7;
        int r52;
        int r63;
        int r18;
        LayoutParams layoutParams;
        ArrayList arrayList2;
        int r19;
        Rect rect2;
        int r212;
        View view;
        Pools$SynchronizedPool pools$SynchronizedPool;
        LayoutParams layoutParams2;
        int r53;
        boolean z5;
        Behavior behavior;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int layoutDirection = ViewCompat.Api17Impl.getLayoutDirection(this);
        ArrayList arrayList3 = this.mDependencySortedChildren;
        int size = arrayList3.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        int r32 = r26;
        int r15 = 0;
        while (true) {
            Pools$SynchronizedPool pools$SynchronizedPool2 = sRectPool;
            if (r15 < size) {
                View view2 = (View) arrayList3.get(r15);
                LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
                if (r32 == 0 && view2.getVisibility() == 8) {
                    arrayList = arrayList3;
                    r6 = size;
                    rect = acquireTempRect3;
                    r21 = r15;
                } else {
                    int r54 = 0;
                    while (r54 < r15) {
                        if (layoutParams3.mAnchorDirectChild == ((View) arrayList3.get(r54))) {
                            LayoutParams layoutParams4 = (LayoutParams) view2.getLayoutParams();
                            if (layoutParams4.mAnchorView != null) {
                                Rect acquireTempRect4 = acquireTempRect();
                                Rect acquireTempRect5 = acquireTempRect();
                                arrayList2 = arrayList3;
                                Rect acquireTempRect6 = acquireTempRect();
                                r18 = r54;
                                getDescendantRect(layoutParams4.mAnchorView, acquireTempRect4);
                                getChildRect(view2, false, acquireTempRect5);
                                int measuredWidth = view2.getMeasuredWidth();
                                r19 = size;
                                int measuredHeight = view2.getMeasuredHeight();
                                r212 = r15;
                                layoutParams = layoutParams3;
                                view = view2;
                                rect2 = acquireTempRect3;
                                pools$SynchronizedPool = pools$SynchronizedPool2;
                                getDesiredAnchoredChildRectWithoutConstraints(layoutDirection, acquireTempRect4, acquireTempRect6, layoutParams4, measuredWidth, measuredHeight);
                                if (acquireTempRect6.left == acquireTempRect5.left && acquireTempRect6.top == acquireTempRect5.top) {
                                    layoutParams2 = layoutParams4;
                                    r53 = measuredWidth;
                                    z5 = false;
                                } else {
                                    layoutParams2 = layoutParams4;
                                    r53 = measuredWidth;
                                    z5 = true;
                                }
                                constrainChildRect(layoutParams2, acquireTempRect6, r53, measuredHeight);
                                int r55 = acquireTempRect6.left - acquireTempRect5.left;
                                int r64 = acquireTempRect6.top - acquireTempRect5.top;
                                if (r55 != 0) {
                                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                                    view.offsetLeftAndRight(r55);
                                }
                                if (r64 != 0) {
                                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                                    view.offsetTopAndBottom(r64);
                                }
                                if (z5 && (behavior = layoutParams2.mBehavior) != null) {
                                    behavior.onDependentViewChanged(this, view, layoutParams2.mAnchorView);
                                }
                                acquireTempRect4.setEmpty();
                                pools$SynchronizedPool.release(acquireTempRect4);
                                acquireTempRect5.setEmpty();
                                pools$SynchronizedPool.release(acquireTempRect5);
                                acquireTempRect6.setEmpty();
                                pools$SynchronizedPool.release(acquireTempRect6);
                                r54 = r18 + 1;
                                pools$SynchronizedPool2 = pools$SynchronizedPool;
                                view2 = view;
                                arrayList3 = arrayList2;
                                size = r19;
                                r15 = r212;
                                layoutParams3 = layoutParams;
                                acquireTempRect3 = rect2;
                            }
                        }
                        r18 = r54;
                        layoutParams = layoutParams3;
                        arrayList2 = arrayList3;
                        r19 = size;
                        rect2 = acquireTempRect3;
                        r212 = r15;
                        view = view2;
                        pools$SynchronizedPool = pools$SynchronizedPool2;
                        r54 = r18 + 1;
                        pools$SynchronizedPool2 = pools$SynchronizedPool;
                        view2 = view;
                        arrayList3 = arrayList2;
                        size = r19;
                        r15 = r212;
                        layoutParams3 = layoutParams;
                        acquireTempRect3 = rect2;
                    }
                    LayoutParams layoutParams5 = layoutParams3;
                    ArrayList arrayList4 = arrayList3;
                    int r192 = size;
                    Rect rect3 = acquireTempRect3;
                    r21 = r15;
                    View view3 = view2;
                    Pools$SynchronizedPool pools$SynchronizedPool3 = pools$SynchronizedPool2;
                    getChildRect(view3, true, acquireTempRect2);
                    if (layoutParams5.insetEdge != 0 && !acquireTempRect2.isEmpty()) {
                        int absoluteGravity = Gravity.getAbsoluteGravity(layoutParams5.insetEdge, layoutDirection);
                        int r9 = absoluteGravity & 112;
                        if (r9 != 48) {
                            if (r9 == 80) {
                                acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                            }
                        } else {
                            acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                        }
                        int r33 = absoluteGravity & 7;
                        if (r33 != 3) {
                            if (r33 == 5) {
                                acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                            }
                        } else {
                            acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                        }
                    }
                    if (layoutParams5.dodgeInsetEdges != 0 && view3.getVisibility() == 0) {
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap4 = ViewCompat.sViewPropertyAnimatorMap;
                        if (ViewCompat.Api19Impl.isLaidOut(view3) && view3.getWidth() > 0 && view3.getHeight() > 0) {
                            LayoutParams layoutParams6 = (LayoutParams) view3.getLayoutParams();
                            Behavior behavior2 = layoutParams6.mBehavior;
                            Rect acquireTempRect7 = acquireTempRect();
                            Rect acquireTempRect8 = acquireTempRect();
                            acquireTempRect8.set(view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom());
                            if (behavior2 != null && behavior2.getInsetDodgeRect(view3)) {
                                if (!acquireTempRect8.contains(acquireTempRect7)) {
                                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect7.toShortString() + " | Bounds:" + acquireTempRect8.toShortString());
                                }
                            } else {
                                acquireTempRect7.set(acquireTempRect8);
                            }
                            acquireTempRect8.setEmpty();
                            pools$SynchronizedPool3.release(acquireTempRect8);
                            if (acquireTempRect7.isEmpty()) {
                                acquireTempRect7.setEmpty();
                                pools$SynchronizedPool3.release(acquireTempRect7);
                            } else {
                                int absoluteGravity2 = Gravity.getAbsoluteGravity(layoutParams6.dodgeInsetEdges, layoutDirection);
                                if ((absoluteGravity2 & 48) == 48 && (r52 = (acquireTempRect7.top - ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin) - layoutParams6.mInsetOffsetY) < (r63 = acquireTempRect.top)) {
                                    setInsetOffsetY(r63 - r52, view3);
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - acquireTempRect7.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin) + layoutParams6.mInsetOffsetY) < (r7 = acquireTempRect.bottom)) {
                                    setInsetOffsetY(height - r7, view3);
                                    z2 = true;
                                }
                                if (!z2) {
                                    setInsetOffsetY(0, view3);
                                }
                                if ((absoluteGravity2 & 3) == 3 && (r5 = (acquireTempRect7.left - ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin) - layoutParams6.mInsetOffsetX) < (r62 = acquireTempRect.left)) {
                                    setInsetOffsetX(r62 - r5, view3);
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - acquireTempRect7.right) - ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin) + layoutParams6.mInsetOffsetX) < (r3 = acquireTempRect.right)) {
                                    setInsetOffsetX(width - r3, view3);
                                    z4 = true;
                                } else {
                                    z4 = z3;
                                }
                                if (!z4) {
                                    setInsetOffsetX(0, view3);
                                }
                                acquireTempRect7.setEmpty();
                                pools$SynchronizedPool3.release(acquireTempRect7);
                            }
                        }
                    }
                    if (r26 != 2) {
                        rect = rect3;
                        rect.set(((LayoutParams) view3.getLayoutParams()).mLastChildRect);
                        if (rect.equals(acquireTempRect2)) {
                            arrayList = arrayList4;
                            r6 = r192;
                            r32 = r26;
                        } else {
                            ((LayoutParams) view3.getLayoutParams()).mLastChildRect.set(acquireTempRect2);
                        }
                    } else {
                        rect = rect3;
                    }
                    int r4 = r21 + 1;
                    r6 = r192;
                    while (true) {
                        arrayList = arrayList4;
                        if (r4 >= r6) {
                            break;
                        }
                        View view4 = (View) arrayList.get(r4);
                        LayoutParams layoutParams7 = (LayoutParams) view4.getLayoutParams();
                        Behavior behavior3 = layoutParams7.mBehavior;
                        if (behavior3 != null && behavior3.layoutDependsOn(view4, view3)) {
                            if (r26 == 0 && layoutParams7.mDidChangeAfterNestedScroll) {
                                layoutParams7.mDidChangeAfterNestedScroll = false;
                            } else {
                                if (r26 != 2) {
                                    z = behavior3.onDependentViewChanged(this, view4, view3);
                                } else {
                                    behavior3.onDependentViewRemoved(this, view3);
                                    z = true;
                                }
                                if (r26 == 1) {
                                    layoutParams7.mDidChangeAfterNestedScroll = z;
                                }
                            }
                        }
                        r4++;
                        arrayList4 = arrayList;
                    }
                    r32 = r26;
                }
                r15 = r21 + 1;
                acquireTempRect3 = rect;
                size = r6;
                arrayList3 = arrayList;
            } else {
                Rect rect4 = acquireTempRect3;
                acquireTempRect.setEmpty();
                pools$SynchronizedPool2.release(acquireTempRect);
                acquireTempRect2.setEmpty();
                pools$SynchronizedPool2.release(acquireTempRect2);
                rect4.setEmpty();
                pools$SynchronizedPool2.release(rect4);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int r0;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            if (windowInsetsCompat != null) {
                r0 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                r0 = 0;
            }
            if (r0 > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), r0);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return performIntercept;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r4, int r5, int r6, int r7) {
        Behavior behavior;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int layoutDirection = ViewCompat.Api17Impl.getLayoutDirection(this);
        ArrayList arrayList = this.mDependencySortedChildren;
        int size = arrayList.size();
        for (int r62 = 0; r62 < size; r62++) {
            View view = (View) arrayList.get(r62);
            if (view.getVisibility() != 8 && ((behavior = ((LayoutParams) view.getLayoutParams()).mBehavior) == null || !behavior.onLayoutChild(this, view, layoutDirection))) {
                onLayoutChild(layoutDirection, view);
            }
        }
    }

    public final void onLayoutChild(int r13, View view) {
        boolean z;
        Rect acquireTempRect;
        Rect acquireTempRect2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        View view2 = layoutParams.mAnchorView;
        int r3 = 0;
        if (view2 == null && layoutParams.mAnchorId != -1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Pools$SynchronizedPool pools$SynchronizedPool = sRectPool;
            if (view2 != null) {
                acquireTempRect = acquireTempRect();
                acquireTempRect2 = acquireTempRect();
                try {
                    getDescendantRect(view2, acquireTempRect);
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    getDesiredAnchoredChildRectWithoutConstraints(r13, acquireTempRect, acquireTempRect2, layoutParams2, measuredWidth, measuredHeight);
                    constrainChildRect(layoutParams2, acquireTempRect2, measuredWidth, measuredHeight);
                    view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
                    return;
                } finally {
                    acquireTempRect.setEmpty();
                    pools$SynchronizedPool.release(acquireTempRect);
                    acquireTempRect2.setEmpty();
                    pools$SynchronizedPool.release(acquireTempRect2);
                }
            }
            int r0 = layoutParams.keyline;
            if (r0 >= 0) {
                LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                int r4 = layoutParams3.gravity;
                if (r4 == 0) {
                    r4 = 8388661;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(r4, r13);
                int r5 = absoluteGravity & 7;
                int r42 = absoluteGravity & 112;
                int width = getWidth();
                int height = getHeight();
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                if (r13 == 1) {
                    r0 = width - r0;
                }
                int keyline = getKeyline(r0) - measuredWidth2;
                if (r5 != 1) {
                    if (r5 == 5) {
                        keyline += measuredWidth2;
                    }
                } else {
                    keyline += measuredWidth2 / 2;
                }
                if (r42 != 16) {
                    if (r42 == 80) {
                        r3 = measuredHeight2 + 0;
                    }
                } else {
                    r3 = 0 + (measuredHeight2 / 2);
                }
                int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin));
                int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin, Math.min(r3, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin));
                view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
                return;
            }
            LayoutParams layoutParams4 = (LayoutParams) view.getLayoutParams();
            acquireTempRect = acquireTempRect();
            acquireTempRect.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin);
            if (this.mLastInsets != null) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (ViewCompat.Api16Impl.getFitsSystemWindows(this) && !ViewCompat.Api16Impl.getFitsSystemWindows(view)) {
                    acquireTempRect.left = this.mLastInsets.getSystemWindowInsetLeft() + acquireTempRect.left;
                    acquireTempRect.top = this.mLastInsets.getSystemWindowInsetTop() + acquireTempRect.top;
                    acquireTempRect.right -= this.mLastInsets.getSystemWindowInsetRight();
                    acquireTempRect.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
                }
            }
            acquireTempRect2 = acquireTempRect();
            int r02 = layoutParams4.gravity;
            if ((r02 & 7) == 0) {
                r02 |= 8388611;
            }
            if ((r02 & 112) == 0) {
                r02 |= 48;
            }
            GravityCompat$Api17Impl.apply(r02, view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, r13);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
            return;
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0191, code lost:            if (r0.onMeasureChild(r32, r19, r25, r20, r26) == false) goto L82;     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0194  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r33, int r34) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public final void onMeasureChild(View view, int r8, int r9, int r10) {
        measureChildWithMargins(view, r8, r9, r10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        for (int r5 = 0; r5 < childCount; r5++) {
            View childAt = getChildAt(r5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0)) {
                    Behavior behavior = layoutParams.mBehavior;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z = false;
        for (int r0 = 0; r0 < childCount; r0++) {
            View childAt = getChildAt(r0);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.mBehavior) != null) {
                    z |= behavior.onNestedPreFling(view);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int r8, int r9, int[] r10) {
        onNestedPreScroll(view, r8, r9, r10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int r9, int r10, int r11, int r12) {
        onNestedScroll(view, r9, r10, r11, r12, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View view, View view2, int r4, int r5) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mNestedScrollingParentHelper;
        if (r5 == 1) {
            nestedScrollingParentHelper.mNestedScrollAxesNonTouch = r4;
        } else {
            nestedScrollingParentHelper.mNestedScrollAxesTouch = r4;
        }
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int r3 = 0; r3 < childCount; r3++) {
            ((LayoutParams) getChildAt(r3).getLayoutParams()).getClass();
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int r1 = 0; r1 < childCount; r1++) {
            View childAt = getChildAt(r1);
            int id = childAt.getId();
            Behavior behavior = getResolvedLayoutParams(childAt).mBehavior;
            if (id != -1 && behavior != null && (parcelable2 = sparseArray.get(id)) != null) {
                behavior.onRestoreInstanceState(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int r3 = 0; r3 < childCount; r3++) {
            View childAt = getChildAt(r3);
            int id = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).mBehavior;
            if (id != -1 && behavior != null && (onSaveInstanceState = behavior.onSaveInstanceState(childAt)) != null) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int r4) {
        return onStartNestedScroll(view, view2, r4, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View view, int r9) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mNestedScrollingParentHelper;
        if (r9 == 1) {
            nestedScrollingParentHelper.mNestedScrollAxesNonTouch = 0;
        } else {
            nestedScrollingParentHelper.mNestedScrollAxesTouch = 0;
        }
        int childCount = getChildCount();
        for (int r3 = 0; r3 < childCount; r3++) {
            View childAt = getChildAt(r3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(r9)) {
                Behavior behavior = layoutParams.mBehavior;
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view, r9);
                }
                if (r9 == 0) {
                    layoutParams.mDidAcceptNestedScrollTouch = false;
                } else if (r9 == 1) {
                    layoutParams.mDidAcceptNestedScrollNonTouch = false;
                }
                layoutParams.mDidChangeAfterNestedScroll = false;
            }
        }
        this.mNestedScrollingTarget = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:            if (r3 != false) goto L8;     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.mBehaviorTouchView
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.performIntercept(r1, r4)
            if (r3 == 0) goto L29
            goto L16
        L15:
            r3 = r5
        L16:
            android.view.View r6 = r0.mBehaviorTouchView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.mBehavior
            if (r6 == 0) goto L29
            android.view.View r7 = r0.mBehaviorTouchView
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
            goto L2a
        L29:
            r6 = r5
        L2a:
            android.view.View r7 = r0.mBehaviorTouchView
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L52
            r1 = 3
            if (r2 != r1) goto L55
        L52:
            r0.resetTouchBehaviors(r5)
        L55:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean performIntercept(MotionEvent motionEvent, int r25) {
        boolean z;
        int r8;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.mTempList1;
        arrayList.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int r7 = childCount - 1; r7 >= 0; r7--) {
            if (isChildrenDrawingOrderEnabled) {
                r8 = getChildDrawingOrder(childCount, r7);
            } else {
                r8 = r7;
            }
            arrayList.add(getChildAt(r8));
        }
        ViewElevationComparator viewElevationComparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (viewElevationComparator != null) {
            Collections.sort(arrayList, viewElevationComparator);
        }
        int size = arrayList.size();
        MotionEvent motionEvent2 = null;
        boolean z2 = false;
        boolean z3 = false;
        for (int r82 = 0; r82 < size; r82++) {
            View view = (View) arrayList.get(r82);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.mBehavior;
            if ((z2 || z3) && actionMasked != 0) {
                if (behavior != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (r25 != 0) {
                        if (r25 == 1) {
                            behavior.onTouchEvent(this, view, motionEvent2);
                        }
                    } else {
                        behavior.onInterceptTouchEvent(this, view, motionEvent2);
                    }
                }
            } else {
                if (!z2 && behavior != null) {
                    if (r25 != 0) {
                        if (r25 == 1) {
                            z2 = behavior.onTouchEvent(this, view, motionEvent);
                        }
                    } else {
                        z2 = behavior.onInterceptTouchEvent(this, view, motionEvent);
                    }
                    if (z2) {
                        this.mBehaviorTouchView = view;
                    }
                }
                if (layoutParams.mBehavior == null) {
                    layoutParams.mDidBlockInteraction = false;
                }
                boolean z4 = layoutParams.mDidBlockInteraction;
                if (z4) {
                    z = true;
                } else {
                    z = z4 | false;
                    layoutParams.mDidBlockInteraction = z;
                }
                if (z && !z4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z && !z3) {
                    break;
                }
            }
        }
        arrayList.clear();
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x014e, code lost:            throw new java.lang.IllegalArgumentException("All nodes must be present in the graph before being added as an edge");     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0071, code lost:            if (r12 != false) goto L58;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void prepareChildren() {
        /*
            Method dump skipped, instructions count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.prepareChildren():void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).mBehavior;
        if (behavior != null && behavior.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return true;
        }
        return super.requestChildRectangleOnScreen(view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.mDisallowInterceptReset) {
            resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    public final void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int r2 = 0; r2 < childCount; r2++) {
            View childAt = getChildAt(r2);
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).mBehavior;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behavior.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    behavior.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int r14 = 0; r14 < childCount; r14++) {
            ((LayoutParams) getChildAt(r14).getLayoutParams()).mDidBlockInteraction = false;
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        boolean z;
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                Drawable drawable4 = this.mStatusBarBackground;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                DrawableCompat$Api23Impl.setLayoutDirection(drawable4, ViewCompat.Api17Impl.getLayoutDirection(this));
                Drawable drawable5 = this.mStatusBarBackground;
                if (getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                drawable5.setVisible(z, false);
                this.mStatusBarBackground.setCallback(this);
            }
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarBackgroundColor(int r2) {
        setStatusBarBackground(new ColorDrawable(r2));
    }

    public void setStatusBarBackgroundResource(int r3) {
        Drawable drawable;
        if (r3 != 0) {
            Context context = getContext();
            Object obj = ContextCompat.sLock;
            drawable = ContextCompat.Api21Impl.getDrawable(context, r3);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        boolean z;
        super.setVisibility(r3);
        if (r3 == 0) {
            z = true;
        } else {
            z = false;
        }
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isVisible() != z) {
            this.mStatusBarBackground.setVisible(z, false);
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.coordinatorlayout.widget.CoordinatorLayout$1] */
    public final void setupForInsets() {
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api16Impl.getFitsSystemWindows(this)) {
            if (this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new OnApplyWindowInsetsListener() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        boolean z;
                        CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
                        if (!ObjectsCompat$Api19Impl.equals(coordinatorLayout.mLastInsets, windowInsetsCompat)) {
                            coordinatorLayout.mLastInsets = windowInsetsCompat;
                            boolean z2 = true;
                            if (windowInsetsCompat.getSystemWindowInsetTop() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            coordinatorLayout.mDrawStatusBarBackground = z;
                            if (z || coordinatorLayout.getBackground() != null) {
                                z2 = false;
                            }
                            coordinatorLayout.setWillNotDraw(z2);
                            WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
                            if (!impl.isConsumed()) {
                                int childCount = coordinatorLayout.getChildCount();
                                for (int r2 = 0; r2 < childCount; r2++) {
                                    View childAt = coordinatorLayout.getChildAt(r2);
                                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                                    if (ViewCompat.Api16Impl.getFitsSystemWindows(childAt) && ((LayoutParams) childAt.getLayoutParams()).mBehavior != null && impl.isConsumed()) {
                                        break;
                                    }
                                }
                            }
                            coordinatorLayout.requestLayout();
                        }
                        return windowInsetsCompat;
                    }
                };
            }
            ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this, null);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mStatusBarBackground) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View view, int r18, int r19, int[] r20, int r21) {
        Behavior behavior;
        int min;
        int childCount = getChildCount();
        boolean z = false;
        int r12 = 0;
        int r13 = 0;
        for (int r11 = 0; r11 < childCount; r11++) {
            View childAt = getChildAt(r11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(r21) && (behavior = layoutParams.mBehavior) != null) {
                    int[] r6 = this.mBehaviorConsumed;
                    r6[0] = 0;
                    r6[1] = 0;
                    behavior.onNestedPreScroll(this, childAt, view, r18, r19, r6, r21);
                    int[] r0 = this.mBehaviorConsumed;
                    r12 = r18 > 0 ? Math.max(r12, r0[0]) : Math.min(r12, r0[0]);
                    if (r19 > 0) {
                        min = Math.max(r13, r0[1]);
                    } else {
                        min = Math.min(r13, r0[1]);
                    }
                    r13 = min;
                    z = true;
                }
            }
        }
        r20[0] = r12;
        r20[1] = r13;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View view, int r10, int r11, int r12, int r13, int r14) {
        onNestedScroll(view, r10, r11, r12, r13, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View view, View view2, int r18, int r19) {
        int childCount = getChildCount();
        boolean z = false;
        for (int r10 = 0; r10 < childCount; r10++) {
            View childAt = getChildAt(r10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.mBehavior;
                if (behavior != null) {
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, r18, r19);
                    z |= onStartNestedScroll;
                    if (r19 == 0) {
                        layoutParams.mDidAcceptNestedScrollTouch = onStartNestedScroll;
                    } else if (r19 == 1) {
                        layoutParams.mDidAcceptNestedScrollNonTouch = onStartNestedScroll;
                    }
                } else if (r19 == 0) {
                    layoutParams.mDidAcceptNestedScrollTouch = false;
                } else if (r19 == 1) {
                    layoutParams.mDidAcceptNestedScrollNonTouch = false;
                }
            }
        }
        return z;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View view, int r18, int r19, int r20, int r21, int r22, int[] r23) {
        Behavior behavior;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z = false;
        int r11 = 0;
        int r12 = 0;
        for (int r10 = 0; r10 < childCount; r10++) {
            View childAt = getChildAt(r10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(r22) && (behavior = layoutParams.mBehavior) != null) {
                    int[] r15 = this.mBehaviorConsumed;
                    r15[0] = 0;
                    r15[1] = 0;
                    behavior.onNestedScroll(this, childAt, r19, r20, r21, r15);
                    if (r20 > 0) {
                        min = Math.max(r11, r15[0]);
                    } else {
                        min = Math.min(r11, r15[0]);
                    }
                    r11 = min;
                    if (r21 > 0) {
                        min2 = Math.max(r12, r15[1]);
                    } else {
                        min2 = Math.min(r12, r15[1]);
                    }
                    r12 = min2;
                    z = true;
                }
            }
        }
        r23[0] = r23[0] + r11;
        r23[1] = r23[1] + r12;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int anchorGravity;
        public int dodgeInsetEdges;
        public final int gravity;
        public int insetEdge;
        public final int keyline;
        public View mAnchorDirectChild;
        public final int mAnchorId;
        public View mAnchorView;
        public Behavior mBehavior;
        public boolean mBehaviorResolved;
        public boolean mDidAcceptNestedScrollNonTouch;
        public boolean mDidAcceptNestedScrollTouch;
        public boolean mDidBlockInteraction;
        public boolean mDidChangeAfterNestedScroll;
        public int mInsetOffsetX;
        public int mInsetOffsetY;
        public final Rect mLastChildRect;

        public LayoutParams() {
            super(-2, -2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public final boolean isNestedScrollAccepted(int r2) {
            if (r2 != 0) {
                if (r2 != 1) {
                    return false;
                }
                return this.mDidAcceptNestedScrollNonTouch;
            }
            return this.mDidAcceptNestedScrollTouch;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Behavior newInstance;
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(0, 0);
            this.mAnchorId = obtainStyledAttributes.getResourceId(1, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(2, 0);
            this.keyline = obtainStyledAttributes.getInteger(6, -1);
            this.insetEdge = obtainStyledAttributes.getInt(5, 0);
            this.dodgeInsetEdges = obtainStyledAttributes.getInt(4, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(3);
            this.mBehaviorResolved = hasValue;
            if (hasValue) {
                String string = obtainStyledAttributes.getString(3);
                String str = CoordinatorLayout.WIDGET_PACKAGE_NAME;
                if (TextUtils.isEmpty(string)) {
                    newInstance = null;
                } else {
                    if (string.startsWith(InstructionFileId.DOT)) {
                        string = context.getPackageName() + string;
                    } else if (string.indexOf(46) < 0) {
                        String str2 = CoordinatorLayout.WIDGET_PACKAGE_NAME;
                        if (!TextUtils.isEmpty(str2)) {
                            string = str2 + '.' + string;
                        }
                    }
                    try {
                        ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = CoordinatorLayout.sConstructors;
                        Map<String, Constructor<Behavior>> map = threadLocal.get();
                        if (map == null) {
                            map = new HashMap<>();
                            threadLocal.set(map);
                        }
                        Constructor<Behavior> constructor = map.get(string);
                        if (constructor == null) {
                            constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.CONSTRUCTOR_PARAMS);
                            constructor.setAccessible(true);
                            map.put(string, constructor);
                        }
                        newInstance = constructor.newInstance(context, attributeSet);
                    } catch (Exception e) {
                        throw new RuntimeException(ConstraintSet$$ExternalSyntheticOutline0.m("Could not inflate Behavior subclass ", string), e);
                    }
                }
                this.mBehavior = newInstance;
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.mBehavior;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int r4) {
        onNestedScrollAccepted(view, view2, r4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }
}
