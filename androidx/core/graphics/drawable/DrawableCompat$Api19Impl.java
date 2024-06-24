package androidx.core.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;

/* loaded from: classes.dex */
public final class DrawableCompat$Api19Impl {
    public static int getAlpha(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static Drawable getChild(DrawableContainer.DrawableContainerState drawableContainerState, int r1) {
        return drawableContainerState.getChild(r1);
    }

    public static Drawable getDrawable(InsetDrawable insetDrawable) {
        return insetDrawable.getDrawable();
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }
}
