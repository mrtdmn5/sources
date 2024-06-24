package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class MenuAdapter extends BaseAdapter {
    public final MenuBuilder mAdapterMenu;
    public int mExpandedIndex = -1;
    public boolean mForceShowIcon;
    public final LayoutInflater mInflater;
    public final int mItemLayoutRes;
    public final boolean mOverflowOnly;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int r5) {
        this.mOverflowOnly = z;
        this.mInflater = layoutInflater;
        this.mAdapterMenu = menuBuilder;
        this.mItemLayoutRes = r5;
        findExpandedIndex();
    }

    public final void findExpandedIndex() {
        MenuBuilder menuBuilder = this.mAdapterMenu;
        MenuItemImpl menuItemImpl = menuBuilder.mExpandedItem;
        if (menuItemImpl != null) {
            menuBuilder.flagActionItems();
            ArrayList<MenuItemImpl> arrayList = menuBuilder.mNonActionItems;
            int size = arrayList.size();
            for (int r3 = 0; r3 < size; r3++) {
                if (arrayList.get(r3) == menuItemImpl) {
                    this.mExpandedIndex = r3;
                    return;
                }
            }
        }
        this.mExpandedIndex = -1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<MenuItemImpl> visibleItems;
        boolean z = this.mOverflowOnly;
        MenuBuilder menuBuilder = this.mAdapterMenu;
        if (z) {
            menuBuilder.flagActionItems();
            visibleItems = menuBuilder.mNonActionItems;
        } else {
            visibleItems = menuBuilder.getVisibleItems();
        }
        if (this.mExpandedIndex < 0) {
            return visibleItems.size();
        }
        return visibleItems.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r3) {
        return r3;
    }

    @Override // android.widget.Adapter
    public final View getView(int r6, View view, ViewGroup viewGroup) {
        int r1;
        boolean z = false;
        if (view == null) {
            view = this.mInflater.inflate(this.mItemLayoutRes, viewGroup, false);
        }
        int r8 = getItem(r6).mGroup;
        int r12 = r6 - 1;
        if (r12 >= 0) {
            r1 = getItem(r12).mGroup;
        } else {
            r1 = r8;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.mAdapterMenu.isGroupDividerEnabled() && r8 != r1) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.mForceShowIcon) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.initialize(getItem(r6));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final MenuItemImpl getItem(int r3) {
        ArrayList<MenuItemImpl> visibleItems;
        boolean z = this.mOverflowOnly;
        MenuBuilder menuBuilder = this.mAdapterMenu;
        if (z) {
            menuBuilder.flagActionItems();
            visibleItems = menuBuilder.mNonActionItems;
        } else {
            visibleItems = menuBuilder.getVisibleItems();
        }
        int r1 = this.mExpandedIndex;
        if (r1 >= 0 && r3 >= r1) {
            r3++;
        }
        return visibleItems.get(r3);
    }
}
