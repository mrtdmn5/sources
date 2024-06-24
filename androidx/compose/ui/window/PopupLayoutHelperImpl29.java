package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPopup.android.kt */
/* loaded from: classes.dex */
public final class PopupLayoutHelperImpl29 extends PopupLayoutHelperImpl {
    @Override // androidx.compose.ui.window.PopupLayoutHelperImpl, androidx.compose.ui.window.PopupLayoutHelper
    public final void setGestureExclusionRects(View composeView, int r5, int r6) {
        Intrinsics.checkNotNullParameter(composeView, "composeView");
        composeView.setSystemGestureExclusionRects(CollectionsKt__CollectionsKt.mutableListOf(new Rect(0, 0, r5, r6)));
    }
}
