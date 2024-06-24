package androidx.compose.ui.platform;

import android.graphics.Canvas;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewLayerContainer.android.kt */
/* loaded from: classes.dex */
public final class ViewLayerContainer extends DrawChildContainer {
    @Override // androidx.compose.ui.platform.DrawChildContainer, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    public final void dispatchGetDisplayList() {
    }
}
