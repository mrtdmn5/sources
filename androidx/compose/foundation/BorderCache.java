package androidx.compose.foundation;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Border.kt */
/* loaded from: classes.dex */
public final class BorderCache {
    public Path borderPath;
    public Canvas canvas;
    public CanvasDrawScope canvasDrawScope;
    public ImageBitmap imageBitmap;

    public BorderCache() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderCache)) {
            return false;
        }
        BorderCache borderCache = (BorderCache) obj;
        if (Intrinsics.areEqual(this.imageBitmap, borderCache.imageBitmap) && Intrinsics.areEqual(this.canvas, borderCache.canvas) && Intrinsics.areEqual(this.canvasDrawScope, borderCache.canvasDrawScope) && Intrinsics.areEqual(this.borderPath, borderCache.borderPath)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        ImageBitmap imageBitmap = this.imageBitmap;
        int r1 = 0;
        if (imageBitmap == null) {
            hashCode = 0;
        } else {
            hashCode = imageBitmap.hashCode();
        }
        int r0 = hashCode * 31;
        Canvas canvas = this.canvas;
        if (canvas == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = canvas.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        if (canvasDrawScope == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = canvasDrawScope.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        Path path = this.borderPath;
        if (path != null) {
            r1 = path.hashCode();
        }
        return r03 + r1;
    }

    public final String toString() {
        return "BorderCache(imageBitmap=" + this.imageBitmap + ", canvas=" + this.canvas + ", canvasDrawScope=" + this.canvasDrawScope + ", borderPath=" + this.borderPath + ')';
    }

    public BorderCache(int r1) {
        this.imageBitmap = null;
        this.canvas = null;
        this.canvasDrawScope = null;
        this.borderPath = null;
    }
}
