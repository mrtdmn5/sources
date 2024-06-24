package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public abstract class MenuPopup implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {
    public Rect mEpicenterBounds;

    public static int measureIndividualMenuWidth(MenuAdapter menuAdapter, Context context, int r12) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = menuAdapter.getCount();
        int r5 = 0;
        int r6 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int r0 = 0; r0 < count; r0++) {
            int itemViewType = menuAdapter.getItemViewType(r0);
            if (itemViewType != r6) {
                view = null;
                r6 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = menuAdapter.getView(r0, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= r12) {
                return r12;
            }
            if (measuredWidth > r5) {
                r5 = measuredWidth;
            }
        }
        return r5;
    }

    public static boolean shouldPreserveIconSpacing(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int r2 = 0; r2 < size; r2++) {
            MenuItem item = menuBuilder.getItem(r2);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void addMenu(MenuBuilder menuBuilder);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int r3, long j) {
        MenuAdapter menuAdapter;
        int r32;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            menuAdapter = (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) listAdapter;
        }
        MenuBuilder menuBuilder = menuAdapter.mAdapterMenu;
        MenuItem menuItem = (MenuItem) listAdapter.getItem(r3);
        if (!(this instanceof CascadingMenuPopup)) {
            r32 = 0;
        } else {
            r32 = 4;
        }
        menuBuilder.performItemAction(menuItem, this, r32);
    }

    public abstract void setAnchorView(View view);

    public abstract void setForceShowIcon(boolean z);

    public abstract void setGravity(int r1);

    public abstract void setHorizontalOffset(int r1);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener);

    public abstract void setShowTitle(boolean z);

    public abstract void setVerticalOffset(int r1);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
    }
}
