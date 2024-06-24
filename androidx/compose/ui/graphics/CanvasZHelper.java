package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: CanvasUtils.android.kt */
/* loaded from: classes.dex */
public final class CanvasZHelper {
    public static final CanvasZHelper INSTANCE = new CanvasZHelper();

    public final void enableZ(android.graphics.Canvas canvas, boolean z) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (z) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }
}
