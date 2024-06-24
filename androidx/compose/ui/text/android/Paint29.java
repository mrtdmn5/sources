package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaintExtensions.kt */
/* loaded from: classes.dex */
public final class Paint29 {
    public static final void getTextBounds(Paint paint, CharSequence text, int r3, int r4, Rect rect) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(rect, "rect");
        paint.getTextBounds(text, r3, r4, rect);
    }
}
