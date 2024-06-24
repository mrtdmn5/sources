package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

/* loaded from: classes.dex */
public final class PointerIconCompat$Api24Impl {
    public static PointerIcon create(Bitmap bitmap, float f, float f2) {
        return PointerIcon.create(bitmap, f, f2);
    }

    public static PointerIcon getSystemIcon(Context context, int r1) {
        return PointerIcon.getSystemIcon(context, r1);
    }

    public static PointerIcon load(Resources resources, int r1) {
        return PointerIcon.load(resources, r1);
    }
}
