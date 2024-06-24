package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.actionmodecallback.FloatingTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.TextActionModeCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidTextToolbar.android.kt */
/* loaded from: classes.dex */
public final class AndroidTextToolbar implements TextToolbar {
    public ActionMode actionMode;
    public TextToolbarStatus status;
    public final TextActionModeCallback textActionModeCallback;
    public final View view;

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.platform.AndroidTextToolbar$textActionModeCallback$1] */
    public AndroidTextToolbar(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.textActionModeCallback = new TextActionModeCallback(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidTextToolbar$textActionModeCallback$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                AndroidTextToolbar.this.actionMode = null;
                return Unit.INSTANCE;
            }
        });
        this.status = TextToolbarStatus.Hidden;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public final TextToolbarStatus getStatus() {
        return this.status;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public final void hide() {
        this.status = TextToolbarStatus.Hidden;
        ActionMode actionMode = this.actionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.actionMode = null;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public final void showMenu(Rect rect, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04) {
        TextActionModeCallback textActionModeCallback = this.textActionModeCallback;
        textActionModeCallback.getClass();
        textActionModeCallback.rect = rect;
        textActionModeCallback.onCopyRequested = function0;
        textActionModeCallback.onCutRequested = function03;
        textActionModeCallback.onPasteRequested = function02;
        textActionModeCallback.onSelectAllRequested = function04;
        ActionMode actionMode = this.actionMode;
        if (actionMode == null) {
            this.status = TextToolbarStatus.Shown;
            this.actionMode = TextToolbarHelperMethods.INSTANCE.startActionMode(this.view, new FloatingTextActionModeCallback(textActionModeCallback), 1);
            return;
        }
        actionMode.invalidate();
    }
}
