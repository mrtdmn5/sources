package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;

/* compiled from: DrawCache.kt */
/* loaded from: classes.dex */
public final class DrawCache {
    public final CanvasDrawScope cacheScope;
    public AndroidCanvas cachedCanvas;
    public AndroidImageBitmap mCachedImage;
    public Density scopeDensity;
    public long size;

    public DrawCache() {
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        this.size = 0L;
        this.cacheScope = new CanvasDrawScope();
    }
}
