package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {
    public View mClose;
    public View mCloseButton;
    public final int mCloseItemLayout;
    public View mCustomView;
    public CharSequence mSubtitle;
    public final int mSubtitleStyleRes;
    public TextView mSubtitleView;
    public CharSequence mTitle;
    public LinearLayout mTitleLayout;
    public boolean mTitleOptional;
    public final int mTitleStyleRes;
    public TextView mTitleView;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.actionModeStyle);
        Drawable drawable;
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMode, R.attr.actionModeStyle, 0);
        if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
            drawable = AppCompatResources.getDrawable(context, resourceId);
        } else {
            drawable = obtainStyledAttributes.getDrawable(0);
        }
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.setBackground(this, drawable);
        this.mTitleStyleRes = obtainStyledAttributes.getResourceId(5, 0);
        this.mSubtitleStyleRes = obtainStyledAttributes.getResourceId(4, 0);
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(3, 0);
        this.mCloseItemLayout = obtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public final void initForMode(final ActionMode actionMode) {
        View view = this.mClose;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, (ViewGroup) this, false);
            this.mClose = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.mClose);
        }
        View findViewById = this.mClose.findViewById(R.id.action_mode_close_button);
        this.mCloseButton = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActionMode.this.finish();
            }
        });
        MenuBuilder menu = actionMode.getMenu();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.hideOverflowMenu();
            ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = actionMenuPresenter.mActionButtonPopup;
            if (actionButtonSubmenu != null && actionButtonSubmenu.isShowing()) {
                actionButtonSubmenu.mPopup.dismiss();
            }
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter = actionMenuPresenter2;
        actionMenuPresenter2.mReserveOverflow = true;
        actionMenuPresenter2.mReserveOverflowSet = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menu.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        ActionMenuPresenter actionMenuPresenter3 = this.mActionMenuPresenter;
        MenuView menuView = actionMenuPresenter3.mMenuView;
        if (menuView == null) {
            MenuView menuView2 = (MenuView) actionMenuPresenter3.mSystemInflater.inflate(actionMenuPresenter3.mMenuLayoutRes, (ViewGroup) this, false);
            actionMenuPresenter3.mMenuView = menuView2;
            menuView2.initialize(actionMenuPresenter3.mMenu);
            actionMenuPresenter3.updateMenuView();
        }
        MenuView menuView3 = actionMenuPresenter3.mMenuView;
        if (menuView != menuView3) {
            ((ActionMenuView) menuView3).setPresenter(actionMenuPresenter3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) menuView3;
        this.mMenuView = actionMenuView;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.setBackground(actionMenuView, null);
        addView(this.mMenuView, layoutParams);
    }

    public final void initTitle() {
        int r5;
        if (this.mTitleLayout == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.mTitleLayout = linearLayout;
            this.mTitleView = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_subtitle);
            int r0 = this.mTitleStyleRes;
            if (r0 != 0) {
                this.mTitleView.setTextAppearance(getContext(), r0);
            }
            int r02 = this.mSubtitleStyleRes;
            if (r02 != 0) {
                this.mSubtitleView.setTextAppearance(getContext(), r02);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean z = !TextUtils.isEmpty(this.mTitle);
        boolean z2 = !TextUtils.isEmpty(this.mSubtitle);
        TextView textView = this.mSubtitleView;
        int r3 = 0;
        if (z2) {
            r5 = 0;
        } else {
            r5 = 8;
        }
        textView.setVisibility(r5);
        LinearLayout linearLayout2 = this.mTitleLayout;
        if (!z && !z2) {
            r3 = 8;
        }
        linearLayout2.setVisibility(r3);
        if (this.mTitleLayout.getParent() == null) {
            addView(this.mTitleLayout);
        }
    }

    public final void killMode() {
        removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
        this.mActionMenuPresenter = null;
        View view = this.mCloseButton;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.hideOverflowMenu();
            ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = this.mActionMenuPresenter.mActionButtonPopup;
            if (actionButtonSubmenu != null && actionButtonSubmenu.isShowing()) {
                actionButtonSubmenu.mPopup.dismiss();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r6, int r7, int r8, int r9) {
        int paddingLeft;
        int paddingRight;
        int r3;
        int r72;
        int r0;
        int r32;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (isLayoutRtl) {
            paddingLeft = (r8 - r6) - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((r9 - r7) - getPaddingTop()) - getPaddingBottom();
        View view = this.mClose;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
            if (isLayoutRtl) {
                r3 = marginLayoutParams.rightMargin;
            } else {
                r3 = marginLayoutParams.leftMargin;
            }
            if (isLayoutRtl) {
                r72 = marginLayoutParams.leftMargin;
            } else {
                r72 = marginLayoutParams.rightMargin;
            }
            if (isLayoutRtl) {
                r0 = paddingLeft - r3;
            } else {
                r0 = paddingLeft + r3;
            }
            int positionChild = AbsActionBarView.positionChild(this.mClose, isLayoutRtl, r0, paddingTop, paddingTop2) + r0;
            if (isLayoutRtl) {
                r32 = positionChild - r72;
            } else {
                r32 = positionChild + r72;
            }
            paddingLeft = r32;
        }
        LinearLayout linearLayout = this.mTitleLayout;
        if (linearLayout != null && this.mCustomView == null && linearLayout.getVisibility() != 8) {
            paddingLeft += AbsActionBarView.positionChild(this.mTitleLayout, isLayoutRtl, paddingLeft, paddingTop, paddingTop2);
        }
        View view2 = this.mCustomView;
        if (view2 != null) {
            AbsActionBarView.positionChild(view2, isLayoutRtl, paddingLeft, paddingTop, paddingTop2);
        }
        if (isLayoutRtl) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = (r8 - r6) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            AbsActionBarView.positionChild(actionMenuView, !isLayoutRtl, paddingRight, paddingTop, paddingTop2);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int r11, int r12) {
        int r9;
        boolean z;
        int r6;
        int r1 = 1073741824;
        if (View.MeasureSpec.getMode(r11) == 1073741824) {
            if (View.MeasureSpec.getMode(r12) != 0) {
                int size = View.MeasureSpec.getSize(r11);
                int r0 = this.mContentHeight;
                if (r0 <= 0) {
                    r0 = View.MeasureSpec.getSize(r12);
                }
                int paddingBottom = getPaddingBottom() + getPaddingTop();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int r3 = r0 - paddingBottom;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(r3, Integer.MIN_VALUE);
                View view = this.mClose;
                if (view != null) {
                    int measureChildView = AbsActionBarView.measureChildView(view, paddingLeft, makeMeasureSpec);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
                    paddingLeft = measureChildView - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.mMenuView;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = AbsActionBarView.measureChildView(this.mMenuView, paddingLeft, makeMeasureSpec);
                }
                LinearLayout linearLayout = this.mTitleLayout;
                if (linearLayout != null && this.mCustomView == null) {
                    if (this.mTitleOptional) {
                        this.mTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.mTitleLayout.getMeasuredWidth();
                        if (measuredWidth <= paddingLeft) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            paddingLeft -= measuredWidth;
                        }
                        LinearLayout linearLayout2 = this.mTitleLayout;
                        if (z) {
                            r6 = 0;
                        } else {
                            r6 = 8;
                        }
                        linearLayout2.setVisibility(r6);
                    } else {
                        paddingLeft = AbsActionBarView.measureChildView(linearLayout, paddingLeft, makeMeasureSpec);
                    }
                }
                View view2 = this.mCustomView;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int r62 = layoutParams.width;
                    if (r62 != -2) {
                        r9 = 1073741824;
                    } else {
                        r9 = Integer.MIN_VALUE;
                    }
                    if (r62 >= 0) {
                        paddingLeft = Math.min(r62, paddingLeft);
                    }
                    int r5 = layoutParams.height;
                    if (r5 == -2) {
                        r1 = Integer.MIN_VALUE;
                    }
                    if (r5 >= 0) {
                        r3 = Math.min(r5, r3);
                    }
                    this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, r9), View.MeasureSpec.makeMeasureSpec(r3, r1));
                }
                if (this.mContentHeight <= 0) {
                    int childCount = getChildCount();
                    int r02 = 0;
                    for (int r7 = 0; r7 < childCount; r7++) {
                        int measuredHeight = getChildAt(r7).getMeasuredHeight() + paddingBottom;
                        if (measuredHeight > r02) {
                            r02 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, r02);
                    return;
                }
                setMeasuredDimension(size, r0);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int r1) {
        this.mContentHeight = r1;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.mCustomView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mCustomView = view;
        if (view != null && (linearLayout = this.mTitleLayout) != null) {
            removeView(linearLayout);
            this.mTitleLayout = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        initTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        initTitle();
        ViewCompat.setAccessibilityPaneTitle(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.mTitleOptional) {
            requestLayout();
        }
        this.mTitleOptional = z;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int r1) {
        super.setVisibility(r1);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
