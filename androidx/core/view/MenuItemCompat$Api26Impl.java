package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;

/* loaded from: classes.dex */
public final class MenuItemCompat$Api26Impl {
    public static int getAlphabeticModifiers(MenuItem menuItem) {
        return menuItem.getAlphabeticModifiers();
    }

    public static CharSequence getContentDescription(MenuItem menuItem) {
        return menuItem.getContentDescription();
    }

    public static ColorStateList getIconTintList(MenuItem menuItem) {
        return menuItem.getIconTintList();
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem menuItem) {
        return menuItem.getIconTintMode();
    }

    public static int getNumericModifiers(MenuItem menuItem) {
        return menuItem.getNumericModifiers();
    }

    public static CharSequence getTooltipText(MenuItem menuItem) {
        return menuItem.getTooltipText();
    }

    public static MenuItem setAlphabeticShortcut(MenuItem menuItem, char c, int r2) {
        return menuItem.setAlphabeticShortcut(c, r2);
    }

    public static MenuItem setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setContentDescription(charSequence);
    }

    public static MenuItem setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        return menuItem.setIconTintList(colorStateList);
    }

    public static MenuItem setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        return menuItem.setIconTintMode(mode);
    }

    public static MenuItem setNumericShortcut(MenuItem menuItem, char c, int r2) {
        return menuItem.setNumericShortcut(c, r2);
    }

    public static MenuItem setShortcut(MenuItem menuItem, char c, char c2, int r3, int r4) {
        return menuItem.setShortcut(c, c2, r3, r4);
    }

    public static MenuItem setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setTooltipText(charSequence);
    }
}
