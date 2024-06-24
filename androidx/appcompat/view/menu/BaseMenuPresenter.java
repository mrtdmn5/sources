package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.appcompat.view.menu.MenuPresenter;
import com.kronaby.watch.app.R;

/* loaded from: classes.dex */
public abstract class BaseMenuPresenter implements MenuPresenter {
    public MenuPresenter.Callback mCallback;
    public Context mContext;
    public MenuBuilder mMenu;
    public MenuView mMenuView;
    public final Context mSystemContext;
    public final LayoutInflater mSystemInflater;
    public final int mMenuLayoutRes = R.layout.abc_action_menu_layout;
    public final int mItemLayoutRes = R.layout.abc_action_menu_item_layout;

    public BaseMenuPresenter(Context context) {
        this.mSystemContext = context;
        this.mSystemInflater = LayoutInflater.from(context);
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
    public final void setCallback(MenuPresenter.Callback callback) {
        this.mCallback = callback;
    }
}
