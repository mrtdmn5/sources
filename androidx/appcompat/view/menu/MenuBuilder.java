package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MenuBuilder implements SupportMenu {
    public static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    public final ArrayList<MenuItemImpl> mActionItems;
    public Callback mCallback;
    public final Context mContext;
    public MenuItemImpl mExpandedItem;
    public Drawable mHeaderIcon;
    public CharSequence mHeaderTitle;
    public View mHeaderView;
    public boolean mIsActionItemsStale;
    public boolean mIsVisibleItemsStale;
    public final ArrayList<MenuItemImpl> mItems;
    public final ArrayList<MenuItemImpl> mNonActionItems;
    public boolean mOverrideVisibleItems;
    public boolean mQwertyMode;
    public final Resources mResources;
    public boolean mShortcutsVisible;
    public final ArrayList<MenuItemImpl> mVisibleItems;
    public int mDefaultShowAsAction = 0;
    public boolean mPreventDispatchingItemsChanged = false;
    public boolean mItemsChangedWhileDispatchPrevented = false;
    public boolean mStructureChangedWhileDispatchPrevented = false;
    public boolean mIsClosing = false;
    public final ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<>();
    public final CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList<>();
    public boolean mGroupDividerEnabled = false;

    /* loaded from: classes.dex */
    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem);

        void onMenuModeChange(MenuBuilder menuBuilder);
    }

    /* loaded from: classes.dex */
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        boolean z;
        boolean z2 = false;
        this.mContext = context;
        Resources resources = context.getResources();
        this.mResources = resources;
        this.mItems = new ArrayList<>();
        this.mVisibleItems = new ArrayList<>();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList<>();
        this.mNonActionItems = new ArrayList<>();
        this.mIsActionItemsStale = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
            if (Build.VERSION.SDK_INT >= 28) {
                z = ViewConfigurationCompat.Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                if (identifier != 0 && resources2.getBoolean(identifier)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                z2 = true;
            }
        }
        this.mShortcutsVisible = z2;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int r8, int r9, int r10, ComponentName componentName, Intent[] intentArr, Intent intent, int r14, MenuItem[] menuItemArr) {
        int r2;
        Intent intent2;
        int r142;
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            r2 = queryIntentActivityOptions.size();
        } else {
            r2 = 0;
        }
        if ((r14 & 1) == 0) {
            removeGroup(r8);
        }
        for (int r1 = 0; r1 < r2; r1++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(r1);
            int r4 = resolveInfo.specificIndex;
            if (r4 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[r4];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItemImpl addInternal = addInternal(r8, r9, r10, resolveInfo.loadLabel(packageManager));
            addInternal.setIcon(resolveInfo.loadIcon(packageManager));
            addInternal.mIntent = intent3;
            if (menuItemArr != null && (r142 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[r142] = addInternal;
            }
        }
        return r2;
    }

    public final MenuItemImpl addInternal(int r11, int r12, int r13, CharSequence charSequence) {
        int r122;
        int r0 = ((-65536) & r13) >> 16;
        if (r0 >= 0 && r0 < 6) {
            int r02 = (sCategoryToOrder[r0] << 16) | (65535 & r13);
            MenuItemImpl menuItemImpl = new MenuItemImpl(this, r11, r12, r13, r02, charSequence, this.mDefaultShowAsAction);
            ArrayList<MenuItemImpl> arrayList = this.mItems;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size >= 0) {
                    if (arrayList.get(size).mOrdering <= r02) {
                        r122 = size + 1;
                        break;
                    }
                } else {
                    r122 = 0;
                    break;
                }
            }
            arrayList.add(r122, menuItemImpl);
            onItemsChanged(true);
            return menuItemImpl;
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public final void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.mPresenters.add(new WeakReference<>(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        MenuItemImpl menuItemImpl = this.mExpandedItem;
        if (menuItemImpl != null) {
            collapseItemActionView(menuItemImpl);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    public final void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    public final void close(boolean z) {
        if (this.mIsClosing) {
            return;
        }
        this.mIsClosing = true;
        CopyOnWriteArrayList<WeakReference<MenuPresenter>> copyOnWriteArrayList = this.mPresenters;
        Iterator<WeakReference<MenuPresenter>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                menuPresenter.onCloseMenu(this, z);
            }
        }
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        CopyOnWriteArrayList<WeakReference<MenuPresenter>> copyOnWriteArrayList = this.mPresenters;
        boolean z = false;
        if (!copyOnWriteArrayList.isEmpty() && this.mExpandedItem == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    copyOnWriteArrayList.remove(next);
                } else {
                    z = menuPresenter.collapseItemActionView(menuItemImpl);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.mExpandedItem = null;
            }
        }
        return z;
    }

    public boolean dispatchMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        Callback callback = this.mCallback;
        if (callback != null && callback.onMenuItemSelected(menuBuilder, menuItem)) {
            return true;
        }
        return false;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        CopyOnWriteArrayList<WeakReference<MenuPresenter>> copyOnWriteArrayList = this.mPresenters;
        boolean z = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                z = menuPresenter.expandItemActionView(menuItemImpl);
                if (z) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z) {
            this.mExpandedItem = menuItemImpl;
        }
        return z;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int r5) {
        MenuItem findItem;
        int size = size();
        for (int r1 = 0; r1 < size; r1++) {
            MenuItemImpl menuItemImpl = this.mItems.get(r1);
            if (menuItemImpl.mId == r5) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.mSubMenu.findItem(r5)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final MenuItemImpl findItemWithShortcutForKey(int r12, KeyEvent keyEvent) {
        char c;
        ArrayList<MenuItemImpl> arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, r12, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int r6 = 0; r6 < size; r6++) {
            MenuItemImpl menuItemImpl = arrayList.get(r6);
            if (isQwertyMode) {
                c = menuItemImpl.mShortcutAlphabeticChar;
            } else {
                c = menuItemImpl.mShortcutNumericChar;
            }
            char[] cArr = keyData.meta;
            if ((c == cArr[0] && (metaState & 2) == 0) || ((c == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && c == '\b' && r12 == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public final void findItemsWithShortcutForKey(ArrayList arrayList, int r18, KeyEvent keyEvent) {
        char c;
        int r14;
        boolean z;
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (!keyEvent.getKeyData(keyData) && r18 != 67) {
            return;
        }
        ArrayList<MenuItemImpl> arrayList2 = this.mItems;
        int size = arrayList2.size();
        for (int r11 = 0; r11 < size; r11++) {
            MenuItemImpl menuItemImpl = arrayList2.get(r11);
            if (menuItemImpl.hasSubMenu()) {
                menuItemImpl.mSubMenu.findItemsWithShortcutForKey(arrayList, r18, keyEvent);
            }
            if (isQwertyMode) {
                c = menuItemImpl.mShortcutAlphabeticChar;
            } else {
                c = menuItemImpl.mShortcutNumericChar;
            }
            if (isQwertyMode) {
                r14 = menuItemImpl.mShortcutAlphabeticModifiers;
            } else {
                r14 = menuItemImpl.mShortcutNumericModifiers;
            }
            if ((modifiers & 69647) == (r14 & 69647)) {
                z = true;
            } else {
                z = false;
            }
            if (z && c != 0) {
                char[] cArr = keyData.meta;
                if (c != cArr[0] && c != cArr[2]) {
                    if (isQwertyMode && c == '\b') {
                        if (r18 != 67) {
                        }
                    }
                }
                if (menuItemImpl.isEnabled()) {
                    arrayList.add(menuItemImpl);
                }
            }
        }
    }

    public final void flagActionItems() {
        boolean z;
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (!this.mIsActionItemsStale) {
            return;
        }
        CopyOnWriteArrayList<WeakReference<MenuPresenter>> copyOnWriteArrayList = this.mPresenters;
        Iterator<WeakReference<MenuPresenter>> it = copyOnWriteArrayList.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                z2 |= menuPresenter.flagActionItems();
            }
        }
        ArrayList<MenuItemImpl> arrayList = this.mActionItems;
        ArrayList<MenuItemImpl> arrayList2 = this.mNonActionItems;
        if (z2) {
            arrayList.clear();
            arrayList2.clear();
            int size = visibleItems.size();
            for (int r5 = 0; r5 < size; r5++) {
                MenuItemImpl menuItemImpl = visibleItems.get(r5);
                if ((menuItemImpl.mFlags & 32) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList.add(menuItemImpl);
                } else {
                    arrayList2.add(menuItemImpl);
                }
            }
        } else {
            arrayList.clear();
            arrayList2.clear();
            arrayList2.addAll(getVisibleItems());
        }
        this.mIsActionItemsStale = false;
    }

    public String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int r2) {
        return this.mItems.get(r2);
    }

    public final ArrayList<MenuItemImpl> getVisibleItems() {
        boolean z = this.mIsVisibleItemsStale;
        ArrayList<MenuItemImpl> arrayList = this.mVisibleItems;
        if (!z) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList<MenuItemImpl> arrayList2 = this.mItems;
        int size = arrayList2.size();
        for (int r4 = 0; r4 < size; r4++) {
            MenuItemImpl menuItemImpl = arrayList2.get(r4);
            if (menuItemImpl.isVisible()) {
                arrayList.add(menuItemImpl);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return arrayList;
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        int size = size();
        for (int r3 = 0; r3 < size; r3++) {
            if (this.mItems.get(r3).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int r1, KeyEvent keyEvent) {
        if (findItemWithShortcutForKey(r1, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    public final void onItemsChanged(boolean z) {
        if (!this.mPreventDispatchingItemsChanged) {
            if (z) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }
            CopyOnWriteArrayList<WeakReference<MenuPresenter>> copyOnWriteArrayList = this.mPresenters;
            if (!copyOnWriteArrayList.isEmpty()) {
                stopDispatchingItemsChanged();
                Iterator<WeakReference<MenuPresenter>> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference<MenuPresenter> next = it.next();
                    MenuPresenter menuPresenter = next.get();
                    if (menuPresenter == null) {
                        copyOnWriteArrayList.remove(next);
                    } else {
                        menuPresenter.updateMenuView();
                    }
                }
                startDispatchingItemsChanged();
                return;
            }
            return;
        }
        this.mItemsChangedWhileDispatchPrevented = true;
        if (z) {
            this.mStructureChangedWhileDispatchPrevented = true;
        }
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int r2, int r3) {
        return performItemAction(findItem(r2), null, r3);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean performItemAction(android.view.MenuItem r7, androidx.appcompat.view.menu.MenuPresenter r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.MenuItemImpl r7 = (androidx.appcompat.view.menu.MenuItemImpl) r7
            r0 = 0
            if (r7 == 0) goto Lcc
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Lcc
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.mClickListener
            r2 = 1
            if (r1 == 0) goto L19
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L19
            goto L3e
        L19:
            androidx.appcompat.view.menu.MenuBuilder r1 = r7.mMenu
            boolean r3 = r1.dispatchMenuItemSelected(r1, r7)
            if (r3 == 0) goto L22
            goto L3e
        L22:
            android.content.Intent r3 = r7.mIntent
            if (r3 == 0) goto L34
            android.content.Context r1 = r1.mContext     // Catch: android.content.ActivityNotFoundException -> L2c
            r1.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L2c
            goto L3e
        L2c:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L34:
            androidx.core.view.ActionProvider r1 = r7.mActionProvider
            if (r1 == 0) goto L40
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L40
        L3e:
            r1 = r2
            goto L41
        L40:
            r1 = r0
        L41:
            androidx.core.view.ActionProvider r3 = r7.mActionProvider
            if (r3 == 0) goto L4d
            boolean r4 = r3.hasSubMenu()
            if (r4 == 0) goto L4d
            r4 = r2
            goto L4e
        L4d:
            r4 = r0
        L4e:
            boolean r5 = r7.hasCollapsibleActionView()
            if (r5 == 0) goto L60
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Lcb
            r6.close(r2)
            goto Lcb
        L60:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L71
            if (r4 == 0) goto L69
            goto L71
        L69:
            r7 = r9 & 1
            if (r7 != 0) goto Lcb
            r6.close(r2)
            goto Lcb
        L71:
            r9 = r9 & 4
            if (r9 != 0) goto L78
            r6.close(r0)
        L78:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L8c
            androidx.appcompat.view.menu.SubMenuBuilder r9 = new androidx.appcompat.view.menu.SubMenuBuilder
            android.content.Context r5 = r6.mContext
            r9.<init>(r5, r6, r7)
            r7.mSubMenu = r9
            java.lang.CharSequence r5 = r7.mTitle
            r9.setHeaderTitle(r5)
        L8c:
            androidx.appcompat.view.menu.SubMenuBuilder r7 = r7.mSubMenu
            if (r4 == 0) goto L93
            r3.onPrepareSubMenu(r7)
        L93:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<androidx.appcompat.view.menu.MenuPresenter>> r9 = r6.mPresenters
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto L9c
            goto Lc5
        L9c:
            if (r8 == 0) goto La2
            boolean r0 = r8.onSubMenuSelected(r7)
        La2:
            java.util.Iterator r8 = r9.iterator()
        La6:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto Lc5
            java.lang.Object r3 = r8.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r4 = r3.get()
            androidx.appcompat.view.menu.MenuPresenter r4 = (androidx.appcompat.view.menu.MenuPresenter) r4
            if (r4 != 0) goto Lbe
            r9.remove(r3)
            goto La6
        Lbe:
            if (r0 != 0) goto La6
            boolean r0 = r4.onSubMenuSelected(r7)
            goto La6
        Lc5:
            r1 = r1 | r0
            if (r1 != 0) goto Lcb
            r6.close(r2)
        Lcb:
            return r1
        Lcc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuBuilder.performItemAction(android.view.MenuItem, androidx.appcompat.view.menu.MenuPresenter, int):boolean");
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int r1, KeyEvent keyEvent, int r3) {
        boolean z;
        MenuItemImpl findItemWithShortcutForKey = findItemWithShortcutForKey(r1, keyEvent);
        if (findItemWithShortcutForKey != null) {
            z = performItemAction(findItemWithShortcutForKey, null, r3);
        } else {
            z = false;
        }
        if ((r3 & 2) != 0) {
            close(true);
        }
        return z;
    }

    @Override // android.view.Menu
    public final void removeGroup(int r6) {
        ArrayList<MenuItemImpl> arrayList;
        int size = size();
        int r1 = 0;
        int r2 = 0;
        while (true) {
            arrayList = this.mItems;
            if (r2 < size) {
                if (arrayList.get(r2).mGroup == r6) {
                    break;
                } else {
                    r2++;
                }
            } else {
                r2 = -1;
                break;
            }
        }
        if (r2 >= 0) {
            int size2 = arrayList.size() - r2;
            while (true) {
                int r4 = r1 + 1;
                if (r1 >= size2 || arrayList.get(r2).mGroup != r6) {
                    break;
                }
                if (r2 >= 0 && r2 < arrayList.size()) {
                    arrayList.remove(r2);
                }
                r1 = r4;
            }
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int r5) {
        ArrayList<MenuItemImpl> arrayList;
        int size = size();
        int r1 = 0;
        while (true) {
            arrayList = this.mItems;
            if (r1 < size) {
                if (arrayList.get(r1).mId == r5) {
                    break;
                } else {
                    r1++;
                }
            } else {
                r1 = -1;
                break;
            }
        }
        if (r1 >= 0 && r1 < arrayList.size()) {
            arrayList.remove(r1);
            onItemsChanged(true);
        }
    }

    public final void removeMenuPresenter(MenuPresenter menuPresenter) {
        CopyOnWriteArrayList<WeakReference<MenuPresenter>> copyOnWriteArrayList = this.mPresenters;
        Iterator<WeakReference<MenuPresenter>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                copyOnWriteArrayList.remove(next);
            }
        }
    }

    public final void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int size = size();
        for (int r2 = 0; r2 < size; r2++) {
            MenuItem item = getItem(r2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
            }
        }
        int r8 = bundle.getInt("android:menu:expandedactionview");
        if (r8 > 0 && (findItem = findItem(r8)) != null) {
            findItem.expandActionView();
        }
    }

    public final void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int r2 = 0; r2 < size; r2++) {
            MenuItem item = getItem(r2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int r8, boolean z, boolean z2) {
        int r6;
        ArrayList<MenuItemImpl> arrayList = this.mItems;
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            MenuItemImpl menuItemImpl = arrayList.get(r3);
            if (menuItemImpl.mGroup == r8) {
                int r5 = menuItemImpl.mFlags & (-5);
                if (z2) {
                    r6 = 4;
                } else {
                    r6 = 0;
                }
                menuItemImpl.mFlags = r5 | r6;
                menuItemImpl.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.mGroupDividerEnabled = z;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int r6, boolean z) {
        ArrayList<MenuItemImpl> arrayList = this.mItems;
        int size = arrayList.size();
        for (int r2 = 0; r2 < size; r2++) {
            MenuItemImpl menuItemImpl = arrayList.get(r2);
            if (menuItemImpl.mGroup == r6) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int r11, boolean z) {
        int r9;
        boolean z2;
        ArrayList<MenuItemImpl> arrayList = this.mItems;
        int size = arrayList.size();
        boolean z3 = false;
        for (int r3 = 0; r3 < size; r3++) {
            MenuItemImpl menuItemImpl = arrayList.get(r3);
            if (menuItemImpl.mGroup == r11) {
                int r7 = menuItemImpl.mFlags;
                int r8 = r7 & (-9);
                if (z) {
                    r9 = 0;
                } else {
                    r9 = 8;
                }
                int r82 = r8 | r9;
                menuItemImpl.mFlags = r82;
                if (r7 != r82) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            onItemsChanged(true);
        }
    }

    public final void setHeaderInternal(int r2, CharSequence charSequence, int r4, Drawable drawable, View view) {
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (r2 > 0) {
                this.mHeaderTitle = this.mResources.getText(r2);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (r4 > 0) {
                Object obj = ContextCompat.sLock;
                this.mHeaderIcon = ContextCompat.Api21Impl.getDrawable(this.mContext, r4);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.mQwertyMode = z;
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.mItems.size();
    }

    public final void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public final void stopDispatchingItemsChanged() {
        if (!this.mPreventDispatchingItemsChanged) {
            this.mPreventDispatchingItemsChanged = true;
            this.mItemsChangedWhileDispatchPrevented = false;
            this.mStructureChangedWhileDispatchPrevented = false;
        }
    }

    @Override // android.view.Menu
    public final MenuItem add(int r2) {
        return addInternal(0, 0, 0, this.mResources.getString(r2));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r2) {
        return addSubMenu(0, 0, 0, this.mResources.getString(r2));
    }

    @Override // android.view.Menu
    public final MenuItem add(int r1, int r2, int r3, CharSequence charSequence) {
        return addInternal(r1, r2, r3, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r1, int r2, int r3, CharSequence charSequence) {
        MenuItemImpl addInternal = addInternal(r1, r2, r3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.mContext, this, addInternal);
        addInternal.mSubMenu = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(addInternal.mTitle);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public final MenuItem add(int r2, int r3, int r4, int r5) {
        return addInternal(r2, r3, r4, this.mResources.getString(r5));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r2, int r3, int r4, int r5) {
        return addSubMenu(r2, r3, r4, this.mResources.getString(r5));
    }

    @Override // android.view.Menu
    public final void close() {
        close(true);
    }

    public MenuBuilder getRootMenu() {
        return this;
    }
}
