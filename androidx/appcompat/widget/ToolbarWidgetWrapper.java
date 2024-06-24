package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.kronaby.watch.app.R;

/* loaded from: classes.dex */
public final class ToolbarWidgetWrapper implements DecorToolbar {
    public ActionMenuPresenter mActionMenuPresenter;
    public View mCustomView;
    public int mDefaultNavigationContentDescription;
    public Drawable mDefaultNavigationIcon;
    public int mDisplayOpts;
    public CharSequence mHomeDescription;
    public Drawable mIcon;
    public Drawable mLogo;
    public boolean mMenuPrepared;
    public Drawable mNavIcon;
    public CharSequence mSubtitle;
    public ScrollingTabContainerView mTabView;
    public CharSequence mTitle;
    public boolean mTitleSet;
    public final Toolbar mToolbar;
    public Window.Callback mWindowCallback;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        boolean z2;
        Drawable drawable;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = toolbar;
        this.mTitle = toolbar.getTitle();
        this.mSubtitle = toolbar.getSubtitle();
        if (this.mTitle != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mTitleSet = z2;
        this.mNavIcon = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, R$styleable.ActionBar, R.attr.actionBarStyle);
        int r3 = 15;
        this.mDefaultNavigationIcon = obtainStyledAttributes.getDrawable(15);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(27);
            if (!TextUtils.isEmpty(text)) {
                this.mTitleSet = true;
                this.mTitle = text;
                if ((this.mDisplayOpts & 8) != 0) {
                    toolbar.setTitle(text);
                    if (this.mTitleSet) {
                        ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = obtainStyledAttributes.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                this.mSubtitle = text2;
                if ((this.mDisplayOpts & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(20);
            if (drawable2 != null) {
                this.mLogo = drawable2;
                updateToolbarLogo();
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(17);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.mNavIcon == null && (drawable = this.mDefaultNavigationIcon) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(10, 0));
            int resourceId = obtainStyledAttributes.getResourceId(9, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.mCustomView;
                if (view != null && (this.mDisplayOpts & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.mCustomView = inflate;
                if (inflate != null && (this.mDisplayOpts & 16) != 0) {
                    toolbar.addView(inflate);
                }
                setDisplayOptions(this.mDisplayOpts | 16);
            }
            int layoutDimension = obtainStyledAttributes.mWrapped.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                toolbar.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(28, 0);
            if (resourceId2 != 0) {
                toolbar.setTitleTextAppearance(toolbar.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(26, 0);
            if (resourceId3 != 0) {
                toolbar.setSubtitleTextAppearance(toolbar.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(22, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.mDefaultNavigationIcon = toolbar.getNavigationIcon();
            } else {
                r3 = 11;
            }
            this.mDisplayOpts = r3;
        }
        obtainStyledAttributes.recycle();
        if (R.string.abc_action_bar_up_description != this.mDefaultNavigationContentDescription) {
            this.mDefaultNavigationContentDescription = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int r8 = this.mDefaultNavigationContentDescription;
                String string = r8 != 0 ? getContext().getString(r8) : null;
                this.mHomeDescription = string;
                if ((this.mDisplayOpts & 4) != 0) {
                    if (TextUtils.isEmpty(string)) {
                        toolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
                    } else {
                        toolbar.setNavigationContentDescription(this.mHomeDescription);
                    }
                }
            }
        }
        this.mHomeDescription = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.1
            public final ActionMenuItem mNavItem;

            {
                this.mNavItem = new ActionMenuItem(ToolbarWidgetWrapper.this.mToolbar.getContext(), ToolbarWidgetWrapper.this.mTitle);
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.mWindowCallback;
                if (callback != null && toolbarWidgetWrapper.mMenuPrepared) {
                    callback.onMenuItemSelected(0, this.mNavItem);
                }
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean canShowOverflowMenu() {
        return this.mToolbar.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void collapseActionView() {
        this.mToolbar.collapseActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void dismissPopupMenus() {
        this.mToolbar.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final Context getContext() {
        return this.mToolbar.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean hasExpandedActionView() {
        return this.mToolbar.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean hideOverflowMenu() {
        return this.mToolbar.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean isOverflowMenuShowPending() {
        return this.mToolbar.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setCollapsible(boolean z) {
        this.mToolbar.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setDisplayOptions(int r5) {
        View view;
        int r0 = this.mDisplayOpts ^ r5;
        this.mDisplayOpts = r5;
        if (r0 != 0) {
            int r1 = r0 & 4;
            Toolbar toolbar = this.mToolbar;
            if (r1 != 0) {
                if ((r5 & 4) != 0 && (r5 & 4) != 0) {
                    if (TextUtils.isEmpty(this.mHomeDescription)) {
                        toolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
                    } else {
                        toolbar.setNavigationContentDescription(this.mHomeDescription);
                    }
                }
                if ((this.mDisplayOpts & 4) != 0) {
                    Drawable drawable = this.mNavIcon;
                    if (drawable == null) {
                        drawable = this.mDefaultNavigationIcon;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((r0 & 3) != 0) {
                updateToolbarLogo();
            }
            if ((r0 & 8) != 0) {
                if ((r5 & 8) != 0) {
                    toolbar.setTitle(this.mTitle);
                    toolbar.setSubtitle(this.mSubtitle);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((r0 & 16) != 0 && (view = this.mCustomView) != null) {
                if ((r5 & 16) != 0) {
                    toolbar.addView(view);
                } else {
                    toolbar.removeView(view);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setEmbeddedTabView() {
        ScrollingTabContainerView scrollingTabContainerView = this.mTabView;
        if (scrollingTabContainerView != null) {
            ViewParent parent = scrollingTabContainerView.getParent();
            Toolbar toolbar = this.mToolbar;
            if (parent == toolbar) {
                toolbar.removeView(this.mTabView);
            }
        }
        this.mTabView = null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setIcon(int r2) {
        setIcon(r2 != 0 ? AppCompatResources.getDrawable(getContext(), r2) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setLogo(int r2) {
        Drawable drawable;
        if (r2 != 0) {
            drawable = AppCompatResources.getDrawable(getContext(), r2);
        } else {
            drawable = null;
        }
        this.mLogo = drawable;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setMenu(MenuBuilder menuBuilder, AppCompatDelegateImpl.ActionMenuPresenterCallback actionMenuPresenterCallback) {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        Toolbar toolbar = this.mToolbar;
        if (actionMenuPresenter == null) {
            this.mActionMenuPresenter = new ActionMenuPresenter(toolbar.getContext());
        }
        ActionMenuPresenter actionMenuPresenter2 = this.mActionMenuPresenter;
        actionMenuPresenter2.mCallback = actionMenuPresenterCallback;
        toolbar.setMenu(menuBuilder, actionMenuPresenter2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setNavigationIcon(Drawable drawable) {
        this.mNavIcon = drawable;
        int r0 = this.mDisplayOpts & 4;
        Toolbar toolbar = this.mToolbar;
        if (r0 != 0) {
            if (drawable == null) {
                drawable = this.mDefaultNavigationIcon;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        toolbar.setNavigationIcon((Drawable) null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setVisibility(int r2) {
        this.mToolbar.setVisibility(r2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setWindowCallback(Window.Callback callback) {
        this.mWindowCallback = callback;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setWindowTitle(CharSequence charSequence) {
        if (!this.mTitleSet) {
            this.mTitle = charSequence;
            if ((this.mDisplayOpts & 8) != 0) {
                Toolbar toolbar = this.mToolbar;
                toolbar.setTitle(charSequence);
                if (this.mTitleSet) {
                    ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int r3, long j) {
        float f;
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(this.mToolbar);
        if (r3 == 0) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        animate.alpha(f);
        animate.setDuration(j);
        animate.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.2
            public boolean mCanceled = false;

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public final void onAnimationCancel(View view) {
                this.mCanceled = true;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public final void onAnimationEnd() {
                if (!this.mCanceled) {
                    ToolbarWidgetWrapper.this.mToolbar.setVisibility(r3);
                }
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public final void onAnimationStart() {
                ToolbarWidgetWrapper.this.mToolbar.setVisibility(0);
            }
        });
        return animate;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }

    public final void updateToolbarLogo() {
        Drawable drawable;
        int r0 = this.mDisplayOpts;
        if ((r0 & 2) != 0) {
            if ((r0 & 1) != 0) {
                drawable = this.mLogo;
                if (drawable == null) {
                    drawable = this.mIcon;
                }
            } else {
                drawable = this.mIcon;
            }
        } else {
            drawable = null;
        }
        this.mToolbar.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void getNavigationMode() {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setHomeButtonEnabled() {
    }
}
