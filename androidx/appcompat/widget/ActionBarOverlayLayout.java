package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent2, NestedScrollingParent3 {
    public static final int[] ATTRS = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public int mActionBarHeight;
    public ActionBarContainer mActionBarTop;
    public ActionBarVisibilityCallback mActionBarVisibilityCallback;
    public final AnonymousClass3 mAddActionBarHideOffset;
    public boolean mAnimatingForFling;
    public final Rect mBaseContentInsets;
    public WindowInsetsCompat mBaseInnerInsets;
    public ContentFrameLayout mContent;
    public final Rect mContentInsets;
    public ViewPropertyAnimator mCurrentActionBarTopAnimator;
    public DecorToolbar mDecorToolbar;
    public OverScroller mFlingEstimator;
    public boolean mHasNonEmbeddedTabs;
    public boolean mHideOnContentScroll;
    public int mHideOnContentScrollReference;
    public boolean mIgnoreWindowContentOverlay;
    public WindowInsetsCompat mInnerInsets;
    public final Rect mLastBaseContentInsets;
    public WindowInsetsCompat mLastBaseInnerInsets;
    public WindowInsetsCompat mLastInnerInsets;
    public int mLastSystemUiVisibility;
    public boolean mOverlayMode;
    public final NestedScrollingParentHelper mParentHelper;
    public final AnonymousClass2 mRemoveActionBarHideOffset;
    public final AnonymousClass1 mTopAnimatorListener;
    public Drawable mWindowContentOverlay;
    public int mWindowVisibility;

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.haltActionBarHideOffsetAnimations();
            actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(0.0f).setListener(actionBarOverlayLayout.mTopAnimatorListener);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.haltActionBarHideOffsetAnimations();
            actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(-actionBarOverlayLayout.mActionBarTop.getHeight()).setListener(actionBarOverlayLayout.mTopAnimatorListener);
        }
    }

    /* loaded from: classes.dex */
    public interface ActionBarVisibilityCallback {
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams() {
            super(-1, -1);
        }
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.appcompat.widget.ActionBarOverlayLayout$1] */
    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.CONSUMED;
        this.mBaseInnerInsets = windowInsetsCompat;
        this.mLastBaseInnerInsets = windowInsetsCompat;
        this.mInnerInsets = windowInsetsCompat;
        this.mLastInnerInsets = windowInsetsCompat;
        this.mTopAnimatorListener = new AnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                actionBarOverlayLayout.mAnimatingForFling = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                actionBarOverlayLayout.mAnimatingForFling = false;
            }
        };
        this.mRemoveActionBarHideOffset = new AnonymousClass2();
        this.mAddActionBarHideOffset = new AnonymousClass3();
        init(context);
        this.mParentHelper = new NestedScrollingParentHelper();
    }

    public static boolean applyInsets(FrameLayout frameLayout, Rect rect, boolean z) {
        boolean z2;
        LayoutParams layoutParams = (LayoutParams) frameLayout.getLayoutParams();
        int r0 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        int r1 = rect.left;
        if (r0 != r1) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = r1;
            z2 = true;
        } else {
            z2 = false;
        }
        int r12 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        int r3 = rect.top;
        if (r12 != r3) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = r3;
            z2 = true;
        }
        int r13 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int r32 = rect.right;
        if (r13 != r32) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = r32;
            z2 = true;
        }
        if (z) {
            int r6 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int r5 = rect.bottom;
            if (r6 != r5) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = r5;
                return true;
            }
        }
        return z2;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final boolean canShowOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final void dismissPopups() {
        pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int r0;
        super.draw(canvas);
        if (this.mWindowContentOverlay != null && !this.mIgnoreWindowContentOverlay) {
            if (this.mActionBarTop.getVisibility() == 0) {
                r0 = (int) (this.mActionBarTop.getTranslationY() + this.mActionBarTop.getBottom() + 0.5f);
            } else {
                r0 = 0;
            }
            this.mWindowContentOverlay.setBounds(0, r0, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + r0);
            this.mWindowContentOverlay.draw(canvas);
        }
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.mActionBarTop;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mParentHelper;
        return nestedScrollingParentHelper.mNestedScrollAxesNonTouch | nestedScrollingParentHelper.mNestedScrollAxesTouch;
    }

    public CharSequence getTitle() {
        pullChildren();
        return this.mDecorToolbar.getTitle();
    }

    public final void haltActionBarHideOffsetAnimations() {
        removeCallbacks(this.mRemoveActionBarHideOffset);
        removeCallbacks(this.mAddActionBarHideOffset);
        ViewPropertyAnimator viewPropertyAnimator = this.mCurrentActionBarTopAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final boolean hideOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public final void init(Context context) {
        boolean z;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(ATTRS);
        boolean z2 = false;
        this.mActionBarHeight = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.mWindowContentOverlay = drawable;
        if (drawable == null) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.mIgnoreWindowContentOverlay = z2;
        this.mFlingEstimator = new OverScroller(context);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final void initFeature(int r2) {
        pullChildren();
        if (r2 != 2) {
            if (r2 != 5) {
                if (r2 == 109) {
                    setOverlayMode(true);
                    return;
                }
                return;
            }
            this.mDecorToolbar.initIndeterminateProgress();
            return;
        }
        this.mDecorToolbar.initProgress();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final boolean isOverflowMenuShowPending() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final boolean isOverflowMenuShowing() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        pullChildren();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this, windowInsets);
        boolean applyInsets = applyInsets(this.mActionBarTop, new Rect(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom()), false);
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        Rect rect = this.mBaseContentInsets;
        ViewCompat.Api21Impl.computeSystemWindowInsets(this, windowInsetsCompat, rect);
        int r2 = rect.left;
        int r3 = rect.top;
        int r4 = rect.right;
        int r5 = rect.bottom;
        WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
        WindowInsetsCompat inset = impl.inset(r2, r3, r4, r5);
        this.mBaseInnerInsets = inset;
        boolean z = true;
        if (!this.mLastBaseInnerInsets.equals(inset)) {
            this.mLastBaseInnerInsets = this.mBaseInnerInsets;
            applyInsets = true;
        }
        Rect rect2 = this.mLastBaseContentInsets;
        if (!rect2.equals(rect)) {
            rect2.set(rect);
        } else {
            z = applyInsets;
        }
        if (z) {
            requestLayout();
        }
        return impl.consumeDisplayCutout().mImpl.consumeSystemWindowInsets().mImpl.consumeStableInsets().toWindowInsets();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        init(getContext());
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api20Impl.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r6, int r7, int r8, int r9) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int r82 = 0; r82 < childCount; r82++) {
            View childAt = getChildAt(r82);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int r3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int r0 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(r3, r0, measuredWidth + r3, measuredHeight + r0);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int r12, int r13) {
        boolean z;
        int measuredHeight;
        WindowInsetsCompat.BuilderImpl builderImpl20;
        pullChildren();
        measureChildWithMargins(this.mActionBarTop, r12, 0, r13, 0);
        LayoutParams layoutParams = (LayoutParams) this.mActionBarTop.getLayoutParams();
        int max = Math.max(0, this.mActionBarTop.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int max2 = Math.max(0, this.mActionBarTop.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if ((ViewCompat.Api16Impl.getWindowSystemUiVisibility(this) & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            measuredHeight = this.mActionBarHeight;
            if (this.mHasNonEmbeddedTabs && this.mActionBarTop.getTabContainer() != null) {
                measuredHeight += this.mActionBarHeight;
            }
        } else {
            measuredHeight = this.mActionBarTop.getVisibility() != 8 ? this.mActionBarTop.getMeasuredHeight() : 0;
        }
        Rect rect = this.mBaseContentInsets;
        Rect rect2 = this.mContentInsets;
        rect2.set(rect);
        WindowInsetsCompat windowInsetsCompat = this.mBaseInnerInsets;
        this.mInnerInsets = windowInsetsCompat;
        if (!this.mOverlayMode && !z) {
            rect2.top += measuredHeight;
            rect2.bottom += 0;
            this.mInnerInsets = windowInsetsCompat.mImpl.inset(0, measuredHeight, 0, 0);
        } else {
            Insets of = Insets.of(windowInsetsCompat.getSystemWindowInsetLeft(), this.mInnerInsets.getSystemWindowInsetTop() + measuredHeight, this.mInnerInsets.getSystemWindowInsetRight(), this.mInnerInsets.getSystemWindowInsetBottom() + 0);
            WindowInsetsCompat windowInsetsCompat2 = this.mInnerInsets;
            int r6 = Build.VERSION.SDK_INT;
            if (r6 >= 30) {
                builderImpl20 = new WindowInsetsCompat.BuilderImpl30(windowInsetsCompat2);
            } else if (r6 >= 29) {
                builderImpl20 = new WindowInsetsCompat.BuilderImpl29(windowInsetsCompat2);
            } else {
                builderImpl20 = new WindowInsetsCompat.BuilderImpl20(windowInsetsCompat2);
            }
            builderImpl20.setSystemWindowInsets(of);
            this.mInnerInsets = builderImpl20.build();
        }
        applyInsets(this.mContent, rect2, true);
        if (!this.mLastInnerInsets.equals(this.mInnerInsets)) {
            WindowInsetsCompat windowInsetsCompat3 = this.mInnerInsets;
            this.mLastInnerInsets = windowInsetsCompat3;
            ViewCompat.dispatchApplyWindowInsets(this.mContent, windowInsetsCompat3);
        }
        measureChildWithMargins(this.mContent, r12, 0, r13, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.mContent.getLayoutParams();
        int max3 = Math.max(max, this.mContent.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int max4 = Math.max(max2, this.mContent.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.mContent.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), r12, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), r13, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.mHideOnContentScroll || !z) {
            return false;
        }
        this.mFlingEstimator.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight()) {
            z2 = true;
        }
        if (z2) {
            haltActionBarHideOffsetAnimations();
            this.mAddActionBarHideOffset.run();
        } else {
            haltActionBarHideOffsetAnimations();
            this.mRemoveActionBarHideOffset.run();
        }
        this.mAnimatingForFling = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int r2, int r3, int[] r4) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View view, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        onNestedScroll(view, r2, r3, r4, r5, r6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int r3) {
        WindowDecorActionBar windowDecorActionBar;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mParentHelper.mNestedScrollAxesTouch = r3;
        this.mHideOnContentScrollReference = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback == null || (viewPropertyAnimatorCompatSet = (windowDecorActionBar = (WindowDecorActionBar) actionBarVisibilityCallback).mCurrentShowAnim) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.cancel();
        windowDecorActionBar.mCurrentShowAnim = null;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View view, View view2, int r3, int r4) {
        return r4 == 0 && onStartNestedScroll(view, view2, r3);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View view, int r2) {
        if (r2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    @Deprecated
    public final void onWindowSystemUiVisibilityChanged(int r8) {
        boolean z;
        boolean z2;
        super.onWindowSystemUiVisibilityChanged(r8);
        pullChildren();
        int r0 = this.mLastSystemUiVisibility ^ r8;
        this.mLastSystemUiVisibility = r8;
        if ((r8 & 4) == 0) {
            z = true;
        } else {
            z = false;
        }
        if ((r8 & 256) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            ((WindowDecorActionBar) actionBarVisibilityCallback).mContentAnimations = !z2;
            if (!z && z2) {
                WindowDecorActionBar windowDecorActionBar = (WindowDecorActionBar) actionBarVisibilityCallback;
                if (!windowDecorActionBar.mHiddenBySystem) {
                    windowDecorActionBar.mHiddenBySystem = true;
                    windowDecorActionBar.updateVisibility(true);
                }
            } else {
                WindowDecorActionBar windowDecorActionBar2 = (WindowDecorActionBar) actionBarVisibilityCallback;
                if (windowDecorActionBar2.mHiddenBySystem) {
                    windowDecorActionBar2.mHiddenBySystem = false;
                    windowDecorActionBar2.updateVisibility(true);
                }
            }
        }
        if ((r0 & 256) != 0 && this.mActionBarVisibilityCallback != null) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api20Impl.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r2) {
        super.onWindowVisibilityChanged(r2);
        this.mWindowVisibility = r2;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            ((WindowDecorActionBar) actionBarVisibilityCallback).mCurWindowVisibility = r2;
        }
    }

    public final void pullChildren() {
        DecorToolbar wrapper;
        if (this.mContent == null) {
            this.mContent = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.mActionBarTop = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback findViewById = findViewById(R.id.action_bar);
            if (findViewById instanceof DecorToolbar) {
                wrapper = (DecorToolbar) findViewById;
            } else if (findViewById instanceof Toolbar) {
                wrapper = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
            }
            this.mDecorToolbar = wrapper;
        }
    }

    public void setActionBarHideOffset(int r3) {
        haltActionBarHideOffsetAnimations();
        this.mActionBarTop.setTranslationY(-Math.max(0, Math.min(r3, this.mActionBarTop.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.mActionBarVisibilityCallback = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            ((WindowDecorActionBar) this.mActionBarVisibilityCallback).mCurWindowVisibility = this.mWindowVisibility;
            int r2 = this.mLastSystemUiVisibility;
            if (r2 != 0) {
                onWindowSystemUiVisibilityChanged(r2);
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api20Impl.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.mHasNonEmbeddedTabs = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.mHideOnContentScroll) {
            this.mHideOnContentScroll = z;
            if (!z) {
                haltActionBarHideOffsetAnimations();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int r2) {
        pullChildren();
        this.mDecorToolbar.setIcon(r2);
    }

    public void setLogo(int r2) {
        pullChildren();
        this.mDecorToolbar.setLogo(r2);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final void setMenu(MenuBuilder menuBuilder, AppCompatDelegateImpl.ActionMenuPresenterCallback actionMenuPresenterCallback) {
        pullChildren();
        this.mDecorToolbar.setMenu(menuBuilder, actionMenuPresenterCallback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final void setMenuPrepared() {
        pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        boolean z2;
        this.mOverlayMode = z;
        if (z && getContext().getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mIgnoreWindowContentOverlay = z2;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        pullChildren();
        this.mDecorToolbar.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        pullChildren();
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final boolean showOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View view, int r2, int r3, int[] r4, int r5) {
        if (r5 == 0) {
            onNestedPreScroll(view, r2, r3, r4);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View view, int r2, int r3, int r4, int r5, int r6) {
        if (r6 == 0) {
            onNestedScroll(view, r2, r3, r4, r5);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int r3) {
        if ((r3 & 2) == 0 || this.mActionBarTop.getVisibility() != 0) {
            return false;
        }
        return this.mHideOnContentScroll;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.mHideOnContentScroll || this.mAnimatingForFling) {
            return;
        }
        if (this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
            haltActionBarHideOffsetAnimations();
            postDelayed(this.mRemoveActionBarHideOffset, 600L);
        } else {
            haltActionBarHideOffsetAnimations();
            postDelayed(this.mAddActionBarHideOffset, 600L);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int r2, int r3, int r4, int r5) {
        int r1 = this.mHideOnContentScrollReference + r3;
        this.mHideOnContentScrollReference = r1;
        setActionBarHideOffset(r1);
    }

    public void setIcon(Drawable drawable) {
        pullChildren();
        this.mDecorToolbar.setIcon(drawable);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View view, View view2, int r3, int r4) {
        if (r4 == 0) {
            onNestedScrollAccepted(view, view2, r3);
        }
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int r1) {
    }
}
