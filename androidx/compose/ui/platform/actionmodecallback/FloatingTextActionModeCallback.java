package androidx.compose.ui.platform.actionmodecallback;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FloatingTextActionModeCallback.android.kt */
/* loaded from: classes.dex */
public final class FloatingTextActionModeCallback extends ActionMode.Callback2 {
    public final TextActionModeCallback callback;

    public FloatingTextActionModeCallback(TextActionModeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.callback.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        this.callback.onCreateActionMode(actionMode, menu);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode actionMode) {
        Function0<Unit> function0 = this.callback.onActionModeDestroy;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // android.view.ActionMode.Callback2
    public final void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
        androidx.compose.ui.geometry.Rect rect2 = this.callback.rect;
        if (rect != null) {
            rect.set((int) rect2.left, (int) rect2.top, (int) rect2.right, (int) rect2.bottom);
        }
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        TextActionModeCallback textActionModeCallback = this.callback;
        textActionModeCallback.getClass();
        if (actionMode != null && menu != null) {
            TextActionModeCallback.addOrRemoveMenuItem(menu, MenuItemOption.Copy, textActionModeCallback.onCopyRequested);
            TextActionModeCallback.addOrRemoveMenuItem(menu, MenuItemOption.Paste, textActionModeCallback.onPasteRequested);
            TextActionModeCallback.addOrRemoveMenuItem(menu, MenuItemOption.Cut, textActionModeCallback.onCutRequested);
            TextActionModeCallback.addOrRemoveMenuItem(menu, MenuItemOption.SelectAll, textActionModeCallback.onSelectAllRequested);
            return true;
        }
        return false;
    }
}
