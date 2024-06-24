package com.google.android.material.appbar;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat$Api23Impl;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.internal.fitness.zzav;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    public Behavior behavior;
    public int currentOffset;
    public int downPreScrollRange;
    public int downScrollRange;
    public ValueAnimator elevationOverlayAnimator;
    public boolean haveChildWithInterpolator;
    public boolean liftOnScroll;
    public WeakReference<View> liftOnScrollTargetView;
    public int liftOnScrollTargetViewId;
    public boolean liftable;
    public boolean liftableOverride;
    public boolean lifted;
    public int pendingAction;
    public Drawable statusBarForeground;
    public int[] tmpStatesArray;
    public int totalScrollRange;

    /* loaded from: classes3.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        public WeakReference<View> lastNestedScrollingChildRef;
        public int lastStartedType;
        public ValueAnimator offsetAnimator;
        public int offsetDelta;
        public SavedState savedState;

        /* loaded from: classes3.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
            public boolean firstVisibleChildAtMinimumHeight;
            public int firstVisibleChildIndex;
            public float firstVisibleChildPercentageShown;
            public boolean fullyExpanded;
            public boolean fullyScrolled;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState$1, reason: invalid class name */
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
                    return new SavedState(parcel, null);
                }
            }

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                boolean z;
                boolean z2;
                if (parcel.readByte() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.fullyScrolled = z;
                if (parcel.readByte() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.fullyExpanded = z2;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int r3) {
                parcel.writeParcelable(this.mSuperState, r3);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.fullyExpanded ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
        }

        public static View findFirstScrollingChild(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int r1 = 0; r1 < childCount; r1++) {
                View childAt = coordinatorLayout.getChildAt(r1);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void updateAppBarLayoutDrawableState(androidx.coordinatorlayout.widget.CoordinatorLayout r7, com.google.android.material.appbar.AppBarLayout r8, int r9, int r10, boolean r11) {
            /*
                int r0 = java.lang.Math.abs(r9)
                int r1 = r8.getChildCount()
                r2 = 0
                r3 = r2
            La:
                r4 = 0
                if (r3 >= r1) goto L21
                android.view.View r5 = r8.getChildAt(r3)
                int r6 = r5.getTop()
                if (r0 < r6) goto L1e
                int r6 = r5.getBottom()
                if (r0 > r6) goto L1e
                goto L22
            L1e:
                int r3 = r3 + 1
                goto La
            L21:
                r5 = r4
            L22:
                r0 = 1
                if (r5 == 0) goto L5e
                android.view.ViewGroup$LayoutParams r1 = r5.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r1 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r1
                int r1 = r1.scrollFlags
                r3 = r1 & 1
                if (r3 == 0) goto L5e
                java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r3 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
                int r3 = androidx.core.view.ViewCompat.Api16Impl.getMinimumHeight(r5)
                if (r10 <= 0) goto L4b
                r10 = r1 & 12
                if (r10 == 0) goto L4b
                int r9 = -r9
                int r10 = r5.getBottom()
                int r10 = r10 - r3
                int r1 = r8.getTopInset()
                int r10 = r10 - r1
                if (r9 < r10) goto L5e
                goto L5c
            L4b:
                r10 = r1 & 2
                if (r10 == 0) goto L5e
                int r9 = -r9
                int r10 = r5.getBottom()
                int r10 = r10 - r3
                int r1 = r8.getTopInset()
                int r10 = r10 - r1
                if (r9 < r10) goto L5e
            L5c:
                r9 = r0
                goto L5f
            L5e:
                r9 = r2
            L5f:
                boolean r10 = r8.liftOnScroll
                if (r10 == 0) goto L6b
                android.view.View r9 = findFirstScrollingChild(r7)
                boolean r9 = r8.shouldLift(r9)
            L6b:
                boolean r9 = r8.setLiftedState(r9)
                if (r11 != 0) goto Lad
                if (r9 == 0) goto Lb0
                androidx.coordinatorlayout.widget.DirectedAcyclicGraph<android.view.View> r9 = r7.mChildDag
                androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> r9 = r9.mGraph
                java.lang.Object r9 = r9.getOrDefault(r8, r4)
                java.util.List r9 = (java.util.List) r9
                java.util.ArrayList r7 = r7.mTempDependenciesList
                r7.clear()
                if (r9 == 0) goto L87
                r7.addAll(r9)
            L87:
                int r9 = r7.size()
                r10 = r2
            L8c:
                if (r10 >= r9) goto Lab
                java.lang.Object r11 = r7.get(r10)
                android.view.View r11 = (android.view.View) r11
                android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
                androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r11 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r11
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r11 = r11.mBehavior
                boolean r1 = r11 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r1 == 0) goto La8
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r11 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r11
                int r7 = r11.overlayTop
                if (r7 == 0) goto Lab
                r2 = r0
                goto Lab
            La8:
                int r10 = r10 + 1
                goto L8c
            Lab:
                if (r2 == 0) goto Lb0
            Lad:
                r8.jumpDrawablesToCurrentState()
            Lb0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.updateAppBarLayoutDrawableState(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        public final void animateOffsetTo(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int r7) {
            int height;
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - r7);
            float abs2 = Math.abs(0.0f);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            }
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == r7) {
                ValueAnimator valueAnimator = this.offsetAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.offsetAnimator.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.offsetAnimator = valueAnimator3;
                valueAnimator3.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                        int intValue = ((Integer) valueAnimator4.getAnimatedValue()).intValue();
                        BaseBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, intValue);
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.offsetAnimator.setDuration(Math.min(height, 600));
            this.offsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, r7);
            this.offsetAnimator.start();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final boolean canDragView(View view) {
            View view2;
            WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
            if (weakReference != null && ((view2 = weakReference.get()) == null || !view2.isShown() || view2.canScrollVertically(-1))) {
                return false;
            }
            return true;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final int getMaxDragOffset(View view) {
            return -((AppBarLayout) view).getDownNestedScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final int getScrollRangeForDragFling(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public final int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public final void onFlingFinished(View view, CoordinatorLayout coordinatorLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            snapToChildIfNeeded(coordinatorLayout, appBarLayout);
            if (appBarLayout.liftOnScroll) {
                appBarLayout.setLiftedState(appBarLayout.shouldLift(findFirstScrollingChild(coordinatorLayout)));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int r7) {
            boolean z;
            int round;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.onLayoutChild(coordinatorLayout, appBarLayout, r7);
            int pendingAction = appBarLayout.getPendingAction();
            SavedState savedState = this.savedState;
            if (savedState != null && (pendingAction & 8) == 0) {
                if (savedState.fullyScrolled) {
                    setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
                } else if (savedState.fullyExpanded) {
                    setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, 0);
                } else {
                    View childAt = appBarLayout.getChildAt(savedState.firstVisibleChildIndex);
                    int r0 = -childAt.getBottom();
                    if (this.savedState.firstVisibleChildAtMinimumHeight) {
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        round = appBarLayout.getTopInset() + ViewCompat.Api16Impl.getMinimumHeight(childAt) + r0;
                    } else {
                        round = Math.round(childAt.getHeight() * this.savedState.firstVisibleChildPercentageShown) + r0;
                    }
                    setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, round);
                }
            } else if (pendingAction != 0) {
                if ((pendingAction & 4) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if ((pendingAction & 2) != 0) {
                    int r72 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        animateOffsetTo(coordinatorLayout, appBarLayout, r72);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, r72);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        animateOffsetTo(coordinatorLayout, appBarLayout, 0);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.pendingAction = 0;
            this.savedState = null;
            int clamp = MathUtils.clamp(getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), 0);
            ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
            if (viewOffsetHelper != null) {
                if (viewOffsetHelper.offsetTop != clamp) {
                    viewOffsetHelper.offsetTop = clamp;
                    viewOffsetHelper.applyOffsets();
                }
            } else {
                this.tempTopBottomOffset = clamp;
            }
            updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, getTopAndBottomOffset(), 0, true);
            appBarLayout.currentOffset = getTopAndBottomOffset();
            if (!appBarLayout.willNotDraw()) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.postInvalidateOnAnimation(appBarLayout);
            }
            updateAccessibilityActions(coordinatorLayout, appBarLayout);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int r5, int r6, int r7) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.onMeasureChild(appBarLayout, r5, r6, View.MeasureSpec.makeMeasureSpec(0, 0));
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int r10, int r11, int[] r12, int r13) {
            onNestedPreScroll(coordinatorLayout, (AppBarLayout) view, view2, r11, r12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, int r9, int r10, int r11, int[] r12) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (r11 < 0) {
                r12[1] = setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, getTopBottomOffsetForScrollingSibling() - r11, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (r11 == 0) {
                updateAccessibilityActions(coordinatorLayout, appBarLayout);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onRestoreInstanceState(View view, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = this.savedState;
                this.savedState = (SavedState) parcelable;
            } else {
                this.savedState = null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final Parcelable onSaveInstanceState(View view) {
            android.view.AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            SavedState saveScrollState = saveScrollState(absSavedState, (AppBarLayout) view);
            if (saveScrollState != null) {
                return saveScrollState;
            }
            return absSavedState;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:            if (r2 != false) goto L16;     */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r2, android.view.View r3, android.view.View r4, android.view.View r5, int r6, int r7) {
            /*
                r1 = this;
                com.google.android.material.appbar.AppBarLayout r3 = (com.google.android.material.appbar.AppBarLayout) r3
                r5 = r6 & 2
                r6 = 0
                if (r5 == 0) goto L2c
                boolean r5 = r3.liftOnScroll
                r0 = 1
                if (r5 != 0) goto L2b
                int r5 = r3.getTotalScrollRange()
                if (r5 == 0) goto L14
                r5 = r0
                goto L15
            L14:
                r5 = r6
            L15:
                if (r5 == 0) goto L28
                int r2 = r2.getHeight()
                int r4 = r4.getHeight()
                int r2 = r2 - r4
                int r3 = r3.getHeight()
                if (r2 > r3) goto L28
                r2 = r0
                goto L29
            L28:
                r2 = r6
            L29:
                if (r2 == 0) goto L2c
            L2b:
                r6 = r0
            L2c:
                if (r6 == 0) goto L35
                android.animation.ValueAnimator r2 = r1.offsetAnimator
                if (r2 == 0) goto L35
                r2.cancel()
            L35:
                r2 = 0
                r1.lastNestedScrollingChildRef = r2
                r1.lastStartedType = r7
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, android.view.View, int, int):boolean");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int r5) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.lastStartedType == 0 || r5 == 1) {
                snapToChildIfNeeded(coordinatorLayout, appBarLayout);
                if (appBarLayout.liftOnScroll) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view2));
                }
            }
            this.lastNestedScrollingChildRef = new WeakReference<>(view2);
        }

        public final SavedState saveScrollState(Parcelable parcelable, T t) {
            boolean z;
            boolean z2;
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t.getChildCount();
            boolean z3 = false;
            for (int r3 = 0; r3 < childCount; r3++) {
                View childAt = t.getChildAt(r3);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    if (topAndBottomOffset == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    savedState.fullyExpanded = z;
                    if (!z && (-topAndBottomOffset) >= t.getTotalScrollRange()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    savedState.fullyScrolled = z2;
                    savedState.firstVisibleChildIndex = r3;
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    if (bottom == t.getTopInset() + ViewCompat.Api16Impl.getMinimumHeight(childAt)) {
                        z3 = true;
                    }
                    savedState.firstVisibleChildAtMinimumHeight = z3;
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0187  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0189  */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int setHeaderTopBottomOffset(androidx.coordinatorlayout.widget.CoordinatorLayout r19, android.view.View r20, int r21, int r22, int r23) {
            /*
                Method dump skipped, instructions count: 405
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.setHeaderTopBottomOffset(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, T t) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            int paddingTop = t.getPaddingTop() + t.getTopInset();
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling() - paddingTop;
            int childCount = t.getChildCount();
            int r4 = 0;
            while (true) {
                z = true;
                if (r4 < childCount) {
                    View childAt = t.getChildAt(r4);
                    int top = childAt.getTop();
                    int bottom = childAt.getBottom();
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if ((layoutParams.scrollFlags & 32) == 32) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    int r7 = -topBottomOffsetForScrollingSibling;
                    if (top <= r7 && bottom >= r7) {
                        break;
                    } else {
                        r4++;
                    }
                } else {
                    r4 = -1;
                    break;
                }
            }
            if (r4 >= 0) {
                View childAt2 = t.getChildAt(r4);
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                int r8 = layoutParams2.scrollFlags;
                if ((r8 & 17) == 17) {
                    int r9 = -childAt2.getTop();
                    int r10 = -childAt2.getBottom();
                    if (r4 == 0) {
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        if (ViewCompat.Api16Impl.getFitsSystemWindows(t) && ViewCompat.Api16Impl.getFitsSystemWindows(childAt2)) {
                            r9 -= t.getTopInset();
                        }
                    }
                    if ((r8 & 2) == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                        r10 += ViewCompat.Api16Impl.getMinimumHeight(childAt2);
                    } else {
                        if ((r8 & 5) == 5) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                            int minimumHeight = ViewCompat.Api16Impl.getMinimumHeight(childAt2) + r10;
                            if (topBottomOffsetForScrollingSibling < minimumHeight) {
                                r9 = minimumHeight;
                            } else {
                                r10 = minimumHeight;
                            }
                        }
                    }
                    if ((r8 & 32) != 32) {
                        z = false;
                    }
                    if (z) {
                        r9 += ((LinearLayout.LayoutParams) layoutParams2).topMargin;
                        r10 -= ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    }
                    if (topBottomOffsetForScrollingSibling < (r10 + r9) / 2) {
                        r9 = r10;
                    }
                    animateOffsetTo(coordinatorLayout, t, MathUtils.clamp(r9 + paddingTop, -t.getTotalScrollRange(), 0));
                }
            }
        }

        public final void updateAccessibilityActions(final CoordinatorLayout coordinatorLayout, final T t) {
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD;
            ViewCompat.removeActionWithId(accessibilityActionCompat.getId(), coordinatorLayout);
            final boolean z = false;
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, coordinatorLayout);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD;
            ViewCompat.removeActionWithId(accessibilityActionCompat2.getId(), coordinatorLayout);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, coordinatorLayout);
            final View findFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
            if (findFirstScrollingChild == null || t.getTotalScrollRange() == 0 || !(((CoordinatorLayout.LayoutParams) findFirstScrollingChild.getLayoutParams()).mBehavior instanceof ScrollingViewBehavior)) {
                return;
            }
            final boolean z2 = true;
            if (getTopBottomOffsetForScrollingSibling() != (-t.getTotalScrollRange()) && findFirstScrollingChild.canScrollVertically(1)) {
                ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, new AccessibilityViewCommand() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                    public final boolean perform(View view) {
                        AppBarLayout.this.setExpanded(z);
                        return true;
                    }
                });
            }
            if (getTopBottomOffsetForScrollingSibling() != 0) {
                if (findFirstScrollingChild.canScrollVertically(-1)) {
                    final int r9 = -t.getDownNestedPreScrollRange();
                    if (r9 != 0) {
                        ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat2, new AccessibilityViewCommand() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
                            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                            public final boolean perform(View view) {
                                BaseBehavior.this.onNestedPreScroll(coordinatorLayout, t, findFirstScrollingChild, r9, new int[]{0, 0});
                                return true;
                            }
                        });
                        return;
                    }
                    return;
                }
                ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat2, new AccessibilityViewCommand() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                    public final boolean perform(View view) {
                        AppBarLayout.this.setExpanded(z2);
                        return true;
                    }
                });
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int r12, int[] r13) {
            int r0;
            int r1;
            if (r12 != 0) {
                if (r12 < 0) {
                    r0 = -appBarLayout.getTotalScrollRange();
                    r1 = appBarLayout.getDownNestedPreScrollRange() + r0;
                } else {
                    r0 = -appBarLayout.getUpNestedPreScrollRange();
                    r1 = 0;
                }
                int r6 = r0;
                int r7 = r1;
                if (r6 != r7) {
                    r13[1] = setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, getTopBottomOffsetForScrollingSibling() - r12, r6, r7);
                }
            }
            if (appBarLayout.liftOnScroll) {
                appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ChildScrollEffect {
    }

    /* loaded from: classes3.dex */
    public static class CompressChildScrollEffect extends ChildScrollEffect {
        public final Rect relativeRect = new Rect();
        public final Rect ghostRect = new Rect();
    }

    /* loaded from: classes3.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final AppBarLayout findFirstDependency$1(ArrayList arrayList) {
            int size = arrayList.size();
            for (int r1 = 0; r1 < size; r1++) {
                View view = (View) arrayList.get(r1);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final float getOverlapRatioForOffset(View view) {
            int r5;
            int r0;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).mBehavior;
                if (behavior instanceof BaseBehavior) {
                    r5 = ((BaseBehavior) behavior).getTopBottomOffsetForScrollingSibling();
                } else {
                    r5 = 0;
                }
                if ((downNestedPreScrollRange == 0 || totalScrollRange + r5 > downNestedPreScrollRange) && (r0 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (r5 / r0) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final int getScrollRange(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return view.getMeasuredHeight();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean layoutDependsOn(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            int clamp;
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).mBehavior;
            if (behavior instanceof BaseBehavior) {
                int bottom = (view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).offsetDelta + this.verticalLayoutGap;
                if (this.overlayTop == 0) {
                    clamp = 0;
                } else {
                    float overlapRatioForOffset = getOverlapRatioForOffset(view2);
                    int r2 = this.overlayTop;
                    clamp = MathUtils.clamp((int) (overlapRatioForOffset * r2), 0, r2);
                }
                int r0 = bottom - clamp;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                view.offsetTopAndBottom(r0);
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.liftOnScroll) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                ViewCompat.removeActionWithId(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId(), coordinatorLayout);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, coordinatorLayout);
                ViewCompat.removeActionWithId(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId(), coordinatorLayout);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, coordinatorLayout);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayout;
            ArrayList dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            int r2 = 0;
            int r3 = 0;
            while (true) {
                if (r3 < size) {
                    View view2 = (View) dependencies.get(r3);
                    if (view2 instanceof AppBarLayout) {
                        appBarLayout = (AppBarLayout) view2;
                        break;
                    }
                    r3++;
                } else {
                    appBarLayout = null;
                    break;
                }
            }
            if (appBarLayout != null) {
                rect.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect2 = this.tempRect1;
                rect2.set(0, 0, width, height);
                if (!rect2.contains(rect)) {
                    if (!z) {
                        r2 = 4;
                    }
                    appBarLayout.pendingAction = 2 | r2 | 8;
                    appBarLayout.requestLayout();
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            this.overlayTop = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        if (this.statusBarForeground != null && getTopInset() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.currentOffset);
            this.statusBarForeground.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarForeground;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.behavior = behavior;
        return behavior;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getDownNestedPreScrollRange() {
        /*
            r9 = this;
            int r0 = r9.downPreScrollRange
            r1 = -1
            if (r0 == r1) goto L6
            return r0
        L6:
            int r0 = r9.getChildCount()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        Le:
            if (r0 < 0) goto L60
            android.view.View r3 = r9.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$LayoutParams r4 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r4
            int r5 = r3.getMeasuredHeight()
            int r6 = r4.scrollFlags
            r7 = r6 & 5
            r8 = 5
            if (r7 != r8) goto L5a
            int r7 = r4.topMargin
            int r4 = r4.bottomMargin
            int r7 = r7 + r4
            r4 = r6 & 8
            if (r4 == 0) goto L36
            java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r4 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
            int r4 = androidx.core.view.ViewCompat.Api16Impl.getMinimumHeight(r3)
        L34:
            int r4 = r4 + r7
            goto L45
        L36:
            r4 = r6 & 2
            if (r4 == 0) goto L43
            java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r4 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
            int r4 = androidx.core.view.ViewCompat.Api16Impl.getMinimumHeight(r3)
            int r4 = r5 - r4
            goto L34
        L43:
            int r4 = r7 + r5
        L45:
            if (r0 != 0) goto L58
            java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r6 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
            boolean r3 = androidx.core.view.ViewCompat.Api16Impl.getFitsSystemWindows(r3)
            if (r3 == 0) goto L58
            int r3 = r9.getTopInset()
            int r5 = r5 - r3
            int r4 = java.lang.Math.min(r4, r5)
        L58:
            int r2 = r2 + r4
            goto L5d
        L5a:
            if (r2 <= 0) goto L5d
            goto L60
        L5d:
            int r0 = r0 + (-1)
            goto Le
        L60:
            int r0 = java.lang.Math.max(r1, r2)
            r9.downPreScrollRange = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.getDownNestedPreScrollRange():int");
    }

    public int getDownNestedScrollRange() {
        int r0 = this.downScrollRange;
        if (r0 != -1) {
            return r0;
        }
        int childCount = getChildCount();
        int r2 = 0;
        int r3 = 0;
        while (true) {
            if (r2 >= childCount) {
                break;
            }
            View childAt = getChildAt(r2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
            int r5 = layoutParams.scrollFlags;
            if ((r5 & 1) == 0) {
                break;
            }
            r3 += measuredHeight;
            if ((r5 & 2) != 0) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                r3 -= ViewCompat.Api16Impl.getMinimumHeight(childAt);
                break;
            }
            r2++;
        }
        int max = Math.max(0, r3);
        this.downScrollRange = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int minimumHeight = ViewCompat.Api16Impl.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            if (childCount >= 1) {
                minimumHeight = ViewCompat.Api16Impl.getMinimumHeight(getChildAt(childCount - 1));
            } else {
                minimumHeight = 0;
            }
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.pendingAction;
    }

    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        return 0;
    }

    public final int getTotalScrollRange() {
        int r0 = this.totalScrollRange;
        if (r0 != -1) {
            return r0;
        }
        int childCount = getChildCount();
        int r2 = 0;
        int r3 = 0;
        while (true) {
            if (r2 >= childCount) {
                break;
            }
            View childAt = getChildAt(r2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int r7 = layoutParams.scrollFlags;
            if ((r7 & 1) == 0) {
                break;
            }
            int r6 = measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + r3;
            if (r2 == 0) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (ViewCompat.Api16Impl.getFitsSystemWindows(childAt)) {
                    r6 -= getTopInset();
                }
            }
            r3 = r6;
            if ((r7 & 2) != 0) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                r3 -= ViewCompat.Api16Impl.getMinimumHeight(childAt);
                break;
            }
            r2++;
        }
        int max = Math.max(0, r3);
        this.totalScrollRange = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void invalidateScrollRanges() {
        BaseBehavior.SavedState savedState;
        Behavior behavior = this.behavior;
        if (behavior != null && this.totalScrollRange != -1 && this.pendingAction == 0) {
            savedState = behavior.saveScrollState(AbsSavedState.EMPTY_STATE, this);
        } else {
            savedState = null;
        }
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        if (savedState != null) {
            Behavior behavior2 = this.behavior;
            if (behavior2.savedState == null) {
                behavior2.savedState = savedState;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            zzav.setParentAbsoluteElevation(this, (MaterialShapeDrawable) background);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r5) {
        int r2;
        int r22;
        int r23;
        int r1;
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] r0 = this.tmpStatesArray;
        int[] onCreateDrawableState = super.onCreateDrawableState(r5 + r0.length);
        boolean z = this.liftable;
        if (z) {
            r2 = R.attr.state_liftable;
        } else {
            r2 = -2130969600;
        }
        r0[0] = r2;
        if (z && this.lifted) {
            r22 = R.attr.state_lifted;
        } else {
            r22 = -2130969601;
        }
        r0[1] = r22;
        if (z) {
            r23 = R.attr.state_collapsible;
        } else {
            r23 = -2130969598;
        }
        r0[2] = r23;
        if (z && this.lifted) {
            r1 = R.attr.state_collapsed;
        } else {
            r1 = -2130969597;
        }
        r0[3] = r1;
        return View.mergeDrawableStates(onCreateDrawableState, r0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.liftOnScrollTargetView = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r3, int r4, int r5, int r6) {
        boolean z2;
        boolean z3;
        super.onLayout(z, r3, r4, r5, r6);
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean z4 = true;
        if (ViewCompat.Api16Impl.getFitsSystemWindows(this) && shouldOffsetFirstChild()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                getChildAt(childCount).offsetTopAndBottom(topInset);
            }
        }
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int childCount2 = getChildCount();
        int r52 = 0;
        while (true) {
            if (r52 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(r52).getLayoutParams()).scrollInterpolator != null) {
                this.haveChildWithInterpolator = true;
                break;
            }
            r52++;
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.liftableOverride) {
            if (!this.liftOnScroll) {
                int childCount3 = getChildCount();
                int r53 = 0;
                while (true) {
                    if (r53 < childCount3) {
                        int r62 = ((LayoutParams) getChildAt(r53).getLayoutParams()).scrollFlags;
                        if ((r62 & 1) == 1 && (r62 & 10) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            z2 = true;
                            break;
                        }
                        r53++;
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (!z2) {
                    z4 = false;
                }
            }
            if (this.liftable != z4) {
                this.liftable = z4;
                refreshDrawableState();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        int mode = View.MeasureSpec.getMode(r4);
        if (mode != 1073741824) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api16Impl.getFitsSystemWindows(this) && shouldOffsetFirstChild()) {
                int measuredHeight = getMeasuredHeight();
                if (mode != Integer.MIN_VALUE) {
                    if (mode == 0) {
                        measuredHeight += getTopInset();
                    }
                } else {
                    measuredHeight = MathUtils.clamp(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(r4));
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        invalidateScrollRanges();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).setElevation(f);
        }
    }

    public void setExpanded(boolean z) {
        int r2;
        int r0;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean isLaidOut = ViewCompat.Api19Impl.isLaidOut(this);
        if (z) {
            r2 = 1;
        } else {
            r2 = 2;
        }
        if (isLaidOut) {
            r0 = 4;
        } else {
            r0 = 0;
        }
        this.pendingAction = r2 | r0 | 8;
        requestLayout();
    }

    public void setLiftOnScroll(boolean z) {
        this.liftOnScroll = z;
    }

    public void setLiftOnScrollTargetViewId(int r1) {
        this.liftOnScrollTargetViewId = r1;
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.liftOnScrollTargetView = null;
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.liftableOverride = z;
    }

    public final boolean setLiftedState(boolean z) {
        float f;
        if (!(!this.liftableOverride) || this.lifted == z) {
            return false;
        }
        this.lifted = z;
        refreshDrawableState();
        if (!this.liftOnScroll || !(getBackground() instanceof MaterialShapeDrawable)) {
            return true;
        }
        final MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        if (z) {
            f = 0.0f;
        } else {
            f = dimension;
        }
        if (!z) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.elevationOverlayAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, dimension);
        this.elevationOverlayAnimator = ofFloat;
        ofFloat.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.elevationOverlayAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.elevationOverlayAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                materialShapeDrawable.setElevation(floatValue);
                AppBarLayout appBarLayout = AppBarLayout.this;
                Drawable drawable = appBarLayout.statusBarForeground;
                if (drawable instanceof MaterialShapeDrawable) {
                    ((MaterialShapeDrawable) drawable).setElevation(floatValue);
                }
                appBarLayout.getClass();
                throw null;
            }
        });
        this.elevationOverlayAnimator.start();
        return true;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r2) {
        if (r2 == 1) {
            super.setOrientation(r2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        boolean z;
        Drawable drawable2 = this.statusBarForeground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.statusBarForeground = drawable3;
            boolean z2 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.statusBarForeground.setState(getDrawableState());
                }
                Drawable drawable4 = this.statusBarForeground;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                DrawableCompat$Api23Impl.setLayoutDirection(drawable4, ViewCompat.Api17Impl.getLayoutDirection(this));
                Drawable drawable5 = this.statusBarForeground;
                if (getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                drawable5.setVisible(z, false);
                this.statusBarForeground.setCallback(this);
            }
            if (this.statusBarForeground != null && getTopInset() > 0) {
                z2 = true;
            }
            setWillNotDraw(!z2);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(int r2) {
        setStatusBarForeground(new ColorDrawable(r2));
    }

    public void setStatusBarForegroundResource(int r2) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), r2));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        int integer = getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{android.R.attr.state_enabled, R.attr.state_liftable, -2130969601}, ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{android.R.attr.state_enabled}, ObjectAnimator.ofFloat(this, "elevation", f).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(0L));
        setStateListAnimator(stateListAnimator);
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
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    public final boolean shouldLift(View view) {
        int r0;
        View view2;
        View view3 = null;
        if (this.liftOnScrollTargetView == null && (r0 = this.liftOnScrollTargetViewId) != -1) {
            if (view != null) {
                view2 = view.findViewById(r0);
            } else {
                view2 = null;
            }
            if (view2 == null && (getParent() instanceof ViewGroup)) {
                view2 = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
            }
            if (view2 != null) {
                this.liftOnScrollTargetView = new WeakReference<>(view2);
            }
        }
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            view3 = weakReference.get();
        }
        if (view3 != null) {
            view = view3;
        }
        if (view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0)) {
            return true;
        }
        return false;
    }

    public final boolean shouldOffsetFirstChild() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8) {
            return false;
        }
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api16Impl.getFitsSystemWindows(childAt)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.statusBarForeground) {
            return false;
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public ChildScrollEffect scrollEffect;
        public final int scrollFlags;
        public final Interpolator scrollInterpolator;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.scrollFlags = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.scrollFlags = obtainStyledAttributes.getInt(1, 0);
            this.scrollEffect = obtainStyledAttributes.getInt(0, 0) != 1 ? null : new CompressChildScrollEffect();
            if (obtainStyledAttributes.hasValue(2)) {
                this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(2, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -2);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }
    }
}
