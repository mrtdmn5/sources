package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPopup.android.kt */
/* loaded from: classes.dex */
public class PopupLayoutHelperImpl implements PopupLayoutHelper {
    @Override // androidx.compose.ui.window.PopupLayoutHelper
    public final void getWindowVisibleDisplayFrame(View composeView, Rect outRect) {
        Intrinsics.checkNotNullParameter(composeView, "composeView");
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        composeView.getWindowVisibleDisplayFrame(outRect);
    }

    @Override // androidx.compose.ui.window.PopupLayoutHelper
    public void setGestureExclusionRects(View composeView, int r2, int r3) {
        Intrinsics.checkNotNullParameter(composeView, "composeView");
    }

    @Override // androidx.compose.ui.window.PopupLayoutHelper
    public final void updateViewLayout(WindowManager windowManager, View popupView, WindowManager.LayoutParams params) {
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        Intrinsics.checkNotNullParameter(popupView, "popupView");
        Intrinsics.checkNotNullParameter(params, "params");
        windowManager.updateViewLayout(popupView, params);
    }
}
