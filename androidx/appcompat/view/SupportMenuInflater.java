package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat$Api26Impl;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.watch.image.Kolors;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class SupportMenuInflater extends MenuInflater {
    public static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    public static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    public final Object[] mActionProviderConstructorArguments;
    public final Object[] mActionViewConstructorArguments;
    public final Context mContext;
    public Object mRealOwner;

    /* loaded from: classes.dex */
    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        public static final Class<?>[] PARAM_TYPES = {MenuItem.class};
        public final Method mMethod;
        public final Object mRealOwner;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.mRealOwner = obj;
            Class<?> cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, PARAM_TYPES);
            } catch (Exception e) {
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Couldn't resolve menu item onClick handler ", str, " in class ");
                m.append(cls.getName());
                InflateException inflateException = new InflateException(m.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            Method method = this.mMethod;
            try {
                Class<?> returnType = method.getReturnType();
                Class<?> cls = Boolean.TYPE;
                Object obj = this.mRealOwner;
                if (returnType == cls) {
                    return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
                }
                method.invoke(obj, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class MenuState {
        public ActionProvider itemActionProvider;
        public String itemActionViewClassName;
        public int itemActionViewLayout;
        public boolean itemAdded;
        public int itemAlphabeticModifiers;
        public char itemAlphabeticShortcut;
        public int itemCategoryOrder;
        public int itemCheckable;
        public boolean itemChecked;
        public CharSequence itemContentDescription;
        public boolean itemEnabled;
        public int itemIconResId;
        public int itemId;
        public String itemListenerMethodName;
        public int itemNumericModifiers;
        public char itemNumericShortcut;
        public int itemShowAsAction;
        public CharSequence itemTitle;
        public CharSequence itemTitleCondensed;
        public CharSequence itemTooltipText;
        public boolean itemVisible;
        public final Menu menu;
        public ColorStateList itemIconTintList = null;
        public PorterDuff.Mode itemIconTintMode = null;
        public int groupId = 0;
        public int groupCategory = 0;
        public int groupOrder = 0;
        public int groupCheckable = 0;
        public boolean groupVisible = true;
        public boolean groupEnabled = true;

        public MenuState(Menu menu) {
            this.menu = menu;
        }

        public final <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.mContext.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        public final void setItem(MenuItem menuItem) {
            boolean z;
            MenuItem enabled = menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
            boolean z2 = false;
            if (this.itemCheckable >= 1) {
                z = true;
            } else {
                z = false;
            }
            enabled.setCheckable(z).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int r0 = this.itemShowAsAction;
            if (r0 >= 0) {
                menuItem.setShowAsAction(r0);
            }
            String str = this.itemListenerMethodName;
            SupportMenuInflater supportMenuInflater = SupportMenuInflater.this;
            if (str != null) {
                if (!supportMenuInflater.mContext.isRestricted()) {
                    if (supportMenuInflater.mRealOwner == null) {
                        supportMenuInflater.mRealOwner = SupportMenuInflater.findRealOwner(supportMenuInflater.mContext);
                    }
                    menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(supportMenuInflater.mRealOwner, this.itemListenerMethodName));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.itemCheckable >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
                    menuItemImpl.mFlags = (menuItemImpl.mFlags & (-5)) | 4;
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    MenuItemWrapperICS menuItemWrapperICS = (MenuItemWrapperICS) menuItem;
                    try {
                        Method method = menuItemWrapperICS.mSetExclusiveCheckableMethod;
                        SupportMenuItem supportMenuItem = menuItemWrapperICS.mWrappedObject;
                        if (method == null) {
                            menuItemWrapperICS.mSetExclusiveCheckableMethod = supportMenuItem.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        menuItemWrapperICS.mSetExclusiveCheckableMethod.invoke(supportMenuItem, Boolean.TRUE);
                    } catch (Exception e) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
                    }
                }
            }
            String str2 = this.itemActionViewClassName;
            if (str2 != null) {
                menuItem.setActionView((View) newInstance(str2, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, supportMenuInflater.mActionViewConstructorArguments));
                z2 = true;
            }
            int r02 = this.itemActionViewLayout;
            if (r02 > 0) {
                if (!z2) {
                    menuItem.setActionView(r02);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.itemActionProvider;
            if (actionProvider != null) {
                if (menuItem instanceof SupportMenuItem) {
                    ((SupportMenuItem) menuItem).setSupportActionProvider(actionProvider);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.itemContentDescription;
            boolean z3 = menuItem instanceof SupportMenuItem;
            if (z3) {
                ((SupportMenuItem) menuItem).setContentDescription(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setContentDescription(menuItem, charSequence);
            }
            CharSequence charSequence2 = this.itemTooltipText;
            if (z3) {
                ((SupportMenuItem) menuItem).setTooltipText(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setTooltipText(menuItem, charSequence2);
            }
            char c = this.itemAlphabeticShortcut;
            int r3 = this.itemAlphabeticModifiers;
            if (z3) {
                ((SupportMenuItem) menuItem).setAlphabeticShortcut(c, r3);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setAlphabeticShortcut(menuItem, c, r3);
            }
            char c2 = this.itemNumericShortcut;
            int r32 = this.itemNumericModifiers;
            if (z3) {
                ((SupportMenuItem) menuItem).setNumericShortcut(c2, r32);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setNumericShortcut(menuItem, c2, r32);
            }
            PorterDuff.Mode mode = this.itemIconTintMode;
            if (mode != null) {
                if (z3) {
                    ((SupportMenuItem) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    MenuItemCompat$Api26Impl.setIconTintMode(menuItem, mode);
                }
            }
            ColorStateList colorStateList = this.itemIconTintList;
            if (colorStateList != null) {
                if (z3) {
                    ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    MenuItemCompat$Api26Impl.setIconTintList(menuItem, colorStateList);
                }
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = clsArr;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.mContext = context;
        Object[] objArr = {context};
        this.mActionViewConstructorArguments = objArr;
        this.mActionProviderConstructorArguments = objArr;
    }

    public static Object findRealOwner(Context context) {
        if (context instanceof Activity) {
            return context;
        }
        if (context instanceof ContextWrapper) {
            return findRealOwner(((ContextWrapper) context).getBaseContext());
        }
        return context;
    }

    @Override // android.view.MenuInflater
    public final void inflate(int r4, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(r4, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.mContext.getResources().getLayout(r4);
                    parseMenu(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (IOException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    public final void parseMenu(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        int r5;
        char charAt;
        char charAt2;
        boolean z;
        ColorStateList colorStateList;
        MenuState menuState = new MenuState(menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            r5 = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlResourceParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z2 = false;
        boolean z3 = false;
        String str = null;
        while (!z2) {
            if (eventType != 1) {
                Menu menu2 = menuState.menu;
                z2 = z2;
                z2 = z2;
                if (eventType != r5) {
                    if (eventType == 3) {
                        String name2 = xmlResourceParser.getName();
                        if (z3 && name2.equals(str)) {
                            z3 = false;
                            str = null;
                        } else if (name2.equals(ConfigurationItem.COLUMN_NAME_GROUP)) {
                            menuState.groupId = 0;
                            menuState.groupCategory = 0;
                            menuState.groupOrder = 0;
                            menuState.groupCheckable = 0;
                            menuState.groupVisible = true;
                            menuState.groupEnabled = true;
                            z2 = z2;
                        } else if (name2.equals("item")) {
                            z2 = z2;
                            if (!menuState.itemAdded) {
                                ActionProvider actionProvider = menuState.itemActionProvider;
                                if (actionProvider != null && actionProvider.hasSubMenu()) {
                                    menuState.itemAdded = true;
                                    menuState.setItem(menu2.addSubMenu(menuState.groupId, menuState.itemId, menuState.itemCategoryOrder, menuState.itemTitle).getItem());
                                    z2 = z2;
                                } else {
                                    menuState.itemAdded = true;
                                    menuState.setItem(menu2.add(menuState.groupId, menuState.itemId, menuState.itemCategoryOrder, menuState.itemTitle));
                                    z2 = z2;
                                }
                            }
                        } else {
                            z2 = z2;
                            if (name2.equals("menu")) {
                                z2 = true;
                            }
                        }
                    }
                } else if (!z3) {
                    String name3 = xmlResourceParser.getName();
                    boolean equals = name3.equals(ConfigurationItem.COLUMN_NAME_GROUP);
                    SupportMenuInflater supportMenuInflater = SupportMenuInflater.this;
                    if (equals) {
                        TypedArray obtainStyledAttributes = supportMenuInflater.mContext.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
                        menuState.groupId = obtainStyledAttributes.getResourceId(1, 0);
                        menuState.groupCategory = obtainStyledAttributes.getInt(3, 0);
                        menuState.groupOrder = obtainStyledAttributes.getInt(4, 0);
                        menuState.groupCheckable = obtainStyledAttributes.getInt(5, 0);
                        menuState.groupVisible = obtainStyledAttributes.getBoolean(2, true);
                        menuState.groupEnabled = obtainStyledAttributes.getBoolean(0, true);
                        obtainStyledAttributes.recycle();
                        z2 = z2;
                    } else if (name3.equals("item")) {
                        Context context = supportMenuInflater.mContext;
                        TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, R$styleable.MenuItem));
                        menuState.itemId = tintTypedArray.getResourceId(2, 0);
                        menuState.itemCategoryOrder = (tintTypedArray.getInt(5, menuState.groupCategory) & Kolors.red) | (tintTypedArray.getInt(6, menuState.groupOrder) & 65535);
                        menuState.itemTitle = tintTypedArray.getText(7);
                        menuState.itemTitleCondensed = tintTypedArray.getText(8);
                        menuState.itemIconResId = tintTypedArray.getResourceId(0, 0);
                        String string = tintTypedArray.getString(9);
                        if (string == null) {
                            charAt = 0;
                        } else {
                            charAt = string.charAt(0);
                        }
                        menuState.itemAlphabeticShortcut = charAt;
                        menuState.itemAlphabeticModifiers = tintTypedArray.getInt(16, 4096);
                        String string2 = tintTypedArray.getString(10);
                        if (string2 == null) {
                            charAt2 = 0;
                        } else {
                            charAt2 = string2.charAt(0);
                        }
                        menuState.itemNumericShortcut = charAt2;
                        menuState.itemNumericModifiers = tintTypedArray.getInt(20, 4096);
                        if (tintTypedArray.hasValue(11)) {
                            menuState.itemCheckable = tintTypedArray.getBoolean(11, false) ? 1 : 0;
                        } else {
                            menuState.itemCheckable = menuState.groupCheckable;
                        }
                        menuState.itemChecked = tintTypedArray.getBoolean(3, false);
                        menuState.itemVisible = tintTypedArray.getBoolean(4, menuState.groupVisible);
                        menuState.itemEnabled = tintTypedArray.getBoolean(1, menuState.groupEnabled);
                        menuState.itemShowAsAction = tintTypedArray.getInt(21, -1);
                        menuState.itemListenerMethodName = tintTypedArray.getString(12);
                        menuState.itemActionViewLayout = tintTypedArray.getResourceId(13, 0);
                        menuState.itemActionViewClassName = tintTypedArray.getString(15);
                        String string3 = tintTypedArray.getString(14);
                        if (string3 != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && menuState.itemActionViewLayout == 0 && menuState.itemActionViewClassName == null) {
                            menuState.itemActionProvider = (ActionProvider) menuState.newInstance(string3, ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, supportMenuInflater.mActionProviderConstructorArguments);
                        } else {
                            if (z) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            menuState.itemActionProvider = null;
                        }
                        menuState.itemContentDescription = tintTypedArray.getText(17);
                        menuState.itemTooltipText = tintTypedArray.getText(22);
                        if (tintTypedArray.hasValue(19)) {
                            menuState.itemIconTintMode = DrawableUtils.parseTintMode(tintTypedArray.getInt(19, -1), menuState.itemIconTintMode);
                            colorStateList = null;
                        } else {
                            colorStateList = null;
                            menuState.itemIconTintMode = null;
                        }
                        if (tintTypedArray.hasValue(18)) {
                            menuState.itemIconTintList = tintTypedArray.getColorStateList(18);
                        } else {
                            menuState.itemIconTintList = colorStateList;
                        }
                        tintTypedArray.recycle();
                        menuState.itemAdded = false;
                    } else if (name3.equals("menu")) {
                        menuState.itemAdded = true;
                        SubMenu addSubMenu = menu2.addSubMenu(menuState.groupId, menuState.itemId, menuState.itemCategoryOrder, menuState.itemTitle);
                        menuState.setItem(addSubMenu.getItem());
                        parseMenu(xmlResourceParser, attributeSet, addSubMenu);
                    } else {
                        str = name3;
                        z3 = true;
                    }
                }
                eventType = xmlResourceParser.next();
                r5 = 2;
                z2 = z2;
                z3 = z3;
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }
}
