package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* compiled from: Drawable.kt */
/* loaded from: classes.dex */
public final class DrawableKt {
    public static Bitmap toBitmap$default(Drawable drawable, int r6, int r7, int r8) {
        if ((r8 & 1) != 0) {
            r6 = drawable.getIntrinsicWidth();
        }
        if ((r8 & 2) != 0) {
            r7 = drawable.getIntrinsicHeight();
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                if (r6 == bitmapDrawable.getBitmap().getWidth() && r7 == bitmapDrawable.getBitmap().getHeight()) {
                    return bitmapDrawable.getBitmap();
                }
                return Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), r6, r7, true);
            }
            throw new IllegalArgumentException("bitmap is null");
        }
        Rect bounds = drawable.getBounds();
        int r0 = bounds.left;
        int r1 = bounds.top;
        int r2 = bounds.right;
        int r82 = bounds.bottom;
        Bitmap createBitmap = Bitmap.createBitmap(r6, r7, Bitmap.Config.ARGB_8888);
        drawable.setBounds(0, 0, r6, r7);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(r0, r1, r2, r82);
        return createBitmap;
    }
}
