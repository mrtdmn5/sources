package androidx.transition;

import android.os.Build;

/* loaded from: classes.dex */
public final class TransitionUtils {
    public static final boolean HAS_IS_ATTACHED_TO_WINDOW;
    public static final boolean HAS_OVERLAY;
    public static final boolean HAS_PICTURE_BITMAP;

    static {
        int r0 = Build.VERSION.SDK_INT;
        boolean z = true;
        HAS_IS_ATTACHED_TO_WINDOW = true;
        HAS_OVERLAY = true;
        if (r0 < 28) {
            z = false;
        }
        HAS_PICTURE_BITMAP = z;
    }
}
