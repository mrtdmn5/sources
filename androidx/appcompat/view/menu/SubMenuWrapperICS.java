package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportSubMenu;

/* loaded from: classes.dex */
public final class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    public final SupportSubMenu mSubMenu;

    public SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
        this.mSubMenu = supportSubMenu;
    }

    @Override // android.view.SubMenu
    public final void clearHeader() {
        this.mSubMenu.clearHeader();
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return getMenuItemWrapper(this.mSubMenu.getItem());
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int r2) {
        this.mSubMenu.setHeaderIcon(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int r2) {
        this.mSubMenu.setHeaderTitle(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        this.mSubMenu.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int r2) {
        this.mSubMenu.setIcon(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        this.mSubMenu.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        this.mSubMenu.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.mSubMenu.setIcon(drawable);
        return this;
    }
}
