package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* loaded from: classes.dex */
public abstract class BaseMenuWrapper {
    public final Context mContext;
    public SimpleArrayMap<SupportMenuItem, MenuItem> mMenuItems;
    public SimpleArrayMap<SupportSubMenu, SubMenu> mSubMenus;

    public BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    public final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
            if (this.mMenuItems == null) {
                this.mMenuItems = new SimpleArrayMap<>();
            }
            MenuItem orDefault = this.mMenuItems.getOrDefault(menuItem, null);
            if (orDefault == null) {
                MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.mContext, supportMenuItem);
                this.mMenuItems.put(supportMenuItem, menuItemWrapperICS);
                return menuItemWrapperICS;
            }
            return orDefault;
        }
        return menuItem;
    }

    public final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        if (subMenu instanceof SupportSubMenu) {
            SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
            if (this.mSubMenus == null) {
                this.mSubMenus = new SimpleArrayMap<>();
            }
            SubMenu orDefault = this.mSubMenus.getOrDefault(supportSubMenu, null);
            if (orDefault == null) {
                SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.mContext, supportSubMenu);
                this.mSubMenus.put(supportSubMenu, subMenuWrapperICS);
                return subMenuWrapperICS;
            }
            return orDefault;
        }
        return subMenu;
    }
}
