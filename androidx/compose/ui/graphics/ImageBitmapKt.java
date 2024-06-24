package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageBitmap.kt */
/* loaded from: classes.dex */
public final class ImageBitmapKt {
    /* renamed from: ImageBitmap-x__-hDU$default, reason: not valid java name */
    public static AndroidImageBitmap m336ImageBitmapx__hDU$default(int r5, int r6, int r7, int r8) {
        Rgb colorSpace;
        Bitmap createBitmap;
        boolean z = false;
        if ((r8 & 4) != 0) {
            r7 = 0;
        }
        if ((r8 & 8) != 0) {
            z = true;
        }
        if ((r8 & 16) != 0) {
            colorSpace = ColorSpaces.Srgb;
        } else {
            colorSpace = null;
        }
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap.Config m290toBitmapConfig1JJdX4A = AndroidImageBitmap_androidKt.m290toBitmapConfig1JJdX4A(r7);
        if (Build.VERSION.SDK_INT >= 26) {
            createBitmap = Api26Bitmap.m308createBitmapx__hDU$ui_graphics_release(r5, r6, r7, z, colorSpace);
        } else {
            createBitmap = Bitmap.createBitmap((DisplayMetrics) null, r5, r6, m290toBitmapConfig1JJdX4A);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(\n          …   bitmapConfig\n        )");
            createBitmap.setHasAlpha(z);
        }
        return new AndroidImageBitmap(createBitmap);
    }
}
