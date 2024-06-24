package androidx.compose.ui.platform.actionmodecallback;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.AndroidTextToolbar$textActionModeCallback$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextActionModeCallback.android.kt */
/* loaded from: classes.dex */
public final class TextActionModeCallback {
    public final Function0<Unit> onActionModeDestroy;
    public Function0<Unit> onCopyRequested;
    public Function0<Unit> onCutRequested;
    public Function0<Unit> onPasteRequested;
    public Function0<Unit> onSelectAllRequested;
    public Rect rect;

    public TextActionModeCallback(AndroidTextToolbar$textActionModeCallback$1 androidTextToolbar$textActionModeCallback$1) {
        Rect rect = Rect.Zero;
        this.onActionModeDestroy = androidTextToolbar$textActionModeCallback$1;
        this.rect = rect;
        this.onCopyRequested = null;
        this.onPasteRequested = null;
        this.onCutRequested = null;
        this.onSelectAllRequested = null;
    }

    public static void addMenuItem$ui_release(Menu menu, MenuItemOption item) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(item, "item");
        menu.add(0, item.getId(), item.getOrder(), item.getTitleResource()).setShowAsAction(1);
    }

    public static void addOrRemoveMenuItem(Menu menu, MenuItemOption menuItemOption, Function0 function0) {
        if (function0 != null && menu.findItem(menuItemOption.getId()) == null) {
            addMenuItem$ui_release(menu, menuItemOption);
        } else if (function0 == null && menu.findItem(menuItemOption.getId()) != null) {
            menu.removeItem(menuItemOption.getId());
        }
    }

    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        Intrinsics.checkNotNull(menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == MenuItemOption.Copy.getId()) {
            Function0<Unit> function0 = this.onCopyRequested;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (itemId == MenuItemOption.Paste.getId()) {
            Function0<Unit> function02 = this.onPasteRequested;
            if (function02 != null) {
                function02.invoke();
            }
        } else if (itemId == MenuItemOption.Cut.getId()) {
            Function0<Unit> function03 = this.onCutRequested;
            if (function03 != null) {
                function03.invoke();
            }
        } else if (itemId == MenuItemOption.SelectAll.getId()) {
            Function0<Unit> function04 = this.onSelectAllRequested;
            if (function04 != null) {
                function04.invoke();
            }
        } else {
            return false;
        }
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        return true;
    }

    public final void onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (menu != null) {
            if (actionMode != null) {
                if (this.onCopyRequested != null) {
                    addMenuItem$ui_release(menu, MenuItemOption.Copy);
                }
                if (this.onPasteRequested != null) {
                    addMenuItem$ui_release(menu, MenuItemOption.Paste);
                }
                if (this.onCutRequested != null) {
                    addMenuItem$ui_release(menu, MenuItemOption.Cut);
                }
                if (this.onSelectAllRequested != null) {
                    addMenuItem$ui_release(menu, MenuItemOption.SelectAll);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
