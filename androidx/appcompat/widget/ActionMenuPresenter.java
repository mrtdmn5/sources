package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.view.ActionProvider;
import com.kronaby.watch.app.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ActionMenuPresenter extends BaseMenuPresenter {
    public final SparseBooleanArray mActionButtonGroups;
    public ActionButtonSubmenu mActionButtonPopup;
    public int mActionItemWidthLimit;
    public boolean mExpandedActionViewsExclusive;
    public int mMaxItems;
    public OverflowMenuButton mOverflowButton;
    public OverflowPopup mOverflowPopup;
    public Drawable mPendingOverflowIcon;
    public boolean mPendingOverflowIconSet;
    public ActionMenuPopupCallback mPopupCallback;
    public final PopupPresenterCallback mPopupPresenterCallback;
    public OpenOverflowRunnable mPostedOpenRunnable;
    public boolean mReserveOverflow;
    public boolean mReserveOverflowSet;
    public int mWidthLimit;

    /* loaded from: classes.dex */
    public class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false);
            if (!((subMenuBuilder.mItem.mFlags & 32) == 32)) {
                View view2 = ActionMenuPresenter.this.mOverflowButton;
                this.mAnchorView = view2 == null ? (View) ActionMenuPresenter.this.mMenuView : view2;
            }
            PopupPresenterCallback popupPresenterCallback = ActionMenuPresenter.this.mPopupPresenterCallback;
            this.mPresenterCallback = popupPresenterCallback;
            MenuPopup menuPopup = this.mPopup;
            if (menuPopup != null) {
                menuPopup.setCallback(popupPresenterCallback);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public final void onDismiss() {
            ActionMenuPresenter.this.mActionButtonPopup = null;
            super.onDismiss();
        }
    }

    /* loaded from: classes.dex */
    public class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        public ActionMenuPopupCallback() {
        }
    }

    /* loaded from: classes.dex */
    public class OpenOverflowRunnable implements Runnable {
        public final OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MenuBuilder.Callback callback;
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
            if (menuBuilder != null && (callback = menuBuilder.mCallback) != null) {
                callback.onMenuModeChange(menuBuilder);
            }
            View view = (View) actionMenuPresenter.mMenuView;
            if (view != null && view.getWindowToken() != null) {
                OverflowPopup overflowPopup = this.mPopup;
                boolean z = true;
                if (!overflowPopup.isShowing()) {
                    if (overflowPopup.mAnchorView == null) {
                        z = false;
                    } else {
                        overflowPopup.showPopup(0, 0, false, false);
                    }
                }
                if (z) {
                    actionMenuPresenter.mOverflowPopup = overflowPopup;
                }
            }
            actionMenuPresenter.mPostedOpenRunnable = null;
        }
    }

    /* loaded from: classes.dex */
    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this) { // from class: androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton.1
                @Override // androidx.appcompat.widget.ForwardingListener
                public final ShowableListMenu getPopup() {
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.mOverflowPopup;
                    if (overflowPopup == null) {
                        return null;
                    }
                    return overflowPopup.getPopup();
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public final boolean onForwardingStarted() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public final boolean onForwardingStopped() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.mPostedOpenRunnable != null) {
                        return false;
                    }
                    actionMenuPresenter.hideOverflowMenu();
                    return true;
                }
            });
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public final boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public final boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public final boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.showOverflowMenu();
            return true;
        }

        @Override // android.widget.ImageView
        public final boolean setFrame(int r5, int r6, int r7, int r8) {
            boolean frame = super.setFrame(r5, r6, r7, r8);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat$Api21Impl.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* loaded from: classes.dex */
    public class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, OverflowMenuButton overflowMenuButton) {
            super(context, menuBuilder, overflowMenuButton, true);
            this.mDropDownGravity = 8388613;
            PopupPresenterCallback popupPresenterCallback = ActionMenuPresenter.this.mPopupPresenterCallback;
            this.mPresenterCallback = popupPresenterCallback;
            MenuPopup menuPopup = this.mPopup;
            if (menuPopup != null) {
                menuPopup.setCallback(popupPresenterCallback);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public final void onDismiss() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
            if (menuBuilder != null) {
                menuBuilder.close(true);
            }
            actionMenuPresenter.mOverflowPopup = null;
            super.onDismiss();
        }
    }

    /* loaded from: classes.dex */
    public class PopupPresenterCallback implements MenuPresenter.Callback {
        public PopupPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.mCallback;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            if (menuBuilder == actionMenuPresenter.mMenu) {
                return false;
            }
            ((SubMenuBuilder) menuBuilder).mItem.getClass();
            actionMenuPresenter.getClass();
            MenuPresenter.Callback callback = actionMenuPresenter.mCallback;
            if (callback == null) {
                return false;
            }
            return callback.onOpenSubMenu(menuBuilder);
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        int r4;
        ArrayList<MenuItemImpl> arrayList;
        int r13;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            r4 = arrayList.size();
        } else {
            r4 = 0;
            arrayList = null;
        }
        int r5 = actionMenuPresenter.mMaxItems;
        int r6 = actionMenuPresenter.mActionItemWidthLimit;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.mMenuView;
        int r9 = 0;
        boolean z9 = false;
        int r11 = 0;
        int r12 = 0;
        while (true) {
            r13 = 2;
            z = true;
            if (r9 >= r4) {
                break;
            }
            MenuItemImpl menuItemImpl = arrayList.get(r9);
            int r3 = menuItemImpl.mShowAsAction;
            if ((r3 & 2) == 2) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                r11++;
            } else {
                if ((r3 & 1) == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8) {
                    r12++;
                } else {
                    z9 = true;
                }
            }
            if (actionMenuPresenter.mExpandedActionViewsExclusive && menuItemImpl.mIsActionViewExpanded) {
                r5 = 0;
            }
            r9++;
        }
        if (actionMenuPresenter.mReserveOverflow && (z9 || r12 + r11 > r5)) {
            r5--;
        }
        int r52 = r5 - r11;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.mActionButtonGroups;
        sparseBooleanArray.clear();
        int r32 = 0;
        int r92 = 0;
        while (r32 < r4) {
            MenuItemImpl menuItemImpl2 = arrayList.get(r32);
            int r112 = menuItemImpl2.mShowAsAction;
            if ((r112 & 2) == r13) {
                z2 = z;
            } else {
                z2 = false;
            }
            int r15 = menuItemImpl2.mGroup;
            if (z2) {
                View itemView = actionMenuPresenter.getItemView(menuItemImpl2, null, viewGroup);
                itemView.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = itemView.getMeasuredWidth();
                r6 -= measuredWidth;
                if (r92 == 0) {
                    r92 = measuredWidth;
                }
                if (r15 != 0) {
                    sparseBooleanArray.put(r15, z);
                }
                menuItemImpl2.setIsActionButton(z);
            } else {
                if ((r112 & 1) == z) {
                    z3 = z;
                } else {
                    z3 = false;
                }
                if (z3) {
                    boolean z10 = sparseBooleanArray.get(r15);
                    if ((r52 > 0 || z10) && r6 > 0) {
                        z4 = z;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        View itemView2 = actionMenuPresenter.getItemView(menuItemImpl2, null, viewGroup);
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                        int measuredWidth2 = itemView2.getMeasuredWidth();
                        r6 -= measuredWidth2;
                        if (r92 == 0) {
                            r92 = measuredWidth2;
                        }
                        if (r6 + r92 > 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z4 &= z6;
                    }
                    if (z4 && r15 != 0) {
                        sparseBooleanArray.put(r15, true);
                    } else if (z10) {
                        sparseBooleanArray.put(r15, false);
                        for (int r113 = 0; r113 < r32; r113++) {
                            MenuItemImpl menuItemImpl3 = arrayList.get(r113);
                            if (menuItemImpl3.mGroup == r15) {
                                if ((menuItemImpl3.mFlags & 32) == 32) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (z5) {
                                    r52++;
                                }
                                menuItemImpl3.setIsActionButton(false);
                            }
                        }
                    }
                    if (z4) {
                        r52--;
                    }
                    menuItemImpl2.setIsActionButton(z4);
                } else {
                    menuItemImpl2.setIsActionButton(false);
                    r32++;
                    r13 = 2;
                    actionMenuPresenter = this;
                    z = true;
                }
            }
            r32++;
            r13 = 2;
            actionMenuPresenter = this;
            z = true;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.appcompat.view.menu.MenuView$ItemView] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        ActionMenuItemView actionMenuItemView;
        View actionView = menuItemImpl.getActionView();
        int r1 = 0;
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            if (view instanceof MenuView.ItemView) {
                actionMenuItemView = (MenuView.ItemView) view;
            } else {
                actionMenuItemView = (MenuView.ItemView) this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
            }
            actionMenuItemView.initialize(menuItemImpl);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.mMenuView);
            if (this.mPopupCallback == null) {
                this.mPopupCallback = new ActionMenuPopupCallback();
            }
            actionMenuItemView2.setPopupCallback(this.mPopupCallback);
            actionView = actionMenuItemView;
        }
        if (menuItemImpl.mIsActionViewExpanded) {
            r1 = 8;
        }
        actionView.setVisibility(r1);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public final boolean hideOverflowMenu() {
        Object obj;
        OpenOverflowRunnable openOverflowRunnable = this.mPostedOpenRunnable;
        if (openOverflowRunnable != null && (obj = this.mMenuView) != null) {
            ((View) obj).removeCallbacks(openOverflowRunnable);
            this.mPostedOpenRunnable = null;
            return true;
        }
        OverflowPopup overflowPopup = this.mOverflowPopup;
        if (overflowPopup != null) {
            if (overflowPopup.isShowing()) {
                overflowPopup.mPopup.dismiss();
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.mContext = context;
        LayoutInflater.from(context);
        this.mMenu = menuBuilder;
        Resources resources = context.getResources();
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = true;
        }
        int r1 = 2;
        this.mWidthLimit = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int r0 = configuration.screenWidthDp;
        int r2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && r0 <= 600 && ((r0 <= 960 || r2 <= 720) && (r0 <= 720 || r2 <= 960))) {
            if (r0 < 500 && ((r0 <= 640 || r2 <= 480) && (r0 <= 480 || r2 <= 640))) {
                if (r0 >= 360) {
                    r1 = 3;
                }
            } else {
                r1 = 4;
            }
        } else {
            r1 = 5;
        }
        this.mMaxItems = r1;
        int r5 = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.mSystemContext);
                this.mOverflowButton = overflowMenuButton;
                if (this.mPendingOverflowIconSet) {
                    overflowMenuButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(makeMeasureSpec, makeMeasureSpec);
            }
            r5 -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = r5;
        float f = resources.getDisplayMetrics().density;
    }

    public final boolean isOverflowMenuShowing() {
        OverflowPopup overflowPopup = this.mOverflowPopup;
        if (overflowPopup != null && overflowPopup.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        hideOverflowMenu();
        ActionButtonSubmenu actionButtonSubmenu = this.mActionButtonPopup;
        if (actionButtonSubmenu != null && actionButtonSubmenu.isShowing()) {
            actionButtonSubmenu.mPopup.dismiss();
        }
        MenuPresenter.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008e  */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder r9) {
        /*
            r8 = this;
            boolean r0 = r9.hasVisibleItems()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            r0 = r9
        L9:
            androidx.appcompat.view.menu.MenuBuilder r2 = r0.mParentMenu
            androidx.appcompat.view.menu.MenuBuilder r3 = r8.mMenu
            if (r2 == r3) goto L13
            r0 = r2
            androidx.appcompat.view.menu.SubMenuBuilder r0 = (androidx.appcompat.view.menu.SubMenuBuilder) r0
            goto L9
        L13:
            androidx.appcompat.view.menu.MenuView r2 = r8.mMenuView
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            if (r2 != 0) goto L1a
            goto L38
        L1a:
            int r3 = r2.getChildCount()
            r4 = r1
        L1f:
            if (r4 >= r3) goto L38
            android.view.View r5 = r2.getChildAt(r4)
            boolean r6 = r5 instanceof androidx.appcompat.view.menu.MenuView.ItemView
            if (r6 == 0) goto L35
            r6 = r5
            androidx.appcompat.view.menu.MenuView$ItemView r6 = (androidx.appcompat.view.menu.MenuView.ItemView) r6
            androidx.appcompat.view.menu.MenuItemImpl r6 = r6.getItemData()
            androidx.appcompat.view.menu.MenuItemImpl r7 = r0.mItem
            if (r6 != r7) goto L35
            goto L39
        L35:
            int r4 = r4 + 1
            goto L1f
        L38:
            r5 = 0
        L39:
            if (r5 != 0) goto L3c
            return r1
        L3c:
            androidx.appcompat.view.menu.MenuItemImpl r0 = r9.mItem
            r0.getClass()
            int r0 = r9.size()
            r2 = r1
        L46:
            r3 = 1
            if (r2 >= r0) goto L5e
            android.view.MenuItem r4 = r9.getItem(r2)
            boolean r6 = r4.isVisible()
            if (r6 == 0) goto L5b
            android.graphics.drawable.Drawable r4 = r4.getIcon()
            if (r4 == 0) goto L5b
            r0 = r3
            goto L5f
        L5b:
            int r2 = r2 + 1
            goto L46
        L5e:
            r0 = r1
        L5f:
            androidx.appcompat.widget.ActionMenuPresenter$ActionButtonSubmenu r2 = new androidx.appcompat.widget.ActionMenuPresenter$ActionButtonSubmenu
            android.content.Context r4 = r8.mContext
            r2.<init>(r4, r9, r5)
            r8.mActionButtonPopup = r2
            r2.mForceShowIcon = r0
            androidx.appcompat.view.menu.MenuPopup r2 = r2.mPopup
            if (r2 == 0) goto L71
            r2.setForceShowIcon(r0)
        L71:
            androidx.appcompat.widget.ActionMenuPresenter$ActionButtonSubmenu r0 = r8.mActionButtonPopup
            boolean r2 = r0.isShowing()
            if (r2 == 0) goto L7b
        L79:
            r1 = r3
            goto L84
        L7b:
            android.view.View r2 = r0.mAnchorView
            if (r2 != 0) goto L80
            goto L84
        L80:
            r0.showPopup(r1, r1, r1, r1)
            goto L79
        L84:
            if (r1 == 0) goto L8e
            androidx.appcompat.view.menu.MenuPresenter$Callback r0 = r8.mCallback
            if (r0 == 0) goto L8d
            r0.onOpenSubMenu(r9)
        L8d:
            return r3
        L8e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "MenuPopupHelper cannot be used without an anchor"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuPresenter.onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder):boolean");
    }

    public final boolean showOverflowMenu() {
        MenuBuilder menuBuilder;
        if (this.mReserveOverflow && !isOverflowMenuShowing() && (menuBuilder = this.mMenu) != null && this.mMenuView != null && this.mPostedOpenRunnable == null) {
            menuBuilder.flagActionItems();
            if (!menuBuilder.mNonActionItems.isEmpty()) {
                OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton));
                this.mPostedOpenRunnable = openOverflowRunnable;
                ((View) this.mMenuView).post(openOverflowRunnable);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView() {
        int r7;
        boolean z;
        boolean z2;
        MenuItemImpl menuItemImpl;
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        ArrayList<MenuItemImpl> arrayList = null;
        boolean z3 = false;
        if (viewGroup != null) {
            MenuBuilder menuBuilder = this.mMenu;
            if (menuBuilder != null) {
                menuBuilder.flagActionItems();
                ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
                int size = visibleItems.size();
                r7 = 0;
                for (int r6 = 0; r6 < size; r6++) {
                    MenuItemImpl menuItemImpl2 = visibleItems.get(r6);
                    if ((menuItemImpl2.mFlags & 32) == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        View childAt = viewGroup.getChildAt(r7);
                        if (childAt instanceof MenuView.ItemView) {
                            menuItemImpl = ((MenuView.ItemView) childAt).getItemData();
                        } else {
                            menuItemImpl = null;
                        }
                        View itemView = getItemView(menuItemImpl2, childAt, viewGroup);
                        if (menuItemImpl2 != menuItemImpl) {
                            itemView.setPressed(false);
                            itemView.jumpDrawablesToCurrentState();
                        }
                        if (itemView != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) itemView.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(itemView);
                            }
                            ((ViewGroup) this.mMenuView).addView(itemView, r7);
                        }
                        r7++;
                    }
                }
            } else {
                r7 = 0;
            }
            while (r7 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(r7) == this.mOverflowButton) {
                    z = false;
                } else {
                    viewGroup.removeViewAt(r7);
                    z = true;
                }
                if (!z) {
                    r7++;
                }
            }
        }
        ((View) this.mMenuView).requestLayout();
        MenuBuilder menuBuilder2 = this.mMenu;
        if (menuBuilder2 != null) {
            menuBuilder2.flagActionItems();
            ArrayList<MenuItemImpl> arrayList2 = menuBuilder2.mActionItems;
            int size2 = arrayList2.size();
            for (int r5 = 0; r5 < size2; r5++) {
                ActionProvider actionProvider = arrayList2.get(r5).mActionProvider;
            }
        }
        MenuBuilder menuBuilder3 = this.mMenu;
        if (menuBuilder3 != null) {
            menuBuilder3.flagActionItems();
            arrayList = menuBuilder3.mNonActionItems;
        }
        if (this.mReserveOverflow && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z3 = !arrayList.get(0).mIsActionViewExpanded;
            } else if (size3 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.mOverflowButton.getParent();
            if (viewGroup3 != this.mMenuView) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.mOverflowButton);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                OverflowMenuButton overflowMenuButton = this.mOverflowButton;
                actionMenuView.getClass();
                ActionMenuView.LayoutParams layoutParams = new ActionMenuView.LayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
                layoutParams.isOverflowButton = true;
                actionMenuView.addView(overflowMenuButton, layoutParams);
            }
        } else {
            OverflowMenuButton overflowMenuButton2 = this.mOverflowButton;
            if (overflowMenuButton2 != null) {
                Object parent = overflowMenuButton2.getParent();
                Object obj = this.mMenuView;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.mOverflowButton);
                }
            }
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
