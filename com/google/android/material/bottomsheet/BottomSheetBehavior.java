package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.material.R$styleable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public int activePointerId;
    public final ColorStateList backgroundTint;
    public final ArrayList<BottomSheetCallback> callbacks;
    public int childHeight;
    public int collapsedOffset;
    public final AnonymousClass4 dragCallback;
    public boolean draggable;
    public final float elevation;
    public int expandHalfwayActionId;
    public int expandedOffset;
    public boolean fitToContents;
    public int fitToContentsOffset;
    public int gestureInsetBottom;
    public boolean gestureInsetBottomIgnored;
    public int halfExpandedOffset;
    public float halfExpandedRatio;
    public boolean hideable;
    public boolean ignoreEvents;
    public HashMap importantForAccessibilityMap;
    public int initialY;
    public int insetBottom;
    public int insetTop;
    public ValueAnimator interpolatorAnimator;
    public boolean isShapeExpanded;
    public int lastNestedScrollDy;
    public final boolean marginLeftSystemWindowInsets;
    public final boolean marginRightSystemWindowInsets;
    public final boolean marginTopSystemWindowInsets;
    public MaterialShapeDrawable materialShapeDrawable;
    public int maxHeight;
    public int maxWidth;
    public final float maximumVelocity;
    public boolean nestedScrolled;
    public WeakReference<View> nestedScrollingChildRef;
    public final boolean paddingBottomSystemWindowInsets;
    public final boolean paddingLeftSystemWindowInsets;
    public final boolean paddingRightSystemWindowInsets;
    public final boolean paddingTopSystemWindowInsets;
    public int parentHeight;
    public int parentWidth;
    public int peekHeight;
    public boolean peekHeightAuto;
    public final int peekHeightGestureInsetBuffer;
    public int peekHeightMin;
    public int saveFlags;
    public final ShapeAppearanceModel shapeAppearanceModelDefault;
    public boolean skipCollapsed;
    public int state;
    public final BottomSheetBehavior<V>.StateSettlingTracker stateSettlingTracker;
    public boolean touchingScrollingChild;
    public VelocityTracker velocityTracker;
    public ViewDragHelper viewDragHelper;
    public WeakReference<V> viewRef;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ View val$child;
        public final /* synthetic */ int val$finalState;

        public AnonymousClass1(View view, int r3) {
            r2 = view;
            r3 = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BottomSheetBehavior.this.startSettling(r2, r3, false);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$2 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.this.materialShapeDrawable;
            if (materialShapeDrawable != null) {
                MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
                if (materialShapeDrawableState.interpolation != floatValue) {
                    materialShapeDrawableState.interpolation = floatValue;
                    materialShapeDrawable.pathDirty = true;
                    materialShapeDrawable.invalidateSelf();
                }
            }
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$3 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass3 implements ViewUtils.OnApplyWindowInsetsListener {
        public final /* synthetic */ boolean val$shouldHandleGestureInsets;

        public AnonymousClass3(boolean z) {
            this.val$shouldHandleGestureInsets = z;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$4 */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 extends ViewDragHelper.Callback {
        public AnonymousClass4() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View view, int r2) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View view, int r4) {
            int r3;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int expandedOffset = bottomSheetBehavior.getExpandedOffset();
            if (bottomSheetBehavior.hideable) {
                r3 = bottomSheetBehavior.parentHeight;
            } else {
                r3 = bottomSheetBehavior.collapsedOffset;
            }
            return MathUtils.clamp(r4, expandedOffset, r3);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewVerticalDragRange() {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                return bottomSheetBehavior.parentHeight;
            }
            return bottomSheetBehavior.collapsedOffset;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewDragStateChanged(int r3) {
            if (r3 == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.draggable) {
                    bottomSheetBehavior.setStateInternal(1);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View view, int r2, int r3) {
            BottomSheetBehavior.this.dispatchOnSlide(r3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:            if (java.lang.Math.abs(r5.getTop() - r3.getExpandedOffset()) < java.lang.Math.abs(r5.getTop() - r3.halfExpandedOffset)) goto L107;     */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0098, code lost:            if (java.lang.Math.abs(r6 - r3.halfExpandedOffset) < java.lang.Math.abs(r6 - r3.collapsedOffset)) goto L110;     */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00b2, code lost:            if (java.lang.Math.abs(r6 - r3.fitToContentsOffset) < java.lang.Math.abs(r6 - r3.collapsedOffset)) goto L107;     */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00c1, code lost:            if (r6 < java.lang.Math.abs(r6 - r3.collapsedOffset)) goto L107;     */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00d2, code lost:            if (java.lang.Math.abs(r6 - r7) < java.lang.Math.abs(r6 - r3.collapsedOffset)) goto L110;     */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:            if (r6 > r3.halfExpandedOffset) goto L110;     */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onViewReleased(android.view.View r5, float r6, float r7) {
            /*
                r4 = this;
                r0 = 0
                int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                r2 = 1
                com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                if (r1 >= 0) goto L1b
                boolean r6 = r3.fitToContents
                if (r6 == 0) goto Le
                goto Lc3
            Le:
                int r6 = r5.getTop()
                java.lang.System.currentTimeMillis()
                int r7 = r3.halfExpandedOffset
                if (r6 <= r7) goto Lc3
                goto Ld4
            L1b:
                boolean r1 = r3.hideable
                if (r1 == 0) goto L6f
                boolean r1 = r3.shouldHide(r5, r7)
                if (r1 == 0) goto L6f
                float r6 = java.lang.Math.abs(r6)
                float r0 = java.lang.Math.abs(r7)
                int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                if (r6 >= 0) goto L37
                r6 = 1140457472(0x43fa0000, float:500.0)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 > 0) goto L4b
            L37:
                int r6 = r5.getTop()
                int r7 = r3.parentHeight
                int r0 = r3.getExpandedOffset()
                int r0 = r0 + r7
                int r0 = r0 / 2
                if (r6 <= r0) goto L48
                r6 = r2
                goto L49
            L48:
                r6 = 0
            L49:
                if (r6 == 0) goto L4e
            L4b:
                r6 = 5
                goto Ld7
            L4e:
                boolean r6 = r3.fitToContents
                if (r6 == 0) goto L54
                goto Lc3
            L54:
                int r6 = r5.getTop()
                int r7 = r3.getExpandedOffset()
                int r6 = r6 - r7
                int r6 = java.lang.Math.abs(r6)
                int r7 = r5.getTop()
                int r0 = r3.halfExpandedOffset
                int r7 = r7 - r0
                int r7 = java.lang.Math.abs(r7)
                if (r6 >= r7) goto Ld4
                goto Lc3
            L6f:
                int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r0 == 0) goto L9b
                float r6 = java.lang.Math.abs(r6)
                float r7 = java.lang.Math.abs(r7)
                int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
                if (r6 <= 0) goto L80
                goto L9b
            L80:
                boolean r6 = r3.fitToContents
                if (r6 == 0) goto L85
                goto Ld6
            L85:
                int r6 = r5.getTop()
                int r7 = r3.halfExpandedOffset
                int r7 = r6 - r7
                int r7 = java.lang.Math.abs(r7)
                int r0 = r3.collapsedOffset
                int r6 = r6 - r0
                int r6 = java.lang.Math.abs(r6)
                if (r7 >= r6) goto Ld6
                goto Ld4
            L9b:
                int r6 = r5.getTop()
                boolean r7 = r3.fitToContents
                if (r7 == 0) goto Lb5
                int r7 = r3.fitToContentsOffset
                int r7 = r6 - r7
                int r7 = java.lang.Math.abs(r7)
                int r0 = r3.collapsedOffset
                int r6 = r6 - r0
                int r6 = java.lang.Math.abs(r6)
                if (r7 >= r6) goto Ld6
                goto Lc3
            Lb5:
                int r7 = r3.halfExpandedOffset
                if (r6 >= r7) goto Lc5
                int r7 = r3.collapsedOffset
                int r7 = r6 - r7
                int r7 = java.lang.Math.abs(r7)
                if (r6 >= r7) goto Ld4
            Lc3:
                r6 = 3
                goto Ld7
            Lc5:
                int r7 = r6 - r7
                int r7 = java.lang.Math.abs(r7)
                int r0 = r3.collapsedOffset
                int r6 = r6 - r0
                int r6 = java.lang.Math.abs(r6)
                if (r7 >= r6) goto Ld6
            Ld4:
                r6 = 6
                goto Ld7
            Ld6:
                r6 = 4
            Ld7:
                r3.getClass()
                r3.startSettling(r5, r6, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4.onViewReleased(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(int r6, View view) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int r1 = bottomSheetBehavior.state;
            if (r1 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (r1 == 3 && bottomSheetBehavior.activePointerId == r6) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                if (weakReference != null) {
                    view2 = weakReference.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            System.currentTimeMillis();
            WeakReference<V> weakReference2 = bottomSheetBehavior.viewRef;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$5 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass5 implements AccessibilityViewCommand {
        public final /* synthetic */ int val$state;

        public AnonymousClass5(int r2) {
            r2 = r2;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public final boolean perform(View view) {
            BottomSheetBehavior.this.setState(r2);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class StateSettlingTracker {
        public final AnonymousClass1 continueSettlingRunnable = new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.StateSettlingTracker.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                stateSettlingTracker.isContinueSettlingRunnablePosted = false;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                ViewDragHelper viewDragHelper = bottomSheetBehavior.viewDragHelper;
                if (viewDragHelper != null && viewDragHelper.continueSettling()) {
                    stateSettlingTracker.continueSettlingToState(stateSettlingTracker.targetState);
                } else if (bottomSheetBehavior.state == 2) {
                    bottomSheetBehavior.setStateInternal(stateSettlingTracker.targetState);
                }
            }
        };
        public boolean isContinueSettlingRunnablePosted;
        public int targetState;

        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$StateSettlingTracker$1 */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                stateSettlingTracker.isContinueSettlingRunnablePosted = false;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                ViewDragHelper viewDragHelper = bottomSheetBehavior.viewDragHelper;
                if (viewDragHelper != null && viewDragHelper.continueSettling()) {
                    stateSettlingTracker.continueSettlingToState(stateSettlingTracker.targetState);
                } else if (bottomSheetBehavior.state == 2) {
                    bottomSheetBehavior.setStateInternal(stateSettlingTracker.targetState);
                }
            }
        }

        public StateSettlingTracker() {
        }

        public final void continueSettlingToState(int r3) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            WeakReference<V> weakReference = bottomSheetBehavior.viewRef;
            if (weakReference != null && weakReference.get() != null) {
                this.targetState = r3;
                if (!this.isContinueSettlingRunnablePosted) {
                    V v = bottomSheetBehavior.viewRef.get();
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api16Impl.postOnAnimation(v, this.continueSettlingRunnable);
                    this.isContinueSettlingRunnablePosted = true;
                }
            }
        }
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker();
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
            public AnonymousClass4() {
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int clampViewPositionHorizontal(View view, int r2) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int clampViewPositionVertical(View view, int r4) {
                int r3;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int expandedOffset = bottomSheetBehavior.getExpandedOffset();
                if (bottomSheetBehavior.hideable) {
                    r3 = bottomSheetBehavior.parentHeight;
                } else {
                    r3 = bottomSheetBehavior.collapsedOffset;
                }
                return MathUtils.clamp(r4, expandedOffset, r3);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int getViewVerticalDragRange() {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.hideable) {
                    return bottomSheetBehavior.parentHeight;
                }
                return bottomSheetBehavior.collapsedOffset;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void onViewDragStateChanged(int r3) {
                if (r3 == 1) {
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.draggable) {
                        bottomSheetBehavior.setStateInternal(1);
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void onViewPositionChanged(View view, int r2, int r3) {
                BottomSheetBehavior.this.dispatchOnSlide(r3);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void onViewReleased(View view, float f, float f2) {
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                    	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                    */
                /*
                    this = this;
                    r0 = 0
                    int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                    r2 = 1
                    com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    if (r1 >= 0) goto L1b
                    boolean r6 = r3.fitToContents
                    if (r6 == 0) goto Le
                    goto Lc3
                Le:
                    int r6 = r5.getTop()
                    java.lang.System.currentTimeMillis()
                    int r7 = r3.halfExpandedOffset
                    if (r6 <= r7) goto Lc3
                    goto Ld4
                L1b:
                    boolean r1 = r3.hideable
                    if (r1 == 0) goto L6f
                    boolean r1 = r3.shouldHide(r5, r7)
                    if (r1 == 0) goto L6f
                    float r6 = java.lang.Math.abs(r6)
                    float r0 = java.lang.Math.abs(r7)
                    int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                    if (r6 >= 0) goto L37
                    r6 = 1140457472(0x43fa0000, float:500.0)
                    int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                    if (r6 > 0) goto L4b
                L37:
                    int r6 = r5.getTop()
                    int r7 = r3.parentHeight
                    int r0 = r3.getExpandedOffset()
                    int r0 = r0 + r7
                    int r0 = r0 / 2
                    if (r6 <= r0) goto L48
                    r6 = r2
                    goto L49
                L48:
                    r6 = 0
                L49:
                    if (r6 == 0) goto L4e
                L4b:
                    r6 = 5
                    goto Ld7
                L4e:
                    boolean r6 = r3.fitToContents
                    if (r6 == 0) goto L54
                    goto Lc3
                L54:
                    int r6 = r5.getTop()
                    int r7 = r3.getExpandedOffset()
                    int r6 = r6 - r7
                    int r6 = java.lang.Math.abs(r6)
                    int r7 = r5.getTop()
                    int r0 = r3.halfExpandedOffset
                    int r7 = r7 - r0
                    int r7 = java.lang.Math.abs(r7)
                    if (r6 >= r7) goto Ld4
                    goto Lc3
                L6f:
                    int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                    if (r0 == 0) goto L9b
                    float r6 = java.lang.Math.abs(r6)
                    float r7 = java.lang.Math.abs(r7)
                    int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
                    if (r6 <= 0) goto L80
                    goto L9b
                L80:
                    boolean r6 = r3.fitToContents
                    if (r6 == 0) goto L85
                    goto Ld6
                L85:
                    int r6 = r5.getTop()
                    int r7 = r3.halfExpandedOffset
                    int r7 = r6 - r7
                    int r7 = java.lang.Math.abs(r7)
                    int r0 = r3.collapsedOffset
                    int r6 = r6 - r0
                    int r6 = java.lang.Math.abs(r6)
                    if (r7 >= r6) goto Ld6
                    goto Ld4
                L9b:
                    int r6 = r5.getTop()
                    boolean r7 = r3.fitToContents
                    if (r7 == 0) goto Lb5
                    int r7 = r3.fitToContentsOffset
                    int r7 = r6 - r7
                    int r7 = java.lang.Math.abs(r7)
                    int r0 = r3.collapsedOffset
                    int r6 = r6 - r0
                    int r6 = java.lang.Math.abs(r6)
                    if (r7 >= r6) goto Ld6
                    goto Lc3
                Lb5:
                    int r7 = r3.halfExpandedOffset
                    if (r6 >= r7) goto Lc5
                    int r7 = r3.collapsedOffset
                    int r7 = r6 - r7
                    int r7 = java.lang.Math.abs(r7)
                    if (r6 >= r7) goto Ld4
                Lc3:
                    r6 = 3
                    goto Ld7
                Lc5:
                    int r7 = r6 - r7
                    int r7 = java.lang.Math.abs(r7)
                    int r0 = r3.collapsedOffset
                    int r6 = r6 - r0
                    int r6 = java.lang.Math.abs(r6)
                    if (r7 >= r6) goto Ld6
                Ld4:
                    r6 = 6
                    goto Ld7
                Ld6:
                    r6 = 4
                Ld7:
                    r3.getClass()
                    r3.startSettling(r5, r6, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4.onViewReleased(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final boolean tryCaptureView(int r6, View view) {
                View view2;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int r1 = bottomSheetBehavior.state;
                if (r1 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (r1 == 3 && bottomSheetBehavior.activePointerId == r6) {
                    WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                System.currentTimeMillis();
                WeakReference<V> weakReference2 = bottomSheetBehavior.viewRef;
                if (weakReference2 == null || weakReference2.get() != view) {
                    return false;
                }
                return true;
            }
        };
    }

    public static View findScrollingChild(View view) {
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api21Impl.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int r1 = 0; r1 < childCount; r1++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(r1));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
            return null;
        }
        return null;
    }

    public static BottomSheetBehavior from(FrameLayout frameLayout) {
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public static int getChildMeasureSpec(int r0, int r1, int r2, int r3) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(r0, r1, r3);
        if (r2 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                r2 = Math.min(size, r2);
            }
            return View.MeasureSpec.makeMeasureSpec(r2, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, r2), 1073741824);
    }

    public final void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    public final int calculatePeekHeight() {
        int r0;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom;
        }
        if (!this.gestureInsetBottomIgnored && !this.paddingBottomSystemWindowInsets && (r0 = this.gestureInsetBottom) > 0) {
            return Math.max(this.peekHeight, r0 + this.peekHeightGestureInsetBuffer);
        }
        return this.peekHeight + this.insetBottom;
    }

    public final void dispatchOnSlide(int r5) {
        float f;
        float f2;
        V v = this.viewRef.get();
        if (v != null) {
            ArrayList<BottomSheetCallback> arrayList = this.callbacks;
            if (!arrayList.isEmpty()) {
                int r2 = this.collapsedOffset;
                if (r5 <= r2 && r2 != getExpandedOffset()) {
                    int r22 = this.collapsedOffset;
                    f = r22 - r5;
                    f2 = r22 - getExpandedOffset();
                } else {
                    int r23 = this.collapsedOffset;
                    f = r23 - r5;
                    f2 = this.parentHeight - r23;
                }
                float f3 = f / f2;
                for (int r24 = 0; r24 < arrayList.size(); r24++) {
                    arrayList.get(r24).onSlide(v, f3);
                }
            }
        }
    }

    public final int getExpandedOffset() {
        int r1;
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        int r0 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets) {
            r1 = 0;
        } else {
            r1 = this.insetTop;
        }
        return Math.max(r0, r1);
    }

    public final int getTopOffsetForState(int r3) {
        if (r3 != 3) {
            if (r3 != 4) {
                if (r3 != 5) {
                    if (r3 == 6) {
                        return this.halfExpandedOffset;
                    }
                    throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Invalid state to get top offset: ", r3));
                }
                return this.parentHeight;
            }
            return this.collapsedOffset;
        }
        return getExpandedOffset();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z;
        View view;
        ViewDragHelper viewDragHelper;
        if (v.isShown() && this.draggable) {
            int actionMasked = motionEvent.getActionMasked();
            View view2 = null;
            if (actionMasked == 0) {
                this.activePointerId = -1;
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.velocityTracker = null;
                }
            }
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.touchingScrollingChild = false;
                    this.activePointerId = -1;
                    if (this.ignoreEvents) {
                        this.ignoreEvents = false;
                        return false;
                    }
                }
            } else {
                int x = (int) motionEvent.getX();
                this.initialY = (int) motionEvent.getY();
                if (this.state != 2) {
                    WeakReference<View> weakReference = this.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view = weakReference.get();
                    } else {
                        view = null;
                    }
                    if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.initialY)) {
                        this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.touchingScrollingChild = true;
                    }
                }
                if (this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.initialY)) {
                    z = true;
                } else {
                    z = false;
                }
                this.ignoreEvents = z;
            }
            if (!this.ignoreEvents && (viewDragHelper = this.viewDragHelper) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
            WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
            if (weakReference2 != null) {
                view2 = weakReference2.get();
            }
            if (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(this.initialY - motionEvent.getY()) <= this.viewDragHelper.mTouchSlop) {
                return false;
            }
            return true;
        }
        this.ignoreEvents = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int r13) {
        boolean z;
        boolean z2;
        float f;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api16Impl.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.Api16Impl.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        int r4 = 0;
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            if (Build.VERSION.SDK_INT >= 29 && !this.gestureInsetBottomIgnored && !this.peekHeightAuto) {
                z = true;
            } else {
                z = false;
            }
            if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || this.marginLeftSystemWindowInsets || this.marginRightSystemWindowInsets || this.marginTopSystemWindowInsets || z) {
                ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(v, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ViewUtils.3
                    public final /* synthetic */ RelativePadding val$initialPadding;
                    public final /* synthetic */ OnApplyWindowInsetsListener val$listener;

                    public AnonymousClass3(BottomSheetBehavior.AnonymousClass3 anonymousClass3, RelativePadding relativePadding) {
                        r1 = anonymousClass3;
                        r2 = relativePadding;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
                    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View r17, androidx.core.view.WindowInsetsCompat r18) {
                        /*
                            r16 = this;
                            r0 = r16
                            r1 = r17
                            r2 = r18
                            com.google.android.material.internal.ViewUtils$RelativePadding r3 = r2
                            int r4 = r3.start
                            com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener r5 = r1
                            com.google.android.material.bottomsheet.BottomSheetBehavior$3 r5 = (com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass3) r5
                            r5.getClass()
                            r6 = 7
                            androidx.core.graphics.Insets r6 = r2.getInsets(r6)
                            r7 = 32
                            androidx.core.graphics.Insets r7 = r2.getInsets(r7)
                            int r8 = r6.top
                            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                            r9.insetTop = r8
                            boolean r8 = com.google.android.material.internal.ViewUtils.isLayoutRtl(r17)
                            int r10 = r17.getPaddingBottom()
                            int r11 = r17.getPaddingLeft()
                            int r12 = r17.getPaddingRight()
                            boolean r13 = r9.paddingBottomSystemWindowInsets
                            if (r13 == 0) goto L3f
                            int r10 = r18.getSystemWindowInsetBottom()
                            r9.insetBottom = r10
                            int r14 = r3.bottom
                            int r10 = r10 + r14
                        L3f:
                            int r3 = r3.end
                            boolean r14 = r9.paddingLeftSystemWindowInsets
                            int r15 = r6.left
                            if (r14 == 0) goto L4d
                            if (r8 == 0) goto L4b
                            r11 = r3
                            goto L4c
                        L4b:
                            r11 = r4
                        L4c:
                            int r11 = r11 + r15
                        L4d:
                            boolean r14 = r9.paddingRightSystemWindowInsets
                            int r0 = r6.right
                            if (r14 == 0) goto L59
                            if (r8 == 0) goto L56
                            goto L57
                        L56:
                            r4 = r3
                        L57:
                            int r12 = r4 + r0
                        L59:
                            android.view.ViewGroup$LayoutParams r3 = r17.getLayoutParams()
                            android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
                            boolean r4 = r9.marginLeftSystemWindowInsets
                            r8 = 1
                            if (r4 == 0) goto L6c
                            int r4 = r3.leftMargin
                            if (r4 == r15) goto L6c
                            r3.leftMargin = r15
                            r4 = r8
                            goto L6d
                        L6c:
                            r4 = 0
                        L6d:
                            boolean r14 = r9.marginRightSystemWindowInsets
                            if (r14 == 0) goto L78
                            int r14 = r3.rightMargin
                            if (r14 == r0) goto L78
                            r3.rightMargin = r0
                            r4 = r8
                        L78:
                            boolean r0 = r9.marginTopSystemWindowInsets
                            if (r0 == 0) goto L85
                            int r0 = r3.topMargin
                            int r6 = r6.top
                            if (r0 == r6) goto L85
                            r3.topMargin = r6
                            goto L86
                        L85:
                            r8 = r4
                        L86:
                            if (r8 == 0) goto L8b
                            r1.setLayoutParams(r3)
                        L8b:
                            int r0 = r17.getPaddingTop()
                            r1.setPadding(r11, r0, r12, r10)
                            boolean r0 = r5.val$shouldHandleGestureInsets
                            if (r0 == 0) goto L9a
                            int r1 = r7.bottom
                            r9.gestureInsetBottom = r1
                        L9a:
                            if (r13 != 0) goto L9e
                            if (r0 == 0) goto La1
                        L9e:
                            r9.updatePeekHeight()
                        La1:
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.ViewUtils.AnonymousClass3.onApplyWindowInsets(android.view.View, androidx.core.view.WindowInsetsCompat):androidx.core.view.WindowInsetsCompat");
                    }
                });
                if (ViewCompat.Api19Impl.isAttachedToWindow(v)) {
                    ViewCompat.Api20Impl.requestApplyInsets(v);
                } else {
                    v.addOnAttachStateChangeListener(new ViewUtils.AnonymousClass4());
                }
            }
            this.viewRef = new WeakReference<>(v);
            MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
            if (materialShapeDrawable != null) {
                ViewCompat.Api16Impl.setBackground(v, materialShapeDrawable);
                MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
                float f2 = this.elevation;
                if (f2 == -1.0f) {
                    f2 = ViewCompat.Api21Impl.getElevation(v);
                }
                materialShapeDrawable2.setElevation(f2);
                if (this.state == 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.isShapeExpanded = z2;
                MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
                if (z2) {
                    f = 0.0f;
                } else {
                    f = 1.0f;
                }
                MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable3.drawableState;
                if (materialShapeDrawableState.interpolation != f) {
                    materialShapeDrawableState.interpolation = f;
                    materialShapeDrawable3.pathDirty = true;
                    materialShapeDrawable3.invalidateSelf();
                }
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    ViewCompat.Api21Impl.setBackgroundTintList(v, colorStateList);
                }
            }
            updateAccessibilityActions$1();
            if (ViewCompat.Api16Impl.getImportantForAccessibility(v) == 0) {
                ViewCompat.Api16Impl.setImportantForAccessibility(v, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = new ViewDragHelper(coordinatorLayout.getContext(), coordinatorLayout, this.dragCallback);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(r13, v);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.childHeight = height;
        int r132 = this.parentHeight;
        int r11 = r132 - height;
        int r5 = this.insetTop;
        if (r11 < r5) {
            if (this.paddingTopSystemWindowInsets) {
                this.childHeight = r132;
            } else {
                this.childHeight = r132 - r5;
            }
        }
        this.fitToContentsOffset = Math.max(0, r132 - this.childHeight);
        this.halfExpandedOffset = (int) ((1.0f - this.halfExpandedRatio) * this.parentHeight);
        calculateCollapsedOffset();
        int r112 = this.state;
        if (r112 == 3) {
            v.offsetTopAndBottom(getExpandedOffset());
        } else if (r112 == 6) {
            v.offsetTopAndBottom(this.halfExpandedOffset);
        } else if (this.hideable && r112 == 5) {
            v.offsetTopAndBottom(this.parentHeight);
        } else if (r112 == 4) {
            v.offsetTopAndBottom(this.collapsedOffset);
        } else if (r112 == 1 || r112 == 2) {
            v.offsetTopAndBottom(top - v.getTop());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v));
        while (true) {
            ArrayList<BottomSheetCallback> arrayList = this.callbacks;
            if (r4 >= arrayList.size()) {
                return true;
            }
            arrayList.get(r4).onLayout(v);
            r4++;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int r6, int r7, int r8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(r6, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + r7, this.maxWidth, marginLayoutParams.width), getChildMeasureSpec(r8, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(View view) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.state != 3) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int r5, int r6, int[] r7, int r8) {
        View view2;
        if (r8 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (view != view2) {
            return;
        }
        int top = v.getTop();
        int r82 = top - r6;
        if (r6 > 0) {
            if (r82 < getExpandedOffset()) {
                int expandedOffset = top - getExpandedOffset();
                r7[1] = expandedOffset;
                int r4 = -expandedOffset;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                v.offsetTopAndBottom(r4);
                setStateInternal(3);
            } else {
                if (!this.draggable) {
                    return;
                }
                r7[1] = r6;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                v.offsetTopAndBottom(-r6);
                setStateInternal(1);
            }
        } else if (r6 < 0 && !view.canScrollVertically(-1)) {
            int r42 = this.collapsedOffset;
            if (r82 > r42 && !this.hideable) {
                int r52 = top - r42;
                r7[1] = r52;
                int r43 = -r52;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                v.offsetTopAndBottom(r43);
                setStateInternal(4);
            } else {
                if (!this.draggable) {
                    return;
                }
                r7[1] = r6;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap4 = ViewCompat.sViewPropertyAnimatorMap;
                v.offsetTopAndBottom(-r6);
                setStateInternal(1);
            }
        }
        dispatchOnSlide(v.getTop());
        this.lastNestedScrollDy = r6;
        this.nestedScrolled = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        int r6 = this.saveFlags;
        if (r6 != 0) {
            if (r6 == -1 || (r6 & 1) == 1) {
                this.peekHeight = savedState.peekHeight;
            }
            if (r6 == -1 || (r6 & 2) == 2) {
                this.fitToContents = savedState.fitToContents;
            }
            if (r6 == -1 || (r6 & 4) == 4) {
                this.hideable = savedState.hideable;
            }
            if (r6 == -1 || (r6 & 8) == 8) {
                this.skipCollapsed = savedState.skipCollapsed;
            }
        }
        int r62 = savedState.state;
        if (r62 != 1 && r62 != 2) {
            this.state = r62;
        } else {
            this.state = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(View view) {
        return new SavedState(View.BaseSavedState.EMPTY_STATE, this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int r5, int r6) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((r5 & 2) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:            if (r3.getTop() <= r1.halfExpandedOffset) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:            if (java.lang.Math.abs(r2 - r1.fitToContentsOffset) < java.lang.Math.abs(r2 - r1.collapsedOffset)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007e, code lost:            if (r2 < java.lang.Math.abs(r2 - r1.collapsedOffset)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008e, code lost:            if (java.lang.Math.abs(r2 - r4) < java.lang.Math.abs(r2 - r1.collapsedOffset)) goto L107;     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a9, code lost:            if (java.lang.Math.abs(r2 - r1.halfExpandedOffset) < java.lang.Math.abs(r2 - r1.collapsedOffset)) goto L107;     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r2, V r3, android.view.View r4, int r5) {
        /*
            r1 = this;
            int r2 = r3.getTop()
            int r5 = r1.getExpandedOffset()
            r0 = 3
            if (r2 != r5) goto Lf
            r1.setStateInternal(r0)
            return
        Lf:
            java.lang.ref.WeakReference<android.view.View> r2 = r1.nestedScrollingChildRef
            if (r2 == 0) goto Lb4
            java.lang.Object r2 = r2.get()
            if (r4 != r2) goto Lb4
            boolean r2 = r1.nestedScrolled
            if (r2 != 0) goto L1f
            goto Lb4
        L1f:
            int r2 = r1.lastNestedScrollDy
            if (r2 <= 0) goto L33
            boolean r2 = r1.fitToContents
            if (r2 == 0) goto L29
            goto Lae
        L29:
            int r2 = r3.getTop()
            int r4 = r1.halfExpandedOffset
            if (r2 <= r4) goto Lae
            goto Lab
        L33:
            boolean r2 = r1.hideable
            if (r2 == 0) goto L54
            android.view.VelocityTracker r2 = r1.velocityTracker
            if (r2 != 0) goto L3d
            r2 = 0
            goto L4c
        L3d:
            r4 = 1000(0x3e8, float:1.401E-42)
            float r5 = r1.maximumVelocity
            r2.computeCurrentVelocity(r4, r5)
            android.view.VelocityTracker r2 = r1.velocityTracker
            int r4 = r1.activePointerId
            float r2 = r2.getYVelocity(r4)
        L4c:
            boolean r2 = r1.shouldHide(r3, r2)
            if (r2 == 0) goto L54
            r0 = 5
            goto Lae
        L54:
            int r2 = r1.lastNestedScrollDy
            if (r2 != 0) goto L91
            int r2 = r3.getTop()
            boolean r4 = r1.fitToContents
            if (r4 == 0) goto L72
            int r4 = r1.fitToContentsOffset
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.collapsedOffset
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto Lad
            goto Lae
        L72:
            int r4 = r1.halfExpandedOffset
            if (r2 >= r4) goto L81
            int r4 = r1.collapsedOffset
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            if (r2 >= r4) goto Lab
            goto Lae
        L81:
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.collapsedOffset
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto Lad
            goto Lab
        L91:
            boolean r2 = r1.fitToContents
            if (r2 == 0) goto L96
            goto Lad
        L96:
            int r2 = r3.getTop()
            int r4 = r1.halfExpandedOffset
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.collapsedOffset
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto Lad
        Lab:
            r0 = 6
            goto Lae
        Lad:
            r0 = 4
        Lae:
            r2 = 0
            r1.startSettling(r3, r0, r2)
            r1.nestedScrolled = r2
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int r1 = this.state;
        if (r1 == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null && (this.draggable || r1 == 1)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.activePointerId = -1;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (this.viewDragHelper != null && (this.draggable || this.state == 1)) {
            z2 = true;
        }
        if (z2 && actionMasked == 2 && !this.ignoreEvents) {
            float abs = Math.abs(this.initialY - motionEvent.getY());
            ViewDragHelper viewDragHelper2 = this.viewDragHelper;
            if (abs > viewDragHelper2.mTouchSlop) {
                viewDragHelper2.captureChildView(motionEvent.getPointerId(motionEvent.getActionIndex()), v);
            }
        }
        return !this.ignoreEvents;
    }

    public final void setHideable(boolean z) {
        if (this.hideable != z) {
            this.hideable = z;
            if (!z && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions$1();
        }
    }

    public final void setPeekHeight(int r4) {
        boolean z = false;
        if (r4 == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
                z = true;
            }
        } else if (this.peekHeightAuto || this.peekHeight != r4) {
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, r4);
            z = true;
        }
        if (z) {
            updatePeekHeight();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:            if (androidx.core.view.ViewCompat.Api19Impl.isAttachedToWindow(r5) != false) goto L81;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setState(int r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 == r0) goto L71
            r1 = 2
            if (r5 != r1) goto L8
            goto L71
        L8:
            boolean r1 = r4.hideable
            if (r1 != 0) goto L23
            r1 = 5
            if (r5 != r1) goto L23
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Cannot set state: "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "BottomSheetBehavior"
            android.util.Log.w(r0, r5)
            return
        L23:
            r1 = 6
            if (r5 != r1) goto L34
            boolean r1 = r4.fitToContents
            if (r1 == 0) goto L34
            int r1 = r4.getTopOffsetForState(r5)
            int r2 = r4.fitToContentsOffset
            if (r1 > r2) goto L34
            r1 = 3
            goto L35
        L34:
            r1 = r5
        L35:
            java.lang.ref.WeakReference<V extends android.view.View> r2 = r4.viewRef
            if (r2 == 0) goto L6d
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L40
            goto L6d
        L40:
            java.lang.ref.WeakReference<V extends android.view.View> r5 = r4.viewRef
            java.lang.Object r5 = r5.get()
            android.view.View r5 = (android.view.View) r5
            com.google.android.material.bottomsheet.BottomSheetBehavior$1 r2 = new com.google.android.material.bottomsheet.BottomSheetBehavior$1
            r2.<init>()
            android.view.ViewParent r1 = r5.getParent()
            if (r1 == 0) goto L62
            boolean r1 = r1.isLayoutRequested()
            if (r1 == 0) goto L62
            java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r1 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
            boolean r1 = androidx.core.view.ViewCompat.Api19Impl.isAttachedToWindow(r5)
            if (r1 == 0) goto L62
            goto L63
        L62:
            r0 = 0
        L63:
            if (r0 == 0) goto L69
            r5.post(r2)
            goto L70
        L69:
            r2.run()
            goto L70
        L6d:
            r4.setStateInternal(r5)
        L70:
            return
        L71:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "STATE_"
            r2.<init>(r3)
            if (r5 != r0) goto L7f
            java.lang.String r5 = "DRAGGING"
            goto L81
        L7f:
            java.lang.String r5 = "SETTLING"
        L81:
            java.lang.String r0 = " should not be set externally."
            java.lang.String r5 = androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0.m(r2, r5, r0)
            r1.<init>(r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.setState(int):void");
    }

    public final void setStateInternal(int r5) {
        V v;
        if (this.state == r5) {
            return;
        }
        this.state = r5;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        int r3 = 0;
        if (r5 == 3) {
            updateImportantForAccessibility(true);
        } else if (r5 == 6 || r5 == 5 || r5 == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(r5);
        while (true) {
            ArrayList<BottomSheetCallback> arrayList = this.callbacks;
            if (r3 < arrayList.size()) {
                arrayList.get(r3).onStateChanged(v, r5);
                r3++;
            } else {
                updateAccessibilityActions$1();
                return;
            }
        }
    }

    public final boolean shouldHide(View view, float f) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs(((f * 0.1f) + view.getTop()) - this.collapsedOffset) / calculatePeekHeight() > 0.5f) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:            if (r4 != false) goto L38;     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:            if (r1.settleCapturedViewAt(r4.getLeft(), r0) != false) goto L38;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0032, code lost:            r2 = true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void startSettling(android.view.View r4, int r5, boolean r6) {
        /*
            r3 = this;
            int r0 = r3.getTopOffsetForState(r5)
            androidx.customview.widget.ViewDragHelper r1 = r3.viewDragHelper
            r2 = 0
            if (r1 == 0) goto L33
            if (r6 == 0) goto L16
            int r4 = r4.getLeft()
            boolean r4 = r1.settleCapturedViewAt(r4, r0)
            if (r4 == 0) goto L33
            goto L32
        L16:
            int r6 = r4.getLeft()
            r1.mCapturedView = r4
            r4 = -1
            r1.mActivePointerId = r4
            boolean r4 = r1.forceSettleCapturedViewAt(r6, r0, r2, r2)
            if (r4 != 0) goto L30
            int r6 = r1.mDragState
            if (r6 != 0) goto L30
            android.view.View r6 = r1.mCapturedView
            if (r6 == 0) goto L30
            r6 = 0
            r1.mCapturedView = r6
        L30:
            if (r4 == 0) goto L33
        L32:
            r2 = 1
        L33:
            if (r2 == 0) goto L42
            r4 = 2
            r3.setStateInternal(r4)
            r3.updateDrawableForTargetState(r5)
            com.google.android.material.bottomsheet.BottomSheetBehavior<V>$StateSettlingTracker r4 = r3.stateSettlingTracker
            r4.continueSettlingToState(r5)
            goto L45
        L42:
            r3.setStateInternal(r5)
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.startSettling(android.view.View, int, boolean):void");
    }

    public final void updateAccessibilityActions$1() {
        V v;
        int r2;
        boolean z;
        AccessibilityDelegateCompat accessibilityDelegateCompat;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeActionWithId(524288, v);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, v);
        ViewCompat.removeActionWithId(262144, v);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, v);
        ViewCompat.removeActionWithId(Constants.MB, v);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, v);
        int r22 = this.expandHalfwayActionId;
        if (r22 != -1) {
            ViewCompat.removeActionWithId(r22, v);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, v);
        }
        int r4 = 6;
        if (!this.fitToContents && this.state != 6) {
            String string = v.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            AnonymousClass5 anonymousClass5 = new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
                public final /* synthetic */ int val$state;

                public AnonymousClass5(int r23) {
                    r2 = r23;
                }

                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean perform(View view) {
                    BottomSheetBehavior.this.setState(r2);
                    return true;
                }
            };
            ArrayList actionList = ViewCompat.getActionList(v);
            int r5 = 0;
            while (true) {
                if (r5 < actionList.size()) {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) actionList.get(r5)).mAction).getLabel())) {
                        r2 = ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) actionList.get(r5)).getId();
                        break;
                    }
                    r5++;
                } else {
                    int r6 = 0;
                    int r52 = -1;
                    while (true) {
                        int[] r7 = ViewCompat.ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
                        if (r6 >= r7.length || r52 != -1) {
                            break;
                        }
                        int r72 = r7[r6];
                        boolean z2 = true;
                        for (int r11 = 0; r11 < actionList.size(); r11++) {
                            if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) actionList.get(r11)).getId() != r72) {
                                z = true;
                            } else {
                                z = false;
                            }
                            z2 &= z;
                        }
                        if (z2) {
                            r52 = r72;
                        }
                        r6++;
                    }
                    r2 = r52;
                }
            }
            if (r2 != -1) {
                AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, r2, string, anonymousClass5, null);
                View.AccessibilityDelegate accessibilityDelegateInternal = ViewCompat.getAccessibilityDelegateInternal(v);
                if (accessibilityDelegateInternal == null) {
                    accessibilityDelegateCompat = null;
                } else if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
                    accessibilityDelegateCompat = ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat;
                } else {
                    accessibilityDelegateCompat = new AccessibilityDelegateCompat(accessibilityDelegateInternal);
                }
                if (accessibilityDelegateCompat == null) {
                    accessibilityDelegateCompat = new AccessibilityDelegateCompat();
                }
                ViewCompat.setAccessibilityDelegate(v, accessibilityDelegateCompat);
                ViewCompat.removeActionWithId(accessibilityActionCompat.getId(), v);
                ViewCompat.getActionList(v).add(accessibilityActionCompat);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, v);
            }
            this.expandHalfwayActionId = r2;
        }
        if (this.hideable && this.state != 5) {
            ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
                public final /* synthetic */ int val$state;

                public AnonymousClass5(int r23) {
                    r2 = r23;
                }

                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean perform(View view) {
                    BottomSheetBehavior.this.setState(r2);
                    return true;
                }
            });
        }
        int r1 = this.state;
        if (r1 != 3) {
            if (r1 != 4) {
                if (r1 == 6) {
                    ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
                        public final /* synthetic */ int val$state;

                        public AnonymousClass5(int r23) {
                            r2 = r23;
                        }

                        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                        public final boolean perform(View view) {
                            BottomSheetBehavior.this.setState(r2);
                            return true;
                        }
                    });
                    ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
                        public final /* synthetic */ int val$state;

                        public AnonymousClass5(int r23) {
                            r2 = r23;
                        }

                        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                        public final boolean perform(View view) {
                            BottomSheetBehavior.this.setState(r2);
                            return true;
                        }
                    });
                    return;
                }
                return;
            }
            if (this.fitToContents) {
                r4 = 3;
            }
            ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
                public final /* synthetic */ int val$state;

                public AnonymousClass5(int r42) {
                    r2 = r42;
                }

                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean perform(View view) {
                    BottomSheetBehavior.this.setState(r2);
                    return true;
                }
            });
            return;
        }
        if (this.fitToContents) {
            r42 = 4;
        }
        ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
            public final /* synthetic */ int val$state;

            public AnonymousClass5(int r42) {
                r2 = r42;
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean perform(View view) {
                BottomSheetBehavior.this.setState(r2);
                return true;
            }
        });
    }

    public final void updateDrawableForTargetState(int r6) {
        boolean z;
        ValueAnimator valueAnimator;
        float f;
        if (r6 == 2) {
            return;
        }
        if (r6 == 3) {
            z = true;
        } else {
            z = false;
        }
        if (this.isShapeExpanded != z) {
            this.isShapeExpanded = z;
            if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                if (valueAnimator.isRunning()) {
                    this.interpolatorAnimator.reverse();
                    return;
                }
                if (z) {
                    f = 0.0f;
                } else {
                    f = 1.0f;
                }
                this.interpolatorAnimator.setFloatValues(1.0f - f, f);
                this.interpolatorAnimator.start();
            }
        }
    }

    public final void updateImportantForAccessibility(boolean z) {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z) {
            if (this.importantForAccessibilityMap == null) {
                this.importantForAccessibilityMap = new HashMap(childCount);
            } else {
                return;
            }
        }
        for (int r2 = 0; r2 < childCount; r2++) {
            View childAt = coordinatorLayout.getChildAt(r2);
            if (childAt != this.viewRef.get() && z) {
                this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
            }
        }
        if (!z) {
            this.importantForAccessibilityMap = null;
        }
    }

    public final void updatePeekHeight() {
        V v;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (v = this.viewRef.get()) != null) {
                v.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public final boolean fitToContents;
        public final boolean hideable;
        public final int peekHeight;
        public final boolean skipCollapsed;
        public final int state;

        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState$1 */
        /* loaded from: classes3.dex */
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
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r3) {
            parcel.writeParcelable(this.mSuperState, r3);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(android.view.AbsSavedState absSavedState, BottomSheetBehavior bottomSheetBehavior) {
            super(absSavedState);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int r4;
        this.saveFlags = 0;
        this.fitToContents = true;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker();
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
            public AnonymousClass4() {
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int clampViewPositionHorizontal(View view, int r2) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int clampViewPositionVertical(View view, int r42) {
                int r3;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int expandedOffset = bottomSheetBehavior.getExpandedOffset();
                if (bottomSheetBehavior.hideable) {
                    r3 = bottomSheetBehavior.parentHeight;
                } else {
                    r3 = bottomSheetBehavior.collapsedOffset;
                }
                return MathUtils.clamp(r42, expandedOffset, r3);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int getViewVerticalDragRange() {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.hideable) {
                    return bottomSheetBehavior.parentHeight;
                }
                return bottomSheetBehavior.collapsedOffset;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void onViewDragStateChanged(int r3) {
                if (r3 == 1) {
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.draggable) {
                        bottomSheetBehavior.setStateInternal(1);
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void onViewPositionChanged(View view, int r2, int r3) {
                BottomSheetBehavior.this.dispatchOnSlide(r3);
            }

            /*  JADX ERROR: Method code generation error
                java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void onViewReleased(android.view.View r5, float r6, float r7) {
                /*
                    r4 = this;
                    r0 = 0
                    int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                    r2 = 1
                    com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    if (r1 >= 0) goto L1b
                    boolean r6 = r3.fitToContents
                    if (r6 == 0) goto Le
                    goto Lc3
                Le:
                    int r6 = r5.getTop()
                    java.lang.System.currentTimeMillis()
                    int r7 = r3.halfExpandedOffset
                    if (r6 <= r7) goto Lc3
                    goto Ld4
                L1b:
                    boolean r1 = r3.hideable
                    if (r1 == 0) goto L6f
                    boolean r1 = r3.shouldHide(r5, r7)
                    if (r1 == 0) goto L6f
                    float r6 = java.lang.Math.abs(r6)
                    float r0 = java.lang.Math.abs(r7)
                    int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                    if (r6 >= 0) goto L37
                    r6 = 1140457472(0x43fa0000, float:500.0)
                    int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                    if (r6 > 0) goto L4b
                L37:
                    int r6 = r5.getTop()
                    int r7 = r3.parentHeight
                    int r0 = r3.getExpandedOffset()
                    int r0 = r0 + r7
                    int r0 = r0 / 2
                    if (r6 <= r0) goto L48
                    r6 = r2
                    goto L49
                L48:
                    r6 = 0
                L49:
                    if (r6 == 0) goto L4e
                L4b:
                    r6 = 5
                    goto Ld7
                L4e:
                    boolean r6 = r3.fitToContents
                    if (r6 == 0) goto L54
                    goto Lc3
                L54:
                    int r6 = r5.getTop()
                    int r7 = r3.getExpandedOffset()
                    int r6 = r6 - r7
                    int r6 = java.lang.Math.abs(r6)
                    int r7 = r5.getTop()
                    int r0 = r3.halfExpandedOffset
                    int r7 = r7 - r0
                    int r7 = java.lang.Math.abs(r7)
                    if (r6 >= r7) goto Ld4
                    goto Lc3
                L6f:
                    int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                    if (r0 == 0) goto L9b
                    float r6 = java.lang.Math.abs(r6)
                    float r7 = java.lang.Math.abs(r7)
                    int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
                    if (r6 <= 0) goto L80
                    goto L9b
                L80:
                    boolean r6 = r3.fitToContents
                    if (r6 == 0) goto L85
                    goto Ld6
                L85:
                    int r6 = r5.getTop()
                    int r7 = r3.halfExpandedOffset
                    int r7 = r6 - r7
                    int r7 = java.lang.Math.abs(r7)
                    int r0 = r3.collapsedOffset
                    int r6 = r6 - r0
                    int r6 = java.lang.Math.abs(r6)
                    if (r7 >= r6) goto Ld6
                    goto Ld4
                L9b:
                    int r6 = r5.getTop()
                    boolean r7 = r3.fitToContents
                    if (r7 == 0) goto Lb5
                    int r7 = r3.fitToContentsOffset
                    int r7 = r6 - r7
                    int r7 = java.lang.Math.abs(r7)
                    int r0 = r3.collapsedOffset
                    int r6 = r6 - r0
                    int r6 = java.lang.Math.abs(r6)
                    if (r7 >= r6) goto Ld6
                    goto Lc3
                Lb5:
                    int r7 = r3.halfExpandedOffset
                    if (r6 >= r7) goto Lc5
                    int r7 = r3.collapsedOffset
                    int r7 = r6 - r7
                    int r7 = java.lang.Math.abs(r7)
                    if (r6 >= r7) goto Ld4
                Lc3:
                    r6 = 3
                    goto Ld7
                Lc5:
                    int r7 = r6 - r7
                    int r7 = java.lang.Math.abs(r7)
                    int r0 = r3.collapsedOffset
                    int r6 = r6 - r0
                    int r6 = java.lang.Math.abs(r6)
                    if (r7 >= r6) goto Ld6
                Ld4:
                    r6 = 6
                    goto Ld7
                Ld6:
                    r6 = 4
                Ld7:
                    r3.getClass()
                    r3.startSettling(r5, r6, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4.onViewReleased(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final boolean tryCaptureView(int r6, View view) {
                View view2;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int r1 = bottomSheetBehavior.state;
                if (r1 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (r1 == 3 && bottomSheetBehavior.activePointerId == r6) {
                    WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                System.currentTimeMillis();
                WeakReference<V> weakReference2 = bottomSheetBehavior.viewRef;
                if (weakReference2 == null || weakReference2.get() != view) {
                    return false;
                }
                return true;
            }
        };
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        if (obtainStyledAttributes.hasValue(3)) {
            this.backgroundTint = MaterialResources.getColorStateList(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(20)) {
            this.shapeAppearanceModelDefault = new ShapeAppearanceModel(ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, 2132083604));
        }
        ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearanceModelDefault;
        if (shapeAppearanceModel != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
            this.materialShapeDrawable = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            ColorStateList colorStateList = this.backgroundTint;
            if (colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.materialShapeDrawable.setTint(typedValue.data);
            }
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
            public AnonymousClass2() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MaterialShapeDrawable materialShapeDrawable2 = BottomSheetBehavior.this.materialShapeDrawable;
                if (materialShapeDrawable2 != null) {
                    MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable2.drawableState;
                    if (materialShapeDrawableState.interpolation != floatValue) {
                        materialShapeDrawableState.interpolation = floatValue;
                        materialShapeDrawable2.pathDirty = true;
                        materialShapeDrawable2.invalidateSelf();
                    }
                }
            }
        });
        this.elevation = obtainStyledAttributes.getDimension(2, -1.0f);
        if (obtainStyledAttributes.hasValue(0)) {
            this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.maxHeight = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(9);
        if (peekValue != null && (r4 = peekValue.data) == -1) {
            setPeekHeight(r4);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(9, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(8, false));
        this.gestureInsetBottomIgnored = obtainStyledAttributes.getBoolean(12, false);
        boolean z = obtainStyledAttributes.getBoolean(6, true);
        if (this.fitToContents != z) {
            this.fitToContents = z;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
            updateAccessibilityActions$1();
        }
        this.skipCollapsed = obtainStyledAttributes.getBoolean(11, false);
        this.draggable = obtainStyledAttributes.getBoolean(4, true);
        this.saveFlags = obtainStyledAttributes.getInt(10, 0);
        float f = obtainStyledAttributes.getFloat(7, 0.5f);
        if (f > 0.0f && f < 1.0f) {
            this.halfExpandedRatio = f;
            if (this.viewRef != null) {
                this.halfExpandedOffset = (int) ((1.0f - f) * this.parentHeight);
            }
            TypedValue peekValue2 = obtainStyledAttributes.peekValue(5);
            if (peekValue2 != null && peekValue2.type == 16) {
                int r13 = peekValue2.data;
                if (r13 >= 0) {
                    this.expandedOffset = r13;
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
                if (dimensionPixelOffset >= 0) {
                    this.expandedOffset = dimensionPixelOffset;
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(16, false);
            this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(17, false);
            this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(18, false);
            this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(19, true);
            this.marginLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(13, false);
            this.marginRightSystemWindowInsets = obtainStyledAttributes.getBoolean(14, false);
            this.marginTopSystemWindowInsets = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
            this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    /* loaded from: classes3.dex */
    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int r2);

        public void onLayout(View view) {
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, int r3, int r4, int r5, int[] r6) {
    }
}
