package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidImageBitmap.android.kt */
/* loaded from: classes.dex */
public final class AndroidImageBitmap_androidKt {
    public static final Bitmap asAndroidBitmap(ImageBitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(imageBitmap, "<this>");
        if (imageBitmap instanceof AndroidImageBitmap) {
            return ((AndroidImageBitmap) imageBitmap).bitmap;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    public static final AndroidImageBitmap asImageBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        return new AndroidImageBitmap(bitmap);
    }

    /* renamed from: toBitmapConfig-1JJdX4A, reason: not valid java name */
    public static final Bitmap.Config m290toBitmapConfig1JJdX4A(int r5) {
        boolean z;
        boolean z2;
        boolean z3;
        Bitmap.Config config;
        boolean z4;
        Bitmap.Config config2;
        boolean z5 = false;
        if (r5 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Bitmap.Config.ARGB_8888;
        }
        if (r5 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return Bitmap.Config.ALPHA_8;
        }
        if (r5 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return Bitmap.Config.RGB_565;
        }
        int r2 = Build.VERSION.SDK_INT;
        if (r2 >= 26) {
            if (r5 == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                config2 = Bitmap.Config.RGBA_F16;
                return config2;
            }
        }
        if (r2 >= 26) {
            if (r5 == 4) {
                z5 = true;
            }
            if (z5) {
                config = Bitmap.Config.HARDWARE;
                return config;
            }
        }
        return Bitmap.Config.ARGB_8888;
    }
}
