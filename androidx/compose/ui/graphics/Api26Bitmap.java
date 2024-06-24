package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidImageBitmap.android.kt */
/* loaded from: classes.dex */
public final class Api26Bitmap {
    public static final ColorSpace composeColorSpace$ui_graphics_release(Bitmap bitmap) {
        android.graphics.ColorSpace colorSpace;
        ColorSpace composeColorSpace;
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        colorSpace = bitmap.getColorSpace();
        if (colorSpace == null || (composeColorSpace = ColorSpaceVerificationHelper.composeColorSpace(colorSpace)) == null) {
            float[] fArr = ColorSpaces.SrgbPrimaries;
            return ColorSpaces.Srgb;
        }
        return composeColorSpace;
    }

    /* renamed from: createBitmap-x__-hDU$ui_graphics_release, reason: not valid java name */
    public static final Bitmap m308createBitmapx__hDU$ui_graphics_release(int r1, int r2, int r3, boolean z, ColorSpace colorSpace) {
        Bitmap createBitmap;
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        createBitmap = Bitmap.createBitmap((DisplayMetrics) null, r1, r2, AndroidImageBitmap_androidKt.m290toBitmapConfig1JJdX4A(r3), z, ColorSpaceVerificationHelper.androidColorSpace(colorSpace));
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(\n          …oidColorSpace()\n        )");
        return createBitmap;
    }
}
