package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import com.kronaby.watch.app.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    public MenuAdapter mAdapter;
    public MenuPresenter.Callback mCallback;
    public Context mContext;
    public LayoutInflater mInflater;
    public MenuBuilder mMenu;
    public ExpandedMenuView mMenuView;

    /* loaded from: classes.dex */
    public class MenuAdapter extends BaseAdapter {
        public int mExpandedIndex = -1;

        public MenuAdapter() {
            findExpandedIndex();
        }

        public final void findExpandedIndex() {
            MenuBuilder menuBuilder = ListMenuPresenter.this.mMenu;
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
            ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
            MenuBuilder menuBuilder = listMenuPresenter.mMenu;
            menuBuilder.flagActionItems();
            int size = menuBuilder.mNonActionItems.size();
            listMenuPresenter.getClass();
            int r1 = size + 0;
            if (this.mExpandedIndex < 0) {
                return r1;
            }
            return r1 - 1;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int r3) {
            return r3;
        }

        @Override // android.widget.Adapter
        public final View getView(int r3, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ListMenuPresenter.this.mInflater.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
            }
            ((MenuView.ItemView) view).initialize(getItem(r3));
            return view;
        }

        @Override // android.widget.BaseAdapter
        public final void notifyDataSetChanged() {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public final MenuItemImpl getItem(int r3) {
            ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
            MenuBuilder menuBuilder = listMenuPresenter.mMenu;
            menuBuilder.flagActionItems();
            ArrayList<MenuItemImpl> arrayList = menuBuilder.mNonActionItems;
            listMenuPresenter.getClass();
            int r32 = r3 + 0;
            int r0 = this.mExpandedIndex;
            if (r0 >= 0 && r32 >= r0) {
                r32++;
            }
            return arrayList.get(r32);
        }
    }

    public ListMenuPresenter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.mContext != null) {
            this.mContext = context;
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(context);
            }
        }
        this.mMenu = menuBuilder;
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int r3, long j) {
        this.mMenu.performItemAction(this.mAdapter.getItem(r3), this, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        MenuDialogHelper menuDialogHelper = new MenuDialogHelper(subMenuBuilder);
        Context context = subMenuBuilder.mContext;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertController.AlertParams alertParams = builder.P;
        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(alertParams.mContext);
        menuDialogHelper.mPresenter = listMenuPresenter;
        listMenuPresenter.mCallback = menuDialogHelper;
        subMenuBuilder.addMenuPresenter(listMenuPresenter, context);
        ListMenuPresenter listMenuPresenter2 = menuDialogHelper.mPresenter;
        if (listMenuPresenter2.mAdapter == null) {
            listMenuPresenter2.mAdapter = new MenuAdapter();
        }
        alertParams.mAdapter = listMenuPresenter2.mAdapter;
        alertParams.mOnClickListener = menuDialogHelper;
        View view = subMenuBuilder.mHeaderView;
        if (view != null) {
            alertParams.mCustomTitleView = view;
        } else {
            alertParams.mIcon = subMenuBuilder.mHeaderIcon;
            alertParams.mTitle = subMenuBuilder.mHeaderTitle;
        }
        alertParams.mOnKeyListener = menuDialogHelper;
        AlertDialog create = builder.create();
        menuDialogHelper.mDialog = create;
        create.setOnDismissListener(menuDialogHelper);
        WindowManager.LayoutParams attributes = menuDialogHelper.mDialog.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        menuDialogHelper.mDialog.show();
        MenuPresenter.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
            return true;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
        this.mCallback = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView() {
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
