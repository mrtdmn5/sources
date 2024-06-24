package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidImageBitmap.android.kt */
/* loaded from: classes.dex */
public final class AndroidImageBitmap implements ImageBitmap {
    public final Bitmap bitmap;

    public AndroidImageBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
    }

    @Override // androidx.compose.ui.graphics.ImageBitmap
    public final int getHeight() {
        return this.bitmap.getHeight();
    }

    @Override // androidx.compose.ui.graphics.ImageBitmap
    public final int getWidth() {
        return this.bitmap.getWidth();
    }
}
