package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public View mAnchorView;
    public final Context mContext;
    public boolean mHasXOffset;
    public boolean mHasYOffset;
    public int mLastPosition;
    public final int mMenuMaxWidth;
    public PopupWindow.OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public final int mPopupStyleAttr;
    public final int mPopupStyleRes;
    public MenuPresenter.Callback mPresenterCallback;
    public boolean mShouldCloseImmediately;
    public boolean mShowTitle;
    public View mShownAnchorView;
    public final Handler mSubMenuHoverHandler;
    public ViewTreeObserver mTreeObserver;
    public int mXOffset;
    public int mYOffset;
    public final ArrayList mPendingMenus = new ArrayList();
    public final ArrayList mShowingMenus = new ArrayList();
    public final AnonymousClass1 mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
            if (cascadingMenuPopup.isShowing()) {
                ArrayList arrayList = cascadingMenuPopup.mShowingMenus;
                if (arrayList.size() > 0 && !((CascadingMenuInfo) arrayList.get(0)).window.mModal) {
                    View view = cascadingMenuPopup.mShownAnchorView;
                    if (view != null && view.isShown()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((CascadingMenuInfo) it.next()).window.show();
                        }
                        return;
                    }
                    cascadingMenuPopup.dismiss();
                }
            }
        }
    };
    public final AnonymousClass2 mAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
            ViewTreeObserver viewTreeObserver = cascadingMenuPopup.mTreeObserver;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    cascadingMenuPopup.mTreeObserver = view.getViewTreeObserver();
                }
                cascadingMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(cascadingMenuPopup.mGlobalLayoutListener);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }
    };
    public final AnonymousClass3 mMenuItemHoverListener = new MenuItemHoverListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3
        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public final void onItemHoverEnter(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
            CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
            final CascadingMenuInfo cascadingMenuInfo = null;
            cascadingMenuPopup.mSubMenuHoverHandler.removeCallbacksAndMessages(null);
            ArrayList arrayList = cascadingMenuPopup.mShowingMenus;
            int size = arrayList.size();
            int r4 = 0;
            while (true) {
                if (r4 < size) {
                    if (menuBuilder == ((CascadingMenuInfo) arrayList.get(r4)).menu) {
                        break;
                    } else {
                        r4++;
                    }
                } else {
                    r4 = -1;
                    break;
                }
            }
            if (r4 == -1) {
                return;
            }
            int r42 = r4 + 1;
            if (r42 < arrayList.size()) {
                cascadingMenuInfo = (CascadingMenuInfo) arrayList.get(r42);
            }
            cascadingMenuPopup.mSubMenuHoverHandler.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    CascadingMenuInfo cascadingMenuInfo2 = cascadingMenuInfo;
                    if (cascadingMenuInfo2 != null) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        CascadingMenuPopup.this.mShouldCloseImmediately = true;
                        cascadingMenuInfo2.menu.close(false);
                        CascadingMenuPopup.this.mShouldCloseImmediately = false;
                    }
                    MenuItem menuItem = menuItemImpl;
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        menuBuilder.performItemAction(menuItem, null, 4);
                    }
                }
            }, menuBuilder, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public final void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
        }
    };
    public int mRawDropDownGravity = 0;
    public int mDropDownGravity = 0;
    public boolean mForceShowIcon = false;

    /* loaded from: classes.dex */
    public static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int r3) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = r3;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.appcompat.view.menu.CascadingMenuPopup$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.appcompat.view.menu.CascadingMenuPopup$2] */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.appcompat.view.menu.CascadingMenuPopup$3] */
    public CascadingMenuPopup(Context context, View view, int r4, int r5, boolean z) {
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = r4;
        this.mPopupStyleRes = r5;
        this.mOverflowOnly = z;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        this.mLastPosition = ViewCompat.Api17Impl.getLayoutDirection(view) != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.mMenuMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(menuBuilder);
        } else {
            this.mPendingMenus.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) arrayList.toArray(new CascadingMenuInfo[size]);
            while (true) {
                size--;
                if (size >= 0) {
                    CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[size];
                    if (cascadingMenuInfo.window.isShowing()) {
                        cascadingMenuInfo.window.dismiss();
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final DropDownListView getListView() {
        ArrayList arrayList = this.mShowingMenus;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((CascadingMenuInfo) arrayList.get(arrayList.size() - 1)).window.mDropDownList;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean isShowing() {
        ArrayList arrayList = this.mShowingMenus;
        if (arrayList.size() <= 0 || !((CascadingMenuInfo) arrayList.get(0)).window.isShowing()) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int r5;
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int r3 = 0;
        while (true) {
            if (r3 < size) {
                if (menuBuilder == ((CascadingMenuInfo) arrayList.get(r3)).menu) {
                    break;
                } else {
                    r3++;
                }
            } else {
                r3 = -1;
                break;
            }
        }
        if (r3 < 0) {
            return;
        }
        int r1 = r3 + 1;
        if (r1 < arrayList.size()) {
            ((CascadingMenuInfo) arrayList.get(r1)).menu.close(false);
        }
        CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) arrayList.remove(r3);
        cascadingMenuInfo.menu.removeMenuPresenter(this);
        boolean z2 = this.mShouldCloseImmediately;
        MenuPopupWindow menuPopupWindow = cascadingMenuInfo.window;
        if (z2) {
            menuPopupWindow.mPopup.setExitTransition(null);
            menuPopupWindow.mPopup.setAnimationStyle(0);
        }
        menuPopupWindow.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.mLastPosition = ((CascadingMenuInfo) arrayList.get(size2 - 1)).position;
        } else {
            View view = this.mAnchorView;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api17Impl.getLayoutDirection(view) == 1) {
                r5 = 0;
            } else {
                r5 = 1;
            }
            this.mLastPosition = r5;
        }
        if (size2 == 0) {
            dismiss();
            MenuPresenter.Callback callback = this.mPresenterCallback;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, true);
            }
            ViewTreeObserver viewTreeObserver = this.mTreeObserver;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
                }
                this.mTreeObserver = null;
            }
            this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
            this.mOnDismissListener.onDismiss();
            return;
        }
        if (z) {
            ((CascadingMenuInfo) arrayList.get(0)).menu.close(false);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int r3 = 0;
        while (true) {
            if (r3 < size) {
                cascadingMenuInfo = (CascadingMenuInfo) arrayList.get(r3);
                if (!cascadingMenuInfo.window.isShowing()) {
                    break;
                } else {
                    r3++;
                }
            } else {
                cascadingMenuInfo = null;
                break;
            }
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int r2, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && r2 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        Iterator it = this.mShowingMenus.iterator();
        while (it.hasNext()) {
            CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) it.next();
            if (subMenuBuilder == cascadingMenuInfo.menu) {
                cascadingMenuInfo.window.mDropDownList.requestFocus();
                return true;
            }
        }
        if (subMenuBuilder.hasVisibleItems()) {
            addMenu(subMenuBuilder);
            MenuPresenter.Callback callback = this.mPresenterCallback;
            if (callback != null) {
                callback.onOpenSubMenu(subMenuBuilder);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setAnchorView(View view) {
        if (this.mAnchorView != view) {
            this.mAnchorView = view;
            int r0 = this.mRawDropDownGravity;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(r0, ViewCompat.Api17Impl.getLayoutDirection(view));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setGravity(int r3) {
        if (this.mRawDropDownGravity != r3) {
            this.mRawDropDownGravity = r3;
            View view = this.mAnchorView;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(r3, ViewCompat.Api17Impl.getLayoutDirection(view));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setHorizontalOffset(int r2) {
        this.mHasXOffset = true;
        this.mXOffset = r2;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setShowTitle(boolean z) {
        this.mShowTitle = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setVerticalOffset(int r2) {
        this.mHasYOffset = true;
        this.mYOffset = r2;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void show() {
        boolean z;
        if (isShowing()) {
            return;
        }
        ArrayList arrayList = this.mPendingMenus;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            showMenu((MenuBuilder) it.next());
        }
        arrayList.clear();
        View view = this.mAnchorView;
        this.mShownAnchorView = view;
        if (view != null) {
            if (this.mTreeObserver == null) {
                z = true;
            } else {
                z = false;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.mTreeObserver = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            }
            this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showMenu(androidx.appcompat.view.menu.MenuBuilder r19) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.CascadingMenuPopup.showMenu(androidx.appcompat.view.menu.MenuBuilder):void");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView() {
        Iterator it = this.mShowingMenus.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((CascadingMenuInfo) it.next()).window.mDropDownList.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((MenuAdapter) adapter).notifyDataSetChanged();
        }
    }
}
