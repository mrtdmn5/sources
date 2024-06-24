package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;
import com.amazonaws.services.s3.internal.Constants;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public boolean interceptingEvents;
    public ViewDragHelper viewDragHelper;
    public int swipeDirection = 2;
    public final float dragDismissThreshold = 0.5f;
    public float alphaStartSwipeDistance = 0.0f;
    public float alphaEndSwipeDistance = 0.5f;
    public final AnonymousClass1 dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1
        public int activePointerId = -1;
        public int originalCapturedViewLeft;

        public AnonymousClass1() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View view, int r5) {
            boolean z;
            int width;
            int width2;
            int width3;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api17Impl.getLayoutDirection(view) == 1) {
                z = true;
            } else {
                z = false;
            }
            int r2 = SwipeDismissBehavior.this.swipeDirection;
            if (r2 == 0) {
                if (z) {
                    width = this.originalCapturedViewLeft - view.getWidth();
                    width2 = this.originalCapturedViewLeft;
                } else {
                    width = this.originalCapturedViewLeft;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (r2 == 1) {
                if (z) {
                    width = this.originalCapturedViewLeft;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                } else {
                    width = this.originalCapturedViewLeft - view.getWidth();
                    width2 = this.originalCapturedViewLeft;
                }
            } else {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = view.getWidth() + this.originalCapturedViewLeft;
            }
            return Math.min(Math.max(width, r5), width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View view, int r2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewCaptured(int r1, View view) {
            this.activePointerId = r1;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewDragStateChanged(int r1) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View view, int r6, int r7) {
            float f = this.originalCapturedViewLeft;
            float width = view.getWidth();
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            float f2 = (width * swipeDismissBehavior.alphaStartSwipeDistance) + f;
            float width2 = (view.getWidth() * swipeDismissBehavior.alphaEndSwipeDistance) + this.originalCapturedViewLeft;
            float f3 = r6;
            if (f3 <= f2) {
                view.setAlpha(1.0f);
            } else if (f3 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((f3 - f2) / (width2 - f2))), 1.0f));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0050, code lost:            if (java.lang.Math.abs(r9.getLeft() - r8.originalCapturedViewLeft) >= java.lang.Math.round(r9.getWidth() * r3.dragDismissThreshold)) goto L67;     */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onViewReleased(android.view.View r9, float r10, float r11) {
            /*
                r8 = this;
                r11 = -1
                r8.activePointerId = r11
                int r11 = r9.getWidth()
                r0 = 0
                int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                r2 = 1
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r4 = 0
                if (r1 == 0) goto L39
                java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r5 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
                int r5 = androidx.core.view.ViewCompat.Api17Impl.getLayoutDirection(r9)
                if (r5 != r2) goto L1a
                r5 = r2
                goto L1b
            L1a:
                r5 = r4
            L1b:
                int r6 = r3.swipeDirection
                r7 = 2
                if (r6 != r7) goto L21
                goto L52
            L21:
                if (r6 != 0) goto L2d
                if (r5 == 0) goto L2a
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 >= 0) goto L54
                goto L52
            L2a:
                if (r1 <= 0) goto L54
                goto L52
            L2d:
                if (r6 != r2) goto L54
                if (r5 == 0) goto L34
                if (r1 <= 0) goto L54
                goto L52
            L34:
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 >= 0) goto L54
                goto L52
            L39:
                int r10 = r9.getLeft()
                int r0 = r8.originalCapturedViewLeft
                int r10 = r10 - r0
                int r0 = r9.getWidth()
                float r0 = (float) r0
                float r1 = r3.dragDismissThreshold
                float r0 = r0 * r1
                int r0 = java.lang.Math.round(r0)
                int r10 = java.lang.Math.abs(r10)
                if (r10 < r0) goto L54
            L52:
                r10 = r2
                goto L55
            L54:
                r10 = r4
            L55:
                if (r10 == 0) goto L63
                int r10 = r9.getLeft()
                int r0 = r8.originalCapturedViewLeft
                if (r10 >= r0) goto L61
                int r0 = r0 - r11
                goto L66
            L61:
                int r0 = r0 + r11
                goto L66
            L63:
                int r0 = r8.originalCapturedViewLeft
                r2 = r4
            L66:
                androidx.customview.widget.ViewDragHelper r10 = r3.viewDragHelper
                int r11 = r9.getTop()
                boolean r10 = r10.settleCapturedViewAt(r0, r11)
                if (r10 == 0) goto L7c
                com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable r10 = new com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable
                r10.<init>(r9, r2)
                java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r11 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
                androidx.core.view.ViewCompat.Api16Impl.postOnAnimation(r9, r10)
            L7c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.onViewReleased(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(int r3, View view) {
            int r0 = this.activePointerId;
            if ((r0 == -1 || r0 == r3) && SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                return true;
            }
            return false;
        }
    };

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends ViewDragHelper.Callback {
        public int activePointerId = -1;
        public int originalCapturedViewLeft;

        public AnonymousClass1() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View view, int r5) {
            boolean z;
            int width;
            int width2;
            int width3;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api17Impl.getLayoutDirection(view) == 1) {
                z = true;
            } else {
                z = false;
            }
            int r2 = SwipeDismissBehavior.this.swipeDirection;
            if (r2 == 0) {
                if (z) {
                    width = this.originalCapturedViewLeft - view.getWidth();
                    width2 = this.originalCapturedViewLeft;
                } else {
                    width = this.originalCapturedViewLeft;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (r2 == 1) {
                if (z) {
                    width = this.originalCapturedViewLeft;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                } else {
                    width = this.originalCapturedViewLeft - view.getWidth();
                    width2 = this.originalCapturedViewLeft;
                }
            } else {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = view.getWidth() + this.originalCapturedViewLeft;
            }
            return Math.min(Math.max(width, r5), width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View view, int r2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewCaptured(int r1, View view) {
            this.activePointerId = r1;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewDragStateChanged(int r1) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View view, int r6, int r7) {
            float f = this.originalCapturedViewLeft;
            float width = view.getWidth();
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            float f2 = (width * swipeDismissBehavior.alphaStartSwipeDistance) + f;
            float width2 = (view.getWidth() * swipeDismissBehavior.alphaEndSwipeDistance) + this.originalCapturedViewLeft;
            float f3 = r6;
            if (f3 <= f2) {
                view.setAlpha(1.0f);
            } else if (f3 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((f3 - f2) / (width2 - f2))), 1.0f));
            }
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
                r11 = -1
                r8.activePointerId = r11
                int r11 = r9.getWidth()
                r0 = 0
                int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                r2 = 1
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r4 = 0
                if (r1 == 0) goto L39
                java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r5 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
                int r5 = androidx.core.view.ViewCompat.Api17Impl.getLayoutDirection(r9)
                if (r5 != r2) goto L1a
                r5 = r2
                goto L1b
            L1a:
                r5 = r4
            L1b:
                int r6 = r3.swipeDirection
                r7 = 2
                if (r6 != r7) goto L21
                goto L52
            L21:
                if (r6 != 0) goto L2d
                if (r5 == 0) goto L2a
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 >= 0) goto L54
                goto L52
            L2a:
                if (r1 <= 0) goto L54
                goto L52
            L2d:
                if (r6 != r2) goto L54
                if (r5 == 0) goto L34
                if (r1 <= 0) goto L54
                goto L52
            L34:
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 >= 0) goto L54
                goto L52
            L39:
                int r10 = r9.getLeft()
                int r0 = r8.originalCapturedViewLeft
                int r10 = r10 - r0
                int r0 = r9.getWidth()
                float r0 = (float) r0
                float r1 = r3.dragDismissThreshold
                float r0 = r0 * r1
                int r0 = java.lang.Math.round(r0)
                int r10 = java.lang.Math.abs(r10)
                if (r10 < r0) goto L54
            L52:
                r10 = r2
                goto L55
            L54:
                r10 = r4
            L55:
                if (r10 == 0) goto L63
                int r10 = r9.getLeft()
                int r0 = r8.originalCapturedViewLeft
                if (r10 >= r0) goto L61
                int r0 = r0 - r11
                goto L66
            L61:
                int r0 = r0 + r11
                goto L66
            L63:
                int r0 = r8.originalCapturedViewLeft
                r2 = r4
            L66:
                androidx.customview.widget.ViewDragHelper r10 = r3.viewDragHelper
                int r11 = r9.getTop()
                boolean r10 = r10.settleCapturedViewAt(r0, r11)
                if (r10 == 0) goto L7c
                com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable r10 = new com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable
                r10.<init>(r9, r2)
                java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r11 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
                androidx.core.view.ViewCompat.Api16Impl.postOnAnimation(r9, r10)
            L7c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.onViewReleased(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(int r3, View view) {
            int r0 = this.activePointerId;
            if ((r0 == -1 || r0 == r3) && SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$2 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass2 implements AccessibilityViewCommand {
        public AnonymousClass2() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public final boolean perform(View view) {
            boolean z;
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            boolean z2 = false;
            if (!swipeDismissBehavior.canSwipeDismissView(view)) {
                return false;
            }
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api17Impl.getLayoutDirection(view) == 1) {
                z = true;
            } else {
                z = false;
            }
            int r0 = swipeDismissBehavior.swipeDirection;
            if ((r0 == 0 && z) || (r0 == 1 && !z)) {
                z2 = true;
            }
            int width = view.getWidth();
            if (z2) {
                width = -width;
            }
            view.offsetLeftAndRight(width);
            view.setAlpha(0.0f);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class SettleRunnable implements Runnable {
        public final View view;

        public SettleRunnable(View view, boolean z) {
            this.view = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.viewDragHelper;
            if (viewDragHelper != null && viewDragHelper.continueSettling()) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.postOnAnimation(this.view, this);
            }
        }
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.interceptingEvents = false;
            }
        } else {
            z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = z;
        }
        if (!z) {
            return false;
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = new ViewDragHelper(coordinatorLayout.getContext(), coordinatorLayout, this.dragCallback);
        }
        return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int r4) {
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api16Impl.getImportantForAccessibility(v) == 0) {
            ViewCompat.Api16Impl.setImportantForAccessibility(v, 1);
            ViewCompat.removeActionWithId(Constants.MB, v);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, v);
            if (canSwipeDismissView(v)) {
                ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, new AccessibilityViewCommand() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                    public AnonymousClass2() {
                    }

                    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                    public final boolean perform(View view) {
                        boolean z;
                        SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
                        boolean z2 = false;
                        if (!swipeDismissBehavior.canSwipeDismissView(view)) {
                            return false;
                        }
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                        if (ViewCompat.Api17Impl.getLayoutDirection(view) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        int r0 = swipeDismissBehavior.swipeDirection;
                        if ((r0 == 0 && z) || (r0 == 1 && !z)) {
                            z2 = true;
                        }
                        int width = view.getWidth();
                        if (z2) {
                            width = -width;
                        }
                        view.offsetLeftAndRight(width);
                        view.setAlpha(0.0f);
                        return true;
                    }
                });
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
            return true;
        }
        return false;
    }
}
