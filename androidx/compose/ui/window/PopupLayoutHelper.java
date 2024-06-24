package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;

/* compiled from: AndroidPopup.android.kt */
/* loaded from: classes.dex */
public interface PopupLayoutHelper {
    void getWindowVisibleDisplayFrame(View view, Rect rect);

    void setGestureExclusionRects(View view, int r2, int r3);

    void updateViewLayout(WindowManager windowManager, View view, WindowManager.LayoutParams layoutParams);
}
