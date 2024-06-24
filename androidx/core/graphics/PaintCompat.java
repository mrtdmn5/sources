package androidx.core.graphics;

import android.graphics.Paint;

/* loaded from: classes.dex */
public final class PaintCompat {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static boolean hasGlyph(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    static {
        new ThreadLocal();
    }
}
