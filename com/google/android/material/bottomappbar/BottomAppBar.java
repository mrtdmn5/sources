package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.internal.fitness.zzav;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    public static final /* synthetic */ int $r8$clinit = 0;
    public Behavior behavior;
    public int fabAlignmentMode;
    public int fabAnimationMode;
    public boolean fabAttached;
    public boolean hideOnScroll;
    public Animator menuAnimator;
    public Animator modeAnimator;
    public Integer navigationIconTint;
    public int pendingMenuResId;

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public int fabAlignmentMode;
        public boolean fabAttached;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$SavedState$1, reason: invalid class name */
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
            this.fabAlignmentMode = parcel.readInt();
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.fabAttached = z;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r3) {
            parcel.writeParcelable(this.mSuperState, r3);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int r0 = 0; r0 < getChildCount(); r0++) {
            View childAt = getChildAt(r0);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private int getBottomInset() {
        return 0;
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().cradleVerticalOffset;
    }

    private int getLeftInset() {
        return 0;
    }

    private int getRightInset() {
        return 0;
    }

    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        throw null;
    }

    public final View findDependentView() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) getParent();
        ArrayList<View> orDefault = coordinatorLayout.mChildDag.mGraph.getOrDefault(this, null);
        ArrayList arrayList = coordinatorLayout.mTempDependenciesList;
        arrayList.clear();
        if (orDefault != null) {
            arrayList.addAll(orDefault);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public final int getActionMenuViewTranslationX(ActionMenuView actionMenuView, int r8, boolean z) {
        int r9;
        int left;
        boolean z2;
        if (r8 != 1 || !z) {
            return 0;
        }
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (isLayoutRtl) {
            r9 = getMeasuredWidth();
        } else {
            r9 = 0;
        }
        for (int r2 = 0; r2 < getChildCount(); r2++) {
            View childAt = getChildAt(r2);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & 8388615) == 8388611) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (isLayoutRtl) {
                    r9 = Math.min(r9, childAt.getLeft());
                } else {
                    r9 = Math.max(r9, childAt.getRight());
                }
            }
        }
        if (isLayoutRtl) {
            left = actionMenuView.getRight();
        } else {
            left = actionMenuView.getLeft();
        }
        return r9 - (left + 0);
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().cradleVerticalOffset;
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().roundedCornerRadius;
    }

    public final float getFabTranslationX(int r3) {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (r3 == 1) {
            return ((getMeasuredWidth() / 2) + 0) * (isLayoutRtl ? -1 : 1);
        }
        return 0.0f;
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        zzav.setParentAbsoluteElevation(this, null);
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
        boolean z2;
        super.onLayout(z, r2, r3, r4, r5);
        FloatingActionButton floatingActionButton = null;
        if (z) {
            Animator animator = this.menuAnimator;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.modeAnimator;
            if (animator2 != null) {
                animator2.cancel();
            }
            setCutoutState();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.menuAnimator == null) {
            actionMenuView.setAlpha(1.0f);
            View findDependentView = findDependentView();
            if (findDependentView instanceof FloatingActionButton) {
                floatingActionButton = (FloatingActionButton) findDependentView;
            }
            if (floatingActionButton != null && floatingActionButton.isOrWillBeShown()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                translateActionMenuView(actionMenuView, 0, false, false);
            } else {
                translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached, false);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        this.fabAlignmentMode = savedState.fabAlignmentMode;
        this.fabAttached = savedState.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        DrawableCompat$Api21Impl.setTintList(null, colorStateList);
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            BottomAppBarTopEdgeTreatment topEdgeTreatment = getTopEdgeTreatment();
            if (f >= 0.0f) {
                topEdgeTreatment.cradleVerticalOffset = f;
                throw null;
            }
            topEdgeTreatment.getClass();
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
    }

    public final void setCutoutState() {
        FloatingActionButton floatingActionButton;
        BottomAppBarTopEdgeTreatment topEdgeTreatment = getTopEdgeTreatment();
        getFabTranslationX();
        topEdgeTreatment.getClass();
        findDependentView();
        if (this.fabAttached) {
            View findDependentView = findDependentView();
            if (findDependentView instanceof FloatingActionButton) {
                floatingActionButton = (FloatingActionButton) findDependentView;
            } else {
                floatingActionButton = null;
            }
            if (floatingActionButton != null) {
                floatingActionButton.isOrWillBeShown();
                throw null;
            }
            throw null;
        }
        throw null;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.material.bottomappbar.BottomAppBar$5] */
    public void setFabAlignmentMode(final int r13) {
        FloatingActionButton floatingActionButton;
        boolean z;
        final int r5;
        this.pendingMenuResId = 0;
        final boolean z2 = this.fabAttached;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        FloatingActionButton floatingActionButton2 = 0;
        FloatingActionButton floatingActionButton3 = null;
        if (!ViewCompat.Api19Impl.isLaidOut(this)) {
            int r1 = this.pendingMenuResId;
            if (r1 != 0) {
                this.pendingMenuResId = 0;
                getMenu().clear();
                inflateMenu(r1);
            }
        } else {
            Animator animator = this.menuAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            View findDependentView = findDependentView();
            if (findDependentView instanceof FloatingActionButton) {
                floatingActionButton = (FloatingActionButton) findDependentView;
            } else {
                floatingActionButton = null;
            }
            if (floatingActionButton != null && floatingActionButton.isOrWillBeShown()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                z2 = false;
                r5 = 0;
            } else {
                r5 = r13;
            }
            final ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                if (Math.abs(actionMenuView.getTranslationX() - getActionMenuViewTranslationX(actionMenuView, r5, z2)) > 1.0f) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.7
                        public boolean cancelled;

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationCancel(Animator animator2) {
                            this.cancelled = true;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator2) {
                            boolean z3;
                            if (!this.cancelled) {
                                BottomAppBar bottomAppBar = BottomAppBar.this;
                                int r0 = bottomAppBar.pendingMenuResId;
                                if (r0 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (r0 != 0) {
                                    bottomAppBar.pendingMenuResId = 0;
                                    bottomAppBar.getMenu().clear();
                                    bottomAppBar.inflateMenu(r0);
                                }
                                bottomAppBar.translateActionMenuView(actionMenuView, r5, z2, z3);
                            }
                        }
                    });
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(150L);
                    animatorSet.playSequentially(ofFloat2, ofFloat);
                    arrayList.add(animatorSet);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList.add(ofFloat);
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList);
            this.menuAnimator = animatorSet2;
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    BottomAppBar bottomAppBar = BottomAppBar.this;
                    bottomAppBar.getClass();
                    bottomAppBar.menuAnimator = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator2) {
                    BottomAppBar.this.getClass();
                }
            });
            this.menuAnimator.start();
        }
        if (this.fabAlignmentMode != r13 && ViewCompat.Api19Impl.isLaidOut(this)) {
            Animator animator2 = this.modeAnimator;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (this.fabAnimationMode == 1) {
                View findDependentView2 = findDependentView();
                if (findDependentView2 instanceof FloatingActionButton) {
                    floatingActionButton3 = (FloatingActionButton) findDependentView2;
                }
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(floatingActionButton3, "translationX", getFabTranslationX(r13));
                ofFloat3.setDuration(300L);
                arrayList2.add(ofFloat3);
            } else {
                View findDependentView3 = findDependentView();
                if (findDependentView3 instanceof FloatingActionButton) {
                    floatingActionButton2 = (FloatingActionButton) findDependentView3;
                }
                if (floatingActionButton2 != 0 && !floatingActionButton2.isOrWillBeHidden()) {
                    floatingActionButton2.hide(new FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.material.bottomappbar.BottomAppBar$5$1] */
                        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                        public final void onHidden(FloatingActionButton floatingActionButton4) {
                            floatingActionButton4.setTranslationX(BottomAppBar.this.getFabTranslationX(r13));
                            floatingActionButton4.show(new FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5.1
                                @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                                public final void onShown() {
                                    BottomAppBar bottomAppBar = BottomAppBar.this;
                                    int r12 = BottomAppBar.$r8$clinit;
                                    bottomAppBar.getClass();
                                }
                            }, true);
                        }
                    }, true);
                }
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            this.modeAnimator = animatorSet3;
            animatorSet3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator3) {
                    BottomAppBar bottomAppBar = BottomAppBar.this;
                    bottomAppBar.getClass();
                    bottomAppBar.modeAnimator = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator3) {
                    BottomAppBar.this.getClass();
                }
            });
            this.modeAnimator.start();
        }
        this.fabAlignmentMode = r13;
    }

    public void setFabAnimationMode(int r1) {
        this.fabAnimationMode = r1;
    }

    public void setFabCornerSize(float f) {
        if (f == getTopEdgeTreatment().fabCornerSize) {
            return;
        }
        getTopEdgeTreatment().fabCornerSize = f;
        throw null;
    }

    public void setFabCradleMargin(float f) {
        if (f == getFabCradleMargin()) {
            return;
        }
        getTopEdgeTreatment().fabMargin = f;
        throw null;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f == getFabCradleRoundedCornerRadius()) {
            return;
        }
        getTopEdgeTreatment().roundedCornerRadius = f;
        throw null;
    }

    public void setHideOnScroll(boolean z) {
        this.hideOnScroll = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.navigationIconTint != null) {
            drawable = drawable.mutate();
            DrawableCompat$Api21Impl.setTint(drawable, this.navigationIconTint.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int r1) {
        this.navigationIconTint = Integer.valueOf(r1);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public final void translateActionMenuView(final ActionMenuView actionMenuView, final int r3, final boolean z, boolean z2) {
        Runnable runnable = new Runnable() { // from class: com.google.android.material.bottomappbar.BottomAppBar.8
            @Override // java.lang.Runnable
            public final void run() {
                int r0 = r3;
                boolean z3 = z;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                actionMenuView.setTranslationX(bottomAppBar.getActionMenuViewTranslationX(r3, r0, z3));
            }
        };
        if (z2) {
            actionMenuView.post(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new Behavior();
        }
        return this.behavior;
    }

    /* loaded from: classes3.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final Rect fabContentRect;
        public final AnonymousClass1 fabLayoutListener;
        public WeakReference<BottomAppBar> viewRef;

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.material.bottomappbar.BottomAppBar$Behavior$1] */
        public Behavior() {
            this.fabLayoutListener = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                    Behavior behavior = Behavior.this;
                    if (behavior.viewRef.get() != null && (view instanceof FloatingActionButton)) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                        behavior.fabContentRect.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                        throw null;
                    }
                    view.removeOnLayoutChangeListener(this);
                }
            };
            this.fabContentRect = new Rect();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v9, types: [com.google.android.material.bottomappbar.BottomAppBar$9] */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int r5) {
            final BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.viewRef = new WeakReference<>(bottomAppBar);
            int r0 = BottomAppBar.$r8$clinit;
            View findDependentView = bottomAppBar.findDependentView();
            if (findDependentView != null) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (!ViewCompat.Api19Impl.isLaidOut(findDependentView)) {
                    ((CoordinatorLayout.LayoutParams) findDependentView.getLayoutParams()).anchorGravity = 49;
                    if (findDependentView instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) findDependentView;
                        if (floatingActionButton.getShowMotionSpec() == null) {
                            floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                        }
                        if (floatingActionButton.getHideMotionSpec() == null) {
                            floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                        }
                        floatingActionButton.addOnLayoutChangeListener(this.fabLayoutListener);
                        floatingActionButton.addOnHideAnimationListener();
                        floatingActionButton.addOnShowAnimationListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.9
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationStart(Animator animator) {
                                BottomAppBar.this.getClass();
                                throw null;
                            }
                        });
                        floatingActionButton.addTransformationCallback();
                    }
                    bottomAppBar.setCutoutState();
                    throw null;
                }
            }
            coordinatorLayout.onLayoutChild(r5, bottomAppBar);
            super.onLayoutChild(coordinatorLayout, bottomAppBar, r5);
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int r12, int r13) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            if (bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view2, view3, r12, r13)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.material.bottomappbar.BottomAppBar$Behavior$1] */
        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.fabLayoutListener = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                    Behavior behavior = Behavior.this;
                    if (behavior.viewRef.get() != null && (view instanceof FloatingActionButton)) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                        behavior.fabContentRect.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                        throw null;
                    }
                    view.removeOnLayoutChangeListener(this);
                }
            };
            this.fabContentRect = new Rect();
        }
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
