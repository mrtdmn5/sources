package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* loaded from: classes.dex */
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    public final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu != null) {
            this.mWrappedObject = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int r13, int r14, int r15, ComponentName componentName, Intent[] intentArr, Intent intent, int r19, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        } else {
            menuItemArr2 = null;
        }
        int addIntentOptions = this.mWrappedObject.addIntentOptions(r13, r14, r15, componentName, intentArr, intent, r19, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int r5 = 0; r5 < length; r5++) {
                menuItemArr[r5] = getMenuItemWrapper(menuItemArr2[r5]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public final void clear() {
        SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.mMenuItems;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap<SupportSubMenu, SubMenu> simpleArrayMap2 = this.mSubMenus;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
        this.mWrappedObject.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.mWrappedObject.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int r2) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(r2));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int r2) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(r2));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int r2, KeyEvent keyEvent) {
        return this.mWrappedObject.isShortcutKey(r2, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int r2, int r3) {
        return this.mWrappedObject.performIdentifierAction(r2, r3);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int r2, KeyEvent keyEvent, int r4) {
        return this.mWrappedObject.performShortcut(r2, keyEvent, r4);
    }

    @Override // android.view.Menu
    public final void removeGroup(int r4) {
        if (this.mMenuItems != null) {
            int r0 = 0;
            while (true) {
                SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.mMenuItems;
                if (r0 >= simpleArrayMap.mSize) {
                    break;
                }
                if (simpleArrayMap.keyAt(r0).getGroupId() == r4) {
                    this.mMenuItems.removeAt(r0);
                    r0--;
                }
                r0++;
            }
        }
        this.mWrappedObject.removeGroup(r4);
    }

    @Override // android.view.Menu
    public final void removeItem(int r4) {
        if (this.mMenuItems != null) {
            int r0 = 0;
            while (true) {
                SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.mMenuItems;
                if (r0 >= simpleArrayMap.mSize) {
                    break;
                }
                if (simpleArrayMap.keyAt(r0).getItemId() == r4) {
                    this.mMenuItems.removeAt(r0);
                    break;
                }
                r0++;
            }
        }
        this.mWrappedObject.removeItem(r4);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int r2, boolean z, boolean z2) {
        this.mWrappedObject.setGroupCheckable(r2, z, z2);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int r2, boolean z) {
        this.mWrappedObject.setGroupEnabled(r2, z);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int r2, boolean z) {
        this.mWrappedObject.setGroupVisible(r2, z);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.mWrappedObject.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.mWrappedObject.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int r2) {
        return getMenuItemWrapper(this.mWrappedObject.add(r2));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r2) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r2));
    }

    @Override // android.view.Menu
    public final MenuItem add(int r2, int r3, int r4, CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(r2, r3, r4, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r2, int r3, int r4, CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r2, r3, r4, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int r2, int r3, int r4, int r5) {
        return getMenuItemWrapper(this.mWrappedObject.add(r2, r3, r4, r5));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r2, int r3, int r4, int r5) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r2, r3, r4, r5));
    }
}
