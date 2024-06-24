package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuProvider;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    public MenuPresenter.Callback mActionMenuPresenterCallback;
    public boolean mFormatItems;
    public int mFormatItemsWidth;
    public final int mGeneratedItemPadding;
    public MenuBuilder mMenu;
    public MenuBuilder.Callback mMenuBuilderCallback;
    public final int mMinCellSize;
    public OnMenuItemClickListener mOnMenuItemClickListener;
    public Context mPopupContext;
    public int mPopupTheme;
    public ActionMenuPresenter mPresenter;
    public boolean mReserveOverflow;

    /* loaded from: classes.dex */
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    /* loaded from: classes.dex */
    public class MenuBuilderCallback implements MenuBuilder.Callback {
        public MenuBuilderCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            boolean z;
            boolean z2;
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.mOnMenuItemClickListener;
            if (onMenuItemClickListener == null) {
                return false;
            }
            Toolbar toolbar = Toolbar.this;
            Iterator<MenuProvider> it = toolbar.mMenuHostHelper.mMenuProviders.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().onMenuItemSelected()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                z2 = true;
            } else {
                Toolbar.OnMenuItemClickListener onMenuItemClickListener2 = toolbar.mOnMenuItemClickListener;
                if (onMenuItemClickListener2 != null) {
                    z2 = ToolbarActionBar.this.mWindowCallback.onMenuItemSelected(0, menuItem);
                } else {
                    z2 = false;
                }
            }
            if (!z2) {
                return false;
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final void onMenuModeChange(MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.mMenuBuilderCallback;
            if (callback != null) {
                callback.onMenuModeChange(menuBuilder);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
    }

    public ActionMenuView() {
        throw null;
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f);
        this.mGeneratedItemPadding = (int) (f * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams();
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.mMenu = menuBuilder;
            menuBuilder.mCallback = new MenuBuilderCallback();
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.mPresenter = actionMenuPresenter;
            actionMenuPresenter.mReserveOverflow = true;
            actionMenuPresenter.mReserveOverflowSet = true;
            MenuPresenter.Callback callback = this.mActionMenuPresenterCallback;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter.mCallback = callback;
            this.mMenu.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
            ActionMenuPresenter actionMenuPresenter2 = this.mPresenter;
            actionMenuPresenter2.mMenuView = this;
            this.mMenu = actionMenuPresenter2.mMenu;
        }
        return this.mMenu;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        ActionMenuPresenter.OverflowMenuButton overflowMenuButton = actionMenuPresenter.mOverflowButton;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (actionMenuPresenter.mPendingOverflowIconSet) {
            return actionMenuPresenter.mPendingOverflowIcon;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final boolean hasSupportDividerBeforeChildAt(int r5) {
        boolean z = false;
        if (r5 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(r5 - 1);
        KeyEvent.Callback childAt2 = getChildAt(r5);
        if (r5 < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = false | ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        if (r5 > 0 && (childAt2 instanceof ActionMenuChildView)) {
            return z | ((ActionMenuChildView) childAt2).needsDividerBefore();
        }
        return z;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public final void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public final boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, null, 0);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView();
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.hideOverflowMenu();
            ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = actionMenuPresenter.mActionButtonPopup;
            if (actionButtonSubmenu != null && actionButtonSubmenu.isShowing()) {
                actionButtonSubmenu.mPopup.dismiss();
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r19, int r20, int r21, int r22) {
        int r3;
        int width;
        int r15;
        if (!this.mFormatItems) {
            super.onLayout(z, r19, r20, r21, r22);
            return;
        }
        int childCount = getChildCount();
        int r2 = (r22 - r20) / 2;
        int dividerWidth = getDividerWidth();
        int r4 = r21 - r19;
        int paddingRight = (r4 - getPaddingRight()) - getPaddingLeft();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int r9 = 0;
        int r10 = 0;
        for (int r8 = 0; r8 < childCount; r8++) {
            View childAt = getChildAt(r8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(r8)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        r15 = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = r15 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        r15 = width - measuredWidth;
                    }
                    int r7 = r2 - (measuredHeight / 2);
                    childAt.layout(r15, r7, width, measuredHeight + r7);
                    paddingRight -= measuredWidth;
                    r9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    hasSupportDividerBeforeChildAt(r8);
                    r10++;
                }
            }
        }
        if (childCount == 1 && r9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int r42 = (r4 / 2) - (measuredWidth2 / 2);
            int r23 = r2 - (measuredHeight2 / 2);
            childAt2.layout(r42, r23, measuredWidth2 + r42, measuredHeight2 + r23);
            return;
        }
        int r102 = r10 - (r9 ^ 1);
        if (r102 > 0) {
            r3 = paddingRight / r102;
        } else {
            r3 = 0;
        }
        int max = Math.max(0, r3);
        if (isLayoutRtl) {
            int width2 = getWidth() - getPaddingRight();
            for (int r72 = 0; r72 < childCount; r72++) {
                View childAt3 = getChildAt(r72);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                    int r5 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int r103 = r2 - (measuredHeight3 / 2);
                    childAt3.layout(r5 - measuredWidth3, r103, r5, measuredHeight3 + r103);
                    width2 = r5 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int r73 = 0; r73 < childCount; r73++) {
            View childAt4 = getChildAt(r73);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                int r52 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int r104 = r2 - (measuredHeight4 / 2);
                childAt4.layout(r52, r104, r52 + measuredWidth4, measuredHeight4 + r104);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + max + r52;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v36 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int r32, int r33) {
        boolean z;
        int r5;
        boolean z2;
        boolean z3;
        boolean z4;
        int r3;
        boolean z5;
        int r6;
        int r2;
        int r62;
        int r63;
        ?? r4;
        boolean z6;
        int r64;
        int r23;
        int r21;
        ActionMenuItemView actionMenuItemView;
        boolean z7;
        int r9;
        boolean z8;
        MenuBuilder menuBuilder;
        boolean z9 = this.mFormatItems;
        if (View.MeasureSpec.getMode(r32) == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        this.mFormatItems = z;
        if (z9 != z) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(r32);
        if (this.mFormatItems && (menuBuilder = this.mMenu) != null && size != this.mFormatItemsWidth) {
            this.mFormatItemsWidth = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (this.mFormatItems && childCount > 0) {
            int mode = View.MeasureSpec.getMode(r33);
            int size2 = View.MeasureSpec.getSize(r32);
            int size3 = View.MeasureSpec.getSize(r33);
            int paddingRight = getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(r33, paddingBottom, -2);
            int r22 = size2 - paddingRight;
            int r8 = this.mMinCellSize;
            int r10 = r22 / r8;
            int r11 = r22 % r8;
            if (r10 == 0) {
                setMeasuredDimension(r22, 0);
                return;
            }
            int r112 = (r11 / r10) + r8;
            int childCount2 = getChildCount();
            int r42 = 0;
            int r12 = 0;
            int r13 = 0;
            int r14 = 0;
            boolean z10 = false;
            int r18 = 0;
            long j = 0;
            while (true) {
                r5 = this.mGeneratedItemPadding;
                if (r14 >= childCount2) {
                    break;
                }
                View childAt = getChildAt(r14);
                int r19 = size3;
                int r20 = r22;
                if (childAt.getVisibility() == 8) {
                    r23 = mode;
                    r21 = paddingBottom;
                } else {
                    boolean z11 = childAt instanceof ActionMenuItemView;
                    int r122 = r12 + 1;
                    if (z11) {
                        childAt.setPadding(r5, 0, r5, 0);
                    }
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.expanded = false;
                    layoutParams.extraPixels = 0;
                    layoutParams.cellsUsed = 0;
                    layoutParams.expandable = false;
                    ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
                    ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
                    if (z11 && ((ActionMenuItemView) childAt).hasText()) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    layoutParams.preventEdgeOffset = z6;
                    if (layoutParams.isOverflowButton) {
                        r64 = 1;
                    } else {
                        r64 = r10;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    r23 = mode;
                    r21 = paddingBottom;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                    if (z11) {
                        actionMenuItemView = (ActionMenuItemView) childAt;
                    } else {
                        actionMenuItemView = null;
                    }
                    if (actionMenuItemView != null && actionMenuItemView.hasText()) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (r64 > 0 && (!z7 || r64 >= 2)) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(r64 * r112, Integer.MIN_VALUE), makeMeasureSpec);
                        int measuredWidth = childAt.getMeasuredWidth();
                        r9 = measuredWidth / r112;
                        if (measuredWidth % r112 != 0) {
                            r9++;
                        }
                        if (z7 && r9 < 2) {
                            r9 = 2;
                        }
                    } else {
                        r9 = 0;
                    }
                    if (!layoutParams2.isOverflowButton && z7) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    layoutParams2.expandable = z8;
                    layoutParams2.cellsUsed = r9;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(r112 * r9, 1073741824), makeMeasureSpec);
                    r13 = Math.max(r13, r9);
                    if (layoutParams.expandable) {
                        r18++;
                    }
                    if (layoutParams.isOverflowButton) {
                        z10 = true;
                    }
                    r10 -= r9;
                    r42 = Math.max(r42, childAt.getMeasuredHeight());
                    if (r9 == 1) {
                        j |= 1 << r14;
                    }
                    r12 = r122;
                }
                r14++;
                size3 = r19;
                r22 = r20;
                paddingBottom = r21;
                mode = r23;
            }
            int r232 = mode;
            int r202 = r22;
            int r192 = size3;
            if (z10 && r12 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z12 = false;
            while (r18 > 0 && r10 > 0) {
                int r34 = Integer.MAX_VALUE;
                int r65 = 0;
                int r92 = 0;
                long j2 = 0;
                while (r92 < childCount2) {
                    LayoutParams layoutParams3 = (LayoutParams) getChildAt(r92).getLayoutParams();
                    boolean z13 = z12;
                    if (layoutParams3.expandable) {
                        int r24 = layoutParams3.cellsUsed;
                        if (r24 < r34) {
                            j2 = 1 << r92;
                            r34 = r24;
                            r65 = 1;
                        } else if (r24 == r34) {
                            j2 |= 1 << r92;
                            r65++;
                        }
                    }
                    r92++;
                    z12 = z13;
                }
                z3 = z12;
                j |= j2;
                if (r65 > r10) {
                    break;
                }
                int r35 = r34 + 1;
                int r25 = 0;
                while (r25 < childCount2) {
                    View childAt2 = getChildAt(r25);
                    LayoutParams layoutParams4 = (LayoutParams) childAt2.getLayoutParams();
                    int r27 = r42;
                    int r142 = childMeasureSpec;
                    int r28 = childCount2;
                    long j3 = 1 << r25;
                    if ((j2 & j3) == 0) {
                        if (layoutParams4.cellsUsed == r35) {
                            j |= j3;
                        }
                    } else {
                        if (z2 && layoutParams4.preventEdgeOffset) {
                            r4 = 1;
                            r4 = 1;
                            if (r10 == 1) {
                                childAt2.setPadding(r5 + r112, 0, r5, 0);
                            }
                        } else {
                            r4 = 1;
                        }
                        layoutParams4.cellsUsed += r4;
                        layoutParams4.expanded = r4;
                        r10--;
                    }
                    r25++;
                    childMeasureSpec = r142;
                    r42 = r27;
                    childCount2 = r28;
                }
                z12 = true;
            }
            z3 = z12;
            int r272 = r42;
            int r143 = childMeasureSpec;
            int r282 = childCount2;
            if (!z10 && r12 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (r10 > 0 && j != 0 && (r10 < r12 - 1 || z4 || r13 > 1)) {
                float bitCount = Long.bitCount(j);
                if (!z4) {
                    if ((j & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                        bitCount -= 0.5f;
                    }
                    int r82 = r282 - 1;
                    if ((j & (1 << r82)) != 0 && !((LayoutParams) getChildAt(r82).getLayoutParams()).preventEdgeOffset) {
                        bitCount -= 0.5f;
                    }
                }
                if (bitCount > 0.0f) {
                    r63 = (int) ((r10 * r112) / bitCount);
                } else {
                    r63 = 0;
                }
                boolean z14 = z3;
                r3 = r282;
                for (int r26 = 0; r26 < r3; r26++) {
                    if ((j & (1 << r26)) != 0) {
                        View childAt3 = getChildAt(r26);
                        LayoutParams layoutParams5 = (LayoutParams) childAt3.getLayoutParams();
                        if (childAt3 instanceof ActionMenuItemView) {
                            layoutParams5.extraPixels = r63;
                            layoutParams5.expanded = true;
                            if (r26 == 0 && !layoutParams5.preventEdgeOffset) {
                                ((LinearLayout.LayoutParams) layoutParams5).leftMargin = (-r63) / 2;
                            }
                            z14 = true;
                        } else {
                            if (layoutParams5.isOverflowButton) {
                                layoutParams5.extraPixels = r63;
                                layoutParams5.expanded = true;
                                ((LinearLayout.LayoutParams) layoutParams5).rightMargin = (-r63) / 2;
                                z14 = true;
                            } else {
                                if (r26 != 0) {
                                    ((LinearLayout.LayoutParams) layoutParams5).leftMargin = r63 / 2;
                                }
                                if (r26 != r3 - 1) {
                                    ((LinearLayout.LayoutParams) layoutParams5).rightMargin = r63 / 2;
                                }
                            }
                        }
                    }
                }
                z5 = z14;
            } else {
                r3 = r282;
                z5 = z3;
            }
            if (z5) {
                int r1 = 0;
                while (r1 < r3) {
                    View childAt4 = getChildAt(r1);
                    LayoutParams layoutParams6 = (LayoutParams) childAt4.getLayoutParams();
                    if (!layoutParams6.expanded) {
                        r62 = r143;
                    } else {
                        r62 = r143;
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams6.cellsUsed * r112) + layoutParams6.extraPixels, 1073741824), r62);
                    }
                    r1++;
                    r143 = r62;
                }
            }
            if (r232 != 1073741824) {
                r2 = r202;
                r6 = r272;
            } else {
                r6 = r192;
                r2 = r202;
            }
            setMeasuredDimension(r2, r6);
            return;
        }
        for (int r66 = 0; r66 < childCount; r66++) {
            LayoutParams layoutParams7 = (LayoutParams) getChildAt(r66).getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams7).rightMargin = 0;
            ((LinearLayout.LayoutParams) layoutParams7).leftMargin = 0;
        }
        super.onMeasure(r32, r33);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mPresenter.mExpandedActionViewsExclusive = z;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        ActionMenuPresenter.OverflowMenuButton overflowMenuButton = actionMenuPresenter.mOverflowButton;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        } else {
            actionMenuPresenter.mPendingOverflowIconSet = true;
            actionMenuPresenter.mPendingOverflowIcon = drawable;
        }
    }

    public void setOverflowReserved(boolean z) {
        this.mReserveOverflow = z;
    }

    public void setPopupTheme(int r3) {
        if (this.mPopupTheme != r3) {
            this.mPopupTheme = r3;
            if (r3 == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), r3);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        actionMenuPresenter.mMenuView = this;
        this.mMenu = actionMenuPresenter.mMenu;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        @ViewDebug.ExportedProperty
        public int cellsUsed;

        @ViewDebug.ExportedProperty
        public boolean expandable;
        public boolean expanded;

        @ViewDebug.ExportedProperty
        public int extraPixels;

        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;

        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams() {
            super(-2, -2);
            this.isOverflowButton = false;
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams();
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams != null) {
            if (layoutParams instanceof LayoutParams) {
                layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
            } else {
                layoutParams2 = new LayoutParams(layoutParams);
            }
            if (((LinearLayout.LayoutParams) layoutParams2).gravity <= 0) {
                ((LinearLayout.LayoutParams) layoutParams2).gravity = 16;
            }
            return layoutParams2;
        }
        LayoutParams layoutParams3 = new LayoutParams();
        ((LinearLayout.LayoutParams) layoutParams3).gravity = 16;
        return layoutParams3;
    }

    /* loaded from: classes.dex */
    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }
    }
}
