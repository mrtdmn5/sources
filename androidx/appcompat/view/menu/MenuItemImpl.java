package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {
    public ActionProvider mActionProvider;
    public View mActionView;
    public final int mCategoryOrder;
    public MenuItem.OnMenuItemClickListener mClickListener;
    public CharSequence mContentDescription;
    public final int mGroup;
    public Drawable mIconDrawable;
    public final int mId;
    public Intent mIntent;
    public final MenuBuilder mMenu;
    public MenuItem.OnActionExpandListener mOnActionExpandListener;
    public final int mOrdering;
    public char mShortcutAlphabeticChar;
    public char mShortcutNumericChar;
    public int mShowAsAction;
    public SubMenuBuilder mSubMenu;
    public CharSequence mTitle;
    public CharSequence mTitleCondensed;
    public CharSequence mTooltipText;
    public int mShortcutNumericModifiers = 4096;
    public int mShortcutAlphabeticModifiers = 4096;
    public int mIconResId = 0;
    public ColorStateList mIconTintList = null;
    public PorterDuff.Mode mIconTintMode = null;
    public boolean mHasIconTint = false;
    public boolean mHasIconTintMode = false;
    public boolean mNeedToApplyIconTint = false;
    public int mFlags = 16;
    public boolean mIsActionViewExpanded = false;

    /* renamed from: androidx.appcompat.view.menu.MenuItemImpl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ActionProvider.VisibilityListener {
        public AnonymousClass1() {
        }
    }

    public MenuItemImpl(MenuBuilder menuBuilder, int r4, int r5, int r6, int r7, CharSequence charSequence, int r9) {
        this.mMenu = menuBuilder;
        this.mId = r5;
        this.mGroup = r4;
        this.mCategoryOrder = r6;
        this.mOrdering = r7;
        this.mTitle = charSequence;
        this.mShowAsAction = r9;
    }

    public static void appendModifier(StringBuilder sb, int r1, int r2, String str) {
        if ((r1 & r2) == r2) {
            sb.append(str);
        }
    }

    public final Drawable applyIconTintIfNecessary(Drawable drawable) {
        if (drawable != null && this.mNeedToApplyIconTint && (this.mHasIconTint || this.mHasIconTintMode)) {
            drawable = drawable.mutate();
            if (this.mHasIconTint) {
                DrawableCompat$Api21Impl.setTintList(drawable, this.mIconTintList);
            }
            if (this.mHasIconTintMode) {
                DrawableCompat$Api21Impl.setTintMode(drawable, this.mIconTintMode);
            }
            this.mNeedToApplyIconTint = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse(this)) {
            return false;
        }
        return this.mMenu.collapseItemActionView(this);
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionExpand(this)) {
            return false;
        }
        return this.mMenu.expandItemActionView(this);
    }

    @Override // android.view.MenuItem
    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.mActionView;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.mActionProvider;
        if (actionProvider != null) {
            View onCreateActionView = actionProvider.onCreateActionView(this);
            this.mActionView = onCreateActionView;
            return onCreateActionView;
        }
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.mGroup;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.mIconDrawable;
        if (drawable != null) {
            return applyIconTintIfNecessary(drawable);
        }
        int r0 = this.mIconResId;
        if (r0 != 0) {
            Drawable drawable2 = AppCompatResources.getDrawable(this.mMenu.mContext, r0);
            this.mIconResId = 0;
            this.mIconDrawable = drawable2;
            return applyIconTintIfNecessary(drawable2);
        }
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.mIntent;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.mId;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.mCategoryOrder;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        if (charSequence == null) {
            return this.mTitle;
        }
        return charSequence;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public final boolean hasCollapsibleActionView() {
        ActionProvider actionProvider;
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null && (actionProvider = this.mActionProvider) != null) {
            this.mActionView = actionProvider.onCreateActionView(this);
        }
        if (this.mActionView == null) {
            return false;
        }
        return true;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        if (this.mSubMenu != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        if ((this.mFlags & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        if ((this.mFlags & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        if ((this.mFlags & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        ActionProvider actionProvider = this.mActionProvider;
        if (actionProvider != null && actionProvider.overridesItemVisibility()) {
            if ((this.mFlags & 8) == 0 && this.mActionProvider.isVisible()) {
                return true;
            }
            return false;
        }
        if ((this.mFlags & 8) == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int r0;
        this.mActionView = view;
        this.mActionProvider = null;
        if (view != null && view.getId() == -1 && (r0 = this.mId) > 0) {
            view.setId(r0);
        }
        MenuBuilder menuBuilder = this.mMenu;
        menuBuilder.mIsActionItemsStale = true;
        menuBuilder.onItemsChanged(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.mShortcutAlphabeticChar == c) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int r0 = this.mFlags;
        int r3 = (z ? 1 : 0) | (r0 & (-2));
        this.mFlags = r3;
        if (r0 != r3) {
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        boolean z2;
        int r7;
        int r0 = this.mFlags;
        int r1 = r0 & 4;
        MenuBuilder menuBuilder = this.mMenu;
        int r3 = 2;
        if (r1 != 0) {
            menuBuilder.getClass();
            ArrayList<MenuItemImpl> arrayList = menuBuilder.mItems;
            int size = arrayList.size();
            menuBuilder.stopDispatchingItemsChanged();
            for (int r12 = 0; r12 < size; r12++) {
                MenuItemImpl menuItemImpl = arrayList.get(r12);
                if (menuItemImpl.mGroup == this.mGroup) {
                    boolean z3 = true;
                    if ((menuItemImpl.mFlags & 4) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 && menuItemImpl.isCheckable()) {
                        if (menuItemImpl != this) {
                            z3 = false;
                        }
                        int r6 = menuItemImpl.mFlags;
                        int r8 = r6 & (-3);
                        if (z3) {
                            r7 = 2;
                        } else {
                            r7 = 0;
                        }
                        int r72 = r7 | r8;
                        menuItemImpl.mFlags = r72;
                        if (r6 != r72) {
                            menuItemImpl.mMenu.onItemsChanged(false);
                        }
                    }
                }
            }
            menuBuilder.startDispatchingItemsChanged();
        } else {
            int r13 = r0 & (-3);
            if (!z) {
                r3 = 0;
            }
            int r10 = r3 | r13;
            this.mFlags = r10;
            if (r0 != r10) {
                menuBuilder.onItemsChanged(false);
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.mFlags |= 16;
        } else {
            this.mFlags &= -17;
        }
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.mIconResId = 0;
        this.mIconDrawable = drawable;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public final void setIsActionButton(boolean z) {
        if (z) {
            this.mFlags |= 32;
        } else {
            this.mFlags &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        if (this.mShortcutNumericChar == c) {
            return this;
        }
        this.mShortcutNumericChar = c;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.mOnActionExpandListener = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        this.mShortcutNumericChar = c;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int r4) {
        int r0 = r4 & 3;
        if (r0 != 0 && r0 != 1 && r0 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.mShowAsAction = r4;
        MenuBuilder menuBuilder = this.mMenu;
        menuBuilder.mIsActionItemsStale = true;
        menuBuilder.onItemsChanged(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int r1) {
        setShowAsAction(r1);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.mActionProvider;
        if (actionProvider2 != null) {
            actionProvider2.mVisibilityListener = null;
        }
        this.mActionView = null;
        this.mActionProvider = actionProvider;
        this.mMenu.onItemsChanged(true);
        ActionProvider actionProvider3 = this.mActionProvider;
        if (actionProvider3 != null) {
            actionProvider3.setVisibilityListener(new AnonymousClass1());
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.mMenu.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.mSubMenu;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int r4;
        int r0 = this.mFlags;
        int r1 = r0 & (-9);
        boolean z2 = false;
        if (z) {
            r4 = 0;
        } else {
            r4 = 8;
        }
        int r42 = r4 | r1;
        this.mFlags = r42;
        if (r0 != r42) {
            z2 = true;
        }
        if (z2) {
            MenuBuilder menuBuilder = this.mMenu;
            menuBuilder.mIsVisibleItemsStale = true;
            menuBuilder.onItemsChanged(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.mTitle;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int r3) {
        if (this.mShortcutAlphabeticChar == c && this.mShortcutAlphabeticModifiers == r3) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r3);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int r3) {
        if (this.mShortcutNumericChar == c && this.mShortcutNumericModifiers == r3) {
            return this;
        }
        this.mShortcutNumericChar = c;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r3);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int r3, int r4) {
        this.mShortcutNumericChar = c;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r3);
        this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r4);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int r2) {
        this.mIconDrawable = null;
        this.mIconResId = r2;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int r2) {
        setTitle(this.mMenu.mContext.getString(r2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int r5) {
        int r1;
        MenuBuilder menuBuilder = this.mMenu;
        Context context = menuBuilder.mContext;
        View inflate = LayoutInflater.from(context).inflate(r5, (ViewGroup) new LinearLayout(context), false);
        this.mActionView = inflate;
        this.mActionProvider = null;
        if (inflate != null && inflate.getId() == -1 && (r1 = this.mId) > 0) {
            inflate.setId(r1);
        }
        menuBuilder.mIsActionItemsStale = true;
        menuBuilder.onItemsChanged(true);
        return this;
    }
}
