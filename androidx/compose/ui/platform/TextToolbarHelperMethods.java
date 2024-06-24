package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidTextToolbar.android.kt */
/* loaded from: classes.dex */
public final class TextToolbarHelperMethods {
    public static final TextToolbarHelperMethods INSTANCE = new TextToolbarHelperMethods();

    public final void invalidateContentRect(ActionMode actionMode) {
        Intrinsics.checkNotNullParameter(actionMode, "actionMode");
        actionMode.invalidateContentRect();
    }

    public final ActionMode startActionMode(View view, ActionMode.Callback actionModeCallback, int r4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(actionModeCallback, "actionModeCallback");
        return view.startActionMode(actionModeCallback, r4);
    }
}
