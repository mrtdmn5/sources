package androidx.appcompat.app;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import com.amazonaws.services.s3.internal.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    public static final AccelerateInterpolator sHideInterpolator = new AccelerateInterpolator();
    public static final DecelerateInterpolator sShowInterpolator = new DecelerateInterpolator();
    public ActionModeImpl mActionMode;
    public ActionBarContainer mContainerView;
    public boolean mContentAnimations;
    public final View mContentView;
    public Context mContext;
    public ActionBarContextView mContextView;
    public int mCurWindowVisibility;
    public ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    public DecorToolbar mDecorToolbar;
    public ActionModeImpl mDeferredDestroyActionMode;
    public ActionMode.Callback mDeferredModeDestroyCallback;
    public boolean mDisplayHomeAsUpSet;
    public boolean mHasEmbeddedTabs;
    public boolean mHiddenBySystem;
    public final AnonymousClass1 mHideListener;
    public boolean mHideOnContentScroll;
    public boolean mLastMenuVisibility;
    public final ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners;
    public boolean mNowShowing;
    public ActionBarOverlayLayout mOverlayLayout;
    public boolean mShowHideAnimationEnabled;
    public final AnonymousClass2 mShowListener;
    public boolean mShowingForMode;
    public Context mThemedContext;
    public final AnonymousClass3 mUpdateListener;

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends ViewPropertyAnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            View view;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mContentAnimations && (view = windowDecorActionBar.mContentView) != null) {
                view.setTranslationY(0.0f);
                windowDecorActionBar.mContainerView.setTranslationY(0.0f);
            }
            windowDecorActionBar.mContainerView.setVisibility(8);
            windowDecorActionBar.mContainerView.setTransitioning(false);
            windowDecorActionBar.mCurrentShowAnim = null;
            ActionMode.Callback callback = windowDecorActionBar.mDeferredModeDestroyCallback;
            if (callback != null) {
                callback.onDestroyActionMode(windowDecorActionBar.mDeferredDestroyActionMode);
                windowDecorActionBar.mDeferredDestroyActionMode = null;
                windowDecorActionBar.mDeferredModeDestroyCallback = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = windowDecorActionBar.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api20Impl.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends ViewPropertyAnimatorListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.mCurrentShowAnim = null;
            windowDecorActionBar.mContainerView.requestLayout();
        }
    }

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements ViewPropertyAnimatorUpdateListener {
        public AnonymousClass3() {
        }
    }

    /* loaded from: classes.dex */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        public final Context mActionModeContext;
        public ActionMode.Callback mCallback;
        public WeakReference<View> mCustomView;
        public final MenuBuilder mMenu;

        public ActionModeImpl(Context context, AppCompatDelegateImpl.ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9) {
            this.mActionModeContext = context;
            this.mCallback = actionModeCallbackWrapperV9;
            MenuBuilder menuBuilder = new MenuBuilder(context);
            menuBuilder.mDefaultShowAsAction = 1;
            this.mMenu = menuBuilder;
            menuBuilder.mCallback = this;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mActionMode != this) {
                return;
            }
            if (!(!windowDecorActionBar.mHiddenBySystem)) {
                windowDecorActionBar.mDeferredDestroyActionMode = this;
                windowDecorActionBar.mDeferredModeDestroyCallback = this.mCallback;
            } else {
                this.mCallback.onDestroyActionMode(this);
            }
            this.mCallback = null;
            windowDecorActionBar.animateToMode(false);
            ActionBarContextView actionBarContextView = windowDecorActionBar.mContextView;
            if (actionBarContextView.mClose == null) {
                actionBarContextView.killMode();
            }
            windowDecorActionBar.mOverlayLayout.setHideOnContentScrollEnabled(windowDecorActionBar.mHideOnContentScroll);
            windowDecorActionBar.mActionMode = null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final View getCustomView() {
            WeakReference<View> weakReference = this.mCustomView;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final MenuBuilder getMenu() {
            return this.mMenu;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.mActionModeContext);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final CharSequence getSubtitle() {
            return WindowDecorActionBar.this.mContextView.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final CharSequence getTitle() {
            return WindowDecorActionBar.this.mContextView.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void invalidate() {
            if (WindowDecorActionBar.this.mActionMode != this) {
                return;
            }
            MenuBuilder menuBuilder = this.mMenu;
            menuBuilder.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, menuBuilder);
            } finally {
                menuBuilder.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public final boolean isTitleOptional() {
            return WindowDecorActionBar.this.mContextView.mTitleOptional;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.mCallback;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.mCallback == null) {
                return;
            }
            invalidate();
            ActionMenuPresenter actionMenuPresenter = WindowDecorActionBar.this.mContextView.mActionMenuPresenter;
            if (actionMenuPresenter != null) {
                actionMenuPresenter.showOverflowMenu();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setCustomView(View view) {
            WindowDecorActionBar.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setTitleOptionalHint(boolean z) {
            this.mTitleOptionalHint = z;
            WindowDecorActionBar.this.mContextView.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setSubtitle(int r2) {
            setSubtitle(WindowDecorActionBar.this.mContext.getResources().getString(r2));
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setTitle(int r2) {
            setTitle(WindowDecorActionBar.this.mContext.getResources().getString(r2));
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        new ArrayList();
        this.mMenuVisibilityListeners = new ArrayList<>();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1();
        this.mShowListener = new AnonymousClass2();
        this.mUpdateListener = new AnonymousClass3();
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if (z) {
            return;
        }
        this.mContentView = decorView.findViewById(R.id.content);
    }

    public final void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        long j;
        if (z) {
            if (!this.mShowingForMode) {
                this.mShowingForMode = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                updateVisibility(false);
            }
        } else if (this.mShowingForMode) {
            this.mShowingForMode = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
        ActionBarContainer actionBarContainer = this.mContainerView;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api19Impl.isLaidOut(actionBarContainer)) {
            if (z) {
                viewPropertyAnimatorCompat2 = this.mDecorToolbar.setupAnimatorToVisibility(4, 100L);
                viewPropertyAnimatorCompat = this.mContextView.setupAnimatorToVisibility(0, 200L);
            } else {
                viewPropertyAnimatorCompat = this.mDecorToolbar.setupAnimatorToVisibility(0, 200L);
                viewPropertyAnimatorCompat2 = this.mContextView.setupAnimatorToVisibility(8, 100L);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            ArrayList<ViewPropertyAnimatorCompat> arrayList = viewPropertyAnimatorCompatSet.mAnimators;
            arrayList.add(viewPropertyAnimatorCompat2);
            View view = viewPropertyAnimatorCompat2.mView.get();
            if (view != null) {
                j = view.animate().getDuration();
            } else {
                j = 0;
            }
            View view2 = viewPropertyAnimatorCompat.mView.get();
            if (view2 != null) {
                view2.animate().setStartDelay(j);
            }
            arrayList.add(viewPropertyAnimatorCompat);
            viewPropertyAnimatorCompatSet.start();
            return;
        }
        if (z) {
            this.mDecorToolbar.setVisibility(4);
            this.mContextView.setVisibility(0);
        } else {
            this.mDecorToolbar.setVisibility(0);
            this.mContextView.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean collapseActionView() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar != null && decorToolbar.hasExpandedActionView()) {
            this.mDecorToolbar.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void dispatchMenuVisibilityChanged(boolean z) {
        if (z == this.mLastMenuVisibility) {
            return;
        }
        this.mLastMenuVisibility = z;
        ArrayList<ActionBar.OnMenuVisibilityListener> arrayList = this.mMenuVisibilityListeners;
        int size = arrayList.size();
        for (int r1 = 0; r1 < size; r1++) {
            arrayList.get(r1).onMenuVisibilityChanged();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(com.kronaby.watch.app.R.attr.actionBarWidgetTheme, typedValue, true);
            int r0 = typedValue.resourceId;
            if (r0 != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, r0);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public final void init(View view) {
        String str;
        DecorToolbar wrapper;
        boolean z;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.kronaby.watch.app.R.id.decor_content_parent);
        this.mOverlayLayout = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback findViewById = view.findViewById(com.kronaby.watch.app.R.id.action_bar);
        if (findViewById instanceof DecorToolbar) {
            wrapper = (DecorToolbar) findViewById;
        } else if (findViewById instanceof Toolbar) {
            wrapper = ((Toolbar) findViewById).getWrapper();
        } else {
            if (findViewById != null) {
                str = findViewById.getClass().getSimpleName();
            } else {
                str = Constants.NULL_VERSION_ID;
            }
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(str));
        }
        this.mDecorToolbar = wrapper;
        this.mContextView = (ActionBarContextView) view.findViewById(com.kronaby.watch.app.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.kronaby.watch.app.R.id.action_bar_container);
        this.mContainerView = actionBarContainer;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar != null && this.mContextView != null && actionBarContainer != null) {
            this.mContext = decorToolbar.getContext();
            if ((this.mDecorToolbar.getDisplayOptions() & 4) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.mDisplayHomeAsUpSet = true;
            }
            Context context = this.mContext;
            if (context.getApplicationInfo().targetSdkVersion < 14) {
            }
            this.mDecorToolbar.setHomeButtonEnabled();
            setHasEmbeddedTabs(context.getResources().getBoolean(com.kronaby.watch.app.R.bool.abc_action_bar_embed_tabs));
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, R$styleable.ActionBar, com.kronaby.watch.app.R.attr.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(14, false)) {
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
                if (actionBarOverlayLayout2.mOverlayMode) {
                    this.mHideOnContentScroll = true;
                    actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
                } else {
                    throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                }
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
            if (dimensionPixelSize != 0) {
                ActionBarContainer actionBarContainer2 = this.mContainerView;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api21Impl.setElevation(actionBarContainer2, dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException("WindowDecorActionBar can only be used with a compatible window decor layout");
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void onConfigurationChanged() {
        setHasEmbeddedTabs(this.mContext.getResources().getBoolean(com.kronaby.watch.app.R.bool.abc_action_bar_embed_tabs));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean onKeyShortcut(int r5, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        int r2;
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl == null || (menuBuilder = actionModeImpl.mMenu) == null) {
            return false;
        }
        if (keyEvent != null) {
            r2 = keyEvent.getDeviceId();
        } else {
            r2 = -1;
        }
        boolean z = true;
        if (KeyCharacterMap.load(r2).getKeyboardType() == 1) {
            z = false;
        }
        menuBuilder.setQwertyMode(z);
        return menuBuilder.performShortcut(r5, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.mDisplayHomeAsUpSet) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDisplayHomeAsUpEnabled(boolean z) {
        int r4;
        if (z) {
            r4 = 4;
        } else {
            r4 = 0;
        }
        int displayOptions = this.mDecorToolbar.getDisplayOptions();
        this.mDisplayHomeAsUpSet = true;
        this.mDecorToolbar.setDisplayOptions((r4 & 4) | ((-5) & displayOptions));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDisplayShowTitleEnabled() {
        this.mDecorToolbar.setDisplayOptions((this.mDecorToolbar.getDisplayOptions() & (-9)) | 0);
    }

    public final void setHasEmbeddedTabs(boolean z) {
        this.mHasEmbeddedTabs = z;
        if (!z) {
            this.mDecorToolbar.setEmbeddedTabView();
            this.mContainerView.setTabContainer(null);
        } else {
            this.mContainerView.setTabContainer(null);
            this.mDecorToolbar.setEmbeddedTabView();
        }
        this.mDecorToolbar.getNavigationMode();
        DecorToolbar decorToolbar = this.mDecorToolbar;
        boolean z2 = this.mHasEmbeddedTabs;
        decorToolbar.setCollapsible(false);
        ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
        boolean z3 = this.mHasEmbeddedTabs;
        actionBarOverlayLayout.setHasNonEmbeddedTabs(false);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setShowHideAnimationEnabled(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mShowHideAnimationEnabled = z;
        if (!z && (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final ActionMode startActionMode(AppCompatDelegateImpl.ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9) {
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.mContextView.getContext(), actionModeCallbackWrapperV9);
        MenuBuilder menuBuilder = actionModeImpl2.mMenu;
        menuBuilder.stopDispatchingItemsChanged();
        try {
            if (actionModeImpl2.mCallback.onCreateActionMode(actionModeImpl2, menuBuilder)) {
                this.mActionMode = actionModeImpl2;
                actionModeImpl2.invalidate();
                this.mContextView.initForMode(actionModeImpl2);
                animateToMode(true);
                return actionModeImpl2;
            }
            return null;
        } finally {
            menuBuilder.startDispatchingItemsChanged();
        }
    }

    public final void updateVisibility(boolean z) {
        boolean z2;
        boolean z3 = this.mHiddenBySystem;
        if (this.mShowingForMode || !z3) {
            z2 = true;
        } else {
            z2 = false;
        }
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        View view = this.mContentView;
        final AnonymousClass3 anonymousClass3 = this.mUpdateListener;
        if (z2) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
                if (viewPropertyAnimatorCompatSet != null) {
                    viewPropertyAnimatorCompatSet.cancel();
                }
                this.mContainerView.setVisibility(0);
                int r0 = this.mCurWindowVisibility;
                AnonymousClass2 anonymousClass2 = this.mShowListener;
                if (r0 == 0 && (this.mShowHideAnimationEnabled || z)) {
                    this.mContainerView.setTranslationY(0.0f);
                    float f = -this.mContainerView.getHeight();
                    if (z) {
                        this.mContainerView.getLocationInWindow(new int[]{0, 0});
                        f -= r12[1];
                    }
                    this.mContainerView.setTranslationY(f);
                    ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
                    ViewPropertyAnimatorCompat animate = ViewCompat.animate(this.mContainerView);
                    animate.translationY(0.0f);
                    final View view2 = animate.mView.get();
                    if (view2 != null) {
                        if (anonymousClass3 != null) {
                            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(anonymousClass3, view2) { // from class: androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0
                                public final /* synthetic */ ViewPropertyAnimatorUpdateListener f$0;

                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    ((View) WindowDecorActionBar.this.mContainerView.getParent()).invalidate();
                                }
                            };
                        }
                        ViewPropertyAnimatorCompat.Api19Impl.setUpdateListener(view2.animate(), animatorUpdateListener);
                    }
                    boolean z4 = viewPropertyAnimatorCompatSet2.mIsStarted;
                    ArrayList<ViewPropertyAnimatorCompat> arrayList = viewPropertyAnimatorCompatSet2.mAnimators;
                    if (!z4) {
                        arrayList.add(animate);
                    }
                    if (this.mContentAnimations && view != null) {
                        view.setTranslationY(f);
                        ViewPropertyAnimatorCompat animate2 = ViewCompat.animate(view);
                        animate2.translationY(0.0f);
                        if (!viewPropertyAnimatorCompatSet2.mIsStarted) {
                            arrayList.add(animate2);
                        }
                    }
                    DecelerateInterpolator decelerateInterpolator = sShowInterpolator;
                    boolean z5 = viewPropertyAnimatorCompatSet2.mIsStarted;
                    if (!z5) {
                        viewPropertyAnimatorCompatSet2.mInterpolator = decelerateInterpolator;
                    }
                    if (!z5) {
                        viewPropertyAnimatorCompatSet2.mDuration = 250L;
                    }
                    if (!z5) {
                        viewPropertyAnimatorCompatSet2.mListener = anonymousClass2;
                    }
                    this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
                    viewPropertyAnimatorCompatSet2.start();
                } else {
                    this.mContainerView.setAlpha(1.0f);
                    this.mContainerView.setTranslationY(0.0f);
                    if (this.mContentAnimations && view != null) {
                        view.setTranslationY(0.0f);
                    }
                    anonymousClass2.onAnimationEnd();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api20Impl.requestApplyInsets(actionBarOverlayLayout);
                    return;
                }
                return;
            }
            return;
        }
        if (this.mNowShowing) {
            this.mNowShowing = false;
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet3 = this.mCurrentShowAnim;
            if (viewPropertyAnimatorCompatSet3 != null) {
                viewPropertyAnimatorCompatSet3.cancel();
            }
            int r02 = this.mCurWindowVisibility;
            AnonymousClass1 anonymousClass1 = this.mHideListener;
            if (r02 == 0 && (this.mShowHideAnimationEnabled || z)) {
                this.mContainerView.setAlpha(1.0f);
                this.mContainerView.setTransitioning(true);
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet4 = new ViewPropertyAnimatorCompatSet();
                float f2 = -this.mContainerView.getHeight();
                if (z) {
                    this.mContainerView.getLocationInWindow(new int[]{0, 0});
                    f2 -= r12[1];
                }
                ViewPropertyAnimatorCompat animate3 = ViewCompat.animate(this.mContainerView);
                animate3.translationY(f2);
                final View view3 = animate3.mView.get();
                if (view3 != null) {
                    if (anonymousClass3 != null) {
                        animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(anonymousClass3, view3) { // from class: androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0
                            public final /* synthetic */ ViewPropertyAnimatorUpdateListener f$0;

                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                ((View) WindowDecorActionBar.this.mContainerView.getParent()).invalidate();
                            }
                        };
                    }
                    ViewPropertyAnimatorCompat.Api19Impl.setUpdateListener(view3.animate(), animatorUpdateListener);
                }
                boolean z6 = viewPropertyAnimatorCompatSet4.mIsStarted;
                ArrayList<ViewPropertyAnimatorCompat> arrayList2 = viewPropertyAnimatorCompatSet4.mAnimators;
                if (!z6) {
                    arrayList2.add(animate3);
                }
                if (this.mContentAnimations && view != null) {
                    ViewPropertyAnimatorCompat animate4 = ViewCompat.animate(view);
                    animate4.translationY(f2);
                    if (!viewPropertyAnimatorCompatSet4.mIsStarted) {
                        arrayList2.add(animate4);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = sHideInterpolator;
                boolean z7 = viewPropertyAnimatorCompatSet4.mIsStarted;
                if (!z7) {
                    viewPropertyAnimatorCompatSet4.mInterpolator = accelerateInterpolator;
                }
                if (!z7) {
                    viewPropertyAnimatorCompatSet4.mDuration = 250L;
                }
                if (!z7) {
                    viewPropertyAnimatorCompatSet4.mListener = anonymousClass1;
                }
                this.mCurrentShowAnim = viewPropertyAnimatorCompatSet4;
                viewPropertyAnimatorCompatSet4.start();
                return;
            }
            anonymousClass1.onAnimationEnd();
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        new ArrayList();
        this.mMenuVisibilityListeners = new ArrayList<>();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1();
        this.mShowListener = new AnonymousClass2();
        this.mUpdateListener = new AnonymousClass3();
        init(dialog.getWindow().getDecorView());
    }
}
